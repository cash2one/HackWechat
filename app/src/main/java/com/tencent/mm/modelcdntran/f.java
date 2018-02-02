package com.tencent.mm.modelcdntran;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.w;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e, a {
    Map<String, j> hsY = new HashMap();
    Map<String, keep_SceneResult> hsZ = new HashMap();
    Queue<String> hss = new LinkedList();
    Map<String, j> hst = new HashMap();
    Map<String, j> hsu = new HashMap();

    public f() {
        g.CG().a(379, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            x.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (g.Dh().Cy()) {
                g.Dm().F(new Runnable(this) {
                    final /* synthetic */ f hta;

                    {
                        this.hta = r1;
                    }

                    public final void run() {
                        this.hta.bJ(true);
                    }
                });
            }
        }
    }

    public final boolean a(final j jVar, boolean z) {
        if (jVar == null) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            return false;
        } else if (bh.ov(jVar.field_mediaId)) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            return false;
        } else {
            x.i("MicroMsg.OnlineVideoService", "add download task : " + jVar.field_mediaId + " delay : " + z);
            if (jVar.field_fileId == null) {
                jVar.field_fileId = "";
            }
            if (jVar.field_aesKey == null) {
                jVar.field_aesKey = "";
            }
            jVar.fLH = false;
            if (b(jVar.field_mediaId, null) || z) {
                g.Dm().F(new Runnable(this) {
                    final /* synthetic */ f hta;

                    public final void run() {
                        this.hta.hss.add(jVar.field_mediaId);
                        this.hta.hst.put(jVar.field_mediaId, jVar);
                        this.hta.bJ(false);
                    }
                });
            } else {
                g.Dm().F(new 3(this, jVar));
            }
            return true;
        }
    }

    public final boolean b(final String str, final Object[] objArr) {
        boolean z = false;
        if (!bh.ov(str)) {
            if (this.hsu.containsKey(str)) {
                z = true;
            } else {
                g.MJ().kI(str);
            }
            g.Dm().F(new Runnable(this) {
                final /* synthetic */ f hta;

                public final void run() {
                    j jVar = (j) this.hta.hsu.remove(str);
                    keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult;
                    if (jVar != null) {
                        com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
                        if (g.MK().a(jVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult) == 0) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, jVar, false);
                        } else {
                            x.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[]{Integer.valueOf(g.MK().a(jVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult)), jVar.field_mediaId});
                        }
                    } else {
                        jVar = (j) this.hta.hsY.remove(str);
                        com_tencent_mm_modelcdntran_keep_SceneResult = (keep_SceneResult) this.hta.hsZ.remove(str);
                        if (!(jVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null)) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, jVar, true);
                        }
                    }
                    this.hta.hst.remove(str);
                }
            });
        }
        x.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (((j) this.hsu.get(str)) == null) {
            x.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[]{str});
            return false;
        }
        g.MK();
        x.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b.isVideoDataAvailable(str, i, i2))});
        return b.isVideoDataAvailable(str, i, i2);
    }

    public static int f(String str, int i, int i2) {
        g.MK();
        x.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(b.requestVideoData(str, i, i2, 0))});
        return b.requestVideoData(str, i, i2, 0);
    }

    public final void bJ(boolean z) {
        if (g.Dh().Cy()) {
            if (!z && g.MK().MD()) {
                g.Dh();
                if (com.tencent.mm.kernel.a.Cx()) {
                    x.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    g.MJ().bJ(z);
                    return;
                }
            }
            c.ME();
            while (!this.hss.isEmpty()) {
                String str = (String) this.hss.poll();
                j jVar = (j) this.hst.remove(str);
                if (jVar != null) {
                    jVar.field_startTime = bh.Wp();
                    if (!jVar.fLH) {
                        Object obj;
                        b kzVar;
                        int a;
                        boolean MN;
                        int i;
                        r nF;
                        int i2;
                        if (((Integer) g.Dj().CU().get(w.a.xso, Integer.valueOf(-1))).intValue() == 2) {
                            x.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!jVar.MO()) {
                            String str2 = jVar.htH;
                            int i3 = jVar.htI;
                            String dc = ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().dc(str2, i3);
                            int bN = i3 - com.tencent.mm.a.e.bN(dc);
                            if (!bh.ov(dc) && bN >= 0 && bN <= 16) {
                                x.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[]{Integer.valueOf(i3), str2, dc});
                                com.tencent.mm.sdk.platformtools.k.fp(dc, jVar.field_fullpath);
                                r nF2 = t.nF(jVar.filename);
                                a(nF2, i3, str2);
                                cf dH = ((h) g.h(h.class)).aZi().dH((long) nF2.hVI);
                                ((h) g.h(h.class)).aZi().a(new c(dH.field_talker, "update", dH));
                                obj = 1;
                                if (obj == null) {
                                    kzVar = new kz();
                                    kzVar.fCj.fuL = 6;
                                    kzVar.fCj.mediaId = str;
                                    com.tencent.mm.sdk.b.a.xef.m(kzVar);
                                } else {
                                    if (jVar.MN()) {
                                        g.MK();
                                        a = b.a(jVar, jVar.htJ);
                                    } else if (jVar.MM()) {
                                        if ((jVar.htE != 3 ? 1 : null) == null) {
                                            g.MK();
                                            a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.field_preloadRatio, jVar.concurrentCount);
                                        } else {
                                            g.MK();
                                            a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.hto, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.field_preloadRatio);
                                        }
                                    } else {
                                        g.MK();
                                        a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.hto, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                                    }
                                    x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[]{jVar, Integer.valueOf(a)});
                                    if (a == 0) {
                                        x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + jVar.field_mediaId);
                                        MN = jVar.MN();
                                        i = jVar.htJ;
                                        if (MN) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 210, 1, false);
                                            if (i != 1) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 211, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 212, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(200), Long.valueOf(bh.Wo()), ""});
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 3, 1, false);
                                            if (i != 1) {
                                                if (a == -21006) {
                                                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 100, 1, false);
                                                } else if (a != -20003) {
                                                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 101, 1, false);
                                                } else {
                                                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 106, 1, false);
                                            } else if (a != -20003) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 107, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 108, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(100), Long.valueOf(bh.Wo()), ""});
                                        }
                                    } else {
                                        jVar.htG = bh.Wp();
                                        if (jVar.MN()) {
                                            nF = t.nF(jVar.filename);
                                            if (nF != null) {
                                                i2 = nF.status;
                                                if (!(i2 == 120 || i2 == 122 || i2 == 121)) {
                                                    nF.status = 120;
                                                    nF.fDt = 256;
                                                    o.TU().b(nF);
                                                }
                                            }
                                        }
                                        this.hsu.put(jVar.field_mediaId, jVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (jVar.MN()) {
                                g.MK();
                                a = b.a(jVar, jVar.htJ);
                            } else if (jVar.MM()) {
                                if (jVar.htE != 3) {
                                }
                                if ((jVar.htE != 3 ? 1 : null) == null) {
                                    g.MK();
                                    a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.hto, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.field_preloadRatio);
                                } else {
                                    g.MK();
                                    a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.field_preloadRatio, jVar.concurrentCount);
                                }
                            } else {
                                g.MK();
                                a = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.htJ, jVar.hto, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                            }
                            x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[]{jVar, Integer.valueOf(a)});
                            if (a == 0) {
                                jVar.htG = bh.Wp();
                                if (jVar.MN()) {
                                    nF = t.nF(jVar.filename);
                                    if (nF != null) {
                                        i2 = nF.status;
                                        nF.status = 120;
                                        nF.fDt = 256;
                                        o.TU().b(nF);
                                    }
                                }
                                this.hsu.put(jVar.field_mediaId, jVar);
                            } else {
                                x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + jVar.field_mediaId);
                                MN = jVar.MN();
                                i = jVar.htJ;
                                if (MN) {
                                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 210, 1, false);
                                    if (i != 1) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 212, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 211, 1, false);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(200), Long.valueOf(bh.Wo()), ""});
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 3, 1, false);
                                    if (i != 1) {
                                        if (a == -21006) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 106, 1, false);
                                        } else if (a != -20003) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 108, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 107, 1, false);
                                        }
                                    } else if (a == -21006) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 100, 1, false);
                                    } else if (a != -20003) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 102, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 101, 1, false);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(100), Long.valueOf(bh.Wo()), ""});
                                }
                            }
                        } else {
                            kzVar = new kz();
                            kzVar.fCj.fuL = 6;
                            kzVar.fCj.mediaId = str;
                            com.tencent.mm.sdk.b.a.xef.m(kzVar);
                        }
                    }
                }
            }
        }
    }

    public final void onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[]{str});
        if (!bh.ov(str)) {
            g.Dm().F(new 5(this, str, i, i2));
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!bh.ov(str)) {
            g.Dm().F(new 6(this, str, i, i2));
        }
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!bh.ov(str)) {
            g.Dm().F(new 7(this, str, i, i2));
        }
    }

    public final int a(final String str, final keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (bh.ov(str)) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            return -2;
        } else {
            g.Dm().F(new Runnable(this) {
                final /* synthetic */ f hta;

                public final void run() {
                    j jVar = (j) this.hta.hsu.get(str);
                    if (jVar != null) {
                        if (jVar.htQ == null) {
                            r nF = t.nF(jVar.filename);
                            if (nF == null) {
                                x.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", new Object[]{jVar.filename});
                            } else if (jVar.htt != null) {
                                jVar.htt.a(str, 0, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, jVar.field_onlycheckexist);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                    this.hta.hsu.remove(str);
                                }
                            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                                if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == nF.hlp) {
                                    x.i("MicroMsg.OnlineVideoService", "stream download finish.");
                                } else if (nF.status == 130 || nF.hVB <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                                    x.i("MicroMsg.OnlineVideoService", "callback progress info " + com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength);
                                    nF.hVF = bh.Wo();
                                    nF.hVB = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                    nF.fDt = 1040;
                                    t.e(nF);
                                    r0 = new kz();
                                    r0.fCj.fuL = 5;
                                    r0.fCj.mediaId = str;
                                    r0.fCj.offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                    r0.fCj.length = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                                    com.tencent.mm.sdk.b.a.xef.m(r0);
                                } else {
                                    x.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", new Object[]{Integer.valueOf(nF.hVB), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
                                }
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                x.i("MicroMsg.OnlineVideoService", "callback result info " + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode + ", filesize:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + ",recved:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != -10012) {
                                        t.ny(nF.getFileName());
                                    }
                                    boolean MN = jVar.MN();
                                    int i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                                    int i2 = jVar.htJ;
                                    if (MN) {
                                        if (i2 == 1) {
                                            if (i == -5103059) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 111, 1, false);
                                            } else if (i == -5103087) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 112, 1, false);
                                            } else if (i == -10012) {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 113, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pQN.a(354, 114, 1, false);
                                            }
                                        } else if (i == -5103059) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 116, 1, false);
                                        } else if (i == -5103087) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 117, 1, false);
                                        } else if (i == -10012) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 118, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 119, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(101), Long.valueOf(bh.Wo()), Integer.valueOf(i)});
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 213, 1, false);
                                        if (i2 == 1) {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 214, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 215, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(201), Long.valueOf(bh.Wo()), Integer.valueOf(i)});
                                    }
                                } else {
                                    f.a(nF, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, jVar.htH);
                                    this.hta.hsY.put(jVar.field_mediaId, jVar);
                                    this.hta.hsZ.put(jVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult);
                                }
                                r0 = new kz();
                                r0.fCj.fuL = 4;
                                r0.fCj.mediaId = str;
                                r0.fCj.offset = 0;
                                r0.fCj.retCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                                r0.fCj.length = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                                com.tencent.mm.sdk.b.a.xef.m(r0);
                                this.hta.hsu.remove(str);
                            }
                        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                            jVar.htQ.g(str, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            jVar.htQ.K(str, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                            this.hta.hsu.remove(str);
                        }
                    }
                }
            });
            if (this.hsu.get(str) != null) {
                return 1;
            }
            return 0;
        }
    }

    static void a(r rVar, int i, String str) {
        x.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[]{Integer.valueOf(i)});
        if (rVar != null) {
            t.X(rVar.getFileName(), i);
            String fileName = rVar.getFileName();
            if (!bh.ov(str)) {
                o.TU();
                String nt = s.nt(fileName);
                if (bh.ov(str) || i <= 0 || bh.ov(nt)) {
                    x.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[]{Integer.valueOf(i), str, nt});
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().y(str, i, nt);
            }
        }
    }

    public static j a(an anVar, String str, String str2, String str3, int i) {
        if (anVar == null) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            return null;
        } else if (bh.ov(str)) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            return null;
        } else {
            r nF = t.nF(str3);
            if (nF == null) {
                x.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[]{str3});
                return null;
            }
            String a = d.a("snsvideo", (long) anVar.time, "sns", str);
            if (bh.ov(a)) {
                x.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[]{str});
                return null;
            }
            j jVar = new j();
            jVar.filename = str3;
            jVar.field_fullpath = str2;
            jVar.field_mediaId = a;
            jVar.htE = 2;
            jVar.htJ = i;
            jVar.htL = nF.htL;
            String str4 = "";
            if (anVar == null) {
                a = "";
            } else if (anVar.equals(an.xyR)) {
                a = "album_friend";
            } else if (anVar.equals(an.xyS)) {
                a = "album_self";
            } else if (anVar.equals(an.xyT)) {
                a = "album_stranger";
            } else if (anVar.equals(an.xyU)) {
                a = "profile_friend";
            } else if (anVar.equals(an.xyV)) {
                a = "profile_stranger";
            } else if (anVar.equals(an.xyW)) {
                a = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (anVar.equals(an.xyQ)) {
                a = "timeline";
            } else if (anVar.equals(an.xyZ)) {
                a = "snssight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            g.Dk();
            g.Dh();
            r3[1] = com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.Cg());
            r3[2] = Integer.valueOf(com.tencent.mm.sdk.platformtools.an.getNetTypeForStat(ac.getContext()));
            r3[3] = Integer.valueOf(com.tencent.mm.sdk.platformtools.an.getStrength(ac.getContext()));
            r3[4] = !bh.ov(a) ? "&scene=" + a : "";
            jVar.referer = String.format(str5, r3);
            jVar.url = str;
            long j = (long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            x.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[]{((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(anVar.time)});
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(anVar, jVar.url, j, r5);
            try {
                jVar.host = new URL(jVar.url).getHost();
                List arrayList = new ArrayList();
                com.tencent.mm.network.b.a(a2, arrayList, jVar.host);
                jVar.hto = new String[arrayList.size()];
                arrayList.toArray(jVar.hto);
                jVar.isColdSnsData = bh.by((long) anVar.time) > j;
                jVar.signalQuality = com.tencent.mm.sdk.platformtools.an.getStrength(ac.getContext());
                jVar.snsScene = a;
                return jVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", new Object[]{jVar});
                return null;
            }
        }
    }

    private static boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.time == 0 || bh.by((long) anVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    public static void a(Object[] objArr, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, j jVar, boolean z) {
        if (jVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            x.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
        } else if (jVar.MM() || jVar.MN()) {
            r nF;
            String str;
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int i;
            int i2;
            int i3;
            String str2;
            String str3 = com_tencent_mm_modelcdntran_keep_SceneResult.field_clientIP;
            x.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat), str3, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_isCrossNet ? 1 : 0)});
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat == 2) {
                nF = t.nF(jVar.filename);
                if (nF != null) {
                    nF.videoFormat = 2;
                    nF.fDt = 2;
                    boolean b = o.TU().b(nF);
                    x.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[]{Boolean.valueOf(b), str, Integer.valueOf(2)});
                }
            }
            if (bh.ov(str3)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 45, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 46, 1, false);
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_isCrossNet) {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 47, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 48, 1, false);
            }
            boolean MN = jVar.MN();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            t.a(jVar.field_fullpath, pInt, pInt2);
            int i4 = pInt.value * 1000;
            int i5 = pInt2.value;
            int i6 = 0;
            if (objArr != null) {
                intValue = ((Integer) objArr[0]).intValue() * 1000;
                intValue2 = ((Integer) objArr[1]).intValue();
                intValue3 = ((Integer) objArr[2]).intValue();
                intValue4 = ((Integer) objArr[3]).intValue();
                intValue5 = ((Integer) objArr[4]).intValue();
                intValue6 = ((Integer) objArr[5]).intValue();
                i6 = ((Integer) objArr[6]).intValue();
            } else {
                intValue5 = 0;
                intValue4 = 0;
                intValue3 = 0;
                intValue2 = 0;
                intValue = 0;
                intValue6 = 0;
            }
            int i7 = jVar.htL;
            if (i7 <= 0) {
                if (MN) {
                    i7 = 10;
                } else {
                    i7 = 31;
                }
            }
            int eQ = com.tencent.mm.sdk.platformtools.an.eQ(ac.getContext());
            String rptIpList = com_tencent_mm_modelcdntran_keep_SceneResult.getRptIpList();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            String str4 = jVar.filename;
            int i8 = jVar.htO;
            r nF2 = t.nF(str4);
            if (nF2 != null) {
                i = nF2.fzU;
                i2 = nF2.hlp;
                i3 = i;
                i = i2;
            } else {
                i3 = 0;
                i = 0;
            }
            if (i8 <= 0) {
                i2 = 1;
            } else {
                i2 = i3 < ((int) ((((float) i8) / 100.0f) * ((float) i))) ? 2 : 3;
                x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[]{Integer.valueOf(i8), Integer.valueOf(i), Integer.valueOf((int) ((((float) i8) / 100.0f) * ((float) i))), Integer.valueOf(i3)});
            }
            pInt3.value = i3;
            pInt4.value = i2;
            x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[]{Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value)});
            StringBuffer stringBuffer = new StringBuffer();
            if (MN) {
                stringBuffer.append(jVar.field_fileId).append(",").append(jVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(jVar.url).append(",").append(jVar.htM).append(",");
            }
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength).append(",").append(i4).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes).append(",");
            stringBuffer.append(intValue + ",").append(intValue2 + ",").append(intValue3 + ",");
            stringBuffer.append(intValue4 + ",").append(intValue5 + ",");
            stringBuffer.append(eQ).append(",");
            stringBuffer.append(i7).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime).append(",");
            if (MN) {
                stringBuffer.append(jVar.htK != null ? com.tencent.mm.a.g.s(jVar.htK.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(com.tencent.mm.z.s.eV(jVar.htK) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode).append(",");
            }
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_enQueueTime).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageSpeed).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageConnectCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstConnectCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_netConnectTimes).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovRequestTimes).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovFailReason).append(",");
            stringBuffer.append(intValue6).append(",");
            stringBuffer.append(i6).append(",");
            if (MN) {
                stringBuffer.append(i5).append(",");
            } else {
                stringBuffer.append(i5).append(",");
                stringBuffer.append(jVar.htK != null ? com.tencent.mm.a.g.s(jVar.htK.getBytes()) : Integer.valueOf(0)).append(",");
            }
            stringBuffer.append(rptIpList).append(",");
            if (MN) {
                stringBuffer.append(jVar.htN).append(",");
                stringBuffer.append(jVar.fFo).append(",");
                stringBuffer.append(jVar.initialDownloadLength).append(",");
                stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat).append(",");
            } else {
                stringBuffer.append(jVar.fzW).append(",");
            }
            stringBuffer.append(str3).append(",");
            stringBuffer.append(r11).append(",");
            stringBuffer.append(jVar.htP).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value);
            x.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[]{Integer.valueOf(MN ? 13570 : 13790), stringBuffer.toString()});
            com.tencent.mm.plugin.report.service.g.pQN.k(i6, str2);
            if (z) {
                str = jVar.fzO;
                str2 = jVar.htK;
                intValue5 = jVar.fzQ;
                String str5 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                long j = com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime;
                long j2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime;
                String str6 = jVar.field_fullpath;
                String[] strArr = com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps;
                String str7 = jVar.url;
                i3 = pInt3.value;
                int i9 = pInt4.value;
                String str8 = jVar.fzW;
                b jjVar = new jj();
                jjVar.fzN.fzO = str;
                jjVar.fzN.fzP = str2;
                jjVar.fzN.fzQ = intValue5;
                jjVar.fzN.fzR = str5;
                jjVar.fzN.netType = eQ;
                jjVar.fzN.startTime = j;
                jjVar.fzN.endTime = j2;
                jjVar.fzN.path = str6;
                jjVar.fzN.fzS = strArr;
                jjVar.fzN.fzT = str7;
                jjVar.fzN.fzU = i3;
                jjVar.fzN.fzV = i9;
                jjVar.fzN.fzW = str8;
                com.tencent.mm.sdk.b.a.xef.m(jjVar);
            }
            if (MN) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat == 2) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 132, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 133, 1, false);
                }
                nF = t.nF(jVar.filename);
                if (nF != null) {
                    cf dH = ((h) g.h(h.class)).aZi().dH((long) nF.hVI);
                    ((h) g.h(h.class)).aZi().a(new c(dH.field_talker, "update", dH));
                }
            }
        }
    }
}
