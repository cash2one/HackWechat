package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;

class b$15 implements OnClickListener {
    final /* synthetic */ String gID;
    final /* synthetic */ Context gIm;

    b$15(Context context, String str) {
        this.gIm = context;
        this.gID = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.gIm.getSystemService("clipboard")).setText(this.gID);
    }
}
