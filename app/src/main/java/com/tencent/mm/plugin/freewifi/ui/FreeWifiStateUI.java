package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected int cOY;
    protected String fFm;
    protected int fdS;
    protected String fpz;
    private int fsg = 1;
    protected String fvL;
    private final c hDn;
    protected String mFa;
    protected String mFc;
    private TextView mGV;
    protected String mGr;
    protected FreeWifiNetworkReceiver mGs;
    protected boolean mGt = false;
    private ak mGv = new ak(new 1(this), false);
    private ak mGw = new ak(new 2(this), true);
    private j.a mGx;
    private ImageView mHi;
    private TextView mHj;
    private TextView mHk;
    private Button mHl;
    private Button mHm;
    protected String mHp;
    protected String mHq;
    protected String mHr;
    protected String mHs;
    private r mIl = null;
    protected int mIq;
    protected String mIr;
    protected String mIs;
    protected String signature;
    protected String ssid;

    public abstract void a(State state);

    protected abstract void aMs();

    protected abstract int aMt();

    protected abstract void afF();

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.hDy = true;
        aVar.hDz = true;
        aVar.hDP = R.g.bCj;
        aVar.hDY = true;
        aVar.hDZ = 0.0f;
        this.hDn = aVar.PK();
        this.mGx = new 3(this);
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.mGs == null) {
            freeWifiStateUI.aMy();
        }
        freeWifiStateUI.mGs.mEr = freeWifiStateUI;
        d.aLA();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mGr = getIntent().getStringExtra("free_wifi_mid");
        this.mFa = getIntent().getStringExtra("free_wifi_url");
        this.cOY = getIntent().getIntExtra("free_wifi_source", 1);
        this.fdS = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.fFm = getIntent().getStringExtra("free_wifi_appid");
        this.mHp = getIntent().getStringExtra("free_wifi_head_img_url");
        this.mHq = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.mHr = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mHs = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mFc = getIntent().getStringExtra("free_wifi_app_nickname");
        switch (this.cOY) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
                if (bh.ov(this.ssid)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                com.tencent.mm.sdk.e.c cVar;
                int i;
                com.tencent.mm.sdk.e.c AR = com.tencent.mm.plugin.freewifi.model.j.aLO().AR(this.ssid);
                if (AR == null) {
                    AR = new com.tencent.mm.plugin.freewifi.g.c();
                    AR.field_ssidmd5 = ab.UZ(this.ssid);
                    AR.field_ssid = this.ssid;
                    cVar = AR;
                    i = 1;
                } else {
                    cVar = AR;
                    i = 0;
                }
                cVar.field_url = this.mFa;
                cVar.field_mid = this.mGr;
                cVar.field_wifiType = getIntent().getIntExtra("free_wifi_auth_type", 2);
                cVar.field_connectState = 1;
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
                    x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "source from mainui banner, ssid : %s, mid : %s, url : %s", this.ssid, this.mGr, this.mFa);
                } else {
                    x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "there is no connect sucessfull wifi info");
                }
                if (bh.ov(this.ssid)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
                    break;
                }
                x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mGr, Integer.valueOf(this.cOY));
                break;
        }
        if (bh.ov(this.ssid)) {
            x.e("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid is null");
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mGr, Integer.valueOf(this.cOY));
        }
        initView();
        com.tencent.mm.plugin.freewifi.model.j.aLO().c(this.mGx);
        l.p(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void initView() {
        setBackBtn(new 4(this));
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.h.cUl).setVisibility(0);
        }
        this.mHi = (ImageView) findViewById(R.h.cjh);
        this.mHj = (TextView) findViewById(R.h.cjT);
        this.mHk = (TextView) findViewById(R.h.cjG);
        this.mGV = (TextView) findViewById(R.h.cjo);
        this.mHl = (Button) findViewById(R.h.bWZ);
        this.mHl.setOnClickListener(new 5(this));
        this.mHm = (Button) findViewById(R.h.cUm);
        this.mHm.setOnClickListener(new 6(this));
        if (bh.ov(this.ssid)) {
            this.mHk.setText(getString(R.l.eka));
            this.mHl.setVisibility(4);
        }
    }

    protected final void aMv() {
        if (this.mGs != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.fsg));
            if (this.fsg != 2) {
                if (m.F(getIntent()) == 4) {
                    this.mGv.J(30000, 30000);
                } else {
                    this.mGv.J(60000, 60000);
                }
                this.mGw.J(1000, 1000);
                if (d.AJ(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.mGt));
                    if (this.mGt) {
                        x.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
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
            d.a(this.ssid, this.fsg, getIntent());
            return;
        }
        this.mGv.J(60000, 60000);
        this.mGw.J(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new 7(this));
    }

    protected final void pi(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mGv.TG();
                this.mGw.TG();
                this.mGV.setVisibility(0);
                this.mHl.setText(R.l.ejY);
                return;
            case -1:
                return;
            case 1:
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUm);
                this.mIl = h.a(this.mController.xIM, getString(R.l.dUm), true, new 9(this));
                return;
            case 2:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mGv.TG();
                this.mGw.TG();
                this.mHl.setText(R.l.dUj);
                this.mHl.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.fFm);
                intent.putExtra("free_wifi_app_nickname", this.mFc);
                intent.putExtra("free_wifi_app_username", this.fvL);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.mIq);
                intent.putExtra("free_wifi_finish_url", this.mIr);
                if (bh.ov(this.mIs)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.mIs);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.wW();
                return;
            case 3:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mGv.TG();
                this.mGw.TG();
                this.mGV.setVisibility(0);
                this.mHl.setText(R.l.ejY);
                return;
            case 4:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mGv.TG();
                this.mGw.TG();
                this.mGt = false;
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUp);
                if (!(m.G(getIntent()) != 10 || m.AA(q.gFZ.gGv) || m.AA(q.aI(this.mController.xIM)))) {
                    this.mHl.setText(String.format(getString(R.l.ejy), new Object[]{q.aI(this.mController.xIM)}));
                }
                if (this.cOY == 3) {
                    this.mHk.setText(getString(R.l.evc, new Object[]{this.ssid}));
                } else if (bh.ov(this.mHr)) {
                    this.mHk.setText(getString(R.l.dUl));
                } else {
                    this.mHk.setText(this.mHr);
                }
                if (!bh.ov(this.fFm)) {
                    if (!bh.ov(this.mHq)) {
                        this.mHj.setText(this.mHq);
                    }
                    if (!bh.ov(this.mHp)) {
                        o.PA().a(this.mHp, this.mHi, this.hDn);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUp);
                if (this.cOY == 3) {
                    this.mHk.setText(getString(R.l.evc, new Object[]{this.ssid}));
                } else if (bh.ov(this.mHr)) {
                    this.mHk.setText(getString(R.l.dUl));
                } else {
                    this.mHk.setText(this.mHr);
                }
                if (!bh.ov(this.fFm)) {
                    if (!bh.ov(this.mHq)) {
                        this.mHj.setText(this.mHq);
                    }
                    if (!bh.ov(this.mHp)) {
                        o.PA().a(this.mHp, this.mHi, this.hDn);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.diy;
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
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i));
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
        l.r(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ifs.i(new Intent(), this);
        finish();
    }
}
