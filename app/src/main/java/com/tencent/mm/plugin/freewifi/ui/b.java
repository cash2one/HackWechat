package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bh;

public final class b {
    Activity activity;
    int fCR;
    String fpz;
    Intent intent;

    public b(Activity activity, String str, int i) {
        if (activity == null || bh.ov(str)) {
            throw new IllegalArgumentException("acitvity or apKey cannot be null.");
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.fpz = str;
        this.fCR = i;
    }

    final void AT(String str) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
    }
}
