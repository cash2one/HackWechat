package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.b.a.u;
import com.tencent.mm.plugin.fts.b.a.v;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;

class a$4 implements a {
    final /* synthetic */ a mMS;

    a$4(a aVar) {
        this.mMS = aVar;
    }

    public final void a(String str, l lVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0 && split[0].equals("update")) {
            for (int i = 1; i < split.length; i++) {
                a.e(this.mMS).a(65554, new v(this.mMS, bh.getLong(split[i], 0)));
            }
            a.e(this.mMS).a(65556, new u(this.mMS, (byte) 0));
        }
    }
}
