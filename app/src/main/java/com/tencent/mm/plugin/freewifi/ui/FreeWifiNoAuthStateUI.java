package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k$b;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String mBX;
    private int mGk;
    private boolean mGl;

    protected abstract String aMu();

    public void onCreate(Bundle bundle) {
        this.mGk = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.mBX = getIntent().getStringExtra("free_wifi_passowrd");
        this.mGl = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void initView() {
        super.initView();
        setMMTitle(aMu());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", state.toString());
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
            x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.mGt = true;
        aMw();
        int d = d.d(this.ssid, this.mBX, this.mGk, this.mGl);
        a aLe = k.aLe();
        aLe.ssid = this.ssid;
        aLe.fpz = this.fpz;
        aLe.mCu = m.D(getIntent());
        aLe.mCv = m.F(getIntent());
        aLe.mCw = k$b.AddNetwork.mDi;
        aLe.mCx = k$b.AddNetwork.name;
        aLe.result = d;
        aLe.fCR = m.G(getIntent());
        aLe.mCt = this.fFm;
        aLe.mCy = this.fvL;
        aLe.aLg().aLf();
    }

    protected int aMt() {
        if (!d.AJ(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
