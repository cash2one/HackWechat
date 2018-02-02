package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends h implements Iterable<b> {
    public final List<String> abD = new ArrayList();
    public transient a abE = new a();
    public final List<h> abw = new ArrayList();

    public final e a(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            this.abE.h(str, this.abD.size());
            this.abD.add(str);
            this.abw.add(hVar);
            return this;
        }
    }

    public final e g(String str, int i) {
        b(str, a.bS(i));
        return this;
    }

    public final e b(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.abw.set(indexOf, hVar);
            } else {
                this.abE.h(str, this.abD.size());
                this.abD.add(str);
                this.abw.add(hVar);
            }
            return this;
        }
    }

    public final h C(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int indexOf = indexOf(str);
        return indexOf != -1 ? (h) this.abw.get(indexOf) : null;
    }

    public final Iterator<b> iterator() {
        return new 1(this, this.abD.iterator(), this.abw.iterator());
    }

    final void a(i iVar) {
        iVar.hG();
        Iterator it = this.abw.iterator();
        Object obj = 1;
        for (String H : this.abD) {
            if (obj == null) {
                iVar.hJ();
            }
            iVar.H(H);
            iVar.hI();
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.hH();
    }

    public final boolean isObject() {
        return true;
    }

    public final e ht() {
        return this;
    }

    public final int hashCode() {
        return ((this.abD.hashCode() + 31) * 31) + this.abw.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.abD.equals(eVar.abD) && this.abw.equals(eVar.abw)) {
            return true;
        }
        return false;
    }

    public final int indexOf(String str) {
        a aVar = this.abE;
        int i = (aVar.abI[aVar.T(str)] & 255) - 1;
        return (i == -1 || !str.equals(this.abD.get(i))) ? this.abD.lastIndexOf(str) : i;
    }
}
