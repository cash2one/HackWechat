package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SnsTagContactListUI extends MMActivity {
    private ListView nPx;
    private a yUS;
    private List<Long> yUT = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.ePX);
        findViewById(R.h.ctC).setVisibility(8);
        this.nPx = (ListView) findViewById(R.h.bJe);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.yUT.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(R.h.cee)).setVisibility(8);
        findViewById(R.h.bJn).setVisibility(8);
        this.nPx.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.nPx.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        this.yUS = new a(this, this.yUT);
        this.nPx.setAdapter(this.yUS);
        this.nPx.setVisibility(0);
        this.nPx.setOnItemClickListener(new 1(this));
        setBackBtn(new 2(this));
        showOptionMenu(false);
    }

    public void onResume() {
        super.onResume();
        if (this.yUS != null) {
            this.yUS.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daa;
    }
}
