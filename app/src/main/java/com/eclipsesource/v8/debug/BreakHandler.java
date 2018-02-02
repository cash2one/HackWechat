package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.V8Object;

public interface BreakHandler {
    void onBreak(DebugHandler$DebugEvent debugHandler$DebugEvent, ExecutionState executionState, EventData eventData, V8Object v8Object);
}
