package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.compatible.util.e;
import java.util.HashSet;
import java.util.Set;

public final class b {
    public static final String OBJECT_ROOT_DIR_PATH;
    public static final Set<Integer> tNU = new HashSet();
    public static a tNV = new a();
    public static boolean tNW = false;

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wepkg/pkgfiles/";
    }
}
