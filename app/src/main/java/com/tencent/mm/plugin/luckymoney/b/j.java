package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.ByteArrayOutputStream;

public final class j implements i$a {
    public String lON = null;
    private boolean ocA = true;
    public a ocy;
    public String ocz;

    public static String aXf() {
        return bh.ou(d.a("NewYearImg", System.currentTimeMillis(), q.Gy().field_username, ""));
    }

    public final boolean a(String str, String str2, int i, String str3, a aVar) {
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", new Object[]{str});
        this.ocA = false;
        this.lON = aXf();
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", new Object[]{this.lON});
        this.ocz = str3;
        this.ocy = aVar;
        i iVar = new i();
        iVar.fLH = false;
        iVar.htt = this;
        iVar.field_fullpath = str3;
        iVar.field_mediaId = this.lON;
        iVar.field_fileId = str;
        iVar.field_aesKey = str2;
        iVar.field_totalLen = i;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_priority = b.hrK;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 0;
        iVar.field_bzScene = 0;
        if (g.MJ().b(iVar, -1)) {
            return true;
        }
        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
        return false;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.lON.equals(str) && !bh.ov(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
            x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (i == 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                if (this.ocA) {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
                if (this.ocy != null) {
                    this.ocy.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.ocz, true);
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.ocy != null) {
                    this.ocy.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.ocz, false);
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.lON.equals(str) && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (this.ocy != null) {
                this.ocy.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.ocz, false);
            }
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
