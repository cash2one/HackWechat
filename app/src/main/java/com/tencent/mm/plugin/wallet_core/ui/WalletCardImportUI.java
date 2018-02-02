package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView$a {
    private static final String[] sSB = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private af mHandler = new af();
    private String nXC;
    private String nXD;
    private Orders pPl = null;
    private Dialog qb = null;
    private Button sCT;
    private PayInfo sEO = null;
    private Authen sEt = new Authen();
    private WalletFormView sGY;
    private int sHc = 1;
    private ElementQuery sJK = new ElementQuery();
    private WalletFormView sRj;
    private TextView sSC;
    private MMScrollView sSD;
    private Bankcard sSE = null;
    private CheckBox sSF;
    private BaseAdapter sSG = new 9(this);
    private WalletFormView sSa;
    private WalletFormView sSb;
    private WalletFormView sSc;
    private WalletFormView sSd;
    private WalletFormView sSe;
    private WalletFormView sSh;
    private WalletFormView sSi;
    private WalletFormView sSj;
    private WalletFormView sSk;
    private WalletFormView sSl;
    private WalletFormView sSm;
    private WalletFormView sSn;
    private WalletFormView sSp = null;
    private WalletFormView sSq;
    private CheckBox sSu;
    private String sSv;

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        b bVar = walletFormView.zJJ;
        if (bVar instanceof a) {
            ((a) bVar).HG(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uRt);
        this.sJK = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.sSE = (Bankcard) this.vf.getParcelable("key_import_bankcard");
        if (this.sEO == null) {
            this.sEO = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.sEO);
        initView();
        this.sSD.pageScroll(33);
        c.b(this, this.vf, 3);
    }

    protected final void initView() {
        this.sSq = (WalletFormView) findViewById(a$f.uyq);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sSq);
        this.sSe = (WalletFormView) findViewById(a$f.urD);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sSe);
        this.sRj = (WalletFormView) findViewById(a$f.urM);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sRj);
        this.sSd = (WalletFormView) findViewById(a$f.uyH);
        this.sGY = (WalletFormView) findViewById(a$f.ukS);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sGY);
        this.sSa = (WalletFormView) findViewById(a$f.uyy);
        this.sSc = (WalletFormView) findViewById(a$f.uja);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sSc);
        this.sSb = (WalletFormView) findViewById(a$f.ujb);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.sSb);
        this.sSC = (TextView) findViewById(a$f.uzT);
        this.sSh = (WalletFormView) findViewById(a$f.ukI);
        this.sSi = (WalletFormView) findViewById(a$f.uls);
        this.sSj = (WalletFormView) findViewById(a$f.ueG);
        this.sSk = (WalletFormView) findViewById(a$f.ueu);
        this.sSl = (WalletFormView) findViewById(a$f.utw);
        this.sSm = (WalletFormView) findViewById(a$f.utD);
        this.sSn = (WalletFormView) findViewById(a$f.ujX);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.sSn);
        this.sSF = (CheckBox) findViewById(a$f.uex);
        this.sSu = (CheckBox) findViewById(a$f.uev);
        this.sCT = (Button) findViewById(a$f.cAg);
        this.sSD = (MMScrollView) findViewById(a$f.cYz);
        Object obj = this.sSD;
        obj.a(obj, obj);
        this.sSD.zIS = new 1(this);
        this.sRj.zJH = this;
        this.sSq.zJH = this;
        this.sSd.zJH = this;
        this.sGY.zJH = this;
        this.sSe.zJH = this;
        this.sSc.zJH = this;
        this.sSb.zJH = this;
        this.sSh.zJH = this;
        this.sSi.zJH = this;
        this.sSj.zJH = this;
        this.sSk.zJH = this;
        this.sSl.zJH = this;
        this.sSm.zJH = this;
        this.sSn.zJH = this;
        this.sRj.setOnEditorActionListener(this);
        this.sSq.setOnEditorActionListener(this);
        this.sSd.setOnEditorActionListener(this);
        this.sGY.setOnEditorActionListener(this);
        this.sSe.setOnEditorActionListener(this);
        this.sSc.setOnEditorActionListener(this);
        this.sSb.setOnEditorActionListener(this);
        this.sSh.setOnEditorActionListener(this);
        this.sSi.setOnEditorActionListener(this);
        this.sSj.setOnEditorActionListener(this);
        this.sSk.setOnEditorActionListener(this);
        this.sSl.setOnEditorActionListener(this);
        this.sSm.setOnEditorActionListener(this);
        this.sSn.setOnEditorActionListener(this);
        this.sSa.setOnClickListener(new 2(this));
        this.sSd.setOnClickListener(new 3(this));
        this.sSF.setChecked(true);
        this.sSF.setOnCheckedChangeListener(new 4(this));
        this.sSu.setChecked(true);
        findViewById(a$f.bJC).setOnClickListener(new 5(this));
        this.sSj.setOnClickListener(new 6(this));
        this.sCT.setOnClickListener(new 7(this));
        au();
        XK();
    }

    private void au() {
        WalletFormView walletFormView = null;
        if (this.sSE != null) {
            WalletFormView walletFormView2;
            findViewById(a$f.uyx).setVisibility(0);
            if (bh.ov(this.vf.getString("key_bank_username"))) {
                this.sSu.setVisibility(8);
            } else {
                CharSequence string = this.vf.getString("key_recommand_desc");
                if (bh.ov(string)) {
                    this.sSu.setText(getString(i.uQm, new Object[]{this.sSE.field_bankName}));
                } else {
                    this.sSu.setText(string);
                }
                this.sSu.setVisibility(0);
            }
            this.sSh.setVisibility(8);
            this.sSi.setVisibility(8);
            this.sSj.setVisibility(8);
            this.sSk.setVisibility(8);
            this.sSl.setVisibility(8);
            this.sSm.setVisibility(8);
            this.sSn.setVisibility(8);
            if (bh.ov(this.sSE.field_bankcardTail) || !b(this.sSq, this.sSE.sLa)) {
                this.sSq.setVisibility(8);
                walletFormView2 = null;
            } else {
                walletFormView2 = this.sSq;
                walletFormView = this.sSq;
            }
            String string2;
            if (this.sSE.bKR()) {
                string2 = getString(i.uRc);
            } else {
                string2 = getString(i.uRr);
            }
            if (bh.ov(this.sSE.field_bankName) || !b(this.sSa, this.sSE.field_bankName + " " + r2)) {
                this.sSa.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sSa;
                }
                walletFormView = this.sSa;
            }
            if (b(this.sRj, this.sSE.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sRj;
                }
                walletFormView = this.sRj;
            }
            if (b(this.sSd, o.bLy().O(this.mController.xIM, this.sSE.sKv))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sSd;
                }
                walletFormView = this.sSd;
            }
            if (b(this.sGY, this.sSE.sKZ)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sGY;
                }
                walletFormView = this.sGY;
            }
            if (b(this.sSe, this.sSE.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sSe;
                }
                walletFormView = this.sSe;
            }
            if (b(this.sSc, this.sSE.sKx)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sSc;
                }
                walletFormView = this.sSc;
            }
            if (b(this.sSb, this.sSE.sLb)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.sSb;
                }
                walletFormView = this.sSb;
            }
            walletFormView2.setBackgroundResource(e.bBx);
            walletFormView.setBackgroundResource(e.bBx);
            if (o.bLq().bLJ()) {
                this.sCT.setText(i.uQt);
            } else {
                this.sCT.setText(i.uQr);
            }
        }
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        if (bh.ov(str)) {
            walletFormView.setVisibility(8);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        return true;
    }

    private void bMv() {
        if (XK()) {
            c.bNg();
            this.sEt = new Authen();
            this.vf.putBoolean("key_is_follow_bank_username", this.sSu.isChecked());
            if (this.sSE == null || bh.ov(this.sSE.sLl)) {
                String text;
                boolean z;
                String string = this.vf.getString("key_card_id");
                if (this.sSq.getVisibility() == 0) {
                    text = this.sSq.getText();
                } else {
                    text = string;
                }
                this.sEt.pCn = (PayInfo) this.vf.getParcelable("key_pay_info");
                this.sEt.sKw = text;
                this.sEt.oZz = this.sJK.oZz;
                this.sEt.sKv = this.sHc;
                this.sEt.sKs = this.vf.getString("key_pwd1");
                if (!bh.ov(this.sSc.getText())) {
                    this.sEt.sKx = this.sSc.getText();
                }
                this.sEt.sIF = this.sSe.getText();
                this.sEt.sKB = this.sSh.getText();
                this.sEt.sKC = this.sSi.getText();
                this.sEt.country = this.sSv;
                this.sEt.fWp = this.nXC;
                this.sEt.fWq = this.nXD;
                this.sEt.hxu = this.sSk.getText();
                this.sEt.nBO = this.sSl.getText();
                this.sEt.ilY = this.sSm.getText();
                this.sEt.fWi = this.sSn.getText();
                this.vf.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.aaB(this.sEt.sIF));
                Bundle bundle = this.vf;
                String str = "key_is_oversea";
                if (this.sJK.sIJ == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.sEt.sKu = this.sGY.getText();
                this.sEt.sKt = this.sRj.getText();
                this.sEt.sKy = this.sSb.getText();
                x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.sEt.pCn + " elemt.bankcardTag : " + this.sJK.sIJ);
            } else {
                this.sEt.sBQ = this.sSE.sLl;
                this.sEt.oZA = this.sSE.field_bindSerial;
                this.sEt.oZz = this.sSE.field_bankcardType;
                this.sEt.sKv = this.sSE.sKv;
                this.sEt.sKs = this.vf.getString("key_pwd1");
                this.sEt.token = this.vf.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.ag(this);
            if (cCd().k(new Object[]{this.sEt, this.pPl})) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.vf;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.sEO);
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            return false;
        }
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
        h.bu(this, getString(i.uPE));
        return true;
    }

    protected final int getLayoutId() {
        return g.uEI;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.sJK = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    au();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.sSv = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bh.ov(intent.getStringExtra("Contact_City"))) {
                        this.nXC = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.nXD = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        this.sSj.setText(stringExtra + " " + stringExtra4);
                    } else if (bh.ov(intent.getStringExtra("Contact_Province"))) {
                        this.nXD = this.sSv;
                        this.sSj.setText(stringExtra);
                    } else {
                        this.nXD = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.sSj.setText(stringExtra + " " + stringExtra3);
                    }
                    if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.sJK.sMM) {
                        this.sSm.setVisibility(8);
                        break;
                    } else {
                        this.sSm.setVisibility(0);
                        break;
                    }
                    break;
            }
            XK();
        }
    }

    private boolean XK() {
        boolean z;
        if (this.sSF.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
        } else {
            this.sCT.setEnabled(false);
            this.sCT.setClickable(false);
        }
        return z;
    }

    public final void hx(boolean z) {
        XK();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.sSp == null) {
                    bMv();
                } else if (this.sSp.isEnabled() && !this.sSp.isClickable() && this.sSp.cCm()) {
                    this.sSp.cCo();
                } else {
                    this.sSp.performClick();
                }
                return true;
            default:
                if (this.sSp == null) {
                    bMv();
                }
                return false;
        }
    }

    public void onDestroy() {
        if (this.qb != null && this.qb.isShowing()) {
            this.qb.dismiss();
            this.qb = null;
        }
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                Dialog kVar = new com.tencent.mm.ui.base.k(this, j.uYA);
                kVar.setContentView(g.uFd);
                ListView listView = (ListView) kVar.findViewById(a$f.bJe);
                listView.setAdapter(this.sSG);
                listView.setOnItemClickListener(new 8(this));
                return kVar;
            default:
                return super.onCreateDialog(i);
        }
    }
}
