package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.g.a.my;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.m.a$h;
import com.tencent.mm.plugin.m.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView$c;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.SmileyPanelViewPager$a;
import com.tencent.mm.view.a.d;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a implements e, OnClickListener, MMRadioGroupView$c, b, SmileyPanelViewPager$a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context kaK;
    public final com.tencent.mm.sdk.e.j.a lxe = new 5(this);
    public final c lxf = new c<my>(this) {
        final /* synthetic */ a zGr;

        {
            this.zGr = r2;
            this.xen = my.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            this.zGr.cAQ();
            return false;
        }
    };
    private af mHandler = new 1(this);
    public View mView;
    public Context tI = ac.getContext();
    public com.tencent.mm.view.f.a zDs;
    private final int zFV = 100;
    private final int zFW = TXLiveConstants.PUSH_WARNING_RECONNECT;
    private final int zFX = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
    private final int zFY = 100;
    public SmileyPanelViewPager zFZ;
    private d zGa;
    public SmileyPanelScrollView zGb;
    public HorizontalListViewV2 zGc;
    public com.tencent.mm.view.a.e zGd;
    public View zGe;
    public ImageView zGf;
    public ImageView zGg;
    private ImageButton zGh;
    public ImageButton zGi;
    public TextView zGj;
    public a zGk;
    private int zGl = -1;
    private boolean zGm = false;
    public boolean zGn = true;
    public String zGo;
    public final com.tencent.mm.sdk.e.j.a zGp = new 4(this);
    public OnItemClickListener zGq = new OnItemClickListener(this) {
        final /* synthetic */ a zGr;

        {
            this.zGr = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EmojiGroupInfo Hr = this.zGr.zGd.Hr(i);
            if (Hr == null) {
                x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
            } else if (Hr.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB")) {
                com.tencent.mm.bm.d.b(this.zGr.tI, "emoji", ".ui.EmojiMineUI", new Intent());
            } else {
                this.zGr.c(this.zGr.zDs.Hy(this.zGr.zGl), false, true);
                com.tencent.mm.view.c.a aas = this.zGr.zDs.aas(Hr.field_productID);
                this.zGr.zGl = aas.kaM;
                int cAJ = aas.zFU > aas.cAJ() + -1 ? aas.cAJ() - 1 : aas.zFU;
                if (this.zGr.zFZ != null) {
                    this.zGr.zFZ.d(this.zGr.zGl + cAJ, false);
                }
                this.zGr.t(aas.cAJ(), cAJ, true);
                this.zGr.zDs.zGF = cAJ;
                this.zGr.zDs.aar(Hr.field_productID);
                if (Hr.equals(String.valueOf(EmojiGroupInfo.xAc))) {
                    g.pQN.h(11594, new Object[]{Integer.valueOf(0)});
                }
            }
        }
    };

    public a(Context context, com.tencent.mm.view.f.a aVar, a aVar2) {
        this.kaK = context;
        this.zDs = aVar;
        this.zGk = aVar2;
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().i(this.zGp);
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().g(this.lxe);
        com.tencent.mm.sdk.b.a.xef.b(this.lxf);
    }

    public final synchronized void cAK() {
        if (this.mView == null || !this.zDs.zGV) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
        } else {
            Object obj;
            ArrayList aBb;
            int i;
            Collection arrayList;
            Iterator it;
            int i2;
            EmojiGroupInfo emojiGroupInfo;
            com.tencent.mm.view.a.e eVar;
            long currentTimeMillis = System.currentTimeMillis();
            this.zDs.zGK = false;
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.view.f.a aVar = this.zDs;
            if (aVar.zGS != null) {
                Iterator it2 = aVar.zGS.iterator();
                while (it2.hasNext()) {
                    if (((com.tencent.mm.view.c.a) it2.next()) != null) {
                        x.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[]{((com.tencent.mm.view.c.a) it2.next()).lyH});
                    } else {
                        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                    }
                }
            }
            if (aVar.zGS != null) {
                aVar.zGS.clear();
            }
            if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBa() <= 2) {
                com.tencent.mm.bu.a.cdS();
                com.tencent.mm.bu.a.b bVar = com.tencent.mm.bu.a.xbo;
                if (!com.tencent.mm.bu.a.b.CX(208912)) {
                    obj = null;
                    aBb = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBb();
                    com.tencent.mm.bu.a.cdS();
                    i = ((h) com.tencent.mm.kernel.g.Dg().CN()).DS() ? com.tencent.mm.k.g.zY().getInt("EmotionRecommandCount", 3) : com.tencent.mm.bu.a.xbp.getInt("EmotionRecommandCount", 3);
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBc()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBc())});
                    arrayList = new ArrayList();
                    if (!this.zDs.zGH) {
                        arrayList.add(com.tencent.mm.view.f.a.cAW());
                        a(com.tencent.mm.view.f.a.cAW(), true);
                    }
                    if (!this.zDs.zGG) {
                        if (obj != null) {
                            arrayList.add(com.tencent.mm.view.f.a.cAX());
                            a(com.tencent.mm.view.f.a.cAX(), true);
                        }
                        if (aBb != null) {
                            it = aBb.iterator();
                            i2 = 0;
                            while (it.hasNext()) {
                                emojiGroupInfo = (EmojiGroupInfo) it.next();
                                if (!(emojiGroupInfo == null || bh.ov(emojiGroupInfo.field_productID))) {
                                    if (emojiGroupInfo.field_recommand != 1) {
                                        if (i2 < r6 && i2 < i) {
                                            i2++;
                                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                            arrayList.add(emojiGroupInfo);
                                        }
                                    } else if (!(emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xAc)) || emojiGroupInfo.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                        a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                        arrayList.add(emojiGroupInfo);
                                    }
                                }
                            }
                        }
                        if (obj == null) {
                            arrayList.add(com.tencent.mm.view.f.a.cAX());
                            a(com.tencent.mm.view.f.a.cAX(), true);
                        }
                        if (!this.zDs.zGH) {
                            emojiGroupInfo = new EmojiGroupInfo();
                            emojiGroupInfo.field_productID = "TAG_STORE_MANEGER_TAB";
                            arrayList.add(emojiGroupInfo);
                        }
                    }
                    eVar = this.zGd;
                    eVar.mData.clear();
                    eVar.mData.addAll(arrayList);
                    eVar.notifyDataSetChanged();
                    cAN();
                    this.zDs.cBb();
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                    if (this.zFZ == null) {
                        x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                    } else if (this.zGa != null) {
                        cAM();
                        this.zGa = new d(this.zDs, this.kaK);
                        this.zDs.cBa();
                        this.zFZ.a(this.zGa);
                        this.zFZ.xe(1);
                    } else {
                        this.zGa.zEt = true;
                        this.zGa.cAr();
                        this.zGa.notifyDataSetChanged();
                        this.zGa.zEt = false;
                    }
                    cAL();
                    this.zDs.zGK = true;
                    this.zDs.zGN = true;
                    if (!this.zDs.zGL) {
                        g.pQN.a(406, 6, 1, false);
                        g.pQN.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                }
            }
            obj = 1;
            aBb = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBb();
            com.tencent.mm.bu.a.cdS();
            if (((h) com.tencent.mm.kernel.g.Dg().CN()).DS()) {
            }
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBc()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBc())});
            arrayList = new ArrayList();
            if (this.zDs.zGH) {
                arrayList.add(com.tencent.mm.view.f.a.cAW());
                a(com.tencent.mm.view.f.a.cAW(), true);
            }
            if (this.zDs.zGG) {
                if (obj != null) {
                    arrayList.add(com.tencent.mm.view.f.a.cAX());
                    a(com.tencent.mm.view.f.a.cAX(), true);
                }
                if (aBb != null) {
                    it = aBb.iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        emojiGroupInfo = (EmojiGroupInfo) it.next();
                        if (emojiGroupInfo.field_recommand != 1) {
                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                            arrayList.add(emojiGroupInfo);
                        } else {
                            i2++;
                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                            arrayList.add(emojiGroupInfo);
                        }
                    }
                }
                if (obj == null) {
                    arrayList.add(com.tencent.mm.view.f.a.cAX());
                    a(com.tencent.mm.view.f.a.cAX(), true);
                }
                if (this.zDs.zGH) {
                    emojiGroupInfo = new EmojiGroupInfo();
                    emojiGroupInfo.field_productID = "TAG_STORE_MANEGER_TAB";
                    arrayList.add(emojiGroupInfo);
                }
            }
            eVar = this.zGd;
            eVar.mData.clear();
            eVar.mData.addAll(arrayList);
            eVar.notifyDataSetChanged();
            cAN();
            this.zDs.cBb();
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
            if (this.zFZ == null) {
                x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
            } else if (this.zGa != null) {
                this.zGa.zEt = true;
                this.zGa.cAr();
                this.zGa.notifyDataSetChanged();
                this.zGa.zEt = false;
            } else {
                cAM();
                this.zGa = new d(this.zDs, this.kaK);
                this.zDs.cBa();
                this.zFZ.a(this.zGa);
                this.zFZ.xe(1);
            }
            cAL();
            this.zDs.zGK = true;
            this.zDs.zGN = true;
            if (this.zDs.zGL) {
                g.pQN.a(406, 6, 1, false);
                g.pQN.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
            }
        }
    }

    public final void cAL() {
        com.tencent.mm.view.c.a cBa = this.zDs.cBa();
        if (cBa == null) {
            this.zDs.aar("TAG_DEFAULT_TAB");
            cBa = this.zDs.cBa();
        }
        cAP();
        if (cBa != null && this.zFZ != null) {
            int i = this.zDs.zGF;
            if (i < 0 || i > cBa.cAJ() - 1) {
                i = cBa.cAJ() - 1;
            }
            this.zGl = cBa.kaM + i;
            this.zFZ.ah(this.zGl);
            if (!cBa.lyH.equals("TAG_STORE_TAB")) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
            }
            t(cBa.cAJ(), i + 0, false);
        }
    }

    private void t(int i, int i2, boolean z) {
        if (i <= 1) {
            this.zGb.setVisibility(4);
            return;
        }
        this.zGb.setVisibility(0);
        SmileyPanelScrollView smileyPanelScrollView = this.zGb;
        x.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        smileyPanelScrollView.zDy = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > smileyPanelScrollView.zDy) {
            i2 = smileyPanelScrollView.zDy;
        }
        smileyPanelScrollView.zDz = i2;
        if (smileyPanelScrollView.zDM == -1 || z) {
            smileyPanelScrollView.zDM = smileyPanelScrollView.zDz;
        }
        if (smileyPanelScrollView.zDL == -1 || z) {
            smileyPanelScrollView.zDL = smileyPanelScrollView.zDz;
            smileyPanelScrollView.zDN = 0.0f;
        }
        smileyPanelScrollView.invalidate();
    }

    public final void cAM() {
        if (this.zGa != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.zGa.mCount = 0;
        }
    }

    private void a(EmojiGroupInfo emojiGroupInfo, boolean z) {
        int i = 0;
        com.tencent.mm.view.f.a aVar = this.zDs;
        if (aVar.zGS == null) {
            aVar.zGS = new ArrayList();
        }
        int size = aVar.zGS.size();
        com.tencent.mm.view.c.a aVar2 = size <= 0 ? null : (com.tencent.mm.view.c.a) aVar.zGS.get(size - 1);
        int a = bh.a((Integer) aVar.zGT.get(emojiGroupInfo.field_productID), 0);
        if (aVar2 != null) {
            i = aVar2.kaM + aVar2.cAJ();
        }
        aVar.zGS.add(new com.tencent.mm.view.c.a(emojiGroupInfo, i, a, aVar, this, z));
    }

    public final void cAN() {
        if (this.zGf != null) {
            if (!com.tencent.mm.view.f.a.cAS() || this.zDs.zGE.equalsIgnoreCase("TAG_STORE_TAB")) {
                this.zGg.setVisibility(8);
            } else {
                this.zGg.setVisibility(0);
            }
            this.zGf.setContentDescription(this.tI.getString(a$h.lJP));
        }
    }

    private ImageButton cAO() {
        if (this.zGh == null) {
            this.zGh = new ImageButton(this.kaK, null, i.lJR);
            this.zGh.setMaxHeight(this.zDs.zGs);
            this.zGh.setMinimumHeight(this.zDs.zGs);
            this.zGh.setMaxWidth(this.zDs.lHW);
            this.zGh.setMinimumWidth(this.zDs.lHW);
            this.zGh.setScaleType(ScaleType.CENTER);
            this.zGh.setPadding(this.zDs.zGu, this.zDs.zGu, this.zDs.zGu, this.zDs.zGu);
            this.zGh.setClickable(false);
            this.zGh.setVisibility(8);
        }
        return this.zGh;
    }

    public final void onClick(View view) {
        if (view == this.zGf) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (com.tencent.mm.view.f.a.cAR()) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!bh.ov(this.zDs.vpS)) {
                intent.putExtra("to_talker_name", this.zDs.vpS);
            }
            com.tencent.mm.bm.d.b(this.tI, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            g.pQN.h(11594, new Object[]{Integer.valueOf(2)});
        } else if (view == this.zGj) {
            if (this.zGk != null && this.zGk.cAn() != null) {
                this.zGk.cAn().aXU();
            }
        } else if (view == this.zGi && this.zGk.cAo() != null) {
            this.zGk.cAo().aZf();
        }
    }

    public final View findViewById(int i) {
        return this.mView.findViewById(i);
    }

    public final void nI(boolean z) {
        cAO().setVisibility(8);
        if (this.zGj != null && this.zGj.getVisibility() == 0) {
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.zGj.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.zGj.startAnimation(translateAnimation);
            }
            this.zGj.setVisibility(8);
        }
    }

    public final void Hp(int i) {
        if (this.zFZ != null) {
            int i2 = this.zFZ.yF;
            int i3 = this.zDs.Hx(i2).kaM + i;
            if (i3 != i2) {
                Math.abs(i3 - i2);
                this.zFZ.ah(i3);
            }
            this.zGl = i3;
        }
    }

    public final void af(int i) {
        if (this.zGb != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.zGb;
            if (i == 0) {
                smileyPanelScrollView.zDM = smileyPanelScrollView.zDz;
                smileyPanelScrollView.zDL = smileyPanelScrollView.zDz;
                smileyPanelScrollView.zDN = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.zDO) {
                    smileyPanelScrollView.zDO = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.zDM = smileyPanelScrollView.zDz;
                smileyPanelScrollView.zDL = smileyPanelScrollView.zDz;
                smileyPanelScrollView.zDN = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.zGl = this.zFZ.yF;
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.zGb != null && f != 0.0f) {
            if (this.zGl == -1) {
                this.zGl = this.zFZ.yF;
            }
            int i3 = this.zGl;
            if (i == this.zGl) {
                i3 = this.zGl + 1;
            }
            com.tencent.mm.view.c.a Hx = this.zDs.Hx(i3);
            com.tencent.mm.view.c.a Hx2 = this.zDs.Hx(i);
            if (Hx == Hx2) {
                SmileyPanelScrollView smileyPanelScrollView = this.zGb;
                int i4 = i - Hx2.kaM;
                smileyPanelScrollView.zDN = f;
                if (smileyPanelScrollView.zDM != i4) {
                    smileyPanelScrollView.zDM = i4;
                }
                smileyPanelScrollView.invalidate();
                this.zGm = true;
                return;
            }
            this.zGm = false;
        }
    }

    private void c(int i, boolean z, boolean z2) {
        int i2 = 1;
        if (this.zGc != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.zGc.getChildCount())});
            this.zGc.setSelection(i);
            View selectedView = this.zGc.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(z);
                return;
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                Message message = new Message();
                message.what = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
                message.arg1 = i;
                if (!z) {
                    i2 = 0;
                }
                message.arg2 = i2;
                this.mHandler.sendMessageDelayed(message, 100);
            }
        }
    }

    public final void ae(int i) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[]{Integer.valueOf(i)});
        if (this.zDs != null && this.zDs.zGV) {
            boolean z;
            com.tencent.mm.view.c.a Hx = this.zDs.Hx(i);
            if (Hx.lyH.equals("TAG_STORE_TAB")) {
                this.zGf.setSelected(true);
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[]{Integer.valueOf(this.zGf.getId()), "TAG_STORE_TAB"});
                this.zDs.aar("TAG_STORE_TAB");
                g.pQN.h(11594, new Object[]{Integer.valueOf(5)});
                com.tencent.mm.s.c.Bq().aS(262147, 266244);
                com.tencent.mm.s.c.Bq().aS(262149, 266244);
                cAN();
            } else {
                this.zGf.setSelected(false);
            }
            int i2 = i - Hx.kaM;
            int cAJ = Hx.cAJ();
            int i3 = i - Hx.kaM;
            if (this.zGm) {
                z = false;
            } else {
                z = true;
            }
            t(cAJ, i3, z);
            this.zDs.zGF = i2;
            this.zDs.aar(Hx.lyH);
            Hx.zFU = i2;
            com.tencent.mm.view.f.a aVar = this.zDs;
            aVar.zGT.put(Hx.lyH, Integer.valueOf(Hx.zFU));
            Hv(this.zDs.Hy(i));
            c(this.zDs.Hy(i) - 1, false, true);
            c(this.zDs.Hy(i) + 1, false, true);
            cAP();
        }
    }

    private void Hv(int i) {
        int i2 = this.zDs.lHW;
        int width = this.zGc.getWidth();
        int firstVisiblePosition = this.zGc.getFirstVisiblePosition();
        if (i > this.zGc.getLastVisiblePosition()) {
            this.zGc.Es((i2 * (i + 1)) - width);
        } else if (i < firstVisiblePosition) {
            this.zGc.Es(i2 * i);
        }
        c(i, true, true);
    }

    public final void cAP() {
        if (this.zDs.zGE.equals("TAG_DEFAULT_TAB")) {
            if (!(this.zGk == null || this.zGk.cAn() == null)) {
                this.zGk.cAn().gw(true);
            }
            if (this.zDs.cAY()) {
                this.zDs.zGM = false;
                cAO().setVisibility(0);
                if (this.zGj != null && this.zGj.getVisibility() != 0) {
                    Animation translateAnimation = new TranslateAnimation((float) this.zGj.getWidth(), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(250);
                    this.zGj.startAnimation(translateAnimation);
                    this.zGj.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (!(this.zGk == null || this.zGk.cAn() == null)) {
            this.zGk.cAn().gw(false);
        }
        nI(true);
    }

    public final synchronized void Hq(int i) {
        com.tencent.mm.view.f.a aVar;
        if (this.zDs.cBc()) {
            if (!this.zDs.zGQ) {
                aVar = this.zDs;
                aVar.zGQ = true;
                aVar.zGR = false;
            }
        } else if (!this.zDs.zGR) {
            aVar = this.zDs;
            aVar.zGR = true;
            aVar.zGQ = false;
        }
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new 2(this));
        }
    }

    public final void EO(int i) {
        if (i > 0) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            Hv(this.zDs.cAZ());
        }
    }

    public final void cAQ() {
        this.zGn = false;
        this.mHandler.removeMessages(TXLiveConstants.PUSH_WARNING_RECONNECT);
        this.mHandler.sendEmptyMessageDelayed(TXLiveConstants.PUSH_WARNING_RECONNECT, 100);
    }
}
