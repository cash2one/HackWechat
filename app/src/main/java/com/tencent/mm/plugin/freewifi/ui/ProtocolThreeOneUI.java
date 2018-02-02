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
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    protected int cOY;
    protected String fFm;
    protected int fdS;
    private boolean fhN = false;
    private String fpz;
    private String frP;
    private int fsg = 1;
    protected String fvL;
    private final c hDn;
    private Intent intent;
    protected String mFa;
    protected String mFc;
    private String mFl;
    private int mFm = 0;
    private TextView mGV;
    protected String mGr;
    private a mGx;
    private ImageView mHi;
    private TextView mHj;
    private TextView mHk;
    private Button mHl;
    private Button mHm;
    protected String mHp;
    protected String mHq;
    protected String mHr;
    protected String mHs;
    private ak mIP = new ak(new ak.a(this) {
        final /* synthetic */ ProtocolThreeOneUI mIQ;

        {
            this.mIQ = r1;
        }

        public final boolean uF() {
            if (!bh.ov(this.mIQ.ssid)) {
                this.mIQ.fsg = this.mIQ.aMt();
                if (this.mIQ.fsg != 2) {
                    this.mIQ.fhN = true;
                    x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), d.pW(this.mIQ.fsg)});
                    d.a(this.mIQ.ssid, 3, this.mIQ.getIntent());
                    this.mIQ.ag(31, "AUTH_TIMEOUT");
                }
            }
            return false;
        }
    }, false);
    private r mIl;
    protected int mIq;
    protected String mIr;
    protected String mIs;
    protected String signature;
    protected String ssid;

    public ProtocolThreeOneUI() {
        c.a aVar = new c.a();
        aVar.hDy = true;
        aVar.hDz = true;
        aVar.hDP = R.g.bCj;
        aVar.hDY = true;
        aVar.hDZ = 0.0f;
        this.hDn = aVar.PK();
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        protocolThreeOneUI.mFm++;
        if (protocolThreeOneUI.mFm > 3) {
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(protocolThreeOneUI.getIntent()), Integer.valueOf(m.E(protocolThreeOneUI.getIntent()))});
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.ag(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.D(protocolThreeOneUI.getIntent()), Integer.valueOf(m.E(protocolThreeOneUI.getIntent())), str});
        if (m.AA(str)) {
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.ag(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeOneUI) {
            final /* synthetic */ ProtocolThreeOneUI mIQ;

            {
                this.mIQ = r1;
            }

            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeOneUI.e(this.mIQ);
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    ProtocolThreeOneUI.a(this.mIQ, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent()))});
                    d.a(this.mIQ.ssid, 3, this.mIQ.getIntent());
                    this.mIQ.ag(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), exception.getMessage()});
                d.a(this.mIQ.ssid, 3, this.mIQ.getIntent());
                this.mIQ.ag(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLn();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass7);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLn();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass7);
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        protocolThreeOneUI.ag(0, "");
        j.aLR().aLz().post(new 8(protocolThreeOneUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        this.frP = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.mFl = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.fpz, this.frP});
        initView();
        if (bh.ov(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
        } else {
            com.tencent.mm.sdk.e.c cVar;
            int i;
            com.tencent.mm.sdk.e.c AR = j.aLO().AR(this.ssid);
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
            cVar.field_wifiType = 3;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.aLO().b(cVar);
            } else {
                j.aLO().c(cVar, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.mGr, Integer.valueOf(this.cOY)});
            this.mGx = new 5(this);
            j.aLO().c(this.mGx);
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
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
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.ssid, this.mGr, this.mFa, Integer.valueOf(this.cOY), Integer.valueOf(this.fdS), this.fFm, this.mHp, this.mHq, this.mHs});
        setBackBtn(new 2(this));
        findViewById(R.h.cUl).setVisibility(0);
        this.mHi = (ImageView) findViewById(R.h.cjh);
        this.mHj = (TextView) findViewById(R.h.cjT);
        this.mHk = (TextView) findViewById(R.h.cjG);
        this.mGV = (TextView) findViewById(R.h.cjo);
        this.mHl = (Button) findViewById(R.h.bWZ);
        this.mHl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeOneUI mIQ;

            {
                this.mIQ = r1;
            }

            public final void onClick(View view) {
                l.q(d.aLF(), this.mIQ.getIntent().getStringExtra("free_wifi_ap_key"), this.mIQ.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), d.pW(this.mIQ.aMt())});
                if (this.mIQ.aMt() == 2) {
                    this.mIQ.finish();
                    return;
                }
                d.a(this.mIQ.ssid, 1, this.mIQ.getIntent());
                this.mIQ.connect();
            }
        });
        this.mHm = (Button) findViewById(R.h.cUm);
        this.mHm.setOnClickListener(new 4(this));
        if (bh.ov(this.ssid)) {
            this.mHk.setText(getString(R.l.eka));
            this.mHl.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekc));
    }

    protected final void connect() {
        this.fsg = aMt();
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), d.pW(this.fsg)});
        if (this.fsg != 2) {
            this.mIP.J(15000, 15000);
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(60)});
            j.aLR().aLz().post(new 6(this, this.mFl));
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void pZ(int i) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.mGV.setVisibility(4);
                this.mHl.setText(R.l.dUm);
                this.mIl = h.a(this.mController.xIM, getString(R.l.dUm), true, new 9(this));
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
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
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 3:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
                this.mGV.setVisibility(0);
                this.mHl.setText(R.l.ejY);
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                return;
            case 4:
                if (this.mIl != null) {
                    this.mIl.dismiss();
                }
                this.mIP.TG();
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
                    if (!bh.ov(this.mFc)) {
                        this.mHj.setText(this.mFc);
                    }
                    if (!bh.ov(this.mHp)) {
                        o.PA().a(this.mHp, this.mHi, this.hDn);
                    }
                }
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
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
            x.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
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

    private void ag(int i, String str) {
        k.a aLe = k.aLe();
        aLe.ssid = this.ssid;
        aLe.bssid = m.AE("MicroMsg.FreeWifi.Protocol31UI");
        aLe.fpA = m.AF("MicroMsg.FreeWifi.Protocol31UI");
        aLe.fpz = this.fpz;
        aLe.mCt = this.fFm;
        aLe.mCu = m.D(this.intent);
        aLe.mCv = m.F(this.intent);
        aLe.mCw = b.mCX.mDi;
        aLe.mCx = b.mCX.name;
        aLe.result = i;
        aLe.kZo = str;
        aLe.fCR = m.G(this.intent);
        aLe.mCy = this.fvL;
        aLe.aLg().aLf();
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
