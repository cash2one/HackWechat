package com.google.android.exoplayer2.i;

import java.util.concurrent.ThreadFactory;

class t$1 implements ThreadFactory {
    final /* synthetic */ String aCN;

    t$1(String str) {
        this.aCN = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.aCN);
    }
}
