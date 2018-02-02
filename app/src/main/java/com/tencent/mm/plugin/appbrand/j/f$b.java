package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j.f.1;
import com.tencent.mm.plugin.appbrand.report.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

public class f$b implements Runnable {
    private g jBJ;
    final /* synthetic */ f jBK;

    public f$b(f fVar, g gVar) {
        this.jBK = fVar;
        this.jBJ = gVar;
    }

    public final void run() {
        b(this.jBJ);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(g gVar) {
        long length;
        DataOutputStream dataOutputStream;
        UnsupportedEncodingException unsupportedEncodingException;
        int i;
        int i2;
        HttpURLConnection httpURLConnection;
        FileInputStream fileInputStream;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
        FileNotFoundException fileNotFoundException;
        SSLHandshakeException sSLHandshakeException;
        SocketTimeoutException socketTimeoutException;
        Exception exception;
        int responseCode;
        HttpURLConnection httpURLConnection2;
        FileInputStream fileInputStream2;
        Throwable th;
        int i3;
        String str = gVar.mUrl;
        String str2 = gVar.jBL;
        String str3 = gVar.mName;
        String str4 = gVar.mMimeType;
        String str5 = bh.ov(str4) ? "application/octet-stream" : str4;
        x.v("MicroMsg.AppBrandNetworkUpload", "uploadFile filename %s", new Object[]{gVar.mFileName});
        Map map = gVar.jBM;
        Map map2 = gVar.jBB;
        int i4 = 0;
        int i5 = 0;
        long j = 0;
        f$a com_tencent_mm_plugin_appbrand_j_f_a = gVar.jBN;
        ArrayList arrayList = gVar.jBC;
        if (arrayList == null || i.a(arrayList, str)) {
            HttpURLConnection httpURLConnection3 = null;
            DataOutputStream dataOutputStream3 = null;
            InputStream inputStream2 = null;
            if (!gVar.bgH) {
                com_tencent_mm_plugin_appbrand_j_f_a.sD("force_stop!");
                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, 0, 0, 0, 2, gVar.aiz());
                x.e("MicroMsg.AppBrandNetworkUpload", "force stop!");
                return;
            } else if (URLUtil.isHttpsUrl(gVar.mUrl) || URLUtil.isHttpUrl(gVar.mUrl)) {
                String str6 = "--";
                String l = Long.toString(System.currentTimeMillis());
                String str7 = "\r\n";
                String str8 = "";
                try {
                    byte[] bytes;
                    byte[] bArr;
                    g.pQN.a(436, 0, 1, false);
                    File file = new File(str2);
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    try {
                        httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                        if (!bh.ov(gVar.jbo)) {
                            gVar.jBF = httpURLConnection3;
                        }
                        if (httpURLConnection3 instanceof HttpsURLConnection) {
                            if (this.jBK.jBh == null) {
                                this.jBK.jBh = i.tx(this.jBK.mAppId);
                            }
                            if (this.jBK.jBh != null) {
                                ((HttpsURLConnection) httpURLConnection3).setSSLSocketFactory(this.jBK.jBh.getSocketFactory());
                                i.a(httpURLConnection3, arrayList);
                            }
                        }
                        httpURLConnection3.setDoInput(true);
                        httpURLConnection3.setDoOutput(true);
                        httpURLConnection3.setUseCaches(false);
                        httpURLConnection3.setConnectTimeout(gVar.jBx);
                        httpURLConnection3.setReadTimeout(gVar.jBx);
                        httpURLConnection3.setRequestMethod("POST");
                        httpURLConnection3.setRequestProperty("Connection", "Keep-Alive");
                        httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                        x.i("MicroMsg.AppBrandNetworkUpload", "file path = %s, length = %d", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())});
                        httpURLConnection3.setInstanceFollowRedirects(false);
                        if (map2 != null) {
                            x.i("MicroMsg.AppBrandNetworkUpload", "url %s : set header ", new Object[]{str});
                            for (Entry entry : map2.entrySet()) {
                                x.i("MicroMsg.AppBrandNetworkUpload", "set header for : url %s : key:%s ,value %s ", new Object[]{str, entry.getKey(), entry.getValue()});
                                if (!(bh.ov((String) entry.getKey()) || bh.ov((String) entry.getValue()))) {
                                    if (((String) entry.getKey()).toLowerCase().contains("content-length")) {
                                        x.e("MicroMsg.AppBrandNetworkUpload", "not allow to set Content-Length");
                                    } else {
                                        httpURLConnection3.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                            }
                        }
                        httpURLConnection3.setRequestProperty("User-Agent", s.aL(ac.getContext(), this.jBK.jBi));
                        length = file.length();
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (map != null) {
                            httpURLConnection3.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + l);
                            for (String str42 : map.keySet()) {
                                x.i("MicroMsg.AppBrandNetworkUpload", "append form data: key = %s, value = %s", new Object[]{str42, (String) map.get(str42)});
                                stringBuilder.append(str6 + l + str7);
                                stringBuilder.append("Content-Disposition: form-data; name=\"" + str42 + "\"");
                                stringBuilder.append(str7);
                                stringBuilder.append(str7);
                                stringBuilder.append(r6);
                                stringBuilder.append(str7);
                            }
                            stringBuilder.append(str6 + l + str7);
                            stringBuilder.append("Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"" + r28 + "\"" + str7);
                            stringBuilder.append("Content-Type: " + str5);
                            stringBuilder.append(str7);
                            stringBuilder.append(str7);
                            stringBuilder2.append(str7 + str6 + l + str6 + str7);
                        }
                        bytes = stringBuilder.toString().getBytes("UTF-8");
                        byte[] bytes2 = stringBuilder2.toString().getBytes("UTF-8");
                        if (bytes == null) {
                            bytes = new byte[0];
                        }
                        if (bytes2 == null) {
                            bArr = new byte[0];
                        } else {
                            bArr = bytes2;
                        }
                        x.i("MicroMsg.AppBrandNetworkUpload", "contentLenght = %d", new Object[]{Long.valueOf((length + ((long) bytes.length)) + ((long) bArr.length))});
                        httpURLConnection3.setRequestProperty("Content-Length", String.valueOf(length));
                        dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                    } catch (UnsupportedEncodingException e) {
                        unsupportedEncodingException = e;
                        i = 0;
                        i2 = 0;
                        httpURLConnection = httpURLConnection3;
                        fileInputStream = fileInputStream3;
                        inputStream = inputStream2;
                        dataOutputStream2 = null;
                    } catch (FileNotFoundException e2) {
                        fileNotFoundException = e2;
                    } catch (SSLHandshakeException e3) {
                        sSLHandshakeException = e3;
                    } catch (SocketTimeoutException e4) {
                        socketTimeoutException = e4;
                    } catch (Exception e5) {
                        exception = e5;
                    }
                    try {
                        dataOutputStream.write(bytes);
                        byte[] bArr2 = new byte[8192];
                        long length2 = file.length();
                        length = 0;
                        while (true) {
                            try {
                                int read = fileInputStream3.read(bArr2);
                                Object d;
                                if (read == -1 || !gVar.bgH) {
                                    dataOutputStream.write(bArr);
                                    dataOutputStream.flush();
                                    responseCode = httpURLConnection3.getResponseCode();
                                    if (200 != responseCode) {
                                        try {
                                            x.e("MicroMsg.AppBrandNetworkUpload", "code %d  url is %s filepath %s ", new Object[]{Integer.valueOf(httpURLConnection3.getResponseCode()), str, str2});
                                            if (i.kZ(responseCode)) {
                                                d = i.d(httpURLConnection3);
                                                read = gVar.jBD;
                                                if (!TextUtils.isEmpty(d)) {
                                                    if (read <= 0) {
                                                        x.w("MicroMsg.AppBrandNetworkUpload", "reach the max redirect count(%d)", new Object[]{Integer.valueOf(15)});
                                                        com_tencent_mm_plugin_appbrand_j_f_a.c(0, "reach the max redirect count 15", responseCode);
                                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, 0, responseCode, 1, gVar.aiz());
                                                        gVar.bgH = false;
                                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                        try {
                                                            fileInputStream3.close();
                                                        } catch (Exception e6) {
                                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e6.toString(), str, str2});
                                                        }
                                                        try {
                                                            dataOutputStream.close();
                                                        } catch (IOException e7) {
                                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e7.toString(), str, str2});
                                                        }
                                                        this.jBK.jBj.remove(gVar.jbo);
                                                        return;
                                                    }
                                                    x.i("MicroMsg.AppBrandNetworkUpload", "redirect(%d) URL(%s) to URL(%s)", new Object[]{Integer.valueOf(read), gVar.mUrl, d});
                                                    gVar.mUrl = d;
                                                    gVar.jBD = read - 1;
                                                    b(gVar);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, 0, responseCode, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                    try {
                                                        fileInputStream3.close();
                                                    } catch (Exception e62) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e62.toString(), str, str2});
                                                    }
                                                    try {
                                                        dataOutputStream.close();
                                                    } catch (IOException e72) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e72.toString(), str, str2});
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                }
                                            }
                                        } catch (Exception e52) {
                                            x.e("MicroMsg.AppBrandNetworkUpload", "read err stream failed : %s", new Object[]{e52.toString()});
                                        } catch (UnsupportedEncodingException e8) {
                                            unsupportedEncodingException = e8;
                                            httpURLConnection = httpURLConnection3;
                                            j = length;
                                            i2 = 0;
                                            fileInputStream = fileInputStream3;
                                            inputStream = inputStream2;
                                            dataOutputStream2 = dataOutputStream;
                                            i = responseCode;
                                            try {
                                                g.pQN.a(436, 1, 1, false);
                                                x.e("MicroMsg.AppBrandNetworkUpload", "UnsupportEncodingException : %s ,url is %s filepath %s ", new Object[]{unsupportedEncodingException.toString(), str, str2});
                                                com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "unsupported encoding", i);
                                                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i2, i, 2, gVar.aiz());
                                                gVar.bgH = false;
                                                f.a(this.jBK, gVar.jbo, httpURLConnection);
                                                if (fileInputStream != null) {
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Exception e622) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e622.toString(), str, str2});
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e722) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e722.toString(), str, str2});
                                                    } catch (Throwable e9) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e9, "", new Object[0]);
                                                    } catch (Throwable e92) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e92, "", new Object[0]);
                                                    }
                                                }
                                                if (dataOutputStream2 != null) {
                                                    try {
                                                        dataOutputStream2.close();
                                                    } catch (IOException e7222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e7222.toString(), str, str2});
                                                    }
                                                }
                                                this.jBK.jBj.remove(gVar.jbo);
                                                return;
                                            } catch (Throwable e922) {
                                                length = j;
                                                responseCode = i;
                                                i4 = i2;
                                                httpURLConnection2 = httpURLConnection;
                                                dataOutputStream3 = dataOutputStream2;
                                                inputStream2 = inputStream;
                                                fileInputStream2 = fileInputStream;
                                                th = e922;
                                                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                                                gVar.bgH = false;
                                                f.a(this.jBK, gVar.jbo, httpURLConnection2);
                                                if (fileInputStream2 != null) {
                                                    try {
                                                        fileInputStream2.close();
                                                    } catch (Exception e6222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e6222.toString(), str, str2});
                                                    }
                                                }
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (IOException e72222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e72222.toString(), str, str2});
                                                    } catch (Throwable e9222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e9222, "", new Object[0]);
                                                    } catch (Throwable e92222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e92222, "", new Object[0]);
                                                    }
                                                }
                                                if (dataOutputStream3 != null) {
                                                    try {
                                                        dataOutputStream3.close();
                                                    } catch (IOException e722222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e722222.toString(), str, str2});
                                                    }
                                                }
                                                this.jBK.jBj.remove(gVar.jbo);
                                                throw th;
                                            }
                                        } catch (FileNotFoundException e22) {
                                            fileNotFoundException = e22;
                                            dataOutputStream3 = dataOutputStream;
                                            j = length;
                                            i5 = responseCode;
                                            try {
                                                g.pQN.a(436, 3, 1, false);
                                                x.e("MicroMsg.AppBrandNetworkUpload", "FileNotFoundException : %s ,url is %s filepath %s ", new Object[]{fileNotFoundException.toString(), str, str2});
                                                com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "file not exist", i5);
                                                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                                gVar.bgH = false;
                                                f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                if (fileInputStream2 != null) {
                                                    try {
                                                        fileInputStream2.close();
                                                    } catch (Exception e62222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e62222.toString(), str, str2});
                                                    }
                                                }
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (IOException e7222222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e7222222.toString(), str, str2});
                                                    } catch (Throwable e922222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e922222, "", new Object[0]);
                                                    } catch (Throwable e9222222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e9222222, "", new Object[0]);
                                                    }
                                                }
                                                if (dataOutputStream3 != null) {
                                                    try {
                                                        dataOutputStream3.close();
                                                    } catch (IOException e72222222) {
                                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e72222222.toString(), str, str2});
                                                    }
                                                }
                                                this.jBK.jBj.remove(gVar.jbo);
                                                return;
                                            } catch (Throwable e92222222) {
                                                httpURLConnection2 = httpURLConnection3;
                                                length = j;
                                                responseCode = i5;
                                                th = e92222222;
                                                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                                                gVar.bgH = false;
                                                f.a(this.jBK, gVar.jbo, httpURLConnection2);
                                                if (fileInputStream2 != null) {
                                                    fileInputStream2.close();
                                                }
                                                if (inputStream2 != null) {
                                                    inputStream2.close();
                                                }
                                                if (dataOutputStream3 != null) {
                                                    dataOutputStream3.close();
                                                }
                                                this.jBK.jBj.remove(gVar.jbo);
                                                throw th;
                                            }
                                        } catch (SSLHandshakeException e32) {
                                            sSLHandshakeException = e32;
                                            dataOutputStream3 = dataOutputStream;
                                            j = length;
                                            i5 = responseCode;
                                            g.pQN.a(436, 2, 1, false);
                                            x.e("MicroMsg.AppBrandNetworkUpload", "SSLHandshakeException : %s ,url is %s filepath %s ", new Object[]{sSLHandshakeException.toString(), str, str2});
                                            com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "ssl hand shake error", i5);
                                            j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                            gVar.bgH = false;
                                            f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (Exception e622222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e622222.toString(), str, str2});
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (IOException e722222222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e722222222.toString(), str, str2});
                                                } catch (Throwable e922222222) {
                                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e922222222, "", new Object[0]);
                                                } catch (Throwable e9222222222) {
                                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e9222222222, "", new Object[0]);
                                                }
                                            }
                                            if (dataOutputStream3 != null) {
                                                try {
                                                    dataOutputStream3.close();
                                                } catch (IOException e7222222222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e7222222222.toString(), str, str2});
                                                }
                                            }
                                            this.jBK.jBj.remove(gVar.jbo);
                                            return;
                                        } catch (SocketTimeoutException e42) {
                                            socketTimeoutException = e42;
                                            dataOutputStream3 = dataOutputStream;
                                            j = length;
                                            i5 = responseCode;
                                            g.pQN.a(436, 4, 1, false);
                                            x.e("MicroMsg.AppBrandNetworkUpload", "SocketTimeoutException : %s ,url is %s filepath %s ", new Object[]{socketTimeoutException.toString(), str, str2});
                                            com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "socket timeout error", i5);
                                            j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                            gVar.bgH = false;
                                            f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (Exception e6222222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e6222222.toString(), str, str2});
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (IOException e72222222222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e72222222222.toString(), str, str2});
                                                } catch (Throwable e92222222222) {
                                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e92222222222, "", new Object[0]);
                                                } catch (Throwable e922222222222) {
                                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e922222222222, "", new Object[0]);
                                                }
                                            }
                                            if (dataOutputStream3 != null) {
                                                try {
                                                    dataOutputStream3.close();
                                                } catch (IOException e722222222222) {
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e722222222222.toString(), str, str2});
                                                }
                                            }
                                            this.jBK.jBj.remove(gVar.jbo);
                                            return;
                                        } catch (Throwable e9222222222222) {
                                            dataOutputStream3 = dataOutputStream;
                                            httpURLConnection2 = httpURLConnection3;
                                            th = e9222222222222;
                                            j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                                            gVar.bgH = false;
                                            f.a(this.jBK, gVar.jbo, httpURLConnection2);
                                            if (fileInputStream2 != null) {
                                                fileInputStream2.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (dataOutputStream3 != null) {
                                                dataOutputStream3.close();
                                            }
                                            this.jBK.jBj.remove(gVar.jbo);
                                            throw th;
                                        }
                                    }
                                    x.i("MicroMsg.AppBrandNetworkUpload", "url %s ,start to read response ", new Object[]{str});
                                    if ("gzip".equals(httpURLConnection3.getContentEncoding())) {
                                        inputStream2 = new GZIPInputStream(httpURLConnection3.getInputStream());
                                    } else {
                                        inputStream2 = httpURLConnection3.getInputStream();
                                    }
                                    if (inputStream2 != null) {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                                        StringBuilder stringBuilder3 = new StringBuilder();
                                        while (true) {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null || !gVar.bgH) {
                                                str42 = stringBuilder3.toString();
                                                read = str42.getBytes(Charset.forName("UTF-8")).length;
                                                try {
                                                    x.i("MicroMsg.AppBrandNetworkUpload", "upload for url : %s, result = %s, statecode = %s", new Object[]{r11, str42, Integer.valueOf(responseCode)});
                                                    i3 = read;
                                                } catch (UnsupportedEncodingException e82) {
                                                    unsupportedEncodingException = e82;
                                                    httpURLConnection = httpURLConnection3;
                                                    j = length;
                                                    i2 = read;
                                                    fileInputStream = fileInputStream3;
                                                    inputStream = inputStream2;
                                                    dataOutputStream2 = dataOutputStream;
                                                    i = responseCode;
                                                    g.pQN.a(436, 1, 1, false);
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "UnsupportEncodingException : %s ,url is %s filepath %s ", new Object[]{unsupportedEncodingException.toString(), str, str2});
                                                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "unsupported encoding", i);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i2, i, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection);
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    if (dataOutputStream2 != null) {
                                                        dataOutputStream2.close();
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                } catch (FileNotFoundException e222) {
                                                    fileNotFoundException = e222;
                                                    dataOutputStream3 = dataOutputStream;
                                                    j = length;
                                                    i5 = responseCode;
                                                    i4 = read;
                                                    g.pQN.a(436, 3, 1, false);
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "FileNotFoundException : %s ,url is %s filepath %s ", new Object[]{fileNotFoundException.toString(), str, str2});
                                                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "file not exist", i5);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream2.close();
                                                    }
                                                    if (inputStream2 != null) {
                                                        inputStream2.close();
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                        dataOutputStream3.close();
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                } catch (SSLHandshakeException e322) {
                                                    sSLHandshakeException = e322;
                                                    dataOutputStream3 = dataOutputStream;
                                                    j = length;
                                                    i5 = responseCode;
                                                    i4 = read;
                                                    g.pQN.a(436, 2, 1, false);
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "SSLHandshakeException : %s ,url is %s filepath %s ", new Object[]{sSLHandshakeException.toString(), str, str2});
                                                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "ssl hand shake error", i5);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream2.close();
                                                    }
                                                    if (inputStream2 != null) {
                                                        inputStream2.close();
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                        dataOutputStream3.close();
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                } catch (SocketTimeoutException e422) {
                                                    socketTimeoutException = e422;
                                                    dataOutputStream3 = dataOutputStream;
                                                    j = length;
                                                    i5 = responseCode;
                                                    i4 = read;
                                                    g.pQN.a(436, 4, 1, false);
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "SocketTimeoutException : %s ,url is %s filepath %s ", new Object[]{socketTimeoutException.toString(), str, str2});
                                                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "socket timeout error", i5);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream2.close();
                                                    }
                                                    if (inputStream2 != null) {
                                                        inputStream2.close();
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                        dataOutputStream3.close();
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                } catch (Exception e522) {
                                                    exception = e522;
                                                    dataOutputStream3 = dataOutputStream;
                                                    j = length;
                                                    i5 = responseCode;
                                                    i4 = read;
                                                    g.pQN.a(436, 5, 1, false);
                                                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{exception.toString(), str, str2});
                                                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, exception.getMessage(), i5);
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                                    if (fileInputStream2 != null) {
                                                        try {
                                                            fileInputStream2.close();
                                                        } catch (Exception e62222222) {
                                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e62222222.toString(), str, str2});
                                                        }
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (IOException e7222222222222) {
                                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e7222222222222.toString(), str, str2});
                                                        } catch (Throwable e92222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e92222222222222, "", new Object[0]);
                                                        } catch (Throwable e922222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e922222222222222, "", new Object[0]);
                                                        }
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                        try {
                                                            dataOutputStream3.close();
                                                        } catch (IOException e72222222222222) {
                                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e72222222222222.toString(), str, str2});
                                                        }
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    return;
                                                } catch (Throwable e9222222222222222) {
                                                    dataOutputStream3 = dataOutputStream;
                                                    i4 = read;
                                                    httpURLConnection2 = httpURLConnection3;
                                                    th = e9222222222222222;
                                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                                                    gVar.bgH = false;
                                                    f.a(this.jBK, gVar.jbo, httpURLConnection2);
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream2.close();
                                                    }
                                                    if (inputStream2 != null) {
                                                        inputStream2.close();
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                        dataOutputStream3.close();
                                                    }
                                                    this.jBK.jBj.remove(gVar.jbo);
                                                    throw th;
                                                }
                                            }
                                            stringBuilder3.append(readLine);
                                        }
                                    } else {
                                        str42 = str8;
                                        i3 = 0;
                                    }
                                    try {
                                        Object obj;
                                        if (gVar.bgH) {
                                            com_tencent_mm_plugin_appbrand_j_f_a.c(0, str42, responseCode);
                                            x.i("MicroMsg.AppBrandNetworkUpload", "success : url = %s, filePath = %s", new Object[]{str, str2});
                                            obj = 1;
                                        } else {
                                            com_tencent_mm_plugin_appbrand_j_f_a.c(0, "force_stop!", responseCode);
                                            x.e("MicroMsg.AppBrandNetworkUpload", "force stop!");
                                            obj = null;
                                        }
                                        if (obj != null) {
                                            j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i3, responseCode, 1, gVar.aiz());
                                        } else {
                                            j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i3, responseCode, 2, gVar.aiz());
                                        }
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                        try {
                                            fileInputStream3.close();
                                        } catch (Exception e622222222) {
                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e622222222.toString(), str, str2});
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e722222222222222) {
                                                x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s , url is %s filepath %s ", new Object[]{e722222222222222.toString(), str, str2});
                                            } catch (Throwable e92222222222222222) {
                                                x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e92222222222222222, "", new Object[0]);
                                            } catch (Throwable e922222222222222222) {
                                                x.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e922222222222222222, "", new Object[0]);
                                            }
                                        }
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e7222222222222222) {
                                            x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e7222222222222222.toString(), str, str2});
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (UnsupportedEncodingException e822) {
                                        unsupportedEncodingException = e822;
                                        httpURLConnection = httpURLConnection3;
                                        j = length;
                                        i2 = i3;
                                        fileInputStream = fileInputStream3;
                                        inputStream = inputStream2;
                                        dataOutputStream2 = dataOutputStream;
                                        i = responseCode;
                                        g.pQN.a(436, 1, 1, false);
                                        x.e("MicroMsg.AppBrandNetworkUpload", "UnsupportEncodingException : %s ,url is %s filepath %s ", new Object[]{unsupportedEncodingException.toString(), str, str2});
                                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "unsupported encoding", i);
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i2, i, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection);
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (dataOutputStream2 != null) {
                                            dataOutputStream2.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (FileNotFoundException e2222) {
                                        fileNotFoundException = e2222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = length;
                                        i5 = responseCode;
                                        i4 = i3;
                                        g.pQN.a(436, 3, 1, false);
                                        x.e("MicroMsg.AppBrandNetworkUpload", "FileNotFoundException : %s ,url is %s filepath %s ", new Object[]{fileNotFoundException.toString(), str, str2});
                                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "file not exist", i5);
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (dataOutputStream3 != null) {
                                            dataOutputStream3.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (SSLHandshakeException e3222) {
                                        sSLHandshakeException = e3222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = length;
                                        i5 = responseCode;
                                        i4 = i3;
                                        g.pQN.a(436, 2, 1, false);
                                        x.e("MicroMsg.AppBrandNetworkUpload", "SSLHandshakeException : %s ,url is %s filepath %s ", new Object[]{sSLHandshakeException.toString(), str, str2});
                                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "ssl hand shake error", i5);
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (dataOutputStream3 != null) {
                                            dataOutputStream3.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (SocketTimeoutException e4222) {
                                        socketTimeoutException = e4222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = length;
                                        i5 = responseCode;
                                        i4 = i3;
                                        g.pQN.a(436, 4, 1, false);
                                        x.e("MicroMsg.AppBrandNetworkUpload", "SocketTimeoutException : %s ,url is %s filepath %s ", new Object[]{socketTimeoutException.toString(), str, str2});
                                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "socket timeout error", i5);
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (dataOutputStream3 != null) {
                                            dataOutputStream3.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (Exception e5222) {
                                        exception = e5222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = length;
                                        i5 = responseCode;
                                        i4 = i3;
                                        g.pQN.a(436, 5, 1, false);
                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{exception.toString(), str, str2});
                                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, exception.getMessage(), i5);
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (dataOutputStream3 != null) {
                                            dataOutputStream3.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        return;
                                    } catch (Throwable e9222222222222222222) {
                                        dataOutputStream3 = dataOutputStream;
                                        i4 = i3;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = e9222222222222222222;
                                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                                        gVar.bgH = false;
                                        f.a(this.jBK, gVar.jbo, httpURLConnection2);
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (dataOutputStream3 != null) {
                                            dataOutputStream3.close();
                                        }
                                        this.jBK.jBj.remove(gVar.jbo);
                                        throw th;
                                    }
                                }
                                e oQ = a.oQ(this.jBK.mAppId);
                                if (oQ != null) {
                                    switch (1.iGZ[oQ.iqO.iGV.aas().ordinal()]) {
                                        case 1:
                                        case 2:
                                            d = 1;
                                            break;
                                        default:
                                            d = null;
                                            break;
                                    }
                                }
                                d = 1;
                                if (d != null) {
                                    com_tencent_mm_plugin_appbrand_j_f_a.sD("interrupted");
                                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, 0, 0, 2, gVar.aiz());
                                    gVar.bgH = false;
                                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                                    try {
                                        fileInputStream3.close();
                                    } catch (Exception e6222222222) {
                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e6222222222.toString(), str, str2});
                                    }
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e72222222222222222) {
                                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{e72222222222222222.toString(), str, str2});
                                    }
                                    this.jBK.jBj.remove(gVar.jbo);
                                    return;
                                }
                                dataOutputStream.write(bArr2, 0, read);
                                long j2 = ((long) read) + length;
                                if (length2 > 0) {
                                    try {
                                        if (gVar.bgH) {
                                            com_tencent_mm_plugin_appbrand_j_f_a.g((int) ((100 * j2) / length2), j2, length2);
                                            x.v("MicroMsg.AppBrandNetworkUpload", "uploadSize %d, totalSize %d, percent = %d", new Object[]{Long.valueOf(j2), Long.valueOf(length2), Integer.valueOf(r5)});
                                            length = j2;
                                        }
                                    } catch (UnsupportedEncodingException e8222) {
                                        unsupportedEncodingException = e8222;
                                        httpURLConnection = httpURLConnection3;
                                        j = j2;
                                        i2 = 0;
                                        fileInputStream = fileInputStream3;
                                        inputStream = inputStream2;
                                        dataOutputStream2 = dataOutputStream;
                                        i = 0;
                                    } catch (FileNotFoundException e22222) {
                                        fileNotFoundException = e22222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = j2;
                                    } catch (SSLHandshakeException e32222) {
                                        sSLHandshakeException = e32222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = j2;
                                    } catch (SocketTimeoutException e42222) {
                                        socketTimeoutException = e42222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = j2;
                                    } catch (Exception e52222) {
                                        exception = e52222;
                                        dataOutputStream3 = dataOutputStream;
                                        j = j2;
                                    } catch (Throwable e92222222222222222222) {
                                        dataOutputStream3 = dataOutputStream;
                                        length = j2;
                                        responseCode = 0;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = e92222222222222222222;
                                    }
                                }
                                length = j2;
                            } catch (UnsupportedEncodingException e82222) {
                                unsupportedEncodingException = e82222;
                                httpURLConnection = httpURLConnection3;
                                j = length;
                                i2 = 0;
                                fileInputStream = fileInputStream3;
                                inputStream = inputStream2;
                                dataOutputStream2 = dataOutputStream;
                                i = 0;
                            } catch (FileNotFoundException e222222) {
                                fileNotFoundException = e222222;
                                dataOutputStream3 = dataOutputStream;
                                j = length;
                            } catch (SSLHandshakeException e322222) {
                                sSLHandshakeException = e322222;
                                dataOutputStream3 = dataOutputStream;
                                j = length;
                            } catch (SocketTimeoutException e422222) {
                                socketTimeoutException = e422222;
                                dataOutputStream3 = dataOutputStream;
                                j = length;
                            } catch (Exception e522222) {
                                exception = e522222;
                                dataOutputStream3 = dataOutputStream;
                                j = length;
                            } catch (Throwable e922222222222222222222) {
                                dataOutputStream3 = dataOutputStream;
                                responseCode = 0;
                                httpURLConnection2 = httpURLConnection3;
                                th = e922222222222222222222;
                            }
                        }
                    } catch (UnsupportedEncodingException e822222) {
                        unsupportedEncodingException = e822222;
                        httpURLConnection = httpURLConnection3;
                        i2 = 0;
                        fileInputStream = fileInputStream3;
                        inputStream = inputStream2;
                        dataOutputStream2 = dataOutputStream;
                        i = 0;
                        g.pQN.a(436, 1, 1, false);
                        x.e("MicroMsg.AppBrandNetworkUpload", "UnsupportEncodingException : %s ,url is %s filepath %s ", new Object[]{unsupportedEncodingException.toString(), str, str2});
                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "unsupported encoding", i);
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i2, i, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        return;
                    } catch (FileNotFoundException e2222222) {
                        fileNotFoundException = e2222222;
                        dataOutputStream3 = dataOutputStream;
                        g.pQN.a(436, 3, 1, false);
                        x.e("MicroMsg.AppBrandNetworkUpload", "FileNotFoundException : %s ,url is %s filepath %s ", new Object[]{fileNotFoundException.toString(), str, str2});
                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "file not exist", i5);
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (dataOutputStream3 != null) {
                            dataOutputStream3.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        return;
                    } catch (SSLHandshakeException e3222222) {
                        sSLHandshakeException = e3222222;
                        dataOutputStream3 = dataOutputStream;
                        g.pQN.a(436, 2, 1, false);
                        x.e("MicroMsg.AppBrandNetworkUpload", "SSLHandshakeException : %s ,url is %s filepath %s ", new Object[]{sSLHandshakeException.toString(), str, str2});
                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "ssl hand shake error", i5);
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (dataOutputStream3 != null) {
                            dataOutputStream3.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        return;
                    } catch (SocketTimeoutException e4222222) {
                        socketTimeoutException = e4222222;
                        dataOutputStream3 = dataOutputStream;
                        g.pQN.a(436, 4, 1, false);
                        x.e("MicroMsg.AppBrandNetworkUpload", "SocketTimeoutException : %s ,url is %s filepath %s ", new Object[]{socketTimeoutException.toString(), str, str2});
                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "socket timeout error", i5);
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (dataOutputStream3 != null) {
                            dataOutputStream3.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        return;
                    } catch (Exception e5222222) {
                        exception = e5222222;
                        dataOutputStream3 = dataOutputStream;
                        g.pQN.a(436, 5, 1, false);
                        x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{exception.toString(), str, str2});
                        com_tencent_mm_plugin_appbrand_j_f_a.c(-1, exception.getMessage(), i5);
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection3);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (dataOutputStream3 != null) {
                            dataOutputStream3.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        return;
                    } catch (Throwable e9222222222222222222222) {
                        dataOutputStream3 = dataOutputStream;
                        length = 0;
                        responseCode = 0;
                        httpURLConnection2 = httpURLConnection3;
                        th = e9222222222222222222222;
                        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                        gVar.bgH = false;
                        f.a(this.jBK, gVar.jbo, httpURLConnection2);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (dataOutputStream3 != null) {
                            dataOutputStream3.close();
                        }
                        this.jBK.jBj.remove(gVar.jbo);
                        throw th;
                    }
                } catch (UnsupportedEncodingException e8222222) {
                    unsupportedEncodingException = e8222222;
                    inputStream = inputStream2;
                    i = 0;
                    dataOutputStream2 = null;
                    httpURLConnection = httpURLConnection3;
                    fileInputStream = null;
                    i2 = 0;
                    g.pQN.a(436, 1, 1, false);
                    x.e("MicroMsg.AppBrandNetworkUpload", "UnsupportEncodingException : %s ,url is %s filepath %s ", new Object[]{unsupportedEncodingException.toString(), str, str2});
                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "unsupported encoding", i);
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i2, i, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    return;
                } catch (FileNotFoundException e22222222) {
                    fileNotFoundException = e22222222;
                    fileInputStream2 = null;
                    g.pQN.a(436, 3, 1, false);
                    x.e("MicroMsg.AppBrandNetworkUpload", "FileNotFoundException : %s ,url is %s filepath %s ", new Object[]{fileNotFoundException.toString(), str, str2});
                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "file not exist", i5);
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (dataOutputStream3 != null) {
                        dataOutputStream3.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    return;
                } catch (SSLHandshakeException e32222222) {
                    sSLHandshakeException = e32222222;
                    fileInputStream2 = null;
                    g.pQN.a(436, 2, 1, false);
                    x.e("MicroMsg.AppBrandNetworkUpload", "SSLHandshakeException : %s ,url is %s filepath %s ", new Object[]{sSLHandshakeException.toString(), str, str2});
                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "ssl hand shake error", i5);
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (dataOutputStream3 != null) {
                        dataOutputStream3.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    return;
                } catch (SocketTimeoutException e42222222) {
                    socketTimeoutException = e42222222;
                    fileInputStream2 = null;
                    g.pQN.a(436, 4, 1, false);
                    x.e("MicroMsg.AppBrandNetworkUpload", "SocketTimeoutException : %s ,url is %s filepath %s ", new Object[]{socketTimeoutException.toString(), str, str2});
                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, "socket timeout error", i5);
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (dataOutputStream3 != null) {
                        dataOutputStream3.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    return;
                } catch (Exception e52222222) {
                    exception = e52222222;
                    fileInputStream2 = null;
                    g.pQN.a(436, 5, 1, false);
                    x.e("MicroMsg.AppBrandNetworkUpload", "exception : %s ,url is %s filepath %s ", new Object[]{exception.toString(), str, str2});
                    com_tencent_mm_plugin_appbrand_j_f_a.c(-1, exception.getMessage(), i5);
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, j, (long) i4, i5, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection3);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (dataOutputStream3 != null) {
                        dataOutputStream3.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    return;
                } catch (Throwable e92222222222222222222222) {
                    fileInputStream2 = null;
                    httpURLConnection2 = httpURLConnection3;
                    length = 0;
                    responseCode = 0;
                    th = e92222222222222222222222;
                    j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, length, (long) i4, responseCode, 2, gVar.aiz());
                    gVar.bgH = false;
                    f.a(this.jBK, gVar.jbo, httpURLConnection2);
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (dataOutputStream3 != null) {
                        dataOutputStream3.close();
                    }
                    this.jBK.jBj.remove(gVar.jbo);
                    throw th;
                }
            } else {
                com_tencent_mm_plugin_appbrand_j_f_a.sD("uploadFile protocol must be http or https");
                j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, 0, 0, 0, 2, gVar.aiz());
                return;
            }
        }
        com_tencent_mm_plugin_appbrand_j_f_a.sD("fail:url not in domain list");
        j.a(this.jBK.mAppId, gVar.jBG, "POST", gVar.mUrl, 0, 0, 0, 2, gVar.aiz());
        x.i("MicroMsg.AppBrandNetworkUpload", "not in domain url %s", new Object[]{str});
    }
}
