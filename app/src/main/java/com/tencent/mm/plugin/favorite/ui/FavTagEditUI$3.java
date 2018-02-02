package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Collection;
import java.util.Iterator;

class FavTagEditUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FavTagEditUI mtH;
    final /* synthetic */ long mtI;

    FavTagEditUI$3(FavTagEditUI favTagEditUI, long j) {
        this.mtH = favTagEditUI;
        this.mtI = j;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (FavTagEditUI.b(this.mtH)) {
            FavTagEditUI.c(this.mtH);
        } else {
            Collection cpH = FavTagEditUI.d(this.mtH).cpH();
            String trim = FavTagEditUI.d(this.mtH).cpC().trim();
            if (!bh.ov(trim)) {
                cpH.remove(trim);
                cpH.add(trim);
            }
            FavTagEditUI.a(this.mtH, h.getFavItemInfoStorage().db(this.mtI));
            Intent intent;
            if (FavTagEditUI.e(this.mtH) != null) {
                j.a(FavTagEditUI.e(this.mtH), cpH, this.mtH.getIntent().getIntExtra("key_fav_scene", 1));
                intent = new Intent();
                intent.putExtra("key_fav_result_list", cpH);
                this.mtH.setResult(-1, intent);
            } else {
                String[] strArr = new String[cpH.size()];
                Iterator it = cpH.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = (String) it.next();
                    i = i2;
                }
                intent = new Intent();
                intent.putExtra("key_fav_result_array", strArr);
                intent.putExtra("key_fav_result_list", cpH);
                this.mtH.setResult(-1, intent);
            }
            this.mtH.finish();
            this.mtH.aWs();
        }
        return true;
    }
}
