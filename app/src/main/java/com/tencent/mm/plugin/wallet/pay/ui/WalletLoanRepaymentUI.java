package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.m.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String mzr;
    private double pKW;
    private String paz = "CNY";
    private String sEY;
    private String sEZ;
    private String sFa;
    private String sFb;
    private String sFc;
    private String sFd;
    private String sFe;
    private String sFf;
    private int sFg;
    protected m szh;
    private String token;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.sFd = intent.getStringExtra("appId");
        this.sEY = intent.getStringExtra("timeStamp");
        this.sEZ = intent.getStringExtra("nonceStr");
        this.sFa = intent.getStringExtra("packageExt");
        this.sFb = intent.getStringExtra("signtype");
        this.sFc = intent.getStringExtra("paySignature");
        this.sFe = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.sFg = intent.getIntExtra("pay_channel", 0);
        ji(580);
        r(new com.tencent.mm.plugin.wallet_core.c.a(this.sFd, this.sEY, this.sEZ, this.sFa, this.sFb, this.sFc, this.sFe, 7, "getWebPayCheckoutCounterRequst", this.sFg));
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void MN(String str) {
        b(new b(str), true);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
                this.token = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).bhV();
                MN(this.token);
                return true;
            } else if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.paz = bVar.paz;
                this.pKW = bVar.pKW;
                this.desc = bVar.desc;
                ad bLr = o.bLr();
                if (bLr.bLB()) {
                    Bankcard bLC = bLr.bLC();
                    if (bLC == null || !bh.ov(bLC.field_forbidWord)) {
                        bKc();
                    } else {
                        a(bLC, this.pKW, this.paz);
                    }
                } else {
                    h.a(this, getResources().getString(i.uSm), "", getString(i.uUs), getString(i.dEn), new 4(this), new 5(this));
                }
                return true;
            } else if (kVar instanceof s) {
                s sVar = (s) kVar;
                if (sVar.bKI()) {
                    x.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.mzr);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", sVar.sIG);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", sVar.sIF);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.k.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", sVar.sID);
                    intent.putExtra("bind_serial", this.sFf);
                    setResult(-1, intent);
                    finish();
                }
                return true;
            }
        }
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        c 1 = new 1(this);
        OnClickListener 2 = new 2(this);
        OnCancelListener 3 = new 3(this);
        this.sFf = bankcard.field_bindSerial;
        this.szh = m.a(this, this.desc, d, str, bankcard, 1, 2, 3);
    }

    private void bKc() {
        x.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    }

    protected final void bKd() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new 6(this));
    }

    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        x.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            MN(this.token);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.sFf);
            setResult(-1, intent2);
            finish();
        } else {
            x.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", DownloadResult.CODE_UNDEFINED);
            if (intExtra == -1003) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                bKd();
            } else if (intExtra == 0) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                r0 = o.bLr().MW(intent.getStringExtra("bindSerial"));
                if (r0 == null) {
                    x.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    return;
                }
                a(r0, this.pKW, this.paz);
            } else {
                x.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
            }
        } else {
            ad bLr = o.bLr();
            if (bLr.bLB()) {
                r0 = bLr.bLC();
                if (r0 == null || !bh.ov(r0.field_forbidWord)) {
                    finish();
                    return;
                } else {
                    a(r0, this.pKW, this.paz);
                    return;
                }
            }
            x.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
