package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.g.e.a;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class f {
    public static final Pattern azF = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern azG = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder ayB = new StringBuilder();

    private static final class b implements Comparable<b> {
        public final d azK;
        public final int score;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.score - ((b) obj).score;
        }

        public b(int i, d dVar) {
            this.score = i;
            this.azK = dVar;
        }
    }

    final boolean a(j jVar, a aVar, List<d> list) {
        Object readLine = jVar.readLine();
        if (readLine == null) {
            return false;
        }
        Matcher matcher = azF.matcher(readLine);
        if (matcher.matches()) {
            return a(null, matcher, jVar, aVar, this.ayB, list);
        }
        CharSequence readLine2 = jVar.readLine();
        if (readLine2 == null) {
            return false;
        }
        matcher = azF.matcher(readLine2);
        if (!matcher.matches()) {
            return false;
        }
        return a(readLine.trim(), matcher, jVar, aVar, this.ayB, list);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(String str, a aVar) {
        Matcher matcher = azG.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                int indexOf;
                int parseInt;
                if ("line".equals(group)) {
                    indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        aVar.avW = U(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        aVar.avW = Integer.MIN_VALUE;
                    }
                    if (group2.endsWith("%")) {
                        aVar.avU = h.W(group2);
                        aVar.avV = 0;
                    } else {
                        parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        aVar.avU = (float) parseInt;
                        aVar.avV = 1;
                    }
                } else if ("align".equals(group)) {
                    Alignment alignment;
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                parseInt = 2;
                                break;
                            }
                        case -1074341483:
                            if (group2.equals("middle")) {
                                parseInt = 3;
                                break;
                            }
                        case 100571:
                            if (group2.equals("end")) {
                                parseInt = 4;
                                break;
                            }
                        case 3317767:
                            if (group2.equals("left")) {
                                parseInt = 1;
                                break;
                            }
                        case 108511772:
                            if (group2.equals("right")) {
                                parseInt = 5;
                                break;
                            }
                        case 109757538:
                            if (group2.equals("start")) {
                                parseInt = 0;
                                break;
                            }
                        default:
                            parseInt = -1;
                            break;
                    }
                    switch (parseInt) {
                        case 0:
                        case 1:
                            alignment = Alignment.ALIGN_NORMAL;
                            break;
                        case 2:
                        case 3:
                            alignment = Alignment.ALIGN_CENTER;
                            break;
                        case 4:
                        case 5:
                            alignment = Alignment.ALIGN_OPPOSITE;
                            break;
                        default:
                            alignment = null;
                            break;
                    }
                    aVar.avT = alignment;
                } else if ("position".equals(group)) {
                    indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        aVar.avY = U(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        aVar.avY = Integer.MIN_VALUE;
                    }
                    aVar.avX = h.W(group2);
                } else if ("size".equals(group)) {
                    aVar.width = h.W(group2);
                } else {
                    new StringBuilder("Unknown cue setting ").append(group).append(":").append(group2);
                }
            } catch (NumberFormatException e) {
                new StringBuilder("Skipping bad cue setting: ").append(matcher.group());
            }
        }
    }

    static void a(String str, String str2, a aVar, List<d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            int indexOf;
            String substring;
            Object obj;
            switch (charAt) {
                case '&':
                    indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    }
                    substring = str2.substring(i + 1, indexOf);
                    obj = -1;
                    switch (substring.hashCode()) {
                        case 3309:
                            if (substring.equals("gt")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 3464:
                            if (substring.equals("lt")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 96708:
                            if (substring.equals("amp")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 3374865:
                            if (substring.equals("nbsp")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            spannableStringBuilder.append('<');
                            break;
                        case 1:
                            spannableStringBuilder.append('>');
                            break;
                        case 2:
                            spannableStringBuilder.append(' ');
                            break;
                        case 3:
                            spannableStringBuilder.append('&');
                            break;
                        default:
                            new StringBuilder("ignoring unsupported entity: '&").append(substring).append(";'");
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i = indexOf + 1;
                    break;
                case '<':
                    if (i + 1 < str2.length()) {
                        Object obj2 = str2.charAt(i + 1) == '/' ? 1 : null;
                        indexOf = str2.indexOf(62, i + 1);
                        indexOf = indexOf == -1 ? str2.length() : indexOf + 1;
                        Object obj3 = str2.charAt(indexOf + -2) == '/' ? 1 : null;
                        String substring2 = str2.substring((obj2 != null ? 2 : 1) + i, obj3 != null ? indexOf - 2 : indexOf - 1);
                        String trim = substring2.trim();
                        substring = trim.isEmpty() ? null : trim.split("[ \\.]")[0];
                        if (substring != null) {
                            obj = -1;
                            switch (substring.hashCode()) {
                                case 98:
                                    if (substring.equals("b")) {
                                        obj = null;
                                        break;
                                    }
                                    break;
                                case 99:
                                    if (substring.equals("c")) {
                                        obj = 1;
                                        break;
                                    }
                                    break;
                                case 105:
                                    if (substring.equals("i")) {
                                        obj = 2;
                                        break;
                                    }
                                    break;
                                case 117:
                                    if (substring.equals("u")) {
                                        obj = 4;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (substring.equals("v")) {
                                        obj = 5;
                                        break;
                                    }
                                    break;
                                case 3314158:
                                    if (substring.equals("lang")) {
                                        obj = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case null:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj != null) {
                                if (obj2 == null) {
                                    if (obj3 == null) {
                                        stack.push(a.j(substring2, spannableStringBuilder.length()));
                                        i = indexOf;
                                        break;
                                    }
                                }
                                while (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.name.equals(substring)) {
                                        i = indexOf;
                                        break;
                                    }
                                }
                                i = indexOf;
                            }
                        }
                        i = indexOf;
                        break;
                    }
                    i++;
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    i++;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.lf(), spannableStringBuilder, list, arrayList);
        aVar.azE = spannableStringBuilder;
    }

    private static boolean a(String str, Matcher matcher, j jVar, a aVar, StringBuilder stringBuilder, List<d> list) {
        try {
            aVar.startTime = h.V(matcher.group(1));
            aVar.endTime = h.V(matcher.group(2));
            a(matcher.group(3), aVar);
            stringBuilder.setLength(0);
            while (true) {
                Object readLine = jVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    a(str, stringBuilder.toString(), aVar, (List) list);
                    return true;
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(readLine.trim());
            }
        } catch (NumberFormatException e) {
            new StringBuilder("Skipping cue with bad header: ").append(matcher.group());
            return false;
        }
    }

    private static int U(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    i = 1;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    i = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    i = 3;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<d> list, List<b> list2) {
        boolean z;
        int i = aVar.position;
        int length = spannableStringBuilder.length();
        String str2 = aVar.name;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    z = true;
                    break;
                }
            case 98:
                if (str2.equals("b")) {
                    z = false;
                    break;
                }
            case 99:
                if (str2.equals("c")) {
                    z = true;
                    break;
                }
            case 105:
                if (str2.equals("i")) {
                    z = true;
                    break;
                }
            case 117:
                if (str2.equals("u")) {
                    z = true;
                    break;
                }
            case 118:
                if (str2.equals("v")) {
                    z = true;
                    break;
                }
            case 3314158:
                if (str2.equals("lang")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case true:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case true:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case true:
            case true:
            case true:
            case true:
                break;
            default:
                return;
        }
        list2.clear();
        a((List) list, str, aVar, (List) list2);
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = ((b) list2.get(i2)).azK;
            if (dVar != null) {
                if (dVar.getStyle() != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), i, length, 33);
                }
                if (dVar.ayW == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
                }
                if (dVar.ayX == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (dVar.ayU) {
                    if (dVar.ayU) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.ayT), i, length, 33);
                    } else {
                        throw new IllegalStateException("Font color not defined");
                    }
                }
                if (dVar.ayV) {
                    if (dVar.ayV) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.backgroundColor), i, length, 33);
                    } else {
                        throw new IllegalStateException("Background color not defined.");
                    }
                }
                if (dVar.ayS != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(dVar.ayS), i, length, 33);
                }
                if (dVar.azd != null) {
                    spannableStringBuilder.setSpan(new Standard(dVar.azd), i, length, 33);
                }
                switch (dVar.aza) {
                    case 1:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.azb, true), i, length, 33);
                        break;
                    case 2:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.azb), i, length, 33);
                        break;
                    case 3:
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.azb / 100.0f), i, length, 33);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int i2;
            d dVar = (d) list.get(i);
            String str2 = aVar.name;
            String[] strArr = aVar.azJ;
            String str3 = aVar.azI;
            if (dVar.azz.isEmpty() && dVar.azA.isEmpty() && dVar.azB.isEmpty() && dVar.azC.isEmpty()) {
                i2 = str2.isEmpty() ? 1 : 0;
            } else {
                i2 = d.a(d.a(d.a(0, dVar.azz, str, 1073741824), dVar.azA, str2, 2), dVar.azC, str3, 4);
                i2 = (i2 == -1 || !Arrays.asList(strArr).containsAll(dVar.azB)) ? 0 : i2 + (dVar.azB.size() * 4);
            }
            if (i2 > 0) {
                list2.add(new b(i2, dVar));
            }
        }
        Collections.sort(list2);
    }
}
