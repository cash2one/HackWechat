package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    String tuq = null;
    private a tur;
    private c tus = new 1(this);
    private c tut = new c<oi>(this) {
        final /* synthetic */ d tuv;

        {
            this.tuv = r2;
            this.xen = oi.class.getName().hashCode();
        }

        private boolean a(oi oiVar) {
            if ((oiVar instanceof oi) && "bank".equals(this.tuv.tuq)) {
                if (oiVar.fGj.action == 0) {
                    d.a(this.tuv, this.tuv.tuq);
                } else if (oiVar.fGj.action == 1) {
                    if (bh.ov(oiVar.fGj.cardNum)) {
                        d.b(this.tuv, this.tuv.tuq);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", oiVar.fGj.cardNum);
                            d.a(this.tuv, this.tuv.tuq, jSONObject, null);
                        } catch (JSONException e) {
                            x.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[]{e});
                            d.b(this.tuv, this.tuv.tuq);
                        }
                    }
                }
                d.a(this.tuv);
            }
            return false;
        }
    };
    private c tuu = new 3(this);

    static /* synthetic */ void a(d dVar) {
        dVar.tur = null;
        a.xef.c(dVar.tus);
        a.xef.c(dVar.tut);
        a.xef.c(dVar.tuu);
    }

    static /* synthetic */ void a(d dVar, String str) {
        if (dVar.tur != null) {
            dVar.tur.OH(str);
        }
    }

    static /* synthetic */ void a(d dVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        if (dVar.tur != null) {
            dVar.tur.a(str, jSONObject, bitmap);
        }
    }

    static /* synthetic */ void b(d dVar, String str) {
        if (dVar.tur != null) {
            dVar.tur.KZ(str);
        }
    }

    public final boolean a(String str, Context context, a aVar) {
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bm.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.tur = aVar;
            this.tuq = "bank";
            a.xef.b(this.tus);
            a.xef.b(this.tut);
            return true;
        } else if (!"identity_pay_auth".equalsIgnoreCase(str)) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            com.tencent.mm.bm.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.tur = aVar;
            this.tuq = "identity";
            a.xef.b(this.tus);
            a.xef.b(this.tuu);
            return true;
        }
    }
}
