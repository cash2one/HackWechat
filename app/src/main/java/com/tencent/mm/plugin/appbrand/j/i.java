package com.tencent.mm.plugin.appbrand.j;

import android.net.Uri;
import com.tencent.mm.bq.b;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.protocal.c.aqb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

public enum i {
    ;

    private static HashMap<String, String> tw(String str) {
        Object scheme;
        Exception e;
        HashMap<String, String> hashMap;
        Object obj = "";
        String str2 = "";
        Object obj2 = "";
        try {
            Uri parse = Uri.parse(str);
            obj = parse.getHost();
            scheme = parse.getScheme();
            try {
                obj2 = String.valueOf(parse.getPort());
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
                hashMap = new HashMap();
                hashMap.put("host", obj);
                hashMap.put("scheme", scheme);
                hashMap.put("port", obj2);
                return hashMap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            scheme = str2;
            e = exception;
            x.e("MicroMsg.AppBrandNetworkUtil", "message %s", new Object[]{e.getMessage()});
            hashMap = new HashMap();
            hashMap.put("host", obj);
            hashMap.put("scheme", scheme);
            hashMap.put("port", obj2);
            return hashMap;
        }
        hashMap = new HashMap();
        hashMap.put("host", obj);
        hashMap.put("scheme", scheme);
        hashMap.put("port", obj2);
        return hashMap;
    }

    private static Map<String, String> u(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str != null) {
                        hashMap.put(str.toLowerCase(), optJSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "get header error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static Map<String, String> v(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, optJSONObject.getString(str));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "get form error, exception : %s", new Object[]{e});
        }
        return hashMap;
    }

    public static boolean a(ArrayList<String> arrayList, String str) {
        return a((ArrayList) arrayList, str, false);
    }

    public static boolean a(ArrayList<String> arrayList, String str, boolean z) {
        if (bh.ov(str)) {
            return false;
        }
        x.i("MicroMsg.AppBrandNetworkUtil", "url " + str);
        x.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
        HashMap tw = tw(str);
        String str2 = (String) tw.get("host");
        String str3 = (String) tw.get("scheme");
        String str4 = (String) tw.get("port");
        if (bh.ov(str2) || bh.ov(str3)) {
            return false;
        }
        x.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", new Object[]{str2, str3, str4, Boolean.valueOf(z)});
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            x.i("MicroMsg.AppBrandNetworkUtil", "configUrl " + str5);
            HashMap tw2 = tw(str5);
            x.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", new Object[]{(String) tw2.get("host"), (String) tw2.get("scheme"), (String) tw2.get("port")});
            if (str2.equalsIgnoreCase((String) tw2.get("host")) && str3.equalsIgnoreCase(r4)) {
                if (z || str4.equalsIgnoreCase(r5)) {
                    x.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> a(JSONObject jSONObject, AppBrandSysConfig appBrandSysConfig) {
        String str;
        Map<String, String> u = u(jSONObject);
        if (appBrandSysConfig.iOJ != null) {
            HttpSetting httpSetting = appBrandSysConfig.iOJ.iNu;
            if (httpSetting != null) {
                Map<String, String> map;
                ArrayList arrayList;
                if (httpSetting.mode == 1) {
                    if (httpSetting.iNK != null) {
                        arrayList = httpSetting.iNK;
                        if (arrayList == null || arrayList.isEmpty()) {
                            x.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderBlackList fail, headerMap is null or blacklist is null or nil.");
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                if (str != null) {
                                    if (((String) u.remove(str.toLowerCase())) != null) {
                                        x.v("MicroMsg.AppBrandNetworkUtil", "remove key %s value %s", new Object[]{str.toLowerCase(), (String) u.remove(str.toLowerCase())});
                                    }
                                }
                            }
                        }
                        map = u;
                    }
                } else if (httpSetting.mode == 2 && httpSetting.iNL != null) {
                    arrayList = httpSetting.iNL;
                    if (arrayList == null) {
                        x.e("MicroMsg.AppBrandNetworkUtil", "filterHttpHeaderWhiteList fail");
                        map = u;
                    } else {
                        Map<String, String> hashMap = new HashMap();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            str = (String) it2.next();
                            if (str != null) {
                                String toLowerCase = str.toLowerCase();
                                str = (String) u.get(toLowerCase);
                                if (str != null) {
                                    x.v("MicroMsg.AppBrandNetworkUtil", "add item, key(%s), value(%s)", new Object[]{toLowerCase, str});
                                    hashMap.put(toLowerCase, str);
                                }
                            }
                        }
                        map = hashMap;
                    }
                }
                u = map;
            }
        }
        u.remove("referer");
        String str2 = "referer";
        str = "";
        if (!(appBrandSysConfig.iOJ == null || appBrandSysConfig.iOJ.iNu == null)) {
            str = appBrandSysConfig.iOJ.iNu.iNQ;
        }
        if (bh.ov(str)) {
            str = "servicewechat.com";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.appId);
        stringBuilder.append("/");
        stringBuilder.append(appBrandSysConfig.iOI.iGL);
        stringBuilder.append("/page-frame.html");
        u.put(str2, stringBuilder.toString());
        return u;
    }

    public static int a(AppBrandSysConfig appBrandSysConfig, a aVar, int i) {
        int i2;
        int i3;
        int i4;
        switch (i) {
            case 0:
                i2 = aVar.iMB.fLk;
                if (appBrandSysConfig.iOJ == null || appBrandSysConfig.iOJ.iNu == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iOJ.iNu.iNM;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "request apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 1:
                i2 = aVar.iMB.iMI;
                if (appBrandSysConfig.iOJ == null || appBrandSysConfig.iOJ.iNu == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iOJ.iNu.iNM;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "socket apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 2:
                i2 = aVar.iMB.iMJ;
                if (appBrandSysConfig.iOJ == null || appBrandSysConfig.iOJ.iNu == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iOJ.iNu.iNN;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "upload apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            case 3:
                i2 = aVar.iMB.iMK;
                if (appBrandSysConfig.iOJ == null || appBrandSysConfig.iOJ.iNu == null) {
                    i3 = 0;
                } else {
                    i3 = appBrandSysConfig.iOJ.iNu.iNO;
                }
                x.i("MicroMsg.AppBrandNetworkUtil", "download apptimeout %d, systimeout %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                i4 = i3;
                i3 = i2;
                i2 = i4;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        if (i3 > 0 && i2 <= 0) {
            return i3;
        }
        if (i3 <= 0 && i2 > 0) {
            return i2;
        }
        if (i3 <= 0 || i2 <= 0) {
            return 0;
        }
        return Math.min(i3, i2);
    }

    public static boolean kZ(int i) {
        return i == HardCoderJNI.SCENE_QUIT_CHATTING || i == 301;
    }

    public static String d(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return "";
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (headerField == null) {
            return null;
        }
        try {
            return url.toURI().resolve(headerField).toString();
        } catch (URISyntaxException e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "resolve url error %s", new Object[]{e.getMessage()});
            return headerField;
        }
    }

    public static boolean a(AppBrandSysConfig appBrandSysConfig, boolean z) {
        if (z) {
            x.v("MicroMsg.AppBrandNetworkUtil", "skipCheck Domains");
            return false;
        }
        boolean z2;
        if (appBrandSysConfig.iOI.iGK == 1 || appBrandSysConfig.iOI.iGK == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (appBrandSysConfig.iNV) {
            if (z2 && appBrandSysConfig.iOl) {
                return false;
            }
            return true;
        } else if (z2 && appBrandSysConfig.iOi) {
            return false;
        } else {
            return true;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, ArrayList<String> arrayList) {
        if (httpURLConnection != null) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new 1(HttpsURLConnection.getDefaultHostnameVerifier(), arrayList));
        }
    }

    public static SSLContext tx(String str) {
        if (ty(str) == null) {
            return null;
        }
        TrustManager[] trustManagerArr = new TrustManager[]{ty(str)};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            return instance;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandNetworkUtil", "SSLContext init error: " + e);
            return null;
        }
    }

    public static l ty(String str) {
        LinkedList tz = tz(str);
        if (tz.isEmpty()) {
            return null;
        }
        l lVar = new l();
        Iterator it = tz.iterator();
        while (it.hasNext()) {
            InputStream inputStream = (InputStream) it.next();
            if (lVar.jCa == null) {
                x.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            } else {
                try {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                    inputStream.close();
                    lVar.jCa.setCertificateEntry(((X509Certificate) generateCertificate).getSubjectDN(), generateCertificate);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandX509TrustManager", "initLocalSelfSignedCertificate:" + e);
                } catch (Throwable th) {
                    inputStream.close();
                }
            }
        }
        lVar.init();
        return lVar;
    }

    private static LinkedList<InputStream> tz(String str) {
        LinkedList<InputStream> linkedList = new LinkedList();
        byte[] e = ah.e(com.tencent.mm.plugin.appbrand.a.oQ(str), "cer");
        if (e == null) {
            return linkedList;
        }
        try {
            aqb com_tencent_mm_protocal_c_aqb = new aqb();
            com_tencent_mm_protocal_c_aqb.aF(e);
            if (com_tencent_mm_protocal_c_aqb.wwN == null) {
                return linkedList;
            }
            Iterator it = com_tencent_mm_protocal_c_aqb.wwN.iterator();
            while (it.hasNext()) {
                linkedList.add(new ByteArrayInputStream(((b) it.next()).oz));
            }
            return linkedList;
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrandNetworkUtil", "parse error: " + e2);
        }
    }
}
