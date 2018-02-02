package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class i$2 implements a {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;
    final /* synthetic */ ProgressDialog lpj;

    i$2(ProgressDialog progressDialog, boolean z, o oVar) {
        this.lpj = progressDialog;
        this.kCv = z;
    }

    public final boolean uF() {
        if (this.lpj != null) {
            this.lpj.dismiss();
        }
        int Gd = q.Gd();
        if (this.kCv) {
            Gd &= -16777217;
        } else {
            Gd |= 16777216;
            ar.Hg();
            c.CU().set(286722, "");
            ar.Hg();
            c.CU().set(286721, "");
            ar.Hg();
            c.CU().set(286723, "");
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(Gd));
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_axg = new axg();
        com_tencent_mm_protocal_c_axg.vFu = 16777216;
        com_tencent_mm_protocal_c_axg.wEy = this.kCv ? 0 : 1;
        ar.Hg();
        c.EX().b(new e.a(39, com_tencent_mm_protocal_c_axg));
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
        return false;
    }
}
