package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class BooleanMirror extends ValueMirror {
    BooleanMirror(V8Object v8Object) {
        super(v8Object);
    }

    public boolean isBoolean() {
        return true;
    }

    public String toString() {
        return this.v8Object.executeStringFunction("toText", null);
    }
}
