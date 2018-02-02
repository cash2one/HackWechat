package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.appbrand.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.math.BigInteger;
import java.util.List;

@Keep
public class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI extends b implements d {
    private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
    private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
    private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
    private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
    private d adapter;
    private a appBrandServiceActionSheet;
    private ListView appbrandMessageLV;
    private l contextMenuHelper;
    private ae conversation;
    private TextView emptyTipTv;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private String mAppId;
    private String mSceneId;
    private String superUsername;
    private String talker = "";
    private r tipDialog = null;

    public void onActivityCreated(Bundle bundle) {
        x.i(TAG, "onActivityCreated");
        super.onActivityCreated(bundle);
        this.superUsername = getStringExtra("Contact_User");
        if (TextUtils.isEmpty(this.superUsername)) {
            this.superUsername = "appbrandcustomerservicemsg";
        }
        this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
        x.i(TAG, "fromScene:%d", Integer.valueOf(this.fromScene));
        ar.Hg();
        this.mSceneId = System.currentTimeMillis() + intToString(c.Cg());
        initView();
        addIconOptionMenu(1, R.k.dvH, new 1(this));
        ar.Hg();
        c.Fd().a(this.adapter);
        cleadAllServiceAppBrandUnreadCount();
        enterConversationReport();
        batchSyncForWxaContact();
    }

    private void cleadAllServiceAppBrandUnreadCount() {
        com.tencent.mm.sdk.b.a.xef.m(new o());
    }

    protected int getLayoutId() {
        return R.i.dsZ;
    }

    public String getUserName() {
        return this.superUsername;
    }

    public void onDestroy() {
        if (ar.Hj()) {
            ar.Hg();
            c.Fd().b(this.adapter);
        }
        batchSyncForWxaContact();
        if (this.adapter != null) {
            this.adapter.onDestroy();
        }
        super.onDestroy();
    }

    public void onResume() {
        x.i(TAG, "on resume");
        if (this.adapter != null) {
            this.adapter.onResume();
        }
        super.onResume();
    }

    public void onPause() {
        x.i(TAG, "on pause");
        ar.Hg();
        c.Fd().Xa(this.superUsername);
        if (this.adapter != null) {
            this.adapter.onPause();
        }
        super.onPause();
    }

    private void batchSyncForWxaContact() {
        if (this.adapter != null && this.adapter.getCount() != 0) {
            x.i(TAG, "batchSyncForWxaContact, size:%d", Integer.valueOf(this.adapter.getCount()));
            if (this.adapter instanceof a) {
                List list = ((a) this.adapter).gIW;
                if (list != null && list.size() > 0) {
                    ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).Z(list);
                }
            }
        }
    }

    private String intToString(int i) {
        return new BigInteger(Integer.toBinaryString(i), 2).toString();
    }

    private void enterConversationReport() {
        String str = "";
        if (this.adapter == null) {
            x.d(TAG, "adapter is null!");
            return;
        }
        int i;
        Object obj;
        int i2;
        ar.Hg();
        aj WY = c.Fd().WY("appbrandcustomerservicemsg");
        if (WY == null || bh.ov(WY.field_username)) {
            i = 0;
        } else {
            i = WY.field_unReadCount;
        }
        ae aeVar = (ae) this.adapter.getItem(0);
        if (aeVar == null || bh.ov(aeVar.field_username)) {
            String str2 = str;
        } else {
            String ou = bh.ou(aeVar.field_content);
            WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(aeVar.field_username);
            this.mAppId = qK == null ? null : qK.field_appId;
            obj = ou;
        }
        if (i > 0) {
            int count = this.adapter.getCount();
            int i3 = 0;
            i2 = 0;
            while (i3 < count) {
                int i4;
                aeVar = (ae) this.adapter.getItem(i3);
                if (aeVar.field_unReadMuteCount + aeVar.field_unReadCount > 0) {
                    i4 = i2 + 1;
                } else {
                    i4 = i2;
                }
                i3++;
                i2 = i4;
            }
        } else {
            i2 = 0;
        }
        x.d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", Integer.valueOf(13797), this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, obj);
        com.tencent.mm.plugin.report.service.g.pQN.h(13797, this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, Long.valueOf(bh.Wo()), Integer.valueOf(0), obj);
    }

    public void customerMsgOperateReport(int i) {
        x.d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), this.mAppId, this.mSceneId);
        com.tencent.mm.plugin.report.service.g.pQN.h(13798, Integer.valueOf(i), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bh.Wo()));
    }

    public void entryCustomerMsgDialogReport(String str, int i) {
        ar.Hg();
        aj WY = c.Fd().WY(str);
        if (WY == null) {
            x.e(TAG, "cvs:%s is null, error", str);
            return;
        }
        int i2 = WY.field_unReadCount;
        String ou = bh.ou(this.mSceneId);
        x.d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), ou);
        com.tencent.mm.plugin.report.service.g.pQN.h(13799, this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), ou, Long.valueOf(bh.Wo()));
    }

    protected void initView() {
        setMMTitle(getString(R.l.dDQ));
        this.appbrandMessageLV = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.dDS);
        setBackBtn(new 5(this));
        this.appBrandServiceActionSheet = new a(thisActivity());
        this.adapter = new a(thisActivity(), this.superUsername, new 6(this));
        this.adapter.a(new 7(this));
        this.adapter.a(new 8(this));
        this.appbrandMessageLV.setAdapter(this.adapter);
        this.contextMenuHelper = new l(thisActivity());
        this.appbrandMessageLV.setOnItemClickListener(new 9(this));
        this.appbrandMessageLV.setOnItemLongClickListener(new 10(this));
        this.adapter.a(new 11(this));
        this.adapter.a(new 12(this));
        this.adapter.a(new 2(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 == -1) {
        }
    }

    private void setShowView(int i) {
        if (i <= 0) {
            this.emptyTipTv.setVisibility(0);
            this.appbrandMessageLV.setVisibility(8);
            return;
        }
        this.emptyTipTv.setVisibility(8);
        this.appbrandMessageLV.setVisibility(0);
    }

    private void delConversationAndMsg(String str) {
        if (bh.ov(str)) {
            x.e(TAG, "Delete Conversation and messages fail because username is null or nil.");
            return;
        }
        asyncDelMsg(str);
        ar.Hg();
        c.Fd().WX(str);
    }

    private void asyncDelMsg(String str) {
        x.i(TAG, "async del msg talker:%s", str);
        ar.Hg();
        cf Ew = c.Fa().Ew(str);
        com.tencent.mm.bq.a qaVar = new qa();
        qaVar.vYI = new bdo().UA(bh.ou(str));
        qaVar.vHe = Ew.field_msgSvrId;
        ar.Hg();
        c.EX().b(new e.a(8, qaVar));
        this.isDeleteCancel = false;
        Context thisActivity = thisActivity();
        getString(R.l.dGO);
        ProgressDialog a = h.a(thisActivity, getString(R.l.dHc), true, new 3(this));
        customerMsgOperateReport(5);
        ba.a(str, new 4(this, a));
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ar.Hg();
        com.tencent.mm.l.a WO = c.EY().WO(this.talker);
        if (WO == null || ((int) WO.gJd) == 0) {
            x.e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
            return;
        }
        switch (menuItem.getItemId()) {
            case 1:
                this.appBrandServiceActionSheet.username = this.talker;
                this.appBrandServiceActionSheet.scene = this.fromScene;
                this.appBrandServiceActionSheet.xVB = this.mSceneId;
                this.appBrandServiceActionSheet.kfu = true;
                this.appBrandServiceActionSheet.show(3);
                return;
            case 2:
                this.appBrandServiceActionSheet.username = this.talker;
                this.appBrandServiceActionSheet.scene = this.fromScene;
                this.appBrandServiceActionSheet.xVB = this.mSceneId;
                this.appBrandServiceActionSheet.kfu = true;
                this.appBrandServiceActionSheet.show(4);
                return;
            case 3:
                delConversationAndMsg(this.talker);
                return;
            default:
                return;
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(this.talker);
        int i = (qK == null || (qK.field_appOpt & 2) <= 0) ? 0 : 1;
        if (i != 0) {
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dDW);
        } else {
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dDX);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.dYt);
    }
}
