package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private j poY = null;
    private r psE = null;
    private TextView psF = null;
    private TextView psG = null;
    private ListView psH;
    private a psI;
    private List<i> psJ;
    private com.tencent.mm.plugin.qqmail.b.j.a psK = new 1(this);

    class a extends BaseAdapter {
        private final Context context;
        final /* synthetic */ MailAddrListUI psL;
        boolean psM = false;
        boolean psN = false;
        Map<String, i> psO = new HashMap();

        public final /* synthetic */ Object getItem(int i) {
            return vd(i);
        }

        public a(MailAddrListUI mailAddrListUI, Context context) {
            this.psL = mailAddrListUI;
            this.context = context;
        }

        public final void c(i iVar) {
            this.psO.put(iVar.nQt, iVar);
        }

        public final int bkT() {
            return this.psO.size();
        }

        public final int getCount() {
            int size = this.psL.psJ.size();
            if (size != 0) {
                return !this.psN ? size + 1 : size;
            } else {
                if (this.psM) {
                    return 1;
                }
                return 0;
            }
        }

        private TextView bkU() {
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(R.g.bDq);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTextSize(0, (float) this.psL.getResources().getDimensionPixelSize(R.f.bvs));
            int dimensionPixelSize = this.psL.getResources().getDimensionPixelSize(R.f.bvv);
            int dimensionPixelSize2 = this.psL.getResources().getDimensionPixelSize(R.f.bvS);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            if (i == 0) {
                if (this.psM) {
                    view = bkU();
                    view.setText(R.l.eAn);
                    int dimensionPixelSize = this.psL.getResources().getDimensionPixelSize(R.f.bvv);
                    view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    view.setTextSize(0, (float) this.psL.getResources().getDimensionPixelSize(R.f.bus));
                    view.setGravity(17);
                    return view;
                } else if (!this.psN) {
                    view = bkU();
                    view.setText(R.l.eAm);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.context, R.i.dpR, null);
                aVar2.psP = (TextView) view.findViewById(R.h.cEA);
                aVar2.lgz = (TextView) view.findViewById(R.h.cEB);
                aVar2.psQ = (TextView) view.findViewById(R.h.cEz);
                aVar2.iis = (CheckBox) view.findViewById(R.h.cEC);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i vd = vd(i);
            if (this.psN || i <= 10) {
                aVar.psP.setVisibility(8);
            } else {
                i vd2 = vd(i - 1);
                if (i == 11) {
                    vd2 = null;
                }
                String d = d(vd);
                String d2 = d(vd2);
                if (d == null) {
                    aVar.psP.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.psP.setVisibility(8);
                } else {
                    aVar.psP.setText(d.toUpperCase());
                    aVar.psP.setVisibility(0);
                }
            }
            aVar.lgz.setText(vd.name);
            aVar.psQ.setText(vd.nQt);
            CheckBox checkBox = aVar.iis;
            if (this.psO.get(vd.nQt) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            return view;
        }

        private static String d(i iVar) {
            if (iVar == null) {
                return null;
            }
            String HF = com.tencent.mm.plugin.qqmail.b.a.HF(iVar.poC);
            char charAt = HF.length() > 1 ? HF.charAt(0) : '~';
            switch (charAt) {
                case '{':
                    charAt = HF.charAt(1);
                    if (bh.p(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
                case '~':
                    return "~";
                default:
                    if (bh.o(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
            }
        }

        public final i vd(int i) {
            if (!this.psN) {
                i = i == 0 ? 0 : i - 1;
            }
            return (i) this.psL.psJ.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.psN;
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.dpQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eAg);
        this.psJ = new ArrayList();
        this.poY = w.bks().poY;
        initView();
        this.poY.a(this.psK);
        this.poY.bki();
    }

    protected final void initView() {
        this.psH = (ListView) findViewById(R.h.cED);
        this.psF = (TextView) findViewById(R.h.ces);
        this.psG = (TextView) findViewById(R.h.cAz);
        this.psI = new a(this, this);
        p pVar = new p(true, true);
        pVar.zms = new b(this) {
            final /* synthetic */ MailAddrListUI psL;

            {
                this.psL = r1;
            }

            public final void Xt() {
            }

            public final void Xu() {
            }

            public final boolean oK(String str) {
                return false;
            }

            public final void oL(String str) {
                String az = bh.az(str, "");
                this.psL.psJ = this.psL.poY.HJ(az.toLowerCase().trim());
                if (az.length() > 0) {
                    this.psL.psI.psN = true;
                } else {
                    this.psL.psI.psN = false;
                }
                this.psL.psI.psM = false;
                if (this.psL.psJ.size() == 0) {
                    this.psL.enableOptionMenu(false);
                    this.psL.psG.setVisibility(0);
                } else {
                    this.psL.enableOptionMenu(true);
                    this.psL.psG.setVisibility(8);
                }
                this.psL.psI.notifyDataSetChanged();
            }

            public final void Xr() {
            }

            public final void Xs() {
            }
        };
        a(pVar);
        this.psH.setAdapter(this.psI);
        this.psH.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MailAddrListUI psL;

            {
                this.psL = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a e = this.psL.psI;
                i vd = e.vd(i - this.psL.psH.getHeaderViewsCount());
                String str = vd.nQt;
                if (e.psO.containsKey(str)) {
                    e.psO.remove(str);
                } else {
                    e.psO.put(str, vd);
                }
                e.notifyDataSetChanged();
                this.psL.setMMTitle(this.psL.getString(R.l.eAg) + (this.psL.psI.bkT() > 0 ? "(" + this.psL.psI.bkT() + ")" : ""));
            }
        });
        this.psH.setOnScrollListener(new 4(this));
        this.psJ = this.poY.HJ(null);
        this.psI.notifyDataSetChanged();
        setBackBtn(new 5(this));
        6 6 = new 6(this);
        addTextOptionMenu(0, getString(R.l.eAf), new 7(this));
        enableOptionMenu(!this.psJ.isEmpty());
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.psE = h.a(context, getString(R.l.eAe), true, new OnCancelListener(this) {
            final /* synthetic */ MailAddrListUI psL;

            {
                this.psL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.psI.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.poY.b(this.psK);
    }
}
