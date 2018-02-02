package com.tencent.mm.aq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.by.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class g extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0)", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) "};
    public static long hAI = 0;
    public static int hAv = 0;
    private Map<Integer, WeakReference<ImageView>> hAA = new HashMap();
    private Map<Integer, WeakReference<View>> hAB = new HashMap();
    private Set<Integer> hAC = new HashSet();
    private Map<String, String> hAD = new HashMap();
    public long hAE = 1;
    private LayoutParams hAF = new LayoutParams(-2, -2);
    private SoftReference<ColorDrawable> hAG;
    public int hAH = 150;
    public f<String, Bitmap> hAw = new f(40, new 1(this));
    f<String, String> hAx = new f(40, new 2(this));
    private List<b> hAy = new ArrayList();
    private Map<Integer, WeakReference<ImageView>> hAz = new HashMap();
    private af hae = new af(Looper.getMainLooper());
    public h hhp = null;

    static /* synthetic */ void a(g gVar, String str) {
        x.d("MicroMsg.ImgInfoStorage", "checkrefresh load done, uri: %s", new Object[]{str});
        gVar.hAC.remove(Integer.valueOf(str.hashCode()));
        for (b bVar : gVar.hAy) {
            if (str.equals(bVar.url)) {
                Bitmap bitmap = (Bitmap) gVar.hAw.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    ImageView imageView = (ImageView) ((WeakReference) gVar.hAz.get(Integer.valueOf(bVar.hAO))).get();
                    if (imageView != null) {
                        x.i("MicroMsg.ImgInfoStorage", "[checkrefresh] bitmap width %d,height %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                        a.a(bitmap, imageView);
                        imageView.setLayoutParams(gVar.hAF);
                        int i = bitmap.getWidth() >= bitmap.getHeight() * 2 ? 1 : 0;
                        int i2 = bitmap.getHeight() >= bitmap.getWidth() * 2 ? 1 : 0;
                        if (!(i == 0 && i2 == 0)) {
                            x.d("MicroMsg.ImgInfoStorage", "bm: w:%d, h:%d ", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                            imageView.setScaleType(ScaleType.CENTER);
                        }
                        if (gVar.hAA.get(Integer.valueOf(bVar.hAP)) != null) {
                            imageView = (ImageView) ((WeakReference) gVar.hAA.get(Integer.valueOf(bVar.hAP))).get();
                            if (imageView != null) {
                                imageView.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                            }
                        }
                        if (gVar.hAB.get(Integer.valueOf(bVar.hAQ)) != null) {
                            View view = (View) ((WeakReference) gVar.hAB.get(Integer.valueOf(bVar.hAQ))).get();
                            if (view != null) {
                                view.setLayoutParams(new LayoutParams(bitmap.getWidth(), bitmap.getHeight()));
                            }
                        }
                    }
                }
            }
        }
    }

    public g(h hVar) {
        a(hVar);
        this.hhp = hVar;
        Pg();
    }

    public final void Pg() {
        Cursor a = this.hhp.a("SELECT max(id) FROM ImgInfo2", null, 2);
        if (a.moveToFirst()) {
            this.hAE = a.getLong(0) + 1;
        }
        a.close();
        x.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.hAE);
    }

    private static void a(h hVar) {
        Object obj = null;
        Cursor a = hVar.a("PRAGMA table_info(ImgInfo2)", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("hashdthumb".equals(string)) {
                    obj6 = 1;
                }
                if ("iscomplete".equals(string)) {
                    obj5 = 1;
                }
                if ("origImgMD5".equals(string)) {
                    obj4 = 1;
                }
                if ("compressType".equals(string)) {
                    obj3 = 1;
                }
                if ("midImgPath".equals(string)) {
                    obj2 = 1;
                }
                if ("forwardType".equals(string)) {
                    obj = 1;
                }
            }
        }
        a.close();
        long dz = com.tencent.mm.kernel.g.Dj().gQj.dz(Thread.currentThread().getId());
        if (obj6 == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
        }
        if (obj5 == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
        }
        if (obj4 == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
        }
        if (obj3 == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
        }
        if (obj2 == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
        }
        if (obj == null) {
            hVar.fx("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
        }
        if (dz > 0) {
            com.tencent.mm.kernel.g.Dj().gQj.fS(dz);
        }
    }

    public final String a(String str, String str2, String str3, boolean z) {
        if (bh.ov(str)) {
            return null;
        }
        String str4;
        String str5;
        String str6 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str4 = bh(Long.valueOf(str.substring(11)).longValue()).hzQ;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        str4 = str6;
        if (str.startsWith("THUMBNAIL_DIRPATH://")) {
            str = str.substring(23);
            str5 = "th_";
        } else {
            str5 = str2;
        }
        str6 = c.Fi();
        String Fj = c.Fj();
        if (bh.ov(str4)) {
            str4 = str;
        }
        return i.a(str6, Fj, str5, str4, str3, 1, z);
    }

    public final String m(String str, String str2, String str3) {
        return a(str, str2, str3, true);
    }

    public final String getFullPath(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String str2 = "";
        if (str.startsWith("SERVERID://")) {
            try {
                str2 = bh(Long.valueOf(str.substring(11)).longValue()).hzQ;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        }
        String Fi = c.Fi();
        String Fj = c.Fj();
        String str3 = "th_";
        if (!bh.ov(str2)) {
            str = str2;
        }
        return i.e(Fi, Fj, str3, str, "");
    }

    public static String ll(String str) {
        return "THUMBNAIL_DIRPATH://th_" + str;
    }

    public final String lm(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = "";
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = hQ(Integer.valueOf(trim.substring(12)).intValue()).hzS;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            trim = trim.substring(23);
            str2 = "th_";
        }
        return m(trim, str2, "");
    }

    public final String a(byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(8, bArr, z, compressFormat);
    }

    public final String a(byte[] bArr, CompressFormat compressFormat) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String s = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
        x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[]{m(s, "th_", "")});
        try {
            d.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), 100, compressFormat, m(s, "th_", ""), true);
            return "THUMBNAIL_DIRPATH://th_" + s;
        } catch (IOException e) {
            x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e});
            return a(9, bArr, true, compressFormat);
        } catch (Exception e2) {
            x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e2});
            return a(9, bArr, true, compressFormat);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(byte[] bArr, CompressFormat compressFormat, int i, int i2) {
        OutputStream iE;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream;
        int i4;
        Throwable th;
        IOException e;
        String a;
        OutputStream outputStream = null;
        if (bh.bw(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String s = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
        String m = m(s, "th_", "");
        String str = m + ".tmp";
        x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + m);
        try {
            iE = FileOp.iE(str);
            try {
                iE.write(bArr);
                iE.flush();
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a2 = d.a(str, i2, i, false, decodeResultLogger, 0);
                if (a2 != null) {
                    i3 = 100;
                    if (bArr.length > 262144) {
                        try {
                            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                a2.compress(compressFormat, 100, byteArrayOutputStream2);
                                while (byteArrayOutputStream2.toByteArray().length > 262144 && i3 >= 15) {
                                    byteArrayOutputStream2.reset();
                                    i3 -= 5;
                                    a2.compress(compressFormat, i3, byteArrayOutputStream2);
                                }
                                byteArrayOutputStream2.close();
                            } catch (Exception e2) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                i4 = 100;
                                try {
                                    x.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                                    if (byteArrayOutputStream == null) {
                                        i3 = i4;
                                    } else {
                                        byteArrayOutputStream.close();
                                        i3 = i4;
                                    }
                                    d.a(a2, i3, compressFormat, m, true);
                                    x.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", new Object[]{str, m, Integer.valueOf(i3)});
                                    if (FileOp.bO(str)) {
                                        x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                                        FileOp.deleteFile(str);
                                    }
                                    if (iE != null) {
                                        try {
                                            iE.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    return "THUMBNAIL_DIRPATH://th_" + s;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                outputStream = byteArrayOutputStream2;
                                th = th3;
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            i4 = 100;
                            x.e("MicroMsg.ImgInfoStorage", "compress bitmap failed.");
                            if (byteArrayOutputStream == null) {
                                byteArrayOutputStream.close();
                                i3 = i4;
                            } else {
                                i3 = i4;
                            }
                            d.a(a2, i3, compressFormat, m, true);
                            x.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", new Object[]{str, m, Integer.valueOf(i3)});
                            if (FileOp.bO(str)) {
                                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                                FileOp.deleteFile(str);
                            }
                            if (iE != null) {
                                iE.close();
                            }
                            return "THUMBNAIL_DIRPATH://th_" + s;
                        }
                    }
                    d.a(a2, i3, compressFormat, m, true);
                    x.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s, quality : %d", new Object[]{str, m, Integer.valueOf(i3)});
                } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    x.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", new Object[]{str, m});
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, 6, decodeResultLogger));
                }
            } catch (Exception e5) {
                i3 = i4;
            } catch (IOException e6) {
                e = e6;
                outputStream = iE;
            }
            if (FileOp.bO(str)) {
                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (iE != null) {
                iE.close();
            }
            return "THUMBNAIL_DIRPATH://th_" + s;
        } catch (IOException e7) {
            e = e7;
            try {
                x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e});
                a = a(6, bArr, true, compressFormat);
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e8) {
                    }
                }
                return a;
            } catch (Throwable th4) {
                th = th4;
                iE = outputStream;
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (iE != null) {
                    try {
                        iE.close();
                    } catch (Exception e9) {
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            Exception e11 = e10;
            iE = null;
            try {
                x.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[]{e11});
                a = a(6, bArr, true, compressFormat);
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (iE != null) {
                    try {
                        iE.close();
                    } catch (Exception e12) {
                    }
                }
                return a;
            } catch (Throwable th5) {
                th = th5;
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (iE != null) {
                    iE.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            iE = null;
            if (FileOp.bO(str)) {
                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (iE != null) {
                iE.close();
            }
            throw th;
        }
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat) {
        return a(i, bArr, z, compressFormat, false);
    }

    public final String a(int i, byte[] bArr, boolean z, CompressFormat compressFormat, boolean z2) {
        OutputStream iE;
        Exception exception;
        OutputStream outputStream;
        Throwable th;
        if (bh.bw(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        String s = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
        String m = m(s, "th_", "");
        String str = m + ".tmp";
        x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + m);
        try {
            iE = FileOp.iE(str);
            try {
                Bitmap decodeFile;
                iE.write(bArr);
                iE.flush();
                int i2 = z ? FileUtils.S_IWUSR : 120;
                int i3 = z ? FileUtils.S_IWUSR : 120;
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                if (z2) {
                    decodeFile = d.decodeFile(str, null);
                } else {
                    decodeFile = d.a(str, i2, i3, false, decodeResultLogger, 0);
                }
                if (decodeFile != null) {
                    d.a(decodeFile, 90, compressFormat, m, true);
                    x.d("MicroMsg.ImgInfoStorage", "in ImgInfoStorage, extractThumbNail done: %s, %s", new Object[]{str, m});
                } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    x.w("MicroMsg.ImgInfoStorage", "hit image hole while extractThumbNail: %s, %s", new Object[]{str, m});
                    com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(str, i, decodeResultLogger));
                }
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (iE != null) {
                    try {
                        iE.close();
                    } catch (Exception e) {
                    }
                }
                return "THUMBNAIL_DIRPATH://th_" + s;
            } catch (Exception e2) {
                exception = e2;
                outputStream = iE;
                try {
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 189, 1, false);
                    x.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + s + ", ex = " + exception.getMessage());
                    if (FileOp.bO(str)) {
                        x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    iE = outputStream;
                    if (FileOp.bO(str)) {
                        x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                        FileOp.deleteFile(str);
                    }
                    if (iE != null) {
                        try {
                            iE.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (FileOp.bO(str)) {
                    x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                    FileOp.deleteFile(str);
                }
                if (iE != null) {
                    iE.close();
                }
                throw th;
            }
        } catch (Exception e22) {
            exception = e22;
            outputStream = null;
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 189, 1, false);
            x.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: th_" + s + ", ex = " + exception.getMessage());
            if (FileOp.bO(str)) {
                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            iE = null;
            if (FileOp.bO(str)) {
                x.d("MicroMsg.ImgInfoStorage", "create thumbnail, delete tmp file");
                FileOp.deleteFile(str);
            }
            if (iE != null) {
                iE.close();
            }
            throw th;
        }
    }

    public final String f(int i, byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
            return null;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger)) {
            String s = com.tencent.mm.a.g.s((bh.Wp()).getBytes());
            String m = m(s, "th_", "");
            x.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + m);
            FileOp.deleteFile(m);
            FileOp.j(m, bArr);
            return "THUMBNAIL_DIRPATH://th_" + s;
        } else if (decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            return null;
        } else {
            x.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
            com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(bArr, i, decodeResultLogger));
            return null;
        }
    }

    public final String B(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("THUMBNAIL://")) {
            try {
                trim = hQ(Integer.valueOf(trim.substring(12)).intValue()).hzS;
            } catch (NumberFormatException e) {
                x.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + e.getMessage());
                return null;
            }
        } else if (trim.startsWith("THUMBNAIL_DIRPATH://")) {
            return a(trim.substring(20).substring(3), "th_", "", z);
        }
        return a(trim, "", "", z);
    }

    public final Bitmap a(String str, float f, boolean z) {
        return a(str, false, f, z, false, false, -1);
    }

    public final boolean a(ImageView imageView, String str, float f, int i, int i2, int i3, ImageView imageView2, int i4, int i5, View view) {
        return a(imageView, str, false, f, i, i2, true, i3, imageView2, i4, i5, true, view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(ImageView imageView, String str, boolean z, float f, int i, int i2, boolean z2, int i3, ImageView imageView2, int i4, int i5, boolean z3, View view) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[]{str});
            return false;
        }
        synchronized (this.hAD) {
            boolean containsKey = this.hAD.containsKey(str);
            String b = b(str, z, false);
            if (bh.ov(b)) {
                x.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[]{bh.ou(str)});
                return false;
            } else if (!containsKey) {
                if (!b.endsWith("hd") && FileOp.bO(b + "hd")) {
                    this.hAD.put(str, b + "hd");
                    b = b + "hd";
                }
            }
        }
    }

    private void a(ImageView imageView, ImageView imageView2, View view, String str, float f, boolean z, int i) {
        int hashCode;
        int i2;
        int hashCode2 = str.hashCode();
        int hashCode3 = imageView.hashCode();
        for (b bVar : this.hAy) {
            if (hashCode3 == bVar.hAO) {
                x.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[]{Integer.valueOf(bVar.hAO), bVar.url});
                bVar.url = str;
                if (!this.hAC.contains(Integer.valueOf(hashCode2))) {
                    this.hAC.add(Integer.valueOf(hashCode2));
                    a(str, f, z, i);
                    return;
                }
                return;
            }
        }
        this.hAz.put(Integer.valueOf(hashCode3), new WeakReference(imageView));
        if (imageView2 != null) {
            hashCode = imageView2.hashCode();
            this.hAA.put(Integer.valueOf(hashCode), new WeakReference(imageView2));
            i2 = hashCode;
        } else {
            i2 = 0;
        }
        if (view != null) {
            hashCode = view.hashCode();
            this.hAB.put(Integer.valueOf(hashCode), new WeakReference(view));
        } else {
            hashCode = 0;
        }
        this.hAy.add(new b(hashCode3, str, i2, hashCode));
        if (!this.hAC.contains(Integer.valueOf(hashCode2))) {
            this.hAC.add(Integer.valueOf(hashCode2));
            a(str, f, z, i);
        }
    }

    private void a(String str, float f, boolean z, int i) {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dm().F(new 4(this, str, f, z, i));
    }

    public final Bitmap b(String str, float f, boolean z) {
        return a(str, true, f, z, true, false, 0);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i) {
        return a(str, z, f, z2, z3, z4, i, true);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5) {
        return a(str, z, f, z2, z3, z4, i, z5, null);
    }

    public final Bitmap a(String str, boolean z, float f, boolean z2, boolean z3, boolean z4, int i, boolean z5, Bitmap bitmap) {
        if (!z) {
            str = b(str, false, true);
        }
        if (str == null) {
            return null;
        }
        Bitmap bitmap2 = null;
        Object obj = bitmap != null ? 1 : null;
        if (z5) {
            bitmap2 = (Bitmap) this.hAw.get(str);
            if (bitmap2 == null) {
                String str2 = "MicroMsg.ImgInfoStorage";
                String str3 = "bm is null:%b,  url:%s";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bitmap2 == null);
                objArr[1] = str;
                x.j(str2, str3, objArr);
            }
        }
        if (bitmap2 != null && !bitmap2.isRecycled() && obj == null) {
            return bitmap2;
        }
        Bitmap bitmap3;
        bh.Wp();
        if (obj != null) {
            bitmap3 = bitmap;
        } else {
            bitmap3 = d.a(str, f, 0);
        }
        if (bitmap3 == null) {
            bitmap3 = com.tencent.mm.platformtools.j.op(str);
        }
        if (bitmap3 == null) {
            return bitmap2;
        }
        Bitmap createScaledBitmap;
        long currentTimeMillis = System.currentTimeMillis();
        int width = bitmap3.getWidth();
        int height = bitmap3.getHeight();
        if (z3) {
            if (hAv == 0) {
                hAv = a.ab(ac.getContext(), com.tencent.mm.plugin.comm.a.c.lnJ);
            }
            if (width > hAv || height > hAv) {
                if (width > height) {
                    height = (height * hAv) / width;
                    width = hAv;
                } else if (width == height) {
                    height = hAv;
                    width = hAv;
                } else {
                    width = (width * hAv) / height;
                    height = hAv;
                }
            }
        }
        if (z4) {
            int i2;
            if (str.endsWith("hd")) {
                i2 = width;
                width = height;
            } else {
                i2 = (int) ((((float) bitmap3.getWidth()) * f) * 1.25f);
                width = (int) ((((float) bitmap3.getHeight()) * f) * 1.25f);
            }
            if (((float) i2) >= 160.0f * f || ((float) width) >= 160.0f * f) {
                float f2;
                if (width > i2) {
                    f2 = (160.0f * f) / ((float) width);
                } else {
                    f2 = (160.0f * f) / ((float) i2);
                }
                height = (int) (f2 * ((float) width));
                width = (int) (((float) i2) * f2);
            } else {
                height = width;
                width = i2;
            }
            if (((float) width) < 60.0f * f) {
                x.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[]{Integer.valueOf(width)});
                width = (int) (60.0f * f);
            }
            if (((float) height) < 60.0f * f) {
                x.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[]{Integer.valueOf(height)});
                height = (int) (60.0f * f);
            }
            Context context = ac.getContext();
            int[] iArr = new int[2];
            float f3;
            if (height >= width) {
                f3 = ((float) height) / ((float) width);
                if (f3 <= 2.0f) {
                    height = a.ab(context, com.tencent.mm.plugin.comm.a.c.buw);
                    width = (int) (((float) height) / f3);
                } else {
                    width = a.ab(context, com.tencent.mm.plugin.comm.a.c.bux);
                    height = (int) (((float) width) * f3);
                }
            } else {
                f3 = ((float) width) / ((float) height);
                if (f3 <= 2.0f) {
                    width = a.ab(context, com.tencent.mm.plugin.comm.a.c.buw);
                    height = (int) (((float) width) / f3);
                } else {
                    height = a.ab(context, com.tencent.mm.plugin.comm.a.c.bux);
                    width = (int) (((float) height) * f3);
                }
            }
            iArr[0] = width;
            iArr[1] = height;
            width = iArr[0];
            height = iArr[1];
        }
        try {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, width, height, true);
        } catch (OutOfMemoryError e) {
            createScaledBitmap = bitmap3;
        }
        if (bitmap3 != createScaledBitmap && obj == null) {
            x.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[]{bitmap3.toString()});
            bitmap3.recycle();
        }
        if (z4) {
            bitmap2 = d.b(createScaledBitmap, i);
        } else if (z2) {
            bitmap2 = d.a(createScaledBitmap, true, (float) a.fromDPToPix(ac.getContext(), 3));
            x.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[]{createScaledBitmap.toString()});
            createScaledBitmap.recycle();
        } else {
            bitmap2 = createScaledBitmap;
        }
        str2 = "MicroMsg.ImgInfoStorage";
        str3 = "cached file :%s bitmap time:%s bitmap:%s";
        objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = (System.currentTimeMillis() - currentTimeMillis);
        objArr[2] = bitmap2 == null ? "" : bitmap2.toString();
        x.i(str2, str3, objArr);
        if (bitmap2 == null || obj != null) {
            return bitmap2;
        }
        this.hAw.l(str, bitmap2);
        return bitmap2;
    }

    public final Bitmap a(String str, float f, Context context) {
        return a(str, f, context, -1);
    }

    public final Bitmap a(String str, float f, Context context, int i) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        Bitmap bitmap = (Bitmap) this.hAw.get(trim);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap b = b.b(trim, f);
        if (b == null) {
            return b;
        }
        int b2;
        int i2;
        int width = b.getWidth();
        int height = b.getHeight();
        if (width >= height) {
            b2 = b.b(context, (float) this.hAH);
            i2 = (int) ((((float) height) / ((float) width)) * ((float) b2));
        } else {
            i2 = b.b(context, (float) this.hAH);
            b2 = (int) ((((float) width) / ((float) height)) * ((float) i2));
        }
        if (b2 <= 0 || i2 <= 0 || b2 > 2048 || i2 > 2048) {
            x.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[]{Integer.valueOf(b2), Integer.valueOf(i2)});
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 188, 1, false);
            bitmap = null;
        } else {
            try {
                bitmap = Bitmap.createScaledBitmap(b, b2, i2, true);
            } catch (Exception e) {
                x.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[]{e.getMessage()});
                bitmap = null;
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 188, 1, false);
            }
        }
        if (i != -1) {
            bitmap = d.b(bitmap, i);
        }
        if (b != bitmap) {
            x.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[]{b.toString()});
            b.recycle();
        }
        x.d("MicroMsg.ImgInfoStorage", "cached file " + trim);
        this.hAw.l(trim, bitmap);
        return bitmap;
    }

    public final e n(au auVar) {
        e bi = bi(auVar.field_msgId);
        if (bi.hzP != 0) {
            return bi;
        }
        bi = bh(auVar.field_msgSvrId);
        if (bi.hzP != 0) {
            return bi;
        }
        x.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        return null;
    }

    public final e b(Long l) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "id=?", new String[]{String.valueOf(l)}, null, null, null);
        if (a != null && a.moveToFirst()) {
            eVar.b(a);
        }
        a.close();
        return eVar;
    }

    private e O(String str, int i) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[]{str, String.valueOf(i)}, null, null, null);
        if (a.moveToFirst()) {
            eVar.b(a);
        }
        a.close();
        return eVar;
    }

    public final void o(au auVar) {
        e n = n(auVar);
        if (n == null || n.hzP == 0) {
            x.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
            return;
        }
        FileOp.deleteFile(m(n.hzQ, "", ""));
        FileOp.deleteFile(m(n.hzS, "", ""));
        FileOp.deleteFile(m(n.hzS, "", "") + "hd");
        this.hhp.delete("ImgInfo2", "id=?", new String[]{n.hzP});
        if (n.Pe()) {
            n = hQ(n.hzZ);
            if (n != null) {
                FileOp.deleteFile(m(n.hzQ, "", ""));
                FileOp.deleteFile(m(n.hzS, "", ""));
                FileOp.deleteFile(m(n.hzS, "", "") + "hd");
                this.hhp.delete("ImgInfo2", "id=?", new String[]{n.hzP});
            }
        }
    }

    public final String d(e eVar) {
        String str = null;
        if (eVar != null && eVar.Pe()) {
            Cursor a = a("ImgInfo2", new String[]{"bigImgPath"}, "id=? and totalLen = offset", new String[]{eVar.hzZ});
            if (a.moveToFirst()) {
                str = a.getString(0);
            }
            a.close();
        }
        return str;
    }

    public final HashMap<Long, e> a(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msgSvrId in " + (str + ")"), null);
        HashMap<Long, e> hashMap = new HashMap();
        while (a.moveToNext()) {
            e eVar = new e();
            eVar.b(a);
            hashMap.put(Long.valueOf(eVar.fFo), eVar);
        }
        a.close();
        return hashMap;
    }

    public final HashMap<Long, e> b(Long... lArr) {
        Object obj = 1;
        int length = lArr.length;
        String str = "(";
        int i = 0;
        while (i < length) {
            long longValue = lArr[i].longValue();
            str = str + (obj != null ? Long.valueOf(longValue) : "," + longValue);
            i++;
            obj = null;
        }
        Cursor a = a("ImgInfo2", null, "msglocalid in " + (str + ")"), null);
        HashMap<Long, e> hashMap = new HashMap();
        while (a.moveToNext()) {
            e eVar = new e();
            eVar.b(a);
            hashMap.put(Long.valueOf(eVar.fFo), eVar);
        }
        a.close();
        return hashMap;
    }

    public final e hQ(int i) {
        return b(Long.valueOf((long) i));
    }

    public final e bh(long j) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "msgSvrId=?", new String[]{String.valueOf(j)});
        if (a.moveToFirst()) {
            eVar.b(a);
        }
        a.close();
        return eVar;
    }

    public final e bi(long j) {
        e eVar = new e();
        Cursor a = a("ImgInfo2", null, "msglocalid=?", new String[]{String.valueOf(j)});
        if (a.moveToLast()) {
            eVar.b(a);
        }
        a.close();
        return eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e hR(int i) {
        e eVar;
        Exception exception;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor a = a("ImgInfo2", null, "reserved1=?", new String[]{String.valueOf(i)});
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        e eVar2 = new e();
                        eVar2.b(a);
                        eVar = eVar2;
                        if (a != null) {
                            a.close();
                        }
                        return eVar;
                    }
                } catch (Exception e) {
                    exception = e;
                    eVar = null;
                    cursor = a;
                    try {
                        x.w("MicroMsg.ImgInfoStorage", "Exception :%s", new Object[]{exception.toString()});
                        if (cursor != null) {
                            cursor.close();
                        }
                        return eVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            eVar = null;
            if (a != null) {
                a.close();
            }
        } catch (Exception e2) {
            exception = e2;
            eVar = null;
            x.w("MicroMsg.ImgInfoStorage", "Exception :%s", new Object[]{exception.toString()});
            if (cursor != null) {
                cursor.close();
            }
            return eVar;
        }
        return eVar;
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return this.hhp.query(str, strArr, str2, strArr2, null, null, null);
    }

    private Cursor a(String str, String[] strArr, String str2, String[] strArr2) {
        return a(str, strArr, str2, strArr2, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2) {
        return a(str, i, i2, i3, pString, pInt, pInt2, "", "", -1, null, null, null);
    }

    public final long a(String str, int i, int i2, int i3, PString pString, PInt pInt, PInt pInt2, String str2, String str3, long j, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, n.a aVar) {
        e a;
        long e;
        if (i == 0) {
            a = a(str, 0, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.hzS;
            e = e(a);
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else if (i == 1) {
            a = a(str, 1, true, i2, i3, pInt, pInt2, pString.value, j, str2, str3, bVar2, bVar, aVar);
            if (a == null) {
                return -1;
            }
            pString.value = a.hzS;
            a.bf(0);
            a.ap(0);
            a.hL((int) FileOp.me(m(a.hzQ, "", "")));
            e a2 = a(str, 0, false, i2, i3, new PInt(), new PInt(), "", j, str2, str3, bVar2, bVar, aVar);
            if (a2 == null) {
                return 0;
            }
            a2.lg(a.hzQ);
            a2.li(a.hzS);
            a2.lh(a.hzR);
            a2.hL(0);
            long dz = this.hhp.dz(Thread.currentThread().getId());
            a2.hM((int) e(a));
            e = e(a2);
            x.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[]{Long.valueOf(e), Long.valueOf(a2.hzP), Long.valueOf(a2.hzX), a2.hzQ, a2.hzR, Integer.valueOf(a2.hlp)});
            if (dz > 0) {
                com.tencent.mm.kernel.g.Dj().gQj.fS(dz);
            }
            if (e == -1) {
                return e;
            }
            doNotify();
            return e;
        } else {
            Assert.assertTrue(false);
            return 0;
        }
    }

    public final long e(e eVar) {
        long insert = this.hhp.insert("ImgInfo2", SlookAirButtonFrequentContactAdapter.ID, eVar.vI());
        if (insert != -1) {
            eVar.Pf();
        }
        x.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[]{Long.valueOf(insert), Long.valueOf(eVar.hzP), Long.valueOf(eVar.hzX), Long.valueOf(eVar.fFo), Integer.valueOf(eVar.hzZ)});
        return insert;
    }

    private String P(String str, int i) {
        e O = O(FileOp.mk(str), i);
        if (!bh.ov(O.hzS)) {
            String B = B(O.hzS, true);
            if (FileOp.bO(B)) {
                return B;
            }
        }
        return null;
    }

    public final Bitmap a(String str, int i, int i2, PInt pInt, PInt pInt2, boolean z, String str2, com.tencent.mm.a.b bVar) {
        Bitmap bitmap;
        String str3;
        x.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s]", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), bh.cgy()});
        Bitmap bitmap2 = (Bitmap) this.hAw.get(str);
        if (bitmap2 == null || bitmap2.isRecycled()) {
            String P = P(str, i);
            if (bh.ov(P)) {
                bitmap = bitmap2;
                str3 = str;
            } else if (P.endsWith("hd")) {
                bitmap = bitmap2;
                str3 = P;
            } else {
                bitmap = d.cU(P, 0);
                str3 = str;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                int UM = d.UM(str3);
                int UJ = ExifHelper.UJ(str3) + (i2 * 90);
                if (UM > 0) {
                    bitmap = d.c(str3, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, UM, UJ, 0);
                    str3 = P;
                } else {
                    bitmap = d.a(str3, 120, 120, true, false, 0);
                    str3 = P;
                }
            } else {
                str3 = P;
            }
        } else {
            bitmap = bitmap2;
            str3 = null;
        }
        if (bitmap != null) {
            this.hAw.l(str, bitmap);
            pInt.value = bitmap.getWidth();
            pInt2.value = bitmap.getHeight();
            if (z) {
                if (str3 == null) {
                    str3 = P(str, i);
                }
                if (!bh.ov(str3) && str3.endsWith("hd")) {
                    str3 = str3.substring(0, str3.length() - 2);
                }
                if (bVar != null) {
                    bVar.sV();
                }
                if (bh.ov(str3) || !FileOp.bO(str3)) {
                    try {
                        d.a(bitmap, 100, CompressFormat.JPEG, str2, false);
                    } catch (IOException e) {
                    }
                } else {
                    FileOp.x(str3, str2);
                    x.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[]{str3});
                }
            }
        }
        return bitmap;
    }

    public static synchronized String Ph() {
        String s;
        synchronized (g.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (hAI == currentTimeMillis) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            hAI = currentTimeMillis;
            s = com.tencent.mm.a.g.s(String.valueOf(currentTimeMillis).getBytes());
        }
        return s;
    }

    public final String a(String str, String str2, int i, boolean z, PString pString, PString pString2, PString pString3, PString pString4, String str3, com.tencent.mm.a.b bVar) {
        int i2;
        int i3;
        String value;
        int indexOf;
        int intValue;
        boolean z2;
        boolean z3;
        int i4;
        if (bh.ov(str3)) {
            str3 = com.tencent.mm.a.g.s((str + System.currentTimeMillis()).getBytes());
        }
        String a = a(str3, "", ".jpg", false);
        if (bVar == null) {
            a = a(str3, "", ".jpg", true);
        }
        pString.value = str3;
        pString2.value = a;
        if (z && !bh.ov(str2) && i == 0) {
            e O = O(str2, i);
            if (!bh.ov(O.hzQ)) {
                String m;
                m = m(O.hzQ, "", "");
                if (bVar != null) {
                    bVar.sV();
                }
                FileOp.x(m, a);
                if (FileOp.me(m) <= 0) {
                    x.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[]{str, a});
                } else if (bh.ov(O.hAa)) {
                    return null;
                } else {
                    return O.hAa;
                }
            }
        }
        try {
            i2 = an.isWifi(ac.getContext()) ? bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressPicLevelForWifi"), 60) : an.is2G(ac.getContext()) ? bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressPicLevelFor2G"), 40) : an.is3G(ac.getContext()) ? bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressPicLevelFor3G"), 40) : bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressPicLevelFor4G"), 60);
        } catch (Exception e) {
            i2 = 0;
        }
        x.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[]{Integer.valueOf(i2)});
        if (i2 <= 10 || i2 > 100) {
            i3 = 70;
        } else {
            i3 = i2;
        }
        int i5 = 1080;
        try {
            if (an.isWifi(ac.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressResolutionForWifi");
            } else if (an.is2G(ac.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressResolutionFor2G");
            } else if (an.is3G(ac.getContext())) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressResolutionFor3G");
            } else {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressResolutionFor4G");
            }
            indexOf = value.indexOf("*");
            if (-1 != indexOf) {
                intValue = Integer.valueOf(value.substring(0, indexOf)).intValue();
                i2 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                i5 = intValue;
            } else {
                i2 = 1080;
                i5 = 0;
            }
            intValue = i5;
            i5 = i2;
        } catch (Exception e2) {
            intValue = 0;
        }
        try {
            int i6;
            i6 = bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("UseOptImage"), 0);
            com.tencent.mm.kernel.g.Dh();
            if ((((int) (new o(com.tencent.mm.kernel.a.Cg()).longValue() / 100)) % 100) + 1 <= i6) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i6), Long.valueOf(new o(com.tencent.mm.kernel.a.Cg()).longValue()), Long.valueOf(new o(com.tencent.mm.kernel.a.Cg()).longValue() / 100), Boolean.valueOf(com.tencent.mm.sdk.a.b.ceK()), Integer.valueOf(VERSION.SDK_INT)});
        } catch (Throwable e3) {
            x.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[]{bh.i(e3)});
            z2 = false;
        }
        if (com.tencent.mm.sdk.a.b.ceK()) {
            z2 = true;
        }
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            z3 = false;
        } else {
            z3 = z2;
        }
        x.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i5)});
        if (intValue <= 0 && i5 <= 0) {
            intValue = 0;
            i5 = 1080;
        } else if (i5 >= 2160) {
            intValue = 0;
            i5 = 1080;
        } else if (i5 <= 0 && intValue > 3240) {
            intValue = 1620;
            i5 = 0;
        }
        i2 = bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i2 <= 0) {
            i2 = 100;
        }
        int i7 = i2 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i2 = bh.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i2 <= 0 || i2 >= 100) {
            i4 = 10;
        } else {
            i4 = i2;
        }
        int queryQuality = MMNativeJpeg.queryQuality(str);
        Object obj = 1;
        if (queryQuality != 0 && queryQuality <= i3) {
            obj = null;
        }
        x.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[]{str, a, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i7), Integer.valueOf(i4)});
        if (z) {
            Options UL = d.UL(str);
            if (UL == null || UL.outWidth == 0 || UL.outHeight == 0) {
                m = "MicroMsg.ImgInfoStorage";
                String str4 = "genBigImg getImageOptions error:%s, origOptions_null:%b";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(UL == null);
                x.w(m, str4, objArr);
                return null;
            }
            int i8;
            Object obj2;
            boolean z4;
            long j;
            boolean z5;
            int i9 = UL.outWidth;
            int i10 = UL.outHeight;
            indexOf = UL.outWidth > UL.outHeight ? UL.outWidth : UL.outHeight;
            if (UL.outWidth < UL.outHeight) {
                i8 = UL.outWidth;
            } else {
                i8 = UL.outHeight;
            }
            if (i5 > 0) {
                intValue = i8 / i5;
                indexOf = (UL.outHeight * i5) / i8;
                i5 = (i5 * UL.outWidth) / i8;
                i8 = intValue;
                intValue = indexOf;
                indexOf = i5;
            } else {
                i5 = indexOf / intValue;
                i8 = (UL.outHeight * intValue) / indexOf;
                indexOf = (intValue * UL.outWidth) / indexOf;
                intValue = i8;
                i8 = i5;
            }
            if (intValue * indexOf > 10240000) {
                double sqrt = Math.sqrt(1.024E7d / ((double) (intValue * indexOf)));
                intValue = (int) (((double) intValue) / sqrt);
                indexOf = (int) (((double) indexOf) / sqrt);
            }
            x.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[]{Integer.valueOf(UL.outHeight), Integer.valueOf(UL.outWidth), Integer.valueOf(intValue), Integer.valueOf(indexOf)});
            m = UL != null ? UL.outMimeType : "";
            long me = FileOp.me(str);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str);
            if (m == null || !(m.endsWith("jpeg") || m.endsWith("jpg") || m.endsWith("bmp") || m.endsWith("png") || m.endsWith("gif"))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (i != 0 || ((r4 == null && me <= 204800 && (UL == null || r11 <= 0)) || me <= ((long) i7))) {
                x.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[]{Integer.valueOf(queryQuality), Long.valueOf(me), Integer.valueOf(i9), Integer.valueOf(i10)});
                if (obj2 != null) {
                    FileOp.x(str, a);
                } else {
                    if (d.a(false, str, i9, i10, CompressFormat.JPEG, 100, a, bVar) != 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 187, 1, false);
                        x.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[]{str});
                        return null;
                    }
                }
                com.tencent.mm.modelcdntran.g.MJ();
                if (!com.tencent.mm.modelcdntran.c.hu(256)) {
                    x.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                } else if (i == 1) {
                    int i11;
                    int i12;
                    int i13 = 0;
                    try {
                        i13 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressMidPicLevel")).intValue();
                    } catch (Exception e4) {
                    }
                    try {
                        i2 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("CompressMidPicSize")).intValue();
                    } catch (Exception e5) {
                        i2 = 0;
                    }
                    x.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[]{Integer.valueOf(i13), Integer.valueOf(i2)});
                    if (i13 <= 10 || i13 > 100) {
                        i13 = 52;
                    }
                    if (i2 <= 0 || i2 > 800) {
                        i5 = 800;
                    } else {
                        i5 = i2;
                    }
                    if (indexOf > i5) {
                        i11 = i5;
                    } else {
                        i11 = indexOf;
                    }
                    if (intValue > i5) {
                        i12 = i5;
                    } else {
                        i12 = intValue;
                    }
                    z2 = true;
                    if (queryQuality != 0 && queryQuality <= i13) {
                        z2 = false;
                    }
                    if (z2 || me > 800 || (UL != null && (i10 > i5 || i9 > i5))) {
                        pString3.value = com.tencent.mm.a.g.s((str + System.currentTimeMillis()).getBytes());
                        pString4.value = a(pString3.value, "", ".jpg", false);
                        x.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[]{pString3.value, pString4.value, Boolean.valueOf(false), Integer.valueOf(d.a(false, str, i12, i11, CompressFormat.JPEG, i13, pString4.value, bVar)), Integer.valueOf(i12), Integer.valueOf(i11)});
                        intValue = i2;
                        i7 = 38;
                        z4 = false;
                        j = 0;
                    } else {
                        pString3.value = pString.value;
                        pString4.value = pString2.value;
                        x.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i10), Integer.valueOf(i9), Integer.valueOf(i12), Integer.valueOf(i11), pString3.value, pString4.value});
                        j = 0;
                        intValue = 1;
                        i7 = 38;
                        z4 = false;
                    }
                }
                j = 0;
                intValue = 1;
                i7 = 38;
                z4 = false;
            } else {
                if (queryQuality < 55 || !IsJpegFile) {
                    z2 = false;
                } else {
                    z2 = z3;
                }
                if (z2) {
                    i7 = 18;
                } else {
                    i7 = 8;
                }
                long Wp = bh.Wp();
                i5 = d.a(z2, str, intValue, indexOf, CompressFormat.JPEG, i3, a, bVar);
                if (i5 == 1 || !z2) {
                    int i14 = i5;
                    z5 = z2;
                    i2 = i14;
                } else {
                    i7 = 28;
                    i2 = d.a(false, str, intValue, indexOf, CompressFormat.JPEG, i3, a, bVar);
                    z5 = false;
                }
                x.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[]{Long.valueOf(me), Long.valueOf(FileOp.me(a)), Long.valueOf((100 * FileOp.me(a)) / me), Integer.valueOf(i4), a});
                if (obj2 != null && (me - r6) * 100 < ((long) i4) * me) {
                    FileOp.x(str, a);
                    z5 = false;
                    i7 = 48;
                    i2 = 1;
                }
                long Wp2 = bh.Wp() - Wp;
                if (i2 != 1) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 187, 1, false);
                    x.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[]{str});
                    return null;
                }
                long j2 = Wp2;
                intValue = i2;
                z4 = z5;
                j = j2;
            }
            Options UL2 = d.UL(a);
            i8 = UL2 != null ? UL2.outWidth : -1;
            i6 = UL2 != null ? UL2.outHeight : -1;
            long me2 = FileOp.me(a);
            i4 = MMNativeJpeg.queryQuality(a);
            boolean IsJpegFile2 = MMNativeJpeg.IsJpegFile(a);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr2 = new Object[13];
            objArr2[0] = Integer.valueOf(intValue);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Integer.valueOf(i7);
            objArr2[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
            objArr2[4] = Long.valueOf(me);
            objArr2[5] = Integer.valueOf(i9);
            objArr2[6] = Integer.valueOf(i10);
            objArr2[7] = Integer.valueOf(i);
            objArr2[8] = Long.valueOf(me2);
            objArr2[9] = Integer.valueOf(i8);
            objArr2[10] = Integer.valueOf(i6);
            objArr2[11] = Integer.valueOf(queryQuality);
            objArr2[12] = Integer.valueOf(i4);
            gVar.h(11713, objArr2);
            x.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[]{Integer.valueOf(intValue), Boolean.valueOf(z4), Integer.valueOf(i7), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(me), Boolean.valueOf(IsJpegFile), Integer.valueOf(i8), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(me2), Boolean.valueOf(IsJpegFile2), str, a});
            if (i == 0 && me2 >= 40960 && IsJpegFile2 && !MMNativeJpeg.isProgressive(a)) {
                value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("EnableCDNUploadImg");
                if (!bh.ov(value) && value.equals("1")) {
                    long Wp3 = bh.Wp();
                    if (z4) {
                        String str5 = a + ".prog";
                        FileOp.x(a, str5);
                        z2 = (bh.ov(str5) || bh.ov(a) || !new File(str5).exists()) ? false : MMJpegOptim.convertToProgressive(str5, a, i3) == 0;
                        FileOp.deleteFile(str5);
                        if (z2) {
                            z5 = z2;
                            i2 = 19;
                        } else {
                            i2 = 29;
                            z5 = MMNativeJpeg.convertToProgressive(a, i3);
                        }
                    } else {
                        i2 = 9;
                        z5 = MMNativeJpeg.convertToProgressive(a, i3);
                    }
                    Wp3 = bh.Wp() - Wp3;
                    long me3 = FileOp.me(a);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
                    Integer[] numArr = new Object[14];
                    numArr[0] = Integer.valueOf(z5 ? 1 : -1);
                    numArr[1] = Long.valueOf(Wp3);
                    numArr[2] = Integer.valueOf(i2);
                    numArr[3] = Integer.valueOf(IsJpegFile ? 1 : 2);
                    numArr[4] = Long.valueOf(me);
                    numArr[5] = Integer.valueOf(i9);
                    numArr[6] = Integer.valueOf(i10);
                    numArr[7] = Integer.valueOf(i);
                    numArr[8] = Long.valueOf(me2);
                    numArr[9] = Integer.valueOf(i8);
                    numArr[10] = Integer.valueOf(i6);
                    numArr[11] = Integer.valueOf(queryQuality);
                    numArr[12] = Integer.valueOf(i4);
                    numArr[13] = Long.valueOf(me3);
                    gVar2.h(11713, numArr);
                    x.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[]{Integer.valueOf(intValue), Boolean.valueOf(z5), Long.valueOf(me3), Boolean.valueOf(z4), Integer.valueOf(i2), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(queryQuality), Long.valueOf(me), Boolean.valueOf(IsJpegFile), Integer.valueOf(i8), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(me2), Boolean.valueOf(IsJpegFile2), str, a});
                    if (!z5) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 186, 1, false);
                        x.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[]{a});
                    }
                }
            }
        }
        return null;
    }

    private e a(String str, int i, boolean z, int i2, int i3, PInt pInt, PInt pInt2, String str2, long j, String str3, String str4, com.tencent.mm.a.b bVar, com.tencent.mm.a.b bVar2, n.a aVar) {
        if (!FileOp.bO(str)) {
            return null;
        }
        String str5;
        String str6;
        PString pString;
        PString pString2;
        PString pString3;
        String a;
        String mk = FileOp.mk(str);
        x.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[]{str});
        if (FileOp.bO(str)) {
            if (bh.ov(str3)) {
                str3 = Ph();
            }
            str5 = "THUMBNAIL_DIRPATH://th_" + str3;
            String a2 = a(str5, "th_", "", false);
            if (bVar == null) {
                a2 = m(str5, "th_", "");
            }
            if (z) {
                if (bh.ov(str2) || !FileOp.bO(str2)) {
                    long Wq = bh.Wq();
                    a(str, i, i3, pInt, pInt2, true, a2, bVar);
                    if (FileOp.bO(a2)) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10921, new Object[]{Long.valueOf(FileOp.me(a2)), Long.valueOf(FileOp.me(str)), Integer.valueOf(90), Long.valueOf(bh.bA(Wq))});
                    } else {
                        x.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
                    }
                } else {
                    FileOp.x(str2, a2);
                }
                x.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str5);
            }
            str6 = str5;
        } else {
            x.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[]{str});
            str6 = null;
        }
        if (aVar == null || aVar.hzT != i) {
            com.tencent.mm.a.b bVar3;
            if (aVar == null || aVar.hzT == i) {
                bVar3 = bVar2;
                str5 = str4;
            } else {
                bVar3 = null;
                str5 = null;
            }
            pString = new PString();
            pString2 = new PString();
            pString3 = new PString();
            a = a(str, mk, i, z, pString, pString2, pString3, new PString(), str5, bVar3);
            x.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, r10.value});
        } else {
            n.a.a Pp = aVar.Pp();
            pString = Pp.hCf;
            pString2 = Pp.hCg;
            a = Pp.hAa;
            pString3 = Pp.hCh;
            PString pString4 = Pp.hCi;
            x.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i), pString3.value, pString4.value});
        }
        e eVar = new e();
        eVar.fDt = -1;
        long j2 = this.hAE;
        this.hAE = 1 + j2;
        eVar.bg(j2);
        eVar.bf(j);
        if (!bh.ov(a)) {
            eVar.lj(a);
        }
        eVar.hO(0);
        eVar.cOY = i2;
        eVar.hAo = true;
        if (i2 == 4) {
            if (str.startsWith(u.Fo())) {
                eVar.hN(3);
            } else {
                eVar.hN(2);
            }
        } else {
            eVar.hN(1);
        }
        if (z) {
            eVar.lg(pString.value + ".jpg");
            if (!bh.ov(pString3.value)) {
                eVar.lh(pString3.value + ".jpg");
            }
            if (bh.ov(eVar.hzS)) {
                eVar.li(str6);
            }
            eVar.hL((int) FileOp.me(pString2.value));
            if (eVar.hlp == 0) {
                x.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[]{pString2.value});
            }
            eVar.lf(mk);
        }
        eVar.hK((int) bh.Wo());
        eVar.hP(i);
        x.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + eVar.hlp);
        return eVar;
    }

    public final long a(byte[] bArr, long j, boolean z, String str, PString pString, PInt pInt, PInt pInt2) {
        return a(bArr, j, z, "", 0, str, pString, pInt, pInt2);
    }

    public final long a(byte[] bArr, long j, boolean z, String str, int i, String str2, PString pString, PInt pInt, PInt pInt2) {
        String str3 = "SERVERID://" + j;
        String s = com.tencent.mm.a.g.s(str3.getBytes());
        String m = m(s, "th_", "");
        if (bArr != null && bArr.length >= 0) {
            Bitmap bm = d.bm(bArr);
            if (bm == null) {
                x.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(bArr));
            }
            if (!(z || bm == null)) {
                try {
                    bm = d.P(bm);
                    pInt.value = bm.getWidth();
                    pInt2.value = bm.getHeight();
                    d.a(bm, 90, CompressFormat.JPEG, m, true);
                } catch (IOException e) {
                    x.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + s + " " + new String(bArr));
                }
            }
        }
        e eVar = new e();
        if (bh.ov(str)) {
            str = str3;
        } else {
            eVar.setOffset(i);
            eVar.hL(i);
        }
        eVar.fDt = -1;
        long j2 = this.hAE;
        this.hAE = 1 + j2;
        eVar.bg(j2);
        eVar.lg(str);
        eVar.li("THUMBNAIL_DIRPATH://th_" + s);
        pString.value = eVar.hzS;
        if (z) {
            eVar.ap(0);
        } else {
            eVar.ap(j);
        }
        eVar.lj(str2);
        eVar.hK((int) bh.Wo());
        long e2 = e(eVar);
        if (e2 != -1) {
            doNotify();
        }
        return e2;
    }

    public final int a(int i, e eVar) {
        return a(Long.valueOf((long) i), eVar);
    }

    public final int a(Long l, e eVar) {
        int i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        ContentValues vI = eVar.vI();
        if (vI.size() == 0) {
            i = 1;
        } else {
            i = this.hhp.update("ImgInfo2", vI, "id=?", new String[]{String.valueOf(l)});
        }
        x.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - valueOf.longValue()), vI.toString()});
        if (i != -1) {
            eVar.Pf();
            doNotify();
        }
        return i;
    }

    public final Bitmap a(long j, String str, int i, int i2, int i3, boolean z) {
        Object obj;
        if (z) {
            obj = "location_backgroup_key_from" + j;
        } else {
            String str2 = "location_backgroup_key_tor" + j;
        }
        Bitmap bitmap = (Bitmap) this.hAw.get(obj);
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        bitmap = d.j(str, i, i2, i3);
        this.hAw.l(obj, bitmap);
        return bitmap;
    }

    public final boolean a(String str, String str2, int i, int i2) {
        x.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bh.cgy()});
        long currentTimeMillis = System.currentTimeMillis();
        float density = a.getDensity(ac.getContext());
        if (bh.ov(str) || bh.ov(str2)) {
            return false;
        }
        String b = b(str2, false, true);
        if (bh.ov(b)) {
            return false;
        }
        String str3;
        String substring;
        int i3;
        int i4;
        boolean a;
        if (b.endsWith("hd")) {
            str3 = b;
            substring = b.substring(0, b.length() - 2);
        } else {
            str3 = b + "hd";
            substring = b;
        }
        Options UL = d.UL(substring);
        if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 185, 1, false);
            if (e.bN(substring) > 0) {
                return false;
            }
            UL = new Options();
            d.c(UL);
            x.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", new Object[]{UL, Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight)});
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 183, 1, false);
        }
        int i5 = (int) ((((float) UL.outWidth) * density) * 1.25f);
        int i6 = (int) ((((float) UL.outHeight) * density) * 1.25f);
        if (((float) i5) >= 160.0f * density || ((float) i6) >= 160.0f * density) {
            float f;
            if (i6 > i5) {
                f = (160.0f * density) / ((float) i6);
            } else {
                f = (160.0f * density) / ((float) i5);
            }
            i3 = (int) (((float) i5) * f);
            i4 = (int) (f * ((float) i6));
        } else {
            i4 = i6;
            i3 = i5;
        }
        i3 = Math.max(i3, i5);
        i6 = Math.max(i4, i6);
        if (i2 == 0) {
            try {
                a = d.a(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
            } catch (Exception e) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 184, 1, false);
                x.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", new Object[]{e.toString()});
                return false;
            }
        }
        a = d.b(str, i6, i3, CompressFormat.JPEG, str3, new PInt(), new PInt());
        x.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", new Object[]{(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i6), Integer.valueOf(i3), Boolean.valueOf(a)});
        a(substring, true, a.getDensity(ac.getContext()), true, false, true, i, false);
        if (a) {
            synchronized (this.hAD) {
                if (this.hAD.containsKey(str2) && !((String) this.hAD.get(str2)).endsWith("hd")) {
                    this.hAD.put(str2, str3);
                }
            }
            return a;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 184, 1, false);
        return a;
    }

    public final String b(String str, boolean z, boolean z2) {
        if (str != null && this.hAD.containsKey(str)) {
            return (String) this.hAD.get(str);
        }
        String str2;
        if (z) {
            str2 = str;
        } else {
            str2 = B(str, z2);
        }
        if (bh.ov(str2)) {
            return str2;
        }
        this.hAD.put(str, str2);
        return str2;
    }

    public final String ln(String str) {
        return b(str, false, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String p(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
            return null;
        }
        e bi;
        long currentTimeMillis = System.currentTimeMillis();
        if (auVar.field_isSend == 1) {
            bi = o.Pw().bi(auVar.field_msgId);
        }
        bi = o.Pw().bh(auVar.field_msgSvrId);
        if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
            if (auVar.field_isSend == 1) {
                String c = f.c(bi);
                String m = o.Pw().m(c, "", "");
                if (c != null && c.length() > 0 && FileOp.bO(m)) {
                    return m;
                }
                m = bi.hzQ;
                String m2 = o.Pw().m(m, "", "");
                if (m != null && m.length() > 0 && FileOp.bO(m2)) {
                    return m2;
                }
            } else if (bi.Pd()) {
                String str = bi.hzQ;
                if (bi.Pe()) {
                    bi = f.a(bi);
                    if (bi != null && bi.hzP > 0 && bi.Pd() && FileOp.bO(o.Pw().m(bi.hzQ, "", ""))) {
                        return bi.hzQ;
                    }
                }
                return str;
            }
        }
        x.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
        return null;
    }
}
