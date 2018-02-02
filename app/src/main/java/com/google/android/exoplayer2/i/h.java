package com.google.android.exoplayer2.i;

import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class h {
    public static final byte[] aBW = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] aCe = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, DownloadHelper.SAVE_FATOR, 2.0f};
    private static final Object aCf = new Object();
    private static int[] aCg = new int[10];

    public static int h(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        synchronized (aCf) {
            int i4;
            int i5 = 0;
            int i6 = 0;
            while (i6 < i) {
                while (i6 < i - 2) {
                    if (bArr[i6] == (byte) 0 && bArr[i6 + 1] == (byte) 0 && bArr[i6 + 2] == (byte) 3) {
                        break;
                    }
                    i6++;
                }
                i6 = i;
                if (i6 < i) {
                    if (aCg.length <= i5) {
                        aCg = Arrays.copyOf(aCg, aCg.length * 2);
                    }
                    i4 = i5 + 1;
                    aCg[i5] = i6;
                    i6 += 3;
                    i5 = i4;
                }
            }
            i2 = i - i5;
            i6 = 0;
            i4 = 0;
            while (i3 < i5) {
                int i7 = aCg[i3] - i4;
                System.arraycopy(bArr, i4, bArr, i6, i7);
                i6 += i7;
                int i8 = i6 + 1;
                bArr[i6] = (byte) 0;
                i6 = i8 + 1;
                bArr[i8] = (byte) 0;
                i4 += i7 + 3;
                i3++;
            }
            System.arraycopy(bArr, i4, bArr, i6, i2 - i6);
        }
        return i2;
    }

    public static void d(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
    }

    public static boolean a(String str, byte b) {
        return ("video/avc".equals(str) && (b & 31) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39);
    }

    public static int i(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int j(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static b j(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        float f;
        k kVar = new k(bArr, i, i2);
        kVar.cS(8);
        int cT = kVar.cT(8);
        kVar.cS(16);
        int lO = kVar.lO();
        boolean z2 = false;
        if (cT == 100 || cT == 110 || cT == 122 || cT == c$a.CTRL_INDEX || cT == 44 || cT == 83 || cT == 86 || cT == 118 || cT == FileUtils.S_IWUSR || cT == 138) {
            int lO2 = kVar.lO();
            if (lO2 == 3) {
                z2 = kVar.lC();
            }
            kVar.lO();
            kVar.lO();
            kVar.lL();
            if (kVar.lC()) {
                i3 = lO2 != 3 ? 8 : 12;
                i4 = 0;
                while (i4 < i3) {
                    if (kVar.lC()) {
                        int i8 = i4 < 6 ? 16 : 64;
                        i5 = 8;
                        cT = 8;
                        for (i6 = 0; i6 < i8; i6++) {
                            if (i5 != 0) {
                                i5 = ((kVar.lN() + cT) + 256) % 256;
                            }
                            if (i5 != 0) {
                                cT = i5;
                            }
                        }
                    }
                    i4++;
                }
            }
            z = z2;
            i7 = lO2;
        } else {
            z = false;
            i7 = 1;
        }
        i4 = kVar.lO() + 4;
        i6 = kVar.lO();
        int i9 = 0;
        boolean z3 = false;
        if (i6 == 0) {
            i9 = kVar.lO() + 4;
        } else if (i6 == 1) {
            z3 = kVar.lC();
            kVar.lN();
            kVar.lN();
            long lO3 = (long) kVar.lO();
            for (i3 = 0; ((long) i3) < lO3; i3++) {
                kVar.lO();
            }
        }
        kVar.lO();
        kVar.lL();
        cT = kVar.lO() + 1;
        i5 = kVar.lO() + 1;
        boolean lC = kVar.lC();
        i3 = (2 - (lC ? 1 : 0)) * i5;
        if (!lC) {
            kVar.lL();
        }
        kVar.lL();
        cT *= 16;
        i5 = i3 * 16;
        if (kVar.lC()) {
            int lO4 = kVar.lO();
            int lO5 = kVar.lO();
            int lO6 = kVar.lO();
            int lO7 = kVar.lO();
            if (i7 == 0) {
                i3 = 1;
                i7 = 2 - (lC ? 1 : 0);
            } else {
                i3 = i7 == 3 ? 1 : 2;
                i7 = (2 - (lC ? 1 : 0)) * (i7 == 1 ? 2 : 1);
            }
            i3 = cT - (i3 * (lO4 + lO5));
            cT = i5 - (i7 * (lO6 + lO7));
        } else {
            i3 = cT;
            cT = i5;
        }
        float f2 = 1.0f;
        if (kVar.lC() && kVar.lC()) {
            i5 = kVar.cT(8);
            if (i5 == 255) {
                i5 = kVar.cT(16);
                int cT2 = kVar.cT(16);
                if (!(i5 == 0 || cT2 == 0)) {
                    f2 = ((float) i5) / ((float) cT2);
                }
                f = f2;
            } else if (i5 < aCe.length) {
                f = aCe[i5];
            }
            return new b(lO, i3, cT, f, z, lC, i4, i6, i9, z3);
        }
        f = 1.0f;
        return new b(lO, i3, cT, f, z, lC, i4, i6, i9, z3);
    }

    public static a k(byte[] bArr, int i) {
        k kVar = new k(bArr, 3, i);
        kVar.cS(8);
        int lO = kVar.lO();
        int lO2 = kVar.lO();
        kVar.lL();
        return new a(lO, lO2, kVar.lC());
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        int i3 = i2 - i;
        a.an(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                a(zArr);
                return i - 3;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                a(zArr);
                return i - 2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                a(zArr);
                return i - 1;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & i.CTRL_BYTE) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        a(zArr);
                    }
                    return i5 - 2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr == null) {
            return i2;
        }
        boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
        zArr[0] = z2;
        z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i2 - 1] == (byte) 0 : zArr[2] && bArr[i2 - 1] == (byte) 0;
        zArr[1] = z2;
        if (bArr[i2 - 1] != (byte) 0) {
            z = false;
        }
        zArr[2] = z;
        return i2;
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
