package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.b.de;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable$Columns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;

public final class i extends de {
    protected static a gJc;
    public int roN;

    static {
        a aVar = new a();
        aVar.hSY = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsID";
        aVar.xjA.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "parentID";
        aVar.xjA.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xjA.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xjA.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "talker";
        aVar.xjA.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadSettingTable$Columns.TYPE;
        aVar.xjA.put(DownloadSettingTable$Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSend";
        aVar.xjA.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "curActionBuf";
        aVar.xjA.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "refActionBuf";
        aVar.xjA.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "commentSvrID";
        aVar.xjA.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = ClientInfoTable$Columns.CLIENTID;
        aVar.xjA.put(ClientInfoTable$Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "commentflag";
        aVar.xjA.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "isSilence";
        aVar.xjA.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        aVar.columns[13] = "rowid";
        aVar.xjB = stringBuilder.toString();
        gJc = aVar;
    }

    protected final a Ac() {
        return gJc;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.roN = (int) this.xjy;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsComment", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.bvA().byd();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
        }
    }

    public final void bxZ() {
        this.field_commentflag |= 1;
    }
}
