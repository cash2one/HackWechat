package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

class V8Executor$ExecutorTermination implements JavaVoidCallback {
    final /* synthetic */ V8Executor this$0;

    V8Executor$ExecutorTermination(V8Executor v8Executor) {
        this.this$0 = v8Executor;
    }

    public void invoke(V8Object v8Object, V8Array v8Array) {
        if (V8Executor.access$000(this.this$0)) {
            throw new RuntimeException("V8Thread Termination");
        }
    }
}
