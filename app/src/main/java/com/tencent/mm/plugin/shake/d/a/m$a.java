package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$a {
    public String path;
    public String thumbUrl;
    public String title;
    public String username;
    public int version;

    private m$a() {
    }

    public static m$a Jh(String str) {
        Map y = bi.y(str, "program");
        if (y == null) {
            return null;
        }
        try {
            m$a com_tencent_mm_plugin_shake_d_a_m_a = new m$a();
            com_tencent_mm_plugin_shake_d_a_m_a.title = bh.ou((String) y.get(".program.title"));
            com_tencent_mm_plugin_shake_d_a_m_a.thumbUrl = bh.ou((String) y.get(".program.thumburl"));
            com_tencent_mm_plugin_shake_d_a_m_a.username = bh.ou((String) y.get(".program.username"));
            com_tencent_mm_plugin_shake_d_a_m_a.path = bh.ou((String) y.get(".program.path"));
            com_tencent_mm_plugin_shake_d_a_m_a.version = bh.getInt((String) y.get(".program.version"), 0);
            return com_tencent_mm_plugin_shake_d_a_m_a;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
