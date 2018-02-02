package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$a extends e {
    final /* synthetic */ a sZD;

    public a$a(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final boolean k(Object... objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        a.y(this.sZD).putString(a.sZh, str);
        a.z(this.sZD).putString(a.sZi, str2);
        this.zHV.a(new t("", str, null), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Bundle bundle;
        if (kVar instanceof t) {
            t tVar = (t) kVar;
            if (i == 0 && i2 == 0) {
                bundle = new Bundle();
                if (tVar.sII == null || !tVar.sII.sMx) {
                    bundle.putBoolean(a.sZn, true);
                    this.sZD.a(this.zHU, 0, bundle);
                    return false;
                }
                String string = a.A(this.sZD).getString(a.sZh);
                String string2 = a.B(this.sZD).getString(a.sZi);
                String str2 = tVar.sII.oZz;
                a.C(this.sZD).putString(a.sZj, str2);
                this.zHV.ji(Exif.PARSE_EXIF_ERROR_CORRUPT);
                this.zHV.a(new d(a.b(this.sZD), a.n(this.sZD), string, string2, str2, a.g(this.sZD), false), true);
                return false;
            }
            x.w("MicroMsg.OpenECardProcess", "net error: %s", tVar);
            h.b(this.zHU, b.d(this.zHU, new String[]{str}), "", false);
            return false;
        } else if (!(kVar instanceof d)) {
            return false;
        } else {
            this.zHV.jj(Exif.PARSE_EXIF_ERROR_CORRUPT);
            d dVar = (d) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                h.b(this.zHU, b.d(this.zHU, new String[]{str}), "", false);
            } else if (dVar.sZw.kLO == 0) {
                bundle = new Bundle();
                bundle.putBoolean(a.sZn, false);
                if (dVar.sZw.vLM == null || bh.ov(dVar.sZw.vLM.title)) {
                    x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                    bundle.putBoolean(a.sZm, true);
                    bundle.putString(a.sZk, dVar.sZw.vLK);
                    bundle.putString(a.sZl, dVar.sZw.wCH);
                } else {
                    x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                    bundle.putBoolean(a.sZm, false);
                    a.D(this.sZD).putString(a.sZp, dVar.sZw.vLM.title);
                }
                this.sZD.a(this.zHU, 0, bundle);
            } else if (!(b.a((WalletBaseUI) this.zHU, dVar.sZw.vLL) || b.a((WalletBaseUI) this.zHU, dVar, dVar.liH, dVar.liI, dVar.sZw.kLO, dVar.sZw.kLP))) {
                h.b(this.zHU, b.d(this.zHU, new String[]{dVar.sZw.kLP, dVar.liI, str}), "", false);
            }
            return true;
        }
    }
}
