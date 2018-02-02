package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba.a;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class b$4 implements a {
    final /* synthetic */ String gIx;
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ PBool yWn;

    b$4(PBool pBool, ProgressDialog progressDialog, String str) {
        this.yWn = pBool;
        this.lao = progressDialog;
        this.gIx = str;
    }

    public final boolean HB() {
        return this.yWn.value || this.lao == null || !this.lao.isShowing();
    }

    public final void HA() {
        ar.Hg();
        af WO = c.EY().WO(this.gIx);
        WO.An();
        if (com.tencent.mm.l.a.fZ(WO.field_type)) {
            s.s(WO.field_username, false);
        } else {
            ar.Hg();
            c.EY().a(this.gIx, WO);
        }
        ar.Hg();
        c.Fd().WX(this.gIx);
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
