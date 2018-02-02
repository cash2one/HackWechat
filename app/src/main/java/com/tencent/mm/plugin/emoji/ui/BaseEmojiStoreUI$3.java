package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class BaseEmojiStoreUI$3 implements OnCancelListener {
    final /* synthetic */ BaseEmojiStoreUI lAV;

    BaseEmojiStoreUI$3(BaseEmojiStoreUI baseEmojiStoreUI) {
        this.lAV = baseEmojiStoreUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lAV.aCt();
        BaseEmojiStoreUI.aCB();
    }
}
