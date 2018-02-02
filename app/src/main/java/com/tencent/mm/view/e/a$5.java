package com.tencent.mm.view.e;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.emotion.EmojiInfo;

class a$5 implements a {
    final /* synthetic */ a zGr;

    a$5(a aVar) {
        this.zGr = aVar;
    }

    public final void a(String str, l lVar) {
        if (str != null) {
            if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                this.zGr.cAQ();
            } else if (g.Dh().Cy()) {
                EmojiInfo yc = ((c) g.k(c.class)).getEmojiMgr().yc(str);
                if (yc != null && yc.field_catalog == EmojiInfo.xAk) {
                    ((c) g.k(c.class)).getProvider().aBd();
                    this.zGr.cAQ();
                }
            }
        }
    }
}
