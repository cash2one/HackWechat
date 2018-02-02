package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.viewitems.c.e.3;

class c$e$3$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap kXG;
    final /* synthetic */ 3 yJI;

    c$e$3$1(3 3, Bitmap bitmap) {
        this.yJI = 3;
        this.kXG = bitmap;
    }

    public final boolean onPreDraw() {
        this.yJI.yJE.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.yJI.yJE.yJf.getHeight();
        int width = this.yJI.yJE.yJf.getWidth();
        if (height == 0) {
            height = a.aa(this.yJI.yII.getContext(), R.f.bwS);
        }
        if (width == 0) {
            width = a.aa(this.yJI.yII.getContext(), R.f.bwT);
        }
        this.yJI.yJE.yJf.setBackgroundDrawable(new BitmapDrawable(d.a(this.kXG, R.g.bAP, width, height)));
        return true;
    }
}
