package com.tencent.mm.plugin.fts.d.b;

import android.text.TextPaint;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class a {
    public TextPaint gTN;
    public boolean mLy;
    public e mMb;
    public CharSequence mPW;
    public boolean mPX;
    public int mPY = a.mQd;
    public int mPZ = com.tencent.mm.plugin.fts.d.d.a.mOB;
    public float mQa;
    public CharSequence mQb = "";
    public CharSequence mQc = "";

    public static final a b(CharSequence charSequence, List<String> list) {
        return d(charSequence, bh.d(list, " "));
    }

    public static final a d(CharSequence charSequence, String str) {
        a aVar = new a();
        aVar.mPW = charSequence;
        aVar.mMb = e.an(str, false);
        aVar.mLy = false;
        aVar.mPX = false;
        return aVar;
    }

    public static final a a(CharSequence charSequence, e eVar) {
        a aVar = new a();
        aVar.mPW = charSequence;
        aVar.mMb = eVar;
        return aVar;
    }

    public static final a a(CharSequence charSequence, e eVar, boolean z, boolean z2) {
        return a(charSequence, eVar, z, z2, 0.0f, null);
    }

    public static final a a(CharSequence charSequence, e eVar, float f, TextPaint textPaint) {
        return a(charSequence, eVar, false, false, f, textPaint);
    }

    public static final a a(CharSequence charSequence, e eVar, boolean z, boolean z2, float f, TextPaint textPaint) {
        a aVar = new a();
        aVar.mPW = charSequence;
        aVar.mMb = eVar;
        aVar.mLy = z;
        aVar.mPX = z2;
        aVar.mQa = f;
        aVar.gTN = textPaint;
        return aVar;
    }

    public static final a a(CharSequence charSequence, e eVar, boolean z, boolean z2, TextPaint textPaint, CharSequence charSequence2, CharSequence charSequence3) {
        a aVar = new a();
        aVar.mPW = charSequence;
        aVar.mMb = eVar;
        aVar.mLy = z;
        aVar.mPX = z2;
        aVar.mQa = 400.0f;
        aVar.gTN = textPaint;
        aVar.mQb = charSequence2;
        aVar.mQc = charSequence3;
        return aVar;
    }

    public static final a a(CharSequence charSequence, List<String> list, int i, int i2) {
        Object b = b(charSequence, list);
        b.mPY = i;
        b.mPZ = i2;
        return b;
    }
}
