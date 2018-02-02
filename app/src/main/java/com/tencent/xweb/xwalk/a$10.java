package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.k;

class a$10 implements OnClickListener {
    final /* synthetic */ a Asx;

    a$10(a aVar) {
        this.Asx = aVar;
    }

    public final void onClick(View view) {
        k.cIo().a("tools", c.AqC);
        k.cIo().a("appbrand", c.AqC);
        k.cIo().a("support", c.AqC);
        if (WebView.getTbsCoreVersion(this.Asx.Aqf) <= 0) {
            this.Asx.bv("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
        } else {
            this.Asx.act("已使用x5，点任意位置重启进程生效\n");
        }
    }
}
