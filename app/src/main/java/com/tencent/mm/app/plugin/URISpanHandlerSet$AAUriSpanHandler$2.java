package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class URISpanHandlerSet$AAUriSpanHandler$2 implements OnClickListener {
    final /* synthetic */ String fhf;
    final /* synthetic */ String fhg;
    final /* synthetic */ long fhh;
    final /* synthetic */ AAUriSpanHandler fhi;

    URISpanHandlerSet$AAUriSpanHandler$2(AAUriSpanHandler aAUriSpanHandler, String str, String str2, long j) {
        this.fhi = aAUriSpanHandler;
        this.fhf = str;
        this.fhg = str2;
        this.fhh = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b bnVar = new bn();
        bnVar.fpH.fpE = this.fhf;
        bnVar.fpH.fpF = this.fhg;
        bnVar.fpH.fpG = this.fhh;
        a.xef.m(bnVar);
    }
}
