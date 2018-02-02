package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.t.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class v {
    static String y(Map<String, String> map) {
        return bh.az((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
    }

    static void a(Map<String, String> map, t tVar) {
        tVar.ncj.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                t$h com_tencent_mm_plugin_game_model_t_h = new t$h();
                com_tencent_mm_plugin_game_model_t_h.userName = bh.az((String) map.get(str2 + ".username"), "");
                com_tencent_mm_plugin_game_model_t_h.bgo = bh.az((String) map.get(str2 + ".nickname"), "");
                com_tencent_mm_plugin_game_model_t_h.ndh = bh.az((String) map.get(str2 + ".usericon"), "");
                com_tencent_mm_plugin_game_model_t_h.ndj = bh.az((String) map.get(str2 + ".badge_icon"), "");
                com_tencent_mm_plugin_game_model_t_h.ndk = bh.az((String) map.get(str2 + ".$jump_id"), "");
                tVar.ncj.add(com_tencent_mm_plugin_game_model_t_h);
                i++;
            } else {
                return;
            }
        }
    }

    static long z(Map<String, String> map) {
        return bh.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
    }

    static void b(Map<String, String> map, t tVar) {
        boolean z;
        boolean z2 = true;
        tVar.ncA.url = bh.az((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        a aVar = tVar.ncA;
        if (bh.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.nbV = z;
        tVar.ncA.orientation = bh.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        aVar = tVar.ncA;
        if (bh.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.ncX = z2;
    }
}
