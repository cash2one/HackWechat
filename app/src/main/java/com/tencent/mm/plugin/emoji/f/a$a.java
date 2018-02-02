package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class a$a implements a {
    public a$a() {
        a.access$002(0);
    }

    public final boolean uF() {
        if (a.bl() >= 100) {
            a.access$002(0);
            x.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
            com.tencent.mm.storage.emotion.a aVar = i.aBE().lwM;
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.aDB();
            emojiGroupInfo.field_packName = "emoji_custom_all";
            emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
            emojiGroupInfo.field_sort = 1;
            emojiGroupInfo.field_idx = 0;
            emojiGroupInfo.field_packType = 4;
            emojiGroupInfo.field_packFlag = 1;
            emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
            aVar.c(emojiGroupInfo);
            i.aBG().f(com.tencent.mm.plugin.emoji.h.a.aDB(), 7, a.bl(), "");
            a.aBM();
            return false;
        }
        i.aBG().f(com.tencent.mm.plugin.emoji.h.a.aDB(), 6, a.bl(), "");
        a.access$002(a.bl() + 2);
        return true;
    }
}
