package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ae;

class b$14 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ Context val$context;
    final /* synthetic */ ae xym;
    final /* synthetic */ PBool yWn;
    final /* synthetic */ ProgressDialog yWo;
    final /* synthetic */ Runnable yWp;
    final /* synthetic */ boolean yWr;

    b$14(ProgressDialog progressDialog, PBool pBool, Context context, String str, ae aeVar, Runnable runnable, boolean z) {
        this.yWo = progressDialog;
        this.yWn = pBool;
        this.val$context = context;
        this.gIx = str;
        this.xym = aeVar;
        this.yWp = runnable;
        this.yWr = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yWo.show();
        this.yWn.value = false;
        b.a(this.gIx, this.xym, this.yWn, this.yWo);
        if (this.yWp != null) {
            this.yWp.run();
        }
        if (this.yWr) {
            g.pQN.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(3), this.gIx});
        }
    }
}
