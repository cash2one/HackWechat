package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;
import com.tencent.mm.z.ar;

final class FacebookLoginUI$a implements a {
    final /* synthetic */ FacebookLoginUI xOf;

    private FacebookLoginUI$a(FacebookLoginUI facebookLoginUI) {
        this.xOf = facebookLoginUI;
    }

    public final void k(Bundle bundle) {
        FacebookLoginUI.a(this.xOf, ProgressDialog.show(this.xOf, this.xOf.getString(R.l.dGO), this.xOf.getString(R.l.eed), true));
        FacebookLoginUI.e(this.xOf).setOnCancelListener(FacebookLoginUI.d(this.xOf));
        FacebookLoginUI.a(this.xOf, FacebookLoginUI.f(this.xOf).ykF);
        x.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[]{"facebook@wechat_auth", Integer.valueOf(FacebookLoginUI.a(this.xOf).length()), FacebookLoginUI.a(this.xOf).substring(0, 4)});
        FacebookLoginUI.a(this.xOf, new v("facebook@wechat_auth", FacebookLoginUI.a(this.xOf), 0, "", "", "", 0, "", true, false));
        ar.CG().a(FacebookLoginUI.b(this.xOf), 0);
        FacebookLoginUI.mb(true);
        b.oI(ar.CB() + "," + this.xOf.getClass().getName() + ",L14," + ar.fH("L14") + ",2");
        g.pQN.a(582, 6, 1, false);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + dVar.zca);
        h.b(this.xOf, dVar.getMessage(), this.xOf.getString(R.l.dUS), true);
        FacebookLoginUI.mb(false);
        b.oI(ar.CB() + "," + this.xOf.getClass().getName() + ",L14," + ar.fH("L14") + ",2");
        g.pQN.a(582, 7, 1, false);
    }

    public final void a(com.tencent.mm.ui.f.a.b bVar) {
        x.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
        h.b(this.xOf, bVar.getMessage(), this.xOf.getString(R.l.dUS), true);
        FacebookLoginUI.mb(false);
        b.oI(ar.CB() + "," + this.xOf.getClass().getName() + ",L14," + ar.fH("L14") + ",2");
        g.pQN.a(582, 8, 1, false);
    }

    public final void onCancel() {
        x.d("MicroMsg.FacebookLoginUI", "onCancel");
        FacebookLoginUI.mb(false);
        b.oI(ar.CB() + "," + this.xOf.getClass().getName() + ",L14," + ar.fH("L14") + ",2");
        g.pQN.a(582, 9, 1, false);
    }
}
