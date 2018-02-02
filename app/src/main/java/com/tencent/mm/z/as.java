package com.tencent.mm.z;

import android.content.SharedPreferences;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.i;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class as extends i implements c {
    private static a hgj = null;
    private final int hgg;
    private final f hgh;
    private final g hgi;

    public interface a {
        void a(f fVar, g gVar);
    }

    public as(int i) {
        boolean z = i == 702 || i == 701;
        Assert.assertTrue(z);
        this.hgg = i;
        if (i == 702) {
            this.hgh = new com.tencent.mm.protocal.i.a();
            this.hgi = new b();
            return;
        }
        this.hgh = new d();
        this.hgi = new e();
    }

    private q gR(int i) {
        x.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), bh.cgy());
        f fVar = (f) Kb();
        g gVar = this.hgi;
        SharedPreferences Hn = at.Hn();
        x.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(Hn.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        if (Hn.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.vAz) {
            fVar.vBj = this.hgg == 702 ? 12 : 16;
            com.tencent.mm.plugin.report.d.pPH.a(148, this.hgg == 702 ? 14 : 13, 1, false);
        } else {
            fVar.vBj = this.hgg == 702 ? 2 : 1;
        }
        fb fbVar = new fb();
        fbVar.vKU = i;
        fbVar.vJg = new bdn().bj(new byte[0]);
        fbVar.vJf = new bdn().bj(new byte[0]);
        bwv com_tencent_mm_protocal_c_bwv = new bwv();
        fbVar.vKS = com_tencent_mm_protocal_c_bwv;
        com_tencent_mm_protocal_c_bwv.vMD = "";
        com_tencent_mm_protocal_c_bwv.vMC = "";
        com_tencent_mm_protocal_c_bwv.wXK = "";
        cak com_tencent_mm_protocal_c_cak = new cak();
        fbVar.vKT = com_tencent_mm_protocal_c_cak;
        com_tencent_mm_protocal_c_cak.wnL = "";
        com_tencent_mm_protocal_c_cak.wnK = "";
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            String oVar;
            byte[] bArr;
            com.tencent.mm.kernel.g.Dk();
            String ou = bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(2, null));
            com.tencent.mm.kernel.g.Dk();
            o oVar2 = new o(bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(9, null), 0));
            if (bh.ov(ou)) {
                oVar = oVar2.toString();
            } else {
                oVar = ou;
            }
            com.tencent.mm.kernel.g.Dk();
            byte[] a = com.tencent.mm.kernel.g.Dh().Cq().a(oVar2.longValue(), "", this.hgg == 701);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = oVar;
            objArr[1] = oVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? "null" : bh.VT(bh.bv(a));
            x.i(str, str2, objArr);
            bdn com_tencent_mm_protocal_c_bdn = new bdn();
            if (bh.bw(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            fbVar.vKR = com_tencent_mm_protocal_c_bdn.bj(bArr);
            if (this.hgg == 702) {
                com.tencent.mm.protocal.i.a aVar = (com.tencent.mm.protocal.i.a) fVar;
                b bVar = (b) gVar;
                ee eeVar = new ee();
                eh ehVar = new eh();
                aVar.vAU.vJD = ehVar;
                aVar.vAU.vJE = eeVar;
                bArr = bh.VD(Hn.getString("_auth_key", ""));
                ef efVar = new ef();
                if (bh.bw(bArr)) {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 16, 1, false);
                    eeVar.vJa = new bdn().bj(new byte[0]);
                } else {
                    eeVar.vJa = new bdn().bj(bArr);
                    try {
                        efVar.aF(bArr);
                    } catch (Throwable e) {
                        com.tencent.mm.plugin.report.d.pPH.a(148, 15, 1, false);
                        x.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (efVar.vJB != null) {
                    ehVar.vJF = efVar.vJB;
                } else {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 17, 1, false);
                    ehVar.vJF = new bdn().bj(new byte[0]);
                    x.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                eeVar.vJw = fbVar;
                aVar.username = oVar;
                bVar.hZv = oVar;
                return this;
            }
            d dVar = (d) fVar;
            aqf com_tencent_mm_protocal_c_aqf = new aqf();
            aqd com_tencent_mm_protocal_c_aqd = new aqd();
            dVar.vAW.wwY = com_tencent_mm_protocal_c_aqf;
            dVar.vAW.wwZ = com_tencent_mm_protocal_c_aqd;
            com_tencent_mm_protocal_c_aqd.wwX = 2;
            com_tencent_mm_protocal_c_aqd.vJw = fbVar;
            com_tencent_mm_protocal_c_aqf.ksU = oVar;
            com.tencent.mm.kernel.g.Dk();
            ou = bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(3, null));
            com.tencent.mm.kernel.g.Dk();
            com_tencent_mm_protocal_c_aqf.vMp = bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(19, null));
            com_tencent_mm_protocal_c_aqf.vMB = ou;
            return this;
        }
        x.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
    }

    public final int Hm() {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dh();
            return com.tencent.mm.kernel.a.Cg();
        }
        x.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", bh.cgy());
        return 0;
    }

    public final q aW(int i, int i2) {
        return new as(i).gR(i2);
    }

    public static void a(a aVar) {
        hgj = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            bpb com_tencent_mm_protocal_c_bpb = gVar.vAZ;
            if (com_tencent_mm_protocal_c_bpb == null || com_tencent_mm_protocal_c_bpb.wRq == null) {
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(gVar.vBp));
            } else {
                int i3 = gVar.vAZ.wRq.vJp;
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i3));
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(47, Integer.valueOf(i3));
                com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Di().gPJ.hmV;
                if (eVar != null) {
                    eVar.bH((i3 & 1) == 0);
                }
            }
            x.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (hgj != null) {
                    hgj.a(fVar, gVar);
                    return;
                }
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.d.pPH.a(148, 18, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (com_tencent_mm_protocal_c_bpb == null || com_tencent_mm_protocal_c_bpb.wRs == null) {
                    x.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    return;
                } else {
                    a(true, gVar.vAZ.wRs.vMr, gVar.vAZ.wRs.vMs, gVar.vAZ.wRs.vMq);
                    return;
                }
            } else {
                return;
            }
        }
        x.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }

    public static void a(boolean z, il ilVar, asx com_tencent_mm_protocal_c_asx, aki com_tencent_mm_protocal_c_aki) {
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(ilVar == null ? -1 : ilVar.vOG);
        objArr[2] = Integer.valueOf(ilVar == null ? -1 : ilVar.vOH);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_aki == null ? -1 : com_tencent_mm_protocal_c_aki.ksO);
        objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_asx == null ? -1 : com_tencent_mm_protocal_c_asx.wAJ);
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_asx == null ? -1 : com_tencent_mm_protocal_c_asx.wAK);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_asx == null ? -1 : com_tencent_mm_protocal_c_asx.wAL);
        objArr[7] = com_tencent_mm_protocal_c_asx == null ? "null" : com_tencent_mm_protocal_c_asx.wAH;
        objArr[8] = com_tencent_mm_protocal_c_asx == null ? "null" : com_tencent_mm_protocal_c_asx.wAI;
        x.i(str, str2, objArr);
        if (com_tencent_mm_protocal_c_aki == null || com_tencent_mm_protocal_c_aki.ksP == null || com_tencent_mm_protocal_c_aki.ksP.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bh.cgy());
        } else if (com_tencent_mm_protocal_c_aki == null || com_tencent_mm_protocal_c_aki.ksP == null || com_tencent_mm_protocal_c_aki.ksP.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bh.cgy());
        } else {
            ik ikVar;
            com.tencent.mm.protocal.n.a fl;
            List linkedList = new LinkedList();
            linkedList.clear();
            if (ilVar != null) {
                Iterator it = ilVar.vOK.iterator();
                while (it.hasNext()) {
                    ikVar = (ik) it.next();
                    str = "";
                    if (ikVar.vOF != null) {
                        str = ikVar.vOF.cdp();
                    }
                    linkedList.add(new n(ikVar.type, ikVar.vOE.cdp(), ikVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(ikVar.type), Integer.valueOf(ikVar.port), ikVar.vOE.cdp());
                }
            }
            str2 = n.cy(linkedList);
            List linkedList2 = new LinkedList();
            if (ilVar != null) {
                Iterator it2 = ilVar.vOJ.iterator();
                while (it2.hasNext()) {
                    ikVar = (ik) it2.next();
                    str = "";
                    if (ikVar.vOF != null) {
                        str = ikVar.vOF.cdp();
                    }
                    linkedList2.add(new n(ikVar.type, ikVar.vOE.cdp(), ikVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(ikVar.type), Integer.valueOf(ikVar.port), ikVar.vOE.cdp());
                }
            }
            String cy = n.cy(linkedList2);
            x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", cy, str2);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().gQd.set(2, str2);
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().gQd.set(3, cy);
            if (com_tencent_mm_protocal_c_asx != null) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(6, com_tencent_mm_protocal_c_asx.wAH);
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(7, com_tencent_mm_protocal_c_asx.wAI);
                if (com_tencent_mm_protocal_c_asx.wAL != 0) {
                    int i;
                    com.tencent.mm.kernel.g.Dk();
                    s sVar = com.tencent.mm.kernel.g.Dj().gQd;
                    if (com_tencent_mm_protocal_c_asx.wAL > 60) {
                        i = 60;
                    } else {
                        i = com_tencent_mm_protocal_c_asx.wAL;
                    }
                    sVar.set(35, Integer.valueOf(i));
                }
                ad.m((long) com_tencent_mm_protocal_c_asx.wAJ, (long) com_tencent_mm_protocal_c_asx.wAM);
                fl = n.fl(com_tencent_mm_protocal_c_asx.wAH, com_tencent_mm_protocal_c_asx.wAI);
            } else {
                fl = null;
            }
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[com_tencent_mm_protocal_c_aki.ksP.size()];
            String[] strArr2 = new String[com_tencent_mm_protocal_c_aki.ksP.size()];
            int[] iArr = new int[com_tencent_mm_protocal_c_aki.ksP.size()];
            x.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(com_tencent_mm_protocal_c_aki.ksO));
            Iterator it3 = com_tencent_mm_protocal_c_aki.ksP.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                akh com_tencent_mm_protocal_c_akh = (akh) it3.next();
                x.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", com_tencent_mm_protocal_c_akh.wrB, com_tencent_mm_protocal_c_akh.wrC);
                strArr[i2] = com_tencent_mm_protocal_c_akh.wrB;
                strArr2[i2] = com_tencent_mm_protocal_c_akh.wrC;
                iArr[i2] = com_tencent_mm_protocal_c_akh.wrD;
                i2++;
                if (!(bh.ov(com_tencent_mm_protocal_c_akh.wrB) || bh.ov(com_tencent_mm_protocal_c_akh.wrC))) {
                    if (com_tencent_mm_protocal_c_akh.wrB.equals("short.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().gQd.set(24, com_tencent_mm_protocal_c_akh.wrC);
                        str4 = com_tencent_mm_protocal_c_akh.wrC;
                    } else if (com_tencent_mm_protocal_c_akh.wrB.equals("long.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().gQd.set(25, com_tencent_mm_protocal_c_akh.wrC);
                        str3 = com_tencent_mm_protocal_c_akh.wrC;
                    } else if (com_tencent_mm_protocal_c_akh.wrB.equals("support.weixin.qq.com") && !bh.ov(com_tencent_mm_protocal_c_akh.wrC)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", com_tencent_mm_protocal_c_akh.wrC).commit();
                    }
                }
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Di().gPJ.hmV;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!bh.ov(str3)) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(25, str3);
            }
            if (!bh.ov(str4)) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().gQd.set(24, str4);
            }
            if (eVar != null && fl != null) {
                eVar.a(z, str2, cy, fl.vBw, fl.vBx, fl.vBy, fl.vBz, str4, str3);
            }
        }
    }

    public static SharedPreferences Hn() {
        return at.Hn();
    }

    protected final k.d Ho() {
        return this.hgh;
    }

    public final k.e Hp() {
        return this.hgi;
    }

    public final int getType() {
        return this.hgh.Hr();
    }

    public final String getUri() {
        return this.hgh.getUri();
    }

    public static int b(q qVar) {
        g gVar = (g) qVar.Hp();
        x.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) qVar.Kb()).Hr()), Integer.valueOf(qVar.hashCode()), Integer.valueOf(gVar.vBb), bh.cgy());
        if (gVar.vBb != 0) {
            x.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.vBb));
            return gVar.vBb;
        }
        bpb com_tencent_mm_protocal_c_bpb = gVar.vAZ;
        int i = com_tencent_mm_protocal_c_bpb.wRp;
        if ((i & 1) != 0) {
            dv dvVar = com_tencent_mm_protocal_c_bpb.wRq;
            x.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(dvVar.vJo), Integer.valueOf(dvVar.vJn));
            rt rtVar = dvVar.vIY;
            byte[] a = com.tencent.mm.platformtools.n.a(dvVar.vIZ);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(rtVar.vJC.wJB);
            objArr[1] = Integer.valueOf(rtVar.vZG);
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = bh.VT(bh.bv(a));
            x.d(str, str2, objArr);
            byte[] a2 = com.tencent.mm.platformtools.n.a(rtVar.vJC);
            byte[] bArr = r0.vAY;
            if (bh.bw(a2)) {
                com.tencent.mm.plugin.report.d.pPH.a(148, 24, 1, false);
                x.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a2 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a2.length);
                objArr2[1] = bh.VT(bh.bv(a2));
                objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr2[3] = bh.VT(bh.bv(bArr));
                x.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(rtVar.vZG, a2, bArr, pByteArray, 0);
                a2 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.length);
                objArr[2] = bh.VT(bh.bv(a2));
                x.i(str, str2, objArr);
            }
            gVar.vBa = a2 != null ? a2 : new byte[0];
            if ((r12 & 4) != 0) {
                x.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (bh.bw(a2)) {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 26, 1, false);
                    x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.be(new byte[0]);
                    gVar.vBb = 2;
                } else {
                    a2 = MMProtocalJni.aesDecrypt(a, a2);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                    objArr3[1] = bh.VT(bh.bv(a));
                    objArr3[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
                    objArr3[3] = bh.VT(bh.bv(a2));
                    x.d(str4, str, objArr3);
                    if (bh.bw(a2)) {
                        com.tencent.mm.plugin.report.d.pPH.a(148, 25, 1, false);
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.be(new byte[0]);
                        gVar.vBb = 2;
                    } else {
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", bh.VT(bh.bv(a2)));
                        gVar.be(a2);
                        gVar.vBb = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.d.pPH.a(148, 27, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.be(a);
                gVar.vBb = 1;
            }
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
            gVar.be(new byte[0]);
            gVar.vBb = 2;
        }
        if ((i & 2) != 0) {
            gVar.hZv = com_tencent_mm_protocal_c_bpb.wRr.ksU;
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        return gVar.vBb;
    }
}
