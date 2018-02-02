package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.bq.a;
import com.tencent.mm.cd.c;

public final class s {
    private static SparseArray<a> ooM = new SparseArray();
    private static c<r> ooN;

    public static synchronized <T extends a> void a(int i, q<T> qVar) {
        synchronized (s.class) {
            a aVar = (a) ooM.get(i);
            if (aVar == null) {
                aVar = new a((byte) 0);
                ooM.put(i, aVar);
            }
            aVar.aE(qVar);
        }
    }

    public static synchronized void a(q qVar) {
        synchronized (s.class) {
            a aVar = (a) ooM.get(5);
            if (aVar != null) {
                aVar.remove(qVar);
                if (aVar.size() == 0) {
                    ooM.remove(5);
                }
            }
        }
    }

    public static synchronized <T extends a> void h(T t) {
        synchronized (s.class) {
            a aVar = (a) ooM.get(5);
            if (aVar != null) {
                aVar.f(t);
            }
        }
    }

    public static synchronized <T extends a> void b(int i, T t) {
        synchronized (s.class) {
            a aVar = (a) ooM.get(i);
            if (aVar != null) {
                aVar.e(t);
            }
        }
    }

    public static final c<r> aZj() {
        return ooN;
    }

    public static final void b(c<r> cVar) {
        ooN = cVar;
    }
}
