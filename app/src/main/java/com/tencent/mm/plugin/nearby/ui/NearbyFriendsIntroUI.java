package com.tencent.mm.plugin.nearby.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button krY;
    private View oOq;
    private CheckBox oOr;
    private i oOt = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.exr);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.doK;
    }

    protected final void initView() {
        this.oOq = View.inflate(this, R.i.dmB, null);
        this.oOr = (CheckBox) this.oOq.findViewById(R.h.csH);
        this.oOr.setChecked(false);
        this.krY = (Button) findViewById(R.h.cyT);
        this.krY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI oOz;

            {
                this.oOz = r1;
            }

            public final void onClick(View view) {
                if (this.oOz.oOt == null) {
                    this.oOz.oOt = h.a(this.oOz.mController.xIM, this.oOz.getString(R.l.dGO), this.oOz.oOq, new 1(this), null);
                } else {
                    this.oOz.oOt.show();
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI oOz;

            {
                this.oOz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oOz.aWs();
                this.oOz.finish();
                return true;
            }
        });
    }
}
