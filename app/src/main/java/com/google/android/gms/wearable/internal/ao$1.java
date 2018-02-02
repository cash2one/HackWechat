package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import java.util.concurrent.Callable;

class ao$1 implements Callable<Boolean> {
    final /* synthetic */ byte[] beP;
    final /* synthetic */ ParcelFileDescriptor bfe;
    final /* synthetic */ ao bff;

    ao$1(ao aoVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        this.bff = aoVar;
        this.bfe = parcelFileDescriptor;
        this.beP = bArr;
    }

    private java.lang.Boolean rt() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0082 in list []
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
        r1 = 3;
        r0 = "WearableClient";
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = new java.lang.StringBuilder;
        r1 = "processAssets: writing data to FD : ";
        r0.<init>(r1);
        r1 = r4.bfe;
        r0.append(r1);
    L_0x0017:
        r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
        r0 = r4.bfe;
        r1.<init>(r0);
        r0 = r4.beP;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r1.write(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r1.flush();	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0 = "WearableClient";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = 3;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        if (r0 == 0) goto L_0x003d;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
    L_0x0030:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = r4.bfe;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
    L_0x003d:
        r0 = 1;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = "WearableClient";	 Catch:{ IOException -> 0x00ab }
        r3 = 3;	 Catch:{ IOException -> 0x00ab }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00ab }
        if (r2 == 0) goto L_0x0059;	 Catch:{ IOException -> 0x00ab }
    L_0x004c:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ab }
        r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00ab }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00ab }
        r3 = r4.bfe;	 Catch:{ IOException -> 0x00ab }
        r2.append(r3);	 Catch:{ IOException -> 0x00ab }
    L_0x0059:
        r1.close();	 Catch:{ IOException -> 0x00ab }
    L_0x005c:
        return r0;
    L_0x005d:
        r0 = move-exception;
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r2 = r4.bfe;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        r0 = "WearableClient";
        r2 = 3;
        r0 = android.util.Log.isLoggable(r0, r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0075:
        r0 = new java.lang.StringBuilder;
        r2 = "processAssets: closing: ";
        r0.<init>(r2);
        r2 = r4.bfe;
        r0.append(r2);
    L_0x0082:
        r1.close();
    L_0x0085:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x005c;
    L_0x008b:
        r0 = move-exception;
        r2 = "WearableClient";	 Catch:{ IOException -> 0x00a7 }
        r3 = 3;	 Catch:{ IOException -> 0x00a7 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00a7 }
        if (r2 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a7 }
    L_0x0096:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a7 }
        r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00a7 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x00a7 }
        r3 = r4.bfe;	 Catch:{ IOException -> 0x00a7 }
        r2.append(r3);	 Catch:{ IOException -> 0x00a7 }
    L_0x00a3:
        r1.close();	 Catch:{ IOException -> 0x00a7 }
    L_0x00a6:
        throw r0;
    L_0x00a7:
        r1 = move-exception;
        goto L_0x00a6;
    L_0x00a9:
        r0 = move-exception;
        goto L_0x0085;
    L_0x00ab:
        r1 = move-exception;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ao$1.rt():java.lang.Boolean");
    }

    public final /* synthetic */ Object call() {
        return rt();
    }
}
