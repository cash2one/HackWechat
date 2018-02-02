package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.xweb.WebView;

class t$1 implements OnLongClickListener {
    final /* synthetic */ t jFj;

    t$1(t tVar) {
        this.jFj = tVar;
    }

    public final boolean onLongClick(View view) {
        if (WebView.getTbsCoreVersion(this.jFj.getContext()) >= 43011) {
            return false;
        }
        return true;
    }
}
