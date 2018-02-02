package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.bm.d;

class g$50 implements Runnable {
    final /* synthetic */ String mDz;
    final /* synthetic */ String tIN;
    final /* synthetic */ boolean tIO;
    final /* synthetic */ int tIP;
    final /* synthetic */ g tIj;

    g$50(g gVar, String str, String str2, boolean z, int i) {
        this.tIj = gVar;
        this.mDz = str;
        this.tIN = str2;
        this.tIO = z;
        this.tIP = i;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_ssid", this.mDz);
        intent.putExtra("free_wifi_source", 3);
        intent.putExtra("free_wifi_passowrd", this.tIN);
        intent.putExtra("free_wifi_hide_ssid", this.tIO);
        intent.putExtra("free_wifi_encrypt_type", this.tIP);
        intent.addFlags(67108864);
        d.b(g.i(this.tIj), "freewifi", ".ui.FreeWifiEntryUI", intent);
    }
}
