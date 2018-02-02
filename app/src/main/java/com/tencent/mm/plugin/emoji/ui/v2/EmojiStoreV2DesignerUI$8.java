package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class EmojiStoreV2DesignerUI$8 implements a {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.lFV;
            ar.Hg();
            EmojiStoreV2DesignerUI.a(emojiStoreV2DesignerUI, c.EY().WO(str));
            EmojiStoreV2DesignerUI.a(this.lFV);
        }
    }
}
