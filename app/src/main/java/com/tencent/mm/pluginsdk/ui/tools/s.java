package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class s {
    private static as icl = null;
    private static final Pattern tjI = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    private static final Map<String, String> tjJ;
    private static final Map<String, String> tjK;

    public interface b {
        void sS(String str);
    }

    public static String aL(Context context, String str) {
        String str2;
        Assert.assertTrue("MicroMsg.WebViewUtil, appendUserAgent fail, context is null, stack = " + bh.cgy(), context != null);
        if (str == null) {
            str2 = " MicroMessenger/";
        } else {
            str2 = str + " MicroMessenger/";
        }
        PackageInfo packageInfo = getPackageInfo(context, ac.getPackageName());
        if (packageInfo != null) {
            str2 = ((str2 + f.ag(null, d.vAz)) + "." + packageInfo.versionCode) + "(0x26060235)";
        }
        str2 = (str2 + " NetType/" + an.eP(ac.getContext())) + " Language/" + w.eL(ac.getContext());
        x.i("MicroMsg.WebViewUtil", "appendUserAgent, uaStr = " + str2);
        return str2;
    }

    public static boolean SQ(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
    }

    public static boolean eE(String str, String str2) {
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0 || str2.length() > str.length() || !str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            return false;
        }
        return true;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            x.e("MicroMsg.WebViewUtil", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpg"));
        arrayList.add(new Pair("json", "application/json"));
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put(pair.first, pair.second);
            hashMap2.put(pair.second, pair.first);
        }
        tjJ = Collections.unmodifiableMap(hashMap);
        tjK = Collections.unmodifiableMap(hashMap2);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (icl == null) {
            icl = new as(1, "webview-save-image", 1);
        }
        icl.c(new c(context, str, str2, z));
    }

    public static void a(Context context, String str, String str2, boolean z, b bVar) {
        if (icl == null) {
            icl = new as(1, "webview-save-image", 1);
        }
        icl.c(new c(context, str, str2, z, 1, bVar));
    }

    public static void a(WebView webView) {
        x.d("MicroMsg.WebViewUtil", "initIFrame");
        ag.y(new 1(webView));
    }

    public static void a(WebView webView, String str, String str2) {
        a(webView, str, str2, true);
    }

    public static void a(WebView webView, String str, String str2, boolean z) {
        if (webView == null || bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", new Object[]{str, str2});
            return;
        }
        x.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", new Object[]{str, str2});
        a(webView);
        ag.y(new 2(z, webView, str, str2));
    }

    public static String fj(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", new Object[]{str, str2});
            return null;
        }
        x.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", new Object[]{str, str2});
        return "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
    }

    public static final String ar(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(bh.ov(str) || obj == null)) {
                if (!(obj instanceof String) || !bh.ov((String) obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("=");
                    stringBuilder.append(obj);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static final String SR(String str) {
        if (!bh.ov(str)) {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", new Object[]{e.getMessage()});
            }
        }
        return str;
    }

    public static final String SS(String str) {
        if (bh.ov(str)) {
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            x.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", new Object[]{unsupportedEncodingException.getMessage()});
        }
        return Base64.encodeToString(bytes, 2);
    }

    private static String es(Context context) {
        WifiInfo connectionInfo;
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return "127.0.0.1";
        }
        int ipAddress = connectionInfo.getIpAddress();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
    }

    public static String ccQ() {
        int i = 0;
        try {
            i = com.tencent.mm.compatible.d.w.yV();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", new Object[]{e});
        }
        if (i == 0) {
            return "127.0.0.1";
        }
        if (i == 1) {
            return es(ac.getContext());
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return bh.ov(inetAddress.getHostAddress()) ? "127.0.0.1" : inetAddress.getHostAddress();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e2) {
        }
        return "127.0.0.1";
    }

    public static String ST(String str) {
        if (!bh.ov(str) && tjI.matcher(str).matches()) {
            return str.substring(str.indexOf("base64,") + 7).trim();
        }
        return null;
    }

    public static String bQV() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ac.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        x.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", new Object[]{activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo()});
        if (activeNetworkInfo.getExtraInfo() != null) {
            return activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return "no";
    }

    public static String SU(String str) {
        String str2 = "";
        if (str == null || !str.startsWith("Refused to frame")) {
            return str2;
        }
        String[] split = str.split("'");
        if (split.length > 2) {
            return split[1];
        }
        return str2;
    }

    public static String SV(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = (String) tjJ.get(str.toLowerCase());
        if (!bh.ov(str2) || bh.ov(str)) {
            return str2;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static String SW(String str) {
        return SV(SX(str));
    }

    public static String SX(String str) {
        if (bh.ov(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String Sd(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = (String) tjK.get(str.toLowerCase());
        if (bh.ov(str2)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return str2;
    }
}
