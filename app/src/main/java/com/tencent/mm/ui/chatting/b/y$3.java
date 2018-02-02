package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import java.util.LinkedList;

class y$3 implements p$d {
    final /* synthetic */ y yBS;
    final /* synthetic */ LinkedList yBT;
    final /* synthetic */ String yBU;

    y$3(y yVar, LinkedList linkedList, String str) {
        this.yBS = yVar;
        this.yBT = linkedList;
        this.yBU = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                this.yBS.ywc.az(this.yBT);
                return;
            case 1:
                final b kbVar = new kb();
                Context context = this.yBS.fhr.csq().getContext();
                this.yBS.fhr.csq().getString(R.l.dGO);
                this.yBS.fhr.b(h.a(context, this.yBS.fhr.csq().getString(R.l.eFg), true, new OnCancelListener(this) {
                    final /* synthetic */ y$3 yBW;

                    public final void onCancel(DialogInterface dialogInterface) {
                        kbVar.fBo.fAJ = true;
                        a.xef.m(kbVar);
                    }
                }));
                kbVar.fBo.chatroomName = this.yBS.fhr.csi().field_username;
                kbVar.fBo.fBq = this.yBU;
                a.xef.m(kbVar);
                return;
            default:
                return;
        }
    }
}
