package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a yQd;

    a$1(a aVar) {
        this.yQd = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.AddressAdapter", "on delView clicked");
        this.yQd.kBF.aUz();
        if (this.yQd.oPr != null) {
            this.yQd.oPr.bo(((ViewStub) a.a(this.yQd).get(view)).getTag());
        }
    }
}
