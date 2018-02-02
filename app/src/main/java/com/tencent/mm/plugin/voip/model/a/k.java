package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.buz;
import com.tencent.mm.protocal.c.bva;

public final class k extends n<buz, bva> {
    public k(blm com_tencent_mm_protocal_c_blm) {
        a aVar = new a();
        aVar.hmj = new buz();
        aVar.hmk = new bva();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        aVar.hmi = 765;
        aVar.hml = 765;
        aVar.hmm = 1000000765;
        this.gJQ = aVar.JZ();
        buz com_tencent_mm_protocal_c_buz = (buz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_buz.wbh = com_tencent_mm_protocal_c_blm.wbh;
        com_tencent_mm_protocal_c_buz.wOO = com_tencent_mm_protocal_c_blm.wOO;
        com_tencent_mm_protocal_c_buz.vWK = com_tencent_mm_protocal_c_blm.vWK;
        com_tencent_mm_protocal_c_buz.wOP = com_tencent_mm_protocal_c_blm.wOP;
        com_tencent_mm_protocal_c_buz.wOQ = com_tencent_mm_protocal_c_blm.wOQ;
        com_tencent_mm_protocal_c_buz.wOR = com_tencent_mm_protocal_c_blm.wOR;
        com_tencent_mm_protocal_c_buz.wOS = com_tencent_mm_protocal_c_blm.wOS;
        com_tencent_mm_protocal_c_buz.wOT = com_tencent_mm_protocal_c_blm.wOT;
        com_tencent_mm_protocal_c_buz.wOU = com_tencent_mm_protocal_c_blm.wOU;
        com_tencent_mm_protocal_c_buz.wOV = com_tencent_mm_protocal_c_blm.wOV;
        com_tencent_mm_protocal_c_buz.wOW = com_tencent_mm_protocal_c_blm.wOW;
        com_tencent_mm_protocal_c_buz.wOX = com_tencent_mm_protocal_c_blm.wOX;
        com_tencent_mm_protocal_c_buz.wOY = com_tencent_mm_protocal_c_blm.wOY;
    }

    public final int getType() {
        return 765;
    }

    public final e bHJ() {
        return new e(this) {
            final /* synthetic */ k snT;

            {
                this.snT = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    bva com_tencent_mm_protocal_c_bva = (bva) this.snT.bHN();
                    if (com_tencent_mm_protocal_c_bva.wWA == 0 || com_tencent_mm_protocal_c_bva.wWB == 0) {
                        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + com_tencent_mm_protocal_c_bva.wWB);
                    } else if (this.snT.skx.sjJ != 1) {
                        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.snT.skx.sjJ);
                    } else {
                        this.snT.skx.sjJ = 2;
                        this.snT.skx.sjL = com_tencent_mm_protocal_c_bva.wWw;
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.snT.skx.ske;
                        if (com_tencent_mm_plugin_voip_model_v2protocal.spn != 0) {
                            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                            return;
                        }
                        com_tencent_mm_plugin_voip_model_v2protocal.spn = com_tencent_mm_protocal_c_bva.wWw;
                        com_tencent_mm_plugin_voip_model_v2protocal.field_SpeedTestSvrParaArray = com.tencent.mm.plugin.voip.b.a.a(com_tencent_mm_protocal_c_bva);
                        com_tencent_mm_plugin_voip_model_v2protocal.StartSpeedTest(com_tencent_mm_protocal_c_bva.wWw, com_tencent_mm_protocal_c_bva.wWB);
                    }
                } catch (Exception e) {
                    this.snT.skx.sjJ = 0;
                }
            }
        };
    }
}
