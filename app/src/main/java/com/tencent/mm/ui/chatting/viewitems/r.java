package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class r {
    private static final LayoutParams yLY = new LayoutParams(-1, -2);

    private static class a implements Comparable<a> {
        public int color;
        public boolean fHI;
        public int offset;
        public int yLZ;
        public boolean yMa;
        public String yMb;

        private a() {
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (aVar != null) {
                return this.offset - aVar.offset;
            }
            x.e("MicroMsg.LineNode", "compareTo fail, should not be null");
            return 1;
        }

        public static a u(Map<String, String> map, String str) {
            a aVar = new a();
            try {
                aVar.offset = bh.getInt((String) map.get(str + ".offset"), 0);
                String str2 = (String) map.get(str + ".font");
                if (bh.ov(str2)) {
                    x.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                aVar.fHI = str2.contains("b");
                aVar.yMa = str2.contains("u");
                aVar.yLZ = r.Zu(str2);
                aVar.color = r.dp((String) map.get(str + ".color"), WebView.NIGHT_MODE_COLOR);
                aVar.yMb = (String) map.get(str + ".chars");
                if (!bh.ov(aVar.yMb)) {
                    return aVar;
                }
                x.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                return null;
            } catch (Exception e) {
                x.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
                return null;
            }
        }
    }

    static /* synthetic */ int Zu(String str) {
        if (str.contains("m")) {
            return 18;
        }
        return str.contains("l") ? 21 : 14;
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        if (linearLayout == null) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (bh.ov(str)) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            return false;
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(WebView.NIGHT_MODE_COLOR), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[]{e.getMessage()});
        }
        int i = 0;
        while (true) {
            String str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? "" : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            b v = b.v(map, str2);
            if (v == null) {
                x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = " + str2);
            } else if (v.yMc >= v.yMd) {
                x.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + v.yMc + ", rangeTo = " + v.yMd);
            } else {
                int length;
                int i2 = v.yMc;
                int i3 = v.yMd;
                int i4 = v.yLZ;
                boolean z = v.fHI;
                boolean z2 = v.yMa;
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e2.getMessage()});
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e22.getMessage()});
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e3.getMessage()});
                    }
                }
                i2 = v.yMc;
                i3 = v.yMd;
                length = v.color;
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[]{Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3)});
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[]{e32.getMessage()});
                }
            }
            i++;
        }
        x.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = " + i);
        i = 0;
        List arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? "" : String.valueOf(i));
            if (map.containsKey(str2)) {
                a u = a.u(map, str2);
                if (u == null) {
                    x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = " + str2);
                } else {
                    arrayList.add(u);
                }
                i++;
            } else {
                x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = " + i);
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                return true;
            }
        }
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        x.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (a aVar : list) {
            if (aVar.offset > i) {
                View textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, yLY);
            }
            View textView2 = new TextView(linearLayout.getContext());
            textView2.setText(Zt(aVar.yMb));
            textView2.setSingleLine(true);
            if (aVar.yLZ != 14) {
                textView2.setTextSize((float) aVar.yLZ);
            }
            if (aVar.fHI) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.yMa) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(aVar.color);
            linearLayout.addView(textView2, yLY);
            i = aVar.offset;
        }
        if (i >= length) {
            x.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
        } else {
            View textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) com.tencent.mm.bv.a.aa(textView3.getContext(), R.f.bvs));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, yLY);
        }
        return true;
    }

    private static String Zt(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private static int dp(String str, int i) {
        int i2 = WebView.NIGHT_MODE_COLOR;
        if (!bh.ov(str)) {
            try {
                i2 = Color.parseColor(str);
            } catch (Exception e) {
                x.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
            }
        }
        return i2;
    }
}
