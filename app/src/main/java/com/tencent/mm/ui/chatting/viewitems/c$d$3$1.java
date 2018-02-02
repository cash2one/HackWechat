package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.viewitems.c.d.3;

class c$d$3$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap kXG;
    final /* synthetic */ 3 yJG;

    c$d$3$1(3 3, Bitmap bitmap) {
        this.yJG = 3;
        this.kXG = bitmap;
    }

    public final boolean onPreDraw() {
        this.yJG.yJE.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.yJG.yJE.yJf.getHeight();
        int width = this.yJG.yJE.yJf.getWidth();
        if (height == 0) {
            height = a.aa(this.yJG.yII.getContext(), R.f.bwS);
        }
        if (width == 0) {
            width = a.aa(this.yJG.yII.getContext(), R.f.bwT);
        }
        this.yJG.yJE.yJf.setBackgroundDrawable(new BitmapDrawable(d.a(this.kXG, R.g.bAD, width, height)));
        return true;
    }
}
