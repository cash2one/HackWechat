package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.sdk.platformtools.bh;

class EmojiStoreV2RewardUI$7 implements i {
    final /* synthetic */ String gBF;
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;
    final /* synthetic */ String lGR;

    EmojiStoreV2RewardUI$7(EmojiStoreV2RewardUI emojiStoreV2RewardUI, String str, String str2) {
        this.lGQ = emojiStoreV2RewardUI;
        this.lGR = str;
        this.gBF = str2;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (!bh.ov(str) && str.equalsIgnoreCase(this.lGR)) {
            Message message = new Message();
            message.what = 1001;
            message.obj = this.gBF;
            EmojiStoreV2RewardUI.j(this.lGQ).sendMessage(message);
        }
    }
}
