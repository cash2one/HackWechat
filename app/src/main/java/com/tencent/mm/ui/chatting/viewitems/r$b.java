package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class r$b {
    public int color;
    public boolean fHI;
    public int yLZ;
    public boolean yMa;
    public int yMc;
    public int yMd;

    private r$b() {
    }

    public static r$b v(Map<String, String> map, String str) {
        String str2 = (String) map.get(str + ".range");
        if (bh.ov(str2)) {
            x.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
            return null;
        } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
            x.d("MicroMsg.StyleNode", "parseFrom, range = " + str2);
            String[] split = str2.substring(1, str2.length() - 1).split(",");
            if (split == null || split.length != 2) {
                x.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                return null;
            }
            r$b com_tencent_mm_ui_chatting_viewitems_r_b = new r$b();
            try {
                com_tencent_mm_ui_chatting_viewitems_r_b.yMc = bh.getInt(split[0], 0);
                com_tencent_mm_ui_chatting_viewitems_r_b.yMd = bh.getInt(split[1], 0) + com_tencent_mm_ui_chatting_viewitems_r_b.yMc;
                str2 = (String) map.get(str + ".font");
                if (bh.ov(str2)) {
                    x.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                com_tencent_mm_ui_chatting_viewitems_r_b.fHI = r.Al(str2);
                com_tencent_mm_ui_chatting_viewitems_r_b.yMa = r.pA(str2);
                com_tencent_mm_ui_chatting_viewitems_r_b.yLZ = r.Zu(str2);
                com_tencent_mm_ui_chatting_viewitems_r_b.color = r.Zv((String) map.get(str + ".color"));
                return com_tencent_mm_ui_chatting_viewitems_r_b;
            } catch (Exception e) {
                x.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                return null;
            }
        } else {
            x.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = " + str2);
            return null;
        }
    }
}
