package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.j.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.1;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class LuckyMoneyNewYearSendUI$1$1 implements a {
    final /* synthetic */ 1 ojd;

    LuckyMoneyNewYearSendUI$1$1(1 1) {
        this.ojd = 1;
    }

    public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
        if (z) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image success, to send HB");
            LuckyMoneyNewYearSendUI.a(this.ojd.ojc, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
            LuckyMoneyNewYearSendUI.b(this.ojd.ojc, com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
            LuckyMoneyNewYearSendUI.a(this.ojd.ojc, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
            LuckyMoneyNewYearSendUI.j(this.ojd.ojc).post(new 1(this));
            return;
        }
        LuckyMoneyNewYearSendUI.j(this.ojd.ojc).post(new Runnable(this) {
            final /* synthetic */ LuckyMoneyNewYearSendUI$1$1 oje;

            {
                this.oje = r1;
            }

            public final void run() {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "upload image fail!");
                if (LuckyMoneyNewYearSendUI.k(this.oje.ojd.ojc) != null && LuckyMoneyNewYearSendUI.k(this.oje.ojd.ojc).isShowing()) {
                    LuckyMoneyNewYearSendUI.k(this.oje.ojd.ojc).hide();
                }
                h.bu(this.oje.ojd.ojc, this.oje.ojd.ojc.getString(a$i.uLa));
            }
        });
    }
}
