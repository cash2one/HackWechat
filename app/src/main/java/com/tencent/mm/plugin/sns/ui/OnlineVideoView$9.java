package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$9 implements Runnable {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$9(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final void run() {
        x.w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", new Object[]{Integer.valueOf(this.rvm.hashCode()), Boolean.valueOf(OnlineVideoView.x(this.rvm))});
        if (OnlineVideoView.x(this.rvm)) {
            OnlineVideoView.y(this.rvm);
            OnlineVideoView.d(this.rvm).stop();
            this.rvm.bzL();
            boolean deleteFile = FileOp.deleteFile(ap.D(OnlineVideoView.e(this.rvm)));
            if (OnlineVideoView.k(this.rvm) != null) {
                OnlineVideoView.k(this.rvm).bzU();
                OnlineVideoView.k(this.rvm).clear();
                OnlineVideoView.a(this.rvm, new af(this.rvm));
            }
            x.i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", new Object[]{Integer.valueOf(this.rvm.hashCode()), Boolean.valueOf(deleteFile), r0});
            OnlineVideoView.z(this.rvm);
            OnlineVideoView.A(this.rvm);
        }
    }
}
