package com.tencent.mm.plugin.card.b;

import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.card.b.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

class a$1 implements i$a {
    final /* synthetic */ String hVc;
    final /* synthetic */ String icE;

    a$1(String str, String str2) {
        this.hVc = str;
        this.icE = str2;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i == -21005) {
            x.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[]{str});
        } else if (i != 0) {
            x.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
            for (r1 = 0; r1 < a.JL().size(); r1++) {
                r0 = (WeakReference) a.JL().get(r1);
                if (r0 != null) {
                    r0 = (a) r0.get();
                    if (r0 != null) {
                        r0.fail(this.hVc);
                    }
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                r1 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
            } else {
                r1 = 0;
            }
            if (r1 < 0) {
                r1 = 0;
            } else if (r1 > 100) {
                r1 = 100;
            }
            for (int i2 = 0; i2 < a.JL().size(); i2++) {
                r0 = (WeakReference) a.JL().get(i2);
                if (r0 != null) {
                    r0 = (a) r0.get();
                    if (r0 != null) {
                        r0.aW(this.hVc, r1);
                    }
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                for (r1 = 0; r1 < a.JL().size(); r1++) {
                    r0 = (WeakReference) a.JL().get(r1);
                    if (r0 != null) {
                        r0 = (a) r0.get();
                        if (r0 != null) {
                            r0.fail(this.hVc);
                        }
                    }
                }
            } else {
                x.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult});
                for (r1 = 0; r1 < a.JL().size(); r1++) {
                    r0 = (WeakReference) a.JL().get(r1);
                    if (r0 != null) {
                        r0 = (a) r0.get();
                        if (r0 != null) {
                            r0.bU(this.hVc, this.icE);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
    }

    public final byte[] h(String str, byte[] bArr) {
        x.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[]{str});
        return null;
    }
}
