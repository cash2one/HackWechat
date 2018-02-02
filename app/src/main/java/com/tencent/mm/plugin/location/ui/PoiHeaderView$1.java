package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class PoiHeaderView$1 implements OnClickListener {
    final /* synthetic */ PoiHeaderView nTn;

    PoiHeaderView$1(PoiHeaderView poiHeaderView) {
        this.nTn = poiHeaderView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.d("MicroMsg.PoiHeaderView", "click url %s", new Object[]{bh.ov(PoiHeaderView.a(this.nTn)) ? PoiHeaderView.b(this.nTn) : PoiHeaderView.a(this.nTn)});
        intent.putExtra("rawUrl", r0);
        intent.putExtra("showShare", false);
        d.a(this.nTn.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
