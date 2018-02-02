package com.tencent.mm.plugin.ext;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build.VERSION;
import com.qq.wx.voice.embed.recognizer.b;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.qq.wx.voice.embed.recognizer.d;
import com.qq.wx.voice.embed.recognizer.e;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class b$2 implements Runnable {
    final /* synthetic */ b lZF;

    b$2(b bVar) {
        this.lZF = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        try {
            String value = g.zY().getValue("VoiceRecognizeSprSoMD5");
            String value2 = g.zY().getValue("VoiceRecognizeSprDataMD5");
            if (value == null || value2 == null) {
                x.i("MicroMsg.SubCoreExt", "error mMd5So:%s,  mMd5Data:%s", new Object[]{value, value2});
                b.e(this.lZF);
                return;
            }
            int i;
            String str = "/system/lib/";
            if (VERSION.SDK_INT >= 24) {
                str = "/vendor/lib/";
            }
            x.i("MicroMsg.SubCoreExt", "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s", new Object[]{value, value2, str});
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = a.bgn;
            Context context = ac.getContext();
            e eVar = bVar.bgm;
            if (eVar.d) {
                i = 0;
            } else {
                i = eVar.bgt.checkFiles(context, str, value, value2);
                if (i >= 0) {
                    eVar.d = true;
                    i = 0;
                }
            }
            SharedPreferences cft = ac.cft();
            x.i("MicroMsg.SubCoreExt", "checkFiles ret:%s,use time:%s", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (i == 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                List linkedList = new LinkedList();
                linkedList.add("tmessage");
                linkedList.add("officialaccounts");
                linkedList.add("helper_entry");
                ar.Hg();
                bc EY = c.Fg().EY("@t.qq.com");
                if (EY != null) {
                    linkedList.add(EY.name);
                }
                ArrayList arrayList = new ArrayList();
                ar.Hg();
                Cursor a = c.EY().a("@all.contact.android", null, linkedList, null, true, true);
                if (a == null) {
                    x.w("MicroMsg.SubCoreExt", "initLocalVoiceControl cu is null");
                    b.e(this.lZF);
                    return;
                }
                if (a.moveToFirst()) {
                    while (!a.isAfterLast()) {
                        f fVar = new f();
                        fVar.b(a);
                        arrayList.add(new d(fVar.field_username, fVar.field_nickname, fVar.field_conRemark));
                        a.moveToNext();
                    }
                }
                a.close();
                x.i("MicroMsg.SubCoreExt", "init cusor,count:%s,use time:%s", new Object[]{Integer.valueOf(a.getCount()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                long currentTimeMillis3 = System.currentTimeMillis();
                e eVar2 = a.bgn.bgm;
                if (eVar2.d) {
                    if (eVar2.e) {
                        i = eVar2.bgt.update(arrayList);
                    } else {
                        i = eVar2.bgt.init(arrayList);
                        if (i >= 0) {
                            eVar2.e = true;
                        }
                    }
                    i = 0;
                } else {
                    i = -304;
                }
                if (i == 0) {
                    cft.edit().putBoolean("hasInitVoiceControlData", true).putBoolean("hasTryToInitVoiceControlData", true).commit();
                    b.f(this.lZF);
                } else {
                    cft.edit().putBoolean("hasInitVoiceControlData", false).commit();
                }
                x.i("MicroMsg.SubCoreExt", "init ret:%s,use time:%s", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                b.e(this.lZF);
            } else {
                cft.edit().putBoolean("hasInitVoiceControlData", false).putBoolean("hasTryToInitVoiceControlData", true).commit();
                b.f(this.lZF);
            }
            b.e(this.lZF);
        } catch (Exception e) {
            x.i("MicroMsg.SubCoreExt", "initLocalVoiceControl Exception:%s", new Object[]{e.getMessage()});
        }
    }
}
