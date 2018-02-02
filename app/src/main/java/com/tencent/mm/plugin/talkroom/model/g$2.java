package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class g$2 extends a {
    final /* synthetic */ g scg;

    g$2(g gVar) {
        this.scg = gVar;
    }

    public final void keep_OnOpenSuccess() {
        x.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
        if (g.b(this.scg) != 1) {
            x.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", Integer.valueOf(g.b(this.scg)));
            return;
        }
        b.bEF().bEK();
        new af(Looper.getMainLooper()).post(new 1(this));
        g.d(this.scg);
        g.a(this.scg).aWb();
    }

    public final void keep_OnError(int i) {
        x.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", Integer.valueOf(i));
        b.bEF().bEK();
        b.bEF().sbl = 1;
        g.a(this.scg).J("component OnError " + i, 99, i);
        new af(Looper.getMainLooper()).post(new 2(this));
    }
}
