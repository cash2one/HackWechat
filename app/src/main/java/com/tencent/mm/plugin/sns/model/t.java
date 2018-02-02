package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkn;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.an;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public final class t extends k implements com.tencent.mm.network.k {
    private static List<an> qUn = new LinkedList();
    private static c qUp;
    private static boolean qUq = true;
    b gJQ;
    e gJT;
    private String gze = "";
    private a qUo = new a(this);

    public t() {
        a aVar = new a();
        aVar.hmj = new bkn();
        aVar.hmk = new bko();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.hmi = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hml = 102;
        aVar.hmm = 1000000102;
        this.gJQ = aVar.JZ();
        ((bkn) this.gJQ.hmg.hmo).vRz = 256;
        this.gze = q.FS();
        if (qUq) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            String stringBuilder2 = stringBuilder.append(g.Dj().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + stringBuilder2);
            byte[] d = FileOp.d(stringBuilder2, 0, -1);
            if (d != null) {
                try {
                    qUp = (c) new c().aF(d);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (qUp == null) {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + qUp.raI.size());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
            qUq = false;
        }
    }

    protected final int Bh() {
        return 10;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hmP;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Dk();
        byte[] VD = bh.VD(bh.ou((String) g.Dj().CU().get(8195, null)));
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(VD);
        ((bkn) this.gJQ.hmg.hmo).vRA = com_tencent_mm_protocal_c_bdn;
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public static void ex(long j) {
        if (qUp == null) {
            qUp = new c();
        }
        qUp.raI.add(Long.valueOf(j));
    }

    public static void ey(long j) {
        if (qUp != null) {
            qUp.raI.remove(Long.valueOf(j));
        }
    }

    public static boolean ez(long j) {
        if (qUp != null && qUp.raI.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public static void buQ() {
        if (qUp != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dk();
            String stringBuilder2 = stringBuilder.append(g.Dj().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = qUp.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + qUp.raI.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public final boolean Kd() {
        return true;
    }

    public final int getType() {
        return JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bko com_tencent_mm_protocal_c_bko = (bko) ((b) qVar).hmh.hmo;
            LinkedList linkedList = com_tencent_mm_protocal_c_bko.vRD.ksP;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(com_tencent_mm_protocal_c_bko.vRA == null || com_tencent_mm_protocal_c_bko.vRA.wJD == null)) {
                    byte[] g = ad.g(((bkn) ((b) qVar).hmg.hmo).vRA.wJD.toByteArray(), com_tencent_mm_protocal_c_bko.vRA.wJD.toByteArray());
                    if (g != null && g.length > 0) {
                        g.Dk();
                        g.Dj().CU().set(8195, bh.by(g));
                    }
                }
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.qUo;
            aVar.mqJ = linkedList;
            aVar.mqK.sendEmptyMessage(0);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final boolean a(ol olVar, af afVar) {
        try {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(olVar.vXq.wJD.toByteArray());
            String str = new String(com_tencent_mm_protocal_c_bjv.wMW.wJD.toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            x.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + com_tencent_mm_protocal_c_bjv.vPO + " " + i.eq(com_tencent_mm_protocal_c_bjv.vPO) + " isPhoto " + z);
            if (z) {
                String eq = i.eq(com_tencent_mm_protocal_c_bjv.vPO);
                com.tencent.mm.plugin.sns.storage.k Lq = ae.bvz().Lq(com_tencent_mm_protocal_c_bjv.vIy);
                if (bh.ov(Lq.field_newerIds)) {
                    ae.bvz().em(com_tencent_mm_protocal_c_bjv.vIy, eq);
                } else {
                    String[] split = Lq.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (eq.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = eq;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    x.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + com_tencent_mm_protocal_c_bjv.vPO + " S: " + eq + " list " + Lq.field_newerIds + " newer " + str2);
                    if (z) {
                        ae.bvz().em(com_tencent_mm_protocal_c_bjv.vIy, str2);
                    }
                }
            }
            if (ae.bvv().eL(com_tencent_mm_protocal_c_bjv.vPO)) {
                x.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                return false;
            }
            com.tencent.mm.sdk.b.a.xef.m(new qa());
            ae.aNT().post(new 1(this, com_tencent_mm_protocal_c_bjv, afVar));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean b(ol olVar, af afVar) {
        try {
            boolean z;
            bjf com_tencent_mm_protocal_c_bjf = (bjf) new bjf().aF(olVar.vXq.wJD.toByteArray());
            long j = com_tencent_mm_protocal_c_bjf.vPO;
            long j2 = com_tencent_mm_protocal_c_bjf.wMC;
            bje com_tencent_mm_protocal_c_bje = com_tencent_mm_protocal_c_bjf.wMD;
            String str = com_tencent_mm_protocal_c_bjf.vGQ;
            if (str == null) {
                str = "";
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + com_tencent_mm_protocal_c_bje.ktN + " " + j + " " + str);
            com.tencent.mm.sdk.e.c c;
            boolean a;
            j bvA;
            String str2;
            switch (com_tencent_mm_protocal_c_bje.ktN) {
                case 9:
                    c = ae.bvA().c(j, (long) com_tencent_mm_protocal_c_bje.wMw, com_tencent_mm_protocal_c_bje.ktN);
                    if (c != null) {
                        c.bxZ();
                        a = ae.bvA().a(c.xjy, c);
                        ai.b(j, com_tencent_mm_protocal_c_bjf);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + a);
                        break;
                    }
                    break;
                case 10:
                    c = ae.bvA().c(j, com_tencent_mm_protocal_c_bje.wMz, com_tencent_mm_protocal_c_bje.ktN);
                    if (c != null) {
                        c.bxZ();
                        a = ae.bvA().a(c.xjy, c);
                        ai.b(j, com_tencent_mm_protocal_c_bjf);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + a);
                        break;
                    }
                    break;
                case 11:
                    bvA = ae.bvA();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j;
                    x.i("MicroMsg.SnsCommentStorage", "set sns del " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + bvA.hhp.fx("SnsComment", str2));
                    break;
                case 12:
                    bvA = ae.bvA();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j + " and talker = " + bh.ot(com_tencent_mm_protocal_c_bje.wFM);
                    x.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + bvA.hhp.fx("SnsComment", str2));
                    break;
                case 13:
                    b(com_tencent_mm_protocal_c_bjf, com_tencent_mm_protocal_c_bje, j, j2, str);
                    break;
                case 14:
                    c(com_tencent_mm_protocal_c_bjf, com_tencent_mm_protocal_c_bje, j, j2, str);
                    break;
                default:
                    a(com_tencent_mm_protocal_c_bjf, com_tencent_mm_protocal_c_bje, j, j2, str);
                    break;
            }
            if ((com_tencent_mm_protocal_c_bje.wMB & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            ae.aNT().post(new 2(this, z, com_tencent_mm_protocal_c_bje, afVar));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean eA(long j) {
        try {
            return a.a(j, null, bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyLimit"), 0), bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyLikeTimeLimit"), 0), bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return true;
        }
    }

    private static boolean a(bjf com_tencent_mm_protocal_c_bjf, bje com_tencent_mm_protocal_c_bje, long j, long j2, String str) {
        try {
            boolean a;
            int i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyLimit"), 0);
            int i2 = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i3 = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i > 0 || i2 > 0 || i3 > 0) && (com_tencent_mm_protocal_c_bje.ktN == 8 || com_tencent_mm_protocal_c_bje.ktN == 7)) {
                a = a.a(j, com_tencent_mm_protocal_c_bjf, i, i2, i3, true);
                if (ez(j)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "user open notify off");
                }
                if (!a) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bje.wMz + " " + com_tencent_mm_protocal_c_bje.wMw + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
                    if (a.a(j, com_tencent_mm_protocal_c_bjf)) {
                        return false;
                    }
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID  " + com_tencent_mm_protocal_c_bjf.wMD.wMz);
                    return false;
                }
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bje.wMz + " " + com_tencent_mm_protocal_c_bje.wMw + " actionLimit: " + i);
            if (ae.bvA().a(j, com_tencent_mm_protocal_c_bje.wFM, com_tencent_mm_protocal_c_bje.pbl, str)) {
                return false;
            }
            bje com_tencent_mm_protocal_c_bje2 = com_tencent_mm_protocal_c_bjf.wME;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = com_tencent_mm_protocal_c_bje.pbl;
            iVar.field_talker = com_tencent_mm_protocal_c_bje.wFM;
            iVar.field_type = com_tencent_mm_protocal_c_bje.ktN;
            iVar.field_curActionBuf = com_tencent_mm_protocal_c_bje.toByteArray();
            iVar.field_refActionBuf = com_tencent_mm_protocal_c_bje2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_isSilence = (com_tencent_mm_protocal_c_bje.wMB & 2) == 0 ? 0 : 1;
            if (com_tencent_mm_protocal_c_bje.ktN == 8 || com_tencent_mm_protocal_c_bje.ktN == 7) {
                iVar.field_commentSvrID = com_tencent_mm_protocal_c_bje.wMz;
                if (!a.a(j, com_tencent_mm_protocal_c_bjf)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + iVar.field_snsID + " " + iVar.field_commentSvrID);
                    return false;
                }
            }
            iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bje.wMw;
            if (!ai.a(j, com_tencent_mm_protocal_c_bjf)) {
                return false;
            }
            ae.bvA().b(iVar);
            j bvA = ae.bvA();
            if ((com_tencent_mm_protocal_c_bje.wMB & 2) != 0) {
                a = true;
            } else {
                a = false;
            }
            bvA.q(j, a);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean b(bjf com_tencent_mm_protocal_c_bjf, bje com_tencent_mm_protocal_c_bje, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bje.wMz + " " + com_tencent_mm_protocal_c_bje.wMw);
            if (com.tencent.mm.plugin.sns.lucky.a.g.bup()) {
                if (ae.bvA().a(j, com_tencent_mm_protocal_c_bje.wFM, com_tencent_mm_protocal_c_bje.pbl, str)) {
                    return false;
                }
                bje com_tencent_mm_protocal_c_bje2 = com_tencent_mm_protocal_c_bjf.wME;
                com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
                iVar.field_snsID = j;
                iVar.field_parentID = j2;
                iVar.field_createTime = com_tencent_mm_protocal_c_bje.pbl;
                iVar.field_talker = com_tencent_mm_protocal_c_bje.wFM;
                iVar.field_type = com_tencent_mm_protocal_c_bje.ktN;
                iVar.field_curActionBuf = com_tencent_mm_protocal_c_bje.toByteArray();
                iVar.field_refActionBuf = com_tencent_mm_protocal_c_bje2.toByteArray();
                iVar.field_clientId = str;
                iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bje.wMw;
                x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
                ai.c(j, com_tencent_mm_protocal_c_bjf);
                GV();
                ae.bvA().b(iVar);
                return true;
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            return false;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean c(bjf com_tencent_mm_protocal_c_bjf, bje com_tencent_mm_protocal_c_bje, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bje.wMz + " " + com_tencent_mm_protocal_c_bje.wMw);
            if (ae.bvA().a(j, com_tencent_mm_protocal_c_bje.wFM, com_tencent_mm_protocal_c_bje.pbl, str)) {
                return false;
            }
            bje com_tencent_mm_protocal_c_bje2 = com_tencent_mm_protocal_c_bjf.wME;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = com_tencent_mm_protocal_c_bje.pbl;
            iVar.field_talker = com_tencent_mm_protocal_c_bje.wFM;
            iVar.field_type = com_tencent_mm_protocal_c_bje.ktN;
            iVar.field_curActionBuf = com_tencent_mm_protocal_c_bje.toByteArray();
            iVar.field_refActionBuf = com_tencent_mm_protocal_c_bje2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bje.wMw;
            akb com_tencent_mm_protocal_c_akb = new akb();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bje.wMA);
            com_tencent_mm_protocal_c_akb.aF(n.a(com_tencent_mm_protocal_c_bje.wMA));
            x.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + com_tencent_mm_protocal_c_akb.fLR);
            ae.bvA().b(iVar);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static void buR() {
        for (an anVar : qUn) {
            if (anVar != null) {
                anVar.GW();
            }
        }
    }

    private static void GV() {
        for (an anVar : qUn) {
            if (anVar != null) {
                anVar.GV();
            }
        }
    }

    public static void a(an anVar) {
        if (!qUn.contains(anVar)) {
            qUn.add(anVar);
        }
    }

    public static void b(an anVar) {
        qUn.remove(anVar);
    }
}
