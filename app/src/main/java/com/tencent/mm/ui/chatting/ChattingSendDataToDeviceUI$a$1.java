package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$a$1 implements Runnable {
    final /* synthetic */ al yvb;
    final /* synthetic */ c yvc;
    final /* synthetic */ int yvd;
    final /* synthetic */ int yve;
    final /* synthetic */ a yvi;

    ChattingSendDataToDeviceUI$a$1(a aVar, int i, c cVar, al alVar, int i2) {
        this.yvi = aVar;
        this.yvd = i;
        this.yvc = cVar;
        this.yvb = alVar;
        this.yve = i2;
    }

    public final void run() {
        int i = this.yvd + 1;
        while (this.yvi.yuZ.yuP) {
            if (i >= 100) {
                try {
                    if (this.yvc.fsK.equals("send_data_sucess")) {
                        this.yvi.yuZ.runOnUiThread(new 1(this));
                        return;
                    } else if (this.yvc.fsK.equals("send_data_failed")) {
                        this.yvi.yuZ.runOnUiThread(new 2(this));
                        return;
                    }
                } catch (Exception e) {
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[]{e});
                }
            } else {
                this.yvb.yxX.setProgress(i);
                this.yvc.progress = i;
                i++;
                Thread.sleep((long) this.yve);
            }
        }
    }
}
