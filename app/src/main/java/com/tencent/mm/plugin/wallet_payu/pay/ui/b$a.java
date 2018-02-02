package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m$a;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;

class b$a {
    public m$a sVE;
    public String tde;
    public Bankcard tdf;
    public FavorPayInfo tdg;
    public boolean tdh;
    public b tdi;
    public OnCancelListener tdj;
    final /* synthetic */ b tdk;

    public b$a(b bVar, String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, m$a com_tencent_mm_plugin_wallet_core_ui_m_a, b bVar2) {
        this.tdk = bVar;
        this.tde = str;
        this.tdf = bankcard;
        this.tdg = favorPayInfo;
        this.tdh = z;
        this.tdj = onCancelListener;
        this.sVE = com_tencent_mm_plugin_wallet_core_ui_m_a;
        this.tdi = bVar2;
    }
}
