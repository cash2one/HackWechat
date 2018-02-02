package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.ui.MMActivity;

public class ShowNonWeixinFriendUI extends MMActivity implements a {
    private long xSG = 0;
    private String xSH = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.epH);
        this.xSG = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.xSH = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
    }

    protected void onPause() {
        super.onPause();
        n.Jz().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.Jz().d(this);
    }

    protected final int getLayoutId() {
        return R.i.dho;
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(R.h.cpX);
        TextView textView = (TextView) findViewById(R.h.cqb);
        TextView textView2 = (TextView) findViewById(R.h.cqc);
        imageView.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.k.dyn));
        imageView.setImageBitmap(b.iR(this.xSG));
        textView.setText(this.xSH);
        textView2.setText(getString(R.l.cqc, new Object[]{this.xSH}));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowNonWeixinFriendUI xSI;

            {
                this.xSI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xSI.aWs();
                this.xSI.finish();
                return true;
            }
        });
        ((Button) findViewById(R.h.cqa)).setOnClickListener(new 2(this));
    }

    public final void jh(String str) {
        initView();
    }
}
