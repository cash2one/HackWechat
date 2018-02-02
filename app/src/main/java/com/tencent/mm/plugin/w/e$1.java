package com.tencent.mm.plugin.w;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.ByteArrayOutputStream;

class e$1 implements a {
    final /* synthetic */ e oFJ;

    e$1(e eVar) {
        this.oFJ = eVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
        if (i == -21005) {
            x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", str);
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", str, Integer.valueOf(i));
            g.pQN.a(466, 2, 1, false);
            g.pQN.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.oFJ.fAo));
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, str, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    g.pQN.a(466, 2, 1, false);
                    g.pQN.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.oFJ.fAo));
                } else {
                    x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", str, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType));
                    PByteArray pByteArray = new PByteArray();
                    if (MMProtocalJni.rsaPublicEncryptPemkey(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey.getBytes(), pByteArray, this.oFJ.oFz)) {
                        String by = bh.by(pByteArray.value);
                        this.oFJ.oFA = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        this.oFJ.oFB = by;
                        this.oFJ.oFC = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                        if (com.tencent.mm.kernel.a.gB(com.tencent.mm.kernel.g.Dh().gPs)) {
                            x.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                            this.oFJ.bbM();
                        } else {
                            x.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                            ar.Hg();
                            c.a(this.oFJ);
                            this.oFJ.oFH = true;
                        }
                    } else {
                        x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                        return -1;
                    }
                }
            }
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
