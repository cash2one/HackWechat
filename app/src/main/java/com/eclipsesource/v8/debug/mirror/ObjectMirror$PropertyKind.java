package com.eclipsesource.v8.debug.mirror;

public enum ObjectMirror$PropertyKind {
    Named(1),
    Indexed(2);
    
    int index;

    private ObjectMirror$PropertyKind(int i) {
        this.index = i;
    }
}
