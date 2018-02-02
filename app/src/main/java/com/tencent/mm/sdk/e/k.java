package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class k<T, E> {
    public int xjH = 0;
    private final Hashtable<T, Object> xjI = new Hashtable();
    private final HashSet<E> xjJ = new HashSet();

    public abstract void p(T t, E e);

    public final void lock() {
        this.xjH++;
    }

    public final void unlock() {
        this.xjH--;
        if (this.xjH <= 0) {
            this.xjH = 0;
            cgQ();
        }
    }

    public final boolean isLocked() {
        return this.xjH > 0;
    }

    public synchronized void a(T t, Looper looper) {
        if (!this.xjI.containsKey(t)) {
            if (looper != null) {
                this.xjI.put(t, looper);
            } else {
                this.xjI.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.xjI.remove(t);
    }

    public final synchronized void removeAll() {
        this.xjI.clear();
    }

    private synchronized Vector<T> cgP() {
        Vector<T> vector;
        vector = new Vector();
        vector.addAll(this.xjI.keySet());
        return vector;
    }

    public final boolean ca(E e) {
        boolean add;
        synchronized (this.xjJ) {
            add = this.xjJ.add(e);
        }
        return add;
    }

    public final void doNotify() {
        if (!isLocked()) {
            cgQ();
        }
    }

    public void cB(List<E> list) {
    }

    private void cgQ() {
        Vector cgP = cgP();
        if (cgP.size() <= 0) {
            this.xjJ.clear();
            return;
        }
        Object arrayList;
        synchronized (this.xjJ) {
            arrayList = new ArrayList(this.xjJ);
            this.xjJ.clear();
        }
        cB(arrayList);
        Map hashMap = new HashMap();
        Iterator it = cgP.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.xjI.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        af afVar = (af) hashMap.get(looper);
                        if (afVar == null) {
                            afVar = new af(looper);
                            hashMap.put(looper, afVar);
                        }
                        afVar.post(new Runnable(this) {
                            final /* synthetic */ k xjM;

                            public final void run() {
                                this.xjM.p(next, next2);
                            }
                        });
                    } else {
                        p(next, next2);
                    }
                }
            }
        }
    }
}
