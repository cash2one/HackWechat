package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class a$1 implements OnClickListener {
    final /* synthetic */ a nWf;

    a$1(a aVar) {
        this.nWf = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.nWf.activity, RemarkUI.class);
        intent.putExtra("key_nullable", true);
        intent.putExtra("key_value", this.nWf.aWp());
        intent.putExtra("key_hint", this.nWf.getString(R.l.ete));
        intent.putExtra("Kwebmap_locaion", this.nWf.nVS.nQz);
        intent.putExtra("kFavInfoLocalId", this.nWf.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
        intent.putExtra("kRemark", this.nWf.activity.getIntent().getStringExtra("kRemark"));
        this.nWf.activity.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
    }
}
