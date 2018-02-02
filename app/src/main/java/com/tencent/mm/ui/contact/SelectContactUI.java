package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.b.af;
import com.tencent.mm.k.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class SelectContactUI extends MMBaseSelectContactUI implements e {
    private String chatroomName;
    private HashSet<String> iiv;
    private ProgressDialog iln;
    private TextView jCQ;
    private String kLv;
    private List<String> kiU;
    private int ldq;
    private String title;
    private int yQm;
    private TextView yUg;
    private TextView yUh;
    private TextView yUi;
    private TextView yUj;
    private HashSet<String> yUk;
    private boolean yUl;
    private boolean yUm;
    private String yUn;
    private String yUo;
    private boolean yUp;
    private jv yUq;
    private boolean yUr;
    private boolean yUs = true;
    private boolean yUt = false;
    private String yUu;
    private AlphaAnimation yUv;
    private AlphaAnimation yUw;
    private boolean yUx = false;
    private b yze = new 6(this);

    static /* synthetic */ void a(SelectContactUI selectContactUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new q(selectContactUI, new 8(selectContactUI)).g(linkedList, linkedList2);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ac.getContext().getString(R.l.dQz);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bh.d(ar(arrayList), string)};
        h.a((Context) selectContactUI, selectContactUI.getString(R.l.eiO, objArr), selectContactUI.getString(R.l.esI), selectContactUI.getString(R.l.eiN), selectContactUI.getString(R.l.eiM), true, new 7(selectContactUI, linkedList), null);
    }

    static /* synthetic */ void d(SelectContactUI selectContactUI) {
        List nd = selectContactUI.nd(false);
        nd.remove(com.tencent.mm.z.q.FS());
        if (nd.size() == 1) {
            selectContactUI.finish();
            selectContactUI.a(ChattingUI.class, new Intent().putExtra("Chat_User", (String) nd.get(0)));
            return;
        }
        selectContactUI.yUq = new jv();
        selectContactUI.yUq.fAK.fAM = "";
        selectContactUI.yUq.fAK.fAN = nd;
        a.xef.m(selectContactUI.yUq);
        selectContactUI.getString(R.l.dGO);
        selectContactUI.iln = h.a((Context) selectContactUI, selectContactUI.getString(R.l.esJ), true, new 4(selectContactUI));
    }

    protected final void WT() {
        super.WT();
        this.ldq = getIntent().getIntExtra("list_attr", s.yTD);
        this.title = getIntent().getStringExtra("titile");
        this.kLv = getIntent().getStringExtra("sub_title");
        this.yQm = getIntent().getIntExtra("list_type", -1);
        this.yUs = getIntent().getBooleanExtra("show_too_many_member", true);
        if (s.fa(this.ldq, 256) && s.GD().size() == 0) {
            s.fb(this.ldq, 256);
        }
        this.yUl = getIntent().getBooleanExtra("Add_SendCard", false);
        this.yUm = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.yUl || this.yUm) {
            this.yUn = bh.az(getIntent().getStringExtra("be_send_card_name"), "");
            this.yUo = bh.az(getIntent().getStringExtra("received_card_name"), "");
        }
        this.kiU = new ArrayList();
        this.iiv = new HashSet();
        this.yUk = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bh.ov(stringExtra)) {
            this.yUk.addAll(bh.F(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiv.addAll(bh.F(stringExtra.split(",")));
        }
        Collection hashSet = new HashSet();
        String stringExtra2 = getIntent().getStringExtra("block_contact");
        if (!bh.ov(stringExtra2)) {
            hashSet.addAll(bh.F(stringExtra2.split(",")));
        }
        Collection hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(s.cwj());
        hashSet2.addAll(s.cwk());
        if (this.yUl) {
            hashSet2.removeAll(s.cwj());
        }
        this.kiU.addAll(hashSet2);
        cwl();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(30, this);
        ar.CG().a(138, this);
        b.a(jv.class.getName(), this.yze);
        x.i("MicroMsg.SelectContactUI", "create!");
        if (!bh.ov(this.kLv)) {
            setMMSubTitle(this.kLv);
        }
        if (s.fa(this.ldq, 64)) {
            a(1, getString(R.l.dFU), new 17(this), p.b.xJz);
        }
        WZ();
        setBackBtn(new 1(this));
        if (this.yQm != 15) {
            Iterator it = this.iiv.iterator();
            while (it.hasNext()) {
                this.ooa.ba((String) it.next(), false);
            }
        }
    }

    protected void onDestroy() {
        ar.CG().b(30, this);
        ar.CG().b(138, this);
        b.b(jv.class.getName(), this.yze);
        super.onDestroy();
    }

    public final void ja(int i) {
        int headerViewsCount = i - this.prJ.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            x.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[]{Integer.valueOf(headerViewsCount), Integer.valueOf(i)});
            return;
        }
        com.tencent.mm.ui.contact.a.a Gm = cvZ().Gm(headerViewsCount);
        if (Gm == null) {
            return;
        }
        if (Gm instanceof j) {
            if (s.fa(this.ldq, 16384)) {
                x.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                String str = "";
                intent.putExtra("Select_Contact", str);
                intent.putExtra("Select_Conv_User", str);
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            }
        } else if (Gm.jLe != null && Gm.jLe.field_deleteFlag != 1) {
            String str2 = Gm.jLe.field_username;
            x.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[]{str2});
            if (s.fa(this.ldq, 64)) {
                if (!s.fa(this.ldq, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.iiv.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    ZC(str2);
                } else if (!this.yUk.contains(str2)) {
                    cwf();
                    if (this.iiv.contains(str2)) {
                        this.ooa.Sg(str2);
                        this.iiv.remove(str2);
                    } else {
                        str2 = getIntent().getStringExtra("too_many_member_tip_string");
                        if (bh.ov(str2)) {
                            str2 = getString(R.l.eJi, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        h.a(this.mController.xIM, str2, getString(R.l.dGt), new 5(this));
                    }
                }
                WZ();
                cwl();
                cwa().notifyDataSetChanged();
                return;
            }
            du(bh.F(new String[]{str2}));
        }
    }

    private void cwl() {
        if (!this.yUs) {
            return;
        }
        if (this.yQm == 1 || this.yQm == 0) {
            int size;
            int size2 = this.yUk != null ? this.yUk.size() : 0;
            if (this.iiv != null) {
                size = this.iiv.size();
            } else {
                size = 0;
            }
            size2 += size;
            size = bh.VI(g.zY().getValue("ChatRoomInviteStartCount"));
            if (size > 0 && size2 == size + 1 && !this.yUx) {
                if (this.jCQ == null) {
                    this.jCQ = (TextView) findViewById(R.h.cKL);
                }
                if (this.jCQ.getVisibility() != 0) {
                    this.jCQ.setText(R.l.eEK);
                    this.jCQ.setOnClickListener(new 9(this));
                    if (this.yUv == null) {
                        this.yUv = new AlphaAnimation(0.0f, 1.0f);
                    }
                    this.yUv.setDuration(300);
                    if (this.yUw != null) {
                        this.yUw.cancel();
                    }
                    this.jCQ.setVisibility(0);
                    this.jCQ.startAnimation(this.yUv);
                }
            } else if (size2 < size) {
                cwm();
                this.yUx = false;
            }
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return true;
    }

    protected final String WW() {
        return this.title;
    }

    protected final o WX() {
        boolean z;
        boolean z2 = false;
        c$a com_tencent_mm_ui_contact_c_a = new c$a();
        com_tencent_mm_ui_contact_c_a.yQX = s.fa(this.ldq, 16);
        com_tencent_mm_ui_contact_c_a.yQW = s.fa(this.ldq, 32);
        com_tencent_mm_ui_contact_c_a.yQY = !s.fa(this.ldq, 4);
        if (s.fa(this.ldq, 1)) {
            z = false;
        } else {
            z = true;
        }
        com_tencent_mm_ui_contact_c_a.yQZ = z;
        com_tencent_mm_ui_contact_c_a.yRa = s.fa(this.ldq, FileUtils.S_IWUSR);
        com_tencent_mm_ui_contact_c_a.yRb = s.fa(this.ldq, 1048576);
        if (com_tencent_mm_ui_contact_c_a.yRa) {
            this.yUt = true;
            com_tencent_mm_ui_contact_c_a.yRc = getIntent().getStringExtra("wechat_sport_contact");
            com_tencent_mm_ui_contact_c_a.yRd = getIntent().getStringExtra("wechat_sport_recent_like");
            this.yUu = com_tencent_mm_ui_contact_c_a.yRc;
        }
        List list = this.kiU;
        boolean fa = s.fa(this.ldq, 1);
        boolean fa2 = s.fa(this.ldq, 64);
        if (this.yQm == 15) {
            z2 = true;
        }
        return new c(this, list, fa, fa2, com_tencent_mm_ui_contact_c_a, z2);
    }

    protected final m WY() {
        if (this.yUt) {
            return new r(this, this.kiU, s.fa(this.ldq, 64), this.yUu);
        }
        return new q(this, this.kiU, s.fa(this.ldq, 64), this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (s.fa(this.ldq, 256)) {
            if (this.yUg == null) {
                String string;
                OnClickListener anonymousClass11 = new OnClickListener(this) {
                    final /* synthetic */ SelectContactUI yUy;

                    {
                        this.yUy = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClassName(this.yUy, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", true);
                        boolean fa = s.fa(this.yUy.ldq, 16384);
                        intent.putExtra("group_select_need_result", fa);
                        if (!fa) {
                            this.yUy.startActivity(intent);
                        } else if (this.yUy.yQm == 14) {
                            intent.putExtra("group_multi_select", true);
                            intent.putExtra("already_select_contact", t.d(this.yUy.nc(true), ","));
                            intent.putExtra("max_limit_num", this.yUy.getIntent().getIntExtra("max_limit_num", 9));
                            this.yUy.startActivityForResult(intent, 4);
                        } else {
                            this.yUy.startActivityForResult(intent, 0);
                        }
                    }
                };
                if (this.yQm == 14) {
                    string = getString(R.l.dDh);
                } else {
                    string = getString(R.l.dCW);
                }
                this.yUg = a(listView, anonymousClass11, string);
            }
            this.yUg.setVisibility(i);
        }
        if (s.fa(this.ldq, WXMediaMessage.TITLE_LENGTH_LIMIT)) {
            if (this.yUh == null) {
                this.yUh = a(listView, new 12(this), getString(R.l.ehw));
            }
            this.yUh.setVisibility(i);
        }
        if (s.fa(this.ldq, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.yUi == null) {
                this.yUi = a(listView, new OnClickListener(this) {
                    final /* synthetic */ SelectContactUI yUy;

                    {
                        this.yUy = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClassName(this.yUy, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", false);
                        this.yUy.startActivityForResult(intent, 1);
                    }
                }, getString(R.l.dCX));
            }
            this.yUi.setVisibility(i);
        }
        if (s.fa(this.ldq, 2048)) {
            if (this.yUj == null) {
                this.yUj = a(listView, new OnClickListener(this) {
                    final /* synthetic */ SelectContactUI yUy;

                    {
                        this.yUy = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        d.b(this.yUy, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                    }
                }, getString(R.l.dDe));
            }
            this.yUj.setVisibility(i);
            this.yUj.setTextSize(16.0f * com.tencent.mm.bv.a.eu(this.yUj.getContext()));
        }
        if (s.fa(this.ldq, 2048)) {
            if (this.yUj != null) {
                this.yUj.setBackgroundResource(R.g.bBy);
            }
        } else if (s.fa(this.ldq, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            if (this.yUi != null) {
                this.yUi.setBackgroundResource(R.g.bBy);
            }
        } else if (s.fa(this.ldq, WXMediaMessage.TITLE_LENGTH_LIMIT)) {
            if (this.yUh != null) {
                this.yUh.setBackgroundResource(R.g.bBy);
            }
        } else if (s.fa(this.ldq, 256) && this.yUg != null) {
            this.yUg.setBackgroundResource(R.g.bBy);
        }
    }

    private TextView a(ListView listView, OnClickListener onClickListener, String str) {
        View inflate = v.fv(this).inflate(R.i.dlx, null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.h.bYS);
        textView.setText(str);
        listView.addHeaderView(inflate);
        return textView;
    }

    private boolean du(final List<String> list) {
        x.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[]{list});
        if (!s.fa(this.ldq, 65536)) {
            return dv(list);
        }
        String string;
        if (list != null) {
            if (list.size() == 1) {
                string = getString(R.l.eJg, new Object[]{r.gu((String) list.get(0))});
            } else if (list.size() > 1) {
                String string2 = getString(R.l.dGC);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 3) {
                        stringBuilder.append("...");
                        break;
                    }
                    stringBuilder.append(r.gu((String) list.get(i)));
                    if (i < list.size() - 1) {
                        stringBuilder.append(string2);
                    }
                }
                string = getString(R.l.eJg, new Object[]{stringBuilder.toString()});
            }
            this.yUr = true;
            h.a(this.mController.xIM, string, null, true, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SelectContactUI yUy;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.yUy.yUr = this.yUy.dv(list);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SelectContactUI yUy;

                {
                    this.yUy = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.yUy.yUr = false;
                }
            });
            return this.yUr;
        }
        string = null;
        this.yUr = true;
        h.a(this.mController.xIM, string, null, true, /* anonymous class already generated */, /* anonymous class already generated */);
        return this.yUr;
    }

    private boolean dv(List<String> list) {
        boolean endsWith;
        Intent intent;
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (bh.ov(this.yUn)) {
                this.yUn = bh.d(list, ",");
            } else if (bh.ov(this.yUo)) {
                this.yUo = bh.d(list, ",");
            } else {
                x.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[]{this.yUn, this.yUo});
                return false;
            }
            endsWith = this.yUo.endsWith("@chatroom");
            intent = new Intent();
            intent.putExtra("be_send_card_name", this.yUn);
            intent.putExtra("received_card_name", this.yUo);
            intent.putExtra("Is_Chatroom", endsWith);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            x.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[]{list.toString()});
            ArrayList nc = nc(false);
            nc.remove(com.tencent.mm.z.q.FS());
            boolean z = false;
            for (String str : list) {
                if (!bh.ov(str)) {
                    if (!(nc.contains(str) || com.tencent.mm.z.q.FS().equals(str))) {
                        ar.Hg();
                        af WO = c.EY().WO(str);
                        if (!(WO == null || ((int) WO.gJd) == 0 || !com.tencent.mm.l.a.fZ(WO.field_type))) {
                            ZC(str);
                            nc.add(str);
                            endsWith = true;
                            z = endsWith;
                        }
                    }
                }
                endsWith = z;
                z = endsWith;
            }
            if (z) {
                WZ();
                cvZ().notifyDataSetChanged();
            } else {
                List nc2 = nc(false);
                nc2.remove(com.tencent.mm.z.q.FS());
                String d = bh.d(nc2, ",");
                if (bh.cA(nc2)) {
                    r0 = new Intent();
                    r0.putExtra("Select_Contact", d);
                    r0.putExtra("Select_Conv_User", d);
                    r0.putExtra("Select_Contact", d);
                    r0.putExtra("Select_Contacts_To_Create_New_Label", d);
                    setResult(0, r0);
                    finish();
                } else {
                    h.a(this.mController.xIM, true, getString(R.l.esH), "", getString(R.l.esG), getString(R.l.esF), new 2(this, d), new 3(this, d));
                }
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            x.i("MicroMsg.SelectContactUI", "Recommend Friends");
            v.a(this.mController.xIM, this.yUo, list);
        } else if (s.fa(this.ldq, 16384)) {
            x.i("MicroMsg.SelectContactUI", "return the result");
            r0 = new Intent();
            String d2 = bh.d(list, ",");
            r0.putExtra("Select_Contact", d2);
            r0.putExtra("Select_Conv_User", d2);
            r0.putExtra("Select_Contact", d2);
            setResult(-1, r0);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            x.i("MicroMsg.SelectContactUI", "Share Image");
            ArrayList nc3 = nc(true);
            nc3.remove(com.tencent.mm.z.q.FS());
            if (nc3.size() > 0) {
                this.iln = h.a(this.mController.xIM, getString(R.l.euA), false, null);
                ar.Dm().F(new 18(this, nc3));
            }
        } else if (list.size() > 0) {
            x.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[]{list.toString()});
            finish();
            intent = new Intent();
            intent.setClass(this, ChattingUI.class);
            intent.putExtra("Chat_User", (String) list.get(0));
            intent.addFlags(67108864);
            startActivity(intent);
        } else {
            x.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[]{list.toString()});
        }
        return true;
    }

    private void WZ() {
        if (!s.fa(this.ldq, 64) || this.iiv.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.dFU));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.dFU) + "(" + this.iiv.size() + ")");
        int intExtra = getIntent().getIntExtra("min_limit_num", 0);
        if (!s.fa(this.ldq, 262144) || this.iiv.size() >= intExtra) {
            enableOptionMenu(1, true);
        } else {
            enableOptionMenu(1, false);
        }
    }

    private ArrayList<String> nc(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.iiv.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !s.gC(str)) {
                hashSet.add(str);
            } else {
                List<String> gk = m.gk(str);
                if (gk != null) {
                    for (String str2 : gk) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    private ArrayList<String> nd(boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = this.iiv.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z || !s.gC(str)) {
                hashSet.add(str);
            } else {
                List<String> gk = m.gk(str);
                if (gk != null) {
                    for (String str2 : gk) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.yUk);
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!bh.bF(this) || com.tencent.mm.ui.t.a.a(this, i, i2, str, 4)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    cvZ().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        } else if (i == 4 && i2 == -24 && !bh.ov(str)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (aVar.ySW && aVar.jLe != null) {
            return this.iiv.contains(aVar.jLe.field_username);
        }
        if (aVar.ySX && aVar.jLe != null) {
            return this.iiv.contains(aVar.jLe.field_username);
        }
        if (aVar instanceof j) {
            return this.iiv.isEmpty();
        }
        return false;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.yUk.contains(aVar.jLe.field_username);
    }

    public final int[] aXV() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        if (!s.fa(this.ldq, 1)) {
            arrayList.add(Integer.valueOf(131076));
        }
        if (!s.fa(this.ldq, 4)) {
            arrayList.add(Integer.valueOf(131075));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public final void oE(String str) {
        this.iiv.remove(str);
        cvZ().notifyDataSetChanged();
        WZ();
    }

    private void ZC(String str) {
        if (!this.yUk.contains(str)) {
            cwf();
            this.ooa.Sg(str);
            if (this.iiv.contains(str)) {
                this.iiv.remove(str);
            } else {
                this.iiv.add(str);
            }
        }
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
            com.tencent.mm.l.a WO = c.EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 0:
                    if (!bh.ov(intent.getStringExtra("Select_Conv_User"))) {
                        du(bh.F(new String[]{intent.getStringExtra("Select_Conv_User")}));
                        return;
                    }
                    return;
                case 1:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (!bh.ov(stringExtra)) {
                        du(bh.F(stringExtra.split(",")));
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        if (!bh.ov(intent.getStringExtra("Select_Contact"))) {
                            du(bh.F(new String[]{intent.getStringExtra("Select_Contact")}));
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (bh.ov(stringExtra)) {
                        x.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    if (s.fa(this.ldq, 64)) {
                        for (String str : stringExtra.split(",")) {
                            if (this.iiv.add(str)) {
                                this.ooa.Sg(str);
                            }
                        }
                        WZ();
                        cvZ().notifyDataSetChanged();
                        return;
                    }
                    du(bh.F(new String[]{stringExtra}));
                    return;
                case 4:
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    Iterator it = this.iiv.iterator();
                    while (it.hasNext()) {
                        this.ooa.Sh((String) it.next());
                    }
                    this.iiv.clear();
                    if (!bh.ov(stringExtra2)) {
                        this.iiv.addAll(bh.F(stringExtra2.split(",")));
                    }
                    Iterator it2 = this.iiv.iterator();
                    while (it2.hasNext()) {
                        this.ooa.ba((String) it2.next(), false);
                    }
                    WZ();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean aZc() {
        if (this.yUt) {
            return false;
        }
        return true;
    }

    protected final void En(String str) {
        com.tencent.mm.plugin.report.service.g.pQN.h(11225, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(nc(s.fa(this.ldq, 8192)));
        hashSet.addAll(this.yUk);
        intent.putExtra("always_select_contact", bh.d(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", bh.d(new ArrayList(hashSet), ","));
        if (s.fa(this.ldq, 64)) {
            intent.putExtra("list_attr", s.p(new int[]{16384, 64, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT}));
            if (this.yQm == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
    }

    private void cwm() {
        if (this.jCQ == null) {
            this.jCQ = (TextView) findViewById(R.h.cKL);
        }
        if (this.jCQ.getVisibility() != 8) {
            if (this.yUw == null) {
                this.yUw = new AlphaAnimation(1.0f, 0.0f);
                this.yUw.setAnimationListener(new 10(this));
            }
            this.yUw.setDuration(300);
            if (this.yUv != null) {
                this.yUv.cancel();
            }
            this.jCQ.startAnimation(this.yUw);
        }
    }
}
