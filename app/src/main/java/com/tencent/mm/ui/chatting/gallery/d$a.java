package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class d$a {
    private static HashMap<String, d$a> yEu = new HashMap();
    private int height;
    private int hlp;
    private int width;
    private long xfY = 0;
    private int yEr = 0;
    private String yEs = "";
    private int yEt = 0;

    private d$a() {
    }

    public static void do(String str, int i) {
        try {
            if (!bh.ov(str) && i != 0) {
                d$a com_tencent_mm_ui_chatting_gallery_d_a = (d$a) yEu.get(str);
                if (com_tencent_mm_ui_chatting_gallery_d_a != null) {
                    com_tencent_mm_ui_chatting_gallery_d_a.hlp = i;
                }
                Set<String> hashSet = new HashSet();
                for (String str2 : yEu.keySet()) {
                    d$a com_tencent_mm_ui_chatting_gallery_d_a2 = (d$a) yEu.get(str2);
                    if (com_tencent_mm_ui_chatting_gallery_d_a2 != null) {
                        x.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[]{Long.valueOf(bh.bz(com_tencent_mm_ui_chatting_gallery_d_a2.xfY)), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.hlp), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.width), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.height), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.yEr), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.yEt), com_tencent_mm_ui_chatting_gallery_d_a2.yEs, str2});
                        if (bh.bz(com_tencent_mm_ui_chatting_gallery_d_a2.xfY) >= 60000) {
                            if (com_tencent_mm_ui_chatting_gallery_d_a2.hlp > 0 && !bh.ov(com_tencent_mm_ui_chatting_gallery_d_a2.yEs)) {
                                g.pQN.h(11713, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.hlp), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.width), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.height), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.yEr), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a2.yEt), com_tencent_mm_ui_chatting_gallery_d_a2.yEs});
                            }
                            hashSet.add(str2);
                        }
                    }
                }
                for (String str22 : hashSet) {
                    yEu.remove(str22);
                }
            }
        } catch (Throwable th) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[]{bh.i(th)});
        }
    }

    public static void k(String str, int i, int i2, int i3) {
        try {
            if (!bh.ov(str) && i != 0 && i2 != 0) {
                d$a com_tencent_mm_ui_chatting_gallery_d_a = (d$a) yEu.get(str);
                if (com_tencent_mm_ui_chatting_gallery_d_a == null) {
                    com_tencent_mm_ui_chatting_gallery_d_a = new d$a();
                    com_tencent_mm_ui_chatting_gallery_d_a.xfY = bh.Wp();
                    yEu.put(str, com_tencent_mm_ui_chatting_gallery_d_a);
                }
                com_tencent_mm_ui_chatting_gallery_d_a.height = i2;
                com_tencent_mm_ui_chatting_gallery_d_a.width = i;
                com_tencent_mm_ui_chatting_gallery_d_a.yEs += i3 + "|";
                if (i3 > 0) {
                    if (com_tencent_mm_ui_chatting_gallery_d_a.yEr == 0) {
                        com_tencent_mm_ui_chatting_gallery_d_a.yEr = i3;
                    }
                } else if (com_tencent_mm_ui_chatting_gallery_d_a.yEr != 0) {
                    com_tencent_mm_ui_chatting_gallery_d_a.yEt++;
                    com_tencent_mm_ui_chatting_gallery_d_a.yEr = 0;
                }
                x.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a.yEr), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_d_a.yEt), com_tencent_mm_ui_chatting_gallery_d_a.yEs, str});
            }
        } catch (Throwable th) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[]{bh.i(th)});
        }
    }
}
