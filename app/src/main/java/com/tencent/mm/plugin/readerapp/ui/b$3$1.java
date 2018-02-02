package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.readerapp.b.g.a;
import com.tencent.mm.plugin.readerapp.ui.b.3;

class b$3$1 implements a {
    final /* synthetic */ ProgressDialog lpj;
    final /* synthetic */ 3 pAK;

    b$3$1(3 3, ProgressDialog progressDialog) {
        this.pAK = 3;
        this.lpj = progressDialog;
    }

    public final void bmm() {
        if (this.lpj != null) {
            this.lpj.dismiss();
        }
    }
}
