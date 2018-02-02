package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private static synchronized void aC(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bh.ov(str)) {
                a fT = a.fT(str);
                if (!(fT == null || bh.ov(fT.hcP))) {
                    long j;
                    c oD = b.WA().oD(fT.hcP);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = fT.hcP;
                    objArr[1] = str2;
                    objArr[2] = oD;
                    if (oD == null || !oD.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (oD != null) {
                        j = oD.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr[4] = Long.valueOf(j);
                    x.i(str3, str4, objArr);
                    if (oD == null) {
                        x.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    } else if (!oD.field_insertmsg || oD.field_localMsgId <= 0) {
                        cf auVar = new au();
                        auVar.aq(ba.hR(str2));
                        auVar.setType(436207665);
                        auVar.setContent(q.FS() + ":\n" + str);
                        String s = g.s((bh.Wp()).getBytes());
                        String fullPath = o.Pw().getFullPath(s);
                        o.Pw();
                        s = com.tencent.mm.aq.g.ll(s);
                        com.tencent.mm.aq.a.a PA = o.PA();
                        String str5 = fT.hcz;
                        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                        aVar.hDC = fullPath;
                        aVar.hDA = true;
                        PA.a(str5, null, aVar.PK());
                        auVar.dT(s);
                        auVar.eR(1);
                        auVar.dS(str2);
                        auVar.eQ(3);
                        auVar.ao(ba.i(auVar));
                        x.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(fT.hcP, true, auVar.field_msgId);
                        com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
                        fT.a(gVar);
                        gVar.field_msgId = auVar.field_msgId;
                        com.tencent.mm.plugin.y.a.bio().b(gVar);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            if (!bh.ov(str)) {
                x.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[]{str, Boolean.valueOf(z)});
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                b.WA().b(cVar);
            }
        }
    }

    public static synchronized void aD(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bh.ov(str)) {
                a fT = a.fT(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = fT != null ? fT.hcP : "";
                objArr[1] = str.trim().replace(" ", "");
                x.d(str3, str4, objArr);
                if (!(fT == null || bh.ov(fT.hcP))) {
                    boolean z2;
                    long j;
                    String str5 = fT.hcP;
                    c oD = b.WA().oD(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (oD == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (oD == null || !oD.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    if (oD != null) {
                        j = oD.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr2[4] = Long.valueOf(j);
                    x.i(str4, str6, objArr2);
                    if (oD != null && oD.field_insertmsg && oD.field_localMsgId > 0 && ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(oD.field_localMsgId).field_msgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        b.WA().a(oD, new String[0]);
                    } else if (oD == null || !oD.field_insertmsg || oD.field_localMsgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        aC(str, str2);
                    } else {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        g(oD.field_localMsgId, str);
                    }
                }
            }
        }
    }

    public static synchronized void r(String str, String str2, String str3) {
        synchronized (h.class) {
            x.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[]{str, str2, Boolean.valueOf(bh.ov(str3)), b.WA().oD(str)});
            if (b.WA().oD(str) == null) {
                a(str, false, 0);
            }
            aD(str3, str2);
        }
    }

    public static synchronized void b(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            x.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[]{str, str3, str4});
            if (!(bh.ov(str) || bh.ov(str3) || bh.ov(str4))) {
                com.tencent.mm.plugin.aa.a.b.a oC = b.WB().oC(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = oC;
                if (oC == null || !oC.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                x.i(str6, str7, objArr);
                if (oC == null || !oC.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (bh.ov(str5)) {
                        x.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(q.FS())) {
                            str5 = ac.getContext().getString(a$i.uMg, new Object[]{str8});
                        } else {
                            String L = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(str, str2);
                            str5 = ac.getContext().getString(a$i.uMh, new Object[]{L, str8});
                        }
                    } else {
                        x.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[]{str5});
                    }
                    a(str5, str2, oC, str4);
                }
            }
        }
    }

    public static synchronized void s(String str, String str2, String str3) {
        synchronized (h.class) {
            try {
                if (!(bh.ov(str) || bh.ov(str2) || bh.ov(str3))) {
                    x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[]{str2, str3});
                    com.tencent.mm.plugin.aa.a.b.a oC = b.WB().oC(str3);
                    if (oC == null || !oC.field_insertmsg) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, oC, str3);
                    } else {
                        cf dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(oC.field_msgId);
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[]{Long.valueOf(oC.field_msgId), Long.valueOf(dH.field_msgId)});
                        dH.setContent(str);
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(oC.field_msgId, dH);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            au auVar = new au();
            auVar.eR(0);
            auVar.dS(str2);
            auVar.eQ(3);
            auVar.setContent(str);
            auVar.aq(ba.n(str2, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            long Q = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(auVar);
            x.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[]{Long.valueOf(Q)});
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (Q > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = Q;
                b.WB().a(aVar);
            }
        }
    }

    public static synchronized void g(long j, String str) {
        synchronized (h.class) {
            if (j > 0) {
                if (!bh.ov(str)) {
                    a fT = a.fT(str);
                    if (fT == null || bh.ov(fT.hcP)) {
                        x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[]{Long.valueOf(j)});
                    } else {
                        x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), fT.hcP});
                        c oD = b.WA().oD(fT.hcP);
                        if (oD != null) {
                            long j2 = oD.field_localMsgId;
                            cf dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(j2);
                            if (dH.field_msgId > 0) {
                                dH.setContent(ba.hP(dH.field_content) + ":\n" + str);
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(j2, dH);
                                x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[]{Long.valueOf(j2), oD.field_billNo});
                            } else {
                                x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[]{oD.field_billNo, Long.valueOf(oD.field_localMsgId), Long.valueOf(j), Long.valueOf(dH.field_msgId)});
                            }
                        } else {
                            oD = new c();
                            oD.field_localMsgId = j;
                            oD.field_billNo = fT.hcP;
                            oD.field_insertmsg = true;
                            b.WA().a(oD);
                            x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), fT.hcP});
                        }
                    }
                }
            }
            x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[]{Long.valueOf(j), Boolean.valueOf(bh.ov(str))});
        }
    }

    public static void h(long j, String str) {
        x.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[]{Long.valueOf(j), str});
        au dH = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(j);
        String oz = oz(str);
        if (!bh.ov(oz)) {
            dH.setContent(oz);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(j, dH);
    }

    public static boolean a(Activity activity, y yVar) {
        if (yVar.vDQ == 1) {
            x.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            String str = yVar.odv;
            str = yVar.odw;
            str = yVar.odx;
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, 0);
        } else if (yVar.vDQ == 2) {
            x.i("MicroMsg.AAUtil", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, yVar.odv, yVar.ody, yVar.odw, yVar.odx, false, null);
        } else {
            x.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + yVar.vDQ);
            return false;
        }
    }

    private static String oz(String str) {
        UnsupportedEncodingException e;
        String str2 = (String) bi.y(str, "sysmsg").get(".sysmsg.paymsg.appmsgcontent");
        if (bh.ov(str2)) {
            x.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            return "";
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                x.d("MicroMsg.AAUtil", "msgContent: %s", new Object[]{str2});
                return str2;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                x.e("MicroMsg.AAUtil", e.getMessage());
                return str2;
            }
        } catch (UnsupportedEncodingException e3) {
            UnsupportedEncodingException unsupportedEncodingException = e3;
            str2 = str3;
            e = unsupportedEncodingException;
            x.e("MicroMsg.AAUtil", e.getMessage());
            return str2;
        }
    }

    public static double b(String str, String str2, int i, int i2) {
        try {
            return new BigDecimal(bh.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static long aE(String str, String str2) {
        try {
            double d = bh.getDouble(str, 0.0d);
            double d2 = bh.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).longValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static List<String> oA(String str) {
        if (bh.ov(str)) {
            x.i("MicroMsg.AAUtil", "illegal chatroomName");
            return new ArrayList();
        } else if (s.eV(str)) {
            try {
                r0 = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().hH(str);
                if (r0 == null) {
                    return new ArrayList();
                }
                return r0;
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[]{e.getMessage()});
                return new ArrayList();
            }
        } else {
            r0 = new ArrayList();
            r0.add(q.FS());
            r0.add(str);
            return r0;
        }
    }

    public static String WJ() {
        com.tencent.mm.kernel.g.Dk();
        return bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xvN, null));
    }

    public static void oB(String str) {
        String WJ = WJ();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!bh.ov(WJ)) {
            String[] split = WJ.split(",");
            int i = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i < 5) {
                    stringBuilder.append(str2);
                    stringBuilder.append(",");
                    i++;
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        x.d("MicroMsg.AAUtil", "recent group: %s", new Object[]{stringBuilder.toString()});
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xvN, stringBuilder.toString());
    }
}
