package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$2 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;

    ExdeviceAddDataSourceUI$2(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.lRL = exdeviceAddDataSourceUI;
    }

    public final void run() {
        if (ExdeviceAddDataSourceUI.f(this.lRL) != null && ExdeviceAddDataSourceUI.f(this.lRL).isShowing()) {
            ExdeviceAddDataSourceUI.f(this.lRL).dismiss();
        }
    }
}
