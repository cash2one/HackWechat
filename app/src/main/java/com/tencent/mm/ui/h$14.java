package com.tencent.mm.ui;

import com.tencent.mm.g.a.ip;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class h$14 extends a {
    final /* synthetic */ h xFs;

    h$14(h hVar) {
        this.xFs = hVar;
    }

    public final void j(b bVar) {
        x.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[]{bVar});
        if (bVar instanceof ip) {
            h.d(this.xFs);
        }
    }
}
