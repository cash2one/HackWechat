package com.tencent.mm.modelvideo;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import java.io.ByteArrayOutputStream;
import java.util.List;

final class m$a implements e, a {
    final /* synthetic */ m hUT;
    String hUU;
    long hUa;
    r hUb;
    List<r> hiw;
    long startTime;

    private m$a(m mVar) {
        this.hUT = mVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.hUU, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (i == -21005) {
            x.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{this.hUU});
            return 0;
        } else if (i != 0) {
            m.V(this.hiw);
            x.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", new Object[]{Long.valueOf(this.hUa), Integer.valueOf(i)});
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), ""});
            this.hUT.d(this.hUa, 3, i);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.v("MicroMsg.SightMassSendService", "progress length %d", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
            for (r rVar : this.hiw) {
                rVar.hVF = bh.Wo();
                rVar.hUp = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                rVar.fDt = 1032;
                t.e(rVar);
            }
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, Long.valueOf(this.hUa)});
                    m.V(this.hiw);
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.hUT.d(this.hUa, 3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                } else {
                    x.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Long.valueOf(this.hUa)});
                    x.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", new Object[]{((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>"});
                    for (r rVar2 : this.hiw) {
                        if (bh.ov(rVar2.Ug())) {
                            rVar2.hVN = r1;
                            rVar2.fDt = 2097152;
                            boolean e = t.e(rVar2);
                            x.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", new Object[]{Long.valueOf(this.hUa), rVar2.getFileName(), Boolean.valueOf(e)});
                        }
                    }
                    synchronized (m.a(this.hUT)) {
                        if (bh.ov((String) m.b(this.hUT).get(Long.valueOf(this.hUa)))) {
                            x.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", new Object[]{Long.valueOf(this.hUa), (String) m.b(this.hUT).get(Long.valueOf(this.hUa)), this.hUU});
                        } else {
                            x.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", new Object[]{Long.valueOf(this.hUa), (String) m.b(this.hUT).get(Long.valueOf(this.hUa)), this.hUU});
                            m.b(this.hUT).put(Long.valueOf(this.hUa), "done_upload_cdn_client_id");
                            com.tencent.mm.kernel.g.CG().a(245, this);
                            if (!com.tencent.mm.kernel.g.CG().a(new e(this.hUa, this.hUb, com_tencent_mm_modelcdntran_keep_SceneResult, this.hUU), 0)) {
                                x.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                com.tencent.mm.kernel.g.CG().b(245, this);
                                this.hUT.d(this.hUa, 3, 0);
                            }
                        }
                    }
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

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.kernel.g.CG().b(245, this);
        if (i == 4 && i2 == -22) {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.hUa);
            m.W(this.hiw);
            this.hUT.d(this.hUa, i, i2);
        } else if (i == 4 && i2 != 0) {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hUa);
            m.V(this.hiw);
            this.hUT.d(this.hUa, i, i2);
        } else if (i == 0 && i2 == 0) {
            for (r rVar : this.hiw) {
                rVar.hVF = bh.Wo();
                rVar.status = 199;
                rVar.fDt = 1280;
                if (t.e(rVar)) {
                    if (rVar == null) {
                        x.e("MicroMsg.VideoLogic", "video info is null");
                    } else if (rVar.hVI > 0) {
                        cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) rVar.hVI);
                        int type = dH.getType();
                        x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", new Object[]{Integer.valueOf(type)});
                        if (43 == type || 62 == type) {
                            dH.eR(1);
                            dH.dS(rVar.Ud());
                            dH.ap(rVar.fFo);
                            dH.eQ(2);
                            dH.setContent(p.b(rVar.Ue(), (long) rVar.hVH, false));
                            ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a((long) rVar.hVI, dH);
                            x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", new Object[]{Long.valueOf(dH.field_msgId)});
                        }
                    } else {
                        cf auVar = new au();
                        auVar.dS(rVar.Ud());
                        auVar.setType(62);
                        auVar.eR(1);
                        auVar.dT(rVar.getFileName());
                        auVar.eQ(2);
                        auVar.aq(ba.hR(rVar.Ud()));
                        rVar.hVI = (int) ba.i(auVar);
                        rVar.fDt = 8192;
                        t.e(rVar);
                        x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
                    }
                }
                x.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", new Object[]{Long.valueOf(this.hUa), rVar.getFileName(), Integer.valueOf(199)});
            }
            com.tencent.mm.kernel.g.Dm().F(new m$1(this.hUT, this.hUa));
        } else {
            x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hUa);
            m.V(this.hiw);
            this.hUT.d(this.hUa, i, i2);
        }
    }
}
