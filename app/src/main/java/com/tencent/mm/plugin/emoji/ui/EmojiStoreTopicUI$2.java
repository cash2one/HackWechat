package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.hardcoder.HardCoderJNI;

class EmojiStoreTopicUI$2 implements i {
    final /* synthetic */ EmojiStoreTopicUI lDW;

    EmojiStoreTopicUI$2(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.lDW = emojiStoreTopicUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        EmojiBaseActivity emojiBaseActivity = this.lDW;
        if (emojiBaseActivity.lBw != null) {
            emojiBaseActivity.lBw.sendEmptyMessage(HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION);
        }
    }
}
