package com.tencent.mm.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    public a fdO;
    public b fdP = null;

    public static class a {
        static final long fdQ = ((long) "Micromsg".hashCode());
        public int fdR = 0;

        public a(int i) {
            this.fdR = i;
        }

        public static a w(byte[] bArr) {
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & 255)) << (i * 8);
                }
                if ((j >> 32) == fdQ) {
                    return new a((int) j);
                }
            }
            return null;
        }

        static byte[] ah(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.fdP = bVar;
    }

    public final int j(File file) {
        try {
            if (cg(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                return -1;
            }
            byte[] toByteArray = this.fdP.toByteArray();
            byte[] ah = a.ah((a.fdQ << 32) | ((long) new a(toByteArray.length).fdR));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % 256), (byte) ((toByteArray.length + 8) / 256)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(ah);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static a cg(String str) {
        int i = 0;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
                return null;
            }
        }
        if (i < 8) {
            return null;
        }
        a w = a.w(e(str, i - 8, 8));
        if (w == null || w.fdR < 0) {
            return null;
        }
        b bVar = new b();
        bVar.aF(e(str, (i - w.fdR) - 8, w.fdR));
        a aVar = new a(bVar);
        aVar.fdO = w;
        return aVar;
    }

    public static boolean ch(String str) {
        boolean z = false;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                a cg = cg(str);
                if (!(cg == null || cg.fdP == null)) {
                    try {
                        byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = cg.fdP.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (cg.fdO.fdR + 8))) - 2), bArr));
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return z;
    }

    private static byte[] e(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            byte[] bArr = new byte[length];
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
