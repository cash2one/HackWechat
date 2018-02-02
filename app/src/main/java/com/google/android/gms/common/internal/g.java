package com.google.android.gms.common.internal;

import java.util.Arrays;

public abstract class g {
    public static final g aNA = new 8();
    public static final g aNB = new 9();
    public static final g aNC = new 10();
    public static final g aND = a('\u0000', '\u001f').a(a('', ''));
    public static final g aNE = a('\u0000', ' ').a(a('', ' ')).a(d('­')).a(a('؀', '؃')).a(k("۝܏ ឴឵᠎")).a(a(' ', '‏')).a(a(' ', ' ')).a(a(' ', '⁤')).a(a('⁪', '⁯')).a(d('　')).a(a('?', '')).a(k("﻿￹￺￻"));
    public static final g aNF = a('\u0000', 'ӹ').a(d('־')).a(a('א', 'ת')).a(d('׳')).a(d('״')).a(a('؀', 'ۿ')).a(a('ݐ', 'ݿ')).a(a('฀', '๿')).a(a('Ḁ', '₯')).a(a('℀', '℺')).a(a('ﭐ', '﷿')).a(a('ﹰ', '﻿')).a(a('｡', 'ￜ'));
    public static final g aNG = new g() {
        public final g a(g gVar) {
            w.ag(gVar);
            return this;
        }

        public final boolean e(char c) {
            return true;
        }

        public final boolean l(CharSequence charSequence) {
            w.ag(charSequence);
            return true;
        }
    };
    public static final g aNH = new 2();
    public static final g aNt = k("\t\n\u000b\f\r     　 ᠎ ").a(a(' ', ' '));
    public static final g aNu = k("\t\n\u000b\f\r     　").a(a(' ', ' ')).a(a(' ', ' '));
    public static final g aNv = a('\u0000', '');
    public static final g aNw;
    public static final g aNx = a('\t', '\r').a(a('\u001c', ' ')).a(d(' ')).a(d('᠎')).a(a(' ', ' ')).a(a(' ', '​')).a(a(' ', ' ')).a(d(' ')).a(d('　'));
    public static final g aNy = new 1();
    public static final g aNz = new g() {
        public final boolean e(char c) {
            return Character.isLetter(c);
        }
    };

    static {
        g a = a('0', '9');
        g gVar = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            gVar = gVar.a(a(c, (char) (c + 9)));
        }
        aNw = gVar;
    }

    private static g a(final char c, final char c2) {
        w.as(c2 >= c);
        return new g() {
            public final boolean e(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    private static g d(char c) {
        return new 3(c);
    }

    private static g k(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return aNH;
            case 1:
                return d(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new g() {
                    public final boolean e(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new g() {
                    public final boolean e(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public g a(g gVar) {
        return new a(Arrays.asList(new g[]{this, (g) w.ag(gVar)}));
    }

    public abstract boolean e(char c);

    public boolean l(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!e(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
