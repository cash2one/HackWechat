package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class FTSEmojiDetailPageUI$2 implements OnCancelListener {
    final /* synthetic */ FTSEmojiDetailPageUI lEU;

    FTSEmojiDetailPageUI$2(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.lEU = fTSEmojiDetailPageUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        FTSEmojiDetailPageUI.f(this.lEU);
    }
}
