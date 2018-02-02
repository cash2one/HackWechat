package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.g;

class EmojiStoreDetailUI$17 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$17(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lDM, EmojiStoreV2RewardUI.class);
        intent.putExtra("extra_id", EmojiStoreDetailUI.a(this.lDM));
        intent.putExtra("extra_name", EmojiStoreDetailUI.b(this.lDM).war);
        if (!(EmojiStoreDetailUI.b(this.lDM) == null || EmojiStoreDetailUI.b(this.lDM).waM == null)) {
            intent.putExtra("name", EmojiStoreDetailUI.b(this.lDM).waM.nfp);
        }
        intent.putExtra("scene", EmojiStoreDetailUI.c(this.lDM));
        intent.putExtra("pageType", 1);
        intent.putExtra("searchID", EmojiStoreDetailUI.d(this.lDM));
        this.lDM.startActivity(intent);
        g.pQN.h(12738, new Object[]{EmojiStoreDetailUI.a(this.lDM), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(this.lDM)), Integer.valueOf(0)});
    }
}
