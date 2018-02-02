package com.tencent.mm.pluginsdk.i.a.d;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pluginsdk.i.a.c.a;
import com.tencent.mm.pluginsdk.i.a.c.d;
import com.tencent.mm.pluginsdk.i.a.c.f;
import com.tencent.mm.pluginsdk.i.a.c.g;
import com.tencent.mm.pluginsdk.i.a.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

public final class j {
    private static final Class[] vhJ = new Class[]{InterruptedException.class};
    private static final Class[] vhK = new Class[]{UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, a.class, d.class, g.class};
    private static final Class[] vhL = new Class[]{SocketException.class, SocketTimeoutException.class};
    private boolean vhI = false;

    j() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final l a(e eVar) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        Throwable th2;
        DataOutputStream dataOutputStream;
        Exception exception;
        l b;
        if (eVar == null) {
            x.d("MicroMsg.ResDownloader.NetworkPerformer", "get null task, just skip");
            return null;
        } else if (bh.ov(eVar.getFilePath())) {
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: filePath is null or nil, just return null", eVar.bZj());
            return null;
        } else {
            while (true) {
                try {
                    boolean z;
                    if (!eVar.aad()) {
                        com.tencent.mm.pluginsdk.i.a.e.a.Sa(eVar.getFilePath());
                    }
                    bZA();
                    URL url = new URL(eVar.getURL());
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    try {
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: connection opened, url = %s", eVar.bZj(), eVar.getURL());
                        bZA();
                        a(eVar, httpURLConnection2);
                        bZA();
                        long Gr = com.tencent.mm.pluginsdk.i.a.e.a.Gr(eVar.getFilePath());
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: RangeOffset = %d", eVar.bZj(), Long.valueOf(Gr));
                        if (Gr == 0) {
                            z = false;
                        } else {
                            httpURLConnection2.addRequestProperty("Range", "bytes=" + Gr + "-");
                            z = true;
                        }
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: hasRangerHeader=%b", eVar.bZj(), Boolean.valueOf(z));
                        bZA();
                        if ("https".equalsIgnoreCase(url.getProtocol())) {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                            SSLContext PX = PX("TLSv1.2");
                            if (PX == null) {
                                PX = PX("TLSv1");
                                if (PX == null) {
                                    PX = SSLContext.getDefault();
                                }
                            }
                            if (PX != null) {
                                PX.init(null, null, new SecureRandom());
                                httpsURLConnection.setSSLSocketFactory(PX.getSocketFactory());
                            }
                            httpsURLConnection.setSSLSocketFactory(SSLCertificateSocketFactory.getDefault(eVar.bZy(), new SSLSessionCache(ac.getContext())));
                        }
                    } catch (Exception e) {
                    } catch (Throwable th22) {
                        httpURLConnection = httpURLConnection2;
                        th = th22;
                    }
                    bZA();
                    x.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpMethod = %s", eVar.bZj(), eVar.bZw());
                    if ("POST".equals(eVar.bZw()) && !bh.bw(null)) {
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setRequestProperty("Content-Type", eVar.bZz());
                        Object[] objArr = null;
                        httpURLConnection2.setFixedLengthStreamingMode(objArr.length);
                        try {
                            dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                            try {
                                dataOutputStream.write(null);
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable th222) {
                                    x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", eVar.bZj());
                                    x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th222, "", new Object[0]);
                                }
                            } catch (IOException e2) {
                                th222 = e2;
                                try {
                                    x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", eVar.bZj());
                                    x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th222, "", new Object[0]);
                                    throw th222;
                                } catch (Throwable th3) {
                                    th222 = th3;
                                }
                            }
                        } catch (IOException e3) {
                            th222 = e3;
                            dataOutputStream = null;
                            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", eVar.bZj());
                            x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th222, "", new Object[0]);
                            throw th222;
                        } catch (Throwable th4) {
                            th222 = th4;
                            dataOutputStream = null;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Throwable e4) {
                                    x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", eVar.bZj());
                                    x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e4, "", new Object[0]);
                                }
                            }
                            throw th222;
                        }
                    }
                    bZA();
                    l a = a(eVar, httpURLConnection2, z);
                    httpURLConnection2.disconnect();
                    break;
                } catch (Exception e5) {
                    exception = e5;
                    httpURLConnection = null;
                    try {
                        b = b(eVar, exception);
                        if (b == null) {
                            x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: get null response in catch-block, may retry", eVar.bZj());
                            if (!eVar.aah()) {
                                x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: retry times out", eVar.bZj());
                                b = a(eVar, exception);
                                if (httpURLConnection != null) {
                                    return b;
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    return b;
                                } catch (Exception e6) {
                                    return b;
                                }
                            } else if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e7) {
                                }
                            }
                        } else if (httpURLConnection == null) {
                            return b;
                        } else {
                            try {
                                httpURLConnection.disconnect();
                                return b;
                            } catch (Exception e8) {
                                return b;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = null;
                }
            }
            x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: retry times out", eVar.bZj());
            b = a(eVar, exception);
            if (httpURLConnection != null) {
                return b;
            }
            httpURLConnection.disconnect();
            return b;
        }
        return a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e9) {
            }
        }
        throw th;
        throw th;
    }

    private static void bZA() {
        if (Thread.interrupted()) {
            throw new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
        }
    }

    private static void a(e eVar, HttpURLConnection httpURLConnection) {
        x.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", eVar.bZj());
        Collection<b> bZx = eVar.bZx();
        if (bZx != null && bZx.size() > 0) {
            for (b bVar : bZx) {
                httpURLConnection.addRequestProperty(bVar.name, bVar.value);
            }
        }
        httpURLConnection.setRequestMethod(eVar.bZw());
        if ("GET".equalsIgnoreCase(eVar.bZw())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(eVar.getConnectTimeout());
        httpURLConnection.setReadTimeout(eVar.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (eVar.aac()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!bh.ov(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        if (eVar.aag()) {
            httpURLConnection.setInstanceFollowRedirects(true);
        } else {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
    }

    private static SSLContext PX(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static l a(e eVar, HttpURLConnection httpURLConnection, boolean z) {
        Closeable bufferedInputStream;
        int read;
        InterruptedException e;
        Throwable th;
        UnknownHostException e2;
        SocketException e3;
        SocketTimeoutException e4;
        IOException e5;
        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: step4, start to read response", eVar.bZj());
        Closeable closeable = null;
        Closeable closeable2 = null;
        int i = -1;
        try {
            boolean z2;
            l lVar;
            int responseCode = httpURLConnection.getResponseCode();
            int contentLength = httpURLConnection.getContentLength();
            String contentEncoding = httpURLConnection.getContentEncoding();
            String contentType = httpURLConnection.getContentType();
            if ("bytes".equals(httpURLConnection.getHeaderField("Accept-Ranges"))) {
                z2 = true;
            } else {
                String headerField = httpURLConnection.getHeaderField("Content-Range");
                z2 = headerField != null && headerField.startsWith("bytes");
            }
            x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: received status code = %d, content-length = %d, content-encoding = %s, content-type = %s, isSupportRange = %b, \nresponseHeaders = %s", eVar.bZj(), Integer.valueOf(responseCode), Integer.valueOf(contentLength), contentEncoding, contentType, Boolean.valueOf(z2), b.aq(httpURLConnection.getHeaderFields()));
            long Gr = com.tencent.mm.pluginsdk.i.a.e.a.Gr(eVar.getFilePath());
            if (contentLength == 0 && com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX == responseCode && Gr > 0) {
                x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: file exists, return", eVar.bZj());
                lVar = new l(eVar, Gr, contentType);
                com.tencent.mm.pluginsdk.i.a.e.a.g(null);
                com.tencent.mm.pluginsdk.i.a.e.a.g(null);
            } else if ((301 == responseCode || HardCoderJNI.SCENE_QUIT_CHATTING == responseCode) && !eVar.aag()) {
                x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: task redirects not allowed, return", eVar.bZj());
                throw new d();
            } else if (contentLength == 0) {
                throw new g();
            } else if (eVar.aae() || contentLength >= 0) {
                if (contentLength > 0) {
                    if (!eVar.bD((long) contentLength)) {
                        throw new a();
                    }
                }
                if (416 == responseCode) {
                    throw new com.tencent.mm.pluginsdk.i.a.c.b((long) contentLength, Gr);
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    boolean z3;
                    if (!bh.ov(contentEncoding) && contentEncoding.equalsIgnoreCase("gzip")) {
                        bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                    }
                    contentEncoding = eVar.getFilePath();
                    String bZj = eVar.bZj();
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    x.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: getOutputStream, filePath %s", bZj, contentEncoding);
                    if (bh.ov(contentEncoding)) {
                        throw new FileNotFoundException(String.format("%s filePath is null or nil", new Object[]{bZj}));
                    }
                    closeable = new BufferedOutputStream(new FileOutputStream(contentEncoding, z3));
                    try {
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: append = %b, isSupportRange = %s", eVar.bZj(), Boolean.valueOf(z), Boolean.valueOf(z2));
                        byte[] bArr = new byte[16384];
                        i = 0;
                        while (true) {
                            read = bufferedInputStream.read(bArr, 0, 16384);
                            if (read == -1) {
                                break;
                            }
                            closeable.write(bArr, 0, read);
                            i += read;
                            bZA();
                        }
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: read count = %d", eVar.bZj(), Integer.valueOf(i));
                        closeable.flush();
                        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download complete, flush and send complete status", eVar.bZj());
                        if (eVar.aae()) {
                            lVar = new l(eVar, com.tencent.mm.pluginsdk.i.a.e.a.Gr(eVar.getFilePath()), contentType);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(bufferedInputStream);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                            if (i > 0 && ak.a.hfM != null) {
                                ak.a.hfM.aV(i, 0);
                            }
                        } else {
                            lVar = new l(eVar, (long) contentLength, contentType);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(bufferedInputStream);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                            if (i > 0 && ak.a.hfM != null) {
                                ak.a.hfM.aV(i, 0);
                            }
                        }
                    } catch (InterruptedException e6) {
                        e = e6;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (UnknownHostException e7) {
                        e2 = e7;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        throw e2;
                    } catch (SSLHandshakeException e8) {
                        th = e8;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection SSLHandshakeException!", eVar.bZj());
                        x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th, "", new Object[0]);
                        throw th;
                    } catch (SocketException e9) {
                        e3 = e9;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        x.e("MicroMsg.ResDownloader.NetworkPerformer", eVar.bZj() + ": " + e3.getMessage());
                        throw e3;
                    } catch (SocketTimeoutException e10) {
                        e4 = e10;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        throw e4;
                    } catch (IOException e11) {
                        e5 = e11;
                        read = i;
                        i = responseCode;
                        try {
                            com.tencent.mm.pluginsdk.i.a.e.a.g(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            i = read;
                            closeable2 = closeable;
                            closeable = bufferedInputStream;
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable2);
                            ak.a.hfM.aV(i, 0);
                            throw th;
                        }
                        try {
                            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.bZj(), e5);
                            throw new f(i, e5);
                        } catch (Throwable th4) {
                            th = th4;
                            i = read;
                            closeable2 = closeable;
                            Object errorStream = httpURLConnection.getErrorStream();
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                            com.tencent.mm.pluginsdk.i.a.e.a.g(closeable2);
                            ak.a.hfM.aV(i, 0);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        closeable2 = closeable;
                        closeable = bufferedInputStream;
                        com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                        com.tencent.mm.pluginsdk.i.a.e.a.g(closeable2);
                        ak.a.hfM.aV(i, 0);
                        throw th;
                    }
                } catch (InterruptedException e12) {
                    e = e12;
                    closeable = bufferedInputStream;
                    throw e;
                } catch (UnknownHostException e13) {
                    e2 = e13;
                    closeable = bufferedInputStream;
                    throw e2;
                } catch (SSLHandshakeException e14) {
                    th = e14;
                    closeable = bufferedInputStream;
                    x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection SSLHandshakeException!", eVar.bZj());
                    x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th, "", new Object[0]);
                    throw th;
                } catch (SocketException e15) {
                    e3 = e15;
                    closeable = bufferedInputStream;
                    x.e("MicroMsg.ResDownloader.NetworkPerformer", eVar.bZj() + ": " + e3.getMessage());
                    throw e3;
                } catch (SocketTimeoutException e16) {
                    e4 = e16;
                    closeable = bufferedInputStream;
                    throw e4;
                } catch (IOException e17) {
                    e5 = e17;
                    closeable = null;
                    read = -1;
                    i = responseCode;
                    com.tencent.mm.pluginsdk.i.a.e.a.g(bufferedInputStream);
                    x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.bZj(), e5);
                    throw new f(i, e5);
                } catch (Throwable th6) {
                    th = th6;
                    closeable = bufferedInputStream;
                    com.tencent.mm.pluginsdk.i.a.e.a.g(closeable);
                    com.tencent.mm.pluginsdk.i.a.e.a.g(closeable2);
                    ak.a.hfM.aV(i, 0);
                    throw th;
                }
            } else {
                throw new SocketException();
            }
            return lVar;
        } catch (InterruptedException e18) {
            e = e18;
            throw e;
        } catch (UnknownHostException e19) {
            e2 = e19;
            throw e2;
        } catch (SSLHandshakeException e20) {
            th = e20;
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection SSLHandshakeException!", eVar.bZj());
            x.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th, "", new Object[0]);
            throw th;
        } catch (SocketException e21) {
            e3 = e21;
            x.e("MicroMsg.ResDownloader.NetworkPerformer", eVar.bZj() + ": " + e3.getMessage());
            throw e3;
        } catch (SocketTimeoutException e22) {
            e4 = e22;
            throw e4;
        } catch (IOException e23) {
            e5 = e23;
            bufferedInputStream = null;
            closeable = null;
            read = -1;
            i = -1;
            com.tencent.mm.pluginsdk.i.a.e.a.g(bufferedInputStream);
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.bZj(), e5);
            throw new f(i, e5);
        }
    }

    private static l a(e eVar, Exception exception) {
        int i = -1;
        if (exception instanceof f) {
            i = ((f) exception).httpStatusCode;
            exception = ((f) exception).vhv;
        }
        x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", eVar.bZj(), exception);
        return new l(eVar, exception, i, 3);
    }

    private static l b(e eVar, Exception exception) {
        if (exception instanceof ProtocolException) {
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", eVar.bZj(), eVar.bZw());
            return a(eVar, exception);
        } else if (exception instanceof com.tencent.mm.pluginsdk.i.a.c.b) {
            x.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", eVar.bZj(), exception.getClass().getSimpleName(), exception.getMessage());
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(eVar.getFilePath());
            return null;
        } else {
            for (Object equals : vhJ) {
                if (equals.equals(exception.getClass())) {
                    x.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", eVar.bZj(), exception);
                    return new l(eVar, exception, 4);
                }
            }
            for (Object equals2 : vhL) {
                if (equals2.equals(exception.getClass())) {
                    return null;
                }
            }
            for (Object equals3 : vhK) {
                if (equals3.equals(exception.getClass())) {
                    return a(eVar, exception);
                }
            }
            return a(eVar, exception);
        }
    }
}
