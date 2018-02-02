package com.tencent.mm.sdk.platformtools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public final class q {
    private static final Pattern xeI = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern xeJ = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern xeK = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean isIPv4Address(String str) {
        return xeI.matcher(str).matches();
    }

    public static boolean isIPv6Address(String str) {
        return xeJ.matcher(str).matches() || xeK.matcher(str).matches();
    }

    public static InetAddress UT(String str) {
        if (isIPv4Address(str)) {
            return InetAddress.getByName(str);
        }
        if (isIPv6Address(str)) {
            return InetAddress.getByName(str);
        }
        throw new UnknownHostException("invalid ipv4 or ipv6 dotted string");
    }
}
