package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a$c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] iD = new int[]{16842908, 16842910};
    private final Rect gO = new Rect();
    Drawable iA;
    float iB;
    float iC;
    final VisibilityAwareImageButton iE;
    final p iF;
    OnPreDrawListener iG;
    Drawable ix;
    Drawable iy;
    d iz;

    abstract void Z();

    abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void a(a aVar, boolean z);

    abstract void b(Rect rect);

    abstract void b(a aVar, boolean z);

    abstract void b(int[] iArr);

    abstract void j(float f);

    abstract void k(float f);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    l(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.iE = visibilityAwareImageButton;
        this.iF = pVar;
    }

    final void ad() {
        Rect rect = this.gO;
        b(rect);
        c(rect);
        this.iF.d(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c(Rect rect) {
    }

    boolean ab() {
        return false;
    }

    final d a(int i, ColorStateList colorStateList) {
        Resources resources = this.iE.getResources();
        d ae = ae();
        int color = resources.getColor(a$c.aZ);
        int color2 = resources.getColor(a$c.aY);
        int color3 = resources.getColor(a$c.aW);
        int color4 = resources.getColor(a$c.aX);
        ae.fG = color;
        ae.fH = color2;
        ae.fI = color3;
        ae.fJ = color4;
        float f = (float) i;
        if (ae.fF != f) {
            ae.fF = f;
            ae.fC.setStrokeWidth(f * 1.3333f);
            ae.fM = true;
            ae.invalidateSelf();
        }
        ae.c(colorStateList);
        return ae;
    }

    d ae() {
        return new d();
    }

    void ac() {
    }

    static GradientDrawable af() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
