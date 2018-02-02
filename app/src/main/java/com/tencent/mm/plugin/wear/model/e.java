package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;

public final class e {
    c gzG = new 11(this);
    ak ikI = new ak(Looper.getMainLooper(), new 7(this), true);
    a lZv = new 2(this);
    c odL = new 3(this);
    c rIj = new c<kd>(this) {
        final /* synthetic */ e tik;

        {
            this.tik = r2;
            this.xen = kd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kd kdVar = (kd) bVar;
            if (e.a(this.tik) && !"gh_3dfda90e39d6".equals(kdVar.fBv.talker)) {
                ar.Hg();
                au Ex = com.tencent.mm.z.c.Fa().Ex(kdVar.fBv.talker);
                boolean z = Ex != null ? g.zY().getInt("WearLuckyBlock", 0) == 0 && (Ex.ciX() || Ex.ciY()) : false;
                if (z) {
                    a.bOt().thN.a(new com.tencent.mm.plugin.wear.model.f.g(Ex));
                    if (kdVar.fBv.fnm > 1) {
                        e.n(kdVar.fBv.talker, kdVar.fBv.fnm, false);
                    }
                } else {
                    e.n(kdVar.fBv.talker, kdVar.fBv.fnm, true);
                }
            }
            return false;
        }
    };
    private PowerManager tib;
    private KeyguardManager tic;
    c tie = new 4(this);
    c tif = new 5(this);
    c tig = new 6(this);
    c tih = new 8(this);
    c tii = new 9(this);
    c tij = new 10(this);

    static /* synthetic */ boolean a(e eVar) {
        return eVar.tic.inKeyguardRestrictedInputMode() || !eVar.tib.isScreenOn();
    }

    public e() {
        x.i("MicroMsg.Wear.WearLogic", "Create!");
        this.rIj.ceO();
        this.tie.ceO();
        this.tif.ceO();
        this.tig.ceO();
        this.tih.ceO();
        this.tii.ceO();
        this.tij.ceO();
        this.gzG.ceO();
        this.odL.ceO();
        this.ikI.J(1800000, 1800000);
        this.tib = (PowerManager) ac.getContext().getSystemService("power");
        this.tic = (KeyguardManager) ac.getContext().getSystemService("keyguard");
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this.lZv, null);
    }

    public static void n(String str, int i, boolean z) {
        a.bOt().thN.a(new j(str, i, z));
    }
}
