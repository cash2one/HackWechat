package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
    private static int iQW = -1;

    public static void a(bvm com_tencent_mm_protocal_c_bvm, f fVar) {
        if (fVar != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - fVar.iPS);
            g.pQN.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(fVar.size), Integer.valueOf(com_tencent_mm_protocal_c_bvm.bke()), Integer.valueOf(0), "", "", Integer.valueOf(acu()), Integer.valueOf(acv())});
        }
    }

    public static void a(a aVar, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - aVar.iPS);
        g.pQN.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(aVar.size), Integer.valueOf(i), Integer.valueOf(1), "", bh.ou(aVar.fok), Integer.valueOf(acu()), Integer.valueOf(acv())});
    }

    public static void a(String str, LinkedList<String> linkedList, long j, int i, int i2) {
        String str2 = "";
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            str2 = (String) linkedList.get(0);
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        g.pQN.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), str, str2, Integer.valueOf(acu()), Integer.valueOf(acv())});
    }

    public static String rh(String str) {
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private static int acu() {
        if (iQW >= 0) {
            return iQW;
        }
        int iSPCode = an.getISPCode(ac.getContext());
        iQW = iSPCode;
        return iSPCode;
    }

    public static int acv() {
        Context context = ac.getContext();
        if (!an.isConnected(context)) {
            return 0;
        }
        if (an.is2G(context)) {
            return 1;
        }
        if (an.is3G(context)) {
            return 2;
        }
        if (an.is4G(context)) {
            return 3;
        }
        if (an.isWifi(context)) {
            return 4;
        }
        return 5;
    }
}
