package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class SightPlayAutoSizeImageView$a extends b {
    private WeakReference<SightPlayAutoSizeImageView> quB;

    protected final int bsJ() {
        return R.a.bqx;
    }

    public SightPlayAutoSizeImageView$a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
        super(0, sightPlayAutoSizeImageView);
        this.quB = new WeakReference(sightPlayAutoSizeImageView);
    }

    public final void cg(int i, int i2) {
    }

    public final void D(Bitmap bitmap) {
        SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.quB.get();
        if (sightPlayAutoSizeImageView == null) {
            x.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
            clear();
            return;
        }
        sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
        sightPlayAutoSizeImageView.setImageBitmap(bitmap);
    }
}
