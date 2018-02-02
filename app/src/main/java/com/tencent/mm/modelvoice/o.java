package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class o {
    public static int nQ(String str) {
        if (bh.ov(str)) {
            return -1;
        }
        x.d("MicroMsg.VoiceFile", "fileName " + str);
        if (f(str, 0, false)) {
            return 0;
        }
        if (g(str, 0, false)) {
            return 2;
        }
        return 1;
    }

    public static int e(String str, int i, boolean z) {
        if (bh.ov(str)) {
            return -1;
        }
        x.d("MicroMsg.VoiceFile", "fileName " + str);
        if (f(str, i, z)) {
            return 0;
        }
        if (g(str, i, z)) {
            return 2;
        }
        return 1;
    }

    private static boolean f(String str, int i, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        if (!z) {
            if (i == 0) {
                str = q.getFullPath(str);
            } else {
                str = null;
            }
        }
        x.d("MicroMsg.VoiceFile", "path " + str);
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    x.e("MicroMsg.VoiceFile", "read amr file header failed!");
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e2));
                    }
                    return false;
                }
                x.i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bh.bv(bArr), new String(bArr), "#!AMR\n");
                if (new String(bArr).endsWith("#!AMR\n")) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e22));
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e222) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e222));
                }
                return false;
            } catch (Exception e3) {
                e222 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.VoiceFile", e222, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e2222) {
                            x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e2222));
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e4) {
                            x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e4));
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Throwable e42) {
            th = e42;
            randomAccessFile = null;
            e2222 = th;
            x.printErrStackTrace("MicroMsg.VoiceFile", e2222, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return false;
        } catch (Throwable e422) {
            th = e422;
            randomAccessFile = null;
            e2222 = th;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e2222;
        }
    }

    public static boolean g(String str, int i, boolean z) {
        Throwable e;
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        if (!z) {
            if (i == 0) {
                str = q.getFullPath(str);
            } else if (i == 1) {
                x.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str);
                return false;
            } else {
                str = null;
            }
        }
        x.d("MicroMsg.VoiceFile", "isSilkHeader path " + str);
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[9];
                randomAccessFile2.seek(1);
                if (randomAccessFile2.read(bArr, 0, 9) == -1) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e2));
                    }
                    return false;
                }
                x.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bh.bv(bArr), new String(bArr), "#!SILK_V3");
                if (new String(bArr).endsWith("#!SILK_V3")) {
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e22));
                    }
                    return true;
                }
                try {
                    randomAccessFile2.close();
                } catch (Throwable e222) {
                    x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e222));
                }
                return false;
            } catch (Exception e3) {
                randomAccessFile = randomAccessFile2;
                try {
                    x.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e2222) {
                            x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(e2222));
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    e2222 = th;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th22) {
                            x.e("MicroMsg.VoiceFile", "exception:%s", bh.i(th22));
                        }
                    }
                    throw e2222;
                }
            } catch (Throwable th3) {
                e2222 = th3;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw e2222;
            }
        } catch (Exception e4) {
            x.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return false;
        } catch (Throwable th222) {
            th = th222;
            randomAccessFile2 = null;
            e2222 = th;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw e2222;
        }
    }

    public static int nv(String str) {
        boolean z = true;
        String fullPath;
        File file;
        int length;
        switch (nQ(str)) {
            case 0:
                return nR(q.getFullPath(str));
            case 1:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                if (length > 0) {
                    return length;
                }
                return 0;
            case 2:
                fullPath = q.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(fullPath);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                return length > 0 ? length : 0;
            default:
                return nR(q.getFullPath(str));
        }
    }

    private static int nR(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = ((int) file.length()) - 6;
        if (length > 0) {
            return length;
        }
        return 0;
    }
}
