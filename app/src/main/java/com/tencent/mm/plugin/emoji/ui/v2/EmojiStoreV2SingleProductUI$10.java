package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.ui.v2.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rw;

class EmojiStoreV2SingleProductUI$10 implements a {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$10(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final void mv(int i) {
        if (EmojiStoreV2SingleProductUI.h(this.lHL) != null && EmojiStoreV2SingleProductUI.c(this.lHL) != null) {
            rw oZ = EmojiStoreV2SingleProductUI.c(this.lHL).oZ(i);
            if (oZ != null) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(this.lHL));
                    intent.putExtra("extra_object", oZ.toByteArray());
                    intent.putExtra("scene", EmojiStoreV2SingleProductUI.j(this.lHL));
                    intent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(this.lHL));
                    intent.setClass(this.lHL.mController.xIM, EmojiStoreV2SingleProductDialogUI.class);
                    this.lHL.startActivityForResult(intent, 5001);
                    this.lHL.overridePendingTransition(R.a.bqk, R.a.bql);
                    g.pQN.h(12787, new Object[]{Integer.valueOf(EmojiStoreV2SingleProductUI.j(this.lHL)), Integer.valueOf(0), oZ.vZL, Long.valueOf(EmojiStoreV2SingleProductUI.k(this.lHL))});
                } catch (Exception e) {
                }
            }
        }
    }
}
