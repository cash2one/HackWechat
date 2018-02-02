package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView lCz;
    private a xME;
    private long xMF;
    private List<f> xMG;

    protected final int getLayoutId() {
        return R.i.dsL;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xMF = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.xMG = g.b(this, this.xMF, true);
        final List fs = an.bYT().fs(this.xMF);
        if (fs != null && fs.size() > 0) {
            Collections.sort(this.xMG, new Comparator<f>(this) {
                final /* synthetic */ Sort3rdAppUI xMH;

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return fs.indexOf(((f) obj2).field_appId) - fs.indexOf(((f) obj).field_appId);
                }
            });
        }
        this.xME = new a(this, this.xMG, this.xMF);
        this.lCz.setAdapter(this.xME);
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ Sort3rdAppUI xMH;

            {
                this.xMH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xMH.finish();
                return true;
            }
        });
        setMMTitle(getString(R.l.dCj));
        this.lCz = (DragSortListView) findViewById(R.h.ctf);
        this.lCz.zrB = new DragSortListView.g(this) {
            final /* synthetic */ Sort3rdAppUI xMH;

            {
                this.xMH = r1;
            }

            public final void cq(int i, int i2) {
                f fVar = (f) this.xMH.xME.getItem(i);
                this.xMH.xME.remove(fVar);
                this.xMH.xME.insert(fVar, i2);
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.xME != null) {
            List list = this.xME.ltR;
            o bYT = an.bYT();
            long j = this.xMF;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            bYT.gJP.fx("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                ar.Hg();
                j = c.EV().dz(Thread.currentThread().getId());
                o bYT2 = an.bYT();
                for (int i = 0; i < list.size(); i++) {
                    n nVar = new n();
                    nVar.field_flag = this.xMF;
                    nVar.field_appId = ((f) list.get(i)).field_appId;
                    nVar.field_sortId = i;
                    bYT2.a(nVar);
                }
                ar.Hg();
                c.EV().fS(j);
            }
        }
    }
}
