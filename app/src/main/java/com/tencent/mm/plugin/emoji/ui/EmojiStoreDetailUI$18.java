package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;

class EmojiStoreDetailUI$18 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$18(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lDM, EmojiStoreV2RewardDetailUI.class);
        intent.putExtra("extra_id", EmojiStoreDetailUI.a(this.lDM));
        intent.putExtra("extra_iconurl", EmojiStoreDetailUI.b(this.lDM).nfT);
        intent.putExtra("extra_name", EmojiStoreDetailUI.b(this.lDM).war);
        if (EmojiStoreDetailUI.b(this.lDM).waM != null) {
            intent.putExtra("name", EmojiStoreDetailUI.b(this.lDM).waM.nfp);
        }
        this.lDM.startActivity(intent);
    }
}
