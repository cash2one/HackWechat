package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

class CompressPreviewUI$5 extends a {
    final /* synthetic */ CompressPreviewUI prM;

    CompressPreviewUI$5(CompressPreviewUI compressPreviewUI) {
        this.prM = compressPreviewUI;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        CompressPreviewUI.b(this.prM, (String) map.get(".Response.result.compressfilepath"));
        int i = bh.getInt((String) map.get(".Response.result.filelist.count"), 0);
        int i2 = 0;
        while (i2 < i) {
            try {
                String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                String str3 = (String) map.get(str2 + ".path");
                if (str3 != null) {
                    String str4;
                    String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                    String str5 = (String) map.get(str2 + ".parentpath");
                    int i3 = bh.getInt((String) map.get(str2 + ".size"), 0);
                    int i4 = bh.getInt((String) map.get(str2 + ".type"), 0);
                    boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                    String str6 = (String) map.get(str2 + ".name");
                    List h = CompressPreviewUI.h(this.prM);
                    CompressPreviewUI compressPreviewUI = this.prM;
                    if (i3 == 0) {
                        str4 = "";
                    } else {
                        str4 = "(" + bh.bx((long) i3) + ")";
                    }
                    h.add(new CompressPreviewUI.a(compressPreviewUI, decode, str6, str5, i4, str4, equals));
                }
                i2++;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
            }
        }
        CompressPreviewUI.a(this.prM, "");
    }

    public final void onError(int i, String str) {
        if (i == -5) {
            CompressPreviewUI.j(this.prM).a(new 1(this));
            return;
        }
        CompressPreviewUI.k(this.prM).setVisibility(8);
        CompressPreviewUI.l(this.prM).setVisibility(0);
        CompressPreviewUI.d(this.prM).setVisibility(8);
    }
}
