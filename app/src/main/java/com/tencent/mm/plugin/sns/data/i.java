package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public final class i {
    public static String kmS = "<TimelineObject>";
    public static String kmT = "</TimelineObject>";
    public static int qRd = Integer.MAX_VALUE;
    public static String qRe = "/";
    private static String qRf = "snsb";
    private static int qRg = -1;
    private static int qRh = -1;
    public static int qRi = 4194304;
    public static int qRj = 1048576;

    public static String aD(int i, String str) {
        return i + "-" + str;
    }

    public static String bJ(List<aqr> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i = 0;
        for (aqr com_tencent_mm_protocal_c_aqr : list) {
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + com_tencent_mm_protocal_c_aqr.nGJ;
            int i2 = i + 1;
            if (i2 >= 4) {
                return str;
            }
            i = i2;
        }
        return str;
    }

    private static String c(aqr com_tencent_mm_protocal_c_aqr) {
        if (!bh.ov(com_tencent_mm_protocal_c_aqr.wxS)) {
            return com_tencent_mm_protocal_c_aqr.wxS;
        }
        String str = "";
        try {
            return g.s(com_tencent_mm_protocal_c_aqr.toByteArray());
        } catch (Exception e) {
            return str;
        }
    }

    public static String JD(String str) {
        return "snst_" + JO(str);
    }

    public static String JE(String str) {
        return "snsu_" + JO(str);
    }

    public static String JF(String str) {
        return "snsb_" + JO(str);
    }

    public static String d(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snsb_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String e(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snst_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String JG(String str) {
        return "snsu_" + JO(str);
    }

    public static String f(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snsu_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String g(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snsblurt_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String h(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snsblurs_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String i(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snstblur_src_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String j(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sight_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String k(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sightad_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str, com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String l(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "snsb_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String m(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sns_tmpb_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String JH(String str) {
        return "sns_tmpb_" + JO(str);
    }

    public static String n(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sns_tmpt_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String JI(String str) {
        return "sns_tmpt_" + JO(str);
    }

    public static String o(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sns_tmpu_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String p(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sns_tmps_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String JJ(String str) {
        return "sns_tmps_" + JO(str);
    }

    public static String q(aqr com_tencent_mm_protocal_c_aqr) {
        String str = "sns_tmpsad_" + JO(com_tencent_mm_protocal_c_aqr.nGJ);
        if (com_tencent_mm_protocal_c_aqr.wxQ == 1) {
            return f.p(str + c(com_tencent_mm_protocal_c_aqr), com_tencent_mm_protocal_c_aqr.wxR);
        }
        return str;
    }

    public static String aE(int i, String str) {
        return i + "-" + str;
    }

    public static void Z(String str, long j) {
        x.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
    }

    public static boolean m(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static boolean b(n nVar) {
        if (nVar == null || nVar.isRecycled()) {
            return false;
        }
        return true;
    }

    public static Bitmap s(String str, Bitmap bitmap) {
        int orientationInDegree;
        Throwable e;
        Throwable th;
        if (bitmap == null) {
            return null;
        }
        String str2;
        if (bh.ov(str)) {
            str2 = "";
        } else {
            int lastIndexOf = str.lastIndexOf(qRe);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                str2 = str.substring(lastIndexOf + 1);
                if (str2.startsWith(qRf) || str2.startsWith("sns_tmpb_")) {
                    str2 = str;
                } else if (str2.startsWith("snst_") || str2.startsWith("snsu_")) {
                    str2 = "";
                }
            }
            str2 = str;
        }
        if (bh.ov(str2)) {
            return bitmap;
        }
        Exif exif = new Exif();
        InputStream openRead;
        try {
            x.i("MicroMsg.SnsUtil", "[tomys] parsing jpg, path: %s, size: %s", new Object[]{str, Long.valueOf(FileOp.me(str))});
            openRead = FileOp.openRead(str);
            try {
                exif.parseFromStream(openRead);
                orientationInDegree = exif.getOrientationInDegree();
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str2, new Object[0]);
                    if (openRead == null) {
                        orientationInDegree = 0;
                    } else {
                        try {
                            openRead.close();
                            orientationInDegree = 0;
                        } catch (Throwable th3) {
                            orientationInDegree = 0;
                        }
                    }
                    x.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
                    return d.b(bitmap, (float) orientationInDegree);
                } catch (Throwable th4) {
                    th = th4;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable e3) {
            Throwable th6 = e3;
            openRead = null;
            e = th6;
            x.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str2, new Object[0]);
            if (openRead == null) {
                openRead.close();
                orientationInDegree = 0;
            } else {
                orientationInDegree = 0;
            }
            x.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
            return d.b(bitmap, (float) orientationInDegree);
        } catch (Throwable th7) {
            th = th7;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            throw th;
        }
        x.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
        return d.b(bitmap, (float) orientationInDegree);
    }

    public static n JK(String str) {
        n nVar = null;
        try {
            x.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + FileOp.bO(str));
            if (FileOp.bO(str)) {
                nVar = JM(str);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
        }
        return nVar;
    }

    public static Bitmap JL(String str) {
        Throwable th;
        try {
            InputStream inputStream;
            if (!FileOp.bO(str)) {
                return null;
            }
            Options options = new Options();
            d.c(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                InputStream openRead;
                try {
                    openRead = FileOp.openRead(str);
                    try {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        long Wq = bh.Wq();
                        Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options, decodeResultLogger, 0, new int[0]);
                        long bA = bh.bA(Wq);
                        if (options.inSampleSize > 1) {
                            x.w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                        }
                        if (decodeStream != null) {
                            decodeStream = s(str, decodeStream);
                            c.aa(str, bA);
                        } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                        }
                        if (openRead == null) {
                            return decodeStream;
                        }
                        try {
                            openRead.close();
                            return decodeStream;
                        } catch (IOException e) {
                            return decodeStream;
                        }
                    } catch (OutOfMemoryError e2) {
                    }
                } catch (OutOfMemoryError e3) {
                    openRead = null;
                    try {
                        options.inSampleSize++;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        inputStream = openRead;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
            return null;
            throw th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        } catch (Throwable th5) {
            x.printErrStackTrace("MicroMsg.SnsUtil", th5, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static n JM(String str) {
        try {
            if (!FileOp.bO(str)) {
                return null;
            }
            Options options = new Options();
            d.c(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    long Wq = bh.Wq();
                    n c = a.c(str, options, decodeResultLogger);
                    Wq = bh.bA(Wq);
                    if (c != null) {
                        c.aa(str, Wq);
                    } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                    }
                    return c;
                } catch (OutOfMemoryError e) {
                    options.inSampleSize++;
                }
            }
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static String JN(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, "0");
        }
        return stringBuffer.toString();
    }

    public static String eq(long j) {
        return new BigInteger(Long.toBinaryString(j), 2).toString();
    }

    public static String er(long j) {
        if (j == 0) {
            return "";
        }
        return JN(new BigInteger(Long.toBinaryString(j), 2).toString());
    }

    private static String JO(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    private static Rect F(Bitmap bitmap) {
        int width = bitmap.getWidth();
        return new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
    }

    private static Rect G(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap h(List<n> list, int i) {
        for (n b : list) {
            if (!b(b)) {
                return null;
            }
        }
        if (i <= 0) {
            return null;
        }
        Rect rect;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        int size = list.size();
        List linkedList = new LinkedList();
        int i2 = i >> 1;
        int i3 = i2 + 2;
        i2 -= 2;
        Rect rect2;
        if (size == 2) {
            rect = new Rect(0, 0, i2, i);
            rect2 = new Rect(i3, 0, i, i);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            rect = new Rect(0, 0, i2, i);
            r7 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect2);
        } else if (size >= 4) {
            rect = new Rect(0, 0, i2, i2);
            r7 = new Rect(0, i3, i2, i);
            Rect rect3 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect3);
            linkedList.add(rect2);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        i2 = 0;
        for (i3 = 0; i3 < list.size() && i2 < 4; i3++) {
            Rect G;
            Bitmap ED = ((n) list.get(i3)).ED();
            rect = (Rect) linkedList.get(i3);
            switch (list.size()) {
                case 1:
                    G = G(ED);
                    break;
                case 2:
                    G = F(ED);
                    break;
                case 3:
                    if (i3 != 0) {
                        G = G(ED);
                        break;
                    }
                    G = F(ED);
                    break;
                default:
                    G = G(ED);
                    break;
            }
            canvas.drawBitmap(ED, G, rect, null);
            i2++;
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static boolean JP(String str) {
        return str.startsWith(e.bnD);
    }

    public static boolean JQ(String str) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean JR(String str) {
        int i = qRi;
        try {
            Options UL = d.UL(str);
            int i2 = UL.outWidth;
            int i3 = UL.outHeight;
            if ((i3 > 0 || i2 > 0) && i3 < i2 * 2 && i2 < i3 * 2 && i3 * i2 > i) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean wv(int i) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putInt("sns_control_flag", i).commit();
        return true;
    }

    public static int buk() {
        return ac.getContext().getSharedPreferences(ac.cfs(), 0).getInt("sns_control_flag", 0);
    }

    public static boolean ww(int i) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putInt("sns_respone_count", i).commit();
        return true;
    }

    public static int bul() {
        return ac.getContext().getSharedPreferences(ac.cfs(), 0).getInt("sns_respone_count", 20);
    }

    public static String A(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            return "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        com.tencent.mm.pluginsdk.ui.d.n[] nVarArr = (com.tencent.mm.pluginsdk.ui.d.n[]) spannableString.getSpans(0, spannableString.length(), com.tencent.mm.pluginsdk.ui.d.n.class);
        x.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[]{Integer.valueOf(nVarArr.length)});
        while (i < nVarArr.length) {
            spannableString.removeSpan(nVarArr[i]);
            i++;
        }
        return spannableString.toString();
    }

    public static void b(View view, Context context) {
        if (view != null && com.tencent.mm.ui.ac.eu(context) > 1.0f) {
            float eu = com.tencent.mm.ui.ac.eu(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i = (int) (((float) layoutParams.width) * eu);
                int i2 = (int) (eu * ((float) layoutParams.height));
                if (i > fromDPToPix) {
                    i = fromDPToPix;
                }
                layoutParams.width = i;
                if (i2 <= fromDPToPix) {
                    fromDPToPix = i2;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static int bum() {
        Context context = ac.getContext();
        if (an.is2G(context)) {
            return 1;
        }
        if (an.is3G(context)) {
            return 2;
        }
        if (an.is4G(context)) {
            return 3;
        }
        if (an.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean f(m mVar) {
        if (mVar.field_type == 3 || mVar.field_type == 4 || mVar.field_type == 5 || mVar.field_type == 6 || mVar.field_type == 9 || mVar.field_type == 10 || mVar.field_type == 11 || mVar.field_type == 12 || mVar.field_type == 13 || mVar.field_type == 14 || mVar.field_type == 17 || mVar.field_type == 22 || mVar.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long MQ() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        if (bh.ov(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        return new SpannableString(com.tencent.mm.pluginsdk.ui.d.i.e(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
    }

    public static String g(m mVar) {
        return mVar == null ? "0" : eq(mVar.field_snsId);
    }

    public static long lS(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        x.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public static int JS(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        int i = 0;
        try {
            if (!bh.ov(str)) {
                x.i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", new Object[]{str});
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    i = bh.fM((long) bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                    mediaMetadataRetriever.release();
                } catch (Throwable th) {
                    try {
                        x.e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", new Object[]{str});
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return i;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th3 = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th3;
        }
        return i;
    }
}
