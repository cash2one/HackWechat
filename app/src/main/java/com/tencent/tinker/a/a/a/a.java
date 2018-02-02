package com.tencent.tinker.a.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.g$b;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.u;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] AeS = new short[0];
    private static final g$b[] AfQ = new g$b[0];
    private static final com.tencent.tinker.a.a.g.a[] AfR = new com.tencent.tinker.a.a.g.a[0];
    public int AfS;
    private boolean AfT;
    public ByteBuffer aif;

    public a() {
        this.aif = ByteBuffer.allocate(WXMediaMessage.TITLE_LENGTH_LIMIT);
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        this.AfS = this.aif.position();
        this.aif.limit(this.aif.capacity());
        this.AfT = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.aif = byteBuffer;
        this.aif.order(ByteOrder.LITTLE_ENDIAN);
        this.AfS = byteBuffer.limit();
        this.AfT = false;
    }

    public final void Ih(int i) {
        if (this.aif.position() + i > this.aif.limit() && this.AfT) {
            Object array = this.aif.array();
            Object obj = new byte[((array.length + i) + (array.length >> 1))];
            System.arraycopy(array, 0, obj, 0, this.aif.position());
            int position = this.aif.position();
            this.aif = ByteBuffer.wrap(obj);
            this.aif.order(ByteOrder.LITTLE_ENDIAN);
            this.aif.position(position);
            this.aif.limit(this.aif.capacity());
        }
    }

    public final byte readByte() {
        return this.aif.get();
    }

    private int readUnsignedShort() {
        return this.aif.getShort() & 65535;
    }

    public final byte[] Ii(int i) {
        byte[] bArr = new byte[i];
        this.aif.get(bArr);
        return bArr;
    }

    private short[] Ij(int i) {
        if (i == 0) {
            return AeS;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.aif.getShort();
        }
        return sArr;
    }

    private int cGP() {
        return o.b(this);
    }

    private int cGQ() {
        return o.b(this) - 1;
    }

    private int cGR() {
        return o.a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public s cGq() {
        int i = 0;
        int position = this.aif.position();
        try {
            int b = o.b(this);
            char[] cArr = new char[b];
            while (true) {
                char readByte = (char) (readByte() & 255);
                if (readByte == '\u0000') {
                    break;
                }
                cArr[i] = readByte;
                if (readByte < '') {
                    i++;
                } else if ((readByte & 224) == ar.CTRL_INDEX) {
                    r6 = readByte() & 255;
                    if ((r6 & ar.CTRL_INDEX) != FileUtils.S_IWUSR) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    r1 = i + 1;
                    cArr[i] = (char) (((readByte & 31) << 6) | (r6 & 63));
                    i = r1;
                } else if ((readByte & 240) == 224) {
                    r6 = readByte() & 255;
                    int readByte2 = readByte() & 255;
                    if ((r6 & ar.CTRL_INDEX) == FileUtils.S_IWUSR && (readByte2 & ar.CTRL_INDEX) == FileUtils.S_IWUSR) {
                        r1 = i + 1;
                        cArr[i] = (char) ((((readByte & 15) << 12) | ((r6 & 63) << 6)) | (readByte2 & 63));
                        i = r1;
                    }
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
            }
            throw new UTFDataFormatException("bad second or third byte");
        } catch (Throwable e) {
            throw new j(e);
        }
    }

    public u cGr() {
        return new u(this.aif.position(), Ij(this.aif.getInt()));
    }

    public n cGs() {
        return new n(this.aif.position(), readUnsignedShort(), readUnsignedShort(), this.aif.getInt());
    }

    public p cGt() {
        return new p(this.aif.position(), readUnsignedShort(), readUnsignedShort(), this.aif.getInt());
    }

    public r cGu() {
        return new r(this.aif.position(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt());
    }

    public f cGv() {
        return new f(this.aif.position(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt(), this.aif.getInt());
    }

    public g cGw() {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        g$b[] com_tencent_tinker_a_a_g_bArr;
        int position = this.aif.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i = this.aif.getInt();
        short[] Ij = Ij(this.aif.getInt());
        if (readUnsignedShort4 > 0) {
            int position2;
            int a;
            int i2;
            if ((Ij.length & 1) == 1) {
                skip(2);
            }
            int position3 = this.aif.position();
            skip(readUnsignedShort4 * 8);
            int position4 = this.aif.position();
            int b = o.b(this);
            aVarArr = new com.tencent.tinker.a.a.g.a[b];
            for (int i3 = 0; i3 < b; i3++) {
                position2 = this.aif.position() - position4;
                a = o.a(this);
                int abs = Math.abs(a);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (i2 = 0; i2 < abs; i2++) {
                    iArr[i2] = o.b(this);
                    iArr2[i2] = o.b(this);
                }
                aVarArr[i3] = new com.tencent.tinker.a.a.g.a(iArr, iArr2, a <= 0 ? o.b(this) : -1, position2);
            }
            position4 = this.aif.position();
            this.aif.position(position3);
            com_tencent_tinker_a_a_g_bArr = new g$b[readUnsignedShort4];
            position3 = 0;
            while (position3 < readUnsignedShort4) {
                b = this.aif.getInt();
                position2 = readUnsignedShort();
                a = readUnsignedShort();
                i2 = 0;
                while (i2 < aVarArr.length) {
                    if (aVarArr[i2].offset == a) {
                        com_tencent_tinker_a_a_g_bArr[position3] = new g$b(b, position2, i2);
                        position3++;
                    } else {
                        i2++;
                    }
                }
                throw new IllegalArgumentException();
            }
            this.aif.position(position4);
        } else {
            com_tencent_tinker_a_a_g_bArr = AfQ;
            aVarArr = AfR;
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i, Ij, com_tencent_tinker_a_a_g_bArr, aVarArr);
    }

    public h cGx() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        int position = this.aif.position();
        int b = o.b(this);
        int b2 = o.b(this);
        int[] iArr = new int[b2];
        for (int i = 0; i < b2; i++) {
            iArr[i] = o.b(this) - 1;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(64);
            b 1 = new 1(this, byteArrayOutputStream);
            while (true) {
                byte b3 = this.aif.get();
                byteArrayOutputStream.write(b3);
                switch (b3) {
                    case (byte) 0:
                        h hVar = new h(position, b, iArr, byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                        return hVar;
                    case (byte) 1:
                        o.a(1, cGP());
                        break;
                    case (byte) 2:
                        try {
                            o.c(1, cGR());
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            break;
                        }
                    case (byte) 3:
                    case (byte) 4:
                        o.a(1, cGP());
                        o.b(1, cGQ());
                        o.b(1, cGQ());
                        if (b3 != (byte) 4) {
                            break;
                        }
                        o.b(1, cGQ());
                        break;
                    case (byte) 5:
                    case (byte) 6:
                        o.a(1, cGP());
                        break;
                    case (byte) 9:
                        o.b(1, cGQ());
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            }
            throw th;
        }
    }

    public e cGy() {
        return new e(this.aif.position(), Ik(o.b(this)), Ik(o.b(this)), Il(o.b(this)), Il(o.b(this)));
    }

    private com.tencent.tinker.a.a.e.a[] Ik(int i) {
        int i2 = 0;
        com.tencent.tinker.a.a.e.a[] aVarArr = new com.tencent.tinker.a.a.e.a[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            aVarArr[i2] = new com.tencent.tinker.a.a.e.a(i3, o.b(this));
            i2++;
        }
        return aVarArr;
    }

    private e.b[] Il(int i) {
        int i2 = 0;
        e.b[] bVarArr = new e.b[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.b(this);
            bVarArr[i2] = new e.b(i3, o.b(this), o.b(this));
            i2++;
        }
        return bVarArr;
    }

    private byte[] Im(int i) {
        byte[] bArr = new byte[(this.aif.position() - i)];
        this.aif.position(i);
        this.aif.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a cGz() {
        int position = this.aif.position();
        byte b = this.aif.get();
        int position2 = this.aif.position();
        new m(this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b, new k(position2, Im(position2)));
    }

    public com.tencent.tinker.a.a.b cGA() {
        int position = this.aif.position();
        int i = this.aif.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aif.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c cGB() {
        int position = this.aif.position();
        int i = this.aif.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.aif.getInt();
        }
        return new c(position, iArr);
    }

    public d cGC() {
        int i;
        int position = this.aif.position();
        int i2 = this.aif.getInt();
        int i3 = this.aif.getInt();
        int i4 = this.aif.getInt();
        int i5 = this.aif.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i3, 2});
        for (i = 0; i < i3; i++) {
            iArr[i][0] = this.aif.getInt();
            iArr[i][1] = this.aif.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i4, 2});
        for (i = 0; i < i4; i++) {
            iArr2[i][0] = this.aif.getInt();
            iArr2[i][1] = this.aif.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i5, 2});
        for (i = 0; i < i5; i++) {
            iArr3[i][0] = this.aif.getInt();
            iArr3[i][1] = this.aif.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k cGD() {
        int position = this.aif.position();
        new m(this, 28).skipValue();
        return new k(position, Im(position));
    }

    private void skip(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.aif.position(this.aif.position() + i);
    }

    public final void writeByte(int i) {
        Ih(1);
        this.aif.put((byte) i);
        if (this.aif.position() > this.AfS) {
            this.AfS = this.aif.position();
        }
    }

    public final void writeShort(short s) {
        Ih(2);
        this.aif.putShort(s);
        if (this.aif.position() > this.AfS) {
            this.AfS = this.aif.position();
        }
    }

    private void In(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: " + i);
        }
        writeShort(s);
    }

    public final void writeInt(int i) {
        Ih(4);
        this.aif.putInt(i);
        if (this.aif.position() > this.AfS) {
            this.AfS = this.aif.position();
        }
    }

    public final void write(byte[] bArr) {
        Ih(bArr.length * 1);
        this.aif.put(bArr);
        if (this.aif.position() > this.AfS) {
            this.AfS = this.aif.position();
        }
    }

    public int a(s sVar) {
        int position = this.aif.position();
        try {
            o.a(this, sVar.value.length());
            String str = sVar.value;
            long j = 0;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                j = (charAt == '\u0000' || charAt > '') ? charAt <= '߿' ? j + 2 : j + 3 : j + 1;
                if (j > 65535) {
                    throw new UTFDataFormatException("String more than 65535 UTF bytes long");
                }
            }
            byte[] bArr = new byte[((int) j)];
            q.a(bArr, 0, str);
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public int a(u uVar) {
        int position = this.aif.position();
        short[] sArr = uVar.AfP;
        writeInt(sArr.length);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.aif.position();
        In(nVar.Afi);
        In(nVar.Aev);
        writeInt(nVar.Afj);
        return position;
    }

    public int a(p pVar) {
        int position = this.aif.position();
        In(pVar.Afi);
        In(pVar.Afk);
        writeInt(pVar.Afj);
        return position;
    }

    public int a(r rVar) {
        int position = this.aif.position();
        writeInt(rVar.Afl);
        writeInt(rVar.Afm);
        writeInt(rVar.Afn);
        return position;
    }

    public int a(f fVar) {
        int position = this.aif.position();
        writeInt(fVar.Aev);
        writeInt(fVar.Aes);
        writeInt(fVar.Aew);
        writeInt(fVar.Aex);
        writeInt(fVar.Aey);
        writeInt(fVar.Aez);
        writeInt(fVar.AeA);
        writeInt(fVar.AeB);
        return position;
    }

    public int a(g gVar) {
        int length;
        int position;
        int i = 0;
        int position2 = this.aif.position();
        In(gVar.AeC);
        In(gVar.AeD);
        In(gVar.AeE);
        In(gVar.AeH.length);
        writeInt(gVar.AeF);
        writeInt(gVar.AeG.length);
        short[] sArr = gVar.AeG;
        Ih(sArr.length * 2);
        for (short writeShort : sArr) {
            writeShort(writeShort);
        }
        if (this.aif.position() > this.AfS) {
            this.AfS = this.aif.position();
        }
        if (gVar.AeH.length > 0) {
            if ((gVar.AeG.length & 1) == 1) {
                writeShort((short) 0);
            }
            position = this.aif.position();
            length = gVar.AeH.length * 8;
            Ih(length * 1);
            skip(length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.AeI;
            int position3 = this.aif.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (length = 0; length < aVarArr.length; length++) {
                iArr[length] = this.aif.position() - position3;
                com.tencent.tinker.a.a.g.a aVar = aVarArr[length];
                int i2 = aVar.AeL;
                int[] iArr2 = aVar.AeJ;
                int[] iArr3 = aVar.AeK;
                if (i2 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    o.a(this, iArr2[i3]);
                    o.a(this, iArr3[i3]);
                }
                if (i2 != -1) {
                    o.a(this, i2);
                }
            }
            length = this.aif.position();
            this.aif.position(position);
            g$b[] com_tencent_tinker_a_a_g_bArr = gVar.AeH;
            position = com_tencent_tinker_a_a_g_bArr.length;
            while (i < position) {
                g$b com_tencent_tinker_a_a_g_b = com_tencent_tinker_a_a_g_bArr[i];
                writeInt(com_tencent_tinker_a_a_g_b.AeM);
                In(com_tencent_tinker_a_a_g_b.AeN);
                In(iArr[com_tencent_tinker_a_a_g_b.AeO]);
                i++;
            }
            this.aif.position(length);
        }
        return position2;
    }

    public int a(h hVar) {
        int position = this.aif.position();
        o.a(this, hVar.AeP);
        o.a(this, r2);
        for (int i : hVar.AeQ) {
            o.a(this, i + 1);
        }
        write(hVar.AeR);
        return position;
    }

    public int a(e eVar) {
        int position = this.aif.position();
        o.a(this, eVar.Aen.length);
        o.a(this, eVar.Aeo.length);
        o.a(this, eVar.Aep.length);
        o.a(this, eVar.Aeq.length);
        a(eVar.Aen);
        a(eVar.Aeo);
        a(eVar.Aep);
        a(eVar.Aeq);
        return position;
    }

    private void a(com.tencent.tinker.a.a.e.a[] aVarArr) {
        int i = 0;
        int length = aVarArr.length;
        int i2 = 0;
        while (i < length) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            o.a(this, aVar.Aer - i2);
            i2 = aVar.Aer;
            o.a(this, aVar.Aes);
            i++;
        }
    }

    private void a(e.b[] bVarArr) {
        int i = 0;
        int length = bVarArr.length;
        int i2 = 0;
        while (i < length) {
            e.b bVar = bVarArr[i];
            o.a(this, bVar.Aet - i2);
            i2 = bVar.Aet;
            o.a(this, bVar.Aes);
            o.a(this, bVar.Aeu);
            i++;
        }
    }

    public int a(com.tencent.tinker.a.a.a aVar) {
        int position = this.aif.position();
        writeByte(aVar.Aef);
        a(aVar.Aeg);
        return position;
    }

    public int a(com.tencent.tinker.a.a.b bVar) {
        int position = this.aif.position();
        writeInt(bVar.Aeh.length);
        for (int writeInt : bVar.Aeh) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(c cVar) {
        int position = this.aif.position();
        writeInt(cVar.Aei.length);
        for (int writeInt : cVar.Aei) {
            writeInt(writeInt);
        }
        return position;
    }

    public int a(d dVar) {
        int position = this.aif.position();
        writeInt(dVar.Aej);
        writeInt(dVar.Aek.length);
        writeInt(dVar.Ael.length);
        writeInt(dVar.Aem.length);
        for (int[] iArr : dVar.Aek) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : dVar.Ael) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr22 : dVar.Aem) {
            writeInt(iArr22[0]);
            writeInt(iArr22[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.aif.position();
        write(kVar.data);
        return position;
    }
}
