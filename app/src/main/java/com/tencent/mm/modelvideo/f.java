package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.Map;

public final class f {
    long fqm;
    public String frH;
    private a hBx = new 1(this);
    private j hTS;
    boolean hUd = false;
    String hUe;
    private long hUf;
    long hUg;
    long hUh;
    int hUi;
    private String hUj;
    public a hUk;
    private b htF = new 2(this);
    String htH;
    private String mediaId;

    public f(long j) {
        this.fqm = j;
        this.hUd = true;
    }

    public f(j jVar, String str) {
        this.hTS = jVar;
        this.frH = str;
        this.hUd = false;
    }

    public final String TM() {
        return this.hUd ? this.fqm : this.frH;
    }

    public final void stop() {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.mediaId);
        if (!bh.ov(this.mediaId)) {
            keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
            c MJ = g.MJ();
            String str = this.mediaId;
            int i = 0;
            if (((i) MJ.hsu.remove(str)) != null) {
                i = g.MK().a(str, com_tencent_mm_modelcdntran_keep_SceneResult);
                com.tencent.mm.plugin.report.service.g.pQN.h(10769, Integer.valueOf(d.hsO), Integer.valueOf(r0.field_fileType), Long.valueOf(bh.Wp() - r0.field_startTime));
            }
            MJ.hst.remove(str);
            MJ.hsv.remove(str);
            x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.hUg = bh.Wo();
            this.hUh = (long) c(this.hUe, com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes, false);
            ni(com_tencent_mm_modelcdntran_keep_SceneResult.getRptIpList());
        }
        this.hUk = null;
    }

    public final int a(a aVar) {
        this.hUk = aVar;
        try {
            String str;
            String str2;
            i iVar;
            Object obj;
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.fqm));
            i iVar2;
            if (this.hUd) {
                cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH(this.fqm);
                ba.b hT = ba.hT(dH.gjF);
                if (hT == null || hT.hgR <= 0) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    iVar2 = null;
                } else {
                    String str3 = dH.field_imgPath;
                    r nF = t.nF(str3);
                    if (nF == null) {
                        iVar2 = null;
                    } else {
                        Map y = bi.y(nF.Ug(), "msg");
                        if (y == null) {
                            x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            iVar2 = null;
                        } else {
                            str = (String) y.get(".msg.videomsg.$cdnvideourl");
                            if (bh.ov(str)) {
                                x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                iVar2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) y.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) y.get(".msg.videomsg.$md5");
                                str2 = (String) y.get(".msg.videomsg.$newmd5");
                                String str5 = (String) y.get(".msg.videomsg.$aeskey");
                                String str6 = (String) y.get(".msg.videomsg.$fileparam");
                                String a = d.a("downvideo", nF.hVE, nF.Ud(), nF.getFileName());
                                if (bh.ov(a)) {
                                    x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", nF.getFileName());
                                    iVar2 = null;
                                } else {
                                    o.TU();
                                    String nt = s.nt(str3);
                                    i jVar = new j();
                                    jVar.filename = str3;
                                    jVar.htH = str4;
                                    jVar.htI = intValue;
                                    jVar.htJ = 2;
                                    jVar.fzO = nF.Ue();
                                    jVar.htK = nF.Ud();
                                    jVar.fzQ = s.eV(nF.Ud()) ? m.gl(nF.Ud()) : 0;
                                    jVar.field_mediaId = a;
                                    jVar.field_fullpath = nt;
                                    jVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                    jVar.field_totalLen = intValue;
                                    jVar.field_aesKey = str5;
                                    jVar.field_fileId = str;
                                    jVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                                    jVar.field_wxmsgparam = str6;
                                    jVar.field_chattype = s.eV(nF.Ud()) ? 1 : 0;
                                    jVar.field_autostart = false;
                                    jVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, nF);
                                    jVar.field_preloadRatio = hT.hgR;
                                    jVar.fek = str2;
                                    iVar2 = jVar;
                                }
                            }
                        }
                    }
                }
                if (iVar2 != null) {
                    this.hUi = s.eV(iVar2.htK) ? 2 : 1;
                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 140, 1, false);
                    if (this.hUi == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 121, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 122, 1, false);
                    }
                }
                if (this.hTS == null) {
                    this.hTS = iVar2;
                    iVar = iVar2;
                } else {
                    iVar = iVar2;
                }
            } else {
                this.hUi = 3;
                iVar2 = this.hTS;
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 141, 1, false);
                iVar = iVar2;
            }
            if (iVar == null) {
                x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!iVar.MO()) {
                    str2 = iVar.htH;
                    int i = iVar.htI;
                    str = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().dc(str2, i);
                    int bN = i - e.bN(str);
                    if (!bh.ov(str) && bN >= 0 && bN <= 16) {
                        x.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        k.fp(str, iVar.field_fullpath);
                        f(iVar.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            iVar.htF = this.htF;
                            iVar.htt = this.hBx;
                            iVar.htD = 2;
                            this.htH = iVar.htH;
                            this.mediaId = iVar.field_mediaId;
                            this.hUe = iVar.filename;
                            this.hUf = bh.Wo();
                            this.hUj = iVar.fek;
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), iVar);
                            g.MJ().b(iVar, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    iVar.htF = this.htF;
                    iVar.htt = this.hBx;
                    iVar.htD = 2;
                    this.htH = iVar.htH;
                    this.mediaId = iVar.field_mediaId;
                    this.hUe = iVar.filename;
                    this.hUf = bh.Wo();
                    this.hUj = iVar.fek;
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), iVar);
                    g.MJ().b(iVar, -1);
                    obj = 1;
                } else {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                    obj = null;
                }
            }
            if (obj != null) {
                return 0;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.hUk = null;
        return -1;
    }

    static int c(String str, int i, boolean z) {
        r nF = t.nF(str);
        if (nF == null) {
            return i;
        }
        int i2;
        int i3 = nF.fzU;
        if (z) {
            nF.fzU = i;
        } else {
            nF.fzU = i3 + i;
        }
        x.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(nF.fzU), Boolean.valueOf(z));
        nF.hVF = bh.Wo();
        nF.fDt = 1025;
        t.e(nF);
        if (z) {
            i2 = i - i3;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    final void f(String str, int i, String str2) {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (t.nF(str) != null) {
            t.X(str, i);
            if (!bh.ov(str2)) {
                o.TU();
                String nt = s.nt(str);
                if (bh.ov(str2) || i <= 0 || bh.ov(nt) || !e.bO(nt)) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str2, nt);
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().y(str2, i, nt);
            }
        }
    }

    final void ni(String str) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.hUf).append(",");
        stringBuffer.append(this.hUg).append(",");
        stringBuffer.append(this.hUh).append(",");
        stringBuffer.append(this.hUj).append(",");
        stringBuffer.append(this.hUi).append(",");
        try {
            i = (int) ((this.hUh / 1024) / (this.hUg - this.hUf));
        } catch (Exception e) {
            i = 0;
        }
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(this.hTS.fzO).append(",");
        stringBuffer.append(this.hTS.htK).append(",");
        stringBuffer.append(this.hTS.fzQ).append(",");
        stringBuffer.append(this.hTS.field_fileId).append(",");
        stringBuffer.append(this.hTS.url).append(",");
        stringBuffer.append(this.hTS.fzW);
        x.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        com.tencent.mm.plugin.report.service.g.pQN.k(14499, r0);
    }
}
