package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.a.a;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class n {
    public static String a(FaceResult faceResult) {
        if (faceResult == null || faceResult.result != 0) {
            x.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            return null;
        }
        try {
            String str = aGP() + File.separator + "release_out.fd";
            hd hdVar = new hd();
            hdVar.vMO = b.bc(faceResult.sidedata);
            hdVar.vMP = b.bc(faceResult.data);
            byte[] toByteArray = hdVar.toByteArray();
            try {
                if (FileOp.mi(str)) {
                    FileOp.j(str, toByteArray);
                    return str;
                }
                x.e("MicroMsg.FaceUtils", "hy: create file failed!");
                return str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
                return str;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e2, "", new Object[0]);
            return null;
        }
    }

    public static Bitmap zK(String str) {
        try {
            if (bh.ov(str)) {
                x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                return null;
            }
            String str2 = a.mfR + ab.UZ(str);
            if (new File(str2).exists()) {
                byte[] d = FileOp.d(str2, 0, -1);
                if (d != null) {
                    d = a.f(d, zL(str));
                    if (d.length > 0) {
                        return com.tencent.mm.compatible.f.a.decodeByteArray(d, 0, d.length);
                    }
                    x.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                    return null;
                }
                x.w("MicroMsg.FaceUtils", "hy: nothing in file");
                return null;
            }
            x.w("MicroMsg.FaceUtils", "hy: no last file. return");
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
            return null;
        }
    }

    public static boolean b(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                x.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                return false;
            }
        } else if (bh.ov(str)) {
            x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            return false;
        } else {
            File file = new File(a.mfR);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = a.mfR + ab.UZ(str);
            File file2 = new File(str2);
            if (!file2.exists()) {
                x.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                file2.createNewFile();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] f = a.f(toByteArray, zL(str));
                if (f.length <= 0) {
                    x.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    return false;
                }
                FileOp.j(str2, f);
                return true;
            }
            x.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            return false;
        }
    }

    private static String zL(String str) {
        return Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
    }

    public static boolean o(Activity activity) {
        boolean aZ = com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.CAMERA");
        boolean aZ2 = com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.RECORD_AUDIO");
        x.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(aZ), Boolean.valueOf(aZ2), bh.cgy(), activity});
        ArrayList arrayList = new ArrayList();
        if (!aZ) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!aZ2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (aZ && aZ2) {
            return true;
        }
        x.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        return false;
    }

    public static void p(Activity activity) {
        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public static boolean aGO() {
        boolean z;
        String aGQ = aGQ();
        String aGR = aGR();
        if (bh.ov(aGQ) || bh.ov(aGR)) {
            x.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
            z = false;
        } else {
            File file = new File(aGQ);
            File file2 = new File(aGR);
            if (file.exists() || pw(0)) {
                z = true;
            } else {
                x.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z = false;
            }
            if (!(file2.exists() || pw(1))) {
                x.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
                z = false;
            }
        }
        if (!z) {
            x.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
            g.CG().a(new m(42), 0);
        }
        return z;
    }

    public static String aGP() {
        String str;
        if (a.mfP) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "face_detect";
        } else {
            str = ac.getContext().getFilesDir().getParent() + File.separator + "face_detect";
        }
        File file = new File(str);
        if (!file.exists()) {
            x.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str;
    }

    public static String aGQ() {
        return aGP() + File.separator + "ufdmtcc.bin";
    }

    public static String aGR() {
        return aGP() + File.separator + "ufat.bin";
    }

    private static boolean pw(int i) {
        String str = "";
        switch (i) {
            case 0:
                str = aq.hfP.H("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = aq.hfP.H("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (bh.ov(str)) {
            x.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (new File(str).exists()) {
            File file = new File(py(i));
            if (file.exists()) {
                file.delete();
            }
            e.x(str, py(i));
            return true;
        } else {
            x.e("MicroMsg.FaceUtils", "originFile file not exist");
            return false;
        }
    }

    public static String py(int i) {
        switch (i) {
            case 0:
                return aGQ();
            case 1:
                return aGR();
            default:
                return "";
        }
    }

    public static void n(Context context, String str, String str2) {
        InputStream open;
        FileOutputStream fileOutputStream;
        Throwable e;
        InputStream inputStream = null;
        x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", new Object[]{str, str2});
        try {
            File file = new File(str2);
            open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", new Object[]{str, Long.valueOf(file.length())});
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    inputStream = open;
                    try {
                        x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                                return;
                            }
                        }
                        if (fileOutputStream == null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (open != null) {
                        open.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                inputStream = open;
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            open = null;
            if (open != null) {
                open.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap n(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            long currentTimeMillis2 = System.currentTimeMillis();
            bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            bitmap2 = bitmap2.copy(bitmap2.getConfig(), true);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int[] iArr = new int[(width * height)];
            x.e("pix", width + " " + height + " " + iArr.length);
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int i12 = width - 1;
            int i13 = height - 1;
            int i14 = width * height;
            int[] iArr2 = new int[i14];
            int[] iArr3 = new int[i14];
            int[] iArr4 = new int[i14];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i15 = 0; i15 < 246016; i15++) {
                iArr6[i15] = i15 / 961;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{61, 3});
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < height; i18++) {
                i = 0;
                if (b.cQ(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                int[] iArr8;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                for (i10 = -30; i10 <= 30; i10++) {
                    i11 = iArr[Math.min(i12, Math.max(i10, 0)) + i17];
                    iArr8 = iArr7[i10 + 30];
                    iArr8[0] = (16711680 & i11) >> 16;
                    iArr8[1] = (65280 & i11) >> 8;
                    iArr8[2] = i11 & 255;
                    i11 = 31 - Math.abs(i10);
                    i8 += iArr8[0] * i11;
                    i7 += iArr8[1] * i11;
                    i6 += i11 * iArr8[2];
                    if (i10 > 0) {
                        i2 += iArr8[0];
                        i9 += iArr8[1];
                        i += iArr8[2];
                    } else {
                        i5 += iArr8[0];
                        i4 += iArr8[1];
                        i3 += iArr8[2];
                    }
                }
                i10 = 30;
                if (b.cQ(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                for (i11 = 0; i11 < width; i11++) {
                    iArr2[i17] = iArr6[i8];
                    iArr3[i17] = iArr6[i7];
                    iArr4[i17] = iArr6[i6];
                    i8 -= i5;
                    i7 -= i4;
                    i6 -= i3;
                    iArr8 = iArr7[((i10 - 30) + 61) % 61];
                    i5 -= iArr8[0];
                    i4 -= iArr8[1];
                    i3 -= iArr8[2];
                    if (i18 == 0) {
                        iArr5[i11] = Math.min((i11 + 30) + 1, i12);
                    }
                    int i19 = iArr[iArr5[i11] + i16];
                    iArr8[0] = (16711680 & i19) >> 16;
                    iArr8[1] = (65280 & i19) >> 8;
                    iArr8[2] = i19 & 255;
                    i2 += iArr8[0];
                    i9 += iArr8[1];
                    i += iArr8[2];
                    i8 += i2;
                    i7 += i9;
                    i6 += i;
                    i10 = (i10 + 1) % 61;
                    iArr8 = iArr7[i10 % 61];
                    i5 += iArr8[0];
                    i4 += iArr8[1];
                    i3 += iArr8[2];
                    i2 -= iArr8[0];
                    i9 -= iArr8[1];
                    i -= iArr8[2];
                    i17++;
                }
                i16 += width;
            }
            for (i10 = 0; i10 < width; i10++) {
                i9 = 0;
                i2 = width * -30;
                if (b.cQ(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                int[] iArr9;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i17 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i = i2;
                i2 = 0;
                for (i11 = -30; i11 <= 30; i11++) {
                    i16 = Math.max(0, i) + i10;
                    iArr9 = iArr7[i11 + 30];
                    iArr9[0] = iArr2[i16];
                    iArr9[1] = iArr3[i16];
                    iArr9[2] = iArr4[i16];
                    i12 = 31 - Math.abs(i11);
                    i8 += iArr2[i16] * i12;
                    i7 += iArr3[i16] * i12;
                    i6 += iArr4[i16] * i12;
                    if (i11 > 0) {
                        i3 += iArr9[0];
                        i2 += iArr9[1];
                        i9 += iArr9[2];
                    } else {
                        i17 += iArr9[0];
                        i5 += iArr9[1];
                        i4 += iArr9[2];
                    }
                    if (i11 < i13) {
                        i += width;
                    }
                }
                if (b.cQ(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i16 = i8;
                i8 = i7;
                i7 = i6;
                i11 = 30;
                i = i9;
                i9 = i2;
                i2 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i17;
                i17 = i10;
                for (i6 = 0; i6 < height; i6++) {
                    iArr[i17] = (((WebView.NIGHT_MODE_COLOR & iArr[i17]) | (iArr6[i16] << 16)) | (iArr6[i8] << 8)) | iArr6[i7];
                    i16 -= i5;
                    i8 -= i4;
                    i7 -= i3;
                    iArr9 = iArr7[((i11 - 30) + 61) % 61];
                    i5 -= iArr9[0];
                    i4 -= iArr9[1];
                    i3 -= iArr9[2];
                    if (i10 == 0) {
                        iArr5[i6] = Math.min(i6 + 31, i13) * width;
                    }
                    i12 = iArr5[i6] + i10;
                    iArr9[0] = iArr2[i12];
                    iArr9[1] = iArr3[i12];
                    iArr9[2] = iArr4[i12];
                    i2 += iArr9[0];
                    i9 += iArr9[1];
                    i += iArr9[2];
                    i16 += i2;
                    i8 += i9;
                    i7 += i;
                    i11 = (i11 + 1) % 61;
                    iArr9 = iArr7[i11];
                    i5 += iArr9[0];
                    i4 += iArr9[1];
                    i3 += iArr9[2];
                    i2 -= iArr9[0];
                    i9 -= iArr9[1];
                    i -= iArr9[2];
                    i17 += width;
                }
            }
            x.e("pix", width + " " + height + " " + i14);
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        }
        x.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        Object obj = 1;
        if (bitmap2 == null) {
            x.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = zK(str);
            if (bitmap2 == null) {
                bitmap2 = d.CZ(com.tencent.mm.plugin.facedetect.a.d.mcB);
            }
        }
        if (obj != null) {
            com.tencent.mm.sdk.f.e.post(new 1(bitmap2, str), "FaceUtils_SaveFile");
        }
        return bitmap2;
    }

    public static String zM(String str) {
        return com.tencent.mm.a.g.s((bh.Wq() + ", " + str).getBytes());
    }
}
