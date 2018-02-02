package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$e {
    public String fCU;
    public String hOf;
    public String thumbUrl;
    public String title;

    private m$e() {
    }

    public static m$e Jl(String str) {
        Map y = bi.y(str, "h5url");
        if (y == null) {
            return null;
        }
        try {
            m$e com_tencent_mm_plugin_shake_d_a_m_e = new m$e();
            com_tencent_mm_plugin_shake_d_a_m_e.title = bh.ou((String) y.get(".h5url.title"));
            com_tencent_mm_plugin_shake_d_a_m_e.thumbUrl = bh.ou((String) y.get(".h5url.thumburl"));
            com_tencent_mm_plugin_shake_d_a_m_e.hOf = bh.ou((String) y.get(".h5url.link"));
            com_tencent_mm_plugin_shake_d_a_m_e.fCU = bh.ou((String) y.get(".h5url.username"));
            return com_tencent_mm_plugin_shake_d_a_m_e;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
