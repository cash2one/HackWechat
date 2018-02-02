package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.a;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ae {
    private Context context;
    private x fAh = null;
    private SimpleDateFormat kmq = new SimpleDateFormat("yyyy-MM-dd");
    String mNV = null;
    List<au> yrI;
    private String yxp = null;
    ArrayList<Uri> yxq = new ArrayList();

    public ae(Context context, List<au> list, x xVar) {
        this.context = context;
        this.yrI = list;
        this.fAh = xVar;
    }

    public final String ctc() {
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.mNV == null);
        objArr[1] = Integer.valueOf(this.yrI.size());
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (this.mNV != null) {
            return this.mNV;
        }
        this.yxq.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ctd());
        stringBuilder.append("\n\n");
        for (au auVar : this.yrI) {
            if (this.yxp == null) {
                this.yxp = ga(auVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yxp}));
                stringBuilder.append("\n");
            } else {
                str = ga(auVar.field_createTime);
                if (!str.equals(this.yxp)) {
                    this.yxp = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.yxp}));
                    stringBuilder.append("\n");
                }
            }
            String str3;
            if (auVar.cjg()) {
                if (!auVar.cjg()) {
                    str3 = null;
                } else if (auVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content});
                } else if (this.fAh.field_username.endsWith("@chatroom")) {
                    str3 = ba.hO(auVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content.substring(ba.hO(auVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), auVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (auVar.cje()) {
                if (auVar.cje()) {
                    long j = auVar.field_msgId;
                    long j2 = auVar.field_msgSvrId;
                    str = ab.fY(j);
                    if (bh.ov(str)) {
                        str = ab.fZ(j2);
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", new Object[]{str});
                    if (!bh.ov(str)) {
                        this.yxq.add(Uri.parse("file://" + str));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.dZo), new File(str).getName(), this.context.getString(R.l.dZk)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (auVar.ciW()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(R.l.dZt)});
                } else if (auVar.cja()) {
                    str = auVar.field_isSend == 1 ? this.context.getString(R.l.dZr) : this.context.getString(R.l.dZq);
                } else if (auVar.aNe()) {
                    b ixVar = new ix();
                    ixVar.fzx.fzr = 1;
                    ixVar.fzx.fnB = auVar;
                    a.xef.m(ixVar);
                    str = String.format("[%s]", new Object[]{ixVar.fzy.fwv});
                } else {
                    if (auVar.aNc()) {
                        g.a fT = g.a.fT(bh.VH(auVar.field_content));
                        if (fT != null) {
                            switch (fT.type) {
                                case 4:
                                case 6:
                                    com.tencent.mm.pluginsdk.model.app.b Rz = an.aqd().Rz(fT.fny);
                                    if (Rz != null) {
                                        File file = new File(Rz.field_fileFullPath);
                                        if (file.exists()) {
                                            this.yxq.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, true);
                            if (aZ == null) {
                                str = "";
                            } else {
                                String str4 = aZ.field_appName;
                                str = 6 == fT.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.dZj), str4, this.context.getString(R.l.dZk)}) : String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZj), str4});
                            }
                        }
                    } else if (auVar.cjf()) {
                        ar.Hg();
                        str = c.Fa().EK(auVar.field_content).fpL;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.dZl), str});
                    } else if (auVar.cjh()) {
                        r7 = new Object[3];
                        o.TU();
                        r7[1] = new File(s.nt(auVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(R.l.dZk);
                        str = String.format("[%s: %s(%s)]", r7);
                        o.TU();
                        File file2 = new File(s.nt(auVar.field_imgPath));
                        if (file2.exists()) {
                            this.yxq.add(Uri.fromFile(file2));
                        }
                    } else if (auVar.cjj() || auVar.cjk()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(R.l.dZm)});
                    }
                    str = null;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[]{str});
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aC(auVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.mNV = stringBuilder.toString();
        return this.mNV;
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
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = q.FU();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String ga(long j) {
        return this.kmq.format(new Date(j));
    }
}
