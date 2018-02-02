package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.f;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

public class NestedScrollView extends FrameLayout implements p, r, w {
    private static final a Ds = new a();
    private static final int[] Dt = new int[]{16843130};
    private long Dg;
    private i Dh;
    private i Di;
    private boolean Dj;
    private boolean Dk;
    private View Dl;
    private boolean Dm;
    private boolean Dn;
    private final int[] Do;
    private final int[] Dp;
    private int Dq;
    private SavedState Dr;
    private final s Du;
    private final q Dv;
    private float Dw;
    public b Dx;
    private final Rect ey;
    private VelocityTracker ft;
    private int fu;
    private q iK;
    private boolean iL;
    private int iM;
    private int iN;
    private int zc;
    private int zd;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int Dy;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Dy = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Dy);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.Dy + "}";
        }
    }

    public interface b {
        void b(NestedScrollView nestedScrollView);
    }

    static class a extends android.support.v4.view.a {
        a() {
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.cC());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.as(min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.as(min);
                    return true;
                default:
                    return false;
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.cC();
                if (a > 0) {
                    bVar.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        bVar.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        bVar.addAction(Downloads.RECV_BUFFER_SIZE);
                    }
                }
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setScrollable(nestedScrollView.cC() > 0);
            f.AC.f(a.AD, nestedScrollView.getScrollX());
            f.AC.g(a.AD, nestedScrollView.getScrollY());
            f.AC.i(a.AD, nestedScrollView.getScrollX());
            f.AC.j(a.AD, nestedScrollView.cC());
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ey = new Rect();
        this.Dj = true;
        this.Dk = false;
        this.Dl = null;
        this.iL = false;
        this.Dn = true;
        this.fu = -1;
        this.Do = new int[2];
        this.Dp = new int[2];
        this.iK = q.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.iN = viewConfiguration.getScaledTouchSlop();
        this.zc = viewConfiguration.getScaledMinimumFlingVelocity();
        this.zd = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Dt, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        if (z != this.Dm) {
            this.Dm = z;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        this.Du = new s(this);
        this.Dv = new q(this);
        setNestedScrollingEnabled(true);
        z.a((View) this, Ds);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.Dv.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.Dv.xx;
    }

    public boolean startNestedScroll(int i) {
        return this.Dv.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.Dv.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.Dv.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.Dv.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.Dv.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.Dv.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.Dv.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Du.xA = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.Du.xA = 0;
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        at((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.Du.xA;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.Dx != null) {
            this.Dx.b(this);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Dm && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean z;
        this.ey.setEmpty();
        View childAt = getChildAt(0);
        if (childAt != null) {
            z = getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        } else {
            z = false;
        }
        View childAt2;
        if (z) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(33);
                    }
                    return arrowScroll(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return fullScroll(130);
                    }
                    return arrowScroll(130);
                case 62:
                    int i = keyEvent.isShiftPressed() ? 33 : 130;
                    boolean z2 = i == 130;
                    int height = getHeight();
                    if (z2) {
                        this.ey.top = getScrollY() + height;
                        int childCount = getChildCount();
                        if (childCount > 0) {
                            childAt2 = getChildAt(childCount - 1);
                            if (this.ey.top + height > childAt2.getBottom()) {
                                this.ey.top = childAt2.getBottom() - height;
                            }
                        }
                    } else {
                        this.ey.top = getScrollY() - height;
                        if (this.ey.top < 0) {
                            this.ey.top = 0;
                        }
                    }
                    this.ey.bottom = height + this.ey.top;
                    h(i, this.ey.top, this.ey.bottom);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            childAt2 = findFocus();
            if (childAt2 == this) {
                childAt2 = null;
            }
            childAt2 = FocusFinder.getInstance().findNextFocus(this, childAt2, 130);
            if (childAt2 == null || childAt2 == this || !childAt2.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private void cA() {
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
    }

    private void cB() {
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            cB();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.iL) {
            return true;
        }
        int y;
        switch (action & 255) {
            case 0:
                boolean z2;
                y = (int) motionEvent.getY();
                action = (int) motionEvent.getX();
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    z2 = y >= childAt.getTop() - scrollY && y < childAt.getBottom() - scrollY && action >= childAt.getLeft() && action < childAt.getRight();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    this.iL = false;
                    cB();
                    break;
                }
                this.iM = y;
                this.fu = o.c(motionEvent, 0);
                if (this.ft == null) {
                    this.ft = VelocityTracker.obtain();
                } else {
                    this.ft.clear();
                }
                this.ft.addMovement(motionEvent);
                this.iK.computeScrollOffset();
                if (this.iK.isFinished()) {
                    z = false;
                }
                this.iL = z;
                startNestedScroll(2);
                break;
                break;
            case 1:
            case 3:
                this.iL = false;
                this.fu = -1;
                cB();
                if (this.iK.i(getScrollX(), getScrollY(), cC())) {
                    z.E(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.fu;
                if (action != -1) {
                    y = o.b(motionEvent, action);
                    if (y != -1) {
                        action = (int) o.e(motionEvent, y);
                        if (Math.abs(action - this.iM) > this.iN && (getNestedScrollAxes() & 2) == 0) {
                            this.iL = true;
                            this.iM = action;
                            cA();
                            this.ft.addMovement(motionEvent);
                            this.Dq = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Invalid pointerId=").append(action).append(" in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        return this.iL;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        cA();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Dq = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.Dq);
        switch (d) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.iK.isFinished();
                    this.iL = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.iK.isFinished()) {
                        this.iK.abortAnimation();
                    }
                    this.iM = (int) motionEvent.getY();
                    this.fu = o.c(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.iL) {
                    VelocityTracker velocityTracker = this.ft;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.zd);
                    d = (int) y.b(velocityTracker, this.fu);
                    if (Math.abs(d) > this.zc) {
                        at(-d);
                    } else if (this.iK.i(getScrollX(), getScrollY(), cC())) {
                        z.E(this);
                    }
                }
                this.fu = -1;
                cD();
                break;
            case 2:
                int b = o.b(motionEvent, this.fu);
                if (b != -1) {
                    int i;
                    int e = (int) o.e(motionEvent, b);
                    d = this.iM - e;
                    if (dispatchNestedPreScroll(0, d, this.Dp, this.Do)) {
                        d -= this.Dp[1];
                        obtain.offsetLocation(0.0f, (float) this.Do[1]);
                        this.Dq += this.Do[1];
                    }
                    if (this.iL || Math.abs(d) <= this.iN) {
                        i = d;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.iL = true;
                        if (d > 0) {
                            i = d - this.iN;
                        } else {
                            i = d + this.iN;
                        }
                    }
                    if (this.iL) {
                        Object obj;
                        this.iM = e - this.Do[1];
                        int scrollY = getScrollY();
                        int cC = cC();
                        d = z.B(this);
                        if (d == 0 || (d == 1 && cC > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (d(0, i, 0, getScrollY(), cC) && !hasNestedScrollingParent()) {
                            this.ft.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.Do)) {
                            if (obj != null) {
                                cE();
                                d = scrollY + i;
                                if (d < 0) {
                                    this.Dh.h(((float) i) / ((float) getHeight()), o.d(motionEvent, b) / ((float) getWidth()));
                                    if (!this.Di.isFinished()) {
                                        this.Di.cv();
                                    }
                                } else if (d > cC) {
                                    this.Di.h(((float) i) / ((float) getHeight()), 1.0f - (o.d(motionEvent, b) / ((float) getWidth())));
                                    if (!this.Dh.isFinished()) {
                                        this.Dh.cv();
                                    }
                                }
                                if (!(this.Dh == null || (this.Dh.isFinished() && this.Di.isFinished()))) {
                                    z.E(this);
                                    break;
                                }
                            }
                        }
                        this.iM -= this.Do[1];
                        obtain.offsetLocation(0.0f, (float) this.Do[1]);
                        this.Dq += this.Do[1];
                        break;
                    }
                }
                new StringBuilder("Invalid pointerId=").append(this.fu).append(" in onTouchEvent");
                break;
                break;
            case 3:
                if (this.iL && getChildCount() > 0 && this.iK.i(getScrollX(), getScrollY(), cC())) {
                    z.E(this);
                }
                this.fu = -1;
                cD();
                break;
            case 5:
                d = o.e(motionEvent);
                this.iM = (int) o.e(motionEvent, d);
                this.fu = o.c(motionEvent, d);
                break;
            case 6:
                h(motionEvent);
                this.iM = (int) o.e(motionEvent, o.b(motionEvent, this.fu));
                break;
        }
        if (this.ft != null) {
            this.ft.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (o.c(motionEvent, action) == this.fu) {
            action = action == 0 ? 1 : 0;
            this.iM = (int) o.e(motionEvent, action);
            this.fu = o.c(motionEvent, action);
            if (this.ft != null) {
                this.ft.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((o.g(motionEvent) & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (!this.iL) {
                        float f = o.f(motionEvent, 9);
                        if (f != 0.0f) {
                            if (this.Dw == 0.0f) {
                                TypedValue typedValue = new TypedValue();
                                Context context = getContext();
                                if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                                    this.Dw = typedValue.getDimension(context.getResources().getDisplayMetrics());
                                } else {
                                    throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                                }
                            }
                            int i = (int) (f * this.Dw);
                            int cC = cC();
                            int scrollY = getScrollY();
                            i = scrollY - i;
                            if (i < 0) {
                                cC = 0;
                            } else if (i <= cC) {
                                cC = i;
                            }
                            if (cC != scrollY) {
                                super.scrollTo(getScrollX(), cC);
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean d(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        boolean z2;
        z.B(this);
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i7 = i3 + i;
        int i8 = i4 + i2;
        int i9 = i5 + 0;
        if (i7 > 0) {
            z = true;
            i6 = 0;
        } else if (i7 < 0) {
            z = true;
            i6 = 0;
        } else {
            i6 = i7;
            z = false;
        }
        if (i8 > i9) {
            i8 = i9;
            z2 = true;
        } else if (i8 < 0) {
            z2 = true;
            i8 = 0;
        } else {
            z2 = false;
        }
        if (z2) {
            this.iK.i(i6, i8, cC());
        }
        onOverScrolled(i6, i8, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    private int cC() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.ey.top = 0;
        this.ey.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.ey.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.ey.top = this.ey.bottom - height;
            }
        }
        return h(i, this.ey.top, this.ey.bottom);
    }

    private boolean h(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        Object obj = i == 33 ? 1 : null;
        List focusables = getFocusables(2);
        View view = null;
        Object obj2 = null;
        int size = focusables.size();
        int i5 = 0;
        while (i5 < size) {
            View view2;
            Object obj3;
            View view3 = (View) focusables.get(i5);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i2 < bottom && top < i3) {
                Object obj4 = (i2 >= top || bottom >= i3) ? null : 1;
                if (view == null) {
                    Object obj5 = obj4;
                    view2 = view3;
                    obj3 = obj5;
                } else {
                    Object obj6 = ((obj == null || top >= view.getTop()) && (obj != null || bottom <= view.getBottom())) ? null : 1;
                    if (obj2 != null) {
                        if (!(obj4 == null || obj6 == null)) {
                            view2 = view3;
                            obj3 = obj2;
                        }
                    } else if (obj4 != null) {
                        view2 = view3;
                        height = 1;
                    } else if (obj6 != null) {
                        view2 = view3;
                        obj3 = obj2;
                    }
                }
                i5++;
                view = view2;
                obj2 = obj3;
            }
            obj3 = obj2;
            view2 = view;
            i5++;
            view = view2;
            obj2 = obj3;
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            ar(obj != null ? i2 - scrollY : i3 - i4);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    private boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int height = (int) (0.5f * ((float) getHeight()));
        if (findNextFocus == null || !d(findNextFocus, height, getHeight())) {
            if (i == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < height) {
                    height = bottom - scrollY;
                }
            }
            if (height == 0) {
                return false;
            }
            if (i != 130) {
                height = -height;
            }
            ar(height);
        } else {
            findNextFocus.getDrawingRect(this.ey);
            offsetDescendantRectToMyCoords(findNextFocus, this.ey);
            ar(computeScrollDeltaToGetChildRectOnScreen(this.ey));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && aB(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean aB(View view) {
        return !d(view, 0, getHeight());
    }

    private boolean d(View view, int i, int i2) {
        view.getDrawingRect(this.ey);
        offsetDescendantRectToMyCoords(view, this.ey);
        return this.ey.bottom + i >= getScrollY() && this.ey.top - i <= getScrollY() + i2;
    }

    private void ar(int i) {
        if (i == 0) {
            return;
        }
        if (this.Dn) {
            smoothScrollBy(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.Dg > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                int max2 = Math.max(0, Math.min(scrollY + i2, max)) - scrollY;
                q qVar = this.iK;
                qVar.DH.a(qVar.DG, getScrollX(), scrollY, 0, max2);
                z.E(this);
            } else {
                if (!this.iK.isFinished()) {
                    this.iK.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.Dg = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void as(int i) {
        smoothScrollBy(0 - getScrollX(), i - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.iK.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.iK.getCurrX();
            int currY = this.iK.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int cC = cC();
                int B = z.B(this);
                Object obj = (B == 0 || (B == 1 && cC > 0)) ? 1 : null;
                d(currX - scrollX, currY - scrollY, scrollX, scrollY, cC);
                if (obj != null) {
                    cE();
                    if (currY <= 0 && scrollY > 0) {
                        this.Dh.ap((int) this.iK.getCurrVelocity());
                    } else if (currY >= cC && scrollY < cC) {
                        this.Di.ap((int) this.iK.getCurrVelocity());
                    }
                }
            }
        }
    }

    private void aC(View view) {
        view.getDrawingRect(this.ey);
        offsetDescendantRectToMyCoords(view, this.ey);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.ey);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.Dj) {
            this.Dl = view2;
        } else {
            aC(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || aB(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z2;
    }

    public void requestLayout() {
        this.Dj = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Dj = false;
        if (this.Dl != null && a(this.Dl, this)) {
            aC(this.Dl);
        }
        this.Dl = null;
        if (!this.Dk) {
            if (this.Dr != null) {
                scrollTo(getScrollX(), this.Dr.Dy);
                this.Dr = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.Dk = true;
    }

    public void onAttachedToWindow() {
        this.Dk = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && d(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.ey);
            offsetDescendantRectToMyCoords(findFocus, this.ey);
            ar(computeScrollDeltaToGetChildRectOnScreen(this.ey));
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            q qVar = this.iK;
            qVar.DH.a(qVar.DG, getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            z.E(this);
        }
    }

    private void at(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < cC() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                fling(i);
            }
        }
    }

    private void cD() {
        this.iL = false;
        cB();
        stopNestedScroll();
        if (this.Dh != null) {
            this.Dh.cv();
            this.Di.cv();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    private void cE() {
        if (z.B(this) == 2) {
            this.Dh = null;
            this.Di = null;
        } else if (this.Dh == null) {
            Context context = getContext();
            this.Dh = new i(context);
            this.Di = new i(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Dh != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.Dh.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.Dh.setSize(width, getHeight());
                if (this.Dh.draw(canvas)) {
                    z.E(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.Di.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(cC(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.Di.setSize(width, height);
                if (this.Di.draw(canvas)) {
                    z.E(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int clamp(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.Dr = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.Dy = getScrollY();
        return savedState;
    }
}
