package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    private static final SparseIntArray iDK;

    static int A(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap.getInt();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        iDK = sparseIntArray;
        sparseIntArray.put(0, com.tencent.mm.plugin.appbrand.e.a.a.dEJ);
        iDK.put(1, com.tencent.mm.plugin.appbrand.e.a.a.iVP);
        iDK.put(2, com.tencent.mm.plugin.appbrand.e.a.a.iVO);
    }

    public static String ju(int i) {
        return ac.getResources().getString(iDK.get(i, com.tencent.mm.plugin.appbrand.e.a.a.dEJ));
    }

    public static String px(String str) {
        if (bh.ov(str)) {
            return str;
        }
        int i = 0;
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return str.substring(i);
    }

    public static String py(String str) {
        int i = 0;
        x.d("MicroMsg.AppBrandAppCacheUtil", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[]{str});
        if (bh.ov(str)) {
            return "";
        }
        String trim = str.trim();
        if (!trim.startsWith("/")) {
            return "/" + trim;
        }
        while (i < trim.length() && '/' == trim.charAt(i)) {
            i++;
        }
        return "/" + trim.substring(i);
    }
}
