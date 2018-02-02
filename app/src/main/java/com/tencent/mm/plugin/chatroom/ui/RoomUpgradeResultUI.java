package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private q kZS;
    private Button lci;
    private View lcj;
    private ImageView lck;
    private TextView lcl;
    private TextView lcm;
    private TextView lcn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        x.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[]{this.chatroomName});
        ar.Hg();
        this.kZS = c.Fh().hD(this.chatroomName);
        if (this.kZS == null) {
            goBack();
        }
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eGm);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomUpgradeResultUI lco;

            {
                this.lco = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lco.goBack();
                return true;
            }
        });
        this.lcj = findViewById(R.h.cTW);
        this.lck = (ImageView) findViewById(R.h.cTV);
        this.lcl = (TextView) findViewById(R.h.cTX);
        this.lcm = (TextView) findViewById(R.h.cTT);
        this.lcn = (TextView) findViewById(R.h.cTU);
        this.lci = (Button) findViewById(R.h.coI);
        this.lci.setOnClickListener(new 2(this));
        this.lci.setVisibility(0);
        final String str = this.kZS.field_roomowner;
        ar.Hg();
        a WO = c.EY().WO(str);
        if (WO == null || ((int) WO.gJd) > 0) {
            xd(str);
        } else {
            ak.a.hfL.a(str, this.chatroomName, new b.a(this) {
                final /* synthetic */ RoomUpgradeResultUI lco;

                public final void v(String str, boolean z) {
                    if (z) {
                        this.lco.lcj.post(new 1(this));
                    }
                }
            });
        }
        int chU = this.kZS.chU();
        this.lcm.setVisibility(0);
        this.lcm.setText(getString(R.l.eGu, new Object[]{Integer.valueOf(chU)}));
        this.lci.setText(R.l.eGp);
        this.lcn.setVisibility(8);
    }

    private void xd(String str) {
        ar.Hg();
        a WO = c.EY().WO(str);
        if (WO != null && ((int) WO.gJd) > 0) {
            CharSequence AP = WO.AP();
            com.tencent.mm.pluginsdk.ui.a.b.a(this.lck, str);
            this.lcl.setVisibility(0);
            this.lcl.setText(AP);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dcS;
    }
}
