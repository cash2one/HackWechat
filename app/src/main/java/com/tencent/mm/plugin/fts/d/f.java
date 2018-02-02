package com.tencent.mm.plugin.fts.d;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e$d;
import com.tencent.mm.plugin.fts.a.a.e.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.b.a;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static final b a(String str, String str2, a aVar) {
        b a = a(aVar);
        a.mQk = TextUtils.concat(new CharSequence[]{str, a.mQk, str2});
        return a;
    }

    public static final SpannableString b(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        a.b bVar = new a.b();
        bVar.mQi = 0;
        bVar.mQj = i;
        b(spannableString, bVar, new a());
        return spannableString;
    }

    public static final b a(a aVar) {
        int i;
        b bVar = new b();
        CharSequence spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{aVar.mQb, aVar.mPW, aVar.mQc}));
        bVar.bjW = -1;
        bVar.mQk = spannableString;
        if (bh.M(aVar.mPW) || aVar.mMb == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return bVar;
        }
        String Bd = d.Bd(aVar.mPW.toString());
        ArrayList arrayList = new ArrayList();
        if (aVar.mLy) {
            List ao = ao(Bd, aVar.mPX);
        } else {
            Object obj = arrayList;
        }
        a.b bVar2;
        b b;
        if (aVar.mMb.mLE.size() == 1 || a(spannableString, aVar)) {
            bVar2 = new a.b();
            if (aVar.mMb.mLE.size() == 1) {
                bVar2.mQh = (c) aVar.mMb.mLE.get(0);
                if (aVar.mLy) {
                    a(ao, bVar2, aVar);
                } else {
                    a(Bd, bVar2, aVar);
                }
                if (!bVar2.isAvailable()) {
                    return bVar;
                }
                try {
                    b = b(spannableString, bVar2, aVar);
                } catch (Exception e) {
                    bVar.mQk = spannableString;
                    b = bVar;
                }
                return b;
            }
            for (c cVar : aVar.mMb.mLE) {
                bVar2.mQh = cVar;
                if (aVar.mLy) {
                    a(ao, bVar2, aVar);
                } else {
                    a(Bd, bVar2, aVar);
                }
                if (bVar2.isAvailable()) {
                    try {
                        return b(spannableString, bVar2, aVar);
                    } catch (Exception e2) {
                        bVar.mQk = spannableString;
                        return bVar;
                    }
                }
            }
            return bVar;
        }
        a.b bVar3 = new a.b();
        bVar3.mQh = new c();
        e.b bVar4 = new e.b();
        bVar4.mLG = e$d.mLL;
        bVar4.content = aVar.mMb.mLB;
        bVar3.mQh.mLI.add(bVar4);
        if (aVar.mLy) {
            a(ao, bVar3, aVar);
        } else {
            a(Bd, bVar3, aVar);
        }
        if (bVar3.isAvailable()) {
            try {
                return b(spannableString, bVar3, aVar);
            } catch (Exception e3) {
                bVar.mQk = spannableString;
                return bVar;
            }
        }
        List<a.b> arrayList2 = new ArrayList();
        for (c cVar2 : aVar.mMb.mLE) {
            bVar2 = new a.b();
            bVar2.mQh = cVar2;
            arrayList2.add(bVar2);
        }
        for (a.b bVar32 : arrayList2) {
            if (aVar.mLy) {
                a(ao, bVar32, aVar);
            } else {
                a(Bd, bVar32, aVar);
            }
        }
        for (a.b bVar322 : arrayList2) {
            if (bVar322.isAvailable()) {
                b = b(spannableString, bVar322, aVar);
                if (b.bjW == 0) {
                    bVar = b;
                }
            }
        }
        return bVar;
    }

    private static boolean a(SpannableString spannableString, a aVar) {
        if (aVar.mQa <= 0.0f || aVar.gTN == null || aVar.mQa - (aVar.gTN.getTextSize() * 2.0f) >= aVar.gTN.measureText(spannableString.toString())) {
            return false;
        }
        return true;
    }

    private static b a(SpannableString spannableString, a.b bVar, a aVar) {
        b bVar2 = new b();
        float textSize = aVar.mQa - (aVar.gTN.getTextSize() * 2.0f);
        float measureText = aVar.gTN.measureText("…");
        float measureText2 = aVar.gTN.measureText(spannableString, 0, bVar.mQi);
        float measureText3 = aVar.gTN.measureText(spannableString, bVar.mQi, bVar.mQj);
        float measureText4 = aVar.gTN.measureText(spannableString, bVar.mQj, spannableString.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            return c(spannableString, bVar, aVar);
        }
        Object backgroundColorSpan;
        if (aVar.mPY == a.a.mQe) {
            backgroundColorSpan = new BackgroundColorSpan(aVar.mPZ);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar.mPZ);
        }
        CharSequence spannableString2 = new SpannableString(spannableString.subSequence(bVar.mQi, bVar.mQj));
        try {
            spannableString2.setSpan(backgroundColorSpan, 0, spannableString2.length(), 33);
            CharSequence spannableStringBuilder;
            if ((measureText2 + measureText3) + measureText < textSize) {
                spannableStringBuilder = new SpannableStringBuilder(spannableString, 0, bVar.mQi);
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(bVar.mQj, spannableString.length()), aVar.gTN, (textSize - measureText2) - measureText3, TruncateAt.END));
                bVar2.mQk = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText4 < textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(0, bVar.mQi), aVar.gTN, (textSize - measureText3) - measureText4, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(spannableString, bVar.mQj, spannableString.length());
                bVar2.mQk = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText >= textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString2, aVar.gTN, textSize, TruncateAt.END));
                bVar2.mQk = spannableStringBuilder;
            } else {
                spannableStringBuilder = new SpannableStringBuilder();
                textSize = (textSize - measureText3) / 2.0f;
                CharSequence subSequence = spannableString.subSequence(0, bVar.mQi);
                CharSequence subSequence2 = spannableString.subSequence(bVar.mQj, spannableString.length());
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence, aVar.gTN, textSize, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, aVar.gTN, textSize, TruncateAt.END));
                bVar2.mQk = spannableStringBuilder;
            }
            bVar2.bjW = 0;
            return bVar2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", new Object[]{bVar.toString()});
            bVar2.bjW = -1;
            bVar2.mQk = spannableString;
            return bVar2;
        }
    }

    private static b b(SpannableString spannableString, a.b bVar, a aVar) {
        if (a(spannableString, aVar)) {
            return a(spannableString, bVar, aVar);
        }
        return c(spannableString, bVar, aVar);
    }

    private static b c(SpannableString spannableString, a.b bVar, a aVar) {
        Object backgroundColorSpan;
        b bVar2 = new b();
        if (aVar.mPY == a.a.mQe) {
            backgroundColorSpan = new BackgroundColorSpan(aVar.mPZ);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar.mPZ);
        }
        try {
            spannableString.setSpan(backgroundColorSpan, bVar.mQi, bVar.mQj, 33);
            bVar2.mQk = spannableString;
            bVar2.bjW = 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", new Object[]{bVar.toString()});
            bVar2.mQk = spannableString;
            bVar2.bjW = -1;
        }
        return bVar2;
    }

    private static void a(String str, a.b bVar, a aVar) {
        String str2;
        if (bVar.mQh != null && bVar.mQh.mLI.size() > 0) {
            for (e.b bVar2 : bVar.mQh.mLI) {
                if (bVar2.mLG == e$d.mLL) {
                    str2 = bVar2.content;
                    break;
                }
            }
        }
        str2 = null;
        if (!bh.ov(str2)) {
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                bVar.mQi = indexOf;
                bVar.mQj = str2.length() + indexOf;
            }
            if (bVar.isAvailable() && aVar.mQb != null) {
                bVar.mQi += aVar.mQb.length();
                bVar.mQj += aVar.mQb.length();
            }
        }
    }

    private static void a(List<List<String>> list, a.b bVar, a aVar) {
        e.b bVar2;
        if (aVar.mPX) {
            for (e.b bVar22 : bVar.mQh.mLI) {
                if (bVar22.mLG == e$d.mLK) {
                    break;
                }
            }
            bVar22 = null;
            if (bVar22 != null) {
                int g = g(list, bVar22.mLH);
                if (g >= 0) {
                    bVar.mQi = g;
                    bVar.mQj = bVar22.mLH.size() + g;
                }
            } else {
                return;
            }
        }
        for (e.b bVar222 : bVar.mQh.mLI) {
            if (bVar222.mLG == e$d.mLJ) {
                int g2 = g(list, bVar222.mLH);
                if (g2 >= 0) {
                    bVar.mQi = g2;
                    bVar.mQj = bVar222.mLH.size() + g2;
                    break;
                }
            }
        }
        if (bVar.isAvailable() && aVar.mQb != null) {
            bVar.mQi += aVar.mQb.length();
            bVar.mQj += aVar.mQb.length();
        }
    }

    private static int g(List<List<String>> list, List<String> list2) {
        int i = 0;
        int i2 = 0;
        while (i < (list.size() - list2.size()) + 1) {
            int i3;
            int i4 = i2;
            while (i4 < list2.size()) {
                Object obj;
                List<String> list3 = (List) list.get(i + i4);
                String str = (String) list2.get(i4);
                if (!list3.contains(str)) {
                    if (i4 != list2.size() - 1) {
                        obj = null;
                        i3 = 0;
                        break;
                    }
                    for (String startsWith : list3) {
                        if (startsWith.startsWith(str)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        obj = null;
                        i3 = 0;
                        break;
                    }
                    i4++;
                } else {
                    i4++;
                }
            }
            i2 = 1;
            i3 = i4;
            if (obj != null) {
                return i;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    private static List<List<String>> ao(String str, boolean z) {
        List<List<String>> arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            List arrayList2 = new ArrayList(2);
            if (com.tencent.mm.plugin.fts.a.f.i(charAt)) {
                String[] strArr = (String[]) com.tencent.mm.plugin.fts.a.f.mLj.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    for (Object obj : strArr) {
                        Object obj2;
                        if (z) {
                            obj2 = obj2.substring(0, 1);
                        }
                        if (!arrayList2.contains(obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }
}
