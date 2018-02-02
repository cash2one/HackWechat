package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardThanksUI$1 extends af {
    final /* synthetic */ EmojiStoreV2RewardThanksUI lGz;

    EmojiStoreV2RewardThanksUI$1(EmojiStoreV2RewardThanksUI emojiStoreV2RewardThanksUI) {
        this.lGz = emojiStoreV2RewardThanksUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                if (bh.ov(str) || !e.bO(str)) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                    return;
                }
                EmojiStoreV2RewardThanksUI.a(this.lGz).cR(str, null);
                EmojiStoreV2RewardThanksUI.a(this.lGz).setScaleType(ScaleType.FIT_XY);
                if (EmojiStoreV2RewardThanksUI.b(this.lGz) != null && EmojiStoreV2RewardThanksUI.b(this.lGz).isRunning()) {
                    EmojiStoreV2RewardThanksUI.b(this.lGz).stop();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
