package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

public final class n {

    public static class b {
        public String hOf;

        public b(String str) {
            this.hOf = str;
        }
    }

    public static String J(Context context, int i) {
        if (context == null || i < 0) {
            return "";
        }
        if (i == 0) {
            context.getString(R.l.eIh);
        } else if (i == 1) {
            context.getString(R.l.eIa);
        } else if (i == 2) {
            context.getString(R.l.eIg);
        } else if (i == 3) {
            context.getString(R.l.eIb);
        }
        return context.getString(R.l.eIh);
    }

    public static int IK(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            return 1;
        }
        if (trim.startsWith("<url")) {
            return 2;
        }
        if (trim.startsWith("<product")) {
            return 3;
        }
        if (trim.startsWith("<search")) {
            return 4;
        }
        return 0;
    }

    public static c IL(String str) {
        if (str == null) {
            return null;
        }
        Map y = bi.y(str, "user");
        if (y != null) {
            return new c(bh.ou((String) y.get(".user.username")), bh.ou((String) y.get(".user.nickname")));
        }
        return null;
    }

    public static b IM(String str) {
        if (str == null) {
            return null;
        }
        Map y = bi.y(str, SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (y != null) {
            return new b(bh.ou((String) y.get(".url.link")));
        }
        return null;
    }

    public static String c(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!bh.ov(aVar.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            stringBuilder.append("<id>" + bh.VG(aVar.field_productid) + "</id>");
            stringBuilder.append("<title>" + bh.VG(aVar.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + bh.VG(aVar.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + bh.VG(aVar.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + bh.VG(aVar.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + bh.VG(aVar.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + bh.VG(aVar.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + bh.VG(aVar.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + bh.VG(aVar.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + bh.VG(aVar.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + bh.VG(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + bh.VG(aVar.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + bh.VG(aVar.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + bh.VG(aVar.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            x.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            return "";
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            return aVar.field_xml;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(aVar.field_xml);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        return stringBuilder.toString();
    }

    public static int a(int i, String str, i iVar, int i2, a aVar, int i3, int i4, boolean z) {
        if (iVar == null || str == null || iVar.bpn() == null || iVar.bpn().getContext() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(str == null);
            x.e(str2, str3, objArr);
            return 2;
        }
        int IK = IK(str);
        x.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(IK)});
        if (IK == 1) {
            c IL = IL(str);
            if (IL == null || bh.ov(IL.username)) {
                x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                return 2;
            }
            ar.Hg();
            af WO = c.EY().WO(IL.username);
            if (WO == null || ((int) WO.gJd) <= 0) {
                iVar.bpn().a(IL.username, 1, i3, i4, aVar);
                return 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", WO.field_username);
            intent.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.ifs.d(intent, iVar.bpn().getContext());
            return 0;
        } else if (IK == 2) {
            b IM = IM(str);
            if (IM == null || bh.ov(IM.hOf)) {
                x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                return 2;
            }
            x.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{IM.hOf});
            if (i == 5) {
                ((d) g.h(d.class)).b(iVar.bpn().getContext(), IM.hOf, z ? 1032 : 1025, null);
                return 0;
            }
            r0 = new Intent();
            r0.putExtra("rawUrl", IM.hOf);
            r0.setFlags(65536);
            com.tencent.mm.plugin.scanner.b.ifs.j(r0, iVar.bpn().getContext());
            return 0;
        } else if (IK == 3 || IK == 4) {
            x.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(i2), Boolean.valueOf(true)});
            r0 = new Intent();
            r0.setClass(iVar.bpn().getContext(), ProductUI.class);
            r0.setFlags(65536);
            r0.putExtra("key_Product_xml", str);
            r0.putExtra("key_Product_funcType", i2);
            r0.putExtra("key_ProductUI_addToDB", true);
            r0.putExtra("key_need_add_to_history", true);
            r0.putExtra("key_is_from_barcode", true);
            iVar.bpn().getContext().startActivity(r0);
            return 0;
        } else {
            x.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            x.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str});
            return 2;
        }
    }
}
