package com.eclipsesource.v8.debug.mirror;

public enum Scope$ScopeType {
    Global(0),
    Local(1),
    With(2),
    Closure(3),
    Catch(4),
    Block(5),
    Script(6);
    
    int index;

    private Scope$ScopeType(int i) {
        this.index = i;
    }
}
