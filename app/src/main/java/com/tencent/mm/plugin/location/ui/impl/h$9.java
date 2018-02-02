package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.j;

class h$9 implements OnClickListener {
    final /* synthetic */ h nYk;
    final /* synthetic */ String nYn;

    h$9(h hVar, String str) {
        this.nYk = hVar;
        this.nYn = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.nYk.activity, j.class);
        x.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{this.nYn});
        intent.putExtra("rawUrl", this.nYn);
        intent.putExtra("showShare", false);
        d.a(this.nYk.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
