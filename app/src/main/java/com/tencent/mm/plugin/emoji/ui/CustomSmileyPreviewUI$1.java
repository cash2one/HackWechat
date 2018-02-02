package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class CustomSmileyPreviewUI$1 extends af {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$1(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final void handleMessage(Message message) {
        int i;
        String string;
        switch (message.what) {
            case 2:
                CustomSmileyPreviewUI.a(this.lBm, CustomSmileyPreviewUI.c(this.lBm), CustomSmileyPreviewUI.b(this.lBm));
                return;
            case 131075:
                i = message.getData().getInt("progress");
                string = message.getData().getString("product_id");
                if (bh.ov(string)) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                    return;
                } else if (CustomSmileyPreviewUI.d(this.lBm) != null && CustomSmileyPreviewUI.d(this.lBm).luB != null) {
                    CustomSmileyPreviewUI.d(this.lBm).bd(string, i);
                    CustomSmileyPreviewUI.d(this.lBm).amg();
                    return;
                } else {
                    return;
                }
            case 131076:
                i = message.getData().getInt(DownloadInfo.STATUS);
                string = message.getData().getString("product_id");
                if (bh.ov(string)) {
                    x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                    return;
                } else if (CustomSmileyPreviewUI.d(this.lBm) != null && CustomSmileyPreviewUI.d(this.lBm).luB != null) {
                    CustomSmileyPreviewUI.d(this.lBm).bc(string, i);
                    return;
                } else {
                    return;
                }
            case 131077:
                if (CustomSmileyPreviewUI.a(this.lBm) != null) {
                    CustomSmileyPreviewUI.a(this.lBm).setText(((c) g.k(c.class)).getEmojiMgr().xZ(CustomSmileyPreviewUI.b(this.lBm).Nr()));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
