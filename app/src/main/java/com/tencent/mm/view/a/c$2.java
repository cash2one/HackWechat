package com.tencent.mm.view.a;

import com.tencent.mm.aq.a.c.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$2 implements d {
    final /* synthetic */ c zEr;

    c$2(c cVar) {
        this.zEr = cVar;
    }

    public final byte[] f(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj != null && (obj instanceof EmojiInfo)) {
                return ((c) g.k(c.class)).getProvider().a((EmojiInfo) obj);
            }
        }
        return null;
    }
}
