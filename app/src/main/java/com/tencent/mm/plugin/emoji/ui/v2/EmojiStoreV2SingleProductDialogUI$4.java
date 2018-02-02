package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.protocal.c.rw;

class EmojiStoreV2SingleProductDialogUI$4 implements i {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$4(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreV2SingleProductDialogUI.d(this.lHi) != null && objArr[0] != null && (objArr[0] instanceof rw)) {
            rw rwVar = (rw) objArr[0];
            if (EmojiStoreV2SingleProductDialogUI.a(this.lHi) != null && rwVar != null && rwVar.vZL.equals(EmojiStoreV2SingleProductDialogUI.a(this.lHi).vZL)) {
                EmojiStoreV2SingleProductDialogUI.e(this.lHi);
            }
        }
    }
}
