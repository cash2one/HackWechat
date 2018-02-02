package com.tencent.mm.ui.chatting.e;

import android.content.pm.PackageInfo;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class f$2 implements e {
    final /* synthetic */ f yHG;

    f$2(f fVar) {
        this.yHG = fVar;
    }

    public final void a(int i, b bVar) {
        ar.Hg();
        cf dH = c.Fa().dH(bVar.fqm);
        a fT = a.fT(dH.field_content);
        String A = p.A(fT.url, "message");
        String A2 = p.A(fT.hba, "message");
        PackageInfo packageInfo = f.getPackageInfo(this.yHG.mContext, fT.appId);
        this.yHG.a(A, A2, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, fT.appId, dH.field_msgId, dH.field_msgSvrId, dH);
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
        new l(view.getContext()).b(view, new OnCreateContextMenuListener(this) {
            final /* synthetic */ f$2 yHI;

            {
                this.yHI = r1;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eEG));
                contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dQP));
                contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dRH));
            }
        }, new 2(this, bVar));
    }
}
