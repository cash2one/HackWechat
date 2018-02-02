package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected long fqm = -1;
    protected ListView kGl = null;
    protected h pGe;

    protected abstract h bmY();

    protected abstract String bmZ();

    protected abstract String bna();

    protected abstract String bnb();

    protected abstract void bnc();

    protected abstract void c(int i, int i2, Intent intent);

    protected final int getLayoutId() {
        return R.i.dqz;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        bmX();
        e.i(this);
    }

    protected void bmX() {
        this.pGe = bmY();
        this.fqm = getIntent().getLongExtra("message_id", -1);
        this.kGl = (ListView) findViewById(R.h.cGZ);
        bnf();
        String bna = bna();
        String bnb = bnb();
        if (bh.ov(bna) || bh.ov(bnb)) {
            x.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            bna = bna.split(" ")[0];
            bnb = bnb.split(" ")[0];
            if (bna.equals(bnb)) {
                this.pGe.pFY = false;
            } else {
                bna = bna + "~" + bnb;
                this.pGe.pFY = true;
            }
            setMMSubTitle(bna);
        }
        View view = new View(this.mController.xIM);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.bvN)));
        this.kGl.addHeaderView(view, null, false);
        view = View.inflate(this.mController.xIM, R.i.dqy, null);
        this.kGl.setAdapter(this.pGe);
        this.pGe.Fv = this.kGl;
        this.pGe.bnd();
        this.kGl.setOnScrollListener(new 1(this));
        setBackBtn(new 2(this));
        bnc();
        this.kGl.postDelayed(new 3(this, view), 100);
    }

    protected void onResume() {
        super.onResume();
        b rtVar = new rt();
        if (this.kGl != null) {
            rtVar.fJy.type = 0;
            rtVar.fJy.fJz = this.kGl.getFirstVisiblePosition();
            rtVar.fJy.fJA = this.kGl.getLastVisiblePosition();
            rtVar.fJy.fJB = this.kGl.getHeaderViewsCount();
            a.xef.m(rtVar);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.pGe != null) {
            h hVar = this.pGe;
            for (int i = 0; i < hVar.pFX.size(); i++) {
                h.b bVar = (h.b) hVar.pFX.valueAt(i);
                if (bVar != null) {
                    bVar.pause();
                }
            }
        }
        b rtVar = new rt();
        rtVar.fJy.type = 1;
        a.xef.m(rtVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pGe != null) {
            this.pGe.destroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        c(i, i2, intent);
    }

    protected final void bnf() {
        CharSequence bmZ = bmZ();
        String string = this.mController.xIM.getString(R.l.edV);
        if (bmZ != null && bmZ.endsWith(string) && bmZ.lastIndexOf(string) > 0) {
            bmZ = bmZ.substring(0, bmZ.lastIndexOf(string) - 1);
        }
        O(i.c(this.mController.xIM, bmZ, getResources().getDimensionPixelSize(R.f.bus)));
    }
}
