package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.model.ab.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class av implements e, l {
    public static int qSu = 0;
    public Set<a> gCl = new HashSet();
    private String gze = "";
    private r qXT = null;
    public a qXU = new 6(this);

    static /* synthetic */ void a(av avVar) {
        if (ae.bvf() != null && !ae.bve()) {
            g.Dk();
            if (g.Dj().isSDCardAvailable()) {
                ae.bvf().post(new Runnable(avVar) {
                    final /* synthetic */ av qXV;

                    {
                        this.qXV = r1;
                    }

                    public final void run() {
                        m mVar = null;
                        if (ae.bve()) {
                            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                            return;
                        }
                        this.qXV.bwc();
                        if (ae.bve()) {
                            x.e("MicroMsg.UploadManager", "is invalid after checkTLE");
                            return;
                        }
                        n bvv = ae.bvv();
                        m mVar2 = new m();
                        String str = "select *,rowid from SnsInfo  where " + n.rpe + " order by SnsInfo.rowid" + " asc ";
                        Cursor a = bvv.gJP.a(str, null, 2);
                        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
                        if (a.moveToFirst()) {
                            mVar2.b(a);
                            a.close();
                            mVar = mVar2;
                        } else {
                            a.close();
                        }
                        if (mVar == null) {
                            x.d("MicroMsg.UploadManager", "All has post");
                        } else if (ae.bvu().wA(mVar.roJ)) {
                            x.d("MicroMsg.UploadManager", "checking isPosting " + mVar.roJ);
                        } else {
                            x.d("MicroMsg.UploadManager", "checking startPost " + mVar.byq());
                            this.qXV.t(mVar);
                        }
                    }
                });
            }
        }
    }

    public final String bvb() {
        if (this.gze == null || this.gze.equals("")) {
            g.Dk();
            this.gze = (String) g.Dj().CU().get(2, null);
        }
        return this.gze;
    }

    private void a(m mVar, int i, int i2, String str) {
        int i3;
        b qcVar;
        x.i("MicroMsg.UploadManager", "localId " + mVar.byq() + "processError " + i2 + " errMsg: " + str);
        com.tencent.mm.plugin.report.service.g.pQN.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((aqu) new aqu().aF(ae.bvk().eS((long) i).rpt)).wyj;
                try {
                    aqs byi = mVar.byi();
                    if (byi != null) {
                        byi.wyj = i3;
                        mVar.field_postBuf = byi.toByteArray();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    x.d("MicroMsg.UploadManager", "post error " + i3);
                    mVar.byu();
                    ae.bvv().b(mVar.roJ, mVar);
                    x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.roJ);
                    qcVar = new qc();
                    qcVar.fHK.fHL = (long) mVar.roJ;
                    com.tencent.mm.sdk.b.a.xef.m(qcVar);
                    switch (i2) {
                        case 1:
                            x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                            break;
                        case 2:
                            x.e("MicroMsg.UploadManager", "parser protobuf error");
                            break;
                        case 3:
                            x.e("MicroMsg.UploadManager", "local id is not in db");
                            break;
                        case 4:
                            x.e("MicroMsg.UploadManager", "arg is error");
                            break;
                        case 5:
                            x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                            break;
                        case 6:
                            x.e("MicroMsg.UploadManager", "errtle  error");
                            break;
                    }
                    K(mVar.roJ, false);
                }
            } catch (Exception e2) {
                i3 = 0;
                x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                x.d("MicroMsg.UploadManager", "post error " + i3);
                mVar.byu();
                ae.bvv().b(mVar.roJ, mVar);
                x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.roJ);
                qcVar = new qc();
                qcVar.fHK.fHL = (long) mVar.roJ;
                com.tencent.mm.sdk.b.a.xef.m(qcVar);
                switch (i2) {
                    case 1:
                        x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                        break;
                    case 2:
                        x.e("MicroMsg.UploadManager", "parser protobuf error");
                        break;
                    case 3:
                        x.e("MicroMsg.UploadManager", "local id is not in db");
                        break;
                    case 4:
                        x.e("MicroMsg.UploadManager", "arg is error");
                        break;
                    case 5:
                        x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                        break;
                    case 6:
                        x.e("MicroMsg.UploadManager", "errtle  error");
                        break;
                }
                K(mVar.roJ, false);
            }
        }
        aqs byi2 = mVar.byi();
        i3 = byi2 != null ? byi2.wyj : 0;
        x.d("MicroMsg.UploadManager", "post error " + i3);
        mVar.byu();
        ae.bvv().b(mVar.roJ, mVar);
        x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.roJ);
        qcVar = new qc();
        qcVar.fHK.fHL = (long) mVar.roJ;
        com.tencent.mm.sdk.b.a.xef.m(qcVar);
        switch (i2) {
            case 1:
                x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                x.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                x.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                x.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                x.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        K(mVar.roJ, false);
    }

    private void c(m mVar, int i, String str) {
        a(mVar, 0, i, str);
    }

    private static int wK(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean dW(String str, String str2) {
        x.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.s(str.getBytes());
        FileOp.x(str, str3);
        aw awVar = new aw(1);
        awVar.Kz(str2);
        awVar.wQ(6);
        List linkedList = new LinkedList();
        linkedList.add(new h(str3, 2));
        awVar.bN(linkedList);
        if (awVar.commit() > 0) {
            return true;
        }
        return false;
    }

    public static aw a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        x.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        x.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        aw awVar = new aw(i);
        awVar.KF(bh.az(str2, "")).KG(bh.az(str3, ""));
        awVar.wQ(5);
        x.d("MicroMsg.UploadManager", "TimeLineType " + i);
        if (i == -1) {
            x.d("MicroMsg.UploadManager", "timeLineType is invalid");
            return null;
        }
        if (!bh.ov(str)) {
            awVar.Kz(str);
        }
        awVar.KE(bh.az(wXMediaMessage.title, "")).KC(bh.az(wXMediaMessage.description, ""));
        int wK;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                awVar.KC("");
                awVar.Kz(wXTextObject.text);
                return awVar;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (bh.bw(wXImageObject.imageData)) {
                    if (bh.ov(wXImageObject.imagePath)) {
                        x.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        return null;
                    } else if (awVar.ee(wXImageObject.imagePath, "")) {
                        return awVar;
                    } else {
                        return null;
                    }
                } else if (awVar.b(wXImageObject.imageData, "", "")) {
                    return awVar;
                } else {
                    return null;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String az = bh.az(!bh.ov(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String az2 = bh.az(!bh.ov(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                awVar.KE("").KC("");
                wK = wK(3);
                if (wK == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, az, bh.az(!bh.ov(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), az2, wK, bh.az(wXMediaMessage.title, ""), bh.az(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                awVar.KE("").KC("");
                wK = wK(4);
                if (wK == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, bh.az(!bh.ov(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, wK, bh.az(wXMediaMessage.title, ""), bh.az(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!bh.bw(wXMediaMessage.thumbData)) {
                    awVar.b(wXMediaMessage.thumbData, bh.az(wXMediaMessage.description, ""), bh.az(wXMediaMessage.title, ""));
                }
                awVar.KC(wXWebpageObject.webpageUrl).KD(wXWebpageObject.webpageUrl);
                awVar.qYq.wQo.nfX = wXWebpageObject.webpageUrl;
                awVar.KB(wXWebpageObject.canvasPageXml);
                return awVar;
            case 6:
                x.e("MicroMsg.UploadManager", "file is not support!");
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (bh.ov(wXAppExtendObject.filePath) || !wXAppExtendObject.filePath.startsWith("http")) {
                    x.e("MicroMsg.UploadManager", "appdata is not support!");
                    return null;
                }
                awVar.KE(wXAppExtendObject.filePath);
                awVar.KC(wXAppExtendObject.filePath);
                return awVar;
            default:
                x.e("MicroMsg.UploadManager", "none type not support!");
                return null;
        }
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        aw a = a(wXMediaMessage, str, str2, str3);
        if (a == null) {
            return false;
        }
        a.KA(wXMediaMessage.mediaTagName);
        a.U(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.c.a.qQF) {
            a.wM(1);
        }
        x.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + a.commit());
        return true;
    }

    private boolean q(m mVar) {
        if (mVar == null) {
            return false;
        }
        bnp bxV = mVar.bxV();
        if (bxV.wQo.vYc == 8) {
            return true;
        }
        if (bxV.wQo.vYc == 2) {
            return true;
        }
        if (bxV.wQo.vYc == 26) {
            b fvVar = new fv();
            fvVar.fvq.type = 30;
            fvVar.fvq.fvx = 5;
            fvVar.fvq.desc = bxV.wQo.vYf;
            fvVar.fvq.fvw = String.valueOf(mVar.roJ);
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            if (fvVar.fvr.ret != 1) {
                return false;
            }
        }
        if (bxV == null || bxV.wQo.vYd == null) {
            c(mVar, 1, "timeline or timelineObjList is null");
            return false;
        } else if (bxV.wQo.vYd.size() == 0) {
            return true;
        } else {
            try {
                boolean z;
                boolean z2;
                aqs com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(mVar.field_postBuf);
                if (bxV.wQo.vYc != 1) {
                    z = true;
                } else if (com_tencent_mm_protocal_c_aqs.wyc.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (bxV.wQo.vYc == 21) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (bxV.wQo.vYc == 15) {
                    Iterator it = com_tencent_mm_protocal_c_aqs.wyc.iterator();
                    while (it.hasNext()) {
                        aox com_tencent_mm_protocal_c_aox = (aox) it.next();
                        int wL = wL(com_tencent_mm_protocal_c_aox.wvG);
                        if (wL == b.qYh) {
                            a(mVar, com_tencent_mm_protocal_c_aox.wvG, 2, "upload has set it fail");
                            return false;
                        } else if (wL == b.qYj) {
                            return false;
                        }
                    }
                    return true;
                }
                Iterator it2 = com_tencent_mm_protocal_c_aqs.wyc.iterator();
                while (it2.hasNext()) {
                    aox com_tencent_mm_protocal_c_aox2 = (aox) it2.next();
                    int a = a(com_tencent_mm_protocal_c_aox2.wvG, z2, com_tencent_mm_protocal_c_aqs, bxV.wQo.vYc);
                    if (a == b.qYh) {
                        a(mVar, com_tencent_mm_protocal_c_aox2.wvG, 2, "upload has set it fail");
                        return false;
                    } else if (a == b.qYj) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.byq());
                c(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                return false;
            }
        }
    }

    public final void r(m mVar) {
        if (mVar != null) {
            aqs com_tencent_mm_protocal_c_aqs;
            x.i("MicroMsg.UploadManager", "cancel snsinfo " + mVar.byq());
            try {
                com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(mVar.field_postBuf);
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.byq());
                c(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                com_tencent_mm_protocal_c_aqs = null;
            }
            if (!(com_tencent_mm_protocal_c_aqs == null || com_tencent_mm_protocal_c_aqs.wyc == null)) {
                Iterator it = com_tencent_mm_protocal_c_aqs.wyc.iterator();
                while (it.hasNext()) {
                    aox com_tencent_mm_protocal_c_aox = (aox) it.next();
                    int wG = ae.bvu().wG(com_tencent_mm_protocal_c_aox.wvG);
                    ae.bvu().wF(com_tencent_mm_protocal_c_aox.wvG);
                    x.i("MicroMsg.UploadManager", "cancel upload %d", new Object[]{Integer.valueOf(wG)});
                    if (mVar.field_type != 15 && wG >= 0) {
                        g.Dk();
                        g.Di().gPJ.cancel(wG);
                        ae.bvu().wE(com_tencent_mm_protocal_c_aox.wvG);
                    }
                }
            }
            if (ae.bvu().wA(mVar.roJ) && this.qXT != null) {
                x.i("MicroMsg.UploadManager", "cancel post");
                this.qXT.lbP = true;
                g.Dk();
                g.Di().gPJ.c(this.qXT);
                ae.bvu().wC(mVar.roJ);
            }
            m xo = ae.bvv().xo(mVar.roJ);
            if (!(xo == null || xo.field_snsId == 0)) {
                ae.bvu().eD(xo.field_snsId);
                g.Dk();
                g.Di().gPJ.a(new q(xo.field_snsId, 1), 0);
            }
            ae.bvv().xp(mVar.roJ);
            if (mVar.field_type == 21) {
                com.tencent.mm.plugin.sns.lucky.a.g.buo().buq();
            }
            x.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + mVar.byq());
            b qcVar = new qc();
            qcVar.fHK.fHL = (long) mVar.roJ;
            com.tencent.mm.sdk.b.a.xef.m(qcVar);
        }
    }

    public final void buj() {
        ae.aNT().postDelayed(new 1(this), 1000);
    }

    private boolean bwc() {
        n bvv = ae.bvv();
        String str = "select *,rowid from SnsInfo  where " + n.rpe + " order by SnsInfo.rowid" + " asc ";
        Cursor rawQuery = bvv.gJP.rawQuery(str, null);
        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        m mVar = new m();
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        do {
            mVar.b(rawQuery);
            try {
                aqs com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(mVar.field_postBuf);
                int i = com_tencent_mm_protocal_c_aqs.hkU;
                if (m.eQ(com_tencent_mm_protocal_c_aqs.wyf)) {
                    a(com_tencent_mm_protocal_c_aqs);
                    c(mVar, 6, "snsinfo is tle");
                    x.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + mVar.byq() + " is die ");
                }
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                c(mVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return true;
    }

    private static bnp s(m mVar) {
        bnp bxV = mVar.bxV();
        aoy com_tencent_mm_protocal_c_aoy = bxV.wQm;
        String str = bxV.wQl;
        String str2 = bxV.vmS;
        String str3 = bxV.vmT;
        String str4 = bxV.wQo.nfe;
        String str5 = bxV.wQo.fon;
        String str6 = bxV.wQo.nfX;
        String str7 = bxV.wQo.vYf;
        cu cuVar = bxV.wQn;
        bxv com_tencent_mm_protocal_c_bxv = bxV.wQu;
        int i = bxV.wQo.vYc;
        int i2 = bxV.wQo.vYe;
        bnp SA = com.tencent.mm.modelsns.e.SA();
        SA.ksU = mVar.field_userName;
        SA.wxG = mVar.field_pravited;
        SA.wQl = str;
        SA.vmS = bh.ou(str2);
        SA.vmT = bh.ou(str3);
        SA.wQq = bxV.wQq;
        SA.wQr = bxV.wQr;
        SA.hbg = bxV.hbg;
        SA.wQs = bxV.wQs;
        SA.rLO = bxV.rLO;
        SA.wQo.nfe = str4;
        SA.wQo.fon = str5;
        SA.wQo.vYc = i;
        SA.wQo.vYe = i2;
        SA.wQo.nfX = str6;
        SA.wQo.vYf = str7;
        SA.wQm = com_tencent_mm_protocal_c_aoy;
        SA.wQt = bxV.wQt;
        SA.rtA = bxV.rtA;
        if (bxV.qYu != null) {
            SA.qYu = bxV.qYu;
        }
        if (cuVar != null) {
            SA.wQn = cuVar;
        }
        if (com_tencent_mm_protocal_c_bxv != null) {
            SA.wQu = com_tencent_mm_protocal_c_bxv;
        }
        Iterator it = bxV.wQo.vYd.iterator();
        while (it.hasNext()) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
            if (com_tencent_mm_protocal_c_aqr.wxK == 1) {
                SA.wQo.vYd.add(com_tencent_mm_protocal_c_aqr);
            }
        }
        if (bxV.qYw != null) {
            SA.qYw = bxV.qYw;
        }
        return SA;
    }

    private boolean t(m mVar) {
        try {
            aqs com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(mVar.field_postBuf);
            com_tencent_mm_protocal_c_aqs.hkU++;
            mVar.field_postBuf = com_tencent_mm_protocal_c_aqs.toByteArray();
            ae.bvv().b(mVar.roJ, mVar);
            int i = com_tencent_mm_protocal_c_aqs.hkU;
            if (m.eQ(com_tencent_mm_protocal_c_aqs.wyf)) {
                c(mVar, 6, "this item isTimeLimit");
                x.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + mVar.byq() + " is die ");
                return false;
            }
            x.i("MicroMsg.UploadManager", "try start post " + mVar.byq());
            if (q(mVar)) {
                List linkedList;
                Iterator it;
                String b;
                bnp bxV = mVar.bxV();
                bnp s = s(mVar);
                int i2 = 0;
                while (i2 < com_tencent_mm_protocal_c_aqs.wyc.size()) {
                    i = ((aox) com_tencent_mm_protocal_c_aqs.wyc.get(i2)).wvG;
                    q eS = ae.bvk().eS((long) i);
                    if (eS == null) {
                        c(mVar, 3, "can not get the media from db ,localMediaId: " + i);
                        return false;
                    }
                    try {
                        aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
                        if (com_tencent_mm_protocal_c_aqu.wyx == null || com_tencent_mm_protocal_c_aqu.wyz.size() <= 0) {
                            x.e("MicroMsg.UploadManager", "item with not url" + mVar.field_type);
                            if (mVar.field_type != 3) {
                                c(mVar, 4, "buf url is null");
                                return false;
                            }
                            if (ae.bvu().wB(mVar.roJ)) {
                                x.d("MicroMsg.UploadManager", "this snsinfo is posting");
                                return false;
                            }
                            linkedList = new LinkedList();
                            it = com_tencent_mm_protocal_c_aqs.wyd.iterator();
                            while (it.hasNext()) {
                                linkedList.add(((bld) it.next()).ksU);
                            }
                            b = j.b(s);
                            x.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.wQr + " contentDescShowType: " + s.wQq);
                            if (mVar.field_pravited != 1) {
                                x.i("MicroMsg.UploadManager", "content private xml is null ? " + bh.ov(b));
                            } else {
                                x.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{b});
                            }
                            if (b != null || b.equals("")) {
                                c(mVar, 5, "content is error");
                                ae.bvu().wC(mVar.roJ);
                                return false;
                            }
                            boolean z;
                            if (com_tencent_mm_protocal_c_aqs.wyl == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ae.aNT().post(new 4(this, b, com_tencent_mm_protocal_c_aqs, linkedList, bxV, mVar.roJ, z, com_tencent_mm_protocal_c_aqs.wym, s.wQm.wvL, s.wQo.fon));
                        } else {
                            aqr a;
                            aqr com_tencent_mm_protocal_c_aqr;
                            b = com_tencent_mm_protocal_c_aqu.wyx.nfX;
                            String str = ((aqo) com_tencent_mm_protocal_c_aqu.wyz.get(0)).nfX;
                            int i3 = com_tencent_mm_protocal_c_aqu.wyx.ktN;
                            int i4 = ((aqo) com_tencent_mm_protocal_c_aqu.wyz.get(0)).ktN;
                            String str2 = com_tencent_mm_protocal_c_aqu.fqR;
                            aqt com_tencent_mm_protocal_c_aqt = null;
                            if (i2 < bxV.wQo.vYd.size()) {
                                com_tencent_mm_protocal_c_aqt = ((aqr) bxV.wQo.vYd.get(i2)).wxH;
                            }
                            if (bxV.wQo.vYc != 4 && bxV.wQo.vYc != 5) {
                                a = com.tencent.mm.modelsns.e.a(eS.rps, eS.type, b, str, i3, i4, com_tencent_mm_protocal_c_aqu.wxG, "", com_tencent_mm_protocal_c_aqt);
                            } else if (i2 < bxV.wQo.vYd.size()) {
                                com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.get(i2);
                                com_tencent_mm_protocal_c_aqr.wxE = str;
                                com_tencent_mm_protocal_c_aqr.wxF = i4;
                                a = com_tencent_mm_protocal_c_aqr;
                            } else {
                                a = null;
                            }
                            if (a != null && s.wQo.vYc == 1) {
                                a.fqR = str2;
                            }
                            if (a != null && s.wQo.vYc == 15) {
                                a.fqR = com_tencent_mm_protocal_c_aqu.fqR;
                                a.wxZ = com_tencent_mm_protocal_c_aqu.wxZ;
                            }
                            if (i2 < bxV.wQo.vYd.size()) {
                                com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.get(i2);
                                a.fon = com_tencent_mm_protocal_c_aqr.fon;
                                a.nfe = com_tencent_mm_protocal_c_aqr.nfe;
                                a.fpn = com_tencent_mm_protocal_c_aqr.fpn;
                                a.rsn = com_tencent_mm_protocal_c_aqr.rsn;
                            }
                            if (a == null) {
                                c(mVar, 3, "make media error");
                                return false;
                            }
                            s.wQo.vYd.add(a);
                            i2++;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        c(mVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        return false;
                    }
                }
                if (ae.bvu().wB(mVar.roJ)) {
                    linkedList = new LinkedList();
                    it = com_tencent_mm_protocal_c_aqs.wyd.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((bld) it.next()).ksU);
                    }
                    b = j.b(s);
                    x.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.wQr + " contentDescShowType: " + s.wQq);
                    if (mVar.field_pravited != 1) {
                        x.i("MicroMsg.UploadManager", "upload xmlsns: %s", new Object[]{b});
                    } else {
                        x.i("MicroMsg.UploadManager", "content private xml is null ? " + bh.ov(b));
                    }
                    if (b != null) {
                    }
                    c(mVar, 5, "content is error");
                    ae.bvu().wC(mVar.roJ);
                    return false;
                }
                x.d("MicroMsg.UploadManager", "this snsinfo is posting");
                return false;
            }
            x.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + mVar.byq());
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            c(mVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            return false;
        }
    }

    private void K(int i, boolean z) {
        ae.aNT().post(new 3(this, i, z));
    }

    private int a(int i, boolean z, aqs com_tencent_mm_protocal_c_aqs, int i2) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            return b.qYh;
        }
        q eS = ae.bvk().eS((long) i);
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            x.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_aqu.wyA + " pic isMuti: " + z);
            if (com_tencent_mm_protocal_c_aqu.wyA == 1) {
                return b.qYh;
            }
            String str = am.r(ae.getAccSnsPath(), eS.rpp) + i.JH(eS.rpp);
            if (FileOp.me(str) == 0) {
                x.i("MicroMsg.UploadManager", "path not exist  " + str);
                return b.qYh;
            } else if (com_tencent_mm_protocal_c_aqu.wyA == 0) {
                return b.qYi;
            } else {
                if (ae.bvu().wD(i)) {
                    ae.bvk().a(i, eS);
                    final String s = com.tencent.mm.a.g.s((bh.Wq() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final aqs com_tencent_mm_protocal_c_aqs2 = com_tencent_mm_protocal_c_aqs;
                    final int i4 = i2;
                    ae.aNT().post(new Runnable(this) {
                        final /* synthetic */ av qXV;

                        public final void run() {
                            if (ae.bve()) {
                                x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                return;
                            }
                            k yVar = new y(i3, s, z2, i4);
                            ae.bvu().du(i3, yVar.hashCode());
                            g.Dk();
                            g.Di().gPJ.a(yVar, 0);
                        }
                    });
                }
                return b.qYj;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error");
            return b.qYh;
        }
    }

    private static void a(aqs com_tencent_mm_protocal_c_aqs) {
        if (com_tencent_mm_protocal_c_aqs != null) {
            Iterator it = com_tencent_mm_protocal_c_aqs.wyc.iterator();
            while (it.hasNext()) {
                ae.bvu().wE(((aox) it.next()).wvG);
            }
        }
    }

    private int wL(int i) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            return b.qYh;
        }
        q eS = ae.bvk().eS((long) i);
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            x.i("MicroMsg.UploadManager", "state " + com_tencent_mm_protocal_c_aqu.wyA + " doUploadSight, serverErr:" + com_tencent_mm_protocal_c_aqu.wyj);
            if (com_tencent_mm_protocal_c_aqu.wyA == 1) {
                return b.qYh;
            }
            if (FileOp.me(com_tencent_mm_protocal_c_aqu.videoPath) == 0) {
                x.i("MicroMsg.UploadManager", "path not fileexist  " + com_tencent_mm_protocal_c_aqu.videoPath);
                return b.qYh;
            } else if (FileOp.me(com_tencent_mm_protocal_c_aqu.wyC) == 0) {
                x.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + com_tencent_mm_protocal_c_aqu.wyC);
                return b.qYh;
            } else if (com_tencent_mm_protocal_c_aqu.wyA == 0) {
                return b.qYi;
            } else {
                if (ae.bvu().wD(i)) {
                    ae.bvk().a(i, eS);
                    new ab(i, eS, com_tencent_mm_protocal_c_aqu.videoPath, com_tencent_mm_protocal_c_aqu.wyC, this.qXU).buV();
                }
                return b.qYj;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            return b.qYh;
        }
    }

    public final void bwd() {
        for (a aVar : this.gCl) {
            if (aVar != null) {
                aVar.bwe();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.UploadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        switch (kVar.getType()) {
            case 207:
                if (!(i == 0 && i2 == 0)) {
                    buj();
                    break;
                }
            case c.CTRL_INDEX /*209*/:
                r rVar = (r) kVar;
                int i3 = rVar.qQY;
                if (rVar.lbP) {
                    long j = rVar.qUc;
                    x.i("MicroMsg.UploadManager", "get the del post come back %d " + j, new Object[]{Integer.valueOf(i3)});
                    if (j != 0) {
                        ae.bvu().eD(j);
                        g.Dk();
                        g.Di().gPJ.a(new q(j, 1), 0);
                    }
                    ae.bvv().xp(i3);
                    if (j != 0) {
                        ae.bvA().eM(j);
                    }
                }
                if (i == 0 && i2 == 0) {
                    K(rVar.qQY, true);
                    aj.eH(rVar.qUc);
                } else {
                    K(rVar.qQY, false);
                }
                this.qXT = null;
                break;
        }
        if (i != 0 || i2 != 0) {
        }
    }
}
