package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.i;

public final class a {
    private static final i iSH = new c();

    public static android.graphics.Bitmap aQ(java.lang.String r7, java.lang.String r8) {
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
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bh.ov(r7);
        if (r1 != 0) goto L_0x000d;
    L_0x0007:
        r1 = com.tencent.mm.sdk.platformtools.bh.ov(r8);
        if (r1 == 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = com.tencent.mm.plugin.appbrand.appcache.a.px(r8);
        r1 = com.tencent.mm.sdk.platformtools.bh.ov(r2);
        if (r1 != 0) goto L_0x000d;
    L_0x0018:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r7);
        r3 = 35;
        r1 = r1.append(r3);
        r1 = r1.append(r2);
        r3 = r1.toString();
        r1 = iSH;
        r1 = r1.iG(r3);
        if (r1 == 0) goto L_0x003f;
    L_0x0037:
        r4 = r1.isRecycled();
        if (r4 != 0) goto L_0x003f;
    L_0x003d:
        r0 = r1;
        goto L_0x000d;
    L_0x003f:
        r2 = com.tencent.mm.plugin.appbrand.dynamic.j.c.bc(r7, r2);
        if (r2 == 0) goto L_0x0051;
    L_0x0045:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r1 == 0) goto L_0x0051;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
    L_0x0049:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r1 = r1.available();	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r1 > 0) goto L_0x0059;
    L_0x0051:
        if (r2 == 0) goto L_0x000d;
    L_0x0053:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bh.d(r1);
        goto L_0x000d;
    L_0x0059:
        r1 = r2.mInputStream;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r1 = com.tencent.mm.sdk.platformtools.d.decodeStream(r1);	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r1 == 0) goto L_0x0075;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
    L_0x0061:
        r4 = r1.isRecycled();	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r4 != 0) goto L_0x0075;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
    L_0x0067:
        r4 = iSH;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r4.c(r3, r1);	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r2 == 0) goto L_0x0073;
    L_0x006e:
        r0 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bh.d(r0);
    L_0x0073:
        r0 = r1;
        goto L_0x000d;
    L_0x0075:
        if (r2 == 0) goto L_0x000d;
    L_0x0077:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bh.d(r1);
        goto L_0x000d;
    L_0x007d:
        r1 = move-exception;
        r3 = "MicroMsg.CanvasImageCache";	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r4 = "try decode icon e = %s";	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r5 = 1;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r6 = 0;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        r5[r6] = r1;	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ IOException -> 0x007d, all -> 0x0096 }
        if (r2 == 0) goto L_0x000d;
    L_0x008f:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bh.d(r1);
        goto L_0x000d;
    L_0x0096:
        r0 = move-exception;
        if (r2 == 0) goto L_0x009e;
    L_0x0099:
        r1 = r2.mInputStream;
        com.tencent.mm.sdk.platformtools.bh.d(r1);
    L_0x009e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.b.a.aQ(java.lang.String, java.lang.String):android.graphics.Bitmap");
    }
}
