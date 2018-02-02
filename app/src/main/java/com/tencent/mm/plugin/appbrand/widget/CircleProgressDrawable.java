package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF jUR = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF jUS = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private Paint fC;
    private int jUT = Math.round(ac.getResources().getDisplayMetrics().density * 48.0f);
    private int jUU = 4;
    private boolean jUV = false;
    private int jUW = 0;
    public RingPathTransform jUX = new RingPathTransform((byte) 0);
    public RingRotation jUY = new RingRotation((byte) 0);
    public ArrayList<Animator> mg = new ArrayList();
    public int mz = WebView.NIGHT_MODE_COLOR;

    public final void start() {
        Object obj;
        Iterator it = this.mg.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            it = this.mg.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        Iterator it = this.mg.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
    }

    public final int getIntrinsicWidth() {
        return this.jUT;
    }

    public final int getIntrinsicHeight() {
        return this.jUT;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save;
            if (this.fC == null) {
                this.fC = new Paint();
                this.fC.setAntiAlias(true);
                this.fC.setStyle(Style.STROKE);
                this.fC.setStrokeWidth((float) this.jUU);
                this.fC.setStrokeCap(Cap.SQUARE);
                this.fC.setStrokeJoin(Join.MITER);
            }
            int save2 = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            int width = bounds.width();
            int height = bounds.height();
            Paint paint = this.fC;
            canvas.scale(((float) width) / jUR.width(), ((float) height) / jUR.height());
            canvas.translate(jUR.width() / 2.0f, jUR.height() / 2.0f);
            if (this.jUV) {
                save = canvas.save();
                paint.setColor(this.jUW);
                canvas.drawArc(jUS, 0.0f, 360.0f, false, paint);
                canvas.restoreToCount(save);
            }
            save = canvas.save();
            paint.setColor(this.mz);
            canvas.rotate(RingRotation.a(this.jUY));
            Canvas canvas2 = canvas;
            canvas2.drawArc(jUS, -90.0f + ((this.jUX.mH + this.jUX.mF) * 360.0f), 360.0f * (this.jUX.mG - this.jUX.mF), false, paint);
            canvas.restoreToCount(save);
            canvas.restoreToCount(save2);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }
}
