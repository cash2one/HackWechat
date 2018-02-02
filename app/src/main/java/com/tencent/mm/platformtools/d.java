package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;

public final class d {
    public static boolean a(String str, Context context, int i) {
        if (!p.UR(str)) {
            return a(str, context, true, i);
        }
        if (!bh.ov(str)) {
            String on = on("gif");
            e.bU(on);
            if (FileOp.x(str, on) >= 0) {
                b(on, context);
                Toast.makeText(context, context.getString(i, new Object[]{Wc()}), 1).show();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(String str, Context context, boolean z, int i) {
        Throwable th;
        if (str == null || str.equals("")) {
            return false;
        }
        String on = on("jpg");
        e.bU(on);
        if (FileOp.x(str, on) < 0) {
            return false;
        }
        if (MMNativeJpeg.isProgressive(on)) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            Bitmap decodeAsBitmap;
            Bitmap b;
            try {
                int UJ = ExifHelper.UJ(on);
                decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(on);
                if (decodeAsBitmap != null) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeAsBitmap, (float) UJ);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(on);
                    try {
                        b.compress(compressFormat, 80, fileOutputStream);
                    } catch (Exception e) {
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        try {
                            FileOp.deleteFile(on);
                            if (fileOutputStream3 != null) {
                                return false;
                            }
                            try {
                                fileOutputStream3.close();
                                return false;
                            } catch (Exception e2) {
                                return false;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream3;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                }
                fileOutputStream = null;
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.ExportImgUtil", e4, "rotate img failed.", new Object[0]);
                b = decodeAsBitmap;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            }
        }
        b(on, context);
        if (z) {
            Toast.makeText(context, context.getString(i, new Object[]{Wc()}), 1).show();
        }
        return true;
    }

    public static String on(String str) {
        return com.tencent.mm.compatible.util.e.gHu + String.format("%s%d.%s", new Object[]{"mmexport", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static void b(String str, Context context) {
        if (!bh.ov(str)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
            x.i("MicroMsg.ExportImgUtil", "refreshing media scanner on path=%s", new Object[]{str});
        }
    }

    public static String Wc() {
        String str = com.tencent.mm.compatible.util.e.gHu;
        return str.substring(str.indexOf("tencent/MicroMsg"));
    }
}
