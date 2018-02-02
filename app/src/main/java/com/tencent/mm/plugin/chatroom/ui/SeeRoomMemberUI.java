package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.l;
import com.tencent.mm.z.m;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements e {
    private static int ldd = 5;
    private boolean fzz;
    private r jmO;
    private boolean kZA;
    private q kZS;
    private String lbf;
    private String lbu;
    private int lbv;
    private String lbw;
    private boolean lbx;
    private GridView lcP;
    private b lcW;
    private String lcX;
    private String lcY;
    private p lcZ;
    private String lda;
    private MMEditText ldb;
    private int ldc;
    private String mTitle;
    private String talker;
    private String username;
    private int wn;

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, int i) {
        if (seeRoomMemberUI.lcW.og(i).type == 1) {
            String str = seeRoomMemberUI.lcW.og(i).jLe.field_username;
            x.d("MicroMsg.SeeRoomMemberUI", "roomPref del " + i + " userName : " + str);
            ar.Hg();
            if (bh.az((String) c.CU().get(2, null), "").equals(str)) {
                h.h(seeRoomMemberUI.mController.xIM, R.l.eFp, R.l.dGO);
            } else {
                seeRoomMemberUI.xe(str);
            }
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, Context context) {
        if (context != null && axD()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", seeRoomMemberUI.getString(R.l.dQv, new Object[]{w.cfi()}));
            intent.putExtra("geta8key_username", com.tencent.mm.z.q.FS());
            intent.putExtra("showShare", false);
            d.b(seeRoomMemberUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, String str, String str2, String str3) {
        if (bh.ov(str2)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(str);
            if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                str2 = EZ.field_conRemark;
            }
        }
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomMemberUI.fzz && seeRoomMemberUI.kZS != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomMemberUI.kZS.gu(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomMemberUI.lbu);
            ar.Hg();
            af WO = c.EY().WO(str);
            if (WO != null && ((int) WO.gJd) > 0 && a.fZ(WO.field_type)) {
                b oxVar = new ox();
                oxVar.fGO.intent = intent;
                oxVar.fGO.username = str;
                com.tencent.mm.sdk.b.a.xef.m(oxVar);
            }
            if (seeRoomMemberUI.fzz) {
                if (WO != null && WO.cia()) {
                    g.pQN.k(10298, WO.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (seeRoomMemberUI.kZA) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.z.q.gr(WO.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Is_RoomOwner", seeRoomMemberUI.lbx);
            intent.putExtra("Contact_ChatRoomId", seeRoomMemberUI.lbf);
            com.tencent.mm.plugin.chatroom.a.ifs.d(intent, seeRoomMemberUI);
        }
    }

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        String d = bh.d(m.gj(seeRoomMemberUI.lbf), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.l.dDo));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.yTE);
        intent.putExtra("always_select_contact", d);
        intent.putExtra("scene", 4);
        d.a(seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        g.pQN.a(219, 8, 1, true);
        List gj = m.gj(seeRoomMemberUI.lbf);
        String d = bh.d(gj, ",");
        int size = gj.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.lbf);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", d);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.lbx);
        intent.putExtra("list_attr", s.yTE);
        intent.putExtra("room_name", seeRoomMemberUI.lbf);
        intent.putExtra("room_owner_name", seeRoomMemberUI.kZS.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelRoomMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pQN.a(219, 2, 1, true);
        ar.CG().a(990, this);
        ar.CG().a(179, this);
        ar.CG().a(120, this);
        ar.CG().a(610, this);
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.lcY = getIntent().getStringExtra("Chatroom_member_list");
        this.fzz = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.kZA = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.lbx = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lbw = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        ar.Hg();
        this.kZS = c.Fh().hD(this.talker == null ? this.lbf : this.talker);
        this.lbv = getIntent().getIntExtra("room_member_count", 0);
        this.lbu = getIntent().getStringExtra("room_name");
        this.wn = getIntent().getIntExtra("offset", 0);
        this.ldc = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.lcW != null) {
            axV();
            this.lcP.setSelection(this.ldc * ldd < this.lcW.getCount() ? this.ldc * ldd : this.lcW.getCount() - 1);
            this.lcP.postDelayed(new 1(this), 100);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.lcW != null) {
            this.lcW.xg(this.ldb.getText().toString());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.lcP.setNumColumns(cq(this));
    }

    private static int cq(Context context) {
        if (context == null) {
            return 0;
        }
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.f.bvy) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.f.bvB) * 2.0f) + context.getResources().getDimension(R.f.bvD)))));
        x.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[]{Integer.valueOf(width)});
        ldd = width;
        return width;
    }

    protected final void initView() {
        setMMTitle(this.mTitle + "(" + this.lbv + ")");
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI lde;

            {
                this.lde = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lde.setResult(0);
                this.lde.finish();
                return true;
            }
        });
        this.ldb = (MMEditText) findViewById(R.h.cyt);
        this.lcP = (GridView) findViewById(R.h.bSJ);
        this.lcP.setNumColumns(cq(this));
        this.lcP.setColumnWidth(getResources().getDimensionPixelSize(R.f.bvy));
        q qVar = this.kZS;
        String str = this.lbf;
        List linkedList = new LinkedList();
        if (!bh.ov(this.lcX)) {
            linkedList = bh.F(this.lcX.split(","));
        }
        ar.Hg();
        bc EY = c.Fg().EY("@t.qq.com");
        if (EY != null) {
            linkedList.add(EY.name);
        }
        this.lcW = new b(this, this, qVar, str, linkedList, this.lbw);
        this.ldb.addTextChangedListener(new 6(this));
        this.lcP.setOnItemClickListener(new 7(this));
        this.lcP.setOnItemLongClickListener(new 8(this));
        this.lcP.setAdapter(this.lcW);
    }

    private void axV() {
        ar.Hg();
        this.kZS = c.Fh().hD(this.talker == null ? this.lbf : this.talker);
        List gj = m.gj(this.lbf);
        if (this.lcW != null) {
            this.lcW.at(gj);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    protected void onDestroy() {
        ar.CG().b(990, this);
        ar.CG().b(179, this);
        ar.CG().b(120, this);
        ar.CG().b(610, this);
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.drB;
    }

    private void xe(String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.lbf, linkedList);
            getString(R.l.dGO);
            this.jmO = h.a(this, getString(R.l.eEY), true, new 9(this, gVar));
            ar.CG().a(gVar, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA != null) {
            eA.a(this, null, null);
        } else if (i != 0 || i2 != 0) {
            if (kVar.getType() == 179 && i2 == -66) {
                h.b(this, getString(R.l.dYo), getString(R.l.dGO), true);
            }
            if (kVar.getType() == 120) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
            } else if (kVar.getType() == 610) {
                h.b(this, getString(R.l.epQ), getString(R.l.dGO), true);
            }
        } else if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 120:
                    a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                    axV();
                    break;
                case 179:
                    axV();
                    break;
                case 610:
                    h.b(this, getString(R.l.epR), null, true);
                    break;
            }
            if (this.kZS != null) {
                setMMTitle(this.mTitle + "(" + this.kZS.Ms().size() + ")");
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (!com.tencent.mm.z.s.gx(stringExtra)) {
                        h.b(this, getString(R.l.eFH), getString(R.l.dGO), true);
                        return;
                    } else if (xf(stringExtra)) {
                        h.b(this, getString(R.l.dCA), getString(R.l.dGO), true);
                        return;
                    } else if (bh.F(stringExtra.split(",")) != null) {
                        final String stringExtra2 = intent.getStringExtra("Select_Contact");
                        ar.Hg();
                        q hD = c.Fh().hD(this.lbf);
                        if (hD == null) {
                            return;
                        }
                        if (hD.chT() == 2) {
                            com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, getString(R.l.eEB), getString(R.l.eCm), getString(R.l.dGA), new o.a(this) {
                                final /* synthetic */ SeeRoomMemberUI lde;

                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        this.lde.n(stringExtra2, str, R.l.epZ);
                                    }
                                }
                            });
                            return;
                        } else {
                            n(stringExtra, null, R.l.dCE);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (intent != null) {
                    xe(intent.getStringExtra("Select_Contact"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void n(String str, String str2, int i) {
        if (!com.tencent.mm.z.s.gx(str)) {
            h.b(this, getString(R.l.eFH), getString(R.l.dGO), true);
        } else if (xf(str)) {
            h.b(this, getString(R.l.dCA), getString(R.l.dGO), true);
        } else {
            List F = bh.F(str.split(","));
            if (F != null) {
                final k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.lbf, F, str2);
                getString(R.l.dGO);
                this.jmO = h.a(this, getString(i), true, new OnCancelListener(this) {
                    final /* synthetic */ SeeRoomMemberUI lde;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().c(dVar);
                    }
                });
                ar.CG().a(dVar, 0);
            }
        }
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        Object obj = null;
        String str = "";
        String str2 = "";
        String string = ac.getContext().getString(R.l.dQz);
        final List list = dVar.kZl;
        final List list2 = dVar.kZn;
        final List list3 = dVar.fAT;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            ar.Hg();
            q hE = c.Fh().hE(this.lbf);
            if (i == -116 && axD() && !bh.ov(hE.field_roomowner)) {
                str = getString(R.l.eFE);
                str2 = getString(R.l.eFD);
                obj = 1;
            }
            if (i == -23) {
                str = getString(R.l.eFK);
                str2 = getString(R.l.eFJ);
            }
            if (i == -109) {
                str = getString(R.l.eFG);
                str2 = getString(R.l.eFF);
            }
            if (i == -122) {
                str = getString(R.l.eFK);
                int i2 = R.l.eFI;
                Object[] objArr = new Object[2];
                str2 = null;
                ar.Hg();
                af WO = c.EY().WO(this.kZS.field_roomowner);
                if (WO != null && ((int) WO.gJd) > 0) {
                    str2 = WO.field_conRemark;
                }
                if (bh.ov(str2)) {
                    str2 = this.kZS.field_roomowner;
                    if (this.kZS == null) {
                        str2 = null;
                    } else {
                        str2 = this.kZS.gu(str2);
                    }
                }
                if (bh.ov(str2) && WO != null && ((int) WO.gJd) > 0) {
                    str2 = WO.AP();
                }
                if (bh.ov(str2)) {
                    str2 = this.kZS.field_roomowner;
                }
                objArr[0] = str2;
                objArr[1] = Integer.valueOf(hE.chU());
                str2 = getString(i2, objArr);
            }
            list2 = dVar.kZm;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fzQ && (list2 == null || list2.size() <= 0 || dVar.fzQ != list3.size() + list2.size()))) {
                list2 = dVar.kZm;
                if (list2 != null && list2.size() > 0) {
                    str2 = str2 + getString(R.l.eiF, new Object[]{bh.d(ar(list2), string)});
                }
                list2 = dVar.fAS;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCy);
                    str2 = str2 + getString(R.l.eiP, new Object[]{bh.d(ar(list2), string)});
                }
                list2 = dVar.fAQ;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCy);
                    str2 = str2 + getString(R.l.eiI, new Object[]{bh.d(ar(list2), string)});
                }
                Collection collection = dVar.kZn;
                if (!(list3 == null || list3.isEmpty()) || (collection != null && collection.size() > 0)) {
                    List arrayList = new ArrayList();
                    arrayList.addAll(list3);
                    arrayList.addAll(collection);
                    d(dVar.chatroomName, list3);
                    str2 = str2 + getString(R.l.eit, new Object[]{bh.d(ar(arrayList), string)});
                    if (list3 != null && list3.isEmpty()) {
                        str2 = null;
                    }
                }
                if (str2 != null && str2.length() > 0) {
                    if (obj != null) {
                        h.a(this, str2, str, new 3(this), null);
                    } else {
                        h.b(this, str2, str, true);
                    }
                }
                hE.chT();
                return;
            }
            List linkedList = new LinkedList();
            for (int i3 = 0; i3 < list3.size(); i3++) {
                linkedList.add(list3.get(i3));
            }
            str2 = "";
            String string2 = ac.getContext().getString(R.l.dQz);
            if (!(list2 == null || list2.isEmpty())) {
                str2 = getString(R.l.eis, new Object[]{bh.d(ar(list2), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(R.l.eit, new Object[]{bh.d(ar(linkedList), string2)});
            }
            h.a(this, str2, "", getString(R.l.ein), new OnClickListener(this) {
                final /* synthetic */ SeeRoomMemberUI lde;

                {
                    this.lde = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.lde.axV();
                }
            });
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCz);
        String string3 = getString(R.l.epF);
        String string4 = getString(R.l.dEn);
        final com.tencent.mm.plugin.chatroom.d.d dVar2 = dVar;
        AnonymousClass12 anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI lde;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.lde.d(dVar2.chatroomName, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                k kVar = new com.tencent.mm.plugin.chatroom.d.k(this.lde.lbf, arrayList);
                ar.CG().a(kVar, 0);
                SeeRoomMemberUI seeRoomMemberUI = this.lde;
                Context context = this.lde;
                this.lde.getString(R.l.dGO);
                seeRoomMemberUI.jmO = h.a(context, this.lde.getString(R.l.eFy), true, new 1(this, kVar));
            }
        };
        h.a(this, string, null, string3, string4, anonymousClass12, new 2(this));
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            l.a(str, linkedList, getString(R.l.dQy), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private static boolean axD() {
        return bh.getInt(com.tencent.mm.k.g.zY().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private static List<String> ar(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ar.Hj()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ar.Hg();
            a WO = c.EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    private boolean xf(String str) {
        if (bh.ou(com.tencent.mm.z.q.FS()).equals(str)) {
            return true;
        }
        List<String> gj = m.gj(this.lbf);
        if (gj == null) {
            return false;
        }
        boolean z = false;
        for (String equals : gj) {
            boolean z2;
            if (equals.equals(str)) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return "";
        }
        return qVar.gu(str);
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        if (obj == null) {
            return null;
        }
        Method declaredMethod;
        Object invoke;
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (Throwable e32) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e32, "", new Object[0]);
                invoke = null;
            } catch (Throwable e322) {
                x.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e322, "", new Object[0]);
            }
            return invoke;
        }
        invoke = null;
        return invoke;
        cls = cls.getSuperclass();
    }
}
