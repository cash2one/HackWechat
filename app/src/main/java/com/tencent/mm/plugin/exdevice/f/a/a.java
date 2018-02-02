package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a {
    public static ArrayList<d> a(String str, String str2, String str3, String str4, Map<String, String> map, List<c> list) {
        x.d("MicroMsg.ExdeviceMsgXmlParser", str3);
        if (bh.ov(str3)) {
            x.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            return null;
        }
        com.tencent.mm.y.g.a I = com.tencent.mm.y.g.a.I(str3, str4);
        if (I != null) {
            Map map2 = I.haZ;
            ArrayList<d> arrayList = new ArrayList();
            String str5 = "MicroMsg.ExdeviceMsgXmlParser";
            String str6 = "map is null :%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(map2 == null);
            x.d(str5, str6, objArr);
            if (!(map2 == null || map2.isEmpty())) {
                String str7;
                String str8;
                x.d("MicroMsg.ExdeviceMsgXmlParser", "ap: map %s", new Object[]{map2.toString()});
                int i = 0;
                while (true) {
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    if (bh.ov(str7)) {
                        break;
                    }
                    str8 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i == 0 ? "" : Integer.valueOf(i)) + ".step");
                    c cVar = new c();
                    cVar.field_appusername = str2;
                    cVar.field_username = str7;
                    cVar.field_rankID = str;
                    cVar.field_step = bh.getInt(str5, 0);
                    list.add(cVar);
                    map.put(str7, str8);
                    i++;
                }
                x.i("MicroMsg.ExdeviceMsgXmlParser", "follow should break now : %d", new Object[]{Integer.valueOf(i)});
                int i2 = 0;
                while (true) {
                    str7 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                    str8 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname");
                    if (bh.ov(str7)) {
                        x.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[]{Integer.valueOf(i2)});
                        return arrayList;
                    }
                    str5 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".rank.rankdisplay");
                    i = bh.getInt((String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".score.scoredisplay"), 0);
                    d dVar = new d();
                    dVar.field_appusername = str2;
                    dVar.field_rankID = str;
                    dVar.field_username = str7;
                    dVar.field_ranknum = bh.getInt(str5, 0);
                    dVar.field_score = i;
                    dVar.field_selfLikeState = 2;
                    dVar.field_likecount = 0;
                    arrayList.add(dVar);
                    map.put(str7, str8);
                    i2++;
                }
            }
        }
        return null;
    }

    public static void a(String str, String str2, Map<String, String> map) {
        int i = 0;
        x.d("MicroMsg.ExdeviceMsgXmlParser", "ap: only nickname: %s", new Object[]{str});
        if (bh.ov(str)) {
            x.e("MicroMsg.ExdeviceMsgXmlParser", "rank info is null or nil");
            return;
        }
        com.tencent.mm.y.g.a I = com.tencent.mm.y.g.a.I(str, str2);
        if (I != null) {
            Map map2 = I.haZ;
            if (map2 != null && !map2.isEmpty()) {
                String str3;
                int i2 = 0;
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".username");
                    if (bh.ov(str3)) {
                        break;
                    }
                    map.put(str3, (String) map2.get(".msg.appmsg.hardwareinfo.follows.follow" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".nickname"));
                    i2++;
                }
                while (true) {
                    str3 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                    String str4 = (String) map2.get(".msg.appmsg.hardwareinfo.rankview.rankinfolist.rankinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".nickname");
                    if (!bh.ov(str3)) {
                        map.put(str3, str4);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
