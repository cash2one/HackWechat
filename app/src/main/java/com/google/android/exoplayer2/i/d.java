package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d {
    private static final Pattern aBZ = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern aCa = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern aCb = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> aCc;

    static {
        Map hashMap = new HashMap();
        aCc = hashMap;
        hashMap.put("aliceblue", Integer.valueOf(-984833));
        aCc.put("antiquewhite", Integer.valueOf(-332841));
        aCc.put("aqua", Integer.valueOf(-16711681));
        aCc.put("aquamarine", Integer.valueOf(-8388652));
        aCc.put("azure", Integer.valueOf(-983041));
        aCc.put("beige", Integer.valueOf(-657956));
        aCc.put("bisque", Integer.valueOf(-6972));
        aCc.put("black", Integer.valueOf(WebView.NIGHT_MODE_COLOR));
        aCc.put("blanchedalmond", Integer.valueOf(-5171));
        aCc.put("blue", Integer.valueOf(-16776961));
        aCc.put("blueviolet", Integer.valueOf(-7722014));
        aCc.put("brown", Integer.valueOf(-5952982));
        aCc.put("burlywood", Integer.valueOf(-2180985));
        aCc.put("cadetblue", Integer.valueOf(-10510688));
        aCc.put("chartreuse", Integer.valueOf(-8388864));
        aCc.put("chocolate", Integer.valueOf(-2987746));
        aCc.put("coral", Integer.valueOf(-32944));
        aCc.put("cornflowerblue", Integer.valueOf(-10185235));
        aCc.put("cornsilk", Integer.valueOf(-1828));
        aCc.put("crimson", Integer.valueOf(-2354116));
        aCc.put("cyan", Integer.valueOf(-16711681));
        aCc.put("darkblue", Integer.valueOf(-16777077));
        aCc.put("darkcyan", Integer.valueOf(-16741493));
        aCc.put("darkgoldenrod", Integer.valueOf(-4684277));
        aCc.put("darkgray", Integer.valueOf(-5658199));
        aCc.put("darkgreen", Integer.valueOf(-16751616));
        aCc.put("darkgrey", Integer.valueOf(-5658199));
        aCc.put("darkkhaki", Integer.valueOf(-4343957));
        aCc.put("darkmagenta", Integer.valueOf(-7667573));
        aCc.put("darkolivegreen", Integer.valueOf(-11179217));
        aCc.put("darkorange", Integer.valueOf(-29696));
        aCc.put("darkorchid", Integer.valueOf(-6737204));
        aCc.put("darkred", Integer.valueOf(-7667712));
        aCc.put("darksalmon", Integer.valueOf(-1468806));
        aCc.put("darkseagreen", Integer.valueOf(-7357297));
        aCc.put("darkslateblue", Integer.valueOf(-12042869));
        aCc.put("darkslategray", Integer.valueOf(-13676721));
        aCc.put("darkslategrey", Integer.valueOf(-13676721));
        aCc.put("darkturquoise", Integer.valueOf(-16724271));
        aCc.put("darkviolet", Integer.valueOf(-7077677));
        aCc.put("deeppink", Integer.valueOf(-60269));
        aCc.put("deepskyblue", Integer.valueOf(-16728065));
        aCc.put("dimgray", Integer.valueOf(-9868951));
        aCc.put("dimgrey", Integer.valueOf(-9868951));
        aCc.put("dodgerblue", Integer.valueOf(-14774017));
        aCc.put("firebrick", Integer.valueOf(-5103070));
        aCc.put("floralwhite", Integer.valueOf(-1296));
        aCc.put("forestgreen", Integer.valueOf(-14513374));
        aCc.put("fuchsia", Integer.valueOf(-65281));
        aCc.put("gainsboro", Integer.valueOf(-2302756));
        aCc.put("ghostwhite", Integer.valueOf(-460545));
        aCc.put("gold", Integer.valueOf(-10496));
        aCc.put("goldenrod", Integer.valueOf(-2448096));
        aCc.put("gray", Integer.valueOf(-8355712));
        aCc.put("green", Integer.valueOf(-16744448));
        aCc.put("greenyellow", Integer.valueOf(-5374161));
        aCc.put("grey", Integer.valueOf(-8355712));
        aCc.put("honeydew", Integer.valueOf(-983056));
        aCc.put("hotpink", Integer.valueOf(-38476));
        aCc.put("indianred", Integer.valueOf(-3318692));
        aCc.put("indigo", Integer.valueOf(-11861886));
        aCc.put("ivory", Integer.valueOf(-16));
        aCc.put("khaki", Integer.valueOf(-989556));
        aCc.put("lavender", Integer.valueOf(-1644806));
        aCc.put("lavenderblush", Integer.valueOf(-3851));
        aCc.put("lawngreen", Integer.valueOf(-8586240));
        aCc.put("lemonchiffon", Integer.valueOf(-1331));
        aCc.put("lightblue", Integer.valueOf(-5383962));
        aCc.put("lightcoral", Integer.valueOf(-1015680));
        aCc.put("lightcyan", Integer.valueOf(-2031617));
        aCc.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        aCc.put("lightgray", Integer.valueOf(-2894893));
        aCc.put("lightgreen", Integer.valueOf(-7278960));
        aCc.put("lightgrey", Integer.valueOf(-2894893));
        aCc.put("lightpink", Integer.valueOf(-18751));
        aCc.put("lightsalmon", Integer.valueOf(-24454));
        aCc.put("lightseagreen", Integer.valueOf(-14634326));
        aCc.put("lightskyblue", Integer.valueOf(-7876870));
        aCc.put("lightslategray", Integer.valueOf(-8943463));
        aCc.put("lightslategrey", Integer.valueOf(-8943463));
        aCc.put("lightsteelblue", Integer.valueOf(-5192482));
        aCc.put("lightyellow", Integer.valueOf(-32));
        aCc.put("lime", Integer.valueOf(-16711936));
        aCc.put("limegreen", Integer.valueOf(-13447886));
        aCc.put("linen", Integer.valueOf(-331546));
        aCc.put("magenta", Integer.valueOf(-65281));
        aCc.put("maroon", Integer.valueOf(-8388608));
        aCc.put("mediumaquamarine", Integer.valueOf(-10039894));
        aCc.put("mediumblue", Integer.valueOf(-16777011));
        aCc.put("mediumorchid", Integer.valueOf(-4565549));
        aCc.put("mediumpurple", Integer.valueOf(-7114533));
        aCc.put("mediumseagreen", Integer.valueOf(-12799119));
        aCc.put("mediumslateblue", Integer.valueOf(-8689426));
        aCc.put("mediumspringgreen", Integer.valueOf(-16713062));
        aCc.put("mediumturquoise", Integer.valueOf(-12004916));
        aCc.put("mediumvioletred", Integer.valueOf(-3730043));
        aCc.put("midnightblue", Integer.valueOf(-15132304));
        aCc.put("mintcream", Integer.valueOf(-655366));
        aCc.put("mistyrose", Integer.valueOf(-6943));
        aCc.put("moccasin", Integer.valueOf(-6987));
        aCc.put("navajowhite", Integer.valueOf(-8531));
        aCc.put("navy", Integer.valueOf(-16777088));
        aCc.put("oldlace", Integer.valueOf(-133658));
        aCc.put("olive", Integer.valueOf(-8355840));
        aCc.put("olivedrab", Integer.valueOf(-9728477));
        aCc.put("orange", Integer.valueOf(-23296));
        aCc.put("orangered", Integer.valueOf(-47872));
        aCc.put("orchid", Integer.valueOf(-2461482));
        aCc.put("palegoldenrod", Integer.valueOf(-1120086));
        aCc.put("palegreen", Integer.valueOf(-6751336));
        aCc.put("paleturquoise", Integer.valueOf(-5247250));
        aCc.put("palevioletred", Integer.valueOf(-2396013));
        aCc.put("papayawhip", Integer.valueOf(-4139));
        aCc.put("peachpuff", Integer.valueOf(-9543));
        aCc.put("peru", Integer.valueOf(-3308225));
        aCc.put("pink", Integer.valueOf(-16181));
        aCc.put("plum", Integer.valueOf(-2252579));
        aCc.put("powderblue", Integer.valueOf(-5185306));
        aCc.put("purple", Integer.valueOf(-8388480));
        aCc.put("rebeccapurple", Integer.valueOf(-10079335));
        aCc.put("red", Integer.valueOf(-65536));
        aCc.put("rosybrown", Integer.valueOf(-4419697));
        aCc.put("royalblue", Integer.valueOf(-12490271));
        aCc.put("saddlebrown", Integer.valueOf(-7650029));
        aCc.put("salmon", Integer.valueOf(-360334));
        aCc.put("sandybrown", Integer.valueOf(-744352));
        aCc.put("seagreen", Integer.valueOf(-13726889));
        aCc.put("seashell", Integer.valueOf(-2578));
        aCc.put("sienna", Integer.valueOf(-6270419));
        aCc.put("silver", Integer.valueOf(-4144960));
        aCc.put("skyblue", Integer.valueOf(-7876885));
        aCc.put("slateblue", Integer.valueOf(-9807155));
        aCc.put("slategray", Integer.valueOf(-9404272));
        aCc.put("slategrey", Integer.valueOf(-9404272));
        aCc.put("snow", Integer.valueOf(-1286));
        aCc.put("springgreen", Integer.valueOf(-16711809));
        aCc.put("steelblue", Integer.valueOf(-12156236));
        aCc.put("tan", Integer.valueOf(-2968436));
        aCc.put("teal", Integer.valueOf(-16744320));
        aCc.put("thistle", Integer.valueOf(-2572328));
        aCc.put("tomato", Integer.valueOf(-40121));
        aCc.put("transparent", Integer.valueOf(0));
        aCc.put("turquoise", Integer.valueOf(-12525360));
        aCc.put("violet", Integer.valueOf(-1146130));
        aCc.put("wheat", Integer.valueOf(-663885));
        aCc.put("white", Integer.valueOf(-1));
        aCc.put("whitesmoke", Integer.valueOf(-657931));
        aCc.put("yellow", Integer.valueOf(-256));
        aCc.put("yellowgreen", Integer.valueOf(-6632142));
    }

    public static int X(String str) {
        return d(str, false);
    }

    public static int Y(String str) {
        return d(str, true);
    }

    private static int d(String str, boolean z) {
        a.am(!TextUtils.isEmpty(str));
        Object replace = str.replace(" ", "");
        int parseLong;
        if (replace.charAt(0) == '#') {
            parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | WebView.NIGHT_MODE_COLOR;
            }
            if (replace.length() == 9) {
                return (parseLong >>> 8) | ((parseLong & 255) << 24);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            Matcher matcher = (z ? aCb : aCa).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseLong = (int) (255.0f * Float.parseFloat(matcher.group(4)));
                } else {
                    parseLong = Integer.parseInt(matcher.group(4), 10);
                }
                return argb(parseLong, Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = aBZ.matcher(replace);
            if (matcher2.matches()) {
                return argb(255, Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = (Integer) aCc.get(t.ai(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int argb(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }
}
