package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class c$2 implements OnKeyListener {
    final /* synthetic */ String pTU;
    final /* synthetic */ c pTV;

    c$2(c cVar, String str) {
        this.pTV = cVar;
        this.pTU = str;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        c.a(this.pTV, this.pTU);
        return true;
    }
}
