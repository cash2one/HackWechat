package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class FreeWifiCopyPwdUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiCopyPwdUI mGY;
    final /* synthetic */ String mGZ;

    FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI freeWifiCopyPwdUI, String str) {
        this.mGY = freeWifiCopyPwdUI;
        this.mGZ = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_show_detail_error", 1);
        intent.putExtra("free_wifi_error_ui_error_msg", this.mGY.getString(R.l.ejz));
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", this.mGZ);
        intent.setClass(this.mGY, FreeWifiErrorUI.class);
        this.mGY.startActivity(intent);
    }
}
