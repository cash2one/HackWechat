package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
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
public class ProtocolThreeTwoUI extends MMActivity {
    protected int cOY;
    protected String fFm;
    protected int fdS;
    private String fpz;
    private String fqD;
    private int fsg = 1;
    protected String fvL;
    private final c hDn;
    private Intent intent;
    protected String mFa;
    protected String mFc;
    private a mFg;
    private int mFm = 0;
    private String mFx;
    private TextView mGV;
    protected String mGr;
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
    private ak mIP = new ak(new 1(this), false);
    private r mIl;
    protected int mIq;
    protected String mIr;
    protected String mIs;
    private String openId;
    private String sign;
    protected String signature;
    protected String ssid;

    public ProtocolThreeTwoUI() {
        c.a aVar = new c.a();
        aVar.hDy = true;
        aVar.hDz = true;
        aVar.hDP = R.g.bCj;
        aVar.hDY = true;
        aVar.hDZ = 0.0f;
        this.hDn = aVar.PK();
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        protocolThreeTwoUI.mFm++;
        if (protocolThreeTwoUI.mFm > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent()))});
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.ag(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent())), str});
        if (m.AA(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.ag(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a 11 = new 11(protocolThreeTwoUI);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 11);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 11);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid});
        protocolThreeTwoUI.mFg.a(new 9(protocolThreeTwoUI));
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        protocolThreeTwoUI.ag(0, "");
        com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new 2(protocolThreeTwoUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.mFx = getIntent().getStringExtra("free_wifi_tid");
        this.fqD = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.fpz});
        initView();
        if (bh.ov(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
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
            cVar.field_wifiType = 32;
            cVar.field_connectState = 1;
            if (i != 0) {
                com.tencent.mm.plugin.freewifi.model.j.aLO().b(cVar);
            } else {
                com.tencent.mm.plugin.freewifi.model.j.aLO().c(cVar, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.mGr, Integer.valueOf(this.cOY)});
            this.mGx = new 7(this);
            com.tencent.mm.plugin.freewifi.model.j.aLO().c(this.mGx);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        l.p(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
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
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.ssid, this.mGr, this.mFa, Integer.valueOf(this.cOY), Integer.valueOf(this.fdS), this.fFm, this.mHp, this.mHq, this.mHs});
        setBackBtn(new 4(this));
        findViewById(R.h.cUl).setVisibility(0);
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
        setMMTitle(getString(R.l.ekc));
    }

    protected final void connect() {
        this.fsg = aMt();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), d.pW(this.fsg)});
        if (this.fsg != 2) {
            this.mIP.J(45000, 45000);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(60)});
            this.mFg = new a(this.ssid, this);
            com.tencent.mm.plugin.freewifi.model.j.aLR().aLz().post(new 8(this));
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void pZ(int i) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUm);
                this.mIl = h.a(this.mController.xIM, getString(R.l.dUm), true, new 3(this));
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 2:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
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
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 3:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
                this.mGV.setVisibility(0);
                this.mHl.setText(R.l.ejY);
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 4:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
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
                    if (!bh.ov(this.mFc)) {
                        this.mHj.setText(this.mFc);
                    }
                    if (!bh.ov(this.mHp)) {
                        o.PA().a(this.mHp, this.mHi, this.hDn);
                    }
                }
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.diy;
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

    protected final int aMt() {
        if (bh.ov(this.ssid)) {
            x.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c AR = com.tencent.mm.plugin.freewifi.model.j.aLO().AR(this.ssid);
        if (AR == null || !AR.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return AR.field_connectState;
    }

    private void ag(int i, String str) {
        k.a aLe = k.aLe();
        aLe.ssid = this.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol32UI");
        aLe.fpz = this.fpz;
        aLe.mCt = this.fFm;
        aLe.mCu = m.D(this.intent);
        aLe.mCv = m.F(this.intent);
        aLe.mCw = b.mCY.mDi;
        aLe.mCx = b.mCY.name;
        aLe.result = i;
        aLe.kZo = str;
        aLe.fCR = m.G(this.intent);
        aLe.mCy = this.fvL;
        aLe.aLg().aLf();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mGx != null) {
            com.tencent.mm.plugin.freewifi.model.j.aLO().j(this.mGx);
        }
        this.mIP.TG();
        com.tencent.mm.plugin.freewifi.model.j.aLR().release();
    }
}
