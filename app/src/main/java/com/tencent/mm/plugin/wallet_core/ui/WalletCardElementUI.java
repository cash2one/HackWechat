package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.a.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import com.tencent.mm.z.s;
import com.tenpay.ndk.Encrypt;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView$a {
    private String countryCode;
    private String hhw;
    private String hhx;
    private String nXC;
    private String nXD;
    private Orders pPl = null;
    private TextView rFp;
    private Button sCT;
    private PayInfo sEO = null;
    private Authen sEt = new Authen();
    a sFy = null;
    private c sGV = new c<oh>(this) {
        final /* synthetic */ WalletCardElementUI sSA;

        {
            this.sSA = r2;
            this.xen = oh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oh ohVar = (oh) bVar;
            if (ohVar instanceof oh) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletCardElementUI.a(this.sSA, encrypt.desedeEncode(ohVar.fGh.cardId, randomKey), randomKey, ohVar.fGh.fGi);
                return true;
            }
            x.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    private WalletFormView sGY;
    private TextView sGZ;
    private TextView sHa;
    private int sHc = 1;
    private Profession[] sIM;
    private ElementQuery sJK = new ElementQuery();
    private Profession sJL;
    private TextView sRS;
    private TextView sRT;
    private TextView sRU;
    private TextView sRV;
    private TextView sRW;
    private TextView sRX;
    private TextView sRY;
    private TextView sRZ;
    private WalletFormView sRj;
    private Bankcard sRk = null;
    private WalletFormView sSa;
    private WalletFormView sSb;
    private WalletFormView sSc;
    private WalletFormView sSd;
    private WalletFormView sSe;
    private WalletFormView sSf;
    private WalletFormView sSg;
    private WalletFormView sSh;
    private WalletFormView sSi;
    private WalletFormView sSj;
    private WalletFormView sSk;
    private WalletFormView sSl;
    private WalletFormView sSm;
    private WalletFormView sSn;
    private ScrollView sSo;
    private WalletFormView sSp = null;
    private WalletFormView sSq;
    private Map<String, a> sSr = null;
    private boolean sSs = false;
    private CheckBox sSt;
    private CheckBox sSu;
    private String sSv;
    private boolean sSw;
    private boolean sSx;
    private BaseAdapter sSy = new 3(this);
    private OnClickListener sSz = new OnClickListener(this) {
        final /* synthetic */ WalletCardElementUI sSA;

        {
            this.sSA = r1;
        }

        public final void onClick(View view) {
            g.pQN.h(11353, Integer.valueOf(2), Integer.valueOf(0));
            e.e(this.sSA, o.bLq().azp());
        }
    };

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putString("key_bankcard_des", str2);
        bundle.putString("key_bankcard_id", str);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletCardElementUI);
        if (ag != null) {
            ag.a(walletCardElementUI, WalletConfirmCardIDUI.class, bundle, 3);
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.uFd, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(a$f.bJe);
                listViewInScrollView.setAdapter(this.sSy);
                listViewInScrollView.setOnItemClickListener(new 2(this));
                i.a aVar = new i.a(this);
                aVar.Ez(com.tencent.mm.plugin.wxpay.a.i.uQf);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.akx();
            default:
                return h.b(this, getString(com.tencent.mm.plugin.wxpay.a.i.uQf), "", true);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.sJK = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.sHc = o.bLq().bLS();
        this.sRk = (Bankcard) this.vf.getParcelable("key_history_bankcard");
        this.sSw = this.vf.getBoolean("key_need_area", false);
        this.sSx = this.vf.getBoolean("key_need_profession", false);
        if (this.sSw || this.sSx) {
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uRu);
        } else {
            setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uRt);
        }
        Parcelable[] parcelableArray = this.vf.getParcelableArray("key_profession_list");
        if (parcelableArray != null) {
            this.sIM = new Profession[parcelableArray.length];
            while (i < parcelableArray.length) {
                this.sIM[i] = (Profession) parcelableArray[i];
                i++;
            }
        }
        if (this.sEO == null) {
            this.sEO = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.sEO);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
        if (!(this.pPl == null || favorPayInfo == null)) {
            this.sFy = b.sRa.a(this.pPl);
            if (this.sFy != null) {
                this.sSr = this.sFy.Ng(this.sFy.Nk(favorPayInfo.sMT));
            } else {
                x.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.sSo.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 3);
        com.tencent.mm.sdk.b.a.xef.b(this.sGV);
    }

    protected final void initView() {
        this.sRS = (TextView) findViewById(a$f.uys);
        this.sSq = (WalletFormView) findViewById(a$f.uyq);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sSq);
        this.sRT = (TextView) findViewById(a$f.uyr);
        this.sGZ = (TextView) findViewById(a$f.uyu);
        this.sRj = (WalletFormView) findViewById(a$f.urM);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sRj);
        this.sSe = (WalletFormView) findViewById(a$f.urD);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sSe);
        this.sSd = (WalletFormView) findViewById(a$f.uyH);
        this.sGY = (WalletFormView) findViewById(a$f.ukS);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sGY);
        this.sHa = (TextView) findViewById(a$f.uyt);
        this.sRU = (TextView) findViewById(a$f.uyk);
        this.sSa = (WalletFormView) findViewById(a$f.uyy);
        this.sRV = (TextView) findViewById(a$f.uyl);
        this.sRZ = (TextView) findViewById(a$f.uyo);
        this.sRW = (TextView) findViewById(a$f.uyn);
        this.sSc = (WalletFormView) findViewById(a$f.uja);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sSc);
        this.sSb = (WalletFormView) findViewById(a$f.ujb);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.sSb);
        this.sRX = (TextView) findViewById(a$f.uym);
        this.rFp = (TextView) findViewById(a$f.uyi);
        this.sSh = (WalletFormView) findViewById(a$f.ukI);
        this.sSi = (WalletFormView) findViewById(a$f.uls);
        this.sSj = (WalletFormView) findViewById(a$f.ueG);
        this.sSk = (WalletFormView) findViewById(a$f.ueu);
        this.sSl = (WalletFormView) findViewById(a$f.utw);
        this.sSm = (WalletFormView) findViewById(a$f.utD);
        this.sSn = (WalletFormView) findViewById(a$f.ujX);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.sSn);
        this.sRY = (TextView) findViewById(a$f.uyh);
        this.sSt = (CheckBox) findViewById(a$f.uex);
        this.sSu = (CheckBox) findViewById(a$f.uev);
        this.sCT = (Button) findViewById(a$f.cAg);
        this.sSo = (ScrollView) findViewById(a$f.cYz);
        this.sSf = (WalletFormView) findViewById(a$f.utG);
        this.sSg = (WalletFormView) findViewById(a$f.utF);
        this.sRj.zJH = this;
        this.sSq.zJH = this;
        this.sSd.zJH = this;
        this.sGY.zJH = this;
        this.sSe.zJH = new 1(this);
        this.sSc.zJH = this;
        this.sSb.zJH = this;
        this.sSh.zJH = this;
        this.sSi.zJH = this;
        this.sSj.zJH = this;
        this.sSk.zJH = this;
        this.sSl.zJH = this;
        this.sSm.zJH = this;
        this.sSn.zJH = this;
        this.sSf.zJH = this;
        this.sSg.zJH = this;
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
        this.sSg.setOnEditorActionListener(this);
        this.sSf.setOnEditorActionListener(this);
        this.sSa.setOnClickListener(new 6(this));
        this.sSd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI sSA;

            {
                this.sSA = r1;
            }

            public final void onClick(View view) {
                this.sSA.showDialog(1);
            }
        });
        this.sSg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI sSA;

            {
                this.sSA = r1;
            }

            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (!Bankcard.zh(this.sSA.sJK.sIJ)) {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                this.sSA.startActivityForResult(putExtra, 4);
            }
        });
        this.sSf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI sSA;

            {
                this.sSA = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.sSA.mController.xIM, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", this.sSA.sIM);
                this.sSA.startActivityForResult(intent, 5);
            }
        });
        this.sSt.setChecked(true);
        this.sSt.setOnCheckedChangeListener(new 10(this));
        findViewById(a$f.bJC).setOnClickListener(new 11(this));
        this.sSj.setOnClickListener(new 12(this));
        this.sCT.setOnClickListener(new 13(this));
        e(this.sSq, 0, false);
        e(this.sGY, 1, false);
        e(this.sSe, 0, false);
        if (this.sJK != null && !bh.ov(this.sJK.sMF)) {
            h.a(this, this.sJK.sMF, null, true, null);
            this.sJK = null;
        } else if (this.vf.getInt("key_bind_scene", -1) == 5 && !this.sJK.sMS) {
            h.a(this, getString(com.tencent.mm.plugin.wxpay.a.i.uXM), null, true, null);
            this.sJK.nBM = null;
        }
        au();
        XK();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null && ag.cBk()) {
            Orders orders = (Orders) this.vf.getParcelable("key_orders");
            if (orders == null || orders.sNG != 1) {
                this.sSs = false;
                return;
            }
            this.sSs = true;
            this.sRj.setText(e.aaA(orders.sKt));
            this.sRj.setEnabled(false);
            this.sRj.setFocusable(false);
            this.sHc = orders.sNI;
            this.sSd.setText(o.bLy().O(this, this.sHc));
            this.sSd.setEnabled(false);
            this.sGY.setText(orders.sNH);
            this.sGY.setEnabled(false);
            this.sGY.setFocusable(false);
            this.sGZ.setText(com.tencent.mm.plugin.wxpay.a.i.uPZ);
            this.sSe.cCo();
        }
    }

    private void au() {
        if (this.sJK == null) {
            this.sJK = new ElementQuery();
        }
        if (this.sJK == null || this.sSr == null || !this.sSr.containsKey(this.sJK.oZz)) {
            this.sRZ.setVisibility(8);
        } else {
            double d;
            a aVar = (a) this.sSr.get(this.sJK.oZz);
            if (aVar == null || aVar.sQX == null) {
                d = 0.0d;
            } else {
                d = aVar.sQY;
            }
            this.sRZ.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQa, new Object[]{e.u(d)}));
            this.sRZ.setVisibility(0);
        }
        com.tencent.mm.wallet_core.a.ag(this);
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        if (!bMw() || bankcard == null) {
            if (bh.ov(this.sJK.nBM)) {
                this.sSa.setText("");
            } else if (!bh.ov(this.sJK.sMA)) {
                this.sSa.setText(this.sJK.nBM + " " + this.sJK.sMA);
            } else if (2 == this.sJK.sMz) {
                this.sSa.setText(this.sJK.nBM + " " + getString(com.tencent.mm.plugin.wxpay.a.i.uRc));
            } else {
                this.sSa.setText(this.sJK.nBM + " " + getString(com.tencent.mm.plugin.wxpay.a.i.uRr));
            }
            a(new boolean[]{false}, new WalletFormView[]{this.sSq}, this.sRS, this.sRT, true);
            a(new boolean[]{true}, new WalletFormView[]{this.sSa}, this.sRU, this.sRV, true);
            this.sSq.r(this.sSz);
            if (o.bLq().bLQ().bLE()) {
                this.sSq.pEi.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGK);
                this.sSq.pEi.setVisibility(0);
            } else {
                this.sSq.pEi.setVisibility(4);
            }
        } else {
            this.sSq.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uQn, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.sSq}, this.sRS, this.sRT);
            a(new boolean[]{false}, new WalletFormView[]{this.sSa}, this.sRU, this.sRV);
        }
        if (Bankcard.zh(this.sJK.sIJ)) {
            a(new boolean[]{false, false, false}, new WalletFormView[]{this.sRj, this.sSd, this.sGY}, this.sGZ, this.sHa);
            this.sSe.setVisibility(8);
            jK(true);
            this.sSg.setVisibility(8);
            this.sSf.setVisibility(8);
            findViewById(a$f.uyw).setVisibility(8);
        } else {
            boolean z = this.sJK.bLc() != null && this.sJK.bLc().size() > 0;
            if (bMw() || o.bLq().bLJ()) {
                if (bh.ov(o.bLq().azp())) {
                    this.sRj.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uQE));
                } else {
                    this.sRj.setHint(getString(com.tencent.mm.plugin.wxpay.a.i.uQF, new Object[]{e.aaA(o.bLq().azp())}));
                }
                a(new boolean[]{true, z, true}, new WalletFormView[]{this.sRj, this.sSd, this.sGY}, this.sGZ, this.sHa);
                this.sSe.setVisibility(0);
            } else {
                boolean[] zArr = new boolean[3];
                zArr[0] = this.sJK.sMs;
                if (z && this.sJK.sMt) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.sJK.sMt;
                a(zArr, new WalletFormView[]{this.sRj, this.sSd, this.sGY}, this.sGZ, this.sHa);
                this.sSe.setVisibility(0);
                x.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.sJK.sMs + " canModifyIdentity:" + this.sJK.sMt);
            }
            if (this.sRk != null) {
                if (!bh.ov(this.sRk.field_mobile)) {
                    a(this.sSe, this.sRk.field_mobile);
                }
                if (!bh.ov(this.sRk.sKx)) {
                    a(this.sSc, this.sRk.sKx);
                }
                if (!bh.ov(this.sRk.sLb)) {
                    a(this.sSb, this.sRk.sLb);
                }
            }
            if (this.sJK.sMs) {
                this.sHa.setText("");
            } else {
                this.sHa.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQq));
            }
            if (!bMw() || o.bLq().bLS() <= 0) {
                if (this.sSy.getCount() <= 1) {
                    this.sSd.setClickable(false);
                    this.sSd.setEnabled(false);
                } else {
                    this.sSd.setClickable(true);
                    this.sSd.setEnabled(true);
                }
                List bLc = this.sJK.bLc();
                if (bLc == null || !bLc.contains(Integer.valueOf(this.sHc))) {
                    this.sHc = 1;
                }
                this.sSd.setText(o.bLy().O(this, this.sHc));
            } else {
                this.sSd.setClickable(false);
                this.sSd.setText(o.bLy().O(this, o.bLq().bLS()));
                this.sSd.setEnabled(false);
                a(this.sGY, this.sHc);
            }
            zn(this.sHc);
            jK(false);
            if (this.sSw) {
                this.sSg.setVisibility(0);
            } else {
                this.sSg.setVisibility(8);
            }
            if (this.sSx) {
                this.sSf.setVisibility(0);
            } else {
                this.sSf.setVisibility(8);
            }
            if (this.sSw || this.sSx) {
                findViewById(a$f.uyw).setVisibility(0);
            } else {
                findViewById(a$f.uyw).setVisibility(8);
            }
        }
        a(new boolean[]{this.sJK.sMu, this.sJK.sMv}, new WalletFormView[]{this.sSc, this.sSb}, this.sRW, this.sRX);
        if (this.sSa.getVisibility() == 0) {
            switch (this.sJK.sMy) {
                case 1:
                    this.sRV.setVisibility(8);
                    break;
                case 2:
                    this.sRV.setVisibility(8);
                    break;
                case 3:
                    this.sRV.setText(com.tencent.mm.plugin.wxpay.a.i.uQd);
                    this.sRV.setVisibility(0);
                    break;
                case 4:
                    this.sRV.setVisibility(8);
                    break;
                default:
                    this.sRV.setVisibility(8);
                    break;
            }
            this.sRV.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bts));
        } else {
            this.sRV.setVisibility(8);
        }
        if (bh.ov(this.sJK.sMD) || !s.gE(this.sJK.sMD) || bMw()) {
            this.sSu.setVisibility(8);
            return;
        }
        this.sSu.setText(this.sJK.sME);
        this.sSu.setVisibility(0);
    }

    private static void a(WalletFormView walletFormView, String str) {
        if (bh.ov(str)) {
            walletFormView.setVisibility(8);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
    }

    private void jK(boolean z) {
        int i = 0;
        if (z) {
            int i2;
            this.rFp.setVisibility(this.sJK.sMG ? 0 : 8);
            WalletFormView walletFormView = this.sSh;
            if (this.sJK.sMG) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sSi;
            if (this.sJK.sMH) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sSj;
            if (this.sJK.sMI) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sSk;
            if (this.sJK.sML) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sSl;
            if (this.sJK.sMN) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.sSm;
            if (this.sJK.sMM) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.sSn;
            if (!this.sJK.sMO) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.sRY.setVisibility(4);
            return;
        }
        this.rFp.setVisibility(8);
        this.sSh.setVisibility(8);
        this.sSi.setVisibility(8);
        this.sSj.setVisibility(8);
        this.sSk.setVisibility(8);
        this.sSl.setVisibility(8);
        this.sSm.setVisibility(8);
        this.sSn.setVisibility(8);
        this.sRY.setVisibility(8);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 == null) {
                return;
            }
            if (z) {
                textView2.setVisibility(8);
                return;
            } else {
                textView2.setVisibility(4);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        a(zArr, walletFormViewArr, textView, textView2, false);
    }

    private void bMv() {
        if (XK()) {
            String text;
            com.tencent.mm.plugin.wallet_core.e.c.bNg();
            if (!bh.ov(this.sJK.sMD)) {
                Bundle bundle = this.vf;
                String str = "key_is_follow_bank_username";
                boolean z = this.sSu.getVisibility() == 0 && this.sSu.isChecked();
                bundle.putBoolean(str, z);
                this.vf.putString("key_bank_username", this.sJK.sMD);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
            if (!(this.sJK == null || favorPayInfo == null || this.sFy == null || this.sSr == null)) {
                if (this.sSr.containsKey(this.sJK.oZz)) {
                    favorPayInfo.sMT = ((a) this.sSr.get(this.sJK.oZz)).sQX.sDE;
                } else {
                    favorPayInfo.sMT = this.sFy.aM(favorPayInfo.sMT, false);
                }
                this.vf.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.sEt = new Authen();
            if (this.sRk != null) {
                this.sEt.oZA = this.sRk.sLd;
                this.sEt.sKz = this.sRk.field_bankcardTail;
            }
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
            text = e.aaB(this.sEt.sIF);
            this.vf.putString("key_mobile", text);
            this.vf.putBoolean("key_is_oversea", this.sJK.sIJ == 2);
            this.sEt.sKu = this.sGY.getText();
            this.sEt.sKt = this.sRj.getText();
            this.sEt.sKy = this.sSb.getText();
            favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.sEt.sKD = favorPayInfo.sMW;
                this.sEt.sKE = favorPayInfo.sMT;
            }
            x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.sEt.pCn + " elemt.bankcardTag : " + this.sJK.sIJ);
            x.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.sJK.sIJ);
            Bundle bundle2 = this.vf;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.sEt);
            bundle2.putString("key_bank_phone", this.sJK.sMC);
            bundle2.putString("key_country_code", this.countryCode);
            bundle2.putString("key_province_code", this.hhx);
            bundle2.putString("key_city_code", this.hhw);
            bundle2.putParcelable("key_profession", this.sJL);
            bundle2.putString("key_bind_card_type", this.sEt.oZz);
            bundle2.putString("key_bind_card_show1", this.sJK.nBM);
            bundle2.putString("key_bind_card_show2", 2 == this.sJK.sMz ? getString(com.tencent.mm.plugin.wxpay.a.i.uRc) : getString(com.tencent.mm.plugin.wxpay.a.i.uRr));
            if (cCd().k(new Object[]{this.sEt, this.pPl})) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.vf;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.sEO);
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            return false;
        }
        x.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEH;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            switch (i) {
                case 1:
                    this.sJK = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    this.sRk = null;
                    au();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.sSv = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bh.ov(intent.getStringExtra("Contact_City"))) {
                        this.nXC = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.nXD = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (bh.ov(stringExtra)) {
                            this.sSj.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.sSj.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (bh.ov(intent.getStringExtra("Contact_Province"))) {
                        this.nXD = this.sSv;
                        this.sSj.setText(stringExtra);
                    } else {
                        this.nXD = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.sSj.setText(stringExtra + " " + stringExtra3);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.sJK.sMM) {
                        this.sSm.setVisibility(0);
                    } else {
                        this.sSm.setVisibility(8);
                    }
                    x.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, this.nXD);
                    break;
                case 3:
                    this.sSq.aaI(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("ProviceName");
                    stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.hhx = intent.getStringExtra("Contact_Province");
                    this.hhw = intent.getStringExtra("Contact_City");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bh.ov(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!bh.ov(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!bh.ov(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.sSg.setText(stringBuilder.toString());
                    break;
                case 5:
                    this.sJL = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.sSf.setText(this.sJL.sKd);
                    break;
            }
            XK();
        }
    }

    private boolean XK() {
        boolean z;
        boolean z2;
        WalletFormView walletFormView = this.sSp;
        this.sSp = null;
        if (this.sSa.dQ(null)) {
            z = true;
        } else {
            if (this.sSp == null && walletFormView != this.sSa) {
                this.sSp = this.sSa;
            }
            this.sRV.setText(com.tencent.mm.plugin.wxpay.a.i.uQb);
            this.sRV.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
            z = false;
        }
        if (!this.sRj.dQ(null)) {
            if (this.sSp == null && walletFormView != this.sRj) {
                this.sSp = this.sRj;
            }
            z = false;
        }
        if (!this.sSq.dQ(this.sRT)) {
            if (this.sSp == null && walletFormView != this.sSq) {
                this.sSp = this.sSq;
            }
            z = false;
        }
        if (this.sGY.dQ(this.sHa) || this.sSs) {
            z2 = z;
            z = false;
        } else {
            if (this.sSp == null && walletFormView != this.sGY) {
                this.sSp = this.sGY;
            }
            this.sHa.setText(com.tencent.mm.plugin.wxpay.a.i.uyt);
            this.sHa.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
            z = true;
            z2 = false;
        }
        if (!this.sSe.dQ(this.sHa)) {
            if (z) {
                this.sHa.setText(com.tencent.mm.plugin.wxpay.a.i.uQk);
                this.sHa.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
            } else {
                this.sHa.setText(com.tencent.mm.plugin.wxpay.a.i.uQl);
                this.sHa.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btB));
            }
            if (this.sSp == null && walletFormView != this.sSe) {
                this.sSp = this.sSe;
            }
            z2 = false;
        } else if (z) {
            this.sHa.setVisibility(0);
        }
        if (this.sHa.getVisibility() == 4) {
            if (this.sJK.sMs) {
                this.sHa.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQo));
            } else {
                this.sHa.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQq));
            }
            this.sHa.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
            this.sHa.setVisibility(0);
        }
        if (this.sSc.dQ(this.sRX)) {
            z = false;
        } else {
            if (this.sSp == null && walletFormView != this.sSc) {
                this.sSp = this.sSc;
            }
            z = true;
            z2 = false;
        }
        if (!this.sSb.dQ(this.sRX)) {
            if (this.sSp == null && walletFormView != this.sSb) {
                this.sSp = this.sSb;
            }
            z2 = false;
        } else if (z) {
            this.sRX.setVisibility(4);
        }
        if (!this.sSt.isChecked()) {
            z2 = false;
        }
        if (!this.sSh.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSh) {
                this.sSp = this.sSh;
            }
            z2 = false;
        }
        if (!this.sSi.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSi) {
                this.sSp = this.sSi;
            }
            z2 = false;
        }
        if (!this.sSj.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSj) {
                this.sSp = this.sSj;
            }
            z2 = false;
        }
        if (!this.sSk.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSk) {
                this.sSp = this.sSk;
            }
            z2 = false;
        }
        if (!this.sSl.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSl) {
                this.sSp = this.sSl;
            }
            z2 = false;
        }
        if (!this.sSm.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSm) {
                this.sSp = this.sSm;
            }
            z2 = false;
        }
        if (!this.sSn.dQ(this.sRY)) {
            if (this.sSp == null && walletFormView != this.sSn) {
                this.sSp = this.sSn;
            }
            z2 = false;
        }
        if (this.sSx && !this.sSf.dQ(null)) {
            if (this.sSp == null && walletFormView != this.sSf) {
                this.sSp = this.sSf;
            }
            z2 = false;
        }
        if (this.sSw && !this.sSg.dQ(null)) {
            if (this.sSp == null && walletFormView != this.sSg) {
                this.sSp = this.sSg;
            }
            z2 = false;
        }
        if (z2) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.sCT.setEnabled(false);
            this.sCT.setClickable(false);
        }
        return z2;
    }

    public final void hx(boolean z) {
        XK();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.sSp != null) {
                    WalletFormView walletFormView = this.sSp;
                    if (walletFormView.zJG != null ? walletFormView.zJG.isFocusable() : false) {
                        walletFormView = this.sSp;
                        if (walletFormView.zJG != null) {
                            z = walletFormView.zJG.isClickable();
                        }
                        if (z && this.sSp.cCm()) {
                            this.sSp.cCo();
                        }
                    }
                    this.sSp.performClick();
                } else {
                    bMv();
                }
                return true;
            default:
                if (this.sSp != null) {
                    return false;
                }
                bMv();
                return false;
        }
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.sGV);
        super.onDestroy();
    }

    private static void a(WalletFormView walletFormView, int i) {
        com.tencent.mm.wallet_core.ui.formview.a.b bVar = walletFormView.zJJ;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).HG(i);
        }
    }

    private void zn(int i) {
        if (i == 1) {
            e(this.sGY, 1, false);
        } else {
            e(this.sGY, 1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private boolean bMw() {
        return this.vf.getBoolean("key_is_forgot_process", false);
    }
}
