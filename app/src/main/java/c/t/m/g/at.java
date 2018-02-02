package c.t.m.g;

import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public final class at extends al {
    private static at l = new at();

    private at() {
    }

    public static String a(String str, boolean z, Map<String, String> map) {
        String d = p.d();
        map.put("A23", m.e);
        av avVar = new av();
        avVar.a(str);
        avVar.a = System.currentTimeMillis();
        avVar.b = as.a;
        avVar.c = d;
        map.put("A1", m.d);
        map.put("A2", cg.a());
        map.put("A4", cg.b());
        map.put("A6", cg.c());
        map.put("A7", cg.e());
        map.put("A23", m.e);
        map.put("A33", p.f());
        map.put("A10", as.d);
        map.put("A9", as.c);
        map.put("A19", d);
        avVar.a(map);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        stringBuilder.append("INFO|");
        stringBuilder.append(v.a + "|");
        stringBuilder.append(as.b + "|");
        stringBuilder.append("beacon|");
        stringBuilder.append("1.8.1|");
        d = avVar.b;
        try {
            d = URLEncoder.encode(avVar.b, ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
        stringBuilder.append(d + "|");
        stringBuilder.append("|");
        stringBuilder.append("upload_ip|");
        stringBuilder.append("|");
        stringBuilder.append(avVar.c + "|");
        stringBuilder.append(avVar.a() + "|");
        stringBuilder.append(z + "|");
        stringBuilder.append("0|");
        stringBuilder.append("0|");
        stringBuilder.append(a(avVar.b()) + "|");
        stringBuilder.append(cg.a(avVar.a, "yyyy-MM-dd HH:mm:ss") + "|");
        stringBuilder.append("upload_time");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : keySet) {
            stringBuilder.append("&");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) map.get(str));
        }
        String str2 = stringBuilder.substring(1);
        stringBuilder.setLength(0);
        return str2;
    }

    public static at d() {
        return l;
    }

    public final String a() {
        return "halley-cloud-HalleyAction";
    }

    public final int b() {
        return v.a("report_insert_new_record_num_limit", 5, 100, 100);
    }

    public final String c() {
        return "beacon";
    }
}
