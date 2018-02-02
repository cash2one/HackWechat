package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;

class a$10 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ boolean sKp;
    final /* synthetic */ String val$url;

    a$10(String str, Activity activity, boolean z) {
        this.val$url = str;
        this.icz = activity;
        this.sKp = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.icz, "webview", ".ui.tools.WebViewUI", intent);
        dialogInterface.dismiss();
        if (this.sKp) {
            this.icz.finish();
        }
    }
}
