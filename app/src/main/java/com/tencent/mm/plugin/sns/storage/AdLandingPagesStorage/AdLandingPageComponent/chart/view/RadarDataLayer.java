package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Map.Entry;
import java.util.Set;

public class RadarDataLayer extends DataLayerView {
    public static final Point riq = new Point(0, 0);
    private Path mY = new Path();
    private int ril = 4;
    private float rio = 1.0f;
    private a rir;
    private a ris;
    private b rit = new b();
    private ValueAnimator riu;
    private boolean riv = true;
    private int riw = 80;
    private Point rix = riq;

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bwQ();
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bwQ();
    }

    public RadarDataLayer(Context context, float f, a aVar) {
        super(context);
        this.rio = f;
        this.rit = aVar.rhy;
        this.ril = aVar.size();
        this.rir = aVar;
        TimeInterpolator timeInterpolator = aVar.rhz;
        long j = aVar.duration;
        if (j > 0) {
            this.riu = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.ris = new a();
            this.riu.setDuration(j);
            this.riu.setInterpolator(timeInterpolator);
            this.riu.addUpdateListener(new 1(this));
        }
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

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.riw = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.rix.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.rir == null) {
            throw new RuntimeException("Error: NullPointerException at data.");
        } else if (this.rir != null) {
            Set entrySet;
            if (this.ris == null) {
                entrySet = this.rir.entrySet();
            } else {
                entrySet = this.ris.entrySet();
            }
            int i = 0;
            for (Entry entry : r0) {
                float floatValue = (float) (((double) this.rix.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.rio) * ((float) this.riw))) * Math.sin(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.ril)))));
                float floatValue2 = (float) (((double) this.rix.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.rio) * ((float) this.riw))) * Math.cos(6.283185307179586d - ((((double) (i * 2)) * 3.141592653589793d) / ((double) this.ril)))));
                if (i == 0) {
                    this.mY.moveTo(floatValue, floatValue2);
                } else {
                    this.mY.lineTo(floatValue, floatValue2);
                }
                if (this.riv) {
                    float f = (float) this.rit.rhG;
                    Paint paint = new Paint();
                    paint.setColor(this.rit.rhF);
                    canvas.drawCircle(floatValue, floatValue2, f, paint);
                }
                i++;
            }
            this.mY.close();
            Path path = this.mY;
            Paint paint2 = new Paint();
            b bVar = this.rit;
            paint2.setColor(bVar.rhD == -1 ? bVar.rhB : bVar.rhD);
            paint2.setStyle(Style.FILL);
            paint2.setAntiAlias(true);
            paint2.setAlpha(this.rit.rhE);
            canvas.drawPath(path, paint2);
            Path path2 = this.mY;
            Paint paint3 = new Paint();
            paint3.setColor(this.rit.rhB);
            paint3.setStyle(Style.STROKE);
            paint3.setStrokeWidth(this.rit.rhC);
            paint3.setAntiAlias(true);
            canvas.drawPath(path2, paint3);
            this.mY.reset();
        }
    }
}
