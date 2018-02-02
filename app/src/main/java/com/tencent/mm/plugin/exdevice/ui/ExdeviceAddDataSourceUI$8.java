package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$8 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;

    ExdeviceAddDataSourceUI$8(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.lRL = exdeviceAddDataSourceUI;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.c(this.lRL).aD(ExdeviceAddDataSourceUI.d(this.lRL));
        ExdeviceAddDataSourceUI.c(this.lRL).notifyDataSetChanged();
    }
}
