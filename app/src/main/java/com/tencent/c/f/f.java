package com.tencent.c.f;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class f {
    public static String O(File file) {
        Closeable bufferedReader;
        Throwable th;
        String str = "";
        Closeable closeable = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
                if (str != null) {
                    b(bufferedReader);
                } else {
                    b(bufferedReader);
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedReader;
                if (closeable != null) {
                    b(closeable);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (closeable != null) {
                b(closeable);
            }
            throw th;
        }
        return str;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] P(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile.length();
                int i = (int) length;
                if (((long) i) != length) {
                    throw new IOException("");
                }
                bArr = new byte[i];
                randomAccessFile.readFully(bArr);
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                }
                return bArr;
            } catch (Throwable th2) {
                try {
                    bArr = new byte[0];
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                        }
                    }
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            randomAccessFile = null;
            th = th5;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }
}
