package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;
import junit.framework.Assert;

public final class b implements f {
    private int mHeight;
    private int mWidth;

    public b(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertFalse(z);
        if (i2 != 0) {
            z2 = false;
        }
        Assert.assertFalse(z2);
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final Bitmap k(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) this.mHeight) / ((float) this.mWidth);
        Bitmap createBitmap = d.createBitmap(this.mWidth, this.mHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        if (f <= ((float) height) / ((float) width)) {
            rect.right = width;
            rect.bottom = (int) (((float) width) * f);
        } else {
            rect.right = (int) (((float) height) / f);
            rect.bottom = height;
        }
        Rect rect2 = new Rect();
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = this.mWidth;
        rect2.bottom = this.mHeight;
        canvas.drawBitmap(bitmap, rect, rect2, null);
        return createBitmap;
    }

    public final String Jo() {
        return String.format("Transformation_w%s_h%s", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }
}
