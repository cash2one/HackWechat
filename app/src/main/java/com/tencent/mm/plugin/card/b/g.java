package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class g {
    public static d wJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        Map y = bi.y(str, "msg");
        dVar.kKY = (String) y.get(".msg.appmsg.carditem.from_username");
        dVar.fGU = (String) y.get(".msg.appmsg.carditem.card_id");
        dVar.kJO = wL((String) y.get(".msg.appmsg.carditem.card_type"));
        dVar.fGW = wL((String) y.get(".msg.appmsg.carditem.from_scene"));
        dVar.hbM = (String) y.get(".msg.appmsg.carditem.color");
        dVar.kKZ = (String) y.get(".msg.appmsg.carditem.card_type_name");
        dVar.kLa = (String) y.get(".msg.appmsg.carditem.brand_name");
        dVar.fGV = (String) y.get(".msg.appmsg.carditem.card_ext");
        dVar.kLb = wL((String) y.get(".msg.appmsg.carditem.is_recommend"));
        dVar.kLc = (String) y.get(".msg.appmsg.carditem.recommend_card_id");
        return dVar;
    }

    public static String wK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) bi.y(str, "msg").get(".msg.appmsg.fromusername");
    }

    private static int wL(String str) {
        if (TextUtils.isEmpty(str) || !l.wP(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static String a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.kKY).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.fGU).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.kJO).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.fGW).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.hbM).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.kKZ).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.kLa).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.fGV)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.fGV).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.kLb).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.kLc).append("</recommend_card_id>");
        return stringBuilder.toString();
    }
}
