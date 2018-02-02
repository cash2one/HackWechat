package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectMemberUI extends MMActivity implements e {
    private ListView Fv;
    private r jmO;
    private int kFm;
    private q kZS;
    private View kgd;
    private String lbf;
    private String lcX;
    private View ldC;
    SelectMemberScrollBar ldL;
    private b ldM;
    private boolean ldN;
    private boolean ldO;
    private MMEditText ldb;
    private String mTitle;

    public class b extends BaseAdapter {
        volatile boolean acS = false;
        List<a> fAN = new ArrayList();
        private q kZS;
        private String lbf;
        private c lcA;
        final /* synthetic */ SelectMemberUI ldP;
        public final String ldS = new String(Character.toChars(91));
        HashMap<String, Integer> ldT = new HashMap();
        public String ldh;
        String ldj = null;
        List<a> ldk = new ArrayList(0);
        private Context mContext;

        static /* synthetic */ void b(b bVar) {
            if (bVar.fAN != null) {
                Object obj = null;
                int i = 0;
                for (a aVar : bVar.fAN) {
                    String ol;
                    if (aVar.jLe != null) {
                        ol = com.tencent.mm.platformtools.c.ol(bVar.c(aVar.jLe));
                        ol = bh.ov(ol) ? "" : ol.startsWith(bVar.ldS) ? "#" : ol.toUpperCase().substring(0, 1);
                        if (i == 0) {
                            bVar.ldT.put(ol, Integer.valueOf(i));
                        } else if (!(obj == null || ol.equals(obj))) {
                            bVar.ldT.put(ol, Integer.valueOf(i));
                        }
                    } else {
                        ol = null;
                    }
                    i++;
                    String str = ol;
                }
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return oi(i);
        }

        public b(SelectMemberUI selectMemberUI, Context context, q qVar, String str, String str2) {
            this.ldP = selectMemberUI;
            this.kZS = qVar;
            this.lbf = str;
            this.ldj = str2;
            this.mContext = context;
            this.lcA = ar.Hg();
        }

        public final void xi(String str) {
            x.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            List arrayList = new ArrayList();
            if (bh.ov(str)) {
                this.fAN = this.ldk;
                return;
            }
            for (a aVar : this.ldk) {
                if (!(aVar == null || aVar.jLe == null || aVar.type != 1)) {
                    af afVar = aVar.jLe;
                    if (afVar.field_conRemark != null && afVar.field_conRemark.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!bh.ov(SeeRoomMemberUI.a(this.kZS, afVar.field_username)) && SeeRoomMemberUI.a(this.kZS, afVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.AP() != null && afVar.AP().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.vQ() != null && afVar.vQ().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.vN() != null && afVar.vN().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.field_username != null && afVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!a.fZ(afVar.field_type)) {
                        ar.Hg();
                        bf EZ = c.EZ().EZ(afVar.field_username);
                        if (!(EZ == null || EZ.field_conRemark == null || !EZ.field_conRemark.contains(str))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            this.fAN = arrayList;
        }

        public final int getCount() {
            if (this.fAN == null || this.acS) {
                return 0;
            }
            return this.fAN.size();
        }

        public final a oi(int i) {
            if (this.fAN.size() > i) {
                return (a) this.fAN.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.drG, null);
                c cVar2 = new c((byte) 0);
                cVar2.ldx = (MaskLayout) view.findViewById(R.h.cKZ);
                cVar2.kEZ = (TextView) view.findViewById(R.h.cLb);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.kEZ.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.ldy = (TextView) view.findViewById(R.h.cLa);
                cVar2.ldy.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            com.tencent.mm.storage.x xVar = oi(i).jLe;
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) cVar.ldx.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                cVar.ldx.cpQ();
            } else if (ak.a.hfN != null) {
                String gP = ak.a.hfN.gP(xVar.field_verifyFlag);
                if (gP != null) {
                    cVar.ldx.d(m.kf(gP), MaskLayout.a.yfa);
                } else {
                    cVar.ldx.cpQ();
                }
            } else {
                cVar.ldx.cpQ();
            }
            CharSequence c = c(xVar);
            CharSequence charSequence = "";
            if (a.fZ(xVar.field_type)) {
                charSequence = xVar.fWy;
            }
            if (bh.ov(charSequence)) {
                cVar.ldy.setVisibility(8);
                cVar.ldy.setText("");
            } else {
                cVar.ldy.setVisibility(0);
                cVar.ldy.setText(i.b(this.mContext, charSequence, cVar.ldy.getTextSize()));
            }
            cVar.kEZ.setText(i.b(this.mContext, c, cVar.kEZ.getTextSize()));
            return view;
        }

        private String c(com.tencent.mm.storage.x xVar) {
            String a;
            if (bh.ov(xVar.field_conRemark)) {
                a = SelectMemberUI.a(this.kZS, xVar.field_username);
            } else {
                a = xVar.field_conRemark;
            }
            if (bh.ov(a)) {
                a = xVar.AP();
            }
            if (a.fZ(xVar.field_type)) {
                return a;
            }
            ar.Hg();
            bf EZ = c.EZ().EZ(xVar.field_username);
            if (EZ == null || bh.ov(EZ.field_conRemark)) {
                return a;
            }
            return EZ.field_conRemark;
        }
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, int i) {
        a oi = selectMemberUI.ldM.oi(i);
        if (oi == null || oi.jLe == null) {
            x.e("MicroMsg.SelectMemberUI", "null == item || null == item.contact");
            return;
        }
        af afVar = oi.jLe;
        String str = afVar.field_username;
        String a = !bh.ov(afVar.field_conRemark) ? afVar.field_conRemark : a(selectMemberUI.kZS, afVar.field_username);
        if (bh.ov(a)) {
            a = afVar.AP();
        }
        if (!a.fZ(afVar.field_type)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(afVar.field_username);
            if (!(EZ == null || bh.ov(EZ.field_conRemark))) {
                a = EZ.field_conRemark;
            }
        }
        h.a(selectMemberUI, !selectMemberUI.ldN ? selectMemberUI.getString(R.l.eGj, new Object[]{a}) : selectMemberUI.getString(R.l.eFQ, new Object[]{a}), "", new 5(selectMemberUI, str), new OnClickListener(selectMemberUI) {
            final /* synthetic */ SelectMemberUI ldP;

            {
                this.ldP = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, String str) {
        selectMemberUI.aWs();
        Intent intent = new Intent(selectMemberUI, SelectMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", selectMemberUI.lbf);
        intent.putExtra("room_member", str);
        intent.putExtra("title", selectMemberUI.getString(R.l.eJf));
        selectMemberUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SelectMemberUI", "[onCreate]");
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        x.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[]{this.lbf});
        ar.Hg();
        this.kZS = c.Fh().hE(this.lbf);
        this.lcX = getIntent().getStringExtra("Block_list");
        this.kFm = getIntent().getIntExtra("frome_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.ldN = getIntent().getBooleanExtra("quit_room", false);
        this.ldO = getIntent().getBooleanExtra("is_show_owner", true);
        initView();
        if (this.kFm == 2) {
            ar.CG().a(990, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kFm == 2) {
            ar.CG().b(990, this);
        }
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
    }

    protected final void initView() {
        setMMTitle(bh.ou(this.mTitle));
        this.Fv = (ListView) findViewById(R.h.cvH);
        this.ldC = findViewById(R.h.cKW);
        this.kgd = findViewById(R.h.cKX);
        this.ldM = new b(this, this, this.kZS, this.lbf, this.kZS.field_roomowner);
        this.Fv.setAdapter(this.ldM);
        this.ldL = (SelectMemberScrollBar) findViewById(R.h.cvJ);
        this.ldL.setVisibility(0);
        this.ldL.yhE = new 1(this);
        this.ldb = (MMEditText) findViewById(R.h.cKV);
        this.ldb.addTextChangedListener(new 2(this));
        this.Fv.setOnItemClickListener(new 3(this));
        b bVar = this.ldM;
        bVar.ldP.kgd.setVisibility(0);
        ar.Dm().F(new 1(bVar));
        setBackBtn(new 4(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
        }
        if (kVar.getType() != 990) {
            return;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[]{((n) kVar).username});
            u.makeText(this, R.l.eGi, 1).show();
            Intent intent = new Intent();
            intent.putExtra("RoomInfo_Id", this.lbf);
            intent.putExtra("Chat_User", this.lbf);
            intent.putExtra("Is_Chatroom", true);
            intent.setFlags(67108864);
            d.b(this.mController.xIM, "chatroom", ".ui.ChatroomInfoUI", intent);
            finish();
            return;
        }
        u.makeText(this, R.l.eGh, 1).show();
        x.w("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.gu(str);
    }

    protected final int getLayoutId() {
        return R.i.drH;
    }
}
