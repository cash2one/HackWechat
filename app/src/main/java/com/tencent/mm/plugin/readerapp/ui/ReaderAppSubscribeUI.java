package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView pAM;
    private a pAN;

    protected final int getLayoutId() {
        return R.i.dqo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        c.CU().set(868518890, "in");
        setMMTitle(R.l.dVZ);
        initView();
    }

    protected final void initView() {
        ar.Hg();
        this.pAN = new a(this, bh.e((Integer) c.CU().get(868518889, null)));
        this.pAM = (ListView) findViewById(R.h.cFQ);
        this.pAM.setAdapter(this.pAN);
        this.pAM.setOnItemClickListener(new 1(this));
        this.pAN.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI pAO;

            {
                this.pAO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pAO.vh(this.pAO.pAN.pAQ);
                return true;
            }
        });
        3 3 = new 3(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.pAN != null) {
            vh(this.pAN.pAQ);
        }
        return true;
    }

    private void vh(int i) {
        ar.Hg();
        c.CU().set(868518889, Integer.valueOf(i));
        a com_tencent_mm_protocal_c_asf = new asf();
        com_tencent_mm_protocal_c_asf.wzK = i;
        ar.Hg();
        c.EX().b(new e.a(43, com_tencent_mm_protocal_c_asf));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.a.a.ifs.d(intent, this);
        finish();
    }

    protected void onResume() {
        super.onResume();
        this.pAN.notifyDataSetChanged();
    }
}
