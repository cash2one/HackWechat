package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.wallet_core.ui.e;

class b$2 implements OnClickListener {
    final /* synthetic */ String oXE;
    final /* synthetic */ Activity oZ;

    b$2(String str, Activity activity) {
        this.oXE = str;
        this.oZ = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.oXE);
        d.b(this.oZ, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        e.HF(3);
        dialogInterface.dismiss();
    }
}
