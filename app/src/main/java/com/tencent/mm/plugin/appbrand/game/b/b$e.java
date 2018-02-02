package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.a$a;
import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.game.c.d.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class b$e implements a$a {
    private final int iYg;
    private final int iYh;

    @android.annotation.SuppressLint({"DefaultLocale"})
    public final android.graphics.Bitmap a(java.lang.String r10, java.io.InputStream r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r6 = 0;
        r2 = 1;
        r3 = 0;
        if (r11 == 0) goto L_0x0181;
    L_0x0005:
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3.<init>();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = com.tencent.mm.sdk.platformtools.d.a(r11, r3, r0);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = r3.getDecodeResult();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        if (r1 == 0) goto L_0x0042;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x0015:
        r0 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = "hy: get bitmap options error!! path: %s, errorcode: %d, is native: %b";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = 3;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = new java.lang.Object[r2];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2[r4] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = r3.getDecodeResult();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2[r4] = r5;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = r3.isDecodeByMMDecoder();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2[r4] = r5;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        a(r10, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        r0 = r6;
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r0.outWidth;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = r0.outHeight;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = "hy: %s out mime type: %s, width: %d, height: %d";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = 4;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = new java.lang.Object[r7];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r8 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7[r8] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r8 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = r0.outMimeType;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7[r8] = r0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = 2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r8 = java.lang.Integer.valueOf(r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7[r0] = r8;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = 3;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r8 = java.lang.Integer.valueOf(r2);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7[r0] = r8;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r7);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        if (r1 > r0) goto L_0x0070;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x006c:
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        if (r2 <= r0) goto L_0x00b4;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x0070:
        r0 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = "hy: size exceed the limit!!";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.w(r0, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = com.tencent.mm.plugin.appbrand.game.c.d.a.iYJ;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = com.tencent.mm.plugin.appbrand.q.j.iBK;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = r3.getString(r4);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 4;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = new java.lang.Object[r4];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r7;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r7;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = 3;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r1] = r2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = java.lang.String.format(r3, r4);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        h(r10, r0, r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        r0 = r6;
        goto L_0x0041;
    L_0x00b4:
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2.<init>();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2.inPreferredConfig = r0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = 0;
        r4 = 0;
        r0 = 0;
        r5 = new int[r0];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = r11;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.decodeStream(r0, r1, r2, r3, r4, r5);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = "hy: %s decoderesult is %s";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = new java.lang.Object[r4];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = r3.toLogString();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r7;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r4);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        if (r0 != 0) goto L_0x010c;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x00df:
        r1 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = "hy: decode error!!path: %s errorcode: %d, is native: %b";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 3;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = new java.lang.Object[r4];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = r3.getDecodeResult();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r7;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 2;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = r3.isDecodeByMMDecoder();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4[r5] = r7;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r4);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        a(r10, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x0107:
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        goto L_0x0041;
    L_0x010c:
        r1 = r0.getConfig();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        if (r1 == r2) goto L_0x0107;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
    L_0x0114:
        r1 = r0.getWidth();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = r0.getHeight();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = new android.graphics.Canvas;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2.<init>(r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r5 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2.drawBitmap(r0, r3, r4, r5);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0.recycle();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = r1;
        goto L_0x0107;
    L_0x0132:
        r0 = move-exception;
        r1 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = "hy: decode out of memory in %s";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = new java.lang.Object[r3];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3[r4] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = com.tencent.mm.plugin.appbrand.game.c.d.a.iYJ;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = com.tencent.mm.plugin.appbrand.q.j.iBH;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = r1.getString(r2);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        h(r10, r0, r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        r0 = r6;
        goto L_0x0041;
    L_0x0157:
        r0 = move-exception;
        r1 = "MicroMsg.MBImageHandlerRegistry";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = "hy: decode image exception %s";	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = 1;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3 = new java.lang.Object[r3];	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r4 = 0;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r3[r4] = r10;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r0 = com.tencent.mm.plugin.appbrand.game.c.d.a.iYJ;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r2 = com.tencent.mm.plugin.appbrand.q.j.iBC;	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        r1 = r1.getString(r2);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        h(r10, r0, r1);	 Catch:{ OutOfMemoryError -> 0x0132, Throwable -> 0x0157, all -> 0x017c }
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        r0 = r6;
        goto L_0x0041;
    L_0x017c:
        r0 = move-exception;
        com.tencent.mm.sdk.platformtools.bh.d(r11);
        throw r0;
    L_0x0181:
        r0 = "MicroMsg.MBImageHandlerRegistry";
        r1 = "hy: input steam is null! regard as not found file: %s";
        r2 = new java.lang.Object[r2];
        r2[r3] = r10;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        r0 = com.tencent.mm.plugin.appbrand.game.c.d.a.iYJ;
        r1 = com.tencent.mm.sdk.platformtools.ac.getContext();
        r2 = com.tencent.mm.plugin.appbrand.q.j.iBJ;
        r1 = r1.getString(r2);
        h(r10, r0, r1);
        r0 = r6;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.b.b$e.a(java.lang.String, java.io.InputStream):android.graphics.Bitmap");
    }

    private b$e() {
        this.iYg = 2048;
        this.iYh = 2048;
    }

    private static void a(String str, DecodeResultLogger decodeResultLogger) {
        String format = String.format(ac.getContext().getString(j.iBD), new Object[]{Integer.valueOf(decodeResultLogger.getDecodeResult())});
        if (decodeResultLogger.getDecodeResult() == 1006) {
            format = format + ac.getContext().getString(j.iBF);
        } else if (decodeResultLogger.getDecodeResult() == 1005) {
            format = format + ac.getContext().getString(j.iBG);
        } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            format = format + ac.getContext().getString(j.iBE);
        } else {
            format = format + ac.getContext().getString(j.iBI);
        }
        h(str, a.iYJ, format);
    }

    private static void h(String str, int i, String str2) {
        int i2 = 0;
        d aee = d.aee();
        String str3 = str + ": " + str2;
        if (i == 0 || bh.ov(str3)) {
            x.e("MicroMsg.GameInspector", "hy: not valid console!");
            return;
        }
        switch (d$2.iYF[i - 1]) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 3;
                break;
        }
        aee.G(i2, str3);
    }
}
