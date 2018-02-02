package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class b$6 implements a {
    final /* synthetic */ b mrg;

    b$6(b bVar) {
        this.mrg = bVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.i("MicroMsg.Fav.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
        }
        String str2 = "";
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            str2 = com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId;
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            str2 = com_tencent_mm_modelcdntran_keep_SceneResult.mediaId;
        }
        if (i == -21006 || i == -21005) {
            this.mrg.Ak(str2);
            return 0;
        }
        if (!bh.ov(str2)) {
            str = str2;
        }
        c zT = ((r) g.k(r.class)).getFavCdnStorage().zT(str);
        if (zT == null) {
            x.e("MicroMsg.Fav.FavCdnService", "klem onCdnCallback info null");
            this.mrg.Ak(str);
            return 0;
        }
        if (i != 0) {
            x.w("MicroMsg.Fav.FavCdnService", "cdn transfer callback, startRet=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.report.service.g.pQN.h(10660, new Object[]{Integer.valueOf(zT.field_type), Integer.valueOf(i)});
            zT.field_status = 4;
            ((r) g.k(r.class)).getFavCdnStorage().a(zT, new String[0]);
            b.d(zT);
            this.mrg.Ak(str);
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            zT.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
            zT.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
            zT.field_status = 1;
            ((r) g.k(r.class)).getFavCdnStorage().a(zT, new String[0]);
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            String str3;
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                zT.field_status = 3;
                if (1 == zT.field_type) {
                    str2 = zT.field_path + ".temp";
                    str3 = zT.field_path;
                    int i2 = zT.field_dataType;
                    if (!(str2 == null || str3 == null)) {
                        if (i2 == -2 && !b.Aj(str2) && b.cx(str2, str3)) {
                            x.i("MicroMsg.Fav.FavCdnService", "renameAndCopyFile write amr head ok!");
                        } else {
                            File file = new File(str2);
                            File file2 = new File(str3);
                            if (file.exists()) {
                                boolean renameTo = file.renameTo(file2);
                                x.i("MicroMsg.Fav.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[]{Boolean.valueOf(renameTo), str2, file2});
                            }
                        }
                    }
                } else {
                    zT.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                    zT.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                }
                ((r) g.k(r.class)).getFavCdnStorage().a(zT, new String[0]);
                b.a(this.mrg, zT, com_tencent_mm_modelcdntran_keep_SceneResult);
                ((r) g.k(r.class)).getFavCdnStorage().b(zT, new String[]{"dataId"});
                this.mrg.mra.remove(zT.field_dataId);
                x.i("MicroMsg.Fav.FavCdnService", "transfer done, mediaid=%s, md5=%s aeskey=%s completeInfo=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str, com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
            } else {
                x.e("MicroMsg.Fav.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                b.a aVar = (b.a) this.mrg.mra.get(zT.field_dataId);
                if (aVar != null) {
                    aVar.errCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                }
                if (-6101 != com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                    switch (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                        case -5103015:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 8, 1, true);
                            break;
                        case -21020:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 7, 1, true);
                            break;
                        case -21014:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 6, 1, true);
                            break;
                        case -21009:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 5, 1, true);
                            break;
                        case -21000:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 4, 1, true);
                            break;
                        case -10005:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 3, 1, true);
                            break;
                        case -10003:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 2, 1, true);
                            break;
                        default:
                            com.tencent.mm.plugin.report.service.g.pQN.a(141, 0, 1, true);
                            break;
                    }
                }
                int i3;
                zT.field_extFlag |= 1;
                com.tencent.mm.plugin.report.service.g.pQN.a(141, 1, 1, true);
                str3 = "MicroMsg.Fav.FavCdnService";
                String str4 = "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d";
                Object[] objArr = new Object[4];
                objArr[0] = com_tencent_mm_modelcdntran_keep_SceneResult.mediaId;
                if (aVar != null) {
                    i3 = aVar.ics;
                } else {
                    i3 = 1;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Integer.valueOf(zT.field_type);
                objArr[3] = Integer.valueOf(zT.field_dataType);
                x.e(str3, str4, objArr);
                zT.field_status = 4;
                com.tencent.mm.plugin.report.service.g.pQN.h(10660, new Object[]{Integer.valueOf(zT.field_type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                ((r) g.k(r.class)).getFavCdnStorage().a(zT, new String[0]);
                b.d(zT);
            }
            b.a(this.mrg, str);
            com.tencent.mm.plugin.report.service.g.pQN.h(10625, new Object[]{Integer.valueOf(1), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, "", com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
