package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static Map<String, Integer> nrQ = new HashMap();
    private static int nrS = 6;
    private static int nrT = 7;
    private int count = 0;
    private Context mContext;
    LinkedList<f> ndF = new LinkedList();
    int ndn = 0;
    private TextView nkI;
    b noH = new 2(this);
    private LinearLayout nrN;
    private ImageView nrO;
    private TextView nrP;
    private final DisplayMetrics nrR = new DisplayMetrics();
    private int nrU = 4;
    private int nrV = 1;
    private int nrW = 999;
    a nrX;
    LinkedList<d> nrY;
    LayoutParams nrZ = new LayoutParams(-1, -2);

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nrN = (LinearLayout) findViewById(R.h.cmr);
        n.a(this.noH);
    }

    public final void eJ(boolean z) {
        if (bh.cA(this.nrY)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.ndF = g.aPW();
            if (!(bh.cA(this.nrY) || bh.cA(this.ndF))) {
                it = this.nrY.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (this.ndF.contains(dVar)) {
                        this.ndF.remove(dVar);
                        this.ndF.addFirst(dVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.ndF);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(g.aPW());
            Collection linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(com.tencent.mm.pluginsdk.model.app.g.aZ(((f) it.next()).field_appId, true));
            }
            this.ndF = linkedList2;
        }
        aRD();
    }

    private void aRD() {
        if (bh.cA(this.ndF)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.nrN.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.ndF.size() >= this.nrU - 1) {
            nrT = 7;
            nrS = 6;
            int b = BackwardSupportUtil.b.b(this.mContext, (float) ((nrS << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.nrR);
            int i = (int) (((float) (this.nrR.widthPixels * JsApiSetBackgroundAudioState.CTRL_INDEX)) / ((float) this.nrR.densityDpi));
            this.nrU = ((this.nrR.widthPixels - 1) / b) + 1;
            if (this.nrU == 3) {
                nrT = 3;
            }
            b = (nrS << 1) + 84;
            int i2 = (nrS + 6) + nrT;
            i = (i - 16) % b;
            if (i < i2) {
                nrS -= 2;
                BackwardSupportUtil.b.b(this.mContext, (float) ((nrS << 1) + 84));
            } else if (i > b - i2) {
                nrS = ((i - (b >> 1)) / this.nrU) + nrS;
                BackwardSupportUtil.b.b(this.mContext, (float) ((nrS << 1) + 84));
            }
        }
        this.nrZ.setMargins(BackwardSupportUtil.b.b(this.mContext, (float) nrS), 0, BackwardSupportUtil.b.b(this.mContext, (float) nrS), 0);
        Iterator it = this.ndF.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(R.i.dlJ, null);
            this.nrO = (ImageView) inflate.findViewById(R.h.cml);
            this.nkI = (TextView) inflate.findViewById(R.h.cmV);
            this.nrP = (TextView) inflate.findViewById(R.h.cnj);
            Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(fVar.field_appId, 1, a.getDensity(this.mContext));
            if (b2 != null) {
                this.nrO.setImageBitmap(b2);
            } else {
                this.nrO.setImageResource(R.g.byX);
            }
            this.nkI.setText(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar, null));
            if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                int Cl = c.Cl(fVar.field_packageName);
                if (nrQ.containsKey(fVar.field_appId) && ((Integer) nrQ.get(fVar.field_appId)).intValue() > Cl) {
                    FileDownloadTaskInfo xI = com.tencent.mm.plugin.downloader.model.f.aAd().xI(fVar.field_appId);
                    this.nrP.setTextColor(this.mContext.getResources().getColor(R.e.bsA));
                    if (xI.status == 1) {
                        this.nrP.setText(R.l.elR);
                    } else {
                        this.nrP.setText(R.l.elQ);
                    }
                } else if (bh.ov(fVar.fQI)) {
                    this.nrP.setText("");
                } else {
                    this.nrP.setText(fVar.fQI);
                    this.nrP.setTextColor(this.mContext.getResources().getColor(R.e.bsD));
                }
            } else {
                this.nrP.setTextColor(this.mContext.getResources().getColor(R.e.bsA));
                this.nrP.setText(R.l.emr);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.nrN.addView(inflate, this.nrZ);
        }
        if (this.nrX != null && this.nrX.iconUrl != null && this.nrX.title != null) {
            View inflate2 = layoutInflater.inflate(R.i.dlJ, null);
            this.nrO = (ImageView) inflate2.findViewById(R.h.cml);
            this.nkI = (TextView) inflate2.findViewById(R.h.cmV);
            this.nrP = (TextView) inflate2.findViewById(R.h.cnj);
            com.tencent.mm.aq.a.a PA = o.PA();
            String str = this.nrX.iconUrl;
            ImageView imageView = this.nrO;
            com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
            aVar.hDz = true;
            PA.a(str, imageView, aVar.PK(), new 1(this, inflate2));
            this.nkI.setText(this.nrX.title);
            this.nrP.setVisibility(8);
            inflate2.setTag(this.nrX);
            inflate2.setOnClickListener(this);
        }
    }

    public static void B(Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            nrQ = map;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof f) {
                f fVar = (f) view.getTag();
                if (fVar == null || bh.ov(fVar.field_appId)) {
                    x.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                } else if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                    int Cl = c.Cl(fVar.field_packageName);
                    if (!nrQ.containsKey(fVar.field_appId) || ((Integer) nrQ.get(fVar.field_appId)).intValue() <= Cl) {
                        g.Y(this.mContext, fVar.field_appId);
                        ap.a(this.mContext, 10, 1002, this.nrV, 3, 0, fVar.field_appId, this.ndn, 0, null, null, null);
                        this.ndF.remove(fVar);
                        this.ndF.addFirst(fVar);
                    } else {
                        r0 = com.tencent.mm.plugin.downloader.model.f.aAd().xI(fVar.field_appId);
                        if (r0.status == 1) {
                            com.tencent.mm.plugin.downloader.model.f.aAd().bX(r0.id);
                        } else {
                            if (r0.status == 3) {
                                if (!e.bO(r0.path) || c.Cm(r0.path) <= Cl) {
                                    com.tencent.mm.plugin.downloader.model.f.aAd().bX(r0.id);
                                } else {
                                    q.e(this.mContext, Uri.fromFile(new File(r0.path)));
                                }
                            }
                            n.a(fVar.fQE, fVar.fQJ, 1002, fVar.field_appId, "");
                            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                            aVar.xL(fVar.fQE);
                            aVar.xN(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar, null));
                            aVar.setAppId(fVar.field_appId);
                            aVar.xO(fVar.fQJ);
                            aVar.ep(true);
                            aVar.ox(1);
                            com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE);
                        }
                    }
                    eJ(false);
                } else {
                    r0 = com.tencent.mm.plugin.downloader.model.f.aAd().xI(fVar.field_appId);
                    if (r0 == null || r0.status != 3) {
                        x.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", new Object[]{fVar.field_appName});
                        eJ(false);
                    } else if (bh.ov(r0.path) || !e.bO(r0.path)) {
                        x.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", new Object[]{r0.path});
                        com.tencent.mm.plugin.downloader.model.f.aAd().bX(r0.id);
                        eJ(false);
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(r0.path)));
                    }
                }
            } else if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (bh.ov(aVar2.jeE)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = c.p(this.mContext, aVar2.jeE, "game_center_installed_more");
                }
                ap.a(this.mContext, 10, 1002, this.nrW, i, 0, null, this.ndn, 0, null, null, null);
            }
        }
    }
}
