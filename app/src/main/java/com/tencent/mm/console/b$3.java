package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;

class b$3 implements OnClickListener {
    final /* synthetic */ Context gIm;
    final /* synthetic */ String gIo;

    b$3(Context context, String str) {
        this.gIm = context;
        this.gIo = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.gIm.getSystemService("clipboard")).setText(this.gIo);
    }
}
