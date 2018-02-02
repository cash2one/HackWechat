package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class g$d extends Drawable {
    static final Paint vxD = new Paint(6);
    final Rect uk = new Rect();
    WeakReference<Bitmap> vxE = new WeakReference(null);
    private boolean vxF = false;
    private boolean vxG = false;

    public static void b(ImageView imageView, Bitmap bitmap) {
        boolean z;
        boolean z2 = true;
        Drawable com_tencent_mm_pluginsdk_ui_tools_g_d = imageView.getDrawable() instanceof g$d ? (g$d) imageView.getDrawable() : new g$d();
        com_tencent_mm_pluginsdk_ui_tools_g_d.vxE = new WeakReference(bitmap);
        if (imageView.getScaleType() == ScaleType.FIT_XY) {
            z = true;
        } else {
            z = false;
        }
        com_tencent_mm_pluginsdk_ui_tools_g_d.vxF = z;
        if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
            z2 = false;
        }
        com_tencent_mm_pluginsdk_ui_tools_g_d.vxG = z2;
        imageView.setImageDrawable(com_tencent_mm_pluginsdk_ui_tools_g_d);
        imageView.postInvalidate();
    }

    public static void d(ImageView imageView) {
        b(imageView, null);
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Bitmap bitmap = (Bitmap) this.vxE.get();
        if (bitmap == null || bitmap.isRecycled()) {
            obj = null;
        } else {
            copyBounds(this.uk);
            canvas.drawBitmap(bitmap, null, this.uk, vxD);
            obj = 1;
        }
        if (obj == null) {
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
