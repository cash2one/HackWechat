package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.m;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView jJn;
    private Context mContext;
    public String vkI;
    public String vkJ;
    public String[] vkK;
    public LinearLayout vkR;
    public boolean vkS;

    private static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> not = null;

        private class a {
            TextView jpW;
            final /* synthetic */ a vkV;

            private a(a aVar) {
                this.vkV = aVar;
            }
        }

        public a(Context context, List<String> list) {
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.not = list;
        }

        public final int getCount() {
            return this.not == null ? 0 : this.not.size();
        }

        public final Object getItem(int i) {
            return this.not.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.ddK, viewGroup, false);
                a aVar = new a();
                aVar.jpW = (TextView) view.findViewById(R.h.title);
                view.setTag(aVar);
                obj = aVar;
            } else {
                obj = view.getTag();
            }
            ((a) obj).jpW.setText(str);
            return view;
        }
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        final m mVar = new m(profileMobilePhoneView.mContext);
        mVar.kPo = new a(profileMobilePhoneView.mContext, bh.F(!profileMobilePhoneView.vkS ? new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dSx)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dSx), profileMobilePhoneView.mContext.getResources().getString(R.l.dSy)}));
        mVar.vwr = new OnItemClickListener(profileMobilePhoneView) {
            final /* synthetic */ ProfileMobilePhoneView vkT;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (mVar != null) {
                    mVar.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    Integer[] numArr;
                    g gVar;
                    Object[] objArr;
                    g gVar2;
                    Integer[] numArr2;
                    int i2;
                    if (bh.ov(this.vkT.vkI)) {
                        numArr = new Object[1];
                        gVar = g.pQN;
                        objArr = numArr;
                    } else {
                        g gVar3 = g.pQN;
                        numArr = new Object[1];
                        if (this.vkT.vkI.equals(str.trim())) {
                            gVar2 = gVar3;
                            numArr2 = numArr;
                            Integer[] numArr3 = numArr;
                            i2 = 1;
                            Integer[] numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            gVar2.h(12043, r2);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            this.vkT.getContext().startActivity(intent);
                        }
                        gVar = gVar3;
                        numArr2 = numArr;
                    }
                    gVar2 = gVar;
                    Object[] objArr2 = objArr;
                    numArr2 = numArr;
                    i2 = 0;
                    numArr2[0] = Integer.valueOf(i2);
                    gVar2.h(12043, objArr2);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                    try {
                        this.vkT.getContext().startActivity(intent);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                    }
                } else if (1 == i) {
                    g.pQN.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    d.b(this.vkT.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
            }
        };
        mVar.setCancelable(true);
        mVar.show();
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vkS = false;
        this.mContext = context;
    }

    public final int bjK() {
        return R.i.dpH;
    }

    public final void init() {
        this.jJn = (TextView) findViewById(R.h.cCs);
        this.vkR = (LinearLayout) findViewById(R.h.cCr);
        for (int i = 0; i < 5; i++) {
            this.vkR.getChildAt(i).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProfileMobilePhoneView vkT;

                {
                    this.vkT = r1;
                }

                public final void onClick(View view) {
                    ProfileMobilePhoneView.a(this.vkT, ((TextView) view).getText().toString());
                }
            });
        }
    }

    @Deprecated
    public final boolean L(com.tencent.mm.storage.x xVar) {
        return false;
    }

    public final boolean bjL() {
        if (this.jJn != null) {
            LayoutParams layoutParams = this.jJn.getLayoutParams();
            layoutParams.width = com.tencent.mm.bv.a.aa(getContext(), R.f.bvb);
            this.jJn.setLayoutParams(layoutParams);
        }
        if (this.vkR != null) {
            int i;
            View childAt;
            int i2;
            int i3;
            if (bh.ov(this.vkI) || !bh.VR(this.vkI).booleanValue()) {
                if (!(this.vkI == null || bh.VR(this.vkI).booleanValue())) {
                    x.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[]{this.vkI});
                }
                i = 0;
                boolean z = false;
            } else {
                childAt = this.vkR.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.vkI);
                }
                i = 1;
                i2 = 1;
            }
            if (bh.ov(this.vkJ)) {
                i3 = i2;
            } else {
                this.vkK = this.vkJ.split(",");
                setVisibility(0);
                i3 = i2;
                while (i3 < this.vkK.length + i) {
                    childAt = this.vkR.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.vkK[i3 - i]);
                    }
                    i3++;
                }
            }
            while (i3 < 5) {
                this.vkR.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && bh.ov(this.vkJ)) {
                setVisibility(8);
            }
        }
        return false;
    }
}
