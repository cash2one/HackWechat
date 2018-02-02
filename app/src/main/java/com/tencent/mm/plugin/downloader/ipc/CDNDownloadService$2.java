package com.tencent.mm.plugin.downloader.ipc;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class CDNDownloadService$2 implements a {
    final /* synthetic */ CDNDownloadService lrx;

    CDNDownloadService$2(CDNDownloadService cDNDownloadService) {
        this.lrx = cDNDownloadService;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2;
        String str3 = "MicroMsg.CDNDownloadService";
        String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo == null ? "null" : com_tencent_mm_modelcdntran_keep_ProgressInfo.toString();
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            str2 = "null";
        } else {
            str2 = com_tencent_mm_modelcdntran_keep_SceneResult.toString();
        }
        objArr[3] = str2;
        x.d(str3, str4, objArr);
        if (i == -21006) {
            x.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
        } else if (i != 0) {
            x.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            CDNDownloadService.a(this.lrx, str, 4, i);
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            CDNDownloadService.a(this.lrx, str, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength);
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                CDNDownloadService.a(this.lrx, str, 4, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            } else {
                x.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[]{str});
                CDNDownloadService.a(this.lrx, str, 3, 0);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
