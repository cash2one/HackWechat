package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.handler.a.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.bx.c;
import com.tencent.mm.plugin.appbrand.p.h;

class a$2 implements a {
    public final int n(String str, int i) {
        return a(str, i, null);
    }

    public final Drawable o(String str, int i) {
        h hVar = new h();
        a(str, i, hVar);
        return b.cgX().a((c) hVar.jRK);
    }

    private static int a(String str, int i, h<c> hVar) {
        if (str == null || i < 0 || i >= str.length()) {
            return 0;
        }
        int codePointAt = str.codePointAt(i);
        c Dk = b.cgX().Dk(codePointAt);
        if (Dk != null) {
            if (hVar != null) {
                hVar.jRK = Dk;
            }
            return Character.charCount(codePointAt);
        }
        int codePointAt2;
        int charCount = i + Character.charCount(codePointAt);
        if (charCount < str.length()) {
            codePointAt2 = str.codePointAt(charCount);
        } else {
            codePointAt2 = 0;
        }
        c eH = b.cgX().eH(codePointAt, codePointAt2);
        if (eH == null) {
            return 0;
        }
        if (eH.xkM != 0) {
            codePointAt2 = Character.charCount(codePointAt2) + charCount;
        } else {
            codePointAt2 = charCount;
        }
        if (hVar != null) {
            hVar.jRK = eH;
        }
        return codePointAt2 - i;
    }
}
