package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class k$1 implements OnClickListener {
    final /* synthetic */ Context val$context;

    k$1(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.val$context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
}
