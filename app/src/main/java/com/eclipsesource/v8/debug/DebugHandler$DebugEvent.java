package com.eclipsesource.v8.debug;

public enum DebugHandler$DebugEvent {
    Undefined(0),
    Break(1),
    Exception(2),
    NewFunction(3),
    BeforeCompile(4),
    AfterCompile(5),
    CompileError(6),
    PromiseError(7),
    AsyncTaskEvent(8);
    
    int index;

    private DebugHandler$DebugEvent(int i) {
        this.index = i;
    }
}
