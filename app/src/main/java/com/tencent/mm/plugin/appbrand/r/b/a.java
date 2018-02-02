package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.mm.plugin.appbrand.r.d.d;
import com.tencent.mm.plugin.appbrand.r.d.d$a;
import com.tencent.mm.plugin.appbrand.r.e.c;
import com.tencent.mm.plugin.appbrand.r.e.e;
import com.tencent.mm.plugin.appbrand.r.e.f;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.plugin.appbrand.r.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int jTC = 1000;
    public static int jTD = 64;
    public static final byte[] jTE = com.tencent.mm.plugin.appbrand.r.f.b.uO("<policy-file-request/>\u0000");
    protected d$a jTF = null;
    protected int jTi = 0;

    public enum b {
        ;

        static {
            jTK = 1;
            jTL = 2;
            jTM = new int[]{jTK, jTL};
        }
    }

    public abstract List<d> Z(String str, boolean z);

    public abstract int a(com.tencent.mm.plugin.appbrand.r.e.a aVar);

    public abstract int a(com.tencent.mm.plugin.appbrand.r.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.r.e.b a(com.tencent.mm.plugin.appbrand.r.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.r.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract int alS();

    public abstract a alT();

    public abstract ByteBuffer d(d dVar);

    public abstract List<d> r(ByteBuffer byteBuffer);

    public abstract void reset();

    private static String q(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        return byteBuffer2 == null ? null : com.tencent.mm.plugin.appbrand.r.f.b.C(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static com.tencent.mm.plugin.appbrand.r.a.b<List> c(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.r.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.r.e.a) fVar).alZ());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).ama());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.r.e.a) fVar).alZ());
            stringBuilder.append(" HTTP/1.1");
            x.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator amb = fVar.amb();
        while (amb.hasNext()) {
            String str = (String) amb.next();
            String uM = fVar.uM(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(uM);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] uP = com.tencent.mm.plugin.appbrand.r.f.b.uP(stringBuilder.toString());
        byte[] amc = fVar.amc();
        ByteBuffer allocate = ByteBuffer.allocate((amc == null ? 0 : amc.length) + uP.length);
        allocate.put(uP);
        if (amc != null) {
            allocate.put(amc);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public final f s(ByteBuffer byteBuffer) {
        int i = this.jTi;
        String q = q(byteBuffer);
        if (q == null) {
            throw new com.tencent.mm.plugin.appbrand.r.c.a(byteBuffer.capacity() + FileUtils.S_IWUSR);
        }
        String[] split = q.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.r.c.d();
        }
        f eVar;
        if (i == com.tencent.mm.plugin.appbrand.r.a.b.jSU) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.uL(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.r.e.d();
            eVar.uK(split[1]);
        }
        while (true) {
            String q2 = q(byteBuffer);
            if (q2 != null && q2.length() > 0) {
                String[] split2 = q2.split(":", 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.r.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (q2 == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.r.c.a();
            }
        }
        if (q2 == null) {
            return eVar;
        }
        throw new com.tencent.mm.plugin.appbrand.r.c.a();
    }

    public static int lL(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.r.c.b("Negative count");
    }

    public final void lM(int i) {
        this.jTi = i;
    }
}
