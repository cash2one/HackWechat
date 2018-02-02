package com.tencent.mm.aq;

import com.tencent.mm.ae.r;
import com.tencent.mm.ae.t;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.protocal.c.js;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba;
import java.io.ByteArrayOutputStream;
import java.util.Map;

class l$4 implements a {
    final /* synthetic */ l hBQ;

    l$4(l lVar) {
        this.hBQ = lVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        Throwable th;
        x.d(l.f(this.hBQ), "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{l.j(this.hBQ), Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (i == -21005) {
            x.w(l.f(this.hBQ), "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{l.j(this.hBQ)});
            if (l.k(this.hBQ) != null) {
                l.k(this.hBQ).Pj();
            }
            l.g(this.hBQ).a(3, i, "", this.hBQ);
            return 0;
        } else if (i != 0) {
            x.e(l.f(this.hBQ), "cdntra cdnCallback clientid:%s startRet:%d", new Object[]{l.j(this.hBQ), Integer.valueOf(i)});
            i.hU((int) l.b(this.hBQ));
            i.hT((int) l.b(this.hBQ));
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                r1 = g.pQN;
                Object[] objArr = new Object[16];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Long.valueOf(l.l(this.hBQ));
                objArr[3] = Long.valueOf(bh.Wp());
                objArr[4] = Integer.valueOf(d.bi(ac.getContext()));
                objArr[5] = Integer.valueOf(l.m(this.hBQ));
                objArr[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                    r0 = "";
                } else {
                    r0 = l.lo(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                }
                objArr[15] = r0;
                r1.h(10421, objArr);
            }
            l.g(this.hBQ).a(3, i, "", this.hBQ);
            if (l.k(this.hBQ) != null) {
                l.k(this.hBQ).Pj();
            }
            return 0;
        } else {
            e d = l.d(this.hBQ);
            if (d == null || d.hzP != l.c(this.hBQ)) {
                com.tencent.mm.modelcdntran.g.MJ().kH(l.j(this.hBQ));
                x.e(l.f(this.hBQ), "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", new Object[]{Long.valueOf(l.c(this.hBQ)), l.j(this.hBQ)});
                if (l.k(this.hBQ) != null) {
                    l.k(this.hBQ).Pj();
                }
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                l.a(this.hBQ, d, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    x.i(l.f(this.hBQ), "dkupimg sceneResult:%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult});
                    bqu com_tencent_mm_protocal_c_bqu;
                    Object[] objArr2;
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        x.e(l.f(this.hBQ), "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{l.j(this.hBQ), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == -21111) {
                            x.w(l.f(this.hBQ), "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", new Object[]{l.j(this.hBQ), Boolean.valueOf(l.n(this.hBQ))});
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Dm().F(new Runnable(this) {
                                final /* synthetic */ l$4 hBR;

                                public final void run() {
                                    l.o(this.hBR.hBQ);
                                    l.p(this.hBR.hBQ);
                                    l.q(this.hBR.hBQ);
                                    e d = l.d(this.hBR.hBQ);
                                    d.hJ(0);
                                    l.r(this.hBR.hBQ).aq(ba.hR(l.r(this.hBR.hBQ).field_talker));
                                    l.a(this.hBR.hBQ, d.a("upimg", l.r(this.hBR.hBQ).field_createTime, l.r(this.hBR.hBQ).field_talker, l.r(this.hBR.hBQ).field_msgId + "_" + l.c(this.hBR.hBQ) + "_" + l.h(this.hBR.hBQ)));
                                    boolean a = l.a(this.hBR.hBQ, d, 0, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                                    bqt com_tencent_mm_protocal_c_bqt = (bqt) l.s(this.hBR.hBQ).hmg.hmo;
                                    if (com_tencent_mm_protocal_c_bqt == null) {
                                        x.w(l.f(this.hBR.hBQ), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                    } else {
                                        com_tencent_mm_protocal_c_bqt.wSf = new bdo().UA(l.j(this.hBR.hBQ));
                                    }
                                    x.i(l.f(this.hBR.hBQ), "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", new Object[]{Boolean.valueOf(l.n(this.hBR.hBQ)), Boolean.valueOf(a), l.j(this.hBR.hBQ), Long.valueOf(l.r(this.hBR.hBQ).field_createTime)});
                                    this.hBR.hBQ.a(l.t(this.hBR.hBQ), l.g(this.hBR.hBQ));
                                }
                            });
                            return 0;
                        }
                        com_tencent_mm_protocal_c_bqu = null;
                        if (!bh.bw(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf)) {
                            com_tencent_mm_protocal_c_bqu = new bqu();
                            try {
                                com_tencent_mm_protocal_c_bqu.aF(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                x.d(l.f(this.hBQ), "parse skeyrespbuf: ret:%d,msg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqu.wJr.vJU), com_tencent_mm_protocal_c_bqu.wJr.vLc.toString()});
                            } catch (Throwable e) {
                                th = e;
                                com_tencent_mm_protocal_c_bqu = null;
                                x.e(l.f(this.hBQ), "UploadMsgImgResponse parse fail: %s", new Object[]{th});
                                x.e(l.f(this.hBQ), "exception:%s", new Object[]{bh.i(th)});
                            } catch (Throwable e2) {
                                th = e2;
                                com_tencent_mm_protocal_c_bqu = null;
                                x.e(l.f(this.hBQ), "UploadMsgImgResponse parse UninitializedMessageException: %s", new Object[]{th});
                                x.e(l.f(this.hBQ), "exception:%s", new Object[]{bh.i(th)});
                            }
                        }
                        i.hU((int) l.b(this.hBQ));
                        i.hT((int) l.b(this.hBQ));
                        g gVar = g.pQN;
                        objArr2 = new Object[16];
                        objArr2[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                        objArr2[1] = Integer.valueOf(1);
                        objArr2[2] = Long.valueOf(l.l(this.hBQ));
                        objArr2[3] = Long.valueOf(bh.Wp());
                        objArr2[4] = Integer.valueOf(d.bi(ac.getContext()));
                        objArr2[5] = Integer.valueOf(l.m(this.hBQ));
                        objArr2[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        objArr2[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                        objArr2[8] = "";
                        objArr2[9] = "";
                        objArr2[10] = "";
                        objArr2[11] = "";
                        objArr2[12] = "";
                        objArr2[13] = "";
                        objArr2[14] = "";
                        objArr2[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : l.lo(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        gVar.h(10421, objArr2);
                        gVar = g.pQN;
                        objArr2 = new Object[16];
                        objArr2[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                        objArr2[1] = Integer.valueOf(1);
                        objArr2[2] = Long.valueOf(l.l(this.hBQ));
                        objArr2[3] = Long.valueOf(bh.Wp());
                        objArr2[4] = Integer.valueOf(d.bi(ac.getContext()));
                        objArr2[5] = Integer.valueOf(l.m(this.hBQ));
                        objArr2[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        objArr2[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                        objArr2[8] = "";
                        objArr2[9] = "";
                        objArr2[10] = "";
                        objArr2[11] = "";
                        objArr2[12] = "";
                        objArr2[13] = "";
                        objArr2[14] = "";
                        objArr2[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : l.lo(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        gVar.h(13937, objArr2);
                        if (com_tencent_mm_protocal_c_bqu == null || com_tencent_mm_protocal_c_bqu.wJr.vJU == 0) {
                            l.g(this.hBQ).a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hBQ);
                        } else {
                            l.g(this.hBQ).a(4, com_tencent_mm_protocal_c_bqu.wJr.vJU, com_tencent_mm_protocal_c_bqu.wJr.vLc.toString(), this.hBQ);
                        }
                        if (l.k(this.hBQ) != null) {
                            l.k(this.hBQ).Pj();
                        }
                    } else {
                        String str2;
                        x.i(l.f(this.hBQ), "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField)});
                        r1 = g.pQN;
                        objArr2 = new Object[3];
                        objArr2[0] = Integer.valueOf(d.cOY == 0 ? 3 : d.cOY);
                        objArr2[1] = l.u(this.hBQ);
                        objArr2[2] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                        r1.h(13230, objArr2);
                        String v = l.v(this.hBQ);
                        r0 = "";
                        a lk = f.lk(v);
                        if (lk == null || bh.ov(lk.appId)) {
                            str2 = r0;
                        } else {
                            str2 = f.c(lk.appId, lk.mediaTagName, lk.messageExt, lk.messageAction);
                        }
                        if (bh.ov(v)) {
                            r0 = (("<msg><img aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\" ") + "length=\"" + (com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength == 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength : com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength) + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/>" + str2 + "</msg>";
                            x.i(l.f(this.hBQ), "cdn callback new build cdnInfo:%s", new Object[]{r0});
                        } else {
                            Map y = bi.y(v, "msg");
                            if (y != null) {
                                if (d.hzT == 0) {
                                    r0 = (("<msg><img aeskey=\"" + ((String) y.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + ((String) y.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) y.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) y.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) y.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength == 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength : com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength) + "\" hdlength=\"" + ((String) y.get(".msg.img.$hdlength")) + "\"/>" + str2 + "</msg>";
                                } else {
                                    r0 = (("<msg><img aeskey=\"" + ((String) y.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) y.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) y.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) y.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) y.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) y.get(".msg.img.$length")) + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/>" + str2 + "</msg>";
                                }
                                x.i(l.f(this.hBQ), "cdn callback rebuild cdnInfo:%s", new Object[]{r0});
                            } else {
                                r0 = v;
                            }
                        }
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                            if (bh.ov(l.w(this.hBQ))) {
                                x.w(l.f(this.hBQ), "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                            } else {
                                r0 = (("<msg><img aeskey=\"" + l.w(this.hBQ) + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + l.w(this.hBQ) + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/>" + str2 + "</msg>";
                            }
                        }
                        d.lj(r0);
                        if (l.b(this.hBQ) != l.c(this.hBQ)) {
                            l.e(this.hBQ).lj(r0);
                        }
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField) {
                            com.tencent.mm.kernel.g.Di().gPJ.a(new m(l.x(this.hBQ), (bqt) l.s(this.hBQ).hmg.hmo, d, com_tencent_mm_modelcdntran_keep_SceneResult, new 2(this, com_tencent_mm_modelcdntran_keep_SceneResult, d)), 0);
                        } else {
                            g.pQN.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.l(this.hBQ)), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(l.m(this.hBQ)), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", l.lo(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2)});
                            com_tencent_mm_protocal_c_bqu = new bqu();
                            try {
                                com_tencent_mm_protocal_c_bqu.aF(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                long j = com_tencent_mm_protocal_c_bqu.vHe != 0 ? com_tencent_mm_protocal_c_bqu.vHe : (long) com_tencent_mm_protocal_c_bqu.vGW;
                                x.d(l.f(this.hBQ), "parse skeyrespbuf: ret:%d,msg:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqu.wJr.vJU), com_tencent_mm_protocal_c_bqu.wJr.vLc.toString()});
                                l.a(this.hBQ, d, d.hlp, j, com_tencent_mm_protocal_c_bqu.pbl, com_tencent_mm_modelcdntran_keep_SceneResult);
                                l.g(this.hBQ).a(0, 0, "", this.hBQ);
                                if (l.k(this.hBQ) != null) {
                                    l.k(this.hBQ).Pj();
                                }
                                return 0;
                            } catch (Throwable e22) {
                                x.e(l.f(this.hBQ), "UploadMsgImgResponse parse fail: %s", new Object[]{e22});
                                x.e(l.f(this.hBQ), "exception:%s", new Object[]{bh.i(e22)});
                                l.g(this.hBQ).a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hBQ);
                                if (l.k(this.hBQ) != null) {
                                    l.k(this.hBQ).Pj();
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        bqt com_tencent_mm_protocal_c_bqt = (bqt) l.s(this.hBQ).hmg.hmo;
        com.tencent.mm.bq.a jrVar = new jr();
        jrVar.vQp = com_tencent_mm_protocal_c_bqt.wSf.wJF;
        jrVar.nkp = com_tencent_mm_protocal_c_bqt.vGX.wJF;
        jrVar.nko = com_tencent_mm_protocal_c_bqt.vGY.wJF;
        jrVar.vQq = com_tencent_mm_protocal_c_bqt.wSm;
        jrVar.vQr = com_tencent_mm_protocal_c_bqt.wSn;
        jrVar.rYW = l.y(this.hBQ);
        jrVar.vQt = l.z(this.hBQ);
        jrVar.vQu = l.A(this.hBQ);
        jrVar.vQv = l.B(this.hBQ);
        jrVar.vHc = com_tencent_mm_protocal_c_bqt.vHc;
        jrVar.vQA = l.C(this.hBQ);
        jrVar.ngo = com_tencent_mm_protocal_c_bqt.ngo;
        jrVar.vFC = com_tencent_mm_protocal_c_bqt.vFC;
        jrVar.vFE = com_tencent_mm_protocal_c_bqt.vFE;
        jrVar.vFD = com_tencent_mm_protocal_c_bqt.vFD;
        e d = l.d(this.hBQ);
        String m = o.Pw().m(d.hzQ, "", "");
        com.tencent.mm.modelcdntran.g.MK();
        jrVar.vQC = b.kC(m);
        jrVar.vQD = d.hzU;
        if (jrVar.vQD <= 0) {
            jrVar.vQD = l.x(this.hBQ) == 4 ? 2 : 1;
        }
        switch (l.x(this.hBQ)) {
            case 1:
            case 2:
                jrVar.vHW = 1;
                break;
            case 4:
                jrVar.vHW = 3;
                break;
            case 6:
                jrVar.vHW = 5;
                break;
            default:
                jrVar.vHW = 2;
                break;
        }
        if (jrVar.vQD == 3) {
            jrVar.vHW = 4;
        }
        x.i(l.f(this.hBQ), "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", new Object[]{str, Integer.valueOf(jrVar.vQq), Integer.valueOf(jrVar.vQr), jrVar.vHc, jrVar.nko, jrVar.vQA, Long.valueOf(l.c(this.hBQ)), Long.valueOf(l.D(this.hBQ)), d.hzQ, m, Integer.valueOf(jrVar.vQC), Integer.valueOf(jrVar.vQD), Integer.valueOf(jrVar.vHW)});
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = jrVar;
        aVar.hmk = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hmi = 625;
        aVar.hml = 9;
        aVar.hmm = 1000000009;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        c Kx = l.E(this.hBQ).Kx();
        String f = l.f(this.hBQ);
        String str2 = "getCdnAuthInfo login:%s";
        Object[] objArr = new Object[1];
        objArr[0] = Kx == null ? "acc == null" : Boolean.valueOf(Kx.Kt());
        x.i(f, str2, objArr);
        if (Kx == null || !Kx.Kt()) {
            x.e(l.f(this.hBQ), "getCdnAuthInfo accinfo return null. clientimgid:%s", new Object[]{jrVar.vQp});
            return;
        }
        if (r.a(Kx.CF(), Kx.Ks(), Kx.Ku(), JZ.Kb(), byteArrayOutputStream, Kx.Kv())) {
            x.d(l.f(this.hBQ), "getCdnAuthInfo successed.clientimgid:%s", new Object[]{jrVar.vQp});
        } else {
            x.e(l.f(this.hBQ), "getCdnAuthInfo failed. clientimgid:%s", new Object[]{jrVar.vQp});
        }
    }

    public final byte[] h(String str, byte[] bArr) {
        PInt pInt = new PInt();
        bdf jsVar = new js();
        try {
            byte[] a = t.a(bArr, com.tencent.mm.kernel.g.Di().gPJ.hmV.Kx().CF(), pInt, jsVar);
            x.i(l.f(this.hBQ), "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", new Object[]{jsVar.vQA, jsVar.vQE, jsVar.vQp});
            l.b(this.hBQ, jsVar.vQA);
            x.i(l.f(this.hBQ), "decodePrepareResponse, clientmediaid:%s, ret:%d", new Object[]{str, Integer.valueOf(pInt.value)});
            return a;
        } catch (Exception e) {
            x.e(l.f(this.hBQ), "decodePrepareResponse Exception:%s", new Object[]{e});
            l.b(this.hBQ, null);
            return null;
        }
    }
}
