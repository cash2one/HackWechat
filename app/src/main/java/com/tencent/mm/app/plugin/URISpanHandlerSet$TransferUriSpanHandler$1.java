package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ac;

class URISpanHandlerSet$TransferUriSpanHandler$1 implements OnClickListener {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ TransferUriSpanHandler fhq;

    URISpanHandlerSet$TransferUriSpanHandler$1(TransferUriSpanHandler transferUriSpanHandler, Bundle bundle) {
        this.fhq = transferUriSpanHandler;
        this.fhp = bundle;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String string = this.fhp.getString("transaction_id");
        String string2 = this.fhp.getString("receiver_name");
        Intent intent = new Intent();
        intent.putExtra("transaction_id", string);
        intent.putExtra("receiver_name", string2);
        d.b(ac.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
    }
}
