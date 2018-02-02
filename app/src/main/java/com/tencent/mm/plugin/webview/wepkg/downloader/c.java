package com.tencent.mm.plugin.webview.wepkg.downloader;

import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

public final class c implements Runnable {
    private String mContentType;
    private int mStatusCode;
    private int retCode = 0;
    f tLH;
    Future<?> tLI;
    HttpURLConnection tLJ;
    private String tLK;
    private String tLL;
    private String tLM;
    boolean tLN;
    private boolean tLO;
    private boolean tLP = false;

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r15 = this;
        r14 = 2;
        r6 = -1;
        r13 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
        r7 = 1;
        r8 = 0;
        r0 = r15.tLH;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = r15.tLH;
        r0 = r0.mUrl;
        if (r0 == 0) goto L_0x000a;
    L_0x0011:
        r0 = r15.tLH;
        r9 = r0.lKp;
        r5 = r8;
    L_0x0016:
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mUrl;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r1.openConnection();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r15.tLJ = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.tMk;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.tMl;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setUseCaches(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setDoInput(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "GET";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "Accept-Encoding";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "identity";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "http.agent";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = com.tencent.mm.sdk.platformtools.bh.ov(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r2 != 0) goto L_0x0079;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0071:
        r2 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "User-agent";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2.setRequestProperty(r3, r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0079:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.tMm;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x0177;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x007f:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = com.tencent.mm.pluginsdk.i.a.e.a.Gr(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = "%s: RangeOffset = %d";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = 2;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = r12.tMe;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10[r11] = r12;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r10);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 != 0) goto L_0x0155;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00a7:
        r0 = r8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00a8:
        r15.tLO = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00aa:
        r0 = "https";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = r1.getProtocol();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x00e8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00b7:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r0.tMk;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = "TLSv1.2";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = PX(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r1 != 0) goto L_0x00d5;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x00c8:
        r1 = "TLSv1";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = PX(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r1 != 0) goto L_0x00d5;
    L_0x00d1:
        r1 = javax.net.ssl.SSLContext.getDefault();	 Catch:{ Exception -> 0x02c6 }
    L_0x00d5:
        if (r1 == 0) goto L_0x01ec;
    L_0x00d7:
        r3 = 0;
        r4 = 0;
        r10 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x01eb }
        r10.<init>();	 Catch:{ Exception -> 0x01eb }
        r1.init(r3, r4, r10);	 Catch:{ Exception -> 0x01eb }
        r1 = r1.getSocketFactory();	 Catch:{ Exception -> 0x01eb }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x01eb }
    L_0x00e8:
        r15.bVd();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = "handle responose retcode:%s";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 != 0) goto L_0x0237;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0104:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.tMn;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == 0) goto L_0x028c;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x010a:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = r0.tMn;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = new com.tencent.mm.plugin.webview.wepkg.downloader.g;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = r15.tLP;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r4 == 0) goto L_0x0234;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0118:
        r4 = r7;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0119:
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10.a(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLH;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x000a;
    L_0x012c:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x000a;
    L_0x0130:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x000a;
    L_0x0134:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.tLH;
        r1 = r15.tLH;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.tLP = r8;
        goto L_0x000a;
    L_0x0155:
        r0 = r15.tLJ;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = "Range";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r11 = "bytes=";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r10.append(r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = "-";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.addRequestProperty(r4, r2);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r7;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00a8;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0177:
        r0 = r15.tLH;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.mFilePath;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.pluginsdk.i.a.e.a.Sa(r0);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00aa;
    L_0x0180:
        r0 = move-exception;
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r2 = "run exception : %s";	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = 1;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r4 = 0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3[r4] = r0;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0 = r15.tLH;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x01a1:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01c9;
    L_0x01a5:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x01a9:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.tLH;
        r1 = r15.tLH;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.tLP = r8;
        r5 = r6;
    L_0x01c9:
        r5 = r5 + 1;
        if (r5 < r9) goto L_0x0016;
    L_0x01cd:
        r0 = r15.tLH;
        r0 = r0.tMn;
        if (r0 == 0) goto L_0x000a;
    L_0x01d3:
        r0 = r15.tLH;
        r6 = r0.tMn;
        r0 = new com.tencent.mm.plugin.webview.wepkg.downloader.g;
        r1 = r15.tLH;
        r3 = r15.retCode;
        r2 = r15.tLP;
        if (r2 == 0) goto L_0x02c3;
    L_0x01e1:
        r4 = r7;
    L_0x01e2:
        r2 = r14;
        r0.<init>(r1, r2, r3, r4, r5);
        r6.a(r0);
        goto L_0x000a;
    L_0x01eb:
        r1 = move-exception;
    L_0x01ec:
        r1 = new android.net.SSLSessionCache;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r3 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = android.net.SSLCertificateSocketFactory.getDefault(r2, r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r0.setSSLSocketFactory(r1);	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        goto L_0x00e8;
    L_0x01fe:
        r0 = move-exception;
        r1 = r15.tLH;
        r1 = r1.mUrl;
        r2 = "https";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0233;
    L_0x020c:
        r1 = r15.retCode;
        if (r1 != r13) goto L_0x0233;
    L_0x0210:
        r1 = r9 + -1;
        if (r5 < r1) goto L_0x0233;
    L_0x0214:
        r1 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r2 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r15.tLH;
        r2 = r15.tLH;
        r2 = r2.mUrl;
        r3 = "https";
        r4 = "http";
        r2 = r2.replaceFirst(r3, r4);
        r1.mUrl = r2;
        r15.retCode = r8;
        r15.tLP = r8;
    L_0x0233:
        throw r0;
    L_0x0234:
        r4 = r8;
        goto L_0x0119;
    L_0x0237:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x023d:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0243:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x0249:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        if (r0 == r1) goto L_0x0255;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
    L_0x024f:
        r0 = r15.retCode;	 Catch:{ Exception -> 0x0180, all -> 0x01fe }
        r1 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        if (r0 != r1) goto L_0x028c;
    L_0x0255:
        r0 = r15.tLH;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01cd;
    L_0x0262:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01cd;
    L_0x0266:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01cd;
    L_0x026a:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.tLH;
        r1 = r15.tLH;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.tLP = r8;
        r5 = r6;
        goto L_0x01cd;
    L_0x028c:
        r0 = r15.tLH;
        r0 = r0.mUrl;
        r1 = "https";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x01c9;
    L_0x0299:
        r0 = r15.retCode;
        if (r0 != r13) goto L_0x01c9;
    L_0x029d:
        r0 = r9 + -1;
        if (r5 < r0) goto L_0x01c9;
    L_0x02a1:
        r0 = "MicroMsg.Wepkg.WePkgDownloadTask";
        r1 = "change https to http request";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.tLH;
        r1 = r15.tLH;
        r1 = r1.mUrl;
        r2 = "https";
        r3 = "http";
        r1 = r1.replaceFirst(r2, r3);
        r0.mUrl = r1;
        r15.retCode = r8;
        r15.tLP = r8;
        r5 = r6;
        goto L_0x01c9;
    L_0x02c3:
        r4 = r8;
        goto L_0x01e2;
    L_0x02c6:
        r3 = move-exception;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.wepkg.downloader.c.run():void");
    }

    public c(f fVar) {
        this.tLH = fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bVd() {
        Closeable bufferedInputStream;
        Exception e;
        Throwable th;
        Exception exception;
        Throwable th2;
        boolean z = true;
        Closeable closeable = null;
        Closeable closeable2 = null;
        int read;
        try {
            this.mStatusCode = this.tLJ.getResponseCode();
            x.i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: received status code = %d", new Object[]{this.tLH.tMe, Integer.valueOf(this.mStatusCode)});
            switch (this.mStatusCode) {
                case 200:
                case b.CTRL_INDEX /*206*/:
                    long PZ;
                    boolean z2;
                    this.mContentType = this.tLJ.getHeaderField("Content-Type");
                    this.tLJ.getHeaderFields();
                    this.tLK = this.tLJ.getHeaderField("Content-Range");
                    this.tLL = this.tLJ.getHeaderField("Content-Length");
                    boolean z3 = "bytes".equals(this.tLJ.getHeaderField("Accept-Ranges")) ? true : this.tLK != null && this.tLK.startsWith("bytes");
                    if (!this.tLO) {
                        x.i("MicroMsg.Wepkg.WePkgDownloadTask", "local dont have download file. not support range");
                        PZ = PZ(this.tLL);
                        z2 = false;
                    } else if (z3) {
                        PZ = (long) PY(this.tLK);
                        if (PZ == -1) {
                            x.i("MicroMsg.Wepkg.WePkgDownloadTask", "content-range in header is error, not support range");
                            a.Sa(this.tLH.mFilePath);
                            PZ = PZ(this.tLL);
                            z2 = false;
                        } else {
                            z2 = z3;
                        }
                    } else {
                        x.i("MicroMsg.Wepkg.WePkgDownloadTask", "Header no Accept-Ranges, not support range");
                        a.Sa(this.tLH.mFilePath);
                        PZ = PZ(this.tLL);
                        z2 = z3;
                    }
                    this.tLP = z2;
                    x.i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: content-range = %s, content-length = %s, content-type = %s, isSupportRange = %b", new Object[]{this.tLH.tMe, this.tLK, this.tLL, this.mContentType, Boolean.valueOf(z2)});
                    if (PZ != -1) {
                        if (this.tLH.tMi > 0 && PZ != this.tLH.tMi) {
                            x.i("MicroMsg.Wepkg.WePkgDownloadTask", "ServerLength(%d) != HeaderLength(%d)", new Object[]{Long.valueOf(this.tLH.tMi), Long.valueOf(PZ)});
                            this.retCode = HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE;
                            break;
                        }
                        this.tLM = this.tLJ.getContentEncoding();
                        InputStream inputStream = this.tLJ.getInputStream();
                        if (bh.ov(this.tLM) || !this.tLM.equalsIgnoreCase("gzip")) {
                            bufferedInputStream = new BufferedInputStream(inputStream);
                        } else {
                            bufferedInputStream = new GZIPInputStream(inputStream);
                        }
                        try {
                            String str = this.tLH.mFilePath;
                            String str2 = this.tLH.tMe;
                            if (!(this.tLO && z2)) {
                                z = false;
                            }
                            x.d("MicroMsg.Wepkg.WePkgDownloadTask", "%s: getOutputStream, filePath %s", new Object[]{str2, str});
                            if (bh.ov(str)) {
                                throw new FileNotFoundException(String.format("%s filePath is null or nil", new Object[]{str2}));
                            }
                            closeable = new BufferedOutputStream(new FileOutputStream(str, z));
                            try {
                                x.i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: append = %b, isSupportRange = %s", new Object[]{this.tLH.tMe, Boolean.valueOf(this.tLO), Boolean.valueOf(z2)});
                                byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                int i = 0;
                                while (true) {
                                    read = bufferedInputStream.read(bArr, 0, Downloads.RECV_BUFFER_SIZE);
                                    if (read == -1) {
                                        x.i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: read count = %d", new Object[]{this.tLH.mUrl, Integer.valueOf(i)});
                                        closeable.flush();
                                        x.i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: download complete, flush and send complete status", new Object[]{this.tLH.mUrl});
                                        closeable2 = closeable;
                                        closeable = bufferedInputStream;
                                        break;
                                    }
                                    closeable.write(bArr, 0, read);
                                    i += read;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    if (!this.tLN) {
                                        this.retCode = 1001;
                                    } else if (ar.CG().Km() == 0) {
                                        this.retCode = 1002;
                                    } else {
                                        read = 1000;
                                        if (!(e instanceof SSLException)) {
                                            read = HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE;
                                        } else if (!(e instanceof SocketTimeoutException)) {
                                            read = 1003;
                                        } else if (!(e instanceof UnknownHostException)) {
                                            read = 1004;
                                        } else if (!(e instanceof ConnectException)) {
                                            read = 1005;
                                        } else if (!(e instanceof SocketException)) {
                                            read = 1006;
                                        } else if (!(e instanceof IOException)) {
                                            read = 1007;
                                        } else if (e instanceof InterruptedException) {
                                            read = 1008;
                                        }
                                        this.retCode = read;
                                    }
                                    x.e("MicroMsg.Wepkg.WePkgDownloadTask", "exception : %s", new Object[]{e.getMessage()});
                                    a.g(bufferedInputStream);
                                    a.g(closeable);
                                } catch (Throwable th3) {
                                    th = th3;
                                    a.g(bufferedInputStream);
                                    a.g(closeable);
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            exception = e3;
                            closeable = null;
                            e = exception;
                            if (!this.tLN) {
                                this.retCode = 1001;
                            } else if (ar.CG().Km() == 0) {
                                this.retCode = 1002;
                            } else {
                                read = 1000;
                                if (!(e instanceof SSLException)) {
                                    read = HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE;
                                } else if (!(e instanceof SocketTimeoutException)) {
                                    read = 1003;
                                } else if (!(e instanceof UnknownHostException)) {
                                    read = 1004;
                                } else if (!(e instanceof ConnectException)) {
                                    read = 1005;
                                } else if (!(e instanceof SocketException)) {
                                    read = 1006;
                                } else if (!(e instanceof IOException)) {
                                    read = 1007;
                                } else if (e instanceof InterruptedException) {
                                    read = 1008;
                                }
                                this.retCode = read;
                            }
                            x.e("MicroMsg.Wepkg.WePkgDownloadTask", "exception : %s", new Object[]{e.getMessage()});
                            a.g(bufferedInputStream);
                            a.g(closeable);
                        } catch (Throwable th4) {
                            th2 = th4;
                            closeable = null;
                            th = th2;
                            a.g(bufferedInputStream);
                            a.g(closeable);
                            throw th;
                        }
                    }
                    this.retCode = HardCoderJNI.FUNC_REG_ANR_CALLBACK;
                    break;
                    break;
                default:
                    this.retCode = this.mStatusCode;
                    break;
            }
        } catch (Exception e4) {
            exception = e4;
            bufferedInputStream = null;
            closeable = null;
            e = exception;
            if (!this.tLN) {
                this.retCode = 1001;
            } else if (ar.CG().Km() == 0) {
                read = 1000;
                if (!(e instanceof SSLException)) {
                    read = HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE;
                } else if (!(e instanceof SocketTimeoutException)) {
                    read = 1003;
                } else if (!(e instanceof UnknownHostException)) {
                    read = 1004;
                } else if (!(e instanceof ConnectException)) {
                    read = 1005;
                } else if (!(e instanceof SocketException)) {
                    read = 1006;
                } else if (!(e instanceof IOException)) {
                    read = 1007;
                } else if (e instanceof InterruptedException) {
                    read = 1008;
                }
                this.retCode = read;
            } else {
                this.retCode = 1002;
            }
            x.e("MicroMsg.Wepkg.WePkgDownloadTask", "exception : %s", new Object[]{e.getMessage()});
            a.g(bufferedInputStream);
            a.g(closeable);
        } catch (Throwable th5) {
            th2 = th5;
            bufferedInputStream = null;
            closeable = null;
            th = th2;
            a.g(bufferedInputStream);
            a.g(closeable);
            throw th;
        }
    }

    private static SSLContext PX(String str) {
        try {
            return SSLContext.getInstance(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static int PY(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split != null && split.length == 2) {
                try {
                    return Integer.valueOf(split[1]).intValue();
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1;
    }

    private static long PZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return -1;
    }
}
