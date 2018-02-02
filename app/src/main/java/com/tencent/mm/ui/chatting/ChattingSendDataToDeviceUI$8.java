package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$8 implements Runnable {
    final /* synthetic */ String tAA;
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;
    final /* synthetic */ al yvb;
    final /* synthetic */ c yvc;
    final /* synthetic */ int yvd;
    final /* synthetic */ int yve;

    ChattingSendDataToDeviceUI$8(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, int i, al alVar, String str, c cVar, int i2) {
        this.yuZ = chattingSendDataToDeviceUI;
        this.yvd = i;
        this.yvb = alVar;
        this.tAA = str;
        this.yvc = cVar;
        this.yve = i2;
    }

    public final void run() {
        int i = this.yvd + 1;
        while (true) {
            if (i >= 100) {
                try {
                    this.yuZ.runOnUiThread(new 1(this));
                    return;
                } catch (Exception e) {
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[]{e});
                }
            } else {
                this.yvb.yxX.setProgress(i);
                i++;
                Thread.sleep((long) this.yve);
            }
        }
    }
}
