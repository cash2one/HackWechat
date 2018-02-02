package com.tencent.tinker.d.a;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h extends FilterOutputStream {
    public static final byte[] Amk = new byte[0];
    private static final byte[] Aml = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private final HashSet<String> Amm;
    private final boolean Amn;
    public byte[] Amo;
    private int Amp;
    private ByteArrayOutputStream Amq;
    private f Amr;
    private byte[] Ams;
    private byte[] Amt;
    private boolean Amu;
    private long oJ;

    public h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.Amm = new HashSet();
        this.Amo = Amk;
        this.Amp = 8;
        this.Amq = new ByteArrayOutputStream();
        this.oJ = 0;
        this.Amn = false;
    }

    private static long a(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int b(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.Amq != null) {
            if (this.Amm.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.Amr != null) {
                closeEntry();
            }
            int size = this.Amq.size();
            a(this.Amq, 101010256);
            b(this.Amq, 0);
            b(this.Amq, 0);
            if (this.Amu) {
                b(this.Amq, 65535);
                b(this.Amq, 65535);
                a(this.Amq, -1);
                a(this.Amq, -1);
            } else {
                b(this.Amq, this.Amm.size());
                b(this.Amq, this.Amm.size());
                a(this.Amq, (long) size);
                a(this.Amq, this.oJ);
            }
            b(this.Amq, this.Amo.length);
            if (this.Amo.length > 0) {
                this.Amq.write(this.Amo);
            }
            this.Amq.writeTo(this.out);
            this.Amq = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        cHo();
        if (this.Amr != null) {
            long j = 30;
            if (this.Amr.Amb != 0) {
                j = 46;
                a(this.out, 134695760);
                a(this.out, this.Amr.AlP);
                a(this.out, this.Amr.Ama);
                a(this.out, this.Amr.size);
            }
            int i = (this.Amr.Amb == 0 ? 0 : 8) | 2048;
            a(this.Amq, 33639248);
            b(this.Amq, 20);
            b(this.Amq, 20);
            b(this.Amq, i);
            b(this.Amq, this.Amr.Amb);
            b(this.Amq, this.Amr.time);
            b(this.Amq, this.Amr.Amc);
            a(this.Amq, this.Amr.AlP);
            if (this.Amr.Amb == 8) {
                j += this.Amr.Ama;
            } else {
                j += this.Amr.size;
            }
            a(this.Amq, this.Amr.Ama);
            a(this.Amq, this.Amr.size);
            j += (long) b(this.Amq, this.Ams.length);
            if (this.Amr.Amd != null) {
                j += (long) b(this.Amq, this.Amr.Amd.length);
            } else {
                b(this.Amq, 0);
            }
            b(this.Amq, this.Amt.length);
            b(this.Amq, 0);
            b(this.Amq, 0);
            a(this.Amq, 0);
            a(this.Amq, this.Amr.Ame);
            this.Amq.write(this.Ams);
            this.Ams = null;
            if (this.Amr.Amd != null) {
                this.Amq.write(this.Amr.Amd);
            }
            this.oJ = j + this.oJ;
            if (this.Amt.length > 0) {
                this.Amq.write(this.Amt);
                this.Amt = Amk;
            }
            this.Amr = null;
        }
    }

    public final void b(f fVar) {
        int i;
        if (this.Amr != null) {
            closeEntry();
        }
        int i2 = fVar.Amb;
        if (i2 == -1) {
            i = this.Amp;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.Ama == -1) {
                fVar.Ama = fVar.size;
            } else if (fVar.size == -1) {
                fVar.setSize(fVar.Ama);
            }
            if (fVar.AlP == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.size != fVar.Ama) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        cHo();
        fVar.wLD = null;
        fVar.Amd = null;
        fVar.time = 40691;
        fVar.Amc = 18698;
        this.Ams = fVar.name.getBytes(d.UTF_8);
        x("Name", this.Ams);
        this.Amt = Amk;
        if (fVar.wLD != null) {
            this.Amt = fVar.wLD.getBytes(d.UTF_8);
            x("Comment", this.Amt);
        }
        fVar.setMethod(i);
        this.Amr = fVar;
        this.Amr.Ame = this.oJ;
        this.Amm.add(this.Amr.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        a(this.out, 67324752);
        b(this.out, 20);
        b(this.out, i2);
        b(this.out, i);
        b(this.out, this.Amr.time);
        b(this.out, this.Amr.Amc);
        if (i == 0) {
            a(this.out, this.Amr.AlP);
            a(this.out, this.Amr.size);
            a(this.out, this.Amr.size);
        } else {
            a(this.out, 0);
            a(this.out, 0);
            a(this.out, 0);
        }
        b(this.out, this.Ams.length);
        if (this.Amr.Amd != null) {
            b(this.out, this.Amr.Amd.length);
        } else {
            b(this.out, 0);
        }
        this.out.write(this.Ams);
        if (this.Amr.Amd != null) {
            this.out.write(this.Amr.Amd);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        a.an(bArr.length, i, i2);
        if (this.Amr == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void cHo() {
        if (this.Amq == null) {
            throw new IOException("Stream is closed");
        }
    }

    public static void x(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
