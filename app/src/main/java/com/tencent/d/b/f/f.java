package com.tencent.d.b.f;

import android.util.SparseArray;
import com.tencent.d.a.c.c;
import com.tencent.d.b.a.e;

public class f {
    private static volatile f Adj = null;
    public static volatile SparseArray<d> Adk = null;
    public final Object Adl = new Object();

    private f() {
        Adk = new SparseArray(5);
    }

    public static f cGi() {
        if (Adj != null) {
            return Adj;
        }
        f fVar;
        synchronized (f.class) {
            if (Adj == null) {
                Adj = new f();
            }
            fVar = Adj;
        }
        return fVar;
    }

    public final boolean a(d dVar, e eVar) {
        if (dVar.cGg()) {
            c.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            return false;
        }
        int hashCode = dVar.hashCode();
        synchronized (this.Adl) {
            int i = 0;
            while (i < Adk.size()) {
                int keyAt = Adk.keyAt(i);
                if (Adk.get(keyAt) == null || !((d) Adk.get(keyAt)).getClass().getName().equals(dVar.getClass().getName())) {
                    i++;
                } else {
                    c.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                    eVar.errCode = 26;
                    eVar.fnL = "add SOTER task to queue failed. check the logcat for further information";
                    dVar.b(eVar);
                    return false;
                }
            }
            Adk.put(hashCode, dVar);
            g.cGk().A(new 1(this, dVar));
            return true;
        }
    }

    public final void cGj() {
        synchronized (this.Adl) {
            c.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
            if (Adk.size() != 0) {
                for (int i = 0; i < Adk.size(); i++) {
                    g.cGk().A(new 2(this, Adk.keyAt(i)));
                }
            }
            Adk.clear();
        }
    }
}
