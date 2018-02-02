package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.d.e.3;

class e$3$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ 3 nxp;

    e$3$1(3 3, Bitmap bitmap) {
        this.nxp = 3;
        this.jsN = bitmap;
    }

    public final void run() {
        this.nxp.lOQ.setImageBitmap(this.jsN);
        LayoutParams layoutParams = this.nxp.lOQ.getLayoutParams();
        float f = ((float) this.nxp.aEf) / ((float) this.nxp.aEe);
        layoutParams.width = this.nxp.nxo;
        layoutParams.height = (int) (f * ((float) this.nxp.nxo));
        this.nxp.lOQ.setLayoutParams(layoutParams);
        this.nxp.lOQ.setScaleType(ScaleType.FIT_XY);
    }
}
