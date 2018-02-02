package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.page.p;

class j$1 extends b {
    final /* synthetic */ String fgU;
    final /* synthetic */ p jfB;
    final /* synthetic */ String jqK;

    public final void a(com.tencent.mm.plugin.appbrand.c.c r11) {
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
        r10 = this;
        r5 = 3;
        r9 = 2;
        r8 = 0;
        r7 = 1;
        r0 = r10.fgU;
        com.tencent.mm.plugin.appbrand.c.b(r0, r10);
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = "action";
        r0.putInt(r1, r7);
        r1 = "com.tencent.mm";
        r2 = com.tencent.mm.plugin.appbrand.jsapi.share.a.class;
        r3 = 0;
        com.tencent.mm.ipcinvoker.f.a(r1, r0, r2, r3);
        r0 = java.lang.System.currentTimeMillis();
        r2 = r10.jfB;
        r2 = com.tencent.mm.plugin.appbrand.jsapi.share.j.b(r2);
        r3 = "MicroMsg.ShareHelper";
        r4 = "cropCover(appId : %s, pageView : %s, cropCost : %sms)";
        r5 = new java.lang.Object[r5];
        r6 = r10.jfB;
        r6 = r6.mAppId;
        r5[r8] = r6;
        r6 = r10.jfB;
        r6 = r6.hashCode();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r7] = r6;
        r6 = java.lang.System.currentTimeMillis();
        r0 = r6 - r0;
        r0 = java.lang.Long.valueOf(r0);
        r5[r9] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        if (r2 == 0) goto L_0x00b7;
    L_0x0052:
        r0 = r2.isRecycled();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        if (r0 != 0) goto L_0x00b7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
    L_0x0058:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3 = 100;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = r10.jqK;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = 1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.d.a(r2, r3, r4, r5, r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = 3;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = 0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = r10.jfB;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = r7.mAppId;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = 1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = r10.jfB;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = r7.hashCode();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = 2;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r8 = r8 - r0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3 = new android.os.Bundle;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3.<init>();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = "delay_load_img_path";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = "file://";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5.<init>(r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r6 = r10.jqK;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = r5.toString();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3.putString(r4, r5);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = new com.tencent.mm.plugin.appbrand.jsapi.share.j$1$1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4.<init>(r10, r0, r3);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        com.tencent.mm.bz.a.post(r4);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
    L_0x00b7:
        if (r2 == 0) goto L_0x00c2;
    L_0x00b9:
        r0 = r2.isRecycled();
        if (r0 != 0) goto L_0x00c2;
    L_0x00bf:
        r2.recycle();
    L_0x00c2:
        return;
    L_0x00c3:
        r0 = move-exception;
        r1 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = 1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = 0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.x.w(r1, r3, r4);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        if (r2 == 0) goto L_0x00c2;
    L_0x00d5:
        r0 = r2.isRecycled();
        if (r0 != 0) goto L_0x00c2;
    L_0x00db:
        r2.recycle();
        goto L_0x00c2;
    L_0x00df:
        r0 = move-exception;
        r1 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = 1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r5 = 0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        r4[r5] = r0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.x.w(r1, r3, r4);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df, all -> 0x00fb }
        if (r2 == 0) goto L_0x00c2;
    L_0x00f1:
        r0 = r2.isRecycled();
        if (r0 != 0) goto L_0x00c2;
    L_0x00f7:
        r2.recycle();
        goto L_0x00c2;
    L_0x00fb:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0107;
    L_0x00fe:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0107;
    L_0x0104:
        r2.recycle();
    L_0x0107:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.j$1.a(com.tencent.mm.plugin.appbrand.c$c):void");
    }

    j$1(String str, p pVar, String str2) {
        this.fgU = str;
        this.jfB = pVar;
        this.jqK = str2;
    }
}
