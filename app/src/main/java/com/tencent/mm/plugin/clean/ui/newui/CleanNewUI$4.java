package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class CleanNewUI$4 implements OnClickListener {
    final /* synthetic */ CleanNewUI lhX;

    CleanNewUI$4(CleanNewUI cleanNewUI) {
        this.lhX = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "qq mgr btn click");
        g.pQN.a(282, 5, 1, false);
        if (!CleanNewUI.a(this.lhX)) {
            if (CleanNewUI.b(this.lhX)) {
                h.a(this.lhX, this.lhX.getString(R.l.dTE, new Object[]{bh.fK(CleanNewUI.c(this.lhX))}), "", this.lhX.getString(R.l.dEz), this.lhX.getString(R.l.dEn), new 1(this), null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            d.b(this.lhX.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
