package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import java.lang.ref.WeakReference;

public class MMViewPager$k extends af {
    long mVE;
    WeakReference<MMViewPager> yeO;

    public MMViewPager$k(WeakReference<MMViewPager> weakReference) {
        this.yeO = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.yeO != null) {
            MMViewPager mMViewPager = (MMViewPager) this.yeO.get();
            if (mMViewPager != null && message.what == 1) {
                if (MMViewPager.r(mMViewPager) == null || MMViewPager.r(mMViewPager).aOC()) {
                    MMViewPager.s(mMViewPager);
                    return;
                }
                MMViewPager.r(mMViewPager).play();
                sendEmptyMessageDelayed(message.what, this.mVE);
            }
        }
    }
}
