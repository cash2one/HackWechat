package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$1 extends c<ki> {
    final /* synthetic */ f mBc;

    f$1(f fVar) {
        this.mBc = fVar;
        this.xen = ki.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ki) bVar).fBF.visible) {
            x.i("MicroMsg.FrameBeatCore", "[NotifyFragmentChangeEvent] fragment:%s onCreate!", new Object[]{((ki) bVar).fBF.name});
            f.a(this.mBc);
        }
        return true;
    }
}
