package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BrandServiceIndexUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BrandServiceIndexUI kFZ;

    BrandServiceIndexUI$3(BrandServiceIndexUI brandServiceIndexUI) {
        this.kFZ = brandServiceIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
        Intent intent = new Intent(this.kFZ, BrandServiceLocalSearchUI.class);
        intent.putExtra("is_return_result", BrandServiceIndexUI.a(this.kFZ));
        intent.addFlags(67108864);
        this.kFZ.startActivityForResult(intent, 1);
        return true;
    }
}
