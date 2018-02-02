package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.q;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean ynd = false;
    private long kGB;
    private ListView kGl;
    private String lcX;
    private String lcY;
    private p lcZ;
    private String mTitle;
    private String talker;
    private a ynb;
    private c ync;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lcX = getIntent().getStringExtra("Block_list");
        this.lcY = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.kGB = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.ync = y.Mh().ag(this.kGB);
        if (this.ync == null) {
            x.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            return;
        }
        if (this.ync != null && this.ync.field_ownerUserId.equals(q.FS())) {
            ynd = true;
        }
        initView();
    }

    protected final void initView() {
        setMMTitle(this.mTitle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI yne;

            {
                this.yne = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.yne.setResult(0);
                this.yne.finish();
                return true;
            }
        });
        this.lcZ = new p(true, true);
        this.lcZ.zms = new 2(this);
        a(this.lcZ);
        this.kGl = (ListView) findViewById(R.h.bSK);
        j jVar = new j();
        c cVar = this.ync;
        String[] strArr = null;
        if (!t.ov(this.lcY)) {
            strArr = this.lcY.split(";");
            x.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[]{Arrays.toString(strArr)});
        }
        List linkedList = new LinkedList();
        if (!t.ov(this.lcX)) {
            linkedList = t.g(this.lcX.split(";"));
        }
        this.ynb = new a(this, jVar, cVar, strArr, linkedList);
        this.kGl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI yne;

            {
                this.yne = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i == 0 && BizChatAtSomeoneUI.ynd) {
                    intent.putExtra("Select_Conv_User", this.yne.getString(R.l.dHk, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    j jVar = (j) this.yne.ynb.getItem(i);
                    String a = BizChatAtSomeoneUI.a(this.yne.ync, jVar.field_userId);
                    intent.putExtra("select_raw_user_name", jVar.field_userId);
                    intent.putExtra("Select_Conv_User", a);
                }
                this.yne.setResult(-1, intent);
                this.yne.finish();
            }
        });
        this.kGl.setAdapter(this.ynb);
        this.kGl.setOnScrollListener(new 4(this));
    }

    protected void onPause() {
        super.onPause();
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    protected void onDestroy() {
        this.ynb.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daC;
    }

    protected static String a(c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        return cVar.gu(str);
    }
}
