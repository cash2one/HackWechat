package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bh.c;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;

class h$1 implements OnClickListener {
    final /* synthetic */ h tBH;

    h$1(h hVar) {
        this.tBH = hVar;
    }

    public final void onClick(View view) {
        c cVar = c.hZo;
        String Ve = c.Ve();
        if (!bh.ov(Ve)) {
            c cVar2 = c.hZo;
            int Vf = c.Vf();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Ve);
            intent.putExtra("is_from_keep_top", true);
            intent.putExtra("keep_top_scene", Vf);
            if (Vf == 2) {
                intent.putExtra("custom_keep_top_url", Ve);
                cVar2 = c.hZo;
                intent.putExtra("custom_keep_top_title", c.Vd());
            }
            d.b((Context) this.tBH.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
