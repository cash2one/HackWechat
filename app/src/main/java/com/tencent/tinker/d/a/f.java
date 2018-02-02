package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f implements Cloneable {
    public long AlP = -1;
    long Ama = -1;
    int Amb = -1;
    int Amc = -1;
    byte[] Amd;
    long Ame = -1;
    long Amf = -1;
    public String name;
    long size = -1;
    int time = -1;
    String wLD;

    public f(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        String str2 = "Name";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length > 65535) {
            throw new IllegalArgumentException(str2 + " too long: " + bytes.length);
        }
        this.name = str;
    }

    public f(f fVar) {
        this.name = fVar.name;
        this.wLD = fVar.wLD;
        this.time = fVar.time;
        this.size = fVar.size;
        this.Ama = fVar.Ama;
        this.AlP = fVar.AlP;
        this.Amb = fVar.Amb;
        this.Amc = fVar.Amc;
        this.Amd = fVar.Amd;
        this.Ame = fVar.Ame;
        this.Amf = fVar.Amf;
    }

    public f(f fVar, String str) {
        this.name = str;
        this.wLD = fVar.wLD;
        this.time = fVar.time;
        this.size = fVar.size;
        this.Ama = fVar.Ama;
        this.AlP = fVar.AlP;
        this.Amb = fVar.Amb;
        this.Amc = fVar.Amc;
        this.Amd = fVar.Amd;
        this.Ame = fVar.Ame;
        this.Amf = fVar.Amf;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) {
        e.b(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            g.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a.seek(8);
        int readShort = a.readShort() & 65535;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + readShort);
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.Amb = a.readShort() & 65535;
        this.time = a.readShort() & 65535;
        this.Amc = a.readShort() & 65535;
        this.AlP = ((long) a.readInt()) & 4294967295L;
        this.Ama = ((long) a.readInt()) & 4294967295L;
        this.size = ((long) a.readInt()) & 4294967295L;
        readShort = a.readShort() & 65535;
        int readShort2 = a.readShort() & 65535;
        int readShort3 = a.readShort() & 65535;
        a.seek(42);
        this.Ame = ((long) a.readInt()) & 4294967295L;
        byte[] bArr2 = new byte[readShort];
        e.b(inputStream, bArr2, 0, bArr2.length);
        if (bR(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.Amd = new byte[readShort2];
            e.b(inputStream, this.Amd, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            e.b(inputStream, bArr2, 0, readShort3);
            this.wLD = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean bR(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.Amb = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    public final void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.size = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.wLD);
        stringBuffer.append("\ntime:" + this.time);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.Ama);
        stringBuffer.append("\ncrc:" + this.AlP);
        stringBuffer.append("\ncompressionMethod:" + this.Amb);
        stringBuffer.append("\nmodDate:" + this.Amc);
        stringBuffer.append("\nextra length:" + this.Amd.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.Ame);
        stringBuffer.append("\ndataOffset:" + this.Amf);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.Amd = this.Amd != null ? (byte[]) this.Amd.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
