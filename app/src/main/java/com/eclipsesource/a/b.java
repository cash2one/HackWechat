package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends h implements Iterable<h> {
    public final List<h> abw = new ArrayList();

    public final b bT(int i) {
        this.abw.add(a.bS(i));
        return this;
    }

    public final b h(long j) {
        this.abw.add(a.g(j));
        return this;
    }

    public final b e(double d) {
        this.abw.add(a.d(d));
        return this;
    }

    public final b ab(boolean z) {
        this.abw.add(a.aa(z));
        return this;
    }

    public final b a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("value is null");
        }
        this.abw.add(hVar);
        return this;
    }

    public final h bU(int i) {
        return (h) this.abw.get(i);
    }

    public final Iterator<h> iterator() {
        return new 1(this, this.abw.iterator());
    }

    final void a(i iVar) {
        iVar.hD();
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                iVar.hF();
            }
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.hE();
    }

    public final boolean isArray() {
        return true;
    }

    public final b ho() {
        return this;
    }

    public final int hashCode() {
        return this.abw.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.abw.equals(((b) obj).abw);
    }
}
