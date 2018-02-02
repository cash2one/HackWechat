package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$f {
    public String bgo;
    public String qqa;
    public String userName;

    private m$f() {
    }

    public static m$f Jm(String str) {
        Map y = bi.y(str, "bizprofile");
        if (y == null) {
            return null;
        }
        try {
            m$f com_tencent_mm_plugin_shake_d_a_m_f = new m$f();
            com_tencent_mm_plugin_shake_d_a_m_f.bgo = bh.ou((String) y.get(".bizprofile.nickname"));
            com_tencent_mm_plugin_shake_d_a_m_f.userName = bh.ou((String) y.get(".bizprofile.username"));
            com_tencent_mm_plugin_shake_d_a_m_f.qqa = bh.ou((String) y.get(".bizprofile.showchat"));
            return com_tencent_mm_plugin_shake_d_a_m_f;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
