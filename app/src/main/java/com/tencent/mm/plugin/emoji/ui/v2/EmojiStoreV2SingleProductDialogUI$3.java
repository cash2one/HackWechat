package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class EmojiStoreV2SingleProductDialogUI$3 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$3(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void onClick(View view) {
        this.lHi.setResult(0);
        this.lHi.finish();
        this.lHi.overridePendingTransition(R.a.bqk, R.a.bql);
    }
}
