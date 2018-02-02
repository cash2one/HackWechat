package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class EmojiStoreDetailUI$1 extends c<cs> {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$1(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
        this.xen = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        if (!(EmojiStoreDetailUI.a(this.lDM) == null || csVar.fqU.fqV == null || !csVar.fqU.fqV.equals(EmojiStoreDetailUI.a(this.lDM)))) {
            this.lDM.g(csVar.fqU.fqV, csVar.fqU.status, csVar.fqU.progress, csVar.fqU.fqW);
        }
        return false;
    }
}
