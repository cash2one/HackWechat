package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.widget.DragSortListView.g;

class EmojiSortUI$4 implements g {
    final /* synthetic */ EmojiSortUI lCD;

    EmojiSortUI$4(EmojiSortUI emojiSortUI) {
        this.lCD = emojiSortUI;
    }

    public final void cq(int i, int i2) {
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) EmojiSortUI.b(this.lCD).getItem(i);
        EmojiSortUI.b(this.lCD).remove(emojiGroupInfo);
        EmojiSortUI.b(this.lCD).insert(emojiGroupInfo, i2);
    }
}
