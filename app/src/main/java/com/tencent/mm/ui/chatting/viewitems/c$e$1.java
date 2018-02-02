package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.c.c;
import com.tencent.mm.ui.chatting.viewitems.c.e;

class c$e$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ a yII;
    private boolean yJD = false;
    final /* synthetic */ c yJE;
    final /* synthetic */ e yJH;

    c$e$1(e eVar, c cVar, a aVar, Bitmap bitmap) {
        this.yJH = eVar;
        this.yJE = cVar;
        this.yII = aVar;
        this.jsN = bitmap;
    }

    public final boolean onPreDraw() {
        if (this.yJD) {
            this.yJE.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
        } else {
            this.yJE.yJf.getViewTreeObserver().removeOnPreDrawListener(this);
            this.yJD = true;
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(this.yII.getContext(), 24);
            Bitmap bitmap = this.jsN;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.ag(this.yII.getContext().getResources().getColor(R.e.brQ), fromDPToPix, fromDPToPix);
            }
            int height = bitmap.getHeight();
            if (fromDPToPix <= height) {
                height = fromDPToPix;
            }
            Bitmap c = d.c(d.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
            height = this.yJE.yJf.getHeight();
            int width = this.yJE.yJf.getWidth();
            if (height == 0) {
                height = com.tencent.mm.bv.a.aa(this.yII.getContext(), R.f.bwS);
            }
            if (width == 0) {
                width = com.tencent.mm.bv.a.aa(this.yII.getContext(), R.f.bwT);
            }
            this.yJE.yJf.setBackgroundDrawable(new BitmapDrawable(d.a(c, R.g.bAP, width, height)));
        }
        return true;
    }
}
