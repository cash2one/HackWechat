package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8;

class ChattingSendDataToDeviceUI$8$1 implements Runnable {
    final /* synthetic */ 8 yvf;

    ChattingSendDataToDeviceUI$8$1(8 8) {
        this.yvf = 8;
    }

    public final void run() {
        this.yvf.yvb.yxX.setProgress(0);
        ChattingSendDataToDeviceUI.b(this.yvf.yuZ).remove(this.yvf.tAA);
        this.yvf.yvb.yxX.setVisibility(4);
        this.yvf.yvb.yvg.setText(this.yvf.yuZ.getText(R.l.dSX));
        this.yvf.yvb.yvg.setTextColor(this.yvf.yuZ.getResources().getColor(R.e.btM));
        this.yvf.yvc.fsK = "send_data_sucess";
        this.yvf.yvc.progress = 0;
        ChattingSendDataToDeviceUI.a(this.yvf.yuZ, 4);
    }
}
