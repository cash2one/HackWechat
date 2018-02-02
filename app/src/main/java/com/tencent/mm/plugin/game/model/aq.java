package com.tencent.mm.plugin.game.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class aq {
    private static String N(LinkedList<t$h> linkedList) {
        if (bh.cA(linkedList)) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t$h com_tencent_mm_plugin_game_model_t_h = (t$h) it.next();
            newSerializer.startTag(null, "userinfo");
            newSerializer.attribute(null, "jump_id", com_tencent_mm_plugin_game_model_t_h.ndk);
            newSerializer.startTag(null, "username");
            try {
                newSerializer.text(bh.az(com_tencent_mm_plugin_game_model_t_h.userName, ""));
            } catch (Exception e) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "username");
            newSerializer.startTag(null, "nickname");
            try {
                newSerializer.text(bh.az(com_tencent_mm_plugin_game_model_t_h.bgo, ""));
            } catch (Exception e2) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "nickname");
            newSerializer.startTag(null, "usericon");
            try {
                newSerializer.text(bh.az(com_tencent_mm_plugin_game_model_t_h.ndh, ""));
            } catch (Exception e3) {
                newSerializer.text("");
            }
            try {
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, "profile");
                try {
                    newSerializer.text(bh.az(com_tencent_mm_plugin_game_model_t_h.ndi, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "profile");
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(bh.az(com_tencent_mm_plugin_game_model_t_h.ndj, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            } catch (Exception e6) {
                x.e("MicroMsg.GameXmlProcess", e6.getMessage());
                return "";
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    private static String a(LinkedList<t$h> linkedList, HashMap<String, d> hashMap) {
        if (bh.cA(linkedList) || hashMap.isEmpty()) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t$h com_tencent_mm_plugin_game_model_t_h = (t$h) it.next();
            d dVar = (d) hashMap.get(com_tencent_mm_plugin_game_model_t_h.ndk);
            if (dVar != null) {
                newSerializer.startTag(null, "jump");
                newSerializer.attribute(null, SlookAirButtonFrequentContactAdapter.ID, com_tencent_mm_plugin_game_model_t_h.ndk);
                newSerializer.startTag(null, "jump_type");
                try {
                    newSerializer.text(String.valueOf(dVar.ndb));
                } catch (Exception e) {
                    try {
                        newSerializer.text("");
                    } catch (Exception e2) {
                        x.e("MicroMsg.GameXmlProcess", e2.getMessage());
                        return "";
                    }
                }
                newSerializer.endTag(null, "jump_type");
                newSerializer.startTag(null, "jump_url");
                try {
                    newSerializer.text(bh.az(dVar.lUj, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "jump_url");
                newSerializer.endTag(null, "jump");
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    public static String a(String str, LinkedList<t$h> linkedList, HashMap<String, d> hashMap) {
        if (bh.ov(str) || bh.cA(linkedList)) {
            return str;
        }
        String N = N(linkedList);
        if (bh.ov(N)) {
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, N);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || bh.ov(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameXmlProcess", e.getMessage());
            x.e("MicroMsg.GameXmlProcess", "xml is invalid : " + str);
        }
        return stringBuilder.toString();
    }
}
