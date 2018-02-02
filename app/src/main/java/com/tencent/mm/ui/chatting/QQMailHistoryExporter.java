package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] jRP = new char[]{'<', '>', '\"', '\'', '&', '\n'};
    private static final String[] jRQ = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String yxr = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + s.fj("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private Context context;
    private x fAh = null;
    private float gUh = 1.0f;
    private List<au> yrI;
    private String yxp = null;

    private static String VG(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = jRP.length - 1; length2 >= 0; length2--) {
                if (jRP[length2] == charAt) {
                    stringBuffer.append(jRQ[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public QQMailHistoryExporter(Context context, List<au> list, x xVar) {
        this.context = context;
        this.yrI = list;
        this.fAh = xVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String ctc() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[]{Integer.valueOf(this.yrI.size())});
        if (a.ey(this.context)) {
            this.gUh = a.eu(this.context);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"history\">\n");
        stringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[]{Float.valueOf(this.gUh), Float.valueOf(this.gUh), ctd()}));
        for (au auVar : this.yrI) {
            String ga;
            if (this.yxp == null) {
                this.yxp = ga(auVar.field_createTime);
                stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.gUh), this.yxp}));
            } else {
                ga = ga(auVar.field_createTime);
                if (!ga.equals(this.yxp)) {
                    this.yxp = ga;
                    stringBuilder.append("<br>");
                    stringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[]{Float.valueOf(this.gUh), this.yxp}));
                }
            }
            String str;
            if (auVar.cjg()) {
                if (!auVar.cjg()) {
                    str = null;
                } else if (auVar.field_isSend == 1) {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.gUh), aC(auVar), Float.valueOf(this.gUh), VG(auVar.field_content)});
                } else if (this.fAh.field_username.endsWith("@chatroom")) {
                    str = ba.hO(auVar.field_content) != -1 ? String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.gUh), aC(auVar), Float.valueOf(this.gUh), VG(auVar.field_content.substring(ba.hO(auVar.field_content) + 1).trim())}) : null;
                } else {
                    str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.gUh), aC(auVar), Float.valueOf(this.gUh), VG(auVar.field_content)});
                }
                stringBuilder.append(str);
            } else if (auVar.cje()) {
                if (auVar.cje()) {
                    long j = auVar.field_msgId;
                    long j2 = auVar.field_msgSvrId;
                    ga = ab.fY(j);
                    if (bh.ov(ga)) {
                        ga = ab.fZ(j2);
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[]{ga});
                    if (!bh.ov(ga)) {
                        r2 = "file://" + ga;
                        ga = String.format(yxr, new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), r2, ga});
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.gUh), aC(auVar), Float.valueOf(this.gUh), ga});
                        stringBuilder.append(str);
                    }
                }
                str = null;
                stringBuilder.append(str);
            } else {
                ga = null;
                if (auVar.ciW()) {
                    ga = String.format("[%s]", new Object[]{this.context.getString(R.l.dZt)});
                } else if (auVar.cja()) {
                    ga = auVar.field_isSend == 1 ? this.context.getString(R.l.dZr) : this.context.getString(R.l.dZq);
                } else if (auVar.aNe()) {
                    b ixVar = new ix();
                    ixVar.fzx.fzr = 1;
                    ixVar.fzx.fnB = auVar;
                    com.tencent.mm.sdk.b.a.xef.m(ixVar);
                    ga = String.format("[%s]", new Object[]{ixVar.fzy.fwv});
                } else if (auVar.aNc()) {
                    r2 = "";
                    ga = auVar.field_content;
                    if (this.fAh.field_username.endsWith("@chatroom")) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                        int hO = ba.hO(auVar.field_content);
                        if (hO != -1) {
                            ga = auVar.field_content.substring(hO + 1).trim();
                        }
                    }
                    g.a fT = g.a.fT(bh.VH(ga));
                    if (fT == null) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                        ga = String.format("[%s]", new Object[]{this.context.getString(R.l.dZj)});
                    } else {
                        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, true);
                        ga = (aZ == null || bh.ov(aZ.field_appName)) ? fT.appName : aZ.field_appName;
                        ga = com.tencent.mm.pluginsdk.model.app.g.a(this.context, aZ, ga);
                        if (auVar.cjl()) {
                            ga = bh.ov(ga) ? VG(fT.title) : String.format("[%s: %s]", new Object[]{ga, VG(fT.title)});
                        } else {
                            if (!auVar.cjm()) {
                                switch (fT.type) {
                                    case 1:
                                        if (!bh.ov(ga)) {
                                            ga = String.format("[%s: %s]", new Object[]{ga, VG(fT.title)});
                                            break;
                                        }
                                        ga = VG(fT.title);
                                        break;
                                    case 2:
                                        ga = ab.a(auVar, fT);
                                        if (!bh.ov(ga)) {
                                            r2 = "file://" + ga;
                                            ga = String.format(yxr, new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), r2, ga});
                                            break;
                                        }
                                    case 3:
                                        if (!bh.ov(fT.description)) {
                                            ga = String.format("[%s: %s-%s]", new Object[]{this.context.getString(R.l.dZp), VG(fT.title), VG(fT.description)});
                                            break;
                                        }
                                        ga = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZp), VG(fT.title)});
                                        break;
                                    case 4:
                                    case 5:
                                        ga = String.format("[%s: %s]", new Object[]{VG(fT.title), VG(fT.url)});
                                        break;
                                    case 6:
                                        if (!bh.ov(fT.description)) {
                                            ga = String.format("[%s: %s-%s(%s)]", new Object[]{this.context.getString(R.l.dZn), VG(fT.title), VG(fT.description), this.context.getString(R.l.dZk)});
                                            break;
                                        }
                                        ga = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZn), VG(fT.title)});
                                        break;
                                    case 8:
                                        ga = String.format("[%s]", new Object[]{this.context.getString(R.l.dZm)});
                                        break;
                                    default:
                                        ga = String.format("[%s]", new Object[]{this.context.getString(R.l.dZj)});
                                        break;
                                }
                            }
                            ga = ab.a(auVar, fT);
                            if (!bh.ov(ga)) {
                                r2 = "file://" + ga;
                                ga = String.format(yxr, new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), r2, ga});
                            }
                            ga = r2;
                        }
                    }
                } else if (auVar.cjf()) {
                    ar.Hg();
                    ga = c.Fa().EK(auVar.field_content).fpL;
                    ga = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZl), ga});
                } else if (auVar.cjh()) {
                    r2 = new Object[3];
                    o.TU();
                    r2[1] = new File(com.tencent.mm.modelvideo.s.nt(auVar.field_imgPath)).getName();
                    r2[2] = this.context.getString(R.l.dZk);
                    ga = String.format("[%s: %s(%s)]", r2);
                } else if (auVar.cjj() || auVar.cjk()) {
                    ga = String.format("[%s]", new Object[]{this.context.getString(R.l.dZm)});
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[]{ga});
                stringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[]{Float.valueOf(this.gUh), aC(auVar), Float.valueOf(this.gUh), ga}));
            }
        }
        stringBuilder.append("\n</div>\n");
        return stringBuilder.toString();
    }

    private String ctd() {
        String substring;
        if (this.fAh.field_username.endsWith("@chatroom")) {
            if (bh.ov(this.fAh.field_nickname)) {
                String str = "";
                for (String substring2 : m.gj(this.fAh.field_username)) {
                    str = str + r.gu(substring2) + ", ";
                }
                substring2 = str.substring(0, str.length() - 2);
            } else {
                substring2 = this.fAh.AP();
            }
            return String.format(this.context.getString(R.l.eJP), new Object[]{substring2});
        }
        substring2 = this.context.getString(R.l.eJQ);
        Object[] objArr = new Object[2];
        objArr[0] = this.fAh.AP();
        ar.Hg();
        objArr[1] = c.CU().get(4, null);
        return String.format(substring2, objArr);
    }

    private String aC(au auVar) {
        String str;
        String str2 = null;
        if (this.fAh.field_username.endsWith("@chatroom")) {
            str = auVar.field_content;
            int hO = ba.hO(str);
            if (hO != -1) {
                str2 = r.gu(str.substring(0, hO).trim());
            }
        } else {
            str2 = r.gu(auVar.field_talker);
        }
        if (auVar.field_isSend == 1) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = q.FU();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String ga(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
