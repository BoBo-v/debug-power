package io.github.future0923.debug.power.idea.tool.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import io.github.future0923.debug.power.idea.tool.DebugPowerToolWindow;
import io.github.future0923.debug.power.idea.tool.DebugPowerToolWindowFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author future0923
 */
public abstract class BaseToolAction extends DumbAwareAction {

    private DebugPowerToolWindow toolWindow;

    public BaseToolAction() {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        if (getToolWindow(project) == null) {
            return;
        }
        doActionPerformed(project, toolWindow);
    }

    protected abstract void doActionPerformed(Project project, DebugPowerToolWindow toolWindow);

    private DebugPowerToolWindow getToolWindow(@Nullable Project project) {
        if (toolWindow != null) {
            return toolWindow;
        }
        return (toolWindow = DebugPowerToolWindowFactory.getToolWindow(project));
    }
}
