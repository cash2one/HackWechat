package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int ftq;
    private String mIL;
    private String mIM;

    protected final String aMu() {
        return getString(R.l.ekc);
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.AJ(this.ssid) && this.mGt) {
            aMx();
            this.mGt = false;
            this.mIL = d.aLB();
            this.mIM = d.aLD();
            this.ftq = d.aLC();
            x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.ftq), this.mIL, this.mIM});
            new a(this.mFa, this.mIL, this.mIM, this.ftq, this.fdS, m.D(getIntent())).b(new 1(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int aMt() {
        j.aLN();
        int AI = d.AI(this.ssid);
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(AI)});
        if (AI == 0) {
            return -2014;
        }
        return AI;
    }
}
