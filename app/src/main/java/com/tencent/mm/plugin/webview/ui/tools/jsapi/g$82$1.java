package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.82;

class g$82$1 implements OnClickListener {
    final /* synthetic */ 82 tJi;

    g$82$1(82 82) {
        this.tJi = 82;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.i(this.tJi.tIj).startActivity(new Intent("android.settings.NFC_SETTINGS"));
        g.a(this.tJi.tIj, this.tJi.tIg, "nfcCheckState:nfc_off", null);
    }
}
