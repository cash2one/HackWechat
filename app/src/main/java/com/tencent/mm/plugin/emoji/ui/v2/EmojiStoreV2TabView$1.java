package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;

class EmojiStoreV2TabView$1 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2TabView lIf;

    EmojiStoreV2TabView$1(EmojiStoreV2TabView emojiStoreV2TabView) {
        this.lIf = emojiStoreV2TabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (EmojiStoreV2TabView.a(this.lIf) != null) {
            EmojiStoreV2TabView.a(this.lIf).oW(intValue);
        }
    }
}
