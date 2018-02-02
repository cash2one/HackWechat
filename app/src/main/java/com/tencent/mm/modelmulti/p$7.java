package com.tencent.mm.modelmulti;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;

class p$7 implements Runnable {
    final /* synthetic */ p hGP;

    p$7(p pVar) {
        this.hGP = pVar;
    }

    public final void run() {
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "reportHardCoder tid[%d, %s] running[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Thread.currentThread().getId());
        objArr[1] = Thread.currentThread().getName();
        boolean z = HardCoderJNI.checkEnv && HardCoderJNI.isRunning() > 0;
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        HardCoderJNI.reportIDKey(true, 0, 1, false);
        HardCoderJNI.readServerAddr(true);
        int i = (!HardCoderJNI.checkEnv || HardCoderJNI.isRunning() <= 0) ? 5 : 4;
        HardCoderJNI.reportIDKey(true, i, 1, false);
        HardCoderJNI.reportIDKey(true, HardCoderJNI.isHCEnable() ? 6 : 7, 1, false);
    }
}
