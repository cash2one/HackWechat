package com.tencent.mm.plugin.wallet_core.e;

import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.model.e;

class a$6 implements Runnable {
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ e sYA;
    final /* synthetic */ a sYx;

    a$6(a aVar, ImageView imageView, e eVar) {
        this.sYx = aVar;
        this.lOQ = imageView;
        this.sYA = eVar;
    }

    public final void run() {
        this.lOQ.setImageResource(this.sYA.sLw);
    }
}
