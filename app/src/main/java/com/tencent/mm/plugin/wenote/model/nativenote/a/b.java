package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        if (spanned == null || bh.ov(spanned.toString())) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        a(spanned, stringBuilder);
        return stringBuilder.toString();
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder) {
        ArrayList arrayList = new j(spanned).tUa;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int indexOf;
            e eVar = (n) arrayList.get(i);
            Set<r> a = a(spanned, eVar);
            q qVar = null;
            for (r rVar : a) {
                if (rVar.tVx.tVY) {
                    qVar = rVar.tVx;
                    break;
                }
            }
            q qVar2 = q.NONE;
            q qVar3 = qVar2;
            int i2 = 0;
            for (r rVar2 : a) {
                int i3 = (rVar2.tVx.bXA() || rVar2.tVx.bXB() || rVar2.tVx.bXC()) ? 1 : 0;
                i2 += i3;
                q qVar4 = rVar2.tVx;
                boolean z = rVar2.tVx.bXA() ? ((d) rVar2.tWe).tVD : rVar2.tVx.bXB() ? ((m) rVar2.tWe).tVD : rVar2.tVx.bXC() ? ((k) rVar2.tWe).tVD : true;
                qVar2 = z ? q.NONE : qVar4.bXA() ? q.NOTEUL : qVar4.bXB() ? q.NOTEOL : qVar4.bXC() ? q.NOTETODO : qVar3;
                qVar3 = qVar2;
            }
            a(stack, stringBuilder, new a(qVar3, i2, 0));
            if (qVar3.bXC()) {
                k[] kVarArr = (k[]) spanned.getSpans(eVar.Ww, eVar.wq, k.class);
                if (kVarArr.length > 0) {
                    qVar3.tWc = kVarArr[0].tVJ;
                    indexOf = qVar3.tVZ.indexOf("\"") + 1;
                    i2 = qVar3.tVZ.lastIndexOf("\"");
                    if (indexOf < i2) {
                        String substring = qVar3.tVZ.substring(indexOf, i2);
                        if (!bh.ov(substring)) {
                            if (!substring.trim().equals(qVar3.tWc ? "1" : "0")) {
                                String str;
                                String str2 = qVar3.tVZ;
                                if (qVar3.tWc) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                qVar3.tVZ = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            stringBuilder.append(qVar3.tVZ);
            if (qVar != null) {
                stringBuilder.append(qVar.tVW);
            }
            indexOf = eVar.Ww;
            int i4 = eVar.wq;
            SortedSet treeSet = new TreeSet(new 1(spanned));
            treeSet.addAll(Arrays.asList(spanned.getSpans(indexOf, i4, CharacterStyle.class)));
            a(spanned, stringBuilder, indexOf, i4, treeSet);
            if (qVar != null) {
                a(stringBuilder, qVar);
                stringBuilder.append(qVar.tVX);
            }
            a(stringBuilder, qVar3);
            stringBuilder.append(qVar3.tWa);
        }
        while (!stack.isEmpty()) {
            a(stack, stringBuilder);
        }
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        int i3 = i;
        while (i3 < i2) {
            CharacterStyle characterStyle = sortedSet.isEmpty() ? null : (CharacterStyle) sortedSet.first();
            int spanStart = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanStart(characterStyle);
            int spanEnd = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanEnd(characterStyle);
            if (i3 < spanStart) {
                int min = Math.min(i2, spanStart);
                int i4 = i3;
                while (i4 < min) {
                    char charAt = spanned.charAt(i4);
                    if (charAt == '\n') {
                        stringBuilder.append("<br/>");
                    } else if (charAt == '<') {
                        stringBuilder.append("&lt;");
                    } else if (charAt == '>') {
                        stringBuilder.append("&gt;");
                    } else if (charAt == '&') {
                        stringBuilder.append("&amp;");
                    } else if (charAt == ' ') {
                        while (i4 + 1 < min && spanned.charAt(i4 + 1) == ' ') {
                            stringBuilder.append("&nbsp;");
                            i4++;
                        }
                        stringBuilder.append(' ');
                    } else if (charAt < ' ') {
                        stringBuilder.append("&#" + charAt + ";");
                    } else {
                        stringBuilder.append(charAt);
                    }
                    i4++;
                }
                i3 = spanStart;
            } else {
                sortedSet.remove(characterStyle);
                a(characterStyle, stringBuilder);
                a(spanned, stringBuilder, Math.max(spanStart, i3), Math.min(spanEnd, i2), sortedSet);
                if (characterStyle instanceof ForegroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof BackgroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof UnderlineSpan) {
                    stringBuilder.append("</u>");
                } else if (characterStyle instanceof BoldSpan) {
                    stringBuilder.append("</wx-b>");
                } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 2) {
                    stringBuilder.append("</i>");
                } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 1) {
                    stringBuilder.append("</wx-b>");
                } else if (characterStyle instanceof RelativeSizeSpan) {
                    stringBuilder.append("</wx-font>");
                }
                i3 = spanEnd;
            }
        }
    }

    private static boolean a(CharacterStyle characterStyle, StringBuilder stringBuilder) {
        if (characterStyle instanceof BoldSpan) {
            stringBuilder.append("<wx-b>");
        } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 1) {
            stringBuilder.append("<wx-b>");
        } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 2) {
            stringBuilder.append("<i>");
        } else if (characterStyle instanceof UnderlineSpan) {
            stringBuilder.append("<u>");
        } else if (characterStyle instanceof RelativeSizeSpan) {
            stringBuilder.append("<wx-font style=\"font-size:");
            stringBuilder.append((float) com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Bs((int) (((RelativeSizeSpan) characterStyle).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
            stringBuilder.append("px\">");
        } else if (characterStyle instanceof AbsoluteSizeSpan) {
            stringBuilder.append("<wx-font style=\"font-size:");
            stringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Bs(((AbsoluteSizeSpan) characterStyle).getSize()));
            stringBuilder.append("px\">");
        } else if (characterStyle instanceof ForegroundColorSpan) {
            stringBuilder.append("<wx-font style=\"color:#");
            r0 = Integer.toHexString(((ForegroundColorSpan) characterStyle).getForegroundColor() + 16777216);
            while (r0.length() < 6) {
                r0 = "0" + r0;
            }
            stringBuilder.append(r0);
            stringBuilder.append("\">");
        } else if (characterStyle instanceof BackgroundColorSpan) {
            stringBuilder.append("<wx-font style=\"background-color:#");
            r0 = Integer.toHexString(((BackgroundColorSpan) characterStyle).getBackgroundColor() + 16777216);
            while (r0.length() < 6) {
                r0 = "0" + r0;
            }
            stringBuilder.append(r0);
            stringBuilder.append("\">");
        }
        return true;
    }

    private static void a(StringBuilder stringBuilder, q qVar) {
        if (qVar.tWb && stringBuilder.length() >= 5) {
            int length = stringBuilder.length() - 5;
            int length2 = stringBuilder.length();
            if (stringBuilder.subSequence(length, length2).equals("<br/>")) {
                stringBuilder.delete(length, length2);
            }
        }
    }

    private static Set<r> a(Spanned spanned, e eVar) {
        Set<r> hashSet = new HashSet();
        for (ParagraphStyle paragraphStyle : (ParagraphStyle[]) spanned.getSpans(eVar.Ww, eVar.wq, ParagraphStyle.class)) {
            q a = q.a(paragraphStyle);
            if (a != null) {
                hashSet.add(new r(a, paragraphStyle));
            }
        }
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        while (true) {
            int i = 0;
            q qVar = q.NONE;
            if (!stack.isEmpty()) {
                a aVar2 = (a) stack.peek();
                i = aVar2.tVy;
                qVar = aVar2.tVx;
            }
            if (aVar.tVy <= i) {
                if (aVar.tVy >= i) {
                    break;
                }
                a((Stack) stack, stringBuilder);
            } else {
                aVar.tVz = aVar.tVy - i;
                b(stack, stringBuilder, aVar);
                return;
            }
        }
        if (aVar.tVx != qVar) {
            aVar.tVz = a((Stack) stack, stringBuilder);
            b(stack, stringBuilder, aVar);
        }
    }

    private static int a(Stack<a> stack, StringBuilder stringBuilder) {
        int i = 0;
        if (stack.isEmpty()) {
            return 0;
        }
        a aVar = (a) stack.pop();
        String str = aVar.tVx.tVX;
        int i2 = aVar.tVz;
        while (i < i2) {
            stringBuilder.append(str);
            i++;
        }
        return aVar.tVz;
    }

    private static void b(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        String str = aVar.tVx.tVW;
        int i = aVar.tVz;
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        stack.push(aVar);
    }
}
