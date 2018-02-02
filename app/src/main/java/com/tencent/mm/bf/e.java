package com.tencent.mm.bf;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static long n(String str, long j) {
        long j2 = 0;
        if (str != null) {
            f mW = l.Tw().mW(str);
            if (mW != null) {
                j2 = mW.field_createTime + 1;
            }
        }
        return j2 > j * 1000 ? j2 : j * 1000;
    }

    public static void e(long j, String str) {
        boolean z = false;
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[]{Long.valueOf(j), str});
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + l.Tx().d(j, str));
        g Tw = l.Tw();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
        } else {
            z = Tw.gJP.fx("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + bh.ot(str) + "'");
        }
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + z);
    }
}
