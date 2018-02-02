package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class ExdeviceBindDeviceGuideUI$2 implements OnClickListener {
    final /* synthetic */ ExdeviceBindDeviceGuideUI lSn;

    ExdeviceBindDeviceGuideUI$2(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.lSn = exdeviceBindDeviceGuideUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(this.lSn));
        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(this.lSn));
        intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(this.lSn));
        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(this.lSn));
        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(this.lSn));
        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(this.lSn));
        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(this.lSn));
        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(this.lSn));
        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(this.lSn));
        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(this.lSn));
        intent.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.k(this.lSn));
        intent.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.l(this.lSn));
        intent.putExtra("jumpToBindDevice", true);
        if (ExdeviceBindDeviceGuideUI.m(this.lSn) && !ExdeviceBindDeviceGuideUI.n(this.lSn)) {
            d.b(this.lSn.mController.xIM, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
        } else if (ExdeviceBindDeviceGuideUI.n(this.lSn) && !ExdeviceBindDeviceGuideUI.m(this.lSn)) {
            intent.putExtra("exdevice_airkiss_open_type", 2);
            d.b(this.lSn.mController.xIM, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
        }
    }
}
