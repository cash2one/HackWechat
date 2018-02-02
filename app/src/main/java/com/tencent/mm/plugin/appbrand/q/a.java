package com.tencent.mm.plugin.appbrand.q;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.ca.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum a {
    ;

    public static boolean a(Options options) {
        if (options == null) {
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            return true;
        }
        if (str.indexOf("jpeg") >= 0) {
            return true;
        }
        return false;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        Options UL = d.UL(str);
        if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
            return false;
        }
        return a(str, UL.outWidth, UL.outHeight, i, i2, compressFormat, i3, str2);
    }

    private static Bitmap b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            x.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), l.EA().a(str, options, decodeResultLogger)});
            return l.EA().a(str, options, decodeResultLogger);
        } catch (OutOfMemoryError e) {
            b.clp();
            x.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                return false;
            }
            int ceil;
            int i6;
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (d < d2) {
                ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                i6 = i4;
            } else {
                i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                ceil = i3;
            }
            int UJ = ExifHelper.UJ(str);
            if (UJ == 90 || UJ == 270) {
                b = d.b(b, (float) UJ);
                int i7 = ceil;
                ceil = i6;
                i6 = i7;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, ceil, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.EA().h(b);
            }
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(UJ), Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight())});
            outputStream = FileOp.iE(str2);
            d.a(createScaledBitmap, i5, compressFormat, outputStream, false);
            l.EA().h(createScaledBitmap);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "create thumbnail from orig failed: %s", new Object[]{str2});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean bE(String str, String str2) {
        Throwable th;
        Throwable th2;
        int me = (int) FileOp.me(str2);
        Options UL = d.UL(str2);
        if (UL == null) {
            x.i("MicroMsg.AppBrandImgUtil", "compressImage, get null bitmap.option from path %s", new Object[]{str2});
            return false;
        }
        boolean z;
        boolean a;
        int i;
        int i2;
        int i3;
        Exif fromFile;
        int i4;
        Options options;
        InputStream inputStream;
        InputStream jVar;
        Bitmap decodeStream;
        if (UL != null) {
            String str3 = UL.outMimeType;
            x.d("MicroMsg.AppBrandImgUtil", "mimetype: " + str3);
            if (str3 != null) {
                str3 = str3.toLowerCase();
                if (str3.indexOf("jpg") >= 0) {
                    z = true;
                } else if (str3.indexOf("jpeg") >= 0) {
                    z = true;
                } else if (str3.indexOf("png") >= 0) {
                    z = true;
                }
                a = a(UL);
                i = -1;
                if (a) {
                    i = MMNativeJpeg.queryQuality(str2);
                    if (i < 70 && i > 25) {
                        i2 = i;
                        i3 = i;
                        i = 0;
                        if (a) {
                            try {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                    x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                                }
                                i4 = i;
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrandImgUtil", "get degree error " + e.getMessage());
                            }
                            x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
                            boolean z2;
                            if ((UL.outWidth < UL.outHeight * 2 || UL.outHeight >= UL.outWidth * 2) && UL.outWidth * UL.outHeight <= 10240000) {
                                if (me >= 204800 && z && i4 == 0) {
                                    x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                                    if (FileOp.x(str2, str) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                options = new Options();
                                d.c(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                    jVar = new j((FileInputStream) inputStream);
                                } else {
                                    jVar = inputStream;
                                }
                                jVar.mark(1048576);
                                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                                jVar.reset();
                                if (decodeStream != null) {
                                    if (jVar != null) {
                                        try {
                                            jVar.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    return false;
                                }
                                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                                if (z || i4 != 0) {
                                    if (jVar != null) {
                                        try {
                                            jVar.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    return true;
                                }
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str)), Integer.valueOf(10)});
                                if ((((long) me) - FileOp.me(str)) * 100 < ((long) (me * 10))) {
                                    FileOp.deleteFile(str);
                                    z2 = FileOp.x(str2, str) >= 0;
                                    if (jVar == null) {
                                        return z2;
                                    }
                                    try {
                                        jVar.close();
                                        return z2;
                                    } catch (IOException e4) {
                                        return z2;
                                    }
                                }
                                if (jVar != null) {
                                    try {
                                        jVar.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                return true;
                            } else if (me < 102400 && z && i4 == 0) {
                                x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                                return FileOp.x(str2, str) >= 0;
                            } else if ((UL.outWidth > 960 || UL.outHeight > 640) && (UL.outHeight > 960 || UL.outWidth > 640)) {
                                i = UL.outWidth >= UL.outHeight ? 960 : 640;
                                int i5 = UL.outWidth >= UL.outHeight ? 640 : 960;
                                if (UL.outWidth >= UL.outHeight * 2 || UL.outHeight >= UL.outWidth * 2) {
                                    x.i("MicroMsg.AppBrandImgUtil", "too max pic " + UL.outWidth + " " + UL.outHeight);
                                    if (UL.outHeight <= 0) {
                                        UL.outHeight = 1;
                                    }
                                    if (UL.outWidth <= 0) {
                                        UL.outWidth = 1;
                                    }
                                    if (UL.outWidth > UL.outHeight) {
                                        i = UL.outWidth / UL.outHeight;
                                    } else {
                                        i = UL.outHeight / UL.outWidth;
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    i5 = (int) Math.sqrt((double) (10240000 / i));
                                    if (UL.outWidth > UL.outHeight) {
                                        i2 = i5 * i;
                                    } else {
                                        i2 = i5;
                                        i5 *= i;
                                    }
                                    x.i("MicroMsg.AppBrandImgUtil", "new width height " + i2 + " " + i5 + " " + i);
                                } else {
                                    i2 = i;
                                }
                                z2 = a(str2, i5, i2, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str)), Integer.valueOf(10)});
                                if ((((long) me) - FileOp.me(str)) * 100 >= ((long) (me * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                if (FileOp.x(str2, str) >= 0) {
                                    return true;
                                }
                                return false;
                            } else {
                                x.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(me), Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight)});
                                if (FileOp.me(str2) < 71680) {
                                    if (z) {
                                        x.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                                        return FileOp.x(str2, str) >= 0;
                                    } else if (UL.outWidth < 150 && UL.outHeight < 150) {
                                        return a(str2, UL.outHeight, UL.outWidth, CompressFormat.PNG, i3, str);
                                    }
                                }
                                z2 = a(str2, UL.outHeight, UL.outWidth, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(me), Long.valueOf(FileOp.me(str)), Integer.valueOf(10)});
                                if ((((long) me) - FileOp.me(str)) * 100 >= ((long) (me * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                return FileOp.x(str2, str) >= 0;
                            }
                        }
                        i4 = 0;
                        x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
                        if (UL.outWidth < UL.outHeight * 2) {
                        }
                        if (me >= 204800) {
                        }
                        options = new Options();
                        d.c(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        jVar = inputStream;
                        jVar.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                        jVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                            if (z) {
                            }
                            if (jVar != null) {
                                jVar.close();
                            }
                            return true;
                        }
                        if (jVar != null) {
                            jVar.close();
                        }
                        return false;
                    }
                }
                i2 = i;
                i3 = 70;
                i = 0;
                if (a) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i = fromFile.getOrientationInDegree() % 360;
                        x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                    }
                    i4 = i;
                    x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
                    if (UL.outWidth < UL.outHeight * 2) {
                    }
                    if (me >= 204800) {
                    }
                    options = new Options();
                    d.c(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    jVar = inputStream;
                    jVar.mark(1048576);
                    decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                    jVar.reset();
                    if (decodeStream != null) {
                        if (jVar != null) {
                            jVar.close();
                        }
                        return false;
                    }
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return true;
                }
                i4 = 0;
                x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
                if (UL.outWidth < UL.outHeight * 2) {
                }
                if (me >= 204800) {
                }
                options = new Options();
                d.c(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                jVar = inputStream;
                jVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return true;
                }
                if (jVar != null) {
                    jVar.close();
                }
                return false;
            }
        }
        z = false;
        a = a(UL);
        i = -1;
        if (a) {
            i = MMNativeJpeg.queryQuality(str2);
            i2 = i;
            i3 = i;
            i = 0;
            if (a) {
                fromFile = Exif.fromFile(str2);
                if (fromFile != null) {
                    i = fromFile.getOrientationInDegree() % 360;
                    x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                }
                i4 = i;
                x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
                if (UL.outWidth < UL.outHeight * 2) {
                }
                if (me >= 204800) {
                }
                options = new Options();
                d.c(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                jVar = inputStream;
                jVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    if (jVar != null) {
                        jVar.close();
                    }
                    return false;
                }
                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                if (z) {
                }
                if (jVar != null) {
                    jVar.close();
                }
                return true;
            }
            i4 = 0;
            x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
            if (UL.outWidth < UL.outHeight * 2) {
            }
            if (me >= 204800) {
            }
            options = new Options();
            d.c(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            jVar = inputStream;
            jVar.mark(1048576);
            decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
            jVar.reset();
            if (decodeStream != null) {
                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                if (z) {
                }
                if (jVar != null) {
                    jVar.close();
                }
                return true;
            }
            if (jVar != null) {
                jVar.close();
            }
            return false;
        }
        i2 = i;
        i3 = 70;
        i = 0;
        if (a) {
            fromFile = Exif.fromFile(str2);
            if (fromFile != null) {
                i = fromFile.getOrientationInDegree() % 360;
                x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
            }
            i4 = i;
            x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
            if (UL.outWidth < UL.outHeight * 2) {
            }
            if (me >= 204800) {
            }
            options = new Options();
            d.c(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            jVar = inputStream;
            jVar.mark(1048576);
            decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
            jVar.reset();
            if (decodeStream != null) {
                if (jVar != null) {
                    jVar.close();
                }
                return false;
            }
            d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
            if (z) {
            }
            if (jVar != null) {
                jVar.close();
            }
            return true;
        }
        i4 = 0;
        x.i("MicroMsg.AppBrandImgUtil", "option info " + UL.outWidth + " " + UL.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + me + " target 960 640");
        if (UL.outWidth < UL.outHeight * 2) {
        }
        if (me >= 204800) {
        }
        options = new Options();
        d.c(options);
        inputStream = null;
        try {
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            jVar = inputStream;
            try {
                jVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(jVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                jVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (jVar != null) {
                        jVar.close();
                    }
                    return true;
                }
                if (jVar != null) {
                    jVar.close();
                }
                return false;
            } catch (Throwable e6) {
                th = e6;
                inputStream = jVar;
                th2 = th;
                try {
                    x.printErrStackTrace("MicroMsg.AppBrandImgUtil", th2, "Decode bitmap failed: " + str2, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable e62) {
                th = e62;
                inputStream = jVar;
                th2 = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        } catch (IOException e9) {
            th2 = e9;
            x.printErrStackTrace("MicroMsg.AppBrandImgUtil", th2, "Decode bitmap failed: " + str2, new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        }
    }

    public static int uD(String str) {
        int i = 0;
        if (e.bO(str)) {
            try {
                return Exif.fromFile(str).orientation;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "duplicate exif", new Object[i]);
                return 1;
            }
        }
        x.e("MicroMsg.AppBrandImgUtil", "getExifOriention err ");
        return i;
    }

    public static int l(InputStream inputStream) {
        int i = 1;
        if (inputStream != null) {
            try {
                i = Exif.fromStream(inputStream).orientation;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "duplicate exif", new Object[0]);
            }
        }
        return i;
    }

    public static String lJ(int i) {
        switch (i) {
            case 0:
                return "up";
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "right";
            case 7:
                return "right-mirrored";
            case 8:
                return "left";
            default:
                return "up";
        }
    }

    public static String b(Options options) {
        String str = options.outMimeType;
        x.d("MicroMsg.AppBrandImgUtil", "mimetype: " + str);
        if (str == null) {
            return "unknown";
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            return "jpeg";
        }
        if (str.indexOf("jpeg") >= 0) {
            return "jpeg";
        }
        if (str.indexOf("png") >= 0) {
            return "png";
        }
        if (str.indexOf("gif") >= 0) {
            return "gif";
        }
        return "unknown";
    }
}
