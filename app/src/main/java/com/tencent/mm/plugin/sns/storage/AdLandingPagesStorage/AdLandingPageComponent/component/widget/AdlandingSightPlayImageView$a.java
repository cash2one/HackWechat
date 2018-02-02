package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class AdlandingSightPlayImageView$a extends a {
    private WeakReference<AdlandingSightPlayImageView> quB;

    protected final int bsJ() {
        return a.bqx;
    }

    public AdlandingSightPlayImageView$a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
        super(0, adlandingSightPlayImageView);
        this.quB = new WeakReference(adlandingSightPlayImageView);
    }

    public final void cg(int i, int i2) {
        AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.quB.get();
        if (adlandingSightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
            clear();
        } else if (!AdlandingSightPlayImageView.a(adlandingSightPlayImageView)) {
            AdlandingSightPlayImageView.a(adlandingSightPlayImageView, i);
            AdlandingSightPlayImageView.b(adlandingSightPlayImageView, i2);
            if (adlandingSightPlayImageView.quG != null) {
                adlandingSightPlayImageView.quG.cg(i, i2);
            }
            if (AdlandingSightPlayImageView.b(adlandingSightPlayImageView)) {
                if (AdlandingSightPlayImageView.c(adlandingSightPlayImageView) >= AdlandingSightPlayImageView.d(adlandingSightPlayImageView)) {
                    AdlandingSightPlayImageView.c(adlandingSightPlayImageView, com.tencent.mm.bv.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150));
                } else {
                    AdlandingSightPlayImageView.c(adlandingSightPlayImageView, com.tencent.mm.bv.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85));
                }
            }
            if (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) > 0) {
                LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                if (!(layoutParams.width == AdlandingSightPlayImageView.e(adlandingSightPlayImageView) && layoutParams.height == (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) * i2) / i)) {
                    layoutParams.width = AdlandingSightPlayImageView.e(adlandingSightPlayImageView);
                    layoutParams.height = (AdlandingSightPlayImageView.e(adlandingSightPlayImageView) * i2) / i;
                    ag.y(new 1(this, adlandingSightPlayImageView, layoutParams));
                    adlandingSightPlayImageView.postInvalidate();
                }
                x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
            }
            x.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[]{Integer.valueOf(AdlandingSightPlayImageView.e(adlandingSightPlayImageView)), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void D(Bitmap bitmap) {
        AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.quB.get();
        if (adlandingSightPlayImageView == null) {
            x.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
            clear();
            return;
        }
        adlandingSightPlayImageView.setImageBitmap(bitmap);
    }
}
