package com.tencent.mm.modelvideo;

import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class u implements d {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null) {
            x.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String str;
        String str2 = (String) g.Dj().CU().get(2, "");
        String a = n.a(bwVar.vGY);
        String a2 = n.a(bwVar.vGX);
        boolean z = ((h) g.h(h.class)).Fg().has(a2) || str2.equals(a2);
        x.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[]{a2, a, str2, Boolean.valueOf(z)});
        c aZi = ((h) g.h(h.class)).aZi();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        cf F = aZi.F(str, bwVar.vHe);
        x.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId), Integer.valueOf(F.field_flag), Long.valueOf(F.field_msgSeq), aVar});
        if (F.field_msgId != 0 && F.field_createTime + 604800000 < ba.n(a2, (long) bwVar.pbl)) {
            x.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(bwVar.vHe), Long.valueOf(F.field_msgId)});
            ba.aK(F.field_msgId);
            F.ao(0);
        }
        if (F.field_msgId != 0) {
            x.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[]{Long.valueOf(bwVar.vHe)});
            return null;
        }
        String a3 = n.a(bwVar.vGZ);
        r rVar = new r();
        if (z) {
            a2 = a;
        }
        rVar.fDC = a2;
        rVar.hVE = (long) bwVar.pbl;
        rVar.fFo = bwVar.vHe;
        rVar.hVN = bwVar.vGZ.wJF;
        x.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[]{a3, bwVar.vHc});
        Map y = bi.y(a3, "msg");
        if (y == null) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 216, 1, false);
            return null;
        }
        cf auVar = new au();
        auVar.dY(bwVar.vHc);
        auVar.dZ(ba.hU(bwVar.vHc));
        try {
            rVar.hlp = bh.getInt((String) y.get(".msg.videomsg.$length"), 0);
            rVar.hVH = bh.getInt((String) y.get(".msg.videomsg.$playlength"), 0);
            x.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[]{Integer.valueOf(rVar.hlp), Integer.valueOf(rVar.hVH)});
            rVar.hVz = (String) y.get(".msg.videomsg.$fromusername");
            if (str2.equals(rVar.Ue())) {
                rVar.hVz = a;
            }
            rVar.fGG = (String) y.get(".msg.statextstr");
            str2 = (String) y.get(".msg.videomsg.$cdnthumbaeskey");
            final String str3 = (String) y.get(".msg.videomsg.$cdnthumburl");
            final int i = bh.getInt((String) y.get(".msg.videomsg.$cdnthumblength"), 0);
            int i2 = bh.getInt((String) y.get(".msg.videomsg.$type"), 0);
            x.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + i2);
            rVar.hVL = i2 == 44 ? 1 : 0;
            if (62 == bwVar.ngq) {
                rVar.hVO = 3;
            } else if (i2 > 0) {
                rVar.hVO = 2;
            } else {
                rVar.hVO = 1;
            }
            a = bh.az((String) y.get(".msg.streamvideo.streamvideourl"), "");
            int i3 = bh.getInt((String) y.get(".msg.streamvideo.streamvideototaltime"), 0);
            String az = bh.az((String) y.get(".msg.streamvideo.streamvideotitle"), "");
            String az2 = bh.az((String) y.get(".msg.streamvideo.streamvideowording"), "");
            String az3 = bh.az((String) y.get(".msg.streamvideo.streamvideoweburl"), "");
            String az4 = bh.az((String) y.get(".msg.streamvideo.streamvideoaduxinfo"), "");
            str = bh.az((String) y.get(".msg.streamvideo.streamvideopublishid"), "");
            if (rVar.hVQ == null) {
                rVar.hVQ = new bmf();
            }
            rVar.hVQ.hdq = az;
            rVar.hVQ.weC = i3;
            rVar.hVQ.hdo = a;
            rVar.hVQ.hdr = az2;
            rVar.hVQ.hds = az3;
            rVar.hVQ.hdu = az4;
            rVar.hVQ.hdv = str;
            if (rVar.Ue().equals((String) g.Dj().CU().get(2, ""))) {
                return null;
            }
            str = (String) y.get(".msg.commenturl");
            y = bi.y(a3, "msgoperation");
            if (y != null) {
                auVar.ea((String) y.get(".msgoperation.expinfo.expidstr"));
                auVar.ff(bh.getInt((String) y.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                x.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{auVar.gjO, Integer.valueOf(auVar.gjP)});
            }
            a2 = s.ns(rVar.Ue());
            rVar.fileName = a2;
            auVar.ap(rVar.fFo);
            auVar.dT(rVar.getFileName());
            auVar.aq(ba.n(rVar.Ud(), rVar.hVE));
            auVar.dS(rVar.Ud());
            auVar.eQ(bwVar.ktm);
            auVar.eR(z ? 1 : 0);
            if (bwVar.ngq == 62) {
                auVar.setType(62);
            } else {
                auVar.setType(43);
            }
            auVar.setContent(p.b(rVar.Ue(), 0, false));
            auVar.dX(str);
            auVar.dY(bwVar.vHc);
            ba.a(auVar, aVar);
            long i4 = ba.i(auVar);
            if (i4 <= 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 215, 1, false);
                x.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[]{Long.valueOf(i4), Long.valueOf(rVar.fFo)});
                return null;
            }
            rVar.hVI = (int) i4;
            rVar.hVF = bh.Wo();
            rVar.hVJ = 0;
            rVar.status = 111;
            x.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hlp + " svrid:" + rVar.fFo + " timelen:" + rVar.hVH + " user:" + rVar.Ud() + " human:" + rVar.Ue());
            if (o.TU().a(rVar)) {
                o.TU();
                a3 = s.nu(a2);
                byte[] a4 = n.a(bwVar.vHb);
                x.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[]{Integer.valueOf(bh.bx(a4))});
                if (r.idz) {
                    x.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                if (bh.bw(a4)) {
                    final long j = rVar.fFo;
                    x.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), rVar.Ud(), str3, a3});
                    final long Wp = bh.Wp();
                    az = a3 + ".tmp";
                    i iVar = new i();
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", rVar.hVE, rVar.Ud(), String.valueOf(j));
                    iVar.field_fullpath = az;
                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    iVar.field_totalLen = i;
                    iVar.field_aesKey = str2;
                    iVar.field_fileId = str3;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrL;
                    iVar.field_chattype = s.eV(rVar.Ud()) ? 1 : 0;
                    x.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[]{Integer.valueOf(iVar.field_chattype), rVar.Ud()});
                    final r rVar2 = rVar;
                    iVar.htt = new i.a(this) {
                        final /* synthetic */ u hWj;

                        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                            if (i != 0) {
                                x.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), rVar2.Ud(), str3, a3});
                                com.tencent.mm.plugin.report.service.g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Wp), Long.valueOf(bh.Wp()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i), ""});
                                return i;
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                return 0;
                            } else {
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    x.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(j), rVar2.Ud(), str3, a3});
                                } else {
                                    new File(az).renameTo(new File(a3));
                                    x.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), rVar2.Ud(), str3, a3});
                                    if (rVar2.hVO == 3) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, 6, (long) i, false);
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, 7, 1, false);
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, s.eV(rVar2.Ud()) ? 9 : 8, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, 11, (long) i, false);
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, 12, 1, false);
                                        com.tencent.mm.plugin.report.service.g.pQN.a(198, s.eV(rVar2.Ud()) ? 14 : 13, 1, false);
                                    }
                                }
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Wp);
                                objArr[3] = Long.valueOf(bh.Wp());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i);
                                objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr[8] = "";
                                objArr[9] = "";
                                objArr[10] = "";
                                objArr[11] = "";
                                objArr[12] = "";
                                objArr[13] = "";
                                objArr[14] = "";
                                objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                gVar.h(10421, objArr);
                                if (!(com_tencent_mm_modelcdntran_keep_SceneResult == null || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0)) {
                                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                    objArr = new Object[16];
                                    objArr[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult == null ? -1 : com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                    objArr[1] = Integer.valueOf(2);
                                    objArr[2] = Long.valueOf(Wp);
                                    objArr[3] = Long.valueOf(bh.Wp());
                                    objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ac.getContext()));
                                    objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                    objArr[6] = Integer.valueOf(i);
                                    objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                    objArr[8] = "";
                                    objArr[9] = "";
                                    objArr[10] = "";
                                    objArr[11] = "";
                                    objArr[12] = "";
                                    objArr[13] = "";
                                    objArr[14] = "";
                                    objArr[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                    gVar.h(13937, objArr);
                                }
                                s TU = o.TU();
                                String fileName = rVar2.getFileName();
                                s$a$c com_tencent_mm_modelvideo_s_a_c = s$a$c.NORMAL;
                                if (!bh.ov(fileName)) {
                                    r nr = TU.nr(fileName);
                                    if (nr != null) {
                                        TU.hkZ.ca(new s$a$a(nr.getFileName(), s.a.b.hWb, com_tencent_mm_modelvideo_s_a_c, nr.hVO, nr.hUa));
                                        TU.hkZ.doNotify();
                                    }
                                }
                                return 0;
                            }
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] h(String str, byte[] bArr) {
                            return null;
                        }
                    };
                    com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1);
                } else {
                    s.a(a3, 0, a4);
                }
                if (auVar.cji()) {
                    Object obj;
                    com.tencent.mm.modelcontrol.c.MR();
                    if (auVar.gjP == 1) {
                        obj = 1;
                    } else if (auVar.gjP == 2) {
                        obj = null;
                    } else if (com.tencent.mm.modelcontrol.c.m(auVar)) {
                        str2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("C2CSightNotAutoDownloadTimeRange");
                        x.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + str2);
                        if (com.tencent.mm.modelcontrol.b.kK(str2)) {
                            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str = auVar.field_talker;
                            x.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + str);
                            i2 = bh.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            if (i2 == 3) {
                                x.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId)});
                                obj = null;
                            } else if (an.isWifi(ac.getContext())) {
                                x.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                r4 = ((h) g.h(h.class)).EY().WO(str);
                                if (r4 == null || ((int) r4.gJd) <= 0 || !((str.endsWith("@chatroom") && r4.fWn == 0) || r4.AI())) {
                                    obj = 1;
                                } else {
                                    x.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (an.is2G(ac.getContext())) {
                                x.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                obj = null;
                            } else {
                                r4 = ((h) g.h(h.class)).EY().WO(auVar.field_talker);
                                if (s.eV(auVar.field_talker)) {
                                    if (r4.fWn == 0) {
                                        x.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                        obj = null;
                                    } else if ((an.is3G(ac.getContext()) || an.is4G(ac.getContext())) && i2 == 1) {
                                        x.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                        obj = 1;
                                    } else {
                                        x.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (r4.AI()) {
                                    x.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                    obj = null;
                                } else if ((an.is3G(ac.getContext()) || an.is4G(ac.getContext())) && i2 == 1) {
                                    x.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_imgPath});
                                    obj = 1;
                                } else {
                                    x.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        t.nB(auVar.field_imgPath);
                        com.tencent.mm.modelcdntran.g.MJ().hsy.add("video_" + auVar.field_msgId);
                    }
                }
                int i5 = 1;
                int i6 = 0;
                if (s.eV(rVar.Ud())) {
                    i6 = m.gl(rVar.Ud());
                    if (s.hs(rVar.Ud()) || !s.hr(rVar.Ud())) {
                        i5 = 2;
                    } else {
                        i5 = 3;
                    }
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14388, new Object[]{Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i5), "", Integer.valueOf(i6)});
                i TW = o.TW();
                synchronized (TW.hUB) {
                    TW.hUB.offerFirst(auVar);
                }
                TW.TN();
                return new b(auVar, true);
            }
            x.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + rVar.getFileName());
            return null;
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 216, 1, false);
            x.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            x.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public final void h(au auVar) {
        int i = 1;
        if (auVar != null) {
            String str = auVar.field_imgPath;
            if (!bh.ov(str)) {
                s TU = o.TU();
                if (TU.hhp.delete("videoinfo2", "filename= ?", new String[]{str}) > 0) {
                    TU.hkZ.ca(new s$a$a(str, s.a.b.hWa, s$a$c.NORMAL, 1, -1));
                    TU.hkZ.doNotify();
                } else {
                    i = 0;
                }
                if (i != 0) {
                    try {
                        o.TU();
                        new File(s.nu(str)).delete();
                        o.TU();
                        new File(s.nt(str)).delete();
                    } catch (Exception e) {
                        x.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.zh() + " file:" + str + " msg:" + e.getMessage());
                    }
                }
            }
        }
    }
}
