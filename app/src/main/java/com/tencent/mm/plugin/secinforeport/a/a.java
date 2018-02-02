package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a {
    public static final int qff = 1;
    private static b qfg = new 1();
    private static final /* synthetic */ int[] qfh = new int[]{qff};

    public static void a(b bVar) {
        if (bVar != null) {
            qfg = bVar;
        }
    }

    public static void d(int i, String str, int i2) {
        x.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        qfg.a(i, str, i2, null);
    }

    public static void s(int i, String str, String str2) {
        x.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", new Object[]{Integer.valueOf(5), Integer.valueOf(i), str, str2});
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.fFm = str;
        com_tencent_mm_protocal_c_are.wyX = str2;
        byte[] bArr = null;
        try {
            bArr = com_tencent_mm_protocal_c_are.toByteArray();
        } catch (IOException e) {
            x.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", new Object[]{e.getMessage()});
        }
        qfg.a(5, "", i, bArr);
    }
}
