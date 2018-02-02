package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;

class EmojiStoreV2DesignerUI$15 implements i {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$15(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (EmojiStoreV2DesignerUI.j(this.lFV) != null) {
            EmojiStoreV2DesignerUI.j(this.lFV).sendEmptyMessage(10001);
        }
    }
}
