package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;

class b$8 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ PBool yWn;
    final /* synthetic */ Runnable yWp;
    final /* synthetic */ boolean yWr;

    b$8(ProgressDialog progressDialog, PBool pBool, String str, boolean z, Runnable runnable) {
        this.lao = progressDialog;
        this.yWn = pBool;
        this.gIx = str;
        this.yWr = z;
        this.yWp = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lao.show();
        this.yWn.value = false;
        b.a(this.gIx, this.yWn, this.lao);
        if (this.yWr) {
            g.pQN.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(3), this.gIx});
        }
        if (this.yWp != null) {
            this.yWp.run();
        }
    }
}
