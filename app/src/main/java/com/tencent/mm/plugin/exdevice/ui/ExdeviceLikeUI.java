package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.z.r;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private final int lUA = 30;
    private ArrayList<e> lUw;
    private boolean lUx;
    private ListView lUy;
    private a lUz;
    private String mAppName;

    class a extends BaseAdapter {
        final /* synthetic */ ExdeviceLikeUI lUB;

        class a {
            ImageView ihQ;
            TextView imP;
            NoMeasuredTextView lUC;
            TextView lUD;
            final /* synthetic */ a lUE;

            a(a aVar) {
                this.lUE = aVar;
            }
        }

        a(ExdeviceLikeUI exdeviceLikeUI) {
            this.lUB = exdeviceLikeUI;
        }

        public final int getCount() {
            return this.lUB.lUw == null ? 0 : this.lUB.lUw.size();
        }

        public final Object getItem(int i) {
            return this.lUB.lUw.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            a aVar;
            e eVar = (e) this.lUB.lUw.get(i);
            if (view == null) {
                if (this.lUB.lUx) {
                    inflate = LayoutInflater.from(this.lUB).inflate(R.i.dgM, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(this.lUB).inflate(R.i.dgL, viewGroup, false);
                }
                a aVar2 = new a(this);
                aVar2.ihQ = (ImageView) inflate.findViewById(R.h.ceU);
                aVar2.lUC = (NoMeasuredTextView) inflate.findViewById(R.h.cfG);
                aVar2.imP = (TextView) inflate.findViewById(R.h.cfz);
                aVar2.lUD = (TextView) inflate.findViewById(R.h.cfy);
                aVar2.lUC.O(this.lUB.getResources().getDimension(R.f.bvK));
                aVar2.lUC.setTextColor(this.lUB.getResources().getColor(R.e.black));
                aVar2.lUC.cpw();
                aVar2.lUC.ygb = true;
                inflate.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            b.p(aVar.ihQ, eVar.field_username);
            aVar.lUC.setText(i.b(this.lUB, r.gu(eVar.field_username), aVar.lUC.gu.getTextSize()));
            if (!bh.ov(eVar.field_liketips) && aVar.imP != null) {
                aVar.imP.setVisibility(0);
                aVar.imP.setText(eVar.field_liketips);
            } else if (aVar.imP != null) {
                aVar.imP.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
                aVar.lUD.setText(this.lUB.getString(R.l.edj, new Object[]{Integer.valueOf(r3)}));
            } else {
                aVar.lUD.setText(n.c(this.lUB, ((long) eVar.field_timestamp) * 1000, true));
            }
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.lUx = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (bh.ov(stringExtra)) {
            stringExtra2 = getIntent().getStringExtra("rank_id");
            Assert.assertTrue(!bh.ov(stringExtra2));
            this.lUw = ad.aEp().zd(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.mAppName;
            x.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (bh.ov(stringExtra)) {
                x.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                com.tencent.mm.y.g.a I = com.tencent.mm.y.g.a.I(stringExtra, stringExtra2);
                if (I != null) {
                    Map map = I.haZ;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (bh.ov(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = bh.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        x.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i));
                        arrayList = arrayList2;
                        this.lUw = arrayList;
                    }
                }
            }
            arrayList = null;
            this.lUw = arrayList;
        }
        this.lUy = (ListView) findViewById(R.h.cfd);
        this.lUy.setEmptyView(findViewById(R.h.empty));
        this.lUz = new a(this);
        this.lUy.setAdapter(this.lUz);
        if (!this.lUx) {
            this.lUy.setOnItemClickListener(new 3(this));
        }
        setMMTitle(R.l.edk);
        if (!this.lUx) {
            addTextOptionMenu(0, getString(R.l.edi), new 1(this));
        }
        setBackBtn(new 2(this));
    }

    protected final int getLayoutId() {
        return R.i.dgN;
    }
}
