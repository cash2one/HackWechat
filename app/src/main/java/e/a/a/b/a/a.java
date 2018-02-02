package e.a.a.b.a;

import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    private InputStream AvC;
    private int AvD = 0;
    private int bfI = 0;
    public int bfJ;
    public int bfK = 0;
    private int bfL = Integer.MAX_VALUE;
    private int bfO = 67108864;
    public byte[] buffer;
    public int bufferSize;

    public final double readDouble() {
        byte rC = rC();
        byte rC2 = rC();
        return Double.longBitsToDouble(((((((((((long) rC2) & 255) << 8) | (((long) rC) & 255)) | ((((long) rC()) & 255) << 16)) | ((((long) rC()) & 255) << 24)) | ((((long) rC()) & 255) << 32)) | ((((long) rC()) & 255) << 40)) | ((((long) rC()) & 255) << 48)) | ((((long) rC()) & 255) << 56));
    }

    public final float readFloat() {
        return Float.intBitsToFloat((((rC() & 255) | ((rC() & 255) << 8)) | ((rC() & 255) << 16)) | ((rC() & 255) << 24));
    }

    public final LinkedList<byte[]> Jl(int i) {
        LinkedList<byte[]> linkedList = new LinkedList();
        int ry = ry();
        try {
            Object obj = new byte[ry];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, ry);
            linkedList.add(obj);
            this.bfJ = ry + this.bfJ;
            ry = this.bfJ;
            if (this.bfJ == this.bufferSize) {
                return linkedList;
            }
            int[] Jm = Jm(ry);
            ry = Jm[0];
            while (e.a.a.b.a.eb(ry) == i) {
                this.bfJ = Jm[1];
                ry = ry();
                obj = new byte[ry];
                System.arraycopy(this.buffer, this.bfJ, obj, 0, ry);
                linkedList.add(obj);
                this.bfJ = ry + this.bfJ;
                if (this.bfJ == this.bufferSize) {
                    break;
                }
                Jm = Jm(this.bfJ);
                ry = Jm[0];
            }
            return linkedList;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("alloc bytes:" + ry);
        }
    }

    public final String readString() {
        int ry = ry();
        if (ry >= this.bufferSize - this.bfJ || ry <= 0) {
            return new String(dT(ry), "UTF-8");
        }
        String str = new String(this.buffer, this.bfJ, ry, "UTF-8");
        this.bfJ = ry + this.bfJ;
        return str;
    }

    private int[] Jm(int i) {
        byte b = this.buffer[i];
        int i2 = i + 1;
        if (b >= (byte) 0) {
            return new int[]{b, i2};
        }
        int i3;
        int i4 = b & 127;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & 127) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & 127) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & 127) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                return new int[]{b2, i3};
                            }
                        }
                        throw b.cJH();
                    }
                }
            }
        }
        return new int[]{i4, i3};
    }

    public final int ry() {
        byte rC = rC();
        if (rC >= (byte) 0) {
            return rC;
        }
        int i = rC & 127;
        byte rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 7);
        }
        i |= (rC2 & 127) << 7;
        rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 14);
        }
        i |= (rC2 & 127) << 14;
        rC2 = rC();
        if (rC2 >= (byte) 0) {
            return i | (rC2 << 21);
        }
        i |= (rC2 & 127) << 21;
        rC2 = rC();
        i |= rC2 << 28;
        if (rC2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (rC() >= (byte) 0) {
                return i;
            }
        }
        throw b.cJH();
    }

    public final long rz() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rC = rC();
            j |= ((long) (rC & 127)) << i;
            if ((rC & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw b.cJH();
    }

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bufferSize = i + 0;
        this.bfJ = 0;
        this.AvC = null;
    }

    public final boolean of(boolean z) {
        if (this.bfJ < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.AvD + this.bufferSize != this.bfL) {
            this.AvD += this.bufferSize;
            this.bfJ = 0;
            this.bufferSize = this.AvC == null ? -1 : this.AvC.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (!z) {
                    return false;
                }
                throw b.cJF();
            }
            this.bufferSize += this.bfI;
            int i = this.AvD + this.bufferSize;
            if (i > this.bfL) {
                this.bfI = i - this.bfL;
                this.bufferSize -= this.bfI;
            } else {
                this.bfI = 0;
            }
            i = (this.AvD + this.bufferSize) + this.bfI;
            if (i <= this.bfO && i >= 0) {
                return true;
            }
            throw b.cJJ();
        } else if (!z) {
            return false;
        } else {
            throw b.cJF();
        }
    }

    private byte rC() {
        if (this.bfJ == this.bufferSize) {
            of(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bfJ;
        this.bfJ = i + 1;
        return bArr[i];
    }

    public final byte[] dT(int i) {
        if (i < 0) {
            throw b.cJG();
        } else if ((this.AvD + this.bfJ) + i > this.bfL) {
            dU((this.bfL - this.AvD) - this.bfJ);
            throw b.cJF();
        } else if (i <= this.bufferSize - this.bfJ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfJ, obj, 0, i);
            this.bfJ += i;
            return obj;
        } else if (i < 2048) {
            Object obj2 = new byte[i];
            r0 = this.bufferSize - this.bfJ;
            System.arraycopy(this.buffer, this.bfJ, obj2, 0, r0);
            this.bfJ = this.bufferSize;
            of(true);
            while (i - r0 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, obj2, r0, this.bufferSize);
                r0 += this.bufferSize;
                this.bfJ = this.bufferSize;
                of(true);
            }
            System.arraycopy(this.buffer, 0, obj2, r0, i - r0);
            this.bfJ = i - r0;
            return obj2;
        } else {
            int read;
            int i2 = this.bfJ;
            int i3 = this.bufferSize;
            this.AvD += this.bufferSize;
            this.bfJ = 0;
            this.bufferSize = 0;
            r0 = i - (i3 - i2);
            LinkedList linkedList = new LinkedList();
            int i4 = r0;
            while (i4 > 0) {
                Object obj3 = new byte[Math.min(i4, 2048)];
                r0 = 0;
                while (r0 < obj3.length) {
                    read = this.AvC == null ? -1 : this.AvC.read(obj3, r0, obj3.length - r0);
                    if (read == -1) {
                        throw b.cJF();
                    }
                    this.AvD += read;
                    r0 += read;
                }
                r0 = i4 - obj3.length;
                linkedList.add(obj3);
                i4 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i3 - i2;
            System.arraycopy(this.buffer, i2, obj4, 0, r0);
            int i5 = r0;
            for (read = 0; read < linkedList.size(); read++) {
                byte[] bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, obj4, i5, bArr.length);
                i5 += bArr.length;
            }
            return obj4;
        }
    }

    private void dU(int i) {
        if (i < 0) {
            throw b.cJG();
        } else if ((this.AvD + this.bfJ) + i > this.bfL) {
            dU((this.bfL - this.AvD) - this.bfJ);
            throw b.cJF();
        } else if (i < this.bufferSize - this.bfJ) {
            this.bfJ += i;
        } else {
            int i2 = this.bufferSize - this.bfJ;
            this.AvD += i2;
            this.bfJ = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.AvC == null ? -1 : (int) this.AvC.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw b.cJF();
                }
                i3 += i2;
                this.AvD = i2 + this.AvD;
            }
        }
    }
}
