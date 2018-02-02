package org.b.g;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.b.b.b;

public final class c {
    private static final Map<String, String> AyT;
    private static String CHARSET = "UTF-8";

    static {
        Map hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        AyT = Collections.unmodifiableMap(hashMap);
    }

    public static String encode(String str) {
        d.j(str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, CHARSET);
            String str2 = encode;
            for (Entry entry : AyT.entrySet()) {
                String str3 = (String) entry.getKey();
                str2 = str2.replaceAll(Pattern.quote(str3), (String) entry.getValue());
            }
            return str2;
        } catch (Exception e) {
            throw new b("Charset not found while encoding string: " + CHARSET, e);
        }
    }

    public static String decode(String str) {
        d.j(str, "Cannot decode null object");
        try {
            return URLDecoder.decode(str, CHARSET);
        } catch (Exception e) {
            throw new b("Charset not found while decoding string: " + CHARSET, e);
        }
    }
}
