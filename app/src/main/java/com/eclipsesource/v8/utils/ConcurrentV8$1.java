package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;

class ConcurrentV8$1 implements V8Runnable {
    final /* synthetic */ ConcurrentV8 this$0;

    ConcurrentV8$1(ConcurrentV8 concurrentV8) {
        this.this$0 = concurrentV8;
    }

    public void run(V8 v8) {
        if (v8 != null && !v8.isReleased()) {
            v8.release();
        }
    }
}
