package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

class b$1 implements a {
    final /* synthetic */ b iLE;

    b$1(b bVar) {
        this.iLE = bVar;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
    }

    public final byte[] h(String str, byte[] bArr) {
        x.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2;
        a aVar;
        String str3 = "MicroMsg.AppbrandCdnService";
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
        x.i(str3, str4, objArr);
        c Zq = f.Zq();
        if (!bh.ov(str)) {
            for (a aVar2 : Zq.iLF.values()) {
                if (bh.ou(aVar2.mediaId).equals(str)) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        x.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
        aVar = null;
        if (aVar == null) {
            x.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[]{str});
            return 0;
        } else if (i == -21005) {
            x.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
            return 0;
        } else if (i != 0) {
            x.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            b.a(this.iLE, false, aVar.fus, aVar.mediaId, null);
            return 0;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            int i2;
            x.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
            int i3 = 0;
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                i3 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
            }
            if (i3 < 0) {
                i2 = 0;
            } else if (i3 > 100) {
                i2 = 100;
            } else {
                i2 = i3;
            }
            b bVar = this.iLE;
            boolean z2 = aVar.iLx;
            int i4 = aVar.ftE;
            String str5 = aVar.fus;
            str4 = aVar.mediaId;
            x.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i2), str5, str4});
            if (bVar.iLB != null && bVar.iLB.size() > 0) {
                Iterator it = bVar.iLB.iterator();
                while (it.hasNext()) {
                    ((d.a) it.next()).B(i2, str5);
                }
            }
            return 0;
        } else {
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                    b.a(this.iLE, false, aVar.fus, aVar.mediaId, null);
                } else {
                    x.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                    if (aVar != null) {
                        if (aVar.iLw == null) {
                            aVar.iLw = new a.a();
                        }
                        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                            x.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
                        } else {
                            aVar.iLw.field_aesKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                            aVar.iLw.field_fileId = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                            aVar.iLw.field_fileUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                            aVar.iLw.field_fileLength = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                            aVar.iLv = aVar.iLw.field_fileId;
                        }
                        f.Zq().a(aVar);
                        b.a(this.iLE, true, aVar.fus, aVar.iLv, aVar.iLw.field_fileUrl);
                    }
                }
            }
            return 0;
        }
    }
}
