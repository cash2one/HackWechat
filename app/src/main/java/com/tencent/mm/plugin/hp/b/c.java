package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.if;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sdk.b.c<if> implements com.tencent.mm.sdk.f.c {
    private static final String hEr = (e.gZK + "_temp.hp");
    private a nAE = null;

    public c() {
        com.tencent.mm.sdk.f.e.a((com.tencent.mm.sdk.f.c) this);
        this.xen = if.class.getName().hashCode();
    }

    public static void Cw(String str) {
        x.w("Tinker.HotPatchApplyService", "hp_apply from file %s", str);
        d.Cx(str);
    }

    public final void z(Runnable runnable) {
        if (runnable == this.nAE) {
            x.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", this.nAE.url, this.nAE.icu, Boolean.valueOf(this.nAE.hlj));
            if (this.nAE.hlj) {
                b.rj(1);
            } else {
                b.ri(1);
                Cw(this.nAE.icu);
            }
            this.nAE = null;
        }
    }

    private boolean a(if ifVar) {
        if (this.nAE != null) {
            x.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
        } else if (1 == ifVar.fyD.fpr) {
            d.aSE();
        } else if (ifVar.fyD.fyI != null) {
            Cw(ifVar.fyD.fyI);
        } else {
            b.rh(1);
            if (ifVar.fyD.fyG != null) {
                try {
                    byte[] decode = Base64.decode(ifVar.fyD.fyG, 0);
                    ifVar.fyD.fyG = new String(decode);
                } catch (Error e) {
                }
            }
            if (!bh.ov(ifVar.fyD.fyG) && !bh.ov(ifVar.fyD.fyH)) {
                x.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", ifVar.fyD.fyG, ifVar.fyD.fyH);
                this.nAE = new a(ifVar.fyD.fyG, hEr, ifVar.fyD.fyH);
            } else if (!bh.ov(ifVar.fyD.fyE)) {
                if (bh.ov(ifVar.fyD.fyF)) {
                }
            }
            com.tencent.mm.sdk.f.e.post(this.nAE, "hp_apply_download");
        }
        return false;
    }
}
