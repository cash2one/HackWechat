package com.tencent.mm.plugin.appbrand.j;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.report.a.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

public final class c {
    int jBf;
    private SSLContext jBh;
    private final String jBi;
    protected final ArrayList<String> jBj = new ArrayList();
    protected final ArrayList<d> jBp = new ArrayList();
    private String mAppId;

    public c(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jBf = appBrandSysConfig.iOq;
        this.jBi = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(d dVar) {
        UnsupportedEncodingException e;
        HttpURLConnection httpURLConnection;
        int i;
        int i2;
        int i3;
        Throwable th;
        SSLHandshakeException e2;
        FileNotFoundException e3;
        SocketTimeoutException e4;
        Exception e5;
        int i4;
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream = null;
        DataOutputStream dataOutputStream = null;
        a aVar = dVar.jBA;
        Map map = dVar.jBB;
        int i5 = 0;
        ArrayList arrayList = dVar.jBC;
        if (arrayList != null) {
            if (!i.a(arrayList, dVar.mUrl)) {
                aVar.sC("url not in domain list");
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, 0, 0, 0, 2, dVar.aiz());
                x.i("MicroMsg.AppBrandNetworkRequest", "not in domain url %s", new Object[]{dVar.mUrl});
                return;
            }
        }
        g.pQN.a(435, 0, 1, false);
        x.i("MicroMsg.AppBrandNetworkRequest", "prepare to send https request url is %s method is %s", new Object[]{dVar.mUrl, dVar.jBz});
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(dVar.mUrl).openConnection();
            try {
                if (!bh.ov(dVar.jbo)) {
                    dVar.jBF = httpURLConnection2;
                }
                if (httpURLConnection2 == null) {
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), 0, 0, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection2);
                    this.jBj.remove(dVar.jbo);
                    return;
                }
                Object d;
                ByteArrayOutputStream byteArrayOutputStream;
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    if (this.jBh == null) {
                        this.jBh = i.tx(this.mAppId);
                    }
                    if (this.jBh != null) {
                        ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(this.jBh.getSocketFactory());
                    }
                    x.i("MicroMsg.AppBrandNetworkRequest", "DomainList: " + arrayList);
                    i.a(httpURLConnection2, arrayList);
                }
                httpURLConnection2.setConnectTimeout(dVar.jBx);
                httpURLConnection2.setReadTimeout(dVar.jBx);
                httpURLConnection2.setRequestProperty("charset", ProtocolPackage.ServerEncoding);
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestMethod(dVar.jBz);
                httpURLConnection2.setUseCaches(true);
                httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                if (map != null) {
                    x.i("MicroMsg.AppBrandNetworkRequest", "url %s : set header ", new Object[]{dVar.mUrl});
                    for (Entry entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        x.i("MicroMsg.AppBrandNetworkRequest", "url %s : key:%s ,value %s ", new Object[]{dVar.mUrl, entry.getKey(), entry.getValue()});
                    }
                }
                httpURLConnection2.setRequestProperty("User-Agent", s.aL(ac.getContext(), this.jBi));
                if (tr(dVar.jBz)) {
                    x.i("MicroMsg.AppBrandNetworkRequest", "set post or put");
                    httpURLConnection2.setRequestProperty("Content-Length", Integer.toString(dVar.jBy.length));
                    httpURLConnection2.setDoOutput(true);
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        dataOutputStream2.write(dVar.jBy);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                        dataOutputStream = dataOutputStream2;
                    } catch (UnsupportedEncodingException e6) {
                        e = e6;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        i2 = 0;
                        try {
                            g.pQN.a(435, 1, 1, false);
                            x.e("MicroMsg.AppBrandNetworkRequest", "UnsupportedEncodingException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e.toString()});
                            aVar.sC("UTF-8 decode error");
                            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i2, i, 2, dVar.aiz());
                            a(dVar.jbo, httpURLConnection);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e7) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7, "", new Object[0]);
                                } catch (Throwable e72) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72, "", new Object[0]);
                                } catch (Throwable e722) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722, "", new Object[0]);
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable e7222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222, "", new Object[0]);
                                }
                            }
                            this.jBj.remove(dVar.jbo);
                        } catch (Throwable e72222) {
                            i3 = i;
                            i5 = i2;
                            th = e72222;
                            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
                            a(dVar.jbo, httpURLConnection);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e722222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222, "", new Object[0]);
                                } catch (Throwable e7222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222, "", new Object[0]);
                                } catch (Throwable e72222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222, "", new Object[0]);
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable e722222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222, "", new Object[0]);
                                }
                            }
                            this.jBj.remove(dVar.jbo);
                            throw th;
                        }
                    } catch (SSLHandshakeException e8) {
                        e2 = e8;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        try {
                            g.pQN.a(435, 2, 1, false);
                            x.e("MicroMsg.AppBrandNetworkRequest", "SSLHandshakeException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e2.toString()});
                            aVar.sC("ssl hand shake error");
                            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                            a(dVar.jbo, httpURLConnection);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e7222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222, "", new Object[0]);
                                } catch (Throwable e72222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222, "", new Object[0]);
                                } catch (Throwable e722222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222, "", new Object[0]);
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable e7222222222222) {
                                    x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222, "", new Object[0]);
                                }
                            }
                            this.jBj.remove(dVar.jbo);
                        } catch (Throwable e72222222222222) {
                            i3 = i;
                            th = e72222222222222;
                            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
                            a(dVar.jbo, httpURLConnection);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            this.jBj.remove(dVar.jbo);
                            throw th;
                        }
                    } catch (FileNotFoundException e9) {
                        e3 = e9;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        g.pQN.a(435, 3, 1, false);
                        x.e("MicroMsg.AppBrandNetworkRequest", "FileNotFoundException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e3.toString()});
                        aVar.sC("file not exist error");
                        j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                        a(dVar.jbo, httpURLConnection);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e722222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222, "", new Object[0]);
                            } catch (Throwable e7222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222, "", new Object[0]);
                            } catch (Throwable e72222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222, "", new Object[0]);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable e722222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222, "", new Object[0]);
                            }
                        }
                        this.jBj.remove(dVar.jbo);
                    } catch (SocketTimeoutException e10) {
                        e4 = e10;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        g.pQN.a(435, 4, 1, false);
                        x.e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed reason: %s", new Object[]{dVar.mUrl, e4.toString()});
                        aVar.sC(e4.getMessage());
                        j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                        a(dVar.jbo, httpURLConnection);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e7222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222, "", new Object[0]);
                            } catch (Throwable e72222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222, "", new Object[0]);
                            } catch (Throwable e722222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222222, "", new Object[0]);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable e7222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222, "", new Object[0]);
                            }
                        }
                        this.jBj.remove(dVar.jbo);
                    } catch (Exception e11) {
                        e5 = e11;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        g.pQN.a(435, 5, 1, false);
                        x.e("MicroMsg.AppBrandNetworkRequest", "url is %s,failed reason: %s", new Object[]{dVar.mUrl, e5.toString()});
                        aVar.sC(e5.getMessage());
                        j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                        a(dVar.jbo, httpURLConnection);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e72222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222222, "", new Object[0]);
                            } catch (Throwable e722222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222222222, "", new Object[0]);
                            } catch (Throwable e7222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222222, "", new Object[0]);
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable e72222222222222222222222222) {
                                x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222222222, "", new Object[0]);
                            }
                        }
                        this.jBj.remove(dVar.jbo);
                    } catch (Throwable e722222222222222222222222222) {
                        i3 = 0;
                        dataOutputStream = dataOutputStream2;
                        httpURLConnection = httpURLConnection2;
                        th = e722222222222222222222222222;
                        j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
                        a(dVar.jbo, httpURLConnection);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        this.jBj.remove(dVar.jbo);
                        throw th;
                    }
                }
                try {
                    i3 = httpURLConnection2.getResponseCode();
                } catch (IOException e12) {
                    i3 = httpURLConnection2.getResponseCode();
                }
                try {
                    x.i("MicroMsg.AppBrandNetworkRequest", "responseCode = %d, url = %s", new Object[]{Integer.valueOf(i3), dVar.mUrl});
                    if (i3 != 200) {
                        x.e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed code: %d", new Object[]{dVar.mUrl, Integer.valueOf(i3)});
                        if (i.kZ(i3)) {
                            d = i.d(httpURLConnection2);
                            int i6 = dVar.jBD;
                            if (!TextUtils.isEmpty(d)) {
                                if (i6 <= 0) {
                                    x.w("MicroMsg.AppBrandNetworkRequest", "reach the max redirect count(%d)", new Object[]{Integer.valueOf(15)});
                                    aVar.a("ok", "reach the max redirect count 15", i3, c(httpURLConnection2));
                                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), 0, i3, 1, dVar.aiz());
                                    a(dVar.jbo, httpURLConnection2);
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Throwable e7222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222222222, "", new Object[0]);
                                        }
                                    }
                                    this.jBj.remove(dVar.jbo);
                                    return;
                                }
                                x.i("MicroMsg.AppBrandNetworkRequest", "redirect(%d) URL(%s) to URL(%s)", new Object[]{Integer.valueOf(i6), dVar.mUrl, d});
                                dVar.mUrl = d;
                                dVar.jBD = i6 - 1;
                                x.i("MicroMsg.AppBrandNetworkRequest", "now redirect count = %d", new Object[]{Integer.valueOf(dVar.jBD)});
                                a(dVar);
                                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), 0, i3, 2, dVar.aiz());
                                a(dVar.jbo, httpURLConnection2);
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Throwable e72222222222222222222222222222) {
                                        x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222222222222, "", new Object[0]);
                                    }
                                }
                                this.jBj.remove(dVar.jbo);
                                return;
                            }
                        }
                    }
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    if ("gzip".equals(httpURLConnection2.getContentEncoding())) {
                        inputStream = new GZIPInputStream(httpURLConnection2.getInputStream());
                    } else {
                        inputStream = httpURLConnection2.getInputStream();
                    }
                } catch (Exception e52) {
                    x.e("MicroMsg.AppBrandNetworkRequest", "read input stream failed : %s", new Object[]{e52.toString()});
                    if ("gzip".equals(httpURLConnection2.getContentEncoding())) {
                        inputStream = new GZIPInputStream(httpURLConnection2.getErrorStream());
                    } else {
                        inputStream = httpURLConnection2.getErrorStream();
                    }
                } catch (UnsupportedEncodingException e13) {
                    e = e13;
                    i2 = 0;
                    httpURLConnection = httpURLConnection2;
                    i = i3;
                    g.pQN.a(435, 1, 1, false);
                    x.e("MicroMsg.AppBrandNetworkRequest", "UnsupportedEncodingException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e.toString()});
                    aVar.sC("UTF-8 decode error");
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i2, i, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    this.jBj.remove(dVar.jbo);
                } catch (SSLHandshakeException e14) {
                    e2 = e14;
                    httpURLConnection = httpURLConnection2;
                    i = i3;
                    g.pQN.a(435, 2, 1, false);
                    x.e("MicroMsg.AppBrandNetworkRequest", "SSLHandshakeException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e2.toString()});
                    aVar.sC("ssl hand shake error");
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    this.jBj.remove(dVar.jbo);
                } catch (FileNotFoundException e15) {
                    e3 = e15;
                    httpURLConnection = httpURLConnection2;
                    i = i3;
                    g.pQN.a(435, 3, 1, false);
                    x.e("MicroMsg.AppBrandNetworkRequest", "FileNotFoundException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e3.toString()});
                    aVar.sC("file not exist error");
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    this.jBj.remove(dVar.jbo);
                } catch (SocketTimeoutException e16) {
                    e4 = e16;
                    httpURLConnection = httpURLConnection2;
                    i = i3;
                    g.pQN.a(435, 4, 1, false);
                    x.e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed reason: %s", new Object[]{dVar.mUrl, e4.toString()});
                    aVar.sC(e4.getMessage());
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    this.jBj.remove(dVar.jbo);
                } catch (Throwable e722222222222222222222222222222) {
                    httpURLConnection = httpURLConnection2;
                    th = e722222222222222222222222222222;
                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
                    a(dVar.jbo, httpURLConnection);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    this.jBj.remove(dVar.jbo);
                    throw th;
                }
                d = null;
                if (inputStream != null) {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    i4 = 0;
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                e oQ = a.oQ(this.mAppId);
                                if (oQ != null) {
                                    switch (2.iGZ[oQ.iqO.iGV.aas().ordinal()]) {
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
                                    aVar.sC("interrupted");
                                    j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i4, i3, 2, dVar.aiz());
                                    a(dVar.jbo, httpURLConnection2);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e7222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e72222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222222222222222, "", new Object[0]);
                                        } catch (Throwable e722222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222222222222222222, "", new Object[0]);
                                        }
                                    }
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Throwable e7222222222222222222222222222222222) {
                                            x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222222222222222, "", new Object[0]);
                                        }
                                    }
                                    this.jBj.remove(dVar.jbo);
                                    return;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                i4 += read;
                            } else {
                                byteArrayOutputStream.flush();
                                inputStream.close();
                                if ("arraybuffer".equals(dVar.jBE)) {
                                    d = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                                } else {
                                    d = com.tencent.mm.plugin.appbrand.q.c.uF(byteArrayOutputStream.toString("UTF-8"));
                                }
                                x.v("MicroMsg.AppBrandNetworkRequest", "url %s : buffer size %d", new Object[]{dVar.mUrl, Integer.valueOf(byteArrayOutputStream.size())});
                            }
                        } catch (UnsupportedEncodingException e17) {
                            e = e17;
                            i2 = i4;
                            httpURLConnection = httpURLConnection2;
                            i = i3;
                        } catch (SSLHandshakeException e18) {
                            e2 = e18;
                            i5 = i4;
                            httpURLConnection = httpURLConnection2;
                            i = i3;
                        } catch (FileNotFoundException e19) {
                            e3 = e19;
                            i5 = i4;
                            httpURLConnection = httpURLConnection2;
                            i = i3;
                        } catch (SocketTimeoutException e20) {
                            e4 = e20;
                            i5 = i4;
                            httpURLConnection = httpURLConnection2;
                            i = i3;
                        } catch (Exception e21) {
                            e52 = e21;
                            i5 = i4;
                            httpURLConnection = httpURLConnection2;
                            i = i3;
                        } catch (Throwable e72222222222222222222222222222222222) {
                            i5 = i4;
                            httpURLConnection = httpURLConnection2;
                            th = e72222222222222222222222222222222222;
                        }
                    }
                } else {
                    i4 = 0;
                }
                aVar.a("ok", d, i3, c(httpURLConnection2));
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i4, i3, 1, dVar.aiz());
                a(dVar.jbo, httpURLConnection2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e722222222222222222222222222222222222) {
                        x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222222222222222222222, "", new Object[0]);
                    } catch (Throwable e7222222222222222222222222222222222222) {
                        x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e7222222222222222222222222222222222222, "", new Object[0]);
                    } catch (Throwable e72222222222222222222222222222222222222) {
                        x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e72222222222222222222222222222222222222, "", new Object[0]);
                    }
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable e722222222222222222222222222222222222222) {
                        x.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e722222222222222222222222222222222222222, "", new Object[0]);
                    }
                }
                this.jBj.remove(dVar.jbo);
            } catch (UnsupportedEncodingException e22) {
                e = e22;
                httpURLConnection = httpURLConnection2;
                i = 0;
                i2 = 0;
                g.pQN.a(435, 1, 1, false);
                x.e("MicroMsg.AppBrandNetworkRequest", "UnsupportedEncodingException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e.toString()});
                aVar.sC("UTF-8 decode error");
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i2, i, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
            } catch (SSLHandshakeException e23) {
                e2 = e23;
                httpURLConnection = httpURLConnection2;
                i = 0;
                g.pQN.a(435, 2, 1, false);
                x.e("MicroMsg.AppBrandNetworkRequest", "SSLHandshakeException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e2.toString()});
                aVar.sC("ssl hand shake error");
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
            } catch (FileNotFoundException e24) {
                e3 = e24;
                httpURLConnection = httpURLConnection2;
                i = 0;
                g.pQN.a(435, 3, 1, false);
                x.e("MicroMsg.AppBrandNetworkRequest", "FileNotFoundException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e3.toString()});
                aVar.sC("file not exist error");
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
            } catch (SocketTimeoutException e25) {
                e4 = e25;
                httpURLConnection = httpURLConnection2;
                i = 0;
                g.pQN.a(435, 4, 1, false);
                x.e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed reason: %s", new Object[]{dVar.mUrl, e4.toString()});
                aVar.sC(e4.getMessage());
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
            } catch (Exception e26) {
                e52 = e26;
                httpURLConnection = httpURLConnection2;
                i = 0;
                g.pQN.a(435, 5, 1, false);
                x.e("MicroMsg.AppBrandNetworkRequest", "url is %s,failed reason: %s", new Object[]{dVar.mUrl, e52.toString()});
                aVar.sC(e52.getMessage());
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
            } catch (Throwable e7222222222222222222222222222222222222222) {
                i3 = 0;
                httpURLConnection = httpURLConnection2;
                th = e7222222222222222222222222222222222222222;
                j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
                a(dVar.jbo, httpURLConnection);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                this.jBj.remove(dVar.jbo);
                throw th;
            }
        } catch (UnsupportedEncodingException e27) {
            e = e27;
            httpURLConnection = httpURLConnection2;
            i = 0;
            i2 = 0;
            g.pQN.a(435, 1, 1, false);
            x.e("MicroMsg.AppBrandNetworkRequest", "UnsupportedEncodingException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e.toString()});
            aVar.sC("UTF-8 decode error");
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i2, i, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
        } catch (SSLHandshakeException e28) {
            e2 = e28;
            httpURLConnection = httpURLConnection2;
            i = 0;
            g.pQN.a(435, 2, 1, false);
            x.e("MicroMsg.AppBrandNetworkRequest", "SSLHandshakeException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e2.toString()});
            aVar.sC("ssl hand shake error");
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
        } catch (FileNotFoundException e29) {
            e3 = e29;
            httpURLConnection = httpURLConnection2;
            i = 0;
            g.pQN.a(435, 3, 1, false);
            x.e("MicroMsg.AppBrandNetworkRequest", "FileNotFoundException: url %s, fail reason : %s", new Object[]{dVar.mUrl, e3.toString()});
            aVar.sC("file not exist error");
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
        } catch (SocketTimeoutException e30) {
            e4 = e30;
            httpURLConnection = httpURLConnection2;
            i = 0;
            g.pQN.a(435, 4, 1, false);
            x.e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed reason: %s", new Object[]{dVar.mUrl, e4.toString()});
            aVar.sC(e4.getMessage());
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
        } catch (Exception e31) {
            e52 = e31;
            httpURLConnection = httpURLConnection2;
            i = 0;
            g.pQN.a(435, 5, 1, false);
            x.e("MicroMsg.AppBrandNetworkRequest", "url is %s,failed reason: %s", new Object[]{dVar.mUrl, e52.toString()});
            aVar.sC(e52.getMessage());
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
        } catch (Throwable e72222222222222222222222222222222222222222) {
            i3 = 0;
            httpURLConnection = httpURLConnection2;
            th = e72222222222222222222222222222222222222222;
            j.a(this.mAppId, dVar.jBG, dVar.jBz, dVar.mUrl, dVar.getDataSize(), (long) i5, i3, 2, dVar.aiz());
            a(dVar.jbo, httpURLConnection);
            if (inputStream != null) {
                inputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            this.jBj.remove(dVar.jbo);
            throw th;
        }
    }

    public final void b(d dVar) {
        x.d("MicroMsg.AppBrandNetworkRequest", "try to abortTask");
        this.jBj.add(dVar.jbo);
        a(dVar.jbo, dVar.jBF);
    }

    public final boolean to(String str) {
        return this.jBj.contains(str);
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        tm(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    static boolean tr(String str) {
        return str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE");
    }

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, com.tencent.mm.plugin.appbrand.jsapi.e eVar, int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str, String str2) {
        com.tencent.mm.sdk.f.e.post(new 1(this, jVar, jSONObject, eVar, aVar, i, map, arrayList, str2, str), "appbrand_request_thread");
    }

    private synchronized void tm(String str) {
        if (str != null) {
            synchronized (this.jBp) {
                Iterator it = this.jBp.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (str.equals(dVar.jbo)) {
                        this.jBp.remove(dVar);
                        break;
                    }
                }
            }
        }
    }

    private static JSONObject c(HttpURLConnection httpURLConnection) {
        JSONObject jSONObject = new JSONObject();
        if (httpURLConnection == null) {
            return jSONObject;
        }
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return jSONObject;
        }
        for (Entry entry : headerFields.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(bh.ov(str) || list == null || list.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String) list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    stringBuilder.append(",");
                    stringBuilder.append((String) list.get(i));
                }
                try {
                    jSONObject.put(str, stringBuilder.toString());
                } catch (Throwable e) {
                    x.e("MicroMsg.AppBrandNetworkRequest", "put header error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        return jSONObject;
    }

    public final d ts(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jBp) {
            Iterator it = this.jBp.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (str.equals(dVar.jbo)) {
                    return dVar;
                }
            }
            return null;
        }
    }
}
