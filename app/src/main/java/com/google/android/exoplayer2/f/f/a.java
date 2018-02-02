package com.google.android.exoplayer2.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends b {
    private static final int azi = t.ak("styl");
    private static final int azj = t.ak("tbox");
    private final j azk = new j();
    private boolean azl;
    private int azm;
    private int azn;
    private String azo;
    private float azp;
    private int azq;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.azm = bArr[24];
            this.azn = ((((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16)) | ((bArr[28] & 255) << 8)) | (bArr[29] & 255);
            this.azo = "Serif".equals(new String(bArr, 43, bArr.length + -43)) ? "serif" : "sans-serif";
            this.azq = bArr[25] * 20;
            this.azl = (bArr[0] & 32) != 0;
            if (this.azl) {
                this.azp = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.azq);
                this.azp = t.g(this.azp, 0.0f, 0.95f);
                return;
            }
            this.azp = 0.85f;
            return;
        }
        this.azm = 0;
        this.azn = -1;
        this.azo = "sans-serif";
        this.azl = false;
        this.azp = 0.85f;
    }

    protected final d a(byte[] bArr, int i, boolean z) {
        this.azk.l(bArr, i);
        j jVar = this.azk;
        assertTrue(jVar.lF() >= 2);
        int readUnsignedShort = jVar.readUnsignedShort();
        if (readUnsignedShort == 0) {
            CharSequence charSequence = "";
        } else {
            Object a;
            if (jVar.lF() >= 2) {
                char c = (char) (((jVar.data[jVar.position] & 255) << 8) | (jVar.data[jVar.position + 1] & 255));
                if (c == '﻿' || c == '￾') {
                    a = jVar.a(readUnsignedShort, Charset.forName("UTF-16"));
                }
            }
            a = jVar.a(readUnsignedShort, Charset.forName("UTF-8"));
        }
        if (charSequence.isEmpty()) {
            return b.azr;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        a(spannableStringBuilder, this.azm, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.azn, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.azo;
        String str2 = "sans-serif";
        int length = spannableStringBuilder.length();
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f = this.azp;
        while (this.azk.lF() >= 8) {
            float f2;
            int i2 = this.azk.position;
            int readInt = this.azk.readInt();
            int readInt2 = this.azk.readInt();
            if (readInt2 == azi) {
                assertTrue(this.azk.lF() >= 2);
                int readUnsignedShort2 = this.azk.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
                    j jVar2 = this.azk;
                    assertTrue(jVar2.lF() >= 12);
                    length = jVar2.readUnsignedShort();
                    int readUnsignedShort3 = jVar2.readUnsignedShort();
                    jVar2.cV(2);
                    readInt2 = jVar2.readUnsignedByte();
                    jVar2.cV(1);
                    int readInt3 = jVar2.readInt();
                    a(spannableStringBuilder, readInt2, this.azm, length, readUnsignedShort3, 0);
                    b(spannableStringBuilder, readInt3, this.azn, length, readUnsignedShort3, 0);
                }
                f2 = f;
            } else if (readInt2 == azj && this.azl) {
                assertTrue(this.azk.lF() >= 2);
                f2 = t.g(((float) this.azk.readUnsignedShort()) / ((float) this.azq), 0.0f, 0.95f);
            } else {
                f2 = f;
            }
            this.azk.cR(i2 + readInt);
            f = f2;
        }
        return new b(new com.google.android.exoplayer2.f.a(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i != i2) {
            int i7;
            int i8 = i5 | 33;
            int i9 = (i & 1) != 0 ? 1 : 0;
            if ((i & 2) != 0) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            if (i9 != 0) {
                if (i7 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i8);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i8);
                }
            } else if (i7 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i8);
            }
            if ((i & 4) == 0) {
                i6 = 0;
            }
            if (i6 != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i8);
            }
            if (i6 == 0 && i9 == 0 && i7 == 0) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i8);
            }
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new f("Unexpected subtitle format.");
        }
    }
}
