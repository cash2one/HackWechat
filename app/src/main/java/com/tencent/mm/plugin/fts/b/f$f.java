package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class f$f extends a {
    private int count;
    final /* synthetic */ f mOg;

    public f$f(f fVar, int i) {
        this.mOg = fVar;
        this.count = i;
    }

    public final boolean execute() {
        InputStream fileInputStream;
        Throwable th;
        if (this.mOg.mOe == null) {
            try {
                fileInputStream = new FileInputStream("/sdcard/test_insert_msg_words.txt");
                try {
                    String str = new String(b.d(fileInputStream));
                    this.mOg.mOe = str.split(",");
                    e.c(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    e.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                e.c(fileInputStream);
                throw th;
            }
        }
        if (this.mOg.mOf == null) {
            this.mOg.mOf = new ArrayList();
            Cursor cin = ((h) g.h(h.class)).EY().cin();
            while (cin.moveToNext()) {
                this.mOg.mOf.add(cin.getString(0));
            }
            cin.close();
        }
        if (this.mOg.mOe != null) {
            for (int i = 0; i < this.count; i++) {
                String w = w(this.mOg.mOe);
                cf auVar = new au();
                auVar.setType(1);
                auVar.eR(1);
                auVar.eQ(4);
                auVar.setContent(w);
                List list = this.mOg.mOf;
                auVar.dS((String) list.get(new Random().nextInt(list.size() - 1)));
                auVar.aq(System.currentTimeMillis() - 250327040);
                ((h) g.h(h.class)).aZi().Q(auVar);
                x.i("MicroMsg.FTS.FTSSearchTestLogic", "InsertMsgInfoTask %d %d %d %d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(i), Integer.valueOf(w.length()), Long.valueOf(auVar.field_msgId)});
            }
        }
        return true;
    }

    private static String w(String[] strArr) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 300; i++) {
            stringBuffer.append(strArr[random.nextInt(strArr.length - 1)]);
        }
        return stringBuffer.toString();
    }
}
