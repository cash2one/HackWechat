package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.buh;

class d$1 implements e {
    final /* synthetic */ d snM;

    d$1(d dVar) {
        this.snM = dVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.et("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + this.snM.skx.mStatus);
        if (i2 != 0) {
            a.es("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + i2);
            return;
        }
        buh com_tencent_mm_protocal_c_buh = (buh) this.snM.bHN();
        this.snM.skx.sjR = com_tencent_mm_protocal_c_buh.wBp;
        if (this.snM.skx.sjR != 0) {
            if (this.snM.skx.ske.doubleLinkSwitch(com_tencent_mm_protocal_c_buh.wVs) == 0) {
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal;
                if (1 == com_tencent_mm_protocal_c_buh.wVs) {
                    com_tencent_mm_plugin_voip_model_v2protocal = this.snM.skx.ske;
                    com_tencent_mm_plugin_voip_model_v2protocal.soY++;
                } else if (2 == com_tencent_mm_protocal_c_buh.wVs) {
                    com_tencent_mm_plugin_voip_model_v2protocal = this.snM.skx.ske;
                    com_tencent_mm_plugin_voip_model_v2protocal.soZ++;
                }
            }
            a.et("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + com_tencent_mm_protocal_c_buh.wbh + " member " + com_tencent_mm_protocal_c_buh.wFB + " key " + com_tencent_mm_protocal_c_buh.wbi + "report flag " + com_tencent_mm_protocal_c_buh.wBp + "switch to link type " + com_tencent_mm_protocal_c_buh.wVs + "doubleLinkSwitchReportStatus " + this.snM.skx.sjR + "mDoubleLinkSwitchSucToDirectCnt" + this.snM.skx.ske.soY + "mDoubleLinkSwitchSucToRelayCnt" + this.snM.skx.ske.soZ);
        }
    }
}
