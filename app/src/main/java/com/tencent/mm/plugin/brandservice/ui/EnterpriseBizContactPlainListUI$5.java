package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class EnterpriseBizContactPlainListUI$5 implements a {
    final /* synthetic */ EnterpriseBizContactPlainListUI kGD;
    final /* synthetic */ String kGF;

    EnterpriseBizContactPlainListUI$5(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, String str) {
        this.kGD = enterpriseBizContactPlainListUI;
        this.kGF = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z && EnterpriseBizContactPlainListUI.b(this.kGD) == 3) {
            Intent intent = this.kGD.getIntent();
            intent.putExtra("enterprise_biz_name", this.kGF);
            this.kGD.setResult(-1, intent);
            this.kGD.finish();
        }
    }
}
