package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bwy;
import com.tencent.mm.z.q;

class MallIndexOSUI$1 implements OnClickListener {
    final /* synthetic */ bwy omn;
    final /* synthetic */ MallIndexOSUI omo;

    MallIndexOSUI$1(MallIndexOSUI mallIndexOSUI, bwy com_tencent_mm_protocal_c_bwy) {
        this.omo = mallIndexOSUI;
        this.omn = com_tencent_mm_protocal_c_bwy;
    }

    public final void onClick(View view) {
        g.pQN.h(13867, new Object[]{n.a(this.omn.wXN), Integer.valueOf(this.omo.okQ)});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", n.a(this.omn.wXN));
        intent.putExtra("geta8key_username", q.FS());
        intent.putExtra("pay_channel", 1);
        d.b(this.omo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
