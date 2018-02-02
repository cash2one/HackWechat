package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.g.a.iz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class VideoActivity$1 extends c<iz> {
    final /* synthetic */ VideoActivity spY;

    VideoActivity$1(VideoActivity videoActivity) {
        this.spY = videoActivity;
        this.xen = iz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((iz) bVar) instanceof iz) {
            x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", new Object[]{Thread.currentThread().getName()});
            ag.y(new 1(this));
        }
        return false;
    }
}
