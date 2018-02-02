package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$2 implements Runnable {
    final /* synthetic */ EmojiInfo lvA;
    final /* synthetic */ c lvB;
    final /* synthetic */ Context val$context;

    c$2(c cVar, EmojiInfo emojiInfo, Context context) {
        this.lvB = cVar;
        this.lvA = emojiInfo;
        this.val$context = context;
    }

    public final void run() {
        if (this.lvA != null && !this.lvA.ckA()) {
            if (bh.ov(this.lvA.field_groupId)) {
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emoji broken. try to recover:%s", new Object[]{this.lvA.Nr()});
                c.a(this.lvA, false);
                return;
            }
            c.a(this.lvB, this.val$context, this.lvA);
        }
    }
}
