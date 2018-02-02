package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.Map;

class g$1 implements i$a {
    final /* synthetic */ g hUv;

    g$1(g gVar) {
        this.hUv = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{g.a(this.hUv), g.b(this.hUv), Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (i == -21005) {
            x.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{g.b(this.hUv)});
            return 0;
        } else if (i != 0) {
            t.ny(g.c(this.hUv));
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(g.d(this.hUv)), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(g.e(this.hUv)), Integer.valueOf(0), ""});
            g.f(this.hUv).a(3, i, "", this.hUv);
            return 0;
        } else {
            g.a(this.hUv, t.nF(g.c(this.hUv)));
            int i2;
            if (g.g(this.hUv) == null || g.g(this.hUv).status == 105) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", new Object[]{g.a(this.hUv), Integer.valueOf(g.g(this.hUv) == null ? -1 : g.g(this.hUv).status)});
                com.tencent.mm.modelcdntran.g.MJ().kH(g.b(this.hUv));
                g.f(this.hUv).a(3, i, "info is null or has paused, status" + i2, this.hUv);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{g.a(this.hUv), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
                        t.ny(g.c(this.hUv));
                        g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.hUv)), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(g.e(this.hUv)), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                        g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(g.d(this.hUv)), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(g.e(this.hUv)), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                        g.f(this.hUv).a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hUv);
                    } else {
                        x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", new Object[]{g.a(this.hUv), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(g.h(this.hUv))});
                        g gVar = g.pQN;
                        Object[] objArr = new Object[2];
                        i2 = g.i(this.hUv) ? 810 : g.j(this.hUv) ? 820 : 830;
                        objArr[0] = Integer.valueOf(i2 + com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                        objArr[1] = Integer.valueOf(g.g(this.hUv).hlp);
                        gVar.h(12696, objArr);
                        boolean z2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced;
                        x.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", new Object[]{g.a(this.hUv), Boolean.valueOf(z2), g.c(this.hUv)});
                        if (z2) {
                            g.pQN.a(106, 200, 1, false);
                        } else {
                            g.pQN.a(106, 205, 1, false);
                            if (g.k(this.hUv) > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                                x.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", new Object[]{g.a(this.hUv), Integer.valueOf(g.k(this.hUv)), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength)});
                                if (g.k(this.hUv) * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength) {
                                    g.pQN.a(106, 206, 1, false);
                                } else {
                                    g.pQN.a(106, 207, 1, false);
                                }
                            }
                            o.TU();
                            x.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", new Object[]{g.a(this.hUv), Integer.valueOf(g.g(this.hUv).hlp), Integer.valueOf(e.bN(s.nt(g.c(this.hUv))))});
                            if (g.g(this.hUv).hlp != e.bN(s.nt(g.c(this.hUv)))) {
                                g.pQN.a(106, 208, 1, false);
                            } else {
                                g.pQN.a(106, 209, 1, false);
                            }
                        }
                        g.a(this.hUv, t.nF(g.c(this.hUv)));
                        if (bh.ov(g.g(this.hUv).Ug())) {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", new Object[]{g.a(this.hUv), ((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>"});
                            g.g(this.hUv).hVN = r0;
                            t.e(g.g(this.hUv));
                        }
                        Map y = bi.y(g.g(this.hUv).Ug(), "msg");
                        if (y != null) {
                            s TU = o.TU();
                            o.TU();
                            boolean p = TU.p(s.nt(g.c(this.hUv)), (String) y.get(".msg.videomsg.$cdnvideourl"), (String) y.get(".msg.videomsg.$aeskey"));
                            gVar = g.pQN;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf((p ? 1 : 2) + 900);
                            objArr[1] = Integer.valueOf(g.g(this.hUv).hlp);
                            gVar.h(12696, objArr);
                        }
                        com.tencent.mm.kernel.g.CG().a(new h(g.c(this.hUv), z2 ? 0 : g.l(this.hUv), com_tencent_mm_modelcdntran_keep_SceneResult, new 1(this, com_tencent_mm_modelcdntran_keep_SceneResult)), 0);
                    }
                }
                return 0;
            } else if (g.g(this.hUv).hUp > com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", new Object[]{g.a(this.hUv), Integer.valueOf(g.g(this.hUv).hUp), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
                return 0;
            } else {
                g.g(this.hUv).hVF = bh.Wo();
                g.g(this.hUv).hUp = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                g.g(this.hUv).fDt = 1032;
                t.e(g.g(this.hUv));
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
