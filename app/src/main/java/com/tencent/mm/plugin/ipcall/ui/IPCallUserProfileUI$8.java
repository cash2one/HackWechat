package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.a;
import java.util.LinkedList;

class IPCallUserProfileUI$8 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;

    IPCallUserProfileUI$8(IPCallUserProfileUI iPCallUserProfileUI) {
        this.nNH = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        g.pQN.h(12766, Integer.valueOf(3));
        a aVar = new a(this.nNH, new 1(this));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(86));
        aVar.vmO = new 2(this);
        aVar.b(IPCallUserProfileUI.c(this.nNH), linkedList, true);
    }
}
