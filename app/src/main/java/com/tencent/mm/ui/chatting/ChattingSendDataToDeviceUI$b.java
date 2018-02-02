package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.7;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChattingSendDataToDeviceUI$b {
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;

    public ChattingSendDataToDeviceUI$b(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.yuZ = chattingSendDataToDeviceUI;
    }

    public final boolean n(b bVar) {
        if (bVar instanceof dx) {
            List list = ((dx) bVar).fsx.frK;
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                c cVar = new c(this.yuZ);
                cVar.frg = (String) ((Map) list.get(i)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i)).get("deviceID");
                cVar.gBL = (String) ((Map) list.get(i)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i)).get("iconUrl");
                cVar.fsF = (String) ((Map) list.get(i)).get("ability");
                cVar.yvl = (String) ((Map) list.get(i)).get("abilityInf");
                if ((this.yuZ.fsG && ChattingSendDataToDeviceUI.a(this.yuZ, cVar, ChattingSendDataToDeviceUI.f(this.yuZ))) || (!this.yuZ.fsG && ChattingSendDataToDeviceUI.a(this.yuZ, cVar, ChattingSendDataToDeviceUI.g(this.yuZ)))) {
                    if (ChattingSendDataToDeviceUI.d(this.yuZ).containsKey(cVar.deviceID) && ((c) ChattingSendDataToDeviceUI.d(this.yuZ).get(cVar.deviceID)).fsK != null) {
                        cVar.fsK = ((c) ChattingSendDataToDeviceUI.d(this.yuZ).get(cVar.deviceID)).fsK;
                        cVar.progress = ((c) ChattingSendDataToDeviceUI.d(this.yuZ).get(cVar.deviceID)).progress;
                    }
                    arrayList.add(cVar);
                }
            }
            if (ChattingSendDataToDeviceUI.l(this.yuZ).size() != arrayList.size()) {
                ChattingSendDataToDeviceUI.a(this.yuZ, arrayList);
                this.yuZ.runOnUiThread(new 1(this));
            }
        } else if (bVar instanceof eb) {
            eb ebVar = (eb) bVar;
            String str = ebVar.fsI.fsK;
            String str2 = ebVar.fsI.ffq;
            if (str.equals("send_data_sending")) {
                ChattingSendDataToDeviceUI.a(this.yuZ, "send_data_sending", str2, ebVar.fsI.progress);
            } else if (str.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(this.yuZ, "send_data_failed", str2, 0);
            } else if (str.equals("send_data_sucess")) {
                ChattingSendDataToDeviceUI chattingSendDataToDeviceUI = this.yuZ;
                try {
                    al alVar = (al) ((View) chattingSendDataToDeviceUI.yuU.get(Integer.valueOf(((Integer) chattingSendDataToDeviceUI.yuV.get(str2)).intValue()))).getTag();
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[]{Integer.valueOf(alVar.yxX.getProgress()), str2});
                    c cVar2 = (c) chattingSendDataToDeviceUI.yuT.get(str2);
                    chattingSendDataToDeviceUI.runOnUiThread(new 7(chattingSendDataToDeviceUI, alVar, cVar2));
                    int abs = Math.abs(alVar.yxX.getProgress());
                    cVar2.progress = abs;
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[]{Integer.valueOf(abs >= 100 ? 0 : 500 / (100 - abs))});
                    e.b(new 8(chattingSendDataToDeviceUI, abs, alVar, str2, cVar2, r6), "progressSuccess_handler").start();
                    chattingSendDataToDeviceUI.yuT.put(cVar2.deviceID, cVar2);
                } catch (Exception e) {
                    x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[]{e});
                }
            }
        }
        return true;
    }
}
