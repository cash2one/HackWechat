package com.tencent.mm.pluginsdk.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.a;

class a$1 implements OnClickListener {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ int pa;
    final /* synthetic */ String vfH;

    a$1(Activity activity, String str, int i) {
        this.oZ = activity;
        this.vfH = str;
        this.pa = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.a(this.oZ, new String[]{this.vfH}, this.pa);
    }
}
