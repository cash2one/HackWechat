package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b extends Drawable {
    public float Wl = 0.0f;
    public final Paint fC = new Paint(1);
    private final RectF kcv = new RectF();
    private float kcw = ((float) a.fromDPToPix(ac.getContext(), 3));
    private final Path mY = new Path();

    public final void draw(Canvas canvas) {
        float width = this.kcv.width();
        float height = this.kcv.height();
        float f = this.kcv.left;
        float f2 = this.kcv.top;
        float f3 = this.kcv.right;
        float f4 = this.kcv.bottom;
        width = Math.min(this.Wl, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(f + this.kcw, f2 + this.kcw, f3 - this.kcw, f4 - this.kcw), width, width, this.fC);
        canvas.drawPath(this.mY, this.fC);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.kcv.set((float) i, (float) i2, (float) i3, (float) i4);
        float f = ((float) (i + i3)) / 2.0f;
        this.mY.moveTo(f, (float) i4);
        this.mY.lineTo(f - this.kcw, ((float) i4) - this.kcw);
        this.mY.lineTo(f + this.kcw, ((float) i4) - this.kcw);
        this.mY.close();
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
