package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class EmojiCustomUI$17 extends af {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$17(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                EmojiCustomUI.g(this.lBU);
                return;
            case 1002:
                i.aBB();
                if (!BKGLoaderManager.aAP()) {
                    return;
                }
                if (i.aBB().aBY() == a.lzs) {
                    EmojiCustomUI.a(this.lBU, true);
                    return;
                } else {
                    EmojiCustomUI.a(this.lBU, false);
                    return;
                }
            case 1003:
                EmojiCustomUI.h(this.lBU).setVisibility(8);
                EmojiCustomUI.e(this.lBU).notifyDataSetChanged();
                return;
            case 1004:
                if (EmojiCustomUI.e(this.lBU) != null) {
                    EmojiCustomUI.e(this.lBU).aCR();
                    EmojiCustomUI.e(this.lBU).notifyDataSetChanged();
                }
                EmojiCustomUI.aCO();
                return;
            default:
                x.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                return;
        }
    }
}
