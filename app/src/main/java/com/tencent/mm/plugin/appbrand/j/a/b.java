package com.tencent.mm.plugin.appbrand.j.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.report.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

public final class b implements Runnable {
    private String appId;
    public volatile boolean bgH = false;
    private String filename;
    public int gKi = 60000;
    public ArrayList<String> jBC;
    private int jBD = 15;
    public String jBG;
    public SSLContext jBh;
    private final String jBi;
    private final a jCc;
    public Map<String, String> jCd;
    public volatile int jCe;
    private long jCf;
    private HttpURLConnection jCg;
    public String jbo;
    private long startTime;
    private String uri;

    public b(String str, String str2, String str3, String str4, a aVar) {
        this.appId = str;
        this.uri = str2;
        this.filename = str3;
        this.jCc = aVar;
        this.startTime = System.currentTimeMillis();
        this.jBi = str4;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        long contentLength;
        int responseCode;
        UnsupportedEncodingException e;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long j;
        int i;
        Object obj;
        int i2;
        Throwable th;
        FileNotFoundException e2;
        SSLHandshakeException e3;
        SocketTimeoutException e4;
        Exception e5;
        InputStream inputStream2;
        Object obj2;
        if (!URLUtil.isHttpsUrl(this.uri) && !URLUtil.isHttpUrl(this.uri)) {
            this.jCc.C(this.filename, this.uri, "downloadFile protocol must be http or https");
        } else if (this.jBC == null || i.a(this.jBC, this.uri)) {
            Object obj3 = null;
            long j2 = 0;
            if (this.bgH) {
                this.jCf = System.currentTimeMillis();
                InputStream inputStream3 = null;
                FileOutputStream fileOutputStream2 = null;
                this.jCc.bv(this.filename, this.uri);
                try {
                    String SW;
                    Object d;
                    g.pQN.a(437, 0, 1, false);
                    URL url = new URL(this.uri);
                    x.i("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , start download", this.uri, this.filename);
                    this.jCg = (HttpURLConnection) url.openConnection();
                    if ((this.jCg instanceof HttpsURLConnection) && this.jBh != null) {
                        ((HttpsURLConnection) this.jCg).setSSLSocketFactory(this.jBh.getSocketFactory());
                        i.a(this.jCg, this.jBC);
                    }
                    this.jCg.setDoInput(true);
                    this.jCg.setConnectTimeout(this.gKi);
                    this.jCg.setReadTimeout(this.gKi);
                    this.jCg.setInstanceFollowRedirects(false);
                    this.jCg.setRequestProperty("Accept-Encoding", "gzip");
                    if (this.jCd != null) {
                        x.i("MicroMsg.AppBrandDownloadWorker", "url %s : set header ", url);
                        for (Entry entry : this.jCd.entrySet()) {
                            this.jCg.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            x.i("MicroMsg.AppBrandDownloadWorker", "filename %s : key:%s ,value %s ", this.filename, entry.getKey(), entry.getValue());
                        }
                    }
                    this.jCg.setRequestProperty("User-Agent", s.aL(ac.getContext(), this.jBi));
                    contentLength = (long) this.jCg.getContentLength();
                    String headerField = this.jCg.getHeaderField("Content-Type");
                    String url2 = url.toString();
                    a SY = a.SY(headerField);
                    if (SY == null) {
                        SW = s.SW(url2);
                    } else {
                        if (SY.mimeType.contains("application/octet-stream")) {
                            headerField = s.SW(url2);
                            if (!bh.ov(headerField)) {
                                SW = headerField;
                            }
                        }
                        SW = SY.mimeType;
                    }
                    responseCode = this.jCg.getResponseCode();
                    if (contentLength > 0) {
                        try {
                            g.pQN.a(437, 16, contentLength, false);
                        } catch (UnsupportedEncodingException e6) {
                            e = e6;
                            fileOutputStream = null;
                            inputStream = null;
                            j = 0;
                            i = responseCode;
                            obj = null;
                            try {
                                g.pQN.a(437, 1, 1, false);
                                x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e.toString());
                                this.jCc.C(this.filename, this.uri, "unsupport encoding error");
                                if (obj == null) {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 1, aiz());
                                    g.pQN.a(437, 10, 1, false);
                                    g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                } else {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e7) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e72) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72, "", new Object[0]);
                                    } catch (Throwable e722) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722, "", new Object[0]);
                                    } catch (Throwable e7222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222, "", new Object[0]);
                                    }
                                }
                                aiI();
                                this.jCc.tp(this.jbo);
                                return;
                            } catch (Throwable e72222) {
                                fileOutputStream2 = fileOutputStream;
                                inputStream3 = inputStream;
                                contentLength = j;
                                i2 = i;
                                obj3 = obj;
                                th = e72222;
                                if (obj3 != null) {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                } else {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                                    g.pQN.a(437, 10, 1, false);
                                    g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable e722222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222, "", new Object[0]);
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable e7222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222, "", new Object[0]);
                                    } catch (Throwable e72222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222, "", new Object[0]);
                                    } catch (Throwable e722222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222, "", new Object[0]);
                                    }
                                }
                                aiI();
                                this.jCc.tp(this.jbo);
                                throw th;
                            }
                        } catch (FileNotFoundException e8) {
                            e2 = e8;
                            try {
                                g.pQN.a(437, 3, 1, false);
                                x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e2.toString());
                                this.jCc.C(this.filename, this.uri, "file not found error");
                                if (obj3 == null) {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                    g.pQN.a(437, 10, 1, false);
                                    g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                } else {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable e7222222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222, "", new Object[0]);
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable e72222222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222, "", new Object[0]);
                                    } catch (Throwable e722222222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222, "", new Object[0]);
                                    } catch (Throwable e7222222222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222, "", new Object[0]);
                                    }
                                }
                                aiI();
                                this.jCc.tp(this.jbo);
                                return;
                            } catch (Throwable e72222222222222) {
                                th = e72222222222222;
                                contentLength = j2;
                                i2 = responseCode;
                                if (obj3 != null) {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                                    g.pQN.a(437, 10, 1, false);
                                    g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                } else {
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                                aiI();
                                this.jCc.tp(this.jbo);
                                throw th;
                            }
                        } catch (SSLHandshakeException e9) {
                            e3 = e9;
                            g.pQN.a(437, 2, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e3.toString());
                            this.jCc.C(this.filename, this.uri, "ssl handshake error");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e722222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable e7222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222, "", new Object[0]);
                                } catch (Throwable e72222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222, "", new Object[0]);
                                } catch (Throwable e722222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222, "", new Object[0]);
                                }
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (SocketTimeoutException e10) {
                            e4 = e10;
                            g.pQN.a(437, 4, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e4.toString());
                            this.jCc.C(this.filename, this.uri, "socket timeout");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e7222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable e72222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222, "", new Object[0]);
                                } catch (Throwable e722222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222, "", new Object[0]);
                                } catch (Throwable e7222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222, "", new Object[0]);
                                }
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (Exception e11) {
                            e5 = e11;
                            g.pQN.a(437, 5, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e5.toString());
                            this.jCc.C(this.filename, this.uri, e5.getMessage());
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e72222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable e722222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222, "", new Object[0]);
                                } catch (Throwable e7222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222, "", new Object[0]);
                                } catch (Throwable e72222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222, "", new Object[0]);
                                }
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        }
                    }
                    int i3 = 28;
                    if (responseCode >= 100 && responseCode < 200) {
                        i3 = 20;
                    } else if (200 == responseCode) {
                        i3 = 21;
                    } else if (responseCode > 200 && responseCode < 300) {
                        i3 = 22;
                    } else if (302 == responseCode) {
                        i3 = 23;
                    } else if (responseCode >= 300 && responseCode < 400) {
                        i3 = 24;
                    } else if (404 == responseCode) {
                        i3 = 25;
                    } else if (responseCode >= 400 && responseCode < 500) {
                        i3 = 26;
                    } else if (responseCode >= 500) {
                        i3 = 27;
                    }
                    g.pQN.a(437, (long) i3, 1, false);
                    x.i("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", Integer.valueOf(responseCode), Integer.valueOf(i3));
                    if (responseCode != 200) {
                        x.e("MicroMsg.AppBrandDownloadWorker", "statusCode %s, url is %s ,filename is %s ", Integer.valueOf(responseCode), this.uri, this.filename);
                        if (i.kZ(responseCode)) {
                            d = i.d(this.jCg);
                            if (!TextUtils.isEmpty(d)) {
                                int i4 = this.jBD;
                                this.jBD = i4 - 1;
                                if (i4 <= 0) {
                                    x.w("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", Integer.valueOf(15));
                                    this.jCc.a(this.filename, SW, this.uri, responseCode);
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, responseCode, 1, aiz());
                                    g.pQN.a(437, 10, 1, false);
                                    g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                }
                                x.i("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(this.jBD), this.uri, d);
                                this.uri = d;
                                run();
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                aiI();
                                this.jCc.tp(this.jbo);
                                return;
                            }
                        }
                    }
                    i3 = this.jCg.getContentLength();
                    if (i3 <= 0 || this.jCe <= 0 || i3 < this.jCe * 1048576) {
                        InputStream gZIPInputStream;
                        if ("gzip".equals(this.jCg.getContentEncoding())) {
                            gZIPInputStream = new GZIPInputStream(this.jCg.getInputStream());
                        } else if ("deflate".equals(this.jCg.getContentEncoding())) {
                            gZIPInputStream = new InflaterInputStream(this.jCg.getInputStream(), new Inflater(true));
                        } else {
                            inputStream2 = this.jCg.getInputStream();
                        }
                        try {
                            File file = new File(this.filename);
                            if (file.exists()) {
                                x.i("MicroMsg.AppBrandDownloadWorker", "exists temp file ,filename is %s ", this.filename);
                                if (!file.delete()) {
                                    x.e("MicroMsg.AppBrandDownloadWorker", "exists temp file delete failed, filename is %s ", this.filename);
                                    this.jCc.C(this.filename, this.uri, "exists temp file delete failed");
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, responseCode, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e722222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e7222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e72222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222, "", new Object[0]);
                                        }
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                }
                            }
                            if (!file.getParentFile().exists()) {
                                x.i("MicroMsg.AppBrandDownloadWorker", "create file ,filename is %s ", this.filename);
                                if (!file.getParentFile().mkdirs()) {
                                    x.e("MicroMsg.AppBrandDownloadWorker", "create file  getParentFile failed, filename is %s ", this.filename);
                                    this.jCc.C(this.filename, this.uri, "getParentFile failed");
                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, responseCode, 2, aiz());
                                    g.pQN.a(437, 11, 1, false);
                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e722222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e7222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e72222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222222, "", new Object[0]);
                                        }
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                }
                            }
                            if (inputStream2 != null) {
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    long j3 = 0;
                                    while (true) {
                                        try {
                                            int read = inputStream2.read(bArr);
                                            if (read == -1 || !this.bgH) {
                                                fileOutputStream3.flush();
                                                fileOutputStream2 = fileOutputStream3;
                                                j2 = j3;
                                            } else {
                                                e oQ = com.tencent.mm.plugin.appbrand.a.oQ(this.appId);
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
                                                    this.jCc.C(this.filename, this.uri, "interrupted");
                                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j3, responseCode, 2, aiz());
                                                    g.pQN.a(437, 11, 1, false);
                                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                                    try {
                                                        fileOutputStream3.close();
                                                    } catch (Throwable e722222222222222222222222222222222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222222, "", new Object[0]);
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Throwable e7222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222222222222, "", new Object[0]);
                                                        } catch (Throwable e72222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222222222, "", new Object[0]);
                                                        } catch (Throwable e722222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222222222, "", new Object[0]);
                                                        }
                                                    }
                                                    aiI();
                                                    this.jCc.tp(this.jbo);
                                                    return;
                                                }
                                                fileOutputStream3.write(bArr, 0, read);
                                                long j4 = j3 + ((long) read);
                                                if (contentLength > 0) {
                                                    try {
                                                        if (this.bgH) {
                                                            this.jCc.g((int) ((100 * j4) / contentLength), j4, contentLength);
                                                            x.v("MicroMsg.AppBrandDownloadWorker", "download size %d, totalSize %d, percent = %d", Long.valueOf(j4), Long.valueOf(contentLength), Integer.valueOf(r5));
                                                        }
                                                    } catch (UnsupportedEncodingException e12) {
                                                        e = e12;
                                                        fileOutputStream = fileOutputStream3;
                                                        inputStream = inputStream2;
                                                        j = j4;
                                                        i = responseCode;
                                                        obj = null;
                                                    } catch (FileNotFoundException e13) {
                                                        e2 = e13;
                                                        fileOutputStream2 = fileOutputStream3;
                                                        j2 = j4;
                                                        inputStream3 = inputStream2;
                                                    } catch (SSLHandshakeException e14) {
                                                        e3 = e14;
                                                        fileOutputStream2 = fileOutputStream3;
                                                        j2 = j4;
                                                        inputStream3 = inputStream2;
                                                    } catch (SocketTimeoutException e15) {
                                                        e4 = e15;
                                                        fileOutputStream2 = fileOutputStream3;
                                                        j2 = j4;
                                                        inputStream3 = inputStream2;
                                                    } catch (Exception e16) {
                                                        e5 = e16;
                                                        fileOutputStream2 = fileOutputStream3;
                                                        j2 = j4;
                                                        inputStream3 = inputStream2;
                                                    } catch (Throwable e7222222222222222222222222222222222222) {
                                                        th = e7222222222222222222222222222222222222;
                                                        fileOutputStream2 = fileOutputStream3;
                                                        contentLength = j4;
                                                        i2 = responseCode;
                                                        inputStream3 = inputStream2;
                                                    }
                                                }
                                                if (j4 <= 0 || this.jCe <= 0 || j4 < ((long) this.jCe) * 1048576) {
                                                    j3 = j4;
                                                } else {
                                                    x.i("MicroMsg.AppBrandDownloadWorker", "after read stream, downloadSize %d exceed limit", Long.valueOf(j4));
                                                    this.jCc.C(this.filename, this.uri, "exceed max file size");
                                                    bh.d(fileOutputStream3);
                                                    bh.d(inputStream2);
                                                    com.tencent.mm.loader.stub.b.deleteFile(file.getAbsolutePath());
                                                    j.a(this.appId, this.jBG, "GET", this.uri, 0, j4, responseCode, 2, aiz());
                                                    g.pQN.a(437, 11, 1, false);
                                                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                                    try {
                                                        fileOutputStream3.close();
                                                    } catch (Throwable e72222222222222222222222222222222222222) {
                                                        x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222222222222, "", new Object[0]);
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Throwable e722222222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222222222222, "", new Object[0]);
                                                        } catch (Throwable e7222222222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222222222222222222, "", new Object[0]);
                                                        } catch (Throwable e72222222222222222222222222222222222222222) {
                                                            x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222222222222222, "", new Object[0]);
                                                        }
                                                    }
                                                    aiI();
                                                    this.jCc.tp(this.jbo);
                                                    return;
                                                }
                                            }
                                        } catch (UnsupportedEncodingException e17) {
                                            e = e17;
                                            fileOutputStream = fileOutputStream3;
                                            j = j3;
                                            obj = null;
                                            i = responseCode;
                                            inputStream = inputStream2;
                                        } catch (FileNotFoundException e18) {
                                            e2 = e18;
                                            fileOutputStream2 = fileOutputStream3;
                                            j2 = j3;
                                            inputStream3 = inputStream2;
                                        } catch (SSLHandshakeException e19) {
                                            e3 = e19;
                                            fileOutputStream2 = fileOutputStream3;
                                            j2 = j3;
                                            inputStream3 = inputStream2;
                                        } catch (SocketTimeoutException e20) {
                                            e4 = e20;
                                            fileOutputStream2 = fileOutputStream3;
                                            j2 = j3;
                                            inputStream3 = inputStream2;
                                        } catch (Exception e21) {
                                            e5 = e21;
                                            fileOutputStream2 = fileOutputStream3;
                                            j2 = j3;
                                            inputStream3 = inputStream2;
                                        } catch (Throwable e722222222222222222222222222222222222222222) {
                                            th = e722222222222222222222222222222222222222222;
                                            fileOutputStream2 = fileOutputStream3;
                                            contentLength = j3;
                                            i2 = responseCode;
                                            inputStream3 = inputStream2;
                                        }
                                    }
                                } catch (UnsupportedEncodingException e22) {
                                    e = e22;
                                    fileOutputStream = fileOutputStream3;
                                    inputStream = inputStream2;
                                    j = 0;
                                    i = responseCode;
                                    obj = null;
                                    g.pQN.a(437, 1, 1, false);
                                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e.toString());
                                    this.jCc.C(this.filename, this.uri, "unsupport encoding error");
                                    if (obj == null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                } catch (FileNotFoundException e23) {
                                    e2 = e23;
                                    fileOutputStream2 = fileOutputStream3;
                                    inputStream3 = inputStream2;
                                    g.pQN.a(437, 3, 1, false);
                                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e2.toString());
                                    this.jCc.C(this.filename, this.uri, "file not found error");
                                    if (obj3 == null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                } catch (SSLHandshakeException e24) {
                                    e3 = e24;
                                    fileOutputStream2 = fileOutputStream3;
                                    inputStream3 = inputStream2;
                                    g.pQN.a(437, 2, 1, false);
                                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e3.toString());
                                    this.jCc.C(this.filename, this.uri, "ssl handshake error");
                                    if (obj3 == null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                } catch (SocketTimeoutException e25) {
                                    e4 = e25;
                                    fileOutputStream2 = fileOutputStream3;
                                    inputStream3 = inputStream2;
                                    g.pQN.a(437, 4, 1, false);
                                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e4.toString());
                                    this.jCc.C(this.filename, this.uri, "socket timeout");
                                    if (obj3 == null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                } catch (Exception e26) {
                                    e5 = e26;
                                    fileOutputStream2 = fileOutputStream3;
                                    inputStream3 = inputStream2;
                                    g.pQN.a(437, 5, 1, false);
                                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e5.toString());
                                    this.jCc.C(this.filename, this.uri, e5.getMessage());
                                    if (obj3 == null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    return;
                                } catch (Throwable e7222222222222222222222222222222222222222222) {
                                    th = e7222222222222222222222222222222222222222222;
                                    fileOutputStream2 = fileOutputStream3;
                                    contentLength = 0;
                                    i2 = responseCode;
                                    inputStream3 = inputStream2;
                                    if (obj3 != null) {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                                        g.pQN.a(437, 10, 1, false);
                                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                                    } else {
                                        j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                                        g.pQN.a(437, 11, 1, false);
                                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    if (inputStream3 != null) {
                                        inputStream3.close();
                                    }
                                    aiI();
                                    this.jCc.tp(this.jbo);
                                    throw th;
                                }
                            }
                            if (this.bgH) {
                                this.jCc.a(this.filename, SW, this.uri, responseCode);
                                long currentTimeMillis = System.currentTimeMillis() - this.jCf;
                                if (contentLength <= 0 || currentTimeMillis <= 0) {
                                    x.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", Long.valueOf(contentLength), Long.valueOf(currentTimeMillis));
                                } else {
                                    i3 = 34;
                                    double d2 = (((double) contentLength) / ((double) currentTimeMillis)) * 0.9765625d;
                                    if (an.is2G(ac.getContext())) {
                                        i3 = 30;
                                    } else if (an.is3G(ac.getContext())) {
                                        i3 = 31;
                                    } else if (an.is4G(ac.getContext())) {
                                        i3 = 32;
                                    } else if (an.isWifi(ac.getContext())) {
                                        i3 = 33;
                                    }
                                    g.pQN.a(437, (long) i3, (long) d2, false);
                                    x.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(contentLength), Long.valueOf(currentTimeMillis), Double.valueOf(d2), Integer.valueOf(i3));
                                }
                                obj2 = 1;
                            } else {
                                this.jCc.C(this.filename, this.uri, "force stop");
                                obj2 = null;
                            }
                        } catch (UnsupportedEncodingException e27) {
                            e = e27;
                            fileOutputStream = null;
                            inputStream = inputStream2;
                            j = 0;
                            i = responseCode;
                            obj = null;
                            g.pQN.a(437, 1, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e.toString());
                            this.jCc.C(this.filename, this.uri, "unsupport encoding error");
                            if (obj == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (FileNotFoundException e28) {
                            e2 = e28;
                            inputStream3 = inputStream2;
                            g.pQN.a(437, 3, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e2.toString());
                            this.jCc.C(this.filename, this.uri, "file not found error");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (SSLHandshakeException e29) {
                            e3 = e29;
                            inputStream3 = inputStream2;
                            g.pQN.a(437, 2, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e3.toString());
                            this.jCc.C(this.filename, this.uri, "ssl handshake error");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (SocketTimeoutException e30) {
                            e4 = e30;
                            inputStream3 = inputStream2;
                            g.pQN.a(437, 4, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e4.toString());
                            this.jCc.C(this.filename, this.uri, "socket timeout");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (Exception e31) {
                            e5 = e31;
                            inputStream3 = inputStream2;
                            g.pQN.a(437, 5, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e5.toString());
                            this.jCc.C(this.filename, this.uri, e5.getMessage());
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (Throwable e72222222222222222222222222222222222222222222) {
                            th = e72222222222222222222222222222222222222222222;
                            inputStream3 = inputStream2;
                            contentLength = j2;
                            i2 = responseCode;
                            if (obj3 != null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            throw th;
                        }
                        try {
                            x.v("MicroMsg.AppBrandDownloadWorker", "finished filename = %s , url = %s ", this.filename, this.uri);
                            this.jCg.disconnect();
                            if (obj2 != null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e722222222222222222222222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222222222222222222, "", new Object[0]);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable e7222222222222222222222222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e7222222222222222222222222222222222222222222222, "", new Object[0]);
                                } catch (Throwable e72222222222222222222222222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e72222222222222222222222222222222222222222222222, "", new Object[0]);
                                } catch (Throwable e722222222222222222222222222222222222222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e722222222222222222222222222222222222222222222222, "", new Object[0]);
                                }
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (UnsupportedEncodingException e32) {
                            e = e32;
                            fileOutputStream = fileOutputStream2;
                            inputStream = inputStream2;
                            j = j2;
                            i = responseCode;
                            obj = obj2;
                            g.pQN.a(437, 1, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e.toString());
                            this.jCc.C(this.filename, this.uri, "unsupport encoding error");
                            if (obj == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (FileNotFoundException e33) {
                            e2 = e33;
                            inputStream3 = inputStream2;
                            obj3 = obj2;
                            g.pQN.a(437, 3, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e2.toString());
                            this.jCc.C(this.filename, this.uri, "file not found error");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (SSLHandshakeException e34) {
                            e3 = e34;
                            inputStream3 = inputStream2;
                            obj3 = obj2;
                            g.pQN.a(437, 2, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e3.toString());
                            this.jCc.C(this.filename, this.uri, "ssl handshake error");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (SocketTimeoutException e35) {
                            e4 = e35;
                            inputStream3 = inputStream2;
                            obj3 = obj2;
                            g.pQN.a(437, 4, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e4.toString());
                            this.jCc.C(this.filename, this.uri, "socket timeout");
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (Exception e36) {
                            e5 = e36;
                            inputStream3 = inputStream2;
                            obj3 = obj2;
                            g.pQN.a(437, 5, 1, false);
                            x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e5.toString());
                            this.jCc.C(this.filename, this.uri, e5.getMessage());
                            if (obj3 == null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            return;
                        } catch (Throwable e7222222222222222222222222222222222222222222222222) {
                            th = e7222222222222222222222222222222222222222222222222;
                            inputStream3 = inputStream2;
                            contentLength = j2;
                            i2 = responseCode;
                            obj3 = obj2;
                            if (obj3 != null) {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                                g.pQN.a(437, 11, 1, false);
                                g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                            } else {
                                j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                                g.pQN.a(437, 10, 1, false);
                                g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            aiI();
                            this.jCc.tp(this.jbo);
                            throw th;
                        }
                    }
                    x.i("MicroMsg.AppBrandDownloadWorker", "before actually read stream, contentLength %d exceed limit", Integer.valueOf(i3));
                    this.jCc.C(this.filename, this.uri, "exceed max file size");
                    j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, responseCode, 2, aiz());
                    g.pQN.a(437, 11, 1, false);
                    g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (UnsupportedEncodingException e37) {
                    e = e37;
                    fileOutputStream = null;
                    inputStream = null;
                    j = 0;
                    i = 0;
                    obj = null;
                    g.pQN.a(437, 1, 1, false);
                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e.toString());
                    this.jCc.C(this.filename, this.uri, "unsupport encoding error");
                    if (obj == null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j, i, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (FileNotFoundException e38) {
                    e2 = e38;
                    responseCode = 0;
                    g.pQN.a(437, 3, 1, false);
                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e2.toString());
                    this.jCc.C(this.filename, this.uri, "file not found error");
                    if (obj3 == null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (SSLHandshakeException e39) {
                    e3 = e39;
                    responseCode = 0;
                    g.pQN.a(437, 2, 1, false);
                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e3.toString());
                    this.jCc.C(this.filename, this.uri, "ssl handshake error");
                    if (obj3 == null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (SocketTimeoutException e40) {
                    e4 = e40;
                    responseCode = 0;
                    g.pQN.a(437, 4, 1, false);
                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e4.toString());
                    this.jCc.C(this.filename, this.uri, "socket timeout");
                    if (obj3 == null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (Exception e41) {
                    e5 = e41;
                    responseCode = 0;
                    g.pQN.a(437, 5, 1, false);
                    x.e("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , error is %s", this.uri, this.filename, e5.toString());
                    this.jCc.C(this.filename, this.uri, e5.getMessage());
                    if (obj3 == null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, j2, responseCode, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    return;
                } catch (Throwable e72222222222222222222222222222222222222222222222222) {
                    th = e72222222222222222222222222222222222222222222222222;
                    contentLength = 0;
                    i2 = 0;
                    if (obj3 != null) {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 1, aiz());
                        g.pQN.a(437, 10, 1, false);
                        g.pQN.a(437, 12, System.currentTimeMillis() - this.jCf, false);
                    } else {
                        j.a(this.appId, this.jBG, "GET", this.uri, 0, contentLength, i2, 2, aiz());
                        g.pQN.a(437, 11, 1, false);
                        g.pQN.a(437, 13, System.currentTimeMillis() - this.jCf, false);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    aiI();
                    this.jCc.tp(this.jbo);
                    throw th;
                }
            }
            this.jCc.C(this.filename, this.uri, "force stop");
            j.a(this.appId, this.jBG, "GET", this.uri, 0, 0, 0, 2, aiz());
        } else {
            this.jCc.C(this.filename, this.uri, "url not in domain list");
            x.i("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", this.uri);
        }
    }

    public final void aiI() {
        this.bgH = false;
        if (this.jCg != null) {
            try {
                this.jCg.disconnect();
            } catch (Exception e) {
            }
        }
    }

    private int aiz() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
