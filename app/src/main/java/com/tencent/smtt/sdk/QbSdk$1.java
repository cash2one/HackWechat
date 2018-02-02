package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

class QbSdk$1 extends Thread {
    final /* synthetic */ String icE;
    final /* synthetic */ Context val$context;
    final /* synthetic */ ab zWh;

    QbSdk$1(Context context, String str, ab abVar) {
        this.val$context = context;
        this.icE = str;
        this.zWh = abVar;
    }

    public final void run() {
        boolean booleanValue;
        af cFg = af.cFg();
        cFg.b(this.val$context, null);
        if (cFg.cFh()) {
            ag cFi = cFg.cFi();
            Context context = this.val$context;
            String str = this.icE;
            Object invokeStaticMethod = cFi.zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, new Object[]{context, str});
            booleanValue = invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        } else {
            booleanValue = false;
        }
        new Handler(Looper.getMainLooper()).post(new 1(this, booleanValue));
    }
}
