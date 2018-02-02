package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> xCc = new HashMap();
    private LinkedList<T> xCd = new LinkedList();

    a() {
    }

    protected final synchronized T cla() {
        T t;
        t = null;
        if (this.xCd.size() != 0) {
            t = this.xCd.poll();
        }
        return t;
    }

    protected final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        if (this.xCc.containsKey(looper)) {
            linkedList = (LinkedList) this.xCc.get(looper);
        } else {
            linkedList = new LinkedList();
            this.xCc.put(looper, linkedList);
        }
        linkedList.add(t);
    }

    protected final synchronized void c(Looper looper) {
        if (this.xCc.containsKey(looper)) {
            this.xCd.addAll((LinkedList) this.xCc.remove(looper));
        }
    }
}
