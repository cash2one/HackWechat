package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c implements TagHandler {
    private static final Pattern ayE = Pattern.compile("\\d+");
    private static final Pattern tSp = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> tSq;
    private Stack<a> tSn = new Stack();
    final HashMap<String, String> tSo = new HashMap();

    private static class b {
        int hX;
        String tSr;
        String tSs;
        String tSt;

        private b() {
            this.hX = Integer.MIN_VALUE;
        }
    }

    private static class d extends c {
        d(int i) {
            super(i, false);
        }
    }

    private static class f extends c {
        f(int i) {
            super(i, false);
        }
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        int intValue;
        int i;
        this.tSo.clear();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            declaredField = obj2.getClass().getDeclaredField(SlookAirButtonFrequentContactAdapter.DATA);
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(obj2);
            Field declaredField3 = obj2.getClass().getDeclaredField("length");
            declaredField3.setAccessible(true);
            intValue = ((Integer) declaredField3.get(obj2)).intValue();
            for (i = 0; i < intValue; i++) {
                this.tSo.put(strArr[(i * 5) + 1], strArr[(i * 5) + 4]);
            }
        } catch (Exception e) {
        }
        int spanStart;
        if (!z) {
            if (str.equalsIgnoreCase("wx-ul")) {
                kF(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                kF(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                r6 = (c) a(editable, c.class);
                if (r6 != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != '\n') {
                        editable.append('\n');
                    }
                    r7 = editable.getSpanStart(r6);
                    r8 = editable.length();
                    if (!r6.tSv) {
                        editable.setSpan(new k(((e) r6).tSw, com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bWo(), r7 == r8, false, false), r7, r8, 33);
                    }
                    editable.removeSpan(r6);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                r6 = (c) a(editable, c.class);
                if (r6 != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != '\n') {
                        editable.append('\n');
                    }
                    r7 = editable.getSpanStart(r6);
                    r8 = editable.length();
                    if (!r6.tSv) {
                        intValue = com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bWo();
                        if (r6 instanceof d) {
                            obj = new m(1, intValue, r7 == r8, false, false);
                        } else {
                            com.tencent.mm.plugin.wenote.model.nativenote.spans.d dVar = new com.tencent.mm.plugin.wenote.model.nativenote.spans.d(intValue, r7 == r8, false, false);
                        }
                        editable.setSpan(obj, r7, r8, 33);
                    }
                    editable.removeSpan(r6);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                intValue = editable.length();
                obj = a(editable, b.class);
                if (obj != null) {
                    spanStart = editable.getSpanStart(obj);
                    editable.removeSpan(obj);
                    if (spanStart != intValue) {
                        b bVar = (b) obj;
                        if ((!TextUtils.isEmpty(bVar.tSt) ? 1 : null) != null) {
                            editable.setSpan(new TypefaceSpan(bVar.tSt), spanStart, intValue, 33);
                        }
                        if ((bVar.hX > 0 ? 1 : null) != null) {
                            editable.setSpan(new AbsoluteSizeSpan(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Br(bVar.hX)), spanStart, intValue, 33);
                        }
                        if ((!TextUtils.isEmpty(bVar.tSr) ? 1 : null) != null) {
                            i = QO(bVar.tSr);
                            if (i != -1) {
                                editable.setSpan(new ForegroundColorSpan(i | WebView.NIGHT_MODE_COLOR), spanStart, intValue, 33);
                            }
                        }
                        if ((!TextUtils.isEmpty(bVar.tSs) ? 1 : null) != null) {
                            int QO = QO(bVar.tSs);
                            if (QO != -1) {
                                editable.setSpan(new BackgroundColorSpan(QO | WebView.NIGHT_MODE_COLOR), spanStart, intValue, 33);
                            }
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                BoldSpan boldSpan = new BoldSpan();
                intValue = editable.length();
                obj = a(editable, a.class);
                spanStart = editable.getSpanStart(obj);
                editable.removeSpan(obj);
                if (spanStart != intValue) {
                    editable.setSpan(boldSpan, spanStart, intValue, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.tSo.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            a(false, q.tVT);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            a(true, q.tVU);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.tSn.push(new a(q.tVV, 1, 1));
            r0 = (String) this.tSo.get("checked");
            r1 = !bh.ov(r0) && r0.equals("1");
            a(editable, new e(((a) this.tSn.peek()).tVy, r1));
        } else if (str.equalsIgnoreCase("wx-li")) {
            r0 = (String) this.tSo.get("done");
            r1 = !bh.ov(r0) && r0.equals("true");
            if (this.tSn.isEmpty()) {
                obj = new f(0);
            } else {
                a aVar = (a) this.tSn.peek();
                q qVar = aVar.tVx;
                r4 = aVar.tVy;
                obj = qVar.bXB() ? new d(r4) : qVar.bXA() ? new f(r4) : qVar.bXC() ? new e(r4, r1) : null;
            }
            if (obj != null) {
                a(editable, obj);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            spanStart = Integer.MIN_VALUE;
            String str2 = null;
            String str3 = null;
            r0 = (String) this.tSo.get("style");
            if (r0 != null) {
                r0 = null;
                str3 = null;
                intValue = Integer.MIN_VALUE;
                for (Object obj3 : r0.toLowerCase(Locale.ENGLISH).split(";")) {
                    Matcher matcher;
                    if (obj3.startsWith("font-size")) {
                        matcher = ayE.matcher(obj3);
                        if (matcher.find(0)) {
                            try {
                                intValue = Integer.parseInt(obj3.substring(matcher.start(), matcher.end()));
                            } catch (NumberFormatException e2) {
                            }
                        }
                    } else if (obj3.startsWith("color")) {
                        matcher = tSp.matcher(obj3);
                        if (matcher.find(0)) {
                            str3 = obj3.substring(matcher.start(), matcher.end());
                        }
                    } else if (obj3.startsWith("background-color")) {
                        matcher = tSp.matcher(obj3);
                        if (matcher.find(0)) {
                            r0 = obj3.substring(matcher.start(), matcher.end());
                        }
                    }
                }
                spanStart = intValue;
                str2 = str3;
                str3 = r0;
            }
            r0 = (String) this.tSo.get("face");
            r4 = editable.length();
            b bVar2 = new b();
            bVar2.hX = spanStart;
            bVar2.tSr = str2;
            bVar2.tSs = str3;
            editable.setSpan(bVar2.tSt = r0, r4, r4, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            a(editable, new a((byte) 0));
        } else if (str.equalsIgnoreCase("wx-p")) {
            d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            d(editable);
        }
        a.tSl = editable;
    }

    private static void d(Editable editable) {
        int length = editable.length();
        if ((length <= 0 || editable.charAt(length - 1) != '\n') && length != 0) {
            editable.append("\n");
        }
    }

    private void a(boolean z, q qVar) {
        if (z) {
            qVar = q.tVU;
        }
        a aVar = this.tSn.isEmpty() ? null : (a) this.tSn.peek();
        if (aVar == null) {
            this.tSn.push(new a(qVar, 1, 1));
        } else if (aVar.tVx == qVar) {
            aVar.tVy++;
            aVar.tVz++;
        } else {
            this.tSn.push(new a(qVar, aVar.tVy + 1, 1));
        }
    }

    private void kF(boolean z) {
        while (!this.tSn.isEmpty()) {
            a aVar = (a) this.tSn.peek();
            q qVar = aVar.tVx;
            if (!(z && qVar.bXB()) && ((z || !qVar.bXA()) && (z || !qVar.bXC()))) {
                this.tSn.pop();
            } else {
                int i = aVar.tVz;
                if (i > 1) {
                    aVar.tVz = i - 1;
                    aVar.tVy--;
                    return;
                }
                this.tSn.pop();
                return;
            }
        }
    }

    private static Object a(Editable editable, Class<? extends Object> cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        return spans.length == 0 ? null : spans[spans.length - 1];
    }

    private static void a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    static {
        HashMap hashMap = new HashMap();
        tSq = hashMap;
        hashMap.put("aqua", Integer.valueOf(65535));
        tSq.put("black", Integer.valueOf(0));
        tSq.put("blue", Integer.valueOf(255));
        tSq.put("fuchsia", Integer.valueOf(16711935));
        tSq.put("green", Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
        tSq.put("grey", Integer.valueOf(8421504));
        tSq.put("lime", Integer.valueOf(65280));
        tSq.put("maroon", Integer.valueOf(8388608));
        tSq.put("navy", Integer.valueOf(FileUtils.S_IWUSR));
        tSq.put("olive", Integer.valueOf(8421376));
        tSq.put("purple", Integer.valueOf(8388736));
        tSq.put("red", Integer.valueOf(16711680));
        tSq.put("silver", Integer.valueOf(12632256));
        tSq.put("teal", Integer.valueOf(32896));
        tSq.put("white", Integer.valueOf(16777215));
        tSq.put("yellow", Integer.valueOf(16776960));
    }

    @SuppressLint({"DefaultLocale"})
    private static int QO(String str) {
        int i = 1;
        Integer num = (Integer) tSq.get(str.toLowerCase());
        if (num != null) {
            return num.intValue();
        }
        if (str == null) {
            return -1;
        }
        try {
            int i2;
            int i3;
            String charSequence = str.toString();
            int length = charSequence.length();
            int i4 = 10;
            if ('-' == charSequence.charAt(0)) {
                i2 = -1;
            } else {
                i2 = 1;
                i = 0;
            }
            if ('0' == charSequence.charAt(i)) {
                if (i == length - 1) {
                    return 0;
                }
                char charAt = charSequence.charAt(i + 1);
                if ('x' == charAt || 'X' == charAt) {
                    i3 = i + 2;
                    i4 = 16;
                } else {
                    i3 = i + 1;
                    i4 = 8;
                }
            } else if ('#' == charSequence.charAt(i)) {
                i3 = i + 1;
                i4 = 16;
            } else {
                i3 = i;
            }
            return Integer.parseInt(charSequence.substring(i3), i4) * i2;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
