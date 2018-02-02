package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements e {
    public boolean fpa = false;
    public b sWX;
    private a sWY;

    public interface a {
        void aYr();

        void aYs();

        void cancel();
    }

    public interface b {
        int aYt();

        Context getContext();
    }

    public final void onResume() {
        g.Dk();
        g.Di().gPJ.a(2541, (e) this);
        g.Dk();
        g.Di().gPJ.a(2791, (e) this);
    }

    public final void onPause() {
        g.Dk();
        g.Di().gPJ.b(2541, (e) this);
        g.Dk();
        g.Di().gPJ.b(2791, (e) this);
    }

    public final void aYr() {
        k oVar = new com.tencent.mm.plugin.wallet_core.c.o();
        g.Dk();
        g.Di().gPJ.a(oVar, 0);
        this.sWY.aYr();
    }

    public final void cancel() {
        this.sWY.cancel();
    }

    public final void a(a aVar, boolean z) {
        this.sWY = aVar;
        g.Dk();
        x.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", Boolean.valueOf(((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()), Boolean.valueOf(z));
        if (((Boolean) g.Dj().CU().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
            aVar.aYs();
        } else if (this.fpa) {
            x.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", Boolean.valueOf(this.fpa));
            aVar.aYs();
        } else if (z) {
            this.fpa = true;
            k fVar = new f();
            g.Dk();
            g.Di().gPJ.a(fVar, 0);
        } else {
            aVar.aYs();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                x.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(ah.aHh()), fVar.sIk, Boolean.valueOf(fVar.sIl));
                if (ah.aHh() && fVar.sIl) {
                    Intent intent = new Intent();
                    intent.putExtra("agreement_content", fVar.sIk);
                    d.b(this.sWX.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.sWX.aYt());
                }
            }
        } else if ((kVar instanceof com.tencent.mm.plugin.wallet_core.c.o) && i == 0 && i2 == 0) {
            g.Dk();
            g.Dj().CU().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(true));
            x.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
        }
    }
}
