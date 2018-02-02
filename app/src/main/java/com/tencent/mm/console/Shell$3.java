package com.tencent.mm.console;

import com.tencent.mm.sdk.platformtools.x;

class Shell$3 implements Runnable {
    Shell$3() {
    }

    public final void run() {
        x.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
        Object[] objArr = new Object[1];
        String str = null;
        objArr[0] = Integer.valueOf(str.length());
        x.d("MicroMsg.Shell", "%d ", objArr);
    }
}
