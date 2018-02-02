package android.support.v7.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.f;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.ab.1;
import android.support.v7.widget.ab.2;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends h {
    int RT;
    private c Se;
    ab Sf;
    private boolean Sg;
    private boolean Sh;
    boolean Si;
    private boolean Sj;
    private boolean Sk;
    int Sl;
    int Sm;
    private boolean Sn;
    SavedState So;
    final a Sp;

    protected static class b {
        public boolean Jw;
        public int St;
        public boolean Su;
        public boolean mFinished;

        protected b() {
        }
    }

    public LinearLayoutManager() {
        this(1, false);
    }

    public LinearLayoutManager(int i, boolean z) {
        this.Sh = false;
        this.Si = false;
        this.Sj = false;
        this.Sk = true;
        this.Sl = -1;
        this.Sm = Integer.MIN_VALUE;
        this.So = null;
        this.Sp = new a(this);
        setOrientation(i);
        w(null);
        if (this.Sh) {
            this.Sh = false;
            requestLayout();
        }
        this.Vd = true;
    }

    public LayoutParams eM() {
        return new LayoutParams(-2, -2);
    }

    public final void a(RecyclerView recyclerView, m mVar) {
        super.a(recyclerView, mVar);
        if (this.Sn) {
            d(mVar);
            mVar.clear();
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            f a = a.a(accessibilityEvent);
            a.setFromIndex(eZ());
            a.setToIndex(fa());
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.So != null) {
            return new SavedState(this.So);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            eU();
            boolean z = this.Sg ^ this.Si;
            savedState.SC = z;
            View eY;
            if (z) {
                eY = eY();
                savedState.SB = this.Sf.fj() - this.Sf.aV(eY);
                savedState.SA = bd(eY);
                return savedState;
            }
            eY = eX();
            savedState.SA = bd(eY);
            savedState.SB = this.Sf.aU(eY) - this.Sf.fi();
            return savedState;
        }
        savedState.SA = -1;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.So = (SavedState) parcelable;
            requestLayout();
        }
    }

    public final boolean eQ() {
        return this.RT == 0;
    }

    public final boolean eR() {
        return this.RT == 1;
    }

    public final void setOrientation(int i) {
        if (i == 0 || i == 1) {
            w(null);
            if (i != this.RT) {
                this.RT = i;
                this.Sf = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
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

    public final View bc(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int bd = i - bd(getChildAt(0));
        if (bd >= 0 && bd < childCount) {
            View childAt = getChildAt(bd);
            if (bd(childAt) == i) {
                return childAt;
            }
        }
        return super.bc(i);
    }

    public int a(q qVar) {
        int i;
        if (qVar.Vv != -1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.Sf.fk();
        }
        return 0;
    }

    public void a(RecyclerView recyclerView, int i) {
        p anonymousClass1 = new z(this, recyclerView.getContext()) {
            final /* synthetic */ LinearLayoutManager Sq;

            public final PointF bd(int i) {
                return this.Sq.bd(i);
            }
        };
        anonymousClass1.Vv = i;
        a(anonymousClass1);
    }

    public final PointF bd(int i) {
        int i2 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < bd(getChildAt(0))) {
            z = true;
        }
        if (z != this.Si) {
            i2 = -1;
        }
        if (this.RT == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void c(m mVar, q qVar) {
        if (!(this.So == null && this.Sl == -1) && qVar.getItemCount() == 0) {
            d(mVar);
            return;
        }
        Object obj;
        View bc;
        int fh;
        int aW;
        int fi;
        int min;
        int fj;
        if (this.So != null && this.So.fc()) {
            this.Sl = this.So.SA;
        }
        eU();
        this.Se.RH = false;
        eS();
        a aVar = this.Sp;
        aVar.mPosition = -1;
        aVar.Sr = Integer.MIN_VALUE;
        aVar.Ss = false;
        this.Sp.Ss = this.Si ^ this.Sj;
        a aVar2 = this.Sp;
        if (qVar.VL || this.Sl == -1) {
            obj = null;
        } else if (this.Sl < 0 || this.Sl >= qVar.getItemCount()) {
            this.Sl = -1;
            this.Sm = Integer.MIN_VALUE;
            obj = null;
        } else {
            aVar2.mPosition = this.Sl;
            if (this.So == null || !this.So.fc()) {
                if (this.Sm == Integer.MIN_VALUE) {
                    bc = bc(this.Sl);
                    if (bc == null) {
                        if (getChildCount() > 0) {
                            aVar2.Ss = (this.Sl < bd(getChildAt(0))) == this.Si;
                        }
                        aVar2.fb();
                    } else if (this.Sf.aW(bc) > this.Sf.fk()) {
                        aVar2.fb();
                    } else if (this.Sf.aU(bc) - this.Sf.fi() < 0) {
                        aVar2.Sr = this.Sf.fi();
                        aVar2.Ss = false;
                    } else if (this.Sf.fj() - this.Sf.aV(bc) < 0) {
                        aVar2.Sr = this.Sf.fj();
                        aVar2.Ss = true;
                    } else {
                        aVar2.Sr = aVar2.Ss ? this.Sf.aV(bc) + this.Sf.fh() : this.Sf.aU(bc);
                    }
                    obj = 1;
                } else {
                    aVar2.Ss = this.Si;
                    if (this.Si) {
                        aVar2.Sr = this.Sf.fj() - this.Sm;
                    } else {
                        aVar2.Sr = this.Sf.fi() + this.Sm;
                    }
                }
                obj = 1;
            } else {
                aVar2.Ss = this.So.SC;
                if (aVar2.Ss) {
                    aVar2.Sr = this.Sf.fj() - this.So.SB;
                } else {
                    aVar2.Sr = this.Sf.fi() + this.So.SB;
                }
                obj = 1;
            }
        }
        if (obj == null) {
            if (getChildCount() != 0) {
                View view;
                if (this.Va == null) {
                    view = null;
                } else {
                    bc = this.Va.getFocusedChild();
                    view = (bc == null || this.TQ.aO(bc)) ? null : bc;
                }
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gd() < 0 || layoutParams.Vh.gd() >= qVar.getItemCount()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        fh = aVar2.Sq.Sf.fh();
                        if (fh >= 0) {
                            aVar2.aS(view);
                        } else {
                            aVar2.mPosition = bd(view);
                            if (aVar2.Ss) {
                                fh = (aVar2.Sq.Sf.fj() - fh) - aVar2.Sq.Sf.aV(view);
                                aVar2.Sr = aVar2.Sq.Sf.fj() - fh;
                                if (fh > 0) {
                                    aW = aVar2.Sr - aVar2.Sq.Sf.aW(view);
                                    fi = aVar2.Sq.Sf.fi();
                                    min = aW - (Math.min(aVar2.Sq.Sf.aU(view) - fi, 0) + fi);
                                    if (min < 0) {
                                        aVar2.Sr = Math.min(fh, -min) + aVar2.Sr;
                                    }
                                }
                            } else {
                                aW = aVar2.Sq.Sf.aU(view);
                                fi = aW - aVar2.Sq.Sf.fi();
                                aVar2.Sr = aW;
                                if (fi > 0) {
                                    fh = (aVar2.Sq.Sf.fj() - Math.min(0, (aVar2.Sq.Sf.fj() - fh) - aVar2.Sq.Sf.aV(view))) - (aW + aVar2.Sq.Sf.aW(view));
                                    if (fh < 0) {
                                        aVar2.Sr -= Math.min(fi, -fh);
                                    }
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fb();
                            if (this.Sj) {
                                fh = qVar.getItemCount() - 1;
                            } else {
                                fh = 0;
                            }
                            aVar2.mPosition = fh;
                        }
                    }
                }
                if (this.Sg == this.Sj) {
                    bc = aVar2.Ss ? d(mVar, qVar) : e(mVar, qVar);
                    if (bc != null) {
                        aVar2.aS(bc);
                        if (!qVar.VL && eP()) {
                            obj = (this.Sf.aU(bc) >= this.Sf.fj() || this.Sf.aV(bc) < this.Sf.fi()) ? 1 : null;
                            if (obj != null) {
                                aVar2.Sr = aVar2.Ss ? this.Sf.fj() : this.Sf.fi();
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            aVar2.fb();
                            if (this.Sj) {
                                fh = 0;
                            } else {
                                fh = qVar.getItemCount() - 1;
                            }
                            aVar2.mPosition = fh;
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                aVar2.fb();
                if (this.Sj) {
                    fh = qVar.getItemCount() - 1;
                } else {
                    fh = 0;
                }
                aVar2.mPosition = fh;
            }
        }
        fh = a(qVar);
        if (this.Se.Sy >= 0) {
            min = 0;
        } else {
            min = fh;
            fh = 0;
        }
        min += this.Sf.fi();
        fh += this.Sf.getEndPadding();
        if (!(!qVar.VL || this.Sl == -1 || this.Sm == Integer.MIN_VALUE)) {
            View bc2 = bc(this.Sl);
            if (bc2 != null) {
                if (this.Si) {
                    fj = (this.Sf.fj() - this.Sf.aV(bc2)) - this.Sm;
                } else {
                    fj = this.Sm - (this.Sf.aU(bc2) - this.Sf.fi());
                }
                if (fj > 0) {
                    min += fj;
                } else {
                    fh -= fj;
                }
            }
        }
        fj = this.Sp.Ss ? this.Si ? 1 : -1 : this.Si ? -1 : 1;
        a(mVar, qVar, this.Sp, fj);
        b(mVar);
        this.Se.RP = eV();
        this.Se.Sx = qVar.VL;
        if (this.Sp.Ss) {
            b(this.Sp);
            this.Se.Sw = min;
            a(mVar, this.Se, qVar, false);
            min = this.Se.wn;
            aW = this.Se.RJ;
            if (this.Se.RI > 0) {
                fh += this.Se.RI;
            }
            a(this.Sp);
            this.Se.Sw = fh;
            c cVar = this.Se;
            cVar.RJ += this.Se.RK;
            a(mVar, this.Se, qVar, false);
            fj = this.Se.wn;
            if (this.Se.RI > 0) {
                fh = this.Se.RI;
                M(aW, min);
                this.Se.Sw = fh;
                a(mVar, this.Se, qVar, false);
                fh = this.Se.wn;
            } else {
                fh = min;
            }
            min = fh;
            fh = fj;
        } else {
            a(this.Sp);
            this.Se.Sw = fh;
            a(mVar, this.Se, qVar, false);
            fh = this.Se.wn;
            fj = this.Se.RJ;
            if (this.Se.RI > 0) {
                min += this.Se.RI;
            }
            b(this.Sp);
            this.Se.Sw = min;
            c cVar2 = this.Se;
            cVar2.RJ += this.Se.RK;
            a(mVar, this.Se, qVar, false);
            min = this.Se.wn;
            if (this.Se.RI > 0) {
                aW = this.Se.RI;
                L(fj, fh);
                this.Se.Sw = aW;
                a(mVar, this.Se, qVar, false);
                fh = this.Se.wn;
            }
        }
        if (getChildCount() <= 0) {
            fj = min;
            min = fh;
        } else if ((this.Si ^ this.Sj) != 0) {
            fj = a(fh, mVar, qVar, true);
            min += fj;
            fh += fj;
            fj = b(min, mVar, qVar, false);
            fh += fj;
            fj = min + fj;
            min = fh;
        } else {
            fj = b(min, mVar, qVar, true);
            min += fj;
            fh += fj;
            fj = a(fh, mVar, qVar, false);
            fh += fj;
            fj = min + fj;
            min = fh;
        }
        if (qVar.VN && getChildCount() != 0 && !qVar.VL && eP()) {
            int i = 0;
            fi = 0;
            List list = mVar.Vq;
            int size = list.size();
            int bd = bd(getChildAt(0));
            int i2 = 0;
            while (i2 < size) {
                RecyclerView$t recyclerView$t = (RecyclerView$t) list.get(i2);
                if (recyclerView$t.isRemoved()) {
                    fh = fi;
                    aW = i;
                } else {
                    if (((recyclerView$t.gd() < bd) != this.Si ? -1 : 1) == -1) {
                        aW = this.Sf.aW(recyclerView$t.VU) + i;
                        fh = fi;
                    } else {
                        fh = this.Sf.aW(recyclerView$t.VU) + fi;
                        aW = i;
                    }
                }
                i = aW;
                i2++;
                fi = fh;
            }
            this.Se.Sz = list;
            if (i > 0) {
                M(bd(eX()), fj);
                this.Se.Sw = i;
                this.Se.RI = 0;
                this.Se.aT(null);
                a(mVar, this.Se, qVar, false);
            }
            if (fi > 0) {
                L(bd(eY()), min);
                this.Se.Sw = fi;
                this.Se.RI = 0;
                this.Se.aT(null);
                a(mVar, this.Se, qVar, false);
            }
            this.Se.Sz = null;
        }
        if (!qVar.VL) {
            this.Sl = -1;
            this.Sm = Integer.MIN_VALUE;
            ab abVar = this.Sf;
            abVar.TH = abVar.fk();
        }
        this.Sg = this.Sj;
        this.So = null;
    }

    void a(m mVar, q qVar, a aVar, int i) {
    }

    private int a(int i, m mVar, q qVar, boolean z) {
        int fj = this.Sf.fj() - i;
        if (fj <= 0) {
            return 0;
        }
        fj = -c(-fj, mVar, qVar);
        int i2 = i + fj;
        if (!z) {
            return fj;
        }
        i2 = this.Sf.fj() - i2;
        if (i2 <= 0) {
            return fj;
        }
        this.Sf.bh(i2);
        return fj + i2;
    }

    private int b(int i, m mVar, q qVar, boolean z) {
        int fi = i - this.Sf.fi();
        if (fi <= 0) {
            return 0;
        }
        fi = -c(fi, mVar, qVar);
        int i2 = i + fi;
        if (!z) {
            return fi;
        }
        i2 -= this.Sf.fi();
        if (i2 <= 0) {
            return fi;
        }
        this.Sf.bh(-i2);
        return fi - i2;
    }

    private void a(a aVar) {
        L(aVar.mPosition, aVar.Sr);
    }

    private void L(int i, int i2) {
        this.Se.RI = this.Sf.fj() - i2;
        this.Se.RK = this.Si ? -1 : 1;
        this.Se.RJ = i;
        this.Se.RL = 1;
        this.Se.wn = i2;
        this.Se.Sv = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        M(aVar.mPosition, aVar.Sr);
    }

    private void M(int i, int i2) {
        this.Se.RI = i2 - this.Sf.fi();
        this.Se.RJ = i;
        this.Se.RK = this.Si ? 1 : -1;
        this.Se.RL = -1;
        this.Se.wn = i2;
        this.Se.Sv = Integer.MIN_VALUE;
    }

    protected final boolean eT() {
        return z.I(this.Va) == 1;
    }

    final void eU() {
        if (this.Se == null) {
            this.Se = new c();
        }
        if (this.Sf == null) {
            ab 1;
            switch (this.RT) {
                case 0:
                    1 = new 1(this);
                    break;
                case 1:
                    1 = new 2(this);
                    break;
                default:
                    throw new IllegalArgumentException("invalid orientation");
            }
            this.Sf = 1;
        }
    }

    public final void be(int i) {
        this.Sl = i;
        this.Sm = Integer.MIN_VALUE;
        if (this.So != null) {
            this.So.SA = -1;
        }
        requestLayout();
    }

    public final void N(int i, int i2) {
        this.Sl = i;
        this.Sm = i2;
        if (this.So != null) {
            this.So.SA = -1;
        }
        requestLayout();
    }

    public int a(int i, m mVar, q qVar) {
        if (this.RT == 1) {
            return 0;
        }
        return c(i, mVar, qVar);
    }

    public int b(int i, m mVar, q qVar) {
        if (this.RT == 0) {
            return 0;
        }
        return c(i, mVar, qVar);
    }

    public final int b(q qVar) {
        return h(qVar);
    }

    public final int c(q qVar) {
        return h(qVar);
    }

    public final int d(q qVar) {
        return i(qVar);
    }

    public final int e(q qVar) {
        return i(qVar);
    }

    public final int f(q qVar) {
        return j(qVar);
    }

    public final int g(q qVar) {
        return j(qVar);
    }

    private int h(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eU();
        ab abVar = this.Sf;
        View N = N(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.a(qVar, abVar, N, O(z), this, this.Sk, this.Si);
    }

    private int i(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eU();
        ab abVar = this.Sf;
        View N = N(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.a(qVar, abVar, N, O(z), this, this.Sk);
    }

    private int j(q qVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        eU();
        ab abVar = this.Sf;
        View N = N(!this.Sk);
        if (this.Sk) {
            z = false;
        }
        return ah.b(qVar, abVar, N, O(z), this, this.Sk);
    }

    private void a(int i, int i2, boolean z, q qVar) {
        int i3 = -1;
        int i4 = 1;
        this.Se.RP = eV();
        this.Se.Sw = a(qVar);
        this.Se.RL = i;
        View eY;
        c cVar;
        if (i == 1) {
            c cVar2 = this.Se;
            cVar2.Sw += this.Sf.getEndPadding();
            eY = eY();
            cVar = this.Se;
            if (!this.Si) {
                i3 = 1;
            }
            cVar.RK = i3;
            this.Se.RJ = bd(eY) + this.Se.RK;
            this.Se.wn = this.Sf.aV(eY);
            i3 = this.Sf.aV(eY) - this.Sf.fj();
        } else {
            eY = eX();
            cVar = this.Se;
            cVar.Sw += this.Sf.fi();
            cVar = this.Se;
            if (!this.Si) {
                i4 = -1;
            }
            cVar.RK = i4;
            this.Se.RJ = bd(eY) + this.Se.RK;
            this.Se.wn = this.Sf.aU(eY);
            i3 = (-this.Sf.aU(eY)) + this.Sf.fi();
        }
        this.Se.RI = i2;
        if (z) {
            c cVar3 = this.Se;
            cVar3.RI -= i3;
        }
        this.Se.Sv = i3;
    }

    private boolean eV() {
        return this.Sf.getMode() == 0 && this.Sf.getEnd() == 0;
    }

    private int c(int i, m mVar, q qVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.Se.RH = true;
        eU();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, qVar);
        int a = this.Se.Sv + a(mVar, this.Se, qVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.Sf.bh(-i);
        this.Se.Sy = i;
        return i;
    }

    public final void w(String str) {
        if (this.So == null) {
            super.w(str);
        }
    }

    private void a(m mVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, mVar);
                }
                return;
            }
            while (i > i2) {
                a(i, mVar);
                i--;
            }
        }
    }

    private void a(m mVar, c cVar) {
        if (cVar.RH && !cVar.RP) {
            int i;
            int childCount;
            int end;
            if (cVar.RL == -1) {
                i = cVar.Sv;
                childCount = getChildCount();
                if (i >= 0) {
                    end = this.Sf.getEnd() - i;
                    if (this.Si) {
                        for (i = 0; i < childCount; i++) {
                            if (this.Sf.aU(getChildAt(i)) < end) {
                                a(mVar, 0, i);
                                return;
                            }
                        }
                        return;
                    }
                    for (i = childCount - 1; i >= 0; i--) {
                        if (this.Sf.aU(getChildAt(i)) < end) {
                            a(mVar, childCount - 1, i);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            childCount = cVar.Sv;
            if (childCount >= 0) {
                end = getChildCount();
                if (this.Si) {
                    for (i = end - 1; i >= 0; i--) {
                        if (this.Sf.aV(getChildAt(i)) > childCount) {
                            a(mVar, end - 1, i);
                            return;
                        }
                    }
                    return;
                }
                for (i = 0; i < end; i++) {
                    if (this.Sf.aV(getChildAt(i)) > childCount) {
                        a(mVar, 0, i);
                        return;
                    }
                }
            }
        }
    }

    private int a(m mVar, c cVar, q qVar, boolean z) {
        int i = cVar.RI;
        if (cVar.Sv != Integer.MIN_VALUE) {
            if (cVar.RI < 0) {
                cVar.Sv += cVar.RI;
            }
            a(mVar, cVar);
        }
        int i2 = cVar.RI + cVar.Sw;
        b bVar = new b();
        while (true) {
            if ((!cVar.RP && i2 <= 0) || !cVar.k(qVar)) {
                break;
            }
            bVar.St = 0;
            bVar.mFinished = false;
            bVar.Su = false;
            bVar.Jw = false;
            a(mVar, qVar, cVar, bVar);
            if (!bVar.mFinished) {
                cVar.wn += bVar.St * cVar.RL;
                if (!(bVar.Su && this.Se.Sz == null && qVar.VL)) {
                    cVar.RI -= bVar.St;
                    i2 -= bVar.St;
                }
                if (cVar.Sv != Integer.MIN_VALUE) {
                    cVar.Sv += bVar.St;
                    if (cVar.RI < 0) {
                        cVar.Sv += cVar.RI;
                    }
                    a(mVar, cVar);
                }
                if (z && bVar.Jw) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.RI;
    }

    void a(m mVar, q qVar, c cVar, b bVar) {
        View a = cVar.a(mVar);
        if (a == null) {
            bVar.mFinished = true;
            return;
        }
        int paddingRight;
        int i;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (cVar.Sz == null) {
            if (this.Si == (cVar.RL == -1)) {
                super.c(a, -1, false);
            } else {
                super.c(a, 0, false);
            }
        } else {
            if (this.Si == (cVar.RL == -1)) {
                super.c(a, -1, true);
            } else {
                super.c(a, 0, true);
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
        Rect bb = this.Va.bb(a);
        int i2 = (bb.left + bb.right) + 0;
        int i3 = (bb.bottom + bb.top) + 0;
        i2 = h.b(this.mWidth, this.Vf, i2 + (((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin), layoutParams2.width, eQ());
        i3 = h.b(this.mHeight, this.Vg, i3 + (((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin), layoutParams2.height, eR());
        if (a(a, i2, i3, layoutParams2)) {
            a.measure(i2, i3);
        }
        bVar.St = this.Sf.aW(a);
        if (this.RT == 1) {
            if (eT()) {
                paddingRight = this.mWidth - getPaddingRight();
                i3 = paddingRight - this.Sf.aX(a);
            } else {
                i3 = getPaddingLeft();
                paddingRight = this.Sf.aX(a) + i3;
            }
            if (cVar.RL == -1) {
                i2 = cVar.wn - bVar.St;
                i = i3;
                i3 = paddingRight;
                paddingRight = cVar.wn;
            } else {
                i2 = cVar.wn;
                i = i3;
                i3 = paddingRight;
                paddingRight = cVar.wn + bVar.St;
            }
        } else {
            i2 = getPaddingTop();
            paddingRight = this.Sf.aX(a) + i2;
            if (cVar.RL == -1) {
                i3 = cVar.wn;
                i = cVar.wn - bVar.St;
            } else {
                i = cVar.wn;
                i3 = cVar.wn + bVar.St;
            }
        }
        g(a, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, paddingRight - layoutParams.bottomMargin);
        if (layoutParams.Vh.isRemoved() || layoutParams.Vh.gr()) {
            bVar.Su = true;
        }
        bVar.Jw = a.isFocusable();
    }

    final boolean eW() {
        if (!(this.Vg == 1073741824 || this.Vf == 1073741824)) {
            boolean z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final int bf(int i) {
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                if (this.RT != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 33:
                if (this.RT != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case 66:
                return this.RT == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.RT == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View eX() {
        return getChildAt(this.Si ? getChildCount() - 1 : 0);
    }

    private View eY() {
        return getChildAt(this.Si ? 0 : getChildCount() - 1);
    }

    private View N(boolean z) {
        if (this.Si) {
            return a(getChildCount() - 1, -1, z, true);
        }
        return a(0, getChildCount(), z, true);
    }

    private View O(boolean z) {
        if (this.Si) {
            return a(0, getChildCount(), z, true);
        }
        return a(getChildCount() - 1, -1, z, true);
    }

    private View d(m mVar, q qVar) {
        return this.Si ? f(mVar, qVar) : g(mVar, qVar);
    }

    private View e(m mVar, q qVar) {
        return this.Si ? g(mVar, qVar) : f(mVar, qVar);
    }

    private View f(m mVar, q qVar) {
        return a(mVar, qVar, 0, getChildCount(), qVar.getItemCount());
    }

    private View g(m mVar, q qVar) {
        return a(mVar, qVar, getChildCount() - 1, -1, qVar.getItemCount());
    }

    View a(m mVar, q qVar, int i, int i2, int i3) {
        View view = null;
        eU();
        int fi = this.Sf.fi();
        int fj = this.Sf.fj();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int bd = bd(childAt);
            if (bd >= 0 && bd < i3) {
                if (((LayoutParams) childAt.getLayoutParams()).Vh.isRemoved()) {
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

    public final int eZ() {
        View a = a(0, getChildCount(), false, true);
        return a == null ? -1 : bd(a);
    }

    public final int fa() {
        View a = a(getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return bd(a);
    }

    public final View a(int i, int i2, boolean z, boolean z2) {
        eU();
        int fi = this.Sf.fi();
        int fj = this.Sf.fj();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int aU = this.Sf.aU(childAt);
            int aV = this.Sf.aV(childAt);
            if (aU < fj && aV > fi) {
                if (!z) {
                    return childAt;
                }
                if (aU >= fi && aV <= fj) {
                    return childAt;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    public View a(View view, int i, m mVar, q qVar) {
        eS();
        if (getChildCount() == 0) {
            return null;
        }
        int bf = bf(i);
        if (bf == Integer.MIN_VALUE) {
            return null;
        }
        View e;
        eU();
        if (bf == -1) {
            e = e(mVar, qVar);
        } else {
            e = d(mVar, qVar);
        }
        if (e == null) {
            return null;
        }
        View eX;
        eU();
        a(bf, (int) (0.33333334f * ((float) this.Sf.fk())), false, qVar);
        this.Se.Sv = Integer.MIN_VALUE;
        this.Se.RH = false;
        a(mVar, this.Se, qVar, true);
        if (bf == -1) {
            eX = eX();
        } else {
            eX = eY();
        }
        if (eX == e || !eX.isFocusable()) {
            return null;
        }
        return eX;
    }

    public boolean eP() {
        return this.So == null && this.Sg == this.Sj;
    }
}
