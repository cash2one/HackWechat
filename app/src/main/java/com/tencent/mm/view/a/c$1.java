package com.tencent.mm.view.a;

import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.emotion.EmojiInfo;

class c$1 implements e {
    final /* synthetic */ c zEr;

    c$1(c cVar) {
        this.zEr = cVar;
    }

    public final void e(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj != null && (obj instanceof EmojiInfo)) {
                b cnVar = new cn();
                cnVar.fqL.scene = 1;
                cnVar.fqL.fqM = (EmojiInfo) obj;
                cnVar.fqL.context = this.zEr.mContext;
                a.xef.m(cnVar);
            }
        }
    }
}
