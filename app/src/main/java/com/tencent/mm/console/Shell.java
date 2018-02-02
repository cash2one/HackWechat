package com.tencent.mm.console;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;

public final class Shell {
    private static HashMap<String, a> gIG = new HashMap();
    public static IntentFilter gIH = new IntentFilter();
    private static Runnable gII = new 3();
    public Receiver gIF = null;

    static /* synthetic */ void Aa() {
    }

    static {
        a("wechat.shell.SET_NEXTRET", new 1());
        a("wechat.shell.SET_LOGLEVEL", new 4());
        a("wechat.shell.SET_CDNTRANS", new a() {
            public final void m(Intent intent) {
                r.idn = intent.getBooleanExtra(DownloadSettingTable$Columns.VALUE, false);
                x.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[]{Boolean.valueOf(r.idn)});
            }
        });
        a("wechat.shell.SET_DKTEST", new 6());
        a("wechat.shell.NET_DNS_TEST", new a() {
            public final void m(Intent intent) {
                r.ids = intent.getIntExtra(DownloadSettingTable$Columns.VALUE, 0);
                x.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[]{Integer.toBinaryString(r.ids)});
            }
        });
        a("wechat.shell.IDC_ERROR", new 8());
        a("wechat.shell.SET_DK_WT_TEST", new 9());
        a("wechat.shell.SET_MUTE_ROOM_TEST", new 10());
        a("wechat.shell.HOTPATCH_TEST", new 11());
        a("wechat.shell.EXEC_SQL", new 2());
    }

    private static void a(String str, a aVar) {
        gIH.addAction(str);
        gIG.put(str, aVar);
    }
}
