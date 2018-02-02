package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.e.a;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class k extends v {
    boolean jQR = false;
    boolean jQS = true;
    private final a jQT = new 1(this);
    final Set<a> jQU = new HashSet();
    private final Interpolator jQV = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> jQW = new ArrayList();
    final ArrayList<RecyclerView$t> jQX = new ArrayList();
    private final ArrayList<d> jQY = new ArrayList();
    final ArrayList<RecyclerView$t> jQZ = new ArrayList();
    private final ArrayList<d> jRa = new ArrayList();
    final ArrayList<d> jRb = new ArrayList();
    private final ArrayList<d> jRc = new ArrayList();
    final ArrayList<d> jRd = new ArrayList();
    private final ArrayList<f> jRe = new ArrayList();
    final ArrayList<d> jRf = new ArrayList();
    private final ArrayList<RecyclerView$t> jRg = new ArrayList();
    private final ArrayList<d> jRh = new ArrayList();
    final ArrayList<d> jRi = new ArrayList();
    final ArrayList<d> jRj = new ArrayList();
    boolean jRk = false;

    k() {
    }

    static /* synthetic */ void a(k kVar) {
        if (!kVar.isRunning()) {
            kVar.fR();
        }
    }

    final void b(a aVar) {
        if (aVar != null) {
            this.jQU.add(aVar);
        }
    }

    final void c(a aVar) {
        if (aVar != null) {
            this.jQU.remove(aVar);
        }
    }

    private void e(RecyclerView$t recyclerView$t) {
        android.support.v4.a.a.v(recyclerView$t.VU);
        d(recyclerView$t);
        z.c(recyclerView$t.VU, 0.0f);
        z.d(recyclerView$t.VU, 1.0f);
    }

    public final boolean isRunning() {
        return (this.jQW.isEmpty() && this.jQX.isEmpty() && this.jQY.isEmpty() && this.jQZ.isEmpty() && this.jRa.isEmpty() && this.jRb.isEmpty() && this.jRc.isEmpty() && this.jRd.isEmpty() && this.jRe.isEmpty() && this.jRf.isEmpty() && this.jRh.isEmpty() && this.jRi.isEmpty() && this.jRj.isEmpty() && !super.isRunning()) ? false : true;
    }

    public final void eI() {
        Iterator it;
        a(this.jQT);
        if (!this.jQW.isEmpty()) {
            it = this.jQW.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                this.jQX.add(bVar.jRn);
                RecyclerView$t recyclerView$t = bVar.jRn;
                View view = bVar.jRn.VU;
                bVar.jRn.jPA.setVisibility(0);
                z.c(view, 0.0f);
                ai U = z.U(view);
                U.d(Math.max(this.UX, Math.min(Math.round((((double) bVar.Ro) / ((double) bVar.jRn.VU.getHeight())) * ((double) this.UX)) + this.UX, 400)));
                U.b(this.jQV);
                U.a(new 2(this, recyclerView$t, U));
                U.s((float) ((-bVar.Ro) - view.getHeight())).start();
            }
            this.jQW.clear();
        }
        if (!this.jQY.isEmpty()) {
            Iterator it2 = this.jQY.iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                this.jQZ.add(dVar.jRn);
                RecyclerView$t recyclerView$t2 = dVar.jRn;
                View view2 = dVar.jRn.VU;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                dVar.jRn.jPA.setVisibility(8);
                z.c(view2, 0.0f);
                U = z.U(view2);
                U.d(this.UX);
                U.a(new 3(this, recyclerView$t2, U));
                U.s((float) (recentsRecyclerView.getHeight() - dVar.Ro)).start();
            }
            this.jQY.clear();
        }
        if (!this.jRa.isEmpty()) {
            it = this.jRa.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                this.jRb.add(dVar2);
                z.e(dVar2.jPA, 0.1f);
                z.f(dVar2.jPA, 0.1f);
                z.d(dVar2.jPA, 0.0f);
                dVar2.jPA.setVisibility(0);
                ai U2 = z.U(dVar2.jPA);
                U2.d(this.UY);
                U2.a(new 4(this, dVar2, U2));
                U2.q(1.0f).t(1.0f).u(1.0f).start();
            }
            this.jRa.clear();
        }
        if (!this.jRc.isEmpty()) {
            it = this.jRc.iterator();
            while (it.hasNext()) {
                dVar2 = (d) it.next();
                this.jRd.add(dVar2);
                z.e(dVar2.jPA, 1.0f);
                z.f(dVar2.jPA, 1.0f);
                z.d(dVar2.jPA, 1.0f);
                dVar2.jPA.setVisibility(0);
                U2 = z.U(dVar2.jPA);
                U2.d(this.UY);
                U2.a(new 5(this, dVar2));
                U2.q(0.0f).t(0.1f).u(0.1f).start();
            }
            this.jRc.clear();
        }
        if (!this.jRe.isEmpty()) {
            it = this.jRe.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.jRf.add(fVar.jRn);
                View view3 = fVar.jRn.VU;
                z.c(view3, 0.0f);
                z.d(view3, 1.0f);
                dVar2 = fVar.jRn;
                ai U3 = z.U(view3);
                U3.d(this.UX);
                U3.a(new 6(this, dVar2));
                U3.q(0.0f).s((float) (-view3.getHeight())).start();
            }
            this.jRe.clear();
        }
        super.eI();
        if (!this.jRh.isEmpty()) {
            this.jRi.addAll(this.jRh);
            Runnable 7 = new 7(this);
            this.jRh.clear();
            if (this.jRk) {
                z.a(((d) this.jRi.get(0)).VU, 7, this.UW);
            } else {
                7.run();
            }
        }
    }

    public final void z(RecyclerView$t recyclerView$t) {
        super.z(recyclerView$t);
        if (!this.jRf.contains(recyclerView$t)) {
            this.jRk = true;
        }
    }

    public final boolean a(RecyclerView$t recyclerView$t, int i, int i2, int i3, int i4) {
        if ((recyclerView$t instanceof d) && this.jQS) {
            return super.a(recyclerView$t, i, i2, i3, i4);
        }
        e(recyclerView$t);
        y(recyclerView$t);
        return false;
    }

    public final boolean c(RecyclerView$t recyclerView$t) {
        e(recyclerView$t);
        k(recyclerView$t);
        return false;
    }

    public final void d(RecyclerView$t recyclerView$t) {
        if ((recyclerView$t instanceof d) && this.jRh.remove(recyclerView$t)) {
            z.c(recyclerView$t.VU, 0.0f);
            k(recyclerView$t);
        }
        super.d(recyclerView$t);
    }

    public final boolean e(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (!this.jQS) {
            return c(recyclerView$t);
        }
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.jQR && (recyclerView$t.VU.getParent() instanceof RecyclerView) && (recyclerView$t instanceof d)) {
                RecyclerView recyclerView = (RecyclerView) recyclerView$t.VU.getParent();
                if (recyclerView.getHeight() > 0) {
                    d dVar;
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        dVar = (d) recyclerView$t;
                        z.c(dVar.VU, (float) dVar.VU.getHeight());
                        this.jRh.add(dVar);
                        return true;
                    } else if (cVar2.top <= 0) {
                        dVar = (d) recyclerView$t;
                        z.c(dVar.VU, (float) (-dVar.VU.getHeight()));
                        this.jRh.add(dVar);
                        return true;
                    }
                }
            }
            return c(recyclerView$t);
        }
        return super.a(recyclerView$t, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public final boolean d(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (!this.jQS) {
            e(recyclerView$t);
            k(recyclerView$t);
            return false;
        } else if (cVar instanceof c) {
            e(recyclerView$t);
            this.jQW.add(new b((d) recyclerView$t, cVar.left, cVar.top));
            return true;
        } else if (cVar instanceof e) {
            e(recyclerView$t);
            this.jQY.add(new d((d) recyclerView$t, cVar.left, cVar.top));
            return true;
        } else {
            if ((cVar.UZ & 2048) > 0 && (recyclerView$t instanceof d) && cVar2 == null) {
                boolean z;
                try {
                    z = ((d) recyclerView$t).alt().iJL;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    e(recyclerView$t);
                    this.jRe.add(new f((d) recyclerView$t, cVar.left, cVar.top, (byte) 0));
                    return true;
                }
            }
            return super.d(recyclerView$t, cVar, cVar2);
        }
    }

    public final boolean b(RecyclerView$t recyclerView$t) {
        if (this.jQS) {
            return super.b(recyclerView$t);
        }
        e(recyclerView$t);
        k(recyclerView$t);
        return false;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2, int i, int i2, int i3, int i4) {
        if (z.U(recyclerView$t.VU) == null) {
            z.d(recyclerView$t.VU, 1.0f);
            z.c(recyclerView$t.VU, 0.0f);
        }
        if (z.U(recyclerView$t2.VU) == null) {
            z.d(recyclerView$t2.VU, 1.0f);
            z.c(recyclerView$t2.VU, 0.0f);
        }
        k(recyclerView$t);
        k(recyclerView$t2);
        return false;
    }

    public final boolean f(RecyclerView$t recyclerView$t, c cVar, c cVar2) {
        if (this.jQS) {
            return super.f(recyclerView$t, cVar, cVar2);
        }
        e(recyclerView$t);
        y(recyclerView$t);
        return false;
    }

    public final void l(RecyclerView$t recyclerView$t) {
        super.l(recyclerView$t);
        ViewParent parent = recyclerView$t.VU.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).bO(recyclerView$t.VU);
        }
    }

    public final void A(RecyclerView$t recyclerView$t) {
        super.A(recyclerView$t);
        if (this.jRg.contains(recyclerView$t)) {
            ((RecentsRecyclerView) recyclerView$t.VU.getParent()).bN(recyclerView$t.VU);
        }
    }

    public final void B(RecyclerView$t recyclerView$t) {
        super.B(recyclerView$t);
        if (this.jRg.contains(recyclerView$t)) {
            this.jRg.remove(recyclerView$t);
            ((RecentsRecyclerView) recyclerView$t.VU.getParent()).bO(recyclerView$t.VU);
        }
    }

    public final c a(q qVar, RecyclerView$t recyclerView$t, int i, List<Object> list) {
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        return new c((byte) 0).b(recyclerView$t, i);
                    }
                    if (!(bool == null || bool.booleanValue())) {
                        return new e((byte) 0).b(recyclerView$t, i);
                    }
                }
            }
        }
        c a = super.a(qVar, recyclerView$t, i, list);
        a.UZ = i;
        return a;
    }

    public final boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2, c cVar, c cVar2) {
        if (!this.jQS) {
            k(recyclerView$t);
            k(recyclerView$t2);
            return false;
        } else if (cVar instanceof c) {
            if (((c) cVar).alD()) {
                ((d) recyclerView$t2).jPA.setVisibility(0);
                ((d) recyclerView$t2).jPA.invalidate();
                ((RecentsRecyclerView) recyclerView$t2.VU.getParent()).bN(recyclerView$t2.VU);
                this.jRg.add(recyclerView$t2);
                return super.a(recyclerView$t2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(recyclerView$t2);
            this.jRa.add((d) recyclerView$t2);
            return true;
        } else if (!(cVar instanceof e)) {
            return super.a(recyclerView$t, recyclerView$t2, cVar, cVar2);
        } else {
            if (((e) cVar).alD()) {
                ((d) recyclerView$t2).jPA.setVisibility(8);
                return super.a(recyclerView$t2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(recyclerView$t2);
            this.jRc.add((d) recyclerView$t2);
            return true;
        }
    }

    public final boolean a(RecyclerView$t recyclerView$t, List<Object> list) {
        return (recyclerView$t instanceof d) || super.a(recyclerView$t, (List) list);
    }
}
