package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.ah.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class SightPlayImageView$a extends b {
    private WeakReference<SightPlayImageView> quB;

    protected final int bsJ() {
        return a.bqx;
    }

    public SightPlayImageView$a(SightPlayImageView sightPlayImageView) {
        super(0, sightPlayImageView);
        this.quB = new WeakReference(sightPlayImageView);
    }

    public final void cg(int i, int i2) {
        SightPlayImageView sightPlayImageView = (SightPlayImageView) this.quB.get();
        if (sightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
            clear();
        } else if (!SightPlayImageView.a(sightPlayImageView)) {
            SightPlayImageView.a(sightPlayImageView, i);
            SightPlayImageView.b(sightPlayImageView, i2);
            if (sightPlayImageView.quG != null) {
                sightPlayImageView.quG.cg(i, i2);
            }
            if (SightPlayImageView.b(sightPlayImageView)) {
                if (SightPlayImageView.c(sightPlayImageView) >= SightPlayImageView.d(sightPlayImageView)) {
                    SightPlayImageView.c(sightPlayImageView, com.tencent.mm.bv.a.fromDPToPix(sightPlayImageView.getContext(), 150));
                } else {
                    SightPlayImageView.c(sightPlayImageView, com.tencent.mm.bv.a.fromDPToPix(sightPlayImageView.getContext(), 85));
                }
            }
            if (SightPlayImageView.e(sightPlayImageView) > 0) {
                LayoutParams layoutParams = sightPlayImageView.getLayoutParams();
                if (!(layoutParams.width == SightPlayImageView.e(sightPlayImageView) && layoutParams.height == (SightPlayImageView.e(sightPlayImageView) * i2) / i)) {
                    layoutParams.width = SightPlayImageView.e(sightPlayImageView);
                    layoutParams.height = (SightPlayImageView.e(sightPlayImageView) * i2) / i;
                    ag.y(new 1(this, sightPlayImageView, layoutParams));
                    sightPlayImageView.postInvalidate();
                }
                x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            }
            x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[]{Integer.valueOf(SightPlayImageView.e(sightPlayImageView)), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void D(Bitmap bitmap) {
        SightPlayImageView sightPlayImageView = (SightPlayImageView) this.quB.get();
        if (sightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
            clear();
            return;
        }
        sightPlayImageView.setImageBitmap(bitmap);
    }
}
