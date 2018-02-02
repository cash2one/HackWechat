package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

class j extends l {
    private int ik;
    private r il = new r();
    private boolean im;
    o in;

    private abstract class a extends Animation {
        final /* synthetic */ j ir;
        private float is;
        private float it;

        protected abstract float aa();

        private a(j jVar) {
            this.ir = jVar;
        }

        public void reset() {
            super.reset();
            this.is = this.ir.in.jk;
            this.it = aa() - this.is;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            o oVar = this.ir.in;
            oVar.d(this.is + (this.it * f), oVar.ji);
        }
    }

    private class c extends a {
        final /* synthetic */ j ir;

        private c(j jVar) {
            this.ir = jVar;
            super();
        }

        protected final float aa() {
            return this.ir.iB;
        }
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.ik = visibilityAwareImageButton.getResources().getInteger(17694720);
        r rVar = this.il;
        View aq = rVar.aq();
        if (aq != visibilityAwareImageButton) {
            if (aq != null) {
                View aq2 = rVar.aq();
                int size = rVar.jI.size();
                for (int i = 0; i < size; i++) {
                    if (aq2.getAnimation() == ((android.support.design.widget.r.a) rVar.jI.get(i)).mAnimation) {
                        aq2.clearAnimation();
                    }
                }
                rVar.fq = null;
                rVar.jJ = null;
                rVar.jK = null;
            }
            if (visibilityAwareImageButton != null) {
                rVar.fq = new WeakReference(visibilityAwareImageButton);
            }
        }
        this.il.a(PRESSED_ENABLED_STATE_SET, c(new b(this, (byte) 0)));
        this.il.a(iD, c(new b(this, (byte) 0)));
        this.il.a(EMPTY_STATE_SET, c(new c()));
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.ix = android.support.v4.b.a.a.h(af());
        android.support.v4.b.a.a.a(this.ix, colorStateList);
        if (mode != null) {
            android.support.v4.b.a.a.a(this.ix, mode);
        }
        this.iy = android.support.v4.b.a.a.h(af());
        Drawable drawable = this.iy;
        r1 = new int[3][];
        int[] iArr = new int[]{iD, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        android.support.v4.b.a.a.a(drawable, new ColorStateList(r1, iArr));
        if (i2 > 0) {
            this.iz = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.iz, this.ix, this.iy};
        } else {
            this.iz = null;
            drawableArr = new Drawable[]{this.ix, this.iy};
        }
        this.iA = new LayerDrawable(drawableArr);
        this.in = new o(this.iE.getResources(), this.iA, this.iF.X(), this.iB, this.iB + this.iC);
        o oVar = this.in;
        oVar.jp = false;
        oVar.invalidateSelf();
        this.iF.setBackgroundDrawable(this.in);
    }

    final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.ix != null) {
            android.support.v4.b.a.a.a(this.ix, colorStateList);
        }
        if (this.iz != null) {
            this.iz.c(colorStateList);
        }
    }

    final void setBackgroundTintMode(Mode mode) {
        if (this.ix != null) {
            android.support.v4.b.a.a.a(this.ix, mode);
        }
    }

    void j(float f) {
        if (this.in != null) {
            this.in.d(f, this.iC + f);
            ad();
        }
    }

    void k(float f) {
        if (this.in != null) {
            o oVar = this.in;
            oVar.d(oVar.jk, this.iB + f);
            ad();
        }
    }

    void b(int[] iArr) {
        android.support.design.widget.r.a aVar;
        r rVar = this.il;
        int size = rVar.jI.size();
        for (int i = 0; i < size; i++) {
            android.support.design.widget.r.a aVar2 = (android.support.design.widget.r.a) rVar.jI.get(i);
            if (StateSet.stateSetMatches(aVar2.jN, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        aVar = null;
        if (aVar != rVar.jJ) {
            View aq;
            if (!(rVar.jJ == null || rVar.jK == null)) {
                aq = rVar.aq();
                if (aq != null && aq.getAnimation() == rVar.jK) {
                    aq.clearAnimation();
                }
                rVar.jK = null;
            }
            rVar.jJ = aVar;
            aq = (View) rVar.fq.get();
            if (aVar != null && aq != null && aq.getVisibility() == 0) {
                rVar.jK = aVar.mAnimation;
                aq = rVar.aq();
                if (aq != null) {
                    aq.startAnimation(rVar.jK);
                }
            }
        }
    }

    void Z() {
        r rVar = this.il;
        if (rVar.jK != null) {
            View aq = rVar.aq();
            if (aq != null && aq.getAnimation() == rVar.jK) {
                aq.clearAnimation();
            }
        }
    }

    void a(android.support.design.widget.l.a aVar, boolean z) {
        if (!this.im && this.iE.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iE.getContext(), android.support.design.a.a.aP);
            loadAnimation.setInterpolator(a.eC);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new 1(this, false, aVar));
            this.iE.startAnimation(loadAnimation);
        }
    }

    void b(android.support.design.widget.l.a aVar, boolean z) {
        if (this.iE.getVisibility() != 0 || this.im) {
            this.iE.clearAnimation();
            this.iE.b(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iE.getContext(), android.support.design.a.a.aO);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.eD);
            loadAnimation.setAnimationListener(new 2(this, aVar));
            this.iE.startAnimation(loadAnimation);
        }
    }

    void b(Rect rect) {
        this.in.getPadding(rect);
    }

    private Animation c(Animation animation) {
        animation.setInterpolator(a.eB);
        animation.setDuration((long) this.ik);
        return animation;
    }
}
