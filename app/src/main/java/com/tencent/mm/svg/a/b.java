package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;

public abstract class b extends Drawable {
    public long mDuration = 0;
    protected View mnm;
    protected final Rect uk = new Rect();
    protected int xCs = 0;
    protected boolean xCt = false;
    protected Paint xCu = new Paint();
    protected int xCv = 0;
    protected int xCw = 0;
    protected int xCx = 0;
    protected int xCy = 0;
    protected float xCz;

    public b(int i, int i2, int i3) {
        this.xCx = i;
        this.xCy = i2;
        this.xCz = 1.0f;
        this.xCv = this.xCx;
        this.xCw = this.xCy;
        setLevel(10000);
        this.xCs = i3;
    }

    protected final void clc() {
        this.uk.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.xCt = true;
    }

    protected boolean onLevelChange(int i) {
        cle();
        return super.onLevelChange(i);
    }

    protected final void cld() {
        if (this.xCt) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.uk);
        }
        this.xCt = false;
    }

    private void cle() {
        this.mnm = a.v(this);
        if (this.mnm != null) {
            a.b(this.mnm, this.xCu);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        cle();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.xCu.setAlpha(i);
        if (this.mnm != null && VERSION.SDK_INT >= 17) {
            try {
                this.mnm.setLayerPaint(this.xCu);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.xCu.setColorFilter(colorFilter);
        if (this.mnm != null && VERSION.SDK_INT >= 17) {
            try {
                this.mnm.setLayerPaint(this.xCu);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    public int getOpacity() {
        if (this.mnm != null && this.mnm.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.xCu == null || this.xCu.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    protected final void j(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.clg()) {
            int height = this.uk.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(127);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.uk.width()) - paint.measureText("SVG"), (float) ((this.uk.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.xCv;
    }

    public int getIntrinsicHeight() {
        return this.xCw;
    }
}
