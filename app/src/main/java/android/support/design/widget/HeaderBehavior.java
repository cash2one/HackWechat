package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private VelocityTracker ft;
    private int fu = -1;
    private Runnable iJ;
    private q iK;
    private boolean iL;
    private int iM;
    private int iN = -1;

    private class a implements Runnable {
        private final CoordinatorLayout iO;
        private final V iP;
        final /* synthetic */ HeaderBehavior iQ;

        a(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            this.iQ = headerBehavior;
            this.iO = coordinatorLayout;
            this.iP = v;
        }

        public final void run() {
            if (this.iP != null && this.iQ.iK != null) {
                if (this.iQ.iK.computeScrollOffset()) {
                    this.iQ.c(this.iO, this.iP, this.iQ.iK.getCurrY());
                    z.a(this.iP, (Runnable) this);
                    return;
                }
                this.iQ.a(this.iO, this.iP);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iN < 0) {
            this.iN = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.iL) {
            return true;
        }
        int y;
        switch (o.d(motionEvent)) {
            case 0:
                this.iL = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (d(v) && coordinatorLayout.b(v, x, y)) {
                    this.iM = y;
                    this.fu = o.c(motionEvent, 0);
                    ag();
                    break;
                }
            case 1:
            case 3:
                this.iL = false;
                this.fu = -1;
                if (this.ft != null) {
                    this.ft.recycle();
                    this.ft = null;
                    break;
                }
                break;
            case 2:
                y = this.fu;
                if (y != -1) {
                    y = o.b(motionEvent, y);
                    if (y != -1) {
                        y = (int) o.e(motionEvent, y);
                        if (Math.abs(y - this.iM) > this.iN) {
                            this.iL = true;
                            this.iM = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.ft != null) {
            this.ft.addMovement(motionEvent);
        }
        return this.iL;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.iN < 0) {
            this.iN = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (o.d(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.b(v, (int) motionEvent.getX(), y) && d(v)) {
                    this.iM = y;
                    this.fu = o.c(motionEvent, 0);
                    ag();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.ft != null) {
                    this.ft.addMovement(motionEvent);
                    this.ft.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -b(v), y.b(this.ft, this.fu));
                    break;
                }
                break;
            case 2:
                int b = o.b(motionEvent, this.fu);
                if (b != -1) {
                    b = (int) o.e(motionEvent, b);
                    int i = this.iM - b;
                    if (!this.iL && Math.abs(i) > this.iN) {
                        this.iL = true;
                        i = i > 0 ? i - this.iN : i + this.iN;
                    }
                    if (this.iL) {
                        this.iM = b;
                        b(coordinatorLayout, v, i, c(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.iL = false;
        this.fu = -1;
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
        if (this.ft != null) {
            this.ft.addMovement(motionEvent);
        }
        return true;
    }

    final int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int K = K();
        if (i2 == 0 || K < i2 || K > i3) {
            return 0;
        }
        int e = n.e(i, i2, i3);
        if (K == e) {
            return 0;
        }
        p(e);
        return K - e;
    }

    int J() {
        return K();
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, J() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, float f) {
        if (this.iJ != null) {
            v.removeCallbacks(this.iJ);
            this.iJ = null;
        }
        if (this.iK == null) {
            this.iK = q.a(v.getContext(), null);
        }
        this.iK.b(K(), 0, Math.round(f), 0, 0, i, 0);
        if (this.iK.computeScrollOffset()) {
            this.iJ = new a(this, coordinatorLayout, v);
            z.a((View) v, this.iJ);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean d(V v) {
        return false;
    }

    int c(V v) {
        return -v.getHeight();
    }

    int b(V v) {
        return v.getHeight();
    }

    private void ag() {
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
    }
}
