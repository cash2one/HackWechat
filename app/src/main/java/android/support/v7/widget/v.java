package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends aj {
    private ArrayList<RecyclerView$t> QO = new ArrayList();
    private ArrayList<RecyclerView$t> QP = new ArrayList();
    private ArrayList<b> QQ = new ArrayList();
    private ArrayList<a> QR = new ArrayList();
    ArrayList<ArrayList<RecyclerView$t>> QS = new ArrayList();
    ArrayList<ArrayList<b>> QT = new ArrayList();
    ArrayList<ArrayList<a>> QU = new ArrayList();
    ArrayList<RecyclerView$t> QV = new ArrayList();
    ArrayList<RecyclerView$t> QW = new ArrayList();
    ArrayList<RecyclerView$t> QX = new ArrayList();
    ArrayList<RecyclerView$t> QY = new ArrayList();

    public void eI() {
        int i;
        int i2;
        int i3;
        int i4 = !this.QO.isEmpty() ? 1 : 0;
        if (this.QQ.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.QR.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.QP.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable 1;
            Iterator it = this.QO.iterator();
            while (it.hasNext()) {
                RecyclerView$t recyclerView$t = (RecyclerView$t) it.next();
                ai U = z.U(recyclerView$t.VU);
                this.QX.add(recyclerView$t);
                U.d(this.UW).q(0.0f).a(new 4(this, recyclerView$t, U)).start();
            }
            this.QO.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.QQ);
                this.QT.add(arrayList);
                this.QQ.clear();
                1 = new 1(this, arrayList);
                if (i4 != 0) {
                    z.a(((b) arrayList.get(0)).Rr.VU, 1, this.UW);
                } else {
                    1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.QR);
                this.QU.add(arrayList);
                this.QR.clear();
                1 = new 2(this, arrayList);
                if (i4 != 0) {
                    z.a(((a) arrayList.get(0)).Rl.VU, 1, this.UW);
                } else {
                    1.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.QP);
                this.QS.add(arrayList2);
                this.QP.clear();
                Runnable 3 = new 3(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    3.run();
                    return;
                }
                long j;
                long j2;
                long j3 = i4 != 0 ? this.UW : 0;
                if (i != 0) {
                    j = this.UX;
                } else {
                    j = 0;
                }
                if (i2 != 0) {
                    j2 = this.UY;
                } else {
                    j2 = 0;
                }
                z.a(((RecyclerView$t) arrayList2.get(0)).VU, 3, j3 + Math.max(j, j2));
            }
        }
    }

    public boolean b(RecyclerView$t recyclerView$t) {
        e(recyclerView$t);
        this.QO.add(recyclerView$t);
        return true;
    }

    public boolean c(RecyclerView$t recyclerView$t) {
        e(recyclerView$t);
        z.d(recyclerView$t.VU, 0.0f);
        this.QP.add(recyclerView$t);
        return true;
    }

    public boolean a(RecyclerView$t recyclerView$t, int i, int i2, int i3, int i4) {
        View view = recyclerView$t.VU;
        int Q = (int) (((float) i) + z.Q(recyclerView$t.VU));
        int R = (int) (((float) i2) + z.R(recyclerView$t.VU));
        e(recyclerView$t);
        int i5 = i3 - Q;
        int i6 = i4 - R;
        if (i5 == 0 && i6 == 0) {
            y(recyclerView$t);
            return false;
        }
        if (i5 != 0) {
            z.b(view, (float) (-i5));
        }
        if (i6 != 0) {
            z.c(view, (float) (-i6));
        }
        this.QQ.add(new b(recyclerView$t, Q, R, i3, i4, (byte) 0));
        return true;
    }

    public boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2, int i, int i2, int i3, int i4) {
        if (recyclerView$t == recyclerView$t2) {
            return a(recyclerView$t, i, i2, i3, i4);
        }
        float Q = z.Q(recyclerView$t.VU);
        float R = z.R(recyclerView$t.VU);
        float G = z.G(recyclerView$t.VU);
        e(recyclerView$t);
        int i5 = (int) (((float) (i3 - i)) - Q);
        int i6 = (int) (((float) (i4 - i2)) - R);
        z.b(recyclerView$t.VU, Q);
        z.c(recyclerView$t.VU, R);
        z.d(recyclerView$t.VU, G);
        if (recyclerView$t2 != null) {
            e(recyclerView$t2);
            z.b(recyclerView$t2.VU, (float) (-i5));
            z.c(recyclerView$t2.VU, (float) (-i6));
            z.d(recyclerView$t2.VU, 0.0f);
        }
        this.QR.add(new a(recyclerView$t, recyclerView$t2, i, i2, i3, i4, (byte) 0));
        return true;
    }

    private void a(List<a> list, RecyclerView$t recyclerView$t) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, recyclerView$t) && aVar.Rl == null && aVar.Rm == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.Rl != null) {
            a(aVar, aVar.Rl);
        }
        if (aVar.Rm != null) {
            a(aVar, aVar.Rm);
        }
    }

    private boolean a(a aVar, RecyclerView$t recyclerView$t) {
        if (aVar.Rm == recyclerView$t) {
            aVar.Rm = null;
        } else if (aVar.Rl != recyclerView$t) {
            return false;
        } else {
            aVar.Rl = null;
        }
        z.d(recyclerView$t.VU, 1.0f);
        z.b(recyclerView$t.VU, 0.0f);
        z.c(recyclerView$t.VU, 0.0f);
        k(recyclerView$t);
        return true;
    }

    public void d(RecyclerView$t recyclerView$t) {
        int size;
        View view = recyclerView$t.VU;
        z.U(view).cancel();
        for (size = this.QQ.size() - 1; size >= 0; size--) {
            if (((b) this.QQ.get(size)).Rr == recyclerView$t) {
                z.c(view, 0.0f);
                z.b(view, 0.0f);
                y(recyclerView$t);
                this.QQ.remove(size);
            }
        }
        a(this.QR, recyclerView$t);
        if (this.QO.remove(recyclerView$t)) {
            z.d(view, 1.0f);
            k(recyclerView$t);
        }
        if (this.QP.remove(recyclerView$t)) {
            z.d(view, 1.0f);
            k(recyclerView$t);
        }
        for (size = this.QU.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.QU.get(size);
            a(list, recyclerView$t);
            if (list.isEmpty()) {
                this.QU.remove(size);
            }
        }
        for (int size2 = this.QT.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.QT.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).Rr == recyclerView$t) {
                    z.c(view, 0.0f);
                    z.b(view, 0.0f);
                    y(recyclerView$t);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QT.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.QS.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.QS.get(size);
            if (arrayList.remove(recyclerView$t)) {
                z.d(view, 1.0f);
                k(recyclerView$t);
                if (arrayList.isEmpty()) {
                    this.QS.remove(size);
                }
            }
        }
        this.QX.remove(recyclerView$t);
        this.QV.remove(recyclerView$t);
        this.QY.remove(recyclerView$t);
        this.QW.remove(recyclerView$t);
        eJ();
    }

    private void e(RecyclerView$t recyclerView$t) {
        a.v(recyclerView$t.VU);
        d(recyclerView$t);
    }

    public boolean isRunning() {
        return (this.QP.isEmpty() && this.QR.isEmpty() && this.QQ.isEmpty() && this.QO.isEmpty() && this.QW.isEmpty() && this.QX.isEmpty() && this.QV.isEmpty() && this.QY.isEmpty() && this.QT.isEmpty() && this.QS.isEmpty() && this.QU.isEmpty()) ? false : true;
    }

    final void eJ() {
        if (!isRunning()) {
            fR();
        }
    }

    public final void eK() {
        int size;
        for (size = this.QQ.size() - 1; size >= 0; size--) {
            b bVar = (b) this.QQ.get(size);
            View view = bVar.Rr.VU;
            z.c(view, 0.0f);
            z.b(view, 0.0f);
            y(bVar.Rr);
            this.QQ.remove(size);
        }
        for (size = this.QO.size() - 1; size >= 0; size--) {
            k((RecyclerView$t) this.QO.get(size));
            this.QO.remove(size);
        }
        for (size = this.QP.size() - 1; size >= 0; size--) {
            RecyclerView$t recyclerView$t = (RecyclerView$t) this.QP.get(size);
            z.d(recyclerView$t.VU, 1.0f);
            k(recyclerView$t);
            this.QP.remove(size);
        }
        for (size = this.QR.size() - 1; size >= 0; size--) {
            a((a) this.QR.get(size));
        }
        this.QR.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.QT.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QT.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.Rr.VU;
                    z.c(view2, 0.0f);
                    z.b(view2, 0.0f);
                    y(bVar2.Rr);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QT.remove(arrayList);
                    }
                }
            }
            for (size2 = this.QS.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QS.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    RecyclerView$t recyclerView$t2 = (RecyclerView$t) arrayList.get(size3);
                    z.d(recyclerView$t2.VU, 1.0f);
                    k(recyclerView$t2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QS.remove(arrayList);
                    }
                }
            }
            for (size2 = this.QU.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QU.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.QU.remove(arrayList);
                    }
                }
            }
            h(this.QX);
            h(this.QW);
            h(this.QV);
            h(this.QY);
            fR();
        }
    }

    private static void h(List<RecyclerView$t> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            z.U(((RecyclerView$t) list.get(size)).VU).cancel();
        }
    }

    public boolean a(RecyclerView$t recyclerView$t, List<Object> list) {
        return !list.isEmpty() || super.a(recyclerView$t, list);
    }
}
