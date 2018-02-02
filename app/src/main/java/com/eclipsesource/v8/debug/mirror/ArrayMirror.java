package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class ArrayMirror extends ObjectMirror {
    private static final String LENGTH = "length";

    ArrayMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isArray() {
        return true;
    }

    public int length() {
        return this.v8Object.executeIntegerFunction(LENGTH, null);
    }
}
