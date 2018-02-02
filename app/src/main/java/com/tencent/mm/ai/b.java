package com.tencent.mm.ai;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends af {
    public final boolean gN(int i) {
        return i != 0 && i < 637735215;
    }

    public final String getTag() {
        return "MicroMsg.App.BizPlaceTopDataTransfer";
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (gN(i)) {
            x.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
            long currentTimeMillis = System.currentTimeMillis();
            g.pQN.a(336, 0, 1, true);
            ar.Hg();
            h EV = c.EV();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select conv.username");
            stringBuilder.append(" from ");
            stringBuilder.append("rconversation");
            stringBuilder.append(" as conv, ");
            stringBuilder.append("rcontact");
            stringBuilder.append(" as ct ");
            stringBuilder.append(" where conv.");
            stringBuilder.append("parentRef");
            stringBuilder.append("='");
            stringBuilder.append("officialaccounts");
            stringBuilder.append("' and conv.");
            stringBuilder.append("username");
            stringBuilder.append(" = ct.");
            stringBuilder.append("username");
            stringBuilder.append(" and ct.");
            stringBuilder.append("verifyFlag");
            stringBuilder.append(" & ");
            stringBuilder.append(8);
            stringBuilder.append(" = 0");
            x.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", new Object[]{stringBuilder.toString()});
            Cursor a = EV.a(r0, null, 2);
            if (a == null) {
                x.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            x.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("update ");
            stringBuilder2.append("rconversation");
            stringBuilder2.append(" set ");
            stringBuilder2.append("parentRef");
            stringBuilder2.append("='' where ");
            stringBuilder2.append("username");
            stringBuilder2.append(" in (");
            if (a.moveToFirst()) {
                g.pQN.a(336, 1, 1, true);
                stringBuilder2.append("'");
                stringBuilder2.append(a.getString(0));
                stringBuilder2.append("'");
                int i2 = 1;
                while (a.moveToNext()) {
                    stringBuilder2.append(",");
                    stringBuilder2.append("'");
                    stringBuilder2.append(a.getString(0));
                    stringBuilder2.append("'");
                    i2++;
                }
                stringBuilder2.append(")");
                String stringBuilder3 = stringBuilder2.toString();
                x.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", new Object[]{Integer.valueOf(i2)});
                x.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", new Object[]{stringBuilder3});
                a.close();
                if (EV.fx("rconversation", stringBuilder2.toString())) {
                    g.pQN.a(336, 2, 1, true);
                } else {
                    g.pQN.a(336, 3, 1, true);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                x.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis)});
                return;
            }
            a.close();
            x.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
        }
    }
}
