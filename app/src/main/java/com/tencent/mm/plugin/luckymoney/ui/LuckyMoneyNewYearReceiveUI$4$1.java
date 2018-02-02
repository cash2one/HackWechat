package com.tencent.mm.plugin.luckymoney.ui;

import android.text.TextUtils;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyNewYearReceiveUI$4$1 implements Runnable {
    final /* synthetic */ keep_SceneResult hsD;
    final /* synthetic */ boolean oiM;
    final /* synthetic */ 4 oiN;

    LuckyMoneyNewYearReceiveUI$4$1(4 4, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        this.oiN = 4;
        this.oiM = z;
        this.hsD = com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void run() {
        if (this.oiM) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "the download image data is success!");
            if (!TextUtils.isEmpty(this.hsD.field_fileId) && this.hsD.field_fileId.equals(LuckyMoneyNewYearReceiveUI.e(this.oiN.oiL))) {
                LuckyMoneyNewYearReceiveUI.f(this.oiN.oiL);
                return;
            }
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image fail!");
        h.bu(this.oiN.oiL, this.oiN.oiL.getString(i.uJQ));
    }
}
