package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.mm.plugin.appbrand.r.d.c;
import com.tencent.mm.plugin.appbrand.r.d.d;
import com.tencent.mm.plugin.appbrand.r.d.e;
import com.tencent.mm.plugin.appbrand.r.e.f;
import com.tencent.mm.plugin.appbrand.r.e.h;
import com.tencent.mm.plugin.appbrand.r.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private ByteBuffer jTN;
    private d jTO = null;
    private final Random jTP = new Random();

    private class a extends Throwable {
        int jTQ;
        final /* synthetic */ b jTR;

        public a(b bVar, int i) {
            this.jTR = bVar;
            this.jTQ = i;
        }
    }

    public static int d(f fVar) {
        int i = -1;
        String uM = fVar.uM("Sec-WebSocket-Version");
        if (uM.length() > 0) {
            try {
                i = new Integer(uM.trim()).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final int a(com.tencent.mm.plugin.appbrand.r.e.a aVar, h hVar) {
        int i = 1;
        String uM = aVar.uM("Sec-WebSocket-Protocol");
        String uM2 = hVar.uM("Sec-WebSocket-Protocol");
        if (!(bh.ov(uM) || bh.ov(uM2))) {
            x.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[]{uM2});
            for (Object equals : uM.split(", ")) {
                if (uM2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                return com.tencent.mm.plugin.appbrand.r.b.a.b.jTL;
            }
        }
        if (!aVar.uN("Sec-WebSocket-Key") || !hVar.uN("Sec-WebSocket-Accept")) {
            return com.tencent.mm.plugin.appbrand.r.b.a.b.jTL;
        }
        if (uJ(aVar.uM("Sec-WebSocket-Key")).equals(hVar.uM("Sec-WebSocket-Accept"))) {
            return com.tencent.mm.plugin.appbrand.r.b.a.b.jTK;
        }
        return com.tencent.mm.plugin.appbrand.r.b.a.b.jTL;
    }

    public int a(com.tencent.mm.plugin.appbrand.r.e.a aVar) {
        int d = d((f) aVar);
        if (d != 7 && d != 8) {
            return com.tencent.mm.plugin.appbrand.r.b.a.b.jTL;
        }
        Object obj = (aVar.uM("Upgrade").equalsIgnoreCase("websocket") && aVar.uM("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) ? 1 : null;
        return obj != null ? com.tencent.mm.plugin.appbrand.r.b.a.b.jTK : com.tencent.mm.plugin.appbrand.r.b.a.b.jTL;
    }

    public final ByteBuffer d(d dVar) {
        int i;
        int i2;
        int i3 = -128;
        int i4 = 0;
        ByteBuffer alV = dVar.alV();
        int i5 = this.jTi == com.tencent.mm.plugin.appbrand.r.a.b.jSU ? 1 : 0;
        int i6 = alV.remaining() <= 125 ? 1 : alV.remaining() <= 65535 ? 2 : 8;
        if (i6 > 1) {
            i = i6 + 1;
        } else {
            i = i6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i5 != 0 ? 4 : 0) + (i + 1)) + alV.remaining());
        com.tencent.mm.plugin.appbrand.r.d.d.a alY = dVar.alY();
        if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jTW) {
            i = 0;
        } else if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jTX) {
            i = 1;
        } else if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jTY) {
            i = 2;
        } else if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jUb) {
            i = 8;
        } else if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jTZ) {
            i = 9;
        } else if (alY == com.tencent.mm.plugin.appbrand.r.d.d.a.jUa) {
            i = 10;
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + alY.toString());
            i = 8;
        }
        if (dVar.alW()) {
            i2 = -128;
        } else {
            i2 = 0;
        }
        allocate.put((byte) (i | ((byte) i2)));
        byte[] h = h((long) alV.remaining(), i6);
        if (i6 == 1) {
            byte b = h[0];
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (b | i3));
        } else if (i6 == 2) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 126));
            allocate.put(h);
        } else if (i6 == 8) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 127));
            allocate.put(h);
        } else {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i5 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.jTP.nextInt());
            allocate.put(allocate2.array());
            while (alV.hasRemaining()) {
                allocate.put((byte) (alV.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(alV);
        }
        allocate.flip();
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        c eVar = new e();
        try {
            eVar.u(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.r.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.dl(true);
        eVar.a(com.tencent.mm.plugin.appbrand.r.d.d.a.jTY);
        eVar.dm(z);
        return Collections.singletonList(eVar);
    }

    public final List<d> Z(String str, boolean z) {
        c eVar = new e();
        try {
            eVar.u(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.r.f.b.uO(str)));
        } catch (com.tencent.mm.plugin.appbrand.r.c.b e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.dl(true);
        eVar.a(com.tencent.mm.plugin.appbrand.r.d.d.a.jTX);
        eVar.dm(z);
        return Collections.singletonList(eVar);
    }

    private static String uJ(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return com.tencent.mm.plugin.appbrand.r.f.a.W(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            x.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            return "";
        }
    }

    public com.tencent.mm.plugin.appbrand.r.e.b a(com.tencent.mm.plugin.appbrand.r.e.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.jTP.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.r.f.a.W(bArr));
        return bVar;
    }

    public com.tencent.mm.plugin.appbrand.r.e.c a(com.tencent.mm.plugin.appbrand.r.e.a aVar, i iVar) {
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.uM("Connection"));
        iVar.uL("Switching Protocols");
        String uM = aVar.uM("Sec-WebSocket-Key");
        if (uM == null) {
            throw new com.tencent.mm.plugin.appbrand.r.c.d("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", uJ(uM));
        return iVar;
    }

    private static byte[] h(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> r(ByteBuffer byteBuffer) {
        while (true) {
            List<d> linkedList = new LinkedList();
            if (this.jTN == null) {
                break;
            }
            try {
                break;
            } catch (a e) {
                this.jTN.limit();
                ByteBuffer allocate = ByteBuffer.allocate(lL(e.jTQ));
                this.jTN.rewind();
                allocate.put(this.jTN);
                this.jTN = allocate;
            }
        }
        byteBuffer.mark();
        int remaining = byteBuffer.remaining();
        int remaining2 = this.jTN.remaining();
        if (remaining2 > remaining) {
            this.jTN.put(byteBuffer.array(), byteBuffer.position(), remaining);
            byteBuffer.position(remaining + byteBuffer.position());
            return Collections.emptyList();
        }
        this.jTN.put(byteBuffer.array(), byteBuffer.position(), remaining2);
        byteBuffer.position(byteBuffer.position() + remaining2);
        linkedList.add(t((ByteBuffer) this.jTN.duplicate().position(0)));
        this.jTN = null;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(t(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.jTN = ByteBuffer.allocate(lL(e2.jTQ));
                this.jTN.put(byteBuffer);
            }
        }
        return linkedList;
    }

    private d t(ByteBuffer byteBuffer) {
        int i = 10;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(this, 2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new com.tencent.mm.plugin.appbrand.r.c.c("bad rsv " + b2);
        }
        int i3;
        com.tencent.mm.plugin.appbrand.r.d.d.a aVar;
        b2 = byteBuffer.get();
        if ((b2 & -128) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        b2 = (byte) (b2 & 127);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jTW;
                break;
            case (byte) 1:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jTX;
                break;
            case (byte) 2:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jTY;
                break;
            case (byte) 8:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jUb;
                break;
            case (byte) 9:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jTZ;
                break;
            case (byte) 10:
                aVar = com.tencent.mm.plugin.appbrand.r.d.d.a.jUa;
                break;
            default:
                throw new com.tencent.mm.plugin.appbrand.r.c.c("unknow optcode " + ((short) b));
        }
        if (z || !(aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jTZ || aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jUa || aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jUb)) {
            int intValue;
            int i4;
            byte b3;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                i = 2;
                b3 = b2;
            } else if (aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jTZ || aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jUa || aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jUb) {
                throw new com.tencent.mm.plugin.appbrand.r.c.c("more than 125 octets");
            } else if (b2 == (byte) 126) {
                if (remaining < 4) {
                    throw new a(this, 4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new a(this, 10);
            } else {
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    x.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b3 = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            if (i3 != 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 = (i4 + i) + intValue;
            if (remaining < i4) {
                throw new a(this, i4);
            }
            d bVar;
            ByteBuffer allocate = ByteBuffer.allocate(lL(intValue));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < intValue) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == com.tencent.mm.plugin.appbrand.r.d.d.a.jUb) {
                bVar = new com.tencent.mm.plugin.appbrand.r.d.b();
            } else {
                bVar = new e();
                bVar.dl(z);
                bVar.a(aVar);
            }
            allocate.flip();
            bVar.u(allocate);
            return bVar;
        }
        throw new com.tencent.mm.plugin.appbrand.r.c.c("control frames may no be fragmented");
    }

    public final void reset() {
        this.jTN = null;
    }

    public a alT() {
        return new b();
    }

    public final int alS() {
        return com.tencent.mm.plugin.appbrand.r.b.a.a.jTI;
    }
}
