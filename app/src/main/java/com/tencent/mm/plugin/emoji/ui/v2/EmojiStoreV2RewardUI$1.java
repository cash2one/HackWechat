package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardUI$1 extends af {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;

    EmojiStoreV2RewardUI$1(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                if (bh.ov(str) || !e.bO(str)) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                    return;
                }
                EmojiStoreV2RewardUI.a(this.lGQ).cR(str, null);
                EmojiStoreV2RewardUI.a(this.lGQ).setScaleType(ScaleType.FIT_XY);
                if (EmojiStoreV2RewardUI.b(this.lGQ) != null && EmojiStoreV2RewardUI.b(this.lGQ).isRunning()) {
                    EmojiStoreV2RewardUI.b(this.lGQ).stop();
                    return;
                }
                return;
            case 1002:
                EmojiStoreV2RewardUI.c(this.lGQ);
                return;
            default:
                return;
        }
    }
}
