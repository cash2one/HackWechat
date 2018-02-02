package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

class l$a {
    final RectF CN = new RectF();
    final Paint CO = new Paint();
    float CP = 0.0f;
    float CQ = 0.0f;
    float CR = 2.5f;
    int[] CS;
    int CT;
    float CU;
    float CV;
    float CW;
    boolean CX;
    Path CY;
    float CZ;
    double Da;
    int Db;
    int Dc;
    int Dd;
    final Paint De = new Paint(1);
    int Df;
    final Paint fC = new Paint();
    float fN = 0.0f;
    float mA = 5.0f;
    private final Callback mc;
    int ua;

    public l$a(Callback callback) {
        this.mc = callback;
        this.fC.setStrokeCap(Cap.SQUARE);
        this.fC.setAntiAlias(true);
        this.fC.setStyle(Style.STROKE);
        this.CO.setStyle(Style.FILL);
        this.CO.setAntiAlias(true);
    }

    public final void aq(int i) {
        this.CT = i;
        this.ua = this.CS[this.CT];
    }

    final int cx() {
        return (this.CT + 1) % this.CS.length;
    }

    public final void A(float f) {
        this.CP = f;
        invalidateSelf();
    }

    public final void B(float f) {
        this.CQ = f;
        invalidateSelf();
    }

    public final void setRotation(float f) {
        this.fN = f;
        invalidateSelf();
    }

    public final void u(boolean z) {
        if (this.CX != z) {
            this.CX = z;
            invalidateSelf();
        }
    }

    public final void cy() {
        this.CU = this.CP;
        this.CV = this.CQ;
        this.CW = this.fN;
    }

    public final void cz() {
        this.CU = 0.0f;
        this.CV = 0.0f;
        this.CW = 0.0f;
        A(0.0f);
        B(0.0f);
        setRotation(0.0f);
    }

    final void invalidateSelf() {
        this.mc.invalidateDrawable(null);
    }
}
