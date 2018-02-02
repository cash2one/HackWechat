package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bkg;
import com.tencent.mm.protocal.c.bkh;
import com.tencent.mm.protocal.c.bkk;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.kd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.t;
import com.tencent.mm.z.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class r extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    int gLV = 0;
    private c gLY = new 1(this);
    private c gLZ = new 2(this);
    boolean lbP = false;
    int qQY;
    private bnp qUa;
    private bnp qUb;
    long qUc = 0;
    private int qUd = 0;
    private tu qUe;
    int qUf;
    String qUg = "";
    HashMap<String, aqr> qUh = new HashMap();
    HashMap<String, Integer> qUi = new HashMap();
    String qUj = "";

    static /* synthetic */ void a(r rVar) {
        if (rVar.qUi.isEmpty()) {
            a.xef.c(rVar.gLY);
            a.xef.c(rVar.gLZ);
            if (rVar.gLV != 0 && !bh.ov(rVar.qUg)) {
                String str = rVar.qUb.wQn == null ? "" : rVar.qUb.wQn.nGJ;
                int size = rVar.qUb.wQo.vYd.size();
                x.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", new Object[]{rVar.qUb.nGJ, Integer.valueOf(size), rVar.qUg, str});
                o.w(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{rVar.qUb.nGJ, Integer.valueOf(size), rVar.qUg, str}));
            }
        }
    }

    public r(String str, int i, int i2, List<String> list, bnp com_tencent_mm_protocal_c_bnp, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, aqs com_tencent_mm_protocal_c_aqs, boolean z, LinkedList<bdo> linkedList2, bkf com_tencent_mm_protocal_c_bkf, com.tencent.mm.bq.b bVar, String str3) {
        int i6;
        String str4;
        this.qUa = com_tencent_mm_protocal_c_bnp;
        this.qQY = i3;
        this.qUf = i5;
        b.a aVar = new b.a();
        aVar.hmj = new bkg();
        aVar.hmk = new bkh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
        aVar.hml = 97;
        aVar.hmm = 1000000097;
        this.gJQ = aVar.JZ();
        bkg com_tencent_mm_protocal_c_bkg = (bkg) this.gJQ.hmg.hmo;
        if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_bnp.qYu.vFI.vFD)) {
            kd kdVar = new kd();
            kdVar.vQT = com_tencent_mm_protocal_c_bnp.qYu.vFI.vFD;
            com_tencent_mm_protocal_c_bkg.wNK = kdVar;
        }
        u.b hy = u.GK().hy(com_tencent_mm_protocal_c_aqs.fqu);
        if (hy != null) {
            String str5;
            this.qUe = new tu();
            this.qUe.fMo.fMp = hy.getString("prePublishId", "");
            this.qUe.fMo.url = hy.getString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
            this.qUe.fMo.fMr = hy.getString("preUsername", "");
            this.qUe.fMo.fMs = hy.getString("preChatName", "");
            this.qUe.fMo.fMt = hy.getInt("preMsgIndex", 0);
            this.qUe.fMo.fMx = hy.getInt("sendAppMsgScene", 0);
            this.qUe.fMo.fMy = hy.getInt("getA8KeyScene", 0);
            this.qUe.fMo.fMz = hy.getString("referUrl", null);
            this.qUe.fMo.fMA = hy.getString("adExtStr", null);
            this.qUe.fMo.fMB = str3;
            str5 = "";
            if (com_tencent_mm_protocal_c_bnp.rtA != null) {
                blt com_tencent_mm_protocal_c_blt = new blt();
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(com_tencent_mm_protocal_c_bnp.rtA, 0));
                    if (com_tencent_mm_protocal_c_blt.wPn != null) {
                        str5 = com_tencent_mm_protocal_c_blt.wPn.nbS;
                    }
                } catch (Exception e) {
                }
            }
            if (bh.ov(str5) && com_tencent_mm_protocal_c_bnp.wQn != null) {
                str5 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
            }
            com_tencent_mm_protocal_c_bkg.wNJ = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qUe.fMo.fMp, this.qUe.fMo.fMr, this.qUe.fMo.fMs, Integer.valueOf(t.N(this.qUe.fMo.fMr, this.qUe.fMo.fMs)), Integer.valueOf(this.qUe.fMo.fMy), str5});
        }
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(str.getBytes());
        String str6 = "MicroMsg.NetSceneSnsPost";
        String str7 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bdn.wJB);
        if (bVar == null) {
            i6 = 0;
        } else {
            i6 = bVar.oz.length;
        }
        objArr[2] = Integer.valueOf(i6);
        x.i(str6, str7, objArr);
        com_tencent_mm_protocal_c_bkg.wMW = com_tencent_mm_protocal_c_bdn;
        com_tencent_mm_protocal_c_bkg.wNE = i;
        com_tencent_mm_protocal_c_bkg.wyb = i2;
        com_tencent_mm_protocal_c_bkg.vGQ = str2;
        this.qUd = i;
        if (com.tencent.mm.platformtools.r.icV) {
            com_tencent_mm_protocal_c_bkg.wMW = new bdn();
            x.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList linkedList3 = new LinkedList();
        if (list != null && list.size() > 0) {
            str4 = "";
            for (String str52 : list) {
                bdo com_tencent_mm_protocal_c_bdo = new bdo();
                com_tencent_mm_protocal_c_bdo.UA(str52);
                linkedList3.add(com_tencent_mm_protocal_c_bdo);
                str4 = str4 + "; + " + str52;
            }
            x.d("MicroMsg.NetSceneSnsPost", "post with list : " + str4);
        }
        com_tencent_mm_protocal_c_bkg.wNg = linkedList3;
        com_tencent_mm_protocal_c_bkg.wNf = linkedList3.size();
        com_tencent_mm_protocal_c_bkg.wNF = i4;
        str4 = "MicroMsg.NetSceneSnsPost";
        str6 = "setObjectSource: %d, clientid:%s fromScene:%s, score:%d";
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(i5);
        objArr2[1] = str2;
        objArr2[2] = com_tencent_mm_protocal_c_bkg.wNJ;
        objArr2[3] = Integer.valueOf(com_tencent_mm_protocal_c_aqs.wyt != null ? com_tencent_mm_protocal_c_aqs.wyt.wMI : 0);
        x.i(str4, str6, objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                com_tencent_mm_protocal_c_bkg.wNl = linkedList2;
                com_tencent_mm_protocal_c_bkg.wNk = linkedList2.size();
            } else {
                com_tencent_mm_protocal_c_bkg.wym = linkedList2;
                com_tencent_mm_protocal_c_bkg.wNm = linkedList2.size();
            }
        }
        x.d("MicroMsg.NetSceneSnsPost", "setObjectSource " + i5);
        com_tencent_mm_protocal_c_bkg.wNG = i5;
        bos com_tencent_mm_protocal_c_bos = new bos();
        if (!bh.ov(com_tencent_mm_protocal_c_aqs.token)) {
            com_tencent_mm_protocal_c_bos.wRe = com_tencent_mm_protocal_c_aqs.token;
            com_tencent_mm_protocal_c_bos.wRf = com_tencent_mm_protocal_c_aqs.wyk;
            com_tencent_mm_protocal_c_bkg.wEF = com_tencent_mm_protocal_c_bos;
        }
        if (!(linkedList == null || linkedList.isEmpty())) {
            com_tencent_mm_protocal_c_bkg.wAO = linkedList.size();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                bjq com_tencent_mm_protocal_c_bjq = new bjq();
                com_tencent_mm_protocal_c_bjq.wMU = l.longValue();
                com_tencent_mm_protocal_c_bkg.wyh.add(com_tencent_mm_protocal_c_bjq);
            }
            x.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + com_tencent_mm_protocal_c_bkg.wyh.toString());
        }
        com_tencent_mm_protocal_c_bkg.wyn = com_tencent_mm_protocal_c_bkf;
        if (!bh.ov(com_tencent_mm_protocal_c_aqs.wyp)) {
            com_tencent_mm_protocal_c_bkg.wNo = new bkk();
        }
        if (com_tencent_mm_protocal_c_bkf != null) {
            x.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{com_tencent_mm_protocal_c_bkf.vHY, com_tencent_mm_protocal_c_bkf.vHZ, com_tencent_mm_protocal_c_bkf.vIa});
        }
        if (bVar != null) {
            com_tencent_mm_protocal_c_bkg.wNI = new bdn().b(bVar);
        }
        com_tencent_mm_protocal_c_bkg.wNN = com_tencent_mm_protocal_c_aqs.wyt;
        m xo = ae.bvv().xo(this.qQY);
        if (xo != null && ((xo.field_type == 1 || xo.field_type == 15) && com_tencent_mm_protocal_c_bnp.wQo != null && com_tencent_mm_protocal_c_bnp.wQo.vYd != null && com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0 && com_tencent_mm_protocal_c_aqs.wyc != null && com_tencent_mm_protocal_c_aqs.wyc.size() == com_tencent_mm_protocal_c_bnp.wQo.vYd.size())) {
            str7 = ae.getAccSnsPath();
            Iterator it2 = com_tencent_mm_protocal_c_bnp.wQo.vYd.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) it2.next();
                if (com_tencent_mm_protocal_c_aqr.ktN == 2 || com_tencent_mm_protocal_c_aqr.ktN == 6) {
                    aqp com_tencent_mm_protocal_c_aqp = new aqp();
                    com_tencent_mm_protocal_c_aqp.njA = com_tencent_mm_protocal_c_aqr.ktN == 2 ? 2 : 1;
                    if (com_tencent_mm_protocal_c_aqr.ktN == 6) {
                        com.tencent.mm.plugin.sight.base.a Js = d.Js(am.r(str7, com_tencent_mm_protocal_c_aqr.nGJ) + i.p(com_tencent_mm_protocal_c_aqr));
                        if (Js != null) {
                            com_tencent_mm_protocal_c_aqp.wxA = (int) Math.round(((double) Js.mxs) / 1000.0d);
                        }
                    }
                    try {
                        com_tencent_mm_protocal_c_aqp.vHW = ((aqu) new aqu().aF(ae.bvk().eS((long) ((aox) com_tencent_mm_protocal_c_aqs.wyc.get(i7)).wvG).rpt)).wyF;
                    } catch (Exception e2) {
                    }
                    x.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aqp.vHW), Integer.valueOf(com_tencent_mm_protocal_c_aqp.wxA), Integer.valueOf(com_tencent_mm_protocal_c_aqp.njA)});
                    com_tencent_mm_protocal_c_bkg.wNM.add(com_tencent_mm_protocal_c_aqp);
                }
                i7++;
            }
            com_tencent_mm_protocal_c_bkg.wNL = com_tencent_mm_protocal_c_bkg.wNM.size();
            x.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bkg.wNL)});
        }
        com_tencent_mm_protocal_c_bkg.wvs = new bdn().bj(com.tencent.mm.plugin.normsg.a.d.oSu.bfJ());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkh com_tencent_mm_protocal_c_bkh = (bkh) ((b) qVar).hmh.hmo;
        com.tencent.mm.sdk.b.b qcVar;
        if (i2 == 4) {
            m xo = ae.bvv().xo(this.qQY);
            try {
                aqs com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(xo.field_postBuf);
                com_tencent_mm_protocal_c_aqs.wyj = i3;
                com_tencent_mm_protocal_c_aqs.wyr = com_tencent_mm_protocal_c_bkh.wyr;
                com_tencent_mm_protocal_c_aqs.wys = false;
                xo.field_postBuf = com_tencent_mm_protocal_c_aqs.toByteArray();
            } catch (Exception e) {
            }
            if (xo != null) {
                xo.byu();
                ae.bvv().b(this.qQY, xo);
                ae.bvu().wC(this.qQY);
                x.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + xo.byq());
                qcVar = new qc();
                qcVar.fHK.fHL = (long) this.qQY;
                a.xef.m(qcVar);
            }
            if (!(this.qUa == null || this.qUa.wQo == null || this.qUa.wQo.vYc != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.pY(8);
                switch (i3) {
                    case -1:
                        com.tencent.mm.plugin.sns.lucky.a.b.pY(19);
                        break;
                    case 201:
                        com.tencent.mm.plugin.sns.lucky.a.b.pY(17);
                        break;
                    case h.CTRL_INDEX /*211*/:
                        com.tencent.mm.plugin.sns.lucky.a.b.pY(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.a.b.pY(20);
                        break;
                }
            }
            this.gJT.a(i2, i3, str, this);
        } else if (i3 != 0) {
            ae.bvu().wC(this.qQY);
            if (!(this.qUa == null || this.qUa.wQo == null || this.qUa.wQo.vYc != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.pY(8);
                com.tencent.mm.plugin.sns.lucky.a.b.pY(16);
            }
            this.gJT.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_bkh.wMm == null || com_tencent_mm_protocal_c_bkh.wMm.wMW == null || com_tencent_mm_protocal_c_bkh.wMm.wMW.wJD == null) {
            x.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            ae.bvu().wC(this.qQY);
            m xo2 = ae.bvv().xo(this.qQY);
            xo2.byt();
            ae.bvv().b(this.qQY, xo2);
            qcVar = new qd();
            qcVar.fHM.fHL = (long) this.qQY;
            a.xef.m(qcVar);
            this.gJT.a(i2, i3, str, this);
        } else {
            String str2;
            String str3;
            String str4 = new String(com_tencent_mm_protocal_c_bkh.wMm.wMW.wJD.toByteArray());
            if (this.qUd == 0) {
                x.d("MicroMsg.NetSceneSnsPost", "resp " + str4 + "  ");
            }
            this.qUb = com.tencent.mm.modelsns.e.mG(str4);
            if (this.qUb.wQt != null) {
                str2 = this.qUb.nGJ;
                str3 = this.qUb.wQt.hdv;
                String str5 = this.qUb.wQt.hdu;
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.q("20CurrPublishId", str2 + ",");
                dVar.q("20SourcePublishId", str3 + ",");
                dVar.q("20SourceAdUxInfo", str5 + ",");
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + dVar.Sz());
                g.pQN.h(13004, new Object[]{dVar});
            }
            m xo3 = ae.bvv().xo(this.qQY);
            if (xo3 == null) {
                x.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                xo3 = new m();
            }
            xo3.hK(com_tencent_mm_protocal_c_bkh.wMm.pbl);
            xo3.Lk(str4);
            xo3.field_localFlag &= -17;
            xo3.eN(com_tencent_mm_protocal_c_bkh.wMm.vPO);
            xo3.eP(com_tencent_mm_protocal_c_bkh.wMm.vPO);
            if ((com_tencent_mm_protocal_c_bkh.wMm.wzw & 1) > 0) {
                xo3.byn();
            }
            this.qUc = com_tencent_mm_protocal_c_bkh.wMm.vPO;
            if (this.qUe != null) {
                this.qUe.fMo.fMq = "sns_" + i.eq(this.qUc);
                a.xef.m(this.qUe);
            }
            bjv com_tencent_mm_protocal_c_bjv = com_tencent_mm_protocal_c_bkh.wMm;
            com_tencent_mm_protocal_c_bjv.wMW.bj(new byte[0]);
            try {
                com.tencent.mm.modelsns.b bK;
                com.tencent.mm.sdk.b.b qdVar;
                int i4;
                String str6;
                aqr com_tencent_mm_protocal_c_aqr;
                n TS;
                long j;
                n.a aVar;
                if (com_tencent_mm_protocal_c_bjv.wNc == 0 && com_tencent_mm_protocal_c_bjv.wMZ == 0 && com_tencent_mm_protocal_c_bjv.wNf == 0 && com_tencent_mm_protocal_c_bjv.wAO == 0) {
                    x.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    xo3.byt();
                    ae.bvv().b(this.qQY, xo3);
                    ae.bvu().wC(this.qQY);
                    bK = com.tencent.mm.plugin.sns.h.e.rdF.bK(Integer.valueOf(this.qQY));
                    bK.Su();
                    bK.Sv();
                    bK.mD(this.qUb.nGJ);
                    bK.ix(this.qUb.wQo.vYc);
                    bK.Sx();
                    bK = f.rdF.bK(Integer.valueOf(this.qQY));
                    bK.Su();
                    bK.Sv();
                    bK.mD(this.qUb.nGJ);
                    bK.ix(this.qUb.wQo.vYc);
                    bK.Sx();
                    qdVar = new qd();
                    qdVar.fHM.fHL = (long) this.qQY;
                    a.xef.m(qdVar);
                    if (xo3.field_type == 21) {
                        if (xo3.field_pravited != 1) {
                            i4 = com_tencent_mm_protocal_c_bkh.wMm.wzw;
                        }
                        com.tencent.mm.plugin.sns.lucky.a.b.pY(7);
                        str6 = this.qUb.nGJ;
                        System.currentTimeMillis();
                    }
                    a(this.qUa, this.qUb);
                    if (this.qUb != null) {
                    }
                    Ke(this.qUb != null ? "" : this.qUb.wQl);
                    if (ae.bvr() != null) {
                        ae.bvr().buj();
                    }
                    if (xo3.field_type == 15) {
                        com_tencent_mm_protocal_c_aqr = (aqr) this.qUb.wQo.vYd.get(0);
                        if (com_tencent_mm_protocal_c_aqr != null) {
                            str2 = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
                            TS = n.TS();
                            str6 = com_tencent_mm_protocal_c_aqr.nfX;
                            j = com_tencent_mm_protocal_c_bjv.vPO;
                            str3 = str6.hashCode();
                            x.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, str6, Long.valueOf(j), str2});
                            aVar = (n.a) TS.hUV.get(str3);
                            if (aVar != null) {
                                aVar.hVk = String.valueOf(j);
                                aVar.hVj = str2;
                                TS.a(aVar.hUz, str3);
                            }
                        }
                    }
                    this.gJT.a(i2, i3, str, this);
                }
                xo3.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                xo3.byt();
                ae.bvv().b(this.qQY, xo3);
                ae.bvu().wC(this.qQY);
                bK = com.tencent.mm.plugin.sns.h.e.rdF.bK(Integer.valueOf(this.qQY));
                if (!(bK == null || this.qUb == null)) {
                    bK.Su();
                    bK.Sv();
                    bK.mD(this.qUb.nGJ);
                    bK.ix(this.qUb.wQo.vYc);
                    bK.Sx();
                }
                bK = f.rdF.bK(Integer.valueOf(this.qQY));
                if (!(bK == null || this.qUb == null)) {
                    bK.Su();
                    bK.Sv();
                    bK.mD(this.qUb.nGJ);
                    bK.ix(this.qUb.wQo.vYc);
                    bK.Sx();
                }
                qdVar = new qd();
                qdVar.fHM.fHL = (long) this.qQY;
                a.xef.m(qdVar);
                if (xo3.field_type == 21) {
                    if (xo3.field_pravited != 1) {
                        i4 = com_tencent_mm_protocal_c_bkh.wMm.wzw;
                    }
                    com.tencent.mm.plugin.sns.lucky.a.b.pY(7);
                    str6 = this.qUb.nGJ;
                    System.currentTimeMillis();
                }
                a(this.qUa, this.qUb);
                Ke(this.qUb != null ? "" : this.qUb.wQl);
                if (ae.bvr() != null) {
                    ae.bvr().buj();
                }
                try {
                    if (xo3.field_type == 15) {
                        com_tencent_mm_protocal_c_aqr = (aqr) this.qUb.wQo.vYd.get(0);
                        if (com_tencent_mm_protocal_c_aqr != null) {
                            str2 = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
                            TS = n.TS();
                            str6 = com_tencent_mm_protocal_c_aqr.nfX;
                            j = com_tencent_mm_protocal_c_bjv.vPO;
                            if (!(bh.ov(str6) || bh.ov(str2))) {
                                str3 = str6.hashCode();
                                x.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, str6, Long.valueOf(j), str2});
                                aVar = (n.a) TS.hUV.get(str3);
                                if (aVar != null) {
                                    aVar.hVk = String.valueOf(j);
                                    aVar.hVj = str2;
                                    TS.a(aVar.hUz, str3);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                this.gJT.a(i2, i3, str, this);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
        }
    }

    private void Ke(String str) {
        this.qUj = str;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100132");
        if (fn.isValid()) {
            this.gLV = bh.getInt((String) fn.chI().get("needUploadData"), 1);
        }
        if ((this.qUf == 12 || this.gLV != 0) && this.qUb != null && this.qUb.wQo != null && this.qUb.wQo.vYd != null && this.qUb.wQo.vYd.size() > 0) {
            LinkedList linkedList = this.qUb.wQo.vYd;
            a.xef.b(this.gLY);
            a.xef.b(this.gLZ);
            Iterator it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                if (com_tencent_mm_protocal_c_aqr.ktN == 2) {
                    String C = g.C(com_tencent_mm_protocal_c_aqr);
                    if (!bh.ov(C)) {
                        this.qUi.put(C, Integer.valueOf(i));
                        this.qUh.put(C, com_tencent_mm_protocal_c_aqr);
                        int i2 = i + 1;
                        com.tencent.mm.sdk.b.b mpVar = new mp();
                        mpVar.fEA.filePath = C;
                        a.xef.m(mpVar);
                        i = i2;
                    }
                }
            }
        }
    }

    private static boolean a(bnp com_tencent_mm_protocal_c_bnp, bnp com_tencent_mm_protocal_c_bnp2) {
        if (com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp2 == null || com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp2.wQo == null) {
            return false;
        }
        String accSnsPath = ae.getAccSnsPath();
        int i = 0;
        while (i < com_tencent_mm_protocal_c_bnp.wQo.vYd.size() && i < com_tencent_mm_protocal_c_bnp2.wQo.vYd.size()) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i);
            aqr com_tencent_mm_protocal_c_aqr2 = (aqr) com_tencent_mm_protocal_c_bnp2.wQo.vYd.get(i);
            String m = i.m(com_tencent_mm_protocal_c_aqr);
            String n = i.n(com_tencent_mm_protocal_c_aqr);
            String o = i.o(com_tencent_mm_protocal_c_aqr);
            String p = i.p(com_tencent_mm_protocal_c_aqr);
            String l = i.l(com_tencent_mm_protocal_c_aqr2);
            String e = i.e(com_tencent_mm_protocal_c_aqr2);
            String f = i.f(com_tencent_mm_protocal_c_aqr2);
            String j = i.j(com_tencent_mm_protocal_c_aqr2);
            x.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
            String r = am.r(accSnsPath, com_tencent_mm_protocal_c_aqr.nGJ);
            String r2 = am.r(accSnsPath, com_tencent_mm_protocal_c_aqr2.nGJ);
            FileOp.mh(r2);
            FileOp.at(r + m, r2 + l);
            FileOp.at(r + n, r2 + e);
            FileOp.at(r + o, r2 + f);
            if (FileOp.bO(r + p)) {
                x.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[]{r2 + j});
                FileOp.at(r + p, r2 + j);
            }
            i++;
        }
        return true;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
    }
}
