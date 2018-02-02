package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;

public class FunctionMirror extends ObjectMirror {
    private static final String NAME = "name";
    private static final String SCRIPT = "script";

    FunctionMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction(NAME, null);
    }

    public String getScriptName() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SCRIPT, null);
        try {
            String executeStringFunction = executeObjectFunction.executeStringFunction(NAME, null);
            return executeStringFunction;
        } finally {
            executeObjectFunction.release();
        }
    }

    public boolean isFunction() {
        return true;
    }
}
