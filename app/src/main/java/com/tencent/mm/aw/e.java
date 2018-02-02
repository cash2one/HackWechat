package com.tencent.mm.aw;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import java.util.Map;

public final class e implements l {
    public final b a(String str, Map<String, String> map, a aVar) {
        x.d("dancy", "dancy consumeNewXml， subType:%s", new Object[]{str});
        if (bh.ou(str).equals("newtips") && map != null) {
            ay ayVar;
            com.tencent.mm.plugin.x.a.bfm();
            if (map == null) {
                x.e("MicroMsg.NewTipsManager", "parse newtips map fail! map is null!!");
                ayVar = null;
            } else {
                Object obj;
                long Wo = bh.Wo();
                ay ayVar2 = new ay();
                ayVar2.field_tipId = bh.getInt((String) map.get(".sysmsg.newtips.control.tips_id"), 0);
                ayVar2.field_tipVersion = bh.getInt((String) map.get(".sysmsg.newtips.control.tips_version"), 0);
                ayVar2.field_tipType = bh.getInt((String) map.get(".sysmsg.newtips.control.tips_type"), 0);
                ayVar2.field_beginShowTime = Math.max(bh.getLong((String) map.get(".sysmsg.newtips.control.begin_time"), 0), Wo);
                ayVar2.field_overdueTime = bh.getLong((String) map.get(".sysmsg.newtips.control.overdue_time"), 0);
                ayVar2.field_disappearTime = bh.getLong((String) map.get(".sysmsg.newtips.control.disappear_time"), 0);
                if (map.get(".sysmsg.newtips.control.tips_showInfo") != null) {
                    ayVar2.field_tipsShowInfo = new bnw();
                    ayVar2.field_tipsShowInfo.showType = bh.getInt((String) map.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
                    ayVar2.field_tipsShowInfo.title = (String) map.get(".sysmsg.newtips.control.tips_showInfo.title");
                    ayVar2.field_tipsShowInfo.oZC = (String) map.get(".sysmsg.newtips.control.tips_showInfo.icon_url");
                    ayVar2.field_tipsShowInfo.path = (String) map.get(".sysmsg.newtips.control.tips_showInfo.path");
                }
                ayVar2.field_extInfo = (String) map.get(".sysmsg.newtips.control.tips_showInfo.");
                com.tencent.mm.plugin.x.a.bfn().Dr(ayVar2.field_tipId);
                com.tencent.mm.plugin.x.a.bfo();
                if (c.a(ayVar2)) {
                    ayVar = com.tencent.mm.plugin.x.a.bfn().Dr(ayVar2.field_tipId);
                    if (!(ayVar == null || ayVar.field_tipsShowInfo == null || ayVar2.field_tipsShowInfo == null)) {
                        String str2 = ayVar.field_tipsShowInfo.path;
                        String str3 = ayVar2.field_tipsShowInfo.path;
                        if (!(str2 == null && str3 == null) && (str2 == null || !str2.equals(str3))) {
                            x.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", new Object[]{str2, str3});
                        } else {
                            obj = 1;
                            if (!(obj == null || ayVar2.field_isReject)) {
                                obj = 1;
                                if (obj != null) {
                                    ayVar2.field_isExit = true;
                                    com.tencent.mm.plugin.x.a.bfn().a(ayVar2, new String[0]);
                                }
                                ayVar = ayVar2;
                            }
                        }
                    }
                    obj = null;
                    obj = 1;
                    if (obj != null) {
                        ayVar2.field_isExit = true;
                        com.tencent.mm.plugin.x.a.bfn().a(ayVar2, new String[0]);
                    }
                    ayVar = ayVar2;
                }
                obj = null;
                if (obj != null) {
                    ayVar2.field_isExit = true;
                    com.tencent.mm.plugin.x.a.bfn().a(ayVar2, new String[0]);
                }
                ayVar = ayVar2;
            }
            if (ayVar != null) {
                d$a com_tencent_mm_aw_d_a = com.tencent.mm.plugin.x.a.bfm().hIq;
                if (com_tencent_mm_aw_d_a != null) {
                    com.tencent.mm.plugin.x.a.bfo();
                    if (c.b(ayVar)) {
                        x.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[]{Boolean.valueOf(ayVar.field_isExit), Long.valueOf(ayVar.field_beginShowTime)});
                        com_tencent_mm_aw_d_a.c(ayVar);
                    }
                }
            }
        }
        return null;
    }
}
