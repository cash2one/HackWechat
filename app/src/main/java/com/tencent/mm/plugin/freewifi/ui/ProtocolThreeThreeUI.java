package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

@Deprecated
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String bssid;
    protected int cOY;
    protected int fdS;
    protected String fqD;
    private int fsg = 1;
    protected String fvL;
    protected String mFc;
    private int mFm = 0;
    protected String mFp;
    protected String mFq;
    protected String mFr;
    private Uri mFs;
    private String mFt;
    private TextView mGV;
    private a mGx;
    private ImageView mHi;
    private TextView mHj;
    private TextView mHk;
    private Button mHl;
    private Button mHm;
    private ak mIP = new ak(new 1(this), false);
    private r mIl;
    protected int mIq;
    protected String mIr;
    protected String mIs;
    protected String sign;
    protected String signature;
    protected String ssid;

    static /* synthetic */ void a(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        protocolThreeThreeUI.mFm++;
        if (protocolThreeThreeUI.mFm > 3) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.E(protocolThreeThreeUI.getIntent()))});
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.E(protocolThreeThreeUI.getIntent())), str});
        if (m.AA(str)) {
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        a$a 7 = new 7(protocolThreeThreeUI);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 7);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 7);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFt = getIntent().getStringExtra("free_wifi_schema_uri");
        this.mFs = Uri.parse(this.mFt);
        this.appId = this.mFs.getQueryParameter("appId");
        this.mFp = this.mFs.getQueryParameter("shopId");
        this.mFq = this.mFs.getQueryParameter("authUrl");
        this.mFr = this.mFs.getQueryParameter("extend");
        this.fqD = this.mFs.getQueryParameter("timestamp");
        this.sign = this.mFs.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.mFt});
        initView();
        if (bh.ov(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            c cVar;
            int i;
            c AR = j.aLO().AR(this.ssid);
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
            cVar.field_url = "";
            cVar.field_mid = "";
            cVar.field_wifiType = 33;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.aLO().b(cVar);
            } else {
                j.aLO().c(cVar, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, "", Integer.valueOf(this.cOY)});
            this.mGx = new a(this) {
                final /* synthetic */ ProtocolThreeThreeUI mIT;
                private int mIu = -999999999;

                {
                    this.mIT = r2;
                }

                public final void a(String str, l lVar) {
                    this.mIT.fsg = this.mIT.aMt();
                    if (this.mIu != this.mIT.fsg) {
                        this.mIu = this.mIT.fsg;
                        this.mIT.pZ(this.mIT.fsg);
                    }
                }
            };
            j.aLO().c(this.mGx);
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.p(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        this.ssid = m.AD("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.AE("MicroMsg.FreeWifi.Protocol33UI");
        this.cOY = getIntent().getIntExtra("free_wifi_source", 1);
        this.fdS = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new 2(this));
        findViewById(R.h.cUl).setVisibility(0);
        this.mHi = (ImageView) findViewById(R.h.cjh);
        this.mHj = (TextView) findViewById(R.h.cjT);
        this.mHk = (TextView) findViewById(R.h.cjG);
        this.mGV = (TextView) findViewById(R.h.cjo);
        this.mHl = (Button) findViewById(R.h.bWZ);
        this.mHl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI mIT;

            {
                this.mIT = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.q(d.aLF(), this.mIT.getIntent().getStringExtra("free_wifi_ap_key"), this.mIT.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.D(this.mIT.getIntent()), Integer.valueOf(m.E(this.mIT.getIntent())), d.pW(this.mIT.aMt())});
                if (this.mIT.aMt() == 2) {
                    this.mIT.finish();
                    return;
                }
                d.a(this.mIT.ssid, 1, this.mIT.getIntent());
                this.mIT.connect();
            }
        });
        this.mHm = (Button) findViewById(R.h.cUm);
        this.mHm.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI mIT;

            {
                this.mIT = r1;
            }

            public final void onClick(View view) {
            }
        });
        if (bh.ov(this.ssid)) {
            this.mHk.setText(getString(R.l.eka));
            this.mHl.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekc));
    }

    protected final void connect() {
        if (m.AA(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else if (m.AA(this.mFq)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else {
            this.fsg = aMt();
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), d.pW(this.fsg)});
            if (this.fsg != 2) {
                this.mIP.J(30000, 30000);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(60)});
                m.AA(this.mFq);
                StringBuilder stringBuilder = new StringBuilder(this.mFq);
                if (this.mFq.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.mFr);
                } else {
                    stringBuilder.append("&extend=").append(this.mFr);
                }
                j.aLR().aLz().post(new 6(this, stringBuilder.toString()));
                return;
            }
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void pZ(int i) {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUm);
                this.mIl = h.a(this.mController.xIM, getString(R.l.dUm), true, new 9(this));
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 2:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
                this.mHl.setText(R.l.dUj);
                this.mHl.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 3:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
                this.mGV.setVisibility(0);
                this.mHl.setText(R.l.ejY);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
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
                } else {
                    this.mHk.setText(getString(R.l.dUn, new Object[]{this.ssid}));
                }
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
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
        com.tencent.mm.plugin.freewifi.l.r(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ifs.i(new Intent(), this);
        finish();
    }

    protected final int aMt() {
        if (bh.ov(this.ssid)) {
            x.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c AR = j.aLO().AR(this.ssid);
        if (AR == null || !AR.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return AR.field_connectState;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mGx != null) {
            j.aLO().j(this.mGx);
        }
        this.mIP.TG();
        j.aLR().release();
    }
}
