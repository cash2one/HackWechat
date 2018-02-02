package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.n.c;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class a implements e {
    public Activity fAF;
    public Bundle fqh;
    public ProgressDialog iln;

    class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ f pYr;
        final /* synthetic */ a pZC;

        public AnonymousClass1(a aVar, f fVar) {
            this.pZC = aVar;
            this.pYr = fVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.pZC.bpu();
            ar.CG().c(this.pYr);
        }
    }

    final void bpu() {
        ar.CG().b(1061, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        bpu();
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (i == 4 && i2 == -4) {
            h.a(this.fAF, R.l.eBw, R.l.dGO, null);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ar.CG().Kn()) {
                    ar.CG().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (ab.bC(this.fAF)) {
                    com.tencent.mm.pluginsdk.ui.k.eo(this.fAF);
                } else {
                    Toast.makeText(this.fAF, this.fAF.getString(R.l.eiD, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.fAF, this.fAF.getString(R.l.eiE), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        if (i == 4 && i2 == -2004) {
            h.h(this.fAF, R.l.eBr, R.l.dGO);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.fAF, this.fAF.getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        } else if (kVar.getType() == 1061) {
            hx boD = ((f) kVar).boD();
            if (boD == null) {
                x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                return;
            }
            x.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(boD.ktN)});
            if (!bh.ov(boD.vNR)) {
                int i3 = boD.ktN;
                Context context = this.fAF;
                String str2 = boD.vNR;
                int i4 = ((f) kVar).fqb;
                int i5 = ((f) kVar).fqc;
                e eVar = new e();
                Bundle bundle = this.fqh;
                int IK = n.IK(str2);
                x.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(IK)});
                Intent intent;
                if (IK == 1) {
                    c IL = n.IL(str2);
                    if (IL == null || bh.ov(IL.username)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        obj = 2;
                    } else {
                        ar.Hg();
                        af WO = com.tencent.mm.z.c.EY().WO(IL.username);
                        if (WO == null || ((int) WO.gJd) <= 0) {
                            eVar.a(context, IL.username, 2, i4, i5, null, bundle);
                            obj = 1;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Contact_User", WO.field_username);
                            intent.setFlags(65536);
                            b.ifs.d(intent, context);
                            obj = null;
                        }
                    }
                } else if (IK == 2) {
                    n.b IM = n.IM(str2);
                    if (IM == null || bh.ov(IM.hOf)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        obj = 2;
                    } else {
                        x.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{IM.hOf});
                        if (i3 == 5) {
                            ((d) g.h(d.class)).b(context, IM.hOf, 1031, bundle);
                            obj = null;
                        } else {
                            intent = new Intent();
                            intent.putExtra("rawUrl", IM.hOf);
                            intent.setFlags(65536);
                            b.ifs.j(intent, context);
                            obj = null;
                        }
                    }
                } else if (IK == 3 || IK == 4) {
                    x.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(4), Boolean.valueOf(true)});
                    intent = new Intent();
                    intent.setClass(context, ProductUI.class);
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", str2);
                    intent.putExtra("key_Product_funcType", 4);
                    intent.putExtra("key_ProductUI_addToDB", true);
                    intent.putExtra("key_need_add_to_history", true);
                    intent.putExtra("key_is_from_barcode", true);
                    context.startActivity(intent);
                    obj = null;
                } else {
                    x.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    x.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str2});
                    obj = 2;
                }
                switch (obj) {
                    case null:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                        return;
                    case 1:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        return;
                    case 2:
                        x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
