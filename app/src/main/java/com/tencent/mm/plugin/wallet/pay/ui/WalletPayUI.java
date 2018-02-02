package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet.pay.a.c.b;
import com.tencent.mm.plugin.wallet.pay.a.c.d;
import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class WalletPayUI extends WalletBaseUI implements a.a {
    private static boolean sFx = false;
    public int mCount = 0;
    public String mzL = null;
    protected com.tencent.mm.plugin.wallet.a pLQ = null;
    private String pMj;
    public Button pNB;
    public Orders pPl = null;
    private c sEF = null;
    public PayInfo sEO = null;
    public FavorPayInfo sEQ = null;
    private a sER;
    com.tencent.mm.plugin.wallet_core.ui.c sES;
    private com.tencent.mm.sdk.b.c sET = new 1(this);
    private boolean sFA = false;
    public boolean sFB = false;
    protected boolean sFC = false;
    protected String sFD = "";
    protected boolean sFE = false;
    public Bundle sFF = null;
    protected boolean sFG = false;
    protected TextView sFH;
    protected TextView sFI;
    private TextView sFJ;
    protected TextView sFK;
    protected TextView sFL;
    protected TextView sFM;
    protected ImageView sFN;
    private TextView sFO;
    private TextView sFP;
    protected LinearLayout sFQ;
    protected a sFR;
    private long sFS = 0;
    private TextView sFT;
    private LinearLayout sFU;
    private boolean sFV = true;
    private boolean sFW = false;
    private boolean sFX = false;
    private boolean sFY = false;
    private boolean sFZ = false;
    protected com.tencent.mm.plugin.wallet_core.ui.a sFy = null;
    private boolean sFz = false;
    private int sGa = -1;
    private boolean sGb = false;
    private boolean sGc = false;
    private e sGd;
    private boolean sGe = false;
    private boolean sGf = false;
    private long sGg = 0;
    public m szh;
    public ArrayList<Bankcard> szk = null;
    public Bankcard szl = null;

    static /* synthetic */ void d(WalletPayUI walletPayUI) {
        Bundle bundle = new Bundle();
        if (walletPayUI.pPl != null) {
            bundle.putString("key_reqKey", walletPayUI.pPl.fuH);
            if (walletPayUI.pPl.sNW != null && walletPayUI.pPl.sNW.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.pPl.sNW.get(0)).fuI);
            }
            bundle.putLong("key_SessionId", walletPayUI.sFS);
        }
        if (walletPayUI.sEO != null) {
            bundle.putInt("key_scene", walletPayUI.sEO.fCV);
        }
        if (walletPayUI.sEO == null || walletPayUI.sEO.fCV != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putBoolean("key_is_oversea", !walletPayUI.bKn());
        com.tencent.mm.wallet_core.a.a((Activity) walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (sFx) {
            x.w("MicroMsg.WalletPayUI", "has Undestory WalletPayUI!");
            finish();
        }
        sFx = true;
        if (g.Dh().Cy()) {
            getWindow().getDecorView().postDelayed(new 12(this), 600);
            this.sGg = bh.Wp();
            com.tencent.mm.sdk.b.a.xef.b(this.sET);
            i.i(this, 5);
            this.pLQ = com.tencent.mm.plugin.wallet.a.X(getIntent());
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uUZ);
            this.sEO = bKt();
            this.sFC = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.sFD = bh.az(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.pMj = getIntent().getStringExtra("key_receiver_true_name");
            if (this.sEO == null || this.sEO.vzB == 0) {
                this.sFS = System.currentTimeMillis();
            } else {
                this.sFS = this.sEO.vzB;
            }
            p.bJN();
            if (!p.bJO().bLM()) {
                t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 1, "");
            }
            if (bKh()) {
                x.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
                finish();
                return;
            }
            x.d("MicroMsg.WalletPayUI", "PayInfo = " + this.sEO);
            if (this.sEO == null || bh.ov(this.sEO.fuH)) {
                String string;
                if (this.sEO == null || bh.ov(this.sEO.fnL)) {
                    string = getString(com.tencent.mm.plugin.wxpay.a.i.uUU);
                } else {
                    string = this.sEO.fnL;
                }
                h.a(this, string, null, false, new 23(this));
            } else {
                bKi();
            }
            initView();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
        finish();
    }

    private boolean bKh() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                x.d("MicroMsg.WalletPayUI", "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                x.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                c(-1, getIntent());
                this.sFA = true;
                return true;
            }
            x.d("MicroMsg.WalletPayUI", "pay cancel");
            c(0, getIntent());
            this.sFA = false;
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            x.i("MicroMsg.WalletPayUI", "hy: pay not end");
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    return true;
                default:
                    return false;
            }
        }
    }

    public void onDestroy() {
        if (this.sER != null) {
            this.sER.bJV();
            this.sER.release();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.sET);
        this.sES = null;
        sFx = false;
        super.onDestroy();
    }

    public void bKi() {
        k kVar;
        int i = 2;
        com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(2), Integer.valueOf(this.sEO.fCV)});
        if (this.sEO.fCV == 11) {
            int i2 = 3;
            if (com.tencent.mm.plugin.wallet.b.a.bKG()) {
                this.pPl = new Orders();
                Commodity commodity = new Commodity();
                commodity.pao = getString(com.tencent.mm.plugin.wxpay.a.i.uPn);
                this.pPl.sNW.add(commodity);
                this.pPl.pNX = this.sEO.vzG;
                this.pPl.paz = "CNY";
                jE(true);
                this.sFG = true;
                return;
            }
        }
        i2 = 2;
        PayInfo payInfo = this.sEO;
        if (payInfo == null || bh.ov(payInfo.fuH)) {
            x.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            kVar = null;
        } else {
            String str = payInfo.fuH;
            x.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[]{str});
            x.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.c.a(payInfo, i2) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.c.g(payInfo, i2) : str.startsWith("sns_ff_") ? new b(payInfo, i2) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.c.c(payInfo, i2) : str.startsWith("sns_") ? new f(payInfo, i2) : str.startsWith("offline_") ? new d(payInfo, i2) : new e(payInfo, i2);
        }
        if (kVar != null) {
            boolean z;
            kVar.gOs = "PayProcess";
            kVar.mgu = this.sFS;
            if (this.sEO.fCV == 6 && this.sEO.vzu == 100) {
                kVar.irz = 100;
            } else {
                kVar.irz = this.sEO.fCV;
            }
            if (this.sEO.vzv) {
                z = true;
            } else {
                z = false;
            }
            super.cCe();
            if (z) {
                i = 1;
            }
            this.zIY.a(kVar, true, i);
        }
    }

    public void onResume() {
        x.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.sGe)});
        if (!this.zIY.aXd()) {
            if (this.szl == null) {
                p.bJN();
                this.szl = p.bJO().a(null, null, bJW(), false);
            } else {
                p.bJN();
                this.szl = p.bJO().a(null, this.szl.field_bindSerial, bJW(), false);
            }
        }
        if (this.sGf) {
            x.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
            this.sGf = false;
        } else if (this.sFB && this.mController.contentView.getVisibility() != 0 && (this.szh == null || !this.szh.isShowing())) {
            x.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.sES != null) {
            this.sES.bMp();
        }
        super.onResume();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFD;
    }

    public void finish() {
        int i = 0;
        cBZ();
        if (!(this.pPl == null || this.pPl.sNW.isEmpty())) {
            getIntent().putExtra("key_trans_id", ((Commodity) this.pPl.sNW.get(0)).fuI);
        }
        if (this.sEO != null) {
            getIntent().putExtra("key_reqKey", this.sEO.fuH);
        }
        if (this.sFA) {
            if (this.pPl != null) {
                getIntent().putExtra("key_total_fee", this.pPl.pNX);
            }
            c(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.sEO == null || this.sEO.fCV != 8 || this.pPl == null)) {
                this.sEO.vzF = 0;
                b(com.tencent.mm.plugin.wallet.pay.a.a.a(bKm(), this.pPl, true), false);
                if (this.sEO.vzx != null) {
                    long j = this.sEO.vzx.getLong("extinfo_key_9");
                    com.tencent.mm.plugin.report.service.g.pQN.h(13956, new Object[]{Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() - j)});
                }
            }
            c(0, getIntent());
            setResult(0, getIntent());
            p.bJN();
            if (p.bJO().bLJ()) {
                t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 18, "");
            } else {
                p.bJN();
                if (p.bJO().bLN()) {
                    if (this.sEO != null) {
                        i = this.sEO.fCV;
                    }
                    t.d(i, this.sEO == null ? "" : this.sEO.fuH, 4, "");
                } else {
                    if (this.sEO != null) {
                        i = this.sEO.fCV;
                    }
                    t.d(i, this.sEO == null ? "" : this.sEO.fuH, 7, "");
                }
            }
        }
        super.finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.szh == null || this.sEO == null || !this.sEO.ncX) {
            aWs();
            showDialog(1000);
        } else {
            finish();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        x.v("MicroMsg.WalletPayUI", "onNewIntent");
        setIntent(intent);
        if (!bKh()) {
            x.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            c(0, getIntent());
            this.sFA = false;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.sFW = true;
            z = true;
        }
        if (z) {
            x.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
            bKi();
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.sFX = true;
        }
        if (z2) {
            x.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
            finish();
        } else {
            x.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
    }

    private void c(int i, Intent intent) {
        com.tencent.mm.sdk.b.b szVar = new sz();
        szVar.fLs.intent = intent;
        szVar.fLs.result = i;
        szVar.fLs.fuH = this.sEO == null ? "" : this.sEO.fuH;
        if (this.sEO != null && i == 0) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.S(this.sEO.fuH, this.sEO.fCV, this.sEO.fCR);
        }
        com.tencent.mm.sdk.b.a.xef.m(szVar);
    }

    protected final void initView() {
        MMScrollView mMScrollView = (MMScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.cYz);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.pNB = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzR);
        this.pNB.setClickable(false);
        this.pNB.setEnabled(false);
        this.sFH = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzI);
        this.sFI = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzH);
        this.sFK = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzr);
        this.sFP = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzp);
        this.sFJ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzx);
        this.sFO = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzO);
        this.sFJ.getPaint().setFlags(16);
        this.sFL = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzS);
        this.sFM = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzP);
        this.sFM.setOnClickListener(new 24(this));
        this.sFN = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzm);
        this.sFN.setOnClickListener(new 25(this));
        this.sFQ = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzu);
        this.sFR = new a(this);
        this.pNB.setOnClickListener(new 26(this));
        this.pNB.setText(com.tencent.mm.plugin.wxpay.a.i.uUq);
        this.sFT = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.utq);
        this.sFU = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.utp);
        au();
    }

    public final void au() {
        boolean z;
        LinearLayout linearLayout;
        if (!(this.pPl == null || this.pPl.sNW == null || this.pPl.sNW.size() <= 0)) {
            this.sFH.setText(com.tencent.mm.wallet_core.ui.e.t(this.pPl.pNX));
            this.sFK.setText(com.tencent.mm.wallet_core.ui.e.aay(this.pPl.paz));
            this.sFR.notifyDataSetChanged();
            if (this.pPl.sNW.size() > 1) {
                this.sFN.setVisibility(0);
                this.sFI.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uVa, new Object[]{((Commodity) this.pPl.sNW.get(0)).desc, this.pPl.sNW.size()}));
            } else {
                this.sFI.setText(((Commodity) this.pPl.sNW.get(0)).desc);
                this.sFN.setVisibility(8);
            }
            this.sFE = false;
            int i = this.pPl.sNG;
        }
        if (this.sEO != null && this.sEO.fCV == 48) {
            this.sFI.setText(com.tencent.mm.plugin.wxpay.a.i.uMz);
        }
        this.sFL.setVisibility(8);
        this.sFM.setVisibility(8);
        this.sFT.setVisibility(8);
        this.sFU.setVisibility(8);
        this.pNB.setText(com.tencent.mm.plugin.wxpay.a.i.uUq);
        if (this.szl == null || !this.szl.bKP()) {
            p.bJN();
            if (p.bJO().bLJ()) {
                bKj();
            }
        } else if (bh.ov(this.szl.field_forbidWord)) {
            p.bJN();
            if (p.bJO().bLN()) {
                bKj();
            }
        } else {
            this.sFL.setText(this.szl.field_forbidWord);
            this.sFL.setVisibility(4);
            this.sFM.setVisibility(8);
            p.bJN();
            if (p.bJO().bLN()) {
                bKj();
            }
        }
        p.bJN();
        if (!p.bJO().bLN()) {
            p.bJN();
            if (!p.bJO().bLJ()) {
                z = false;
                linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzq);
                if (z || this.sEQ == null || this.sFy == null || !this.sFz || this.pPl == null) {
                    linearLayout.setVisibility(8);
                } else {
                    bKl();
                    this.sFP.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI sGh;

                        {
                            this.sGh = r1;
                        }

                        public final void onClick(View view) {
                            t.d(this.sGh.sEO == null ? 0 : this.sGh.sEO.fCV, this.sGh.sEO == null ? "" : this.sGh.sEO.fuH, 12, "");
                            com.tencent.mm.plugin.wallet_core.ui.i.a(this.sGh.mController.xIM, this.sGh.pPl, this.sGh.sEQ.sMT, new 1(this));
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.pPl != null || this.szk == null || this.sEO == null) {
                    this.pNB.setClickable(false);
                    this.pNB.setEnabled(false);
                } else {
                    this.pNB.setClickable(true);
                    this.pNB.setEnabled(true);
                }
                if (this.pPl == null) {
                    this.sFM.setVisibility(8);
                }
            }
        }
        z = true;
        linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzq);
        if (z) {
        }
        linearLayout.setVisibility(8);
        if (this.pPl != null) {
        }
        this.pNB.setClickable(false);
        this.pNB.setEnabled(false);
        if (this.pPl == null) {
            this.sFM.setVisibility(8);
        }
    }

    private void bKj() {
        if (this.pPl == null) {
            x.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
            return;
        }
        this.sFM.setVisibility(8);
        this.sFL.setVisibility(8);
        this.pNB.setText(com.tencent.mm.plugin.wxpay.a.i.uUq);
        this.sFT.setVisibility(0);
        this.sFU.setVisibility(0);
        View findViewById = this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueQ);
        View findViewById2 = this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.uer);
        if ("CFT".equals(this.pPl.sNS)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        CheckedTextView checkedTextView = (CheckedTextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueM);
        CheckedTextView checkedTextView2 = (CheckedTextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueq);
        findViewById.setEnabled(true);
        boolean z;
        if (this.pPl == null || this.pPl.sNW == null || this.pPl.sNW.size() <= 0) {
            z = false;
        } else if (this.pPl.sNG == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.szl == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 28(this, checkedTextView, checkedTextView2));
        }
        findViewById2.setOnClickListener(new 29(this, checkedTextView, checkedTextView2));
        this.sFV = true;
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        x.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.pPl.sNY);
        if (this.pPl.sNY == 1) {
            this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ujH).setVisibility(0);
            ((TextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ujG)).setText(this.pPl.sNZ);
            if (TextUtils.isEmpty(this.pPl.sOa)) {
                ((TextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ukq)).setText("");
            } else {
                ((TextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ukq)).setText(" (" + this.pPl.sOa + ")");
            }
            if (!(this.szl == null || !this.szl.bKP() || TextUtils.isEmpty(this.szl.field_forbidWord))) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueU)).setText(this.szl.field_forbidWord);
            }
        } else {
            this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ujH).setVisibility(8);
            if (this.szl != null && this.szl.bKP() && !TextUtils.isEmpty(this.szl.field_forbidWord)) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.sFU.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueU)).setText(this.szl.field_forbidWord);
            } else if (this.szl != null && this.szl.bKP() && TextUtils.isEmpty(this.szl.field_forbidWord) && !r2) {
                checkedTextView.setChecked(true);
                checkedTextView2.setChecked(false);
                this.sFV = false;
            }
        }
        bKk();
    }

    private void bKk() {
        if (this.sFV) {
            this.pNB.setOnClickListener(new 2(this));
        } else {
            this.pNB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletPayUI sGh;

                {
                    this.sGh = r1;
                }

                public final void onClick(View view) {
                    this.sGh.bKo();
                }
            });
        }
    }

    public final void bKl() {
        double d;
        int i;
        com.tencent.mm.plugin.wallet.a.h Ni = this.sFy.Ni(this.sEQ.sMT);
        List bMo = this.sFy.bMo();
        com.tencent.mm.plugin.wallet.a.f fVar = this.sFy.sQU;
        CharSequence charSequence = "";
        if (Ni != null) {
            d = Ni.sDx;
            if (d > 0.0d) {
                String str = Ni.sDz;
                if (bh.ov(Ni.sDA)) {
                    Object obj = str;
                    i = 1;
                } else {
                    charSequence = str + "," + Ni.sDA;
                    i = 1;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && bMo.size() > 0) {
            charSequence = charSequence + this.mController.xIM.getString(com.tencent.mm.plugin.wxpay.a.i.uVr);
        }
        if (d <= 0.0d || fVar == null || fVar.sDt != 0) {
            this.sFH.setText(com.tencent.mm.wallet_core.ui.e.t(this.pPl.pNX));
            this.sFK.setText(com.tencent.mm.wallet_core.ui.e.aay(this.pPl.paz));
            this.sFJ.setVisibility(8);
        } else {
            if (Ni != null) {
                this.sFH.setText(com.tencent.mm.wallet_core.ui.e.t(Ni.sDw));
            }
            this.sFK.setText(com.tencent.mm.wallet_core.ui.e.aay(this.pPl.paz));
            this.sFJ.setText(com.tencent.mm.wallet_core.ui.e.d(this.pPl.pNX, this.pPl.paz));
            this.sFJ.setVisibility(0);
        }
        if (!bh.ov(charSequence)) {
            this.sFP.setText(charSequence);
        }
    }

    public final Authen bKm() {
        Authen authen = new Authen();
        if (bKn()) {
            authen.fDt = 3;
        } else {
            authen.fDt = 6;
        }
        if (!bh.ov(this.mzL)) {
            authen.sKs = this.mzL;
        }
        if (this.szl != null) {
            authen.oZA = this.szl.field_bindSerial;
            authen.oZz = this.szl.field_bankcardType;
        }
        if (this.sEQ != null) {
            authen.sKE = this.sEQ.sMT;
            authen.sKD = this.sEQ.sMW;
        }
        authen.pCn = this.sEO;
        return authen;
    }

    public final boolean bKn() {
        if (this.szl == null || this.pPl == null || this.pPl.sIJ != 3) {
            if (this.pPl == null || Bankcard.zh(this.pPl.sIJ)) {
                return false;
            }
            return true;
        } else if (this.szl.bKS()) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bKo() {
        jE(true);
    }

    protected final void jE(boolean z) {
        if (z) {
            boolean z2;
            if (this.pPl != null && this.pPl.sNO) {
                g.Dk();
                if (((Boolean) g.Dj().CU().get(196614, Boolean.valueOf(true))).booleanValue()) {
                    View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.uFC, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.uxg);
                    TextView textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.czk);
                    textView.setText(Html.fromHtml(String.format(getResources().getString(com.tencent.mm.plugin.wxpay.a.i.uUV), new Object[]{getResources().getString(com.tencent.mm.plugin.wxpay.a.i.uOK)})));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.cSe)).setOnClickListener(new 19(this, checkBox));
                    com.tencent.mm.ui.base.i a = h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.uUW), inflate, getString(com.tencent.mm.plugin.wxpay.a.i.uQH), getString(com.tencent.mm.plugin.wxpay.a.i.uWa), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI sGh;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (checkBox.isChecked()) {
                                g.Dk();
                                g.Dj().CU().set(196614, Boolean.valueOf(false));
                            }
                            this.sGh.jE(false);
                        }
                    }, new 21(this));
                    a.setCancelable(false);
                    checkBox.setOnCheckedChangeListener(new 22(this, a));
                    z2 = false;
                    if (!z2) {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return;
            }
        }
        if (this.sGd != null) {
            x.i("MicroMsg.WalletPayUI", "need real name,stop");
            e eVar = this.sGd;
            if ("1".equals(eVar.fKP)) {
                x.i("MicroMsg.WalletPayUI", "need realname verify");
                this.sFY = true;
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                String str = eVar.fKQ;
                str = eVar.fKR;
                String str2 = eVar.fKS;
                aYf();
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, this.sEO != null ? this.sEO.fCV : 0);
                return;
            } else if ("2".equals(eVar.fKP)) {
                x.i("MicroMsg.WalletPayUI", "need upload credit");
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, eVar.fKQ, eVar.fKT, eVar.fKR, eVar.fKS, aYf(), null);
                return;
            } else {
                x.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + eVar.fKP);
                return;
            }
        }
        if (this.sEF != null) {
            if (this.sEF.sEn == 1 && !bh.ov(this.sEF.odw) && !bh.ov(this.sEF.odx) && !bh.ov(this.sEF.sEo)) {
                h.a(this.mController.xIM, this.sEF.sEo, "", this.sEF.odx, this.sEF.odw, false, new 4(this), new 5(this));
                return;
            } else if (!(this.sEF.sEn != 2 || bh.ov(this.sEF.sEo) || bh.ov(this.sEF.sEp))) {
                x.i("MicroMsg.WalletPayUI", "pay has been blocked");
                h.a(this.mController.xIM, this.sEF.sEo, "", this.sEF.sEp, false, new 6(this));
                return;
            }
        }
        bKp();
    }

    private void bKp() {
        int i = false;
        com.tencent.mm.plugin.report.service.g.pQN.h(13958, new Object[]{Integer.valueOf(1)});
        if (this.sEO != null && 8 == this.sEO.fCV) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13955, new Object[]{Integer.valueOf(2)});
            if (this.sEO.vzx != null) {
                long j = this.sEO.vzx.getLong("extinfo_key_9");
                com.tencent.mm.plugin.report.service.g.pQN.h(13956, new Object[]{Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - j)});
            }
        }
        if (this.sFC) {
            x.i("MicroMsg.WalletPayUI", "hy: start do pay with force use given bankcard");
            if (bh.ov(this.sFD)) {
                p.bJN();
                if (p.bJO().bLJ()) {
                    t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 17, "");
                } else {
                    p.bJN();
                    if (p.bJO().bLN()) {
                        t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 5, "");
                    }
                }
                b(false, 0, "");
                return;
            }
            this.szl = bKr();
            bJZ();
            return;
        }
        String az = bh.az(getIntent().getStringExtra("key_is_use_default_card"), "");
        if (!bh.ov(az)) {
            this.szl = MO(az);
        }
        if (this.szl != null) {
            int a = this.szl.a(this.pPl.sIJ, this.pPl);
            if (this.pLQ != null) {
                this.pLQ.aK(10002, "");
            }
            if (a != 0) {
                x.i("MicroMsg.WalletPayUI", "main bankcard(" + a + ") is useless! jump to select bankcard!");
                c(false, a, "");
                return;
            }
            p.bJN();
            if (p.bJO().bLN()) {
                x.i("MicroMsg.WalletPayUI", "payWithoutPassword");
                if (this.sEO != null) {
                    i = this.sEO.fCV;
                }
                t.d(i, this.sEO == null ? "" : this.sEO.fuH, 3, "");
                jF(true);
                com.tencent.mm.plugin.wallet_core.e.c.bNg();
                return;
            }
            x.i("MicroMsg.WalletPayUI", "has useful bankcard ! payWithOldBankcard");
            bJZ();
        } else if (this.szk == null || this.szk.size() <= 0) {
            x.i("MicroMsg.WalletPayUI", "default bankcard not found! payWithNewBankcard");
            p.bJN();
            if (p.bJO().bLJ()) {
                t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 17, "");
            } else {
                p.bJN();
                if (p.bJO().bLN()) {
                    t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 5, "");
                }
            }
            b(false, 0, "");
        } else {
            x.i("MicroMsg.WalletPayUI", " no last pay bankcard ! jump to select bankcard!");
            c(false, 8, "");
        }
    }

    public void bJZ() {
        boolean z = false;
        if (XK()) {
            x.i("MicroMsg.WalletPayUI", "pay with old bankcard! from statck %s", new Object[]{bh.cgy().toString()});
            t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 8, "");
            if (!this.sFC) {
                z = true;
            }
            this.szh = m.a(this, z, this.pPl, this.sEQ, this.szl, this.sEO, this.pMj, new 7(this), new 8(this), new 9(this));
            this.sES = this.szh;
        }
    }

    public final void b(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        p.bJN();
        x.d("MicroMsg.WalletPayUI", stringBuilder.append(p.bJO().bLM()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String N;
            if (bh.ov(str)) {
                N = Bankcard.N(this, i);
            } else {
                N = str;
            }
            h.a(this, N, "", getString(com.tencent.mm.plugin.wxpay.a.i.uUs), getString(com.tencent.mm.plugin.wxpay.a.i.dEn), new 10(this), new 11(this));
            return;
        }
        bKq();
    }

    public final void c(boolean z, int i, String str) {
        x.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + z);
        if (z) {
            String N;
            if (bh.ov(str)) {
                N = Bankcard.N(this, i);
            } else {
                N = str;
            }
            h.a(this, N, "", getString(com.tencent.mm.plugin.wxpay.a.i.uUI), getString(com.tencent.mm.plugin.wxpay.a.i.dEn), new 13(this, i), new 14(this));
            return;
        }
        Q(i, false);
    }

    protected final void bKq() {
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        p.bJN();
        extras.putInt(str, p.bJO().bLM() ? 2 : 1);
        extras.putParcelable("key_orders", this.pPl);
        extras.putParcelable("key_pay_info", this.sEO);
        extras.putParcelable("key_favor_pay_info", this.sEQ);
        I(extras);
    }

    protected final void Q(int i, boolean z) {
        int i2 = 0;
        com.tencent.mm.plugin.report.service.g.pQN.h(13958, new Object[]{Integer.valueOf(2)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13955, new Object[]{Integer.valueOf(4)});
        if (this.sEO != null) {
            i2 = this.sEO.fCV;
        }
        t.d(i2, this.sEO == null ? "" : this.sEO.fuH, 11, "");
        Bundle bundle = this.vf;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.pPl);
        bundle.putParcelable("key_pay_info", this.sEO);
        bundle.putParcelable("key_authen", bKm());
        bundle.putString("key_pwd1", this.mzL);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.sEQ);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.szl != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.szl.field_bindSerial);
        }
        I(bundle);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletPayUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        Bundle bundle;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                com.tencent.mm.plugin.report.service.g gVar;
                Object[] objArr;
                long j;
                e eVar = (e) kVar;
                if ("1".equals(eVar.fKP) || "2".equals(eVar.fKP)) {
                    this.sGd = eVar;
                } else {
                    this.sGd = null;
                }
                this.sEF = eVar.sEF;
                this.sGb = true;
                this.pPl = ((e) kVar).pPl;
                this.mCount = this.pPl != null ? this.pPl.sNW.size() : 0;
                x.d("MicroMsg.WalletPayUI", "get mOrders! bankcardTag : " + (this.pPl != null ? Integer.valueOf(this.pPl.sIJ) : ""));
                XK();
                if (!(this.pPl == null || this.pPl.sNX == null)) {
                    this.sFy = com.tencent.mm.plugin.wallet_core.ui.b.sRa.a(this.pPl);
                    if (this.sFy != null) {
                        if (this.sFy.bMo().size() > 0) {
                            this.sFz = true;
                        }
                        this.sEQ = this.sFy.Nl(this.pPl.sNX.sDq);
                        this.sEQ.sMT = this.sFy.Nm(this.sEQ.sMT);
                        x.i("MicroMsg.WalletPayUI", "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", new Object[]{this.pPl.sNX.sDq, this.sEQ.sMT, this.sEQ.sMT, this.sEQ.toString()});
                    }
                }
                if (!(this.pPl == null || this.szk == null || this.sEO == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sEO, this.pPl);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sEO.fCV);
                    objArr[1] = Integer.valueOf(0);
                    p.bJN();
                    objArr[2] = Integer.valueOf(p.bJO().bLM() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pPl.pNX * 100.0d));
                    objArr[4] = this.pPl.paz;
                    gVar.h(10690, objArr);
                }
                if (!(this.pPl == null || this.pPl.sNW == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pPl.sNW) {
                        linkedList.add(commodity.fuI);
                    }
                    if (linkedList.size() > 0) {
                        com.tencent.mm.sdk.b.b syVar = new sy();
                        syVar.fLp.fLr = linkedList;
                        com.tencent.mm.sdk.b.a.xef.m(syVar);
                        if (this.pLQ != null) {
                            this.pLQ.aK(10001, (String) linkedList.get(0));
                        }
                    }
                }
                p.bJN();
                this.szk = p.bJO().jB(bJW());
                p.bJN();
                this.szl = p.bJO().a(null, null, bJW(), false);
                String az = bh.az(getIntent().getStringExtra("key_is_use_default_card"), "");
                if (!bh.ov(az)) {
                    this.szl = MO(az);
                }
                this.pNB.setClickable(true);
                if (bh.ov(o.bLq().sQm)) {
                    this.sFO.setVisibility(8);
                    this.sFO.setText("");
                } else {
                    this.sFO.setVisibility(0);
                    this.sFO.setText(o.bLq().sQm);
                }
                if (!(this.pPl == null || this.szk == null || this.sEO == null)) {
                    com.tencent.mm.plugin.wallet_core.e.c.a(this.sEO, this.pPl);
                    gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.sEO.fCV);
                    objArr[1] = Integer.valueOf(0);
                    p.bJN();
                    objArr[2] = Integer.valueOf(p.bJO().bLM() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pPl.pNX * 100.0d));
                    objArr[4] = this.pPl.paz;
                    gVar.h(10690, objArr);
                }
                if (this.sFW) {
                    Q(0, false);
                }
                if (bKt().vzx == null) {
                    j = 0;
                } else {
                    j = bKt().vzx.getLong("wallet_pay_key_check_time");
                }
                if (j > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 4, 1, true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 5, bh.bz(j), true);
                }
                if (this.sGg > 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 7, 1, true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(641, 8, bh.bz(this.sGg), true);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                j jVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                bundle = this.vf;
                bundle.putParcelable("key_pay_info", this.sEO);
                bundle.putParcelable("key_bankcard", this.szl);
                bundle.putString("key_bank_type", this.szl.field_bankcardType);
                if (!bh.ov(this.mzL)) {
                    bundle.putString("key_pwd1", this.mzL);
                }
                bundle.putString("kreq_token", jVar.token);
                bundle.putParcelable("key_authen", jVar.sEt);
                bundle.putBoolean("key_need_verify_sms", !jVar.sEr);
                bundle.putInt("key_can_verify_tail", jVar.sEx);
                bundle.putString("key_verify_tail_wording", jVar.sEy);
                this.vf.putBoolean("key_block_bind_new_card", jVar.sEz == 1);
                if (bh.ov(jVar.sEu)) {
                    bundle.putString("key_mobile", this.szl.field_mobile);
                } else {
                    bundle.putString("key_mobile", jVar.sEu);
                }
                bundle.putString("key_QADNA_URL", jVar.sEv);
                if (jVar.sFA) {
                    if (this.pLQ != null) {
                        this.pLQ.aK(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.pLQ;
                        com.tencent.mm.plugin.report.service.g.pQN.h(13455, new Object[]{aVar.sxX, Long.valueOf(System.currentTimeMillis()), aVar.sxY});
                    }
                    bundle.putParcelable("key_orders", jVar.sEs);
                    if (this.sEO != null) {
                        x.i("MicroMsg.WalletPayUI", "payscene %d", new Object[]{Integer.valueOf(this.sEO.fCV)});
                        if (8 == this.sEO.fCV) {
                            g.Dk();
                            g.Dj().CU().a(w.a.xsv, Boolean.valueOf(true));
                        }
                    }
                } else {
                    bundle.putParcelable("key_orders", this.pPl);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("pwd", this.mzL);
                ((l) g.h(l.class)).a(jVar.bJS(), true, bundle2);
                bundle.putInt("key_pay_flag", 3);
                Parcelable parcelable = jVar.oWt;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                I(bundle);
                return true;
            }
            au();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            bundle2 = new Bundle();
            bundle2.putString("pwd", this.mzL);
            ((l) g.h(l.class)).a(this.sEO.vzy == 1, false, bundle2);
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX /*402*/:
                case ap.CTRL_INDEX /*403*/:
                case av.CTRL_INDEX /*408*/:
                    String string;
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.sFF = this.vf;
                    this.sFF.putParcelable("key_pay_info", this.sEO);
                    this.sFF.putParcelable("key_bankcard", this.szl);
                    if (!bh.ov(this.mzL)) {
                        this.sFF.putString("key_pwd1", this.mzL);
                    }
                    this.sFF.putString("kreq_token", bVar.token);
                    this.sFF.putParcelable("key_authen", bVar.sEt);
                    this.sFF.putBoolean("key_need_verify_sms", !bVar.sEr);
                    this.sFF.putString("key_mobile", this.szl.field_mobile);
                    this.sFF.putInt("key_err_code", i2);
                    this.sFF.putParcelable("key_orders", this.pPl);
                    if (bh.ov(str)) {
                        string = getString(com.tencent.mm.plugin.wxpay.a.i.uUY, new Object[]{this.szl.field_desc, this.szl.field_mobile});
                    } else {
                        string = str;
                    }
                    h.a(this, string, "", getString(com.tencent.mm.plugin.wxpay.a.i.uUX), getString(com.tencent.mm.plugin.wxpay.a.i.dEn), new 15(this), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI sGh;

                        {
                            this.sGh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.sGh.aYf()) {
                                this.sGh.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.szl == null || this.pPl == null)) {
                        this.szl.sLe = this.pPl.fuH;
                        if (this.szk == null || this.szk.size() <= 1) {
                            b(true, 4, str);
                        } else {
                            c(true, 4, str);
                        }
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                case 100102:
                    this.sEO.vzA = i2;
                    bJZ();
                    return true;
                case 100100:
                case 100101:
                    this.sEO.vzA = i2;
                    boolean z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.sER == null) {
                        this.sER = new a(this, this);
                    }
                    this.sER.a(z, this.sEO.fwX, this.sEO.fuH);
                    x.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof e) {
            this.sGb = true;
            bKs();
            if (i2 == 416) {
                x.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
                this.sFY = true;
                bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle, this.sEO != null ? this.sEO.fCV : 0);
            }
            x.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", new Object[]{Integer.valueOf(i2)});
        }
        return false;
    }

    public final boolean aYj() {
        return false;
    }

    public final boolean XK() {
        if (this.pPl == null || this.pPl.sNW == null || this.pPl.sNW.size() <= 0) {
            x.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
            h.a(this.mController.xIM, com.tencent.mm.plugin.wxpay.a.i.uTp, 0, new 17(this));
            return false;
        } else if (!this.sFC || bh.ov(this.sFD) || bKr() != null) {
            return true;
        } else {
            x.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
            h.a(this.mController.xIM, com.tencent.mm.plugin.wxpay.a.i.uTp, 0, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletPayUI sGh;

                {
                    this.sGh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sGh.finish();
                }
            });
            return false;
        }
    }

    private Bankcard bKr() {
        p.bJN();
        ArrayList jB = p.bJO().jB(true);
        if (jB.size() != 0) {
            Iterator it = jB.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bh.ou(this.sFD).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    private static Bankcard MO(String str) {
        p.bJN();
        ArrayList jB = p.bJO().jB(true);
        if (jB.size() != 0) {
            Iterator it = jB.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bh.ou(str).equals(bankcard.field_bindSerial)) {
                    x.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.sGa = intent.getIntExtra("auto_deduct_flag", -1);
                        this.pPl.sOb.sGa = this.sGa;
                        bKt().vzC = this.sGa;
                        if (this.sGa == 1) {
                            bKt().vzD = intent.getStringExtra("deduct_bank_type");
                            bKt().vzE = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.sFZ = true;
                    aYi();
                } else {
                    finish();
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13958, new Object[]{Integer.valueOf(3)});
                return;
            default:
                return;
        }
    }

    protected final boolean aYi() {
        x.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.sGe)});
        com.tencent.mm.sdk.b.a.xef.m(new sr());
        boolean z = (this.pPl == null || this.pPl.sOb == null || this.sFZ) ? false : true;
        if (!(z || bKs())) {
            t.d(this.sEO == null ? 0 : this.sEO.fCV, this.sEO == null ? "" : this.sEO.fuH, 2, "");
        }
        if (this.sGe) {
            jE(true);
            return true;
        } else if (this.sFY) {
            return true;
        } else {
            if (z) {
                Intent intent = new Intent(this, WalletPayDeductUI.class);
                intent.putExtra("orders", this.pPl);
                startActivityForResult(intent, 0);
                return true;
            } else if (this.mController.contentView.getVisibility() != 0) {
                if (!this.sFG && XK()) {
                    jE(true);
                    this.sFG = true;
                }
                return true;
            } else if (this.mController.contentView.getVisibility() != 0 || this.pPl == null || this.pPl.sOb == null || !this.pNB.isEnabled() || this.sGc) {
                return false;
            } else {
                this.pNB.performClick();
                this.sGc = true;
                return false;
            }
        }
    }

    public final boolean aYf() {
        if (this.sGb) {
            String str = "MicroMsg.WalletPayUI";
            String str2 = "case 1 %s,";
            Object[] objArr = new Object[1];
            boolean z = bKt() == null || !bKt().ncX;
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 2 %s,";
            objArr = new Object[1];
            p.bJN();
            if (p.bJO().bLM()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.szk == null ? 0 : this.szk.size());
            objArr[1] = this.szl == null ? "" : this.szl.field_forbidWord;
            x.d(str, str2, objArr);
            if (bKt() == null || !bKt().ncX) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent1");
                return false;
            }
            p.bJN();
            if (!p.bJO().bLM()) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent2");
                return false;
            } else if (this.szk == null || (this.szk.size() != 0 && (this.szl == null || bh.ov(this.szl.field_forbidWord)))) {
                x.i("MicroMsg.WalletPayUI", "get isTransparent4");
                return true;
            } else {
                str = "MicroMsg.WalletPayUI";
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                z = this.szk != null && this.szk.size() == 0;
                objArr[0] = Boolean.valueOf(z);
                z = (this.szl == null || bh.ov(this.szl.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                return false;
            }
        }
        x.i("MicroMsg.WalletPayUI", "get isTransparent5");
        return true;
    }

    private boolean bKs() {
        if (aYf()) {
            uD(4);
            return false;
        }
        uD(0);
        return true;
    }

    protected final boolean bKa() {
        return true;
    }

    public final void uw(int i) {
        if (i == 0) {
            if (aYf()) {
                finish();
            }
        } else if (i == 1) {
            bJZ();
        }
    }

    public void jF(boolean z) {
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(bKm(), this.pPl, z);
        if (this.pPl != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.pPl.fuH);
            if (this.pPl.sNW != null && this.pPl.sNW.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pPl.sNW.get(0)).fuI);
            }
            bundle.putLong("key_SessionId", this.sFS);
            a.gOs = "PayProcess";
            a.vf = bundle;
        }
        if (this.sEO != null) {
            if (this.sEO.fCV == 6 && this.sEO.vzu == 100) {
                a.irz = 100;
            } else {
                a.irz = this.sEO.fCV;
            }
        }
        l(a);
        if (this.sEO != null && 8 == this.sEO.fCV && this.sEO.vzx != null) {
            long j = this.sEO.vzx.getLong("extinfo_key_9");
            com.tencent.mm.plugin.report.service.g.pQN.h(13956, new Object[]{Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - j)});
        }
    }

    public final boolean bJW() {
        return (this.sEO == null || this.sEO.fCV == 11) ? false : true;
    }

    public final PayInfo bKt() {
        if (this.sEO == null) {
            this.sEO = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        return this.sEO;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void I(Bundle bundle) {
        boolean z;
        this.sFB = true;
        if (this.pPl != null) {
            bundle.putInt("key_support_bankcard", this.pPl.sIJ);
            bundle.putString("key_reqKey", this.pPl.fuH);
            if (this.pPl.sNW != null && this.pPl.sNW.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.pPl.sNW.get(0)).fuI);
            }
            bundle.putLong("key_SessionId", this.sFS);
        }
        if (this.sEO != null) {
            bundle.putInt("key_scene", this.sEO.fCV);
        }
        String str = "key_is_oversea";
        if (bKn()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("is_deduct_open", this.sGa);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, null);
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletPayUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
            this.sEO.fwZ = str;
            this.sEO.fxa = str2;
            jF(false);
            com.tencent.mm.plugin.wallet_core.e.c.bNg();
            return;
        }
        x.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
        jF(false);
        com.tencent.mm.plugin.wallet_core.e.c.bNg();
    }

    public void onPause() {
        super.onPause();
        if (this.sES != null) {
            this.sES.bMq();
        }
    }
}
