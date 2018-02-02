package com.tencent.mm.bc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bx.g;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.aj.d;
import com.tencent.mm.plugin.fts.d.b.a;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class b {
    public static final int hKB = Color.parseColor("#45C01A");
    public static final Pattern hKC = Pattern.compile(";");

    public static Spannable a(CharSequence charSequence, String str) {
        com.tencent.mm.plugin.fts.d.b.b a = f.a(a.d(charSequence, str));
        if (a.mQk instanceof Spannable) {
            return (Spannable) a.mQk;
        }
        return new SpannableString(a.mQk);
    }

    public static Spannable a(CharSequence charSequence, List<String> list) {
        com.tencent.mm.plugin.fts.d.b.b a = f.a(a.b(charSequence, list));
        if (a.mQk instanceof Spannable) {
            return (Spannable) a.mQk;
        }
        return new SpannableString(a.mQk);
    }

    public static String b(String str, List<String> list, String str2) {
        if (bh.ov(str)) {
            return "";
        }
        if (str2 == null) {
            str2 = bh.d(list, "");
        }
        a c = c(com.tencent.mm.plugin.fts.a.f.Bf(str.toString().toLowerCase()), com.tencent.mm.plugin.fts.a.f.Bf(str2.toLowerCase()));
        if (c.isAvailable()) {
            return a(str, c);
        }
        c = b((CharSequence) str, bh.d(list, ""));
        if (c.isAvailable()) {
            return a(str, c);
        }
        CharSequence Bf = com.tencent.mm.plugin.fts.a.f.Bf(str.toString().toLowerCase());
        ArrayList arrayList = new ArrayList();
        for (String toLowerCase : list) {
            c = c(Bf, com.tencent.mm.plugin.fts.a.f.Bf(toLowerCase.toLowerCase()));
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        if (arrayList.size() <= 0) {
            return str;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    private static a b(CharSequence charSequence, String str) {
        String Bf = com.tencent.mm.plugin.fts.a.f.Bf(str.toLowerCase());
        g.chg();
        String str2 = "";
        String fz = com.tencent.mm.bx.f.chd().fz(charSequence.toString(), str2);
        com.tencent.mm.bx.b.cgX();
        a c = c(com.tencent.mm.plugin.fts.a.f.Bf(com.tencent.mm.bx.b.fy(fz, str2).replaceAll(" ", "").toLowerCase()), Bf);
        if (c.isAvailable()) {
            int i = c.start;
            while (i < c.end && i < charSequence.length()) {
                if (charSequence.charAt(i) == ' ') {
                    c.end++;
                }
                i++;
            }
        }
        return c;
    }

    public static String a(String str, List<String> list, boolean z, String str2) {
        if (bh.ov(str)) {
            return "";
        }
        a b = b((CharSequence) str, str2);
        if (b.isAvailable()) {
            return a(str, b);
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (com.tencent.mm.plugin.fts.a.f.i(charAt)) {
                String g = SpellMap.g(charAt);
                if (g == null || g.length() <= 1) {
                    arrayList.add("");
                } else if (z) {
                    arrayList.add(g.substring(0, 1).toLowerCase());
                } else {
                    arrayList.add(g);
                }
            } else {
                arrayList.add("");
            }
        }
        Iterator it = c(arrayList, (List) list).iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    private static String a(String str, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, aVar.start));
        stringBuffer.append("<em class=\"highlight\">");
        stringBuffer.append(str.substring(aVar.start, aVar.end));
        stringBuffer.append("</em>");
        if (aVar.end < str.length()) {
            stringBuffer.append(str.substring(aVar.end, str.length()));
        }
        return stringBuffer.toString();
    }

    private static ArrayList<a> c(List<String> list, List<String> list2) {
        ArrayList<a> arrayList = new ArrayList();
        for (String toLowerCase : list2) {
            a c = c((List) list, toLowerCase.toLowerCase());
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    private static a c(List<String> list, String str) {
        a aVar = new a();
        for (int i = 0; i < list.size(); i++) {
            String str2 = (String) list.get(i);
            if (!bh.ov(str2)) {
                if (str2.startsWith(str)) {
                    if (aVar.start < 0) {
                        aVar.start = i;
                    }
                    aVar.end = i + 1;
                    return aVar;
                } else if (str.startsWith(str2)) {
                    int i2 = i + 1;
                    String str3 = str2;
                    while (i2 < list.size() && !bh.ov((String) list.get(i2))) {
                        str3 = str3 + ((String) list.get(i2));
                        if (str.length() > str3.length() && str.startsWith(str3)) {
                            i2++;
                        } else if (str.length() <= str3.length() && str3.startsWith(str)) {
                            aVar.start = i;
                            aVar.end = i2 + 1;
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static a c(CharSequence charSequence, String str) {
        int indexOf = charSequence.toString().indexOf(str);
        a aVar = new a();
        if (indexOf >= 0) {
            aVar.start = indexOf;
            aVar.end = aVar.start + str.length();
        }
        return aVar;
    }

    public static Map<String, String> bj(int i, int i2) {
        switch (i) {
            case 201:
                return m.b(i, false, i2);
            default:
                return b(i, false, i2);
        }
    }

    public static Map<String, String> b(int i, boolean z, int i2) {
        return a(i, z, i2, "");
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        return a(i, z, i2, str, "", "", "", "", "", "", "");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Map<String, String> a(int i, boolean z, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Object valueOf;
        Map<String, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("searchId", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("sessionId", str3);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("subSessionId", str6);
        }
        if (!TextUtils.isEmpty(str4)) {
            try {
                hashMap.put("query", p.encode(str4, "UTF-8"));
            } catch (Exception e) {
                hashMap.put("query", str4);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("sceneActionType", str5);
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("pRequestId", str8);
        }
        hashMap.put("scene", String.valueOf(i));
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i2));
        hashMap.put("lang", w.eL(ac.getContext()));
        hashMap.put("platform", "android");
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("poiInfo", str7);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        switch (i) {
            case 21:
                valueOf = String.valueOf(com.tencent.mm.plugin.aj.a.g.zN(1));
                break;
            default:
                valueOf = String.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0));
                break;
        }
        hashMap.put("version", valueOf);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        JSONObject NT;
        boolean z5;
        switch (i) {
            case 3:
            case 14:
            case 20:
            case 22:
                if (i2 == 1 && h.NT("bizTab").optInt("bizSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 2 && h.NT("articleTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 8) {
                    NT = h.NT("snsTab");
                    if (NT.optInt("sugSwitch", 0) == 1) {
                        z2 = true;
                    }
                    if (NT.optInt("localSugSwitch", 0) == 1) {
                        z3 = true;
                    }
                }
                if (!z && i2 == 4 && h.NT("bizTab").optInt("bizServiceSugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 1 && h.NT("bizTab").optInt("mfsBizSwitch", 0) == 1) {
                    z4 = true;
                }
                if (i2 == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && h.NT("novelTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == WXMediaMessage.TITLE_LENGTH_LIMIT && h.NT("musicTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 384 && h.NT("emotionTab").optInt("sugSwitch", 0) == 1) {
                    z2 = true;
                }
                if (i2 == 0 && z) {
                    if (h.NT("mixGlobal").optInt("mixSugSwitch", 0) == 1) {
                        z2 = true;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                    break;
                }
            case 6:
            case 9:
                if (h.NT("bizEntry").optInt("sugSwitch") == 1) {
                    break;
                }
                z5 = z4;
                z4 = z3;
                z3 = z2;
                z2 = z5;
                break;
            case 11:
                if (h.NT("bizUnionTopEntry").optInt("sugSwitch") == 1) {
                    break;
                }
                z5 = z4;
                z4 = z3;
                z3 = z2;
                z2 = z5;
                break;
            case 24:
                if (i2 == 384) {
                    if (h.NT("emoticonMall").optInt("sugSwitch", 0) == 1) {
                        z2 = true;
                    }
                    z4 = false;
                    z3 = z2;
                    z2 = false;
                    break;
                }
            case 33:
                break;
            case 300:
                NT = h.NT("mixGlobal");
                if (z) {
                    break;
                } else if (i2 == 1) {
                    if (NT.optInt("bizSugSwitch", 0) == 1) {
                        break;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                    break;
                } else if (i2 == 8) {
                    if (NT.optInt("snsSugSwitch", 0) == 1) {
                        break;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                } else if (i2 == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    if (NT.optInt("novelSugSwitch", 0) == 1) {
                        break;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                } else if (i2 == WXMediaMessage.TITLE_LENGTH_LIMIT) {
                    if (NT.optInt("musicSugSwitch", 0) == 1) {
                        break;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                } else {
                    if ((i2 == 384 || i2 == 256 || i2 == FileUtils.S_IWUSR) && NT.optInt("emotionSugSwitch", 0) == 1) {
                        break;
                    }
                    z5 = z4;
                    z4 = z3;
                    z3 = z2;
                    z2 = z5;
                }
        }
    }

    public static String c(int i, Map<String, String> map) {
        switch (i) {
            case 21:
                return a((Map) map, 1);
            case 201:
                return m.r(map);
            default:
                return a((Map) map, 0);
        }
    }

    public static String r(Map<String, String> map) {
        return a((Map) map, 0);
    }

    public static String a(Map<String, String> map, int i) {
        int i2 = 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String Rh = com.tencent.mm.plugin.aj.a.g.zI(i).Rh();
        String str = "isOpenPreload";
        StringBuilder stringBuilder = new StringBuilder();
        d bOL = d.bOL();
        int i3 = i == 1 ? 2 : 1;
        if (ac.cfw()) {
            boolean bOM;
            switch (i3) {
                case 1:
                    bOM = bOL.bOM();
                    break;
                default:
                    bOM = bOL.bON();
                    break;
            }
            if (!bOM) {
                i2 = 0;
            }
            map.put(str, stringBuilder.append(i2).toString());
            stringBuffer.append(Rh);
            StringBuffer append;
            if (map.size() > 0) {
                append = stringBuffer.append("/");
                com.tencent.mm.plugin.aj.a.g.zI(i);
                append.append("app.html?");
                for (Entry entry : map.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append((String) entry.getValue());
                    stringBuffer.append("&");
                }
                String str2 = (String) map.get("sessionId");
                if (!map.containsKey("sessionId")) {
                    str2 = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) map.get("scene")));
                    stringBuffer.append("sessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                if (!map.containsKey("subSessionId")) {
                    stringBuffer.append("subSessionId");
                    stringBuffer.append("=");
                    stringBuffer.append(str2);
                    stringBuffer.append("&");
                }
                return stringBuffer.substring(0, stringBuffer.length() - 1);
            }
            append = stringBuffer.append("/");
            com.tencent.mm.plugin.aj.a.g.zI(i);
            append.append("app.html");
            return stringBuffer.toString();
        }
        throw new IllegalStateException("please call from main process");
    }

    private static Intent o(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public static Intent QM() {
        return o(new Intent());
    }

    public static void p(Intent intent) {
        intent.putExtra("ftsbizscene", 24);
        Map b = b(24, false, 384);
        String zH = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) b.get("scene")));
        b.put("sessionId", zH);
        intent.putExtra("sessionId", zH);
        intent.putExtra("rawUrl", a(b, 0));
        intent.putExtra("ftsType", 384);
    }

    public static String s(Map<String, ? extends Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt != 0) {
            return optInt;
        }
        if (str.equals(context.getString(R.l.eIP))) {
            return 2;
        }
        if (str.equals(context.getString(R.l.eIR))) {
            return 8;
        }
        if (str.equals(context.getString(R.l.eIQ))) {
            return 1;
        }
        x.i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
        return optInt;
    }

    public static Drawable b(int i, Context context) {
        int i2 = R.k.dAW;
        switch (i) {
            case 1:
                i2 = R.k.dAU;
                break;
            case 2:
                i2 = R.k.dAN;
                break;
            case 8:
                i2 = R.k.dAR;
                break;
            case 64:
                i2 = R.k.dAQ;
                break;
            case 256:
            case 384:
                i2 = R.k.dAO;
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                i2 = R.k.dAS;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.k.dAT;
                break;
            case 12582912:
                i2 = R.k.dAX;
                break;
            case 16777248:
                i2 = R.k.dAV;
                break;
            case 16777728:
                i2 = R.k.dAY;
                break;
        }
        return context.getResources().getDrawable(i2);
    }

    public static int il(int i) {
        if (i == 201) {
            return 1006;
        }
        if (i == 3) {
            return 1005;
        }
        if (i == 16) {
            return 1042;
        }
        if (i == 20) {
            return 1053;
        }
        return 1000;
    }

    public static boolean aq(String str, String str2) {
        int i = 0;
        if (str == str2) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            while (i < str.length()) {
                stringBuilder.append(SpellMap.g(str.charAt(i)));
                i++;
            }
            str3 = stringBuilder.toString();
        }
        return str3.startsWith(str2);
    }

    public static boolean QN() {
        JSONObject NT = h.NT("snsContactMatch");
        if (NT == null) {
            return false;
        }
        if (NT.optInt("matchSwitch") == 1) {
            return true;
        }
        return false;
    }

    public static int QO() {
        JSONObject NT = h.NT("snsContactMatch");
        if (NT != null) {
            return NT.optInt("queryUtfLenLimit");
        }
        return 0;
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5) {
        a(context, str, intent, str2, null, null, str4, str5, str3);
    }

    public static boolean c(Activity activity, int i) {
        try {
            if (android.support.v4.content.a.b(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.h(15104, new Object[]{Integer.valueOf(i), Integer.valueOf(2)});
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(15104, new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
            if (android.support.v4.app.a.a(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                x.w("MicroMsg.FTS.FTSExportLogic", "has shown request permission and user denied, do not show agagin");
                return true;
            }
            x.w("MicroMsg.FTS.FTSExportLogic", "showing request permission dialog");
            android.support.v4.app.a.a(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 73);
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, "", new Object[0]);
            return true;
        }
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        a(context, str, intent, str2, str3, str4, str5, str6, "");
    }

    private static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (intent == null || context == null) {
            x.e("MicroMsg.FTS.FTSExportLogic", "openNews intent is null, or context is null");
            return;
        }
        String zH;
        String zH2;
        Intent o = o(intent);
        o.putExtra("ftsbizscene", 21);
        o.putExtra("ftsQuery", str);
        if (str2 != null) {
            o.putExtra("title", str2);
        }
        o.putExtra("isWebwx", str);
        o.putExtra("ftscaneditable", false);
        o.putExtra("key_load_js_without_delay", true);
        if (TextUtils.isEmpty(str5)) {
            zH = com.tencent.mm.plugin.aj.a.g.zH(21);
        } else {
            zH = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            zH2 = com.tencent.mm.plugin.aj.a.g.zH(21);
        } else {
            zH2 = str6;
        }
        o.putExtra("rawUrl", a(str3, str4, zH, str, "2", false, zH2, str7));
        o.putExtra("sessionId", zH);
        o.putExtra("customize_status_bar_color", context.getResources().getColor(R.e.bug));
        o.putExtra("status_bar_style", "black");
        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.fts.FTSWebViewUI", o);
    }

    public static String QP() {
        return h.NT("discoverRecommendEntry").optString("wording");
    }

    private static String a(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        Map a = a(21, false, 2, str, str2, str3, str4, str5, str6, "", str7);
        if (z) {
            a.put("isPreload", "1");
        }
        return a(a, 1);
    }

    public static void QQ() {
        Object obj;
        String QP = QP();
        if (bh.ov(QP)) {
            x.e("MicroMsg.FTS.FTSExportLogic", "empty query");
            obj = "";
        } else {
            obj = a(null, null, com.tencent.mm.plugin.aj.a.g.zH(21), QP, null, true, com.tencent.mm.plugin.aj.a.g.zH(21), "");
        }
        if (!TextUtils.isEmpty(obj)) {
            d.bOL().cu(obj, 2);
        }
    }

    public static void QR() {
        Object a = a(3, com.tencent.mm.plugin.aj.a.g.zH(3), true, "");
        if (!TextUtils.isEmpty(a)) {
            d.bOL().cu(a, 3);
        }
    }

    public static void QS() {
        Object a = a(20, com.tencent.mm.plugin.aj.a.g.zH(20), true, "");
        if (!TextUtils.isEmpty(a)) {
            d.bOL().cu(a, 1);
        }
    }

    public static String ar(String str, String str2) {
        return a(20, str, false, str2);
    }

    private static String a(int i, String str, boolean z, String str2) {
        Map b = b(i, true, 0);
        b.put("sessionId", str);
        b.put("inputMarginTop", "32");
        b.put("inputMarginLeftRight", "24");
        b.put("inputHeight", "48");
        if (z) {
            b.put("isPreload", "1");
        } else if (!(str2 == null || str2.isEmpty())) {
            b.put("educationTab", Uri.encode(str2));
        }
        return a(b, 0);
    }

    public static boolean bn(long j) {
        x.i("MicroMsg.FTS.FTSExportLogic", "rec updateRedDotTimestamp %d", new Object[]{Long.valueOf(j)});
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xxz, Long.valueOf(j));
        return false;
    }

    public static long QT() {
        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xxz, null);
        return obj == null ? 0 : ((Long) obj).longValue();
    }

    public static long lS(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        x.i("MicroMsg.FTS.FTSExportLogic", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }
}
