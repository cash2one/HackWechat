package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.u;

class LocationExtUI$2 implements OnClickListener {
    final /* synthetic */ LocationExtUI nSF;

    LocationExtUI$2(LocationExtUI locationExtUI) {
        this.nSF = locationExtUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.nSF.mController.xIM, RemarkUI.class);
        intent.putExtra("key_nullable", true);
        intent.putExtra("key_value", this.nSF.getIntent().getStringExtra("key_value"));
        intent.putExtra("key_hint", this.nSF.getString(R.l.ete));
        intent.putExtra("Kwebmap_locaion", this.nSF.getIntent().getStringExtra("Kwebmap_locaion"));
        intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra("kFavInfoLocalId", this.nSF.getIntent().getLongExtra("kFavInfoLocalId", -1));
        intent.putExtra("kRemark", this.nSF.getIntent().getStringExtra("kRemark"));
        this.nSF.startActivityForResult(intent, 4097);
    }
}
