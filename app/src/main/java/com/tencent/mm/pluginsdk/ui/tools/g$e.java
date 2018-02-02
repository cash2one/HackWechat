package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.tools.g.d;

class g$e implements Runnable {
    ImageView fvf;
    Bitmap mTJ;
    final /* synthetic */ g vxl;

    private g$e(g gVar) {
        this.vxl = gVar;
    }

    public final void run() {
        if (this.fvf != null) {
            if (this.mTJ == null || !this.mTJ.isRecycled()) {
                d.b(this.fvf, this.mTJ);
            } else {
                d.d(this.fvf);
            }
        }
        this.fvf = null;
        this.mTJ = null;
        this.vxl.vxh.C(this);
    }
}
