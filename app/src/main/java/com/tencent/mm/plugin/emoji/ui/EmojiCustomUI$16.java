package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.plugin.gif.g;

class EmojiCustomUI$16 implements l {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$16(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final Bitmap I(byte[] bArr) {
        return g.ay(bArr);
    }

    public final Bitmap lD(String str) {
        return g.ay(e.d(str, 0, e.bN(str)));
    }
}
