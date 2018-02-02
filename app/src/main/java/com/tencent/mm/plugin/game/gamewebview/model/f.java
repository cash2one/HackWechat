package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.regex.Pattern;

public final class f {
    public b mXM;
    c mXN;

    public static class b {
        private static final Pattern mXS = Pattern.compile(".*#.*wechat_redirect");
        private String mXT = null;

        public b(String str) {
            this.mXT = str;
        }

        public final int BI(String str) {
            if (bh.ov(str)) {
                x.e("MicroMsg.GameWebViewGetA8KeyHelp", "getReason fail, url is null");
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

    public f(String str, c cVar) {
        this.mXN = cVar;
        this.mXM = new b(str);
    }
}
