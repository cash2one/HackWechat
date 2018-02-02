package com.tencent.mm.ipcinvoker.wx_extension.b;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private final List<b<a>> gNl;
    private final List<Object> gNm;

    private b() {
        this.gNl = new LinkedList();
        this.gNm = new LinkedList();
    }

    public final boolean a(a aVar) {
        if (c(aVar)) {
            return false;
        }
        synchronized (this.gNl) {
            this.gNl.add(new b(aVar));
            BD();
        }
        return true;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean remove;
        synchronized (this.gNl) {
            remove = this.gNl.remove(new b(aVar));
            BE();
        }
        return remove;
    }

    public final boolean c(a aVar) {
        if (aVar == null) {
            return false;
        }
        synchronized (this.gNl) {
            for (b bVar : this.gNl) {
                if (bVar != null) {
                    a aVar2 = (a) bVar.get();
                    if (aVar2 != null && aVar.equals(aVar2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final int size() {
        int size;
        synchronized (this.gNl) {
            size = this.gNl.size();
        }
        return size;
    }

    private synchronized void BD() {
        Iterator it = this.gNm.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized void BE() {
        Iterator it = this.gNm.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
