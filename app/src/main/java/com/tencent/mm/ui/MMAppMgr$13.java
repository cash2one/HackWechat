package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MMAppMgr$13 implements OnClickListener {
    final /* synthetic */ Context val$context;

    MMAppMgr$13(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.val$context.startActivity(new Intent("android.settings.APN_SETTINGS"));
        } catch (Exception e) {
        }
    }
}
