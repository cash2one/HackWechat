package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;

class BannerActView$1 implements OnClickListener {
    final /* synthetic */ BannerActView olc;

    BannerActView$1(BannerActView bannerActView) {
        this.olc = bannerActView;
    }

    public final void onClick(View view) {
        this.olc.setVisibility(8);
        b.cf(BannerActView.a(this.olc));
        if (BannerActView.a(this.olc) != null && BannerActView.a(this.olc).size() > 0) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ((a) BannerActView.a(this.olc).get(0)).sQq);
            d.b(this.olc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
