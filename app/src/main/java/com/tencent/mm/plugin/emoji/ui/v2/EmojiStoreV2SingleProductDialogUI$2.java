package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class EmojiStoreV2SingleProductDialogUI$2 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$2(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EmojiStoreV2SingleProductDialogUI.b(this.lHi, EmojiStoreV2SingleProductDialogUI.a(this.lHi));
        g gVar = g.pQN;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(EmojiStoreV2SingleProductDialogUI.b(this.lHi));
        objArr[1] = Integer.valueOf(1);
        objArr[2] = EmojiStoreV2SingleProductDialogUI.a(this.lHi) == null ? "" : EmojiStoreV2SingleProductDialogUI.a(this.lHi).vZL;
        objArr[3] = Long.valueOf(EmojiStoreV2SingleProductDialogUI.c(this.lHi));
        gVar.h(12787, objArr);
    }
}
