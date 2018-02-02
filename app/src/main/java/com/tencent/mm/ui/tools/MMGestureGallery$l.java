package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class MMGestureGallery$l extends af {
    private long mVE;
    private boolean mVF;
    WeakReference<MMGestureGallery> yeO;

    public MMGestureGallery$l(WeakReference<MMGestureGallery> weakReference) {
        this.yeO = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.yeO != null) {
            final MMGestureGallery mMGestureGallery = (MMGestureGallery) this.yeO.get();
            if (mMGestureGallery == null) {
                return;
            }
            if (message.what == 0) {
                if (MMGestureGallery.m(mMGestureGallery) == 1 || this.mVF) {
                    x.d("MicroMsg.MMGestureGallery", "single click over!");
                    if (MMGestureGallery.h(mMGestureGallery) != null) {
                        MMGestureGallery.c(mMGestureGallery).post(new Runnable(this) {
                            final /* synthetic */ MMGestureGallery$l zlr;

                            public final void run() {
                                MMGestureGallery.h(mMGestureGallery).avW();
                            }
                        });
                    }
                }
                MMGestureGallery.a(mMGestureGallery, 0);
            } else if (message.what != 1) {
                removeMessages(2);
                if (MMGestureGallery.T(mMGestureGallery) != null) {
                    MMGestureGallery.c(mMGestureGallery).post(new 2(this, mMGestureGallery));
                }
            } else if (MMGestureGallery.R(mMGestureGallery) == null || MMGestureGallery.R(mMGestureGallery).aOC()) {
                MMGestureGallery.S(mMGestureGallery);
            } else {
                MMGestureGallery.R(mMGestureGallery).play();
                sendEmptyMessageDelayed(message.what, this.mVE);
            }
        }
    }

    public final void i(int i, long j, long j2) {
        this.mVE = j2;
        sendEmptyMessageDelayed(i, j);
    }

    public final void t(long j, boolean z) {
        this.mVF = z;
        i(0, j, 0);
    }

    public final void release() {
        removeMessages(0);
        removeMessages(1);
        removeMessages(2);
    }
}
