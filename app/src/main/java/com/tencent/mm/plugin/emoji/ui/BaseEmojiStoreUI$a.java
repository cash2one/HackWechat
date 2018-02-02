package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class BaseEmojiStoreUI$a extends c<cs> {
    final /* synthetic */ BaseEmojiStoreUI lAV;

    private BaseEmojiStoreUI$a(BaseEmojiStoreUI baseEmojiStoreUI) {
        this.lAV = baseEmojiStoreUI;
        this.xen = cs.class.getName().hashCode();
    }

    /* synthetic */ BaseEmojiStoreUI$a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
        this(baseEmojiStoreUI);
        this.xen = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        this.lAV.g(csVar.fqU.fqV, csVar.fqU.status, csVar.fqU.progress, csVar.fqU.fqW);
        return false;
    }
}
