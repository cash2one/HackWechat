package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

final class h extends o {
    private static final byte[] aFt = "\n".getBytes();
    private final String aFr;
    private final j aFs;

    h(q qVar) {
        super(qVar);
        String str = p.VERSION;
        String str2 = VERSION.RELEASE;
        String c = k.c(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.aFr = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, c, str3, str4});
        this.aFs = new j(qVar.aFD);
    }

    private int a(URL url, byte[] bArr) {
        HttpURLConnection c;
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        w.ag(url);
        w.ag(bArr);
        b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (mP()) {
            c("Post payload\n", new String(bArr));
        }
        try {
            c = c(url);
            try {
                c.setDoOutput(true);
                c.setFixedLengthStreamingMode(bArr.length);
                c.connect();
                outputStream = c.getOutputStream();
                outputStream.write(bArr);
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFo.mU().mL();
                }
                d("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        f("Error closing http post connection output stream", e2);
                    }
                }
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    e("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            f("Error closing http post connection output stream", e4);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            f("Error closing http post connection output stream", e22);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            c = outputStream;
            e("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (c != null) {
                c.disconnect();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            c = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL a(c cVar) {
        try {
            return new URL(cVar.aFg ? ac.nB() + ac.nD() : ac.nC() + ac.nD());
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int b(java.net.URL r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0034 in list [B:7:0x0031]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        com.google.android.gms.common.internal.w.ag(r5);
        r0 = "GET request";
        r4.d(r0, r5);
        r1 = 0;
        r1 = r4.c(r5);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r1.connect();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.b(r1);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r0 = r1.getResponseCode();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r0 != r2) goto L_0x0025;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
    L_0x001c:
        r2 = r4.aFo;	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2 = r2.mU();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r2.mL();	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
    L_0x0025:
        r2 = "GET status";	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r3 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.d(r2, r3);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.disconnect();
    L_0x0034:
        return r0;
    L_0x0035:
        r0 = move-exception;
        r2 = "Network GET connection error";	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        r4.e(r2, r0);	 Catch:{ IOException -> 0x0035, all -> 0x0043 }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.disconnect();
    L_0x0041:
        r0 = 0;
        goto L_0x0034;
    L_0x0043:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.disconnect();
    L_0x0049:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.h.b(java.net.URL):int");
    }

    private int b(URL url, byte[] bArr) {
        OutputStream outputStream;
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream2 = null;
        w.ag(url);
        w.ag(bArr);
        HttpURLConnection c;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            super.a(3, "POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((100 * ((long) toByteArray.length)) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (mP()) {
                c("Post payload", "\n" + new String(bArr));
            }
            c = c(url);
            try {
                c.setDoOutput(true);
                c.addRequestProperty("Content-Encoding", "gzip");
                c.setFixedLengthStreamingMode(toByteArray.length);
                c.connect();
                outputStream = c.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                httpURLConnection = c;
                try {
                    e("Network compressed POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            f("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    c = httpURLConnection;
                    outputStream2 = outputStream;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e4) {
                            f("Error closing http compressed post connection output stream", e4);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(toByteArray);
                outputStream.close();
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFo.mU().mL();
                }
                d("POST status", Integer.valueOf(responseCode));
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = c;
                e("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return 0;
            } catch (Throwable th4) {
                th = th4;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            e("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th5) {
            th = th5;
            c = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL b(c cVar, String str) {
        try {
            return new URL(cVar.aFg ? ac.nB() + ac.nD() + "?" + str : ac.nC() + ac.nD() + "?" + str);
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    f("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    f("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private HttpURLConnection c(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) aj.aHW.get()).intValue());
            httpURLConnection.setReadTimeout(((Integer) aj.aHX.get()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.aFr);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private URL mq() {
        try {
            return new URL(ac.nB() + ((String) aj.aHL.get()));
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private List<Long> r(List<c> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            boolean z;
            w.ag(cVar);
            String a = a(cVar, !cVar.aFg);
            if (a == null) {
                this.aFo.mS().a(cVar, "Error formatting hit for upload");
                z = true;
            } else {
                URL b;
                if (a.length() <= ((Integer) aj.aHM.get()).intValue()) {
                    b = b(cVar, a);
                    if (b == null) {
                        ay("Failed to build collect GET endpoint url");
                    } else {
                        z = b(b) == 200;
                    }
                } else {
                    String a2 = a(cVar, false);
                    if (a2 == null) {
                        this.aFo.mS().a(cVar, "Error formatting hit for POST upload");
                        z = true;
                    } else {
                        byte[] bytes = a2.getBytes();
                        if (bytes.length > ((Integer) aj.aHR.get()).intValue()) {
                            this.aFo.mS().a(cVar, "Hit payload exceeds size limit");
                            z = true;
                        } else {
                            b = a(cVar);
                            if (b == null) {
                                ay("Failed to build collect POST endpoint url");
                            } else if (a(b, bytes) == 200) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.aFd));
            if (arrayList.size() >= ac.nz()) {
                break;
            }
        }
        return arrayList;
    }

    final String a(c cVar, boolean z) {
        w.ag(cVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : cVar.aFb.entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    a(stringBuilder, str, (String) entry.getValue());
                }
            }
            a(stringBuilder, "ht", String.valueOf(cVar.aFe));
            a(stringBuilder, "qt", String.valueOf(this.aFo.aFD.currentTimeMillis() - cVar.aFe));
            if (f.aNs) {
                a(stringBuilder, "_gmsv", p.VERSION);
            }
            if (z) {
                long ar = k.ar(cVar.k("_s", "0"));
                a(stringBuilder, "z", ar != 0 ? String.valueOf(ar) : String.valueOf(cVar.aFd));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            f("Failed to encode name or value", e);
            return null;
        }
    }

    protected final void mf() {
        c("Network initialized. User agent", this.aFr);
    }

    public final boolean mp() {
        NetworkInfo activeNetworkInfo;
        q.mY();
        mQ();
        try {
            activeNetworkInfo = ((ConnectivityManager) this.aFo.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        au("No network connectivity");
        return false;
    }

    public final List<Long> q(List<c> list) {
        boolean z;
        boolean z2;
        a aVar;
        List<Long> arrayList;
        URL mq;
        int b;
        boolean z3 = true;
        q.mY();
        mQ();
        w.ag(list);
        if (this.aFo.aFW.nE().isEmpty() || !this.aFs.V(((long) ((Integer) aj.aHU.get()).intValue()) * 1000)) {
            z = false;
        } else {
            z = x.aE((String) aj.aHN.get()) != x.aGS;
            if (z.aF((String) aj.aHO.get()) == z.aHc) {
                z2 = true;
                if (z) {
                    return r(list);
                }
                if (list.isEmpty()) {
                    z3 = false;
                }
                w.as(z3);
                a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
                aVar = new a(this);
                arrayList = new ArrayList();
                for (c cVar : list) {
                    if (aVar.b(cVar)) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cVar.aFd));
                }
                if (aVar.aFu == 0) {
                    return arrayList;
                }
                mq = mq();
                if (mq != null) {
                    ay("Failed to build batching endpoint url");
                } else {
                    b = z2 ? b(mq, aVar.aFv.toByteArray()) : a(mq, aVar.aFv.toByteArray());
                    if (200 != b) {
                        c("Batched upload completed. Hits batched", Integer.valueOf(aVar.aFu));
                        return arrayList;
                    }
                    c("Network error uploading hits. status code", Integer.valueOf(b));
                    if (this.aFo.aFW.nE().contains(Integer.valueOf(b))) {
                        ax("Server instructed the client to stop batching");
                        this.aFs.start();
                    }
                }
                return Collections.emptyList();
            }
        }
        z2 = false;
        if (z) {
            return r(list);
        }
        if (list.isEmpty()) {
            z3 = false;
        }
        w.as(z3);
        a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
        aVar = new a(this);
        arrayList = new ArrayList();
        for (c cVar2 : list) {
            if (aVar.b(cVar2)) {
                break;
            }
            arrayList.add(Long.valueOf(cVar2.aFd));
        }
        if (aVar.aFu == 0) {
            return arrayList;
        }
        mq = mq();
        if (mq != null) {
            if (z2) {
            }
            if (200 != b) {
                c("Network error uploading hits. status code", Integer.valueOf(b));
                if (this.aFo.aFW.nE().contains(Integer.valueOf(b))) {
                    ax("Server instructed the client to stop batching");
                    this.aFs.start();
                }
            } else {
                c("Batched upload completed. Hits batched", Integer.valueOf(aVar.aFu));
                return arrayList;
            }
        }
        ay("Failed to build batching endpoint url");
        return Collections.emptyList();
    }
}
