package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class EmojiStoreV2SingleProductDialogUI$7 implements OnDismissListener {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$7(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.lHi.setResult(0);
        this.lHi.finish();
    }
}
