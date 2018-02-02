package com.tencent.mm.az;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<lu> {
    public p() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return QF();
    }

    private static boolean QF() {
        int i;
        boolean z;
        LinkedList linkedList;
        byte[] e;
        Iterator it;
        g gVar;
        anp com_tencent_mm_protocal_c_anp;
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                i = 1;
                if (i != 0) {
                    if (bh.by(bh.a((Long) g.Dj().CU().get(68097, null), 0)) * 1000 <= 3600000) {
                        i = 1;
                    } else {
                        z = false;
                    }
                    if (i != 0) {
                        linkedList = new LinkedList();
                        e = e.e(g.Dj().cachePath + "eggresult.rep", 0, -1);
                        if (e != null) {
                            try {
                                it = ((h) new h().aF(e)).hJD.iterator();
                                while (it.hasNext()) {
                                    gVar = (g) it.next();
                                    if (gVar.hJB != 0) {
                                        com_tencent_mm_protocal_c_anp = new anp();
                                        com_tencent_mm_protocal_c_anp.pQj = 17;
                                        com_tencent_mm_protocal_c_anp.pQt = gVar.hJq + "," + gVar.hJB;
                                        linkedList.add(com_tencent_mm_protocal_c_anp);
                                    }
                                    if (gVar.hJC != 0) {
                                        com_tencent_mm_protocal_c_anp = new anp();
                                        com_tencent_mm_protocal_c_anp.pQj = 18;
                                        com_tencent_mm_protocal_c_anp.pQt = gVar.hJq + "," + gVar.hJC;
                                        linkedList.add(com_tencent_mm_protocal_c_anp);
                                    }
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(g.Dj().cachePath + "eggresult.rep");
                            } catch (Throwable e2) {
                                x.e("MicroMsg.PostTaskReportEgg", "exception:%s", bh.i(e2));
                            }
                            if (!linkedList.isEmpty()) {
                                bo.a(linkedList);
                                g.Dj().CU().set(68097, Long.valueOf(bh.Wo()));
                            }
                        }
                        return false;
                    }
                }
                x.d("MicroMsg.PostTaskReportEgg", "report egg done");
                return false;
            }
        }
        z = false;
        if (i != 0) {
            if (bh.by(bh.a((Long) g.Dj().CU().get(68097, null), 0)) * 1000 <= 3600000) {
                z = false;
            } else {
                i = 1;
            }
            if (i != 0) {
                linkedList = new LinkedList();
                e = e.e(g.Dj().cachePath + "eggresult.rep", 0, -1);
                if (e != null) {
                    it = ((h) new h().aF(e)).hJD.iterator();
                    while (it.hasNext()) {
                        gVar = (g) it.next();
                        if (gVar.hJB != 0) {
                            com_tencent_mm_protocal_c_anp = new anp();
                            com_tencent_mm_protocal_c_anp.pQj = 17;
                            com_tencent_mm_protocal_c_anp.pQt = gVar.hJq + "," + gVar.hJB;
                            linkedList.add(com_tencent_mm_protocal_c_anp);
                        }
                        if (gVar.hJC != 0) {
                            com_tencent_mm_protocal_c_anp = new anp();
                            com_tencent_mm_protocal_c_anp.pQj = 18;
                            com_tencent_mm_protocal_c_anp.pQt = gVar.hJq + "," + gVar.hJC;
                            linkedList.add(com_tencent_mm_protocal_c_anp);
                        }
                    }
                    com.tencent.mm.loader.stub.b.deleteFile(g.Dj().cachePath + "eggresult.rep");
                    if (linkedList.isEmpty()) {
                        bo.a(linkedList);
                        g.Dj().CU().set(68097, Long.valueOf(bh.Wo()));
                    }
                }
                return false;
            }
        }
        x.d("MicroMsg.PostTaskReportEgg", "report egg done");
        return false;
    }
}
