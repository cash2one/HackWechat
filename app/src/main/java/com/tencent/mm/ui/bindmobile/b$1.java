package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bindmobile.a.b;
import java.util.LinkedList;

class b$1 implements b {
    final /* synthetic */ b ymq;

    b$1(b bVar) {
        this.ymq = bVar;
    }

    public final void h(int i, String str, int i2) {
        x.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        final com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) this.ymq.getItem(i);
        if (bVar == null) {
            x.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[]{str});
            return;
        }
        x.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[]{bVar.toString()});
        if (bVar.status == 1) {
            a aVar = new a(b.a(this.ymq), new 1(this));
            aVar.vmO = new 2(this, bVar);
            if (b.c(this.ymq) instanceof MobileFriendUI) {
                ((MobileFriendUI) b.e(this.ymq)).jwN = new MMActivity.a(this) {
                    final /* synthetic */ b$1 ymr;

                    public final void b(int i, int i2, Intent intent) {
                        if (i == 1 && i2 == -1) {
                            ((MobileFriendUI) b.d(this.ymr.ymq)).b(bVar);
                        }
                    }
                };
            }
            aVar.vmW = bVar.Nr();
            aVar.vmV = false;
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(13));
            aVar.b(bVar.getUsername(), linkedList, false);
        }
    }
}
