package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class q$8 implements OnClickListener {
    final /* synthetic */ int hHw;
    final /* synthetic */ String tIq;
    final /* synthetic */ String val$url;
    final /* synthetic */ q yLH;

    q$8(q qVar, String str, String str2, int i) {
        this.yLH = qVar;
        this.val$url = str;
        this.tIq = str2;
        this.hHw = i;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.val$url)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.val$url);
            d.b(q.c(this.yLH).getContext(), "webview", ".ui.tools.WebViewUI", intent);
            g.pQN.h(11608, new Object[]{q.b(this.yLH), this.tIq, Integer.valueOf(this.hHw)});
        }
    }
}
