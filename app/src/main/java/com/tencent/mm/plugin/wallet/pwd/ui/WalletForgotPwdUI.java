package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements WalletFormView.a {
    private ListView inm;
    private LinearLayout jNu;
    c sCQ = new 8(this);
    private Button sCT;
    private ArrayList<Bankcard> sCs = new ArrayList();
    private List<ElementQuery> sGO = new LinkedList();
    private Bankcard sGP;
    private a sGQ;
    private WalletFormView sGR;
    private WalletFormView sGS;
    private int sGT = 1;
    private boolean sGU = false;
    c sGV = new 7(this);

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletForgotPwdUI);
        if (ag != null) {
            ag.a(walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        if (!"1".equals(o.bLm().bMn().field_reset_passwd_flag)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
        } else if (bh.ov(o.bLm().bMn().field_find_passwd_url)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(f.ukK)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(f.ufK)).setOnClickListener(new 6(walletForgotPwdUI));
        } else {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(f.ukL)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(f.ukM);
            g gVar = new g(walletForgotPwdUI);
            gVar.sTw = new 5(walletForgotPwdUI);
            String string = walletForgotPwdUI.getString(a$i.uTS);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 12, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.uUi);
        if (!this.vf.getBoolean("key_is_force_bind", false)) {
            l(new com.tencent.mm.plugin.wallet_core.c.x(null, 6));
            uD(4);
        }
        initView();
        com.tencent.mm.sdk.b.a.xef.b(this.sGV);
        com.tencent.mm.sdk.b.a.xef.b(this.sCQ);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.sGV);
        com.tencent.mm.sdk.b.a.xef.c(this.sCQ);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        update();
    }

    private void update() {
        p.bJN();
        this.sCs = p.bJO().bLX();
        if (this.sCs == null || this.sCs.size() == 0 || this.vf.getBoolean("key_is_force_bind", false)) {
            x.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", new Object[]{Boolean.valueOf(this.vf.getBoolean("key_is_force_bind", false))});
            this.sCs = new ArrayList();
            this.jNu.setVisibility(0);
            this.inm.setVisibility(8);
            setMMTitle(a$i.uRt);
            ((TextView) findViewById(f.uyU)).setText(getString(a$i.uTU));
            WalletFormView walletFormView = this.sGS;
            p.bJN();
            walletFormView.setText(e.aaC(p.bJO().azp()));
            return;
        }
        x.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.ag(this) != null) {
            r(new t());
        }
        this.jNu.setVisibility(8);
        this.sCT.setVisibility(8);
        findViewById(f.urI).setVisibility(0);
        this.sGQ = new a(this, this);
        this.inm.setAdapter(this.sGQ);
        this.sGQ.hiv = this.sCs;
        this.sGQ.notifyDataSetChanged();
    }

    public void initView() {
        this.inm = (ListView) findViewById(f.uww);
        this.jNu = (LinearLayout) findViewById(f.ukJ);
        this.sGS = (WalletFormView) findViewById(f.urM);
        this.sGR = (WalletFormView) findViewById(f.uhs);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sGR);
        if (this.vf.getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.sGS);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sGS);
        }
        this.sGS.zJH = this;
        this.sGR.zJH = this;
        this.sCT = (Button) findViewById(f.cAg);
        this.sCT.setOnClickListener(new 1(this));
        this.sGU = false;
        p.bJN();
        this.sCs = p.bJO().bLX();
        update();
        findViewById(f.urI).setOnClickListener(new 2(this));
        XK();
        a(this.sGR, 0, false, false);
        this.sGR.r(new 3(this));
        this.sGR.pEi.setImageResource(a$h.uGK);
        this.sGR.pEi.setVisibility(0);
    }

    private void bKy() {
        this.vf.remove("elemt_query");
        this.vf.remove("key_bankcard");
        this.vf.remove("bank_name");
        this.vf.remove("key_card_id");
    }

    private void bKz() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.vf.getBoolean("key_is_reset_with_new_card", false));
        bKy();
        if (this.sGP == null && !this.sGU) {
            l(new t(null, this.sGR.getText(), null));
        } else if (this.sGU) {
            af bMn = o.bLm().bMn();
            if (bh.ov(bMn.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (cCc() != null) {
                    cCc().a(this, 0, bundle);
                    return;
                }
                return;
            }
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.l(this, bMn.field_find_passwd_url, false);
        } else {
            com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
            bundle.putParcelable("key_bankcard", this.sGP);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.sGO) {
                x.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.oZz);
                if (!bh.ov(parcelable.oZz) && !bh.ov(this.sGP.field_bankcardType) && parcelable.oZz.trim().equals(this.sGP.field_bankcardType.trim())) {
                    break;
                }
            }
            Object obj = elementQuery;
            bundle.putParcelable("elemt_query", parcelable);
            if (ag != null) {
                ag.a(this, 0, bundle);
            }
        }
    }

    protected final int getLayoutId() {
        return a$g.uEW;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", new Object[]{Integer.valueOf(i2), str, kVar});
        if (i == 0 && i2 == 0) {
            String str2;
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                Bundle bundle = new Bundle();
                if (bh.ov(tVar.kIw)) {
                    this.sGO = tVar.sIH;
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    return true;
                } else if (tVar.sII == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sGR.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.sII.isError()) {
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    h.h(this, a$i.uPD, a$i.dGO);
                    return true;
                } else {
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.sCs == null) {
                        i3 = 0;
                    } else {
                        i3 = this.sCs.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (this.sCs == null || this.sCs.size() == 0) {
                        bKy();
                        bundle.putString("bank_name", tVar.sII.nBM);
                        bundle.putParcelable("elemt_query", tVar.sII);
                        bundle.putString("key_card_id", this.sGR.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        com.tencent.mm.wallet_core.a.j(this, bundle);
                        return true;
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.sGQ == null);
                x.i(str4, str2, objArr2);
                if (this.sGQ != null) {
                    ArrayList arrayList = null;
                    if (o.bLq() != null) {
                        arrayList = o.bLq().bLX();
                    }
                    com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
                    if (ag != null) {
                        ag.cBi();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.sCs = arrayList2;
                        } else {
                            this.sCs = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.sCs == null ? 0 : this.sCs.size());
                    x.i(str4, str2, objArr3);
                    this.sGQ.hiv = this.sCs;
                    new com.tencent.mm.sdk.platformtools.af(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ WalletForgotPwdUI sGW;

                        {
                            this.sGW = r1;
                        }

                        public final void run() {
                            this.sGW.sGQ.notifyDataSetChanged();
                            WalletForgotPwdUI.c(this.sGW);
                        }
                    });
                }
            }
        }
        return false;
    }

    public final boolean aYj() {
        return true;
    }

    private boolean XK() {
        if (this.inm.getVisibility() == 0 || (this.sGS.XO() && this.sGR.XO())) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
            return true;
        }
        this.sCT.setEnabled(false);
        this.sCT.setClickable(false);
        return false;
    }

    public final void hx(boolean z) {
        XK();
    }

    protected boolean bKa() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final boolean aYf() {
        if ((this.sCs == null || this.sCs.size() == 0) && !bh.ov(o.bLm().bMn().field_find_passwd_url)) {
            return true;
        }
        return false;
    }

    protected final boolean aYi() {
        uD(aYf() ? 4 : 0);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i, intent);
        if (i2 == -1 && 1 == i) {
            this.sGR.aaI(intent.getStringExtra("key_bankcard_id"));
            bKz();
        }
    }
}
