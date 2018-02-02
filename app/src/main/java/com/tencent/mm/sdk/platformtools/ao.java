package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ap.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ao {
    public static ap xgW = null;

    public static String fq(String str, String str2) {
        String replace = Vk(str).replace("+", "");
        if (xgW == null) {
            xgW = new ap();
        }
        int length;
        if (bh.ov(str2)) {
            for (a aVar : xgW.xgX) {
                if (replace.startsWith(aVar.xgZ)) {
                    length = replace.length() - aVar.xgZ.length();
                    if (length >= aVar.xha && length <= aVar.xhb) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.xgZ, aVar.xgY, Integer.valueOf(aVar.xhb), Integer.valueOf(aVar.xhb));
                        return aVar.xgZ;
                    }
                }
            }
        } else {
            for (a aVar2 : xgW.xgX) {
                if (replace.startsWith(aVar2.xgZ)) {
                    length = replace.length() - aVar2.xgZ.length();
                    if (length >= aVar2.xha && length <= aVar2.xhb && str2.equalsIgnoreCase(aVar2.xgY)) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.xgZ, aVar2.xgY, Integer.valueOf(aVar2.xhb), Integer.valueOf(aVar2.xhb));
                        return aVar2.xgZ;
                    }
                }
            }
        }
        return null;
    }

    public static String De(String str) {
        return fq(str, null);
    }

    public static String Vj(String str) {
        if (bh.ov(str) || !bh.VR(str).booleanValue()) {
            return str;
        }
        ao aoVar = new ao();
        String str2 = "86";
        if (str.startsWith("+")) {
            str = str.replace("+", "");
            str2 = fq(str, null);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return formatNumber(str2, str);
    }

    public static String Vk(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return str.replaceAll("[\\.\\-\\ ]", "").trim();
    }

    public static String Vl(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return str.replace("+", "");
    }

    public static String Vm(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return !str.startsWith("+") ? "+" + str : str;
    }

    public static String fr(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return "";
        }
        return str + "（+" + str2 + "）";
    }

    public static String formatNumber(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return str2;
        }
        if (xgW == null) {
            xgW = new ap();
        }
        for (a aVar : xgW.xgX) {
            if (!(aVar.xgZ == null || !str.trim().toLowerCase().equals(aVar.xgZ.trim().toLowerCase()) || aVar.xhc == null)) {
                String Vk = Vk(str2);
                if (Vk != null && Vk.length() > aVar.xha) {
                    return Vk;
                }
                for (b bVar : aVar.xhc) {
                    String af;
                    int i;
                    int i2;
                    char charAt;
                    StringBuffer stringBuffer;
                    int length;
                    if (bh.ov(bVar.xhd)) {
                        if (aVar.xhc.size() > 1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(Vk);
                            int length2 = Vk.length();
                            if (length2 <= cW(bVar.xhf, aVar.xhb)) {
                                while (stringBuffer2.toString().length() < aVar.xhb) {
                                    stringBuffer2.append("0");
                                }
                                af = af(bVar.xhf, bVar.xhe, stringBuffer2.toString());
                                Vk = af;
                                i = 0;
                                for (i2 = 0; i2 < Vk.length(); i2++) {
                                    charAt = Vk.charAt(i2);
                                    if (i >= length2) {
                                        Vk = Vk.substring(0, i2);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                        i++;
                                    }
                                }
                                return Vk;
                            }
                        } else {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(Vk);
                            length = Vk.length();
                            while (stringBuffer.toString().length() < aVar.xhb) {
                                stringBuffer.append("0");
                            }
                            String af2 = af(bVar.xhf, bVar.xhe, stringBuffer.toString());
                            i = 0;
                            for (int i3 = 0; i3 < af2.length(); i3++) {
                                charAt = af2.charAt(i3);
                                if (i >= length) {
                                    af2 = af2.substring(0, i3);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                    i++;
                                }
                            }
                            return af2;
                        }
                    } else if (Pattern.compile(bVar.xhd).matcher(Vk).lookingAt()) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(Vk);
                        length = Vk.length();
                        while (stringBuffer.toString().length() < aVar.xhb) {
                            stringBuffer.append(Vk.charAt(length - 1));
                        }
                        af = af(bVar.xhf, bVar.xhe, stringBuffer.toString());
                        Vk = af;
                        i = 0;
                        for (i2 = 0; i2 < Vk.length(); i2++) {
                            charAt = Vk.charAt(i2);
                            if (i >= length) {
                                Vk = Vk.substring(0, i2);
                            }
                            if (!(charAt == ' ' || charAt == '-' || charAt == '。')) {
                                i++;
                            }
                        }
                        return Vk;
                    }
                }
                continue;
            }
        }
        return str2;
    }

    private static int cW(String str, int i) {
        Pattern compile = Pattern.compile(str);
        Object obj = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(obj).find()) {
            obj = obj + "1";
            i2++;
        }
        return i2 + 1;
    }

    private static String af(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            return matcher.replaceAll(str2);
        }
        return str3;
    }
}
