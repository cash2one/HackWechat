package com.tencent.mm.platformtools;

import android.util.SparseBooleanArray;
import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static ConcurrentHashMap<Integer, a> icb = new ConcurrentHashMap();

    public static final class a extends h {
        public final boolean icc;
        SparseBooleanArray icd = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            x.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.icc = z;
            this.path = str;
        }

        public final void iV(int i) {
            x.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.icd.delete(i);
            if (this.icd.size() <= 0) {
                x.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.ES();
                g.icb.remove(Integer.valueOf(this.path.hashCode()));
            }
        }

        @Deprecated
        public final void ES() {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", bh.cgy());
            if (this.icd.size() <= 1) {
                super.ES();
            }
        }

        @Deprecated
        public final void eb(String str) {
            x.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.icd.size() <= 1) {
                super.eb(str);
            }
        }
    }

    public static final a a(int i, String str, HashMap<Integer, d> hashMap, boolean z) {
        boolean z2 = (bh.ov(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) icb.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                com.tencent.mm.kernel.g.Dh();
                if (!aVar.a("", str, "", (long) com.tencent.mm.kernel.a.Cg(), q.yE(), hashMap, true)) {
                    throw new b((byte) 0);
                }
            } else if (!aVar.b(str, hashMap, true, false)) {
                throw new b((byte) 0);
            }
            icb.put(Integer.valueOf(hashCode), aVar);
        } else {
            Assert.assertTrue(z == aVar.icc);
            long dz = aVar.dz(-1);
            for (d wg : hashMap.values()) {
                for (String str2 : wg.wg()) {
                    x.d("MicroMsg.GeneralDBHelper", "init sql:" + str2);
                    try {
                        aVar.fx(null, str2);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + str2 + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.fS(dz);
        }
        x.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.icd.put(i, true);
        return aVar;
    }
}
