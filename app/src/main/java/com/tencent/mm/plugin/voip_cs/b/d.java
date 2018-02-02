package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.f;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.btl;
import com.tencent.mm.protocal.c.btn;
import com.tencent.mm.protocal.c.btr;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.protocal.c.btx;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Arrays;
import java.util.List;

public final class d implements e {
    public int nDH = 0;
    public int sko = 0;
    public a swO;
    public int swP = 0;
    public int swQ = 0;
    public int swR = 0;
    public byte[] swS = null;
    public int swT = 0;
    public int swU = 0;
    public int swV = 0;
    public String swW = "";
    public int swX = 0;
    public int swY = 999;
    public ak swZ = new ak(Looper.getMainLooper(), new 1(this), true);
    public int swl = 0;
    public ak sxa = new ak(Looper.getMainLooper(), new 2(this), true);

    public final void bIY() {
        ar.CG().a(818, this);
        ar.CG().a(new f(b.bIS().nEG.sod, b.bIS().nEG.nDy, this.swP), 0);
    }

    private static void b(int i, int i2, k kVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + i2);
            return;
        }
        btu com_tencent_mm_protocal_c_btu = (btu) ((com.tencent.mm.plugin.voip_cs.b.c.d) kVar).gJQ.hmh.hmo;
        x.i("MicroMsg.voipcs.VoipCSService", "roomid " + com_tencent_mm_protocal_c_btu.wUT + " key " + com_tencent_mm_protocal_c_btu.wbi + "relay addr cnt " + com_tencent_mm_protocal_c_btu.vJP.size());
        List<btl> list = com_tencent_mm_protocal_c_btu.vJP;
        bth com_tencent_mm_protocal_c_bth = new bth();
        for (btl com_tencent_mm_protocal_c_btl : list) {
            btg com_tencent_mm_protocal_c_btg = new btg();
            b.bIS();
            com_tencent_mm_protocal_c_btg.wQd = a.ML(com_tencent_mm_protocal_c_btl.wvP);
            com_tencent_mm_protocal_c_btg.wFo = com_tencent_mm_protocal_c_btl.wFo;
            com_tencent_mm_protocal_c_bth.wUy.add(com_tencent_mm_protocal_c_btg);
        }
        com_tencent_mm_protocal_c_bth.wUx = list.size();
        b.bIS().nEG.a(com_tencent_mm_protocal_c_bth, com_tencent_mm_protocal_c_bth, null, 0, 0);
    }

    public final void a(btz com_tencent_mm_protocal_c_btz) {
        if (com_tencent_mm_protocal_c_btz.wVd > this.swP && b.bIT().swV != 3) {
            x.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + com_tencent_mm_protocal_c_btz.wVd + ",calleeMemberId:" + com_tencent_mm_protocal_c_btz.wVe + ",calleeStatus:" + com_tencent_mm_protocal_c_btz.wVf + ",calleeSubStatus:" + com_tencent_mm_protocal_c_btz.wVg + ",recv roomId:" + com_tencent_mm_protocal_c_btz.wUT + ",recv roomKey:" + com_tencent_mm_protocal_c_btz.wbi);
            if (b.bIS().nEG.sod == 0 || b.bIS().nEG.sod == com_tencent_mm_protocal_c_btz.wUT) {
                this.swP = com_tencent_mm_protocal_c_btz.wVd;
                this.swl = com_tencent_mm_protocal_c_btz.wVe;
                this.swQ = com_tencent_mm_protocal_c_btz.wVf;
                this.swR = com_tencent_mm_protocal_c_btz.wVg;
                b.bIU().swl = this.swl;
                if (this.swQ == 2) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                    this.swZ.TG();
                    bIY();
                    b.bIS().nEG.nDy = com_tencent_mm_protocal_c_btz.wbi;
                    x.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + com_tencent_mm_protocal_c_btz.wUT + ",roomkey:" + com_tencent_mm_protocal_c_btz.wbi);
                    this.swS = com_tencent_mm_protocal_c_btz.wVh != null ? com_tencent_mm_protocal_c_btz.wVh.toByteArray() : null;
                    if (b.bIS().nEG.field_capInfo != null && this.swS != null) {
                        int i;
                        c bIU = b.bIU();
                        x.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
                        if (bIU.swy == 0) {
                            bIU.swK = (int) (System.currentTimeMillis() / 1000);
                            bIU.swy = (long) (bIU.swK - bIU.swI);
                        }
                        b.bIS().nEG.sof = this.swS;
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(b.bIS().nEG.sof));
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.swS.length);
                        if (b.bIS().nEG.sof != null && b.bIS().nEG.exchangeCabInfo(b.bIS().nEG.sof, b.bIS().nEG.sof.length) < 0) {
                            x.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                        }
                        if (b.bIS().nEG.soi == null) {
                            i = 0;
                        } else {
                            i = b.bIS().nEG.soi.length;
                        }
                        if (b.bIS().nEG.setConfigInfo(b.bIS().nEG.soc, b.bIS().nEG.sod, b.bIS().nEG.nDF, b.bIS().nEG.nDy, b.bIS().nEG.field_peerId, 1, b.bIS().nEG.soj, b.bIS().nEG.sok, b.bIS().nEG.soh, i, b.bIS().nEG.soi, this.swY, 1, b.bIS().nEG.netType, b.bIS().nEG.spa, b.bIS().nEG.spb, 255, 0) != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[]{Integer.valueOf(b.bIS().nEG.setConfigInfo(b.bIS().nEG.soc, b.bIS().nEG.sod, b.bIS().nEG.nDF, b.bIS().nEG.nDy, b.bIS().nEG.field_peerId, 1, b.bIS().nEG.soj, b.bIS().nEG.sok, b.bIS().nEG.soh, i, b.bIS().nEG.soi, this.swY, 1, b.bIS().nEG.netType, b.bIS().nEG.spa, b.bIS().nEG.spb, 255, 0))});
                        }
                        if (b.bIS().nEG.connectToPeer() != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", new Object[]{Integer.valueOf(b.bIS().nEG.connectToPeer())});
                        }
                        if (this.sxa.cfK()) {
                            this.sxa.J(50000, 50000);
                        }
                        b.bIU().swr = 1;
                        return;
                    }
                    return;
                } else if (this.swQ != 0 && this.swQ != 1 && this.swQ == 3) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    b.bIU().bjS = 5;
                    b.bIU().bIV();
                    b.bIU().swv = 2;
                    if (this.swR == 1) {
                        b.bIU().swn = 12;
                    } else if (this.swR == 3) {
                        b.bIU().swn = 99;
                    }
                    if (this.swO != null) {
                        this.swO.yX(1);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + b.bIS().nEG.sod + ",recv roomId:" + com_tencent_mm_protocal_c_btz.wUT + ",current and recv not equal!!");
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 && i != 4) {
                this.swX = -1;
                this.swO.onError(10);
            } else if (kVar.getType() == 823) {
                if (i2 == 406) {
                    x.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    return;
                }
                b.bIU().bjS = 1;
                this.swX = 823;
                this.swO.onError(i2);
            } else if (kVar.getType() != 880 && kVar.getType() != 818 && kVar.getType() == 455) {
                this.swO.ew("", "");
            }
        } else if (kVar.getType() == 823) {
            btg com_tencent_mm_protocal_c_btg;
            btr com_tencent_mm_protocal_c_btr = (btr) ((c) kVar).gJQ.hmh.hmo;
            long j = com_tencent_mm_protocal_c_btr.wUT;
            long j2 = com_tencent_mm_protocal_c_btr.wbi;
            List<btl> list = com_tencent_mm_protocal_c_btr.vJP;
            List<btl> list2 = com_tencent_mm_protocal_c_btr.wVc;
            this.nDH = com_tencent_mm_protocal_c_btr.wUY;
            this.swY = com_tencent_mm_protocal_c_btr.wVb;
            x.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.swY);
            b.bIS().nEG.sok = com_tencent_mm_protocal_c_btr.nDO;
            this.swT = com_tencent_mm_protocal_c_btr.nDI;
            b.bIS().nEG.spa = com_tencent_mm_protocal_c_btr.nDT;
            b.bIS().nEG.spb = com_tencent_mm_protocal_c_btr.wFF.toByteArray();
            b.bIS().nEG.soj = com_tencent_mm_protocal_c_btr.nDP;
            bth com_tencent_mm_protocal_c_bth = new bth();
            for (btl com_tencent_mm_protocal_c_btl : list) {
                com_tencent_mm_protocal_c_btg = new btg();
                b.bIS();
                com_tencent_mm_protocal_c_btg.wQd = a.ML(com_tencent_mm_protocal_c_btl.wvP);
                com_tencent_mm_protocal_c_btg.wFo = com_tencent_mm_protocal_c_btl.wFo;
                com_tencent_mm_protocal_c_bth.wUy.add(com_tencent_mm_protocal_c_btg);
            }
            com_tencent_mm_protocal_c_bth.wUx = list.size();
            bth com_tencent_mm_protocal_c_bth2 = new bth();
            for (btl com_tencent_mm_protocal_c_btl2 : list2) {
                com_tencent_mm_protocal_c_btg = new btg();
                b.bIS();
                com_tencent_mm_protocal_c_btg.wQd = a.ML(com_tencent_mm_protocal_c_btl2.wvP);
                com_tencent_mm_protocal_c_btg.wFo = com_tencent_mm_protocal_c_btl2.wFo;
                com_tencent_mm_protocal_c_bth2.wUy.add(com_tencent_mm_protocal_c_btg);
            }
            com_tencent_mm_protocal_c_bth2.wUx = list2.size();
            b.bIS().nEG.sod = j;
            b.bIS().nEG.nDy = j2;
            x.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            b.bIS().nEG.spk = com_tencent_mm_protocal_c_btr.wUZ;
            b.bIS().nEG.spl = com_tencent_mm_protocal_c_btr.wVa;
            buq com_tencent_mm_protocal_c_buq = new buq();
            com_tencent_mm_protocal_c_buq.wWd = 0;
            com_tencent_mm_protocal_c_buq.wWe = 0;
            com_tencent_mm_protocal_c_buq.wWf = 0;
            com_tencent_mm_protocal_c_buq.userName = "";
            com_tencent_mm_protocal_c_buq.mBX = "";
            if (b.bIS().nEG.a(com_tencent_mm_protocal_c_bth, com_tencent_mm_protocal_c_bth, com_tencent_mm_protocal_c_bth, com_tencent_mm_protocal_c_buq) != 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            c bIU = b.bIU();
            r3 = this.swW;
            x.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            bIU.swj = j;
            bIU.nDy = j2;
            bIU.swk = r3;
            if (this.swZ.cfK()) {
                if (this.nDH > 0) {
                    j = (long) (this.nDH * 1000);
                    this.swZ.J(j, j);
                } else {
                    this.swZ.J(4000, 4000);
                }
            }
            bIU = b.bIU();
            x.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (bIU.swI != 0) {
                bIU.swJ = (int) (System.currentTimeMillis() / 1000);
            }
        } else if (kVar.getType() == 818) {
            btz com_tencent_mm_protocal_c_btz = (btz) ((f) kVar).gJQ.hmh.hmo;
            x.i("MicroMsg.voipcs.VoipCSService", "sync status = " + com_tencent_mm_protocal_c_btz.wVf + ",notifySeq = " + com_tencent_mm_protocal_c_btz.wVd);
            a(com_tencent_mm_protocal_c_btz);
        } else if (kVar.getType() == 880) {
            btn com_tencent_mm_protocal_c_btn = (btn) ((com.tencent.mm.plugin.voip_cs.b.c.a) kVar).gJQ.hmh.hmo;
            if (b.bIS().nEG.sod == com_tencent_mm_protocal_c_btn.wUT && b.bIS().nEG.nDy == com_tencent_mm_protocal_c_btn.wbi) {
                x.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            ar.CG().b(880, this);
            b.bIU().yY(com.tencent.mm.plugin.voip_cs.b.a.a.bJa().snl.bIH());
        } else if (kVar.getType() == 455) {
            j jVar = (j) kVar;
            r3 = "";
            String str2 = "";
            if (jVar.kER == null || jVar.kER.size() <= 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            } else {
                bfd com_tencent_mm_protocal_c_bfd = (bfd) jVar.kER.get(0);
                r3 = com_tencent_mm_protocal_c_bfd.vUU;
                str2 = com_tencent_mm_protocal_c_bfd.wsB.wJF;
            }
            this.swO.ew(r3, str2);
        } else if (kVar.getType() == g.CTRL_INDEX) {
            b(i, i2, kVar);
        } else if (kVar.getType() == 312) {
            btx com_tencent_mm_protocal_c_btx = (btx) ((com.tencent.mm.plugin.voip_cs.b.c.e) kVar).gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_btx.wUT == b.bIS().nEG.sod && com_tencent_mm_protocal_c_btx.wbi == b.bIS().nEG.nDy) {
                x.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
        }
    }
}
