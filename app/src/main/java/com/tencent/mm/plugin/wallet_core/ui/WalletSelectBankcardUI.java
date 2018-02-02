package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int irz = 0;
    private TextView lkp;
    private TextView sWe;
    private MaxListView sWf;
    private a sWg = null;
    private String sWh = null;
    private boolean sWi = true;
    private String sWj = null;
    private List<Bankcard> sWk = null;

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        walletSelectBankcardUI.vf.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.cCd().k(new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uPC);
        this.irz = this.vf.getInt("key_scene", 0);
        this.sWh = this.vf.getString("key_top_tips");
        this.sWi = this.vf.getBoolean("key_is_show_new_bankcard", true);
        this.sWj = this.vf.getString("bottom_tips");
        this.sWk = this.vf.getParcelableArrayList("key_showing_bankcards");
        if (this.sWk == null) {
            this.sWk = o.bLq().bLX();
        }
        this.sWe = (TextView) findViewById(f.uxh);
        this.sWf = (MaxListView) findViewById(f.ufq);
        this.lkp = (TextView) findViewById(f.ufQ);
        if (bh.ov(this.sWh)) {
            this.sWe.setVisibility(8);
        } else {
            this.sWe.setVisibility(0);
            this.sWe.setText(this.sWh);
        }
        if (bh.ov(this.sWj)) {
            this.lkp.setVisibility(8);
        } else {
            this.lkp.setVisibility(0);
            this.lkp.setText(this.sWj);
        }
        if (this.irz == 0) {
            this.lkp.setVisibility(0);
            g gVar = new g(this);
            gVar.sTw = new 1(this);
            String string = getString(i.uWr);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 14, string.length(), 33);
            this.lkp.setText(spannableString);
            this.lkp.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.sWg = new a(this, (byte) 0);
        this.sWf.setAdapter(this.sWg);
        this.sWf.setOnItemClickListener(new 2(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uFP;
    }

    protected final boolean bKa() {
        return true;
    }
}
