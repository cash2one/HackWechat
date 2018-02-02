package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class OnlineVideoView$7 implements b {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$7(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final long aZz() {
        x.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[]{Integer.valueOf(this.rvm.hashCode())});
        g.Dk();
        g.Dj().CU().a(a.xtK, Boolean.valueOf(true));
        try {
            if (OnlineVideoView.x(this.rvm) && OnlineVideoView.k(this.rvm) != null) {
                return (long) OnlineVideoView.k(this.rvm).hTE;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
