package com.tencent.mm.by;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class c {
    private static int index = 0;
    private static boolean on = false;
    private static a xAQ = null;
    private static long xAR = 0;
    private static int xAS = 0;

    public static void i(Exception exception) {
        if (on) {
            x.e("MicroMsg.DKTest", "exception:%s", bh.i(exception));
        }
    }

    static void begin() {
        if (on) {
            xAQ = new a();
            index++;
        }
    }

    private static void m(Cursor cursor) {
        if (on && cursor != null) {
            xAS = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < xAS; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            xAR = aVar.zi();
        }
    }

    static void a(String str, Cursor cursor, long j) {
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + xAQ.zi() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                m(cursor);
                str2 = str2 + "[cuCnt:" + xAS + ",cuTime:" + xAR + "]";
            }
            str2 = str2 + "[" + str + "]--";
            x.v("MicroMsg.dbtest", str2 + bh.cgy());
        }
    }
}
