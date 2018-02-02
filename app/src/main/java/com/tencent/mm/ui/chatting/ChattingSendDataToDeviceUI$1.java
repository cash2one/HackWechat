package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$1 implements OnItemClickListener {
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;

    ChattingSendDataToDeviceUI$1(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.yuZ = chattingSendDataToDeviceUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.yuZ.yuO = true;
        c Fy = ChattingSendDataToDeviceUI.a(this.yuZ).Fy(i);
        String str = Fy.frg;
        String str2 = Fy.deviceID;
        String str3 = Fy.fsF;
        try {
            if (ChattingSendDataToDeviceUI.b(this.yuZ).get(str2) != null) {
                x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                b cuVar = new cu();
                cuVar.frc.ffq = str2;
                a.xef.m(cuVar);
                ChattingSendDataToDeviceUI.a(this.yuZ, "send_data_cancel", str2, 0);
                Fy.fsK = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(this.yuZ).remove(str2);
                al alVar = (al) ((View) ChattingSendDataToDeviceUI.c(this.yuZ).get(Integer.valueOf(i))).getTag();
                alVar.yvg.setText(this.yuZ.getText(R.l.dSR));
                alVar.yvg.setTextColor(this.yuZ.getResources().getColor(R.e.btL));
                alVar.yxX.setVisibility(8);
                alVar.yxX.setProgress(0);
                return;
            }
            Fy.fsK = "send_data_sending";
            ChattingSendDataToDeviceUI.d(this.yuZ).put(Fy.deviceID, Fy);
            ChattingSendDataToDeviceUI.b(this.yuZ).put(str2, view);
            ChattingSendDataToDeviceUI.a(this.yuZ, "send_data_sending", str2, 1);
            ChattingSendDataToDeviceUI.a(this.yuZ, 3);
            b eaVar = new ea();
            eaVar.fsD.ffq = str2;
            eaVar.fsD.frg = str;
            eaVar.fsD.data = ChattingSendDataToDeviceUI.e(this.yuZ);
            eaVar.fsD.fsF = str3;
            if (this.yuZ.fsG) {
                eaVar.fsD.frH = ChattingSendDataToDeviceUI.f(this.yuZ);
                eaVar.fsD.fsG = this.yuZ.fsG;
            } else {
                eaVar.fsD.fqm = ChattingSendDataToDeviceUI.g(this.yuZ);
            }
            a.xef.m(eaVar);
            if (!eaVar.fsE.fsH) {
                ChattingSendDataToDeviceUI.Zb("send_data_failed");
                x.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
            }
        } catch (Exception e) {
            ChattingSendDataToDeviceUI.Zb("send_data_failed");
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[]{e});
        }
    }
}
