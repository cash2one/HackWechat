package com.tencent.mm.plugin.clean.c.a;

public abstract class a implements Runnable {
    private long jHU = 0;
    private a lfL;
    c lfM;

    public abstract void execute();

    public void run() {
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
        r4 = this;
        r0 = com.tencent.mm.sdk.platformtools.bh.Wq();	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r4.jHU = r0;	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r4.execute();	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r0 = r4.jHU;	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r0 = com.tencent.mm.sdk.platformtools.bh.bA(r0);	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r4.jHU = r0;	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r0 = r4.lfM;
        if (r0 == 0) goto L_0x0026;
    L_0x0015:
        r0 = r4.lfM;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.f(r1);
    L_0x0026:
        r0 = r4.lfL;
        if (r0 == 0) goto L_0x002f;
    L_0x002a:
        r0 = r4.lfL;
        r0.a(r4);
    L_0x002f:
        return;
    L_0x0030:
        r0 = move-exception;
        r1 = "MicroMsg.AbstractTask";	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r2 = "";	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r3 = 0;	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0030, all -> 0x005c }
        r0 = r4.lfM;
        if (r0 == 0) goto L_0x0052;
    L_0x0041:
        r0 = r4.lfM;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.f(r1);
    L_0x0052:
        r0 = r4.lfL;
        if (r0 == 0) goto L_0x002f;
    L_0x0056:
        r0 = r4.lfL;
        r0.a(r4);
        goto L_0x002f;
    L_0x005c:
        r0 = move-exception;
        r1 = r4.lfM;
        if (r1 == 0) goto L_0x0072;
    L_0x0061:
        r1 = r4.lfM;
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        r2 = java.lang.Long.valueOf(r2);
        r1.f(r2);
    L_0x0072:
        r1 = r4.lfL;
        if (r1 == 0) goto L_0x007b;
    L_0x0076:
        r1 = r4.lfL;
        r1.a(r4);
    L_0x007b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.c.a.a.run():void");
    }

    public String TL() {
        return this.jHU;
    }

    public a(a aVar) {
        this.lfL = aVar;
    }
}
