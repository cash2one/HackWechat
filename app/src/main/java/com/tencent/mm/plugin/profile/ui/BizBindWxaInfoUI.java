package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public final class BizBindWxaInfoUI extends MMActivity {
    private TextView phj;
    private ListView phk;
    private String phl;
    private String phm;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.phl = getIntent().getStringExtra("extra_username");
        this.phm = getIntent().getStringExtra("extra_appid");
        setBackBtn(new 1(this));
        setMMTitle(j.iBX);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(h.ixH, null);
        this.phj = (TextView) inflate.findViewById(g.cSh);
        TextView textView = this.phj;
        int i = j.iBW;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(i, objArr));
        this.phk = (ListView) findViewById(g.ivK);
        this.phk.addHeaderView(inflate);
        this.phk.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.phk.setOnItemClickListener(new 2(this));
        this.mController.contentView.setBackgroundResource(d.btP);
    }

    protected final int getLayoutId() {
        return h.ixI;
    }
}
