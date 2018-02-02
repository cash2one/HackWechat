package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bum;
import com.tencent.mm.protocal.c.bun;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements e {
    final /* synthetic */ g snP;

    g$1(g gVar) {
        this.snP = gVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.et("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + this.snP.skx.mStatus);
        if (this.snP.skx.mStatus != 2) {
            a.es("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.snP.skx.mStatus + " should:2");
            return;
        }
        bun com_tencent_mm_protocal_c_bun = (bun) this.snP.bHN();
        this.snP.skx.ske.soH = com_tencent_mm_protocal_c_bun.wUD;
        this.snP.skx.ske.soI = com_tencent_mm_protocal_c_bun.wUE;
        this.snP.skx.ske.soJ = com_tencent_mm_protocal_c_bun.wUF;
        this.snP.skx.ske.soK = com_tencent_mm_protocal_c_bun.wUG;
        this.snP.skx.ske.soM = com_tencent_mm_protocal_c_bun.wUI;
        this.snP.skx.ske.soL = com_tencent_mm_protocal_c_bun.wUN;
        this.snP.skx.ske.spm = com_tencent_mm_protocal_c_bun.wVA;
        this.snP.skx.ske.som = com_tencent_mm_protocal_c_bun.wUv;
        this.snP.skx.ske.soN = com_tencent_mm_protocal_c_bun.wUP;
        this.snP.skx.yA(com_tencent_mm_protocal_c_bun.wUt);
        this.snP.skx.ske.son = com_tencent_mm_protocal_c_bun.wUw;
        a.et("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.snP.skx.ske.soH + ",audioTsdEdge = " + this.snP.skx.ske.soI + ",passthroughQosAlgorithm = " + this.snP.skx.ske.soJ + ",fastPlayRepair = " + this.snP.skx.ske.soK + ", audioDtx = " + this.snP.skx.ske.soM + ",switchtcpPktCnt = " + this.snP.skx.ske.sol + ",SvrCfgListV = " + this.snP.skx.ske.soL + ", setMaxBRForRelay=" + this.snP.skx.ske.soN + ",EnableDataAccept = " + this.snP.skx.ske.spm + ",WifiScanInterval = " + this.snP.skx.ske.son);
        this.snP.skx.ske.soO = com_tencent_mm_protocal_c_bun.wUM;
        a.et("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.snP.skx.ske.soO);
        this.snP.skx.ske.soP = com_tencent_mm_protocal_c_bun.wUQ;
        a.et("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + this.snP.skx.ske.soP);
        int netType = a.getNetType(ac.getContext());
        if (i == 0) {
            this.snP.skx.eQ(4);
            this.snP.skx.ske.nDx = com_tencent_mm_protocal_c_bun.wbh;
            this.snP.skx.ske.nDy = com_tencent_mm_protocal_c_bun.wbi;
            this.snP.skx.ske.nDF = com_tencent_mm_protocal_c_bun.wFB;
            g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(1), Integer.valueOf(netType)});
            if (com_tencent_mm_protocal_c_bun.wVz > 0) {
                long j = (long) (com_tencent_mm_protocal_c_bun.wVz * 1000);
                this.snP.skx.skq.J(j, j);
            }
            d.bGj().bHy();
            a.et("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.snP.skx.ske.nDx + ",memberid = " + this.snP.skx.ske.nDF + "VoipSyncInterval = " + com_tencent_mm_protocal_c_bun.wVz);
            this.snP.skx.skf.bGU();
        } else if (i == 4) {
            a.et("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + com_tencent_mm_protocal_c_bun.wbh + "," + com_tencent_mm_protocal_c_bun.wbi);
            switch (i2) {
                case h.CTRL_INDEX /*211*/:
                    this.snP.skx.ske.spH.skR = 12;
                    this.snP.skx.ske.spH.sld = 12;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(8), Integer.valueOf(netType)});
                    break;
                case 233:
                    this.snP.skx.ske.spH.skR = 12;
                    this.snP.skx.ske.spH.sld = 1;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(3), Integer.valueOf(netType)});
                    break;
                case 234:
                    this.snP.skx.ske.spH.skR = 13;
                    this.snP.skx.ske.spH.sld = 11;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(4), Integer.valueOf(netType)});
                    break;
                case 235:
                    this.snP.skx.ske.spH.skR = 13;
                    this.snP.skx.ske.spH.sld = 2;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(2), Integer.valueOf(netType)});
                    break;
                case JsApiGetSetting.CTRL_INDEX /*236*/:
                    this.snP.skx.ske.spH.skR = 12;
                    this.snP.skx.ske.spH.sld = 10;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(7), Integer.valueOf(netType)});
                    break;
                case bd.CTRL_BYTE /*237*/:
                    this.snP.skx.ske.spH.skR = 13;
                    this.snP.skx.ske.spH.sld = 9;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(2), Integer.valueOf(netType)});
                    break;
                case bc.CTRL_BYTE /*238*/:
                    this.snP.skx.sjE = true;
                    this.snP.skx.sjG = false;
                    this.snP.skx.sjF = false;
                    this.snP.skx.ske.soG = 0;
                    this.snP.skx.ske.soF = 0;
                    this.snP.skx.eQ(3);
                    this.snP.skx.ske.nDx = com_tencent_mm_protocal_c_bun.wbh;
                    this.snP.skx.ske.nDy = com_tencent_mm_protocal_c_bun.wbi;
                    this.snP.skx.ske.nDF = com_tencent_mm_protocal_c_bun.wFB;
                    this.snP.skx.skf.yF(((bum) ((g) kVar).bHO()).wOO);
                    return;
                case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                    x.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + com_tencent_mm_protocal_c_bun.wVB + " seconds!");
                    d.bGj().smZ = System.currentTimeMillis();
                    if (com_tencent_mm_protocal_c_bun.wVB == 0) {
                        d.bGj().sna = 30000;
                        break;
                    }
                    d.bGj().sna = (long) (com_tencent_mm_protocal_c_bun.wVB * 1000);
                    break;
                default:
                    this.snP.skx.ske.spH.skR = 12;
                    this.snP.skx.ske.spH.sld = 99;
                    g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(5), Integer.valueOf(netType)});
                    break;
            }
            this.snP.skx.ske.spH.skS = i2;
            this.snP.skx.p(1, i2, str);
        } else {
            this.snP.skx.ske.spH.skR = 12;
            this.snP.skx.ske.spH.skS = i2;
            this.snP.skx.ske.spH.sld = 99;
            g.pQN.a(11518, true, true, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(9), Integer.valueOf(netType)});
            this.snP.skx.p(1, -9004, "");
        }
    }
}
