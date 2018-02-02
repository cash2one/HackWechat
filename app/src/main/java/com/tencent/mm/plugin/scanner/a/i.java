package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g;
import java.util.Map;

public final class i {
    public static String a(Context context, a aVar) {
        g.a aVar2 = new g.a();
        aVar2.appId = vD(aVar.field_functionType);
        aVar2.title = aVar.field_title;
        aVar2.description = aVar.field_source;
        aVar2.type = 10;
        aVar2.url = aVar.field_shareurl;
        aVar2.action = "";
        aVar2.appName = n.J(context, aVar.field_type);
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.hbw = aVar.field_type;
        aVar2.hbx = n.c(aVar);
        return g.a.a(aVar2, null, null);
    }

    public static String vD(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static a bW(String str, int i) {
        if (bh.ov(str)) {
            return null;
        }
        int IK = n.IK(str);
        if (IK == 3) {
            if (str == null) {
                return null;
            }
            Map y;
            int i2;
            String str2;
            String str3 = "";
            if (str.startsWith("<productInfo")) {
                y = bi.y(str, "productInfo");
                i2 = 1;
                str2 = ".productInfo";
            } else {
                i2 = 0;
                y = bi.y(str, "product");
                str2 = str3;
            }
            if (y == null) {
                return null;
            }
            a aVar = new a();
            if (bh.ov((String) y.get(str2 + ".product.$type"))) {
                aVar.field_type = 0;
            } else {
                aVar.field_type = Integer.valueOf((String) y.get(str2 + ".product.$type")).intValue();
            }
            aVar.field_productid = bh.ou((String) y.get(str2 + ".product.id"));
            aVar.field_subtitle = bh.ou((String) y.get(str2 + ".product.subtitle"));
            aVar.field_shareurl = bh.ou((String) y.get(str2 + ".product.shareurl"));
            aVar.field_playurl = bh.ou((String) y.get(str2 + ".product.playurl"));
            aVar.field_xmlType = 3;
            aVar.field_title = bh.ou((String) y.get(str2 + ".product.title"));
            aVar.field_thumburl = bh.ou((String) y.get(str2 + ".product.thumburl"));
            aVar.field_source = bh.ou((String) y.get(str2 + ".product.source"));
            aVar.field_feedbackurl = bh.ou((String) y.get(str2 + ".product.feedbackurl"));
            aVar.field_extinfo = bh.ou((String) y.get(str2 + ".product.extinfo"));
            aVar.field_introtitle = bh.ou((String) y.get(str2 + ".product.introtitle"));
            aVar.field_introlink = bh.ou((String) y.get(str2 + ".product.introlink"));
            aVar.field_getaction = bh.getInt((String) y.get(str2 + ".product.getaction"), 0);
            aVar.field_certification = bh.ou((String) y.get(str2 + ".product.certification"));
            aVar.field_headerbackgroundurl = bh.ou((String) y.get(str2 + ".product.headerbackgroundurl"));
            aVar.field_headermask = bh.ou((String) y.get(str2 + ".product.headermask"));
            aVar.field_detailurl = bh.ou((String) y.get(str2 + ".product.detailurl"));
            aVar.field_certificationurl = bh.ou((String) y.get(str2 + ".product.certificationurl"));
            aVar.field_exposeurl = bh.ou((String) y.get(str2 + ".product.exposeurl"));
            aVar.qbc = a.l(y, str2 + ".product");
            aVar.n(y, str2 + ".product");
            String str4 = (String) y.get(str2 + ".functionType");
            if (bh.ov(str4)) {
                aVar.field_functionType = i;
            } else {
                aVar.field_functionType = Integer.valueOf(str4).intValue();
            }
            if (i2 != 0) {
                aVar.field_xml = str;
            } else {
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("<productInfo>");
                stringBuilder.append(str);
                stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
                stringBuilder.append("</productInfo>");
                aVar.field_xml = stringBuilder.toString();
            }
            return aVar;
        } else if (IK != 4 || str == null) {
            return null;
        } else {
            Map y2 = bi.y(str, "search");
            if (y2 == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.field_xmlType = 4;
            aVar2.field_xml = str;
            aVar2.qbc = a.l(y2, ".search");
            return aVar2;
        }
    }
}
