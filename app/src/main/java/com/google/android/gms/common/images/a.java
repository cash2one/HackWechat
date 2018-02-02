package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.c.k;
import com.google.android.gms.c.l;
import com.google.android.gms.c.l$a;

public abstract class a {
    final a aMS;
    protected int aMT;
    protected int aMU;

    final void a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("null reference");
        }
        if ((this.aMU & 1) != 0) {
            bitmap = k.c(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        oD();
    }

    final void a(Context context, l lVar) {
        if (this.aMT != 0) {
            int i = this.aMT;
            Resources resources = context.getResources();
            if (this.aMU > 0) {
                l$a com_google_android_gms_c_l_a = new l$a(i, this.aMU);
                if (((Drawable) lVar.get(com_google_android_gms_c_l_a)) == null) {
                    Object drawable = resources.getDrawable(i);
                    if ((this.aMU & 1) != 0) {
                        Bitmap bitmap;
                        if (drawable == null) {
                            bitmap = null;
                        } else if (drawable instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                            bitmap = createBitmap;
                        }
                        drawable = new BitmapDrawable(resources, k.c(bitmap));
                    }
                    lVar.put(com_google_android_gms_c_l_a, drawable);
                }
            } else {
                resources.getDrawable(i);
            }
        }
        oD();
    }

    protected abstract void oD();
}
