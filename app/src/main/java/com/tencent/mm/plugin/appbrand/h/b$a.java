package com.tencent.mm.plugin.appbrand.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import com.tencent.mm.ui.widget.e;

class b$a extends e {
    public b$a(Drawable drawable) {
        super(drawable, 1);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }
}
