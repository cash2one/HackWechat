package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.MMActivity;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button rGj;
    private Button rGk;
    private Intent rGl;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.rGl = getIntent();
        this.rGj = (Button) findViewById(f.bLT);
        this.rGj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSettingIntroduceUI rGm;

            {
                this.rGm = r1;
            }

            public final void onClick(View view) {
                g.pQN.h(14090, new Object[]{Integer.valueOf(3)});
                d.b(this.rGm, "sns", ".ui.SnsTimeLineUI", this.rGm.rGl);
                this.rGm.finish();
                this.rGm.overridePendingTransition(0, 0);
            }
        });
        g.pQN.h(14090, new Object[]{Integer.valueOf(1)});
        this.rGk = (Button) findViewById(f.cnJ);
        this.rGk.setOnClickListener(new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        g.pQN.h(14090, new Object[]{Integer.valueOf(3)});
        return true;
    }

    protected final int getLayoutId() {
        return i.g.qHN;
    }
}
