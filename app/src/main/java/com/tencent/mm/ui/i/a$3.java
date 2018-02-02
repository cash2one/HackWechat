package com.tencent.mm.ui.i;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.i.a.c;
import org.b.d.j;

class a$3 implements Runnable {
    final /* synthetic */ a zqb;

    a$3(a aVar) {
        this.zqb = aVar;
    }

    public final void run() {
        Object obj = c.zqe;
        if (this.zqb.zpV == null) {
            obj = c.zqf;
        } else {
            org.b.d.c cVar = new org.b.d.c(j.AyE, "https://api.twitter.com/1.1/account/verify_credentials.json");
            this.zqb.zpU.a(this.zqb.zpV, cVar);
            try {
                if (cVar.cKh().code != 200) {
                    obj = c.zqf;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                obj = c.zqf;
            }
        }
        this.zqb.rqY.sendMessage(this.zqb.rqY.obtainMessage(HardCoderJNI.FUNC_REG_ANR_CALLBACK, obj));
    }
}
