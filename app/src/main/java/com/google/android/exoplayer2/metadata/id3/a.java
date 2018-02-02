package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public static final int amF = t.ak("ID3");
    private final a aqO;

    public a() {
        this(null);
    }

    public a(a aVar) {
        this.aqO = aVar;
    }

    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.aif;
        return b(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata b(byte[] bArr, int i) {
        b bVar;
        int readUnsignedByte;
        int lH;
        int readInt;
        boolean z = true;
        List arrayList = new ArrayList();
        j jVar = new j(bArr, i);
        if (jVar.lF() < 10) {
            bVar = null;
        } else if (jVar.lG() != amF) {
            bVar = null;
        } else {
            int i2;
            readUnsignedByte = jVar.readUnsignedByte();
            jVar.cV(1);
            int readUnsignedByte2 = jVar.readUnsignedByte();
            lH = jVar.lH();
            if (readUnsignedByte == 2) {
                if ((readUnsignedByte2 & 64) != 0) {
                    bVar = null;
                } else {
                    i2 = lH;
                }
            } else if (readUnsignedByte == 3) {
                if ((readUnsignedByte2 & 64) != 0) {
                    readInt = jVar.readInt();
                    jVar.cV(readInt);
                    lH -= readInt + 4;
                }
                i2 = lH;
            } else if (readUnsignedByte == 4) {
                if ((readUnsignedByte2 & 64) != 0) {
                    readInt = jVar.lH();
                    jVar.cV(readInt - 4);
                    lH -= readInt;
                }
                if ((readUnsignedByte2 & 16) != 0) {
                    lH -= 10;
                }
                i2 = lH;
            } else {
                bVar = null;
            }
            boolean z2 = readUnsignedByte < 4 && (readUnsignedByte2 & FileUtils.S_IWUSR) != 0;
            bVar = new b(readUnsignedByte, z2, i2);
        }
        if (bVar == null) {
            return null;
        }
        readUnsignedByte = jVar.position;
        lH = bVar.aqP == 2 ? 6 : 10;
        readInt = bVar.aqR;
        if (bVar.aqQ) {
            readInt = d(jVar, bVar.aqR);
        }
        jVar.cU(readInt + readUnsignedByte);
        if (a(jVar, bVar.aqP, lH, false)) {
            z = false;
        } else if (!(bVar.aqP == 4 && a(jVar, 4, lH, true))) {
            new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(bVar.aqP);
            return null;
        }
        while (jVar.lF() >= lH) {
            Id3Frame a = a(bVar.aqP, jVar, z, lH, this.aqO);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return new Metadata(arrayList);
    }

    private static boolean a(j jVar, int i, int i2, boolean z) {
        int i3 = jVar.position;
        while (jVar.lF() >= i2) {
            int readUnsignedShort;
            int readInt;
            long j;
            long aK;
            if (i >= 3) {
                aK = jVar.aK();
                readUnsignedShort = jVar.readUnsignedShort();
                readInt = jVar.readInt();
                j = aK;
            } else {
                aK = (long) jVar.lG();
                readUnsignedShort = 0;
                readInt = jVar.lG();
                j = aK;
            }
            if (readInt == 0 && j == 0 && readUnsignedShort == 0) {
                jVar.cR(i3);
                return true;
            }
            long j2;
            Object obj;
            Object obj2;
            if (i != 4 || z) {
                j2 = j;
            } else if ((8421504 & j) != 0) {
                jVar.cR(i3);
                return false;
            } else {
                j2 = (((j >> 24) & 255) << 21) | (((255 & j) | (((j >> 8) & 255) << 7)) | (((j >> 16) & 255) << 14));
            }
            Object obj3;
            if (i == 4) {
                obj = (readUnsignedShort & 64) != 0 ? 1 : null;
                obj3 = (readUnsignedShort & 1) != 0 ? 1 : null;
                obj2 = obj;
                obj = obj3;
            } else if (i == 3) {
                obj = (readUnsignedShort & 32) != 0 ? 1 : null;
                obj3 = (readUnsignedShort & FileUtils.S_IWUSR) != 0 ? 1 : null;
                obj2 = obj;
                obj = obj3;
            } else {
                obj2 = null;
                obj = null;
            }
            int i4 = 0;
            if (obj2 != null) {
                i4 = 1;
            }
            if (obj != null) {
                i4 += 4;
            }
            if (j2 < ((long) i4)) {
                jVar.cR(i3);
                return false;
            } else if (((long) jVar.lF()) < j2) {
                return false;
            } else {
                try {
                    jVar.cV((int) j2);
                } finally {
                    jVar.cR(i3);
                }
            }
        }
        jVar.cR(i3);
        return true;
    }

    private static Id3Frame a(int i, j jVar, boolean z, int i2, a aVar) {
        int lI;
        int readUnsignedByte = jVar.readUnsignedByte();
        int readUnsignedByte2 = jVar.readUnsignedByte();
        int readUnsignedByte3 = jVar.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? jVar.readUnsignedByte() : 0;
        if (i == 4) {
            lI = jVar.lI();
            if (!z) {
                lI = (((lI & 255) | (((lI >> 8) & 255) << 7)) | (((lI >> 16) & 255) << 14)) | (((lI >> 24) & 255) << 21);
            }
        } else if (i == 3) {
            lI = jVar.lI();
        } else {
            lI = jVar.lG();
        }
        int readUnsignedShort = i >= 3 ? jVar.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && lI == 0 && readUnsignedShort == 0) {
            jVar.cR(jVar.asN);
            return null;
        }
        int i3 = jVar.position + lI;
        if (i3 > jVar.asN) {
            jVar.cR(jVar.asN);
            return null;
        } else if (aVar == null || aVar.f(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            if (i == 3) {
                obj5 = (readUnsignedShort & FileUtils.S_IWUSR) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 64) != 0 ? 1 : null;
                if ((readUnsignedShort & 32) != 0) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                obj = obj5;
                Object obj6 = obj4;
                obj4 = obj5;
                obj5 = obj6;
            } else if (i == 4) {
                obj5 = (readUnsignedShort & 64) != 0 ? 1 : null;
                obj = (readUnsignedShort & 8) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 4) != 0 ? 1 : null;
                obj3 = (readUnsignedShort & 2) != 0 ? 1 : null;
                obj4 = (readUnsignedShort & 1) != 0 ? 1 : null;
            }
            if (obj == null && r8 == null) {
                int i4;
                Id3Frame id3Frame;
                if (obj5 != null) {
                    i4 = lI - 1;
                    jVar.cV(1);
                } else {
                    i4 = lI;
                }
                if (obj4 != null) {
                    i4 -= 4;
                    jVar.cV(4);
                }
                if (obj3 != null) {
                    i4 = d(jVar, i4);
                }
                int readUnsignedByte5;
                String cy;
                byte[] bArr;
                int g;
                String str;
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i4 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cy = cy(readUnsignedByte5);
                        bArr = new byte[(i4 - 1)];
                        jVar.readBytes(bArr, 0, i4 - 1);
                        g = g(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, g, cy);
                        g += cz(readUnsignedByte5);
                        if (g < bArr.length) {
                            cy = new String(bArr, g, g(bArr, g, readUnsignedByte5) - g, cy);
                        } else {
                            cy = "";
                        }
                        id3Frame = new TextInformationFrame("TXXX", str, cy);
                    }
                } else if (readUnsignedByte == 84) {
                    cy = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    if (i4 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        String cy2 = cy(readUnsignedByte5);
                        byte[] bArr2 = new byte[(i4 - 1)];
                        jVar.readBytes(bArr2, 0, i4 - 1);
                        id3Frame = new TextInformationFrame(cy, null, new String(bArr2, 0, g(bArr2, 0, readUnsignedByte5), cy2));
                    }
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i4 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cy = cy(readUnsignedByte5);
                        bArr = new byte[(i4 - 1)];
                        jVar.readBytes(bArr, 0, i4 - 1);
                        g = g(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, g, cy);
                        r2 = g + cz(readUnsignedByte5);
                        id3Frame = new UrlLinkFrame("WXXX", str, r2 < bArr.length ? new String(bArr, r2, c(bArr, r2) - r2, "ISO-8859-1") : "");
                    }
                } else if (readUnsignedByte == 87) {
                    cy = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    r1 = new byte[i4];
                    jVar.readBytes(r1, 0, i4);
                    id3Frame = new UrlLinkFrame(cy, null, new String(r1, 0, c(r1, 0), "ISO-8859-1"));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    r1 = new byte[i4];
                    jVar.readBytes(r1, 0, i4);
                    r2 = c(r1, 0);
                    id3Frame = new PrivFrame(new String(r1, 0, r2, "ISO-8859-1"), h(r1, r2 + 1, r1.length));
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    readUnsignedByte5 = jVar.readUnsignedByte();
                    cy = cy(readUnsignedByte5);
                    bArr = new byte[(i4 - 1)];
                    jVar.readBytes(bArr, 0, i4 - 1);
                    g = c(bArr, 0);
                    str = new String(bArr, 0, g, "ISO-8859-1");
                    g++;
                    readUnsignedShort = g(bArr, g, readUnsignedByte5);
                    String str2 = new String(bArr, g, readUnsignedShort - g, cy);
                    g = cz(readUnsignedByte5) + readUnsignedShort;
                    readUnsignedShort = g(bArr, g, readUnsignedByte5);
                    id3Frame = new GeobFrame(str, str2, new String(bArr, g, readUnsignedShort - g, cy), h(bArr, cz(readUnsignedByte5) + readUnsignedShort, bArr.length));
                } else if (!i != 2 ? !(readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) : !(readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67)) {
                    int readUnsignedByte6 = jVar.readUnsignedByte();
                    r9 = cy(readUnsignedByte6);
                    byte[] bArr3 = new byte[(i4 - 1)];
                    jVar.readBytes(bArr3, 0, i4 - 1);
                    if (i == 2) {
                        readUnsignedByte5 = 2;
                        cy = "image/" + t.ai(new String(bArr3, 0, 3, "ISO-8859-1"));
                        if (cy.equals("image/jpg")) {
                            cy = "image/jpeg";
                        }
                    } else {
                        readUnsignedByte5 = c(bArr3, 0);
                        cy = t.ai(new String(bArr3, 0, readUnsignedByte5, "ISO-8859-1"));
                        if (cy.indexOf(47) == -1) {
                            cy = "image/" + cy;
                        }
                    }
                    readUnsignedShort = bArr3[readUnsignedByte5 + 1] & 255;
                    readUnsignedByte5 += 2;
                    int g2 = g(bArr3, readUnsignedByte5, readUnsignedByte6);
                    id3Frame = new ApicFrame(cy, new String(bArr3, readUnsignedByte5, g2 - readUnsignedByte5, r9), readUnsignedShort, h(bArr3, cz(readUnsignedByte6) + g2, bArr3.length));
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) {
                    if (i4 < 4) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cy = cy(readUnsignedByte5);
                        bArr = new byte[3];
                        jVar.readBytes(bArr, 0, 3);
                        r9 = new String(bArr, 0, 3);
                        bArr = new byte[(i4 - 4)];
                        jVar.readBytes(bArr, 0, i4 - 4);
                        lI = g(bArr, 0, readUnsignedByte5);
                        String str3 = new String(bArr, 0, lI, cy);
                        lI += cz(readUnsignedByte5);
                        id3Frame = new CommentFrame(r9, str3, lI < bArr.length ? new String(bArr, lI, g(bArr, lI, readUnsignedByte5) - lI, cy) : "");
                    }
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                    id3Frame = a(jVar, i4, i, z, i2, aVar);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                    id3Frame = b(jVar, i4, i, z, i2, aVar);
                } else {
                    cy = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr = new byte[i4];
                    jVar.readBytes(bArr, 0, i4);
                    id3Frame = new BinaryFrame(cy, bArr);
                }
                if (id3Frame == null) {
                    try {
                        new StringBuilder("Failed to decode frame: id=").append(g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)).append(", frameSize=").append(i4);
                    } catch (UnsupportedEncodingException e) {
                        jVar.cR(i3);
                        return null;
                    } catch (Throwable th) {
                        jVar.cR(i3);
                    }
                }
                jVar.cR(i3);
                return id3Frame;
            }
            jVar.cR(i3);
            return null;
        } else {
            jVar.cR(i3);
            return null;
        }
    }

    private static ChapterFrame a(j jVar, int i, int i2, boolean z, int i3, a aVar) {
        int i4 = jVar.position;
        int c = c(jVar.data, i4);
        String str = new String(jVar.data, i4, c - i4, "ISO-8859-1");
        jVar.cR(c + 1);
        c = jVar.readInt();
        int readInt = jVar.readInt();
        long aK = jVar.aK();
        if (aK == 4294967295L) {
            aK = -1;
        }
        long aK2 = jVar.aK();
        if (aK2 == 4294967295L) {
            aK2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (jVar.position < i4) {
            Id3Frame a = a(i2, jVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, c, readInt, aK, aK2, id3FrameArr);
    }

    private static ChapterTocFrame b(j jVar, int i, int i2, boolean z, int i3, a aVar) {
        int i4 = jVar.position;
        int c = c(jVar.data, i4);
        String str = new String(jVar.data, i4, c - i4, "ISO-8859-1");
        jVar.cR(c + 1);
        c = jVar.readUnsignedByte();
        boolean z2 = (c & 2) != 0;
        boolean z3 = (c & 1) != 0;
        int readUnsignedByte = jVar.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte];
        for (c = 0; c < readUnsignedByte; c++) {
            int i5 = jVar.position;
            int c2 = c(jVar.data, i5);
            strArr[c] = new String(jVar.data, i5, c2 - i5, "ISO-8859-1");
            jVar.cR(c2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (jVar.position < i4) {
            Id3Frame a = a(i2, jVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static int d(j jVar, int i) {
        Object obj = jVar.data;
        int i2 = jVar.position;
        int i3 = i;
        while (i2 + 1 < i3) {
            if ((obj[i2] & 255) == 255 && obj[i2 + 1] == (byte) 0) {
                System.arraycopy(obj, i2 + 2, obj, i2 + 1, (i3 - i2) - 2);
                i3--;
            }
            i2++;
        }
        return i3;
    }

    private static String cy(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static String g(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int g(byte[] bArr, int i, int i2) {
        int c = c(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return c;
        }
        while (c < bArr.length - 1) {
            if (c % 2 == 0 && bArr[c + 1] == (byte) 0) {
                return c;
            }
            c = c(bArr, c + 1);
        }
        return bArr.length;
    }

    private static int c(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int cz(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] h(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }
}
