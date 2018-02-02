package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.b;

class ChattingSendDataToDeviceUI$b$1 implements Runnable {
    final /* synthetic */ b yvk;

    ChattingSendDataToDeviceUI$b$1(b bVar) {
        this.yvk = bVar;
    }

    public final void run() {
        this.yvk.yuZ.yuC.aD(this.yvk.yuZ.yuK);
        if (this.yvk.yuZ.yuC.getCount() > 0) {
            this.yvk.yuZ.yuH.setText(R.l.dQA);
            this.yvk.yuZ.yuN = false;
        }
        this.yvk.yuZ.yuC.notifyDataSetChanged();
    }
}
