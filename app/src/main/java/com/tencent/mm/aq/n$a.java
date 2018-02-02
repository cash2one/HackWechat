package com.tencent.mm.aq;

import android.os.HandlerThread;
import com.tencent.mm.aq.n.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n$a {
    static af fcF;
    private ReentrantLock fcD = new ReentrantLock();
    private Condition fcE = this.fcD.newCondition();
    a hCc;
    int hzT;

    public static n$a a(e eVar) {
        synchronized (n$a.class) {
            if (fcF == null) {
                HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                handlerThread.start();
                fcF = new af(handlerThread.getLooper());
            }
        }
        n$a com_tencent_mm_aq_n_a = new n$a();
        eVar.hCw = com_tencent_mm_aq_n_a;
        fcF.post(new 1(eVar.hCw, eVar));
        com_tencent_mm_aq_n_a.hzT = eVar.hzT;
        return com_tencent_mm_aq_n_a;
    }

    public final a Pp() {
        this.fcD.lock();
        while (this.hCc == null) {
            try {
                x.i("MicroMsg.SendImgSpeeder", "getResult await");
                this.fcE.await();
            } catch (Exception e) {
            } finally {
                this.fcD.unlock();
            }
        }
        return this.hCc;
    }
}
