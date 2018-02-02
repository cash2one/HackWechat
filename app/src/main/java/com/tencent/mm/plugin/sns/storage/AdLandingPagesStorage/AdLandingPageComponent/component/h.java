package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.a$a;
import com.tencent.mm.plugin.webview.ui.tools.widget.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.xweb.WebView;

public final class h extends a {
    public h(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bxa() {
        if (((x) bwV()) != null) {
            String str;
            WebView webView = (WebView) getView();
            x xVar = (x) bwV();
            if (TextUtils.isEmpty(xVar.url) || TextUtils.isEmpty(xVar.qZM)) {
                str = xVar.url;
            } else {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String l = ac.l(xVar.url, new String[]{"uxinfo=" + xVar.qZM, "uin=" + uin});
                if (xVar.fpn == 1) {
                    str = AdLandingPagesProxy.getInstance().getAdVoteInfo(xVar.url, xVar.qZM, uin);
                    if (!bh.ov(str)) {
                        str = l + "&" + str;
                    }
                }
                str = l;
            }
            webView.loadUrl(str);
        }
    }

    protected final View bxb() {
        View cn = a.tKa.cn(this.context);
        cn.getSettings().cIt();
        cn.getSettings().cIx();
        cn.getSettings().cIw();
        cn.setWebViewClient(a$a.tJZ.a(cn, new b(this) {
            final /* synthetic */ h rjh;

            {
                this.rjh = r1;
            }

            public final boolean n(int i, Bundle bundle) {
                switch (i) {
                    case 150:
                        x xVar = (x) this.rjh.bwV();
                        AdLandingPagesProxy.getInstance().saveAdVoteInfo(xVar.url, xVar.qZM, xVar.uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0);
                        break;
                }
                return false;
            }
        }));
        return cn;
    }

    public final void bwG() {
        super.bwG();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.contentView = null;
    }
}
