package com.tencent.mm.ui;

import android.os.Looper;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class h$15 extends c<qw> {
    final /* synthetic */ h xFs;

    h$15(h hVar) {
        this.xFs = hVar;
        this.xen = qw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", new Object[]{Integer.valueOf(((qw) bVar).fIH.fut)});
        if (((qw) bVar).fIH.fut == 9) {
            new af(Looper.getMainLooper()).post(new 1(this));
        }
        return true;
    }
}
