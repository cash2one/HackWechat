package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import java.util.List;

@a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements WalletFormView$a {
    private int irz = -1;
    c sCQ = new c<ss>(this) {
        final /* synthetic */ WalletBankcardIdUI sRo;

        {
            this.sRo = r2;
            this.xen = ss.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.sRo.finish();
            return false;
        }
    };
    private Button sCT;
    c sGV = new 2(this);
    protected WalletFormView sRi;
    protected WalletFormView sRj;
    private Bankcard sRk;
    private a sRl;
    private boolean sRm = false;
    private boolean sRn;

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.mController.xIM.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(g.uCa, null);
        textView.setText(walletBankcardIdUI.getString(i.uQC));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(d.bvv);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(walletBankcardIdUI.mController.xIM, walletBankcardIdUI.getString(i.uQB), walletBankcardIdUI.getString(i.uRP), textView, new OnClickListener(walletBankcardIdUI) {
            final /* synthetic */ WalletBankcardIdUI sRo;

            {
                this.sRo = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletBankcardIdUI);
        if (ag != null) {
            ag.c(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
    }

    protected final int getLayoutId() {
        return g.uEz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uSj);
        initView();
        com.tencent.mm.sdk.b.a.xef.b(this.sCQ);
        com.tencent.mm.sdk.b.a.xef.b(this.sGV);
        this.irz = this.vf.getInt("key_bind_scene");
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.sCQ);
        com.tencent.mm.sdk.b.a.xef.c(this.sGV);
        super.onDestroy();
    }

    protected final void initView() {
        this.sCT = (Button) findViewById(a$f.cAg);
        this.sRi = (WalletFormView) findViewById(a$f.uhu);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sRi);
        this.sRj = (WalletFormView) findViewById(a$f.urM);
        if (this.vf.getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.sRj);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sRj);
        }
        this.sRi.zJH = this;
        this.sCT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletBankcardIdUI sRo;

            {
                this.sRo = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11353, Integer.valueOf(1), Integer.valueOf(0));
                this.sRo.bKz();
            }
        });
        com.tencent.mm.wallet_core.c cCc = cCc();
        if (cCc != null) {
            this.sRn = cCc.msB.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.sRn = false;
        }
        if (this.sRn) {
            setMMTitle(i.uVB);
        } else {
            setMMTitle(i.uSj);
        }
        TextView textView = (TextView) findViewById(a$f.ula);
        if (o.bLq().bLJ() || o.bLq().bLN()) {
            g gVar = new g(this);
            gVar.sTw = new 4(this);
            String string = getString(i.uSh);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            CharSequence string2 = this.vf.getString("key_custom_bind_tips");
            if (!bh.ov(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.vf.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            a a = b.sRa.a(orders);
            TextView textView2 = (TextView) findViewById(a$f.uyp);
            if (a != null) {
                List Nh = a.Nh(a.Nk(favorPayInfo.sMT));
                if (Nh.size() > 0) {
                    this.sRl = new a(this.mController.xIM, Nh);
                    textView2.setText(i.uSf);
                    textView2.setOnClickListener(new 5(this));
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                x.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        ag bLq = o.bLq();
        if (!bLq.bLM() || bLq.azp() == null || bh.ov(bLq.azp().trim()) || !bLq.bLR()) {
            this.sRj.setVisibility(8);
            this.sRi.setHint(getString(i.uSi));
        } else {
            this.sRj.setVisibility(0);
            this.sRj.setText(bLq.azp());
            this.sRi.setHint(getString(i.uQz));
            this.sRj.setClickable(false);
            this.sRj.setEnabled(false);
        }
        com.tencent.mm.kernel.g.Dk();
        String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, null);
        if (!bh.ov(str)) {
            this.sRi.setHint(str);
        }
        this.sRk = (Bankcard) this.vf.getParcelable("key_history_bankcard");
        if (this.sRk != null) {
            this.sRi.setText(this.sRk.sLa);
            this.sRi.a(new 6(this));
        }
        XK();
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 2);
        e(this.sRi, 0, false);
        this.sRi.r(new 7(this));
        if (o.bLq().bLQ().bLE()) {
            this.sRi.pEi.setVisibility(0);
            this.sRi.pEi.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uGK);
        }
    }

    protected final void bKz() {
        if (cCc() == null) {
            x.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            return;
        }
        String string = cCc().msB.getString("kreq_token");
        int i = this.vf.getInt("entry_scene", -1);
        if (this.sRk != null) {
            k tVar = new t(bJQ(), null, (PayInfo) this.vf.getParcelable("key_pay_info"), string, this.irz, i);
            tVar.pJp = this.sRk.field_bankcardType;
            this.vf.putParcelable("key_history_bankcard", this.sRk);
            l(tVar);
        } else if (XK()) {
            l(new t(bJQ(), this.sRi.getText(), (PayInfo) this.vf.getParcelable("key_pay_info"), string, this.irz, i));
        } else {
            h.h(this, i.uTc, i.dGO);
        }
    }

    protected Dialog onCreateDialog(int i) {
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(g.uFd, null);
            ((ListViewInScrollView) inflate.findViewById(a$f.bJe)).setAdapter(this.sRl);
            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
            aVar.Ez(i.uSe);
            aVar.dk(inflate);
            aVar.d(null);
            aVar.EC(i.uRP);
            return aVar.akx();
        } else if (!this.sRn || i != 1000) {
            return super.onCreateDialog(i);
        } else {
            int b;
            String string = getString(i.uSg);
            com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                b = ag.b(this, 1);
            } else {
                b = -1;
            }
            if (b != -1) {
                string = getString(b);
            }
            return h.a(this, true, string, "", getString(i.dHd), getString(i.dFR), new 8(this), new 9(this));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                bundle.putBoolean("key_need_area", tVar.bKJ());
                bundle.putBoolean("key_need_profession", tVar.bKK());
                bundle.putParcelableArray("key_profession_list", tVar.sIM);
                if (tVar.sII == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sRi.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.sII.sMx && tVar.sII.isError()) {
                    h.h(this, i.uPD, i.dGO);
                    return true;
                } else {
                    bundle.putString("bank_name", tVar.sII.nBM);
                    bundle.putParcelable("elemt_query", tVar.sII);
                    bundle.putString("key_card_id", this.sRi.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.sRi.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            return true;
        }
        return false;
    }

    private boolean XK() {
        if (this.sRi.dQ(null)) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
            return true;
        }
        this.sCT.setEnabled(false);
        this.sCT.setClickable(false);
        return false;
    }

    public final void hx(boolean z) {
        if (!z) {
            this.sRk = null;
            this.vf.putParcelable("key_history_bankcard", null);
        }
        XK();
    }

    protected final boolean bKa() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
