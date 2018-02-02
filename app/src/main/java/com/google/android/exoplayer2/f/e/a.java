package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.i.u;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends b {
    private static final Pattern ayC = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern ayD = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern ayE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern ayF = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final a ayG = new a(30.0f, 1, 1);
    private final XmlPullParserFactory ayH;

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        return g(bArr, i);
    }

    public a() {
        super("TtmlDecoder");
        try {
            this.ayH = XmlPullParserFactory.newInstance();
            this.ayH.setNamespaceAware(true);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private e g(byte[] bArr, int i) {
        try {
            XmlPullParser newPullParser = this.ayH.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new c());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            e eVar = null;
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            a aVar = ayG;
            int i2 = 0;
            for (int i3 = eventType; i3 != 1; i3 = newPullParser.getEventType()) {
                b bVar = (b) linkedList.peekLast();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (i3 == 2) {
                        a aVar2;
                        if ("tt".equals(name)) {
                            int parseInt;
                            float parseInt2;
                            int parseInt3;
                            int parseInt4;
                            String attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
                            if (attributeValue != null) {
                                parseInt = Integer.parseInt(attributeValue);
                            } else {
                                parseInt = 30;
                            }
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
                            if (attributeValue != null) {
                                String[] split = attributeValue.split(" ");
                                if (split.length != 2) {
                                    throw new f("frameRateMultiplier doesn't have 2 parts");
                                }
                                parseInt2 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
                            } else {
                                parseInt2 = 1.0f;
                            }
                            i3 = ayG.ayJ;
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
                            if (attributeValue != null) {
                                parseInt3 = Integer.parseInt(attributeValue);
                            } else {
                                parseInt3 = i3;
                            }
                            i3 = ayG.ayK;
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
                            if (attributeValue != null) {
                                parseInt4 = Integer.parseInt(attributeValue);
                            } else {
                                parseInt4 = i3;
                            }
                            aVar2 = new a(parseInt2 * ((float) parseInt), parseInt3, parseInt4);
                        } else {
                            aVar2 = aVar;
                        }
                        Object obj = (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals("style") || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("smpte:image") || name.equals("smpte:data") || name.equals("smpte:information")) ? 1 : null;
                        if (obj == null) {
                            new StringBuilder("Ignoring unsupported tag: ").append(newPullParser.getName());
                            aVar = aVar2;
                            i3 = i2 + 1;
                        } else if ("head".equals(name)) {
                            a(newPullParser, (Map) hashMap, (Map) hashMap2);
                            aVar = aVar2;
                            i3 = i2;
                        } else {
                            try {
                                b a = a(newPullParser, bVar, hashMap2, aVar2);
                                linkedList.addLast(a);
                                if (bVar != null) {
                                    bVar.a(a);
                                }
                                aVar = aVar2;
                                i3 = i2;
                            } catch (f e) {
                                aVar = aVar2;
                                i3 = i2 + 1;
                            }
                        }
                    } else if (i3 == 4) {
                        bVar.a(new b(null, newPullParser.getText().replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, ""));
                        i3 = i2;
                    } else {
                        e eVar2;
                        if (i3 == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                eVar2 = new e((b) linkedList.getLast(), hashMap, hashMap2);
                            } else {
                                eVar2 = eVar;
                            }
                            linkedList.removeLast();
                        } else {
                            eVar2 = eVar;
                        }
                        i3 = i2;
                        eVar = eVar2;
                    }
                } else if (i3 == 2) {
                    i3 = i2 + 1;
                } else if (i3 == 3) {
                    i3 = i2 - 1;
                } else {
                    i3 = i2;
                }
                newPullParser.next();
                i2 = i3;
            }
            return eVar;
        } catch (Throwable e2) {
            throw new f("Unable to decode source", e2);
        } catch (Throwable e22) {
            throw new IllegalStateException("Unexpected error when reading input.", e22);
        }
    }

    private Map<String, d> a(XmlPullParser xmlPullParser, Map<String, d> map, Map<String, c> map2) {
        Object obj;
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser, "style")) {
                String c = u.c(xmlPullParser, "style");
                d a = a(xmlPullParser, new d());
                if (c != null) {
                    for (Object obj2 : c.split("\\s+")) {
                        a.b((d) map.get(obj2));
                    }
                }
                if (a.id != null) {
                    map.put(a.id, a);
                }
            } else if (u.b(xmlPullParser, "region")) {
                c a2 = a(xmlPullParser);
                if (a2 != null) {
                    map2.put(a2.id, a2);
                }
            }
            String str = "head";
            if (xmlPullParser.getEventType() == 3) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null || !xmlPullParser.getName().equals(str)) {
                obj2 = null;
                continue;
            } else {
                obj2 = 1;
                continue;
            }
        } while (obj2 == null);
        return map;
    }

    private static c a(XmlPullParser xmlPullParser) {
        int i = 1;
        c cVar = null;
        String c = u.c(xmlPullParser, SlookAirButtonFrequentContactAdapter.ID);
        if (c == null) {
            return cVar;
        }
        CharSequence c2 = u.c(xmlPullParser, "origin");
        if (c2 == null) {
            return cVar;
        }
        Matcher matcher = ayF.matcher(c2);
        if (!matcher.matches()) {
            return cVar;
        }
        try {
            float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
            float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
            CharSequence c3 = u.c(xmlPullParser, "extent");
            if (c3 == null) {
                return cVar;
            }
            Matcher matcher2 = ayF.matcher(c3);
            if (!matcher2.matches()) {
                return cVar;
            }
            try {
                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                String c4 = u.c(xmlPullParser, "displayAlign");
                if (c4 != null) {
                    String ai = t.ai(c4);
                    int i2 = -1;
                    switch (ai.hashCode()) {
                        case -1364013995:
                            if (ai.equals("center")) {
                                i2 = 0;
                                break;
                            }
                            break;
                        case 92734940:
                            if (ai.equals("after")) {
                                i2 = 1;
                                break;
                            }
                            break;
                    }
                    switch (i2) {
                        case 0:
                            parseFloat2 += parseFloat4 / 2.0f;
                            break;
                        case 1:
                            parseFloat2 += parseFloat4;
                            i = 2;
                            break;
                    }
                }
                i = 0;
                return new c(c, parseFloat, parseFloat2, 0, i, parseFloat3);
            } catch (NumberFormatException e) {
                return cVar;
            }
        } catch (NumberFormatException e2) {
            return cVar;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static d a(XmlPullParser xmlPullParser, d dVar) {
        int attributeCount = xmlPullParser.getAttributeCount();
        d dVar2 = dVar;
        for (int i = 0; i < attributeCount; i++) {
            boolean z;
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        z = true;
                        break;
                    }
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        z = true;
                        break;
                    }
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        z = true;
                        break;
                    }
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        z = true;
                        break;
                    }
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        z = true;
                        break;
                    }
                case 3355:
                    if (attributeName.equals(SlookAirButtonFrequentContactAdapter.ID)) {
                        z = false;
                        break;
                    }
                case 94842723:
                    if (attributeName.equals("color")) {
                        z = true;
                        break;
                    }
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        z = true;
                        break;
                    }
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            d a;
            boolean z2;
            boolean equalsIgnoreCase;
            switch (z) {
                case false:
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    }
                    dVar2 = a(dVar2);
                    dVar2.id = attributeValue;
                    break;
                case true:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.cM(com.google.android.exoplayer2.i.d.X(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        break;
                    }
                case true:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.cL(com.google.android.exoplayer2.i.d.X(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        break;
                    }
                case true:
                    a = a(dVar2);
                    if (a.azc == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.i.a.an(z2);
                    a.ayS = attributeValue;
                    dVar2 = a;
                    break;
                case true:
                    try {
                        Matcher matcher;
                        dVar2 = a(dVar2);
                        String[] split = attributeValue.split("\\s+");
                        if (split.length == 1) {
                            matcher = ayE.matcher(attributeValue);
                        } else if (split.length == 2) {
                            matcher = ayE.matcher(split[1]);
                        } else {
                            throw new f("Invalid number of entries for fontSize: " + split.length + ".");
                        }
                        if (matcher.matches()) {
                            attributeValue = matcher.group(3);
                            switch (attributeValue.hashCode()) {
                                case 37:
                                    if (attributeValue.equals("%")) {
                                        z = true;
                                        break;
                                    }
                                case 3240:
                                    if (attributeValue.equals("em")) {
                                        z = true;
                                        break;
                                    }
                                case 3592:
                                    if (attributeValue.equals("px")) {
                                        z = false;
                                        break;
                                    }
                                default:
                                    z = true;
                                    break;
                            }
                            switch (z) {
                                case false:
                                    dVar2.aza = 1;
                                    break;
                                case true:
                                    dVar2.aza = 2;
                                    break;
                                case true:
                                    dVar2.aza = 3;
                                    break;
                                default:
                                    throw new f("Invalid unit for fontSize: '" + attributeValue + "'.");
                            }
                            dVar2.azb = Float.valueOf(matcher.group(1)).floatValue();
                            break;
                        }
                        throw new f("Invalid expression for fontSize: '" + attributeValue + "'.");
                    } catch (f e3) {
                        break;
                    }
                case true:
                    a = a(dVar2);
                    equalsIgnoreCase = "bold".equalsIgnoreCase(attributeValue);
                    if (a.azc == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.i.a.an(z2);
                    a.ayY = equalsIgnoreCase ? 1 : 0;
                    dVar2 = a;
                    break;
                case true:
                    a = a(dVar2);
                    equalsIgnoreCase = "italic".equalsIgnoreCase(attributeValue);
                    if (a.azc == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.i.a.an(z2);
                    a.ayZ = equalsIgnoreCase ? 1 : 0;
                    dVar2 = a;
                    break;
                case true:
                    attributeName = t.ai(attributeValue);
                    switch (attributeName.hashCode()) {
                        case -1364013995:
                            if (attributeName.equals("center")) {
                                z = true;
                                break;
                            }
                        case 100571:
                            if (attributeName.equals("end")) {
                                z = true;
                                break;
                            }
                        case 3317767:
                            if (attributeName.equals("left")) {
                                z = false;
                                break;
                            }
                        case 108511772:
                            if (attributeName.equals("right")) {
                                z = true;
                                break;
                            }
                        case 109757538:
                            if (attributeName.equals("start")) {
                                z = true;
                                break;
                            }
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            dVar2 = a(dVar2);
                            dVar2.azd = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.azd = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.azd = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.azd = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.azd = Alignment.ALIGN_CENTER;
                            break;
                        default:
                            break;
                    }
                case true:
                    attributeName = t.ai(attributeValue);
                    switch (attributeName.hashCode()) {
                        case -1461280213:
                            if (attributeName.equals("nounderline")) {
                                z = true;
                                break;
                            }
                        case -1026963764:
                            if (attributeName.equals("underline")) {
                                z = true;
                                break;
                            }
                        case 913457136:
                            if (attributeName.equals("nolinethrough")) {
                                z = true;
                                break;
                            }
                        case 1679736913:
                            if (attributeName.equals("linethrough")) {
                                z = false;
                                break;
                            }
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            dVar2 = a(dVar2).aj(true);
                            break;
                        case true:
                            dVar2 = a(dVar2).aj(false);
                            break;
                        case true:
                            dVar2 = a(dVar2).ak(true);
                            break;
                        case true:
                            dVar2 = a(dVar2).ak(false);
                            break;
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
        return dVar2;
    }

    private static d a(d dVar) {
        return dVar == null ? new d() : dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b a(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, a aVar) {
        long j;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        String str = "";
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        d a = a(xmlPullParser, null);
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            Object obj = -1;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        obj = null;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            long a2;
            switch (obj) {
                case null:
                    j3 = j2;
                    a2 = a(attributeValue, aVar);
                    j = j4;
                    j4 = a2;
                    break;
                case 1:
                    j = a(attributeValue, aVar);
                    j4 = j3;
                    j3 = j2;
                    break;
                case 2:
                    a2 = j4;
                    j4 = j3;
                    j3 = a(attributeValue, aVar);
                    j = a2;
                    break;
                case 3:
                    String[] split = attributeValue.split("\\s+");
                    if (split.length > 0) {
                        strArr = split;
                        j = j4;
                        j4 = j3;
                        j3 = j2;
                        break;
                    }
                case 4:
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        j = j4;
                        j4 = j3;
                        j3 = j2;
                        break;
                    }
                default:
                    j = j4;
                    j4 = j3;
                    j3 = j2;
                    break;
            }
            i++;
            j2 = j3;
            j3 = j4;
            j4 = j;
        }
        if (!(bVar == null || bVar.asL == -9223372036854775807L)) {
            if (j3 != -9223372036854775807L) {
                j3 += bVar.asL;
            }
            if (j4 != -9223372036854775807L) {
                j = j4 + bVar.asL;
                if (j == -9223372036854775807L) {
                    if (j2 != -9223372036854775807L) {
                        if (!(bVar == null || bVar.asM == -9223372036854775807L)) {
                        }
                    }
                    return new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
                }
                j2 = j;
                return new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
            }
        }
        j = j4;
        if (j == -9223372036854775807L) {
            j2 = j2 != -9223372036854775807L ? bVar.asM : j2 + j3;
            return new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
        }
        j2 = j;
        return new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
    }

    private static long a(String str, a aVar) {
        double d = 0.0d;
        Matcher matcher = ayC.matcher(str);
        double parseLong;
        if (matcher.matches()) {
            double parseLong2 = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong2 += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            if (group != null) {
                parseLong = (double) (((float) Long.parseLong(group)) / aVar.ayI);
            } else {
                parseLong = 0.0d;
            }
            parseLong += parseLong2;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) aVar.ayJ)) / ((double) aVar.ayI);
            }
            return (long) ((parseLong + d) * 1000000.0d);
        }
        Matcher matcher2 = ayD.matcher(str);
        if (matcher2.matches()) {
            parseLong = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            int i = -1;
            switch (group3.hashCode()) {
                case 102:
                    if (group3.equals("f")) {
                        i = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group3.equals("h")) {
                        i = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group3.equals("m")) {
                        i = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group3.equals("s")) {
                        i = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group3.equals("t")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group3.equals("ms")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    parseLong *= 3600.0d;
                    break;
                case 1:
                    parseLong *= 60.0d;
                    break;
                case 3:
                    parseLong /= 1000.0d;
                    break;
                case 4:
                    parseLong /= (double) aVar.ayI;
                    break;
                case 5:
                    parseLong /= (double) aVar.ayK;
                    break;
            }
            return (long) (parseLong * 1000000.0d);
        }
        throw new f("Malformed time expression: " + str);
    }
}
