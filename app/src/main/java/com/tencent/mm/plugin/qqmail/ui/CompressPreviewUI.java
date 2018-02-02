package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar kmo;
    private TextView mPP;
    private String poS = null;
    private String pod = null;
    private c pqQ = new c(this);
    private String pqr;
    private long prG = 0;
    private List<a> prH = new ArrayList();
    private String prI;
    private ListView prJ;
    private b prK;
    private a prL = new 5(this);

    protected final int getLayoutId() {
        return R.i.dmP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pod = getIntent().getStringExtra("mail_id");
        this.poS = getIntent().getStringExtra("attach_id");
        this.prG = getIntent().getLongExtra("attach_size", 0);
        this.pqr = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.pqr);
    }

    protected final void initView() {
        this.prJ = (ListView) findViewById(R.h.bWL);
        this.mPP = (TextView) findViewById(R.h.bWJ);
        this.kmo = (ProgressBar) findViewById(R.h.bWK);
        if (this.pod == null || this.poS == null) {
            this.kmo.setVisibility(8);
            this.mPP.setText(R.l.etY);
            return;
        }
        this.prK = new b(this, (byte) 0);
        this.prJ.setAdapter(this.prK);
        this.prJ.setOnItemClickListener(new 1(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ CompressPreviewUI prM;

            {
                this.prM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.prM.onKeyDown(4, null);
                return true;
            }
        });
        3 3 = new 3(this);
        addTextOptionMenu(0, getString(R.l.dEz), new 4(this));
        bkK();
    }

    public void onDestroy() {
        super.onDestroy();
        this.pqQ.release();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.prK.bkM() != null) {
            HQ(this.prK.bkM());
            return true;
        } else if (keyEvent != null) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return true;
        }
    }

    private void HQ(String str) {
        x.i("MicroMsg.CompressPreviewUI", "curPath=" + str);
        this.kmo.setVisibility(8);
        this.mPP.setVisibility(8);
        this.prJ.setVisibility(0);
        a HR = HR(str);
        List arrayList = new ArrayList();
        if (HR != null) {
            arrayList.add(HR);
        }
        for (int i = 0; i < this.prH.size(); i++) {
            a aVar = (a) this.prH.get(i);
            if ((str.endsWith(aVar.prO) && aVar.prO.length() > 0) || aVar.prO.equals(str)) {
                arrayList.add(aVar);
            }
        }
        b bVar = this.prK;
        bVar.prR = HR;
        bVar.prS = arrayList;
        this.prK.notifyDataSetChanged();
        this.prJ.setSelection(0);
    }

    private a HR(String str) {
        for (a aVar : this.prH) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void bkK() {
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.pod);
        hashMap.put("attachid", this.poS);
        hashMap.put("fun", "list");
        w.bks().a("/cgi-bin/viewcompress", hashMap, new c(), this.prL);
    }
}
