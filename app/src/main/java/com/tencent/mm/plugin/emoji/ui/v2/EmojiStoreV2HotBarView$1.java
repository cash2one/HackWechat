package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class EmojiStoreV2HotBarView$1 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2HotBarView lGc;

    EmojiStoreV2HotBarView$1(EmojiStoreV2HotBarView emojiStoreV2HotBarView) {
        this.lGc = emojiStoreV2HotBarView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lGc.getContext(), EmojiStoreV2RankUI.class);
        this.lGc.getContext().startActivity(intent);
    }
}
