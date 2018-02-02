package com.tencent.mm.ui.tools;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView lCz;
    private List<f> xMG;
    private a zlJ;

    protected final int getLayoutId() {
        return R.i.dos;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new 2(this));
        addTextOptionMenu(0, getString(R.l.eaf), new OnMenuItemClickListener(this) {
            final /* synthetic */ MoreShareAppUI zlK;

            {
                this.zlK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.zlJ = new a(this, this.xMG);
        this.lCz.setAdapter(this.zlJ);
    }

    protected final void initView() {
        setMMTitle(R.l.dNb);
        this.lCz = (DragSortListView) findViewById(R.h.ctf);
        this.lCz.zrB = new g(this) {
            final /* synthetic */ MoreShareAppUI zlK;

            {
                this.zlK = r1;
            }

            public final void cq(int i, int i2) {
                f fVar = (f) this.zlK.zlJ.getItem(i);
                a.a(this.zlK.zlJ).remove(i);
                this.zlK.zlJ.notifyDataSetChanged();
                this.zlK.zlJ.insert(fVar, i2);
            }
        };
    }
}
