package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.a;
import java.util.Iterator;
import org.xwalk.core.Log;

public class WalletECardLogoutUI extends WalletECardBaseUI {
    private TextView ihX;
    private TextView jJn;
    private String sBM;
    private String sQZ;
    private TextView sZS;
    private LinearLayout sZT;
    private View sZU;
    private CdnImageView sZV;
    private Button sZW;

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI) {
        Log.i("MicroMsg.WalletECardLogoutUI", "do logout");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_show_detail", false);
        Parcelable bankcard = new Bankcard();
        bankcard.field_bindSerial = walletECardLogoutUI.sBM;
        bankcard.field_bankcardType = walletECardLogoutUI.sQZ;
        bundle.putParcelable("key_bankcard", bankcard);
        bundle.putInt("scene", 2);
        a.a(walletECardLogoutUI, com.tencent.mm.plugin.wallet.bind.a.class, bundle);
    }

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI, azk com_tencent_mm_protocal_c_azk) {
        if (!bh.ov(com_tencent_mm_protocal_c_azk.wGr)) {
            walletECardLogoutUI.setMMTitle(com_tencent_mm_protocal_c_azk.wGr);
        }
        if (!bh.ov(com_tencent_mm_protocal_c_azk.wGs)) {
            walletECardLogoutUI.jJn.setText(com_tencent_mm_protocal_c_azk.wGs);
        }
        if (!bh.ov(com_tencent_mm_protocal_c_azk.kJP)) {
            walletECardLogoutUI.sZV.setUrl(com_tencent_mm_protocal_c_azk.kJP);
        }
        if (com_tencent_mm_protocal_c_azk.wGt != null) {
            ju juVar = com_tencent_mm_protocal_c_azk.wGt;
            if (!bh.ov(juVar.vQJ)) {
                walletECardLogoutUI.sZS.setText(juVar.vQJ);
            }
            if (juVar.vQK != null) {
                Iterator it = juVar.vQK.iterator();
                while (it.hasNext()) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(walletECardLogoutUI).inflate(g.uBO, walletECardLogoutUI.sZT, false);
                    ((TextView) linearLayout.findViewById(f.ujP)).setText((String) it.next());
                    walletECardLogoutUI.sZT.addView(linearLayout);
                }
            }
        }
        if (com_tencent_mm_protocal_c_azk.wGw != null) {
            Log.i("MicroMsg.WalletECardLogoutUI", "show trade detail");
            boe com_tencent_mm_protocal_c_boe = com_tencent_mm_protocal_c_azk.wGw;
            if (!bh.ov(com_tencent_mm_protocal_c_boe.title)) {
                l lVar = new l(new 5(walletECardLogoutUI, com_tencent_mm_protocal_c_boe));
                CharSequence spannableString = new SpannableString(com_tencent_mm_protocal_c_boe.title);
                spannableString.setSpan(lVar, 0, spannableString.length(), 18);
                walletECardLogoutUI.ihX.setClickable(true);
                walletECardLogoutUI.ihX.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(walletECardLogoutUI));
                walletECardLogoutUI.ihX.setText(spannableString);
                walletECardLogoutUI.ihX.setOnClickListener(new 6(walletECardLogoutUI));
                walletECardLogoutUI.ihX.setVisibility(0);
            }
        }
        walletECardLogoutUI.sZU.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(2931);
        initView();
        setMMTitle(i.uJd);
        Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
        k gVar = new com.tencent.mm.plugin.wallet_ecard.a.g();
        gVar.k(this);
        b(gVar, true);
    }

    protected final void initView() {
        this.jJn = (TextView) findViewById(f.ujW);
        this.sZS = (TextView) findViewById(f.ujV);
        this.sZT = (LinearLayout) findViewById(f.ujU);
        this.ihX = (TextView) findViewById(f.ujQ);
        this.sZV = (CdnImageView) findViewById(f.ujR);
        this.sZU = findViewById(f.ujT);
        this.sZW = (Button) findViewById(f.ujS);
        this.sZW.setOnClickListener(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        jj(2931);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.g)) {
            return false;
        }
        com.tencent.mm.plugin.wallet_ecard.a.g gVar = (com.tencent.mm.plugin.wallet_ecard.a.g) kVar;
        gVar.a(new 4(this, gVar)).b(new 3(this)).c(new com.tencent.mm.wallet_core.c.g.a(this) {
            final /* synthetic */ WalletECardLogoutUI sZX;

            {
                this.sZX = r1;
            }

            public final void f(int i, int i2, String str, k kVar) {
            }
        });
        return true;
    }

    protected final int getLayoutId() {
        return g.uBP;
    }
}
