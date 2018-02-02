package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

public class WalletBankcardManageUI extends WalletBaseUI {
    private ListView Fv = null;
    private OnItemClickListener SY = new 9(this);
    private OnClickListener inN = new 8(this);
    private o omB = new o();
    private View sCA;
    private View sCB;
    private CdnImageView sCC;
    private TextView sCD;
    private k sCE;
    public ArrayList<Bankcard> sCs = new ArrayList();
    private ArrayList<Bankcard> sCt = new ArrayList();
    protected ag sCu = null;
    private ListView sCv = null;
    private a sCw = null;
    private a sCx = null;
    private TextView sCy;
    private View sCz;

    protected final int getLayoutId() {
        return g.uEB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(4);
        x.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        p.bJN();
        this.sCu = p.bJO();
        setMMTitle(i.uSa);
        initView();
        com.tencent.mm.wallet_core.c.p.ft(5, 0);
        e.HF(27);
        this.sCE = com.tencent.mm.plugin.wallet_core.model.o.bLq().sQc;
        this.omB.sWX = new 1(this);
    }

    public void onResume() {
        if (this.sCu.bLL()) {
            jA(true);
        } else {
            this.sCu.d(this.sCs, this.sCt);
            if (this.sCu.szU != null) {
                uD(0);
            }
            jA(false);
        }
        this.omB.onResume();
        au();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.omB.onPause();
    }

    public void jA(boolean z) {
        if (z) {
            r(new com.tencent.mm.plugin.wallet_core.c.x(null, 12));
        } else {
            b(new com.tencent.mm.plugin.wallet_core.c.x(null, 12), false);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.omB.aYr();
        } else {
            this.omB.cancel();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.sCw.sBT.destory();
        this.sCx.sBT.destory();
    }

    protected final void initView() {
        setBackBtn(new 3(this));
        this.sCy = (TextView) findViewById(a$f.uxu);
        this.sCy.setOnClickListener(new 4(this));
        this.Fv = (ListView) findViewById(a$f.ufo);
        this.sCw = bJG();
        this.Fv.setAdapter(this.sCw);
        this.Fv.setOnItemClickListener(this.SY);
        this.sCv = (ListView) findViewById(a$f.uxt);
        this.sCx = new a(this, this.sCt);
        this.sCv.setAdapter(this.sCx);
        this.sCv.setOnItemClickListener(this.SY);
        this.sCz = findViewById(a$f.uyK);
        this.sCz.setOnClickListener(this.inN);
        this.sCA = findViewById(a$f.uyO);
        this.sCA.setOnClickListener(this.inN);
        this.sCB = findViewById(a$f.uyM);
        this.sCC = (CdnImageView) findViewById(a$f.uyN);
        this.sCD = (TextView) findViewById(a$f.uyL);
        bJF();
        findViewById(a$f.ueX).setOnClickListener(this.inN);
        b stVar = new st();
        stVar.fKA.fKC = "4";
        stVar.fqI = new 5(this, stVar);
        a.xef.m(stVar);
    }

    private void bJF() {
        com.tencent.mm.kernel.g.Dk();
        f MQ = f.MQ((String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) ""));
        if (!(MQ == null || bh.ov(MQ.sLE))) {
            if (!bh.ov(MQ.sLF)) {
                this.sCC.setUrl(MQ.sLF);
            }
            this.sCD.setText(MQ.sLE);
            if (MQ.sLA == 1) {
                this.sCB.setOnClickListener(new 6(this, MQ));
                this.sCB.setVisibility(0);
                return;
            } else if (MQ.sLA == 2) {
                this.sCB.setOnClickListener(new 7(this, MQ));
                this.sCB.setVisibility(0);
                return;
            } else {
                x.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(MQ.sLA));
            }
        }
        this.sCB.setVisibility(8);
    }

    public a bJG() {
        return new a(this, this.sCs);
    }

    public final void b(Bankcard bankcard) {
        com.tencent.mm.kernel.g.Dk();
        String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
        if (bh.ov(str)) {
            x.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            return;
        }
        x.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
    }

    private void au() {
        if (this.sCu.bLL()) {
            this.sCy.setEnabled(false);
        } else {
            this.sCu.bLJ();
            this.sCy.setEnabled(true);
        }
        if (this.sCs == null || this.sCs.size() <= 0) {
            this.Fv.setVisibility(8);
        } else {
            this.Fv.setVisibility(0);
        }
        if (this.sCt == null || this.sCt.size() <= 0) {
            this.sCv.setVisibility(8);
        } else {
            this.sCv.setVisibility(0);
        }
        if (this.sCE == null || this.sCE.field_is_show_entry != 1) {
            this.sCA.setVisibility(8);
        } else {
            boolean z;
            ((TextView) this.sCA.findViewById(a$f.uyQ)).setText(this.sCE.field_title);
            k kVar = this.sCE;
            TextView textView = (TextView) findViewById(a$f.uyY);
            int i = kVar.field_red_dot_index;
            com.tencent.mm.kernel.g.Dk();
            if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                x.i("MicroMsg.WalletBankcardManageUI", "red point update");
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView = (TextView) findViewById(a$f.uyP);
            if (kVar.field_is_overdue == 1) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
                textView.setText(i.uPN);
                textView.setTextColor(getResources().getColor(c.btB));
            } else if (!bh.ov(kVar.field_tips)) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
                textView.setText(kVar.field_tips);
            } else if (bh.ov(kVar.field_available_otb)) {
                textView.setVisibility(8);
                this.sCA.setVisibility(0);
            } else {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
                i = kVar.field_available_otb.indexOf(".");
                String str = kVar.field_available_otb;
                if (i > 0) {
                    str = str.substring(0, i);
                }
                textView.setText(getString(i.uPM, new Object[]{str}));
            }
            textView.setVisibility(0);
            this.sCA.setVisibility(0);
        }
        this.sCw.R(this.sCs);
        this.sCw.notifyDataSetChanged();
        this.sCx.R(this.sCt);
        this.sCx.notifyDataSetChanged();
        this.sCy.setEnabled(true);
    }

    public void bJH() {
        final Bundle bundle = new Bundle();
        this.omB.a(new 2(this, new Runnable(this) {
            final /* synthetic */ WalletBankcardManageUI sCF;

            public final void run() {
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                com.tencent.mm.wallet_core.a.a(this.sCF, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
            }
        }), new ae().bLI());
    }

    public final void bJI() {
        uD(0);
        this.sCu.d(this.sCs, this.sCt);
        au();
        bJF();
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            return false;
        }
        this.sCE = com.tencent.mm.plugin.wallet_core.model.o.bLq().sQc;
        bJI();
        return true;
    }

    public final boolean aYj() {
        return false;
    }

    public void finish() {
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b(this, "mall", ".ui.MallIndexUI", intent);
        }
        super.finish();
    }
}
