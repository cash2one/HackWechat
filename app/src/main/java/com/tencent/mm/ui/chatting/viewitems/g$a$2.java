package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.viewitems.g.a;

class g$a$2 implements OnPreDrawListener {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ Context val$context;
    private boolean yJD = false;
    final /* synthetic */ a yKe;

    g$a$2(a aVar, Context context, Bitmap bitmap) {
        this.yKe = aVar;
        this.val$context = context;
        this.jsN = bitmap;
    }

    public final boolean onPreDraw() {
        if (this.yJD) {
            this.yKe.yKb.getViewTreeObserver().removeOnPreDrawListener(this);
        } else {
            this.yKe.yKb.getViewTreeObserver().removeOnPreDrawListener(this);
            this.yJD = true;
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.val$context, 24);
            Bitmap bitmap = this.jsN;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.ag(this.val$context.getResources().getColor(R.e.brQ), fromDPToPix, fromDPToPix);
            }
            int height = bitmap.getHeight();
            if (fromDPToPix <= height) {
                height = fromDPToPix;
            }
            Bitmap c = d.c(d.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
            height = this.yKe.yKb.getHeight();
            int width = this.yKe.yKb.getWidth();
            if (height == 0) {
                height = com.tencent.mm.bv.a.aa(this.val$context, R.f.bwS);
            }
            if (width == 0) {
                width = com.tencent.mm.bv.a.aa(this.val$context, R.f.bwT);
            }
            if (this.yKe.yKc) {
                bitmap = d.a(c, R.g.bAD, width, height);
            } else {
                bitmap = d.a(c, R.g.bAP, width, height);
            }
            this.yKe.yKb.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
        return true;
    }
}
