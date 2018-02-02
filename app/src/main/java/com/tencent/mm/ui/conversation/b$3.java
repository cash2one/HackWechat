package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.z.ba.a;

class b$3 implements a {
    final /* synthetic */ PBool yWn;
    final /* synthetic */ ProgressDialog yWo;

    b$3(PBool pBool, ProgressDialog progressDialog) {
        this.yWn = pBool;
        this.yWo = progressDialog;
    }

    public final boolean HB() {
        return this.yWn.value || this.yWo == null || !this.yWo.isShowing();
    }

    public final void HA() {
        if (this.yWo != null) {
            this.yWo.dismiss();
        }
    }
}
