package com.tencent.mm.plugin.accountsync.a;

import com.tencent.mm.R;

class b$2 implements Runnable {
    final /* synthetic */ b ikD;
    final /* synthetic */ int ikE;

    b$2(b bVar, int i) {
        this.ikD = bVar;
        this.ikE = i;
    }

    public final void run() {
        if (this.ikD.tipDialog != null) {
            this.ikD.tipDialog.setMessage(this.ikD.context.getString(R.l.dFy) + this.ikE + "%");
        }
    }
}
