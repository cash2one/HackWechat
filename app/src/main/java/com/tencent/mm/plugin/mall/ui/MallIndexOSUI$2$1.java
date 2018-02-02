package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.mall.ui.MallIndexOSUI.2;
import com.tencent.mm.protocal.c.bxa;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.ui.base.h.c;

class MallIndexOSUI$2$1 implements c {
    final /* synthetic */ bxa omp;
    final /* synthetic */ boolean omq;
    final /* synthetic */ 2 omr;

    MallIndexOSUI$2$1(2 2, bxa com_tencent_mm_protocal_c_bxa, boolean z) {
        this.omr = 2;
        this.omp = com_tencent_mm_protocal_c_bxa;
        this.omq = z;
    }

    public final void jl(int i) {
        if (i < this.omp.wiJ.size()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", n.a(((bxb) this.omp.wiJ.get(i)).wXQ));
            d.b(this.omr.omo, "webview", ".ui.tools.WebViewUI", intent);
        } else if (this.omq) {
            this.omr.omo.aYq();
        }
    }
}
