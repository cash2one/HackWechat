package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Map;

class ComposeUI$15 extends a {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$15(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        h.a(this.prr, R.l.eAl, R.l.dGO, new OnClickListener(this) {
            final /* synthetic */ ComposeUI$15 pry;

            {
                this.pry = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                File file = new File(w.bks().poZ.pob.pol + c.bT(ComposeUI.J(this.pry.prr), ComposeUI.K(this.pry.prr)));
                if (file.exists()) {
                    file.delete();
                }
                this.pry.prr.setResult(-1);
                this.pry.prr.finish();
            }
        });
        ComposeUI.d(this.prr).bp(this.prr.pqx.psU);
        ComposeUI.d(this.prr).bp(ComposeUI.e(this.prr).psU);
        ComposeUI.d(this.prr).bp(ComposeUI.f(this.prr).psU);
    }

    public final void onError(int i, String str) {
        if (i == -5) {
            this.prr.pqQ.a(new 2(this));
        } else {
            h.a(this.prr, str, this.prr.getString(R.l.eAj), null);
        }
    }

    public final void onComplete() {
        if (ComposeUI.G(this.prr) != null) {
            ComposeUI.G(this.prr).dismiss();
            ComposeUI.a(this.prr, null);
        }
    }
}
