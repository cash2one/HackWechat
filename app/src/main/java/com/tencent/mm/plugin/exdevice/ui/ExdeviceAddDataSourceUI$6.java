package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.c;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceAddDataSourceUI$6 implements OnItemClickListener {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;

    ExdeviceAddDataSourceUI$6(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.lRL = exdeviceAddDataSourceUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ExdeviceAddDataSourceUI$b pe = ExdeviceAddDataSourceUI.c(this.lRL).pe(i - ((ListView) adapterView).getHeaderViewsCount());
        if (pe.lRS == c.lRT) {
            if (ExdeviceAddDataSourceUI.zk(pe.mac)) {
                ExdeviceAddDataSourceUI.a(this.lRL, pe.mac);
                pe.lRS = c.lRU;
                ExdeviceAddDataSourceUI.c(this.lRL).notifyDataSetChanged();
                return;
            }
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
        }
    }
}
