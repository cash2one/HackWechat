package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class b {
    public static ArrayList<String> QS(String str) {
        if (bh.ov(str) || str.length() == 0) {
            return null;
        }
        String[] split = Pattern.compile("\n", 2).matcher(Pattern.compile("<div></div>", 2).matcher(Pattern.compile("</object>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("<object[^>]*>", 2).matcher(Pattern.compile("<div><object[^>]*></object></div>", 2).matcher(str).replaceAll("<object>")).replaceAll("#WNNoteNode#<ThisisNoteNodeObj>#WNNoteNode#")).replaceAll("#WNNoteNode#<ThisisNoteNodeHrObj>#WNNoteNode#")).replaceAll("")).replaceAll("")).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : split) {
            String str22;
            if (str22.length() > 0) {
                str22 = str22.replace("</div>", "<div>");
                int i = -1;
                if (str22.endsWith("<div>")) {
                    i = str22.lastIndexOf("<div>");
                }
                if (i > 0) {
                    str22 = str22.substring(0, i);
                }
                arrayList.add(str22.replace("<div><br/>", "<div>"));
            }
        }
        return arrayList;
    }

    public static String QT(String str) {
        if (bh.ov(str) || str.length() == 0) {
            return str;
        }
        return Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<hr[^>]*>", 2).matcher(Pattern.compile("</wx-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(str).replaceAll("\n")).replaceAll("")).replaceAll("\n")).replaceAll("\n")).replaceAll("\n")).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll(" ");
    }
}
