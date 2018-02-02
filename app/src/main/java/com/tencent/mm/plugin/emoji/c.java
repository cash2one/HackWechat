package com.tencent.mm.plugin.emoji;

import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static void cm(long j) {
        x.i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", new Object[]{Long.valueOf(j), Long.valueOf(1)});
        g.pQN.a(96, j, 1, false);
    }

    public static void a(String str, int i, int i2, int i3, String str2, int i4, String str3) {
        x.i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
        g.pQN.h(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_END, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3});
    }
}
