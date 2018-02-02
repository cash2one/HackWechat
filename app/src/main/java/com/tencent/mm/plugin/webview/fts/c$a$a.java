package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.mm.bc.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.fts.a.e;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.bro;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.LinkedList;

class c$a$a implements Runnable {
    d hjF;
    public volatile boolean kpn;
    final /* synthetic */ a tlY;

    private c$a$a(a aVar) {
        this.tlY = aVar;
    }

    public final void run() {
        if (!Thread.interrupted()) {
            if (bh.ov(this.hjF.fod)) {
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "error query %d %d %d %d %s %d", new Object[]{Integer.valueOf(this.hjF.hKY), Integer.valueOf(this.hjF.scene), Integer.valueOf(this.hjF.tjP), Integer.valueOf(this.hjF.tjR), this.hjF.lEK, Integer.valueOf(this.hjF.offset)});
                return;
            }
            e eVar;
            LinkedList linkedList;
            bro com_tencent_mm_protocal_c_bro;
            switch (this.hjF.scene) {
                case 3:
                case 16:
                case 20:
                    ((m) g.k(m.class)).addSOSHistory(this.hjF.fod);
                    break;
            }
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "start New NetScene %s ,  %d", new Object[]{this.hjF.fod, Integer.valueOf(this.hjF.fDl)});
            if (a.a(this.tlY) != null) {
                ar.CG().c(a.a(this.tlY));
            }
            if (this.hjF.tjQ == null || this.hjF.tjQ.isEmpty()) {
                int i;
                long currentTimeMillis;
                Object obj = this.hjF.fod;
                int i2 = this.hjF.scene;
                int i3 = this.hjF.hKY;
                if (this.hjF.tjP == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(obj) && b.QN()) {
                    int QO = b.QO();
                    if (QO <= 0 || obj.length() <= QO) {
                        if ((i2 == 3 || i2 == 20) && (r0 != 0 || i3 == 8)) {
                            i = 1;
                            if (i != 0) {
                                eVar = (e) this.tlY.tlU.tlP.NY(this.hjF.fod);
                                currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
                                com.tencent.mm.plugin.report.service.g.pQN.h(14717, new Object[]{this.hjF.fod, Integer.valueOf(s.GJ()), Integer.valueOf(eVar.mOV.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hjF.scene)});
                                if (this.kpn) {
                                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                    return;
                                }
                                f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
                                a.a(this.tlY, a.a(this.hjF));
                                if (eVar != null) {
                                    linkedList = new LinkedList();
                                    for (e.a aVar : eVar.mOV) {
                                        com_tencent_mm_protocal_c_bro = new bro();
                                        com_tencent_mm_protocal_c_bro.ksU = aVar.userName;
                                        com_tencent_mm_protocal_c_bro.wTn = aVar.tnl;
                                        com_tencent_mm_protocal_c_bro.kub = aVar.bgo;
                                        com_tencent_mm_protocal_c_bro.vXO = aVar.iIj;
                                        com_tencent_mm_protocal_c_bro.hvy = aVar.gfN;
                                        com_tencent_mm_protocal_c_bro.vIO = aVar.desc;
                                        linkedList.add(com_tencent_mm_protocal_c_bro);
                                    }
                                    a.a(this.tlY).ao(linkedList);
                                }
                                ar.CG().a(a.a(this.tlY).getType(), this.tlY.tlU);
                                ar.CG().a(a.a(this.tlY), 0);
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tlY).getType())});
                            }
                        } else if ((i2 == 14 || i2 == 22) && i3 == 8) {
                            i = 1;
                            if (i != 0) {
                                eVar = (e) this.tlY.tlU.tlP.NY(this.hjF.fod);
                                currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
                                com.tencent.mm.plugin.report.service.g.pQN.h(14717, new Object[]{this.hjF.fod, Integer.valueOf(s.GJ()), Integer.valueOf(eVar.mOV.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hjF.scene)});
                                if (this.kpn) {
                                    f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
                                    a.a(this.tlY, a.a(this.hjF));
                                    if (eVar != null) {
                                        linkedList = new LinkedList();
                                        for (e.a aVar2 : eVar.mOV) {
                                            com_tencent_mm_protocal_c_bro = new bro();
                                            com_tencent_mm_protocal_c_bro.ksU = aVar2.userName;
                                            com_tencent_mm_protocal_c_bro.wTn = aVar2.tnl;
                                            com_tencent_mm_protocal_c_bro.kub = aVar2.bgo;
                                            com_tencent_mm_protocal_c_bro.vXO = aVar2.iIj;
                                            com_tencent_mm_protocal_c_bro.hvy = aVar2.gfN;
                                            com_tencent_mm_protocal_c_bro.vIO = aVar2.desc;
                                            linkedList.add(com_tencent_mm_protocal_c_bro);
                                        }
                                        a.a(this.tlY).ao(linkedList);
                                    }
                                    ar.CG().a(a.a(this.tlY).getType(), this.tlY.tlU);
                                    ar.CG().a(a.a(this.tlY), 0);
                                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tlY).getType())});
                                }
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                return;
                            }
                        } else if (i2 == 16) {
                            i = 1;
                            if (i != 0) {
                                eVar = (e) this.tlY.tlU.tlP.NY(this.hjF.fod);
                                currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
                                com.tencent.mm.plugin.report.service.g.pQN.h(14717, new Object[]{this.hjF.fod, Integer.valueOf(s.GJ()), Integer.valueOf(eVar.mOV.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hjF.scene)});
                                if (this.kpn) {
                                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                    return;
                                }
                                f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
                                a.a(this.tlY, a.a(this.hjF));
                                if (eVar != null) {
                                    linkedList = new LinkedList();
                                    for (e.a aVar22 : eVar.mOV) {
                                        com_tencent_mm_protocal_c_bro = new bro();
                                        com_tencent_mm_protocal_c_bro.ksU = aVar22.userName;
                                        com_tencent_mm_protocal_c_bro.wTn = aVar22.tnl;
                                        com_tencent_mm_protocal_c_bro.kub = aVar22.bgo;
                                        com_tencent_mm_protocal_c_bro.vXO = aVar22.iIj;
                                        com_tencent_mm_protocal_c_bro.hvy = aVar22.gfN;
                                        com_tencent_mm_protocal_c_bro.vIO = aVar22.desc;
                                        linkedList.add(com_tencent_mm_protocal_c_bro);
                                    }
                                    a.a(this.tlY).ao(linkedList);
                                }
                                ar.CG().a(a.a(this.tlY).getType(), this.tlY.tlU);
                                ar.CG().a(a.a(this.tlY), 0);
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tlY).getType())});
                            }
                        }
                    }
                }
                i = 0;
                if (i != 0) {
                    eVar = (e) this.tlY.tlU.tlP.NY(this.hjF.fod);
                    currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", new Object[]{Long.valueOf(currentTimeMillis)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(14717, new Object[]{this.hjF.fod, Integer.valueOf(s.GJ()), Integer.valueOf(eVar.mOV.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hjF.scene)});
                    if (this.kpn) {
                        f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
                        a.a(this.tlY, a.a(this.hjF));
                        if (eVar != null) {
                            linkedList = new LinkedList();
                            for (e.a aVar222 : eVar.mOV) {
                                com_tencent_mm_protocal_c_bro = new bro();
                                com_tencent_mm_protocal_c_bro.ksU = aVar222.userName;
                                com_tencent_mm_protocal_c_bro.wTn = aVar222.tnl;
                                com_tencent_mm_protocal_c_bro.kub = aVar222.bgo;
                                com_tencent_mm_protocal_c_bro.vXO = aVar222.iIj;
                                com_tencent_mm_protocal_c_bro.hvy = aVar222.gfN;
                                com_tencent_mm_protocal_c_bro.vIO = aVar222.desc;
                                linkedList.add(com_tencent_mm_protocal_c_bro);
                            }
                            a.a(this.tlY).ao(linkedList);
                        }
                        ar.CG().a(a.a(this.tlY).getType(), this.tlY.tlU);
                        ar.CG().a(a.a(this.tlY), 0);
                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tlY).getType())});
                    }
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                    return;
                }
            }
            eVar = null;
            if (this.kpn) {
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                return;
            }
            f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
            a.a(this.tlY, a.a(this.hjF));
            if (eVar != null) {
                linkedList = new LinkedList();
                for (e.a aVar2222 : eVar.mOV) {
                    com_tencent_mm_protocal_c_bro = new bro();
                    com_tencent_mm_protocal_c_bro.ksU = aVar2222.userName;
                    com_tencent_mm_protocal_c_bro.wTn = aVar2222.tnl;
                    com_tencent_mm_protocal_c_bro.kub = aVar2222.bgo;
                    com_tencent_mm_protocal_c_bro.vXO = aVar2222.iIj;
                    com_tencent_mm_protocal_c_bro.hvy = aVar2222.gfN;
                    com_tencent_mm_protocal_c_bro.vIO = aVar2222.desc;
                    linkedList.add(com_tencent_mm_protocal_c_bro);
                }
                a.a(this.tlY).ao(linkedList);
            }
            ar.CG().a(a.a(this.tlY).getType(), this.tlY.tlU);
            ar.CG().a(a.a(this.tlY), 0);
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tlY).getType())});
        }
    }
}
