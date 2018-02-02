package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
    protected int cOY;
    protected int fdS;
    private int fsg = 1;
    protected String mFa;
    private FreeWifiStateView mGm;
    private TextView mGn;
    private TextView mGo;
    private Button mGp;
    protected Button mGq;
    protected String mGr;
    protected FreeWifiNetworkReceiver mGs;
    protected boolean mGt = false;
    private boolean mGu = false;
    private ak mGv = new ak(new 1(this), false);
    private ak mGw = new ak(new 2(this), true);
    private j.a mGx = new 3(this);
    protected String ssid;

    protected abstract void aMs();

    protected abstract int aMt();

    protected abstract void afF();

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.mGs == null) {
            freeWifiActivateStateUI.aMy();
        }
        freeWifiActivateStateUI.mGs.mEr = freeWifiActivateStateUI;
        d.aLA();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mGr = getIntent().getStringExtra("free_wifi_mid");
        this.mFa = getIntent().getStringExtra("free_wifi_url");
        this.cOY = getIntent().getIntExtra("free_wifi_source", 1);
        this.fdS = getIntent().getIntExtra("free_wifi_channel_id", 0);
        switch (this.cOY) {
            case 1:
            case 3:
            case 4:
            case 5:
                if (bh.ov(this.ssid)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                c cVar;
                int i;
                c AR = com.tencent.mm.plugin.freewifi.model.j.aLO().AR(this.ssid);
                if (AR == null) {
                    AR = new com.tencent.mm.plugin.freewifi.g.c();
                    AR.field_ssidmd5 = ab.UZ(this.ssid);
                    AR.field_ssid = this.ssid;
                    AR.field_connectState = 1;
                    cVar = AR;
                    i = 1;
                } else {
                    cVar = AR;
                    i = 0;
                }
                cVar.field_url = this.mFa;
                cVar.field_mid = this.mGr;
                cVar.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
                if (i != 0) {
                    com.tencent.mm.plugin.freewifi.model.j.aLO().b(cVar);
                } else {
                    com.tencent.mm.plugin.freewifi.model.j.aLO().c(cVar, new String[0]);
                }
            case 2:
                com.tencent.mm.plugin.freewifi.g.c aMq = com.tencent.mm.plugin.freewifi.model.j.aLO().aMq();
                if (aMq != null) {
                    this.ssid = aMq.field_ssid;
                    this.mGr = aMq.field_mid;
                    this.mFa = aMq.field_url;
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mGr, this.mFa);
                } else {
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "there is no connect sucessfull wifi info");
                }
                if (bh.ov(this.ssid)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
                    break;
                }
                x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mGr, Integer.valueOf(this.cOY));
                break;
        }
        if (bh.ov(this.ssid)) {
            x.e("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid is null");
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mGr, Integer.valueOf(this.cOY));
        }
        initView();
        com.tencent.mm.plugin.freewifi.model.j.aLO().c(this.mGx);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!bh.ov(this.ssid)) {
            aMz();
        }
    }

    protected void initView() {
        setBackBtn(new 4(this));
        this.mGm = (FreeWifiStateView) findViewById(R.h.cjj);
        this.mGn = (TextView) findViewById(R.h.cjk);
        this.mGo = (TextView) findViewById(R.h.cjl);
        if (this.cOY == 3) {
            this.mGo.setText(getString(R.l.evc, new Object[]{this.ssid}));
        } else {
            this.mGo.setText(getString(R.l.dUn, new Object[]{this.ssid}));
        }
        this.mGp = (Button) findViewById(R.h.cFr);
        this.mGp.setOnClickListener(new 5(this));
        this.mGq = (Button) findViewById(R.h.coz);
        this.mGq.setOnClickListener(new 6(this));
    }

    protected final void aMv() {
        if (this.mGs != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
            this.mGs.mEr = null;
        }
    }

    protected final void aMw() {
        if (this.mGs == null) {
            aMy();
        }
        this.mGs.mEs = this;
    }

    protected final void aMx() {
        if (this.mGs != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
            this.mGs.mEs = null;
        }
    }

    private void aMy() {
        this.mGs = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.mGs, intentFilter);
    }

    protected final void aMz() {
        if (d.isWifiEnabled()) {
            this.fsg = aMt();
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.fsg));
            if (this.fsg != 2) {
                this.mGv.J(60000, 60000);
                this.mGw.J(1000, 1000);
                if (d.AJ(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mGt));
                    if (this.mGt) {
                        x.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
                        return;
                    }
                    this.mGv.J(60000, 60000);
                    this.mGw.J(1000, 1000);
                    afF();
                    this.mGt = true;
                    return;
                }
                com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new 8(this));
                return;
            }
            pi(this.fsg);
            return;
        }
        this.mGv.J(60000, 60000);
        this.mGw.J(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new 7(this));
    }

    protected final void pi(int i) {
        this.mGm.setOnClickListener(null);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                this.mGv.TG();
                this.mGw.TG();
                this.mGm.setImageResource(R.g.bCq);
                this.mGm.setState(3);
                this.mGn.setText(R.l.ejP);
                this.mGn.setVisibility(0);
                this.mGo.setText(R.l.ejQ);
                this.mGo.setVisibility(0);
                break;
            case 1:
                this.mGm.setImageResource(R.g.bCr);
                this.mGm.setState(1);
                this.mGn.setText(R.l.dUk);
                break;
            case 2:
                this.mGm.setImageResource(R.g.bCp);
                this.mGm.setState(2);
                this.mGn.setText(R.l.dUj);
                this.mGp.setVisibility(0);
                this.mGp.setText(R.l.ejv);
                this.mGv.TG();
                this.mGw.TG();
                if (this.cOY == 1 || this.cOY == 5 || this.cOY == 4) {
                    this.mGp.setVisibility(4);
                    com.tencent.mm.plugin.freewifi.g.c AR = com.tencent.mm.plugin.freewifi.model.j.aLO().AR(this.ssid);
                    if (!(AR == null || bh.ov(AR.field_showUrl) || this.mGu)) {
                        this.mGu = true;
                        ag.h(new 9(this, AR), 1000);
                    }
                }
                d.wW();
                return;
            case 3:
                this.mGm.setImageResource(R.g.bCr);
                this.mGm.setState(3);
                this.mGm.lUf = 2;
                this.mGn.setText(R.l.dUo);
                this.mGp.setVisibility(0);
                this.mGp.setText(R.l.ejY);
                this.mGv.TG();
                this.mGw.TG();
                return;
            default:
                this.mGm.setImageResource(R.g.bCr);
                this.mGn.setText(R.l.dUk);
                if (this.cOY != 3) {
                    this.mGo.setText(getString(R.l.dUn, new Object[]{this.ssid}));
                    break;
                }
                this.mGo.setText(getString(R.l.evc, new Object[]{this.ssid}));
                break;
        }
        this.mGp.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.diF;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aLO().j(this.mGx);
        aMv();
        aMx();
        if (this.mGs != null) {
            unregisterReceiver(this.mGs);
        }
        this.mGv.TG();
        this.mGw.TG();
        com.tencent.mm.plugin.freewifi.model.j.aLR().release();
    }

    public final void pX(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", Integer.valueOf(i));
        switch (i) {
            case 3:
                aMv();
                aMz();
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            g.ifs.i(new Intent(), this);
        }
    }
}
