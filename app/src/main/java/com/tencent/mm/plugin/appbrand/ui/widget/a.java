package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements f {
    private final int jPZ;
    private final int jQb;
    private final int jQc = -1;

    public a(int i, int i2) {
        this.jPZ = i;
        this.jQb = i2;
    }

    public final Bitmap k(Bitmap bitmap) {
        Bitmap a = d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.jPZ, this.jPZ, false);
        if (a != createScaledBitmap) {
            l.EA().h(a);
        }
        a = Bitmap.createBitmap(this.jPZ + (this.jQb * 2), this.jPZ + (this.jQb * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(a);
        canvas.drawBitmap(createScaledBitmap, (float) this.jQb, (float) this.jQb, new Paint());
        l.EA().h(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.jQc);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.jQb);
        canvas.drawCircle((float) ((this.jPZ / 2) + this.jQb), (float) ((this.jPZ / 2) + this.jQb), (float) (this.jPZ / 2), paint);
        return a;
    }

    public final String Jo() {
        return "WxaNearbyShowcaseIcon";
    }
}
