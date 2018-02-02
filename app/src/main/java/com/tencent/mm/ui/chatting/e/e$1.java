package com.tencent.mm.ui.chatting.e;

import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.mm.ui.chatting.a.a.c;

class e$1 extends b {
    final /* synthetic */ e yHA;

    e$1(e eVar) {
        this.yHA = eVar;
    }

    public final int ba(int i) {
        if (((c) e.a(this.yHA).get(i)).type == Integer.MAX_VALUE) {
            return 4;
        }
        return 1;
    }
}
