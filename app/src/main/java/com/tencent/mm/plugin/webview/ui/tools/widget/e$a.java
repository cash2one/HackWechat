package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

protected class e$a {
    private static final Pattern mXS = Pattern.compile(".*#.*wechat_redirect");
    private String mXT = null;

    public e$a(String str) {
        this.mXT = str;
    }

    public final int BI(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
            return 0;
        } else if (str.equals(this.mXT)) {
            return 0;
        } else {
            if (mXS.matcher(str).find()) {
                return 2;
            }
            return 1;
        }
    }
}
