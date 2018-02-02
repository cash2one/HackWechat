package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.xwalk.core.XWalkEnvironment;

public final class a {
    static boolean ApG = false;
    static String ApH = "";
    static Map<String, String> ApI;
    static Map<String, String> ApJ;

    private static void init() {
        if (!ApG) {
            ApG = true;
            SharedPreferences cIi = cIi();
            String string = cIi.getString("setwebtype", c.AqA.toString());
            String string2 = cIi.getString("setjscore", com.tencent.xweb.g.a.ApS.toString());
            a(acn(string), acn(string2), cIi.getString("cStrTAGConfigVer", ""));
        }
    }

    public static String getAbstractInfo() {
        init();
        if ((ApI == null || ApI.size() == 0) && (ApJ == null || ApJ.size() == 0)) {
            return "";
        }
        return "configver : " + ApH + "\n webtype : " + aC(ApI) + "\n jscore type :" + aC(ApJ);
    }

    public static c acj(String str) {
        init();
        if (ApI == null || str == null) {
            return c.AqA;
        }
        return acl((String) ApI.get(str));
    }

    public static com.tencent.xweb.g.a ack(String str) {
        init();
        if (ApJ == null || str == null) {
            return com.tencent.xweb.g.a.ApS;
        }
        return acm((String) ApJ.get(str));
    }

    public static void a(com.tencent.xweb.c.a.a[] aVarArr, String str) {
        init();
        if (str != null && !str.equals(ApH)) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            if (aVarArr == null || aVarArr.length == 0) {
                b(hashMap, hashMap2, str);
                return;
            }
            XWalkEnvironment.getAvailableVersion();
            int i = VERSION.SDK_INT;
            new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL);
            i = 0;
            while (i < aVarArr.length) {
                if (!(aVarArr[i] == null || !aVarArr[i].AqK.cIA() || aVarArr[i].AqN == null || aVarArr[i].AqN.isEmpty() || aVarArr[i].AqM == null)) {
                    String[] split = aVarArr[i].AqN.split(",");
                    String trim;
                    if (aVarArr[i].AqL.equals("setwebtype")) {
                        for (String trim2 : split) {
                            trim2 = trim2.trim();
                            if (!(trim2 == null || trim2.isEmpty() || hashMap.containsKey(trim2))) {
                                hashMap.put(trim2, aVarArr[i].AqM);
                            }
                        }
                    } else if (aVarArr[i].AqL.equals("setjscore")) {
                        for (String trim22 : split) {
                            trim22 = trim22.trim();
                            if (!(trim22 == null || trim22.isEmpty() || hashMap2.containsKey(trim22))) {
                                hashMap2.put(trim22, aVarArr[i].AqM);
                            }
                        }
                    }
                }
                i++;
            }
            b(hashMap, hashMap2, str);
        }
    }

    private static c acl(String str) {
        if (str == null || str.isEmpty()) {
            return c.AqA;
        }
        c cVar = c.AqA;
        try {
            return c.valueOf(str);
        } catch (Exception e) {
            return cVar;
        }
    }

    private static com.tencent.xweb.g.a acm(String str) {
        if (str == null || str.isEmpty()) {
            return com.tencent.xweb.g.a.ApS;
        }
        com.tencent.xweb.g.a aVar = com.tencent.xweb.g.a.ApS;
        try {
            return com.tencent.xweb.g.a.valueOf(str);
        } catch (Exception e) {
            return aVar;
        }
    }

    private static String aC(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(":");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static Map<String, String> acn(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.isEmpty())) {
            for (String str2 : str.split(";")) {
                if (!(str2 == null || str2.isEmpty())) {
                    String[] split = str2.split(":");
                    if (!(split.length != 2 || split[0] == null || split[1] == null)) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            }
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, Map<String, String> map2, String str) {
        ApI = map;
        ApJ = map2;
        ApH = str;
    }

    private static void b(Map<String, String> map, Map<String, String> map2, String str) {
        a(map, map2, str);
        String aC = aC(ApI);
        String aC2 = aC(ApJ);
        XWalkEnvironment.addXWalkInitializeLog("CommandCfg", "save cmds to : webtype = " + aC + "jstype = " + aC2 + "configver = " + ApH);
        Editor edit = cIi().edit();
        edit.putString("setwebtype", aC);
        edit.putString("setjscore", aC2);
        edit.putString("cStrTAGConfigVer", ApH);
        edit.commit();
    }

    private static SharedPreferences cIi() {
        return XWalkEnvironment.getApplicationContext().getSharedPreferences("XWEB.CMDCFG", 0);
    }
}
