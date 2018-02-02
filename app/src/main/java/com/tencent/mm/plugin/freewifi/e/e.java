package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.x;

public class e {
    protected String appId = this.intent.getStringExtra("free_wifi_appid");
    protected int cOY = this.intent.getIntExtra("free_wifi_source", 1);
    protected int fdS = this.intent.getIntExtra("free_wifi_channel_id", 0);
    protected String fpz = this.intent.getStringExtra("free_wifi_ap_key");
    protected final Intent intent;
    protected FreeWifiFrontPageUI mEZ;
    protected String mFa = this.intent.getStringExtra("free_wifi_url");
    protected int mFb = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    protected String mFc = this.intent.getStringExtra("free_wifi_app_nickname");
    protected String ssid = this.intent.getStringExtra("free_wifi_ssid");

    public e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.mEZ = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        x.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.ssid, this.mFa, this.fpz, Integer.valueOf(this.cOY), Integer.valueOf(this.fdS), this.appId, this.mFc, Integer.valueOf(this.mFb)});
    }
}
