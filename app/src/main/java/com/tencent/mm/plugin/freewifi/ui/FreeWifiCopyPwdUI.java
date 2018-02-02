package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int mGS = 111;
    private String appId;
    private int fdS;
    private String fpz;
    private af hae = new 4(this);
    private Intent intent;
    private int mFb;
    private int mGT = 1;
    private int mGU = 2;
    protected TextView mGV;
    protected TextView mGW;
    protected TextView mGX;
    private String ssid;

    public static class a {
        public static a mHa = new a();
        private int jCk;
        String mHb;
        String text;
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, b bVar) {
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        freeWifiCopyPwdUI.hae.sendMessage(obtain);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof ei) {
            com.tencent.mm.plugin.freewifi.k.a aLe;
            ei eiVar = (ei) obj;
            Intent intent = freeWifiCopyPwdUI.getIntent();
            intent.putExtra("free_wifi_appid", eiVar.nkv);
            intent.putExtra("free_wifi_app_nickname", eiVar.kub);
            intent.putExtra("free_wifi_app_username", eiVar.ksU);
            intent.putExtra("free_wifi_signature", eiVar.hvw);
            intent.putExtra("free_wifi_finish_actioncode", eiVar.vJH);
            intent.putExtra("free_wifi_finish_url", eiVar.vJI);
            intent.putExtra(c.xEk, eiVar.mIC);
            if (eiVar.vJH == 2) {
                if (bh.ov(eiVar.ksU)) {
                    intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", eiVar.ksU);
                    d.b(freeWifiCopyPwdUI, "profile", ".ui.ContactInfoUI", intent2);
                    d.wW();
                    x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent()))});
                    aLe = k.aLe();
                    aLe.fpz = freeWifiCopyPwdUI.fpz;
                    aLe.mCu = m.D(intent);
                    aLe.mCw = b.mCW.mDi;
                    aLe.mCx = b.mCW.name;
                    aLe.fCR = m.G(intent);
                    aLe.mCv = m.F(intent);
                    aLe.result = 0;
                    aLe.kZo = "";
                    aLe.aLg().b(intent, true).aLf();
                    return;
                }
            } else if (m.AA(eiVar.vJJ)) {
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", eiVar.vJJ);
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccWebViewUI.class);
            }
            aLe = k.aLe();
            aLe.fpz = freeWifiCopyPwdUI.fpz;
            aLe.mCu = m.D(intent);
            aLe.mCw = b.mCV.mDi;
            aLe.mCx = b.mCV.name;
            aLe.fCR = m.G(intent);
            aLe.mCv = m.F(intent);
            aLe.result = 0;
            aLe.kZo = "";
            aLe.aLg().b(intent, true).aLf();
            freeWifiCopyPwdUI.finish();
            freeWifiCopyPwdUI.startActivity(intent);
            d.wW();
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent()))});
        }
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.D(freeWifiCopyPwdUI.intent), Integer.valueOf(m.E(freeWifiCopyPwdUI.intent)), aVar.mHb});
            freeWifiCopyPwdUI.mGV.setVisibility(0);
            if (m.AA(aVar.text)) {
                if (aVar.jCk == 0) {
                    aVar.jCk = R.l.ejA;
                }
                string = freeWifiCopyPwdUI.getString(aVar.jCk);
            } else {
                string = aVar.text;
            }
            freeWifiCopyPwdUI.mGV.setText(string);
            freeWifiCopyPwdUI.mGV.setVisibility(0);
            freeWifiCopyPwdUI.mGW.setVisibility(0);
            freeWifiCopyPwdUI.mGX.setVisibility(0);
            freeWifiCopyPwdUI.mGX.setOnClickListener(new 5(freeWifiCopyPwdUI, freeWifiCopyPwdUI.getString(R.l.ejL) + ": " + aVar.mHb));
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.D(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.E(freeWifiCopyPwdUI.getIntent()))});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.fpz = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.fdS = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.mFb = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.h.cjF)).setText(this.ssid);
        com.tencent.mm.pluginsdk.h.c.a(this.mController.xIM, "wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.h.cjp)).setOnClickListener(new 2(this));
        this.mGV = (TextView) findViewById(R.h.cjr);
        this.mGW = (TextView) findViewById(R.h.cjq);
        this.mGX = (TextView) findViewById(R.h.cjs);
        String aLF = com.tencent.mm.plugin.freewifi.model.d.aLF();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        g.pQN.h(12651, new Object[]{Integer.valueOf(6), aLF, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == mGS && m.aLl() && !com.tencent.pb.common.c.g.isNullOrEmpty(this.ssid) && this.ssid.equals(com.tencent.mm.plugin.freewifi.model.d.aLG())) {
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent))});
            com.tencent.mm.plugin.freewifi.k.a aLe = k.aLe();
            aLe.ssid = this.ssid;
            aLe.bssid = m.AE("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aLe.fpA = m.AF("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aLe.fpz = this.fpz;
            aLe.mCt = this.appId;
            aLe.mCu = m.D(this.intent);
            aLe.mCv = m.F(this.intent);
            aLe.mCw = b.mCH.mDi;
            aLe.mCx = b.mCH.name;
            aLe.result = 0;
            aLe.fCR = m.G(this.intent);
            aLe.aLg().aLf();
            m.a(this.intent, this.fpz, this.mFb, this.fdS, new com.tencent.mm.plugin.freewifi.m.a(this) {
                final /* synthetic */ FreeWifiCopyPwdUI mGY;

                {
                    this.mGY = r1;
                }

                public final void i(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI;
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
                    int c;
                    a aVar;
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                            ei aMc = ((com.tencent.mm.plugin.freewifi.d.a) kVar).aMc();
                            if (aMc != null) {
                                x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw, aMc.vJJ});
                                FreeWifiCopyPwdUI.a(this.mGY, new b(this.mGY, this.mGY.mGT, aMc));
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                            freeWifiCopyPwdUI = this.mGY;
                            freeWifiCopyPwdUI2 = this.mGY;
                            c = this.mGY.mGU;
                            aVar = new a();
                            aVar.mHb = m.a(this.mGY.mFb, b.mCJ, 21);
                            FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                        }
                    } else if (!m.cA(i, i2) || m.AA(str)) {
                        freeWifiCopyPwdUI = this.mGY;
                        freeWifiCopyPwdUI2 = this.mGY;
                        c = this.mGY.mGU;
                        aVar = new a();
                        aVar.mHb = m.a(this.mGY.mFb, b.mCJ, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    } else {
                        freeWifiCopyPwdUI = this.mGY;
                        freeWifiCopyPwdUI2 = this.mGY;
                        c = this.mGY.mGU;
                        aVar = new a();
                        aVar.text = str;
                        aVar.mHb = m.a(this.mGY.mFb, b.mCJ, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
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
        l.r(com.tencent.mm.plugin.freewifi.model.d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a aLe = k.aLe();
        aLe.fpz = this.fpz;
        aLe.mCu = m.D(this.intent);
        aLe.mCw = b.mDh.mDi;
        aLe.mCx = b.mDh.name;
        aLe.fCR = m.G(this.intent);
        aLe.mCv = m.F(this.intent);
        aLe.result = 0;
        aLe.kZo = "";
        aLe.aLg().b(this.intent, true).aLf();
        com.tencent.mm.plugin.freewifi.g.ifs.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dix;
    }
}
