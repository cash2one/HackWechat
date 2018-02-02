package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public static boolean aCY() {
        return i.aBE().lwM.cka();
    }

    public static boolean d(so soVar) {
        return soVar == null ? false : yO(soVar.vIR);
    }

    public static boolean b(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo == null ? false : yO(emojiGroupInfo.field_productID);
    }

    public static boolean yO(String str) {
        return str == null ? false : str.equals(aDB());
    }

    public static final String aDB() {
        return EmojiGroupInfo.xAb;
    }
}
