package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.io.ByteArrayOutputStream;

class c$b$1 implements a {
    final /* synthetic */ au heR;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ ChattingUI.a yII;
    final /* synthetic */ b yIJ;

    c$b$1(ChattingUI.a aVar, Intent intent, au auVar, b bVar) {
        this.yII = aVar;
        this.val$intent = intent;
        this.heR = auVar;
        this.yIJ = bVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        String str2 = "MicroMsg.AppMessageUtil";
        String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
        objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
        objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
        objArr[5] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult != null);
        objArr[6] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                this.yII.startActivity(this.val$intent);
            } else if (this.heR.cjs() || (this.yIJ != null && c.b.c(this.heR, this.yIJ.field_fileFullPath))) {
                x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                h.a(this.yII.getContext(), this.yII.getContext().getString(R.l.ehl), this.yII.getContext().getString(R.l.dGO), new 1(this));
            } else {
                h.b(this.yII.getContext(), this.yII.getString(R.l.dXA), "", true);
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
