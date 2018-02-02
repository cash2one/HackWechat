package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView emptyTipTv;
    private List<x> onh;
    private boolean ySC = true;
    private boolean ySD;
    private boolean ySE = false;
    private List<String> ySF = null;
    private int ySG;
    private ListView ySH;
    private a ySI;
    private HashMap<String, Long> ySJ;

    class a extends BaseAdapter {
        final /* synthetic */ GroupCardSelectUI ySK;

        public a(GroupCardSelectUI groupCardSelectUI) {
            this.ySK = groupCardSelectUI;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            x xVar = (x) this.ySK.onh.get(i);
            if (view == null) {
                b bVar2 = new b(this.ySK);
                view = View.inflate(this.ySK, R.i.dlz, null);
                bVar2.nQf = (TextView) view.findViewById(R.h.cnZ);
                bVar2.ySL = (TextView) view.findViewById(R.h.coa);
                bVar2.hvY = (ImageView) view.findViewById(R.h.cnY);
                bVar2.pfB = (CheckBox) view.findViewById(R.h.cKI);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a(bVar.hvY, xVar.field_username);
            bVar.ySL.setText(i.c(this.ySK, r.gu(xVar.field_username), com.tencent.mm.bv.a.aa(this.ySK.mController.xIM, R.f.bvK)));
            bVar.nQf.setText("(" + m.gl(xVar.field_username) + ")");
            if (this.ySK.ySE) {
                bVar.pfB.setVisibility(0);
                if (this.ySK.ySF.contains(xVar.field_username)) {
                    bVar.pfB.setChecked(true);
                } else {
                    bVar.pfB.setChecked(false);
                }
            }
            return view;
        }

        public final int getCount() {
            return this.ySK.onh.size();
        }

        public final Object getItem(int i) {
            return this.ySK.onh.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, x xVar) {
        int i = 1;
        if (groupCardSelectUI.ySE) {
            if (groupCardSelectUI.ySF.contains(xVar.field_username)) {
                groupCardSelectUI.ySF.remove(xVar.field_username);
            } else {
                if (!groupCardSelectUI.ySE || groupCardSelectUI.ySF.size() < groupCardSelectUI.ySG) {
                    i = 0;
                } else {
                    h.a(groupCardSelectUI.mController.xIM, groupCardSelectUI.getString(R.l.eJk, new Object[]{Integer.valueOf(groupCardSelectUI.ySG)}), groupCardSelectUI.getString(R.l.dGt), new 4(groupCardSelectUI));
                }
                if (i == 0) {
                    groupCardSelectUI.ySF.add(xVar.field_username);
                }
            }
            groupCardSelectUI.ySI.notifyDataSetChanged();
        } else if (!groupCardSelectUI.ySC) {
            r0 = new Intent();
            ar.Hg();
            r0.putExtra("Select_Contact", bh.d(c.Fh().hH(xVar.field_username), ","));
            r0.putExtra("Select_room_name", r.gu(xVar.field_username));
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else if (groupCardSelectUI.ySD) {
            r0 = new Intent();
            r0.putExtra("Select_Conv_User", xVar.field_username);
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else {
            r0 = new Intent(groupCardSelectUI, ChattingUI.class);
            r0.addFlags(67108864);
            r0.putExtra("Chat_User", xVar.field_username);
            groupCardSelectUI.startActivity(r0);
            groupCardSelectUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.dDh));
        this.ySC = getIntent().getBooleanExtra("group_select_type", true);
        this.ySD = getIntent().getBooleanExtra("group_select_need_result", false);
        this.ySE = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.ySE) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (bh.ov(stringExtra)) {
                this.ySF = new LinkedList();
            } else {
                this.ySF = t.g(stringExtra.split(","));
            }
            this.ySG = getIntent().getIntExtra("max_limit_num", 0);
        }
        cvX();
        initView();
        if (this.ySE) {
            a(1, getString(R.l.dFU), new 3(this), p.b.xJz);
            enableOptionMenu(1, true);
            WZ();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        this.ySH = (ListView) findViewById(R.h.cob);
        this.ySI = new a(this);
        this.ySH.setAdapter(this.ySI);
        this.ySH.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ GroupCardSelectUI ySK;

            {
                this.ySK = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x xVar = (x) this.ySK.ySI.getItem(i);
                if (xVar == null) {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    return;
                }
                GroupCardSelectUI.a(this.ySK, xVar);
                this.ySK.WZ();
            }
        });
        this.emptyTipTv = (TextView) findViewById(R.h.cnX);
        if (this.ySI.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new 2(this));
    }

    private void cvX() {
        ar.Hg();
        this.ySJ = c.Fd().ciB();
        this.onh = new LinkedList();
        List<x> GD = s.GD();
        if (GD.size() != 0) {
            int i = 0;
            for (x xVar : GD) {
                int i2;
                if (this.ySJ.containsKey(xVar.field_username)) {
                    a(i, xVar, ((Long) this.ySJ.get(xVar.field_username)).longValue());
                    i2 = i + 1;
                } else if (com.tencent.mm.l.a.fZ(xVar.field_type)) {
                    this.onh.add(xVar);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            GD.clear();
        }
    }

    private void a(int i, x xVar, long j) {
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.ySJ.get(((x) this.onh.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.onh.add(i2, xVar);
    }

    protected final int getLayoutId() {
        return R.i.dly;
    }

    private void WZ() {
        if (this.ySE) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(R.l.dFU));
            if (this.ySF.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.ySF.size())});
            } else {
                format = "";
            }
            updateOptionMenuText(1, append.append(format).toString());
        }
    }
}
