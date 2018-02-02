package com.tencent.mm.aq;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$a extends af {
    private WeakReference<b> hzA;

    public b$a(b bVar, Looper looper) {
        super(looper);
        this.hzA = new WeakReference(bVar);
    }

    public final void handleMessage(Message message) {
        b bVar = (b) this.hzA.get();
        if (bVar != null && 1 == message.what) {
            if (!bVar.hzo && System.currentTimeMillis() - bVar.hzp > 1200000) {
                x.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            } else if (bVar.hzm != 0 || bVar.hzl.size() <= 0 || bVar.hzq != 0 || bVar.hzr) {
                x.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + bVar.hzm + " size: " + bVar.hzl.size() + " cnt: " + bVar.hzq + " pauseOnMonitor: " + bVar.hzr);
            } else {
                synchronized (bVar.hzl) {
                    bVar.hzm = ((Long) bVar.hzl.pop()).longValue();
                }
                cf dH = ((h) g.h(h.class)).aZi().dH(bVar.hzm);
                e bh = o.Pw().bh(dH.field_msgSvrId);
                if (bh.gjK == 1) {
                    x.d("MicroMsg.AutoGetBigImgLogic", bVar.hzm + " already has hd thumb");
                    bVar.hzm = 0;
                    bVar.start();
                    return;
                }
                x.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + bVar.hzm + "  image_" + dH.field_msgId);
                com.tencent.mm.modelcdntran.g.MJ().hsy.add("image_" + dH.field_msgId);
                o.Px().a(bh.hzP, dH.field_msgId, 0, Long.valueOf(bVar.hzm), bVar.hzn, bVar);
            }
        }
    }
}
