package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class AppBrandSearchUI$1 implements OnClickListener {
    final /* synthetic */ AppBrandSearchUI jLP;

    AppBrandSearchUI$1(AppBrandSearchUI appBrandSearchUI) {
        this.jLP = appBrandSearchUI;
    }

    public final void onClick(View view) {
        if (!TextUtils.isEmpty(AppBrandSearchUI.a(this.jLP))) {
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", AppBrandSearchUI.a(this.jLP));
            intent.putExtra("geta8key_scene", 41);
            intent.putExtra("show_long_click_popup_menu", false);
            d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
