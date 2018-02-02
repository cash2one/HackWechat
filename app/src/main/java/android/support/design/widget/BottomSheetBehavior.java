package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a$i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.support.v4.widget.u.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private float ff;
    private int fg;
    public int fh;
    private int fi;
    public boolean fj;
    public u fk;
    private boolean fl;
    private int fn;
    private boolean fo;
    private int fp;
    public WeakReference<V> fq;
    private WeakReference<View> fr;
    public a fs;
    private VelocityTracker ft;
    private int fu;
    private int fv;
    private boolean fw;
    private final a fx = new 1(this);
    public int mState = 4;

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new 1();
        final int state;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$i.bW);
        q(obtainStyledAttributes.getDimensionPixelSize(a$i.bX, 0));
        this.fj = obtainStyledAttributes.getBoolean(a$i.bY, false);
        obtainStyledAttributes.recycle();
        this.ff = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.mState);
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (!(this.mState == 1 || this.mState == 2)) {
            if (z.Z(coordinatorLayout) && !z.Z(v)) {
                z.a(v, true);
            }
            coordinatorLayout.e(v, i);
        }
        this.fp = coordinatorLayout.getHeight();
        this.fh = Math.max(0, this.fp - v.getHeight());
        this.fi = Math.max(this.fp - this.fg, this.fh);
        if (this.mState == 3) {
            z.j(v, this.fh);
        } else if (this.fj && this.mState == 5) {
            z.j(v, this.fp);
        } else if (this.mState == 4) {
            z.j(v, this.fi);
        }
        if (this.fk == null) {
            this.fk = u.a(coordinatorLayout, this.fx);
        }
        this.fq = new WeakReference(v);
        this.fr = new WeakReference(h((View) v));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = o.d(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        switch (d) {
            case 0:
                int x = (int) motionEvent.getX();
                this.fv = (int) motionEvent.getY();
                View view = (View) this.fr.get();
                if (view != null && coordinatorLayout.b(view, x, this.fv)) {
                    this.fu = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.fw = true;
                }
                boolean z = this.fu == -1 && !coordinatorLayout.b(v, x, this.fv);
                this.fl = z;
                break;
            case 1:
            case 3:
                this.fw = false;
                this.fu = -1;
                if (this.fl) {
                    this.fl = false;
                    return false;
                }
                break;
        }
        if (!this.fl && this.fk.j(motionEvent)) {
            return true;
        }
        view = (View) this.fr.get();
        if (d != 2 || view == null || this.fl || this.mState == 1 || coordinatorLayout.b(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.fv) - motionEvent.getY()) <= ((float) this.fk.iN)) {
            return false;
        }
        return true;
    }

    public final boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int d = o.d(motionEvent);
        if (this.mState == 1 && d == 0) {
            return true;
        }
        this.fk.k(motionEvent);
        if (d == 0) {
            reset();
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        if (d != 2 || this.fl || Math.abs(((float) this.fv) - motionEvent.getY()) <= ((float) this.fk.iN)) {
            return true;
        }
        this.fk.n(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        this.fn = 0;
        this.fo = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr) {
        if (view == ((View) this.fr.get())) {
            int top = v.getTop();
            int i2 = top - i;
            if (i > 0) {
                if (i2 < this.fh) {
                    iArr[1] = top - this.fh;
                    z.j(v, -iArr[1]);
                    r(3);
                } else {
                    iArr[1] = i;
                    z.j(v, -i);
                    r(1);
                }
            } else if (i < 0 && !z.h(view, -1)) {
                if (i2 <= this.fi || this.fj) {
                    iArr[1] = i;
                    z.j(v, -i);
                    r(1);
                } else {
                    iArr[1] = top - this.fi;
                    z.j(v, -iArr[1]);
                    r(4);
                }
            }
            s(v.getTop());
            this.fn = i;
            this.fo = true;
        }
    }

    public final void a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.fh) {
            r(3);
        } else if (view == this.fr.get() && this.fo) {
            int i2;
            if (this.fn > 0) {
                i2 = this.fh;
            } else {
                if (this.fj) {
                    this.ft.computeCurrentVelocity(1000, this.ff);
                    if (a((View) v, y.b(this.ft, this.fu))) {
                        i2 = this.fp;
                        i = 5;
                    }
                }
                if (this.fn == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.fh) < Math.abs(top - this.fi)) {
                        i2 = this.fh;
                    } else {
                        i2 = this.fi;
                        i = 4;
                    }
                } else {
                    i2 = this.fi;
                    i = 4;
                }
            }
            if (this.fk.e(v, v.getLeft(), i2)) {
                r(2);
                z.a(v, new b(this, v, i));
            } else {
                r(i);
            }
            this.fo = false;
        }
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.fr.get() && (this.mState != 3 || super.a(coordinatorLayout, v, view, f, f2));
    }

    public final void q(int i) {
        this.fg = Math.max(0, i);
        this.fi = this.fp - i;
    }

    public final void r(int i) {
        if (this.mState != i) {
            this.mState = i;
            if (((View) this.fq.get()) != null && this.fs != null) {
                this.fs.u(i);
            }
        }
    }

    private void reset() {
        this.fu = -1;
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    private boolean a(View view, float f) {
        if (view.getTop() >= this.fi && Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.fi)) / ((float) this.fg) > 0.5f) {
            return true;
        }
        return false;
    }

    private View h(View view) {
        if (view instanceof p) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View h = h(viewGroup.getChildAt(i));
                if (h != null) {
                    return h;
                }
            }
        }
        return null;
    }

    private void s(int i) {
        if (((View) this.fq.get()) != null && this.fs != null) {
            if (i > this.fi) {
                this.fs.e(((float) (this.fi - i)) / ((float) this.fg));
            } else {
                this.fs.e(((float) (this.fi - i)) / ((float) (this.fi - this.fh)));
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> i(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof d) {
            Behavior behavior = ((d) layoutParams).hC;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
