package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class e {
    private int version = 0;
    public boolean vjA = false;
    public int vjt = -7829368;
    public boolean vju = false;
    public int vjv = -1593835521;
    public boolean vjw = false;
    public int vjx = WebView.NIGHT_MODE_COLOR;
    public boolean vjy = false;
    public int vjz = 0;

    public e(String str) {
        String str2 = "chatbg";
        Map y = bi.y(str, str2);
        String str3 = "." + str2;
        try {
            this.version = bh.e(Integer.valueOf((String) y.get(str3 + ".$version")));
            this.vjt = (int) bh.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$time_color"), 16)), -7829368);
            this.vju = bh.c(Boolean.valueOf((String) y.get(str3 + ".$time_show_shadow_color")));
            this.vjv = (int) bh.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$time_shadow_color"), 16)), 0);
            this.vjw = bh.c(Boolean.valueOf((String) y.get(str3 + ".$time_show_background")));
            this.vjx = (int) bh.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$voice_second_color"), 16)), -16777216);
            this.vjy = bh.c(Boolean.valueOf((String) y.get(str3 + ".$voice_second_show_shadow_color")));
            this.vjz = (int) bh.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$voice_second_shadow_color"), 16)), 0);
            this.vjA = bh.c(Boolean.valueOf((String) y.get(str3 + ".$voice_second_show_background")));
        } catch (Throwable e) {
            x.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            x.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
        }
    }
}
