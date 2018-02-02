package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$d {
    public String qpZ;
    public String thumbUrl;
    public String title;
    public String username;

    private m$d() {
    }

    public static m$d Jk(String str) {
        Map y = bi.y(str, "tempsession");
        if (y == null) {
            return null;
        }
        try {
            m$d com_tencent_mm_plugin_shake_d_a_m_d = new m$d();
            com_tencent_mm_plugin_shake_d_a_m_d.title = bh.ou((String) y.get(".tempsession.title"));
            com_tencent_mm_plugin_shake_d_a_m_d.thumbUrl = bh.ou((String) y.get(".tempsession.thumburl"));
            com_tencent_mm_plugin_shake_d_a_m_d.username = bh.ou((String) y.get(".tempsession.username"));
            com_tencent_mm_plugin_shake_d_a_m_d.qpZ = bh.ou((String) y.get(".tempsession.deeplinkjumpurl"));
            return com_tencent_mm_plugin_shake_d_a_m_d;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
