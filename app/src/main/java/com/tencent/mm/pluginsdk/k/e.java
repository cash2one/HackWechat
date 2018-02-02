package com.tencent.mm.pluginsdk.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class e {
    public static String iW(int i) {
        return String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
    }

    public static void a(Bitmap bitmap, CompressFormat compressFormat, String str) {
        int i;
        FileOutputStream fileOutputStream;
        Throwable e;
        if (str == null || str.length() <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            throw new IOException("saveBitmapToImage pathName null or nil");
        }
        File file = new File(str);
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, 60, fileOutputStream);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.VideoUtil", e2, "", new Object[0]);
                }
                x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            } catch (FileNotFoundException e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.VideoUtil", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.VideoUtil", e22, "", new Object[0]);
                        }
                    }
                    x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.VideoUtil", e4, "", new Object[0]);
                        }
                    }
                    x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                x.printErrStackTrace("MicroMsg.VideoUtil", e22, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.VideoUtil", e222, "", new Object[0]);
                    }
                }
                x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            } catch (Exception e6) {
                e222 = e6;
                x.printErrStackTrace("MicroMsg.VideoUtil", e222, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.VideoUtil", e2222, "", new Object[0]);
                    }
                }
                x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        } catch (FileNotFoundException e7) {
            e2222 = e7;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.VideoUtil", e2222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
        } catch (IOException e8) {
            e2222 = e8;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.VideoUtil", e2222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
        } catch (Exception e9) {
            e2222 = e9;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.VideoUtil", e2222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
        } catch (Throwable th2) {
            e2222 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.i("MicroMsg.VideoUtil", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            throw e2222;
        }
    }
}
