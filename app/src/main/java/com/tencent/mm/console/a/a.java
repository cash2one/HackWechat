package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    static {
        b.a(new a(), new String[]{"//fts"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -1354714445:
                if (str.equals("copydb")) {
                    obj = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    obj = 7;
                    break;
                }
                break;
            case -1132164145:
                if (str.equals("clearconfig")) {
                    obj = 5;
                    break;
                }
                break;
            case -617644996:
                if (str.equals("clearunread")) {
                    obj = 8;
                    break;
                }
                break;
            case 3237038:
                if (str.equals("info")) {
                    obj = 6;
                    break;
                }
                break;
            case 104187309:
                if (str.equals("msbiz")) {
                    obj = null;
                    break;
                }
                break;
            case 624344507:
                if (str.equals("mobilenet")) {
                    obj = 9;
                    break;
                }
                break;
            case 819712873:
                if (str.equals("deletedb")) {
                    obj = 1;
                    break;
                }
                break;
            case 955180557:
                if (str.equals("corrupt")) {
                    obj = 3;
                    break;
                }
                break;
            case 1873247692:
                if (str.equals("addchatroomcontact")) {
                    obj = 4;
                    break;
                }
                break;
        }
        File file;
        g gVar;
        switch (obj) {
            case null:
                asq QX = d.QX();
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = QX.ksP.iterator();
                while (it.hasNext()) {
                    asp com_tencent_mm_protocal_c_asp = (asp) it.next();
                    stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{r.gu(com_tencent_mm_protocal_c_asp.vIy), Double.valueOf(com_tencent_mm_protocal_c_asp.wAg), n.ag("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_asp.wAh / 1000)}));
                    stringBuilder.append("\n");
                }
                x(context, stringBuilder.toString());
                break;
            case 1:
                ar.Hg();
                file = new File(c.FB(), "FTS5IndexMicroMsg.db");
                if (file.exists()) {
                    file.delete();
                }
                Process.killProcess(Process.myPid());
                break;
            case 2:
                ar.Hg();
                file = new File(c.FB(), "FTS5IndexMicroMsg.db");
                File file2 = new File("/sdcard/IndexMicroMsg.db");
                if (file2.exists()) {
                    file2.delete();
                }
                FileOp.x(file.getAbsolutePath(), file2.getAbsolutePath());
                break;
            case 3:
                gVar = new g();
                gVar.mLR = 65522;
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
                break;
            case 4:
                gVar = new g();
                gVar.fDj = strArr[2];
                gVar.mLR = 65523;
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
                break;
            case 5:
                com.tencent.mm.storage.w.a[] aVarArr = new com.tencent.mm.storage.w.a[]{com.tencent.mm.storage.w.a.xuz, com.tencent.mm.storage.w.a.xuA, com.tencent.mm.storage.w.a.xuB, com.tencent.mm.storage.w.a.xuC, com.tencent.mm.storage.w.a.xuD, com.tencent.mm.storage.w.a.xuE, com.tencent.mm.storage.w.a.xuF, com.tencent.mm.storage.w.a.xuG, com.tencent.mm.storage.w.a.xuH, com.tencent.mm.storage.w.a.xuI, com.tencent.mm.storage.w.a.xuJ, com.tencent.mm.storage.w.a.xuK, com.tencent.mm.storage.w.a.xuL, com.tencent.mm.storage.w.a.xuM, com.tencent.mm.storage.w.a.xuN, com.tencent.mm.storage.w.a.xuO, com.tencent.mm.storage.w.a.xuP, com.tencent.mm.storage.w.a.xuQ, com.tencent.mm.storage.w.a.xuR, com.tencent.mm.storage.w.a.xuS, com.tencent.mm.storage.w.a.xuT, com.tencent.mm.storage.w.a.xuU, com.tencent.mm.storage.w.a.xuV, com.tencent.mm.storage.w.a.xuW, com.tencent.mm.storage.w.a.xuX, com.tencent.mm.storage.w.a.xuY};
                for (int i = 0; i < 26; i++) {
                    com.tencent.mm.storage.w.a aVar = aVarArr[i];
                    ar.Hg();
                    c.CU().a(aVar, "");
                }
                break;
            case 6:
                file = new File(com.tencent.mm.plugin.fts.a.c.mKv, "FTS5IndexMicroMsgInfo.txt");
                if (file.exists()) {
                    try {
                        x(context, FileOp.bT(file.getAbsolutePath()));
                        break;
                    } catch (IOException e) {
                        break;
                    }
                }
                break;
            case 7:
                gVar = new g();
                gVar.mLR = 65521;
                gVar.mLW = 100;
                if (strArr.length > 2) {
                    try {
                        gVar.mLW = Integer.valueOf(strArr[2]).intValue();
                    } catch (Exception e2) {
                    }
                }
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
                break;
            case 8:
                gVar = new g();
                gVar.mLR = 65524;
                ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
                break;
            case 9:
                if (!strArr[2].equals("0")) {
                    ((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).iY(true);
                    break;
                }
                ((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).iY(false);
                break;
        }
        return true;
    }

    private static void x(Context context, String str) {
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvv);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(context, null, textView, null);
    }
}
