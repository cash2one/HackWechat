package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.b.b;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

final class l extends Drawable implements Animatable {
    private static final Interpolator CD = new b();
    private static final Interpolator eA = new LinearInterpolator();
    private final int[] CE = new int[]{WebView.NIGHT_MODE_COLOR};
    final a CF;
    private View CG;
    private float CH;
    private double CI;
    private double CJ;
    boolean CK;
    private float fN;
    private Animation mAnimation;
    private Resources mResources;
    private final Callback mc = new 3(this);
    private final ArrayList<Animation> mg = new ArrayList();

    static /* synthetic */ void a(l lVar, float f, a aVar) {
        a(f, aVar);
        float floor = (float) (Math.floor((double) (aVar.CW / 0.8f)) + 1.0d);
        float a = a(aVar);
        aVar.A((((aVar.CV - a) - aVar.CU) * f) + aVar.CU);
        aVar.B(aVar.CV);
        aVar.setRotation(((floor - aVar.CW) * f) + aVar.CW);
    }

    public l(Context context, View view) {
        this.CG = view;
        this.mResources = context.getResources();
        this.CF = new a(this.mc);
        a aVar = this.CF;
        aVar.CS = this.CE;
        aVar.aq(0);
        a aVar2 = this.CF;
        float f = this.mResources.getDisplayMetrics().density;
        this.CI = ((double) f) * 40.0d;
        this.CJ = ((double) f) * 40.0d;
        float f2 = 2.5f * f;
        aVar2.mA = f2;
        aVar2.fC.setStrokeWidth(f2);
        aVar2.invalidateSelf();
        aVar2.Da = 8.75d * ((double) f);
        aVar2.aq(0);
        f2 = 10.0f * f;
        f *= 5.0f;
        aVar2.Db = (int) f2;
        aVar2.Dc = (int) f;
        f = (float) Math.min((int) this.CI, (int) this.CJ);
        f = (aVar2.Da <= 0.0d || f < 0.0f) ? (float) Math.ceil((double) (aVar2.mA / 2.0f)) : (float) (((double) (f / 2.0f)) - aVar2.Da);
        aVar2.CR = f;
        aVar = this.CF;
        Animation 1 = new 1(this, aVar);
        1.setRepeatCount(-1);
        1.setRepeatMode(1);
        1.setInterpolator(eA);
        1.setAnimationListener(new 2(this, aVar));
        this.mAnimation = 1;
    }

    public final void t(boolean z) {
        this.CF.u(z);
    }

    public final void y(float f) {
        a aVar = this.CF;
        if (f != aVar.CZ) {
            aVar.CZ = f;
            aVar.invalidateSelf();
        }
    }

    public final void z(float f) {
        this.CF.A(0.0f);
        this.CF.B(f);
    }

    public final int getIntrinsicHeight() {
        return (int) this.CJ;
    }

    public final int getIntrinsicWidth() {
        return (int) this.CI;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.fN, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.CF;
        RectF rectF = aVar.CN;
        rectF.set(bounds);
        rectF.inset(aVar.CR, aVar.CR);
        float f = 360.0f * (aVar.CP + aVar.fN);
        float f2 = ((aVar.CQ + aVar.fN) * 360.0f) - f;
        aVar.fC.setColor(aVar.ua);
        canvas.drawArc(rectF, f, f2, false, aVar.fC);
        if (aVar.CX) {
            if (aVar.CY == null) {
                aVar.CY = new Path();
                aVar.CY.setFillType(FillType.EVEN_ODD);
            } else {
                aVar.CY.reset();
            }
            float f3 = ((float) (((int) aVar.CR) / 2)) * aVar.CZ;
            float cos = (float) ((aVar.Da * Math.cos(0.0d)) + ((double) bounds.exactCenterX()));
            float sin = (float) ((aVar.Da * Math.sin(0.0d)) + ((double) bounds.exactCenterY()));
            aVar.CY.moveTo(0.0f, 0.0f);
            aVar.CY.lineTo(((float) aVar.Db) * aVar.CZ, 0.0f);
            aVar.CY.lineTo((((float) aVar.Db) * aVar.CZ) / 2.0f, ((float) aVar.Dc) * aVar.CZ);
            aVar.CY.offset(cos - f3, sin);
            aVar.CY.close();
            aVar.CO.setColor(aVar.ua);
            canvas.rotate((f + f2) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(aVar.CY, aVar.CO);
        }
        if (aVar.Dd < 255) {
            aVar.De.setColor(aVar.Df);
            aVar.De.setAlpha(255 - aVar.Dd);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), (float) (bounds.width() / 2), aVar.De);
        }
        canvas.restoreToCount(save);
    }

    public final void setAlpha(int i) {
        this.CF.Dd = i;
    }

    public final int getAlpha() {
        return this.CF.Dd;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        a aVar = this.CF;
        aVar.fC.setColorFilter(colorFilter);
        aVar.invalidateSelf();
    }

    final void setRotation(float f) {
        this.fN = f;
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        ArrayList arrayList = this.mg;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        this.mAnimation.reset();
        this.CF.cy();
        if (this.CF.CQ != this.CF.CP) {
            this.CK = true;
            this.mAnimation.setDuration(666);
            this.CG.startAnimation(this.mAnimation);
            return;
        }
        this.CF.aq(0);
        this.CF.cz();
        this.mAnimation.setDuration(1332);
        this.CG.startAnimation(this.mAnimation);
    }

    public final void stop() {
        this.CG.clearAnimation();
        setRotation(0.0f);
        this.CF.u(false);
        this.CF.aq(0);
        this.CF.cz();
    }

    private static float a(a aVar) {
        return (float) Math.toRadians(((double) aVar.mA) / (6.283185307179586d * aVar.Da));
    }

    private static void a(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int i = aVar.CS[aVar.CT];
            int i2 = aVar.CS[aVar.cx()];
            i = Integer.valueOf(i).intValue();
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            i &= 255;
            i2 = Integer.valueOf(i2).intValue();
            aVar.ua = (((int) (f2 * ((float) ((i2 & 255) - i)))) + i) | ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f2))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f2))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f2)) + i5) << 8));
        }
    }
}
