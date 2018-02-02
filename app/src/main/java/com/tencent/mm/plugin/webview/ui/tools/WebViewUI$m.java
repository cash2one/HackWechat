package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.URLUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class WebViewUI$m {
    private static final Pattern mXS = Pattern.compile(".*#.*wechat_redirect");
    public String mXT = null;
    String[] tAh = null;
    private LinkedList<String> tBy = new LinkedList();

    public WebViewUI$m(String str) {
        this.mXT = str;
    }

    public final int BI(String str) {
        int i = 0;
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewUI", "getReason fail, url is null");
            return 0;
        } else if (str.equals(this.mXT)) {
            return 0;
        } else {
            if (mXS.matcher(str).find()) {
                return 2;
            }
            if (!bh.ov(str) && this.tAh != null && this.tAh.length != 0 && !this.tBy.contains(str)) {
                String substring;
                if (URLUtil.isHttpUrl(str)) {
                    substring = str.substring(7);
                } else {
                    substring = str;
                }
                if (URLUtil.isHttpsUrl(substring)) {
                    substring = str.substring(8);
                }
                x.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", new Object[]{str, substring});
                for (String str2 : this.tAh) {
                    x.i("MicroMsg.WebViewUI", "force geta8key path = %s", new Object[]{str2});
                    if (substring.startsWith(r5[r2])) {
                        this.tBy.add(str);
                        i = 1;
                        break;
                    }
                }
            }
            return i != 0 ? 8 : 1;
        }
    }
}
