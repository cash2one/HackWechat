package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;

public class IPCallMsgUI extends MMActivity {
    private View kUE;
    private boolean kUF = true;
    private ListView nKG;
    private a nKH;
    private View nKI;
    private a nKJ = new 7(this);

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dml;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.aTG().c(this.nKJ);
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.aTG().j(this.nKJ);
        this.nKH.aUn();
        h aTG = i.aTG();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        aTG.gJP.update(aTG.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.erE);
        this.nKI = findViewById(R.h.crh);
        this.nKG = (ListView) findViewById(R.h.cri);
        this.kUE = v.fv(this).inflate(R.i.dns, null);
        this.nKG.addFooterView(this.kUE);
        this.nKH = new a(this, this, new g());
        this.nKH.a(new 1(this));
        this.nKH.a(new 2(this));
        this.nKH.xIi = new 3(this);
        this.nKG.setAdapter(this.nKH);
        this.nKG.setOnItemClickListener(new 4(this));
        this.nKG.setOnScrollListener(new 5(this));
        if (this.nKH.getCount() == 0) {
            this.nKG.setVisibility(8);
            this.nKI.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nKG.setVisibility(0);
            this.nKI.setVisibility(8);
            enableOptionMenu(true);
        }
        if (this.nKH.awe()) {
            this.nKG.removeFooterView(this.kUE);
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMsgUI nKK;

            {
                this.nKK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKK.finish();
                return true;
            }
        });
        if (this.nKH.awe()) {
            this.nKG.removeFooterView(this.kUE);
        }
    }
}
