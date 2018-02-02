package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    private a zcl;

    public interface a {
        void ZN(String str);

        void bp(String str, boolean z);
    }

    static /* synthetic */ void Y(x xVar) {
        if (((int) xVar.gJd) == 0) {
            ar.Hg();
            c.EY().S(xVar);
            if (!bh.ov(xVar.field_username)) {
                ar.Hg();
                xVar = c.EY().WO(xVar.field_username);
            } else {
                return;
            }
        }
        if (((int) xVar.gJd) <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
        } else {
            s.p(xVar);
        }
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.zcl = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        final String str = bVar.username;
        int i = bVar.phF;
        final int i2 = bVar.position;
        ar.Hg();
        final af WO = c.EY().WO(str);
        if (bh.ov(WO.field_username)) {
            WO.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
            final /* synthetic */ a zcm;

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    a.Y(WO);
                    this.zcm.zcl.ZN(str);
                    return;
                }
                this.zcm.zcl.bp(str, z2);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.c(str, linkedList);
    }
}
