package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String mBX;
    private int mGk;
    private boolean mGl;

    protected abstract String aMu();

    public void onCreate(Bundle bundle) {
        this.mGk = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.mBX = getIntent().getStringExtra("free_wifi_passowrd");
        this.mGl = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void initView() {
        super.initView();
        this.mGq.setVisibility(0);
        setMMTitle(aMu());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.AJ(this.ssid)) {
            aMx();
            this.mGt = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void afF() {
        aMs();
    }

    protected final void aMs() {
        if (this.mGt) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.mGt = true;
        aMw();
        d.d(this.ssid, this.mBX, this.mGk, this.mGl);
    }

    protected int aMt() {
        if (!d.AJ(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
