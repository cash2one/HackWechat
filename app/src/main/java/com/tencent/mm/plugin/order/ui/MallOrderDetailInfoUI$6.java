package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject$a;

class MallOrderDetailInfoUI$6 implements OnItemClickListener {
    final /* synthetic */ MallOrderDetailInfoUI pcg;

    MallOrderDetailInfoUI$6(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        this.pcg = mallOrderDetailInfoUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MallOrderDetailObject$a mallOrderDetailObject$a = (MallOrderDetailObject$a) MallOrderDetailInfoUI.e(this.pcg).get(i);
        if (!TextUtils.isEmpty(mallOrderDetailObject$a.jumpUrl)) {
            c.at(this.pcg, mallOrderDetailObject$a.jumpUrl);
        }
        MallOrderDetailInfoUI.a(this.pcg, mallOrderDetailObject$a.name);
    }
}
