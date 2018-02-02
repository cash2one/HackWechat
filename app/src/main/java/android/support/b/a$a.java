package android.support.b;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

class a$a extends InputStream implements DataInput {
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private final int mLength;
    int mPosition;
    private DataInputStream ov;
    ByteOrder ow;

    public a$a(InputStream inputStream) {
        this.ow = ByteOrder.BIG_ENDIAN;
        this.ov = new DataInputStream(inputStream);
        this.mLength = this.ov.available();
        this.mPosition = 0;
        this.ov.mark(this.mLength);
    }

    public a$a(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    public final void seek(long j) {
        if (((long) this.mPosition) > j) {
            this.mPosition = 0;
            this.ov.reset();
            this.ov.mark(this.mLength);
        } else {
            j -= (long) this.mPosition;
        }
        if (skipBytes((int) j) != ((int) j)) {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    public final int available() {
        return this.ov.available();
    }

    public final int read() {
        this.mPosition++;
        return this.ov.read();
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = this.ov.read(bArr, i, i2);
        this.mPosition += read;
        return read;
    }

    public final int readUnsignedByte() {
        this.mPosition++;
        return this.ov.readUnsignedByte();
    }

    public final String readLine() {
        return null;
    }

    public final boolean readBoolean() {
        this.mPosition++;
        return this.ov.readBoolean();
    }

    public final char readChar() {
        this.mPosition += 2;
        return this.ov.readChar();
    }

    public final String readUTF() {
        this.mPosition += 2;
        return this.ov.readUTF();
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        this.mPosition += i2;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        } else if (this.ov.read(bArr, i, i2) != i2) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    public final void readFully(byte[] bArr) {
        this.mPosition += bArr.length;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        } else if (this.ov.read(bArr, 0, bArr.length) != bArr.length) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    public final byte readByte() {
        this.mPosition++;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        }
        int read = this.ov.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public final short readShort() {
        this.mPosition += 2;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        }
        int read = this.ov.read();
        int read2 = this.ov.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        } else if (this.ow == LITTLE_ENDIAN) {
            return (short) (read + (read2 << 8));
        } else {
            if (this.ow == BIG_ENDIAN) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.ow);
        }
    }

    public final int readInt() {
        this.mPosition += 4;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        }
        int read = this.ov.read();
        int read2 = this.ov.read();
        int read3 = this.ov.read();
        int read4 = this.ov.read();
        if ((((read | read2) | read3) | read4) < 0) {
            throw new EOFException();
        } else if (this.ow == LITTLE_ENDIAN) {
            return read + ((read2 << 8) + ((read3 << 16) + (read4 << 24)));
        } else if (this.ow == BIG_ENDIAN) {
            return (((read << 24) + (read2 << 16)) + (read3 << 8)) + read4;
        } else {
            throw new IOException("Invalid byte order: " + this.ow);
        }
    }

    public final int skipBytes(int i) {
        int min = Math.min(i, this.mLength - this.mPosition);
        int i2 = 0;
        while (i2 < min) {
            i2 += this.ov.skipBytes(min - i2);
        }
        this.mPosition += i2;
        return i2;
    }

    public final int readUnsignedShort() {
        this.mPosition += 2;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        }
        int read = this.ov.read();
        int read2 = this.ov.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        } else if (this.ow == LITTLE_ENDIAN) {
            return read + (read2 << 8);
        } else {
            if (this.ow == BIG_ENDIAN) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.ow);
        }
    }

    public final long aK() {
        return ((long) readInt()) & 4294967295L;
    }

    public final long readLong() {
        this.mPosition += 8;
        if (this.mPosition > this.mLength) {
            throw new EOFException();
        }
        int read = this.ov.read();
        int read2 = this.ov.read();
        int read3 = this.ov.read();
        int read4 = this.ov.read();
        int read5 = this.ov.read();
        int read6 = this.ov.read();
        int read7 = this.ov.read();
        int read8 = this.ov.read();
        if ((((((((read | read2) | read3) | read4) | read5) | read6) | read7) | read8) < 0) {
            throw new EOFException();
        } else if (this.ow == LITTLE_ENDIAN) {
            return ((long) read) + (((((long) read3) << 16) + (((((long) read5) << 32) + (((((long) read7) << 48) + (((long) read8) << 56)) + (((long) read6) << 40))) + (((long) read4) << 24))) + (((long) read2) << 8));
        } else if (this.ow == BIG_ENDIAN) {
            return (((((((((long) read2) << 48) + (((long) read) << 56)) + (((long) read3) << 40)) + (((long) read4) << 32)) + (((long) read5) << 24)) + (((long) read6) << 16)) + (((long) read7) << 8)) + ((long) read8);
        } else {
            throw new IOException("Invalid byte order: " + this.ow);
        }
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }
}
