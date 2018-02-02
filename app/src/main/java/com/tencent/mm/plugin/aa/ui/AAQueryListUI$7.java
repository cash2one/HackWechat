package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;

class AAQueryListUI$7 implements a$a {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$7(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final void WO() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", AAQueryListUI.m(this.iih));
        d.b(this.iih, "webview", ".ui.tools.WebViewUI", intent);
    }
}
