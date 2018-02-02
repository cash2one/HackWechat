package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;

class EmojiAddCustomDialogUI$3 implements OnClickListener {
    final /* synthetic */ EmojiAddCustomDialogUI lBu;

    EmojiAddCustomDialogUI$3(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        this.lBu = emojiAddCustomDialogUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        g.pQN.h(11596, new Object[]{Integer.valueOf(3)});
        intent.setClass(EmojiAddCustomDialogUI.f(this.lBu), EmojiCustomUI.class);
        this.lBu.startActivity(intent);
    }
}
