package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.setting.modelsimple.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements e {
    private static int qls = 5;
    private GridView mSh;
    private r mbx;
    private TextView nvb;
    private boolean qjD;
    private List<String> qlp;
    private a qlq;
    private View qlr;

    private class a extends BaseAdapter {
        final /* synthetic */ SettingsTrustFriendUI qlt;

        private a(SettingsTrustFriendUI settingsTrustFriendUI) {
            this.qlt = settingsTrustFriendUI;
        }

        public final int getCount() {
            int size = this.qlt.qlp.size();
            if (this.qlt.qjD) {
                return size;
            }
            if (size == 0) {
                return 1;
            }
            if (size <= 0 || size >= SettingsTrustFriendUI.qls) {
                return size >= SettingsTrustFriendUI.qls ? size + 1 : 0;
            } else {
                return size + 2;
            }
        }

        public final Object getItem(int i) {
            if (getItemViewType(i) == 0) {
                return this.qlt.qlp.get(i);
            }
            return null;
        }

        public final int getItemViewType(int i) {
            int size = this.qlt.qlp.size();
            if (this.qlt.qjD || i < size) {
                return 0;
            }
            if (size == 0) {
                return 1;
            }
            if (size >= SettingsTrustFriendUI.qls) {
                return 2;
            }
            if (i == size) {
                return 1;
            }
            if (i == size + 1) {
                return 2;
            }
            return -1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.qlt.getLayoutInflater().inflate(R.i.dsm, null);
                ImageView imageView = (ImageView) view.findViewById(R.h.cSM);
                ImageView imageView2 = (ImageView) view.findViewById(R.h.cSN);
                TextView textView = (TextView) view.findViewById(R.h.cSR);
                a aVar2 = new a(this, (byte) 0);
                aVar2.pZu = imageView;
                aVar2.qlw = imageView2;
                aVar2.ksb = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) this.qlt.qlp.get(i);
                ar.Hg();
                x WO = c.EY().WO(str);
                aVar.pZu.setScaleType(ScaleType.FIT_XY);
                b.a(aVar.pZu, str);
                aVar.ksb.setText(i.b(this.qlt, WO.AQ(), aVar.ksb.getTextSize()));
                if (this.qlt.qjD) {
                    aVar.qlw.setVisibility(0);
                } else {
                    aVar.qlw.setVisibility(8);
                }
            } else {
                aVar.ksb.setVisibility(4);
                aVar.qlw.setVisibility(8);
                aVar.pZu.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.pZu.setImageResource(R.g.bzk);
                } else if (getItemViewType(i) == 2) {
                    aVar.pZu.setImageResource(R.g.bzl);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        k dVar = new d();
        ar.CG().a(dVar, 0);
        settingsTrustFriendUI.getString(R.l.dEJ);
        settingsTrustFriendUI.mbx = h.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.ctB), true, new 5(settingsTrustFriendUI, dVar));
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        if (settingsTrustFriendUI.qlp.size() <= 0 || settingsTrustFriendUI.qlp.size() >= 3) {
            k aVar = new com.tencent.mm.plugin.setting.modelsimple.a(settingsTrustFriendUI.qlp);
            ar.CG().a(aVar, 0);
            if (settingsTrustFriendUI.mbx != null) {
                settingsTrustFriendUI.mbx.dismiss();
            }
            settingsTrustFriendUI.getString(R.l.dEJ);
            settingsTrustFriendUI.mbx = h.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.dGB), true, new 2(settingsTrustFriendUI, aVar));
            return;
        }
        h.b(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.eNB, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(R.l.dGO), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        String str = (String) c.CU().get(352277, null);
        if (!bh.ov(str)) {
            this.qlp = bh.F(str.split(","));
        }
        if (this.qlp == null) {
            this.qlp = new ArrayList();
        }
        this.mController.contentView.post(new 1(this));
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsl;
    }

    public void onStart() {
        super.onStart();
        ar.CG().a(869, this);
        ar.CG().a(583, this);
    }

    protected void onStop() {
        super.onStop();
        ar.CG().b(869, this);
        ar.CG().b(583, this);
    }

    protected final void initView() {
        setMMTitle(R.l.dsl);
        this.mSh = (GridView) findViewById(R.h.cSP);
        this.qlq = new a();
        this.mSh.setColumnWidth(getResources().getDimensionPixelSize(R.f.bvF));
        this.mSh.setNumColumns(-1);
        this.mSh.setStretchMode(1);
        this.mSh.setHorizontalSpacing(getResources().getDimensionPixelSize(R.f.bxA) * 2);
        this.mSh.setVerticalSpacing(getResources().getDimensionPixelSize(R.f.bxB));
        this.mSh.setAdapter(this.qlq);
        ((ViewGroup) this.mSh.getParent()).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI qlt;

            {
                this.qlt = r1;
            }

            public final void onClick(View view) {
                if (this.qlt.qjD) {
                    this.qlt.qjD = false;
                    this.qlt.qlq.notifyDataSetChanged();
                }
            }
        });
        this.mSh.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SettingsTrustFriendUI qlt;

            {
                this.qlt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.qlt.qjD || motionEvent.getAction() != 1 || this.qlt.mSh.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) != -1) {
                    return false;
                }
                this.qlt.qjD = false;
                this.qlt.qlq.notifyDataSetChanged();
                return true;
            }
        });
        this.mSh.setHorizontalScrollBarEnabled(false);
        this.mSh.setVerticalScrollBarEnabled(false);
        this.mSh.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI qlt;

            {
                this.qlt = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.qlt.qlq.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", this.qlt.getString(R.l.dDo));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.qls);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", bh.d(this.qlt.qlp, ","));
                    intent.putExtra("block_contact", q.FS());
                    intent.putExtra("list_attr", s.fb(s.yTJ, 256));
                    intent.putExtra("too_many_member_tip_string", this.qlt.getString(R.l.eNA, new Object[]{Integer.valueOf(SettingsTrustFriendUI.qls)}));
                    com.tencent.mm.bm.d.a(this.qlt, ".ui.contact.SelectContactUI", intent, 1);
                    return;
                }
                if (this.qlt.qlq.getItemViewType(i) == 2) {
                    if (!this.qlt.qjD) {
                        this.qlt.qjD = true;
                    } else {
                        return;
                    }
                } else if (this.qlt.qlq.getItemViewType(i) == 0 && this.qlt.qjD) {
                    this.qlt.qlp.remove(this.qlt.qlq.getItem(i));
                    if (this.qlt.qlp.size() == 0) {
                        this.qlt.qjD = false;
                    }
                } else {
                    return;
                }
                this.qlt.qlq.notifyDataSetChanged();
            }
        });
        this.nvb = (TextView) findViewById(R.h.cSO);
        CharSequence stringExtra = getIntent().getStringExtra(g.xEo);
        if (bh.ov(stringExtra)) {
            this.nvb.setText(getResources().getString(R.l.eNC, new Object[]{Integer.valueOf(3)}));
        } else {
            this.nvb.setText(stringExtra);
        }
        this.qlr = findViewById(R.h.cSS);
        this.qlr.setVisibility(8);
        ((TextView) this.qlr.findViewById(R.h.cYA)).setText(getString(R.l.eNB, new Object[]{Integer.valueOf(3)}));
        this.qlr.findViewById(R.h.bWl).setOnClickListener(new 9(this));
        findViewById(R.h.cSQ).setOnClickListener(new 10(this));
        setBackBtn(new 11(this));
        a(1, getString(R.l.dFl), new 12(this), p.b.xJz);
        showOptionMenu(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bh.ov(stringExtra)) {
                this.qlp.clear();
                this.qlp.addAll(bh.F(stringExtra.split(",")));
                this.qlq.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.mbx != null) {
            this.mbx.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 869) {
                int i3;
                agu com_tencent_mm_protocal_c_agu = (agu) ((com.tencent.mm.ae.b) kVar.hmG).hmh.hmo;
                qls = com_tencent_mm_protocal_c_agu.woe;
                List<bor> list = com_tencent_mm_protocal_c_agu.vHk;
                if (list.size() != this.qlp.size()) {
                    i3 = 1;
                    break;
                } else if (list.size() == 0) {
                    i3 = 0;
                } else {
                    for (bor com_tencent_mm_protocal_c_bor : list) {
                        if (!this.qlp.contains(com_tencent_mm_protocal_c_bor.ksU)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.qlp.clear();
                    for (bor com_tencent_mm_protocal_c_bor2 : list) {
                        this.qlp.add(com_tencent_mm_protocal_c_bor2.ksU);
                    }
                    this.qlq.notifyDataSetChanged();
                }
                if (this.qlp.size() > 0 && this.qlp.size() < 3) {
                    this.qlr.setVisibility(0);
                }
                ar.Hg();
                c.CU().set(352277, bh.d(this.qlp, ","));
            } else if (kVar.getType() == 583) {
                ar.Hg();
                c.CU().set(352277, bh.d(this.qlp, ","));
                finish();
            }
        } else if (!bh.ov(str)) {
            h.bu(this, str);
        }
    }

    private void bra() {
        ar.Hg();
        String str = (String) c.CU().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (bh.ov(str)) {
            Object obj = arrayList;
        } else {
            Collection F = bh.F(str.split(","));
        }
        if (this.qlp.size() == F.size() && this.qlp.containsAll(F)) {
            finish();
        } else {
            h.a(this, getString(R.l.eHf), getString(R.l.dGO), getString(R.l.dGx), getString(R.l.dFS), true, new 3(this), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsTrustFriendUI qlt;

                {
                    this.qlt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qlt.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        bra();
        return true;
    }
}
