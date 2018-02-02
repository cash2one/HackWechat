package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ap.b;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class h implements e {
    private Context context;
    private ProgressDialog kVi;
    a zdy;

    public interface a {
        void nl(boolean z);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.zdy = aVar;
    }

    final void n(Cursor cursor) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar = new o();
                oVar.b(cursor);
                arrayList.add(oVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(R.l.env);
        this.context.getResources().getString(R.l.dEn);
        com.tencent.mm.ui.base.h.a(context, string, arrayList, arrayList2, new 1(this, arrayList3));
    }

    final void ZP(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        k bVar = new b(arrayList);
        ar.CG().a(bVar, 0);
        Context context = this.context;
        this.context.getString(R.l.epY);
        this.kVi = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.epW), true, new 2(this, bVar));
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        if (kVar.getType() == 489) {
            if (this.kVi != null) {
                this.kVi.dismiss();
                this.kVi = null;
            }
            ar.CG().b(489, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
                com.tencent.mm.ui.base.h.a(this.context, R.l.epV, R.l.dGO, new 3(this));
                return;
            }
            x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
            this.zdy.nl(false);
        }
    }
}
