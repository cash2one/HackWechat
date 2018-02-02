package com.tencent.liteav.videoencoder;

import com.tencent.rtmp.TXLiveConstants;

class b$6 implements Runnable {
    final /* synthetic */ b a;

    b$6(b bVar) {
        this.a = bVar;
    }

    public void run() {
        b.a(this.a, TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW, "软编切硬编");
        if (b.d(this.a) != null) {
            b.d(this.a).setListener(null);
            b.d(this.a).stop();
        }
        b.a(this.a, new a());
        b.a(this.a, 1);
        this.a.setStatusValue(4004, Long.valueOf((long) b.g(this.a)));
        b.d(this.a).start(b.c(this.a));
        if (b.e(this.a) != null) {
            b.d(this.a).setListener(b.e(this.a));
        }
        if (b.f(this.a) != 0) {
            b.d(this.a).setBitrate(b.f(this.a));
        }
        b.d(this.a).setID(this.a.getID());
    }
}
