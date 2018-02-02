package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.b.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class m extends k {
    private InsetDrawable iI;
    private final Interpolator mInterpolator;

    m(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.mInterpolator = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.iE.getContext(), 17563661);
    }

    final void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.ix = a.h(af());
        a.a(this.ix, colorStateList);
        if (mode != null) {
            a.a(this.ix, mode);
        }
        if (i2 > 0) {
            this.iz = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.iz, this.ix});
        } else {
            this.iz = null;
            layerDrawable = this.ix;
        }
        this.iy = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.iA = this.iy;
        this.iF.setBackgroundDrawable(this.iy);
    }

    public final void j(float f) {
        this.iE.setElevation(f);
        if (this.iF.Y()) {
            ad();
        }
    }

    final void k(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, a(ObjectAnimator.ofFloat(this.iE, "translationZ", new float[]{f})));
        stateListAnimator.addState(iD, a(ObjectAnimator.ofFloat(this.iE, "translationZ", new float[]{f})));
        stateListAnimator.addState(EMPTY_STATE_SET, a(ObjectAnimator.ofFloat(this.iE, "translationZ", new float[]{0.0f})));
        this.iE.setStateListAnimator(stateListAnimator);
        if (this.iF.Y()) {
            ad();
        }
    }

    final void c(Rect rect) {
        if (this.iF.Y()) {
            this.iI = new InsetDrawable(this.iy, rect.left, rect.top, rect.right, rect.bottom);
            this.iF.setBackgroundDrawable(this.iI);
            return;
        }
        this.iF.setBackgroundDrawable(this.iy);
    }

    final void b(int[] iArr) {
    }

    final void Z() {
    }

    final boolean ab() {
        return false;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.mInterpolator);
        return animator;
    }

    final d ae() {
        return new e();
    }

    final void b(Rect rect) {
        if (this.iF.Y()) {
            float X = this.iF.X();
            float elevation = this.iE.getElevation() + this.iC;
            int ceil = (int) Math.ceil((double) o.b(elevation, X, false));
            int ceil2 = (int) Math.ceil((double) o.a(elevation, X, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
