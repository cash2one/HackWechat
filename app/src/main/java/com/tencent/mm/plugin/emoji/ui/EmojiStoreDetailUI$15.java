package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.pluginsdk.model.i$a;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class EmojiStoreDetailUI$15 implements i$a {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$15(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void u(ArrayList<q> arrayList) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
        EmojiStoreDetailUI.E(this.lDM);
        if (arrayList != null && arrayList.size() > 0) {
            q qVar = (q) arrayList.get(0);
            if (qVar.vdH == 10232) {
                EmojiStoreDetailUI.a(this.lDM, 4);
                EmojiStoreDetailUI.a(this.lDM, qVar.vdE);
            } else {
                EmojiStoreDetailUI.a(this.lDM, 10);
                EmojiStoreDetailUI.b(this.lDM, qVar.vdH);
            }
            this.lDM.oP(1002);
        }
    }
}
