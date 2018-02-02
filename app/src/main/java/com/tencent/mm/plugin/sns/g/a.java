package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int KP(String str) {
        int i = 0;
        try {
            i = bh.getInt(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.AlbumBgHelper", "parserInt error " + str);
        }
        return i;
    }

    private static float mE(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = bh.getFloat(str, 0.0f);
            } catch (Exception e) {
                x.e("MicroMsg.AlbumBgHelper", "parseFloat error " + str);
            }
        }
        return f;
    }

    private static String mF(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static cf KQ(String str) {
        Map y = bi.y(str, "albumList");
        cf cfVar = new cf();
        if (y == null) {
            return cfVar;
        }
        cfVar.nhF = mF((String) y.get(".albumList.$lang"));
        dp dpVar = new dp();
        dpVar.nfp = mF((String) y.get(".albumList.album.author.name"));
        dpVar.fon = mF((String) y.get(".albumList.album.author.title"));
        dpVar.vIO = mF((String) y.get(".albumList.album.author.description"));
        dpVar.vIN = mF((String) y.get(".albumList.album.author.quote"));
        dq dqVar = new dq();
        aqt o = o(y, ".albumList.album.author.icon.media");
        String str2 = (String) y.get(".albumList.album.author.icon.media.id");
        String str3 = (String) y.get(".albumList.album.author.icon.media.type");
        String str4 = (String) y.get(".albumList.album.author.icon.media.title");
        String str5 = (String) y.get(".albumList.album.author.icon.media.desc");
        String str6 = (String) y.get(".albumList.album.author.icon.media.url");
        String str7 = (String) y.get(".albumList.album.author.icon.media.private");
        String str8 = (String) y.get(".albumList.album.author.icon.media.thumb");
        String str9 = (String) y.get(".albumList.album.author.icon.media.url.$type");
        String str10 = (String) y.get(".albumList.album.author.icon.media.thumb.$type");
        aqr com_tencent_mm_protocal_c_aqr = new aqr();
        com_tencent_mm_protocal_c_aqr.nGJ = mF(str2);
        com_tencent_mm_protocal_c_aqr.ktN = KP(str3);
        com_tencent_mm_protocal_c_aqr.fon = mF(str4);
        com_tencent_mm_protocal_c_aqr.nfe = mF(str5);
        com_tencent_mm_protocal_c_aqr.nfX = mF(str6);
        com_tencent_mm_protocal_c_aqr.wxD = KP(str9);
        com_tencent_mm_protocal_c_aqr.wxE = mF(str8);
        com_tencent_mm_protocal_c_aqr.wxF = KP(str10);
        com_tencent_mm_protocal_c_aqr.wxG = KP(str7);
        com_tencent_mm_protocal_c_aqr.wxH = o;
        dqVar.vIQ = com_tencent_mm_protocal_c_aqr;
        dpVar.vIP = dqVar;
        cfVar.vHy = dpVar;
        int i = 0;
        while (true) {
            Object obj;
            aji com_tencent_mm_protocal_c_aji = new aji();
            if (i == 0) {
                obj = ".albumList.album.groupList.group.name";
                str4 = ".albumList.album.groupList.group.mediaList";
            } else {
                str4 = ".albumList.album.groupList.group" + i + ".name";
                String str11 = ".albumList.album.groupList.group" + i + ".mediaList";
                str2 = str4;
                str4 = str11;
            }
            str2 = (String) y.get(obj);
            if (str2 == null) {
                return cfVar;
            }
            com_tencent_mm_protocal_c_aji.nfp = mF(str2);
            com_tencent_mm_protocal_c_aji.vYd = p(y, str4);
            cfVar.vHz.add(com_tencent_mm_protocal_c_aji);
            i++;
        }
    }

    private static aqt o(Map<String, String> map, String str) {
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        aqt com_tencent_mm_protocal_c_aqt = new aqt();
        com_tencent_mm_protocal_c_aqt.wyv = 0.0f;
        com_tencent_mm_protocal_c_aqt.wyu = 0.0f;
        com_tencent_mm_protocal_c_aqt.wyw = 0.0f;
        if (str2 != null) {
            com_tencent_mm_protocal_c_aqt.wyu = mE(str2);
        }
        if (str3 != null) {
            com_tencent_mm_protocal_c_aqt.wyv = mE(str3);
        }
        if (str4 != null) {
            com_tencent_mm_protocal_c_aqt.wyw = mE(str4);
        }
        return com_tencent_mm_protocal_c_aqt;
    }

    private static LinkedList<aqr> p(Map<String, String> map, String str) {
        LinkedList<aqr> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                str2 = str + ".media" + i + ".type";
                str3 = str + ".media" + i + ".title";
                str4 = str + ".media" + i + ".desc";
                str5 = str + ".media" + i + ".url";
                str6 = str + ".media" + i + ".thumb";
                str7 = str + ".media" + i + ".url.$type";
                str8 = str + ".media" + i + ".thumb.$type";
                str9 = str + ".media" + i + ".private";
                str10 = str + ".media" + i;
                str11 = str9;
                Object obj2 = str2;
                Object obj3 = str8;
                Object obj4 = str3;
                Object obj5 = str7;
                Object obj6 = str4;
                Object obj7 = str6;
                Object obj8 = str5;
                Object obj9 = str11;
            } else {
                obj = str + ".media.id";
                str2 = str + ".media.type";
                str3 = str + ".media.title";
                str4 = str + ".media.desc";
                str5 = str + ".media.url";
                str6 = str + ".media.thumb";
                str7 = str + ".media.url.$type";
                str8 = str + ".media.thumb.$type";
                str9 = str + ".media.private";
                str10 = str + ".media";
                str11 = str9;
                str9 = str2;
                str2 = str8;
                str8 = str3;
                str3 = str7;
                str7 = str4;
                str4 = str6;
                str6 = str5;
                str5 = str11;
            }
            if (obj != null && obj2 != null) {
                aqt o = o(map, str10);
                str10 = (String) map.get(obj);
                str9 = (String) map.get(obj2);
                str8 = (String) map.get(obj4);
                str7 = (String) map.get(obj6);
                str6 = (String) map.get(obj8);
                str5 = (String) map.get(obj9);
                str4 = (String) map.get(obj7);
                str3 = (String) map.get(obj5);
                str2 = (String) map.get(obj3);
                if (str10 == null || str9 == null) {
                    break;
                }
                aqr com_tencent_mm_protocal_c_aqr = new aqr();
                com_tencent_mm_protocal_c_aqr.nGJ = mF(str10);
                com_tencent_mm_protocal_c_aqr.ktN = KP(str9);
                com_tencent_mm_protocal_c_aqr.fon = mF(str8);
                com_tencent_mm_protocal_c_aqr.nfe = mF(str7);
                com_tencent_mm_protocal_c_aqr.nfX = mF(str6);
                com_tencent_mm_protocal_c_aqr.wxD = KP(str3);
                com_tencent_mm_protocal_c_aqr.wxE = mF(str4);
                com_tencent_mm_protocal_c_aqr.wxF = KP(str2);
                com_tencent_mm_protocal_c_aqr.wxG = KP(str5);
                com_tencent_mm_protocal_c_aqr.wxH = o;
                linkedList.add(com_tencent_mm_protocal_c_aqr);
                i++;
            } else {
                break;
            }
        }
        return linkedList;
    }
}
