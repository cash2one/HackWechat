package com.tencent.mapsdk.rastercore.tile.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile$MapSource;
import java.io.File;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a {
    private static final String g = ("Qmap" + File.separator);
    private AtomicBoolean a = new AtomicBoolean(false);
    private volatile Context b;
    private AtomicInteger c = new AtomicInteger(0);
    private b d;
    private c e;
    private ReentrantReadWriteLock f = new ReentrantReadWriteLock();

    public static a a() {
        return a.a;
    }

    public static String a(byte[] bArr) {
        String str = "md5";
        if (!(bArr == null || bArr.length == 0)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                byte[] digest = instance.digest();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : digest) {
                    String toHexString = Integer.toHexString(b & 255);
                    if (toHexString.length() == 1) {
                        toHexString = "0" + toHexString;
                    }
                    stringBuilder.append(toHexString);
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
                new StringBuilder("CacheManager getMd5 failed:").append(e.toString());
            }
        }
        return str;
    }

    private static byte[] c(byte[] bArr, String str) {
        try {
            int i;
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + bArr.length;
            byte[] bArr2 = new byte[length];
            for (i = 0; i < bytes.length; i++) {
                bArr2[i] = bytes[i];
            }
            for (i = bytes.length; i < length; i++) {
                bArr2[i] = bArr[i - bytes.length];
            }
            return bArr2;
        } catch (Exception e) {
            new StringBuilder("CacheManager encode:").append(e.toString());
            return bArr;
        }
    }

    private static byte[] d(byte[] bArr, String str) {
        try {
            int length = str.getBytes("UTF-8").length;
            byte[] bArr2 = new byte[(bArr.length - length)];
            for (int i = length; i < bArr.length; i++) {
                bArr2[i - length] = bArr[i];
            }
            return bArr2;
        } catch (Exception e) {
            return bArr;
        }
    }

    public final c a(com.tencent.mapsdk.rastercore.tile.a aVar) {
        c cVar = new c(null, e.v(), "");
        if (!(this.e == null || aVar.m() == MapTile$MapSource.CUSTOMER || aVar.m() == MapTile$MapSource.TRAFFIC)) {
            this.f.readLock().lock();
            try {
                cVar = this.e.a(aVar);
            } catch (Throwable th) {
            } finally {
                this.f.readLock().unlock();
            }
        }
        return cVar;
    }

    public final void a(Context context) {
        try {
            this.c.incrementAndGet();
            if (this.a.compareAndSet(false, true)) {
                this.b = context;
                this.d = new b(this, this.b);
                this.e = new c(this, this.d);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean a(MapTile$MapSource mapTile$MapSource) {
        boolean z = false;
        if (this.e != null) {
            this.f.writeLock().lock();
            try {
                z = this.e.a(mapTile$MapSource);
            } catch (Throwable th) {
                new StringBuilder("clearCache error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z;
    }

    public final boolean a(MapTile$MapSource mapTile$MapSource, int i) {
        boolean z = false;
        if (this.e != null) {
            this.f.writeLock().lock();
            try {
                z = this.e.a(mapTile$MapSource, i);
            } catch (Throwable th) {
                new StringBuilder("deleteOlderMapCache error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z;
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a.c r5, com.tencent.mapsdk.rastercore.tile.a r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.e;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile$MapSource.CUSTOMER;
        if (r0 == r2) goto L_0x0015;
    L_0x000d:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile$MapSource.TRAFFIC;
        if (r0 != r2) goto L_0x0017;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r6.m();
        r2 = com.tencent.mapsdk.rastercore.tile.a.a.1.a;
        r0 = r0.ordinal();
        r0 = r2[r0];
        switch(r0) {
            case 1: goto L_0x0065;
            case 2: goto L_0x006a;
            case 3: goto L_0x006f;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = -1;
    L_0x0027:
        r2 = r4.f;
        r2 = r2.writeLock();
        r2.lock();
        r2 = new java.lang.StringBuilder;
        r3 = "CacheManager Put currentVersion:";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r3 = ",tileData.getVersion():";
        r2 = r2.append(r3);
        r3 = r6.l();
        r2.append(r3);
        r2 = r6.g();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 == 0) goto L_0x005a;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0050:
        r2 = r6.l();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 != r0) goto L_0x005a;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0056:
        r2 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r2 != 0) goto L_0x0074;
    L_0x005a:
        r0 = r4.f;
        r0 = r0.writeLock();
        r0.unlock();
        r0 = r1;
        goto L_0x0016;
    L_0x0065:
        r0 = com.tencent.mapsdk.rastercore.d.e.s();
        goto L_0x0027;
    L_0x006a:
        r0 = com.tencent.mapsdk.rastercore.d.e.v();
        goto L_0x0027;
    L_0x006f:
        r0 = com.tencent.mapsdk.rastercore.d.e.w();
        goto L_0x0027;
    L_0x0074:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = "Put: tileData.getVersion()=";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = r6.l();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = ",currentVersion=";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.append(r0);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = com.tencent.mapsdk.rastercore.tile.a.a.c.a(r0, r6);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        if (r0 != 0) goto L_0x00ab;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
    L_0x0096:
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r5.c();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.a(r6, r2);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        goto L_0x0016;
    L_0x00ab:
        r0 = r4.e;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2 = r5.c();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = 0;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.a(r6, r2, r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        goto L_0x0016;
    L_0x00c1:
        r0 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r3 = "put error:";	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r2.append(r0);	 Catch:{ Throwable -> 0x00c1, all -> 0x00dd }
        r0 = r4.f;
        r0 = r0.writeLock();
        r0.unlock();
        r0 = r1;
        goto L_0x0016;
    L_0x00dd:
        r0 = move-exception;
        r1 = r4.f;
        r1 = r1.writeLock();
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.tile.a.a.a(com.tencent.mapsdk.rastercore.tile.a.c, com.tencent.mapsdk.rastercore.tile.a):boolean");
    }

    public final boolean a(com.tencent.mapsdk.rastercore.tile.a aVar, byte[] bArr, boolean z) {
        boolean z2 = false;
        if (!(this.e == null || aVar.m() == MapTile$MapSource.CUSTOMER || aVar.m() == MapTile$MapSource.TRAFFIC)) {
            this.f.writeLock().lock();
            try {
                z2 = this.e.a(aVar, null, true);
            } catch (Throwable th) {
                new StringBuilder("updateTile error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z2;
    }

    public final String b() {
        Object obj = 1;
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        if (this.b == null) {
            return null;
        }
        String str;
        if (VERSION.SDK_INT >= 23) {
            int checkSelfPermission = this.b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            int checkSelfPermission2 = this.b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if (!(checkSelfPermission == 0 && checkSelfPermission2 == 0)) {
                obj = null;
            }
        }
        if (!equals || r0 == null) {
            str = this.b.getFileStreamPath("") + File.separator + g;
        } else {
            try {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + g;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }
        com.tencent.mapsdk.rastercore.d.a.b(str);
        return str;
    }

    public final void c() {
        if (this.c.decrementAndGet() == 0) {
            if (this.e != null) {
                this.e.close();
            }
            this.a.compareAndSet(true, false);
        }
    }
}
