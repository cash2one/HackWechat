package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.ui.widget.DragSortListView.l;

class EmojiSortUI$5 implements l {
    final /* synthetic */ EmojiSortUI lCD;

    EmojiSortUI$5(EmojiSortUI emojiSortUI) {
        this.lCD = emojiSortUI;
    }

    public final void remove(int i) {
        EmojiSortUI.b(this.lCD).remove(EmojiSortUI.b(this.lCD).getItem(i));
    }
}
