package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.g;

class CropImageView$1 extends af {
    final /* synthetic */ CropImageView zhQ;

    CropImageView$1(CropImageView cropImageView) {
        this.zhQ = cropImageView;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.CropImageView", "on handler");
        if (message.what == 4659) {
            this.zhQ.cxJ();
        } else if (message.what == 4658) {
            this.zhQ.cxK();
        } else if (message.what == 4660) {
            if (!(CropImageView.a(this.zhQ) == null || CropImageView.b(this.zhQ) == null)) {
                CropImageView.b(this.zhQ).cancel();
                CropImageView.c(this.zhQ);
            }
        } else if (message.what == 4661) {
            boolean z;
            MotionEvent motionEvent = (MotionEvent) message.obj;
            CropImageView.a(this.zhQ, System.currentTimeMillis());
            CropImageView.a(this.zhQ, false);
            if (motionEvent.getRawX() - CropImageView.d(this.zhQ) > 10.0f || motionEvent.getRawY() - CropImageView.e(this.zhQ) > 10.0f || motionEvent.getRawX() - CropImageView.d(this.zhQ) < -10.0f || motionEvent.getRawY() - CropImageView.e(this.zhQ) < -10.0f) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (CropImageView.f(this.zhQ) != 0 && currentTimeMillis - CropImageView.f(this.zhQ) < 300 && currentTimeMillis - CropImageView.f(this.zhQ) >= 0 && CropImageView.g(this.zhQ) != null) {
                    CropImageView.g(this.zhQ).cxH();
                }
                CropImageView.a(this.zhQ, 0);
            }
            g.a(CropImageView.h(this.zhQ), CropImageView.i(this.zhQ));
        }
        super.handleMessage(message);
    }
}
