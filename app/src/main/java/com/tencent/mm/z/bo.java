package com.tencent.mm.z;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bo {
    public static final int hhD;
    public static final int hhE;
    public static final int hhF = (hhD + 2);
    private static bo hhI;
    private long hhG = 0;
    private Map<Integer, a> hhH = new HashMap();

    static {
        int hashCode = "kv_key_start".hashCode();
        hhD = hashCode;
        hhE = hashCode + 1;
    }

    private bo() {
        this.hhH.put(Integer.valueOf(hhE), new 1(this));
        this.hhH.put(Integer.valueOf(hhF), new 12(this));
        this.hhH.put(Integer.valueOf(24), new 16(this));
        this.hhH.put(Integer.valueOf(25), new 17(this));
        this.hhH.put(Integer.valueOf(26), new 18(this));
        this.hhH.put(Integer.valueOf(10071), new 19(this));
        this.hhH.put(Integer.valueOf(10076), new 20(this));
        this.hhH.put(Integer.valueOf(19), new 21(this));
        this.hhH.put(Integer.valueOf(10112), new a(this) {
            final /* synthetic */ bo hhJ;

            {
                this.hhJ = r2;
            }

            public final boolean a(bm bmVar) {
                if (System.currentTimeMillis() - bmVar.hhB <= 1800000 || bh.getInt(bmVar.hhA, 0) <= 0) {
                    return false;
                }
                bo.r(bmVar.key, bmVar.hhA);
                bmVar.hhA = "0";
                bmVar.hhB = System.currentTimeMillis();
                return true;
            }
        });
        this.hhH.put(Integer.valueOf(10113), new 2(this));
        this.hhH.put(Integer.valueOf(10114), new 3(this));
        this.hhH.put(Integer.valueOf(10115), new 4(this));
        this.hhH.put(Integer.valueOf(10240), new 5(this));
        this.hhH.put(Integer.valueOf(10241), new 6(this));
        this.hhH.put(Integer.valueOf(15), new 7(this));
        this.hhH.put(Integer.valueOf(16), new 8(this));
        this.hhH.put(Integer.valueOf(27), new 9(this));
        this.hhH.put(Integer.valueOf(38), new 10(this));
        this.hhH.put(Integer.valueOf(10090), new 11(this));
        this.hhH.put(Integer.valueOf(10237), new 13(this));
        this.hhH.put(Integer.valueOf(10238), new 14(this));
        this.hhH.put(Integer.valueOf(10239), new 15(this));
    }

    public static bo HS() {
        if (hhI == null) {
            hhI = new bo();
        }
        return hhI;
    }

    public static void r(int i, String str) {
        LinkedList linkedList = new LinkedList();
        anp com_tencent_mm_protocal_c_anp = new anp();
        com_tencent_mm_protocal_c_anp.pQj = i;
        com_tencent_mm_protocal_c_anp.pQt = str;
        linkedList.add(com_tencent_mm_protocal_c_anp);
        a(linkedList);
    }

    public static void a(LinkedList<anp> linkedList) {
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_anq = new anq();
                com_tencent_mm_protocal_c_anq.ksP = linkedList;
                com_tencent_mm_protocal_c_anq.ksO = linkedList.size();
                ((h) g.h(h.class)).EX().b(new e.a(36, com_tencent_mm_protocal_c_anq));
            }
        }
    }

    public final void c(int i, Object... objArr) {
        a aVar = (a) this.hhH.get(Integer.valueOf(i));
        if (aVar != null) {
            bn HU = HU();
            for (bm bmVar : HU.hhC) {
                if (bmVar.key == i) {
                    aVar.a(bmVar, objArr);
                    break;
                }
            }
            HU.hhC.add(aVar.d(i, objArr));
            a(HU);
        }
    }

    public final void HT() {
        if (System.currentTimeMillis() - this.hhG >= 60000) {
            this.hhG = System.currentTimeMillis();
            try {
                bn HU = HU();
                int i = 0;
                for (bm bmVar : HU.hhC) {
                    int i2;
                    a aVar = (a) this.hhH.get(Integer.valueOf(bmVar.key));
                    if (aVar == null || !aVar.a(bmVar)) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                    i = i2;
                }
                if (i != 0) {
                    a(HU);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bh.i(e)});
            }
        }
    }

    private static bn HU() {
        if (g.Dh().Cy()) {
            g.Dh();
            if (!(a.Cs() || g.Dj().CU() == null)) {
                byte[] VD = bh.VD((String) g.Dj().CU().get(8215, null));
                if (VD.length <= 0) {
                    return new bn();
                }
                try {
                    bn bnVar = new bn();
                    bnVar.aF(VD);
                    return bnVar;
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
        return new bn();
    }

    private static void a(bn bnVar) {
        if (bnVar != null && g.Dh().Cy() && g.Dj().CU() != null) {
            g.Dh();
            if (!a.Cs()) {
                try {
                    g.Dj().CU().set(8215, bh.by(bnVar.toByteArray()));
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
    }
}
