package com.tencent.mm.ui.chatting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class m {
    public static boolean a(a aVar, List<au> list, x xVar) {
        if (aVar == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            return false;
        } else if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            return false;
        } else if (xVar != null && ((int) xVar.gJd) > 0) {
            return b(aVar, list, xVar);
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(a aVar, List<au> list, x xVar) {
        String substring;
        String format;
        if (xVar.field_username.endsWith("@chatroom")) {
            if (bh.ov(xVar.field_nickname)) {
                String str = "";
                for (String substring2 : com.tencent.mm.z.m.gj(xVar.field_username)) {
                    str = str + r.gu(substring2) + ", ";
                }
                substring2 = str.substring(0, str.length() - 2);
            } else {
                substring2 = xVar.AP();
            }
            format = String.format(aVar.getString(R.l.eJU), new Object[]{substring2});
        } else {
            substring2 = aVar.getString(R.l.eJT);
            Object[] objArr = new Object[2];
            objArr[0] = xVar.AP();
            ar.Hg();
            objArr[1] = c.CU().get(4, null);
            format = String.format(substring2, objArr);
        }
        g.pQN.h(10811, new Object[]{Integer.valueOf(7), Integer.valueOf(list.size())});
        if ((q.Gd() & 1) == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (au auVar : list) {
                if (auVar.cjh()) {
                    o.TU();
                    arrayList.add(s.nt(auVar.field_imgPath));
                    arrayList2.add(null);
                } else if (auVar.aNc()) {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(auVar.field_content);
                    if (fT != null) {
                        switch (fT.type) {
                            case 4:
                            case 6:
                                b Rz = an.aqd().Rz(fT.fny);
                                if (Rz != null) {
                                    File file = new File(Rz.field_fileFullPath);
                                    if (file.exists()) {
                                        arrayList.add(file.getAbsolutePath());
                                        arrayList2.add(fT.title);
                                    }
                                } else {
                                    continue;
                                }
                            default:
                        }
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + arrayList + "file name = " + arrayList2);
            }
            substring2 = new QQMailHistoryExporter(aVar.getContext(), list, xVar).ctc();
            Intent intent = new Intent();
            intent.putExtra("mail_mode", 6);
            intent.putExtra("mail_content", substring2);
            intent.putExtra("subject", format);
            intent.putExtra("show_qqmail", true);
            intent.putStringArrayListExtra("mail_attach", (ArrayList) arrayList);
            intent.putStringArrayListExtra("mail_attach_title", (ArrayList) arrayList2);
            d.a(aVar, "qqmail", ".ui.ComposeUI", intent, 220);
            return false;
        }
        ArrayList arrayList3;
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
        ae aeVar = new ae(aVar.getContext(), list, xVar);
        substring2 = aeVar.ctc();
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.SUBJECT", format);
        intent2.putExtra("android.intent.extra.TEXT", substring2);
        format = "android.intent.extra.STREAM";
        String str2 = "MicroMsg.OtherMailHistoryExporter";
        String str3 = "get image attach: history is null? %B, selectItems.size = %d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(aeVar.mNV == null);
        objArr2[1] = Integer.valueOf(aeVar.yrI.size());
        com.tencent.mm.sdk.platformtools.x.d(str2, str3, objArr2);
        if (aeVar.mNV != null) {
            arrayList3 = aeVar.yxq;
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
            aeVar.ctc();
            arrayList3 = aeVar.yxq;
        }
        intent2.putParcelableArrayListExtra(format, arrayList3);
        try {
            aVar.startActivity(Intent.createChooser(intent2, aVar.getString(R.l.eJS)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(aVar.getContext(), R.l.eJV, 0).show();
        }
        return true;
    }
}
