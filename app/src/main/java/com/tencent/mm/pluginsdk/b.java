package com.tencent.mm.pluginsdk;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;

public final class b {

    public static final class b {
        public static final HashMap<Integer, Integer> vcd;

        static {
            HashMap hashMap = new HashMap();
            vcd = hashMap;
            hashMap.put(Integer.valueOf(22), Integer.valueOf(64));
            vcd.put(Integer.valueOf(9), Integer.valueOf(64));
            vcd.put(Integer.valueOf(3), Integer.valueOf(64));
            vcd.put(Integer.valueOf(23), Integer.valueOf(64));
            vcd.put(Integer.valueOf(25), Integer.valueOf(64));
            vcd.put(Integer.valueOf(13), Integer.valueOf(64));
            vcd.put(Integer.valueOf(29), Integer.valueOf(256));
            vcd.put(Integer.valueOf(34), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
            vcd.put(Integer.valueOf(6), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
            vcd.put(Integer.valueOf(35), Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
            vcd.put(Integer.valueOf(36), Integer.valueOf(Downloads.RECV_BUFFER_SIZE));
            vcd.put(Integer.valueOf(37), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            vcd.put(Integer.valueOf(38), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            vcd.put(Integer.valueOf(42), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            vcd.put(Integer.valueOf(40), Integer.valueOf(65536));
            vcd.put(Integer.valueOf(41), Integer.valueOf(65536));
            vcd.put(Integer.valueOf(46), Integer.valueOf(262144));
            vcd.put(Integer.valueOf(48), Integer.valueOf(SQLiteGlobal.journalSizeLimit));
        }
    }
}
