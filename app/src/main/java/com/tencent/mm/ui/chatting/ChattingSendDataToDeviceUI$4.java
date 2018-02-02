package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.model.app.f;
import java.util.Comparator;
import java.util.List;

class ChattingSendDataToDeviceUI$4 implements Comparator<f> {
    final /* synthetic */ List xMI;
    final /* synthetic */ ChattingSendDataToDeviceUI yuZ;

    ChattingSendDataToDeviceUI$4(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, List list) {
        this.yuZ = chattingSendDataToDeviceUI;
        this.xMI = list;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.xMI.indexOf(((f) obj2).field_appId) - this.xMI.indexOf(((f) obj).field_appId);
    }
}
