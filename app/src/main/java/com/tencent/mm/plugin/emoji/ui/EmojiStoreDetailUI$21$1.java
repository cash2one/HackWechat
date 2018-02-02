package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.21;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.SmileySubGrid;

class EmojiStoreDetailUI$21$1 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ 21 lDN;
    final /* synthetic */ EmojiInfo lvA;

    EmojiStoreDetailUI$21$1(21 21, EmojiInfo emojiInfo, int i) {
        this.lDN = 21;
        this.lvA = emojiInfo;
        this.kI = i;
    }

    public final void run() {
        SmileySubGrid q = EmojiStoreDetailUI.q(this.lDN.lDM);
        EmojiInfo emojiInfo = this.lvA;
        if (q.zEf == this.kI && q.zEg) {
            q.r(emojiInfo);
            return;
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "not show:%d, needData: %B, so do not refresh", new Object[]{Integer.valueOf(r2), Boolean.valueOf(q.zEg)});
    }
}
