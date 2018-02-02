package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.st;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a(3)
public class WalletBalanceFetchUI extends WalletBaseUI implements WalletFormView.a {
    private String fuH = null;
    private final int iiI = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 270);
    private View kND;
    private Button lRZ;
    private double pLR;
    private int szA = 0;
    private DecimalFormat szB = new DecimalFormat("0.00");
    private boolean szC = false;
    private boolean szD = false;
    private boolean szE = false;
    private boolean szF = false;
    private boolean szG = false;
    private ArrayList<Bankcard> szk;
    private Bankcard szl;
    private String szm;
    private WalletFormView szn;
    private WalletFormView szo;
    private View szp;
    private TextView szq;
    private TextView szr;
    private TextView szs;
    private TextView szt;
    private TextView szu;
    private int szv = 0;
    private int szw = 0;
    private int szx = 0;
    private double szy = 0.0d;
    private int szz = -1;

    class AnonymousClass10 implements p$c {
        final /* synthetic */ WalletBalanceFetchUI szH;
        final /* synthetic */ List szJ;
        final /* synthetic */ Context val$context;

        AnonymousClass10(WalletBalanceFetchUI walletBalanceFetchUI, List list, Context context) {
            this.szH = walletBalanceFetchUI;
            this.szJ = list;
            this.val$context = context;
        }

        public final void a(n nVar) {
            int i = 0;
            for (final Bankcard bankcard : this.szJ) {
                String str;
                CharSequence spannableString;
                CharSequence spannableString2;
                Bitmap a;
                e h = b.h(this.val$context, bankcard.field_bankcardType, bankcard.bKO());
                String str2 = "";
                if (h != null) {
                    str2 = h.oPH;
                }
                x.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", new Object[]{str2});
                Bitmap a2 = j.a(new c(str2));
                str2 = "";
                if (!bh.ov(bankcard.field_forbidWord)) {
                    str2 = bankcard.field_forbidWord;
                }
                if (bh.ov(bankcard.field_forbid_title)) {
                    str = str2;
                    spannableString = new SpannableString(str2);
                } else {
                    String str3 = str2 + " ";
                    spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                    AnonymousClass1 anonymousClass1 = new g(this, this.val$context) {
                        final /* synthetic */ AnonymousClass10 szK;

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            x.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", new Object[]{bankcard.field_forbid_url});
                            intent.putExtra("rawUrl", r1);
                            intent.putExtra("geta8key_username", q.FS());
                            intent.putExtra("pay_channel", 1);
                            d.b(this.szK.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        }
                    };
                    int length = str3.length();
                    int length2 = str3.length() + bankcard.field_forbid_title.length();
                    spannableString.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a$c.ubF)), length, length2, 33);
                    spannableString.setSpan(anonymousClass1, length, length2, 33);
                    str = str3;
                }
                if (bh.M(spannableString)) {
                    spannableString2 = new SpannableString(bankcard.field_fetchArriveTimeWording);
                } else {
                    spannableString2 = spannableString;
                }
                spannableString = bankcard.field_desc;
                if (a2 != null) {
                    a = com.tencent.mm.sdk.platformtools.d.a(a2, this.val$context.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.ucs), this.val$context.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.ucs), true, false);
                } else {
                    a = null;
                }
                x.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), spannableString, spannableString2});
                int i2 = i + 1;
                nVar.a(i, spannableString, spannableString2, a == null ? null : new BitmapDrawable(a), !bh.ov(str));
                i = i2;
            }
            nVar.f(i, this.val$context.getString(i.uPf));
        }
    }

    static /* synthetic */ void e(WalletBalanceFetchUI walletBalanceFetchUI) {
        walletBalanceFetchUI.pLR = bh.getDouble(walletBalanceFetchUI.szn.getText(), 0.0d);
        String str = "";
        if (walletBalanceFetchUI.szl != null) {
            str = walletBalanceFetchUI.szl.field_bankcardType;
        } else {
            com.tencent.mm.plugin.wallet_core.model.g bKX = com.tencent.mm.plugin.wallet_core.model.g.bKX();
            if (bKX.aHh()) {
                h.b(walletBalanceFetchUI, bKX.oZB, walletBalanceFetchUI.getString(i.dGO), true);
                return;
            }
        }
        if (walletBalanceFetchUI.szl != null && !bh.ov(walletBalanceFetchUI.szl.field_forbidWord)) {
            u.makeText(walletBalanceFetchUI.mController.xIM, walletBalanceFetchUI.szl.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.pLR <= 0.0d || !walletBalanceFetchUI.szn.XO()) {
            u.makeText(walletBalanceFetchUI.mController.xIM, i.uPA, 0).show();
        } else {
            double d = walletBalanceFetchUI.pLR;
            p.bJN();
            if (d > p.bJO().szU.sLf) {
                u.makeText(walletBalanceFetchUI.mController.xIM, i.uPb, 0).show();
                return;
            }
            d = walletBalanceFetchUI.pLR;
            p.bJN();
            if (d > p.bJO().szU.sLh) {
                u.makeText(walletBalanceFetchUI.mController.xIM, i.uPc, 0).show();
            } else {
                walletBalanceFetchUI.l(new com.tencent.mm.plugin.wallet.balance.a.b(walletBalanceFetchUI.pLR, "CNY", str, walletBalanceFetchUI.szA));
            }
        }
    }

    static /* synthetic */ void f(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        String str;
        if (!(walletBalanceFetchUI.szl == null || walletBalanceFetchUI.szv == 0 || ((walletBalanceFetchUI.szv == 1 && walletBalanceFetchUI.szl.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.szv == 1 && walletBalanceFetchUI.szl.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.szw == 0)))) {
            d = walletBalanceFetchUI.szy;
            p.bJN();
            if (d < p.bJO().szU.sLh) {
                if (walletBalanceFetchUI.szl != null) {
                    p.bJN();
                    d = p.bJO().szU.sLh - walletBalanceFetchUI.szl.field_full_fetch_charge_fee;
                } else {
                    p.bJN();
                    d = p.bJO().szU.sLh;
                }
                if (walletBalanceFetchUI.szx != 1) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.szA = 1;
                    if (walletBalanceFetchUI.szl != null || bh.ov(walletBalanceFetchUI.szl.field_forbidWord)) {
                        str = "";
                        if (walletBalanceFetchUI.szl != null) {
                            str = walletBalanceFetchUI.szl.field_bankcardType;
                        }
                        walletBalanceFetchUI.l(new com.tencent.mm.plugin.wallet.balance.a.b(walletBalanceFetchUI.pLR, "CNY", str, walletBalanceFetchUI.szA));
                    }
                    u.makeText(walletBalanceFetchUI.mController.xIM, walletBalanceFetchUI.szl.field_forbidWord, 0).show();
                    return;
                }
                walletBalanceFetchUI.szn.setText(walletBalanceFetchUI.szB.format(d));
                walletBalanceFetchUI.bJp();
                walletBalanceFetchUI.szA = 1;
                x.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                return;
            }
        }
        p.bJN();
        d = p.bJO().szU.sLh;
        if (walletBalanceFetchUI.szx != 1) {
            walletBalanceFetchUI.szn.setText(walletBalanceFetchUI.szB.format(d));
            walletBalanceFetchUI.bJp();
            walletBalanceFetchUI.szA = 1;
            x.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
            return;
        }
        x.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
        walletBalanceFetchUI.szA = 1;
        if (walletBalanceFetchUI.szl != null) {
        }
        str = "";
        if (walletBalanceFetchUI.szl != null) {
            str = walletBalanceFetchUI.szl.field_bankcardType;
        }
        walletBalanceFetchUI.l(new com.tencent.mm.plugin.wallet.balance.a.b(walletBalanceFetchUI.pLR, "CNY", str, walletBalanceFetchUI.szA));
    }

    static /* synthetic */ void h(WalletBalanceFetchUI walletBalanceFetchUI) {
        if (walletBalanceFetchUI.kND != null) {
            int[] iArr = new int[2];
            walletBalanceFetchUI.lRZ.getLocationInWindow(iArr);
            int eB = (com.tencent.mm.bv.a.eB(walletBalanceFetchUI) - r0) - com.tencent.mm.bv.a.fromDPToPix(walletBalanceFetchUI, 30);
            x.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + walletBalanceFetchUI.lRZ.getHeight()), Integer.valueOf(com.tencent.mm.bv.a.eB(walletBalanceFetchUI)), Integer.valueOf(eB), Integer.valueOf(walletBalanceFetchUI.iiI)});
            if (eB > 0 && eB < walletBalanceFetchUI.iiI) {
                x.d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(walletBalanceFetchUI.iiI - eB)});
                walletBalanceFetchUI.kND.post(new 18(walletBalanceFetchUI, r0));
            }
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Y(getIntent());
        bnw();
        this.szm = getString(i.uPx);
        initView();
        au();
        com.tencent.mm.wallet_core.c.p.ft(4, 0);
    }

    public void onDestroy() {
        this.szo.zJI = null;
        super.onDestroy();
    }

    private void bnw() {
        p.bJN();
        ag bJO = p.bJO();
        if (this.szC) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            x.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.szk != null && this.szk.size() > 0) {
                arrayList.addAll(this.szk);
            }
            this.szk = bJO.bLZ();
            if (this.szk != null && this.szk.size() > 0) {
                arrayList2.addAll(this.szk);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                Collection arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = bJO.a(this.szk, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.szk != null && i < this.szk.size()) {
                        bankcard = (Bankcard) this.szk.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.szz = i;
                            break;
                        }
                        i++;
                    }
                    this.szl = bankcard2;
                    this.szC = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
                bankcard2 = bankcard;
            } else {
                bankcard2 = bJO.a(this.szk, null, false, true);
            }
            i = 0;
            while (this.szk != null) {
                bankcard = (Bankcard) this.szk.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.szl = bankcard2;
            this.szC = false;
        } else {
            this.szk = bJO.bLZ();
            this.szl = bJO.a(this.szk, null, false, true);
        }
        if (bJO.sQd != null) {
            this.szv = bJO.sQd.szv;
            this.szw = bJO.sQd.szw;
            this.szy = bJO.sQd.szy;
            this.szx = bJO.sQd.szx;
        } else {
            x.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        x.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.szv + " is_cal_charge:" + this.szw + " min_charge_fee:" + this.szy + " is_full_fetch_direct:" + this.szx);
    }

    protected final void initView() {
        setMMTitle(i.uPe);
        this.kND = findViewById(f.uky);
        this.szo = (WalletFormView) findViewById(f.ueK);
        this.szo.zJI = new 1(this);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.szo);
        OnClickListener 11 = new 11(this);
        this.szp = findViewById(f.ueL);
        this.szp.setOnClickListener(11);
        this.szo.setOnClickListener(11);
        this.szn = (WalletFormView) findViewById(f.ueN);
        e(this.szn, 2, false);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.szn);
        this.szn.zJH = this;
        this.lRZ = (Button) findViewById(f.cAg);
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI szH;

            {
                this.szH = r1;
            }

            public final void onClick(View view) {
                WalletBalanceFetchUI.e(this.szH);
            }
        });
        this.lRZ.setEnabled(false);
        this.szq = (TextView) findViewById(f.uxv);
        this.szr = (TextView) findViewById(f.ueP);
        this.szs = (TextView) findViewById(f.ueO);
        this.szt = (TextView) findViewById(f.ukx);
        this.szu = (TextView) findViewById(f.ukw);
        this.szu.setOnClickListener(new 13(this));
        this.szn.a(new 14(this));
        this.ofE = new 15(this);
        com.tencent.mm.sdk.b.b stVar = new st();
        stVar.fKA.fKC = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        stVar.fqI = new 16(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }

    public void onResume() {
        bJq();
        super.onResume();
    }

    private void au() {
        if (this.szn.jJn != null) {
            this.szn.jJn.setText(String.format(getString(i.uNP), new Object[]{com.tencent.mm.wallet_core.c.u.cBD()}));
        } else {
            x.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        if (this.szl != null) {
            this.szo.setText(this.szl.field_desc);
            this.szo.setVisibility(0);
            if (this.szo.pEj == null) {
                x.i("MicroMsg.WalletBalanceFetchUI", "mBankcardEHV.getTipsTv() is null");
            } else if (!bh.ov(this.szl.field_fetchArriveTimeWording)) {
                this.szo.pEj.setText(this.szl.field_fetchArriveTimeWording);
                this.szo.pEj.setVisibility(0);
                if (this.szl.field_is_hightlight_pre_arrive_time_wording == 1) {
                    this.szo.pEj.setTextColor(Color.parseColor("#FA962A"));
                } else {
                    this.szo.pEj.setTextColor(Color.parseColor("#B2B2B2"));
                }
            }
            this.szs.setText("");
        } else {
            this.szo.setText(this.szm);
            if (this.szo.pEj != null) {
                this.szo.pEj.setText("");
                this.szo.pEj.setVisibility(8);
            }
        }
        this.szs.setVisibility(8);
        p.bJN();
        CharSequence charSequence = p.bJO().szU.sLj;
        if (bh.ov(charSequence)) {
            this.szr.setVisibility(8);
        } else {
            this.szr.setVisibility(0);
            this.szr.setText(charSequence);
        }
        bJp();
        p.bJN();
        final com.tencent.mm.plugin.wallet_core.model.b bVar = p.bJO().sQd;
        this.mController.removeAllOptionMenu();
        if (bVar != null && bVar.sKN != null && bVar.sKN.sKP != null && bVar.sKN.sKP.length > 0) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.h.duY, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBalanceFetchUI szH;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.szH.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
                    gVar.rKC = new 1(this);
                    gVar.rKD = new 2(this);
                    gVar.bUk();
                    return true;
                }
            });
        }
    }

    private void bJp() {
        this.pLR = bh.getDouble(this.szn.getText(), 0.0d);
        if (this.pLR > 0.0d) {
            this.lRZ.setEnabled(true);
        } else {
            this.lRZ.setEnabled(false);
        }
        double d = this.pLR;
        p.bJN();
        if (!(d == p.bJO().szU.sLh || this.szl == null)) {
            d = this.pLR;
            p.bJN();
            if (d != p.bJO().szU.sLh - this.szl.field_full_fetch_charge_fee) {
                this.szA = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        double d2 = this.pLR;
        p.bJN();
        if (d2 > p.bJO().szU.sLf) {
            this.szu.setVisibility(8);
            this.szt.setTextColor(getResources().getColor(a$c.btB));
            stringBuilder.append(getString(i.uPh));
        } else {
            String str;
            if (!(this.szl == null || this.szv == 0 || ((this.szv == 1 && this.szl.field_fetch_charge_rate <= 0.0d) || (this.szv == 1 && this.szl.field_fetch_charge_rate > 0.0d && this.szw == 0)))) {
                d2 = this.szy;
                p.bJN();
                if (d2 < p.bJO().szU.sLh) {
                    if (this.szv == 1 && this.szl.field_fetch_charge_rate > 0.0d && this.szw == 1 && (this.pLR <= 0.0d || !this.szn.XO())) {
                        this.szu.setVisibility(0);
                        this.szt.setTextColor(getResources().getColor(a$c.bsO));
                        p.bJN();
                        str = p.bJO().szU.sLk;
                        if (bh.ov(str)) {
                            x.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                            p.bJN();
                            d2 = p.bJO().szU.sLh;
                            stringBuilder.append(getString(i.uOY, new Object[]{com.tencent.mm.wallet_core.ui.e.d(d2, "CNY")}));
                        } else {
                            stringBuilder.append(str);
                        }
                        stringBuilder.append("，");
                    } else if (this.szv == 1 && this.szl.field_fetch_charge_rate > 0.0d && this.szw == 1) {
                        this.szu.setVisibility(8);
                        this.szt.setTextColor(getResources().getColor(a$c.bsO));
                        d2 = this.pLR;
                        p.bJN();
                        if (d2 != p.bJO().szU.sLh - this.szl.field_full_fetch_charge_fee || this.szl.field_full_fetch_charge_fee <= 0.0d) {
                            int i = i.uOP;
                            Object[] objArr = new Object[2];
                            double d3 = this.pLR;
                            p.bJN();
                            ag bJO = p.bJO();
                            objArr[0] = com.tencent.mm.wallet_core.ui.e.d(Math.max(((double) Math.round(((d3 - bJO.sQd.pKP) * this.szl.field_fetch_charge_rate) * 100.0d)) / 100.0d, bJO.sQd.szy), "CNY");
                            objArr[1] = (this.szl.field_fetch_charge_rate * 100.0d) + "%";
                            stringBuilder.append(getString(i, objArr));
                        } else {
                            stringBuilder.append(getString(i.uOP, new Object[]{com.tencent.mm.wallet_core.ui.e.d(this.szl.field_full_fetch_charge_fee, "CNY"), (this.szl.field_fetch_charge_rate * 100.0d) + "%"}));
                        }
                    }
                }
            }
            this.szu.setVisibility(0);
            this.szt.setTextColor(getResources().getColor(a$c.bsO));
            p.bJN();
            str = p.bJO().szU.sLk;
            if (bh.ov(str)) {
                x.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                p.bJN();
                d2 = p.bJO().szU.sLh;
                stringBuilder.append(getString(i.uOY, new Object[]{com.tencent.mm.wallet_core.ui.e.d(d2, "CNY")}));
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append("，");
        }
        this.szt.setText(stringBuilder.toString());
    }

    private void a(com.tencent.mm.plugin.wallet.balance.a.b bVar) {
        if (bh.ov(this.fuH)) {
            x.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            return;
        }
        Parcelable payInfo = new PayInfo();
        payInfo.fuH = this.fuH;
        payInfo.fCV = 21;
        this.vf.putParcelable("key_pay_info", payInfo);
        payInfo = new Orders();
        payInfo.pNX = bVar.pKW - bVar.pKL;
        payInfo.sNF = bVar.pKW - bVar.pKL;
        payInfo.sNW.add(new Commodity());
        payInfo.pKL = bVar.pKL;
        this.vf.putParcelable("key_orders", payInfo);
        this.vf.putParcelable("key_bankcard", this.szl);
        if (cCc() == null) {
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.b.class, this.vf, null);
            return;
        }
        cCd().k(this.vf);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            boolean a;
            if (kVar instanceof com.tencent.mm.plugin.wallet.balance.a.b) {
                com.tencent.mm.plugin.wallet.balance.a.b bVar = (com.tencent.mm.plugin.wallet.balance.a.b) kVar;
                this.szD = false;
                if (!this.szG) {
                    this.szE = false;
                }
                this.szF = false;
                this.szG = false;
                if ("1".equals(bVar.fKP)) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    String str2 = bVar.fKQ;
                    str2 = bVar.fKR;
                    str2 = bVar.fKS;
                    aYf();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, 0);
                } else if ("2".equals(bVar.fKP)) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bVar.fKQ, bVar.fKT, bVar.fKR, bVar.fKS, aYf(), null);
                } else {
                    x.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + bVar.fKP);
                    a = false;
                }
                if (!a) {
                    t.j(21, bVar.fwY, i2);
                    if (!b(bVar)) {
                        this.fuH = bVar.fwY;
                        a(bVar);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
                bnw();
                au();
                if (this.szv != 0) {
                    x.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.szv);
                } else {
                    com.tencent.mm.kernel.g.Dk();
                    a = ((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xrj, Boolean.valueOf(false))).booleanValue();
                    p.bJN();
                    com.tencent.mm.plugin.wallet_core.model.b bVar2 = p.bJO().sQd;
                    if (!(bVar2 == null || a)) {
                        double d = bVar2.pKP;
                        h.a(this, getString(i.uUO, new Object[]{com.tencent.mm.wallet_core.ui.e.u(d)}), getString(i.uUP), getString(i.uRP), getString(i.uUQ), new 8(this), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBalanceFetchUI szH;

                            {
                                this.szH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.szH.getString(i.uRE));
                                intent.putExtra("showShare", false);
                                d.b(this.szH, "webview", ".ui.tools.WebViewUI", intent);
                                dialogInterface.dismiss();
                            }
                        }, a$c.bui);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xrj, Boolean.valueOf(true));
                    }
                }
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.balance.a.b) {
            t.j(21, "", i2);
            bJq();
        }
        return false;
    }

    public final void hx(boolean z) {
        this.szn.dQ(null);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1 || intent == null) {
            x.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.szz;
            this.szz = intExtra;
            x.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is " + intExtra);
            if (this.szk == null || intExtra < 0 || intExtra >= this.szk.size()) {
                if (this.szk == null || intExtra < 0 || intExtra > this.szk.size()) {
                    this.szl = null;
                } else {
                    this.szz = i3;
                }
                bJr();
            } else {
                this.szl = (Bankcard) this.szk.get(intExtra);
            }
            au();
        }
    }

    private boolean b(com.tencent.mm.plugin.wallet.balance.a.b bVar) {
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.b bVar2;
        if (this.szD) {
            z = false;
        } else if (bVar.syc) {
            this.szD = true;
            h.a(this, false, bVar.syd, "", getString(i.dFU), getString(i.dEn), new 2(this, bVar), new 3(this));
            z = true;
        } else {
            z = false;
        }
        if (!(z || this.szE)) {
            bVar2 = bVar.sye;
            if (bVar2 == null || (TextUtils.isEmpty(bVar2.sKJ) && (bVar2.sKK == null || bVar2.sKK.size() <= 0))) {
                z = false;
            } else {
                this.szE = true;
                com.tencent.mm.plugin.wallet_core.ui.h.a(this, bVar2, false, new 4(this, bVar), new 5(this));
                z = true;
            }
        }
        if (z || this.szF) {
            return z;
        }
        bVar2 = bVar.syf;
        if (bVar2 == null || (TextUtils.isEmpty(bVar2.sKJ) && (bVar2.sKK == null || bVar2.sKK.size() <= 0))) {
            return false;
        }
        this.szF = true;
        com.tencent.mm.plugin.wallet_core.ui.h.a(this, bVar2, true, new 6(this), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI szH;

            {
                this.szH = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.szH.bJq();
            }
        });
        return true;
    }

    private void bJq() {
        this.szD = false;
        this.szE = false;
        this.szF = false;
        this.szG = false;
    }

    protected void onNewIntent(Intent intent) {
        bJq();
        Y(intent);
    }

    private void Y(Intent intent) {
        boolean z = false;
        if (intent != null && intent.getBooleanExtra("intent_bind_end", false)) {
            z = true;
        }
        this.szC = z;
        if (this.szC) {
            x.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.vf.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.fuH = this.fuH;
                payInfo.fCV = 21;
            }
            if (com.tencent.mm.plugin.wallet.b.a.bKG()) {
                r(new v(payInfo.fuH));
            } else {
                r(new com.tencent.mm.plugin.wallet_core.c.x(payInfo.fuH, 4));
            }
        }
    }

    private void bJr() {
        com.tencent.mm.plugin.wallet_core.model.g bKX = com.tencent.mm.plugin.wallet_core.model.g.bKX();
        if (bKX.aHh()) {
            h.b(this, bKX.oZB, getString(i.dGO), true);
            return;
        }
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) this.vf.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.fuH = this.fuH;
            parcelable.fCV = 21;
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.sya);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
    }
}
