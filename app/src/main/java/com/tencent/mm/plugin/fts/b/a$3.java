package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.b.a.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class a$3 implements a {
    final /* synthetic */ a mMS;

    a$3(a aVar) {
        this.mMS = aVar;
    }

    public final void a(String str, l lVar) {
        if (!str.equals("*") && !str.equals("chatroomname") && !a.b(this.mMS).containsKey(str)) {
            a.e(this.mMS).a(65556, new h(this.mMS, str));
        }
    }
}
