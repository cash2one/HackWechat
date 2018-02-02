package c.t.m.g;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class cf {
    private static byte[] a = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private long[] b = new long[4];
    private long[] c = new long[2];
    private byte[] d = new byte[64];
    private byte[] e = new byte[16];

    public cf() {
        a();
    }

    public static String a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        cf cfVar = new cf();
        cfVar.a();
        cfVar.a(new ByteArrayInputStream(bytes), (long) bytes.length);
        byte[] bArr = new byte[8];
        a(bArr, cfVar.c, 8);
        int i = ((int) (cfVar.c[0] >>> 3)) & 63;
        if (i < 56) {
            i = 56 - i;
        } else {
            i = 120 - i;
        }
        cfVar.a(a, i);
        cfVar.a(bArr, 8);
        a(cfVar.e, cfVar.b, 16);
        bArr = cfVar.e;
        String str2 = "";
        for (i = 0; i < 16; i++) {
            StringBuilder append = new StringBuilder().append(str2);
            byte b = bArr[i];
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            str2 = append.append(new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]})).toString();
        }
        return str2;
    }

    private void a() {
        this.c[0] = 0;
        this.c[1] = 0;
        this.b[0] = 1732584193;
        this.b[1] = 4023233417L;
        this.b[2] = 2562383102L;
        this.b[3] = 271733878;
    }

    private void a(byte[] bArr) {
        long j;
        long j2;
        long j3 = this.b[0];
        long j4 = this.b[1];
        long j5 = this.b[2];
        long j6 = this.b[3];
        long[] jArr = new long[16];
        int i = 0;
        int i2 = 0;
        while (i < 64) {
            byte b = bArr[i];
            if (b < (byte) 0) {
                j = (long) (b & 255);
            } else {
                j = (long) b;
            }
            byte b2 = bArr[i + 1];
            if (b2 < (byte) 0) {
                j2 = (long) (b2 & 255);
            } else {
                j2 = (long) b2;
            }
            j2 = (j2 << 8) | j;
            b = bArr[i + 2];
            if (b < (byte) 0) {
                j = (long) (b & 255);
            } else {
                j = (long) b;
            }
            j2 |= j << 16;
            b = bArr[i + 3];
            if (b < (byte) 0) {
                j = (long) (b & 255);
            } else {
                j = (long) b;
            }
            jArr[i2] = (j << 24) | j2;
            i += 4;
            i2++;
        }
        j = a(j3, j4, j5, j6, jArr[0], 7, 3614090360L);
        j6 = a(j6, j, j4, j5, jArr[1], 12, 3905402710L);
        j5 = a(j5, j6, j, j4, jArr[2], 17, 606105819);
        j2 = a(j4, j5, j6, j, jArr[3], 22, 3250441966L);
        j = a(j, j2, j5, j6, jArr[4], 7, 4118548399L);
        j6 = a(j6, j, j2, j5, jArr[5], 12, 1200080426);
        long a = a(j5, j6, j, j2, jArr[6], 17, 2821735955L);
        j2 = a(j2, a, j6, j, jArr[7], 22, 4249261313L);
        j = a(j, j2, a, j6, jArr[8], 7, 1770035416);
        long a2 = a(j6, j, j2, a, jArr[9], 12, 2336552879L);
        a = a(a, a2, j, j2, jArr[10], 17, 4294925233L);
        j2 = a(j2, a, a2, j, jArr[11], 22, 2304563134L);
        long a3 = a(j, j2, a, a2, jArr[12], 7, 1804603682);
        a2 = a(a2, a3, j2, a, jArr[13], 12, 4254626195L);
        a = a(a, a2, a3, j2, jArr[14], 17, 2792965006L);
        long a4 = a(j2, a, a2, a3, jArr[15], 22, 1236535329);
        a3 = b(a3, a4, a, a2, jArr[1], 5, 4129170786L);
        a2 = b(a2, a3, a4, a, jArr[6], 9, 3225465664L);
        long b3 = b(a, a2, a3, a4, jArr[11], 14, 643717713);
        a4 = b(a4, b3, a2, a3, jArr[0], 20, 3921069994L);
        a3 = b(a3, a4, b3, a2, jArr[5], 5, 3593408605L);
        long b4 = b(a2, a3, a4, b3, jArr[10], 9, 38016083);
        b3 = b(b3, b4, a3, a4, jArr[15], 14, 3634488961L);
        a4 = b(a4, b3, b4, a3, jArr[4], 20, 3889429448L);
        long b5 = b(a3, a4, b3, b4, jArr[9], 5, 568446438);
        b4 = b(b4, b5, a4, b3, jArr[14], 9, 3275163606L);
        b3 = b(b3, b4, b5, a4, jArr[3], 14, 4107603335L);
        long b6 = b(a4, b3, b4, b5, jArr[8], 20, 1163531501);
        b5 = b(b5, b6, b3, b4, jArr[13], 5, 2850285829L);
        b4 = b(b4, b5, b6, b3, jArr[2], 9, 4243563512L);
        long b7 = b(b3, b4, b5, b6, jArr[7], 14, 1735328473);
        b6 = b(b6, b7, b4, b5, jArr[12], 20, 2368359562L);
        b5 = c(b5, b6, b7, b4, jArr[5], 4, 4294588738L);
        long c = c(b4, b5, b6, b7, jArr[8], 11, 2272392833L);
        b7 = c(b7, c, b5, b6, jArr[11], 16, 1839030562);
        b6 = c(b6, b7, c, b5, jArr[14], 23, 4259657740L);
        long c2 = c(b5, b6, b7, c, jArr[1], 4, 2763975236L);
        c = c(c, c2, b6, b7, jArr[4], 11, 1272893353);
        b7 = c(b7, c, c2, b6, jArr[7], 16, 4139469664L);
        long c3 = c(b6, b7, c, c2, jArr[10], 23, 3200236656L);
        c2 = c(c2, c3, b7, c, jArr[13], 4, 681279174);
        c = c(c, c2, c3, b7, jArr[0], 11, 3936430074L);
        long c4 = c(b7, c, c2, c3, jArr[3], 16, 3572445317L);
        c3 = c(c3, c4, c, c2, jArr[6], 23, 76029189);
        c2 = c(c2, c3, c4, c, jArr[9], 4, 3654602809L);
        long c5 = c(c, c2, c3, c4, jArr[12], 11, 3873151461L);
        c4 = c(c4, c5, c2, c3, jArr[15], 16, 530742520);
        c3 = c(c3, c4, c5, c2, jArr[2], 23, 3299628645L);
        long d = d(c2, c3, c4, c5, jArr[0], 6, 4096336452L);
        c5 = d(c5, d, c3, c4, jArr[7], 10, 1126891415);
        c4 = d(c4, c5, d, c3, jArr[14], 15, 2878612391L);
        long d2 = d(c3, c4, c5, d, jArr[5], 21, 4237533241L);
        d = d(d, d2, c4, c5, jArr[12], 6, 1700485571);
        c5 = d(c5, d, d2, c4, jArr[3], 10, 2399980690L);
        long d3 = d(c4, c5, d, d2, jArr[10], 15, 4293915773L);
        d2 = d(d2, d3, c5, d, jArr[1], 21, 2240044497L);
        d = d(d, d2, d3, c5, jArr[8], 6, 1873313359);
        long d4 = d(c5, d, d2, d3, jArr[15], 10, 4264355552L);
        d3 = d(d3, d4, d, d2, jArr[6], 15, 2734768916L);
        d2 = d(d2, d3, d4, d, jArr[13], 21, 1309151649);
        long d5 = d(d, d2, d3, d4, jArr[4], 6, 4149444226L);
        d4 = d(d4, d5, d2, d3, jArr[11], 10, 3174756917L);
        d3 = d(d3, d4, d5, d2, jArr[2], 15, 718787259);
        j3 = d(d2, d3, d4, d5, jArr[9], 21, 3951481745L);
        long[] jArr2 = this.b;
        jArr2[0] = jArr2[0] + d5;
        jArr2 = this.b;
        jArr2[1] = j3 + jArr2[1];
        long[] jArr3 = this.b;
        jArr3[2] = jArr3[2] + d3;
        jArr3 = this.b;
        jArr3[3] = jArr3[3] + d4;
    }

    private void a(byte[] bArr, int i) {
        int i2 = 0;
        byte[] bArr2 = new byte[64];
        int i3 = ((int) (this.c[0] >>> 3)) & 63;
        long[] jArr = this.c;
        long j = jArr[0] + ((long) (i << 3));
        jArr[0] = j;
        if (j < ((long) (i << 3))) {
            jArr = this.c;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.c;
        jArr[1] = jArr[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            byte[] bArr3 = this.d;
            for (int i5 = 0; i5 < i4; i5++) {
                bArr3[i3 + i5] = bArr[i5];
            }
            a(this.d);
            i3 = i4;
            while (i3 + 63 < i) {
                for (i4 = 0; i4 < 64; i4++) {
                    bArr2[i4] = bArr[i3 + i4];
                }
                a(bArr2);
                i3 += 64;
            }
            i4 = 0;
        } else {
            i4 = i3;
            i3 = 0;
        }
        byte[] bArr4 = this.d;
        int i6 = i - i3;
        while (i2 < i6) {
            bArr4[i4 + i2] = bArr[i3 + i2];
            i2++;
        }
    }

    private static void a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            bArr[i2] = (byte) ((int) (jArr[i3] & 255));
            bArr[i2 + 1] = (byte) ((int) ((jArr[i3] >>> 8) & 255));
            bArr[i2 + 2] = (byte) ((int) ((jArr[i3] >>> 16) & 255));
            bArr[i2 + 3] = (byte) ((int) ((jArr[i3] >>> 24) & 255));
            i3++;
            i2 += 4;
        }
    }

    private boolean a(InputStream inputStream, long j) {
        int i = 0;
        byte[] bArr = new byte[64];
        int i2 = ((int) (this.c[0] >>> 3)) & 63;
        long[] jArr = this.c;
        long j2 = jArr[0] + (j << 3);
        jArr[0] = j2;
        if (j2 < (j << 3)) {
            jArr = this.c;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.c;
        jArr[1] = jArr[1] + (j >>> 29);
        int i3 = 64 - i2;
        if (j >= ((long) i3)) {
            byte[] bArr2 = new byte[i3];
            try {
                inputStream.read(bArr2, 0, i3);
                byte[] bArr3 = this.d;
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr3[i2 + i4] = bArr2[i4];
                }
                a(this.d);
                i2 = i3;
                while (((long) (i2 + 63)) < j) {
                    try {
                        inputStream.read(bArr);
                        a(bArr);
                        i2 += 64;
                    } catch (Exception e) {
                        return false;
                    }
                }
                i3 = 0;
            } catch (Exception e2) {
                return false;
            }
        }
        i3 = i2;
        i2 = 0;
        byte[] bArr4 = new byte[((int) (j - ((long) i2)))];
        try {
            inputStream.read(bArr4);
            byte[] bArr5 = this.d;
            int length = bArr4.length;
            while (i < length) {
                bArr5[i3 + i] = bArr4[i];
                i++;
            }
            return true;
        } catch (Exception e3) {
            return false;
        }
    }

    private static long a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j3) | ((-1 ^ j2) & j4)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j4) | ((-1 ^ j4) & j3)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 ^ j3) ^ j4) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    private static long d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = (((((-1 ^ j4) | j2) ^ j3) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }
}
