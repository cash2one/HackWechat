package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point riq = new Point(0, 0);
    private Rect fD = new Rect();
    private Path mY = new Path();
    private List<PointF> riA;
    private int ril = 4;
    private int rim = 4;
    private float rio = 1.0f;
    public c rip;
    private int riw = 80;
    private Point rix = riq;
    private Spannable[] riz;

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bwQ();
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bwQ();
    }

    public RadarGrid(Context context, int i, int i2, float f, Spannable[] spannableArr, c cVar) {
        super(context);
        this.rio = f;
        this.ril = i;
        this.rim = i2;
        this.rio = f;
        this.riz = spannableArr;
        this.rip = cVar;
    }

    private void bwQ() {
        setMinimumHeight(JsApiSetBackgroundAudioState.CTRL_INDEX);
        setMinimumWidth(JsApiSetBackgroundAudioState.CTRL_INDEX);
    }

    protected final int bwN() {
        return this.riw * 2;
    }

    protected final int bwO() {
        return this.riw * 2;
    }

    private List<PointF> av(float f) {
        List<PointF> arrayList = new ArrayList();
        for (int i = 0; i < this.ril; i++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.rix.x) - (((double) (((float) this.riw) * f)) * Math.sin((((double) (i * 2)) * 3.141592653589793d) / ((double) this.ril)))), (float) (((double) this.rix.y) - (((double) (((float) this.riw) * f)) * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) this.ril)))));
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        int i;
        PointF pointF;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.riw = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.rix.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.rip.rib != null) {
            width = (int) (((float) width) / 2.0f);
            height = (int) (((float) height) / 2.0f);
            i = (int) (((float) (this.riw * 2)) + (this.rip.rhY * 2.0f));
            int width2 = (this.rip.rib.getWidth() * i) / this.rip.rib.getHeight();
            if (this.rip.rib != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(this.rip.rib, width2, i, false), (float) (width - (width2 >>> 1)), (float) (height - (i >>> 1)), null);
            }
        }
        if (this.rip.rhI) {
            switch (this.rip.rhH) {
                case 0:
                    this.riA = av(1.0f);
                    for (width = 0; width < this.ril; width++) {
                        pointF = (PointF) this.riA.get(width);
                        if (width == 0) {
                            this.mY.moveTo(pointF.x, pointF.y);
                        } else {
                            this.mY.lineTo(pointF.x, pointF.y);
                        }
                    }
                    this.mY.close();
                    if (this.rip.backgroundColor != 0 && this.rip.rib == null) {
                        canvas.drawPath(this.mY, bwR());
                        break;
                    }
                case 1:
                    canvas.drawCircle((float) this.rix.x, (float) this.rix.y, (float) this.riw, bwR());
                    break;
            }
        }
        if (this.rip.rhJ) {
            this.riA = av(1.0f);
            for (int i2 = 0; i2 < this.ril; i2++) {
                pointF = (PointF) this.riA.get(i2);
                float f = (float) this.rix.x;
                float f2 = (float) this.rix.y;
                float f3 = pointF.x;
                float f4 = pointF.y;
                Paint paint = new Paint();
                paint.setColor(this.rip.rhO);
                paint.setStrokeWidth(this.rip.rhP);
                canvas.drawLine(f, f2, f3, f4, paint);
            }
        }
        if (this.rip.rhI) {
            switch (this.rip.rhH) {
                case 0:
                    canvas.drawPath(this.mY, bwS());
                    this.mY.reset();
                    for (width = 1; width < this.rim; width++) {
                        this.riA = av((((float) width) * 1.0f) / ((float) this.rim));
                        for (i = 0; i < this.ril; i++) {
                            pointF = (PointF) this.riA.get(i);
                            if (i == 0) {
                                this.mY.moveTo(pointF.x, pointF.y);
                            } else {
                                this.mY.lineTo(pointF.x, pointF.y);
                            }
                            f3 = pointF.x;
                            float f5 = pointF.y;
                            f4 = (float) this.rip.ria;
                            paint = new Paint();
                            paint.setColor(this.rip.rhZ);
                            paint.setStyle(Style.FILL);
                            paint.setAntiAlias(true);
                            canvas.drawCircle(f3, f5, f4, paint);
                        }
                        this.mY.close();
                        canvas.drawPath(this.mY, bwT());
                        this.mY.reset();
                    }
                    break;
                case 1:
                    canvas.drawCircle((float) this.rix.x, (float) this.rix.y, (float) this.riw, bwS());
                    for (height = 1; height < this.rim; height++) {
                        canvas.drawCircle((float) this.rix.x, (float) this.rix.y, ((float) this.riw) * ((((float) height) * 1.0f) / ((float) this.rim)), bwT());
                    }
                    break;
            }
        }
        if (this.riz != null && this.rip.rhL) {
            if (this.riz.length != this.ril) {
                throw new RuntimeException("Labels array length not matches longitude lines number.");
            }
            int i3 = 0;
            while (i3 < this.ril) {
                CharSequence charSequence = this.riz[i3];
                if (!charSequence.equals(null)) {
                    float f6;
                    float f7;
                    if (i3 == 0 || i3 == (this.ril >>> 1)) {
                        f6 = 0.5f;
                    } else if (i3 <= 0 || i3 >= (this.ril >>> 1)) {
                        f6 = 1.0f;
                    } else {
                        f6 = 0.0f;
                    }
                    if (i3 == 0) {
                        f7 = this.rip.rhT;
                    } else if (i3 == (this.ril >>> 1)) {
                        f7 = -this.rip.rhT;
                    } else {
                        f7 = 0.0f;
                    }
                    TextPaint textPaint = new TextPaint();
                    textPaint.setColor(this.rip.rhR);
                    textPaint.setTextSize(this.rip.rhS);
                    StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, 1000, Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                    f = (float) (((double) (((float) this.rix.x) - (staticLayout.getLineWidth(0) * f6))) - (((double) (((float) this.riw) + this.rip.rhT)) * Math.sin(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.ril)))));
                    f2 = (float) ((((double) (this.rix.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.riw) + this.rip.rhT)) * Math.cos(6.283185307179586d - ((((double) (i3 * 2)) * 3.141592653589793d) / ((double) this.ril))))) - ((double) f7));
                    canvas.save();
                    canvas.translate(f, f2);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                i3++;
            }
        }
    }

    private Paint bwR() {
        Paint paint = new Paint();
        paint.setColor(this.rip.backgroundColor);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bwS() {
        Paint paint = new Paint();
        c cVar = this.rip;
        paint.setColor(cVar.rhM == -1 ? cVar.rhN : cVar.rhM);
        paint.setStyle(Style.STROKE);
        cVar = this.rip;
        paint.setStrokeWidth(cVar.rhQ == -1.0f ? cVar.rhP : cVar.rhQ);
        paint.setAntiAlias(true);
        return paint;
    }

    private Paint bwT() {
        Paint paint = new Paint();
        paint.setColor(this.rip.rhN);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(this.rip.rhP);
        paint.setAntiAlias(true);
        return paint;
    }

    public void setBackgroundColor(int i) {
        this.rip.backgroundColor = i;
        invalidate();
    }
}
