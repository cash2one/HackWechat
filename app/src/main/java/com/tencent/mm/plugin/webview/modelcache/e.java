package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private final SparseArray<b<a>> ttz = new SparseArray();

    private static final class b<T> {
        final byte[] gSF = new byte[0];
        final SparseArray<T> ttD = new SparseArray();

        public final T valueAt(int i) {
            return this.ttD.valueAt(i);
        }

        public final void remove(int i) {
            this.ttD.remove(i);
        }
    }

    public final boolean An(int i) {
        synchronized (this.ttz) {
            b bVar = (b) this.ttz.get(i);
            this.ttz.remove(i);
        }
        if (bVar != null) {
            synchronized (bVar.gSF) {
                bVar.ttD.clear();
            }
        }
        return true;
    }

    public final boolean b(int i, String str, String str2, String str3, int i2) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.ttz) {
            b bVar = (b) this.ttz.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.gSF) {
            if (bVar.ttD.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.ttD.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (bh.ou(aVar.appId).equals(str) && bh.ou(aVar.fMh).equals(str2) && bh.ou(aVar.fMi).equals(str3) && aVar.fMj == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final boolean a(int i, String str, String str2, String str3, int i2, String str4) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3) || bh.ov(str4) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        synchronized (this.ttz) {
            b bVar = (b) this.ttz.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.gSF) {
            if (bVar.ttD.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            for (int i3 = 0; i3 < bVar.ttD.size(); i3++) {
                a aVar = (a) bVar.valueAt(i3);
                if (bh.ou(aVar.appId).equals(str) && bh.ou(aVar.fMh).equals(str2) && bh.ou(aVar.fMi).equals(str3) && bh.ou(aVar.ttC).equals(str4) && aVar.fMj == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final List<c> n(String str, String str2, String str3, String str4) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3) || bh.ov(str4)) {
            return null;
        }
        String OB = p.OB(str);
        if (bh.ov(OB)) {
            return null;
        }
        List<c> linkedList = new LinkedList();
        synchronized (this.ttz) {
            for (int i = 0; i < this.ttz.size(); i++) {
                b bVar = (b) this.ttz.valueAt(i);
                if (bVar != null) {
                    synchronized (bVar.gSF) {
                        for (int i2 = 0; i2 < bVar.ttD.size(); i2++) {
                            a aVar = (a) bVar.valueAt(i2);
                            if (bh.ou(aVar.ttC).equals(OB) && bh.ou(aVar.appId).equals(str2) && bh.ou(aVar.fMh).equals(str3) && bh.ou(aVar.fMi).equals(str4)) {
                                linkedList.add(new c(aVar.ttB, aVar.ttA));
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }
}
