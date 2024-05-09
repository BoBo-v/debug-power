package io.github.future0923.debug.power.idea.listener;

import io.github.future0923.debug.power.common.utils.DebugPowerTypeUtils;
import io.github.future0923.debug.power.idea.listener.event.DataEvent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author future0923
 */
public class DefaultDataEventMulticaster implements DataEventMulticaster {

    private final Map<String, List<DataListener>> cacheTypeListenerMap = new ConcurrentHashMap<>();

    @Override
    public void addListener(DataListener listener) {
        String typeName = DebugPowerTypeUtils.getTypeArgument(listener.getClass()).getTypeName();
        List<DataListener> dataListeners = cacheTypeListenerMap.computeIfAbsent(typeName, k -> new LinkedList<>());
        dataListeners.add(listener);
    }

    @Override
    public void removeListener(DataListener listener) {
        String typeName = DebugPowerTypeUtils.getTypeArgument(listener.getClass()).getTypeName();
        cacheTypeListenerMap.computeIfPresent(typeName, (k,v) -> {
            v.remove(listener);
            return v;
        });
    }

    @Override
    public void multicastEvent(DataEvent event) {
        cacheTypeListenerMap.getOrDefault(event.getClass().getTypeName(), Collections.emptyList()).forEach(dataListener -> dataListener.event(event));
    }
}
