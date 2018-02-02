package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bn.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class InviteRemindDialog$1 implements OnClickListener {
    final /* synthetic */ InviteRemindDialog spJ;

    InviteRemindDialog$1(InviteRemindDialog inviteRemindDialog) {
        this.spJ = inviteRemindDialog;
    }

    public final void onClick(View view) {
        if (InviteRemindDialog.a(this.spJ) != null) {
            try {
                ar.Hg();
                Map Tk = a.Tk((String) c.CU().get(77829, null));
                a aVar;
                if (Tk != null) {
                    if (Tk != null && Tk.size() > 0) {
                        if (Tk.containsKey(InviteRemindDialog.a(this.spJ))) {
                            aVar = (a) Tk.get(InviteRemindDialog.a(this.spJ));
                            aVar.hJB++;
                            Tk.put(InviteRemindDialog.a(this.spJ), aVar);
                        } else {
                            aVar = new a();
                            aVar.hJB++;
                            Tk.put(InviteRemindDialog.a(this.spJ), aVar);
                        }
                    }
                    ar.Hg();
                    c.CU().set(77829, a.as(Tk));
                    for (Entry value : Tk.entrySet()) {
                        aVar = (a) value.getValue();
                        x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hJB);
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hJB++;
                    hashMap.put(InviteRemindDialog.a(this.spJ), aVar2);
                    ar.Hg();
                    c.CU().set(77829, a.as(hashMap));
                    for (Entry value2 : hashMap.entrySet()) {
                        aVar = (a) value2.getValue();
                        x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hJB);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
            }
        }
        String string = InviteRemindDialog.b(this.spJ) == 0 ? this.spJ.getString(R.l.eVs) : InviteRemindDialog.b(this.spJ) == 1 ? this.spJ.getString(R.l.eVX) : null;
        ar.CG().a(new com.tencent.mm.plugin.voip.model.c(InviteRemindDialog.a(this.spJ), string, s.hp(InviteRemindDialog.a(this.spJ))), 0);
        Intent intent = new Intent();
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", InviteRemindDialog.a(this.spJ));
        com.tencent.mm.plugin.voip.a.a.ifs.e(intent, this.spJ);
        this.spJ.finish();
    }
}
