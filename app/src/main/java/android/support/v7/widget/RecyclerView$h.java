package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public abstract class RecyclerView$h {
    s TQ;
    RecyclerView Va;
    p Vb;
    public boolean Vc = false;
    boolean Vd = false;
    boolean Ve = true;
    int Vf;
    int Vg;
    boolean hq = false;
    int mHeight;
    int mWidth;

    public abstract LayoutParams eM();

    static /* synthetic */ void a(RecyclerView$h recyclerView$h, p pVar) {
        if (recyclerView$h.Vb == pVar) {
            recyclerView$h.Vb = null;
        }
    }

    final void y(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.Va = null;
            this.TQ = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.Va = recyclerView;
            this.TQ = recyclerView.TQ;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.Vf = 1073741824;
        this.Vg = 1073741824;
    }

    final void ad(int i, int i2) {
        this.mWidth = MeasureSpec.getSize(i);
        this.Vf = MeasureSpec.getMode(i);
        if (this.Vf == 0 && !RecyclerView.TK) {
            this.mWidth = 0;
        }
        this.mHeight = MeasureSpec.getSize(i2);
        this.Vg = MeasureSpec.getMode(i2);
        if (this.Vg == 0 && !RecyclerView.TK) {
            this.mHeight = 0;
        }
    }

    final void ae(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        int childCount = getChildCount();
        if (childCount == 0) {
            this.Va.S(i, i2);
            return;
        }
        int i5 = 0;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int bh = bh(childAt) - layoutParams.leftMargin;
            int bj = layoutParams.rightMargin + bj(childAt);
            int bi = bi(childAt) - layoutParams.topMargin;
            int bk = layoutParams.bottomMargin + bk(childAt);
            if (bh >= i7) {
                bh = i7;
            }
            if (bj <= i6) {
                bj = i6;
            }
            if (bi >= i3) {
                bi = i3;
            }
            if (bk <= i4) {
                bk = i4;
            }
            i5++;
            i6 = bj;
            i3 = bi;
            i7 = bh;
            i4 = bk;
        }
        RecyclerView.v(this.Va).set(i7, i3, i6, i4);
        a(RecyclerView.v(this.Va), i, i2);
    }

    public void a(Rect rect, int i, int i2) {
        setMeasuredDimension(m(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), z.S(this.Va)), m(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), z.T(this.Va)));
    }

    public final void requestLayout() {
        if (this.Va != null) {
            this.Va.requestLayout();
        }
    }

    public static int m(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(size, Math.max(i2, i3));
            case 1073741824:
                return size;
            default:
                return Math.max(i2, i3);
        }
    }

    public void w(String str) {
        if (this.Va != null) {
            this.Va.w(str);
        }
    }

    public boolean eP() {
        return false;
    }

    final void b(RecyclerView recyclerView, m mVar) {
        this.hq = false;
        a(recyclerView, mVar);
    }

    public final boolean removeCallbacks(Runnable runnable) {
        if (this.Va != null) {
            return this.Va.removeCallbacks(runnable);
        }
        return false;
    }

    public void a(RecyclerView recyclerView, m mVar) {
    }

    public void c(m mVar, q qVar) {
    }

    public boolean a(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public LayoutParams e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int a(int i, m mVar, q qVar) {
        return 0;
    }

    public int b(int i, m mVar, q qVar) {
        return 0;
    }

    public boolean eQ() {
        return false;
    }

    public boolean eR() {
        return false;
    }

    public void be(int i) {
    }

    public void a(RecyclerView recyclerView, int i) {
    }

    public final void a(p pVar) {
        if (!(this.Vb == null || pVar == this.Vb || !this.Vb.Vx)) {
            this.Vb.stop();
        }
        this.Vb = pVar;
        p pVar2 = this.Vb;
        pVar2.Va = this.Va;
        pVar2.TG = this;
        if (pVar2.Vv == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        pVar2.Va.UB.Vv = pVar2.Vv;
        pVar2.Vx = true;
        pVar2.Vw = true;
        pVar2.Vy = pVar2.Va.TV.bc(pVar2.Vv);
        RecyclerView.x(pVar2.Va).fZ();
    }

    public final boolean fT() {
        return this.Vb != null && this.Vb.Vx;
    }

    void c(View view, int i, boolean z) {
        t aY = RecyclerView.aY(view);
        if (z || aY.isRemoved()) {
            this.Va.TR.D(aY);
        } else {
            this.Va.TR.E(aY);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (aY.gh() || aY.gf()) {
            if (aY.gf()) {
                aY.gg();
            } else {
                aY.gi();
            }
            this.TQ.a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.Va) {
            int indexOfChild = this.TQ.indexOfChild(view);
            if (i == -1) {
                i = this.TQ.getChildCount();
            }
            if (indexOfChild == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.Va.indexOfChild(view));
            } else if (indexOfChild != i) {
                RecyclerView$h recyclerView$h = this.Va.TV;
                View childAt = recyclerView$h.getChildAt(indexOfChild);
                if (childAt == null) {
                    throw new IllegalArgumentException("Cannot move a child from non-existing index:" + indexOfChild);
                }
                recyclerView$h.bm(indexOfChild);
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                t aY2 = RecyclerView.aY(childAt);
                if (aY2.isRemoved()) {
                    recyclerView$h.Va.TR.D(aY2);
                } else {
                    recyclerView$h.Va.TR.E(aY2);
                }
                recyclerView$h.TQ.a(childAt, i, layoutParams2, aY2.isRemoved());
            }
        } else {
            this.TQ.a(view, i, false);
            layoutParams.Vi = true;
            if (this.Vb != null && this.Vb.Vx) {
                p pVar = this.Vb;
                if (RecyclerView.ba(view) == pVar.Vv) {
                    pVar.Vy = view;
                }
            }
        }
        if (layoutParams.Vj) {
            aY.VU.invalidate();
            layoutParams.Vj = false;
        }
    }

    private void removeViewAt(int i) {
        if (getChildAt(i) != null) {
            s sVar = this.TQ;
            int aT = sVar.aT(i);
            View childAt = sVar.QB.getChildAt(aT);
            if (childAt != null) {
                if (sVar.QC.aV(aT)) {
                    sVar.aN(childAt);
                }
                sVar.QB.removeViewAt(aT);
            }
        }
    }

    public static int bd(View view) {
        return ((LayoutParams) view.getLayoutParams()).Vh.gd();
    }

    public final View be(View view) {
        if (this.Va == null) {
            return null;
        }
        ViewParent viewParent = this.Va;
        ViewParent parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != viewParent && (parent instanceof View)) {
            View view3 = (View) parent;
            view2 = view3;
            parent = view3.getParent();
        }
        if (parent == viewParent) {
            view3 = view2;
        } else {
            view3 = null;
        }
        if (view3 == null) {
            return null;
        }
        if (this.TQ.aO(view3)) {
            return null;
        }
        return view3;
    }

    public View bc(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            t aY = RecyclerView.aY(childAt);
            if (aY != null && aY.gd() == i && !aY.gb() && (this.Va.UB.VL || !aY.isRemoved())) {
                return childAt;
            }
        }
        return null;
    }

    private void bm(int i) {
        getChildAt(i);
        this.TQ.detachViewFromParent(i);
    }

    public final void a(View view, m mVar) {
        s sVar = this.TQ;
        int indexOfChild = sVar.QB.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (sVar.QC.aV(indexOfChild)) {
                sVar.aN(view);
            }
            sVar.QB.removeViewAt(indexOfChild);
        }
        mVar.bm(view);
    }

    public final void a(int i, m mVar) {
        View childAt = getChildAt(i);
        removeViewAt(i);
        mVar.bm(childAt);
    }

    public final int getChildCount() {
        return this.TQ != null ? this.TQ.getChildCount() : 0;
    }

    public final View getChildAt(int i) {
        return this.TQ != null ? this.TQ.getChildAt(i) : null;
    }

    public final int getPaddingLeft() {
        return this.Va != null ? this.Va.getPaddingLeft() : 0;
    }

    public final int getPaddingTop() {
        return this.Va != null ? this.Va.getPaddingTop() : 0;
    }

    public final int getPaddingRight() {
        return this.Va != null ? this.Va.getPaddingRight() : 0;
    }

    public final int getPaddingBottom() {
        return this.Va != null ? this.Va.getPaddingBottom() : 0;
    }

    public void bn(int i) {
        if (this.Va != null) {
            RecyclerView recyclerView = this.Va;
            int childCount = recyclerView.TQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                recyclerView.TQ.getChildAt(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void bo(int i) {
        if (this.Va != null) {
            RecyclerView recyclerView = this.Va;
            int childCount = recyclerView.TQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                recyclerView.TQ.getChildAt(i2).offsetTopAndBottom(i);
            }
        }
    }

    public final void b(m mVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            t aY = RecyclerView.aY(childAt);
            if (!aY.gb()) {
                if (!aY.gk() || aY.isRemoved() || RecyclerView.h(this.Va).US) {
                    bm(childCount);
                    mVar.bo(childAt);
                    this.Va.TR.E(aY);
                } else {
                    removeViewAt(childCount);
                    mVar.n(aY);
                }
            }
        }
    }

    final void c(m mVar) {
        int size = mVar.Vn.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((t) mVar.Vn.get(i)).VU;
            t aY = RecyclerView.aY(view);
            if (!aY.gb()) {
                aY.T(false);
                if (aY.gm()) {
                    this.Va.removeDetachedView(view, false);
                }
                if (this.Va.Ur != null) {
                    this.Va.Ur.d(aY);
                }
                aY.T(true);
                mVar.bn(view);
            }
        }
        mVar.Vn.clear();
        if (mVar.Vo != null) {
            mVar.Vo.clear();
        }
        if (size > 0) {
            this.Va.invalidate();
        }
    }

    final boolean a(View view, int i, int i2, LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && this.Ve && n(view.getWidth(), i, layoutParams.width) && n(view.getHeight(), i2, layoutParams.height)) ? false : true;
    }

    static boolean n(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size >= i) {
                    return true;
                }
                return false;
            case 0:
                return true;
            case 1073741824:
                if (size == i) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static int b(int i, int i2, int i3, int i4, boolean z) {
        int i5 = 0;
        int max = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = i2;
                        break;
                    default:
                        max = 0;
                        break;
                }
            } else {
                if (i4 == -2) {
                    max = 0;
                }
                max = 0;
            }
        } else if (i4 >= 0) {
            i5 = 1073741824;
            max = i4;
        } else if (i4 == -1) {
            i5 = i2;
        } else {
            if (i4 == -2) {
                if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                    i5 = Integer.MIN_VALUE;
                }
            }
            max = 0;
        }
        return MeasureSpec.makeMeasureSpec(max, i5);
    }

    public static int bf(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public static int bg(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public static void g(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).RC;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public static int bh(View view) {
        return view.getLeft() - ((LayoutParams) view.getLayoutParams()).RC.left;
    }

    public static int bi(View view) {
        return view.getTop() - ((LayoutParams) view.getLayoutParams()).RC.top;
    }

    public static int bj(View view) {
        return ((LayoutParams) view.getLayoutParams()).RC.right + view.getRight();
    }

    public static int bk(View view) {
        return ((LayoutParams) view.getLayoutParams()).RC.bottom + view.getBottom();
    }

    public final void a(View view, Rect rect) {
        if (this.Va == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.Va.bb(view));
        }
    }

    public View a(View view, int i, m mVar, q qVar) {
        return null;
    }

    public void eL() {
    }

    public void C(int i, int i2) {
    }

    public void D(int i, int i2) {
    }

    public void E(int i, int i2) {
    }

    public void F(int i, int i2) {
    }

    public int d(q qVar) {
        return 0;
    }

    public int b(q qVar) {
        return 0;
    }

    public int f(q qVar) {
        return 0;
    }

    public int e(q qVar) {
        return 0;
    }

    public int c(q qVar) {
        return 0;
    }

    public int g(q qVar) {
        return 0;
    }

    public final void af(int i, int i2) {
        this.Va.S(i, i2);
    }

    public final void setMeasuredDimension(int i, int i2) {
        RecyclerView.b(this.Va, i, i2);
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    final void fU() {
        if (this.Vb != null) {
            this.Vb.stop();
        }
    }

    public void bp(int i) {
    }

    public final void d(m mVar) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.aY(getChildAt(childCount)).gb()) {
                a(childCount, mVar);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        m mVar = this.Va.TN;
        q qVar = this.Va.UB;
        f a = a.a(accessibilityEvent);
        if (this.Va != null) {
            if (!(z.h(this.Va, 1) || z.h(this.Va, -1) || z.g(this.Va, -1) || z.g(this.Va, 1))) {
                z = false;
            }
            a.setScrollable(z);
            if (RecyclerView.h(this.Va) != null) {
                a.setItemCount(RecyclerView.h(this.Va).getItemCount());
            }
        }
    }

    final void b(View view, b bVar) {
        t aY = RecyclerView.aY(view);
        if (aY != null && !aY.isRemoved() && !this.TQ.aO(aY.VU)) {
            a(this.Va.TN, this.Va.UB, view, bVar);
        }
    }

    public void a(m mVar, q qVar, View view, b bVar) {
        int bd;
        int bd2 = eR() ? bd(view) : 0;
        if (eQ()) {
            bd = bd(view);
        } else {
            bd = 0;
        }
        bVar.l(l.a(bd2, 1, bd, 1, false));
    }

    public int a(m mVar, q qVar) {
        if (this.Va == null || RecyclerView.h(this.Va) == null || !eR()) {
            return 1;
        }
        return RecyclerView.h(this.Va).getItemCount();
    }

    public int b(m mVar, q qVar) {
        if (this.Va == null || RecyclerView.h(this.Va) == null || !eQ()) {
            return 1;
        }
        return RecyclerView.h(this.Va).getItemCount();
    }

    final void z(RecyclerView recyclerView) {
        ad(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    boolean eW() {
        return false;
    }
}
