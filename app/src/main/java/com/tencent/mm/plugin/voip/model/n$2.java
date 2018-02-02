package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.sdk.platformtools.ak.a;

class n$2 implements a {
    final /* synthetic */ n sny;

    n$2(n nVar) {
        this.sny = nVar;
    }

    public final boolean uF() {
        e eVar = this.sny.siL;
        eVar.skm++;
        if (this.sny.siL.ske.nDx == 0) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", g.zh() + "double link switch roomId == 0 ");
            n.a(this.sny).TG();
        } else {
            this.sny.siL.ske.app2EngineDataEx(this.sny.siL.ske.spe, this.sny.siL.ske.spf, this.sny.siL.ske.spg, 0, 0);
            if (!this.sny.siL.skl && 1 == this.sny.siL.ske.field_mGetValidSample) {
                this.sny.siL.skl = true;
                this.sny.siL.skn = this.sny.siL.skm;
            }
            if (1 == this.sny.siL.sjR) {
                this.sny.siL.sjR = 15;
            }
            if (true == this.sny.siL.skl && this.sny.siL.skm - this.sny.siL.skn == this.sny.siL.sjR && (this.sny.siL.ske.soV & 1) == 0) {
                this.sny.siL.skn = this.sny.siL.skm;
                int isDCSameLan = this.sny.siL.ske.isDCSameLan();
                int currentConnType = this.sny.siL.ske.getCurrentConnType();
                if (1 == isDCSameLan && 1 == currentConnType) {
                    com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = " + isDCSameLan);
                    eVar = this.sny.siL;
                    eVar.skm++;
                } else {
                    int i = this.sny.siL.ske.getcurstrategy();
                    int isRelayConnReady = this.sny.siL.ske.isRelayConnReady();
                    int isDCReady = this.sny.siL.ske.isDCReady();
                    isDCSameLan = this.sny.siL.sjR - 3;
                    if (isDCSameLan > 15) {
                        isDCSameLan = 15;
                    }
                    this.sny.siL.ske.app2EngineLinkQualityEx(isDCSameLan, n.b(this.sny));
                    new d(this.sny.siL.ske.nDx, this.sny.siL.ske.nDy, this.sny.siL.ske.nDF, currentConnType, isRelayConnReady, isDCReady, i, n.b(this.sny), this.sny.siL.ske.field_realLinkQualityInfoBuffLen).bHM();
                    v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.sny.siL.ske;
                    com_tencent_mm_plugin_voip_model_v2protocal.soX++;
                    com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.sny.siL.sjR + " isFirstValidSampleSet " + this.sny.siL.skl + " mGetValidSample " + this.sny.siL.ske.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.sny.siL.ske.soX + "mTimerCounter " + this.sny.siL.skm + "mLastSwitchTimer " + this.sny.siL.skn);
                }
            }
        }
        return true;
    }
}
