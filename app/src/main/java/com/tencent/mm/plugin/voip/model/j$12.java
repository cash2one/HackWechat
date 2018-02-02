package com.tencent.mm.plugin.voip.model;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.sdk.platformtools.x;

class j$12 implements a {
    final /* synthetic */ j smu;

    j$12(j jVar) {
        this.smu = jVar;
    }

    public final void fY(boolean z) {
        x.d("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b", Boolean.valueOf(z));
        if (!(true == z && 3 == j.f(this.smu)) && (z || 3 == j.f(this.smu))) {
            if (b.yT(j.a(this.smu).mState)) {
                if (z) {
                    j.b(this.smu, false);
                    j.a(this.smu, 3);
                } else if (d.bGj().bHv()) {
                    Toast.makeText(j.g(this.smu), j.g(this.smu).getString(R.l.eVW), 0).show();
                    j.b(this.smu, true);
                    j.a(this.smu, 1);
                } else {
                    j.b(this.smu, false);
                    j.a(this.smu, 3);
                }
            } else if (z) {
                if (1 == j.f(this.smu)) {
                    j.b(this.smu, false);
                    j.c(this.smu, true);
                } else {
                    j.c(this.smu, false);
                }
                j.a(this.smu, 3);
            } else if (d.bGj().bHv()) {
                if (j.h(this.smu) || 2 == j.i(this.smu)) {
                    Toast.makeText(j.g(this.smu), j.g(this.smu).getString(R.l.eVW), 0).show();
                    j.b(this.smu, true);
                    j.a(this.smu, 1);
                } else {
                    Toast.makeText(j.g(this.smu), j.g(this.smu).getString(R.l.eVV), 0).show();
                    j.a(this.smu, 2);
                }
                j.c(this.smu, false);
            } else {
                j.b(this.smu, false);
                j.a(this.smu, 2);
            }
            j.b(this.smu, j.f(this.smu));
            return;
        }
        x.d("MicroMsg.Voip.VoipMgr", "same status, no changed");
    }
}
