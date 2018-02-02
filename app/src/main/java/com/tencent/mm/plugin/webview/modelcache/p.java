package com.tencent.mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class p {
    public static boolean uz(String str) {
        return !bh.ov(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String Oy(String str) {
        String str2;
        if (!uz(str)) {
            return null;
        }
        try {
            URI uri = new URI(str);
            String toLowerCase = bh.ou(uri.getScheme()).toLowerCase();
            String toLowerCase2 = bh.ou(uri.getHost()).toLowerCase();
            if (bh.ov(toLowerCase2)) {
                return null;
            }
            int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : JsApiPauseDownloadTask.CTRL_INDEX : uri.getPort();
            str = toLowerCase + "://" + toLowerCase2 + ":" + port + "/" + bh.ou(uri.getPath()) + (bh.ov(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (bh.ov(uri.getFragment()) ? "" : "#" + uri.getFragment());
            if (str.endsWith("/")) {
                str = str + "/";
            }
            return Oz(str);
        } catch (URISyntaxException e) {
            URISyntaxException uRISyntaxException = e;
            str2 = str;
            x.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[]{uRISyntaxException.getMessage()});
            return str2;
        } catch (Exception e2) {
            Exception exception = e2;
            str2 = str;
            x.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[]{exception.getMessage()});
            return str2;
        }
    }

    private static String Oz(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(":").append(parse.getPort());
        if (bh.cA(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!bh.ov(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!bh.ov(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String OA(String str) {
        String Oy = Oy(str);
        if (bh.ov(Oy)) {
            return null;
        }
        return Uri.parse(Oy).getHost();
    }

    public static String OB(String str) {
        String OC = OC(str);
        return bh.ov(OC) ? null : OC.replaceAll("http://", "").replaceAll("https://", "");
    }

    public static String OC(String str) {
        String Oy = Oy(str);
        if (bh.ov(Oy)) {
            x.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[]{str});
            return null;
        }
        Uri parse = Uri.parse(Oy);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(":").append(parse.getPort());
        if (!bh.cA(parse.getPathSegments())) {
            for (String Oy2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(bh.ou(Oy2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static byte[] OD(String str) {
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                x.d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", new Object[]{str, Integer.valueOf(responseCode), Integer.valueOf(contentLength)});
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            contentLength = inputStream.read(bArr);
                            if (contentLength != -1) {
                                byteArrayOutputStream.write(bArr, 0, contentLength);
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                                bh.d(inputStream);
                                bh.d(byteArrayOutputStream);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                            bh.d(inputStream);
                            bh.d(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = inputStream;
                            bh.d(closeable);
                            bh.d(byteArrayOutputStream);
                            throw th;
                        }
                    }
                }
                bh.d(inputStream);
                bh.d(byteArrayOutputStream);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                x.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                bh.d(inputStream);
                bh.d(byteArrayOutputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bh.d(closeable);
                bh.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            x.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
            bh.d(inputStream);
            bh.d(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            bh.d(closeable);
            bh.d(byteArrayOutputStream);
            throw th;
        }
    }

    public static String OE(String str) {
        FileNotFoundException e;
        Throwable th;
        Exception e2;
        String str2 = null;
        if (FileOp.bO(str)) {
            Closeable openRead;
            try {
                int me = (int) FileOp.me(str);
                openRead = FileOp.openRead(str);
                try {
                    str2 = g.a(openRead, me);
                    bh.d(openRead);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                        bh.d(openRead);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        bh.d(openRead);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                    bh.d(openRead);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
                x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                bh.d(openRead);
                return str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                bh.d(openRead);
                return str2;
            } catch (Throwable th3) {
                openRead = str2;
                th = th3;
                bh.d(openRead);
                throw th;
            }
        }
        return str2;
    }

    public static int a(i iVar) {
        if (!bh.ou(iVar.tJI).equals("cache")) {
            return -1;
        }
        if (!Boolean.parseBoolean((String) iVar.pox.get("async")) || bh.ov((String) iVar.pox.get("src"))) {
            return !bh.ov((String) iVar.pox.get("resourceList")) ? 1 : -1;
        } else {
            return 2;
        }
    }
}
