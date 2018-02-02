package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.b.n;
import com.tencent.mm.sdk.platformtools.x;

class ServiceAppUI$2 implements OnItemClickListener {
    final /* synthetic */ ServiceAppUI rXV;

    ServiceAppUI$2(ServiceAppUI serviceAppUI) {
        this.rXV = serviceAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ServiceAppUI.a(this.rXV) == null) {
            x.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
            return;
        }
        n yg = ServiceAppUI.a(this.rXV).yg(i);
        if (yg == null) {
            x.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
            return;
        }
        x.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(yg.fQZ), yg.field_packageName, yg.field_appId});
        ServiceAppUI.a(this.rXV, yg);
    }
}
