package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;

class ak$1 implements a {
    final /* synthetic */ ak vfe;

    ak$1(ak akVar) {
        this.vfe = akVar;
    }

    public final int a(String str, final int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2 = "MicroMsg.NetSceneUploadAppAttach";
        String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = this.vfe.hBn;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
        objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
        objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
        objArr[5] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult != null);
        objArr[6] = Boolean.valueOf(z);
        x.d(str2, str3, objArr);
        an.aqd().b(this.vfe.veI, this.vfe.veF);
        if (i == -21005) {
            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{this.vfe.hBn});
            return 0;
        } else if (i != 0) {
            l.fr(this.vfe.veF.xjy);
            an.aqd().b(this.vfe.veI, this.vfe.veF);
            this.vfe.veF.field_signature = "";
            r0 = an.aqd().c(this.vfe.veF, new String[0]);
            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[]{Integer.valueOf(i), Long.valueOf(this.vfe.veI), Boolean.valueOf(r0)});
            this.vfe.gJT.a(3, i, "", this.vfe);
            g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.vfe.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(0), ""});
            return 0;
        } else if (this.vfe.veF.field_status == 105) {
            x.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[]{Long.valueOf(this.vfe.veF.field_status), Long.valueOf(this.vfe.veI)});
            com.tencent.mm.modelcdntran.g.MJ().kH(this.vfe.hBn);
            this.vfe.gJT.a(3, i, "attach  has paused, status" + this.vfe.veF.field_status, this.vfe);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            this.vfe.veF.field_lastModifyTime = bh.Wo();
            this.vfe.veF.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
            r0 = an.aqd().c(this.vfe.veF, new String[0]);
            if (r0) {
                return 0;
            }
            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + r0);
            this.vfe.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            this.vfe.gJT.a(3, i, "", this.vfe);
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    l.fr(this.vfe.veF.xjy);
                    an.aqd().b(this.vfe.veI, this.vfe.veF);
                    this.vfe.veF.field_signature = "";
                    r0 = an.aqd().c(this.vfe.veF, new String[0]);
                    x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(this.vfe.veI), Boolean.valueOf(r0)});
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.vfe.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.vfe.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.vfe.gJT.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.vfe);
                } else {
                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bh.VT(this.vfe.veF.field_signature)});
                    if (!z) {
                        a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                    } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                        ar.CG().a(new z(this.vfe.fnC, this.vfe.veF.field_fileFullPath, this.vfe.toUser, new z.a(this) {
                            final /* synthetic */ ak$1 vff;

                            public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                boolean z = true;
                                String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                Object[] objArr = new Object[7];
                                objArr[0] = str;
                                objArr[1] = bh.VT(str2);
                                objArr[2] = bh.VT(str3);
                                objArr[3] = bh.VT(str4);
                                objArr[4] = bh.VT(str5);
                                if (this.vff.vfe.fnC != null) {
                                    z = false;
                                }
                                objArr[5] = Boolean.valueOf(z);
                                objArr[6] = Boolean.valueOf(this.vff.vfe.hBF);
                                x.i(str6, str7, objArr);
                                if (!bh.ov(str3)) {
                                    this.vff.vfe.veF.field_signature = str3;
                                    this.vff.vfe.veF.field_fakeAeskey = str4;
                                    this.vff.vfe.veF.field_fakeSignature = str5;
                                }
                                this.vff.a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                            }
                        }), 0);
                    } else {
                        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                        ar.CG().a(new z(null, this.vfe.veF.field_fileFullPath, this.vfe.toUser, new 2(this, i)), 0);
                    }
                }
            }
            return 0;
        }
    }

    final void a(int i, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.vfe.veF.field_status = 199;
        boolean c = an.aqd().c(this.vfe.veF, new String[0]);
        if (c) {
            l.a(this.vfe.veF.field_msgInfoId, this.vfe.veF.field_mediaSvrId, com_tencent_mm_modelcdntran_keep_SceneResult);
            ar.CG().a(new ai(this.vfe.veF.field_msgInfoId, true, com_tencent_mm_modelcdntran_keep_SceneResult, new 3(this, com_tencent_mm_modelcdntran_keep_SceneResult), this.vfe.fqu, this.vfe.veF), 0);
            return;
        }
        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
        this.vfe.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
        this.vfe.gJT.a(3, i, "", this.vfe);
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
