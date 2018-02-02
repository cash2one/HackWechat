package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$c {
    public String id;
    public String thumbUrl;
    public String title;

    private m$c() {
    }

    public static m$c Jj(String str) {
        Map y = bi.y(str, "product");
        if (y == null) {
            return null;
        }
        try {
            m$c com_tencent_mm_plugin_shake_d_a_m_c = new m$c();
            com_tencent_mm_plugin_shake_d_a_m_c.title = bh.ou((String) y.get(".product.title"));
            com_tencent_mm_plugin_shake_d_a_m_c.thumbUrl = bh.ou((String) y.get(".product.thumburl"));
            com_tencent_mm_plugin_shake_d_a_m_c.id = bh.ou((String) y.get(".product.product_id"));
            return com_tencent_mm_plugin_shake_d_a_m_c;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
