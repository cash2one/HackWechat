package com.tencent.mm.plugin.game.gamewebview.c;

import android.net.Uri;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public static String aAM;
    public static List<akj> mXV;
    public static String mXW = "";
    public static String mXX;
    public static Map<Integer, String> mXY = new HashMap();
    public static String uin;

    public static String b(String str, String str2, JSONObject jSONObject) {
        if (mXY.containsKey(Integer.valueOf(str.hashCode()))) {
            return (String) mXY.remove(Integer.valueOf(str.hashCode()));
        }
        if (str2.equalsIgnoreCase("POST")) {
            return b(str, jSONObject);
        }
        if (str2.equalsIgnoreCase("GET")) {
            return a(str, jSONObject);
        }
        return null;
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        mXY.put(Integer.valueOf(str.hashCode()), b(str, str2, jSONObject));
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(BK(c(str, jSONObject))).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            f(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "GET, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String n = n(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", n);
                return n;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String b(String str, JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            f(httpURLConnection);
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2 != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, ProtocolPackage.ServerEncoding));
                    bufferedWriter.write(jSONObject2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            x.i("MicroMsg.GameWebViewRequest", "POST, code = " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String n = n(inputStream);
                inputStream.close();
                x.d("MicroMsg.GameWebViewRequest", n);
                return n;
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewRequest", e.getMessage());
        }
        return null;
    }

    private static String c(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            Iterator keys = jSONObject.keys();
            if (bh.ov(query)) {
                str2 = "";
            } else {
                str2 = query + "&";
            }
            while (keys.hasNext()) {
                query = (String) keys.next();
                str2 = str2 + query + "=" + jSONObject.optString(query) + "&";
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2.substring(0, str2.lastIndexOf("&")), parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static String BK(String str) {
        if (!(bh.ov(uin) || bh.ov(aAM) || bh.ov(mXX))) {
            String str2;
            Uri parse = Uri.parse(str);
            String query = parse.getQuery();
            if (bh.ov(query)) {
                query = "";
            } else {
                query = query + "&";
            }
            if (!bh.ov(uin)) {
                query = query + "uin=" + uin + "&";
            }
            if (!bh.ov(aAM)) {
                query = query + "key=" + aAM + "&";
            }
            if (bh.ov(mXX)) {
                str2 = query;
            } else {
                str2 = query + "pass_ticket=" + mXX;
            }
            try {
                str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebViewRequest", e, "", new Object[0]);
            }
            x.d("MicroMsg.GameWebViewRequest", "url: " + str);
        }
        return str;
    }

    private static void f(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("User-agent", mXW);
        for (akj com_tencent_mm_protocal_c_akj : mXV) {
            httpURLConnection.setRequestProperty(com_tencent_mm_protocal_c_akj.vNj, com_tencent_mm_protocal_c_akj.pQt);
        }
    }

    private static String n(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                x.e("MicroMsg.GameWebViewRequest", "inputStream2Str: " + e.getMessage());
                return "";
            }
        }
    }

    public static void h(String str, List<akj> list) {
        if (!bh.ov(str)) {
            Uri parse = Uri.parse(str);
            uin = parse.getQueryParameter(OpenSDKTool4Assistant.EXTRA_UIN);
            aAM = parse.getQueryParameter("key");
            mXX = parse.getQueryParameter("pass_ticket");
        }
        mXV = list;
    }
}
