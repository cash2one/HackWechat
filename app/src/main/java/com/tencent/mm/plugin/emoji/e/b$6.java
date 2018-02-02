package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.at;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.EmojiInfo;

class b$6 extends c<at> {
    final /* synthetic */ b lvv;

    b$6(b bVar) {
        this.lvv = bVar;
        this.xen = at.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        at atVar = (at) bVar;
        int i = atVar.foS.type;
        EmojiInfo emojiInfo;
        if (i == 0) {
            emojiInfo = atVar.foS.foU;
            if (emojiInfo != null && emojiInfo.cks()) {
                atVar.foT.fnI = e.aAR().b(emojiInfo);
                if (!atVar.foT.fnI) {
                    g.pQN.a(252, 8, 1, false);
                }
            }
        } else if (i == 1) {
            String str = atVar.foS.foV;
            if (!bh.ov(str)) {
                emojiInfo = i.aBE().lwL.XV(str);
                if (emojiInfo != null && emojiInfo.cks()) {
                    atVar.foT.fnI = e.aAR().b(emojiInfo);
                    if (!atVar.foT.fnI) {
                        g.pQN.a(252, 9, 1, false);
                    }
                }
            }
        }
        return false;
    }
}
