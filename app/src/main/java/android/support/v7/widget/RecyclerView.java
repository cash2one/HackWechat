package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.e;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.d.a.c;
import android.support.v7.widget.as.b;
import android.support.v7.widget.s.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements p, w {
    private static final int[] TI = new int[]{16843830};
    private static final boolean TJ;
    static final boolean TK;
    private static final Class<?>[] TL = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final Interpolator UO = new 3();
    private final int[] Do;
    private final int[] Dp;
    private final o TM;
    final m TN;
    private SavedState TO;
    e TP;
    s TQ;
    final as TR;
    private boolean TS;
    private final Runnable TT;
    private a TU;
    public h TV;
    private n TW;
    public final ArrayList<g> TX;
    public final ArrayList<j> TY;
    public j TZ;
    private final s UA;
    final q UB;
    public k UC;
    public List<k> UD;
    boolean UE;
    boolean UF;
    private b UG;
    private boolean UH;
    private ac UI;
    private d UJ;
    private final int[] UK;
    private q UL;
    private final int[] UM;
    private Runnable UN;
    private final b UP;
    private boolean Ua;
    public boolean Ub;
    boolean Uc;
    private int Ud;
    private boolean Ue;
    public boolean Uf;
    private boolean Ug;
    private int Uh;
    private boolean Ui;
    private final boolean Uj;
    public List<i> Uk;
    boolean Ul;
    private int Um;
    android.support.v4.widget.i Un;
    android.support.v4.widget.i Uo;
    android.support.v4.widget.i Up;
    android.support.v4.widget.i Uq;
    public e Ur;
    private int Us;
    private int Ut;
    private int Uu;
    private int Uv;
    private int Uw;
    private final int Ux;
    private final int Uy;
    private float Uz;
    private final Rect ey;
    private VelocityTracker ft;
    private int iN;
    private final AccessibilityManager ju;
    public int yi;

    public interface d {
        int ac(int i, int i2);
    }

    public interface i {
        void bl(View view);
    }

    public interface j {
        void S(boolean z);

        boolean n(MotionEvent motionEvent);

        void o(MotionEvent motionEvent);
    }

    public static abstract class k {
        public void e(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public final class m {
        final /* synthetic */ RecyclerView UQ;
        final ArrayList<t> Vn = new ArrayList();
        ArrayList<t> Vo = null;
        final ArrayList<t> Vp = new ArrayList();
        final List<t> Vq = Collections.unmodifiableList(this.Vn);
        private int Vr = 2;
        private l Vs;
        private r Vt;

        public m(RecyclerView recyclerView) {
            this.UQ = recyclerView;
        }

        public final void clear() {
            this.Vn.clear();
            fV();
        }

        public final int bq(int i) {
            if (i >= 0 && i < this.UQ.UB.getItemCount()) {
                return !this.UQ.UB.VL ? i : this.UQ.TP.aP(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.UQ.UB.getItemCount());
            }
        }

        public final View br(int i) {
            boolean z = true;
            if (i < 0 || i >= this.UQ.UB.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.UQ.UB.getItemCount());
            }
            boolean z2;
            t tVar;
            boolean z3;
            boolean z4;
            t d;
            LayoutParams layoutParams;
            if (this.UQ.UB.VL) {
                t bt = bt(i);
                t tVar2 = bt;
                z2 = bt != null;
                tVar = tVar2;
            } else {
                tVar = null;
                z2 = false;
            }
            if (tVar == null) {
                tVar = h(i, false);
                if (tVar != null) {
                    if (tVar.isRemoved()) {
                        z3 = this.UQ.UB.VL;
                    } else if (tVar.mPosition < 0 || tVar.mPosition >= this.UQ.TU.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + tVar);
                    } else {
                        z3 = (this.UQ.UB.VL || this.UQ.TU.getItemViewType(tVar.mPosition) == tVar.VX) ? !this.UQ.TU.US || tVar.VW == this.UQ.TU.getItemId(tVar.mPosition) : false;
                    }
                    if (z3) {
                        z2 = true;
                    } else {
                        tVar.addFlags(4);
                        if (tVar.gf()) {
                            this.UQ.removeDetachedView(tVar.VU, false);
                            tVar.gg();
                        } else if (tVar.gh()) {
                            tVar.gi();
                        }
                        n(tVar);
                        tVar = null;
                    }
                }
            }
            if (tVar == null) {
                int aP = this.UQ.TP.aP(i);
                if (aP < 0 || aP >= this.UQ.TU.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + aP + ").state:" + this.UQ.UB.getItemCount());
                }
                View fY;
                ArrayList arrayList;
                int itemViewType = this.UQ.TU.getItemViewType(aP);
                if (this.UQ.TU.US) {
                    tVar = a(this.UQ.TU.getItemId(aP), itemViewType, false);
                    if (tVar != null) {
                        tVar.mPosition = aP;
                        z3 = true;
                        if (tVar == null && this.Vt != null) {
                            fY = this.Vt.fY();
                            if (fY != null) {
                                tVar = this.UQ.aP(fY);
                                if (tVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (tVar.gb()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (tVar == null) {
                            arrayList = (ArrayList) fW().Vk.get(itemViewType);
                            if (arrayList != null || arrayList.isEmpty()) {
                                bt = null;
                            } else {
                                int size = arrayList.size() - 1;
                                bt = (t) arrayList.get(size);
                                arrayList.remove(size);
                            }
                            if (bt != null) {
                                bt.gp();
                                if (RecyclerView.TJ && (bt.VU instanceof ViewGroup)) {
                                    c((ViewGroup) bt.VU, false);
                                }
                            }
                            tVar = bt;
                        }
                        if (tVar != null) {
                            z4 = z3;
                            d = this.UQ.TU.d(this.UQ, itemViewType);
                        } else {
                            z4 = z3;
                            d = tVar;
                        }
                    }
                }
                z3 = z2;
                fY = this.Vt.fY();
                if (fY != null) {
                    tVar = this.UQ.aP(fY);
                    if (tVar == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (tVar.gb()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (tVar == null) {
                    arrayList = (ArrayList) fW().Vk.get(itemViewType);
                    if (arrayList != null) {
                    }
                    bt = null;
                    if (bt != null) {
                        bt.gp();
                        c((ViewGroup) bt.VU, false);
                    }
                    tVar = bt;
                }
                if (tVar != null) {
                    z4 = z3;
                    d = tVar;
                } else {
                    z4 = z3;
                    d = this.UQ.TU.d(this.UQ, itemViewType);
                }
            } else {
                d = tVar;
                z4 = z2;
            }
            if (z4 && !this.UQ.UB.VL && d.bv(8192)) {
                d.setFlags(0, 8192);
                if (this.UQ.UB.VM) {
                    this.UQ.a(d, this.UQ.Ur.a(this.UQ.UB, d, e.j(d) | Downloads.RECV_BUFFER_SIZE, d.go()));
                }
            }
            if (this.UQ.UB.VL && d.isBound()) {
                d.VY = i;
                z2 = false;
            } else if (!d.isBound() || d.gl() || d.gk()) {
                int aP2 = this.UQ.TP.aP(i);
                d.Wi = this.UQ;
                a h = this.UQ.TU;
                d.mPosition = aP2;
                if (h.US) {
                    d.VW = h.getItemId(aP2);
                }
                d.setFlags(1, 519);
                e.beginSection("RV OnBindView");
                h.a(d, aP2, d.go());
                d.gn();
                e.endSection();
                View view = d.VU;
                if (this.UQ.fA()) {
                    if (z.F(view) == 0) {
                        z.i(view, 1);
                    }
                    if (!z.C(view)) {
                        z.a(view, this.UQ.UI.Wj);
                    }
                }
                if (this.UQ.UB.VL) {
                    d.VY = i;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            LayoutParams layoutParams2 = d.VU.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) this.UQ.generateDefaultLayoutParams();
                d.VU.setLayoutParams(layoutParams);
            } else if (this.UQ.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) this.UQ.generateLayoutParams(layoutParams2);
                d.VU.setLayoutParams(layoutParams);
            }
            layoutParams.Vh = d;
            if (!(z4 && r1)) {
                z = false;
            }
            layoutParams.Vj = z;
            return d.VU;
        }

        private void c(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void bm(View view) {
            t aY = RecyclerView.aY(view);
            if (aY.gm()) {
                this.UQ.removeDetachedView(view, false);
            }
            if (aY.gf()) {
                aY.gg();
            } else if (aY.gh()) {
                aY.gi();
            }
            n(aY);
        }

        final void fV() {
            for (int size = this.Vp.size() - 1; size >= 0; size--) {
                bs(size);
            }
            this.Vp.clear();
        }

        final void bs(int i) {
            o((t) this.Vp.get(i));
            this.Vp.remove(i);
        }

        final void n(t tVar) {
            boolean z = true;
            int i = 0;
            if (tVar.gf() || tVar.VU.getParent() != null) {
                StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(tVar.gf()).append(" isAttached:");
                if (tVar.VU.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (tVar.gm()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + tVar);
            } else if (tVar.gb()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                boolean s = t.s(tVar);
                if (this.UQ.TU != null && s) {
                    this.UQ.TU;
                }
                if (tVar.gq()) {
                    boolean z2;
                    if (!tVar.bv(14)) {
                        int size = this.Vp.size();
                        if (size == this.Vr && size > 0) {
                            bs(0);
                        }
                        if (size < this.Vr) {
                            this.Vp.add(tVar);
                            z2 = true;
                            if (z2) {
                                o(tVar);
                                i = 1;
                                z = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        o(tVar);
                        i = 1;
                        z = z2;
                    }
                } else {
                    z = false;
                }
                this.UQ.TR.F(tVar);
                if (!z && r1 == 0 && s) {
                    tVar.Wi = null;
                }
            }
        }

        private void o(t tVar) {
            z.a(tVar.VU, null);
            if (this.UQ.TW != null) {
                this.UQ.TW;
            }
            if (this.UQ.TU != null) {
                this.UQ.TU.a(tVar);
            }
            if (this.UQ.UB != null) {
                this.UQ.TR.F(tVar);
            }
            tVar.Wi = null;
            l fW = fW();
            int i = tVar.VX;
            ArrayList arrayList = (ArrayList) fW.Vk.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                fW.Vk.put(i, arrayList);
                if (fW.Vl.indexOfKey(i) < 0) {
                    fW.Vl.put(i, 5);
                }
            }
            if (fW.Vl.get(i) > arrayList.size()) {
                tVar.gp();
                arrayList.add(tVar);
            }
        }

        final void bn(View view) {
            t aY = RecyclerView.aY(view);
            t.t(aY);
            t.u(aY);
            aY.gi();
            n(aY);
        }

        final void bo(View view) {
            t aY = RecyclerView.aY(view);
            if (!aY.bv(12) && aY.gr() && !RecyclerView.a(this.UQ, aY)) {
                if (this.Vo == null) {
                    this.Vo = new ArrayList();
                }
                aY.a(this, true);
                this.Vo.add(aY);
            } else if (!aY.gk() || aY.isRemoved() || this.UQ.TU.US) {
                aY.a(this, false);
                this.Vn.add(aY);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        final void p(t tVar) {
            if (t.v(tVar)) {
                this.Vo.remove(tVar);
            } else {
                this.Vn.remove(tVar);
            }
            t.t(tVar);
            t.u(tVar);
            tVar.gi();
        }

        private t bt(int i) {
            int i2 = 0;
            if (this.Vo != null) {
                int size = this.Vo.size();
                if (size != 0) {
                    t tVar;
                    int i3 = 0;
                    while (i3 < size) {
                        tVar = (t) this.Vo.get(i3);
                        if (tVar.gh() || tVar.gd() != i) {
                            i3++;
                        } else {
                            tVar.addFlags(32);
                            return tVar;
                        }
                    }
                    if (this.UQ.TU.US) {
                        int w = this.UQ.TP.w(i, 0);
                        if (w > 0 && w < this.UQ.TU.getItemCount()) {
                            long itemId = this.UQ.TU.getItemId(w);
                            while (i2 < size) {
                                tVar = (t) this.Vo.get(i2);
                                if (tVar.gh() || tVar.VW != itemId) {
                                    i2++;
                                } else {
                                    tVar.addFlags(32);
                                    return tVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private t h(int i, boolean z) {
            View view;
            int i2 = 0;
            int size = this.Vn.size();
            int i3 = 0;
            while (i3 < size) {
                t tVar = (t) this.Vn.get(i3);
                if (tVar.gh() || tVar.gd() != i || tVar.gk() || (!this.UQ.UB.VL && tVar.isRemoved())) {
                    i3++;
                } else {
                    tVar.addFlags(32);
                    return tVar;
                }
            }
            s sVar = this.UQ.TQ;
            int size2 = sVar.QD.size();
            for (i3 = 0; i3 < size2; i3++) {
                View view2 = (View) sVar.QD.get(i3);
                t aP = sVar.QB.aP(view2);
                if (aP.gd() == i && !aP.gk() && !aP.isRemoved()) {
                    view = view2;
                    break;
                }
            }
            view = null;
            if (view != null) {
                tVar = RecyclerView.aY(view);
                s sVar2 = this.UQ.TQ;
                i2 = sVar2.QB.indexOfChild(view);
                if (i2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                } else if (sVar2.QC.get(i2)) {
                    sVar2.QC.clear(i2);
                    sVar2.aN(view);
                    int indexOfChild = this.UQ.TQ.indexOfChild(view);
                    if (indexOfChild == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + tVar);
                    }
                    this.UQ.TQ.detachViewFromParent(indexOfChild);
                    bo(view);
                    tVar.addFlags(8224);
                    return tVar;
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                }
            }
            i3 = this.Vp.size();
            while (i2 < i3) {
                tVar = (t) this.Vp.get(i2);
                if (tVar.gk() || tVar.gd() != i) {
                    i2++;
                } else {
                    this.Vp.remove(i2);
                    return tVar;
                }
            }
            return null;
        }

        private t a(long j, int i, boolean z) {
            int size;
            for (size = this.Vn.size() - 1; size >= 0; size--) {
                t tVar = (t) this.Vn.get(size);
                if (tVar.VW == j && !tVar.gh()) {
                    if (i == tVar.VX) {
                        tVar.addFlags(32);
                        if (!tVar.isRemoved() || this.UQ.UB.VL) {
                            return tVar;
                        }
                        tVar.setFlags(2, 14);
                        return tVar;
                    }
                    this.Vn.remove(size);
                    this.UQ.removeDetachedView(tVar.VU, false);
                    bn(tVar.VU);
                }
            }
            for (size = this.Vp.size() - 1; size >= 0; size--) {
                tVar = (t) this.Vp.get(size);
                if (tVar.VW == j) {
                    if (i == tVar.VX) {
                        this.Vp.remove(size);
                        return tVar;
                    }
                    bs(size);
                }
            }
            return null;
        }

        final l fW() {
            if (this.Vs == null) {
                this.Vs = new l();
            }
            return this.Vs;
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        recyclerView.f(tVar);
        tVar.T(false);
        if (recyclerView.Ur.d(tVar, cVar, cVar2)) {
            recyclerView.fC();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        aY(view);
        if (recyclerView.Uk != null) {
            for (int size = recyclerView.Uk.size() - 1; size >= 0; size--) {
                recyclerView.Uk.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, t tVar) {
        return recyclerView.Ur == null || recyclerView.Ur.a(tVar, tVar.go());
    }

    static /* synthetic */ void b(RecyclerView recyclerView, t tVar, c cVar, c cVar2) {
        tVar.T(false);
        if (recyclerView.Ur.e(tVar, cVar, cVar2)) {
            recyclerView.fC();
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        boolean z;
        boolean z2 = true;
        recyclerView.fo();
        s sVar = recyclerView.TQ;
        int indexOfChild = sVar.QB.indexOfChild(view);
        if (indexOfChild == -1) {
            sVar.aN(view);
            z = true;
        } else if (sVar.QC.get(indexOfChild)) {
            sVar.QC.aV(indexOfChild);
            sVar.aN(view);
            sVar.QB.removeViewAt(indexOfChild);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            t aY = aY(view);
            recyclerView.TN.p(aY);
            recyclerView.TN.n(aY);
        }
        if (z) {
            z2 = false;
        }
        recyclerView.Q(z2);
        return z;
    }

    static /* synthetic */ void d(RecyclerView recyclerView, int i) {
        if (recyclerView.TV != null) {
            recyclerView.TV.be(i);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ void n(RecyclerView recyclerView) {
        if (!recyclerView.Ul) {
            int i;
            recyclerView.Ul = true;
            int eF = recyclerView.TQ.eF();
            for (i = 0; i < eF; i++) {
                t aY = aY(recyclerView.TQ.aU(i));
                if (!(aY == null || aY.gb())) {
                    aY.addFlags(WXMediaMessage.TITLE_LENGTH_LIMIT);
                }
            }
            m mVar = recyclerView.TN;
            int size = mVar.Vp.size();
            for (i = 0; i < size; i++) {
                t tVar = (t) mVar.Vp.get(i);
                if (tVar != null) {
                    tVar.addFlags(WXMediaMessage.TITLE_LENGTH_LIMIT);
                }
            }
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        TJ = z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        TK = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2 = true;
        super(context, attributeSet, i);
        this.TM = new o(this, (byte) 0);
        this.TN = new m(this);
        this.TR = new as();
        this.TT = new Runnable(this) {
            final /* synthetic */ RecyclerView UQ;

            {
                this.UQ = r1;
            }

            public final void run() {
                if (this.UQ.Uc && !this.UQ.isLayoutRequested()) {
                    if (this.UQ.Uf) {
                        this.UQ.Ue = true;
                    } else {
                        this.UQ.fn();
                    }
                }
            }
        };
        this.ey = new Rect();
        this.TX = new ArrayList();
        this.TY = new ArrayList();
        this.Ud = 0;
        this.Ul = false;
        this.Um = 0;
        this.Ur = new v();
        this.yi = 0;
        this.Us = -1;
        this.Uz = Float.MIN_VALUE;
        this.UA = new s(this);
        this.UB = new q();
        this.UE = false;
        this.UF = false;
        this.UG = new f(this, (byte) 0);
        this.UH = false;
        this.UK = new int[2];
        this.Do = new int[2];
        this.Dp = new int[2];
        this.UM = new int[2];
        this.UN = new Runnable(this) {
            final /* synthetic */ RecyclerView UQ;

            {
                this.UQ = r1;
            }

            public final void run() {
                if (this.UQ.Ur != null) {
                    this.UQ.Ur.eI();
                }
                this.UQ.UH = false;
            }
        };
        this.UP = new 4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.Uj = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iN = viewConfiguration.getScaledTouchSlop();
        this.Ux = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Uy = viewConfiguration.getScaledMaximumFlingVelocity();
        if (z.B(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.Ur.UT = this.UG;
        this.TP = new e(new 6(this));
        this.TQ = new s(new 5(this));
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        this.ju = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.UI = new ac(this);
        z.a(this, this.UI);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.da, i, 0);
            String string = obtainStyledAttributes.getString(c.Js);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    string = trim.charAt(0) == '.' ? context.getPackageName() + trim : trim.contains(".") ? trim : RecyclerView.class.getPackage().getName() + '.' + trim;
                    try {
                        Object[] objArr;
                        Constructor constructor;
                        Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(string).asSubclass(h.class);
                        try {
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(0)};
                            constructor = asSubclass.getConstructor(TL);
                        } catch (Throwable e) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        }
                        constructor.setAccessible(true);
                        a((h) constructor.newInstance(objArr));
                    } catch (Throwable e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string, e2);
                    } catch (Throwable e3) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string, e3);
                    } catch (Throwable e32) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e32);
                    } catch (Throwable e322) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string, e322);
                    } catch (Throwable e3222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string, e3222);
                    } catch (Throwable e32222) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string, e32222);
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, TI, i, 0);
                z2 = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public void setClipToPadding(boolean z) {
        if (z != this.TS) {
            fv();
        }
        this.TS = z;
        super.setClipToPadding(z);
        if (this.Uc) {
            requestLayout();
        }
    }

    public void a(a aVar) {
        R(false);
        if (this.TU != null) {
            this.TU.b(this.TM);
        }
        if (this.Ur != null) {
            this.Ur.eK();
        }
        if (this.TV != null) {
            this.TV.d(this.TN);
            this.TV.c(this.TN);
        }
        this.TN.clear();
        this.TP.reset();
        a aVar2 = this.TU;
        this.TU = aVar;
        if (aVar != null) {
            aVar.a(this.TM);
        }
        m mVar = this.TN;
        a aVar3 = this.TU;
        mVar.clear();
        l fW = mVar.fW();
        if (aVar2 != null) {
            fW.Vm--;
        }
        if (fW.Vm == 0) {
            fW.Vk.clear();
        }
        if (aVar3 != null) {
            fW.Vm++;
        }
        this.UB.VK = true;
        fK();
        requestLayout();
    }

    public a fm() {
        return this.TU;
    }

    public int getBaseline() {
        if (this.TV != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void a(h hVar) {
        if (hVar != this.TV) {
            fp();
            if (this.TV != null) {
                if (this.Ua) {
                    this.TV.b(this, this.TN);
                }
                this.TV.y(null);
            }
            this.TN.clear();
            s sVar = this.TQ;
            a aVar = sVar.QC;
            while (true) {
                aVar.QE = 0;
                if (aVar.QF == null) {
                    break;
                }
                aVar = aVar.QF;
            }
            for (int size = sVar.QD.size() - 1; size >= 0; size--) {
                sVar.QB.aR((View) sVar.QD.get(size));
                sVar.QD.remove(size);
            }
            sVar.QB.removeAllViews();
            this.TV = hVar;
            if (hVar != null) {
                if (hVar.Va != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView: " + hVar.Va);
                }
                this.TV.y(this);
                if (this.Ua) {
                    this.TV.hq = true;
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.TO != null) {
            SavedState.a(savedState, this.TO);
        } else if (this.TV != null) {
            savedState.Vu = this.TV.onSaveInstanceState();
        } else {
            savedState.Vu = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.TO = (SavedState) parcelable;
            super.onRestoreInstanceState(this.TO.getSuperState());
            if (this.TV != null && this.TO.Vu != null) {
                this.TV.onRestoreInstanceState(this.TO.Vu);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void f(t tVar) {
        View view = tVar.VU;
        boolean z = view.getParent() == this;
        this.TN.p(aP(view));
        if (tVar.gm()) {
            this.TQ.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            s sVar = this.TQ;
            int indexOfChild = sVar.QB.indexOfChild(view);
            if (indexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            sVar.QC.set(indexOfChild);
            sVar.aM(view);
        } else {
            this.TQ.a(view, -1, true);
        }
    }

    private void ag(int i) {
        if (i != this.yi) {
            this.yi = i;
            if (i != 2) {
                fq();
            }
            if (this.TV != null) {
                this.TV.bp(i);
            }
            if (this.UC != null) {
                this.UC.e(this, i);
            }
            if (this.UD != null) {
                for (int size = this.UD.size() - 1; size >= 0; size--) {
                    ((k) this.UD.get(size)).e(this, i);
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.TV != null) {
            this.TV.w("Cannot add item decoration during a scroll  or layout");
        }
        if (this.TX.isEmpty()) {
            setWillNotDraw(false);
        }
        this.TX.add(gVar);
        fI();
        requestLayout();
    }

    public final void a(d dVar) {
        if (dVar != this.UJ) {
            this.UJ = dVar;
            setChildrenDrawingOrderEnabled(this.UJ != null);
        }
    }

    public final void a(k kVar) {
        if (this.UD == null) {
            this.UD = new ArrayList();
        }
        this.UD.add(kVar);
    }

    public void be(int i) {
        if (!this.Uf) {
            fp();
            if (this.TV != null) {
                this.TV.be(i);
                awakenScrollBars();
            }
        }
    }

    public final void smoothScrollToPosition(int i) {
        if (!this.Uf && this.TV != null) {
            this.TV.a(this, i);
        }
    }

    public void scrollTo(int i, int i2) {
    }

    public void scrollBy(int i, int i2) {
        if (this.TV != null && !this.Uf) {
            boolean eQ = this.TV.eQ();
            boolean eR = this.TV.eR();
            if (eQ || eR) {
                if (!eQ) {
                    i = 0;
                }
                if (!eR) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    private void fn() {
        boolean z = false;
        if (!this.Uc) {
            return;
        }
        if (this.Ul) {
            e.beginSection("RV FullInvalidate");
            fF();
            e.endSection();
        } else if (!this.TP.et()) {
        } else {
            if (this.TP.aO(4) && !this.TP.aO(11)) {
                e.beginSection("RV PartialInvalidate");
                fo();
                this.TP.er();
                if (!this.Ue) {
                    int childCount = this.TQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        t aY = aY(this.TQ.getChildAt(i));
                        if (aY != null && !aY.gb() && aY.gr()) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        fF();
                    } else {
                        this.TP.es();
                    }
                }
                Q(true);
                e.endSection();
            } else if (this.TP.et()) {
                e.beginSection("RV FullInvalidate");
                fF();
                e.endSection();
            }
        }
    }

    private boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        fn();
        if (this.TU != null) {
            fo();
            fy();
            e.beginSection("RV Scroll");
            if (i != 0) {
                i5 = this.TV.a(i, this.TN, this.UB);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.TV.b(i2, this.TN, this.UB);
                i4 = i2 - i6;
            }
            e.endSection();
            fL();
            fz();
            Q(false);
        }
        int i7 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.TX.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i7, this.Do)) {
            this.Uv -= this.Do[0];
            this.Uw -= this.Do[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.Do[0], (float) this.Do[1]);
            }
            int[] iArr = this.UM;
            iArr[0] = iArr[0] + this.Do[0];
            iArr = this.UM;
            iArr[1] = iArr[1] + this.Do[1];
        } else if (z.B(this) != 2) {
            if (motionEvent != null) {
                float x = motionEvent.getX();
                float f = (float) i3;
                float y = motionEvent.getY();
                float f2 = (float) i7;
                Object obj = null;
                if (f < 0.0f) {
                    fr();
                    if (this.Un.h((-f) / ((float) getWidth()), 1.0f - (y / ((float) getHeight())))) {
                        obj = 1;
                    }
                } else if (f > 0.0f) {
                    fs();
                    if (this.Up.h(f / ((float) getWidth()), y / ((float) getHeight()))) {
                        obj = 1;
                    }
                }
                if (f2 < 0.0f) {
                    ft();
                    if (this.Uo.h((-f2) / ((float) getHeight()), x / ((float) getWidth()))) {
                        obj = 1;
                    }
                } else if (f2 > 0.0f) {
                    fu();
                    if (this.Uq.h(f2 / ((float) getHeight()), 1.0f - (x / ((float) getWidth())))) {
                        obj = 1;
                    }
                }
                if (!(obj == null && f == 0.0f && f2 == 0.0f)) {
                    z.E(this);
                }
            }
            R(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            T(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        if (this.TV != null && this.TV.eQ()) {
            return this.TV.b(this.UB);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        if (this.TV != null && this.TV.eQ()) {
            return this.TV.d(this.UB);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        if (this.TV != null && this.TV.eQ()) {
            return this.TV.f(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.c(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.e(this.UB);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        if (this.TV != null && this.TV.eR()) {
            return this.TV.g(this.UB);
        }
        return 0;
    }

    final void fo() {
        this.Ud++;
        if (this.Ud == 1 && !this.Uf) {
            this.Ue = false;
        }
    }

    final void Q(boolean z) {
        if (this.Ud <= 0) {
            this.Ud = 1;
        }
        if (!z) {
            this.Ue = false;
        }
        if (this.Ud == 1) {
            if (!(!z || !this.Ue || this.Uf || this.TV == null || this.TU == null)) {
                fF();
            }
            if (!this.Uf) {
                this.Ue = false;
            }
        }
        this.Ud--;
    }

    public final void R(boolean z) {
        if (z != this.Uf) {
            w("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.Uf = true;
                this.Ug = true;
                fp();
                return;
            }
            this.Uf = false;
            if (!(!this.Ue || this.TV == null || this.TU == null)) {
                requestLayout();
            }
            this.Ue = false;
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        int i3 = 0;
        if (this.TV != null && !this.Uf) {
            if (!this.TV.eQ()) {
                i = 0;
            }
            if (this.TV.eR()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.UA.smoothScrollBy(i, i3);
            }
        }
    }

    public boolean Q(int i, int i2) {
        if (this.TV == null || this.Uf) {
            return false;
        }
        boolean eQ = this.TV.eQ();
        boolean eR = this.TV.eR();
        if (!eQ || Math.abs(i) < this.Ux) {
            i = 0;
        }
        if (!eR || Math.abs(i2) < this.Ux) {
            i2 = 0;
        }
        if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
            return false;
        }
        eQ = eQ || eR;
        dispatchNestedFling((float) i, (float) i2, eQ);
        if (!eQ) {
            return false;
        }
        int max = Math.max(-this.Uy, Math.min(i, this.Uy));
        int max2 = Math.max(-this.Uy, Math.min(i2, this.Uy));
        s sVar = this.UA;
        sVar.UQ.ag(2);
        sVar.VR = 0;
        sVar.VQ = 0;
        sVar.iK.b(0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        sVar.fZ();
        return true;
    }

    private void fp() {
        ag(0);
        fq();
    }

    private void fq() {
        this.UA.stop();
        if (this.TV != null) {
            this.TV.fU();
        }
    }

    private void R(int i, int i2) {
        int i3 = 0;
        if (!(this.Un == null || this.Un.isFinished() || i <= 0)) {
            i3 = this.Un.cv();
        }
        if (!(this.Up == null || this.Up.isFinished() || i >= 0)) {
            i3 |= this.Up.cv();
        }
        if (!(this.Uo == null || this.Uo.isFinished() || i2 <= 0)) {
            i3 |= this.Uo.cv();
        }
        if (!(this.Uq == null || this.Uq.isFinished() || i2 >= 0)) {
            i3 |= this.Uq.cv();
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    final void fr() {
        if (this.Un == null) {
            this.Un = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Un.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Un.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void fs() {
        if (this.Up == null) {
            this.Up = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Up.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.Up.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    final void ft() {
        if (this.Uo == null) {
            this.Uo = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Uo.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Uo.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    final void fu() {
        if (this.Uq == null) {
            this.Uq = new android.support.v4.widget.i(getContext());
            if (this.TS) {
                this.Uq.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.Uq.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void fv() {
        this.Uq = null;
        this.Uo = null;
        this.Up = null;
        this.Un = null;
    }

    public View focusSearch(View view, int i) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(findNextFocus != null || this.TU == null || this.TV == null || fB() || this.Uf)) {
            fo();
            findNextFocus = this.TV.a(view, i, this.TN, this.UB);
            Q(false);
        }
        return findNextFocus != null ? findNextFocus : super.focusSearch(view, i);
    }

    public void requestChildFocus(View view, View view2) {
        int i = (this.TV.fT() || fB()) ? 1 : 0;
        if (i == 0 && view2 != null) {
            this.ey.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.Vi) {
                    Rect rect = layoutParams2.RC;
                    Rect rect2 = this.ey;
                    rect2.left -= rect.left;
                    rect2 = this.ey;
                    rect2.right += rect.right;
                    rect2 = this.ey;
                    rect2.top -= rect.top;
                    rect2 = this.ey;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.ey);
            offsetRectIntoDescendantCoords(view, this.ey);
            requestChildRectangleOnScreen(view, this.ey, !this.Uc);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        h hVar = this.TV;
        int paddingLeft = hVar.getPaddingLeft();
        int paddingTop = hVar.getPaddingTop();
        int paddingRight = hVar.mWidth - hVar.getPaddingRight();
        int paddingBottom = hVar.mHeight - hVar.getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = left + rect.width();
        int height = top + rect.height();
        int min = Math.min(0, left - paddingLeft);
        int min2 = Math.min(0, top - paddingTop);
        int max = Math.max(0, width - paddingRight);
        paddingBottom = Math.max(0, height - paddingBottom);
        if (z.I(hVar.Va) == 1) {
            if (max == 0) {
                max = Math.max(min, width - paddingRight);
            }
            min = max;
        } else {
            min = min != 0 ? min : Math.min(left - paddingLeft, max);
        }
        max = min2 != 0 ? min2 : Math.min(top - paddingTop, paddingBottom);
        if (min == 0 && max == 0) {
            return false;
        }
        if (z) {
            scrollBy(min, max);
        } else {
            smoothScrollBy(min, max);
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Um = 0;
        this.Ua = true;
        this.Uc = false;
        if (this.TV != null) {
            this.TV.hq = true;
        }
        this.UH = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Ur != null) {
            this.Ur.eK();
        }
        this.Uc = false;
        fp();
        this.Ua = false;
        if (this.TV != null) {
            this.TV.b(this, this.TN);
        }
        removeCallbacks(this.UN);
        as.a.he();
    }

    public boolean isAttachedToWindow() {
        return this.Ua;
    }

    final void w(String str) {
        if (!fB()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.Uf) {
            return false;
        }
        int i2;
        boolean z;
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.TZ = null;
        }
        int size = this.TY.size();
        for (i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.TY.get(i2);
            if (jVar.n(motionEvent) && action != 3) {
                this.TZ = jVar;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            fx();
            return true;
        } else if (this.TV == null) {
            return false;
        } else {
            z = this.TV.eQ();
            boolean eR = this.TV.eR();
            if (this.ft == null) {
                this.ft = VelocityTracker.obtain();
            }
            this.ft.addMovement(motionEvent);
            action = o.d(motionEvent);
            size = o.e(motionEvent);
            int i3;
            switch (action) {
                case 0:
                    if (this.Ug) {
                        this.Ug = false;
                    }
                    this.Us = o.c(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.Uv = i;
                    this.Ut = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.Uw = i;
                    this.Uu = i;
                    if (this.yi == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        ag(1);
                    }
                    int[] iArr = this.UM;
                    this.UM[1] = 0;
                    iArr[0] = 0;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (eR) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3);
                    break;
                case 1:
                    this.ft.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    action = o.b(motionEvent, this.Us);
                    if (action >= 0) {
                        size = (int) (o.d(motionEvent, action) + 0.5f);
                        action = (int) (o.e(motionEvent, action) + 0.5f);
                        if (this.yi != 1) {
                            size -= this.Ut;
                            action -= this.Uu;
                            if (!z || Math.abs(size) <= this.iN) {
                                z = false;
                            } else {
                                this.Uv = ((size < 0 ? -1 : 1) * this.iN) + this.Ut;
                                z = true;
                            }
                            if (eR && Math.abs(action) > this.iN) {
                                i3 = this.Uu;
                                i2 = this.iN;
                                if (action >= 0) {
                                    i = 1;
                                }
                                this.Uw = i3 + (i * i2);
                                z = true;
                            }
                            if (z) {
                                ag(1);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fx();
                    break;
                case 5:
                    this.Us = o.c(motionEvent, size);
                    i3 = (int) (o.d(motionEvent, size) + 0.5f);
                    this.Uv = i3;
                    this.Ut = i3;
                    i3 = (int) (o.e(motionEvent, size) + 0.5f);
                    this.Uw = i3;
                    this.Uu = i3;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (this.yi != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.TY.size();
        for (int i = 0; i < size; i++) {
            ((j) this.TY.get(i)).S(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Uf || this.Ug) {
            return false;
        }
        boolean z2;
        boolean eQ;
        boolean eR;
        MotionEvent obtain;
        int e;
        float f;
        int d;
        int e2;
        int i;
        boolean z3;
        int action = motionEvent.getAction();
        if (this.TZ != null) {
            if (action == 0) {
                this.TZ = null;
            } else {
                this.TZ.o(motionEvent);
                if (action == 3 || action == 1) {
                    this.TZ = null;
                }
                z2 = true;
                if (z2) {
                    fx();
                    return true;
                } else if (this.TV != null) {
                    return false;
                } else {
                    eQ = this.TV.eQ();
                    eR = this.TV.eR();
                    if (this.ft == null) {
                        this.ft = VelocityTracker.obtain();
                    }
                    obtain = MotionEvent.obtain(motionEvent);
                    action = o.d(motionEvent);
                    e = o.e(motionEvent);
                    if (action == 0) {
                        int[] iArr = this.UM;
                        this.UM[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.UM[0], (float) this.UM[1]);
                    switch (action) {
                        case 0:
                            this.Us = o.c(motionEvent, 0);
                            action = (int) (motionEvent.getX() + 0.5f);
                            this.Uv = action;
                            this.Ut = action;
                            action = (int) (motionEvent.getY() + 0.5f);
                            this.Uw = action;
                            this.Uu = action;
                            if (eQ) {
                                action = 0;
                            } else {
                                action = 1;
                            }
                            if (eR) {
                                action |= 2;
                            }
                            startNestedScroll(action);
                            break;
                        case 1:
                            this.ft.addMovement(obtain);
                            this.ft.computeCurrentVelocity(1000, (float) this.Uy);
                            float f2 = eQ ? -y.a(this.ft, this.Us) : 0.0f;
                            if (eR) {
                                f = 0.0f;
                            } else {
                                f = -y.b(this.ft, this.Us);
                            }
                            if ((f2 == 0.0f && r0 == 0.0f) || !Q((int) f2, (int) r0)) {
                                ag(0);
                            }
                            fw();
                            z = true;
                            break;
                        case 2:
                            action = o.b(motionEvent, this.Us);
                            if (action < 0) {
                                d = (int) (o.d(motionEvent, action) + 0.5f);
                                e2 = (int) (o.e(motionEvent, action) + 0.5f);
                                i = this.Uv - d;
                                action = this.Uw - e2;
                                if (dispatchNestedPreScroll(i, action, this.Dp, this.Do)) {
                                    i -= this.Dp[0];
                                    action -= this.Dp[1];
                                    obtain.offsetLocation((float) this.Do[0], (float) this.Do[1]);
                                    int[] iArr2 = this.UM;
                                    iArr2[0] = iArr2[0] + this.Do[0];
                                    iArr2 = this.UM;
                                    iArr2[1] = iArr2[1] + this.Do[1];
                                }
                                if (this.yi != 1) {
                                    if (eQ || Math.abs(i) <= this.iN) {
                                        z3 = false;
                                    } else {
                                        if (i > 0) {
                                            i -= this.iN;
                                        } else {
                                            i += this.iN;
                                        }
                                        z3 = true;
                                    }
                                    if (eR && Math.abs(action) > this.iN) {
                                        if (action <= 0) {
                                            action -= this.iN;
                                        } else {
                                            action += this.iN;
                                        }
                                        z3 = true;
                                    }
                                    if (z3) {
                                        ag(1);
                                    }
                                }
                                if (this.yi == 1) {
                                    this.Uv = d - this.Do[0];
                                    this.Uw = e2 - this.Do[1];
                                    if (!eQ) {
                                        i = 0;
                                    }
                                    if (!eR) {
                                        action = 0;
                                    }
                                    if (a(i, action, obtain)) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                        break;
                                    }
                                }
                            }
                            new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                            return false;
                            break;
                        case 3:
                            fx();
                            break;
                        case 5:
                            this.Us = o.c(motionEvent, e);
                            action = (int) (o.d(motionEvent, e) + 0.5f);
                            this.Uv = action;
                            this.Ut = action;
                            action = (int) (o.e(motionEvent, e) + 0.5f);
                            this.Uw = action;
                            this.Uu = action;
                            break;
                        case 6:
                            m(motionEvent);
                            break;
                    }
                    if (!z) {
                        this.ft.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        if (action != 0) {
            int size = this.TY.size();
            for (e = 0; e < size; e++) {
                j jVar = (j) this.TY.get(e);
                if (jVar.n(motionEvent)) {
                    this.TZ = jVar;
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            fx();
            return true;
        } else if (this.TV != null) {
            return false;
        } else {
            eQ = this.TV.eQ();
            eR = this.TV.eR();
            if (this.ft == null) {
                this.ft = VelocityTracker.obtain();
            }
            obtain = MotionEvent.obtain(motionEvent);
            action = o.d(motionEvent);
            e = o.e(motionEvent);
            if (action == 0) {
                int[] iArr3 = this.UM;
                this.UM[1] = 0;
                iArr3[0] = 0;
            }
            obtain.offsetLocation((float) this.UM[0], (float) this.UM[1]);
            switch (action) {
                case 0:
                    this.Us = o.c(motionEvent, 0);
                    action = (int) (motionEvent.getX() + 0.5f);
                    this.Uv = action;
                    this.Ut = action;
                    action = (int) (motionEvent.getY() + 0.5f);
                    this.Uw = action;
                    this.Uu = action;
                    if (eQ) {
                        action = 0;
                    } else {
                        action = 1;
                    }
                    if (eR) {
                        action |= 2;
                    }
                    startNestedScroll(action);
                    break;
                case 1:
                    this.ft.addMovement(obtain);
                    this.ft.computeCurrentVelocity(1000, (float) this.Uy);
                    if (eQ) {
                    }
                    if (eR) {
                        f = 0.0f;
                    } else {
                        f = -y.b(this.ft, this.Us);
                    }
                    ag(0);
                    fw();
                    z = true;
                    break;
                case 2:
                    action = o.b(motionEvent, this.Us);
                    if (action < 0) {
                        d = (int) (o.d(motionEvent, action) + 0.5f);
                        e2 = (int) (o.e(motionEvent, action) + 0.5f);
                        i = this.Uv - d;
                        action = this.Uw - e2;
                        if (dispatchNestedPreScroll(i, action, this.Dp, this.Do)) {
                            i -= this.Dp[0];
                            action -= this.Dp[1];
                            obtain.offsetLocation((float) this.Do[0], (float) this.Do[1]);
                            int[] iArr22 = this.UM;
                            iArr22[0] = iArr22[0] + this.Do[0];
                            iArr22 = this.UM;
                            iArr22[1] = iArr22[1] + this.Do[1];
                        }
                        if (this.yi != 1) {
                            if (eQ) {
                                break;
                            }
                            z3 = false;
                            if (action <= 0) {
                                action += this.iN;
                            } else {
                                action -= this.iN;
                            }
                            z3 = true;
                            if (z3) {
                                ag(1);
                            }
                            break;
                        }
                        if (this.yi == 1) {
                            this.Uv = d - this.Do[0];
                            this.Uw = e2 - this.Do[1];
                            if (eQ) {
                                i = 0;
                            }
                            if (eR) {
                                action = 0;
                            }
                            if (a(i, action, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    new StringBuilder("Error processing scroll; pointer index for id ").append(this.Us).append(" not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    fx();
                    break;
                case 5:
                    this.Us = o.c(motionEvent, e);
                    action = (int) (o.d(motionEvent, e) + 0.5f);
                    this.Uv = action;
                    this.Ut = action;
                    action = (int) (o.e(motionEvent, e) + 0.5f);
                    this.Uw = action;
                    this.Uu = action;
                    break;
                case 6:
                    m(motionEvent);
                    break;
            }
            if (z) {
                this.ft.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void fw() {
        if (this.ft != null) {
            this.ft.clear();
        }
        stopNestedScroll();
        int i = 0;
        if (this.Un != null) {
            i = this.Un.cv();
        }
        if (this.Uo != null) {
            i |= this.Uo.cv();
        }
        if (this.Up != null) {
            i |= this.Up.cv();
        }
        if (this.Uq != null) {
            i |= this.Uq.cv();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    private void fx() {
        fw();
        ag(0);
    }

    private void m(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.Us) {
            e = e == 0 ? 1 : 0;
            this.Us = o.c(motionEvent, e);
            int d = (int) (o.d(motionEvent, e) + 0.5f);
            this.Uv = d;
            this.Ut = d;
            e = (int) (o.e(motionEvent, e) + 0.5f);
            this.Uw = e;
            this.Uu = e;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (!(this.TV == null || this.Uf || (o.g(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f2;
            float f3;
            if (this.TV.eR()) {
                f2 = -o.f(motionEvent, 9);
            } else {
                f2 = 0.0f;
            }
            if (this.TV.eQ()) {
                f3 = o.f(motionEvent, 10);
            } else {
                f3 = 0.0f;
            }
            if (!(f2 == 0.0f && f3 == 0.0f)) {
                if (this.Uz == Float.MIN_VALUE) {
                    TypedValue typedValue = new TypedValue();
                    if (getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                        this.Uz = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
                    }
                    a((int) (f3 * f), (int) (f2 * f), motionEvent);
                }
                f = this.Uz;
                a((int) (f3 * f), (int) (f2 * f), motionEvent);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.TV == null) {
            S(i, i2);
        } else if (h.b(this.TV)) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.TV.af(i, i2);
            if (!z && this.TU != null) {
                if (this.UB.VF == 1) {
                    fG();
                }
                this.TV.ad(i, i2);
                this.UB.VP = true;
                fH();
                this.TV.ae(i, i2);
                if (this.TV.eW()) {
                    this.TV.ad(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.UB.VP = true;
                    fH();
                    this.TV.ae(i, i2);
                }
            }
        } else if (this.Ub) {
            this.TV.af(i, i2);
        } else {
            if (this.Ui) {
                fo();
                fE();
                if (this.UB.VN) {
                    this.UB.VL = true;
                } else {
                    this.TP.eu();
                    this.UB.VL = false;
                }
                this.Ui = false;
                Q(false);
            }
            if (this.TU != null) {
                this.UB.VH = this.TU.getItemCount();
            } else {
                this.UB.VH = 0;
            }
            fo();
            this.TV.af(i, i2);
            Q(false);
            this.UB.VL = false;
        }
    }

    final void S(int i, int i2) {
        setMeasuredDimension(h.m(i, getPaddingLeft() + getPaddingRight(), z.S(this)), h.m(i2, getPaddingTop() + getPaddingBottom(), z.T(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            fv();
        }
    }

    public final void a(e eVar) {
        if (this.Ur != null) {
            this.Ur.eK();
            this.Ur.UT = null;
        }
        this.Ur = eVar;
        if (this.Ur != null) {
            this.Ur.UT = this.UG;
        }
    }

    private void fy() {
        this.Um++;
    }

    private void fz() {
        this.Um--;
        if (this.Um <= 0) {
            this.Um = 0;
            int i = this.Uh;
            this.Uh = 0;
            if (i != 0 && fA()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                android.support.v4.view.a.a.a(obtain, i);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    final boolean fA() {
        return this.ju != null && this.ju.isEnabled();
    }

    private boolean fB() {
        return this.Um > 0;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (fB()) {
            int b;
            if (accessibilityEvent != null) {
                b = android.support.v4.view.a.a.b(accessibilityEvent);
            } else {
                b = 0;
            }
            if (b != 0) {
                i = b;
            }
            this.Uh = i | this.Uh;
            i = 1;
        }
        if (i == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private void fC() {
        if (!this.UH && this.Ua) {
            z.a(this, this.UN);
            this.UH = true;
        }
    }

    private boolean fD() {
        return this.Ur != null && this.TV.eP();
    }

    private void fE() {
        boolean z;
        boolean z2 = true;
        if (this.Ul) {
            this.TP.reset();
            fK();
            this.TV.eL();
        }
        if (fD()) {
            this.TP.er();
        } else {
            this.TP.eu();
        }
        boolean z3;
        if (this.UE || this.UF) {
            z3 = true;
        } else {
            z3 = false;
        }
        q qVar = this.UB;
        if (!this.Uc || this.Ur == null || (!(this.Ul || r0 || h.c(this.TV)) || (this.Ul && !this.TU.US))) {
            z = false;
        } else {
            z = true;
        }
        qVar.VM = z;
        q qVar2 = this.UB;
        if (!(this.UB.VM && r0 && !this.Ul && fD())) {
            z2 = false;
        }
        qVar2.VN = z2;
    }

    private void fF() {
        if (this.TU != null && this.TV != null) {
            boolean z;
            int i;
            int i2;
            this.UB.VP = false;
            if (this.UB.VF == 1) {
                fG();
                this.TV.z(this);
                fH();
            } else {
                e eVar = this.TP;
                if (eVar.OT.isEmpty() || eVar.OS.isEmpty()) {
                    z = false;
                } else {
                    i = 1;
                }
                if (i == 0 && this.TV.mWidth == getWidth() && this.TV.mHeight == getHeight()) {
                    this.TV.z(this);
                } else {
                    this.TV.z(this);
                    fH();
                }
            }
            this.UB.bu(4);
            fo();
            fy();
            this.UB.VF = 1;
            if (this.UB.VM) {
                for (int childCount = this.TQ.getChildCount() - 1; childCount >= 0; childCount--) {
                    t aY = aY(this.TQ.getChildAt(childCount));
                    if (!aY.gb()) {
                        long g = g(aY);
                        c b = new c().b(aY, 0);
                        t tVar = (t) this.TR.aat.get(g);
                        if (!(tVar == null || tVar.gb())) {
                            boolean C = this.TR.C(tVar);
                            boolean C2 = this.TR.C(aY);
                            if (!(C && tVar == aY)) {
                                c c = this.TR.c(tVar, 4);
                                this.TR.c(aY, b);
                                b = this.TR.c(aY, 8);
                                if (c == null) {
                                    int childCount2 = this.TQ.getChildCount();
                                    i2 = 0;
                                    while (i2 < childCount2) {
                                        t aY2 = aY(this.TQ.getChildAt(i2));
                                        if (aY2 == aY || g(aY2) != g) {
                                            i2++;
                                        } else if (this.TU == null || !this.TU.US) {
                                            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        } else {
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + aY2 + " \n View Holder 2:" + aY);
                                        }
                                    }
                                    new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(tVar).append(" cannot be found but it is necessary for ").append(aY);
                                } else {
                                    tVar.T(false);
                                    if (C) {
                                        f(tVar);
                                    }
                                    if (tVar != aY) {
                                        if (C2) {
                                            f(aY);
                                        }
                                        tVar.VZ = aY;
                                        f(tVar);
                                        this.TN.p(tVar);
                                        aY.T(false);
                                        aY.Wa = tVar;
                                    }
                                    if (this.Ur.a(tVar, aY, c, b)) {
                                        fC();
                                    }
                                }
                            }
                        }
                        this.TR.c(aY, b);
                    }
                }
                this.TR.a(this.UP);
            }
            this.TV.c(this.TN);
            this.UB.VI = this.UB.VH;
            this.Ul = false;
            this.UB.VM = false;
            this.UB.VN = false;
            h.d(this.TV);
            if (this.TN.Vo != null) {
                this.TN.Vo.clear();
            }
            fz();
            Q(false);
            this.TR.clear();
            i = this.UK[0];
            i2 = this.UK[1];
            if (this.TQ.getChildCount() == 0) {
                z = (i == 0 && i2 == 0) ? false : true;
            } else {
                d(this.UK);
                z = (this.UK[0] == i && this.UK[1] == i2) ? false : true;
            }
            if (z) {
                T(0, 0);
            }
        }
    }

    private void fG() {
        int childCount;
        int i;
        t aY;
        this.UB.bu(1);
        this.UB.VP = false;
        fo();
        this.TR.clear();
        fy();
        fE();
        q qVar = this.UB;
        boolean z = this.UB.VM && this.UF;
        qVar.VO = z;
        this.UF = false;
        this.UE = false;
        this.UB.VL = this.UB.VN;
        this.UB.VH = this.TU.getItemCount();
        d(this.UK);
        if (this.UB.VM) {
            childCount = this.TQ.getChildCount();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.TQ.getChildAt(i));
                if (!aY.gb() && (!aY.gk() || this.TU.US)) {
                    this.TR.b(aY, this.Ur.a(this.UB, aY, e.j(aY), aY.go()));
                    if (!(!this.UB.VO || !aY.gr() || aY.isRemoved() || aY.gb() || aY.gk())) {
                        this.TR.a(g(aY), aY);
                    }
                }
            }
        }
        if (this.UB.VN) {
            childCount = this.TQ.eF();
            for (i = 0; i < childCount; i++) {
                aY = aY(this.TQ.aU(i));
                if (!aY.gb() && aY.VV == -1) {
                    aY.VV = aY.mPosition;
                }
            }
            z = this.UB.VK;
            this.UB.VK = false;
            this.TV.c(this.TN, this.UB);
            this.UB.VK = z;
            for (childCount = 0; childCount < this.TQ.getChildCount(); childCount++) {
                aY = aY(this.TQ.getChildAt(childCount));
                if (!aY.gb()) {
                    as.a aVar = (as.a) this.TR.aas.get(aY);
                    if (aVar == null || (aVar.flags & 4) == 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = e.j(aY);
                        boolean bv = aY.bv(8192);
                        if (!bv) {
                            i |= Downloads.RECV_BUFFER_SIZE;
                        }
                        c a = this.Ur.a(this.UB, aY, i, aY.go());
                        if (bv) {
                            a(aY, a);
                        } else {
                            as asVar = this.TR;
                            aVar = (as.a) asVar.aas.get(aY);
                            if (aVar == null) {
                                aVar = as.a.hd();
                                asVar.aas.put(aY, aVar);
                            }
                            aVar.flags |= 2;
                            aVar.aau = a;
                        }
                    }
                }
            }
            fJ();
        } else {
            fJ();
        }
        fz();
        Q(false);
        this.UB.VF = 2;
    }

    private void fH() {
        boolean z;
        fo();
        fy();
        this.UB.bu(6);
        this.TP.eu();
        this.UB.VH = this.TU.getItemCount();
        this.UB.VJ = 0;
        this.UB.VL = false;
        this.TV.c(this.TN, this.UB);
        this.UB.VK = false;
        this.TO = null;
        q qVar = this.UB;
        if (!this.UB.VM || this.Ur == null) {
            z = false;
        } else {
            z = true;
        }
        qVar.VM = z;
        this.UB.VF = 4;
        fz();
        Q(false);
    }

    private void a(t tVar, c cVar) {
        tVar.setFlags(0, 8192);
        if (this.UB.VO && tVar.gr() && !tVar.isRemoved() && !tVar.gb()) {
            this.TR.a(g(tVar), tVar);
        }
        this.TR.b(tVar, cVar);
    }

    private void d(int[] iArr) {
        int childCount = this.TQ.getChildCount();
        if (childCount == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < childCount) {
            int gd;
            t aY = aY(this.TQ.getChildAt(i3));
            if (!aY.gb()) {
                gd = aY.gd();
                if (gd < i) {
                    i = gd;
                }
                if (gd > i2) {
                    i2 = i;
                    i3++;
                    i = i2;
                    i2 = gd;
                }
            }
            gd = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = gd;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    protected void removeDetachedView(View view, boolean z) {
        t aY = aY(view);
        if (aY != null) {
            if (aY.gm()) {
                aY.gj();
            } else if (!aY.gb()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + aY);
            }
        }
        bc(view);
        super.removeDetachedView(view, z);
    }

    private long g(t tVar) {
        return this.TU.US ? tVar.VW : (long) tVar.mPosition;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e.beginSection("RV OnLayout");
        fF();
        e.endSection();
        this.Uc = true;
    }

    public void requestLayout() {
        if (this.Ud != 0 || this.Uf) {
            this.Ue = true;
        } else {
            super.requestLayout();
        }
    }

    public final void fI() {
        int i = 0;
        int eF = this.TQ.eF();
        for (int i2 = 0; i2 < eF; i2++) {
            ((LayoutParams) this.TQ.aU(i2).getLayoutParams()).Vi = true;
        }
        m mVar = this.TN;
        eF = mVar.Vp.size();
        while (i < eF) {
            LayoutParams layoutParams = (LayoutParams) ((t) mVar.Vp.get(i)).VU.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.Vi = true;
            }
            i++;
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.TX.size();
        for (i = 0; i < size; i++) {
            ((g) this.TX.get(i)).a(canvas, this);
        }
        if (this.Un == null || this.Un.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.TS ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.Un == null || !this.Un.draw(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.Uo == null || this.Uo.isFinished())) {
            size = canvas.save();
            if (this.TS) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.Uo == null || !this.Uo.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Up == null || this.Up.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            if (this.TS) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.Up == null || !this.Up.draw(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.Uq == null || this.Uq.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.TS) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.Uq != null && this.Uq.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.Ur == null || this.TX.size() <= 0 || !this.Ur.isRunning()) {
            i3 = i2;
        }
        if (i3 != 0) {
            z.E(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.TX.size();
        for (int i = 0; i < size; i++) {
            ((g) this.TX.get(i)).a(canvas, this, this.UB);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.TV.a((LayoutParams) layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.TV != null) {
            return this.TV.eM();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.TV != null) {
            return this.TV.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.TV != null) {
            return this.TV.e(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void fJ() {
        int i = 0;
        int eF = this.TQ.eF();
        for (int i2 = 0; i2 < eF; i2++) {
            t aY = aY(this.TQ.aU(i2));
            if (!aY.gb()) {
                aY.ga();
            }
        }
        m mVar = this.TN;
        int size = mVar.Vp.size();
        for (eF = 0; eF < size; eF++) {
            ((t) mVar.Vp.get(eF)).ga();
        }
        size = mVar.Vn.size();
        for (eF = 0; eF < size; eF++) {
            ((t) mVar.Vn.get(eF)).ga();
        }
        if (mVar.Vo != null) {
            eF = mVar.Vo.size();
            while (i < eF) {
                ((t) mVar.Vo.get(i)).ga();
                i++;
            }
        }
    }

    final void c(int i, int i2, boolean z) {
        int i3 = i + i2;
        int eF = this.TQ.eF();
        for (int i4 = 0; i4 < eF; i4++) {
            t aY = aY(this.TQ.aU(i4));
            if (!(aY == null || aY.gb())) {
                if (aY.mPosition >= i3) {
                    aY.i(-i2, z);
                    this.UB.VK = true;
                } else if (aY.mPosition >= i) {
                    int i5 = i - 1;
                    int i6 = -i2;
                    aY.addFlags(8);
                    aY.i(i6, z);
                    aY.mPosition = i5;
                    this.UB.VK = true;
                }
            }
        }
        m mVar = this.TN;
        int i7 = i + i2;
        for (i3 = mVar.Vp.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) mVar.Vp.get(i3);
            if (tVar != null) {
                if (tVar.mPosition >= i7) {
                    tVar.i(-i2, z);
                } else if (tVar.mPosition >= i) {
                    tVar.addFlags(8);
                    mVar.bs(i3);
                }
            }
        }
        requestLayout();
    }

    private void fK() {
        int i;
        int eF = this.TQ.eF();
        for (i = 0; i < eF; i++) {
            t aY = aY(this.TQ.aU(i));
            if (!(aY == null || aY.gb())) {
                aY.addFlags(6);
            }
        }
        fI();
        m mVar = this.TN;
        if (mVar.UQ.TU == null || !mVar.UQ.TU.US) {
            mVar.fV();
            return;
        }
        int size = mVar.Vp.size();
        for (i = 0; i < size; i++) {
            t tVar = (t) mVar.Vp.get(i);
            if (tVar != null) {
                tVar.addFlags(6);
                tVar.S(null);
            }
        }
    }

    public final t aP(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return aY(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static t aY(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).Vh;
    }

    public static int aZ(View view) {
        t aY = aY(view);
        return aY != null ? aY.ge() : -1;
    }

    public static int ba(View view) {
        t aY = aY(view);
        return aY != null ? aY.gd() : -1;
    }

    public final t bi(int i) {
        if (this.Ul) {
            return null;
        }
        int eF = this.TQ.eF();
        for (int i2 = 0; i2 < eF; i2++) {
            t aY = aY(this.TQ.aU(i2));
            if (aY != null && !aY.isRemoved() && h(aY) == i) {
                return aY;
            }
        }
        return null;
    }

    public final View j(float f, float f2) {
        for (int childCount = this.TQ.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.TQ.getChildAt(childCount);
            float Q = z.Q(childAt);
            float R = z.R(childAt);
            if (f >= ((float) childAt.getLeft()) + Q && f <= Q + ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) + R && f2 <= ((float) childAt.getBottom()) + R) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    final Rect bb(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.Vi) {
            return layoutParams.RC;
        }
        Rect rect = layoutParams.RC;
        rect.set(0, 0, 0, 0);
        int size = this.TX.size();
        for (int i = 0; i < size; i++) {
            this.ey.set(0, 0, 0, 0);
            ((g) this.TX.get(i)).a(this.ey, view, this, this.UB);
            rect.left += this.ey.left;
            rect.top += this.ey.top;
            rect.right += this.ey.right;
            rect.bottom += this.ey.bottom;
        }
        layoutParams.Vi = false;
        return rect;
    }

    final void T(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.UC != null) {
            this.UC.c(this, i, i2);
        }
        if (this.UD != null) {
            for (scrollY = this.UD.size() - 1; scrollY >= 0; scrollY--) {
                ((k) this.UD.get(scrollY)).c(this, i, i2);
            }
        }
    }

    private void fL() {
        int childCount = this.TQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.TQ.getChildAt(i);
            t aP = aP(childAt);
            if (!(aP == null || aP.Wa == null)) {
                View view = aP.Wa.VU;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private void bc(View view) {
        aY(view);
        if (this.Uk != null) {
            for (int size = this.Uk.size() - 1; size >= 0; size--) {
                ((i) this.Uk.get(size)).bl(view);
            }
        }
    }

    private int h(t tVar) {
        if (tVar.bv(524) || !tVar.isBound()) {
            return -1;
        }
        e eVar = this.TP;
        int i = tVar.mPosition;
        int size = eVar.OS.size();
        for (int i2 = 0; i2 < size; i2++) {
            e.b bVar = (e.b) eVar.OS.get(i2);
            switch (bVar.pK) {
                case 1:
                    if (bVar.OZ > i) {
                        break;
                    }
                    i += bVar.Pb;
                    break;
                case 2:
                    if (bVar.OZ <= i) {
                        if (bVar.OZ + bVar.Pb <= i) {
                            i -= bVar.Pb;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.OZ != i) {
                        if (bVar.OZ < i) {
                            i--;
                        }
                        if (bVar.Pb > i) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i = bVar.Pb;
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public void setNestedScrollingEnabled(boolean z) {
        fM().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return fM().xx;
    }

    public boolean startNestedScroll(int i) {
        return fM().startNestedScroll(i);
    }

    public void stopNestedScroll() {
        fM().stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return fM().hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return fM().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return fM().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return fM().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return fM().dispatchNestedPreFling(f, f2);
    }

    public int getChildDrawingOrder(int i, int i2) {
        if (this.UJ == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.UJ.ac(i, i2);
    }

    private q fM() {
        if (this.UL == null) {
            this.UL = new q(this);
        }
        return this.UL;
    }
}
