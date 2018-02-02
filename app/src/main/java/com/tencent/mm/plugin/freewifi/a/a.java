package com.tencent.mm.plugin.freewifi.a;

import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public final class a {
    private static final int mDr = b.aLc().aKX();
    private static final int mDs = b.aLc().aKY();

    private a() {
    }

    public static a aLn() {
        return b.aLo();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, a aVar) {
        Exception exception;
        Throwable th;
        x.i("MicroMsg.FreeWifi.HttpTemplate", "method=request, desc=it starts a http GET request. url=%s.", new Object[]{str});
        if (!m.AA(str)) {
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.setConnectTimeout(mDr);
                        httpURLConnection2.setReadTimeout(mDs);
                        httpURLConnection2.setRequestProperty("User-Agent", b.aLc().getUserAgent());
                        httpURLConnection2.setUseCaches(false);
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        aVar.e(httpURLConnection2);
                    } catch (Exception e) {
                        Exception exception2 = e;
                        httpURLConnection = httpURLConnection2;
                        exception = exception2;
                        try {
                            aVar.h(exception);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e2) {
                exception = e2;
                aVar.h(exception);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, String str2, a aVar) {
        Throwable th;
        x.i("MicroMsg.FreeWifi.HttpTemplate", "method=requestPost, desc=it starts a http POST request. url=%s, postParams=%s.", new Object[]{str, str2});
        if (!m.AA(str) && !m.AA(str2)) {
            String str3;
            if (str2 == null || "".equalsIgnoreCase(str2)) {
                str3 = "";
            } else {
                String str4 = "";
                String[] split = str2.split("&");
                int i = 1;
                while (i <= 10) {
                    String str5 = "key" + i;
                    String stringBuilder = new StringBuilder(DownloadSettingTable$Columns.VALUE).append(i).toString();
                    String str6 = null;
                    str3 = null;
                    for (String str7 : split) {
                        if (str7.indexOf(str5) >= 0 && str7.split("=").length == 2) {
                            str3 = str7.split("=")[1];
                        } else if (str7.indexOf(stringBuilder) >= 0 && str7.split("=").length == 2) {
                            str6 = str7.split("=")[1];
                        }
                    }
                    if (str3 == null || str6 == null) {
                        break;
                    }
                    str6 = i == 1 ? str4 + str3 + "=" + str6 : str4 + "&" + str3 + "=" + str6;
                    i++;
                    str4 = str6;
                }
                str3 = str4;
            }
            x.i("MicroMsg.FreeWifi.HttpTemplate", "method=requestPost, desc=it extracts PostParams. url=%s, postParams=%s", new Object[]{str, str3});
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.setConnectTimeout(mDr);
                        httpURLConnection2.setReadTimeout(mDs);
                        httpURLConnection2.setRequestProperty("User-Agent", b.aLc().getUserAgent());
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection2.setRequestProperty("charset", ProtocolPackage.ServerEncoding);
                        httpURLConnection2.setUseCaches(false);
                        byte[] bytes = str3.getBytes(Charset.forName("UTF-8"));
                        httpURLConnection2.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        dataOutputStream.write(bytes);
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        aVar.e(httpURLConnection2);
                    } catch (Exception e) {
                        aVar.h(e);
                    } catch (Exception e2) {
                        aVar.h(e2);
                    } catch (Throwable th2) {
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e3) {
                Exception e4 = e3;
                HttpURLConnection httpURLConnection3 = null;
                try {
                    aVar.h(e4);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
