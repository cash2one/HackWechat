package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.k;

class a$11 implements OnClickListener {
    final /* synthetic */ a Asx;

    a$11(a aVar) {
        this.Asx = aVar;
    }

    public final void onClick(View view) {
        k.cIo().a("tools", c.WV_KIND_SYS);
        k.cIo().a("appbrand", c.WV_KIND_SYS);
        k.cIo().a("support", c.WV_KIND_SYS);
        this.Asx.act("已使用system，点任意位置重启进程生效\n");
    }
}
