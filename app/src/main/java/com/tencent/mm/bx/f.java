package com.tencent.mm.bx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.ak.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class f {
    private static volatile f xkW = null;
    public static Pattern xlh;
    private static final Comparator<a> xli = new 1();
    public String[] xkX = null;
    public String[] xkY = null;
    public String[] xkZ = null;
    public String[] xla = null;
    public String[] xlb = null;
    public String[] xlc = null;
    public ArrayList<q> xld;
    private a[] xle = null;
    private HashMap<String, q> xlf = new HashMap();
    private SparseArray<String> xlg = new SparseArray();

    private f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.xkX = context.getResources().getStringArray(a$a.lIM);
        this.xkY = context.getResources().getStringArray(a$a.lIP);
        this.xkZ = context.getResources().getStringArray(a$a.lIN);
        this.xla = context.getResources().getStringArray(a$a.lIR);
        this.xlb = context.getResources().getStringArray(a$a.lIO);
        this.xlc = context.getResources().getStringArray(a$a.lIQ);
        che();
        x.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public static f chd() {
        if (xkW == null) {
            synchronized (f.class) {
                if (xkW == null) {
                    xkW = new f(ac.getContext());
                }
            }
        }
        return xkW;
    }

    private synchronized int che() {
        int i = 0;
        synchronized (this) {
            if (this.xkX == null || this.xkZ == null || this.xkX.length != this.xkZ.length) {
                x.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
                if (this.xld != null) {
                    this.xle = new a[this.xld.size()];
                }
            } else {
                int length = this.xkX.length;
                if (this.xld != null) {
                    this.xle = new a[((this.xld.size() + length) * 6)];
                } else {
                    this.xle = new a[(length * 6)];
                }
                int i2 = 0;
                while (i2 < length) {
                    String str = this.xkX[i2];
                    String str2 = this.xkZ[i2];
                    String str3 = (this.xkY == null || this.xkY.length <= i2) ? "" : this.xkY[i2];
                    String str4 = (this.xla == null || this.xla.length <= i2) ? "" : this.xla[i2];
                    String str5 = (this.xlb == null || this.xlb.length <= i2) ? "" : this.xlb[i2];
                    String str6 = (this.xlc == null || this.xlc.length <= i2) ? "" : this.xlc[i2];
                    q qVar = new q(str, str3, str2, str4, str5, str6, i2);
                    this.xle[(i2 * 6) + 0] = new a(i2, str, "");
                    this.xle[(i2 * 6) + 1] = new a(i2, str2, "");
                    this.xle[(i2 * 6) + 2] = new a(i2, str3, "");
                    this.xle[(i2 * 6) + 3] = new a(i2, str4, "");
                    this.xle[(i2 * 6) + 4] = new a(i2, str5, "");
                    this.xle[(i2 * 6) + 5] = new a(i2, str6, "");
                    this.xlf.put(str, qVar);
                    this.xlg.put(qVar.field_eggIndex, qVar.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.xld == null || this.xld.isEmpty()) {
                Arrays.sort(this.xle, xli);
            }
        }
        return i;
    }

    public final int chf() {
        long currentTimeMillis = System.currentTimeMillis();
        this.xlf.clear();
        this.xlg.clear();
        this.xld = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aAV();
        int che = che();
        if (this.xld == null || this.xld.isEmpty()) {
            x.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
            che = -1;
        } else {
            Iterator it = this.xld.iterator();
            int i = che;
            while (it.hasNext()) {
                q qVar = (q) it.next();
                this.xlf.put(qVar.field_key, qVar);
                this.xlg.put(qVar.field_eggIndex, qVar.field_key);
                this.xle[(i * 6) + 0] = new a(-1, qVar.field_key, qVar.field_fileName);
                if (bh.ov(qVar.field_cnValue) || "null".equalsIgnoreCase(qVar.field_cnValue)) {
                    this.xle[(i * 6) + 1] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xle[(i * 6) + 1] = new a(-1, qVar.field_cnValue, qVar.field_fileName);
                }
                if (bh.ov(qVar.field_qqValue) || "null".equalsIgnoreCase(qVar.field_qqValue)) {
                    this.xle[(i * 6) + 2] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xle[(i * 6) + 2] = new a(-1, qVar.field_qqValue, qVar.field_fileName);
                }
                if (bh.ov(qVar.field_twValue) || "null".equalsIgnoreCase(qVar.field_twValue)) {
                    this.xle[(i * 6) + 3] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xle[(i * 6) + 3] = new a(-1, qVar.field_twValue, qVar.field_fileName);
                }
                if (bh.ov(qVar.field_enValue) || "null".equalsIgnoreCase(qVar.field_enValue)) {
                    this.xle[(i * 6) + 4] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xle[(i * 6) + 4] = new a(-1, qVar.field_enValue, qVar.field_fileName);
                }
                if (bh.ov(qVar.field_thValue) || "null".equalsIgnoreCase(qVar.field_thValue)) {
                    this.xle[(i * 6) + 5] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xle[(i * 6) + 5] = new a(-1, qVar.field_thValue, qVar.field_fileName);
                }
                i++;
            }
            che = 0;
        }
        Arrays.sort(this.xle, xli);
        x.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return che;
    }

    public final String fz(String str, String str2) {
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '[') {
                a Wk = Wk(str.substring(i));
                if (Wk != null) {
                    stringBuilder.append(str2);
                    i += Wk.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        return stringBuilder.toString();
    }

    public final a Wk(String str) {
        a[] aVarArr = chd().xle;
        if (aVarArr != null) {
            int binarySearch = Arrays.binarySearch(this.xle, new a(0, str, ""), xli);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            if (binarySearch >= 0 && str.startsWith(this.xle[binarySearch].text)) {
                return aVarArr[binarySearch];
            }
        }
        return null;
    }

    public final SpannableString a(SpannableString spannableString, int i, int i2) {
        if (spannableString != null && spannableString.length() != 0) {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        a Wk = Wk(spannableString.subSequence(i, spannableString.length()));
        if (Wk == null) {
            return false;
        }
        int i3 = Wk.pos;
        Drawable mf = i3 >= 0 ? b.cgX().mf(i3) : Wl(Wk.name);
        if (mf == null || i > spannableString.length() || Wk.text.length() + i > spannableString.length()) {
            x.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[]{Wk.toString()});
            return false;
        }
        b.cgX().a(spannableString, mf, i, i + Wk.text.length(), i2);
        return true;
    }

    static Drawable Wl(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(a.Ni() + "/" + str);
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                if (decodeStream == null) {
                    x.i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                Drawable bitmapDrawable = new BitmapDrawable(ac.getContext().getResources(), decodeStream);
                try {
                    fileInputStream.close();
                    return bitmapDrawable;
                } catch (Throwable e2) {
                    x.i("MicroMsg.QQSmileyManager", bh.i(e2));
                    return bitmapDrawable;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    x.i("MicroMsg.QQSmileyManager", bh.i(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            x.i("MicroMsg.QQSmileyManager", bh.i(e4));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            x.i("MicroMsg.QQSmileyManager", bh.i(e22));
                        }
                    }
                    throw e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e4 = e5;
            fileInputStream = null;
            x.i("MicroMsg.QQSmileyManager", bh.i(e4));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    public final q Wm(String str) {
        if (this.xlf != null && this.xlf.containsKey(str)) {
            return (q) this.xlf.get(str);
        }
        x.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[]{str});
        return null;
    }
}
