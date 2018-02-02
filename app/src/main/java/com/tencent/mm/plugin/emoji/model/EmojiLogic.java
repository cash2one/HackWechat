package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static final String lxr = File.separator;

    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int aj(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return EmojiInfo.xAa;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return EmojiInfo.xAl;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return EmojiInfo.xAm;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return EmojiInfo.xAn;
        }
        return EmojiInfo.xAa;
    }

    public static String yd(String str) {
        String str2 = null;
        if (!bh.ov(str)) {
            int bN = e.bN(str);
            if (bN > 0) {
                byte[] d = e.d(str, 0, bN);
                str2 = g.s(d);
                if (!(str2 == null && d == null)) {
                    ar.Hg();
                    e.b(c.Fp() + str2, d, d.length);
                    if (p.bo(d)) {
                        i.aBE().lwL.a(str2, "", EmojiInfo.xAe, EmojiInfo.xAm, d.length, "", "");
                    } else {
                        i.aBE().lwL.a(str2, "", EmojiInfo.xAe, EmojiInfo.xAl, d.length, "", "");
                    }
                }
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        if (wXMediaMessage.getType() != 8) {
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!bh.bw(wXEmojiObject.emojiData)) {
            x.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String s = g.s(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, s, wXEmojiObject.emojiData, str);
            return s;
        } else if (bh.ov(wXEmojiObject.emojiPath)) {
            return null;
        } else {
            int bN = e.bN(wXEmojiObject.emojiPath);
            if (bN <= 0) {
                return null;
            }
            byte[] d = e.d(wXEmojiObject.emojiPath, 0, bN);
            String s2 = g.s(d);
            a(context, wXMediaMessage.thumbData, s2, d, str);
            return s2;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        if (str != null || bArr2 != null) {
            EmojiInfo a;
            ar.Hg();
            String Fp = c.Fp();
            e.b(Fp + str, bArr2, bArr2.length);
            if (p.bo(bArr2)) {
                a = i.aBE().lwL.a(str, "", EmojiInfo.xAe, EmojiInfo.xAo, bArr2.length, str2, "");
            } else {
                a = i.aBE().lwL.a(str, "", EmojiInfo.xAe, EmojiInfo.xAp, bArr2.length, str2, "");
            }
            a(context, bArr, str, Fp, a);
        }
    }

    public static void a(Context context, byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap bitmap;
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            x.d(str3, str4, objArr);
            if (emojiInfo != null) {
                Bitmap fn = emojiInfo.fn(context);
            } else {
                return;
            }
        }
        fn = d.bl(bArr);
        if (fn == null || (fn.getWidth() <= 300 && fn.getHeight() <= 300)) {
            bitmap = fn;
        } else {
            int width = fn.getWidth();
            int height = fn.getHeight();
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", new Object[]{Integer.valueOf(width), Integer.valueOf(height)});
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", new Object[]{Integer.valueOf(height), Integer.valueOf(width)});
            bitmap = d.a(fn, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    d.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
                    return;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
            }
        }
    }

    public static EmojiInfo a(String str, String str2, i iVar) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            EmojiInfo a = a(str, 4, str2, true);
            if (a == null) {
                o.PA().a(str2, null, f.b(str, str2, new Object[0]), iVar);
                x.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", new Object[]{str2});
            }
            return a;
        } else if (ac.getContext() == null || ac.getContext().getResources() == null) {
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.xAl;
            return null;
        }
    }

    public static EmojiInfo a(String str, int i, String str2, boolean z) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            x.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            return null;
        }
        int i3;
        EmojiInfo emojiInfo = new EmojiInfo();
        if (z) {
            ar.Hg();
            String G = G(c.Fp(), str, str2);
            if (e.bO(G)) {
                File file = new File(G);
                if (file.exists()) {
                    if (file.length() < 1) {
                        file.delete();
                    } else {
                        emojiInfo.field_type = aj(e.d(G, 0, 10));
                        i2 = 1;
                    }
                }
            }
            if (i2 == 0) {
                x.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + G + "...., icon type:" + i);
                return null;
            }
        }
        ar.Hg();
        if (!e.bO(G(c.Fp(), str, str2))) {
            x.d("MicroMsg.emoji.EmojiLogic", "icon file no exist. path:%s type:%d, url:%s", new Object[]{G(c.Fp(), str, str2), Integer.valueOf(i), str2});
            return null;
        }
        emojiInfo.field_md5 = cl(str, str2);
        switch (i) {
            case 2:
                i3 = 82;
                break;
            case 4:
                i3 = 83;
                break;
            case 8:
                i3 = 84;
                break;
            default:
                i3 = EmojiInfo.xAg;
                break;
        }
        emojiInfo.field_catalog = i3;
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        return emojiInfo;
    }

    public static boolean a(String str, String str2, EmojiGroupInfo emojiGroupInfo) {
        ZipFile zipFile;
        OutputStream outputStream;
        Exception e;
        OutputStream outputStream2;
        Throwable th;
        OutputStream outputStream3;
        String str3 = com.tencent.mm.compatible.util.e.gHs + str;
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(c.Fp()).append(str).toString();
        InputStream inputStream = null;
        ZipFile zipFile2 = null;
        HashMap hashMap = new HashMap();
        Object arrayList = new ArrayList();
        OutputStream outputStream4;
        InputStream inputStream2;
        try {
            zipFile = new ZipFile(str3);
            try {
                ZipEntry zipEntry;
                InputStream inputStream3;
                byte[] bArr;
                int read;
                EmojiInfo XU;
                Enumeration entries = zipFile.entries();
                int i = 0;
                outputStream4 = null;
                inputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.isDirectory()) {
                            inputStream3 = inputStream2;
                            outputStream = outputStream4;
                        } else {
                            inputStream = zipFile.getInputStream(zipEntry);
                            try {
                                String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                                File file = new File(stringBuilder2 + "/" + zipEntry.getName());
                                if (file.isFile()) {
                                    file.delete();
                                }
                                file.getParentFile().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream = new FileOutputStream(stringBuilder2 + File.separator + toLowerCase);
                                        try {
                                            int i2;
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream.write(bArr, 0, read);
                                            }
                                            outputStream.close();
                                            outputStream4 = null;
                                            String bV = g.bV(stringBuilder2 + File.separator + toLowerCase);
                                            x.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", new Object[]{bV, Integer.valueOf(i)});
                                            File file2 = new File(stringBuilder2 + File.separator + toLowerCase);
                                            File file3 = new File(stringBuilder2 + File.separator + bV);
                                            if (p.UR(file2.getPath())) {
                                                i2 = EmojiInfo.xAm;
                                            } else {
                                                i2 = EmojiInfo.xAl;
                                            }
                                            XU = i.aBE().lwL.XU(bV);
                                            if (XU == null) {
                                                XU = new EmojiInfo();
                                                XU.field_catalog = 0;
                                            }
                                            XU.field_name = toLowerCase;
                                            XU.field_md5 = bV;
                                            XU.field_size = (int) file2.length();
                                            XU.field_type = i2;
                                            XU.field_groupId = str;
                                            XU.field_idx = i;
                                            arrayList.add(XU);
                                            file2.renameTo(file3);
                                            hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), bV);
                                            outputStream = null;
                                            inputStream3 = inputStream;
                                        } catch (Exception e2) {
                                            e = e2;
                                            zipFile2 = zipFile;
                                            outputStream2 = outputStream;
                                            inputStream2 = inputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            outputStream4 = outputStream;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream = new FileOutputStream(stringBuilder2 + File.separator + (g.s(str.getBytes()) + "_panel_enable"));
                                        try {
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream.write(bArr, 0, read);
                                            }
                                            outputStream.close();
                                            outputStream = null;
                                            inputStream3 = inputStream;
                                        } catch (Exception e3) {
                                            e = e3;
                                            zipFile2 = zipFile;
                                            outputStream2 = outputStream;
                                            inputStream2 = inputStream;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream4 = outputStream;
                                        }
                                    }
                                }
                                outputStream = outputStream4;
                                inputStream3 = inputStream;
                            } catch (Exception e4) {
                                e = e4;
                                inputStream2 = inputStream;
                                outputStream3 = outputStream4;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream3;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                                inputStream3 = null;
                            } catch (Exception e5) {
                                Exception exception = e5;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream;
                                inputStream2 = inputStream3;
                                e = exception;
                            } catch (Throwable th5) {
                                inputStream = inputStream3;
                                th = th5;
                                outputStream4 = outputStream;
                            }
                        }
                        i++;
                        outputStream4 = outputStream;
                        inputStream2 = inputStream3;
                    } catch (Exception e6) {
                        e = e6;
                        ZipFile zipFile3 = zipFile;
                        outputStream2 = outputStream4;
                        zipFile2 = zipFile3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStream2;
                    }
                }
                Enumeration entries2 = zipFile.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (zipEntry.isDirectory()) {
                        inputStream3 = inputStream2;
                        outputStream = outputStream4;
                    } else {
                        inputStream = zipFile.getInputStream(zipEntry);
                        String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                        File file4 = new File(stringBuilder2 + "/" + zipEntry.getName());
                        if (file4.isFile()) {
                            file4.delete();
                        }
                        file4.getParentFile().mkdirs();
                        if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                            int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                            String str4 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                            outputStream = new FileOutputStream(stringBuilder2 + File.separator + str4);
                            try {
                                bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                while (true) {
                                    read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    outputStream.write(bArr, 0, read);
                                }
                                outputStream.close();
                                outputStream4 = null;
                                String substring = str4.substring(0, str4.lastIndexOf("_cover."));
                                if (hashMap.containsKey(substring)) {
                                    substring = (String) hashMap.get(substring);
                                    new File(stringBuilder2 + File.separator + str4).renameTo(new File(stringBuilder2 + File.separator + substring + "_cover"));
                                    hashMap.put(str4, substring);
                                }
                                outputStream = null;
                                inputStream3 = inputStream;
                            } catch (Exception e7) {
                                e = e7;
                                zipFile2 = zipFile;
                                outputStream2 = outputStream;
                                inputStream2 = inputStream;
                            } catch (Throwable th7) {
                                th = th7;
                                outputStream4 = outputStream;
                            }
                        } else {
                            outputStream = outputStream4;
                            inputStream3 = inputStream;
                        }
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                        inputStream3 = null;
                    }
                    outputStream4 = outputStream;
                    inputStream2 = inputStream3;
                }
                hashMap.clear();
                if (emojiGroupInfo == null) {
                    emojiGroupInfo = i.aBE().lwM.bf(str, false);
                }
                emojiGroupInfo.field_productID = str;
                if (!bh.ov(str2)) {
                    emojiGroupInfo.field_packName = str2;
                }
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                emojiGroupInfo.field_status = 7;
                emojiGroupInfo.field_packStatus = 1;
                emojiGroupInfo.field_type = EmojiGroupInfo.xzY;
                emojiGroupInfo.field_recommand = 0;
                emojiGroupInfo.field_sync = 2;
                emojiGroupInfo.field_count = arrayList.size();
                if (i.aBE().lwL.k(arrayList, str)) {
                    boolean c = i.aBE().lwM.c(emojiGroupInfo);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        XU = (EmojiInfo) it.next();
                        XU.field_reserved4 = 0;
                        com.tencent.mm.plugin.emoji.e.e.aAR().c(XU, true);
                    }
                    x.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", new Object[]{Boolean.valueOf(c), Boolean.valueOf(r6)});
                } else {
                    x.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", new Object[]{Boolean.valueOf(i.aBE().lwL.k(arrayList, str))});
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                zipFile.close();
                return true;
            } catch (Exception e8) {
                e = e8;
                zipFile2 = zipFile;
                outputStream2 = null;
                inputStream2 = null;
                try {
                    x.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                    return false;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = inputStream2;
                    outputStream3 = outputStream2;
                    zipFile = zipFile2;
                    outputStream4 = outputStream3;
                    if (outputStream4 != null) {
                        outputStream4.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                outputStream4 = null;
                if (outputStream4 != null) {
                    outputStream4.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            outputStream2 = null;
            inputStream2 = null;
            x.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            zipFile = null;
            outputStream4 = null;
            if (outputStream4 != null) {
                outputStream4.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static abt aBu() {
        abt com_tencent_mm_protocal_c_abt = new abt();
        com_tencent_mm_protocal_c_abt.wkA = 1;
        com_tencent_mm_protocal_c_abt.wkC = 1;
        return com_tencent_mm_protocal_c_abt;
    }

    public static String yo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static String i(int i, String str, String str2) {
        if (i == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<designeruin>" + i + "</designeruin>");
        stringBuilder.append("<designername>" + str + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int yj(String str) {
        int bY;
        Exception e;
        try {
            bY = com.tencent.mm.a.o.bY((String) bi.y(str, "xml").get(".xml.designeruin"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{Integer.valueOf(bY)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
                return bY;
            }
        } catch (Exception e3) {
            e = e3;
            bY = 0;
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
            return bY;
        }
        return bY;
    }

    public static String yk(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.designername");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String yp(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.designerrediretcturl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String yi(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.productid");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "productId:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String yh(String str) {
        x.d("MicroMsg.emoji.EmojiLogic", "url:%s", new Object[]{str});
        String str2 = "";
        if (TextUtils.isEmpty(str) || !str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            return str2;
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<tid>" + i + "</tid>");
        stringBuilder.append("<title>" + str + "</title>");
        stringBuilder.append("<desc>" + str2 + "</desc>");
        stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
        stringBuilder.append("<pageType>" + i2 + "</pageType>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int yq(String str) {
        int VI;
        Exception e;
        try {
            VI = bh.VI((String) bi.y(str, "xml").get(".xml.tid"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "tid:%s", new Object[]{Integer.valueOf(VI)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
                return VI;
            }
        } catch (Exception e3) {
            e = e3;
            VI = 0;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
            return VI;
        }
        return VI;
    }

    public static String yr(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.title");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "title:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String ys(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.desc");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "desc:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String yt(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bi.y(str, "xml").get(".xml.iconUrl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String yu(String str) {
        String az;
        Exception e;
        String str2 = "";
        try {
            az = bh.az((String) bi.y(str, "xml").get(".xml.secondUrl"), "");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", new Object[]{az});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
                return az;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            az = str2;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
            return az;
        }
        return az;
    }

    public static int yv(String str) {
        int VI;
        Exception e;
        try {
            VI = bh.VI((String) bi.y(str, "xml").get(".xml.pageType"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", new Object[]{Integer.valueOf(VI)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
                return VI;
            }
        } catch (Exception e3) {
            e = e3;
            VI = 0;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
            return VI;
        }
        return VI;
    }

    public static String G(String str, String str2, String str3) {
        if (bh.ov(str2) && bh.ov(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String cl = cl(str2, str3);
        if (bh.ov(cl)) {
            return null;
        }
        if (bh.ov(str2)) {
            return str + cl;
        }
        return str + str2 + lxr + cl;
    }

    public static String H(String str, String str2, String str3) {
        String str4 = null;
        if (bh.ov(str2) && bh.ov(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
        } else {
            if (!bh.ov(str3)) {
                if (bh.ov(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + lxr + str3;
                }
            }
            x.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", new Object[]{str2, str3, str4});
        }
        return str4;
    }

    private static String cl(String str, String str2) {
        if (bh.ov(str) && bh.ov(str2)) {
            x.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            return null;
        } else if (bh.ov(str2)) {
            return g.s(str.getBytes());
        } else {
            return g.s(str2.getBytes());
        }
    }

    public static boolean yw(String str) {
        if (!bh.ov(str)) {
            try {
                if (b.kK(str)) {
                    x.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", new Object[]{str});
                    return true;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", new Object[]{bh.i(e)});
            }
        }
        return false;
    }
}
