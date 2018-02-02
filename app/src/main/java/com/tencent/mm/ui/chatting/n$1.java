package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class n$1 implements OnMenuItemClickListener {
    final /* synthetic */ n ysc;

    n$1(n nVar) {
        this.ysc = nVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        Set<Long> set = this.ysc.yrX.ytp;
        if (set != null) {
            List<Long> arrayList = new ArrayList();
            for (Long l : set) {
                if (l != null) {
                    arrayList.add(l);
                }
            }
            long[] jArr = new long[arrayList.size()];
            int i = 0;
            for (Long l2 : arrayList) {
                int i2 = i + 1;
                jArr[i] = l2.longValue();
                i = i2;
            }
            intent.putExtra("k_outside_expose_proof_item_list", jArr);
            this.ysc.yrW.thisActivity().setResult(-1, intent);
        } else {
            this.ysc.yrW.thisActivity().setResult(0, intent);
        }
        intent.putExtra("k_is_group_chat", this.ysc.ypn);
        this.ysc.yrW.finish();
        return false;
    }
}
