package io.github.future0923.debug.power.idea.constant;

/**
 * @author future0923
 */
public interface ProjectConstant {

    String NAME = "DebugPower";

    String VERSION = "1.1.1";

    String AGENT_JAR_PATH = "/lib/debug-power-agent-" + ProjectConstant.VERSION + ".jar";

    String PARAM_FILE = "/.idea/DebugPower/agent.json";

    String GLOBAL_HEADER_FILE = "/.idea/DebugPower/globalHeader.json";

    String TOOL_WINDOW_ID = "DebugPower";
}
