package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class NullMirror extends ValueMirror {
    NullMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isNull() {
        return true;
    }

    public String toString() {
        return "null";
    }
}
