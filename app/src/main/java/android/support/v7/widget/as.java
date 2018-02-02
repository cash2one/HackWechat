package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;

final class as {
    final a<t, a> aas = new a();
    final e<t> aat = new e();

    as() {
    }

    final void clear() {
        this.aas.clear();
        e eVar = this.aat;
        int i = eVar.hX;
        Object[] objArr = eVar.wj;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        eVar.hX = 0;
        eVar.wh = false;
    }

    final void b(t tVar, c cVar) {
        a aVar = (a) this.aas.get(tVar);
        if (aVar == null) {
            aVar = a.hd();
            this.aas.put(tVar, aVar);
        }
        aVar.aau = cVar;
        aVar.flags |= 4;
    }

    final boolean C(t tVar) {
        a aVar = (a) this.aas.get(tVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final c c(t tVar, int i) {
        c cVar = null;
        int indexOfKey = this.aas.indexOfKey(tVar);
        if (indexOfKey >= 0) {
            a aVar = (a) this.aas.valueAt(indexOfKey);
            if (!(aVar == null || (aVar.flags & i) == 0)) {
                aVar.flags &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.aau;
                } else if (i == 8) {
                    cVar = aVar.aav;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.flags & 12) == 0) {
                    this.aas.removeAt(indexOfKey);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    final void a(long j, t tVar) {
        this.aat.put(j, tVar);
    }

    final void c(t tVar, c cVar) {
        a aVar = (a) this.aas.get(tVar);
        if (aVar == null) {
            aVar = a.hd();
            this.aas.put(tVar, aVar);
        }
        aVar.aav = cVar;
        aVar.flags |= 8;
    }

    final void D(t tVar) {
        a aVar = (a) this.aas.get(tVar);
        if (aVar == null) {
            aVar = a.hd();
            this.aas.put(tVar, aVar);
        }
        r0.flags |= 1;
    }

    final void E(t tVar) {
        a aVar = (a) this.aas.get(tVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    final void a(b bVar) {
        for (int size = this.aas.size() - 1; size >= 0; size--) {
            t tVar = (t) this.aas.keyAt(size);
            a aVar = (a) this.aas.removeAt(size);
            if ((aVar.flags & 3) == 3) {
                bVar.i(tVar);
            } else if ((aVar.flags & 1) != 0) {
                if (aVar.aau == null) {
                    bVar.i(tVar);
                } else {
                    bVar.a(tVar, aVar.aau, aVar.aav);
                }
            } else if ((aVar.flags & 14) == 14) {
                bVar.b(tVar, aVar.aau, aVar.aav);
            } else if ((aVar.flags & 12) == 12) {
                bVar.c(tVar, aVar.aau, aVar.aav);
            } else if ((aVar.flags & 4) != 0) {
                bVar.a(tVar, aVar.aau, null);
            } else if ((aVar.flags & 8) != 0) {
                bVar.b(tVar, aVar.aau, aVar.aav);
            } else {
                int i = aVar.flags;
            }
            a.a(aVar);
        }
    }

    final void F(t tVar) {
        a aVar;
        for (int size = this.aat.size() - 1; size >= 0; size--) {
            if (tVar == this.aat.valueAt(size)) {
                e eVar = this.aat;
                if (eVar.wj[size] != e.wg) {
                    eVar.wj[size] = e.wg;
                    eVar.wh = true;
                }
                aVar = (a) this.aas.remove(tVar);
                if (aVar != null) {
                    a.a(aVar);
                }
            }
        }
        aVar = (a) this.aas.remove(tVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
