package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j lMU;
    private SparseArray<List<a>> lMV = new SparseArray();

    private j() {
    }

    public static j aEb() {
        if (lMU == null) {
            lMU = new j();
        }
        return lMU;
    }

    public final boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        List list = (List) this.lMV.get(i);
        if (list == null) {
            list = new LinkedList();
            this.lMV.put(i, list);
        } else if (list.contains(aVar)) {
            return false;
        }
        return list.add(aVar);
    }

    public final boolean b(int i, a aVar) {
        List list = (List) this.lMV.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.lMV.remove(i);
            }
        }
        return false;
    }

    public final void f(int i, Object... objArr) {
        List list = (List) this.lMV.get(i);
        if (list != null && list.size() != 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((a) list.get(i2)).e(i, objArr);
            }
        }
    }
}
