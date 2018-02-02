package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.plugin.wallet_core.ui.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class m<K> {
    Map<String, Integer> sNg = new HashMap();
    List<K> sNh = new LinkedList();
    public Vector<b> sNi = new Vector();
    List<String> sNj = new LinkedList();

    public abstract String a(Vector<b> vector, int i);

    public final void d(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.sNj = list3;
        this.sNh = list2;
        this.sNi.clear();
        this.sNi = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b(this);
            Object obj = list.get(i);
            bVar.sNp = obj;
            if (this.sNh.contains(obj)) {
                bVar.sNq = a.sNm;
            } else {
                bVar.sNq = a.sNl;
            }
            this.sNi.add(bVar);
        }
        this.sNg.clear();
        for (i = 0; i < list3.size(); i++) {
            this.sNg.put(list3.get(i), Integer.valueOf(0));
        }
        bLj();
    }

    public final void dZ(int i, int i2) {
        ((b) this.sNi.get(i)).sNq = i2;
    }

    public final void bLj() {
        for (int i = 0; i < this.sNi.size(); i++) {
            if (((b) this.sNi.get(i)).sNq != a.sNm) {
                String a = a(this.sNi, i);
                if (!this.sNg.containsKey(a)) {
                    Object obj;
                    String[] Nj = a.Nj(a);
                    for (int i2 = 0; i2 < this.sNj.size(); i2++) {
                        for (CharSequence contains : Nj) {
                            if (!((String) this.sNj.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int i3 = 1;
                        if (obj != null) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        dZ(i, a.sNl);
                    }
                }
                dZ(i, a.sNn);
            }
        }
    }
}
