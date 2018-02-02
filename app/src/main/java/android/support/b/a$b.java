package android.support.b;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

class a$b extends FilterOutputStream {
    ByteOrder ow;
    private final OutputStream ox;

    public a$b(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.ox = outputStream;
        this.ow = byteOrder;
    }

    public final void write(byte[] bArr) {
        this.ox.write(bArr);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.ox.write(bArr, i, i2);
    }

    public final void writeByte(int i) {
        this.ox.write(i);
    }

    public final void writeShort(short s) {
        if (this.ow == ByteOrder.LITTLE_ENDIAN) {
            this.ox.write((s >>> 0) & 255);
            this.ox.write((s >>> 8) & 255);
        } else if (this.ow == ByteOrder.BIG_ENDIAN) {
            this.ox.write((s >>> 8) & 255);
            this.ox.write((s >>> 0) & 255);
        }
    }

    public final void writeInt(int i) {
        if (this.ow == ByteOrder.LITTLE_ENDIAN) {
            this.ox.write((i >>> 0) & 255);
            this.ox.write((i >>> 8) & 255);
            this.ox.write((i >>> 16) & 255);
            this.ox.write((i >>> 24) & 255);
        } else if (this.ow == ByteOrder.BIG_ENDIAN) {
            this.ox.write((i >>> 24) & 255);
            this.ox.write((i >>> 16) & 255);
            this.ox.write((i >>> 8) & 255);
            this.ox.write((i >>> 0) & 255);
        }
    }
}
