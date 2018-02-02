package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$c;

class EmojiPaidUI$2 implements h$c {
    final /* synthetic */ EmojiPaidUI lCx;

    EmojiPaidUI$2(EmojiPaidUI emojiPaidUI) {
        this.lCx = emojiPaidUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent();
                intent.putExtra("key_action_type", 200002);
                d.b(this.lCx, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                x.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                this.lCx.aCw();
                return;
            default:
                return;
        }
    }
}
