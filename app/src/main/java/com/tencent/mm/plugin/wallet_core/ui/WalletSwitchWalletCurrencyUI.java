package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements OnClickListener {
    private x sWA;
    private x sWB;
    private ListView sWx;
    private ArrayList<x> sWy = null;
    private n sWz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uWZ);
        g.Dk();
        g.Dj().CU().a(a.xqA, Boolean.valueOf(true));
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.sWy = o.bLt().bMm();
        if (this.sWy == null || this.sWy.size() == 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            jS(true);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            jS(false);
        }
        initView();
        setResult(0);
    }

    protected final void initView() {
        this.sWx = (ListView) findViewById(f.uwx);
        this.sWz = new n(this, this.sWy);
        this.sWx.setAdapter(this.sWz);
        if (this.sWy != null && this.sWy.size() > 0) {
            this.sWz.mData = this.sWy;
            this.sWz.notifyDataSetChanged();
        }
        this.sWx.setOnItemClickListener(new 1(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.sWy = o.bLt().bMm();
                this.sWz.mData = this.sWy;
                this.sWz.notifyDataSetChanged();
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.sWy == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                return false;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            return true;
        } else if (!(kVar instanceof p) || i != 0 || i2 != 0) {
            return false;
        } else {
            this.sWA.field_wallet_selected = 1;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.sWA.field_wallet_type + " " + this.sWA.field_wallet_tpa_country_mask);
            ao.bYV().reset();
            o.bLt().c(this.sWA, new String[0]);
            c cVar = this.sWz.sWD;
            if (cVar != null) {
                cVar.field_wallet_selected = 0;
                o.bLt().c(cVar, new String[0]);
            }
            g.Dk();
            g.Dj().CU().set(339975, Integer.valueOf(this.sWA.field_wallet_type));
            g.Dk();
            g.Dj().CU().a(a.xrD, Integer.valueOf(this.sWA.field_wallet_tpa_country_mask));
            if (q.Gg()) {
                o.bLl();
                o.t(this, null);
            }
            setResult(-1);
            finish();
            return true;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFW;
    }

    private void jS(boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = " + z);
        b(new l(), z);
    }

    public void onClick(View view) {
    }
}
