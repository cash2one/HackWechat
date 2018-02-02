package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class LocationExtUI$1 implements OnClickListener {
    final /* synthetic */ LocationExtUI nSF;

    LocationExtUI$1(LocationExtUI locationExtUI) {
        this.nSF = locationExtUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_result_list", LocationExtUI.a(this.nSF));
        d.b(this.nSF.mController.xIM, "favorite", ".ui.FavTagEditUI", intent, 4098);
    }
}
