package com.tencent.mm.pluginsdk.i.a.e;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum b {
    ;

    public static String aq(Map<String, List<String>> map) {
        if (map == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(bh.az((String) entry.getKey(), "null"));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String ou : list) {
                    stringBuilder.append(bh.ou(ou)).append("|");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
