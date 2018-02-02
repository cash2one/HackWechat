package com.tencent.mm.ui;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.aq.n;
import com.tencent.mm.aq.n.b;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.c;

class HomeUI$6 implements IdleHandler {
    final /* synthetic */ HomeUI xGv;

    HomeUI$6(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final boolean queueIdle() {
        ar.Hg();
        if (t.e((Integer) c.CU().get(15, null)) == 0) {
            x.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
        } else {
            String H = aq.hfP.H("login_user_name", "");
            if (ar.Hi() || !H.equals("")) {
                ar.CG().a(new bd(new 1(this), "launch normal"), 0);
            }
            e.post(new 1(new y(HomeUI.d(this.xGv))), "StartupReport_report");
            o.onCreate(true);
            HomeUI.cmF();
            com.tencent.mm.plugin.report.service.e.bok();
            n.c cVar = n.Pn().hBX;
            if (cVar.hCm.size() <= 0 && cVar.hCl.size() <= 0) {
                H = (String) g.Dj().CU().get(348177, (Object) "");
                String str = (String) g.Dj().CU().get(348176, (Object) "");
                if (!bh.ov(H)) {
                    synchronized (cVar) {
                        for (String ls : H.split("-")) {
                            b ls2 = n.c.ls(ls);
                            if (ls2 != null) {
                                cVar.hCm.add(ls2);
                            }
                        }
                    }
                }
                if (!bh.ov(str)) {
                    synchronized (cVar) {
                        for (String lr : str.split("-")) {
                            b lr2 = n.c.lr(lr);
                            if (lr2 != null) {
                                cVar.hCl.add(lr2);
                            }
                        }
                    }
                }
                x.i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", Integer.valueOf(cVar.hCl.size()), Integer.valueOf(cVar.hCm.size()));
            }
            cVar.Pq();
            Looper.myQueue().removeIdleHandler(this.xGv.xGr);
        }
        return false;
    }
}
