package com.tencent.mm.plugin.accountsync.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.accountsync.model.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

final class ContactsSyncUI$a implements a {
    final /* synthetic */ ContactsSyncUI ilf;
    private boolean ilg;
    private d.a ilh = new d.a(this) {
        final /* synthetic */ ContactsSyncUI$a ili;

        {
            this.ili = r1;
        }

        public final void l(Bundle bundle) {
            ContactsSyncUI contactsSyncUI = this.ili.ilf;
            contactsSyncUI.ild = bundle;
            contactsSyncUI.finish();
        }
    };

    public ContactsSyncUI$a(ContactsSyncUI contactsSyncUI, boolean z) {
        this.ilf = contactsSyncUI;
        this.ilg = z;
    }

    public final int bJ(Context context) {
        if (!ar.Hi() || ar.Cs()) {
            return 4;
        }
        if (this.ilg) {
            ar.Hg();
            String str = (String) c.CU().get(6, "");
            if (bh.ov(str)) {
                x.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                return 2;
            } else if (!m.NM()) {
                return H(context, str);
            } else {
                h.a(context, R.l.dXt, R.l.dGO, R.l.dFU, R.l.dEn, new 2(this, context, str), new 3(this, context));
                return 5;
            }
        }
        x.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
        d.a(this.ilf, this.ilh);
        return 0;
    }

    final int H(Context context, String str) {
        if (context == null) {
            return 1;
        }
        int a = d.a(context, str, this.ilh);
        if (a == 2) {
            Toast.makeText(context, this.ilf.getString(R.l.dXv), 1).show();
            return 1;
        } else if (a != 3) {
            return 0;
        } else {
            Toast.makeText(context, this.ilf.getString(R.l.dXu), 1).show();
            return 1;
        }
    }
}
