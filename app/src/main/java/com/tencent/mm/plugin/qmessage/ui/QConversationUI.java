package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements e {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private d kBR = new 5(this);
    private x lFr;
    private boolean onI = false;
    private ListView pnL;
    private c pnM;
    private c pnN;
    private boolean pnO = false;
    private String pnP;
    private String pnQ;
    private boolean pnR = false;
    private String pnS;

    static /* synthetic */ void a(QConversationUI qConversationUI, int i) {
        if (i <= 0) {
            qConversationUI.emptyTipTv.setVisibility(0);
            qConversationUI.pnL.setVisibility(8);
            return;
        }
        qConversationUI.emptyTipTv.setVisibility(8);
        qConversationUI.pnL.setVisibility(0);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str) {
        ar.Hg();
        cf Ew = com.tencent.mm.z.c.Fa().Ew(str);
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.d(str, Ew.field_msgSvrId));
        qConversationUI.isDeleteCancel = false;
        qConversationUI.getString(R.l.dGO);
        ba.a(str, new 4(qConversationUI, str, h.a(qConversationUI, qConversationUI.getString(R.l.dHc), true, new 3(qConversationUI))));
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            return;
        }
        f aZ = g.aZ(str, true);
        if (aZ == null || !p.m(qConversationUI.mController.xIM, aZ.field_packageName)) {
            if (bh.ov(str2)) {
                str2 = p.w(qConversationUI.mController.xIM, str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bm.d.b(qConversationUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
        } else if (aZ.field_status == 3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
        } else if (p.b(qConversationUI.mController.xIM, aZ)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent2.setClassName(aZ.field_packageName, av(qConversationUI.mController.xIM, aZ.field_packageName));
            intent2.putExtra(ConstantsAPI$Token.WX_TOKEN_PLATFORMID_KEY, ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
            ar.Hg();
            Object obj = com.tencent.mm.z.c.CU().get(9, null);
            int intValue = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            if (intValue != 0) {
                try {
                    byte[] bytes = String.valueOf(intValue).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    intValue = 0;
                    int i = 0;
                    while (intValue < length) {
                        byte b = bytes2[intValue];
                        if (i >= bytes.length) {
                            break;
                        }
                        int i2 = i + 1;
                        bytes[i] = (byte) (b ^ bytes[i]);
                        intValue++;
                        i = i2;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
            } catch (Exception e2) {
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", aZ.field_appName);
            Toast.makeText(qConversationUI.mController.xIM, qConversationUI.getString(R.l.emo, new Object[]{g.a(qConversationUI.mController.xIM, aZ, null)}), 1).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsZ;
    }

    public void onDestroy() {
        this.pnM.aUn();
        if (this.pnN != null) {
            ar.CG().c(this.pnN);
            ar.CG().b(this.pnN.getType(), (e) this);
            this.pnN = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        bkb();
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(this.pnM);
        this.pnM.a(null, null);
    }

    private static void bkb() {
        ar.Hg();
        cf su = com.tencent.mm.z.c.Fa().su(2);
        if (su != null && su.field_msgId > 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + su.field_createTime);
            ar.Hg();
            com.tencent.mm.z.c.CU().set(12295, Long.valueOf(su.field_createTime));
        }
        ar.Hg();
        ae WY = com.tencent.mm.z.c.Fd().WY("qmessage");
        if (WY == null || bh.ou(WY.field_username).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            return;
        }
        WY.eO(0);
        ar.Hg();
        if (com.tencent.mm.z.c.Fd().a(WY, WY.field_username) == -1) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
    }

    public void onPause() {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.QConversationUI", "on pause");
        ar.Hg();
        com.tencent.mm.z.c.Fd().b(this.pnM);
        bkb();
        this.pnM.onPause();
        super.onPause();
    }

    protected final void initView() {
        this.onI = getIntent().getBooleanExtra("finish_direct", false);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "isFromSearch  " + this.onI);
        ar.Hg();
        this.lFr = com.tencent.mm.z.c.EY().WO("qmessage");
        String str = "can not find qmessage";
        boolean z = this.lFr != null && ((int) this.lFr.gJd) > 0;
        Assert.assertTrue(str, z);
        this.pnL = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.ebA);
        this.pnM = new c(this, new 1(this));
        this.pnM.a(new 6(this));
        this.pnM.a(new 7(this));
        this.pnM.a(new 8(this));
        this.pnL.setAdapter(this.pnM);
        this.pnL.setOnItemClickListener(new 9(this));
        this.pnL.setOnItemLongClickListener(new 10(this, new i(this)));
        a.pnq.ep(HardCoderJNI.FUNC_REG_ANR_CALLBACK);
        setBackBtn(new 11(this));
        12 12 = new 12(this);
        ar.Hg();
        this.pnP = (String) com.tencent.mm.z.c.CU().get(77, (Object) "");
        ar.Hg();
        this.pnQ = (String) com.tencent.mm.z.c.CU().get(78, (Object) "");
        if (this.pnN == null) {
            this.pnN = new c();
            ar.CG().a(this.pnN.getType(), (e) this);
        }
        ar.CG().a(this.pnN, 0);
        bkc();
        a.pnq.ep(HardCoderJNI.FUNC_REG_ANR_CALLBACK);
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        return null;
    }

    private void bkc() {
        this.mController.removeAllOptionMenu();
        if (!bh.ov(this.pnP)) {
            this.pnO = true;
            addIconOptionMenu(0, R.l.dCi, R.k.cEm, new 13(this));
        }
        addIconOptionMenu(2, R.l.dCj, R.k.dvc, new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        if (this.onI) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        a.ifs.s(intent, this);
        overridePendingTransition(R.a.bpQ, R.a.bql);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ae aeVar = (ae) this.pnM.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        ar.Hg();
        contextMenu.setHeaderTitle(com.tencent.mm.z.c.EY().WO(aeVar.field_username).AQ());
        contextMenu.add(0, 0, 0, R.l.eup);
        this.pnS = aeVar.field_username;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    acy com_tencent_mm_protocal_c_acy;
                    Object obj;
                    String str3;
                    c cVar = (c) kVar;
                    if (cVar.hRB != null) {
                        com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                        if (com_tencent_mm_protocal_c_acy != null) {
                            obj = com_tencent_mm_protocal_c_acy.wlu;
                            if (cVar.hRB != null) {
                                com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                                if (com_tencent_mm_protocal_c_acy != null) {
                                    str3 = com_tencent_mm_protocal_c_acy.vNd;
                                    if (cVar.hRB != null) {
                                        com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                                        if (com_tencent_mm_protocal_c_acy != null) {
                                            str2 = com_tencent_mm_protocal_c_acy.wlv;
                                        }
                                    }
                                    if (!bh.ov(str2)) {
                                        this.pnP = str2;
                                        ar.Hg();
                                        com.tencent.mm.z.c.CU().set(77, str2);
                                    }
                                    this.pnQ = str3;
                                    ar.Hg();
                                    com.tencent.mm.z.c.CU().set(78, str3);
                                    if (!this.pnO) {
                                        bkc();
                                    }
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                                    return;
                                }
                            }
                            str3 = null;
                            if (cVar.hRB != null) {
                                com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                                if (com_tencent_mm_protocal_c_acy != null) {
                                    str2 = com_tencent_mm_protocal_c_acy.wlv;
                                }
                            }
                            if (bh.ov(str2)) {
                                this.pnP = str2;
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(77, str2);
                            }
                            this.pnQ = str3;
                            ar.Hg();
                            com.tencent.mm.z.c.CU().set(78, str3);
                            if (this.pnO) {
                                bkc();
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                            return;
                        }
                    }
                    String str4 = null;
                    if (cVar.hRB != null) {
                        com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                        if (com_tencent_mm_protocal_c_acy != null) {
                            str3 = com_tencent_mm_protocal_c_acy.vNd;
                            if (cVar.hRB != null) {
                                com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                                if (com_tencent_mm_protocal_c_acy != null) {
                                    str2 = com_tencent_mm_protocal_c_acy.wlv;
                                }
                            }
                            if (bh.ov(str2)) {
                                this.pnP = str2;
                                ar.Hg();
                                com.tencent.mm.z.c.CU().set(77, str2);
                            }
                            this.pnQ = str3;
                            ar.Hg();
                            com.tencent.mm.z.c.CU().set(78, str3);
                            if (this.pnO) {
                                bkc();
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                            return;
                        }
                    }
                    str3 = null;
                    if (cVar.hRB != null) {
                        com_tencent_mm_protocal_c_acy = (acy) cVar.hRB.hmh.hmo;
                        if (com_tencent_mm_protocal_c_acy != null) {
                            str2 = com_tencent_mm_protocal_c_acy.wlv;
                        }
                    }
                    if (bh.ov(str2)) {
                        this.pnP = str2;
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(77, str2);
                    }
                    this.pnQ = str3;
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(78, str3);
                    if (this.pnO) {
                        bkc();
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
