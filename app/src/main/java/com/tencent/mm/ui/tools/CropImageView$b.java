package com.tencent.mm.ui.tools;

import android.os.Message;
import java.util.TimerTask;

class CropImageView$b extends TimerTask {
    final /* synthetic */ CropImageView zhQ;

    public final void run() {
        Message message = new Message();
        if (CropImageView.p(this.zhQ) || CropImageView.q(this.zhQ) || CropImageView.r(this.zhQ) || CropImageView.s(this.zhQ)) {
            message.what = 4654;
        } else {
            message.what = 4653;
        }
        CropImageView.t(this.zhQ).sendMessage(message);
    }
}
