package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class s<V extends View> extends Behavior<V> {
    private u fk;
    private boolean fl;
    private final android.support.v4.widget.u.a fx = new android.support.v4.widget.u.a(this) {
        private int fu = -1;
        private int jV;
        final /* synthetic */ s jW;

        {
            this.jW = r2;
        }

        public final boolean b(View view, int i) {
            return this.fu == -1 && this.jW.r(view);
        }

        public final void f(View view, int i) {
            this.fu = i;
            this.jV = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void t(int i) {
            if (this.jW.jO != null) {
                this.jW.jO.G(i);
            }
        }

        public final void a(View view, float f, float f2) {
            boolean z;
            int i;
            boolean z2 = true;
            this.fu = -1;
            int width = view.getWidth();
            if (f != 0.0f) {
                z = z.I(view) == 1;
                z = this.jW.jR == 2 ? true : this.jW.jR == 0 ? z ? f < 0.0f : f > 0.0f : this.jW.jR == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                z = Math.abs(view.getLeft() - this.jV) >= Math.round(((float) view.getWidth()) * this.jW.jS);
            }
            if (z) {
                i = view.getLeft() < this.jV ? this.jV - width : this.jV + width;
            } else {
                i = this.jV;
                z2 = false;
            }
            if (this.jW.fk.t(i, view.getTop())) {
                z.a(view, new b(this.jW, view, z2));
            } else if (z2 && this.jW.jO != null) {
                this.jW.jO.onDismiss(view);
            }
        }

        public final int s(View view) {
            return view.getWidth();
        }

        public final int d(View view, int i) {
            int width;
            int i2;
            Object obj = z.I(view) == 1 ? 1 : null;
            if (this.jW.jR == 0) {
                if (obj != null) {
                    width = this.jV - view.getWidth();
                    i2 = this.jV;
                } else {
                    width = this.jV;
                    i2 = this.jV + view.getWidth();
                }
            } else if (this.jW.jR != 1) {
                width = this.jV - view.getWidth();
                i2 = this.jV + view.getWidth();
            } else if (obj != null) {
                width = this.jV;
                i2 = this.jV + view.getWidth();
            } else {
                width = this.jV - view.getWidth();
                i2 = this.jV;
            }
            return Math.min(Math.max(width, i), i2);
        }

        public final int c(View view, int i) {
            return view.getTop();
        }

        public final void a(View view, int i, int i2) {
            float width = ((float) this.jV) + (((float) view.getWidth()) * this.jW.jT);
            float width2 = ((float) this.jV) + (((float) view.getWidth()) * this.jW.jU);
            if (((float) i) <= width) {
                z.d(view, 1.0f);
            } else if (((float) i) >= width2) {
                z.d(view, 0.0f);
            } else {
                z.d(view, s.c(0.0f, 1.0f - s.d(width, width2, (float) i), 1.0f));
            }
        }
    };
    a jO;
    private float jP = 0.0f;
    private boolean jQ;
    int jR = 2;
    private float jS = 0.5f;
    float jT = 0.0f;
    float jU = 0.5f;

    public interface a {
        void G(int i);

        void onDismiss(View view);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (o.d(motionEvent)) {
            case 1:
            case 3:
                if (this.fl) {
                    this.fl = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.fl = z;
                break;
        }
        if (this.fl) {
            return false;
        }
        if (this.fk == null) {
            u a;
            if (this.jQ) {
                a = u.a(coordinatorLayout, this.jP, this.fx);
            } else {
                a = u.a(coordinatorLayout, this.fx);
            }
            this.fk = a;
        }
        return this.fk.j(motionEvent);
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.fk == null) {
            return false;
        }
        this.fk.k(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }

    static float c(float f, float f2, float f3) {
        return Math.min(Math.max(0.0f, f2), 1.0f);
    }

    static float d(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
