package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Map;

public final class a implements e {
    a tlf = new a();
    private c tlg = new 1(this);

    private class a {
        boolean bgH;
        boolean fsH;
        final /* synthetic */ a tlh;
        private b tli;
        private String tlj;
        private long tlk;

        private a(a aVar) {
            this.tlh = aVar;
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            String str3;
            if (bh.ov(str)) {
                String str4 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str5 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2.toString();
                }
                objArr[2] = str3;
                x.i(str4, str5, objArr);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            str3 = g.s(stringBuffer.toString().getBytes());
            if (!bh.ov(this.tlj) && this.tlj.equals(str3) && System.currentTimeMillis() - this.tlk <= 8000 && bh.ov(str2)) {
                if (this.fsH) {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[]{str});
                    h.Be(i2).a(this.tli.bPc().wKd, true, n.b(this.tli.bPc().wkp), this.tli.bPc().wks);
                    return;
                } else if (this.bgH) {
                    if (this.tli != null) {
                        this.tli.tll = i2;
                    }
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    return;
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[]{str, str3, Integer.valueOf(i2)});
            if (this.tli != null) {
                ar.CG().c(this.tli);
            }
            this.tlj = str3;
            this.tlk = System.currentTimeMillis();
            this.bgH = true;
            this.fsH = false;
            ar.CG().a(234, this.tlh);
            this.tli = new b(i, str, str2.getBytes(), i2, j);
            ar.CG().a(this.tli, 0);
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.xef.b(this.tlg);
    }

    public final boolean V(Map<String, Object> map) {
        x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[]{map.toString()});
        String r = r(map, "keyword");
        String r2 = r(map, "nextPageBuffer");
        int s = s(map, DownloadSettingTable$Columns.TYPE);
        int s2 = s(map, "webview_instance_id");
        String r3 = r(map, "searchID");
        this.tlf.a(s, r, r2, s2, bh.ov(r3) ? 0 : Long.valueOf(r3).longValue());
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            ar.CG().b(234, this);
            this.tlf.bgH = false;
            b bVar = (b) kVar;
            if (i == 0 && i2 == 0) {
                this.tlf.fsH = true;
            } else {
                this.tlf.fsH = false;
                h.Be(bVar.tll).a("{}", bVar.tlm, "", 0);
            }
            h.Be(bVar.tll).a(bVar.bPc().wKd, bVar.tlm, n.b(bVar.bPc().wkp), bVar.bPc().wks);
        }
    }

    public static String r(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static int s(Map<String, Object> map, String str) {
        String r = r(map, str);
        if (bh.ov(r)) {
            return 0;
        }
        return Integer.valueOf(r).intValue();
    }
}
