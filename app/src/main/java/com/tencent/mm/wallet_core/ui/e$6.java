package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.x;

class e$6 implements OnClickListener {
    final /* synthetic */ String val$url;
    final /* synthetic */ TextView zJl;
    final /* synthetic */ String zJm;

    e$6(String str, TextView textView, String str2) {
        this.val$url = str;
        this.zJl = textView;
        this.zJm = str2;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.zJl.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        f.eB(e.Zu(this.zJm), 1);
    }
}
