package com.tencent.mm.aq;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.x;

public class g$a extends BitmapDrawable {
    public static void a(Bitmap bitmap, ImageView imageView) {
        if (imageView != null && imageView.getResources() != null) {
            Drawable com_tencent_mm_aq_g_a = new g$a(imageView.getResources(), bitmap);
            if (imageView.getLayerType() == 1) {
                imageView.destroyDrawingCache();
                imageView.setLayerType(0, null);
            }
            imageView.setImageDrawable(com_tencent_mm_aq_g_a);
        }
    }

    private g$a(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void draw(Canvas canvas) {
        if (getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
        } else if (getBitmap() != null) {
            x.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[]{getBitmap().toString()});
        }
    }
}
