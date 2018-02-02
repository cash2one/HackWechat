package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.z;
import android.support.v7.widget.LinearLayoutManager.a;
import android.support.v7.widget.LinearLayoutManager.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager extends LinearLayoutManager {
    final SparseIntArray RA = new SparseIntArray();
    public b RB = new a();
    final Rect RC = new Rect();
    boolean Rv = false;
    public int Rw = -1;
    int[] Rx;
    View[] Ry;
    final SparseIntArray Rz = new SparseIntArray();

    public GridLayoutManager(Context context, int i) {
        aZ(i);
    }

    public GridLayoutManager() {
        super(1, false);
        aZ(4);
    }

    public final int a(m mVar, q qVar) {
        if (this.RT == 0) {
            return this.Rw;
        }
        if (qVar.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, qVar, qVar.getItemCount() - 1) + 1;
    }

    public final int b(m mVar, q qVar) {
        if (this.RT == 1) {
            return this.Rw;
        }
        if (qVar.getItemCount() <= 0) {
            return 0;
        }
        return a(mVar, qVar, qVar.getItemCount() - 1) + 1;
    }

    public final void a(m mVar, q qVar, View view, b bVar) {
        boolean z = false;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(mVar, qVar, layoutParams2.Vh.gd());
            int i;
            int i2;
            if (this.RT == 0) {
                i = layoutParams2.RD;
                i2 = layoutParams2.RE;
                boolean z2 = this.Rw > 1 && layoutParams2.RE == this.Rw;
                bVar.l(l.a(i, i2, a, 1, z2));
                return;
            }
            i = layoutParams2.RD;
            i2 = layoutParams2.RE;
            if (this.Rw > 1 && layoutParams2.RE == this.Rw) {
                z = true;
            }
            bVar.l(l.a(a, 1, i, i2, z));
            return;
        }
        super.b(view, bVar);
    }

    public final void c(m mVar, q qVar) {
        if (qVar.VL) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int gd = layoutParams.Vh.gd();
                this.Rz.put(gd, layoutParams.RE);
                this.RA.put(gd, layoutParams.RD);
            }
        }
        super.c(mVar, qVar);
        this.Rz.clear();
        this.RA.clear();
        if (!qVar.VL) {
            this.Rv = false;
        }
    }

    public final void C(int i, int i2) {
        this.RB.RF.clear();
    }

    public final void eL() {
        this.RB.RF.clear();
    }

    public final void D(int i, int i2) {
        this.RB.RF.clear();
    }

    public final void E(int i, int i2) {
        this.RB.RF.clear();
    }

    public final void F(int i, int i2) {
        this.RB.RF.clear();
    }

    public final RecyclerView.LayoutParams eM() {
        if (this.RT == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final RecyclerView.LayoutParams e(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void eN() {
        int paddingRight;
        if (this.RT == 1) {
            paddingRight = (this.mWidth - getPaddingRight()) - getPaddingLeft();
        } else {
            paddingRight = (this.mHeight - getPaddingBottom()) - getPaddingTop();
        }
        aY(paddingRight);
    }

    public final void a(Rect rect, int i, int i2) {
        if (this.Rx == null) {
            super.a(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.RT == 1) {
            paddingTop = m(i2, paddingTop + rect.height(), z.T(this.Va));
            paddingRight = m(i, paddingRight + this.Rx[this.Rx.length - 1], z.S(this.Va));
        } else {
            paddingRight = m(i, paddingRight + rect.width(), z.S(this.Va));
            paddingTop = m(i2, paddingTop + this.Rx[this.Rx.length - 1], z.T(this.Va));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    private void aY(int i) {
        int i2 = 0;
        int[] iArr = this.Rx;
        int i3 = this.Rw;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        iArr[0] = 0;
        int i4 = i / i3;
        int i5 = i % i3;
        int i6 = 0;
        for (int i7 = 1; i7 <= i3; i7++) {
            int i8;
            i2 += i5;
            if (i2 <= 0 || i3 - i2 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i2 -= i3;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        this.Rx = iArr;
    }

    final void a(m mVar, q qVar, a aVar, int i) {
        Object obj = 1;
        super.a(mVar, qVar, aVar, i);
        eN();
        if (qVar.getItemCount() > 0 && !qVar.VL) {
            if (i != 1) {
                obj = null;
            }
            int b = b(mVar, qVar, aVar.mPosition);
            if (obj != null) {
                while (b > 0 && aVar.mPosition > 0) {
                    aVar.mPosition--;
                    b = b(mVar, qVar, aVar.mPosition);
                }
            } else {
                int itemCount = qVar.getItemCount() - 1;
                int i2 = aVar.mPosition;
                while (i2 < itemCount) {
                    int b2 = b(mVar, qVar, i2 + 1);
                    if (b2 <= b) {
                        break;
                    }
                    i2++;
                    b = b2;
                }
                aVar.mPosition = i2;
            }
        }
        eO();
    }

    private void eO() {
        if (this.Ry == null || this.Ry.length != this.Rw) {
            this.Ry = new View[this.Rw];
        }
    }

    public final int a(int i, m mVar, q qVar) {
        eN();
        eO();
        return super.a(i, mVar, qVar);
    }

    public final int b(int i, m mVar, q qVar) {
        eN();
        eO();
        return super.b(i, mVar, qVar);
    }

    final View a(m mVar, q qVar, int i, int i2, int i3) {
        int i4;
        View view = null;
        eU();
        int fi = this.Sf.fi();
        int fj = this.Sf.fj();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = bd(childAt);
            if (bd >= 0 && bd < i3 && b(mVar, qVar, bd) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).Vh.isRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.Sf.aU(childAt) < fj && this.Sf.aV(childAt) >= fi) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        return view != null ? view : view2;
    }

    private int a(m mVar, q qVar, int i) {
        if (!qVar.VL) {
            return this.RB.I(i, this.Rw);
        }
        int bq = mVar.bq(i);
        if (bq == -1) {
            return 0;
        }
        return this.RB.I(bq, this.Rw);
    }

    private int b(m mVar, q qVar, int i) {
        if (!qVar.VL) {
            return this.RB.H(i, this.Rw);
        }
        int i2 = this.RA.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bq(i);
        if (i2 == -1) {
            return 0;
        }
        return this.RB.H(i2, this.Rw);
    }

    private int c(m mVar, q qVar, int i) {
        if (!qVar.VL) {
            return this.RB.ba(i);
        }
        int i2 = this.Rz.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = mVar.bq(i);
        if (i2 == -1) {
            return 1;
        }
        return this.RB.ba(i2);
    }

    final void a(m mVar, q qVar, c cVar, b bVar) {
        boolean z;
        int i;
        int fl = this.Sf.fl();
        Object obj = fl != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? this.Rx[this.Rw] : 0;
        if (obj != null) {
            eN();
        }
        if (cVar.RK == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.Rw;
        if (z) {
            i = 0;
        } else {
            i3 = b(mVar, qVar, cVar.RJ) + c(mVar, qVar, cVar.RJ);
            i = 0;
        }
        while (i < this.Rw && cVar.k(qVar) && i3 > 0) {
            View a;
            int i4 = cVar.RJ;
            int c = c(mVar, qVar, i4);
            if (c <= this.Rw) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                a = cVar.a(mVar);
                if (a == null) {
                    break;
                }
                this.Ry[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.Rw + " spans.");
            }
        }
        if (i == 0) {
            bVar.mFinished = true;
            return;
        }
        int b;
        int i5;
        int i6;
        int i7 = 0;
        float f = 0.0f;
        a(mVar, qVar, i, z);
        int i8 = 0;
        while (i8 < i) {
            a = this.Ry[i8];
            if (cVar.Sz == null) {
                if (z) {
                    super.c(a, -1, false);
                } else {
                    super.c(a, 0, false);
                }
            } else if (z) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            c = b(this.Rx[LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams)] - this.Rx[LayoutParams.a(layoutParams)], fl, 0, this.RT == 0 ? layoutParams.height : layoutParams.width, false);
            b = b(this.Sf.fk(), this.Sf.getMode(), 0, this.RT == 1 ? layoutParams.height : layoutParams.width, true);
            if (this.RT == 1) {
                a(a, c, b, layoutParams.height == -1, false);
            } else {
                a(a, b, c, layoutParams.width == -1, false);
            }
            i3 = this.Sf.aW(a);
            if (i3 <= i7) {
                i3 = i7;
            }
            float aX = (((float) this.Sf.aX(a)) * 1.0f) / ((float) LayoutParams.b(layoutParams));
            if (aX <= f) {
                aX = f;
            }
            i8++;
            f = aX;
            i7 = i3;
        }
        if (obj != null) {
            aY(Math.max(Math.round(((float) this.Rw) * f), i2));
            i5 = 0;
            i6 = 0;
            while (i6 < i) {
                a = this.Ry[i6];
                LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = b(this.Rx[LayoutParams.a(layoutParams2) + LayoutParams.b(layoutParams2)] - this.Rx[LayoutParams.a(layoutParams2)], 1073741824, 0, this.RT == 0 ? layoutParams2.height : layoutParams2.width, false);
                b = b(this.Sf.fk(), this.Sf.getMode(), 0, this.RT == 1 ? layoutParams2.height : layoutParams2.width, true);
                if (this.RT == 1) {
                    a(a, c, b, false, true);
                } else {
                    a(a, b, c, false, true);
                }
                i3 = this.Sf.aW(a);
                if (i3 <= i5) {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            i5 = i7;
        }
        b = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        for (i6 = 0; i6 < i; i6++) {
            a = this.Ry[i6];
            if (this.Sf.aW(a) != i5) {
                layoutParams2 = (LayoutParams) a.getLayoutParams();
                c = b(this.Rx[LayoutParams.a(layoutParams2) + LayoutParams.b(layoutParams2)] - this.Rx[LayoutParams.a(layoutParams2)], 1073741824, 0, this.RT == 0 ? layoutParams2.height : layoutParams2.width, false);
                if (this.RT == 1) {
                    a(a, c, b, true, true);
                } else {
                    a(a, b, c, true, true);
                }
            }
        }
        bVar.St = i5;
        b = 0;
        c = 0;
        i4 = 0;
        i3 = 0;
        if (this.RT == 1) {
            if (cVar.RL == -1) {
                i3 = cVar.wn;
                i4 = i3 - i5;
            } else {
                i4 = cVar.wn;
                i3 = i4 + i5;
            }
        } else if (cVar.RL == -1) {
            c = cVar.wn;
            b = c - i5;
        } else {
            b = cVar.wn;
            c = b + i5;
        }
        int i9 = b;
        b = c;
        c = i4;
        i4 = i3;
        for (int i10 = 0; i10 < i; i10++) {
            View view = this.Ry[i10];
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (this.RT != 1) {
                c = this.Rx[LayoutParams.a(layoutParams2)] + getPaddingTop();
                i4 = this.Sf.aX(view) + c;
            } else if (eT()) {
                b = getPaddingLeft() + this.Rx[LayoutParams.a(layoutParams2) + LayoutParams.b(layoutParams2)];
                i9 = b - this.Sf.aX(view);
            } else {
                i9 = this.Rx[LayoutParams.a(layoutParams2)] + getPaddingLeft();
                b = this.Sf.aX(view) + i9;
            }
            g(view, layoutParams2.leftMargin + i9, layoutParams2.topMargin + c, b - layoutParams2.rightMargin, i4 - layoutParams2.bottomMargin);
            if (layoutParams2.Vh.isRemoved() || layoutParams2.Vh.gr()) {
                bVar.Su = true;
            }
            bVar.Jw |= view.isFocusable();
        }
        Arrays.fill(this.Ry, null);
    }

    private void a(View view, int i, int i2, boolean z, boolean z2) {
        a(view, this.RC);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.RT == 1) {
            i = l(i, layoutParams.leftMargin + this.RC.left, layoutParams.rightMargin + this.RC.right);
        }
        if (z || this.RT == 0) {
            i2 = l(i2, layoutParams.topMargin + this.RC.top, layoutParams.bottomMargin + this.RC.bottom);
        }
        boolean a = z2 ? (this.Ve && h.n(view.getMeasuredWidth(), i, layoutParams.width) && h.n(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true : a(view, i, i2, layoutParams);
        if (a) {
            view.measure(i, i2);
        }
    }

    private static int l(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private void a(m mVar, q qVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.RT == 1 && eT()) {
            i4 = -1;
            i5 = this.Rw - 1;
            i6 = i3;
        } else {
            i4 = 1;
            i5 = 0;
            i6 = i3;
        }
        while (i6 != i) {
            View view = this.Ry[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams.a(layoutParams, c(mVar, qVar, bd(view)));
            if (i4 != -1 || LayoutParams.b(layoutParams) <= 1) {
                LayoutParams.b(layoutParams, i5);
            } else {
                LayoutParams.b(layoutParams, i5 - (LayoutParams.b(layoutParams) - 1));
            }
            i5 += LayoutParams.b(layoutParams) * i4;
            i6 += i2;
        }
    }

    public final void aZ(int i) {
        if (i != this.Rw) {
            this.Rv = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.Rw = i;
            this.RB.RF.clear();
        }
    }

    public final View a(View view, int i, m mVar, q qVar) {
        View be = be(view);
        if (be == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        int a = LayoutParams.a(layoutParams);
        int a2 = LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams);
        if (super.a(view, i, mVar, qVar) == null) {
            return null;
        }
        int childCount;
        int i2;
        int i3;
        if (((bf(i) == 1) != this.Si ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            childCount = 0;
            i2 = 1;
            i3 = getChildCount();
        }
        Object obj = (this.RT == 1 && eT()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = childCount;
        while (i6 != i3) {
            View childAt = getChildAt(i6);
            if (childAt == be) {
                break;
            }
            View view3;
            if (childAt.isFocusable()) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = LayoutParams.a(layoutParams);
                int a4 = LayoutParams.a(layoutParams) + LayoutParams.b(layoutParams);
                if (a3 == a && a4 == a2) {
                    return childAt;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = LayoutParams.a(layoutParams);
                    childCount = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = childAt;
                    view2 = view3;
                    i6 += i2;
                    i4 = i5;
                    i5 = childCount;
                }
            }
            childCount = i5;
            i5 = i4;
            view3 = view2;
            view2 = view3;
            i6 += i2;
            i4 = i5;
            i5 = childCount;
        }
        return view2;
    }

    public final boolean eP() {
        return this.So == null && !this.Rv;
    }
}
