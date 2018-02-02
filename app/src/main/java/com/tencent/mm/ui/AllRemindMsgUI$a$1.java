package com.tencent.mm.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.AllRemindMsgUI.a;
import com.tencent.mm.ui.AllRemindMsgUI.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class AllRemindMsgUI$a$1 implements Runnable {
    final /* synthetic */ k flZ;
    final /* synthetic */ a xDH;

    AllRemindMsgUI$a$1(a aVar, k kVar) {
        this.xDH = aVar;
        this.flZ = kVar;
    }

    public final void run() {
        List<bca> list = ((afk) ((s) this.flZ).hFi.hmh.hmo).wnv;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (bca com_tencent_mm_protocal_c_bca : list) {
                d dVar = new d(this.xDH.xDG);
                dVar.xDM = com_tencent_mm_protocal_c_bca;
                dVar.timestamp = ((long) com_tencent_mm_protocal_c_bca.lOD) * 1000;
                dVar.fpn = com_tencent_mm_protocal_c_bca.wFj;
                dVar.xDN = com_tencent_mm_protocal_c_bca.wIn;
                if (com_tencent_mm_protocal_c_bca.wFj == 1) {
                    asr com_tencent_mm_protocal_c_asr = new asr();
                    try {
                        com_tencent_mm_protocal_c_asr.aF(com_tencent_mm_protocal_c_bca.vYR.oz);
                    } catch (IOException e) {
                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e.toString());
                    }
                    dVar.title = com_tencent_mm_protocal_c_asr.fon;
                    dVar.username = com_tencent_mm_protocal_c_asr.ksU;
                    dVar.fqm = com_tencent_mm_protocal_c_asr.vHe;
                    if (dVar.username != null) {
                        com.tencent.mm.storage.x WO;
                        if (com.tencent.mm.z.s.eV(dVar.username)) {
                            String string;
                            ar.Hg();
                            WO = c.EY().WO(dVar.username);
                            if (WO != null) {
                                dVar.fpL = WO.AQ() == null ? WO.AP() : WO.AQ();
                            }
                            if (bh.ov(dVar.fpL)) {
                                string = this.xDH.xDG.getString(R.l.dSN);
                            } else {
                                string = dVar.fpL;
                            }
                            dVar.fpL = string;
                        } else {
                            ar.Hg();
                            WO = c.EY().WO(dVar.username);
                            dVar.fpL = WO.AQ() == null ? WO.AP() : WO.AQ();
                        }
                    }
                } else if (com_tencent_mm_protocal_c_bca.wFj == 2) {
                    vf vfVar = new vf();
                    try {
                        vfVar.aF(com_tencent_mm_protocal_c_bca.vYR.oz);
                    } catch (IOException e2) {
                        x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] %s", e2.toString());
                    }
                    dVar.title = vfVar.fon;
                    dVar.fqd = vfVar.vGR;
                    dVar.wer = vfVar.vGS;
                }
                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] getRemind:%s", dVar);
                linkedList.add(dVar);
            }
            AllRemindMsgUI.a(this.xDH.xDG, linkedList);
        }
        ag.y(new 1(this));
    }
}
