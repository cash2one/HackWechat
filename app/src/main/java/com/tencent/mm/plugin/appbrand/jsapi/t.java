package com.tencent.mm.plugin.appbrand.jsapi;

public final class t extends a {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    public final void a(com.tencent.mm.plugin.appbrand.j r10, org.json.JSONObject r11, int r12) {
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
        r9 = this;
        r2 = 0;
        r8 = 0;
        r7 = 1;
        r3 = r10.mAppId;
        r0 = "MicroMsg.JsApiCaptureScreen";
        r1 = "captureScreen, appId:%s";
        r4 = new java.lang.Object[r7];
        r4[r8] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = b(r10);
        if (r0 == 0) goto L_0x015c;
    L_0x0018:
        r1 = "MicroMsg.JsApiCaptureScreen";
        r4 = "isGame:%b";
        r5 = new java.lang.Object[r7];
        r6 = r10.irP;
        r6 = r6.Yz();
        r6 = java.lang.Boolean.valueOf(r6);
        r5[r8] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r1 = r10.irP;
        r1 = r1.Yz();
        if (r1 == 0) goto L_0x0063;
    L_0x0037:
        r0 = com.tencent.mm.plugin.appbrand.game.e.a.jah;
        r0 = r0.aeQ();
        if (r0 == 0) goto L_0x0058;
    L_0x003f:
        r0 = r0.content;
        r1 = r0;
    L_0x0042:
        if (r1 != 0) goto L_0x006d;
    L_0x0044:
        r0 = "MicroMsg.JsApiCaptureScreen";
        r1 = "bitmap is null, err return";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = "fail:can't captureScreen";
        r0 = r9.e(r0, r2);
        r10.E(r12, r0);
    L_0x0057:
        return;
    L_0x0058:
        r0 = "MicroMsg.JsApiCaptureScreen";
        r1 = "mbCanvasContentHolder is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r1 = r2;
        goto L_0x0042;
    L_0x0063:
        r0 = r0.aeM();
        r0 = com.tencent.mm.sdk.platformtools.d.de(r0);
        r1 = r0;
        goto L_0x0042;
    L_0x006d:
        r0 = new java.lang.StringBuilder;
        r2 = "appbrand_capture_";
        r0.<init>(r2);
        r4 = java.lang.System.currentTimeMillis();
        r0 = r0.append(r4);
        r0 = r0.toString();
        r0 = com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.genMediaFilePath(r3, r0);
        r2 = "MicroMsg.JsApiCaptureScreen";
        r4 = "capture bitmap path:%s";
        r5 = new java.lang.Object[r7];
        r5[r8] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        r2 = 100;
        r4 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        com.tencent.mm.sdk.platformtools.d.a(r1, r2, r4, r0, r5);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = "png";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.attach(r3, r0, r2, r4);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        if (r2 != 0) goto L_0x00ca;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
    L_0x00a4:
        r2 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r3 = "create temp file failed, path:%s";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = "fail:gen temp file failed";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = r9.e(r0, r2);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r10.E(r12, r0);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        if (r1 == 0) goto L_0x0057;
    L_0x00c0:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x0057;
    L_0x00c6:
        r1.recycle();
        goto L_0x0057;
    L_0x00ca:
        r0 = new java.util.HashMap;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0.<init>();	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r3 = "tempFilePath";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = r2.fus;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0.put(r3, r4);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r3 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = "capture bitmap tempFilePath:%s";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r6 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = r2.fus;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5[r6] = r2;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = "ok";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = r9.e(r2, r0);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r10.E(r12, r0);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        if (r1 == 0) goto L_0x0057;
    L_0x00f4:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x0057;
    L_0x00fa:
        r1.recycle();
        goto L_0x0057;
    L_0x00ff:
        r0 = move-exception;
        r2 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r3 = "save bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = "fail:IOException";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = r9.e(r0, r2);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r10.E(r12, r0);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        if (r1 == 0) goto L_0x0057;
    L_0x011c:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x0057;
    L_0x0122:
        r1.recycle();
        goto L_0x0057;
    L_0x0127:
        r0 = move-exception;
        r2 = "MicroMsg.JsApiCaptureScreen";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r3 = "save bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = 1;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r5 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = "fail:Exception";	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r2 = 0;	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r0 = r9.e(r0, r2);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        r10.E(r12, r0);	 Catch:{ IOException -> 0x00ff, Exception -> 0x0127, all -> 0x014f }
        if (r1 == 0) goto L_0x0057;
    L_0x0144:
        r0 = r1.isRecycled();
        if (r0 != 0) goto L_0x0057;
    L_0x014a:
        r1.recycle();
        goto L_0x0057;
    L_0x014f:
        r0 = move-exception;
        if (r1 == 0) goto L_0x015b;
    L_0x0152:
        r2 = r1.isRecycled();
        if (r2 != 0) goto L_0x015b;
    L_0x0158:
        r1.recycle();
    L_0x015b:
        throw r0;
    L_0x015c:
        r0 = "MicroMsg.JsApiCaptureScreen";
        r1 = "captureScreen, container or page is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = "fail:container or page is null";
        r0 = r9.e(r0, r2);
        r10.E(r12, r0);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.t.a(com.tencent.mm.plugin.appbrand.j, org.json.JSONObject, int):void");
    }
}
