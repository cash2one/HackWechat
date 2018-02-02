package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.z.ba;

class b$11 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ String xEU;
    final /* synthetic */ PBool yWn;

    b$11(String str, PBool pBool, ProgressDialog progressDialog, String str2) {
        this.gIx = str;
        this.yWn = pBool;
        this.lao = progressDialog;
        this.xEU = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ba.a(this.gIx, new 1(this));
    }
}
