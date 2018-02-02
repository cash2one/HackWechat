package com.tencent.mm.plugin.emoji.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class EmojiBaseActivity$b extends af {
    final /* synthetic */ EmojiBaseActivity lBx;

    EmojiBaseActivity$b(EmojiBaseActivity emojiBaseActivity, Looper looper) {
        this.lBx = emojiBaseActivity;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        this.lBx.l(message);
    }
}
