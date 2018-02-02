package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class EmojiAddCustomDialogUI$1 extends af {
    final /* synthetic */ EmojiAddCustomDialogUI lBu;

    EmojiAddCustomDialogUI$1(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.lBu = emojiAddCustomDialogUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                EmojiAddCustomDialogUI.a(this.lBu, this.lBu.getString(R.l.ebi));
                return;
            default:
                return;
        }
    }
}
