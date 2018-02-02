package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.t.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class aa {
    public static aa ndp;

    static aa aQy() {
        if (ndp == null) {
            ndp = new aa();
        }
        return ndp;
    }

    static void c(Map<String, String> map, t tVar) {
        String str = ".sysmsg.gamecenter.jump_info.jump";
        tVar.nco.clear();
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                String str3 = (String) map.get(str2 + ".$id");
                t$d com_tencent_mm_plugin_game_model_t_d = new t$d();
                com_tencent_mm_plugin_game_model_t_d.ndb = bh.getInt((String) map.get(str2 + ".jump_type"), 0);
                com_tencent_mm_plugin_game_model_t_d.lUj = bh.az((String) map.get(str2 + ".jump_url"), "");
                if (!bh.ov(str3)) {
                    tVar.nco.put(str3, com_tencent_mm_plugin_game_model_t_d);
                }
                i++;
            } else {
                return;
            }
        }
    }

    static void d(Map<String, String> map, t tVar) {
        tVar.ncS = bh.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        tVar.ncT = bh.az((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
    }

    static void e(Map<String, String> map, t tVar) {
        boolean z;
        boolean z2 = true;
        tVar.ncA.url = bh.az((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        a aVar = tVar.ncA;
        if (bh.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.nbV = z;
        tVar.ncA.orientation = bh.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        aVar = tVar.ncA;
        if (bh.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.ncX = z2;
    }
}
