package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$b {
    public String pbN;
    public String qpY;
    public String thumbUrl;
    public String title;

    private m$b() {
    }

    public static m$b Ji(String str) {
        Map y = bi.y(str, "nativepay");
        if (y == null) {
            return null;
        }
        try {
            m$b com_tencent_mm_plugin_shake_d_a_m_b = new m$b();
            com_tencent_mm_plugin_shake_d_a_m_b.title = bh.ou((String) y.get(".nativepay.title"));
            com_tencent_mm_plugin_shake_d_a_m_b.thumbUrl = bh.ou((String) y.get(".nativepay.thumburl"));
            com_tencent_mm_plugin_shake_d_a_m_b.qpY = bh.ou((String) y.get(".nativepay.wx_pay_url"));
            com_tencent_mm_plugin_shake_d_a_m_b.pbN = bh.ou((String) y.get(".nativepay.price"));
            return com_tencent_mm_plugin_shake_d_a_m_b;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
