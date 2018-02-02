package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class EnterpriseBizContactPlainListUI$4 implements a {
    final /* synthetic */ EnterpriseBizContactPlainListUI kGD;
    final /* synthetic */ b kGE;

    EnterpriseBizContactPlainListUI$4(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, b bVar) {
        this.kGD = enterpriseBizContactPlainListUI;
        this.kGE = bVar;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            Intent intent = this.kGD.getIntent();
            intent.putExtra("enterprise_biz_name", this.kGE.userName);
            this.kGD.setResult(-1, intent);
            this.kGD.finish();
        }
    }
}
