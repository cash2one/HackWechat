package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class b {
    public static boolean q(Context context, String str) {
        if ((!str.equals("noop") || (f.xeC && f.xeB)) && k.aX(context)) {
            x.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
            return false;
        }
        x.d("MicroMsg.CoreServiceHelper", "ensure service running, type=" + str);
        Intent intent = new Intent(context, CoreService.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("START_TYPE", str);
        context.startService(intent);
        return true;
    }
}
