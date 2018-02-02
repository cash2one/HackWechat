package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

public final class f {
    private long duration;
    private String filePath;
    private long htP;
    private long ieW;
    private long[] ieZ;
    public int ifa;
    private List<g> ifb;
    private List<Pair> ifc;
    public int ifd = 0;

    public final int Ww() {
        try {
            if (this.ifc == null) {
                return 0;
            }
            if (this.ifd == 0) {
                this.ifd = (int) ((((Long) ((Pair) this.ifc.get(this.ifc.size() - 1)).second).longValue() / 1000) / 1000);
            }
            return this.ifd;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Mp4Parser", e, "get last key frame error.", new Object[0]);
            return 0;
        }
    }

    @TargetApi(5)
    public final boolean b(int i, PInt pInt, PInt pInt2) {
        boolean z;
        boolean z2;
        Throwable th;
        try {
            if (this.ifc == null) {
                return false;
            }
            int size = this.ifc.size();
            long j = 1000 * (((long) i) * 1000);
            pInt2.value = 0;
            pInt.value = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = (Pair) this.ifc.get(i2);
                if (((Long) pair.second).longValue() > j) {
                    pInt2.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                    z = true;
                    break;
                }
                pInt.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
            }
            z = false;
            if (z) {
                z2 = z;
            } else {
                try {
                    pInt.value = (int) ((((Long) ((Pair) this.ifc.get(size - 1)).second).longValue() / 1000) / 1000);
                    pInt2.value = i;
                    z2 = true;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    z2 = z;
                    th = th2;
                    x.printErrStackTrace("MicroMsg.Mp4Parser", th, "seekVFrame seekTime[%d]", new Object[]{Integer.valueOf(i)});
                    x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
                    return z2;
                }
            }
            x.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value)});
            return z2;
        } catch (Throwable e2) {
            th = e2;
            z2 = false;
        }
    }

    public final boolean a(int i, int i2, PInt pInt, PInt pInt2) {
        if (this.ieZ == null) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        int length = this.ieZ.length;
        if (i >= length || i2 >= length) {
            i = length - 2;
            i2 = length - 1;
        }
        long j = this.ieZ[i];
        long j2 = this.ieZ[i2];
        if (i == 0) {
            pInt.value = 0;
            pInt2.value = (int) j2;
        } else {
            pInt.value = (int) j;
            pInt2.value = ((int) j2) - ((int) j);
        }
        return true;
    }

    public final int bu(int i, int i2) {
        int i3 = 0;
        if (this.ieZ == null) {
            return 0;
        }
        long j = (long) (i + i2);
        int i4 = 0;
        while (i3 < this.ieZ.length) {
            if (this.ieZ[i3] == j) {
                i4 = i3;
                break;
            }
            if (this.ieZ[i3] >= j) {
                if (this.ieZ[i3] > j) {
                    break;
                }
            } else {
                i4 = i3;
            }
            i3++;
        }
        return i4;
    }

    public final boolean r(String str, long j) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        this.filePath = null;
        this.ieZ = null;
        this.ifa = 0;
        this.duration = 0;
        this.ieW = 0;
        this.htP = 0;
        if (this.ifb != null) {
            this.ifb.clear();
        }
        if (this.ifc != null) {
            this.ifc.clear();
        }
        this.ifd = 0;
        this.filePath = str;
        this.htP = j;
        File file = new File(this.filePath);
        if (!file.exists()) {
            return false;
        }
        RandomAccessFile randomAccessFile2;
        try {
            byte[] bArr = new byte[8];
            randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                a a = a(randomAccessFile2, bArr, this.htP);
                while (a != null) {
                    x.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a.ieB);
                    e b = i.b(randomAccessFile2, bArr);
                    if (b == null || !b.a(randomAccessFile2, bArr)) {
                        x.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                        a = null;
                    } else {
                        int i;
                        if (b.ieX == ((long) e.ieT)) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i == 0) {
                            long Wv = a.Wv() - randomAccessFile2.getFilePointer();
                            x.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: " + Wv);
                            a = a(randomAccessFile2, bArr, Wv);
                        } else {
                            this.ieW = b.ieW;
                            this.duration = b.duration;
                            x.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.ieW + " duration: " + this.duration);
                            randomAccessFile2.seek(b.ieY);
                            h hVar = (h) c.a(randomAccessFile2, bArr, a.ajT);
                            if (hVar != null) {
                                hVar.duration = this.duration;
                                hVar.ieW = this.ieW;
                                hVar.c(randomAccessFile2);
                                this.ieZ = hVar.ieZ;
                                this.ifa = this.ieZ.length - 2;
                                this.ifb = hVar.ifb;
                                this.ifc = hVar.ifc;
                            }
                        }
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                randomAccessFile = randomAccessFile2;
            } catch (Throwable th) {
                e2 = th;
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile = null;
            try {
                x.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                x.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e2.toString());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th3) {
            e22 = th3;
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw e22;
        }
    }

    private static i a(RandomAccessFile randomAccessFile, byte[] bArr, long j) {
        x.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (c.a(randomAccessFile, j)) {
            return (i) c.a(randomAccessFile, bArr, a.ajQ);
        }
        return null;
    }
}
