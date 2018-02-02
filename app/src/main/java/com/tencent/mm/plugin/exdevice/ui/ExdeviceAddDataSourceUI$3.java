package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceAddDataSourceUI$3 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;
    final /* synthetic */ String lRM;

    ExdeviceAddDataSourceUI$3(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI, String str) {
        this.lRL = exdeviceAddDataSourceUI;
        this.lRM = str;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.a(this.lRL, h.a(this.lRL.mController.xIM, this.lRL.getString(R.l.dHc), true, new 1(this)));
    }
}
