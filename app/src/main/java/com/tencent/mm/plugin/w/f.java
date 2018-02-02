package com.tencent.mm.plugin.w;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class f {
    public static String bbN() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FB()).append("msgsynchronize/syncFile/").toString();
    }

    public static String bbO() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FB()).append("msgsynchronize/").toString();
    }

    public static String bbP() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FB()).append("msgsynchronize.zip").toString();
    }

    public static void d(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            x.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[]{str, str2});
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long vk = g.vk(str + str2);
                i = e.a(str, str2, bArr);
                long vk2 = g.vk(str + str2);
                if (i != 0 || vk2 < ((long) bArr.length)) {
                    x.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vk), Long.valueOf(vk2), Integer.valueOf(bArr.length)});
                    i = i2;
                } else {
                    x.d("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vk), Long.valueOf(vk2), Integer.valueOf(bArr.length)});
                    return;
                }
            }
            return;
        }
    }
}
