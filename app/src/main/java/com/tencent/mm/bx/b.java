package com.tencent.mm.bx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.api.c;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.m.a$a;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b extends c {
    public static final String xkp = (e.gZJ + "app_font");
    public static final String xkq = (xkp + File.separator + "color_emoji");
    private static final boolean xkr = (VERSION.SDK_INT < 19);
    private static b xks;
    private LinkedList<c> jUz;
    private Context mContext = ac.getContext();
    public SparseArray<c> xkA = new SparseArray();
    private SparseArray<c> xkB = new SparseArray();
    private SparseArray<SparseArray<c>> xkC = new SparseArray();
    private SparseArray<String> xkD = null;
    private z<Integer, Bitmap> xkE = new z(200);
    private boolean xkF = false;
    private LinkedList<d> xkG;
    private final Factory xkH = new 1(this);
    private int xkt = 0;
    private int xku;
    private int xkv;
    private int xkw;
    public long xkx = 0;
    private a xky = new a();
    private SparseArray<c> xkz = new SparseArray();

    private b() {
        if (com.tencent.mm.a.e.bO(xkq)) {
            x.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            cgY();
            k.A(this.mContext, "color_emoji", xkq);
            x.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        init();
        if (a.ey(this.mContext)) {
            this.xkt = a.fromDPToPix(this.mContext, 4);
        } else {
            this.xkt = a.fromDPToPix(this.mContext, 2);
        }
    }

    public static b cgX() {
        if (xks == null) {
            synchronized (b.class) {
                xks = new b();
            }
        }
        return xks;
    }

    public static void cgY() {
        File file = new File(xkp);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void init() {
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(new File(xkq));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    this.xkw = dataInputStream.readInt();
                    this.xkx = dataInputStream.readLong();
                    this.xku = dataInputStream.readInt();
                    this.xkv = ((this.xku + 4) + 8) + 4;
                    byte[] bArr = new byte[this.xku];
                    dataInputStream.read(bArr);
                    this.xky.aF(bArr);
                    cgZ();
                    this.xkF = true;
                    x.i("MicroMsg.EmojiHelper", "init time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                    try {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                                return;
                            }
                        }
                        if (inputStream == null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        fileInputStream = inputStream;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                                throw e22;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e22;
                }
            } catch (Exception e5) {
                e22 = e5;
                dataInputStream = null;
                inputStream = fileInputStream;
                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th3) {
                e22 = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        } catch (Exception e6) {
            e22 = e6;
            dataInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream == null) {
                inputStream.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static long Wg(String str) {
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream = null;
        InputStream fileInputStream;
        try {
            DataInputStream dataInputStream2;
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                inputStream = fileInputStream;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    fileInputStream.close();
                    return readLong;
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                    return readLong;
                }
            } catch (IOException e6) {
                e3 = e6;
                dataInputStream = dataInputStream2;
                inputStream = fileInputStream;
                x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e7) {
            e3 = e7;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public static int Wh(String str) {
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                inputStream = fileInputStream;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                int readInt = dataInputStream.readInt();
                try {
                    dataInputStream.close();
                    fileInputStream.close();
                    return readInt;
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e42, "", new Object[0]);
                    return readInt;
                }
            } catch (IOException e5) {
                e3 = e5;
                inputStream = fileInputStream;
                x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return 0;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e6) {
            e3 = e6;
            dataInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        return (SpannableString) a(spannableString, i, pInt, this.xkH);
    }

    public final Spannable a(Spannable spannable, int i, PInt pInt, Factory factory) {
        if (spannable == null || spannable.length() == 0) {
            return spannable;
        }
        String obj = spannable.toString();
        List<a> linkedList = new LinkedList();
        int length = obj.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = obj.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = obj.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c Dk = cgX().Dk(codePointAt2);
            if (Dk != null) {
                linkedList.add(new a(this, Dk, i2, i2 + 1, true));
            } else {
                Dk = cgX().eH(codePointAt2, codePointAt);
                if (Dk != null) {
                    int charCount2;
                    if (Dk.xkM != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    linkedList.add(new a(this, Dk, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            return spannable;
        }
        Spannable newSpannable;
        if (xkr) {
            StringBuilder stringBuilder = new StringBuilder(obj);
            for (a aVar : linkedList) {
                if (!aVar.xkK) {
                    if (aVar.xkJ.xkN == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.xkJ.xkN));
                    }
                }
            }
            newSpannable = factory.newSpannable(stringBuilder.toString());
        } else {
            newSpannable = spannable;
        }
        for (a aVar2 : linkedList) {
            a(newSpannable, cgX().a(aVar2.xkJ), aVar2.start, aVar2.end, i);
        }
        pInt.value -= linkedList.size();
        return newSpannable;
    }

    public static boolean Wi(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (cgX().Dk(codePointAt) != null) {
                return true;
            }
            if (cgX().eH(codePointAt, i) != null) {
                return true;
            }
            i = charCount;
        }
        return false;
    }

    public final String Wj(String str) {
        if (bh.ov(str)) {
            return str;
        }
        int i;
        if (this.xkD == null) {
            Context context = ac.getContext();
            String d = w.d(context.getSharedPreferences(ac.cfs(), 0));
            String[] stringArray = d.equals("zh_CN") ? context.getResources().getStringArray(a$a.lIJ) : (d.equals("zh_TW") || d.equals("zh_HK")) ? context.getResources().getStringArray(a$a.lIL) : context.getResources().getStringArray(a$a.lIK);
            String[] stringArray2 = context.getResources().getStringArray(a$a.lII);
            this.xkD = new SparseArray();
            i = 0;
            while (i < stringArray2.length && i < stringArray.length) {
                this.xkD.put(stringArray2[i].charAt(0), stringArray[i]);
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c Dk = cgX().Dk(codePointAt2);
            if (Dk != null) {
                d = (String) this.xkD.get(Dk.xkN);
                if (d != null) {
                    stringBuilder.append(d);
                } else {
                    stringBuilder.append(this.mContext.getString(h.dEH));
                }
            } else {
                Dk = cgX().eH(codePointAt2, codePointAt);
                if (Dk != null) {
                    if (Dk.xkM != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    d = (String) this.xkD.get(Dk.xkN);
                    if (d != null) {
                        stringBuilder.append(d);
                    } else {
                        stringBuilder.append(this.mContext.getString(h.dEH));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String fy(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            if (cgX().Dk(codePointAt2) != null) {
                stringBuilder.append(str2);
            } else {
                c eH = cgX().eH(codePointAt2, codePointAt);
                if (eH != null) {
                    if (eH.xkM != 0) {
                        codePointAt = Character.charCount(codePointAt) + i;
                    } else {
                        codePointAt = i;
                    }
                    stringBuilder.append(str2);
                    i = codePointAt;
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable, 1);
            eVar.zsZ = this.xkt;
            spannable.setSpan(eVar, i, i2, 33);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    public final c eH(int i, int i2) {
        if (this.xkG == null || this.xkG.isEmpty() || this.xkF) {
            this.xkG = new LinkedList(this.xky.xkn);
            this.xkF = false;
        }
        if (this.xkG == null || this.xkG.isEmpty()) {
            return null;
        }
        Iterator it = this.xkG.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.sXn || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.xkC.get(i);
        if (sparseArray == null) {
            return null;
        }
        if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            return (c) sparseArray.get(i2);
        }
        return (c) sparseArray.get(0);
    }

    public final c Dk(int i) {
        if (i < 57345 || i > 58679) {
            return null;
        }
        return (c) this.xkz.get(i);
    }

    public final Drawable mf(int i) {
        return a((c) this.xkB.get(i));
    }

    public final Drawable a(c cVar) {
        if (cVar == null) {
            x.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.xkE.get(Integer.valueOf(cVar.hlq));
            if (bitmap != null && !bitmap.isRecycled()) {
                return new BitmapDrawable(ac.getContext().getResources(), bitmap);
            }
            byte[] d = com.tencent.mm.a.e.d(xkq, cVar.hlq + this.xkv, cVar.size);
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length, options);
            if (decodeByteArray != null) {
                decodeByteArray.setDensity(240);
                this.xkE.put(Integer.valueOf(cVar.hlq), decodeByteArray);
                return new BitmapDrawable(ac.getContext().getResources(), decodeByteArray);
            }
            String str = "MicroMsg.EmojiHelper";
            String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(cVar.size);
            objArr[1] = Integer.valueOf(d == null ? 0 : d.length);
            x.i(str, str2, objArr);
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    private void cgZ() {
        this.jUz = new LinkedList(this.xky.xko);
        if (this.jUz == null || this.jUz.isEmpty()) {
            x.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            return;
        }
        Iterator it = this.jUz.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.xkL != 0) {
                SparseArray sparseArray = (SparseArray) this.xkC.get(cVar.xkL);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.xkC.append(cVar.xkL, sparseArray);
                }
                sparseArray.put(cVar.xkM, cVar);
                if (cVar.xkN != 0) {
                    this.xkz.append(cVar.xkN, cVar);
                }
                if (cVar.xkO != -1) {
                    this.xkA.append(cVar.xkO, cVar);
                }
            } else {
                this.xkB.append(cVar.xkP, cVar);
            }
        }
    }

    public static int cha() {
        return 1;
    }
}
