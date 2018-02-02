package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k$b;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

public class FreeWifiSuccWebViewUI extends WebViewUI implements e {
    private int fCR;
    private String fFm;
    private String fvL;
    private String mFc;
    private boolean mIE = false;
    private int mIq;
    private String mIr;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        String str = j.userName;
        if (bh.ov(freeWifiSuccWebViewUI.fvL) || !freeWifiSuccWebViewUI.fvL.equals(str)) {
            freeWifiSuccWebViewUI.mIE = false;
        } else {
            freeWifiSuccWebViewUI.mIE = true;
        }
        if (!(!freeWifiSuccWebViewUI.mIE || bh.ov(freeWifiSuccWebViewUI.fFm) || (s.gF(freeWifiSuccWebViewUI.fvL) && s.gE(freeWifiSuccWebViewUI.fvL)))) {
            ar.CG().a(1703, (e) freeWifiSuccWebViewUI);
            ar.CG().a(new i(freeWifiSuccWebViewUI.fFm, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), m.D(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.c(d.aLF(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.mIE);
        WifiInfo aLE = d.aLE();
        a aLe = k.aLe();
        if (aLE != null) {
            str = aLE.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aLj();
            }
            aLe.ssid = m.AB(aLE.getSSID());
            aLe.bssid = aLE.getBSSID();
            aLe.fpA = str;
        }
        aLe.fpz = m.H(freeWifiSuccWebViewUI.getIntent());
        aLe.mCt = freeWifiSuccWebViewUI.fFm;
        aLe.mCu = m.D(freeWifiSuccWebViewUI.getIntent());
        aLe.mCv = m.F(freeWifiSuccWebViewUI.getIntent());
        aLe.mCw = k$b.QinghuaiBackpageFinished.mDi;
        aLe.mCx = k$b.QinghuaiBackpageFinished.name;
        aLe.fCR = m.G(freeWifiSuccWebViewUI.getIntent());
        aLe.mCy = freeWifiSuccWebViewUI.fvL;
        aLe.aLg().aLf();
        String stringExtra = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.mIq == 1 && !bh.ov(stringExtra)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(stringExtra).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccWebViewUI.getSharedPreferences(ac.cfs(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bm.d.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        } else if (freeWifiSuccWebViewUI.mIq == 3 && !bh.ov(stringExtra)) {
            ((com.tencent.mm.plugin.appbrand.m.d) g.h(com.tencent.mm.plugin.appbrand.m.d.class)).b(freeWifiSuccWebViewUI, stringExtra, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", stringExtra);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        j.userName = "";
        j.type = 0;
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", getIntent().getStringExtra("free_wifi_qinghuai_url"));
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.fFm = getIntent().getStringExtra("free_wifi_appid");
        this.mFc = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fvL = getIntent().getStringExtra("free_wifi_app_username");
        this.mIq = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mIr = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.fCR = m.G(getIntent());
        if (this.fCR == 10) {
            str = q.gFZ.gGv;
            String aI = q.aI(this.mController.xIM);
            if (!(m.AA(str) || m.AA(aI))) {
                this.mIr = Uri.parse(this.mIr).buildUpon().appendQueryParameter("manufacturer", aI).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.fFm, this.mFc, this.fvL, Integer.valueOf(this.mIq), this.mIr, this.signature);
        WifiInfo aLE = d.aLE();
        a aLe = k.aLe();
        if (aLE != null) {
            str = aLE.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aLj();
            }
            aLe.ssid = m.AB(aLE.getSSID());
            aLe.bssid = aLE.getBSSID();
            aLe.fpA = str;
        }
        aLe.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        aLe.mCt = this.fFm;
        aLe.mCu = m.D(getIntent());
        aLe.mCv = m.F(getIntent());
        aLe.mCw = k$b.GetBackPage.mDi;
        aLe.mCx = k$b.GetBackPage.name;
        aLe.fCR = m.G(getIntent());
        aLe.mCy = this.fvL;
        aLe.aLg().aLf();
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1703, (e) this);
    }

    protected final void akN() {
        super.akN();
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void initView() {
        super.initView();
        lV(false);
        a(0, getString(R.l.ejN), new 1(this), b.xJE);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!getString(R.l.ejN).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(R.l.ejN), new 2(this), b.xJE);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        ar.CG().b(1703, (e) this);
    }
}
