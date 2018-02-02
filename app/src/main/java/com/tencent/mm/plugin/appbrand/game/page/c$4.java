package com.tencent.mm.plugin.appbrand.game.page;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements WAGamePageViewContainerLayout$a {
    final /* synthetic */ c iZX;
    final /* synthetic */ MBCanvasContentHolder iZY;

    c$4(c cVar, MBCanvasContentHolder mBCanvasContentHolder) {
        this.iZX = cVar;
        this.iZY = mBCanvasContentHolder;
    }

    public final void a(WAGamePageViewContainerLayout$b wAGamePageViewContainerLayout$b, WAGamePageViewContainerLayout$b wAGamePageViewContainerLayout$b2) {
        x.v("AppBrandGame.WAGamePageView", "hy: after change. old direction:%s, new direction: %s", new Object[]{wAGamePageViewContainerLayout$b, wAGamePageViewContainerLayout$b2});
        if (this.iZY == null || this.iZY.content == null) {
            x.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
        } else if (!c.a(wAGamePageViewContainerLayout$b) || !c.a(wAGamePageViewContainerLayout$b2)) {
            if (!c.b(wAGamePageViewContainerLayout$b) || !c.b(wAGamePageViewContainerLayout$b2)) {
                if (c.a(wAGamePageViewContainerLayout$b2)) {
                    Matrix matrix = new Matrix();
                    if ((wAGamePageViewContainerLayout$b2 == WAGamePageViewContainerLayout$b.PORTRAIT && wAGamePageViewContainerLayout$b == WAGamePageViewContainerLayout$b.LANDSCAPE) || (wAGamePageViewContainerLayout$b2 == WAGamePageViewContainerLayout$b.PORTRAIT_REVERSE && wAGamePageViewContainerLayout$b == WAGamePageViewContainerLayout$b.LANDSCAPE_REVERSE)) {
                        matrix.postRotate(90.0f);
                    } else {
                        matrix.postRotate(270.0f);
                    }
                    this.iZX.iZR.setVisibility(0);
                    this.iZX.iZR.setImageBitmap(Bitmap.createBitmap(this.iZY.content, 0, 0, this.iZY.content.getWidth(), this.iZY.content.getHeight(), matrix, true));
                    return;
                }
                this.iZX.iZR.setVisibility(8);
                this.iZY.content.recycle();
                this.iZX.iZP.jaa = null;
            }
        }
    }
}
