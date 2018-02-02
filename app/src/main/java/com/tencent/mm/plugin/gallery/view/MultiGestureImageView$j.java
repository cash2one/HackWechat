package com.tencent.mm.plugin.gallery.view;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class MultiGestureImageView$j extends af {
    WeakReference<MultiGestureImageView> hkd;
    private long mVE;
    boolean mVF;
    final /* synthetic */ MultiGestureImageView mVw;

    public MultiGestureImageView$j(MultiGestureImageView multiGestureImageView, WeakReference<MultiGestureImageView> weakReference) {
        this.mVw = multiGestureImageView;
        this.hkd = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.hkd != null) {
            MultiGestureImageView multiGestureImageView = (MultiGestureImageView) this.hkd.get();
            if (multiGestureImageView == null) {
                return;
            }
            if (message.what == 0) {
                if (MultiGestureImageView.a(multiGestureImageView) == 1 || this.mVF) {
                    x.d("MicroMsg.MuitlGestureImageView", "single click over!");
                    if (MultiGestureImageView.b(multiGestureImageView) != null) {
                        multiGestureImageView.getHandler().post(new 1(this, multiGestureImageView));
                    }
                }
                MultiGestureImageView.c(this.mVw);
            } else if (message.what != 1) {
                removeMessages(2);
                if (MultiGestureImageView.f(multiGestureImageView) != null) {
                    multiGestureImageView.getHandler().post(new 2(this, multiGestureImageView));
                }
            } else if (MultiGestureImageView.d(this.mVw) == null || MultiGestureImageView.d(this.mVw).aOC()) {
                MultiGestureImageView.e(multiGestureImageView);
            } else {
                MultiGestureImageView.d(this.mVw).play();
                sendEmptyMessageDelayed(message.what, this.mVE);
            }
        }
    }

    public final void i(int i, long j, long j2) {
        this.mVE = j2;
        sendEmptyMessageDelayed(i, j);
    }
}
