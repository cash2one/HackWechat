package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class EmojiAddCustomDialogUI$5 implements OnDismissListener {
    final /* synthetic */ EmojiAddCustomDialogUI lBu;

    EmojiAddCustomDialogUI$5(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.lBu = emojiAddCustomDialogUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.lBu.finish();
    }
}
