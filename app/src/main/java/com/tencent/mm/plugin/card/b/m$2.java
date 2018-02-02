package com.tencent.mm.plugin.card.b;

import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class m$2 implements Runnable {
    final /* synthetic */ int irj;
    final /* synthetic */ ImageView kXE;
    final /* synthetic */ int kXF;

    m$2(ImageView imageView, int i, int i2) {
        this.kXE = imageView;
        this.kXF = i;
        this.irj = i2;
    }

    public final void run() {
        this.kXE.setImageResource(this.kXF);
        this.kXE.setColorFilter(this.irj, Mode.SRC_IN);
    }
}
