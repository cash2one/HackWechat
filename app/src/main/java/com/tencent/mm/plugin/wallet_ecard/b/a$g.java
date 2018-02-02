package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.c;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$g extends e {
    final /* synthetic */ a sZD;

    public a$g(a aVar, MMActivity mMActivity, g gVar) {
        this.sZD = aVar;
        super(mMActivity, gVar);
    }

    public final CharSequence um(int i) {
        return this.zHU.getIntent().getStringExtra(a.sZl);
    }

    public final boolean q(Object... objArr) {
        k dVar;
        int i = a.m(this.sZD).getInt(a.sZb);
        String n = a.n(this.sZD);
        x.i("MicroMsg.OpenECardProcess", "bind action: %s", new Object[]{Integer.valueOf(i)});
        if (i == a.sZq) {
            dVar = new d(a.b(this.sZD), n, a.o(this.sZD).getString(a.sZe), a.p(this.sZD).getString(a.sZf), a.q(this.sZD).getString(a.sZg), a.g(this.sZD), true, true);
        } else {
            dVar = new d(a.b(this.sZD), n, a.r(this.sZD).getString(a.sZh), a.s(this.sZD).getString(a.sZi), a.t(this.sZD).getString(a.sZj), a.g(this.sZD), false, true);
        }
        this.zHV.ji(Exif.PARSE_EXIF_ERROR_CORRUPT);
        this.zHV.a(dVar, true);
        return true;
    }

    public final boolean k(Object... objArr) {
        a.u(this.sZD).getString("key_pwd1");
        String string = a.v(this.sZD).getString("key_verify_code");
        String n = a.n(this.sZD);
        int i = a.w(this.sZD).getInt(a.sYX);
        k cVar = new c(a.b(this.sZD), n, string, this.zHU.getIntent().getStringExtra(a.sZk), i);
        this.zHV.ji(1986);
        this.zHV.a(cVar, true, 3);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            this.zHV.jj(1986);
            c cVar = (c) kVar;
            if (i == 0 && i2 == 0) {
                if (cVar.sZv.kLO == 0) {
                    Bundle bundle = new Bundle();
                    if (!(cVar.sZv.vLM == null || bh.ov(cVar.sZv.vLM.title))) {
                        x.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[]{cVar.sZv.vLM.title});
                        a.x(this.sZD).putString(a.sZp, cVar.sZv.vLM.title);
                    }
                    this.sZD.a(this.zHU, 0, bundle);
                } else if (!b.a((WalletBaseUI) this.zHU, cVar.sZv.vLL)) {
                    h.b(this.zHU, b.d(this.zHU, new String[]{cVar.sZv.kLP, str}), "", false);
                }
            }
            return true;
        } else if (!(kVar instanceof d)) {
            return false;
        } else {
            this.zHV.jj(Exif.PARSE_EXIF_ERROR_CORRUPT);
            d dVar = (d) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{dVar});
                h.b(this.zHU, b.d(this.zHU, new String[]{str}), "", false);
            } else if (dVar.sZw.kLO == 0) {
                this.zHU.getIntent().putExtra(a.sZk, dVar.sZw.vLK);
            } else if (!(b.a((WalletBaseUI) this.zHU, dVar.sZw.vLL) || b.a((WalletBaseUI) this.zHU, dVar, dVar.liH, dVar.liI, dVar.sZw.kLO, dVar.sZw.kLP))) {
                h.b(this.zHU, b.d(this.zHU, new String[]{dVar.sZw.kLP, dVar.liI, str}), "", false);
            }
            return true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.sZD.b(this.zHU, new Bundle());
        super.onActivityResult(i, i2, intent);
    }
}
