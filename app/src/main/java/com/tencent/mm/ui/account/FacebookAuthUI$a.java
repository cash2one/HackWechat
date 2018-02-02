package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

final class FacebookAuthUI$a implements a {
    final /* synthetic */ FacebookAuthUI xNS;

    private FacebookAuthUI$a(FacebookAuthUI facebookAuthUI) {
        this.xNS = facebookAuthUI;
    }

    public final void k(Bundle bundle) {
        x.d("MicroMsg.FacebookAuthUI", "token:" + FacebookAuthUI.e(this.xNS).ykF);
        ar.Hg();
        c.CU().set(65830, FacebookAuthUI.e(this.xNS).ykF);
        if (FacebookAuthUI.e(this.xNS).zbT != 0) {
            ar.Hg();
            c.CU().set(65832, Long.valueOf(FacebookAuthUI.e(this.xNS).zbT));
        }
        FacebookAuthUI.a(this.xNS, ProgressDialog.show(this.xNS, this.xNS.getString(R.l.dGO), this.xNS.getString(R.l.eed), true));
        FacebookAuthUI.d(this.xNS).setOnCancelListener(FacebookAuthUI.c(this.xNS));
        FacebookAuthUI.a(this.xNS, new g(1, FacebookAuthUI.e(this.xNS).ykF));
        ar.CG().a(FacebookAuthUI.a(this.xNS), 0);
        FacebookAuthUI.ma(true);
        com.tencent.mm.plugin.report.service.g.pQN.a(582, 1, 1, false);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + dVar.zca);
        h.b(this.xNS, dVar.getMessage(), this.xNS.getString(R.l.dUS), true);
        FacebookAuthUI.ma(false);
        com.tencent.mm.plugin.report.service.g.pQN.a(582, 2, 1, false);
    }

    public final void a(b bVar) {
        x.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
        h.b(this.xNS, bVar.getMessage(), this.xNS.getString(R.l.dUS), true);
        FacebookAuthUI.ma(false);
        com.tencent.mm.plugin.report.service.g.pQN.a(582, 3, 1, false);
    }

    public final void onCancel() {
        x.d("MicroMsg.FacebookAuthUI", "onCancel");
        FacebookAuthUI.ma(false);
        com.tencent.mm.plugin.report.service.g.pQN.a(582, 4, 1, false);
    }
}
