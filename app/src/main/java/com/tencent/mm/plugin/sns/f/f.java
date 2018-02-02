package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.sns.f.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern rax = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] ray = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> raz = new HashMap();

    public static String a(a aVar) {
        if (!raz.containsKey(aVar.rau)) {
            Object obj = aVar.rau;
            if (bh.ov(obj)) {
                return aVar.rat;
            }
            Object obj2;
            do {
                Matcher matcher = rax.matcher(obj);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    Object group = matcher.group();
                    x.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    obj = obj.replace(group, "");
                    for (String indexOf : ray) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } else {
                    raz.put(aVar.rau, a.raA);
                    return aVar.rau;
                }
            } while (obj2 != null);
            raz.put(aVar.rau, a.raB);
            return aVar.rat;
        } else if (((a) raz.get(aVar.rau)) == a.raA) {
            return aVar.rau;
        } else {
            return aVar.rat;
        }
    }
}
