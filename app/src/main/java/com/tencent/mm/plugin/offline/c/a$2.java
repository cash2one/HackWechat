package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ Activity oZ;

    a$2(Activity activity) {
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oZ.finish();
    }
}
