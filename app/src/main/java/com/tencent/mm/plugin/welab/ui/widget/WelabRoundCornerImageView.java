package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.i;
import android.support.v4.b.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WelabRoundCornerImageView extends ImageView {
    public float tQd;

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WelabRoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() < 0 || bitmap.getHeight() < 0) {
            super.setImageBitmap(bitmap);
        } else if (this.tQd <= 0.0f) {
            super.setImageBitmap(bitmap);
        } else {
            Drawable a = k.a(getResources(), bitmap);
            float min = Math.min(((float) bitmap.getWidth()) * this.tQd, ((float) bitmap.getHeight()) * this.tQd);
            if (a.jf != min) {
                a.un = false;
                if (i.o(min)) {
                    a.fC.setShader(a.uh);
                } else {
                    a.fC.setShader(null);
                }
                a.jf = min;
                a.invalidateSelf();
            }
            super.setImageDrawable(a);
        }
    }
}
