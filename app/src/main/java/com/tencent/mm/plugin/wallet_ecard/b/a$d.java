package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$d extends e {
    final /* synthetic */ a sZD;

    public a$d(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        ey eyVar = (ey) objArr[0];
        String string = a.f(this.sZD).getString(a.sYZ, "");
        if (eyVar == null) {
            x.w("MicroMsg.OpenECardProcess", "empty bank item");
            return false;
        }
        this.zHV.ji(Exif.PARSE_EXIF_ERROR_CORRUPT);
        this.zHV.a(new d(a.b(this.sZD), string, eyVar.vKJ, eyVar.sIF, eyVar.oZz, a.g(this.sZD), true), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof d)) {
            return false;
        }
        this.zHV.jj(Exif.PARSE_EXIF_ERROR_CORRUPT);
        d dVar = (d) kVar;
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
            h.b(this.zHU, b.d(this.zHU, new String[]{str}), "", false);
        } else if (dVar.sZw.kLO == 0) {
            a.h(this.sZD).putInt(a.sZb, a.sZq);
            a.i(this.sZD).putString(a.sZe, dVar.sZx);
            a.j(this.sZD).putString(a.sZf, dVar.sZy);
            a.k(this.sZD).putString(a.sZg, dVar.sZz);
            Bundle bundle = new Bundle();
            if (dVar.sZw.vLM == null || bh.ov(dVar.sZw.vLM.title)) {
                x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                bundle.putBoolean(a.sZm, true);
                bundle.putString(a.sZk, dVar.sZw.vLK);
                bundle.putString(a.sZl, dVar.sZw.wCH);
            } else {
                x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                bundle.putBoolean(a.sZm, false);
                a.l(this.sZD).putString(a.sZp, dVar.sZw.vLM.title);
            }
            this.sZD.a(this.zHU, 0, bundle);
        } else if (!(b.a((WalletBaseUI) this.zHU, dVar.sZw.vLL) || b.a((WalletBaseUI) this.zHU, dVar, dVar.liH, dVar.liI, dVar.sZw.kLO, dVar.sZw.kLP))) {
            h.b(this.zHU, b.d(this.zHU, new String[]{dVar.sZw.kLP, dVar.liI, str}), "", false);
        }
        return true;
    }
}
