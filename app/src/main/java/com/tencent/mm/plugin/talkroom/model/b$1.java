package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.af;

class b$1 extends a {
    final /* synthetic */ b saZ;

    b$1(b bVar) {
        this.saZ = bVar;
    }

    public final void eq(int i) {
        if (i == 4) {
            new af(Looper.getMainLooper()).post(new 1(this));
        }
    }
}
