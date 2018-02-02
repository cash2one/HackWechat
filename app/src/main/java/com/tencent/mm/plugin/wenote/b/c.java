package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.bi.a;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class c {
    public static HashMap<String, String> tWo = new HashMap();
    public static HashMap<String, q> tWp = new HashMap();
    public static c tWq = null;
    private static f<String, Integer> tWr = new f(30);

    public static String fa(String str, String str2) {
        String str3;
        int i = 1280;
        if (bh.ov(str2)) {
            str3 = a.Vk() + "/" + (g.s((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (e.bO(str3)) {
            return str3;
        }
        Options UL = d.UL(str);
        if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
            x.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
            return null;
        }
        int i2 = UL.outHeight;
        int i3 = UL.outWidth;
        if (i3 > 1280) {
            i3 = 1280;
        }
        if (i2 <= 1280) {
            i = i2;
        }
        if (UL.outHeight < UL.outWidth) {
            int i4 = i3;
            i3 = i;
            i = i4;
        }
        if (d.UM(str) > 0) {
            i2 = UL.outHeight;
            i3 = UL.outWidth;
        } else {
            i2 = i;
        }
        d.b(str, i2, i3, CompressFormat.JPEG, 95, str3);
        return str3;
    }

    public static String fb(String str, String str2) {
        String str3;
        int i = 800;
        if (bh.ov(str2)) {
            str3 = a.Vk() + "/" + (g.s((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (e.bO(str3)) {
            return str3;
        }
        Options UL = d.UL(str);
        if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
            x.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
            return null;
        }
        int i2 = UL.outHeight;
        int i3 = UL.outWidth;
        while (i3 * i2 > 2764800) {
            i3 >>= 1;
            i2 >>= 1;
        }
        if (i3 > 800) {
            i3 = 800;
        }
        if (i2 <= 800) {
            i = i2;
        }
        if (UL.outHeight < UL.outWidth) {
            i2 = i3;
            i3 = i;
        } else {
            i2 = i;
        }
        d.b(str, i2, i3, CompressFormat.JPEG, 95, str3);
        return str3;
    }

    public static Bitmap QU(String str) {
        Bitmap aY = com.tencent.mm.pluginsdk.model.c.aY(str, false);
        if (aY != null) {
            return aY;
        }
        if (bh.ov(null)) {
            return null;
        }
        return com.tencent.mm.pluginsdk.model.c.aY(null, false);
    }

    public static b c(b bVar) {
        if (bVar == null) {
            return null;
        }
        b gVar;
        switch (bVar.getType()) {
            case -1:
                gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                break;
            case 1:
                gVar = new h();
                ((h) gVar).content = ((h) bVar).content;
                break;
            case 2:
                gVar = new com.tencent.mm.plugin.wenote.model.a.e();
                ((com.tencent.mm.plugin.wenote.model.a.e) gVar).tRR = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).tRR;
                break;
            case 3:
                gVar = new com.tencent.mm.plugin.wenote.model.a.f();
                com.tencent.mm.plugin.wenote.model.a.f fVar = (com.tencent.mm.plugin.wenote.model.a.f) gVar;
                com.tencent.mm.plugin.wenote.model.a.f fVar2 = (com.tencent.mm.plugin.wenote.model.a.f) bVar;
                fVar.lat = fVar2.lat;
                fVar.lng = fVar2.lng;
                fVar.tSd = fVar2.tSd;
                fVar.hxu = fVar2.hxu;
                fVar.nTe = fVar2.nTe;
                break;
            case 4:
                gVar = new k();
                k kVar = (k) gVar;
                k kVar2 = (k) bVar;
                kVar.tSg = kVar2.tSg;
                kVar.length = kVar2.length;
                kVar.tSf = kVar2.tSf;
                kVar.tRN = kVar2.tRN;
                kVar.fvy = kVar2.fvy;
                kVar.fvx = kVar2.fvx;
                kVar.tRF = kVar2.tRF;
                break;
            case 5:
                gVar = new com.tencent.mm.plugin.wenote.model.a.c();
                com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) gVar;
                com.tencent.mm.plugin.wenote.model.a.c cVar2 = (com.tencent.mm.plugin.wenote.model.a.c) bVar;
                cVar.title = cVar2.title;
                cVar.content = cVar2.content;
                cVar.tRN = cVar2.tRN;
                cVar.tRF = cVar2.tRF;
                break;
            case 6:
                gVar = new j();
                j jVar = (j) gVar;
                j jVar2 = (j) bVar;
                jVar.fvC = jVar2.fvC;
                jVar.duration = jVar2.duration;
                jVar.tRF = jVar2.tRF;
                break;
            default:
                gVar = null;
                break;
        }
        if (gVar == null) {
            return null;
        }
        ((n) gVar).type = ((n) bVar).type;
        ((n) gVar).tRQ = ((n) bVar).tRQ;
        ((n) gVar).fCa = ((n) bVar).fCa;
        return gVar;
    }

    public static String d(b bVar) {
        if (bVar == null) {
            return "";
        }
        if (bVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.e) bVar).tRR;
        }
        return ((n) bVar).fCa;
    }

    public static String e(b bVar) {
        if (bVar == null) {
            return "";
        }
        if (bVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.e) bVar).fCa;
        }
        if (bVar.getType() == 6) {
            return ((j) bVar).fvC;
        }
        return "";
    }

    public static int QV(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        return QX(b.QT(str));
    }

    public static int c(String str, int i, int i2, boolean z) {
        if (bh.ov(str)) {
            return 0;
        }
        Spanned QN = com.tencent.mm.plugin.wenote.model.nativenote.a.a.QN(str);
        if (QN == null) {
            return 0;
        }
        if (z) {
            i2 = QN.length();
        }
        if (i < 0 || i > QN.length() || i2 < 0 || i2 > QN.length() || i > i2) {
            return 0;
        }
        QN = (Spanned) QN.subSequence(i, i2);
        if (QN == null) {
            return 0;
        }
        return QX(QN.toString());
    }

    public static int QW(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        if (tWr.bt(str)) {
            return ((Integer) tWr.get(str)).intValue();
        }
        int QX = QX(str);
        tWr.put(str, Integer.valueOf(QX));
        return QX;
    }

    private static int QX(String str) {
        int i = 0;
        if (bh.ov(str)) {
            return 0;
        }
        int i2 = 0;
        while (i < str.length()) {
            i2 += str.charAt(i) <= '' ? 1 : 2;
            i++;
        }
        return i2;
    }

    public static String a(Context context, b bVar) {
        if (bVar == null) {
            return "";
        }
        int type = bVar.getType();
        if (type == 1) {
            return ((h) bVar).content;
        }
        if (type == 3) {
            return context.getString(R.l.eXM);
        }
        if (type == 2) {
            return context.getString(R.l.eXL);
        }
        if (type == 6) {
            return context.getString(R.l.eXN);
        }
        if (type == 4) {
            return context.getString(R.l.eXO);
        }
        if (type == 5) {
            return context.getString(R.l.eXK);
        }
        return "";
    }

    public static String QY(String str) {
        return Pattern.compile("wa-b>", 2).matcher(Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(Pattern.compile("</wn-todo>", 2).matcher(Pattern.compile("</wx-li>", 2).matcher(Pattern.compile("wx-b>", 2).matcher(str).replaceAll("wa-b>")).replaceAll("<br/>")).replaceAll("<br/>")).replaceAll("")).replaceAll("wx-b>");
    }

    public static String QZ(String str) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        Throwable e2;
        IOException e3;
        Exception e4;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(bArr, "UTF-8");
                try {
                    fileInputStream.close();
                    return str2;
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.WNNoteUtil", e5, "", new Object[0]);
                    return str2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                try {
                    x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath FileNotFoundException error,%s", new Object[]{e.toString()});
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.WNNoteUtil", e22, "", new Object[0]);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e52) {
                            x.printErrStackTrace("MicroMsg.WNNoteUtil", e52, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e7) {
                e3 = e7;
                x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath IOException error,%s", new Object[]{e3.toString()});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.WNNoteUtil", e222, "", new Object[0]);
                    }
                }
                return "";
            } catch (Exception e8) {
                e4 = e8;
                x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath Exception error,%s", new Object[]{e4.toString()});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.WNNoteUtil", e2222, "", new Object[0]);
                    }
                }
                return "";
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath FileNotFoundException error,%s", new Object[]{e.toString()});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (IOException e10) {
            e3 = e10;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath IOException error,%s", new Object[]{e3.toString()});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Exception e11) {
            e4 = e11;
            fileInputStream = null;
            x.e("MicroMsg.WNNoteUtil", "getStringFromFilePath Exception error,%s", new Object[]{e4.toString()});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th2) {
            e2222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2222;
        }
    }
}
