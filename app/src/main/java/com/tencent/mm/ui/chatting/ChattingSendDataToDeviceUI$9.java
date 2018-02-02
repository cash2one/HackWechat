package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$9 implements Runnable {
    final /* synthetic */ int irm;
    final /* synthetic */ String tAA;
    final /* synthetic */ String tBd;
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;
    TextView yvg;

    ChattingSendDataToDeviceUI$9(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, String str, String str2, int i) {
        this.yuZ = chattingSendDataToDeviceUI;
        this.tAA = str;
        this.tBd = str2;
        this.irm = i;
    }

    public final void run() {
        try {
            c cVar = (c) ChattingSendDataToDeviceUI.d(this.yuZ).get(this.tAA);
            cVar.fsK = this.tBd;
            if (this.irm > cVar.progress) {
                cVar.progress = this.irm;
            }
            View view = (View) ChattingSendDataToDeviceUI.c(this.yuZ).get(Integer.valueOf(((Integer) ChattingSendDataToDeviceUI.k(this.yuZ).get(this.tAA)).intValue()));
            al alVar = (al) view.getTag();
            if (alVar == null) {
                x.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                return;
            }
            this.yvg = alVar.yvg;
            this.yvg.setVisibility(0);
            if (this.tBd.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(this.yuZ, 5);
                this.yvg.setText(this.yuZ.getString(R.l.dSV));
                ChattingSendDataToDeviceUI.b(this.yuZ).remove(this.tAA);
                this.yvg.setTextColor(this.yuZ.getResources().getColor(R.e.btN));
                ChattingSendDataToDeviceUI.a(false, 0, view);
            } else if (this.tBd.equals("send_data_sending")) {
                this.yvg.setText(this.yuZ.getString(R.l.dSZ));
                this.yvg.setTextColor(this.yuZ.getResources().getColor(R.e.btM));
                ChattingSendDataToDeviceUI.a(true, this.irm, view);
            } else if (this.tBd.equals("send_data_cancel")) {
                ChattingSendDataToDeviceUI.a(this.yuZ, 6);
                this.yvg.setText(this.yuZ.getString(R.l.dSR));
                this.yvg.setTextColor(this.yuZ.getResources().getColor(R.e.btL));
                ChattingSendDataToDeviceUI.a(true, 0, view);
            }
            ChattingSendDataToDeviceUI.d(this.yuZ).put(cVar.deviceID, cVar);
        } catch (Exception e) {
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", new Object[]{e.getMessage()});
        }
    }
}
