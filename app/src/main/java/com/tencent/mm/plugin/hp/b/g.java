package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bdb;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;

public final class g implements a {
    public final boolean a(Context context, String[] strArr) {
        if (strArr.length < 2) {
            x.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            return false;
        }
        boolean z;
        String str = strArr[1];
        if (b.ceK()) {
            z = true;
            switch (str.hashCode()) {
                case -838846263:
                    if (str.equals("update")) {
                        z = false;
                        break;
                    }
                    break;
                case 3510:
                    if (str.equals("nd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3083269:
                    if (str.equals("diff")) {
                        z = true;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        z = true;
                        break;
                    }
                    break;
                case 3529469:
                    if (str.equals("show")) {
                        z = true;
                        break;
                    }
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    bnr com_tencent_mm_protocal_c_bnr;
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    Object linkedList = new LinkedList();
                    String str2 = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde";
                    String str3 = "";
                    if (strArr.length >= 3) {
                        str = strArr[2];
                    } else {
                        str = str2;
                    }
                    if (strArr.length >= 4) {
                        str3 = strArr[3];
                    }
                    if (strArr.length >= 5) {
                        com_tencent_mm_protocal_c_bnr = new bnr();
                        com_tencent_mm_protocal_c_bnr.aAM = "sdk";
                        com_tencent_mm_protocal_c_bnr.value = strArr[4];
                        linkedList.add(com_tencent_mm_protocal_c_bnr);
                    } else {
                        com_tencent_mm_protocal_c_bnr = new bnr();
                        com_tencent_mm_protocal_c_bnr.aAM = "sdk";
                        com_tencent_mm_protocal_c_bnr.value = String.valueOf(VERSION.SDK_INT);
                        linkedList.add(com_tencent_mm_protocal_c_bnr);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_bnr = (bnr) it.next();
                        stringBuilder.append(com_tencent_mm_protocal_c_bnr.aAM).append(":").append(com_tencent_mm_protocal_c_bnr.value).append("\n");
                    }
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", str, str3, stringBuilder.toString());
                    ar.CG().a(new com.tencent.mm.plugin.hp.c.a(str, str3, linkedList), 0);
                    return true;
                case true:
                    i.a(ac.getContext().getString(R.l.ejp), ac.getContext().getString(R.l.ejp), ac.getContext().getString(R.l.epy), new 1(this), ac.getContext().getString(R.l.eRQ), null);
                    return true;
                case true:
                    ar.Dm().F(new 2(this, strArr));
                    return true;
                case true:
                    bnv com_tencent_mm_protocal_c_bnv = new bnv();
                    com_tencent_mm_protocal_c_bnv.wQH = 1000;
                    com_tencent_mm_protocal_c_bnv.wQE = 2;
                    com_tencent_mm_protocal_c_bnv.wQF = 2;
                    com_tencent_mm_protocal_c_bnv.state = 2;
                    com_tencent_mm_protocal_c_bnv.vWt = "android_tinker_id_123123131231231";
                    bdb com_tencent_mm_protocal_c_bdb = new bdb();
                    com_tencent_mm_protocal_c_bdb.vZU = "c3282ad2467fad9561227bc9b5b6712c";
                    com_tencent_mm_protocal_c_bdb.vYh = 118617;
                    com_tencent_mm_protocal_c_bdb.nfX = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
                    com_tencent_mm_protocal_c_bnv.wQE = 3;
                    com_tencent_mm_protocal_c_bdb.vZU = "3ba62fdbd98df2bdf5da7d726010d867";
                    com_tencent_mm_protocal_c_bdb.vYh = 33338711;
                    com_tencent_mm_protocal_c_bdb.nfX = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    com_tencent_mm_protocal_c_bnv.wQG = com_tencent_mm_protocal_c_bdb;
                    new e(new com.tencent.mm.plugin.hp.d.b(com_tencent_mm_protocal_c_bnv)).fN(false);
                    return true;
                case true:
                    if (strArr.length >= 6) {
                        bh.VJ(strArr[5]);
                    }
                    return true;
                case true:
                    com.tencent.mm.plugin.hp.tinker.g.ah(ac.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.ai(ac.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.E(ac.getContext(), 0);
                    p.bZf();
                    return true;
                default:
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", str);
                    break;
            }
        }
        z = true;
        switch (str.hashCode()) {
            case 94627080:
                if (str.equals("check")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                try {
                    com.tinkerboots.sdk.a.cJn().oe(true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                return true;
            default:
                x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str);
                return false;
        }
    }
}
