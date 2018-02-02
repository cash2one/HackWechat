package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.we;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static volatile boolean mGb = true;
    static Pattern mGc = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern mGd = Pattern.compile("\"stageName\":\"(.+?)\"");

    public static void pY(int i) {
        j.aLS().aLz().post(new 1(i));
    }

    static String L(LinkedList<we> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            we weVar = (we) it.next();
            stringBuilder.append("|id=").append(m.AC(weVar.id)).append("|");
            for (CharSequence charSequence : m.AC(weVar.wgC).split("\\},")) {
                Matcher matcher = mGd.matcher(charSequence);
                String str = "";
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                matcher = mGc.matcher(charSequence);
                String str2 = "0";
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                stringBuilder.append(k.Az(str) + "=" + str2).append("|");
            }
        }
        return stringBuilder.toString();
    }
}
