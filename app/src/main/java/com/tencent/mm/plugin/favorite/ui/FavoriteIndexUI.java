package com.tencent.mm.plugin.favorite.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.a.a$a;
import com.tencent.mm.plugin.favorite.ui.b.a.c;
import com.tencent.mm.plugin.favorite.ui.base.b.1;
import com.tencent.mm.plugin.favorite.ui.base.b.2;
import com.tencent.mm.plugin.favorite.ui.base.b.3;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.plugin.favorite.ui.post.FavPostVoiceUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements c, a {
    private static final long mtK = ((long) b.zG());
    private l contextMenuHelper;
    private d kBR = new d(this) {
        final /* synthetic */ FavoriteIndexUI mtS;

        {
            this.mtS = r1;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (this.mtS.mtL) {
                case 0:
                    if (menuItem != null) {
                        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (adapterContextMenuInfo.position >= this.mtS.mrI.getHeaderViewsCount()) {
                                    x.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                    j.a(this.mtS.mtM.pM((adapterContextMenuInfo.position - this.mtS.mrI.getHeaderViewsCount()) - 1), null);
                                    return;
                                }
                                return;
                            case 1:
                                this.mtS.startTime = bh.Wo();
                                x.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.mtS.mtO = this.mtS.mtM.pM((adapterContextMenuInfo.position - this.mtS.mrI.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(this.mtS, this.mtS.mtO);
                                return;
                            case 2:
                                x.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                f pM = this.mtS.mtM.pM((adapterContextMenuInfo.position - this.mtS.mrI.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent(this.mtS.mController.xIM, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", pM.field_localId);
                                this.mtS.mController.xIM.startActivity(intent);
                                return;
                            case 3:
                                this.mtS.startTime = bh.Wo();
                                x.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", new Object[]{Integer.valueOf(adapterContextMenuInfo.position)});
                                this.mtS.mtR = this.mtS.mtM.pM((adapterContextMenuInfo.position - this.mtS.mrI.getHeaderViewsCount()) - 1);
                                this.mtS.mtR = this.mtS.mtR.aHQ();
                                if (this.mtS.mtR != null) {
                                    List linkedList = new LinkedList();
                                    linkedList.add(this.mtS.mtR);
                                    if (j.a(linkedList, this.mtS, new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass17 mug;

                                        {
                                            this.mug = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            FavoriteIndexUI.a(this.mug.mtS, 4106);
                                        }
                                    })) {
                                        FavoriteIndexUI.a(this.mtS, 4106);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int mtL = 0;
    private com.tencent.mm.plugin.favorite.ui.a.b mtM;
    private com.tencent.mm.plugin.favorite.ui.base.b mtN;
    private f mtO;
    private e mtP = new e(this) {
        final /* synthetic */ FavoriteIndexUI mtS;

        {
            this.mtS = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            this.mtS.mrO.post(new 1(this));
        }
    };
    private OnItemLongClickListener mtQ = new OnItemLongClickListener(this) {
        final /* synthetic */ FavoriteIndexUI mtS;

        {
            this.mtS = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < this.mtS.mrI.getHeaderViewsCount()) {
                x.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
            } else {
                this.mtS.contextMenuHelper.a(view, i, j, this.mtS, this.mtS.kBR);
            }
            return true;
        }
    };
    private f mtR;
    private long startTime = 0;

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, int i) {
        boolean z = false;
        if (i == 4105) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 1);
            intent.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.mtM.aJw() == 1) {
                intent.putExtra("select_fav_local_id", ((f) favoriteIndexUI.mtM.fc(false).get(0)).field_localId);
                if (favoriteIndexUI.mtM.fc(false).get(0) != null && ((f) favoriteIndexUI.mtM.fc(false).get(0)).field_type == 3) {
                    h.bu(favoriteIndexUI.getApplicationContext(), favoriteIndexUI.getString(R.l.egs));
                    return;
                }
            }
            int i2;
            intent.putExtra("Retr_Msg_Type", 17);
            com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
            for (f e : favoriteIndexUI.mtM.fc(false)) {
                if (!dVar.e(e)) {
                    i2++;
                }
            }
            intent.putExtra("select_fav_select_count", i2);
            com.tencent.mm.bm.d.a(favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent, 4105);
        } else if (i == 4106) {
            Intent intent2 = new Intent();
            intent2.putExtra("Select_Conv_Type", 3);
            intent2.putExtra("scene_from", 1);
            intent2.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.mtR != null) {
                intent2.putExtra("select_fav_local_id", favoriteIndexUI.mtR.field_localId);
            }
            if (favoriteIndexUI.mtR != null) {
                int i3 = favoriteIndexUI.mtR.field_type;
                if (i3 == 1) {
                    z = true;
                } else if (i3 != 2) {
                    z = i3 == 16 ? true : i3 == 4 ? true : i3 == 14 ? true : i3 == 6 ? true : true;
                }
                if (!z) {
                    intent2.putExtra("Retr_Msg_Type", favoriteIndexUI.mtR.field_type);
                }
            }
            com.tencent.mm.bm.d.a(favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent2, 4106);
        }
    }

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, List list) {
        if (list != null && !list.isEmpty()) {
            ar.Dm().F(new 3(favoriteIndexUI, list, h.a(favoriteIndexUI.mController.xIM, favoriteIndexUI.getString(R.l.eeJ), false, null)));
        }
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, f fVar) {
        favoriteIndexUI.mtM.a(true, fVar);
        favoriteIndexUI.mrI.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = favoriteIndexUI.mtN;
        if (!bVar.muO) {
            if (bVar.muP != null) {
                if (bVar.muP instanceof ViewStub) {
                    bVar.muP = ((ViewStub) bVar.muP).inflate();
                }
                bVar.muS = (ImageButton) bVar.muP.findViewById(R.h.cgD);
                bVar.muS.setEnabled(false);
                bVar.muS.setContentDescription(bVar.muS.getContext().getString(R.l.eRy));
                bVar.muS.setOnClickListener(new 1(bVar));
                bVar.muT = (ImageButton) bVar.muP.findViewById(R.h.cgA);
                bVar.muT.setEnabled(false);
                bVar.muT.setContentDescription(bVar.muT.getContext().getString(R.l.dZi));
                bVar.muT.setOnClickListener(new 2(bVar));
                bVar.muU = (ImageButton) bVar.muP.findViewById(R.h.cgB);
                bVar.muU.setEnabled(false);
                bVar.muU.setContentDescription(bVar.muU.getContext().getString(R.l.dYp));
                bVar.muU.setOnClickListener(new 3(bVar));
                bVar.muO = true;
            } else {
                return;
            }
        }
        if (bVar.muP.getVisibility() != 0) {
            bVar.muP.setVisibility(0);
            bVar.muP.startAnimation(AnimationUtils.loadAnimation(bVar.muP.getContext(), R.a.bpZ));
        }
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b koVar = new ko();
        if (com.tencent.mm.pluginsdk.model.c.vdg) {
            koVar.fBM.field_localId = currentTimeMillis;
        } else {
            koVar.fBM.field_localId = -1;
        }
        koVar.fBM.context = favoriteIndexUI.mController.xIM;
        koVar.fBM.type = 9;
        com.tencent.mm.sdk.b.a.xef.m(koVar);
        com.tencent.mm.sdk.b.b kpVar = new kp();
        kpVar.fBX.context = favoriteIndexUI.mController.xIM;
        kpVar.fBX.type = 3;
        kpVar.fBX.fBS = 1;
        com.tencent.mm.sdk.b.a.xef.m(kpVar);
    }

    public void onCreate(Bundle bundle) {
        this.mrP = this;
        x.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aHY() == null) {
            x.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            return;
        }
        com.tencent.mm.plugin.favorite.h.aIr().eX(false);
        setMMTitle(R.l.efC);
        setBackBtn(new 1(this));
        this.mrI.setOnItemLongClickListener(this.mtQ);
        ar.CG().a(438, this.mtP);
        ar.CG().a(401, this.mtP);
        this.contextMenuHelper = new l(this);
        addIconOptionMenu(11, R.l.dCl, R.k.duO, new 21(this));
        this.mtN = new com.tencent.mm.plugin.favorite.ui.base.b();
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mtN;
        View findViewById = findViewById(R.h.cgC);
        bVar.muO = false;
        bVar.muP = findViewById;
        this.mtN.muV = new com.tencent.mm.plugin.favorite.ui.base.b.a(this) {
            final /* synthetic */ FavoriteIndexUI mtS;

            {
                this.mtS = r1;
            }

            public final void aJo() {
                if (j.a(this.mtS.mtM.fc(false), this.mtS, new 1(this))) {
                    FavoriteIndexUI.a(this.mtS, 4105);
                }
            }

            public final void aJg() {
                h.a(this.mtS.mController.xIM, this.mtS.getString(R.l.eeI), "", new 2(this), null);
            }

            public final void aJp() {
                if (this.mtS.mtM.aJw() > 0) {
                    if (this.mtS.mtM.aJw() > 1) {
                        Intent intent = new Intent(this.mtS.mController.xIM, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 3);
                        this.mtS.startActivityForResult(intent, 4104);
                        return;
                    }
                    f fVar = (f) this.mtS.mtM.fc(false).get(0);
                    Intent intent2 = new Intent(this.mtS.mController.xIM, FavTagEditUI.class);
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", fVar.field_localId);
                    this.mtS.startActivity(intent2);
                    if (this.mtS.mtM.mup) {
                        this.mtS.aJm();
                    }
                }
            }
        };
        ar.Dm().F(new 14(this));
        com.tencent.mm.plugin.favorite.a.a.aIw().a(null);
        com.tencent.mm.pluginsdk.model.c.bYm();
    }

    protected final void aJf() {
        super.aJf();
        this.hae.post(new Runnable(this) {
            final /* synthetic */ FavoriteIndexUI mtS;

            {
                this.mtS = r1;
            }

            public final void run() {
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aHY() != null) {
            com.tencent.mm.plugin.favorite.h.aIr().eX(true);
            if (this.mtM != null) {
                this.mtM.finish();
            }
            com.tencent.mm.sdk.b.b koVar = new ko();
            koVar.fBM.type = 12;
            com.tencent.mm.sdk.b.a.xef.m(koVar);
            ar.CG().b(438, this.mtP);
            ar.CG().b(401, this.mtP);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i || !this.mtM.mup) {
            return super.onKeyUp(i, keyEvent);
        }
        aJm();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
        f pM = this.mtM.pM((((AdapterContextMenuInfo) contextMenuInfo).position - this.mrI.getHeaderViewsCount()) - 1);
        switch (this.mtL) {
            case 0:
                contextMenu.setHeaderTitle(R.l.dGO);
                boolean e = dVar.e(pM);
                if (!e) {
                    contextMenu.add(0, 3, 0, R.l.egr);
                }
                if (e && j.u(pM)) {
                    contextMenu.add(0, 3, 0, R.l.egr);
                }
                contextMenu.add(0, 2, 0, R.l.eeY);
                contextMenu.add(0, 0, 0, R.l.eeH);
                contextMenu.add(0, 1, 0, R.l.efQ);
                return;
            default:
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                return;
        }
    }

    private void aJm() {
        this.mtM.a(false, null);
        this.mrI.setOnItemLongClickListener(this.mtQ);
        showOptionMenu(11, true);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mtN;
        if (bVar.muO && bVar.muP.getVisibility() != 8) {
            bVar.muP.setVisibility(8);
            bVar.muP.startAnimation(AnimationUtils.loadAnimation(bVar.muP.getContext(), R.a.bqa));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.mtL) {
            case 0:
                if (this.mtM != null) {
                    this.mtM.onItemClick(adapterView, view, i, j);
                    com.tencent.mm.plugin.favorite.ui.b.a.b bVar = (com.tencent.mm.plugin.favorite.ui.b.a.b) view.getTag();
                    if (bVar == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                        return;
                    } else if (bVar.mqC == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        return;
                    } else {
                        x.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[]{Integer.valueOf(bVar.mqC.field_type)});
                        g.pQN.h(12746, new Object[]{Integer.valueOf(bVar.mqC.field_type), Integer.valueOf(0), Integer.valueOf(i - 1)});
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a aJb() {
        if (this.mtM == null) {
            ActionBarActivity actionBarActivity = this.mController.xIM;
            this.mtM = new com.tencent.mm.plugin.favorite.ui.a.b(this.mpb, false);
            this.mtM.a(new a$a(this) {
                final /* synthetic */ FavoriteIndexUI mtS;

                {
                    this.mtS = r1;
                }

                public final void aJq() {
                    this.mtS.mrO.fd(true);
                }
            });
            this.mtM.muw = this;
            this.mtM.scene = 1;
            this.mtM.muz = this.mrI;
        }
        return this.mtM;
    }

    protected final void aJc() {
        this.mrO.post(new 19(this));
    }

    protected final boolean aJd() {
        int aHZ;
        switch (this.mtL) {
            case 3:
                aHZ = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aHZ();
                break;
            default:
                aHZ = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().getCount();
                break;
        }
        if (aHZ > 0) {
            return true;
        }
        return false;
    }

    protected final void aJe() {
        switch (this.mtL) {
            case 3:
                this.mrJ.setCompoundDrawablesWithIntrinsicBounds(0, R.k.dyy, 0, 0);
                this.mrJ.setCompoundDrawablePadding(com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 10));
                this.mrJ.setText(R.l.efb);
                return;
            default:
                this.mrJ.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bCe, 0, 0);
                this.mrJ.setCompoundDrawablePadding(com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 10));
                this.mrJ.setText(R.l.efa);
                return;
        }
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.hae.post(new 20(this));
        x.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected final void initHeaderView() {
        super.initHeaderView();
        this.mrO.fd(false);
    }

    private void a(List<f> list, String str, String str2) {
        if (list != null && !list.isEmpty() && !bh.ov(str2)) {
            boolean eV = s.eV(str2);
            com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
            List<f> linkedList = new LinkedList();
            for (f fVar : list) {
                if (!dVar.e(fVar)) {
                    g.pQN.h(10651, new Object[]{Integer.valueOf(fVar.field_type), Integer.valueOf(1), Integer.valueOf(0)});
                    linkedList.add(fVar);
                    com.tencent.mm.plugin.favorite.a.h.a(eV ? com.tencent.mm.plugin.favorite.a.h.c.mqe : com.tencent.mm.plugin.favorite.a.h.c.mqd, fVar, com.tencent.mm.plugin.favorite.a.h.d.Samll, eV ? m.gl(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                x.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                h.bu(getApplicationContext(), getString(R.l.egs));
                return;
            }
            com.tencent.mm.plugin.favorite.a.e.a(this.mController.xIM, str2, str, linkedList, new 5(this, h.a(this.mController.xIM, getString(R.l.efz), false, null)));
            for (f fVar2 : linkedList) {
                if (fVar2 != null && fVar2.field_type == 5) {
                    String str3 = "";
                    if (fVar2.field_favProto.web != null) {
                        str3 = fVar2.field_favProto.web.wfz;
                    }
                    if (fVar2.field_favProto.weS != null && bh.ov(r1)) {
                        str3 = fVar2.field_favProto.weS.hOf;
                    }
                    if (!bh.ov(str3)) {
                        x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        g.pQN.h(13378, new Object[]{str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                    }
                }
            }
            g.pQN.h(11125, new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(1)});
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String stringExtra;
        String stringExtra2;
        if (i2 == -1) {
            int i3 = 2;
            stringExtra = intent.getStringExtra("custom_send_text");
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        i3 = 0;
                        this.mrL.post(new 7(this, stringArrayListExtra));
                        break;
                    }
                    x.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    return;
                    break;
                case 4097:
                    this.mrL.post(new 8(this, intent.getDoubleExtra("kwebmap_slat", 0.0d), intent.getDoubleExtra("kwebmap_lng", 0.0d), intent.getIntExtra("kwebmap_scale", 0), bh.az(intent.getStringExtra("Kwebmap_locaion"), ""), intent.getCharSequenceExtra("kRemark"), intent.getStringExtra("kPoiName"), intent.getStringArrayListExtra("kTags")));
                    i3 = 0;
                    break;
                case 4098:
                    Context applicationContext = getApplicationContext();
                    ar.Hg();
                    stringExtra = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, com.tencent.mm.z.c.Fi());
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_ImgPath", stringExtra);
                        com.tencent.mm.plugin.favorite.d.ifs.a(this, intent2, 4099);
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    return;
                case 4099:
                    stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        i3 = 0;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(stringExtra);
                        this.mrL.post(new 6(this, arrayList));
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    return;
                case 4100:
                    stringExtra2 = intent.getStringExtra("choosed_file_path");
                    if (!bh.ov(stringExtra2)) {
                        File file = new File(stringExtra2);
                        if (file.exists()) {
                            if (file.length() < mtK) {
                                Object obj;
                                if (bh.ov(stringExtra2)) {
                                    obj = null;
                                } else {
                                    file = new File(stringExtra2);
                                    if (file.exists()) {
                                        f fVar = new f();
                                        fVar.field_type = 8;
                                        fVar.field_sourceType = 6;
                                        com.tencent.mm.plugin.favorite.a.c.j(fVar);
                                        fVar.field_favProto.Ug(file.getName());
                                        uq uqVar = new uq();
                                        uqVar.TE(stringExtra2);
                                        uqVar.lt(true);
                                        uqVar.Tq(file.getName());
                                        uqVar.CJ(fVar.field_type);
                                        uqVar.TA(com.tencent.mm.a.e.bQ(stringExtra2));
                                        fVar.field_favProto.weU.add(uqVar);
                                        com.tencent.mm.plugin.favorite.b.a.B(fVar);
                                        g.pQN.h(10648, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                }
                                if (obj == null) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = 0;
                                this.mrF = true;
                                break;
                            }
                            i3 = 3;
                            break;
                        }
                        i3 = 1;
                        break;
                    }
                    i3 = 1;
                    break;
                case 4101:
                case 4102:
                    i3 = 0;
                    this.mrF = true;
                    break;
                case 4103:
                    long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                    if (-1 != longExtra) {
                        i3 = this.mtM.dr(longExtra);
                        if (-1 != i3) {
                            this.mrI.removeFooterView(this.mrM);
                            this.mrI.setSelection(i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 4104:
                    List fc = this.mtM.fc(false);
                    String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                    if (!(fc.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                        ar.Dm().F(new 4(this, fc, stringArrayExtra, h.a(this.mController.xIM, "", false, null)));
                        g.pQN.h(11125, new Object[]{Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2)});
                        break;
                    }
                case 4105:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    a(this.mtM.fc(false), stringExtra, r4);
                    break;
                case 4106:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    List arrayList2 = new ArrayList();
                    arrayList2.add(this.mtR);
                    a(arrayList2, stringExtra, r4);
                    break;
            }
            if (i3 == 0) {
                h.bu(this.mController.xIM, getString(R.l.efV));
            } else if (1 == i3) {
                h.bu(this.mController.xIM, getString(R.l.efg));
            } else if (3 == i3) {
                Toast.makeText(this.mController.xIM, getString(R.l.egO), 1).show();
            } else if (this.mtM.mup) {
                aJm();
            }
        } else if ((this.mtR != null && this.mtR.field_type == 5) || (this.mtO != null && this.mtO.field_type == 5)) {
            stringExtra2 = "";
            if (this.mtO == null || this.mtO.field_favProto.weS == null) {
                if (this.mtR.field_favProto.web != null) {
                    stringExtra2 = this.mtR.field_favProto.web.wfz;
                }
                if (this.mtR.field_favProto.weS != null && bh.ov(r2)) {
                    stringExtra2 = this.mtR.field_favProto.weS.hOf;
                }
            } else {
                stringExtra2 = this.mtO.field_favProto.weS.hOf;
            }
            if (!bh.ov(stringExtra2)) {
                x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
                stringExtra = "";
                try {
                    stringExtra2 = URLEncoder.encode(stringExtra2, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                    stringExtra2 = stringExtra;
                }
                g.pQN.h(13378, new Object[]{stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void dq(long j) {
        if (this.mtM.mup) {
            com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mtN;
            boolean z = this.mtM.aJw() > 0;
            if (bVar.muO) {
                bVar.muS.setEnabled(z);
                bVar.muT.setEnabled(z);
                bVar.muU.setEnabled(z);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, 10, 0, R.l.eRj);
        add.setIcon(R.k.dvb);
        android.support.v4.view.m.a(add, 2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 10) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this.mController.xIM, FavSearchUI.class);
        intent.putExtra("key_enter_fav_search_from", 0);
        if (this.mtM.mup) {
            intent.putExtra("key_search_type", 2);
            startActivityForResult(intent, 4103);
        } else {
            startActivity(intent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    Intent intent = new Intent();
                    intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                    intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.plugin.favorite.d.ifs.a(intent, 4097, this);
                    return;
                }
                h.a(this, getString(R.l.ezP), "", getString(R.l.est), getString(R.l.cancel), false, new 12(this), new OnClickListener(this) {
                    final /* synthetic */ FavoriteIndexUI mtS;

                    {
                        this.mtS = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case 80:
                if (iArr[0] == 0) {
                    startActivityForResult(new Intent(this, FavPostVoiceUI.class), 4102);
                    overridePendingTransition(0, 0);
                    return;
                }
                h.a(this, getString(R.l.ezQ), "", getString(R.l.est), getString(R.l.cancel), false, new 10(this), new 11(this));
                return;
            default:
                return;
        }
    }

    public final void aJn() {
        Intent intent = new Intent(this.mController.xIM, FavCleanUI.class);
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        this.mController.xIM.startActivity(intent);
    }
}
