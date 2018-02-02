package com.tencent.mapsdk.rastercore.tile;

import android.graphics.BitmapFactory;
import com.tencent.mapsdk.rastercore.d.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Locale;
import java.util.zip.GZIPInputStream;

public final class c {
    private static String a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(URL url) {
        HttpURLConnection httpURLConnection;
        Closeable inputStream;
        Closeable inputStreamReader;
        byte[] bArr;
        Closeable closeable;
        HttpURLConnection httpURLConnection2;
        Throwable th;
        InputStream gZIPInputStream;
        Object obj;
        Closeable closeable2 = null;
        if (url != null) {
            Closeable bufferedReader;
            try {
                Proxy proxy = android.net.Proxy.getDefaultHost() != null ? new Proxy(Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())) : null;
                httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                    httpURLConnection.setRequestProperty("User-Agent", "QmapSdk/1.2.8.29dc259 Android");
                    httpURLConnection.setRequestProperty("Accept-Language", a);
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2;
                            if (httpURLConnection.getContentType().toLowerCase().trim().contains("text")) {
                                inputStreamReader = new InputStreamReader(inputStream);
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader);
                                    try {
                                        String trim = bufferedReader.readLine().toLowerCase().trim();
                                        bArr2 = (trim == null || !trim.equals("0")) ? null : new byte[]{(byte) -1};
                                        bArr = bArr2;
                                    } catch (Exception e) {
                                        closeable = bufferedReader;
                                        bufferedReader = inputStreamReader;
                                        inputStreamReader = inputStream;
                                        httpURLConnection2 = httpURLConnection;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        a.a(closeable);
                                        a.a(bufferedReader);
                                        a.a(inputStreamReader);
                                        return bArr;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        closeable2 = bufferedReader;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        a.a(closeable2);
                                        a.a(inputStreamReader);
                                        a.a(inputStream);
                                        throw th;
                                    }
                                } catch (Exception e2) {
                                    closeable = null;
                                    bufferedReader = inputStreamReader;
                                    inputStreamReader = inputStream;
                                    httpURLConnection2 = httpURLConnection;
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    a.a(closeable);
                                    a.a(bufferedReader);
                                    a.a(inputStreamReader);
                                    return bArr;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    a.a(closeable2);
                                    a.a(inputStreamReader);
                                    a.a(inputStream);
                                    throw th;
                                }
                            }
                            if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
                                gZIPInputStream = new GZIPInputStream(inputStream);
                            } else {
                                bufferedReader = inputStream;
                            }
                            try {
                                bArr2 = a.a(gZIPInputStream);
                                BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                                inputStreamReader = null;
                                obj = gZIPInputStream;
                                bufferedReader = null;
                                bArr = bArr2;
                            } catch (Exception e3) {
                                new StringBuilder("decoder bitmap error:").append(e3.getMessage());
                                inputStreamReader = null;
                                obj = gZIPInputStream;
                                bufferedReader = null;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStreamReader = null;
                                obj = gZIPInputStream;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                a.a(closeable2);
                                a.a(inputStreamReader);
                                a.a(inputStream);
                                throw th;
                            }
                        } catch (Exception e4) {
                            closeable = null;
                            bufferedReader = null;
                            inputStreamReader = inputStream;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            a.a(closeable);
                            a.a(bufferedReader);
                            a.a(inputStreamReader);
                            return bArr;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = null;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            a.a(closeable2);
                            a.a(inputStreamReader);
                            a.a(inputStream);
                            throw th;
                        }
                    }
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a.a(bufferedReader);
                    a.a(inputStreamReader);
                    a.a(inputStream);
                } catch (Exception e5) {
                    closeable = null;
                    bufferedReader = null;
                    inputStreamReader = null;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    a.a(closeable);
                    a.a(bufferedReader);
                    a.a(inputStreamReader);
                    return bArr;
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader = null;
                    inputStream = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a.a(closeable2);
                    a.a(inputStreamReader);
                    a.a(inputStream);
                    throw th;
                }
            } catch (Exception e6) {
                closeable = null;
                bufferedReader = null;
                inputStreamReader = null;
                httpURLConnection2 = null;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                a.a(closeable);
                a.a(bufferedReader);
                a.a(inputStreamReader);
                return bArr;
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                inputStream = null;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a.a(closeable2);
                a.a(inputStreamReader);
                a.a(inputStream);
                throw th;
            }
        }
        return bArr;
    }
}
