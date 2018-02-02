package com.tencent.mm.plugin.wallet_core.e;

import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.bh;

class a$5 implements Runnable {
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ e sYA;
    final /* synthetic */ a sYx;
    final /* synthetic */ a$a sYy;

    a$5(a aVar, e eVar, ImageView imageView, a$a com_tencent_mm_plugin_wallet_core_e_a_a) {
        this.sYx = aVar;
        this.sYA = eVar;
        this.lOQ = imageView;
        this.sYy = com_tencent_mm_plugin_wallet_core_e_a_a;
    }

    public final void run() {
        if (!bh.ov(this.sYA.sLv)) {
            this.lOQ.setImageBitmap(j.a(new c(this.sYA.sLv)));
            j.a(this.sYy);
        } else if (this.sYA.sLy > 0) {
            this.lOQ.setImageResource(this.sYA.sLy);
        }
    }
}
