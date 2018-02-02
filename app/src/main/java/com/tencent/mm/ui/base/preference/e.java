package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.bv.a;

public final class e {
    Bitmap bitmap = null;
    int mPo = -1;

    public final void e(ImageView imageView) {
        if (imageView != null) {
            if (this.mPo != -1) {
                imageView.setImageDrawable(a.b(imageView.getContext(), this.mPo));
            }
            if (this.bitmap != null) {
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }
}
