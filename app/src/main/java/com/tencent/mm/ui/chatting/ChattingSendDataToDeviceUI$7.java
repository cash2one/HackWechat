package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$7 implements Runnable {
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;
    final /* synthetic */ al yvb;
    final /* synthetic */ c yvc;

    ChattingSendDataToDeviceUI$7(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, al alVar, c cVar) {
        this.yuZ = chattingSendDataToDeviceUI;
        this.yvb = alVar;
        this.yvc = cVar;
    }

    public final void run() {
        this.yvb.yxX.setVisibility(0);
        this.yvb.yvg.setTextColor(this.yuZ.getResources().getColor(R.e.btM));
        this.yvb.yvg.setText(this.yuZ.getText(R.l.dSZ));
        this.yvc.fsK = "send_data_sending";
    }
}
