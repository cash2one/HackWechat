package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements android.support.v7.view.menu.f.b, m {
    private Context Mn;
    private int NA;
    private int NP;
    ActionMenuPresenter NQ;
    private android.support.v7.view.menu.l.a NR;
    private android.support.v7.view.menu.f.a NS;
    private boolean NT;
    private int NU;
    private int NV;
    d NW;
    boolean Nr;
    f eg;

    public interface a {
        boolean dn();

        boolean do();
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean NY;
        @ExportedProperty
        public int NZ;
        @ExportedProperty
        public int Oa;
        @ExportedProperty
        public boolean Ob;
        @ExportedProperty
        public boolean Oc;
        boolean Od;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.NY = layoutParams.NY;
        }

        public LayoutParams() {
            super(-2, -2);
            this.NY = false;
        }
    }

    private class b implements android.support.v7.view.menu.l.a {
        final /* synthetic */ ActionMenuView NX;

        private b(ActionMenuView actionMenuView) {
            this.NX = actionMenuView;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean d(f fVar) {
            return false;
        }
    }

    private class c implements android.support.v7.view.menu.f.a {
        final /* synthetic */ ActionMenuView NX;

        private c(ActionMenuView actionMenuView) {
            this.NX = actionMenuView;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return this.NX.NW != null && this.NX.NW.onMenuItemClick(menuItem);
        }

        public final void b(f fVar) {
            if (this.NX.NS != null) {
                this.NX.NS.b(fVar);
            }
        }
    }

    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams c(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams d(android.view.ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    protected final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams ee() {
        return ec();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return ec();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.RQ = false;
        float f = context.getResources().getDisplayMetrics().density;
        this.NA = (int) (56.0f * f);
        this.NV = (int) (f * 4.0f);
        this.Mn = context;
        this.NP = 0;
    }

    public final void setPopupTheme(int i) {
        if (this.NP != i) {
            this.NP = i;
            if (i == 0) {
                this.Mn = getContext();
            } else {
                this.Mn = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public final void a(ActionMenuPresenter actionMenuPresenter) {
        this.NQ = actionMenuPresenter;
        this.NQ.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.NQ != null) {
            this.NQ.f(false);
            if (this.NQ.isOverflowMenuShowing()) {
                this.NQ.hideOverflowMenu();
                this.NQ.showOverflowMenu();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.NT;
        this.NT = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.NT) {
            this.NU = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.NT || this.eg == null || size == this.NU)) {
            this.NU = size;
            this.eg.h(true);
        }
        int childCount = getChildCount();
        int i3;
        if (!this.NT || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.NA;
        size = i4 % this.NA;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        Object obj;
        int i6 = this.NA + (size / i5);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        i3 = 0;
        Object obj2 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i10 = 0;
        while (i10 < childCount2) {
            int i11;
            int i12;
            int i13;
            long j2;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i11 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.NV, 0, this.NV, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.Od = false;
                layoutParams.Oa = 0;
                layoutParams.NZ = 0;
                layoutParams.Ob = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).hasText();
                layoutParams.Oc = z;
                int d = d(childAt, i6, layoutParams.NY ? 1 : i5, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, d);
                if (layoutParams.Ob) {
                    i3 = i9 + 1;
                } else {
                    i3 = i9;
                }
                if (layoutParams.NY) {
                    obj = 1;
                } else {
                    obj = obj2;
                }
                int i14 = i5 - d;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (d == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = i3;
                    obj2 = obj;
                    j2 = j3;
                    i5 = i8;
                    childCount = i11;
                } else {
                    childCount = i11;
                    i5 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = i3;
                    j2 = j4;
                }
            } else {
                childCount = i3;
                j2 = j;
                i12 = i7;
                i13 = i5;
                i5 = i8;
            }
            i10++;
            i8 = i5;
            i7 = i12;
            i5 = i13;
            j = j2;
            i3 = childCount;
        }
        Object obj3 = (obj2 == null || i3 != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i5;
        while (i9 > 0 && paddingTop > 0) {
            i11 = Integer.MAX_VALUE;
            j = 0;
            i5 = 0;
            int i15 = 0;
            while (i15 < childCount2) {
                layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (layoutParams.Ob) {
                    if (layoutParams.NZ < i11) {
                        i5 = layoutParams.NZ;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (layoutParams.NZ == i11) {
                        j |= (long) (1 << i15);
                        size = i5 + 1;
                        i5 = i11;
                    }
                    i15++;
                    i11 = i5;
                    i5 = size;
                }
                size = i5;
                i5 = i11;
                i15++;
                i11 = i5;
                i5 = size;
            }
            j5 |= j;
            if (i5 > paddingTop) {
                break;
            }
            i15 = i11 + 1;
            i11 = 0;
            i5 = paddingTop;
            long j6 = j5;
            while (i11 < childCount2) {
                View childAt2 = getChildAt(i11);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i11)) & j) != 0) {
                    if (obj3 != null && layoutParams.Oc && i5 == 1) {
                        childAt2.setPadding(this.NV + i6, 0, this.NV, 0);
                    }
                    layoutParams.NZ++;
                    layoutParams.Od = true;
                    size = i5 - 1;
                } else if (layoutParams.NZ == i15) {
                    j6 |= (long) (1 << i11);
                    size = i5;
                } else {
                    size = i5;
                }
                i11++;
                i5 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i5;
        }
        j = j5;
        obj = (obj2 == null && i3 == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= i3 - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).Oc)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount2 - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount2 - 1).getLayoutParams()).Oc)) {
                    f = bitCount - 0.5f;
                    i3 = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i5 = 0;
                    obj3 = obj4;
                    while (i5 < childCount2) {
                        if ((((long) (1 << i5)) & j) != 0) {
                            childAt3 = getChildAt(i5);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.Oa = i3;
                                layoutParams.Od = true;
                                if (i5 == 0 && !layoutParams.Oc) {
                                    layoutParams.leftMargin = (-i3) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.NY) {
                                if (i5 != 0) {
                                    layoutParams.leftMargin = i3 / 2;
                                }
                                if (i5 != childCount2 - 1) {
                                    layoutParams.rightMargin = i3 / 2;
                                }
                            } else {
                                layoutParams.Oa = i3;
                                layoutParams.Od = true;
                                layoutParams.rightMargin = (-i3) / 2;
                                obj = 1;
                            }
                            i5++;
                            obj3 = obj;
                        }
                        obj = obj3;
                        i5++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i5 = 0;
            obj3 = obj4;
            while (i5 < childCount2) {
                if ((((long) (1 << i5)) & j) != 0) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams.Oa = i3;
                        layoutParams.Od = true;
                        layoutParams.leftMargin = (-i3) / 2;
                        obj = 1;
                    } else if (layoutParams.NY) {
                        if (i5 != 0) {
                            layoutParams.leftMargin = i3 / 2;
                        }
                        if (i5 != childCount2 - 1) {
                            layoutParams.rightMargin = i3 / 2;
                        }
                    } else {
                        layoutParams.Oa = i3;
                        layoutParams.Od = true;
                        layoutParams.rightMargin = (-i3) / 2;
                        obj = 1;
                    }
                    i5++;
                    obj3 = obj;
                }
                obj = obj3;
                i5++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (i3 = 0; i3 < childCount2; i3++) {
                childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Od) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.Oa + (layoutParams.NZ * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i4, i7);
    }

    static int d(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.NY && z) {
            z2 = true;
        }
        layoutParams.Ob = z2;
        layoutParams.NZ = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.NT) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int i7 = this.Sa;
            int i8 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean bv = at.bv(this);
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.NY) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (aI(i9)) {
                            measuredWidth += i7;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (bv) {
                            paddingLeft = layoutParams.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i10 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i10, i5, measuredHeight + i10);
                        paddingLeft = paddingRight - measuredWidth;
                        obj = 1;
                        measuredWidth = i8;
                    } else {
                        paddingLeft = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        aI(i9);
                        measuredWidth = i8 + 1;
                    }
                } else {
                    paddingLeft = paddingRight;
                    measuredWidth = i8;
                }
                i9++;
                i8 = measuredWidth;
                paddingRight = paddingLeft;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i8 = i6 - (i5 / 2);
                childAt2.layout(paddingRight, i8, measuredWidth + paddingRight, i5 + i8);
                return;
            }
            paddingLeft = i8 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            int i11;
            if (bv) {
                measuredWidth = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.NY) {
                        paddingLeft = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i7 = childAt3.getMeasuredHeight();
                        i11 = i6 - (i7 / 2);
                        childAt3.layout(measuredWidth - i9, i11, measuredWidth, i7 + i11);
                        paddingLeft = measuredWidth - ((layoutParams.leftMargin + i9) + paddingRight);
                    }
                    i5++;
                    measuredWidth = paddingLeft;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.NY) {
                    paddingLeft = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i9 = childAt3.getMeasuredWidth();
                    i7 = childAt3.getMeasuredHeight();
                    i11 = i6 - (i7 / 2);
                    childAt3.layout(measuredWidth, i11, measuredWidth + i9, i7 + i11);
                    paddingLeft = ((layoutParams.rightMargin + i9) + paddingRight) + measuredWidth;
                }
                i5++;
                measuredWidth = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    private static LayoutParams ec() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private LayoutParams b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams c(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return ec();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams ed() {
        LayoutParams ec = ec();
        ec.NY = true;
        return ec;
    }

    public final boolean f(h hVar) {
        return this.eg.a((MenuItem) hVar, null, 0);
    }

    public final void a(f fVar) {
        this.eg = fVar;
    }

    public final Menu getMenu() {
        if (this.eg == null) {
            Context context = getContext();
            this.eg = new f(context);
            this.eg.a(new c());
            this.NQ = new ActionMenuPresenter(context);
            this.NQ.dY();
            this.NQ.ef = this.NR != null ? this.NR : new b();
            this.eg.a(this.NQ, this.Mn);
            this.NQ.a(this);
        }
        return this.eg;
    }

    public final void a(android.support.v7.view.menu.l.a aVar, android.support.v7.view.menu.f.a aVar2) {
        this.NR = aVar;
        this.NS = aVar2;
    }

    public final void dismissPopupMenus() {
        if (this.NQ != null) {
            this.NQ.dZ();
        }
    }

    private boolean aI(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = ((a) childAt).do() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).dn() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }
}
