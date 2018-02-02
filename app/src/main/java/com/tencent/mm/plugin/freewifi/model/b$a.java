package com.tencent.mm.plugin.freewifi.model;

class b$a {
    String bssid;
    long mDY;
    String mDZ;
    String ssid;
    int type;

    private b$a() {
        this.ssid = "";
        this.bssid = "";
        this.mDZ = "";
    }

    public final b$a aLx() {
        b$a com_tencent_mm_plugin_freewifi_model_b_a = new b$a();
        com_tencent_mm_plugin_freewifi_model_b_a.mDY = this.mDY;
        com_tencent_mm_plugin_freewifi_model_b_a.type = this.type;
        com_tencent_mm_plugin_freewifi_model_b_a.ssid = this.ssid;
        com_tencent_mm_plugin_freewifi_model_b_a.bssid = this.bssid;
        com_tencent_mm_plugin_freewifi_model_b_a.mDZ = this.mDZ;
        return com_tencent_mm_plugin_freewifi_model_b_a;
    }

    public final String toString() {
        return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.mDY), Integer.valueOf(this.type), this.ssid, this.bssid, this.mDZ});
    }
}
