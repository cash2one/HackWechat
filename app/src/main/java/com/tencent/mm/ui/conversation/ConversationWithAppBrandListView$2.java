package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

class ConversationWithAppBrandListView$2 implements a {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$2(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final boolean a(View view, final com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        ConversationWithAppBrandListView.f(this.yYl).postDelayed(new Runnable(this) {
            final /* synthetic */ ConversationWithAppBrandListView$2 yYm;

            public final void run() {
                if (ConversationWithAppBrandListView.e(this.yYm.yYl) != null && aVar != null) {
                    if (aVar.type != 1 || aVar.kfb == null) {
                        this.yYm.yYl.z(0, 2);
                        return;
                    }
                    ConversationWithAppBrandListView.e(this.yYm.yYl).kfl.append(aVar.kfb.appId + ":");
                }
            }
        }, 666);
        return false;
    }

    public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        if (!(aVar == null || aVar.kfb == null || aVar.type != 1 || ConversationWithAppBrandListView.e(this.yYl) == null)) {
            b e = ConversationWithAppBrandListView.e(this.yYl);
            String str = aVar.kfb.appId;
            e.kfj++;
            e.kfm.append(str + ":");
        }
        return false;
    }
}
