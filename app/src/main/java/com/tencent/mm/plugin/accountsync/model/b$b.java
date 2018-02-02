package com.tencent.mm.plugin.accountsync.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.plugin.accountsync.model.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b$b implements a {
    private String ikY;
    private int toScene;
    private Uri uri;

    public final int bJ(android.content.Context r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r2 = 3;
        r7 = 0;
        r4 = 2;
        r3 = 0;
        r6 = 1;
        if (r12 != 0) goto L_0x0012;
    L_0x0007:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "null context";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = com.tencent.mm.z.ar.Hi();
        if (r0 == 0) goto L_0x001e;
    L_0x0018:
        r0 = com.tencent.mm.z.ar.Cs();
        if (r0 == 0) goto L_0x0029;
    L_0x001e:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "not login, start bind login";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r2;
        goto L_0x0011;
    L_0x0029:
        com.tencent.mm.z.ar.Hg();
        r0 = com.tencent.mm.z.c.CU();
        r1 = 6;
        r5 = "";
        r0 = r0.get(r1, r5);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bh.ov(r0);
        if (r0 == 0) goto L_0x004b;
    L_0x0040:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "not bind mobile, start bind mobie";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r4;
        goto L_0x0011;
    L_0x004b:
        r0 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.g.a.aZ(r12, r0);
        if (r0 != 0) goto L_0x005f;
    L_0x0054:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "no contacts permission";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x0011;
    L_0x005f:
        r0 = r11.uri;
        if (r0 == 0) goto L_0x0140;
    L_0x0063:
        r0 = r12.getContentResolver();
        r1 = r11.uri;
        r2 = new java.lang.String[r2];
        r5 = "contact_id";
        r2[r7] = r5;
        r5 = "_id";
        r2[r6] = r5;
        r5 = "data4";
        r2[r4] = r5;
        r4 = r3;
        r5 = r3;
        r3 = r0.query(r1, r2, r3, r4, r5);
        if (r3 != 0) goto L_0x008d;
    L_0x0082:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "query database err";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x0011;
    L_0x008d:
        r0 = r3.moveToFirst();
        if (r0 != 0) goto L_0x00a2;
    L_0x0093:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "query database err, move to first fail";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r3.close();
        r0 = r6;
        goto L_0x0011;
    L_0x00a2:
        r0 = "data4";
        r0 = r3.getColumnIndex(r0);
        r1 = -1;
        if (r0 != r1) goto L_0x00bb;
    L_0x00ac:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "no data4 segment exist";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r3.close();
        r0 = r6;
        goto L_0x0011;
    L_0x00bb:
        r2 = "";
        r1 = "";
        r4 = "";
        r2 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r0 = "contact_id";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        if (r0 < 0) goto L_0x00f7;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
    L_0x00d1:
        r1 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
    L_0x00d5:
        r0 = "_id";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        if (r0 < 0) goto L_0x00fb;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
    L_0x00de:
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
    L_0x00e2:
        r3.close();
        r3 = com.tencent.mm.sdk.platformtools.bh.ov(r2);
        if (r3 == 0) goto L_0x013a;
    L_0x00eb:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "null friendmobile";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x0011;
    L_0x00f7:
        r1 = "";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        goto L_0x00d5;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
    L_0x00fb:
        r0 = "";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        goto L_0x00e2;
    L_0x00ff:
        r0 = move-exception;
        r5 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7 = "match error, %s\n%s";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r8 = 2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r9 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r10 = r0.getMessage();	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r9 = 1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r0 = com.tencent.mm.sdk.platformtools.bh.i(r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r8[r9] = r0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        com.tencent.mm.sdk.platformtools.x.e(r5, r7, r8);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r5 = "result friendMobileMd5 %s contact_id %s data_id %s";	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7 = 3;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r8 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7[r8] = r2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r2 = 1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7[r2] = r1;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r1 = 2;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r7[r1] = r4;	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        com.tencent.mm.sdk.platformtools.x.e(r0, r5, r7);	 Catch:{ Exception -> 0x00ff, all -> 0x0135 }
        r3.close();
        r0 = r6;
        goto L_0x0011;
    L_0x0135:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x013a:
        r0 = r11.b(r12, r2, r0, r1);
        goto L_0x0011;
    L_0x0140:
        r0 = r11.ikY;
        r0 = com.tencent.mm.sdk.platformtools.bh.ov(r0);
        if (r0 != 0) goto L_0x015c;
    L_0x0148:
        r0 = r11.ikY;
        r0 = com.tencent.mm.pluginsdk.a.Id(r0);
        r0 = r0.getBytes();
        r0 = com.tencent.mm.a.g.s(r0);
        r0 = r11.b(r12, r0, r3, r3);
        goto L_0x0011;
    L_0x015c:
        r0 = "MicroMsg.ProcessorToChattingOrTimeLineByPhone";
        r1 = "uri is null and the phone num is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r6;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.accountsync.model.b$b.bJ(android.content.Context):int");
    }

    public b$b(int i, String str, Uri uri) {
        this.toScene = i;
        this.ikY = str;
        this.uri = uri;
    }

    private int b(Context context, String str, String str2, String str3) {
        b kS = af.OD().kS(str);
        if (context == null) {
            x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
            return 1;
        } else if (kS == null) {
            x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
            return 1;
        } else {
            String username = kS.getUsername();
            if (bh.ov(username)) {
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is " + str);
                return 1;
            }
            ar.Hg();
            if (c.EY().WK(username)) {
                g.pQN.h(11157, new Object[]{Integer.valueOf(this.toScene)});
                com.tencent.mm.sdk.b.b spVar;
                switch (this.toScene) {
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", username);
                        intent.putExtra("finish_direct", true);
                        intent.addFlags(67108864);
                        com.tencent.mm.plugin.c.a.ifs.e(intent, context);
                        return 0;
                    case 2:
                        Intent intent2 = new Intent();
                        intent2.putExtra("sns_userName", username);
                        intent2.addFlags(67108864);
                        d.b(context, "sns", ".ui.SnsUserUI", intent2);
                        return 0;
                    case 3:
                        spVar = new sp();
                        spVar.fKq.fuL = 5;
                        spVar.fKq.talker = username;
                        spVar.fKq.context = context;
                        spVar.fKq.fKl = 3;
                        com.tencent.mm.sdk.b.a.xef.m(spVar);
                        return 0;
                    case 4:
                        spVar = new sp();
                        spVar.fKq.fuL = 5;
                        spVar.fKq.talker = username;
                        spVar.fKq.context = context;
                        spVar.fKq.fKl = 2;
                        com.tencent.mm.sdk.b.a.xef.m(spVar);
                        return 0;
                    default:
                        return 1;
                }
            } else if (bh.ov(str3) || bh.ov(str2)) {
                return 1;
            } else {
                if (com.tencent.mm.pluginsdk.g.a.aZ(context, "android.permission.READ_CONTACTS")) {
                    Toast.makeText(context, context.getString(R.l.dXw), 1).show();
                    context.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{str2});
                    context.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                    return 1;
                }
                x.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                return 1;
            }
        }
    }
}
