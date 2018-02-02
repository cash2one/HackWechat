package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a xWG;

    a$1(a aVar) {
        this.xWG = aVar;
    }

    public final void onClick(View view) {
        this.xWG.Ek(1);
        a aVar = this.xWG;
        String str = this.xWG.mUrl;
        if (bh.ov(str)) {
            x.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b((Context) aVar.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
