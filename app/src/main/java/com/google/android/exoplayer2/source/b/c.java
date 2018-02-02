package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

final class c {
    byte[] aiR;
    byte[] asT;
    final f asW;
    final f asX;
    final k asY;
    final a[] asZ;
    final e ata;
    final l atb;
    final List<Format> atc;
    boolean atd;
    byte[] ate;
    IOException atf;
    a atg;
    boolean ath;
    Uri ati;
    String atj;
    com.google.android.exoplayer2.g.e atk;

    public c(e eVar, a[] aVarArr, d dVar, k kVar, List<Format> list) {
        this.ata = eVar;
        this.asZ = aVarArr;
        this.asY = kVar;
        this.atc = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            formatArr[i] = aVarArr[i].aeo;
            iArr[i] = i;
        }
        this.asW = dVar.kt();
        this.asX = dVar.kt();
        this.atb = new l(formatArr);
        this.atk = new c(this.atb, iArr);
    }

    final void a(Uri uri, String str, byte[] bArr) {
        String substring;
        if (t.ai(str).startsWith("0x")) {
            substring = str.substring(2);
        } else {
            substring = str;
        }
        Object toByteArray = new BigInteger(substring, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (16 - toByteArray.length) + length, toByteArray.length - length);
        this.ati = uri;
        this.aiR = bArr;
        this.atj = str;
        this.asT = obj;
    }
}
