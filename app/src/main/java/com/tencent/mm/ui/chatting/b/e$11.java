package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class e$11 implements OnClickListener {
    final /* synthetic */ int hLI = 1;
    final /* synthetic */ LinkedList yyR;
    final /* synthetic */ e yzf;

    e$11(e eVar, LinkedList linkedList, int i) {
        this.yzf = eVar;
        this.yyR = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b jwVar = new jw();
        Context context = this.yzf.fhr.csq().getContext();
        this.yzf.fhr.csq().getMMString(R.l.dGO);
        this.yzf.fhr.b(h.a(context, this.yzf.fhr.csq().getMMString(R.l.eEY), true, new 1(this, jwVar)));
        jwVar.fAV.chatroomName = this.yzf.fhr.csi().field_username;
        jwVar.fAV.fAX = this.yyR;
        jwVar.fAV.scene = this.hLI;
        a.xef.m(jwVar);
    }
}
