package com.tencent.mm.plugin.record.b;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;
import java.io.File;

class d$1 implements a {
    final /* synthetic */ d pFi;

    d$1(d dVar) {
        this.pFi = dVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", Integer.valueOf(i), str);
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
        }
        if (i == -21006 || i == -21005) {
            this.pFi.bmQ();
            return 0;
        }
        f Ij = n.getRecordMsgCDNStorage().Ij(str);
        if (Ij == null) {
            x.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", str);
            this.pFi.bmQ();
            return 0;
        }
        if (i != 0) {
            x.w("MicroMsg.RecordMsgCDNService", "tran fail, startRet[%d], mediaId[%s], type[%d]", Integer.valueOf(i), str, Integer.valueOf(Ij.field_type));
            if (-5103059 == i) {
                Ij.field_status = 4;
            } else {
                Ij.field_status = 3;
            }
            Ij.field_errCode = i;
            n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
        } else {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                Ij.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                Ij.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                Ij.field_status = 1;
                n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                x.i("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bh.VT(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                    Ij.field_status = 2;
                    if (1 == Ij.field_type) {
                        String str2 = Ij.field_path + ".temp";
                        String str3 = Ij.field_path;
                        if (bh.ov(str2) || bh.ov(str3)) {
                            x.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                        } else {
                            File file = new File(str2);
                            File file2 = new File(str3);
                            if (file.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                x.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(renameTo), str2, file2);
                            }
                        }
                        n.getRecordMsgCDNStorage().a(Ij, new String[]{"localId"});
                    } else {
                        x.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str);
                        x.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", com_tencent_mm_modelcdntran_keep_SceneResult);
                        x.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                            x.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5);
                            ar.CG().a(new aa(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc, new 1(this, Ij, com_tencent_mm_modelcdntran_keep_SceneResult)), 0);
                            return 0;
                        }
                        Ij.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        Ij.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
                    }
                } else {
                    x.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                    if (-5103059 == com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                        Ij.field_status = 4;
                    } else {
                        Ij.field_status = 3;
                    }
                    Ij.field_errCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                    n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
                }
            }
            return 0;
        }
        this.pFi.bmQ();
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
