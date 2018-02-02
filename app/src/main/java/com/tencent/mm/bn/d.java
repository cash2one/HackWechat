package com.tencent.mm.bn;

import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    public static void cdd() {
        Object obj = (!ar.Hj() || ar.Cs()) ? null : 1;
        if (obj != null && wN()) {
            ar.Hg();
            String str = (String) c.CU().get(77829, null);
            if (str != null) {
                Map Tk = a.Tk(str);
                if (Tk != null && Tk.size() > 0) {
                    List linkedList = new LinkedList();
                    for (Entry entry : Tk.entrySet()) {
                        a aVar = (a) entry.getValue();
                        if (aVar != null) {
                            int i = aVar.hitCount;
                            int i2 = aVar.hJB;
                            if (i > 0 || i2 > 0) {
                                linkedList.add(new a(10166, ((String) entry.getKey()) + "," + i + "," + i2));
                            }
                            x.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState  name " + ((String) entry.getKey()) + " " + i + "  " + i2);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        ar.Hg();
                        c.EX().b(new i(linkedList));
                        ar.Hg();
                        c.CU().set(77829, null);
                    }
                }
            }
        }
        ar.Hg();
        c.CU().set(77828, Long.valueOf(bh.Wo()));
        x.d("PostTaskTenMinutesLogicState", "report PostTaskTenMinutesLogicState done ");
    }

    public static boolean wN() {
        ar.Hg();
        return bh.by(bh.a((Long) c.CU().get(77828, null), 0)) * 1000 > 1800000;
    }
}
