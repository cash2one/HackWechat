package com.tencent.mm.plugin.freewifi.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class FreeWifiManufacturerLoadingUI$1 extends af {
    int i = 0;
    final /* synthetic */ FreeWifiManufacturerLoadingUI mHX;

    FreeWifiManufacturerLoadingUI$1(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.mHX = freeWifiManufacturerLoadingUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.i >= FreeWifiManufacturerLoadingUI.a(this.mHX).length) {
                this.i = 0;
            }
            FreeWifiManufacturerLoadingUI.b(this.mHX).setImageResource(FreeWifiManufacturerLoadingUI.a(this.mHX)[this.i]);
            this.i++;
        } else if (message.what == 2) {
            FreeWifiManufacturerLoadingUI.b(this.mHX).setImageResource(FreeWifiManufacturerLoadingUI.a(this.mHX)[FreeWifiManufacturerLoadingUI.a(this.mHX).length - 1]);
        } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
            FreeWifiManufacturerLoadingUI.c(this.mHX).setText(message.obj.toString());
        }
        super.handleMessage(message);
    }
}
