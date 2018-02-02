package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.k;
import org.xwalk.core.XWalkEnvironment;

class a$9 implements OnClickListener {
    final /* synthetic */ a Asx;

    a$9(a aVar) {
        this.Asx = aVar;
    }

    public final void onClick(View view) {
        if (XWalkEnvironment.getAvailableVersion() < 0) {
            this.Asx.acp("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_gray1.xml&check_xwalk_update");
            return;
        }
        k.cIo().a("tools", c.AqB);
        k.cIo().a("appbrand", c.AqB);
        k.cIo().a("support", c.AqB);
        this.Asx.act("已使用XWeb，点任意位置重启进程生效\n");
    }
}
