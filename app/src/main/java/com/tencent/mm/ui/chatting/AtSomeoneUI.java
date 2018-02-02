package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean ynd = false;
    private ListView kGl;
    private q kZS;
    private String lcX;
    private String lcY;
    private p lcZ;
    private String mTitle;
    private String talker;
    private a yqj;

    private static class b {
        public TextView kEZ;
        public MaskLayout ldx;
        public ImageView ynh;

        private b() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lcX = getIntent().getStringExtra("Block_list");
        this.lcY = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        ar.Hg();
        this.kZS = c.Fh().hD(this.talker);
        if (this.kZS != null && this.kZS.field_roomowner.equals(com.tencent.mm.z.q.FS())) {
            ynd = false;
        }
        initView();
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(this.mTitle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AtSomeoneUI yqk;

            {
                this.yqk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.yqk.setResult(0);
                this.yqk.finish();
                return true;
            }
        });
        this.lcZ = new p(true, true);
        this.lcZ.zms = new 2(this);
        a(this.lcZ);
        this.kGl = (ListView) findViewById(R.h.bSK);
        x xVar = new x();
        q qVar = this.kZS;
        String[] strArr = null;
        if (!t.ov(this.lcY)) {
            strArr = this.lcY.split(",");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[]{Arrays.toString(strArr)});
        }
        if (strArr == null && this.kZS != null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = t.d(this.kZS.Ms(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.kZS != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
        }
        List linkedList = new LinkedList();
        if (!t.ov(this.lcX)) {
            linkedList = t.g(this.lcX.split(","));
        }
        ar.Hg();
        bc EY = c.Fg().EY("@t.qq.com");
        if (EY != null) {
            linkedList.add(EY.name);
        }
        this.yqj = new a(this, xVar, qVar, strArr, linkedList);
        this.kGl.setOnItemClickListener(new 3(this));
        this.kGl.setAdapter(this.yqj);
    }

    protected void onPause() {
        super.onPause();
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    protected void onDestroy() {
        this.yqj.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daC;
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.gu(str);
    }
}
