package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.a.i;
import android.support.v4.d.d;
import android.support.v4.d.e;
import android.support.v4.view.z;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.gif.MMGIFException;
import org.xwalk.core.R$styleable;

final class f {
    private static final boolean fO = (VERSION.SDK_INT < 18);
    private static final Paint fP = null;
    private boolean fQ;
    float fR;
    private final Rect fS;
    private final Rect fT;
    private final RectF fU;
    private int fV = 16;
    private int fW = 16;
    float fX = 15.0f;
    float fY = 15.0f;
    int fZ;
    private int gA;
    private float gB;
    private float gC;
    private float gD;
    private int gE;
    int ga;
    private float gb;
    private float gc;
    private float gd;
    private float ge;
    private float gf;
    private float gg;
    Typeface gh;
    Typeface gi;
    private Typeface gj;
    private CharSequence gk;
    private boolean gl;
    private boolean gm;
    private Bitmap gn;
    private Paint go;
    private float gp;
    private float gq;
    private float gr;
    private float gs;
    private boolean gt;
    private final TextPaint gu;
    Interpolator gv;
    private Interpolator gw;
    private float gx;
    private float gy;
    private float gz;
    CharSequence mText;
    private final View mView;

    public f(View view) {
        this.mView = view;
        this.gu = new TextPaint(129);
        this.fT = new Rect();
        this.fS = new Rect();
        this.fU = new RectF();
    }

    final void a(Interpolator interpolator) {
        this.gw = interpolator;
        P();
    }

    final void v(int i) {
        if (this.ga != i) {
            this.ga = i;
            P();
        }
    }

    final void b(int i, int i2, int i3, int i4) {
        if (!a(this.fS, i, i2, i3, i4)) {
            this.fS.set(i, i2, i3, i4);
            this.gt = true;
            N();
        }
    }

    final void c(int i, int i2, int i3, int i4) {
        if (!a(this.fT, i, i2, i3, i4)) {
            this.fT.set(i, i2, i3, i4);
            this.gt = true;
            N();
        }
    }

    private void N() {
        boolean z = this.fT.width() > 0 && this.fT.height() > 0 && this.fS.width() > 0 && this.fS.height() > 0;
        this.fQ = z;
    }

    final void w(int i) {
        if (this.fV != i) {
            this.fV = i;
            P();
        }
    }

    final void x(int i) {
        if (this.fW != i) {
            this.fW = i;
            P();
        }
    }

    final void y(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.TextAppearance);
        if (obtainStyledAttributes.hasValue(i.TextAppearance_android_textColor)) {
            this.ga = obtainStyledAttributes.getColor(i.TextAppearance_android_textColor, this.ga);
        }
        if (obtainStyledAttributes.hasValue(i.TextAppearance_android_textSize)) {
            this.fY = (float) obtainStyledAttributes.getDimensionPixelSize(i.TextAppearance_android_textSize, (int) this.fY);
        }
        this.gA = obtainStyledAttributes.getInt(i.TextAppearance_android_shadowColor, 0);
        this.gy = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowDx, 0.0f);
        this.gz = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowDy, 0.0f);
        this.gx = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.gh = A(i);
        }
        P();
    }

    final void z(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.TextAppearance);
        if (obtainStyledAttributes.hasValue(i.TextAppearance_android_textColor)) {
            this.fZ = obtainStyledAttributes.getColor(i.TextAppearance_android_textColor, this.fZ);
        }
        if (obtainStyledAttributes.hasValue(i.TextAppearance_android_textSize)) {
            this.fX = (float) obtainStyledAttributes.getDimensionPixelSize(i.TextAppearance_android_textSize, (int) this.fX);
        }
        this.gE = obtainStyledAttributes.getInt(i.TextAppearance_android_shadowColor, 0);
        this.gC = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowDx, 0.0f);
        this.gD = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowDy, 0.0f);
        this.gB = obtainStyledAttributes.getFloat(i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.gi = A(i);
        }
        P();
    }

    private Typeface A(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    final void f(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.fR) {
            this.fR = f;
            O();
        }
    }

    private void O() {
        g(this.fR);
    }

    private void g(float f) {
        this.fU.left = a((float) this.fS.left, (float) this.fT.left, f, this.gv);
        this.fU.top = a(this.gb, this.gc, f, this.gv);
        this.fU.right = a((float) this.fS.right, (float) this.fT.right, f, this.gv);
        this.fU.bottom = a((float) this.fS.bottom, (float) this.fT.bottom, f, this.gv);
        this.gf = a(this.gd, this.ge, f, this.gv);
        this.gg = a(this.gb, this.gc, f, this.gv);
        h(a(this.fX, this.fY, f, this.gw));
        if (this.ga != this.fZ) {
            this.gu.setColor(b(this.fZ, this.ga, f));
        } else {
            this.gu.setColor(this.ga);
        }
        this.gu.setShadowLayer(a(this.gB, this.gx, f, null), a(this.gC, this.gy, f, null), a(this.gD, this.gz, f, null), b(this.gE, this.gA, f));
        z.E(this.mView);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.gk != null && this.fQ) {
            float f;
            float f2 = this.gf;
            float f3 = this.gg;
            int i = (!this.gm || this.gn == null) ? 0 : 1;
            if (i != 0) {
                f = this.gp * this.gr;
            } else {
                this.gu.ascent();
                f = 0.0f;
                this.gu.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.gr != 1.0f) {
                canvas.scale(this.gr, this.gr, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.gn, f2, f3, this.go);
            } else {
                canvas.drawText(this.gk, 0, this.gk.length(), f2, f3, this.gu);
            }
        }
        canvas.restoreToCount(save);
    }

    private void h(float f) {
        i(f);
        boolean z = fO && this.gr != 1.0f;
        this.gm = z;
        if (this.gm && this.gn == null && !this.fS.isEmpty() && !TextUtils.isEmpty(this.gk)) {
            g(0.0f);
            this.gp = this.gu.ascent();
            this.gq = this.gu.descent();
            int round = Math.round(this.gu.measureText(this.gk, 0, this.gk.length()));
            int round2 = Math.round(this.gq - this.gp);
            if (round > 0 && round2 > 0) {
                this.gn = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.gn).drawText(this.gk, 0, this.gk.length(), 0.0f, ((float) round2) - this.gu.descent(), this.gu);
                if (this.go == null) {
                    this.go = new Paint(3);
                }
            }
        }
        z.E(this.mView);
    }

    private void i(float f) {
        boolean z = true;
        if (this.mText != null) {
            float width;
            float f2;
            boolean z2;
            if (c(f, this.fY)) {
                width = (float) this.fT.width();
                float f3 = this.fY;
                this.gr = 1.0f;
                if (this.gj != this.gh) {
                    this.gj = this.gh;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.fS.width();
                width = this.fX;
                if (this.gj != this.gi) {
                    this.gj = this.gi;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (c(f, this.fX)) {
                    this.gr = 1.0f;
                } else {
                    this.gr = f / this.fX;
                }
            }
            if (f2 > 0.0f) {
                if (this.gs != width || this.gt || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.gs = width;
                this.gt = false;
            }
            if (this.gk == null || r0) {
                this.gu.setTextSize(this.gs);
                this.gu.setTypeface(this.gj);
                TextPaint textPaint = this.gu;
                if (this.gr != 1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.gu, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.gk)) {
                    d dVar;
                    this.gk = ellipsize;
                    CharSequence charSequence = this.gk;
                    if (z.I(this.mView) != 1) {
                        z = false;
                    }
                    if (z) {
                        dVar = e.vO;
                    } else {
                        dVar = e.vN;
                    }
                    this.gl = dVar.a(charSequence, charSequence.length());
                }
            }
        }
    }

    public final void P() {
        int i = 1;
        float f = 0.0f;
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            float measureText;
            float f2 = this.gs;
            i(this.fY);
            if (this.gk != null) {
                measureText = this.gu.measureText(this.gk, 0, this.gk.length());
            } else {
                measureText = 0.0f;
            }
            int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(this.fW, this.gl ? 1 : 0);
            switch (absoluteGravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.gc = ((float) this.fT.top) - this.gu.ascent();
                    break;
                case 80:
                    this.gc = (float) this.fT.bottom;
                    break;
                default:
                    this.gc = (((this.gu.descent() - this.gu.ascent()) / 2.0f) - this.gu.descent()) + ((float) this.fT.centerY());
                    break;
            }
            switch (absoluteGravity & 8388615) {
                case 1:
                    this.ge = ((float) this.fT.centerX()) - (measureText / 2.0f);
                    break;
                case 5:
                    this.ge = ((float) this.fT.right) - measureText;
                    break;
                default:
                    this.ge = (float) this.fT.left;
                    break;
            }
            i(this.fX);
            if (this.gk != null) {
                f = this.gu.measureText(this.gk, 0, this.gk.length());
            }
            int i2 = this.fV;
            if (!this.gl) {
                i = 0;
            }
            i2 = android.support.v4.view.f.getAbsoluteGravity(i2, i);
            switch (i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.gb = ((float) this.fS.top) - this.gu.ascent();
                    break;
                case 80:
                    this.gb = (float) this.fS.bottom;
                    break;
                default:
                    this.gb = (((this.gu.descent() - this.gu.ascent()) / 2.0f) - this.gu.descent()) + ((float) this.fS.centerY());
                    break;
            }
            switch (i2 & 8388615) {
                case 1:
                    this.gd = ((float) this.fS.centerX()) - (f / 2.0f);
                    break;
                case 5:
                    this.gd = ((float) this.fS.right) - f;
                    break;
                default:
                    this.gd = (float) this.fS.left;
                    break;
            }
            Q();
            h(f2);
            O();
        }
    }

    final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.gk = null;
            Q();
            P();
        }
    }

    private void Q() {
        if (this.gn != null) {
            this.gn.recycle();
            this.gn = null;
        }
    }

    private static boolean c(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.b(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
