package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$1 extends c<cs> {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$1(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
        this.xen = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.lFV;
        String str = csVar.fqU.fqV;
        int i = csVar.fqU.status;
        int i2 = csVar.fqU.progress;
        x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), csVar.fqU.fqW});
        if (i == 6) {
            emojiStoreV2DesignerUI.bd(str, i2);
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", new Object[]{Integer.valueOf(i)});
            emojiStoreV2DesignerUI.bc(str, i);
        }
        if (!(emojiStoreV2DesignerUI.lAW == null || emojiStoreV2DesignerUI.lAW.luB == null)) {
            f xU = emojiStoreV2DesignerUI.lAW.luB.xU(str);
            if (xU != null) {
                xU.luQ = r4;
            }
        }
        return false;
    }
}
