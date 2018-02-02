package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.z.ba.a;

class b$6 implements a {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ PBool yWn;

    b$6(PBool pBool, ProgressDialog progressDialog) {
        this.yWn = pBool;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return this.yWn.value;
    }

    public final void HA() {
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
