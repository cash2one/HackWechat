package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$11 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;

    ExdeviceAddDataSourceUI$11(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.lRL = exdeviceAddDataSourceUI;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.c(this.lRL).notifyDataSetChanged();
    }
}
