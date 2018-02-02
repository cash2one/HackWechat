package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class a$1 extends af {
    final /* synthetic */ a kaJ;

    a$1(a aVar, Looper looper) {
        this.kaJ = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (1000 == message.what) {
            String str = (String) message.obj;
            int i = message.arg1;
            if (this.kaJ.kaI != null) {
                this.kaJ.kaI.aB(str, i);
            }
        }
    }
}
