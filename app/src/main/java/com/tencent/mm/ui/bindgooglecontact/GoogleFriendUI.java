package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ap.b;
import com.tencent.mm.ap.c;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, a, e, a.a {
    private boolean Mu = false;
    private HashMap<String, o> hzi = new HashMap();
    private String hzj;
    private int jxi;
    private ProgressDialog ltM;
    private String nPC;
    private TextView ntC;
    private String ykJ;
    private ListView ykR;
    private a ykS;
    private c ykT;
    private ArrayList<o> ykU = new ArrayList();
    private boolean ykp = false;
    private String ykr;

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, a aVar, ArrayList arrayList) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] success:%s", aVar);
        if (aVar == a.ykY && !googleFriendUI.Mu) {
            googleFriendUI.ykT = new c(arrayList, googleFriendUI.jxi, googleFriendUI.hzi, googleFriendUI.hzj);
            ar.CG().a(googleFriendUI.ykT, 0);
        } else if (aVar == a.ykZ) {
            googleFriendUI.alp();
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "Google Contact is Empty.");
            googleFriendUI.mz(true);
        } else if (aVar == a.yla) {
            googleFriendUI.alp();
            if (an.isConnected(googleFriendUI)) {
                x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI No Login or network unavaile.");
                googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
                googleFriendUI.finish();
                return;
            }
            googleFriendUI.mz(false);
        } else if (!googleFriendUI.Mu) {
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI unknow error");
            googleFriendUI.alp();
            googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
            googleFriendUI.finish();
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, boolean z, String str) {
        if (!z || TextUtils.isEmpty(str)) {
            googleFriendUI.alp();
            googleFriendUI.mz(false);
            return;
        }
        googleFriendUI.hzj = str;
        ar.Hg();
        com.tencent.mm.z.c.CU().set(208902, str);
        googleFriendUI.cqy();
    }

    protected final int getLayoutId() {
        return R.i.dls;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        this.ykr = (String) com.tencent.mm.z.c.CU().get(208903, null);
        if (TextUtils.isEmpty(this.ykr)) {
            finish();
        }
        this.jxi = getIntent().getIntExtra("enter_scene", 0);
        this.ykS = new a(this, this.ykr);
        this.ykS.ykK = this;
        initView();
        this.ykp = n.bj(this);
        if (this.ykp) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
        } else {
            cqx();
        }
        af.OL().clear();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(488, (e) this);
        ar.CG().a(489, (e) this);
        com.tencent.mm.ad.n.Jz().d(this);
        if (this.ykS != null) {
            this.ykS.Xy();
        }
    }

    protected void onStop() {
        super.onStop();
        ar.CG().b(488, (e) this);
        ar.CG().b(489, (e) this);
        com.tencent.mm.ad.n.Jz().e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        af.OL().clear();
    }

    protected final void initView() {
        setMMTitle(R.l.eno);
        setBackBtn(new 1(this));
        this.ntC = (TextView) findViewById(R.h.empty);
        this.ykR = (ListView) findViewById(R.h.cnx);
        this.ykR.setAdapter(this.ykS);
        this.ykR.setOnItemClickListener(this);
        p pVar = new p(true, true);
        pVar.zms = new 2(this);
        a(pVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", Integer.valueOf(i));
        if (this.ykS != null) {
            o oVar = (o) this.ykS.getItem(i - this.ykR.getHeaderViewsCount());
            if (oVar != null) {
                String str = oVar.field_username;
                x.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", oVar.field_googlegmail, str);
                ar.Hg();
                com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
                Intent intent;
                if ((WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) && TextUtils.isEmpty(oVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", oVar.field_googlegmail);
                    intent.putExtra("friend_nick", oVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", oVar.field_nickname);
                    intent.putExtra("friend_googleID", oVar.field_googleid);
                    intent.putExtra("friend_googleItemID", oVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Nick", oVar.field_nickname);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("verify_gmail", oVar.field_googlegmail);
                intent.putExtra("profileName", oVar.field_googlename);
                intent.putExtra("Contact_Source_FMessage", 58);
                intent.putExtra("Contact_Scene", 58);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.c.a.ifs.d(intent, this.mController.xIM);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            return;
        }
        if (i2 == -1) {
            this.ykp = intent.getBooleanExtra("gpservices", false);
            cqx();
            return;
        }
        this.ykp = intent.getBooleanExtra("gpservices", false);
        finish();
    }

    private void cqx() {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        if (this.ykp) {
            ar.Hg();
            this.hzj = (String) com.tencent.mm.z.c.CU().get(208901, null);
        } else {
            ar.Hg();
            this.hzj = (String) com.tencent.mm.z.c.CU().get(208902, null);
            ar.Hg();
            this.ykJ = (String) com.tencent.mm.z.c.CU().get(208904, null);
        }
        if (TextUtils.isEmpty(this.hzj) || (!this.ykp && TextUtils.isEmpty(this.ykJ))) {
            G(BindGoogleContactUI.class);
            finish();
        } else if (this.ykp) {
            cqy();
        } else {
            aCw();
            new c(this, this.ykJ).execute(new Void[0]);
        }
    }

    public final void Fj(int i) {
        if (this.ykS != null) {
            o oVar = (o) this.ykS.getItem(i);
            if (oVar != null) {
                switch (oVar.field_status) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                            final /* synthetic */ GoogleFriendUI ykV;

                            {
                                this.ykV = r1;
                            }

                            public final void a(boolean z, boolean z2, String str, String str2) {
                                x.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", Boolean.valueOf(z), Boolean.valueOf(z2));
                                if (z || z2) {
                                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", str2);
                                    af.OL().M(str2, 1);
                                } else {
                                    af.OL().M(str2, 2);
                                }
                                this.ykV.ykS.Xy();
                            }
                        });
                        String str = oVar.field_googleitemid;
                        aVar.vmV = false;
                        aVar.vmU = true;
                        aVar.vmW = str;
                        aVar.vmV = false;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(58));
                        aVar.b(oVar.field_username, linkedList, true);
                        oVar.field_googlecgistatus = 0;
                        af.OL().b(oVar);
                        this.ykS.Xy();
                        return;
                    case 1:
                        Cursor kZ = af.OL().kZ(oVar.field_googleid);
                        if (kZ == null || kZ.getCount() <= 1) {
                            a(oVar, null);
                        } else {
                            a(kZ, oVar);
                        }
                        if (kZ != null) {
                            kZ.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        x.i(str2, str3, objArr);
        int type = kVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        h.b(this, getString(R.l.dUz), "", true);
                    } else if ((i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) && !bh.ov(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.ykS != null) {
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.o) kVar).hzc);
                        af.OL().M(r0, 2);
                        this.ykS.Xy();
                        break;
                    }
                    break;
                case 488:
                    mz(false);
                    break;
                case 489:
                    if (this.ykS != null) {
                        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((b) kVar).Pa().ksO));
                        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.hzc);
                        af.OL().M(r0, 1);
                        this.ykS.Xy();
                        break;
                    }
                    break;
                default:
                    x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.ykS != null) {
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", ((com.tencent.mm.pluginsdk.model.o) kVar).hzc);
                    af.OL().M(r0, 1);
                    this.ykS.Xy();
                    break;
                }
                break;
            case 488:
                a(((c) kVar).Pb());
                break;
            case 489:
                if (this.ykS != null) {
                    x.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", Integer.valueOf(((b) kVar).Pa().ksO));
                    x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", r11.hzc);
                    af.OL().M(r0, 1);
                    this.ykS.Xy();
                    break;
                }
                break;
            default:
                x.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        alp();
    }

    public final void jh(String str) {
        if (this.ykS != null) {
            this.ykS.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(Cursor cursor, o oVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar2 = new o();
                oVar2.b(cursor);
                arrayList.add(oVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.mController.xIM;
        String string = getResources().getString(R.l.env);
        getResources().getString(R.l.dEn);
        h.a(context, string, arrayList, arrayList2, new 4(this, arrayList3, oVar));
    }

    private void a(o oVar, o oVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar.field_googlegmail);
        k bVar = new b(arrayList);
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", oVar.field_googleitemid);
        ar.CG().a(bVar, 0);
        if (oVar2 == null) {
            bVar.hzc = oVar.field_googleitemid;
            oVar.field_googlecgistatus = 0;
            af.OL().b(oVar);
        } else {
            bVar.hzc = oVar2.field_googleitemid;
            oVar2.field_googlecgistatus = 0;
            af.OL().b(oVar2);
        }
        this.ykS.Xy();
    }

    private void cqy() {
        this.Mu = false;
        aCw();
        new b(this, this, this.hzj, (byte) 0).execute(new Void[0]);
    }

    private synchronized void a(aot com_tencent_mm_protocal_c_aot) {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(com_tencent_mm_protocal_c_aot.ksO));
        if (this.ykS != null) {
            this.ykS.Xy();
        }
    }

    private void mz(boolean z) {
        CharSequence string;
        this.ntC.setVisibility(0);
        if (!an.isConnected(this)) {
            string = getString(R.l.enu);
        } else if (z) {
            string = getString(R.l.enn);
        } else {
            string = getString(R.l.enm);
        }
        this.ntC.setText(string);
    }

    private void aCw() {
        if (this.ltM == null || !this.ltM.isShowing()) {
            getString(R.l.dGO);
            this.ltM = h.a(this, getString(R.l.dHc), true, new 5(this));
        }
    }

    private void alp() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }
}
