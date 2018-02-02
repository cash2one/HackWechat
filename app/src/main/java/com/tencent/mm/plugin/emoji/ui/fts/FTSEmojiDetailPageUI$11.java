package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class FTSEmojiDetailPageUI$11 implements c {
    final /* synthetic */ FTSEmojiDetailPageUI lEU;
    final /* synthetic */ List lEY;
    final /* synthetic */ List lEZ;

    FTSEmojiDetailPageUI$11(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, List list, List list2) {
        this.lEU = fTSEmojiDetailPageUI;
        this.lEY = list;
        this.lEZ = list2;
    }

    public final void a(n nVar) {
        nVar.setHeaderTitle((CharSequence) "");
        for (int i = 0; i < this.lEY.size(); i++) {
            nVar.f(((Integer) this.lEY.get(i)).intValue(), (CharSequence) this.lEZ.get(i));
        }
    }
}
