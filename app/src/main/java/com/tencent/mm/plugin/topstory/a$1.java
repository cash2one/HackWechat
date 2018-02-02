package com.tencent.mm.plugin.topstory;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends a {
    final /* synthetic */ a seh;

    a$1(a aVar) {
        this.seh = aVar;
    }

    public final void eq(int i) {
        int a = a.a(this.seh);
        a.a(this.seh, a.b(this.seh));
        if (a.a(this.seh) != a) {
            x.i("MicroMsg.WebSearch.TopStoryConfigImpl", "network change current:%d change:%d", Integer.valueOf(a), Integer.valueOf(a.a(this.seh)));
            ag.y(new 1(this, a));
        }
    }
}
