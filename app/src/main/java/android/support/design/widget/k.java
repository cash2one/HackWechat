package android.support.design.widget;

import android.support.design.widget.l.a;
import android.support.v4.view.z;

class k extends j {
    private boolean im;

    k(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
    }

    boolean ab() {
        return true;
    }

    final void ac() {
        float rotation = this.iE.getRotation();
        if (this.in != null) {
            o oVar = this.in;
            float f = -rotation;
            if (oVar.fN != f) {
                oVar.fN = f;
                oVar.invalidateSelf();
            }
        }
        if (this.iz != null) {
            d dVar = this.iz;
            rotation = -rotation;
            if (rotation != dVar.fN) {
                dVar.fN = rotation;
                dVar.invalidateSelf();
            }
        }
    }

    final void a(a aVar, boolean z) {
        if (!this.im && this.iE.getVisibility() == 0) {
            if (!z.ai(this.iE) || this.iE.isInEditMode()) {
                this.iE.b(8, false);
                if (aVar == null) {
                    return;
                }
                return;
            }
            this.iE.animate().cancel();
            this.iE.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.eC).setListener(new 1(this, false, aVar));
        }
    }

    final void b(a aVar, boolean z) {
        if (!this.im && this.iE.getVisibility() == 0) {
            return;
        }
        if (!z.ai(this.iE) || this.iE.isInEditMode()) {
            this.iE.b(0, false);
            this.iE.setAlpha(1.0f);
            this.iE.setScaleY(1.0f);
            this.iE.setScaleX(1.0f);
            return;
        }
        this.iE.animate().cancel();
        if (this.iE.getVisibility() != 0) {
            this.iE.setAlpha(0.0f);
            this.iE.setScaleY(0.0f);
            this.iE.setScaleX(0.0f);
        }
        this.iE.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.eD).setListener(new 2(this, false, aVar));
    }
}
