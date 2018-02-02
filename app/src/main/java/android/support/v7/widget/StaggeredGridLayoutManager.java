package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.BitSet;

public final class StaggeredGridLayoutManager extends h {
    private int RT;
    private int Rw;
    private boolean Sh;
    boolean Si;
    private boolean Sk;
    int Sl;
    int Sm;
    private b[] XM;
    ab XN;
    ab XO;
    private int XP;
    private final y XQ;
    private BitSet XR;
    LazySpanLookup XS;
    private int XT;
    private boolean XU;
    private boolean XV;
    private SavedState XW;
    private int XX;
    private final a XY;
    private boolean XZ;
    private final Runnable Ya;
    private final Rect gO;

    private class a {
        boolean Ss;
        final /* synthetic */ StaggeredGridLayoutManager Yb;
        boolean Yc;
        int mPosition;
        int wn;
    }

    private boolean gG() {
        if (getChildCount() == 0 || this.XT == 0 || !this.hq) {
            return false;
        }
        int gI;
        int gJ;
        if (this.Si) {
            gI = gI();
            gJ = gJ();
        } else {
            gI = gJ();
            gJ = gI();
        }
        if (gI == 0 && gH() != null) {
            this.XS.clear();
            this.Vc = true;
            requestLayout();
            return true;
        } else if (!this.XZ) {
            return false;
        } else {
            int i = this.Si ? -1 : 1;
            FullSpanItem q = this.XS.q(gI, gJ + 1, i);
            if (q == null) {
                this.XZ = false;
                this.XS.bE(gJ + 1);
                return false;
            }
            FullSpanItem q2 = this.XS.q(gI, q.mPosition, i * -1);
            if (q2 == null) {
                this.XS.bE(q.mPosition);
            } else {
                this.XS.bE(q2.mPosition + 1);
            }
            this.Vc = true;
            requestLayout();
            return true;
        }
    }

    public final void bp(int i) {
        if (i == 0) {
            gG();
        }
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        removeCallbacks(this.Ya);
        for (int i = 0; i < this.Rw; i++) {
            this.XM[i].clear();
        }
    }

    private View gH() {
        int i;
        int i2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.Rw);
        bitSet.set(0, this.Rw, true);
        boolean z = (this.RT == 1 && eT()) ? true : true;
        if (this.Si) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        if (childCount < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = childCount;
        while (i3 != i) {
            boolean z2;
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.Yd.mIndex)) {
                b bVar = layoutParams.Yd;
                if (this.Si) {
                    if (bVar.gO() < this.XN.fj()) {
                        z2 = !((LayoutParams) ((View) bVar.Yo.get(bVar.Yo.size() + -1)).getLayoutParams()).Ye;
                    }
                    z2 = false;
                } else {
                    if (bVar.gM() > this.XN.fi()) {
                        z2 = !((LayoutParams) ((View) bVar.Yo.get(0)).getLayoutParams()).Ye;
                    }
                    z2 = false;
                }
                if (z2) {
                    return childAt;
                }
                bitSet.clear(layoutParams.Yd.mIndex);
            }
            if (!(layoutParams.Ye || i3 + i2 == i)) {
                View childAt2 = getChildAt(i3 + i2);
                int aV;
                if (this.Si) {
                    childCount = this.XN.aV(childAt);
                    aV = this.XN.aV(childAt2);
                    if (childCount < aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.XN.aU(childAt);
                    aV = this.XN.aU(childAt2);
                    if (childCount > aV) {
                        return childAt;
                    }
                    if (childCount == aV) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.Yd.mIndex - ((LayoutParams) childAt2.getLayoutParams()).Yd.mIndex < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public final void w(String str) {
        if (this.XW == null) {
            super.w(str);
        }
    }

    private void eS() {
        boolean z = true;
        if (this.RT == 1 || !eT()) {
            z = this.Sh;
        } else if (this.Sh) {
            z = false;
        }
        this.Si = z;
    }

    private boolean eT() {
        return z.I(this.Va) == 1;
    }

    public final void a(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.RT == 1) {
            paddingTop = m(i2, paddingTop + rect.height(), z.T(this.Va));
            paddingRight = m(i, paddingRight + (this.XP * this.Rw), z.S(this.Va));
        } else {
            paddingRight = m(i, paddingRight + rect.width(), z.S(this.Va));
            paddingTop = m(i2, paddingTop + (this.XP * this.Rw), z.T(this.Va));
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public final void c(m mVar, q qVar) {
        Object obj = 1;
        while (true) {
            a aVar = this.XY;
            aVar.mPosition = -1;
            aVar.wn = Integer.MIN_VALUE;
            aVar.Ss = false;
            aVar.Yc = false;
            if (!(this.XW == null && this.Sl == -1) && qVar.getItemCount() == 0) {
                d(mVar);
                return;
            }
            int i;
            int i2;
            Object obj2;
            int childCount;
            int i3;
            if (this.XW != null) {
                if (this.XW.Yk > 0) {
                    if (this.XW.Yk == this.Rw) {
                        for (i = 0; i < this.Rw; i++) {
                            this.XM[i].clear();
                            i2 = this.XW.Yl[i];
                            if (i2 != Integer.MIN_VALUE) {
                                i2 = this.XW.SC ? i2 + this.XN.fj() : i2 + this.XN.fi();
                            }
                            this.XM[i].bL(i2);
                        }
                    } else {
                        SavedState savedState = this.XW;
                        savedState.Yl = null;
                        savedState.Yk = 0;
                        savedState.Ym = 0;
                        savedState.Yn = null;
                        savedState.Yf = null;
                        this.XW.SA = this.XW.Yj;
                    }
                }
                this.XV = this.XW.XV;
                boolean z = this.XW.Sh;
                w(null);
                if (!(this.XW == null || this.XW.Sh == z)) {
                    this.XW.Sh = z;
                }
                this.Sh = z;
                requestLayout();
                eS();
                if (this.XW.SA != -1) {
                    this.Sl = this.XW.SA;
                    aVar.Ss = this.XW.SC;
                } else {
                    aVar.Ss = this.Si;
                }
                if (this.XW.Ym > 1) {
                    this.XS.mData = this.XW.Yn;
                    this.XS.Yf = this.XW.Yf;
                }
            } else {
                eS();
                aVar.Ss = this.Si;
            }
            if (qVar.VL || this.Sl == -1) {
                obj2 = null;
            } else if (this.Sl < 0 || this.Sl >= qVar.getItemCount()) {
                this.Sl = -1;
                this.Sm = Integer.MIN_VALUE;
                obj2 = null;
            } else {
                if (this.XW == null || this.XW.SA == -1 || this.XW.Yk <= 0) {
                    View bc = bc(this.Sl);
                    if (bc != null) {
                        aVar.mPosition = this.Si ? gI() : gJ();
                        if (this.Sm != Integer.MIN_VALUE) {
                            if (aVar.Ss) {
                                aVar.wn = (this.XN.fj() - this.Sm) - this.XN.aV(bc);
                            } else {
                                aVar.wn = (this.XN.fi() + this.Sm) - this.XN.aU(bc);
                            }
                            obj2 = 1;
                        } else if (this.XN.aW(bc) > this.XN.fk()) {
                            aVar.wn = aVar.Ss ? this.XN.fj() : this.XN.fi();
                        } else {
                            i = this.XN.aU(bc) - this.XN.fi();
                            if (i < 0) {
                                aVar.wn = -i;
                            } else {
                                i = this.XN.fj() - this.XN.aV(bc);
                                if (i < 0) {
                                    aVar.wn = i;
                                } else {
                                    aVar.wn = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        aVar.mPosition = this.Sl;
                        if (this.Sm == Integer.MIN_VALUE) {
                            aVar.Ss = bD(aVar.mPosition) == 1;
                            aVar.wn = aVar.Ss ? aVar.Yb.XN.fj() : aVar.Yb.XN.fi();
                        } else {
                            i = this.Sm;
                            if (aVar.Ss) {
                                aVar.wn = aVar.Yb.XN.fj() - i;
                            } else {
                                aVar.wn = i + aVar.Yb.XN.fi();
                            }
                        }
                        aVar.Yc = true;
                    }
                } else {
                    aVar.wn = Integer.MIN_VALUE;
                    aVar.mPosition = this.Sl;
                }
                obj2 = 1;
            }
            if (obj2 == null) {
                int itemCount;
                if (this.XU) {
                    itemCount = qVar.getItemCount();
                    for (i2 = getChildCount() - 1; i2 >= 0; i2--) {
                        i = bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                } else {
                    itemCount = qVar.getItemCount();
                    childCount = getChildCount();
                    for (i2 = 0; i2 < childCount; i2++) {
                        i = bd(getChildAt(i2));
                        if (i >= 0 && i < itemCount) {
                            break;
                        }
                    }
                    i = 0;
                }
                aVar.mPosition = i;
                aVar.wn = Integer.MIN_VALUE;
            }
            if (this.XW == null && !(aVar.Ss == this.XU && eT() == this.XV)) {
                this.XS.clear();
                aVar.Yc = true;
            }
            if (getChildCount() > 0 && (this.XW == null || this.XW.Yk <= 0)) {
                if (aVar.Yc) {
                    for (i = 0; i < this.Rw; i++) {
                        this.XM[i].clear();
                        if (aVar.wn != Integer.MIN_VALUE) {
                            this.XM[i].bL(aVar.wn);
                        }
                    }
                } else {
                    for (i2 = 0; i2 < this.Rw; i2++) {
                        b bVar = this.XM[i2];
                        boolean z2 = this.Si;
                        i3 = aVar.wn;
                        i = z2 ? bVar.bK(Integer.MIN_VALUE) : bVar.bJ(Integer.MIN_VALUE);
                        bVar.clear();
                        if (i != Integer.MIN_VALUE && ((!z2 || i >= bVar.Yb.XN.fj()) && (z2 || i <= bVar.Yb.XN.fi()))) {
                            if (i3 != Integer.MIN_VALUE) {
                                i += i3;
                            }
                            bVar.Yq = i;
                            bVar.Yp = i;
                        }
                    }
                }
            }
            b(mVar);
            this.XQ.RH = false;
            this.XZ = false;
            by(this.XO.fk());
            a(aVar.mPosition, qVar);
            if (aVar.Ss) {
                bz(-1);
                a(mVar, this.XQ, qVar);
                bz(1);
                this.XQ.RJ = aVar.mPosition + this.XQ.RK;
                a(mVar, this.XQ, qVar);
            } else {
                bz(1);
                a(mVar, this.XQ, qVar);
                bz(-1);
                this.XQ.RJ = aVar.mPosition + this.XQ.RK;
                a(mVar, this.XQ, qVar);
            }
            if (this.XO.getMode() != 1073741824) {
                float f = 0.0f;
                i3 = getChildCount();
                childCount = 0;
                while (childCount < i3) {
                    float max;
                    View childAt = getChildAt(childCount);
                    float aW = (float) this.XO.aW(childAt);
                    if (aW >= f) {
                        max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).Ye ? (1.0f * aW) / ((float) this.Rw) : aW);
                    } else {
                        max = f;
                    }
                    childCount++;
                    f = max;
                }
                childCount = this.XP;
                i = Math.round(((float) this.Rw) * f);
                if (this.XO.getMode() == Integer.MIN_VALUE) {
                    i = Math.min(i, this.XO.fk());
                }
                by(i);
                if (this.XP != childCount) {
                    for (i2 = 0; i2 < i3; i2++) {
                        View childAt2 = getChildAt(i2);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.Ye) {
                            if (eT() && this.RT == 1) {
                                childAt2.offsetLeftAndRight(((-((this.Rw - 1) - layoutParams.Yd.mIndex)) * this.XP) - ((-((this.Rw - 1) - layoutParams.Yd.mIndex)) * childCount));
                            } else {
                                int i4 = layoutParams.Yd.mIndex * this.XP;
                                i = layoutParams.Yd.mIndex * childCount;
                                if (this.RT == 1) {
                                    childAt2.offsetLeftAndRight(i4 - i);
                                } else {
                                    childAt2.offsetTopAndBottom(i4 - i);
                                }
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.Si) {
                    a(mVar, qVar, true);
                    b(mVar, qVar, false);
                } else {
                    b(mVar, qVar, true);
                    a(mVar, qVar, false);
                }
            }
            obj2 = null;
            if (!(obj == null || qVar.VL)) {
                obj = (this.XT == 0 || getChildCount() <= 0 || (!this.XZ && gH() == null)) ? null : 1;
                if (obj != null) {
                    removeCallbacks(this.Ya);
                    if (gG()) {
                        obj2 = 1;
                    }
                }
                this.Sl = -1;
                this.Sm = Integer.MIN_VALUE;
            }
            this.XU = aVar.Ss;
            this.XV = eT();
            this.XW = null;
            if (obj2 != null) {
                obj = null;
            } else {
                return;
            }
        }
    }

    private void by(int i) {
        this.XP = i / this.Rw;
        this.XX = MeasureSpec.makeMeasureSpec(i, this.XO.getMode());
    }

    public final boolean eP() {
        return this.XW == null;
    }

    public final int b(q qVar) {
        return h(qVar);
    }

    private int h(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.XN;
        View Y = Y(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.a(qVar, abVar, Y, Z(z), this, this.Sk, this.Si);
    }

    public final int c(q qVar) {
        return h(qVar);
    }

    public final int d(q qVar) {
        return i(qVar);
    }

    private int i(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.XN;
        View Y = Y(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.a(qVar, abVar, Y, Z(z), this, this.Sk);
    }

    public final int e(q qVar) {
        return i(qVar);
    }

    public final int f(q qVar) {
        return j(qVar);
    }

    private int j(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        ab abVar = this.XN;
        View Y = Y(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.b(qVar, abVar, Y, Z(z), this, this.Sk);
    }

    public final int g(q qVar) {
        return j(qVar);
    }

    private void a(View view, int i, int i2, boolean z) {
        a(view, this.gO);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int l = l(i, layoutParams.leftMargin + this.gO.left, layoutParams.rightMargin + this.gO.right);
        int l2 = l(i2, layoutParams.topMargin + this.gO.top, layoutParams.bottomMargin + this.gO.bottom);
        if (a(view, l, l2, layoutParams)) {
            view.measure(l, l2);
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

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.XW = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.XW != null) {
            return new SavedState(this.XW);
        }
        SavedState savedState = new SavedState();
        savedState.Sh = this.Sh;
        savedState.SC = this.XU;
        savedState.XV = this.XV;
        if (this.XS == null || this.XS.mData == null) {
            savedState.Ym = 0;
        } else {
            savedState.Yn = this.XS.mData;
            savedState.Ym = savedState.Yn.length;
            savedState.Yf = this.XS.Yf;
        }
        if (getChildCount() > 0) {
            int i;
            savedState.SA = this.XU ? gI() : gJ();
            View Z = this.Si ? Z(true) : Y(true);
            if (Z == null) {
                i = -1;
            } else {
                i = bd(Z);
            }
            savedState.Yj = i;
            savedState.Yk = this.Rw;
            savedState.Yl = new int[this.Rw];
            for (i = 0; i < this.Rw; i++) {
                int bK;
                if (this.XU) {
                    bK = this.XM[i].bK(Integer.MIN_VALUE);
                    if (bK != Integer.MIN_VALUE) {
                        bK -= this.XN.fj();
                    }
                } else {
                    bK = this.XM[i].bJ(Integer.MIN_VALUE);
                    if (bK != Integer.MIN_VALUE) {
                        bK -= this.XN.fi();
                    }
                }
                savedState.Yl[i] = bK;
            }
        } else {
            savedState.SA = -1;
            savedState.Yj = -1;
            savedState.Yk = 0;
        }
        return savedState;
    }

    public final void a(m mVar, q qVar, View view, b bVar) {
        int i = 1;
        int i2 = -1;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int gK;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.RT == 0) {
                gK = layoutParams2.gK();
                if (layoutParams2.Ye) {
                    i = this.Rw;
                }
                i3 = gK;
                gK = i;
                i = -1;
            } else {
                gK = layoutParams2.gK();
                if (layoutParams2.Ye) {
                    i = this.Rw;
                    i3 = -1;
                    i2 = gK;
                    gK = -1;
                } else {
                    i3 = -1;
                    i2 = gK;
                    gK = -1;
                }
            }
            bVar.l(l.a(i3, gK, i2, i, layoutParams2.Ye));
            return;
        }
        super.b(view, bVar);
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = android.support.v4.view.a.a.a(accessibilityEvent);
            View Y = Y(false);
            View Z = Z(false);
            if (Y != null && Z != null) {
                int bd = bd(Y);
                int bd2 = bd(Z);
                if (bd < bd2) {
                    a.setFromIndex(bd);
                    a.setToIndex(bd2);
                    return;
                }
                a.setFromIndex(bd2);
                a.setToIndex(bd);
            }
        }
    }

    public final int a(m mVar, q qVar) {
        if (this.RT == 0) {
            return this.Rw;
        }
        return super.a(mVar, qVar);
    }

    public final int b(m mVar, q qVar) {
        if (this.RT == 1) {
            return this.Rw;
        }
        return super.b(mVar, qVar);
    }

    private View Y(boolean z) {
        int fi = this.XN.fi();
        int fj = this.XN.fj();
        int childCount = getChildCount();
        View view = null;
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            int aU = this.XN.aU(childAt);
            if (this.XN.aV(childAt) > fi && aU < fj) {
                if (aU >= fi || !z) {
                    return childAt;
                }
                if (view == null) {
                    i++;
                    view = childAt;
                }
            }
            childAt = view;
            i++;
            view = childAt;
        }
        return view;
    }

    private View Z(boolean z) {
        int fi = this.XN.fi();
        int fj = this.XN.fj();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int aU = this.XN.aU(childAt);
            int aV = this.XN.aV(childAt);
            if (aV > fi && aU < fj) {
                if (aV <= fj || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    private void a(m mVar, q qVar, boolean z) {
        int bB = bB(Integer.MIN_VALUE);
        if (bB != Integer.MIN_VALUE) {
            bB = this.XN.fj() - bB;
            if (bB > 0) {
                bB -= -c(-bB, mVar, qVar);
                if (z && bB > 0) {
                    this.XN.bh(bB);
                }
            }
        }
    }

    private void b(m mVar, q qVar, boolean z) {
        int bA = bA(Integer.MAX_VALUE);
        if (bA != Integer.MAX_VALUE) {
            bA -= this.XN.fi();
            if (bA > 0) {
                bA -= c(bA, mVar, qVar);
                if (z && bA > 0) {
                    this.XN.bh(-bA);
                }
            }
        }
    }

    private void a(int i, q qVar) {
        int i2;
        int i3;
        boolean z;
        y yVar;
        boolean z2 = false;
        this.XQ.RI = 0;
        this.XQ.RJ = i;
        if (fT()) {
            i2 = qVar.Vv;
            if (i2 != -1) {
                if (this.Si == (i2 < i)) {
                    i2 = this.XN.fk();
                    i3 = 0;
                } else {
                    i3 = this.XN.fk();
                    i2 = 0;
                }
                if (this.Va == null && RecyclerView.w(this.Va)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.XQ.RN = i2 + this.XN.getEnd();
                    this.XQ.RM = -i3;
                } else {
                    this.XQ.RM = this.XN.fi() - i3;
                    this.XQ.RN = i2 + this.XN.fj();
                }
                this.XQ.RO = false;
                this.XQ.RH = true;
                yVar = this.XQ;
                if (this.XN.getMode() == 0 && this.XN.getEnd() == 0) {
                    z2 = true;
                }
                yVar.RP = z2;
            }
        }
        i2 = 0;
        i3 = 0;
        if (this.Va == null) {
        }
        z = false;
        if (z) {
            this.XQ.RN = i2 + this.XN.getEnd();
            this.XQ.RM = -i3;
        } else {
            this.XQ.RM = this.XN.fi() - i3;
            this.XQ.RN = i2 + this.XN.fj();
        }
        this.XQ.RO = false;
        this.XQ.RH = true;
        yVar = this.XQ;
        z2 = true;
        yVar.RP = z2;
    }

    private void bz(int i) {
        int i2 = 1;
        this.XQ.RL = i;
        y yVar = this.XQ;
        if (this.Si != (i == -1)) {
            i2 = -1;
        }
        yVar.RK = i2;
    }

    public final void bn(int i) {
        super.bn(i);
        for (int i2 = 0; i2 < this.Rw; i2++) {
            this.XM[i2].bM(i);
        }
    }

    public final void bo(int i) {
        super.bo(i);
        for (int i2 = 0; i2 < this.Rw; i2++) {
            this.XM[i2].bM(i);
        }
    }

    public final void D(int i, int i2) {
        p(i, i2, 2);
    }

    public final void C(int i, int i2) {
        p(i, i2, 1);
    }

    public final void eL() {
        this.XS.clear();
        requestLayout();
    }

    public final void F(int i, int i2) {
        p(i, i2, 8);
    }

    public final void E(int i, int i2) {
        p(i, i2, 4);
    }

    private void p(int i, int i2, int i3) {
        int i4;
        int i5;
        int gI = this.Si ? gI() : gJ();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.XS.bF(i5);
        switch (i3) {
            case 1:
                this.XS.aj(i, i2);
                break;
            case 2:
                this.XS.ai(i, i2);
                break;
            case 8:
                this.XS.ai(i, 1);
                this.XS.aj(i2, 1);
                break;
        }
        if (i4 > gI) {
            if (i5 <= (this.Si ? gJ() : gI())) {
                requestLayout();
            }
        }
    }

    private int a(m mVar, y yVar, q qVar) {
        int i;
        int fi;
        this.XR.set(0, this.Rw, true);
        if (this.XQ.RP) {
            if (yVar.RL == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (yVar.RL == 1) {
            i = yVar.RN + yVar.RI;
        } else {
            i = yVar.RM - yVar.RI;
        }
        ah(yVar.RL, i);
        int fj = this.Si ? this.XN.fj() : this.XN.fi();
        Object obj = null;
        while (true) {
            Object obj2 = (yVar.RJ < 0 || yVar.RJ >= qVar.getItemCount()) ? null : 1;
            if (obj2 != null && (this.XQ.RP || !this.XR.isEmpty())) {
                b bVar;
                int i2;
                int i3;
                int bK;
                View br = mVar.br(yVar.RJ);
                yVar.RJ += yVar.RK;
                LayoutParams layoutParams = (LayoutParams) br.getLayoutParams();
                int gd = layoutParams.Vh.gd();
                LazySpanLookup lazySpanLookup = this.XS;
                int i4 = (lazySpanLookup.mData == null || gd >= lazySpanLookup.mData.length) ? -1 : lazySpanLookup.mData[gd];
                Object obj3 = i4 == -1 ? 1 : null;
                if (obj3 != null) {
                    if (layoutParams.Ye) {
                        bVar = this.XM[0];
                    } else {
                        if (bC(yVar.RL)) {
                            i4 = this.Rw - 1;
                            i2 = -1;
                            i3 = -1;
                        } else {
                            i4 = 0;
                            i2 = this.Rw;
                            i3 = 1;
                        }
                        int i5;
                        int fi2;
                        int i6;
                        b bVar2;
                        int i7;
                        if (yVar.RL == 1) {
                            bVar = null;
                            i5 = Integer.MAX_VALUE;
                            fi2 = this.XN.fi();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.XM[i6];
                                bK = bVar2.bK(fi2);
                                if (bK < i5) {
                                    i7 = bK;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        } else {
                            bVar = null;
                            i5 = Integer.MIN_VALUE;
                            fi2 = this.XN.fj();
                            i6 = i4;
                            while (i6 != i2) {
                                bVar2 = this.XM[i6];
                                bK = bVar2.bJ(fi2);
                                if (bK > i5) {
                                    i7 = bK;
                                } else {
                                    bVar2 = bVar;
                                    i7 = i5;
                                }
                                i6 += i3;
                                i5 = i7;
                                bVar = bVar2;
                            }
                        }
                    }
                    lazySpanLookup = this.XS;
                    lazySpanLookup.bG(gd);
                    lazySpanLookup.mData[gd] = bVar.mIndex;
                } else {
                    bVar = this.XM[i4];
                }
                layoutParams.Yd = bVar;
                if (yVar.RL == 1) {
                    super.c(br, -1, false);
                } else {
                    super.c(br, 0, false);
                }
                if (layoutParams.Ye) {
                    if (this.RT == 1) {
                        a(br, this.XX, b(this.mHeight, this.Vg, 0, layoutParams.height, true), false);
                    } else {
                        a(br, b(this.mWidth, this.Vf, 0, layoutParams.width, true), this.XX, false);
                    }
                } else if (this.RT == 1) {
                    a(br, b(this.XP, this.Vf, 0, layoutParams.width, false), b(this.mHeight, this.Vg, 0, layoutParams.height, true), false);
                } else {
                    a(br, b(this.mWidth, this.Vf, 0, layoutParams.width, true), b(this.XP, this.Vg, 0, layoutParams.height, false), false);
                }
                FullSpanItem fullSpanItem;
                if (yVar.RL == 1) {
                    i3 = layoutParams.Ye ? bB(fj) : bVar.bK(fj);
                    i2 = i3 + this.XN.aW(br);
                    if (obj3 == null || !layoutParams.Ye) {
                        i4 = i3;
                        i3 = i2;
                    } else {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.Yh = new int[this.Rw];
                        for (i4 = 0; i4 < this.Rw; i4++) {
                            fullSpanItem.Yh[i4] = i3 - this.XM[i4].bK(i3);
                        }
                        fullSpanItem.Yg = -1;
                        fullSpanItem.mPosition = gd;
                        this.XS.a(fullSpanItem);
                        i4 = i3;
                        i3 = i2;
                    }
                } else {
                    i3 = layoutParams.Ye ? bA(fj) : bVar.bJ(fj);
                    i2 = i3 - this.XN.aW(br);
                    if (obj3 != null && layoutParams.Ye) {
                        fullSpanItem = new FullSpanItem();
                        fullSpanItem.Yh = new int[this.Rw];
                        for (i4 = 0; i4 < this.Rw; i4++) {
                            fullSpanItem.Yh[i4] = this.XM[i4].bJ(i3) - i3;
                        }
                        fullSpanItem.Yg = 1;
                        fullSpanItem.mPosition = gd;
                        this.XS.a(fullSpanItem);
                    }
                    i4 = i2;
                }
                if (layoutParams.Ye && yVar.RK == -1) {
                    if (obj3 == null) {
                        Object obj4;
                        if (yVar.RL == 1) {
                            bK = this.XM[0].bK(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.Rw; i2++) {
                                if (this.XM[i2].bK(Integer.MIN_VALUE) != bK) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        } else {
                            bK = this.XM[0].bJ(Integer.MIN_VALUE);
                            for (i2 = 1; i2 < this.Rw; i2++) {
                                if (this.XM[i2].bJ(Integer.MIN_VALUE) != bK) {
                                    obj4 = null;
                                    break;
                                }
                            }
                            obj4 = 1;
                            obj4 = obj4 == null ? 1 : null;
                        }
                        if (obj4 != null) {
                            FullSpanItem bH = this.XS.bH(gd);
                            if (bH != null) {
                                bH.Yi = true;
                            }
                        }
                    }
                    this.XZ = true;
                }
                if (yVar.RL == 1) {
                    if (layoutParams.Ye) {
                        for (i2 = this.Rw - 1; i2 >= 0; i2--) {
                            this.XM[i2].bq(br);
                        }
                    } else {
                        layoutParams.Yd.bq(br);
                    }
                } else if (layoutParams.Ye) {
                    for (i2 = this.Rw - 1; i2 >= 0; i2--) {
                        this.XM[i2].bp(br);
                    }
                } else {
                    layoutParams.Yd.bp(br);
                }
                if (eT() && this.RT == 1) {
                    i2 = layoutParams.Ye ? this.XO.fj() : this.XO.fj() - (((this.Rw - 1) - bVar.mIndex) * this.XP);
                    bK = i2;
                    i2 -= this.XO.aW(br);
                } else {
                    i2 = layoutParams.Ye ? this.XO.fi() : (bVar.mIndex * this.XP) + this.XO.fi();
                    bK = this.XO.aW(br) + i2;
                }
                if (this.RT == 1) {
                    h(br, i2, i4, bK, i3);
                } else {
                    h(br, i4, i2, i3, bK);
                }
                if (layoutParams.Ye) {
                    ah(this.XQ.RL, i);
                } else {
                    a(bVar, this.XQ.RL, i);
                }
                a(mVar, this.XQ);
                if (this.XQ.RO && br.isFocusable()) {
                    if (layoutParams.Ye) {
                        this.XR.clear();
                    } else {
                        this.XR.set(bVar.mIndex, false);
                    }
                }
                obj = 1;
            } else if (obj == null) {
                a(mVar, this.XQ);
            }
        }
        if (obj == null) {
            a(mVar, this.XQ);
        }
        if (this.XQ.RL == -1) {
            fi = this.XN.fi() - bA(this.XN.fi());
        } else {
            fi = bB(this.XN.fj()) - this.XN.fj();
        }
        return fi > 0 ? Math.min(yVar.RI, fi) : 0;
    }

    private void a(m mVar, y yVar) {
        int i = 1;
        if (yVar.RH && !yVar.RP) {
            if (yVar.RI == 0) {
                if (yVar.RL == -1) {
                    b(mVar, yVar.RN);
                } else {
                    a(mVar, yVar.RM);
                }
            } else if (yVar.RL == -1) {
                r3 = yVar.RM;
                int i2 = yVar.RM;
                r1 = this.XM[0].bJ(i2);
                while (i < this.Rw) {
                    r2 = this.XM[i].bJ(i2);
                    if (r2 > r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r3 - r1;
                if (i < 0) {
                    i = yVar.RN;
                } else {
                    i = yVar.RN - Math.min(i, yVar.RI);
                }
                b(mVar, i);
            } else {
                r3 = yVar.RN;
                r1 = this.XM[0].bK(r3);
                while (i < this.Rw) {
                    r2 = this.XM[i].bK(r3);
                    if (r2 < r1) {
                        r1 = r2;
                    }
                    i++;
                }
                i = r1 - yVar.RN;
                if (i < 0) {
                    i = yVar.RM;
                } else {
                    i = Math.min(i, yVar.RI) + yVar.RM;
                }
                a(mVar, i);
            }
        }
    }

    private static void h(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        g(view, layoutParams.leftMargin + i, layoutParams.topMargin + i2, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void ah(int i, int i2) {
        for (int i3 = 0; i3 < this.Rw; i3++) {
            if (!this.XM[i3].Yo.isEmpty()) {
                a(this.XM[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int i3 = bVar.Yr;
        if (i == -1) {
            if (i3 + bVar.gM() <= i2) {
                this.XR.set(bVar.mIndex, false);
            }
        } else if (bVar.gO() - i3 >= i2) {
            this.XR.set(bVar.mIndex, false);
        }
    }

    private int bA(int i) {
        int bJ = this.XM[0].bJ(i);
        for (int i2 = 1; i2 < this.Rw; i2++) {
            int bJ2 = this.XM[i2].bJ(i);
            if (bJ2 < bJ) {
                bJ = bJ2;
            }
        }
        return bJ;
    }

    private int bB(int i) {
        int bK = this.XM[0].bK(i);
        for (int i2 = 1; i2 < this.Rw; i2++) {
            int bK2 = this.XM[i2].bK(i);
            if (bK2 > bK) {
                bK = bK2;
            }
        }
        return bK;
    }

    private void a(m mVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.XN.aV(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Ye) {
                    int i2 = 0;
                    while (i2 < this.Rw) {
                        if (this.XM[i2].Yo.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.Rw; i2++) {
                        this.XM[i2].gQ();
                    }
                } else if (layoutParams.Yd.Yo.size() != 1) {
                    layoutParams.Yd.gQ();
                } else {
                    return;
                }
                a(childAt, mVar);
            } else {
                return;
            }
        }
    }

    private void b(m mVar, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.XN.aU(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Ye) {
                    int i2 = 0;
                    while (i2 < this.Rw) {
                        if (this.XM[i2].Yo.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.Rw; i2++) {
                        this.XM[i2].gP();
                    }
                } else if (layoutParams.Yd.Yo.size() != 1) {
                    layoutParams.Yd.gP();
                } else {
                    return;
                }
                a(childAt, mVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean bC(int i) {
        if (this.RT == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.Si) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.Si) != eT()) {
            return false;
        }
        return true;
    }

    public final boolean eR() {
        return this.RT == 1;
    }

    public final boolean eQ() {
        return this.RT == 0;
    }

    public final int a(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    public final int b(int i, m mVar, q qVar) {
        return c(i, mVar, qVar);
    }

    private int bD(int i) {
        if (getChildCount() != 0) {
            if ((i < gJ()) != this.Si) {
                return -1;
            }
            return 1;
        } else if (this.Si) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void a(RecyclerView recyclerView, int i) {
        p anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ StaggeredGridLayoutManager Yb;

            public final PointF bd(int i) {
                int a = this.Yb.bD(i);
                if (a == 0) {
                    return null;
                }
                if (this.Yb.RT == 0) {
                    return new PointF((float) a, 0.0f);
                }
                return new PointF(0.0f, (float) a);
            }
        };
        anonymousClass1.Vv = i;
        a(anonymousClass1);
    }

    public final void be(int i) {
        if (!(this.XW == null || this.XW.SA == i)) {
            SavedState savedState = this.XW;
            savedState.Yl = null;
            savedState.Yk = 0;
            savedState.SA = -1;
            savedState.Yj = -1;
        }
        this.Sl = i;
        this.Sm = Integer.MIN_VALUE;
        requestLayout();
    }

    private int c(int i, m mVar, q qVar) {
        int gI;
        int i2;
        if (i > 0) {
            gI = gI();
            i2 = 1;
        } else {
            i2 = -1;
            gI = gJ();
        }
        this.XQ.RH = true;
        a(gI, qVar);
        bz(i2);
        this.XQ.RJ = this.XQ.RK + gI;
        int abs = Math.abs(i);
        this.XQ.RI = abs;
        i2 = a(mVar, this.XQ, qVar);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.XN.bh(-i);
        this.XU = this.Si;
        return i;
    }

    private int gI() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : bd(getChildAt(childCount - 1));
    }

    private int gJ() {
        if (getChildCount() == 0) {
            return 0;
        }
        return bd(getChildAt(0));
    }

    public final RecyclerView$LayoutParams eM() {
        if (this.RT == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView$LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final RecyclerView$LayoutParams e(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean a(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof LayoutParams;
    }

    public final View a(View view, int i, m mVar, q qVar) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View be = be(view);
        if (be == null) {
            return null;
        }
        int i3;
        eS();
        switch (i) {
            case 1:
                i3 = -1;
                break;
            case 2:
                i3 = 1;
                break;
            case 17:
                if (this.RT != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 33:
                if (this.RT != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = -1;
                break;
            case 66:
                if (this.RT != 0) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            case 130:
                if (this.RT != 1) {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
                i3 = 1;
                break;
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        int gI;
        View ak;
        LayoutParams layoutParams = (LayoutParams) be.getLayoutParams();
        boolean z = layoutParams.Ye;
        b bVar = layoutParams.Yd;
        if (i3 == 1) {
            gI = gI();
        } else {
            gI = gJ();
        }
        a(gI, qVar);
        bz(i3);
        this.XQ.RJ = this.XQ.RK + gI;
        this.XQ.RI = (int) (0.33333334f * ((float) this.XN.fk()));
        this.XQ.RO = true;
        this.XQ.RH = false;
        a(mVar, this.XQ, qVar);
        this.XU = this.Si;
        if (!z) {
            ak = bVar.ak(gI, i3);
            if (!(ak == null || ak == be)) {
                return ak;
            }
        }
        if (bC(i3)) {
            for (int i4 = this.Rw - 1; i4 >= 0; i4--) {
                View ak2 = this.XM[i4].ak(gI, i3);
                if (ak2 != null && ak2 != be) {
                    return ak2;
                }
            }
        } else {
            while (i2 < this.Rw) {
                ak = this.XM[i2].ak(gI, i3);
                if (ak != null && ak != be) {
                    return ak;
                }
                i2++;
            }
        }
        return null;
    }
}
