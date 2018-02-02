package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class URISpanHandlerSet$AAUriSpanHandler$1 implements OnClickListener {
    final /* synthetic */ String fhf;
    final /* synthetic */ String fhg;
    final /* synthetic */ long fhh;
    final /* synthetic */ AAUriSpanHandler fhi;

    URISpanHandlerSet$AAUriSpanHandler$1(AAUriSpanHandler aAUriSpanHandler, String str, String str2, long j) {
        this.fhi = aAUriSpanHandler;
        this.fhf = str;
        this.fhg = str2;
        this.fhh = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b bmVar = new bm();
        bmVar.fpD.fpE = this.fhf;
        bmVar.fpD.fpF = this.fhg;
        bmVar.fpD.fpG = this.fhh;
        a.xef.m(bmVar);
    }
}
