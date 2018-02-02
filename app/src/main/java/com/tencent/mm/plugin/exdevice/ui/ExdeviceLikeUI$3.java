package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.exdevice.f.b.a.e;

class ExdeviceLikeUI$3 implements OnItemClickListener {
    final /* synthetic */ ExdeviceLikeUI lUB;

    ExdeviceLikeUI$3(ExdeviceLikeUI exdeviceLikeUI) {
        this.lUB = exdeviceLikeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar = (e) ExdeviceLikeUI.b(this.lUB).getItem(i);
        Intent intent = new Intent(this.lUB, ExdeviceRankInfoUI.class);
        intent.putExtra("app_username", eVar.field_appusername);
        intent.putExtra("rank_id", eVar.field_rankID);
        intent.putExtra("device_type", 1);
        this.lUB.startActivity(intent);
        this.lUB.finish();
    }
}
