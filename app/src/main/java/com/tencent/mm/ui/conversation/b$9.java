package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;

class b$9 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ PBool yWn;
    final /* synthetic */ Runnable yWp;

    b$9(String str, PBool pBool, ProgressDialog progressDialog, Runnable runnable) {
        this.gIx = str;
        this.yWn = pBool;
        this.lao = progressDialog;
        this.yWp = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.gIx, this.yWn, this.lao);
        if (this.yWp != null) {
            this.yWp.run();
        }
    }
}
