package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.viewitems.g.a.1;

class g$a$1$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap kXG;
    final /* synthetic */ 1 yKf;

    g$a$1$1(1 1, Bitmap bitmap) {
        this.yKf = 1;
        this.kXG = bitmap;
    }

    public final boolean onPreDraw() {
        Bitmap a;
        this.yKf.yKe.yKb.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.yKf.yKe.yKb.getHeight();
        int width = this.yKf.yKe.yKb.getWidth();
        if (height == 0) {
            height = a.aa(this.yKf.val$context, R.f.bwS);
        }
        if (width == 0) {
            width = a.aa(this.yKf.val$context, R.f.bwT);
        }
        if (this.yKf.yKe.yKc) {
            a = d.a(this.kXG, R.g.bAD, width, height);
        } else {
            a = d.a(this.kXG, R.g.bAP, width, height);
        }
        this.yKf.yKe.yKb.setBackgroundDrawable(new BitmapDrawable(a));
        return true;
    }
}
