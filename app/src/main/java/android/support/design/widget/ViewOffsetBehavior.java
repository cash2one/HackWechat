package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private z lK;
    private int lL = 0;
    private int lM = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        d(coordinatorLayout, v, i);
        if (this.lK == null) {
            this.lK = new z(v);
        }
        this.lK.aB();
        if (this.lL != 0) {
            this.lK.p(this.lL);
            this.lL = 0;
        }
        if (this.lM != 0) {
            z zVar = this.lK;
            int i2 = this.lM;
            if (zVar.lQ != i2) {
                zVar.lQ = i2;
                zVar.aC();
            }
            this.lM = 0;
        }
        return true;
    }

    protected void d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.e(v, i);
    }

    public boolean p(int i) {
        if (this.lK != null) {
            return this.lK.p(i);
        }
        this.lL = i;
        return false;
    }

    public int K() {
        return this.lK != null ? this.lK.lP : 0;
    }
}
