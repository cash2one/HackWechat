package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class EmojiStoreV2RewardDetailUI$1 extends af {
    final /* synthetic */ EmojiStoreV2RewardDetailUI lGq;

    EmojiStoreV2RewardDetailUI$1(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        this.lGq = emojiStoreV2RewardDetailUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (EmojiStoreV2RewardDetailUI.a(this.lGq) != null) {
                    EmojiStoreV2RewardDetailUI.a(this.lGq).setVisibility(8);
                    return;
                }
                return;
            case 1002:
                if (EmojiStoreV2RewardDetailUI.a(this.lGq) != null) {
                    EmojiStoreV2RewardDetailUI.a(this.lGq).setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
