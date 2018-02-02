package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.b;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int eF = -1;
    private int eG = -1;
    private int eH = -1;
    boolean eI;
    float eJ;
    private int eK = 0;
    private ap eL;
    final List<a> eM;

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private int eO;
        private boolean eP;
        private boolean eQ;
        private u eR;
        private int eS = -1;
        private boolean eT;
        private float eU;
        private WeakReference<View> eV;
        private a eW;

        protected static class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new 1());
            int fa;
            float fb;
            boolean fc;

            public SavedState(Parcel parcel) {
                super(parcel);
                this.fa = parcel.readInt();
                this.fb = parcel.readFloat();
                this.fc = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.fa);
                parcel.writeFloat(this.fb);
                parcel.writeByte((byte) (this.fc ? 1 : 0));
            }
        }

        public final /* bridge */ /* synthetic */ int K() {
            return super.K();
        }

        final /* synthetic */ int a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            view = (AppBarLayout) view;
            int J = J();
            if (i2 == 0 || J < i2 || J > i3) {
                this.eO = 0;
                return 0;
            }
            int e = n.e(i, i2, i3);
            if (J == e) {
                return 0;
            }
            int abs;
            int i4;
            int height;
            if (view.eI) {
                abs = Math.abs(e);
                int childCount = view.getChildCount();
                i4 = 0;
                while (i4 < childCount) {
                    View childAt = view.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator interpolator = layoutParams.fe;
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else {
                        if (interpolator != null) {
                            i4 = layoutParams.fd;
                            if ((i4 & 1) != 0) {
                                height = (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) + 0;
                                if ((i4 & 2) != 0) {
                                    height -= z.T(childAt);
                                }
                            } else {
                                height = 0;
                            }
                            if (z.Z(childAt)) {
                                height -= view.I();
                            }
                            if (height > 0) {
                                i4 = abs - childAt.getTop();
                                height = Math.round(interpolator.getInterpolation(((float) i4) / ((float) height)) * ((float) height));
                                height = (height + childAt.getTop()) * Integer.signum(e);
                            }
                        }
                        height = e;
                    }
                }
                height = e;
            } else {
                height = e;
            }
            boolean p = super.p(height);
            i4 = J - e;
            this.eO = e - height;
            if (!p && view.eI) {
                abs = coordinatorLayout.hi.size();
                J = 0;
                e = 0;
                while (J < abs) {
                    View view2 = (View) coordinatorLayout.hi.get(J);
                    if (view2 == view) {
                        height = 1;
                    } else {
                        if (e != 0) {
                            d dVar = (d) view2.getLayoutParams();
                            android.support.design.widget.CoordinatorLayout.Behavior behavior = dVar.hC;
                            if (behavior != null && dVar.c(coordinatorLayout, view2, view)) {
                                behavior.b(coordinatorLayout, view2, view);
                            }
                        }
                        height = e;
                    }
                    J++;
                    e = height;
                }
            }
            j(view);
            return i4;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.eS = savedState.fa;
                this.eU = savedState.fb;
                this.eT = savedState.fc;
                return;
            }
            super.a(coordinatorLayout, appBarLayout, parcelable);
            this.eS = -1;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!this.eQ) {
                a(coordinatorLayout, appBarLayout);
            }
            this.eP = false;
            this.eQ = false;
            this.eV = new WeakReference(view2);
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i != 0 && !this.eP) {
                int i2;
                int b;
                if (i < 0) {
                    i2 = -appBarLayout.H();
                    b = i2 + AppBarLayout.b(appBarLayout);
                } else {
                    i2 = -appBarLayout.H();
                    b = 0;
                }
                iArr[1] = b(coordinatorLayout, appBarLayout, i, i2, b);
            }
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, float f, boolean z) {
            boolean z2 = true;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (z) {
                int b;
                if (f < 0.0f) {
                    b = (-appBarLayout.H()) + AppBarLayout.b(appBarLayout);
                    if (J() < b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                } else {
                    b = -appBarLayout.H();
                    if (J() > b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                }
                z2 = false;
            } else {
                z2 = a(coordinatorLayout, appBarLayout, -appBarLayout.H(), -f);
            }
            this.eQ = z2;
            return z2;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.eK;
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.H();
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, e);
                    } else {
                        c(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, 0);
                    } else {
                        c(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.eS >= 0) {
                View childAt = appBarLayout.getChildAt(this.eS);
                e = -childAt.getBottom();
                super.p(this.eT ? z.T(childAt) + e : Math.round(((float) childAt.getHeight()) * this.eU) + e);
            }
            appBarLayout.eK = 0;
            this.eS = -1;
            super.p(n.e(super.K(), -appBarLayout.H(), 0));
            j(appBarLayout);
            return a;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            View view2 = (AppBarLayout) view;
            if (((d) view2.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, view2, i, i2, i3, i4);
            }
            coordinatorLayout.a(view2, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && AppBarLayout.a(appBarLayout) && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
            if (z && this.eR != null) {
                this.eR.ls.cancel();
            }
            this.eV = null;
            return z;
        }

        final /* synthetic */ int b(View view) {
            return ((AppBarLayout) view).H();
        }

        public final /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = false;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int K = super.K();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + K;
                if (childAt.getTop() + K > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.fa = i;
                    if (bottom == z.T(childAt)) {
                        z = true;
                    }
                    savedState.fc = z;
                    savedState.fb = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        public final /* synthetic */ void b(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i < 0) {
                b(coordinatorLayout, appBarLayout, i, -AppBarLayout.d(appBarLayout), 0);
                this.eP = true;
                return;
            }
            this.eP = false;
        }

        final /* synthetic */ int c(View view) {
            return -AppBarLayout.d((AppBarLayout) view);
        }

        final /* synthetic */ boolean d(View view) {
            if (this.eW != null) {
                return this.eW.L();
            }
            if (this.eV != null) {
                View view2 = (View) this.eV.get();
                if (view2 == null || !view2.isShown() || z.h(view2, -1)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean p(int i) {
            return super.p(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int J = J();
            if (J != i) {
                if (this.eR == null) {
                    this.eR = aa.ay();
                    this.eR.setInterpolator(a.eE);
                    this.eR.a(new 1(this, coordinatorLayout, appBarLayout));
                } else {
                    this.eR.ls.cancel();
                }
                this.eR.setDuration(Math.round(((((float) Math.abs(J - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.eR.g(J, i);
                this.eR.ls.start();
            } else if (this.eR != null && this.eR.ls.isRunning()) {
                this.eR.ls.cancel();
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            View view;
            int J = J();
            int childCount = appBarLayout.getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                if (childAt.getTop() <= (-J) && childAt.getBottom() >= (-J)) {
                    view = childAt;
                    break;
                }
            }
            view = null;
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.fd & 17) == 17) {
                    int T;
                    childCount = -view.getTop();
                    i = -view.getBottom();
                    if ((layoutParams.fd & 2) == 2) {
                        T = z.T(view) + i;
                    } else {
                        T = i;
                    }
                    if (J >= (T + childCount) / 2) {
                        T = childCount;
                    }
                    a(coordinatorLayout, appBarLayout, n.e(T, -appBarLayout.H(), 0));
                }
            }
        }

        private void j(AppBarLayout appBarLayout) {
            List h = appBarLayout.eM;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) h.get(i);
                if (aVar != null) {
                    aVar.a(appBarLayout, super.K());
                }
            }
        }

        final int J() {
            return super.K() + this.eO;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ LinearLayout.LayoutParams m0generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams m2generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    static /* synthetic */ ap a(AppBarLayout appBarLayout, ap apVar) {
        ap apVar2 = null;
        if (z.Z(appBarLayout)) {
            apVar2 = apVar;
        }
        if (apVar2 != appBarLayout.eL) {
            appBarLayout.eL = apVar2;
            appBarLayout.G();
        }
        return apVar;
    }

    static /* synthetic */ boolean a(AppBarLayout appBarLayout) {
        return appBarLayout.H() != 0;
    }

    static /* synthetic */ int b(AppBarLayout appBarLayout) {
        if (appBarLayout.eG != -1) {
            return appBarLayout.eG;
        }
        int i;
        int childCount = appBarLayout.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = appBarLayout.getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.fd;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + z.T(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - z.T(childAt)) : i + measuredHeight;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        appBarLayout.eG = i;
        return i;
    }

    static /* synthetic */ int d(AppBarLayout appBarLayout) {
        if (appBarLayout.eH != -1) {
            return appBarLayout.eH;
        }
        int i;
        int childCount = appBarLayout.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = appBarLayout.getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.fd;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (z.T(childAt) + appBarLayout.I());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        appBarLayout.eH = i;
        return i;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        int i = 1;
        int i2 = 0;
        super(context, attributeSet);
        setOrientation(1);
        t.e(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bP, 0, h.bG);
        this.eJ = (float) obtainStyledAttributes.getDimensionPixelSize(i.bR, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.bQ));
        if (obtainStyledAttributes.hasValue(i.bS)) {
            boolean z = obtainStyledAttributes.getBoolean(i.bS, false);
            boolean ai = z.ai(this);
            if (!z) {
                i = 2;
            }
            if (ai) {
                i2 = 4;
            }
            this.eK = i2 | i;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        aa.u(this);
        this.eM = new ArrayList();
        z.g(this, this.eJ);
        z.b(this, new t(this) {
            final /* synthetic */ AppBarLayout eN;

            {
                this.eN = r1;
            }

            public final ap a(View view, ap apVar) {
                return AppBarLayout.a(this.eN, apVar);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        G();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        G();
        this.eI = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).fe != null) {
                this.eI = true;
                return;
            }
        }
    }

    private void G() {
        this.eF = -1;
        this.eG = -1;
        this.eH = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int H() {
        if (this.eF != -1) {
            return this.eF;
        }
        int T;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.fd;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                T = i - z.T(childAt);
                break;
            }
        }
        T = i;
        T = Math.max(0, T - I());
        this.eF = T;
        return T;
    }

    final int I() {
        return this.eL != null ? this.eL.getSystemWindowInsetTop() : 0;
    }
}
