package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.R$styleable;

public class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final int[] gIN = new int[]{0, 1};

    public interface a {
        void execute();
    }

    static /* synthetic */ r a(String str, int i, au auVar, c cVar) {
        if (cVar == null) {
            return null;
        }
        r rVar = (r) cVar.gJb;
        long currentTimeMillis = System.currentTimeMillis();
        r rVar2 = new r();
        rVar2.fileName = auVar.field_imgPath;
        rVar2.fFo = auVar.field_msgSvrId;
        rVar2.hUp = rVar.hUp;
        rVar2.hVB = rVar.hVB;
        rVar2.hlp = rVar.hlp;
        rVar2.hVC = rVar.hVC;
        rVar2.hVD = rVar.hVD;
        rVar2.status = rVar.status;
        rVar2.hVE = currentTimeMillis;
        rVar2.hVH = rVar.hVH;
        rVar2.hVI = i;
        rVar2.hVJ = rVar.hVJ;
        rVar2.hVK = rVar.hVK;
        rVar2.fDC = str;
        rVar2.hVz = str;
        rVar2.hVN = rVar.Ug();
        rVar2.hVO = rVar.hVO;
        rVar2.hUa = rVar.hUa;
        rVar2.htL = rVar.htL;
        String fileName = rVar.getFileName();
        String str2 = auVar.field_imgPath;
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(c.FC()).append("/video").toString();
        File file = new File(stringBuilder2, fileName + ".jpg");
        File file2 = new File(stringBuilder2, str2 + ".jpg");
        if (file.exists()) {
            e.bU(file2.getAbsolutePath());
            e.x(file.getAbsolutePath(), file2.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]video,jpg,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file2.getAbsolutePath()});
        file = new File(stringBuilder2, fileName + ".mp4");
        File file3 = new File(stringBuilder2, str2 + ".mp4");
        if (file.exists()) {
            e.bU(file3.getAbsolutePath());
            e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]video,mp4,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file3.getAbsolutePath()});
        return rVar2;
    }

    static /* synthetic */ au a(a aVar, String str, int i) {
        cf auVar = new au();
        auVar.dS(str);
        auVar.setContent("text_" + i);
        auVar.setType(1);
        auVar.eR(gIN[fX(gIN.length)]);
        if (auVar.field_isSend == 1) {
            auVar.eQ(4);
        } else {
            auVar.eQ(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        auVar.ap(currentTimeMillis);
        auVar.aq(currentTimeMillis);
        return auVar;
    }

    static /* synthetic */ au a(a aVar, String str, c cVar) {
        if (cVar == null) {
            return null;
        }
        String substring;
        au auVar = (au) cVar.gJa;
        com.tencent.mm.aq.e eVar = (com.tencent.mm.aq.e) cVar.gJb;
        cf auVar2 = new au();
        auVar2.dS(str);
        auVar2.setContent(auVar.field_content);
        auVar2.setType(3);
        auVar2.eR(gIN[fX(gIN.length)]);
        if (auVar2.field_isSend == 1) {
            auVar2.eQ(4);
        } else {
            auVar2.eQ(3);
        }
        auVar2.A(bh.VD("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        String s = g.s(aD(currentTimeMillis));
        String str2 = "THUMBNAIL_DIRPATH://th_" + s;
        auVar2.ap(currentTimeMillis);
        auVar2.aq(currentTimeMillis);
        auVar2.dT(str2);
        com.tencent.mm.aq.g Pw = o.Pw();
        String str3 = eVar.hzQ;
        String str4 = eVar.hzS;
        int lastIndexOf = str3.lastIndexOf(".");
        if (lastIndexOf > 0) {
            substring = str3.substring(0, lastIndexOf);
            str3 = s + str3.substring(lastIndexOf, str3.length());
        } else {
            substring = str3;
            str3 = s;
        }
        com.tencent.mm.aq.e eVar2 = new com.tencent.mm.aq.e();
        eVar2.setOffset(eVar.offset);
        eVar2.hL(eVar.hlp);
        eVar2.fDt = -1;
        com.tencent.mm.aq.g Pw2 = o.Pw();
        long j = Pw2.hAE;
        Pw2.hAE = 1 + j;
        eVar2.bg(j);
        eVar2.lg(str3);
        eVar2.li(str2);
        eVar2.ap(auVar2.field_msgSvrId);
        eVar2.hK((int) (currentTimeMillis / 1000));
        eVar2.hP(eVar.hzT);
        eVar2.lh(eVar.hzR);
        eVar2.hM(eVar.hzZ);
        Pw.e(eVar2);
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(c.FC()).append("/image2/").append(substring.substring(0, 2)).append("/").append(substring.substring(2, 4)).toString();
        str2 = str4.replace("THUMBNAIL_DIRPATH://th_", "");
        stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder3 = stringBuilder.append(c.FC()).append("/image2/").append(str2.substring(0, 2)).append("/").append(str2.substring(2, 4)).toString();
        stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder4 = stringBuilder.append(c.FC()).append("/image2/").append(s.substring(0, 2)).append("/").append(s.substring(2, 4)).toString();
        x.v("MicroMsg.AgingTestCommand", "[oneliang]old hash:%s,new hash:%s", new Object[]{substring, s});
        File file = new File(stringBuilder2, ".nomedia");
        File file2 = new File(stringBuilder4, ".nomedia");
        if (!file.exists()) {
            file = new File(stringBuilder3, ".nomedia");
        }
        if (file.exists()) {
            e.bU(file2.getAbsolutePath());
            e.x(file.getAbsolutePath(), file2.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]nomedia,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file2.getAbsolutePath()});
        file = new File(stringBuilder2, substring + ".jpg");
        file2 = new File(stringBuilder4, s + ".jpg");
        if (!file.exists()) {
            file = new File(stringBuilder3, str2 + ".jpg");
        }
        if (file.exists()) {
            e.bU(file2.getAbsolutePath());
            e.x(file.getAbsolutePath(), file2.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]jpg,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file2.getAbsolutePath()});
        file = new File(stringBuilder2, substring + ".png");
        file2 = new File(stringBuilder4, s + ".png");
        if (!file.exists()) {
            file = new File(stringBuilder3, str2 + ".png");
        }
        if (file.exists()) {
            e.bU(file2.getAbsolutePath());
            e.x(file.getAbsolutePath(), file2.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]png,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file2.getAbsolutePath()});
        file = new File(stringBuilder2, "th_" + substring);
        file2 = new File(stringBuilder4, "th_" + s);
        if (!file.exists()) {
            file = new File(stringBuilder3, "th_" + str2);
        }
        if (file.exists()) {
            e.bU(file2.getAbsolutePath());
            e.x(file.getAbsolutePath(), file2.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]th_**,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file2.getAbsolutePath()});
        file = new File(stringBuilder2, "th_" + substring + "hd");
        File file3 = new File(stringBuilder4, "th_" + s + "hd");
        if (!file.exists()) {
            file = new File(stringBuilder3, "th_" + str2 + "hd");
        }
        if (file.exists()) {
            e.bU(file3.getAbsolutePath());
            e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        }
        x.v("MicroMsg.AgingTestCommand", "[oneliang]th_**hd,exists:%s,old file:%s,new file:%s", new Object[]{Boolean.valueOf(file.exists()), file.getAbsolutePath(), file3.getAbsolutePath()});
        return auVar2;
    }

    static /* synthetic */ void a(a aVar, int i) {
        x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact begin,count:%s", new Object[]{Integer.valueOf(i)});
        x.i("MicroMsg.AgingTestCommand", "[oneliang]get exists count:%s", new Object[]{Integer.valueOf(s.GJ())});
        int GJ = s.GJ();
        for (int i2 = GJ; i2 < i + GJ; i2++) {
            String str = "rdgztest_atm" + i2;
            com.tencent.mm.storage.x A = A("rdgztest_atm" + i2, i2);
            if (!((h) com.tencent.mm.kernel.g.h(h.class)).EY().WQ(str)) {
                ((h) com.tencent.mm.kernel.g.h(h.class)).EY().R(A);
            }
        }
        x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact end,count:%s", new Object[]{Integer.valueOf(i)});
    }

    static /* synthetic */ void a(a aVar, Context context) {
        try {
            i$a com_tencent_mm_ui_base_i_a = new i$a(context);
            com_tencent_mm_ui_base_i_a.EA(R.l.eRf);
            com_tencent_mm_ui_base_i_a.EC(R.l.dFU).a(new 5(aVar));
            com_tencent_mm_ui_base_i_a.akx().show();
            Toast.makeText(ac.getContext(), R.l.eRf, 1).show();
        } catch (Exception e) {
            x.e("MicroMsg.AgingTestCommand", "[oneliang] show finished dialog error.");
        }
    }

    static /* synthetic */ void a(a aVar, String str, int i, b bVar) {
        if (bVar != null) {
            String str2;
            Cursor cix = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().cix();
            List<String> arrayList = new ArrayList();
            if (bh.ov(str)) {
                while (cix.moveToNext()) {
                    try {
                        af xVar = new com.tencent.mm.storage.x();
                        xVar.b(cix);
                        str2 = xVar.field_username;
                        if (str2 != null && str2.startsWith("rdgztest_atm")) {
                            arrayList.add(str2);
                        }
                    } catch (Throwable th) {
                        if (cix != null) {
                            cix.close();
                        }
                    }
                }
                if (cix != null) {
                    cix.close();
                }
            } else {
                arrayList.add(str);
            }
            x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin all transaction,msg count per conversation:%s", new Object[]{Integer.valueOf(i)});
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr = new int[]{1, 3, 43, 47};
            for (String str22 : arrayList) {
                a 4 = new 4(aVar, str22, i, iArr, bVar);
                if (!(str22 == null || str22.isEmpty())) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.c aZi = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi();
                    com.tencent.mm.by.h aZl = aZi.aZl();
                    aZi.Et("test_msg_info");
                    x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin transaction ticket:%s,username:%s", new Object[]{Long.valueOf(aZl.dz(Thread.currentThread().getId())), str22});
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        4.execute();
                    } catch (Throwable th2) {
                        x.printErrStackTrace("MicroMsg.AgingTestCommand", th2, "", new Object[0]);
                    } finally {
                        aZl.fS(r12);
                    }
                    x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end transaction, cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                    aZi.Eu("test_msg_info");
                }
            }
            x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end all transaction, cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    static /* synthetic */ void a(a aVar, List list) {
        if (list != null) {
            x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list begin,count:" + list.size());
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                com.tencent.mm.storage.x A = A(str, i);
                if (!((h) com.tencent.mm.kernel.g.h(h.class)).EY().WQ(str)) {
                    ((h) com.tencent.mm.kernel.g.h(h.class)).EY().R(A);
                }
            }
            x.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list end,count:%s", new Object[]{Integer.valueOf(list.size())});
        }
    }

    static /* synthetic */ au b(a aVar, String str, c cVar) {
        if (cVar == null) {
            return null;
        }
        au auVar = (au) cVar.gJa;
        String str2 = str + auVar.field_content.substring(auVar.field_content.indexOf(":"));
        auVar = new au();
        auVar.dS(str);
        auVar.setContent(str2);
        auVar.setType(43);
        auVar.eR(gIN[fX(gIN.length)]);
        if (auVar.field_isSend == 1) {
            auVar.eQ(4);
        } else {
            auVar.eQ(3);
        }
        auVar.A(bh.VD("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        auVar.ap(currentTimeMillis);
        auVar.aq(currentTimeMillis);
        auVar.dT(g.s(aD(currentTimeMillis)));
        return auVar;
    }

    static /* synthetic */ au c(a aVar, String str, c cVar) {
        if (cVar == null) {
            return null;
        }
        au auVar = (au) cVar.gJa;
        EmojiInfo emojiInfo = (EmojiInfo) cVar.gJb;
        String str2 = auVar.field_content;
        String str3 = str + str2.substring(str2.indexOf(":"));
        String str4 = "7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D";
        cf auVar2 = new au();
        auVar2.dS(str);
        auVar2.setContent(str3);
        auVar2.setType(47);
        auVar2.eR(gIN[fX(gIN.length)]);
        if (auVar2.field_isSend == 1) {
            auVar2.eQ(4);
        } else {
            auVar2.eQ(3);
        }
        auVar2.dT(auVar.field_imgPath);
        auVar2.A(bh.VD(str4));
        long currentTimeMillis = System.currentTimeMillis();
        auVar2.ap(currentTimeMillis);
        auVar2.aq(currentTimeMillis);
        EmojiInfo emojiInfo2 = new EmojiInfo();
        emojiInfo2.field_md5 = emojiInfo.Nr();
        emojiInfo2.field_svrid = emojiInfo.ckz();
        emojiInfo2.field_catalog = bh.a(Integer.valueOf(emojiInfo.field_catalog), 0);
        emojiInfo2.field_type = bh.a(Integer.valueOf(emojiInfo.field_type), 0);
        emojiInfo2.field_size = bh.a(Integer.valueOf(emojiInfo.field_size), 0);
        emojiInfo2.field_start = bh.a(Integer.valueOf(emojiInfo.field_start), 0);
        emojiInfo2.field_state = bh.a(Integer.valueOf(emojiInfo.field_state), 0);
        emojiInfo2.field_reserved3 = bh.a(Integer.valueOf(emojiInfo.field_reserved3), 0);
        emojiInfo2.field_reserved4 = bh.a(Integer.valueOf(emojiInfo.field_reserved4), 0);
        emojiInfo2.field_groupId = emojiInfo.field_groupId;
        emojiInfo2.field_lastUseTime = bh.a(Long.valueOf(emojiInfo.field_lastUseTime), 0);
        emojiInfo2.field_idx = bh.a(Integer.valueOf(emojiInfo.field_idx), 0);
        emojiInfo2.field_temp = bh.a(Integer.valueOf(emojiInfo.field_temp), 0);
        emojiInfo2.field_source = bh.a(Integer.valueOf(emojiInfo.field_source), 0);
        emojiInfo2.field_needupload = bh.a(Integer.valueOf(emojiInfo.field_needupload), 0);
        emojiInfo2.field_thumbUrl = emojiInfo.field_thumbUrl;
        emojiInfo2.field_cdnUrl = emojiInfo.field_cdnUrl;
        emojiInfo2.field_encrypturl = emojiInfo.field_encrypturl;
        emojiInfo2.field_aeskey = emojiInfo.field_aeskey;
        emojiInfo2.field_width = bh.a(Integer.valueOf(emojiInfo.field_width), 0);
        emojiInfo2.field_height = bh.a(Integer.valueOf(emojiInfo.field_height), 0);
        if (!i.aBE().lwL.XW(emojiInfo.Nr())) {
            i.aBE().lwL.o(emojiInfo2);
        }
        return auVar2;
    }

    static {
        try {
            Object newInstance = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
            if (newInstance != null && (newInstance instanceof com.tencent.mm.pluginsdk.cmd.a)) {
                b.a((com.tencent.mm.pluginsdk.cmd.a) newInstance, new String[]{"//aging"});
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AgingTestCommand", th, "", new Object[0]);
        }
    }

    private a() {
    }

    public final boolean a(final Context context, final String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length <= 1) {
            return false;
        }
        String FS = q.FS();
        final b bVar = new b();
        for (int i = 5001; i <= 6000; i++) {
            bVar.gIW.add("rdgztest_atm" + i);
        }
        com.tencent.mm.by.h aZl = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().aZl();
        Cursor a = aZl.a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[]{FS}, 0);
        while (a.moveToNext()) {
            cf auVar = new au();
            auVar.b(a);
            Cursor a2;
            switch (auVar.getType()) {
                case 3:
                    a2 = aZl.a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[]{String.valueOf(auVar.field_msgSvrId)}, 0);
                    if (a2.moveToNext()) {
                        com.tencent.mm.aq.e eVar = new com.tencent.mm.aq.e();
                        eVar.b(a2);
                        bVar.gIX.add(new c(auVar, eVar));
                    }
                    a2.close();
                    break;
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    a2 = aZl.a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[]{String.valueOf(auVar.field_msgSvrId)}, 0);
                    if (a2.moveToNext()) {
                        r rVar = new r();
                        rVar.b(a2);
                        bVar.gIY.add(new c(auVar, rVar));
                    }
                    a2.close();
                    break;
                case 47:
                    a2 = aZl.a("SELECT * FROM EmojiInfo WHERE md5=?", new String[]{auVar.field_imgPath}, 0);
                    if (a2.moveToNext()) {
                        EmojiInfo emojiInfo = new EmojiInfo();
                        emojiInfo.b(a2);
                        bVar.gIZ.add(new c(auVar, emojiInfo));
                    }
                    a2.close();
                    break;
                default:
                    break;
            }
        }
        a.close();
        if (bVar.gIX.isEmpty() && bVar.gIZ.isEmpty() && bVar.gIY.isEmpty()) {
            Toast.makeText(context, "please send some data(img,video,emoji) to yourself", 1).show();
            return false;
        }
        x.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[]{Integer.valueOf(bVar.gIW.size()), Integer.valueOf(bVar.gIX.size()), Integer.valueOf(bVar.gIZ.size()), Integer.valueOf(bVar.gIY.size())});
        if (strArr.length == 2) {
            Toast.makeText(context, "aging begin", 1).show();
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ a gIQ;

                public final void run() {
                    a.a(this.gIQ, bVar.gIW);
                    a.a(this.gIQ, null, bh.getInt(strArr[1], 0), bVar);
                    a.a(this.gIQ, context);
                }
            });
            return true;
        } else if (strArr.length < 3) {
            return false;
        } else {
            final int i2 = bh.getInt(strArr[2], 0);
            FS = strArr[1];
            Object obj = -1;
            switch (FS.hashCode()) {
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    if (FS.equals("1")) {
                        obj = null;
                        break;
                    }
                    break;
                case 50:
                    if (FS.equals("2")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 51:
                    if (FS.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    ar.Dm().F(new 2(this, i2, context));
                    return true;
                case 1:
                    String str = null;
                    if (strArr.length == 4) {
                        str = strArr[3];
                    }
                    final Context context2 = context;
                    ar.Dm().F(new Runnable(this) {
                        final /* synthetic */ a gIQ;

                        public final void run() {
                            a.a(this.gIQ, str, i2, bVar);
                            a.a(this.gIQ, context2);
                        }
                    });
                    return true;
                case 2:
                    return true;
                default:
                    return true;
            }
        }
    }

    private static int fX(int i) {
        int random = (int) (Math.random() * ((double) i));
        if (random >= i) {
            return 0;
        }
        return random;
    }

    private static com.tencent.mm.storage.x A(String str, int i) {
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        xVar.gJd = (long) (100000 + i);
        xVar.setUsername(str);
        xVar.cZ("alias_" + i);
        xVar.dc("nickName_" + i);
        xVar.de("quanPin_" + i);
        xVar.dd("pyInitial_" + i);
        xVar.setType(3);
        return xVar;
    }

    private static byte[] aD(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }
}
