package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.ui.tools.CropImageView.3;
import java.util.TimerTask;

class CropImageView$3$1 extends TimerTask {
    final /* synthetic */ MotionEvent zhR;
    final /* synthetic */ 3 zhS;

    CropImageView$3$1(3 3, MotionEvent motionEvent) {
        this.zhS = 3;
        this.zhR = motionEvent;
    }

    public final void run() {
        if (CropImageView.z(this.zhS.zhQ)) {
            Message message = new Message();
            message.what = 4661;
            message.obj = this.zhR;
            CropImageView.l(this.zhS.zhQ).sendMessage(message);
            CropImageView.c(this.zhS.zhQ, false);
        }
    }
}
