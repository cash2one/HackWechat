package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI extends FavBaseUI {
    private String mtq;
    private b mtr = null;
    private Set<Integer> mts = new HashSet();
    private d mtt = new d();
    private String toUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUser = getIntent().getStringExtra("key_to_user");
        this.mtq = getIntent().getStringExtra("key_fav_item_id");
        if (this.mtq != null) {
            for (String str : this.mtq.split(",")) {
                int i = bh.getInt(str, Integer.MAX_VALUE);
                if (Integer.MAX_VALUE != i) {
                    this.mts.add(Integer.valueOf(i));
                }
            }
        }
        this.mts.remove(Integer.valueOf(3));
        this.mtr.e(this.mts);
        this.mtt.mpz = false;
        this.mtr.a(this.mtt);
        this.mrL.post(new 1(this));
        addIconOptionMenu(0, R.k.dvb, new 2(this));
        setMMTitle(R.l.egw);
        setBackBtn(new 3(this));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.b bVar = (a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, holder is null");
        } else if (bVar.mqC == null) {
            x.w("MicroMsg.FavSelectUI", "on item click, info is null");
        } else {
            f fVar = bVar.mqC;
            g.pQN.h(10651, Integer.valueOf(fVar.field_type), Integer.valueOf(1), Integer.valueOf(1));
            if (fVar.field_type == 3) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.dBO));
            } else if (fVar.field_type == 8 && s.gF(this.toUser)) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.dBM));
            } else {
                e.a aVar = new e.a(this.mController.xIM);
                aVar.bS(this.toUser);
                com.tencent.mm.plugin.favorite.ui.b.e.a(aVar, this.mController.xIM, bVar.mqC);
                com.tencent.mm.plugin.favorite.ui.b.e.b(aVar, this.mController.xIM, bVar.mqC);
                aVar.f(Boolean.valueOf(true)).BW(R.l.dGA).a(new 4(this, bVar)).pyk.show();
            }
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a aJb() {
        if (this.mtr == null) {
            ActionBarActivity actionBarActivity = this.mController.xIM;
            this.mtr = new b(this.mpb, false);
        }
        return this.mtr;
    }

    protected final void aJc() {
    }

    protected final boolean aJd() {
        return h.getFavItemInfoStorage().getCount() > 0;
    }

    protected final void aJe() {
        this.mrJ.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bCe, 0, 0);
        this.mrJ.setCompoundDrawablePadding(com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 10));
        this.mrJ.setText(R.l.efa);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && -1 == i2) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mtr != null) {
            this.mtr.finish();
        }
    }
}
