package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public enum c$a {
    HVGAME_MENU_ACTION_DEFAULT(0),
    HVGAME_MENU_ACTION_JUMP_H5(1),
    HVGAME_MENU_ACTION_EXIT(2),
    HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
    HVGAME_MENU_ACTION_COLLECT(4),
    HVGAME_MENU_ACTION_STICK_ON(5),
    HVGAME_MENU_ACTION_STICK_OFF(6),
    HVGAME_MENU_ACTION_REFRESH(7),
    HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
    HVGAME_MENU_ACTION_COMPLAINT(9),
    HVGAME_MENU_ACTION_CUSTOM(10);
    
    private static EnumMap<c$a, Integer> tGc;
    int code;

    static {
        tGc = new EnumMap(c$a.class);
        Iterator it = EnumSet.allOf(c$a.class).iterator();
        while (it.hasNext()) {
            c$a com_tencent_mm_plugin_webview_ui_tools_game_menu_c_a = (c$a) it.next();
            tGc.put(com_tencent_mm_plugin_webview_ui_tools_game_menu_c_a, Integer.valueOf(com_tencent_mm_plugin_webview_ui_tools_game_menu_c_a.code));
        }
    }

    private c$a(int i) {
        this.code = i;
    }

    public static boolean AX(int i) {
        return tGc.containsValue(Integer.valueOf(i));
    }

    public static c$a AY(int i) {
        for (Entry entry : tGc.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == i) {
                return (c$a) entry.getKey();
            }
        }
        return HVGAME_MENU_ACTION_DEFAULT;
    }
}
