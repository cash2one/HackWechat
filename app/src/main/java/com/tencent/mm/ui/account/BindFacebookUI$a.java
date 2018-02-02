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

final class BindFacebookUI$a implements a {
    final /* synthetic */ BindFacebookUI xNy;

    private BindFacebookUI$a(BindFacebookUI bindFacebookUI) {
        this.xNy = bindFacebookUI;
    }

    public final void k(Bundle bundle) {
        x.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(this.xNy).ykF);
        ar.Hg();
        c.CU().set(65830, BindFacebookUI.c(this.xNy).ykF);
        if (BindFacebookUI.c(this.xNy).zbT != 0) {
            ar.Hg();
            c.CU().set(65832, Long.valueOf(BindFacebookUI.c(this.xNy).zbT));
        }
        BindFacebookUI.a(this.xNy, ProgressDialog.show(this.xNy, this.xNy.getString(R.l.dGO), this.xNy.getString(R.l.eed), true));
        BindFacebookUI.e(this.xNy).setOnCancelListener(BindFacebookUI.d(this.xNy));
        BindFacebookUI.a(this.xNy, new g(1, BindFacebookUI.c(this.xNy).ykF));
        ar.CG().a(BindFacebookUI.a(this.xNy), 0);
        BindFacebookUI.lZ(true);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.BindFacebookUI", "onFacebookError:" + dVar.zca);
        h.b(this.xNy, dVar.getMessage(), this.xNy.getString(R.l.dUS), true);
        BindFacebookUI.lZ(false);
    }

    public final void a(b bVar) {
        x.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
        h.b(this.xNy, bVar.getMessage(), this.xNy.getString(R.l.dUS), true);
        BindFacebookUI.lZ(false);
    }

    public final void onCancel() {
        x.d("MicroMsg.BindFacebookUI", "onCancel");
        BindFacebookUI.lZ(false);
    }
}
