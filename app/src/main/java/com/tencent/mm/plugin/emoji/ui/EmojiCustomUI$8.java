package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.g;

class EmojiCustomUI$8 implements OnClickListener {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$8(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BKGLoaderManager bKGLoaderManager = i.aBB().lzq;
        bKGLoaderManager.lzD = true;
        bKGLoaderManager.aBZ();
        g.pQN.h(11595, new Object[]{Integer.valueOf(1)});
    }
}
