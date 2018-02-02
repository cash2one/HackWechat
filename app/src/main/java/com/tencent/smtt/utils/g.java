package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.smtt.sdk.a.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class g {
    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String cFz;
        if (z) {
            try {
                cFz = k.cFx().cFz();
            } catch (Exception e) {
                return null;
            }
        }
        j.cFu();
        cFz = j.cFv();
        cFz = str + cFz;
        if (z) {
            try {
                bArr = a.l(k.cFx().AaO.getBytes(), bArr);
            } catch (Exception e2) {
            }
        } else {
            bArr = j.cFu().bL(bArr);
        }
        if (bArr == null) {
            return null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Content-Length", String.valueOf(bArr.length));
        HttpURLConnection s = s(cFz, hashMap);
        if (s == null) {
            return null;
        }
        a(s, bArr);
        return a(s, aVar, z);
    }

    public static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        Throwable th;
        Closeable closeable = null;
        Closeable inflaterInputStream;
        Closeable byteArrayOutputStream;
        try {
            String contentEncoding;
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.HY(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null) {
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                        }
                    }
                    Object obj = inputStream;
                } else {
                    inflaterInputStream = new GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    h(inflaterInputStream);
                    h(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[FileUtils.S_IWUSR];
                    while (true) {
                        int read = inflaterInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (z) {
                        closeable = inflaterInputStream;
                        contentEncoding = new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding);
                    } else {
                        j.cFu();
                        closeable = inflaterInputStream;
                        contentEncoding = new String(j.bM(byteArrayOutputStream.toByteArray()));
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    closeable = byteArrayOutputStream;
                    th = th4;
                    h(inflaterInputStream);
                    h(closeable);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            contentEncoding = null;
            h(closeable);
            h(byteArrayOutputStream);
            return contentEncoding;
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
            h(inflaterInputStream);
            h(closeable);
            throw th;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
        }
    }

    private static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static HttpURLConnection s(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
