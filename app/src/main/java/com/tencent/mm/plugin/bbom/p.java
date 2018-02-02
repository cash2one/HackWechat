package com.tencent.mm.plugin.bbom;

import android.bluetooth.BluetoothAdapter;
import android.text.TextUtils;
import com.tencent.mm.bn.d;
import com.tencent.mm.booter.g;
import com.tencent.mm.booter.h;
import com.tencent.mm.booter.i;
import com.tencent.mm.booter.j;
import com.tencent.mm.booter.l;
import com.tencent.mm.booter.n;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.ao;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.List;

public final class p extends c<lu> {
    public p() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long Wo;
        long c;
        if (a.hfN != null) {
            a.hfN.GR();
        }
        Object obj = (ar.Hj() && !ar.Cs() && (q.Gd() & 16) == 0) ? 1 : null;
        if (obj != null && h.wN()) {
            aqq com_tencent_mm_protocal_c_aqq;
            ar.Hg();
            t CU = com.tencent.mm.z.c.CU();
            int e = com.tencent.mm.platformtools.t.e((Integer) CU.get(67073, null));
            int e2 = com.tencent.mm.platformtools.t.e((Integer) CU.get(67074, null));
            int e3 = com.tencent.mm.platformtools.t.e((Integer) CU.get(67075, null));
            int e4 = com.tencent.mm.platformtools.t.e((Integer) CU.get(67076, null));
            ar.Hg();
            com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = com.tencent.mm.z.c.Fa();
            int bD = Fa.bD("medianote", 1);
            int bD2 = Fa.bD("medianote", 3);
            int bD3 = Fa.bD("medianote", 34);
            int bD4 = Fa.bD("medianote", 43);
            if (bD - e > 0) {
                aqq com_tencent_mm_protocal_c_aqq2 = new aqq();
                com_tencent_mm_protocal_c_aqq2.wxB = bD - e;
                com_tencent_mm_protocal_c_aqq2.wxC = 1;
                CU.set(67073, Integer.valueOf(bD));
            }
            if (bD2 - e2 > 0) {
                com_tencent_mm_protocal_c_aqq = new aqq();
                com_tencent_mm_protocal_c_aqq.wxB = bD2 - e2;
                com_tencent_mm_protocal_c_aqq.wxC = 3;
                CU.set(67074, Integer.valueOf(bD2));
            }
            if (bD3 - e3 > 0) {
                com_tencent_mm_protocal_c_aqq = new aqq();
                com_tencent_mm_protocal_c_aqq.wxB = bD3 - e3;
                com_tencent_mm_protocal_c_aqq.wxC = 34;
                CU.set(67075, Integer.valueOf(bD3));
            }
            if (bD4 - e4 > 0) {
                com_tencent_mm_protocal_c_aqq = new aqq();
                com_tencent_mm_protocal_c_aqq.wxB = bD4 - e4;
                com_tencent_mm_protocal_c_aqq.wxC = 43;
                CU.set(67076, Integer.valueOf(bD4));
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(66817, Long.valueOf(com.tencent.mm.platformtools.t.Wo()));
        }
        com.tencent.mm.bn.a.run();
        ar.Hg();
        boolean d = com.tencent.mm.platformtools.t.d((Boolean) com.tencent.mm.z.c.CU().get(67841, null));
        if (!(m.NN() == m.a.hwi || m.NN() == m.a.hwj)) {
            d = false;
        }
        if (d) {
            x.d("MicroMsg.PostTaskUpdateCtRemark", "collect addr userName");
            List kT = af.OD().kT("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.username!=\"" + bh.ot("") + "\" )");
            x.d("MicroMsg.PostTaskUpdateCtRemark", "list " + kT.size());
            for (int i = 0; i < kT.size(); i++) {
                String username = ((com.tencent.mm.modelfriend.b) kT.get(i)).getUsername();
                String trim = ((com.tencent.mm.modelfriend.b) kT.get(i)).Nt().trim();
                if (!(username == null || username.equals("") || trim == null || trim.equals(""))) {
                    ar.Hg();
                    com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(username);
                    if (com.tencent.mm.l.a.fZ(WO.field_type) && (WO.field_conRemark == null || WO.field_conRemark.equals(""))) {
                        x.d("MicroMsg.PostTaskUpdateCtRemark", "userName " + username + "conRemark" + trim);
                        s.b(WO, trim);
                    }
                }
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(67841, Boolean.valueOf(false));
        }
        x.d("MicroMsg.PostTaskUpdateCtRemark", "update ct remark done");
        bo.HS().HT();
        i.run();
        if (d.wN()) {
            d.cdd();
        }
        n.run();
        g.run();
        if (ar.Hj() && !ar.Cs()) {
            if (bh.ov(com.tencent.mm.bn.c.cdc())) {
                bc.hV("ver" + com.tencent.mm.protocal.d.vAz);
            } else {
                ar.Hg();
                if (bh.by(bh.a((Long) com.tencent.mm.z.c.CU().get(77833, null), 0)) * 1000 >= 604800000) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(10719, new Object[]{com.tencent.mm.bn.c.ccY(), com.tencent.mm.bn.c.ccZ(), com.tencent.mm.bn.c.cda(), com.tencent.mm.bn.c.getRomInfo(), com.tencent.mm.bn.c.cdb(), "", com.tencent.mm.bn.c.cdc()});
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(77833, Long.valueOf(bh.Wo()));
                    x.d("MicroMsg.PostTaskHardwareInfo", "report PostTaskHardwareInfo done ");
                }
            }
        }
        if (ar.Hj() && !ar.Cs()) {
            Wo = bh.Wo();
            ar.Hg();
            if (bh.a((Long) com.tencent.mm.z.c.CU().get(331777, null), 0) < Wo) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(331777, Long.valueOf(Wo + 259200));
                com.tencent.mm.plugin.report.b.d.boc();
            }
            com.tencent.mm.plugin.report.b.d.n(3, 0, "");
        }
        com.tencent.mm.bn.b.run();
        if (ar.Hj()) {
            ar.Hg();
            c = bh.c((Long) com.tencent.mm.z.c.CU().get(74, null));
            if (10010 == r.idt && r.idu > 0) {
                c = bh.Wo() - ((long) r.idu);
                x.d("MicroMsg.PostTaskReportDataFlow", "GET DK_TEST_LAST_REPORT_DATAFLOW val:%d old:%d", new Object[]{Integer.valueOf(r.idu), Long.valueOf(c)});
                r.idu = 0;
            }
            Wo = bh.Wo();
            x.d("MicroMsg.PostTaskReportDataFlow", " now:%d old:%d diff:%d", new Object[]{Long.valueOf(Wo), Long.valueOf(c), Long.valueOf(Wo - c)});
            if ((Wo - c) * 1000 >= 86400000) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(74, Long.valueOf(Wo));
                if (com.tencent.mm.modelstat.q.Tg() == null) {
                    x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getNetStatStg() is null");
                } else {
                    Wo = (bh.Wp() / 86400000) - 1;
                    k iz = com.tencent.mm.modelstat.q.Tg().iz((int) Wo);
                    if (iz == null || iz.hRC != ((int) Wo)) {
                        String str = "MicroMsg.PostTaskReportDataFlow";
                        String str2 = "ERR: NetStatInfo:%d lastDate:%d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(iz == null ? -1 : iz.hRC);
                        objArr[1] = Long.valueOf(Wo);
                        x.e(str, str2, objArr);
                    } else if (com.tencent.mm.modelstat.q.Te() == null) {
                        x.e("MicroMsg.PostTaskReportDataFlow", "ERR: SubCoreStat.getMobileInfoStg() is null");
                    } else {
                        com.tencent.mm.modelstat.g.a SV = com.tencent.mm.modelstat.q.Te().SV();
                        if (SV == null) {
                            x.w("MicroMsg.PostTaskReportDataFlow", "SubCoreStat.getMobileInfoStg().checkInfo null , give default.");
                            SV = new com.tencent.mm.modelstat.g.a();
                        }
                        x.i("MicroMsg.PostTaskReportDataFlow", "last:%d peroid:%d [%d,%d][%d,%d][%d,%d][%d,%d] ispCode:%d subType:%d ispname:%s extra:%s", new Object[]{Long.valueOf(Wo), Integer.valueOf(iz.hRC), Integer.valueOf(iz.hRO), Integer.valueOf(iz.hSa), Integer.valueOf(iz.hRN), Integer.valueOf(iz.hRZ), Integer.valueOf(iz.hRM), Integer.valueOf(iz.hRY), Integer.valueOf(iz.hRL), Integer.valueOf(iz.hRX), Integer.valueOf(SV.hRw), Integer.valueOf(SV.fpn), SV.ispName, SV.extraInfo});
                        com.tencent.mm.plugin.report.service.g.pQN.h(10900, new Object[]{Long.valueOf((Wo * 86400000) / 1000), Integer.valueOf(iz.hRO), Integer.valueOf(iz.hSa), Integer.valueOf(iz.hRN), Integer.valueOf(iz.hRZ), Integer.valueOf(iz.hRM), Integer.valueOf(iz.hRY), Integer.valueOf(iz.hRL), Integer.valueOf(iz.hRX), Integer.valueOf(SV.hRw), Integer.valueOf(SV.fpn), SV.ispName, SV.extraInfo});
                    }
                }
            }
        } else {
            x.e("MicroMsg.PostTaskReportDataFlow", "Account is not ready");
        }
        ao.run();
        ar.Hg();
        if ((com.tencent.mm.platformtools.t.bz(com.tencent.mm.platformtools.t.c((Long) com.tencent.mm.z.c.CU().get(282881, null))) > 172800000 ? 1 : null) != null) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(282881, Long.valueOf(com.tencent.mm.platformtools.t.Wp()));
            com.tencent.mm.sdk.b.a.xef.m(new nw());
        }
        if (ar.Hj() && !ar.Cs()) {
            Wo = bh.Wo();
            ar.Hg();
            if (bh.a((Long) com.tencent.mm.z.c.CU().get(w.a.xnM, null), 0) < Wo) {
                c = 604800 + Wo;
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xnM, Long.valueOf(c));
                obj = q.FS();
                if (!TextUtils.isEmpty(obj)) {
                    ar.CG().a(new com.tencent.mm.modelsimple.r(obj), 0);
                }
            }
        }
        if (ar.Hj() && !ar.Cs()) {
            Wo = bh.Wo();
            ar.Hg();
            if (bh.a((Long) com.tencent.mm.z.c.CU().get(w.a.xnZ, null), 0) < Wo) {
                c = (bh.cgt() / 1000) + 86400;
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.xnZ, Long.valueOf(c));
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    if (defaultAdapter.getState() == 12) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11921, new Object[]{Integer.valueOf(1)});
                    } else if (defaultAdapter.getState() == 10) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(11921, new Object[]{Integer.valueOf(0)});
                    }
                }
            }
        }
        com.tencent.mm.booter.k.run();
        l.run();
        com.tencent.mm.booter.m.run();
        j.run();
        return false;
    }
}
