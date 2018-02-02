package com.tencent.tmassistantsdk.util;

import com.tencent.tmassistantsdk.util.Base64.Coder;

class Base64$Decoder extends Coder {
    private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int EQUALS = -2;
    private static final int SKIP = -1;
    private final int[] alphabet;
    private int state;
    private int value;

    public Base64$Decoder(int i, byte[] bArr) {
        this.output = bArr;
        this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
        this.state = 0;
        this.value = 0;
    }

    public int maxOutputSize(int i) {
        return ((i * 3) / 4) + 10;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean process(byte[] bArr, int i, int i2, boolean z) {
        if (this.state == 6) {
            return false;
        }
        int i3 = i2 + i;
        int i4 = this.state;
        int i5 = this.value;
        int i6 = 0;
        byte[] bArr2 = this.output;
        int[] iArr = this.alphabet;
        int i7 = i4;
        i4 = i;
        while (i4 < i3) {
            if (i7 == 0) {
                while (i4 + 4 <= i3) {
                    i5 = (((iArr[bArr[i4] & 255] << 18) | (iArr[bArr[i4 + 1] & 255] << 12)) | (iArr[bArr[i4 + 2] & 255] << 6)) | iArr[bArr[i4 + 3] & 255];
                    if (i5 >= 0) {
                        bArr2[i6 + 2] = (byte) i5;
                        bArr2[i6 + 1] = (byte) (i5 >> 8);
                        bArr2[i6] = (byte) (i5 >> 16);
                        i6 += 3;
                        i4 += 4;
                    } else if (i4 >= i3) {
                        i4 = i5;
                        if (z) {
                            switch (i7) {
                                case 1:
                                    this.state = 6;
                                    return false;
                                case 2:
                                    i5 = i6 + 1;
                                    bArr2[i6] = (byte) (i4 >> 4);
                                    i6 = i5;
                                    break;
                                case 3:
                                    i5 = i6 + 1;
                                    bArr2[i6] = (byte) (i4 >> 10);
                                    i6 = i5 + 1;
                                    bArr2[i5] = (byte) (i4 >> 2);
                                    break;
                                case 4:
                                    this.state = 6;
                                    return false;
                            }
                            this.state = i7;
                            this.op = i6;
                            return true;
                        }
                        this.state = i7;
                        this.value = i4;
                        this.op = i6;
                        return true;
                    }
                }
                if (i4 >= i3) {
                    i4 = i5;
                    if (z) {
                        switch (i7) {
                            case 1:
                                this.state = 6;
                                return false;
                            case 2:
                                i5 = i6 + 1;
                                bArr2[i6] = (byte) (i4 >> 4);
                                i6 = i5;
                                break;
                            case 3:
                                i5 = i6 + 1;
                                bArr2[i6] = (byte) (i4 >> 10);
                                i6 = i5 + 1;
                                bArr2[i5] = (byte) (i4 >> 2);
                                break;
                            case 4:
                                this.state = 6;
                                return false;
                        }
                        this.state = i7;
                        this.op = i6;
                        return true;
                    }
                    this.state = i7;
                    this.value = i4;
                    this.op = i6;
                    return true;
                }
            }
            i = i4 + 1;
            i4 = iArr[bArr[i4] & 255];
            switch (i7) {
                case 0:
                    if (i4 >= 0) {
                        i7++;
                        i5 = i4;
                        i4 = i;
                        continue;
                    } else if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                case 1:
                    if (i4 >= 0) {
                        i5 = (i5 << 6) | i4;
                        i7++;
                        i4 = i;
                        continue;
                    } else if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                case 2:
                    if (i4 >= 0) {
                        i5 = (i5 << 6) | i4;
                        i7++;
                        i4 = i;
                        continue;
                    } else if (i4 == -2) {
                        i4 = i6 + 1;
                        bArr2[i6] = (byte) (i5 >> 4);
                        i7 = 4;
                        i6 = i4;
                        i4 = i;
                        break;
                    } else if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                case 3:
                    if (i4 >= 0) {
                        i5 = (i5 << 6) | i4;
                        bArr2[i6 + 2] = (byte) i5;
                        bArr2[i6 + 1] = (byte) (i5 >> 8);
                        bArr2[i6] = (byte) (i5 >> 16);
                        i6 += 3;
                        i7 = 0;
                        i4 = i;
                        continue;
                    } else if (i4 == -2) {
                        bArr2[i6 + 1] = (byte) (i5 >> 2);
                        bArr2[i6] = (byte) (i5 >> 10);
                        i6 += 2;
                        i7 = 5;
                        i4 = i;
                        break;
                    } else if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                case 4:
                    if (i4 == -2) {
                        i7++;
                        i4 = i;
                        continue;
                    } else if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                case 5:
                    if (i4 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i4 = i;
                    break;
            }
            i4 = i;
        }
        i4 = i5;
        if (z) {
            this.state = i7;
            this.value = i4;
            this.op = i6;
            return true;
        }
        switch (i7) {
            case 1:
                this.state = 6;
                return false;
            case 2:
                i5 = i6 + 1;
                bArr2[i6] = (byte) (i4 >> 4);
                i6 = i5;
                break;
            case 3:
                i5 = i6 + 1;
                bArr2[i6] = (byte) (i4 >> 10);
                i6 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 2);
                break;
            case 4:
                this.state = 6;
                return false;
        }
        this.state = i7;
        this.op = i6;
        return true;
    }
}
