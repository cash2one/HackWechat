package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.LinkedList;

public final class o {
    e siL = null;
    buo snA = new buo();
    private bud snB = null;
    private int snC = 0;

    public o(e eVar) {
        this.siL = eVar;
    }

    private void a(bud com_tencent_mm_protocal_c_bud) {
        if (com_tencent_mm_protocal_c_bud == null) {
            a.es("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.snC++;
            return;
        }
        if (this.snB == null) {
            this.snB = new bud();
        }
        for (int i = 0; i < com_tencent_mm_protocal_c_bud.ksO; i++) {
            this.snB.ksP.add((buc) com_tencent_mm_protocal_c_bud.ksP.get(i));
        }
        this.snB.ksO = this.snB.ksP.size();
    }

    private void b(bud com_tencent_mm_protocal_c_bud) {
        if (this.snB != null && this.snB.ksO > 0) {
            for (int i = 0; i < this.snB.ksO; i++) {
                com_tencent_mm_protocal_c_bud.ksP.add((buc) this.snB.ksP.get(i));
            }
            com_tencent_mm_protocal_c_bud.ksO = com_tencent_mm_protocal_c_bud.ksP.size();
            bHI();
        }
    }

    public final void bHI() {
        if (this.snB != null) {
            this.snB.ksP.clear();
            this.snB.ksO = 0;
            this.snB = null;
            this.snC = 0;
        }
    }

    public final int a(bud com_tencent_mm_protocal_c_bud, boolean z, int i) {
        if (this.siL.ske.nDx == 0) {
            a.es("MicroMsg.Voip.VoipSyncHandle", g.zh() + "failed to do voip sync , roomid = 0");
        } else if (this.siL.skk) {
            a.es("MicroMsg.Voip.VoipSyncHandle", g.zh() + "voip syncing, push to cache...");
            a(com_tencent_mm_protocal_c_bud);
        } else {
            bud com_tencent_mm_protocal_c_bud2;
            this.siL.skk = true;
            if (com_tencent_mm_protocal_c_bud == null) {
                com_tencent_mm_protocal_c_bud2 = new bud();
                com_tencent_mm_protocal_c_bud2.ksO = 0;
                com_tencent_mm_protocal_c_bud2.ksP = new LinkedList();
            } else {
                com_tencent_mm_protocal_c_bud2 = com_tencent_mm_protocal_c_bud;
            }
            b(com_tencent_mm_protocal_c_bud2);
            this.snC = 0;
            if (this.siL.ski == null) {
                this.siL.ski = "".getBytes();
            }
            a.et("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + com_tencent_mm_protocal_c_bud2.ksO + ",syncKey.length:" + this.siL.ski.length + ",selector:" + i);
            new m(this.siL.ske.nDx, com_tencent_mm_protocal_c_bud2, this.siL.ski, this.siL.ske.nDy, i).bHM();
        }
        return 0;
    }

    public final void a(bve com_tencent_mm_protocal_c_bve, int i) {
        a.et("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + com_tencent_mm_protocal_c_bve.ktm);
        if (com_tencent_mm_protocal_c_bve.ktm == 1) {
            h hVar;
            this.siL.sjD = true;
            if (1 == i) {
                hVar = this.siL.ske.spH;
                if (0 == hVar.slt) {
                    hVar.slt = System.currentTimeMillis();
                    a.et("MicroMsg.VoipDailReport", "accept received timestamp:" + hVar.slt);
                }
            }
            if (3 == i) {
                hVar = this.siL.ske.spH;
                if (0 == hVar.slu) {
                    hVar.slu = System.currentTimeMillis();
                    a.et("MicroMsg.VoipDailReport", "sync accept received timestamp:" + hVar.slu);
                }
            }
            a.et("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: " + i);
            this.siL.skf.aSR();
            d.bGj().smS.bHH();
            this.siL.sjE = true;
            if (this.siL.sjG) {
                this.siL.sjG = false;
                if (this.siL.sjC) {
                    a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.siL.bGu();
                } else if (this.siL.sjF) {
                    a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.siL.p(1, -9000, "");
                } else {
                    a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(11519, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(2)});
            this.siL.bGz();
            this.siL.bGB();
        } else if (com_tencent_mm_protocal_c_bve.ktm == 6) {
            a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.siL.sjG = true;
            this.siL.ske.soF = 1;
            this.siL.bGz();
        } else if (com_tencent_mm_protocal_c_bve.ktm == 8) {
            a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.siL.ske.spH.skS = h.CTRL_INDEX;
            this.siL.ske.spH.skR = 11;
            this.siL.ske.spH.sld = 12;
            com.tencent.mm.plugin.report.service.g.pQN.h(11519, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(3)});
            this.siL.p(1, h.CTRL_INDEX, "");
            this.siL.bGB();
        } else if (com_tencent_mm_protocal_c_bve.ktm == 2) {
            a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.siL.ske.spH.skR = 103;
            this.siL.ske.spH.sld = 4;
            this.siL.ske.spH.slk = (int) (System.currentTimeMillis() - this.siL.ske.spH.beginTime);
            com.tencent.mm.plugin.report.service.g.pQN.h(11519, new Object[]{Integer.valueOf(d.bGj().bHp()), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(1)});
            this.siL.bGB();
            this.siL.p(4, 0, "");
        } else if (com_tencent_mm_protocal_c_bve.ktm == 3) {
            this.siL.ske.spH.sld = 5;
        } else if (com_tencent_mm_protocal_c_bve.ktm == 4) {
            a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.siL.mStatus < 6) {
                this.siL.ske.spH.sle = 1;
            }
            this.siL.ske.spH.skR = 110;
            this.siL.p(6, 0, "");
            this.siL.bGB();
        } else {
            a.et("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + com_tencent_mm_protocal_c_bve.ktm);
        }
    }

    public final void a(but com_tencent_mm_protocal_c_but) {
        ar.Dm().F(new 1(this, com_tencent_mm_protocal_c_but));
    }

    public final void b(but com_tencent_mm_protocal_c_but) {
        e eVar = this.siL;
        eVar.ske.sog = com_tencent_mm_protocal_c_but.vKf.wJD.toByteArray();
        eVar.bGA();
    }

    public final void c(bdn com_tencent_mm_protocal_c_bdn) {
        int aQ = a.aQ(com_tencent_mm_protocal_c_bdn.wJD.toByteArray());
        a.et("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + aQ);
        e eVar = this.siL;
        aQ &= 255;
        if (8 == aQ || 9 == aQ) {
            eVar.sjW = aQ;
        } else {
            eVar.sjU = aQ;
            eVar.sjS = aQ;
        }
        if (1 == aQ || 3 == aQ) {
            eVar.yw(2);
        }
        eVar.skf.yE(aQ);
    }

    public final void o(k kVar) {
        x.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.siL.skk = false;
        bvg com_tencent_mm_protocal_c_bvg = (bvg) ((m) kVar).bHN();
        this.siL.ske.parseSyncKeyBuff(this.siL.ski, this.siL.ski.length);
        int i = this.siL.ske.field_statusSyncKey;
        int i2 = this.siL.ske.field_relayDataSyncKey;
        int i3 = this.siL.ske.field_connectingStatusKey;
        this.siL.ske.parseSyncKeyBuff(com_tencent_mm_protocal_c_bvg.vRA.wJD.toByteArray(), com_tencent_mm_protocal_c_bvg.vRA.wJB);
        int i4 = this.siL.ske.field_statusSyncKey;
        int i5 = this.siL.ske.field_relayDataSyncKey;
        int i6 = this.siL.ske.field_connectingStatusKey;
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.siL.ski = com_tencent_mm_protocal_c_bvg.vRA.wJD.toByteArray();
        x.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + com_tencent_mm_protocal_c_bvg.vPq);
        LinkedList linkedList = com_tencent_mm_protocal_c_bvg.wWI.ksP;
        if (!(linkedList == null || linkedList.size() == 0)) {
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) kVar).bHL());
            for (int i7 = 0; i7 < linkedList.size(); i7++) {
                buc com_tencent_mm_protocal_c_buc = (buc) linkedList.get(i7);
                int i8 = com_tencent_mm_protocal_c_buc.vXp;
                x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:" + i8);
                if (i8 == 1) {
                    if (i4 > i) {
                        if (this.siL.ske.nDx == 0) {
                            a.es("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                bve com_tencent_mm_protocal_c_bve = (bve) new bve().aF(com_tencent_mm_protocal_c_buc.vXq.wJD.toByteArray());
                                a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + com_tencent_mm_protocal_c_buc.nkp + ",itemStatus =  " + com_tencent_mm_protocal_c_bve.ktm);
                                a(com_tencent_mm_protocal_c_bve, 3);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 2) {
                    if (i5 > i2) {
                        if (this.siL.ske.nDx == 0) {
                            a.es("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                but com_tencent_mm_protocal_c_but = (but) new but().aF(com_tencent_mm_protocal_c_buc.vXq.wJD.toByteArray());
                                a.et("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + com_tencent_mm_protocal_c_but.ktN + ",from user = " + com_tencent_mm_protocal_c_buc.nkp);
                                if (com_tencent_mm_protocal_c_but.ktN == 5) {
                                    a(com_tencent_mm_protocal_c_but);
                                } else if (com_tencent_mm_protocal_c_but.ktN == 3) {
                                    this.siL.aM(com_tencent_mm_protocal_c_but.vKf.wJD.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_but.vKf == null || com_tencent_mm_protocal_c_but.vKf.wJD == null)) {
                                        this.snA.wUn = com_tencent_mm_protocal_c_but;
                                    }
                                } else if (com_tencent_mm_protocal_c_but.ktN == 2) {
                                    this.siL.aL(com_tencent_mm_protocal_c_but.vKf.wJD.toByteArray());
                                    if (!(com_tencent_mm_protocal_c_but.vKf == null || com_tencent_mm_protocal_c_but.vKf.wJD == null)) {
                                        this.snA.wUm = com_tencent_mm_protocal_c_but;
                                    }
                                } else if (com_tencent_mm_protocal_c_but.ktN == 1) {
                                    b(com_tencent_mm_protocal_c_but);
                                }
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i8 == 3 && i6 > i3) {
                    if (this.siL.ske.nDx == 0) {
                        x.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            bdn bk = new bdn().bk(com_tencent_mm_protocal_c_buc.vXq.wJD.toByteArray());
                            if (com_tencent_mm_protocal_c_buc.nkp.equals(q.FS())) {
                                a.es("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(bk);
                            }
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
            }
        }
        x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.snB != null && this.snB.ksO > 0) || this.snC > 0) {
            a(null, false, 7);
        }
    }
}
