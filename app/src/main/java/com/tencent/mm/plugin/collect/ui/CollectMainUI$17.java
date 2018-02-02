package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class CollectMainUI$17 implements OnLongClickListener {
    final /* synthetic */ CollectMainUI lnh;

    CollectMainUI$17(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
    }

    public final boolean onLongClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.lnh.getString(a$i.uIM));
        linkedList2.add(Integer.valueOf(0));
        h.a(this.lnh.mController.xIM, this.lnh.getString(a$i.uIO), linkedList, linkedList2, null, true, new 1(this));
        return true;
    }
}
