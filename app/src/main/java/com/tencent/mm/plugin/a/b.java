package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class b {
    public long ieC = -1;
    public long ieD = -1;
    public long ieE = -1;
    public a ieF = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ox(String str) {
        InputStream fileInputStream;
        long j;
        Throwable e;
        InputStream inputStream;
        Throwable th;
        long j2 = -1;
        if (c.ov(str)) {
            x.w("MicroMsg.AtomParsers", "calc moov atom location but filepath is null.");
            return j2;
        }
        File file = new File(str);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.ieE = file.length();
                a j3 = j(fileInputStream);
                if (j3 == null) {
                    x.w("MicroMsg.AtomParsers", "has no atom, this file may be not mp4");
                    j = j2;
                } else if (j3.Wt()) {
                    long j4 = j3.ieB;
                    j2 = j3.getSize();
                    j = j4;
                } else if (j3.Wu()) {
                    x.w("MicroMsg.AtomParsers", "it is the final atom, but can not find moov atom.");
                    j = j2;
                } else if (j3.getSize() > 0) {
                    j = j3.Wv();
                } else {
                    j = j2;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AtomParsers", e2, "", new Object[0]);
                }
            } catch (Throwable e3) {
                inputStream = fileInputStream;
                e2 = e3;
                j = j2;
                try {
                    x.printErrStackTrace("MicroMsg.AtomParsers", e2, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.AtomParsers", e22, "", new Object[0]);
                        }
                    }
                    this.ieC = j;
                    this.ieD = j2;
                    x.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " moovSize : " + this.ieD + " file length : " + (file.length() / 1024) + " K file path: " + str);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.AtomParsers", e4, "", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable e32) {
            e22 = e32;
            inputStream = null;
            j = j2;
            x.printErrStackTrace("MicroMsg.AtomParsers", e22, "", new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            this.ieC = j;
            this.ieD = j2;
            x.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " moovSize : " + this.ieD + " file length : " + (file.length() / 1024) + " K file path: " + str);
            return j;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        this.ieC = j;
        this.ieD = j2;
        x.i("MicroMsg.AtomParsers", "calc moov atom location moovAtomLocation : " + j + " moovSize : " + this.ieD + " file length : " + (file.length() / 1024) + " K file path: " + str);
        return j;
    }

    private a j(InputStream inputStream) {
        Throwable e;
        if (0 < 0) {
            x.w("MicroMsg.AtomParsers", "find Moov Atom, but parameter is error.");
            return null;
        }
        a aVar = null;
        a aVar2;
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            long j = 0;
            byte[] bArr = new byte[8];
            int read = inputStream.read(bArr, 0, 8);
            while (read >= 8) {
                try {
                    int y = c.y(bArr, 0);
                    int y2 = c.y(bArr, 4);
                    long j2 = 0;
                    if (y == 1) {
                        if (inputStream.read(bArr, 0, 8) < 8) {
                            break;
                        }
                        j2 = c.P(bArr);
                    }
                    this.ieF = aVar;
                    aVar2 = new a(y, j, y2, j2);
                    try {
                        if (aVar2.Wt() || aVar2.Wu()) {
                            return aVar2;
                        }
                        long j3;
                        if (y > 1) {
                            j3 = (long) (y - 8);
                            j += (long) y;
                        } else if (j2 <= 0) {
                            return aVar2;
                        } else {
                            j += j2;
                            j3 = (j2 - 8) - 8;
                        }
                        if (inputStream.skip(j3) < j3) {
                            return aVar2;
                        }
                        aVar = aVar2;
                        read = inputStream.read(bArr, 0, 8);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable e3) {
                    e = e3;
                    aVar2 = aVar;
                }
            }
            return aVar;
        } catch (Throwable e32) {
            e = e32;
            aVar2 = null;
            x.printErrStackTrace("MicroMsg.AtomParsers", e, "", new Object[0]);
            return aVar2;
        }
    }
}
