package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class ChattingSendDataToDeviceUI$5 implements OnClickListener {
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;

    ChattingSendDataToDeviceUI$5(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.yuZ = chattingSendDataToDeviceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        for (String str : ChattingSendDataToDeviceUI.b(this.yuZ).keySet()) {
            b cuVar = new cu();
            cuVar.frc.ffq = str;
            a.xef.m(cuVar);
        }
        this.yuZ.finish();
    }
}
