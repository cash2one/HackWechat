package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import com.tencent.mm.plugin.freewifi.e.a;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.e;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int cOY;
    protected String className;
    protected String fFm;
    protected int fdS;
    protected String fpz;
    private final c hDn;
    private af hae = new 1(this);
    protected Intent intent;
    protected String mFa;
    protected int mFb;
    protected String mFc;
    protected TextView mGV;
    protected TextView mGW;
    protected TextView mGX;
    protected ImageView mHi;
    protected TextView mHj;
    protected TextView mHk;
    protected Button mHl;
    protected Button mHm;
    protected Dialog mHn;
    protected View mHo;
    protected String mHp;
    protected String mHq;
    protected String mHr;
    protected String mHs;
    protected a mHt;
    private Lock mHu;
    private d mHv;
    protected String ssid;

    public FreeWifiFrontPageUI() {
        c.a aVar = new c.a();
        aVar.hDy = true;
        aVar.hDz = true;
        aVar.hDP = R.g.bCj;
        aVar.hDY = true;
        aVar.hDZ = 0.0f;
        this.hDn = aVar.PK();
    }

    private d aMB() {
        try {
            this.mHu.lock();
            d dVar = this.mHv;
            return dVar;
        } finally {
            this.mHu.unlock();
        }
    }

    public final void a(d dVar, Object obj) {
        try {
            this.mHu.lock();
            this.mHv = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.hae.sendMessage(obtain);
        } finally {
            this.mHu.unlock();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        switch (this.mFb) {
            case 1:
                this.mHt = new g(this);
                break;
            case 4:
                this.mHt = new f(this);
                break;
            case 31:
                this.mHt = new h(this);
                this.mHo.setVisibility(0);
                aMC();
                break;
            case 32:
                this.mHt = new j(this);
                this.mHo.setVisibility(0);
                break;
            case 33:
                this.mHt = new i(this);
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, this.fpz});
        l.p(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        setBackBtn(new 2(this));
        if (this.mHn != null) {
            this.mHn.dismiss();
        }
        this.mHu = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mFa = getIntent().getStringExtra("free_wifi_url");
        this.fpz = getIntent().getStringExtra("free_wifi_ap_key");
        this.cOY = getIntent().getIntExtra("free_wifi_source", 1);
        this.fdS = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.mFb = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.fFm = getIntent().getStringExtra("free_wifi_appid");
        this.mHp = getIntent().getStringExtra("free_wifi_head_img_url");
        this.mHq = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.mHr = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mHs = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mFc = getIntent().getStringExtra("free_wifi_app_nickname");
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, this.ssid, this.mFa, this.fpz, Integer.valueOf(this.cOY), Integer.valueOf(this.fdS), Integer.valueOf(this.mFb), this.fFm, this.mHp, this.mHq, this.mHs});
        this.mHo = findViewById(R.h.cUl);
        this.mHi = (ImageView) findViewById(R.h.cjh);
        this.mHj = (TextView) findViewById(R.h.cjT);
        this.mHk = (TextView) findViewById(R.h.cjG);
        this.mGV = (TextView) findViewById(R.h.cjo);
        this.mGW = (TextView) findViewById(R.h.cjm);
        this.mGX = (TextView) findViewById(R.h.cjn);
        this.mHl = (Button) findViewById(R.h.bWZ);
        this.mHl.setOnClickListener(new 3(this));
        this.mHm = (Button) findViewById(R.h.cUm);
        this.mHm.setOnClickListener(new 4(this));
        if (bh.ov(this.ssid)) {
            this.mHk.setText(getString(R.l.eka));
            this.mHl.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekc));
        a(d.mHA, null);
    }

    private void aMC() {
        l.q(d.aLF(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d aMB = aMB();
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, aMB.name()});
        if (aMB() == d.mHA || aMB() == d.mHC) {
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.aLk())});
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.mFb != 33) {
                com.tencent.mm.ui.base.h.a(this, R.l.ejw, R.l.ejx, new 5(this), null);
                return;
            }
            this.mHv = d.mHB;
            aME();
            this.mHt.connect();
        }
    }

    protected final void aMD() {
        this.mGV.setVisibility(4);
        if (this.mFb == 31) {
            this.mHl.setVisibility(8);
        } else {
            this.mHl.setVisibility(0);
            this.mHl.setText(R.l.dUp);
        }
        if (!(m.G(getIntent()) != 10 || m.AA(q.gFZ.gGv) || m.AA(q.aI(this.mController.xIM)))) {
            this.mHl.setText(String.format(getString(R.l.ejy), new Object[]{q.aI(this.mController.xIM)}));
        }
        if (!bh.ov(this.mHr)) {
            this.mHk.setText(this.mHr);
        } else if (this.mFb == 33) {
            this.mHk.setText(getString(R.l.dUl) + ": " + this.ssid);
        } else {
            this.mHk.setText(getString(R.l.dUl));
        }
        if (!bh.ov(this.fFm)) {
            if (!bh.ov(this.mFc)) {
                this.mHj.setText(this.mFc);
            }
            if (!bh.ov(this.mHp)) {
                o.PA().a(this.mHp, this.mHi, this.hDn);
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
    }

    protected final void aME() {
        this.mGV.setVisibility(4);
        this.mGW.setVisibility(4);
        this.mGX.setVisibility(4);
        this.mHl.setText(R.l.dUm);
        Context context = this.mController.xIM;
        OnCancelListener 6 = new 6(this);
        View inflate = View.inflate(context, R.i.diE, null);
        Dialog kVar = new k(context, R.m.eYL);
        kVar.setCancelable(true);
        kVar.setContentView(inflate);
        kVar.setOnCancelListener(6);
        this.mHn = kVar;
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
        this.mHn.show();
    }

    protected final void br(Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.D(this.intent), Integer.valueOf(m.E(this.intent)), a.a(aVar)});
            if (this.mHn != null) {
                this.mHn.dismiss();
            }
            this.mGV.setVisibility(0);
            if (m.AA(a.b(aVar))) {
                if (a.c(aVar) == 0) {
                    a.a(aVar, R.l.ejA);
                }
                string = getString(a.c(aVar));
            } else {
                string = a.b(aVar);
            }
            this.mGV.setText(string);
            this.mGV.setVisibility(0);
            this.mGW.setVisibility(0);
            this.mGX.setVisibility(0);
            final String str = getString(R.l.ejL) + ": " + a.a(aVar);
            this.mGX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FreeWifiFrontPageUI mHw;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", this.mHw.getString(R.l.ejz));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(this.mHw, FreeWifiErrorUI.class);
                    this.mHw.startActivity(intent);
                }
            });
            this.mHl.setVisibility(0);
            this.mHl.setText(R.l.ejY);
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
        }
    }

    protected final void bs(Object obj) {
        if (obj instanceof b) {
            com.tencent.mm.plugin.freewifi.k.a aLe;
            ei eiVar = ((b) obj).mHz;
            if (!(this.mFb == 31 || this.mHn == null)) {
                this.mHn.dismiss();
            }
            this.mHl.setText(R.l.dUj);
            this.mHl.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", eiVar.nkv);
            intent.putExtra("free_wifi_app_nickname", eiVar.kub);
            intent.putExtra("free_wifi_app_username", eiVar.ksU);
            intent.putExtra("free_wifi_signature", eiVar.hvw);
            intent.putExtra("free_wifi_finish_actioncode", eiVar.vJH);
            intent.putExtra("free_wifi_finish_url", eiVar.vJI);
            intent.putExtra(e.c.xEk, eiVar.mIC);
            if (eiVar.vJH == 2) {
                if (bh.ov(eiVar.ksU)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", eiVar.ksU);
                    com.tencent.mm.bm.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    d.wW();
                    x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
                    aLe = com.tencent.mm.plugin.freewifi.k.aLe();
                    aLe.fpz = this.fpz;
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
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", eiVar.vJJ);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            aLe = com.tencent.mm.plugin.freewifi.k.aLe();
            aLe.fpz = this.fpz;
            aLe.mCu = m.D(intent);
            aLe.mCw = b.mCV.mDi;
            aLe.mCx = b.mCV.name;
            aLe.fCR = m.G(intent);
            aLe.mCv = m.F(intent);
            aLe.result = 0;
            aLe.kZo = "";
            aLe.aLg().b(intent, true).aLf();
            finish();
            startActivity(intent);
            d.wW();
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.D(getIntent()), Integer.valueOf(m.E(getIntent()))});
        }
    }

    public void finish() {
        super.finish();
        com.tencent.mm.plugin.freewifi.k.a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.fpz = this.fpz;
        aLe.mCu = m.D(this.intent);
        aLe.mCw = b.mCT.mDi;
        aLe.mCx = b.mCT.name;
        aLe.fCR = m.G(this.intent);
        aLe.mCv = m.F(this.intent);
        aLe.result = 0;
        aLe.kZo = "";
        aLe.aLg().b(this.intent, true).aLf();
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
        com.tencent.mm.plugin.freewifi.k.a aLe = com.tencent.mm.plugin.freewifi.k.aLe();
        aLe.fpz = this.fpz;
        aLe.mCu = m.D(this.intent);
        aLe.mCw = b.mCU.mDi;
        aLe.mCx = b.mCU.name;
        aLe.fCR = m.G(this.intent);
        aLe.mCv = m.F(this.intent);
        aLe.result = 0;
        aLe.kZo = "";
        aLe.aLg().b(this.intent, true).aLf();
        com.tencent.mm.plugin.freewifi.g.ifs.i(new Intent(), this);
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aLR().release();
    }
}
