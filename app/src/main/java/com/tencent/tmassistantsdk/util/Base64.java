package com.tencent.tmassistantsdk.util;

import com.qq.taf.jce.JceStruct;
import java.io.UnsupportedEncodingException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus());
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            boolean z;
            if (Base64.class.desiredAssertionStatus()) {
                z = false;
            } else {
                z = true;
            }
            $assertionsDisabled = z;
        }

        public Encoder(int i, byte[] bArr) {
            boolean z;
            boolean z2 = true;
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            if ((i & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.do_newline = z;
            if ((i & 4) == 0) {
                z2 = false;
            }
            this.do_cr = z2;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i7 = 0;
            int i8 = this.count;
            int i9 = i2 + i;
            switch (this.tailLen) {
                case 0:
                    i3 = -1;
                    i4 = i;
                    break;
                case 1:
                    if (i + 2 <= i9) {
                        i4 = i + 1;
                        i = i4 + 1;
                        i5 = (((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8)) | (bArr[i4] & 255);
                        this.tailLen = 0;
                        i3 = i5;
                        i4 = i;
                        break;
                    }
                case 2:
                    if (i + 1 <= i9) {
                        i4 = i + 1;
                        i5 = (((this.tail[0] & 255) << 16) | ((this.tail[1] & 255) << 8)) | (bArr[i] & 255);
                        this.tailLen = 0;
                        i3 = i5;
                        break;
                    }
                default:
                    i3 = -1;
                    i4 = i;
                    break;
            }
            if (i3 != -1) {
                bArr3[0] = bArr2[(i3 >> 18) & 63];
                bArr3[1] = bArr2[(i3 >> 12) & 63];
                bArr3[2] = bArr2[(i3 >> 6) & 63];
                i5 = 4;
                bArr3[3] = bArr2[i3 & 63];
                i8--;
                if (i8 == 0) {
                    if (this.do_cr) {
                        i5 = 5;
                        bArr3[4] = JceStruct.SIMPLE_LIST;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                    i6 = 19;
                } else {
                    i6 = i8;
                    i7 = 4;
                }
            } else {
                i6 = i8;
            }
            while (i4 + 3 <= i9) {
                i5 = (((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8)) | (bArr[i4 + 2] & 255);
                bArr3[i7] = bArr2[(i5 >> 18) & 63];
                bArr3[i7 + 1] = bArr2[(i5 >> 12) & 63];
                bArr3[i7 + 2] = bArr2[(i5 >> 6) & 63];
                bArr3[i7 + 3] = bArr2[i5 & 63];
                i8 = i4 + 3;
                i4 = i7 + 4;
                i5 = i6 - 1;
                if (i5 == 0) {
                    if (this.do_cr) {
                        i5 = i4 + 1;
                        bArr3[i4] = JceStruct.SIMPLE_LIST;
                    } else {
                        i5 = i4;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                    i4 = i8;
                    i6 = 19;
                } else {
                    i6 = i5;
                    i7 = i4;
                    i4 = i8;
                }
            }
            if (z) {
                if (i4 - this.tailLen == i9 - 1) {
                    if (this.tailLen > 0) {
                        i8 = 1;
                        i5 = this.tail[0];
                    } else {
                        i8 = i4 + 1;
                        i5 = bArr[i4];
                        i4 = i8;
                        i8 = 0;
                    }
                    i3 = (i5 & 255) << 4;
                    this.tailLen -= i8;
                    i8 = i7 + 1;
                    bArr3[i7] = bArr2[(i3 >> 6) & 63];
                    i5 = i8 + 1;
                    bArr3[i8] = bArr2[i3 & 63];
                    if (this.do_padding) {
                        i8 = i5 + 1;
                        bArr3[i5] = (byte) 61;
                        i5 = i8 + 1;
                        bArr3[i8] = (byte) 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            i8 = i5 + 1;
                            bArr3[i5] = JceStruct.SIMPLE_LIST;
                            i5 = i8;
                        }
                        i8 = i5 + 1;
                        bArr3[i5] = (byte) 10;
                        i5 = i8;
                    }
                    i7 = i5;
                } else if (i4 - this.tailLen == i9 - 2) {
                    if (this.tailLen > 1) {
                        i8 = 1;
                        i5 = this.tail[0];
                    } else {
                        i8 = i4 + 1;
                        i5 = bArr[i4];
                        i4 = i8;
                        i8 = 0;
                    }
                    int i10 = (i5 & 255) << 10;
                    if (this.tailLen > 0) {
                        i3 = i8 + 1;
                        i5 = this.tail[i8];
                        i8 = i3;
                    } else {
                        i3 = i4 + 1;
                        i5 = bArr[i4];
                        i4 = i3;
                    }
                    i5 = ((i5 & 255) << 2) | i10;
                    this.tailLen -= i8;
                    i8 = i7 + 1;
                    bArr3[i7] = bArr2[(i5 >> 12) & 63];
                    i3 = i8 + 1;
                    bArr3[i8] = bArr2[(i5 >> 6) & 63];
                    i8 = i3 + 1;
                    bArr3[i3] = bArr2[i5 & 63];
                    if (this.do_padding) {
                        i5 = i8 + 1;
                        bArr3[i8] = (byte) 61;
                    } else {
                        i5 = i8;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            i8 = i5 + 1;
                            bArr3[i5] = JceStruct.SIMPLE_LIST;
                            i5 = i8;
                        }
                        i8 = i5 + 1;
                        bArr3[i5] = (byte) 10;
                        i5 = i8;
                    }
                    i7 = i5;
                } else if (this.do_newline && i7 > 0 && i6 != 19) {
                    if (this.do_cr) {
                        i5 = i7 + 1;
                        bArr3[i7] = JceStruct.SIMPLE_LIST;
                    } else {
                        i5 = i7;
                    }
                    i7 = i5 + 1;
                    bArr3[i5] = (byte) 10;
                }
                if (!$assertionsDisabled && this.tailLen != 0) {
                    throw new AssertionError();
                } else if (!($assertionsDisabled || r1 == i9)) {
                    throw new AssertionError();
                }
            } else if (i4 == i9 - 1) {
                r0 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                r0[i8] = bArr[i4];
            } else if (i4 == i9 - 2) {
                r0 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                r0[i8] = bArr[i4];
                r0 = this.tail;
                i8 = this.tailLen;
                this.tailLen = i8 + 1;
                r0[i8] = bArr[i4 + 1];
            }
            this.op = i7;
            this.count = i6;
            return true;
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        if (!decoder.process(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (decoder.op == decoder.output.length) {
            return decoder.output;
        } else {
            byte[] bArr2 = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr2, 0, decoder.op);
            return bArr2;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            int i5;
            int i6 = ((i2 - 1) / 57) + 1;
            if (encoder.do_cr) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i4 += i5 * i6;
        }
        encoder.output = new byte[i4];
        encoder.process(bArr, i, i2, true);
        if ($assertionsDisabled || encoder.op == i4) {
            return encoder.output;
        }
        throw new AssertionError();
    }

    private Base64() {
    }
}
