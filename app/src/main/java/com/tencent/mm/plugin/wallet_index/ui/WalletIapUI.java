package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.z.q;

@a(7)
public class WalletIapUI extends MMActivity implements e {
    private Dialog jLV;
    private c pfJ = new 4(this);
    private c taB;
    private d taD = new 3(this);
    private boolean tbe = false;
    private b tbf;
    private d tbg = new 2(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.v("MicroMsg.WalletIapUI", "onCreate");
        g.Dk();
        g.Di().gPJ.a(422, (e) this);
        g.Dk();
        g.Di().gPJ.a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, (e) this);
        g.Dk();
        g.Di().gPJ.a(1130, (e) this);
        g.Dk();
        g.Di().gPJ.a(1306, (e) this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            this.jLV = com.tencent.mm.wallet_core.ui.g.a(this, getString(i.dHc), true, new 1(this));
        }
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_mini_program", false);
        this.taB = new c();
        this.taB.taO = booleanExtra;
        if (getIntent().getBooleanExtra("key_force_google", false) || q.Ge()) {
            x.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.tbf = new a(this, this.taB, this.taD);
        } else {
            x.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.tbf = new f(this.taB, this.pfJ);
        }
        this.taB.pcE = this.tbf.bNm();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        x.d("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        x.d("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.tbe) {
            this.tbe = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                x.d("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.tbf.c(this, true);
                return;
            }
            c cVar = this.taB;
            String stringExtra = intent.getStringExtra("key_product_id");
            cVar.lyH = stringExtra;
            cVar.taN.add(stringExtra);
            x.d("MicroMsg.IapData", "prepare pay product: " + stringExtra);
            this.taB.tak = intent.getStringExtra("key_price");
            this.taB.taj = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.taB.mCount = intent.getIntExtra("key_count", 1);
            stringExtra = intent.getStringExtra("key_appid");
            String stringExtra3 = intent.getStringExtra("key_desc");
            String stringExtra4 = intent.getStringExtra("key_busiid");
            this.taB.taP = intent.getStringExtra("key_virtual_pay_sign");
            this.taB.taQ = intent.getStringExtra("key_attach");
            g.Dk();
            n nVar = g.Di().gPJ;
            c cVar2 = this.taB;
            int bNm = this.tbf.bNm();
            nVar.a(cVar2.taO ? new d(bNm, stringExtra, cVar2.tak, stringExtra3, cVar2.mCount, cVar2.taj, stringExtra4, cVar2.taP, cVar2.taQ) : new j(cVar2.lyH, cVar2.tak, cVar2.taj, cVar2.mCount, bNm, stringExtra2), 0);
        }
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        x.d("MicroMsg.WalletIapUI", "onDestroy");
        if (this.jLV != null && this.jLV.isShowing()) {
            this.jLV.dismiss();
            this.jLV = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : " + i2);
        if (this.tbf != null) {
            this.tbf.a((MMActivity) this, i, i2, intent);
            x.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            return;
        }
        x.e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(6, "");
        intent2.putExtra("key_err_code", aL.nAh);
        intent2.putExtra("key_err_msg", aL.mMessage);
        intent2.putExtra("key_launch_ts", a.taC);
        setResult(-1, intent2);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        alb com_tencent_mm_protocal_c_alb = null;
        boolean z = true;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd ErrType:" + i + ", errCode:" + i2 + ",errMsg:" + str);
        com.tencent.mm.plugin.wallet_index.c.a aL = com.tencent.mm.plugin.wallet_index.c.a.aL(i2, str);
        int i3 = aL.nAh;
        String str2 = aL.mMessage;
        x.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + kVar.getType() + " errCode:" + i3 + ",errMsg:" + str2);
        int type = kVar.getType();
        Intent intent;
        switch (type) {
            case com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX /*414*/:
            case 1306:
                boolean z2;
                c cVar = this.taB;
                if (kVar instanceof com.tencent.mm.wallet_core.c.k) {
                    com.tencent.mm.wallet_core.c.k kVar2 = (com.tencent.mm.wallet_core.c.k) kVar;
                    cVar.lyH = kVar2.lyH;
                    cVar.taL = kVar2.lyJ;
                    cVar.taM = kVar2.taM;
                    z2 = false;
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.g) {
                    com.tencent.mm.plugin.wallet_index.c.g gVar = (com.tencent.mm.plugin.wallet_index.c.g) kVar;
                    cVar.lyH = gVar.fqV;
                    z2 = gVar.errCode == 0;
                } else {
                    z2 = false;
                }
                cVar.taN.remove(cVar.lyH);
                if (z2) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lyH + " OK");
                    cVar.taJ.add(cVar.lyH);
                    cVar.taK.add(cVar.taL);
                } else if (!cVar.lyH.startsWith("com.tencent.xin.wco")) {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lyH + " fail");
                } else if (cVar.taM > 0) {
                    cVar.taJ.add(cVar.lyH);
                    cVar.taK.add(cVar.taL);
                    x.i("MicroMsg.IapData", "Verify " + cVar.lyH + " fail and cosume");
                    if (this.taB.taN.isEmpty()) {
                        x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                        if (this.taB.taJ.isEmpty()) {
                            x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.taB.taJ.size() + ", Consume ...");
                            this.tbf.a((MMActivity) this, this.taB.taJ, this.taD, z);
                            return;
                        }
                        x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", a.taC);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    return;
                } else {
                    x.i("MicroMsg.IapData", "Verify " + cVar.lyH + " fail");
                }
                z = false;
                if (this.taB.taN.isEmpty()) {
                    x.d("MicroMsg.WalletIapUI", "Verify All End... ");
                    if (this.taB.taJ.isEmpty()) {
                        x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                        intent = new Intent();
                        intent.putExtra("key_err_code", i3);
                        intent.putExtra("key_err_msg", str2);
                        intent.putExtra("key_response_position", 3);
                        intent.putExtra("key_launch_ts", a.taC);
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    x.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.taB.taJ.size() + ", Consume ...");
                    this.tbf.a((MMActivity) this, this.taB.taJ, this.taD, z);
                    return;
                }
                return;
            case 422:
            case 1130:
                c cVar2 = this.taB;
                com.tencent.mm.plugin.wallet_index.c.a aL2 = com.tencent.mm.plugin.wallet_index.c.a.aL(i3, str2);
                type = aL2.nAh;
                if (kVar instanceof j) {
                    j jVar = (j) kVar;
                    if (type == 0) {
                        axy com_tencent_mm_protocal_c_axy;
                        if (cVar2.bNn()) {
                            alc com_tencent_mm_protocal_c_alc;
                            com_tencent_mm_protocal_c_axy = (axy) jVar.gJQ.hmh.hmo;
                            if (com_tencent_mm_protocal_c_axy != null) {
                                alc com_tencent_mm_protocal_c_alc2 = new alc();
                                com_tencent_mm_protocal_c_alc2.wsn = com_tencent_mm_protocal_c_axy.wFa;
                                com_tencent_mm_protocal_c_alc2.wso = com_tencent_mm_protocal_c_axy.wFb;
                                com_tencent_mm_protocal_c_alc2.fCV = 5;
                                com_tencent_mm_protocal_c_alc2.wsp = com_tencent_mm_protocal_c_axy.wFc;
                                x.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + com_tencent_mm_protocal_c_axy.wFc);
                                com_tencent_mm_protocal_c_alc = com_tencent_mm_protocal_c_alc2;
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
                                com_tencent_mm_protocal_c_alc = null;
                            }
                            cVar2.tap = com_tencent_mm_protocal_c_alc;
                        } else {
                            com_tencent_mm_protocal_c_axy = (axy) jVar.gJQ.hmh.hmo;
                            if (com_tencent_mm_protocal_c_axy != null) {
                                com_tencent_mm_protocal_c_alb = new alb();
                                com_tencent_mm_protocal_c_alb.wil = jVar.taj;
                                com_tencent_mm_protocal_c_alb.pek = jVar.lyH;
                                com_tencent_mm_protocal_c_alb.pbN = jVar.tak;
                                com_tencent_mm_protocal_c_alb.wsj = com_tencent_mm_protocal_c_axy.wEZ;
                                x.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + com_tencent_mm_protocal_c_axy.wEZ);
                            } else {
                                x.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
                            }
                            cVar2.tao = com_tencent_mm_protocal_c_alb;
                        }
                    }
                } else if (kVar instanceof d) {
                    d dVar = (d) kVar;
                    if (type == 0 && dVar.errCode == 0) {
                        cVar2.tap = dVar.tap;
                        cVar2.tao = dVar.tao;
                        if (cVar2.bNn()) {
                            if (cVar2.tap != null) {
                                cVar2.taG = cVar2.tap.wsj;
                            } else {
                                x.e("MicroMsg.IapData", "iapWxPayData is null");
                            }
                        } else if (cVar2.tao != null) {
                            cVar2.taG = cVar2.tao.wsj;
                        } else {
                            x.e("MicroMsg.IapData", "iapGoogleData is null");
                        }
                    }
                }
                if (aL2.nAh == 0) {
                    this.tbf.a(this, this.tbg);
                    return;
                }
                x.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + aL2.nAh + " , errMsg: " + aL2.mMessage);
                intent = new Intent();
                intent.putExtra("key_err_code", aL2.nAh);
                intent.putExtra("key_err_msg", aL2.mMessage);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                return;
            default:
                x.w("MicroMsg.WalletIapUI", "get a wrong sceneType : " + type);
                return;
        }
    }

    public void finish() {
        x.i("MicroMsg.WalletIapUI", "finish");
        if (this.jLV != null && this.jLV.isShowing()) {
            this.jLV.dismiss();
            this.jLV = null;
        }
        if (this.tbf != null) {
            this.tbf.g(this);
        }
        g.Dk();
        g.Di().gPJ.b(422, (e) this);
        g.Dk();
        g.Di().gPJ.b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, (e) this);
        g.Dk();
        g.Di().gPJ.b(1130, (e) this);
        g.Dk();
        g.Di().gPJ.b(1306, (e) this);
        super.finish();
    }
}
