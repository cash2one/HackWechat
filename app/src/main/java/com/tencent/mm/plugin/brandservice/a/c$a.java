package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

class c$a implements e {
    private Context context;
    private String fod;
    private long foe;
    private boolean fof;
    private int fromScene;
    private ag kED;
    private int offset;
    private String title;

    public c$a(Context context, String str, long j, int i, int i2, String str2, boolean z, ag agVar) {
        this.context = context;
        this.fod = str;
        this.foe = j;
        this.offset = i;
        this.fromScene = i2;
        this.title = str2;
        this.fof = z;
        this.kED = agVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            dV(false);
        } else if (kVar == null) {
            x.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
            dV(false);
        } else if (kVar.getType() != 1071) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
        } else {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
            je asl = ((h) kVar).asl();
            if (asl == null || asl.ngS == null) {
                x.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                dV(false);
                return;
            }
            x.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[]{asl.vPs});
            Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
            intent.putExtra("addContactScene", 35);
            intent.putExtra("fromScene", this.fromScene);
            intent.putExtra("keyword", this.fod);
            intent.putExtra("businessType", this.foe);
            intent.putExtra("offset", this.offset);
            intent.putExtra("title", this.title);
            intent.putExtra("showEditText", this.fof);
            try {
                intent.putExtra("result", asl.toByteArray());
                if (!(this.context instanceof Activity)) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                dV(true);
            } catch (Throwable e) {
                dV(false);
                x.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
            }
        }
    }

    private void dV(boolean z) {
        ar.CG().b(1071, this);
        if (this.kED != null && this.kED.fob.fog != null) {
            this.kED.foc.foh = z;
            this.kED.fob.fog.run();
        }
    }
}
