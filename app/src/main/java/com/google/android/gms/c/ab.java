package com.google.android.gms.c;

import com.google.android.gms.common.internal.g;
import java.util.regex.Pattern;

public final class ab {
    private static final Pattern aXQ = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean aZ(String str) {
        return str == null || g.aNt.l(str);
    }
}
