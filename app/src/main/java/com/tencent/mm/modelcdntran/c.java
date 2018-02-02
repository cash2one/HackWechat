package com.tencent.mm.modelcdntran;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b.b;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements e, b, m.b {
    af hsp = new 1(this, Looper.getMainLooper());
    com.tencent.mm.sdk.b.c<ja> hsq = new 2(this);
    n hsr = new 3(this);
    Queue<String> hss = new LinkedList();
    public Map<String, i> hst = new HashMap();
    public Map<String, i> hsu = new ConcurrentHashMap();
    public Map<String, Integer> hsv = new HashMap();
    private String hsw = "";
    private long hsx = 0;
    public HashSet<String> hsy = new HashSet();

    public final void a(int i, m mVar, Object obj) {
        if (g.Dh().Cy()) {
            int o = bh.o(obj, 0);
            x.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
            if (mVar != g.Dj().CU() || o <= 0) {
                x.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
            } else if (o == 144385) {
                g.MG().ML();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            x.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
            if (g.Dh().Cy()) {
                g.Dm().F(new 4(this));
            }
        }
    }

    public static boolean hu(int i) {
        g.Dh();
        if (!a.Cx()) {
            return true;
        }
        x.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[]{Integer.valueOf(bh.a((Integer) g.Dj().CU().get(144385, null), 0)), Integer.valueOf(i), Integer.valueOf(bh.a((Integer) g.Dj().CU().get(144385, null), 0) & i), Boolean.valueOf(r.idn)});
        if (r.idn) {
            return true;
        }
        return (r0 & i) > 0;
    }

    public c() {
        g.Di().a(this.hsr);
        if (g.Dh().Cy()) {
            g.Dj().CU().a(this);
        }
        g.CG().a(379, this);
        com.tencent.mm.sdk.b.a.xef.b(this.hsq);
        x.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
    }

    public final boolean b(i iVar, int i) {
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            return false;
        } else if (bh.ov(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            return false;
        } else {
            if (iVar.field_fileId == null) {
                iVar.field_fileId = "";
            }
            if (iVar.field_aesKey == null) {
                iVar.field_aesKey = "";
            }
            iVar.fLH = false;
            g.Dm().F(new 5(this, i, iVar));
            return true;
        }
    }

    public final boolean c(i iVar) {
        if (bh.ov(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            return false;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        iVar.fLH = true;
        g.Dm().F(new 6(this, iVar));
        return true;
    }

    public final boolean kH(String str) {
        if (((i) this.hsu.remove(str)) != null) {
            g.MK();
            b.kz(str);
            com.tencent.mm.plugin.report.service.g.pQN.h(10769, new Object[]{Integer.valueOf(d.hsP), Integer.valueOf(r0.field_fileType), Long.valueOf(bh.Wp() - r0.field_startTime)});
        }
        this.hst.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, r0, Integer.valueOf(0)});
        return true;
    }

    public final boolean kI(String str) {
        i iVar = (i) this.hsu.remove(str);
        if (iVar != null) {
            if (iVar.field_fileType == b.hrV || iVar.field_fileType == b.hrX) {
                g.MK();
                b.kE(str);
            } else if (iVar.htz) {
                g.MK();
                b.kF(str);
            } else {
                g.MK();
                b.kA(str);
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(10769, new Object[]{Integer.valueOf(d.hsO), Integer.valueOf(iVar.field_fileType), Long.valueOf(bh.Wp() - iVar.field_startTime)});
        }
        this.hst.remove(str);
        this.hsv.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, iVar, Integer.valueOf(0)});
        return true;
    }

    public final void bJ(boolean z) {
        if (!z && g.MK().MD()) {
            g.Dh();
            if (a.Cx()) {
                x.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                g.MG().ML();
                return;
            }
        }
        ME();
        x.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[]{Integer.valueOf(this.hss.size())});
        while (!this.hss.isEmpty()) {
            i iVar = (i) this.hst.remove((String) this.hss.poll());
            if (iVar == null) {
                x.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                return;
            }
            x.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[]{iVar.field_mediaId, Boolean.valueOf(iVar.field_autostart), Integer.valueOf(iVar.field_chattype)});
            iVar.field_startTime = bh.Wp();
            String str;
            String str2;
            int i;
            i iVar2;
            i iVar3;
            int b;
            String str3;
            Object[] objArr;
            if (iVar.fLH) {
                String str4;
                str = "MicroMsg.CdnTransportService";
                str2 = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                Object[] objArr2 = new Object[7];
                if (iVar.field_fullpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_fullpath.length();
                }
                objArr2[0] = Integer.valueOf(i);
                if (iVar.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_thumbpath.length();
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = bh.VT(iVar.field_svr_signature);
                objArr2[3] = bh.VT(iVar.field_aesKey);
                objArr2[4] = Integer.valueOf(iVar.field_fileType);
                objArr2[5] = iVar.field_mediaId;
                objArr2[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                x.i(str, str2, objArr2);
                if (iVar.field_fullpath == null) {
                    iVar.field_fullpath = "";
                }
                if (iVar.field_thumbpath == null) {
                    iVar.field_thumbpath = "";
                }
                iVar2 = (i) this.hsu.put(iVar.field_mediaId, iVar);
                iVar3 = (i) this.hsu.get(iVar.field_mediaId);
                if (iVar3 == null) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(594, 5, 1, true);
                }
                g.MK();
                b = b.b(iVar);
                str = "MicroMsg.CdnTransportService";
                str3 = "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                objArr = new Object[5];
                objArr[0] = iVar.field_mediaId;
                objArr[1] = Integer.valueOf(b);
                objArr[2] = iVar2 == null ? null : iVar2.field_mediaId;
                if (iVar3 == null) {
                    str4 = null;
                } else {
                    str4 = iVar3.field_mediaId;
                }
                objArr[3] = str4;
                objArr[4] = Integer.valueOf(hashCode());
                x.i(str, str3, objArr);
                if (b != 0) {
                    iVar2 = (i) this.hsu.remove(iVar.field_mediaId);
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[]{Integer.valueOf(b), iVar.field_mediaId, iVar2});
                    if (iVar.htt != null) {
                        iVar.htt.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                }
            } else {
                i = -1;
                this.hsu.put(iVar.field_mediaId, iVar);
                int i2;
                if (iVar.field_fileType == b.hrV || iVar.field_fileType == b.hrX) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.MK();
                        i = b.a(iVar.field_mediaId, iVar.htu, iVar.field_fullpath, iVar.field_fileType, iVar.htv, iVar.htw, iVar.htx, iVar.hty);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    str3 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.htu;
                    objArr[3] = Integer.valueOf(iVar.field_fileType);
                    x.i(str2, str3, objArr);
                    b = i;
                } else if (iVar.htz) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.MK();
                        i = b.a(iVar.field_mediaId, iVar.field_fullpath, iVar.htu, iVar.htA, iVar.htB, iVar.allow_mobile_net_download, iVar.htv, iVar.htw, iVar.is_resume_task, iVar.htx);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    str3 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.htu;
                    objArr[3] = iVar.htA;
                    x.i(str2, str3, objArr);
                    b = i;
                } else {
                    if (!iVar.htC) {
                        str2 = "MicroMsg.CdnTransportService";
                        str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr = new Object[7];
                        if (iVar.field_fullpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_fullpath.length();
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (iVar.field_thumbpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_thumbpath.length();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = iVar.field_svr_signature;
                        objArr[3] = iVar.field_aesKey;
                        objArr[4] = Integer.valueOf(iVar.field_fileType);
                        objArr[5] = iVar.field_mediaId;
                        objArr[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                        x.i(str2, str3, objArr);
                        if (iVar.htD != 2) {
                            iVar2 = (i) this.hsu.put(iVar.field_mediaId, iVar);
                            iVar3 = (i) this.hsu.get(iVar.field_mediaId);
                            if (iVar3 == null) {
                                com.tencent.mm.plugin.report.service.g.pQN.a(594, 6, 1, true);
                            }
                            g.MK();
                            b = CdnLogic.startC2CDownload(b.a(iVar));
                            str = "MicroMsg.CdnTransportService";
                            str3 = "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                            objArr = new Object[5];
                            objArr[0] = iVar.field_mediaId;
                            objArr[1] = Integer.valueOf(b);
                            objArr[2] = iVar2 == null ? null : iVar2.field_mediaId;
                            objArr[3] = iVar3 == null ? null : iVar3.field_mediaId;
                            objArr[4] = Integer.valueOf(hashCode());
                            x.i(str, str3, objArr);
                        } else if (iVar instanceof j) {
                            j jVar = (j) iVar;
                            if (jVar.MN()) {
                                g.MK();
                                b = b.a(iVar, 2);
                            } else {
                                if (jVar.MM()) {
                                    g.MK();
                                    i = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.hto, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                                }
                                b = i;
                            }
                        }
                    } else if (iVar instanceof h) {
                        h hVar = (h) iVar;
                        g.MK();
                        b = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.htn, hVar.hto, hVar.htp, hVar.htq, hVar.htr, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.snsCipherKey, hVar.fWx, hVar.hts, hVar.fileType);
                    }
                    b = -1;
                }
                if (b != 0) {
                    iVar2 = (i) this.hsu.remove(iVar.field_mediaId);
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s remove[%s]", new Object[]{Integer.valueOf(b), iVar.field_mediaId, iVar2});
                    if (iVar.htt != null) {
                        iVar.htt.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                }
            }
        }
    }

    public static void ME() {
        g.Dh();
        if (a.Cx()) {
            com.tencent.mm.modelcdntran.b.c cVar = new com.tencent.mm.modelcdntran.b.c(g.MK());
            String value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableSnsStreamDownload");
            String value8 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableSnsImageDownload");
            String value9 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("ApprovedVideoPrivateProtocolHosts");
            try {
                if (!bh.ov(value)) {
                    cVar.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!bh.ov(value2)) {
                    cVar.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!bh.ov(value3)) {
                    cVar.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!bh.ov(value4)) {
                    cVar.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!bh.ov(value5)) {
                    cVar.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!bh.ov(value6)) {
                    cVar.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!bh.ov(value7)) {
                    cVar.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!bh.ov(value8)) {
                    cVar.field_EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                if (!bh.ov(value9)) {
                    cVar.field_ApprovedVideoHosts = value9;
                }
                g.MJ();
                cVar.field_EnableSafeCDN = hu(256) ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableJPEGDyncmicETL");
                    if (!bh.ov(value)) {
                        cVar.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!bh.ov(value2)) {
                        cVar.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!bh.ov(value3)) {
                        cVar.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!bh.ov(value4)) {
                        cVar.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!bh.ov(value5)) {
                        cVar.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                x.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[]{cVar});
                g.MK();
                b.a(cVar);
            } catch (NumberFormatException e) {
                x.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (r.idM) {
                int i;
                x.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                cVar.field_UseStreamCDN = r.idI ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    cVar.field_onlysendETL = r.idJ;
                    cVar.field_onlyrecvPtl = r.idK;
                    if (!bh.ov(r.idF)) {
                        cVar.field_WifiEtl = Integer.valueOf(r.idF).intValue();
                    }
                    if (!bh.ov(r.idG)) {
                        cVar.field_noWifiEtl = Integer.valueOf(r.idG).intValue();
                    }
                    if (!bh.ov(r.idH)) {
                        cVar.field_Ptl = Integer.valueOf(r.idH).intValue();
                    }
                }
                cVar.field_EnableCDNVerifyConnect = r.idN ? 1 : 0;
                if (r.idO) {
                    i = 1;
                } else {
                    i = 0;
                }
                cVar.field_EnableCDNVideoRedirectOC = i;
                x.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[]{cVar});
                g.MK();
                b.a(cVar);
            }
        }
    }

    public final int a(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null mediaId:%s", new Object[]{str});
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.e("MicroMsg.CdnTransportService", "cdn callback info all null mediaId:%s", new Object[]{str});
            return -2;
        } else {
            boolean z;
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                x.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify)});
            }
            long Wp = bh.Wp();
            String str2 = "MicroMsg.CdnTransportService";
            String str3 = "callback mediaId:%s, sceneResult is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
            this.hsx = Wp;
            this.hsw = str;
            g.Dm().F(new 7(this, str, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult));
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.hsu.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[]{str});
        } else if (iVar.htt != null) {
            iVar.htt.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] h(String str, byte[] bArr) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.hsu.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[]{str});
            return null;
        } else if (iVar.htt != null) {
            return iVar.htt.h(str, bArr);
        } else {
            x.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (!bh.ov(str)) {
            g.Dm().F(new 8(this, str, com_tencent_mm_modelcdntran_keep_SceneResult));
        }
    }
}
