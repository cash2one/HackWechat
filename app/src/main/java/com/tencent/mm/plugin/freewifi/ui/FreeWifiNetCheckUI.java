package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNetCheckUI extends MMActivity {
    private String aAM;
    private int fCR;
    private ak fhK;
    private Intent intent;
    ImageView mHO;
    private final int mHR = 1;
    private final int mHS = 2;
    private int[] mHU = new int[]{R.g.bCk, R.g.bCl, R.g.bCm, R.g.bCn, R.g.bCo};
    af mHV = new 1(this);
    private b mIc;
    private int scene;

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
    }

    public void finish() {
        if (this.fhK != null) {
            this.fhK.TG();
        }
        this.mHV.sendEmptyMessage(2);
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekc);
        setBackBtn(new 2(this));
        this.intent = getIntent();
        m.C(this.intent);
        this.aAM = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.aAM, d.aLD()});
        this.mHO = (ImageView) findViewById(R.h.cjh);
        this.fhK = new ak(new 3(this), true);
        this.fhK.J(200, 200);
        String str;
        switch (this.scene) {
            case 1:
                getIntent().putExtra("free_wifi_channel_id", 2);
                this.fCR = 2;
                if (!bh.ov(this.aAM)) {
                    Uri uri = null;
                    str = "";
                    try {
                        uri = Uri.parse(this.aAM);
                        str = uri.getQueryParameter("q");
                    } catch (Exception e) {
                        finish();
                    }
                    if (!"pc".equalsIgnoreCase(str)) {
                        "_test".equals(str);
                        aML();
                        break;
                    }
                    str = uri.getQueryParameter("appid");
                    String queryParameter = uri.getQueryParameter("shopid");
                    String queryParameter2 = uri.getQueryParameter("ticket");
                    m.d(getIntent(), queryParameter2);
                    a aLe = k.aLe();
                    aLe.mCs = queryParameter;
                    aLe.mCt = str;
                    aLe.mCu = queryParameter2;
                    aLe.mCw = b.mDc.mDi;
                    aLe.mCx = b.mDc.name;
                    aLe.aLg().aLf();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), queryParameter, str, queryParameter2});
                    new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).b(new 4(this, queryParameter, queryParameter2, str));
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 4:
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if ("1".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 9);
                    this.fCR = 9;
                } else if ("0".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 8);
                    this.fCR = 8;
                } else {
                    getIntent().putExtra("free_wifi_channel_id", 4);
                    this.fCR = 4;
                }
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if (!str.equals("0") || !bh.ov(this.aAM)) {
                    if (!str.equals("0")) {
                        if (!str.equals("1")) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                            finish();
                            break;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                        if (!d.isWifiEnabled()) {
                            d.aLA();
                        }
                        h$b.mEw.a(new 5(this, str));
                        break;
                    }
                    aML();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                finish();
                break;
                break;
            case 5:
                this.fCR = getIntent().getIntExtra("free_wifi_channel_id", 1);
                if (!bh.ov(this.aAM)) {
                    aML();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 6:
                getIntent().putExtra("free_wifi_channel_id", 10);
                this.fCR = 10;
                if (!bh.ov(this.aAM)) {
                    aML();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            default:
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                finish();
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(this.intent)), Integer.valueOf(this.fCR)});
    }

    private void aML() {
        if (bh.ov(this.aAM)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            return;
        }
        this.mIc = new b(this, this.aAM, this.fCR);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(this.intent)), this.aAM, Integer.valueOf(this.fCR)});
        b bVar = this.mIc;
        if (bh.ov(bVar.fpz)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            bVar.activity.finish();
        }
        bVar.activity.getIntent().putExtra("free_wifi_url", bVar.fpz);
        bVar.activity.getIntent().putExtra("free_wifi_ap_key", bVar.fpz);
        if (bh.ov(bVar.fpz)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            bVar.activity.finish();
            return;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[]{m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), bVar.fpz, Integer.valueOf(bVar.fCR)});
        a aLe = k.aLe();
        aLe.fpz = bVar.fpz;
        aLe.mCu = m.D(bVar.intent);
        aLe.mCw = b.mCE.mDi;
        aLe.mCx = b.mCE.name;
        aLe.fCR = bVar.fCR;
        aLe.mCv = m.F(bVar.intent);
        aLe.aLg().b(bVar.intent, false).aLf();
        new com.tencent.mm.plugin.freewifi.d.a(bVar.fpz, bVar.fCR, m.D(bVar.intent)).v(bVar.activity).b(new b$1(bVar));
    }

    protected final int getLayoutId() {
        return R.i.diB;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mIc != null) {
            this.mIc = null;
        }
        this.fhK.TG();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
