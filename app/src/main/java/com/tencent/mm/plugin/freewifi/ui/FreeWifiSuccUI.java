package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

public class FreeWifiSuccUI extends MMActivity implements e {
    private String fFm;
    private String fvL;
    private CheckBox kVV;
    private String mFc;
    private View mIA;
    private Button mIB;
    private int mIC;
    private boolean mIE = false;
    private boolean mIF = false;
    private TextView mIj;
    private int mIq;
    private String mIr;
    private View mIw;
    private TextView mIx;
    private View mIy;
    private TextView mIz;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        freeWifiSuccUI.aMM();
        WifiInfo aLE = d.aLE();
        a aLe = k.aLe();
        if (aLE != null) {
            String macAddress = aLE.getMacAddress();
            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                macAddress = m.aLj();
            }
            aLe.ssid = m.AB(aLE.getSSID());
            aLe.bssid = aLE.getBSSID();
            aLe.fpA = macAddress;
        }
        aLe.fpz = m.H(freeWifiSuccUI.getIntent());
        aLe.mCt = freeWifiSuccUI.fFm;
        aLe.mCu = m.D(freeWifiSuccUI.getIntent());
        aLe.mCv = m.F(freeWifiSuccUI.getIntent());
        aLe.mCw = b.mCM.mDi;
        aLe.mCx = b.mCM.name;
        aLe.fCR = m.G(freeWifiSuccUI.getIntent());
        aLe.mCy = freeWifiSuccUI.fvL;
        aLe.aLg().aLf();
        if (freeWifiSuccUI.mIq == 1 && !bh.ov(freeWifiSuccUI.mIr)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.mIr).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccUI.getSharedPreferences(ac.cfs(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bm.d.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        } else if (freeWifiSuccUI.mIq != 0 && freeWifiSuccUI.mIq == 3 && !bh.ov(freeWifiSuccUI.mIr)) {
            ((com.tencent.mm.plugin.appbrand.m.d) g.h(com.tencent.mm.plugin.appbrand.m.d.class)).b(freeWifiSuccUI, freeWifiSuccUI.mIr, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", new Object[]{freeWifiSuccUI.mIr});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fFm = getIntent().getStringExtra("free_wifi_appid");
        this.mFc = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fvL = getIntent().getStringExtra("free_wifi_app_username");
        this.mIq = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mIr = getIntent().getStringExtra("free_wifi_finish_url");
        this.mIC = getIntent().getIntExtra(c.xEk, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.fFm, this.mFc, this.fvL, Integer.valueOf(this.mIq), this.mIr, this.signature});
        WifiInfo aLE = d.aLE();
        a aLe = k.aLe();
        String macAddress = aLE.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = m.aLj();
        }
        if (aLE != null) {
            aLe.ssid = m.AB(aLE.getSSID());
            aLe.bssid = aLE.getBSSID();
            aLe.fpA = macAddress;
        }
        aLe.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        aLe.mCt = this.fFm;
        aLe.mCu = m.D(getIntent());
        aLe.mCv = m.F(getIntent());
        aLe.mCw = b.mCI.mDi;
        aLe.mCx = b.mCI.name;
        aLe.fCR = m.G(getIntent());
        aLe.mCy = this.fvL;
        aLe.aLg().aLf();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    public void finish() {
        super.finish();
        aMM();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ar.CG().b(1703, this);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.diG;
    }

    protected final void initView() {
        setMMTitle(R.l.ekc);
        lV(false);
        this.mIw = findViewById(R.h.cjM);
        this.mIx = (TextView) findViewById(R.h.cjN);
        this.kVV = (CheckBox) findViewById(R.h.cjK);
        this.mIy = findViewById(R.h.cjH);
        this.mIz = (TextView) findViewById(R.h.cjI);
        this.mIA = findViewById(R.h.cjO);
        this.mIj = (TextView) findViewById(R.h.cjJ);
        this.mIB = (Button) findViewById(R.h.bXa);
        this.mIB.setOnClickListener(new 1(this));
        if (bh.ov(this.fFm) || bh.ov(this.fvL) || bh.ov(this.mFc)) {
            this.mIw.setVisibility(8);
            this.mIy.setVisibility(8);
            this.mIA.setVisibility(8);
        } else if (s.gF(this.fvL) && s.gE(this.fvL)) {
            l.b(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.mIw.setVisibility(8);
            this.mIy.setVisibility(8);
            this.mIA.setVisibility(0);
            this.mIj.setText(this.mFc);
            this.mIA.setOnClickListener(new 2(this));
        } else {
            l.b(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.mIA.setVisibility(8);
            this.mIw.setVisibility(0);
            if (bh.ov(this.signature)) {
                this.mIy.setVisibility(8);
                findViewById(R.h.cjL).setBackgroundColor(getResources().getColor(R.e.white));
            } else {
                this.mIy.setVisibility(0);
                this.mIz.setText(this.signature);
            }
            this.mIx.setText(getString(R.l.ejO, new Object[]{this.mFc}));
            if (this.mIC == 1) {
                this.kVV.setChecked(true);
                this.mIE = true;
            } else {
                this.kVV.setChecked(false);
                this.mIE = false;
            }
            this.kVV.setOnCheckedChangeListener(new 3(this));
        }
        if (m.G(getIntent()) == 10) {
            final String str = q.gFZ.gGv;
            if (!m.AA(str) && !m.AA(q.aI(this.mController.xIM))) {
                Button button = (Button) findViewById(R.h.cjP);
                button.setText(String.format(getString(R.l.ekb), new Object[]{q.aI(this.mController.xIM)}));
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FreeWifiSuccUI mIG;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        com.tencent.mm.bm.d.b(this.mIG, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                button.setVisibility(0);
            }
        }
    }

    private void aMM() {
        if (!this.mIF) {
            this.mIF = true;
            if (!(!this.mIE || bh.ov(this.fFm) || (s.gF(this.fvL) && s.gE(this.fvL)))) {
                ar.CG().a(1703, this);
                ar.CG().a(new i(this.fFm, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.D(getIntent())), 0);
            }
            l.c(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.mIE);
        }
    }
}
