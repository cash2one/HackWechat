package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class w extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT = null;

    public w(int i) {
        a aVar = new a();
        aVar.hmj = new aey();
        aVar.hmk = new aez();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.hmi = 143;
        aVar.hml = 38;
        aVar.hmm = 1000000038;
        this.gJQ = aVar.JZ();
        aey com_tencent_mm_protocal_c_aey = (aey) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aey.nhx = 1;
        com_tencent_mm_protocal_c_aey.wmO = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        aey com_tencent_mm_protocal_c_aey = (aey) this.gJQ.hmg.hmo;
        if (com_tencent_mm_protocal_c_aey.nhx != 1 || af.OG().hG(com_tencent_mm_protocal_c_aey.wmO) != null) {
            return a(eVar, this.gJQ, this);
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
        return -1;
    }

    public final int getType() {
        return 143;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            aey com_tencent_mm_protocal_c_aey = (aey) this.gJQ.hmg.hmo;
            aez com_tencent_mm_protocal_c_aez = (aez) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_aey.nhx == 0) {
                a(com_tencent_mm_protocal_c_aez.wmP);
            } else {
                ad adVar;
                List<ad> arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aez.wmQ.ksO; i4++) {
                    Object obj;
                    k kVar;
                    h hVar;
                    azb com_tencent_mm_protocal_c_azb = (azb) com_tencent_mm_protocal_c_aez.wmQ.wGf.get(i4);
                    int i5 = com_tencent_mm_protocal_c_aey.wmO;
                    x.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    ad adVar2 = new ad();
                    adVar2.hwR = new o(com_tencent_mm_protocal_c_azb.wGb).longValue();
                    com.tencent.mm.ad.b.c(adVar2.hwR, 3);
                    adVar2.hwT = i5;
                    adVar2.hwS = com_tencent_mm_protocal_c_azb.wGd;
                    if (com_tencent_mm_protocal_c_azb.wGd != 0) {
                        if (com_tencent_mm_protocal_c_azb.ksU == null || com_tencent_mm_protocal_c_azb.ksU.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            kVar = new k();
                            kVar.fWf = com_tencent_mm_protocal_c_azb.hvt;
                            kVar.fWo = com_tencent_mm_protocal_c_azb.hvx;
                            kVar.fWp = com_tencent_mm_protocal_c_azb.hvu;
                            kVar.fWq = com_tencent_mm_protocal_c_azb.hvv;
                            kVar.signature = com_tencent_mm_protocal_c_azb.hvw;
                            kVar.username = com_tencent_mm_protocal_c_azb.ksU;
                            arrayList2.add(kVar);
                            hVar = new h();
                            hVar.fWe = 3;
                            hVar.bA(true);
                            hVar.username = com_tencent_mm_protocal_c_azb.ksU;
                            hVar.hly = com_tencent_mm_protocal_c_azb.vUU;
                            hVar.hlx = com_tencent_mm_protocal_c_azb.vUV;
                            arrayList3.add(hVar);
                        } else {
                            ar.Hg();
                            af WO = c.EY().WO(com_tencent_mm_protocal_c_azb.ksU);
                            if (WO != null && WO.field_username.equals(com_tencent_mm_protocal_c_azb.ksU) && com.tencent.mm.l.a.fZ(WO.field_type)) {
                                adVar2.hwS = 2;
                            } else {
                                adVar2.hwS = 1;
                            }
                        }
                    }
                    adVar2.username = com_tencent_mm_protocal_c_azb.ksU;
                    adVar2.fpL = com_tencent_mm_protocal_c_azb.kub;
                    adVar2.hwZ = com_tencent_mm_protocal_c_azb.wGe;
                    adVar2.hxa = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_azb.wGe);
                    adVar2.hxb = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_azb.wGe);
                    adVar2.hwU = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_azb.kub);
                    adVar2.hwV = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_azb.kub);
                    adVar2.hwW = com_tencent_mm_protocal_c_azb.wGc;
                    adVar2.hwX = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_azb.wGc);
                    adVar2.hwY = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_azb.wGc);
                    i5 = 32;
                    if (!bh.ov(adVar2.Oz())) {
                        i5 = adVar2.Oz().charAt(0);
                    } else if (!bh.ov(adVar2.OA())) {
                        i5 = adVar2.OA().charAt(0);
                    } else if (!bh.ov(adVar2.Ow())) {
                        i5 = adVar2.Ow().charAt(0);
                    } else if (!bh.ov(adVar2.Ox())) {
                        i5 = adVar2.Ox().charAt(0);
                    }
                    if (i5 >= 97 && i5 <= 122) {
                        i5 = (char) (i5 - 32);
                    } else if (i5 < 65 || i5 > 90) {
                        i5 = 123;
                    }
                    adVar2.hlu = i5;
                    ar.Hg();
                    c.FI().fB(com_tencent_mm_protocal_c_azb.ksU, com_tencent_mm_protocal_c_azb.whR);
                    x.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + adVar2.Ov() + "  remark: " + adVar2.Oy());
                    ad adVar3 = adVar2;
                    arrayList.add(obj);
                    kVar = new k();
                    kVar.fWf = com_tencent_mm_protocal_c_azb.hvt;
                    kVar.fWo = com_tencent_mm_protocal_c_azb.hvx;
                    kVar.fWp = com_tencent_mm_protocal_c_azb.hvu;
                    kVar.fWq = com_tencent_mm_protocal_c_azb.hvv;
                    kVar.signature = com_tencent_mm_protocal_c_azb.hvw;
                    kVar.username = com_tencent_mm_protocal_c_azb.ksU;
                    arrayList2.add(kVar);
                    hVar = new h();
                    hVar.fWe = 3;
                    hVar.bA(true);
                    hVar.username = com_tencent_mm_protocal_c_azb.ksU;
                    hVar.hly = com_tencent_mm_protocal_c_azb.vUU;
                    hVar.hlx = com_tencent_mm_protocal_c_azb.vUV;
                    arrayList3.add(hVar);
                }
                HashMap hashMap = new HashMap();
                ae OI = af.OI();
                int i6 = com_tencent_mm_protocal_c_aey.wmO;
                x.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i6);
                Cursor a = OI.hhp.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i6 + "\"", null, 0);
                while (a.moveToNext()) {
                    adVar = new ad();
                    adVar.b(a);
                    hashMap.put(Long.valueOf(adVar.hwR), adVar);
                }
                a.close();
                for (ad adVar4 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(adVar4.hwR))) {
                        adVar = (ad) hashMap.get(Long.valueOf(adVar4.hwR));
                        Object obj2 = !bh.s(Long.valueOf(adVar.hwR), Long.valueOf(adVar4.hwR)) ? null : !bh.s(Integer.valueOf(adVar.hwS), Integer.valueOf(adVar4.hwS)) ? null : !bh.s(Integer.valueOf(adVar.hwT), Integer.valueOf(adVar4.hwT)) ? null : !bh.s(adVar.username, adVar4.username) ? null : !bh.s(adVar.fpL, adVar4.fpL) ? null : !bh.s(adVar.hwU, adVar4.hwU) ? null : !bh.s(adVar.hwV, adVar4.hwV) ? null : !bh.s(adVar.hwW, adVar4.hwW) ? null : !bh.s(adVar.hwX, adVar4.hwX) ? null : !bh.s(adVar.hwY, adVar4.hwY) ? null : !bh.s(adVar.hwZ, adVar4.hwZ) ? null : !bh.s(adVar.hxa, adVar4.hxa) ? null : !bh.s(adVar.hxb, adVar4.hxb) ? null : !bh.s(adVar.hls, adVar4.hls) ? null : !bh.s(adVar.hlt, adVar4.hlt) ? null : !bh.s(Integer.valueOf(adVar.hlu), Integer.valueOf(adVar4.hlu)) ? null : !bh.s(Integer.valueOf(adVar.hlv), Integer.valueOf(adVar4.hlv)) ? null : 1;
                        if (obj2 == null) {
                            af.OI().a(adVar4.hwR, adVar4);
                            hashMap.remove(Long.valueOf(adVar4.hwR));
                        }
                    } else {
                        af.OI().a(adVar4);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    m OI2 = af.OI();
                    x.d("MicroMsg.QQListStorage", "delete: QQ:" + longValue2);
                    if (OI2.hhp.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        OI2.b(5, OI2, String.valueOf(longValue2));
                    }
                }
                af.OF().H(arrayList2);
                n.JQ().H(arrayList3);
                ab abVar = new ab();
                abVar.hwJ = com_tencent_mm_protocal_c_aey.wmO;
                abVar.hwO = 0;
                abVar.hwN = (int) bh.Wo();
                abVar.fDt = 48;
                af.OG().a(abVar);
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    private static void a(aze com_tencent_mm_protocal_c_aze) {
        Map map;
        ab abVar;
        Cursor a = af.OG().hhp.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (a == null) {
            map = null;
        } else if (a.getCount() <= 0) {
            a.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < a.getCount(); i++) {
                a.moveToPosition(i);
                ab abVar2 = new ab();
                abVar2.b(a);
                map.put(Integer.valueOf(abVar2.hwJ), abVar2);
            }
            a.close();
        }
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_aze.ksO; i2++) {
            azd com_tencent_mm_protocal_c_azd = (azd) com_tencent_mm_protocal_c_aze.wGh.get(i2);
            x.d("MicroMsg.NetSceneGetQQGroup", "id:" + com_tencent_mm_protocal_c_azd.wmO + " name:" + com_tencent_mm_protocal_c_azd.wgG + " mem:" + com_tencent_mm_protocal_c_azd.wbk + " wei:" + com_tencent_mm_protocal_c_azd.wGg + " md5:" + com_tencent_mm_protocal_c_azd.vZU);
            if (com_tencent_mm_protocal_c_azd.wmO < 0) {
                abVar2 = null;
            } else {
                abVar2 = new ab();
                abVar2.hwJ = com_tencent_mm_protocal_c_azd.wmO;
                abVar2.hwQ = com_tencent_mm_protocal_c_azd.wgG;
                abVar2.hwK = com_tencent_mm_protocal_c_azd.wbk;
                abVar2.hwL = com_tencent_mm_protocal_c_azd.wGg;
                abVar2.hwP = com_tencent_mm_protocal_c_azd.vZU;
            }
            if (abVar2 == null) {
                x.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i2);
            } else if (abVar2.hwK != 0) {
                if (map != null) {
                    abVar = (ab) map.get(Integer.valueOf(abVar2.hwJ));
                } else {
                    abVar = null;
                }
                if (abVar == null) {
                    boolean z;
                    abVar2.hwM = (int) bh.Wo();
                    abVar2.hwN = (int) bh.Wo();
                    abVar2.hwO = 1;
                    ac OG = af.OG();
                    if (abVar2 != null) {
                        x.d("MicroMsg.QQGroupStorage", "insert: name:" + abVar2.Ot());
                        abVar2.fDt = -1;
                        if (((int) OG.hhp.insert("qqgroup", "grouopid", abVar2.Or())) >= 0) {
                            OG.doNotify();
                            z = true;
                            x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar2.Ot() + " ret:" + z);
                        }
                    }
                    z = false;
                    x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar2.Ot() + " ret:" + z);
                } else {
                    abVar.hwO = -1;
                    x.d("MicroMsg.NetSceneGetQQGroup", abVar2.Os() + " " + abVar.Os() + " " + abVar2.hwJ);
                    if (!abVar.Os().equals(abVar2.Os())) {
                        abVar2.hwN = (int) bh.Wo();
                        abVar2.hwO = 1;
                        abVar2.fDt = -1;
                        x.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + abVar2.Ot() + " ret:" + af.OG().a(abVar2));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                abVar = (ab) map.get(obj);
                if (abVar.hwO == 0) {
                    boolean z2;
                    ac OG2 = af.OG();
                    x.d("MicroMsg.QQGroupStorage", "delete: id:" + abVar.hwJ);
                    if (OG2.hhp.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        OG2.doNotify();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + abVar.Ot() + " ret:" + z2);
                    ae OI = af.OI();
                    x.d("MicroMsg.QQListStorage", "delete: GroupID:" + abVar.hwJ);
                    if (OI.hhp.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + abVar.Ot() + " ret:" + z2);
                }
            }
        }
    }
}
