package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SelectPoiCategoryUI$1 implements OnItemClickListener {
    final /* synthetic */ SelectPoiCategoryUI oRn;

    SelectPoiCategoryUI$1(SelectPoiCategoryUI selectPoiCategoryUI) {
        this.oRn = selectPoiCategoryUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(SelectPoiCategoryUI.a(this.oRn).size())});
        Intent intent = new Intent();
        intent.putExtra("poi_category", (String) SelectPoiCategoryUI.a(this.oRn).get(i));
        this.oRn.setResult(-1, intent);
        this.oRn.finish();
    }
}
