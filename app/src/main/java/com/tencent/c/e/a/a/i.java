package com.tencent.c.e.a.a;

import com.tencent.c.e.a.b.f;
import com.tencent.c.e.a.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i {
    final int gTf;
    int mnk = 0;
    Object[] wj;
    final int zFS;
    private final int zUj;

    public i(int i, int i2, int i3) {
        this.zUj = i;
        this.wj = new Object[((int) Math.ceil((double) ((1.0f * ((float) i3)) / ((float) i2))))];
        this.gTf = i3;
        this.zFS = i2;
    }

    private ArrayList<f> HQ(int i) {
        ArrayList<f> arrayList = new ArrayList();
        List list = (List) this.wj[i];
        if (list == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            j jVar = (j) list.get(i2);
            f fVar = new f();
            fVar.x = jVar.values[0];
            fVar.y = jVar.values[1];
            fVar.z = jVar.values[2];
            fVar.zUE = jVar.timestamp;
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final ArrayList<g> dG(List<k> list) {
        ArrayList<g> arrayList = new ArrayList();
        for (int i = 0; i < this.wj.length; i++) {
            List list2 = (List) this.wj[i];
            if (!(list2 == null || list2.size() == 0)) {
                g gVar = new g();
                ArrayList HQ = HQ(i);
                Map hashMap = new HashMap();
                int i2 = this.zUj == 1 ? 0 : this.zUj == 4 ? 2 : this.zUj == 9 ? 4 : -1;
                hashMap.put(Integer.valueOf(i2), HQ);
                gVar.zUG = hashMap;
                j jVar = (j) list2.get(0);
                if (jVar != null) {
                    gVar.zUF = jVar.timestamp;
                    if (list.size() > i) {
                        k kVar = (k) list.get(i);
                        if (kVar != null) {
                            gVar.zUl = kVar.zUl;
                            gVar.zUm = kVar.zUm;
                            gVar.zUn = kVar.zUn;
                            gVar.zUo = kVar.zUo;
                        }
                    }
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    public final Object[] cDH() {
        return (Object[]) this.wj.clone();
    }
}
