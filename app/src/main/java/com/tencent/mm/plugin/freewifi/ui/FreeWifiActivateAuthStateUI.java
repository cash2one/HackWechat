package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cOY != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void initView() {
        super.initView();
        this.mGq = (Button) findViewById(R.h.coz);
        this.mGq.setOnClickListener(new 1(this));
        setMMTitle(R.l.ekc);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.AJ(this.ssid)) {
            aMx();
            aMz();
        }
    }

    protected final void afF() {
        j.aLT().a(this.ssid, new 2(this), this.fdS, getIntent());
    }

    protected final void aMs() {
        aMw();
        d.AK(this.ssid);
    }

    protected final int aMt() {
        j.aLN();
        return d.AI(this.ssid);
    }
}
