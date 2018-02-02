package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private o omB = new o();
    private PayInfo pCn = new PayInfo();
    private boolean sCL = false;
    private String sCM;
    private int sCN = -1;
    private com.tencent.mm.plugin.wallet_core.c.a sCO = null;
    private boolean sCP = false;
    c sCQ = new 3(this);
    private String token = null;

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        ji(580);
        this.omB.sWX = new 1(this);
        this.sCM = getIntent().getStringExtra("key_import_key");
        this.sCN = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i = getIntent().getIntExtra("key_bind_scene", 13);
        }
        b suVar = new su();
        if (i == 4) {
            suVar.fKE.scene = 20;
        } else {
            suVar.fKE.scene = 13;
        }
        suVar.fqI = new 2(this);
        com.tencent.mm.sdk.b.a.xef.m(suVar);
        com.tencent.mm.sdk.b.a.xef.b(this.sCQ);
        p.ft(6, 0);
    }

    private void bJJ() {
        this.pCn.fCW = this.sCN;
        this.vf.putParcelable("key_pay_info", this.pCn);
        if (this.sCN == 2) {
            if (bh.ov(this.sCM)) {
                yE("");
                return;
            }
            x.d("MicroMsg.WalletBindUI", "importKey " + this.sCM);
            r(new com.tencent.mm.plugin.wallet.bind.a.c(this.sCM, this.pCn));
        } else if (this.sCN == 4) {
            com.tencent.mm.wallet_core.c.o.Hz(4);
            if (getIntent() == null) {
                yE("");
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int intExtra = getIntent().getIntExtra("pay_channel", 0);
            if (this.sCN == 6) {
                this.sCO = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.sCO = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            r(this.sCO);
        } else if (this.sCN == 6) {
            bJK();
        } else {
            zd(this.sCN);
        }
    }

    private void zd(int i) {
        x.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bh.cgy().toString());
        Bundle bundle = this.vf;
        bundle.putParcelable("key_pay_info", this.pCn);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (com.tencent.mm.plugin.wallet.a.p.bJO().bLL()) {
            x.i("MicroMsg.WalletBindUI", "user status invalid");
            if (i == 4) {
                r(new com.tencent.mm.plugin.wallet_core.c.x(null, 20));
                return;
            } else {
                r(new com.tencent.mm.plugin.wallet_core.c.x(null, 12));
                return;
            }
        }
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (com.tencent.mm.plugin.wallet.a.p.bJO().bLM()) {
            x.i("MicroMsg.WalletBindUI", "user status reg");
            this.sCL = true;
            this.pCn.fCW = this.sCN;
            bundle.putInt("key_bind_scene", this.pCn.fCW);
            if (!bh.ov(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
            return;
        }
        x.i("MicroMsg.WalletBindUI", "user status unreg");
        this.sCL = true;
        if (this.sCN >= 0) {
            this.pCn.fCW = this.sCN;
        } else {
            this.pCn.fCW = 1;
        }
        bundle.putInt("key_bind_scene", this.pCn.fCW);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
    }

    private void bJK() {
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (com.tencent.mm.plugin.wallet.a.p.bJO().bLL()) {
            r(new com.tencent.mm.plugin.wallet_core.c.x(null, 12));
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!bh.ov(str) && split.length >= 2) {
            String str2 = null;
            str = null;
            for (String str3 : split) {
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
            }
            if (!(bh.ov(str) || bh.ov(str2))) {
                com.tencent.mm.plugin.wallet.a.p.bJN();
                if (com.tencent.mm.plugin.wallet.a.p.bJO().MX(str2)) {
                    Bundle bundle = new Bundle();
                    Object bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", bundle, null);
                    return;
                }
            }
        }
        finish();
    }

    public void onResume() {
        if (this.sCL) {
            finish();
        }
        super.onResume();
        this.omB.onResume();
    }

    public void onPause() {
        super.onPause();
        this.omB.onPause();
    }

    public void onDestroy() {
        jj(580);
        com.tencent.mm.sdk.b.a.xef.c(this.sCQ);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.omB.aYr();
            return;
        }
        this.omB.cancel();
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            this.sCL = true;
        }
        if (i != 0 || i2 != 0) {
            yE(str);
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
            if (this.sCN == 6) {
                bJK();
            } else {
                bJJ();
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            com.tencent.mm.plugin.wallet.bind.a.c cVar = (com.tencent.mm.plugin.wallet.bind.a.c) kVar;
            Bundle bundle = this.vf;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.szk == null || cVar.szk.size() <= 0) {
                if (bh.ov(str)) {
                    str = getString(i.uPR);
                }
                h.a(this, str, null, false, new 6(this));
            } else {
                Bankcard bankcard = (Bankcard) cVar.szk.get(0);
                if (bankcard.sLm) {
                    h.a(this, i.uQs, 0, false, new 5(this));
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.sBO);
                    bundle.putString("key_recommand_desc", cVar.sBP);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.sCL = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, new 4(this));
                }
            }
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                if (this.sCO == null || !this.sCO.equals(kVar)) {
                    com.tencent.mm.wallet_core.c.o.cBv();
                } else {
                    f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
                    this.token = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).bhV();
                    zd(4);
                    return true;
                }
            }
            return false;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.sCL);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.sCL = bundle.getBoolean("key_is_jump", false);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean aYj() {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            return;
        }
        super.onNewIntent(intent);
        x.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            x.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            x.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
    }

    private void yE(String str) {
        if (bh.ov(str)) {
            str = getString(i.uXa);
        }
        h.a(this, str, null, false, new 7(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
