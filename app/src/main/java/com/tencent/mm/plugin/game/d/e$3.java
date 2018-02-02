package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.ag;

class e$3 extends b {
    final /* synthetic */ int aEe;
    final /* synthetic */ int aEf;
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ e nxj;
    final /* synthetic */ int nxo;

    e$3(e eVar, ImageView imageView, int i, int i2, int i3) {
        this.nxj = eVar;
        this.lOQ = imageView;
        this.aEf = i;
        this.aEe = i2;
        this.nxo = i3;
    }

    public final void a(View view, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            ag.y(new 1(this, bitmap));
        }
    }
}
