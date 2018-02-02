package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.x;
import java.util.NavigableMap;

public abstract class a<T> extends e<T, Integer> {
    public synchronized T a(Integer num) {
        T t;
        NavigableMap subMap = this.gZT.subMap(num, true, Integer.valueOf(Integer.MAX_VALUE), true);
        if (!(subMap == null || subMap.isEmpty())) {
            for (Integer intValue : subMap.keySet()) {
                d dVar = (d) subMap.get(Integer.valueOf(intValue.intValue()));
                if (dVar.size() > 0) {
                    T pop = dVar.pop();
                    this.gZT.put(dVar.Et(), dVar);
                    t = pop;
                    break;
                }
            }
            t = null;
            if (t != null) {
                aI(aN(t));
            }
        }
        t = null;
        return t;
    }

    public synchronized T b(Integer num) {
        T t;
        d dVar = (d) this.gZT.get(num);
        if (dVar == null || dVar.size() <= 0) {
            String str = "MicroMsg.BiggerThanPool";
            String str2 = "BiggerThanPool getExactSize cannot get %s size count %d";
            Object[] objArr = new Object[2];
            objArr[0] = num;
            int size = dVar == null ? -1 : dVar.gZR == null ? -1 : dVar.gZR.size();
            objArr[1] = Integer.valueOf(size);
            x.d(str, str2, objArr);
            t = null;
        } else {
            T pop = dVar.pop();
            this.gZT.put(dVar.Et(), dVar);
            aI(aN(pop));
            t = pop;
        }
        return t;
    }
}
