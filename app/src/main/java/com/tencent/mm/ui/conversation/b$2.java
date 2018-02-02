package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ae;

class b$2 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ Context val$context;
    final /* synthetic */ ae xym;
    final /* synthetic */ PBool yWn;
    final /* synthetic */ ProgressDialog yWo;
    final /* synthetic */ Runnable yWp;

    b$2(Context context, String str, ae aeVar, PBool pBool, ProgressDialog progressDialog, Runnable runnable) {
        this.val$context = context;
        this.gIx = str;
        this.xym = aeVar;
        this.yWn = pBool;
        this.yWo = progressDialog;
        this.yWp = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.gIx, this.xym, this.yWn, this.yWo);
        if (this.yWp != null) {
            this.yWp.run();
        }
    }
}
