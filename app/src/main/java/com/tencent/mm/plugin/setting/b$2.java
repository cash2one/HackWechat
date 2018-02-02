package com.tencent.mm.plugin.setting;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.c;
import java.util.Map;

class b$2 implements a {
    final /* synthetic */ b qfX;

    b$2(b bVar) {
        this.qfX = bVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
            return;
        }
        Map y = bi.y(a, "sysmsg");
        if (y != null) {
            String az = bh.az((String) y.get(".sysmsg.RedPoints.redPoint.path"), "");
            int VI = bh.VI(bh.az((String) y.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            bh.VI(bh.az((String) y.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
            if (!bh.ov(az)) {
                if (az.equals("my_setting_privaty_recentOption")) {
                    ar.Hg();
                    if (((Integer) c.CU().get(w.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(0))).intValue() < VI) {
                        ar.Hg();
                        c.CU().a(w.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(VI));
                        ar.Hg();
                        c.CU().a(w.a.USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(VI));
                        ar.Hg();
                        c.CU().a(w.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(VI));
                        ar.Hg();
                        c.CU().a(w.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(VI));
                        ar.Hg();
                        c.CU().a(w.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(VI));
                        com.tencent.mm.s.c.Bq().p(266260, true);
                    }
                } else if (az.equals("my_setting_plugin_switch")) {
                    String az2 = bh.az((String) y.get(".sysmsg.RedPoints.redPoint.ext"), "");
                    if (!bh.ov(az2)) {
                        ar.Hg();
                        if (((Integer) c.CU().get(w.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(0))).intValue() < VI) {
                            Object concat;
                            ar.Hg();
                            c.CU().a(w.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(VI));
                            ar.Hg();
                            a = (String) c.CU().get(w.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                            if (bh.ov(a)) {
                                a = az2;
                            } else {
                                concat = az2.concat(",").concat(a);
                            }
                            ar.Hg();
                            c.CU().a(w.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, concat);
                            com.tencent.mm.s.c.Bq().p(262158, true);
                        }
                    }
                }
            }
        }
    }
}
