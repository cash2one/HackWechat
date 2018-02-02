package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements p, r {
    private static final String Ef = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] yz = new int[]{16842766};
    private l EA;
    private Animation EB;
    private Animation EC;
    private Animation ED;
    private Animation EE;
    private float EF;
    private boolean EG;
    private int EH;
    private int EI;
    private boolean EJ;
    private AnimationListener EK = new 1(this);
    private final Animation EL = new 5(this);
    private final Animation EM = new 6(this);
    private a Eg;
    private boolean Eh = false;
    private float Ei = -1.0f;
    private float Ej;
    private final q Ek;
    private final int[] El = new int[2];
    private final int[] Em = new int[2];
    private boolean En;
    private int Eo;
    private int Ep;
    private boolean Eq = false;
    private float Er;
    private boolean Es;
    private boolean Et;
    private final DecelerateInterpolator Eu;
    private b Ev;
    private int Ew = -1;
    protected int Ex;
    private float Ey;
    protected int Ez;
    private int fu = -1;
    private final s hA;
    private boolean iL;
    private int iN;
    private View oM;
    private float xQ;

    private void reset() {
        this.Ev.clearAnimation();
        this.EA.stop();
        this.Ev.setVisibility(8);
        au(255);
        if (this.Es) {
            E(0.0f);
        } else {
            e(this.Ez - this.Ep, true);
        }
        this.Ep = this.Ev.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void au(int i) {
        this.Ev.getBackground().setAlpha(i);
        this.EA.setAlpha(i);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
        this.Eo = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.Eu = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, yz);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.EH = (int) (displayMetrics.density * 40.0f);
        this.EI = (int) (displayMetrics.density * 40.0f);
        this.Ev = new b(getContext());
        this.EA = new l(getContext(), this);
        this.EA.CF.Df = -328966;
        this.Ev.setImageDrawable(this.EA);
        this.Ev.setVisibility(8);
        addView(this.Ev);
        z.a(this);
        this.EF = displayMetrics.density * 64.0f;
        this.Ei = this.EF;
        this.hA = new s(this);
        this.Ek = new q(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.Ew < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.Ew;
        }
        if (i2 >= this.Ew) {
            return i2 + 1;
        }
        return i2;
    }

    private static boolean cI() {
        return VERSION.SDK_INT < 11;
    }

    private void E(float f) {
        if (cI()) {
            au((int) (255.0f * f));
            return;
        }
        z.e(this.Ev, f);
        z.f(this.Ev, f);
    }

    private void a(AnimationListener animationListener) {
        this.EB = new 2(this);
        this.EB.setDuration(150);
        this.Ev.Bk = animationListener;
        this.Ev.clearAnimation();
        this.Ev.startAnimation(this.EB);
    }

    private Animation s(int i, int i2) {
        if (this.Es && cI()) {
            return null;
        }
        Animation 3 = new 3(this, i, i2);
        3.setDuration(300);
        this.Ev.Bk = null;
        this.Ev.clearAnimation();
        this.Ev.startAnimation(3);
        return 3;
    }

    private void cJ() {
        if (this.oM == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.Ev)) {
                    i++;
                } else {
                    this.oM = childAt;
                    return;
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.oM == null) {
                cJ();
            }
            if (this.oM != null) {
                View view = this.oM;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.Ev.getMeasuredWidth();
                this.Ev.layout((measuredWidth / 2) - (measuredHeight / 2), this.Ep, (measuredWidth / 2) + (measuredHeight / 2), this.Ep + this.Ev.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.oM == null) {
            cJ();
        }
        if (this.oM != null) {
            int i3;
            this.oM.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.Ev.measure(MeasureSpec.makeMeasureSpec(this.EH, 1073741824), MeasureSpec.makeMeasureSpec(this.EI, 1073741824));
            if (!(this.EJ || this.Eq)) {
                this.Eq = true;
                i3 = -this.Ev.getMeasuredHeight();
                this.Ez = i3;
                this.Ep = i3;
            }
            this.Ew = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.Ev) {
                    this.Ew = i3;
                    return;
                }
            }
        }
    }

    private boolean cK() {
        if (VERSION.SDK_INT >= 14) {
            return z.h(this.oM, -1);
        }
        if (!(this.oM instanceof AbsListView)) {
            return z.h(this.oM, -1) || this.oM.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.oM;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cJ();
        int d = o.d(motionEvent);
        if (this.Et && d == 0) {
            this.Et = false;
        }
        if (!isEnabled() || this.Et || cK() || this.Eh || this.En) {
            return false;
        }
        float g;
        switch (d) {
            case 0:
                e(this.Ez - this.Ev.getTop(), true);
                this.fu = o.c(motionEvent, 0);
                this.iL = false;
                g = g(motionEvent, this.fu);
                if (g != -1.0f) {
                    this.Er = g;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.iL = false;
                this.fu = -1;
                break;
            case 2:
                if (this.fu == -1) {
                    return false;
                }
                g = g(motionEvent, this.fu);
                if (g != -1.0f) {
                    if (g - this.Er > ((float) this.iN) && !this.iL) {
                        this.xQ = this.Er + ((float) this.iN);
                        this.iL = true;
                        this.EA.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return this.iL;
    }

    private static float g(MotionEvent motionEvent, int i) {
        int b = o.b(motionEvent, i);
        if (b < 0) {
            return -1.0f;
        }
        return o.e(motionEvent, b);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.oM instanceof AbsListView)) {
            return;
        }
        if (this.oM == null || z.ag(this.oM)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.Et || this.Eh || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.hA.xA = i;
        startNestedScroll(i & 2);
        this.Ej = 0.0f;
        this.En = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.Ej > 0.0f) {
            if (((float) i2) > this.Ej) {
                iArr[1] = i2 - ((int) this.Ej);
                this.Ej = 0.0f;
            } else {
                this.Ej -= (float) i2;
                iArr[1] = i2;
            }
            F(this.Ej);
        }
        if (this.EJ && i2 > 0 && this.Ej == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.Ev.setVisibility(8);
        }
        int[] iArr2 = this.El;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.hA.xA;
    }

    public void onStopNestedScroll(View view) {
        this.hA.xA = 0;
        this.En = false;
        if (this.Ej > 0.0f) {
            G(this.Ej);
            this.Ej = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.Em);
        int i5 = this.Em[1] + i4;
        if (i5 < 0 && !cK()) {
            this.Ej = ((float) Math.abs(i5)) + this.Ej;
            F(this.Ej);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.Ek.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.Ek.xx;
    }

    public boolean startNestedScroll(int i) {
        return this.Ek.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.Ek.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.Ek.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Ek.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Ek.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Ek.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Ek.dispatchNestedPreFling(f, f2);
    }

    private static boolean d(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void F(float f) {
        this.EA.t(true);
        float min = Math.min(1.0f, Math.abs(f / this.Ei));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.Ei;
        float f2 = this.EJ ? this.EF - ((float) this.Ez) : this.EF;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.Ez;
        if (this.Ev.getVisibility() != 0) {
            this.Ev.setVisibility(0);
        }
        if (!this.Es) {
            z.e(this.Ev, 1.0f);
            z.f(this.Ev, 1.0f);
        }
        if (this.Es) {
            E(Math.min(1.0f, f / this.Ei));
        }
        if (f < this.Ei) {
            if (this.EA.getAlpha() > 76 && !d(this.EC)) {
                this.EC = s(this.EA.getAlpha(), 76);
            }
        } else if (this.EA.getAlpha() < 255 && !d(this.ED)) {
            this.ED = s(this.EA.getAlpha(), 255);
        }
        this.EA.z(Math.min(0.8f, max * 0.8f));
        this.EA.y(Math.min(1.0f, max));
        this.EA.CF.setRotation(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        e(i - this.Ep, true);
    }

    private void G(float f) {
        if (f <= this.Ei) {
            this.Eh = false;
            this.EA.z(0.0f);
            AnimationListener animationListener = null;
            if (!this.Es) {
                animationListener = new 4(this);
            }
            int i = this.Ep;
            if (this.Es) {
                this.Ex = i;
                if (cI()) {
                    this.Ey = (float) this.EA.getAlpha();
                } else {
                    this.Ey = z.V(this.Ev);
                }
                this.EE = new 7(this);
                this.EE.setDuration(150);
                if (animationListener != null) {
                    this.Ev.Bk = animationListener;
                }
                this.Ev.clearAnimation();
                this.Ev.startAnimation(this.EE);
            } else {
                this.Ex = i;
                this.EM.reset();
                this.EM.setDuration(200);
                this.EM.setInterpolator(this.Eu);
                if (animationListener != null) {
                    this.Ev.Bk = animationListener;
                }
                this.Ev.clearAnimation();
                this.Ev.startAnimation(this.EM);
            }
            this.EA.t(false);
        } else if (!this.Eh) {
            this.EG = true;
            cJ();
            this.Eh = true;
            if (this.Eh) {
                int i2 = this.Ep;
                AnimationListener animationListener2 = this.EK;
                this.Ex = i2;
                this.EL.reset();
                this.EL.setDuration(200);
                this.EL.setInterpolator(this.Eu);
                if (animationListener2 != null) {
                    this.Ev.Bk = animationListener2;
                }
                this.Ev.clearAnimation();
                this.Ev.startAnimation(this.EL);
                return;
            }
            a(this.EK);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (this.Et && d == 0) {
            this.Et = false;
        }
        if (!isEnabled() || this.Et || cK() || this.En) {
            return false;
        }
        float e;
        switch (d) {
            case 0:
                this.fu = o.c(motionEvent, 0);
                this.iL = false;
                break;
            case 1:
                d = o.b(motionEvent, this.fu);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.xQ) * 0.5f;
                this.iL = false;
                G(e);
                this.fu = -1;
                return false;
            case 2:
                d = o.b(motionEvent, this.fu);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.xQ) * 0.5f;
                if (this.iL) {
                    if (e > 0.0f) {
                        F(e);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                d = o.e(motionEvent);
                if (d >= 0) {
                    this.fu = o.c(motionEvent, d);
                    break;
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return true;
    }

    private void e(int i, boolean z) {
        this.Ev.bringToFront();
        this.Ev.offsetTopAndBottom(i);
        this.Ep = this.Ev.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.fu) {
            this.fu = o.c(motionEvent, e == 0 ? 1 : 0);
        }
    }
}
