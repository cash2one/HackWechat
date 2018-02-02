package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.j.a;
import com.tencent.mm.plugin.fts.d.j.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.s;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class e {
    public static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        return true;
    }

    public static boolean a(String str, TextView textView) {
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        return true;
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        a(context, imageView, str, str2, i, true, 0, 0);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, int i2, int i3) {
        a(context, imageView, str, str2, i, false, i2, i3);
    }

    private static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        h.aNx().a(imageView, str, str2, z, i2, i3);
        if (!bh.ov(str) || !bh.ov(str2)) {
            Bitmap a = h.aNx().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(a.transparent);
                }
                h.aNx().a(context, imageView, str, str2, z, i2, i3);
            } else {
                g.a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
        } else if (i <= 0 || (bh.ov(str) && bh.ov(str2))) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
    }

    public static String qg(int i) {
        int i2 = 0;
        switch (i) {
            case -15:
                i2 = g.mPh;
                break;
            case -13:
                i2 = g.mPk;
                break;
            case -11:
                i2 = g.mPi;
                break;
            case -8:
                i2 = g.mPj;
                break;
            case -7:
                i2 = g.mPf;
                break;
            case -6:
                i2 = g.mPe;
                break;
            case -5:
                i2 = g.mPg;
                break;
            case -4:
                i2 = g.ekt;
                break;
            case -3:
                i2 = g.moA;
                break;
            case -2:
                i2 = g.ekw;
                break;
            case -1:
                i2 = g.mPd;
                break;
        }
        if (i2 == 0) {
            return null;
        }
        return ac.getContext().getString(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static CharSequence a(Context context, List<d> list, String[] strArr, com.tencent.mm.plugin.fts.a.a.e eVar, TextPaint textPaint) {
        Arrays.sort(strArr, new 1((m) com.tencent.mm.kernel.g.k(m.class)));
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            d dVar = (d) list.get(i);
            if (dVar.mLt < strArr.length) {
                String str = strArr[dVar.mLt];
                if (!bh.ov(str)) {
                    af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(str);
                    if (WO != null) {
                        str = WO.field_username;
                        String a = s.a(WO, str);
                        switch (dVar.mLr) {
                            case 29:
                                break;
                            case 30:
                                break;
                            case 31:
                                dVar.mLz = true;
                                break;
                            case 32:
                                dVar.mLv = WO.fWy;
                                dVar.mLw = a;
                                break;
                            case 33:
                                dVar.mLv = dVar.content;
                                dVar.mLw = a;
                                break;
                            case 34:
                                break;
                            case 35:
                                break;
                            case 36:
                                dVar.mLz = true;
                                break;
                            case 37:
                                dVar.mLv = com.tencent.mm.plugin.fts.a.d.cE(str, WO.vN());
                                dVar.mLw = a;
                                break;
                        }
                    }
                }
            }
        }
        Collections.sort(list, new Comparator<d>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((d) obj2).mLx - ((d) obj).mLx;
            }
        });
        float f = 0.0f;
        int i2 = 0;
        while (i2 < list.size() && i2 < eVar.mLC.length) {
            float f2 = ((float) (f$a.mON - 100)) - f;
            if (f2 > 100.0f) {
                dVar = (d) list.get(i2);
                CharSequence b = i.b(context, dVar.mLv, textPaint.getTextSize());
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(", ");
                }
                com.tencent.mm.plugin.fts.d.b.a aVar = new com.tencent.mm.plugin.fts.d.b.a();
                aVar.mPW = b;
                aVar.mMb = eVar;
                aVar.mLy = dVar.mLy;
                aVar.mPX = dVar.mLz;
                aVar.mQa = f2;
                aVar.gTN = textPaint;
                if (!bh.ov(dVar.mLw)) {
                    SpannableString b2 = i.b(context, dVar.mLw, textPaint.getTextSize());
                    aVar.mQb = TextUtils.concat(new CharSequence[]{b2, "("});
                    aVar.mQc = ")";
                }
                spannableStringBuilder.append(f.a(aVar).mQk);
                i2++;
                f = textPaint.measureText(spannableStringBuilder.toString());
            }
        }
        return spannableStringBuilder;
    }
}
