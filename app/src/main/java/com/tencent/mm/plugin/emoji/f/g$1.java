package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.emoji.e.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class g$1 implements i$a {
    final /* synthetic */ g lyN;

    g$1(g gVar) {
        this.lyN = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (bh.ov(this.lyN.hBn) || !str.equals(this.lyN.hBn)) {
            x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
        } else if (i == -21006) {
            x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.lyN.hBn});
            g.f(this.lyN.lyH, 6, 0, this.lyN.hBn);
        } else if (i != 0) {
            x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[]{this.lyN.lyH});
            g.f(this.lyN.lyH, -1, 0, this.lyN.hBn);
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            } else {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.lyN.hBn, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)});
                if (!this.lyN.hnr) {
                    g.f(this.lyN.lyH, 6, (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f), this.lyN.hBn);
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            g.pQN.h(10625, new Object[]{Integer.valueOf(2), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.lyN.lyH, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[]{this.lyN.lyH, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                g.f(this.lyN.lyH, -1, 0, this.lyN.hBn);
            } else {
                x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                try {
                    c aAO = c.aAO();
                    String str2 = this.lyN.lyH;
                    if (aAO.lvx != null && aAO.lvx.contains(str2)) {
                        aAO.lvx.remove(str2);
                    }
                    EmojiLogic.a(this.lyN.lyH, this.lyN.lyI, this.lyN.lyM);
                    i.aBE().lwL.doNotify();
                    g.f(this.lyN.lyH, 7, 100, this.lyN.hBn);
                    File file = new File(e.gHs + this.lyN.lyH);
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                    g.ac(this.lyN.lyH, true);
                } catch (Exception e) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bh.cgy());
                    g.f(this.lyN.lyH, -1, 0, this.lyN.hBn);
                    g.ac(this.lyN.lyH, false);
                    return 0;
                } catch (OutOfMemoryError e2) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bh.cgy());
                    g.f(this.lyN.lyH, -1, 0, this.lyN.hBn);
                    g.ac(this.lyN.lyH, false);
                    return 0;
                }
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
