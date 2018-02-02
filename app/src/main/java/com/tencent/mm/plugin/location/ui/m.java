package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object nUU = new Object();
    private a gyF = new 4(this);
    protected float kCe = 0.0f;
    private boolean kog = false;
    Context mContext;
    public brr nRM;
    private i.a nRY = new 5(this);
    d nSL;
    boolean nSM = false;
    public List<brr> nUT;
    public TrackPoint nUV;
    TrackPointAnimAvatar nUW;
    boolean nUX = false;
    public boolean nUY = false;
    public boolean nUZ = true;
    public boolean nVa = false;
    public boolean nVb = false;
    public boolean nVc = false;
    public bod nVd;
    public boolean nVe = true;
    public boolean nVf = true;
    private boolean nVg = false;
    private long nVh = 0;
    private OnTouchListener nVi = new OnTouchListener(this) {
        final /* synthetic */ m nVm;

        {
            this.nVm = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nVm.nlE = motionEvent.getX();
                    this.nVm.kCe = motionEvent.getY();
                    this.nVm.nVh = System.currentTimeMillis();
                    this.nVm.kog = false;
                    break;
                case 1:
                    if (!this.nVm.kog && System.currentTimeMillis() - this.nVm.nVh < 200) {
                        m.c(this.nVm);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - this.nVm.nlE) > 10.0f || Math.abs(motionEvent.getY() - this.nVm.kCe) > 10.0f) {
                        this.nVm.kog = true;
                        break;
                    }
            }
            return false;
        }
    };
    OnClickListener nVj = new 2(this);
    OnClickListener nVk = new 3(this);
    public a nVl = null;
    protected float nlE = 0.0f;

    static /* synthetic */ boolean a(m mVar, int i, int i2) {
        if (mVar.nUT != null) {
            ArrayList arrayList = new ArrayList();
            float b = (float) b.b(mVar.mContext, 85.0f);
            for (brr com_tencent_mm_protocal_c_brr : mVar.nUT) {
                Point pointByGeoPoint = mVar.nSL.getPointByGeoPoint(com_tencent_mm_protocal_c_brr.wTo.vNP, com_tencent_mm_protocal_c_brr.wTo.vNO);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNO), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y)});
                if (f.l(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) b)) {
                    arrayList.add(com_tencent_mm_protocal_c_brr.vIy);
                }
            }
            if (mVar.nRM != null) {
                Point pointByGeoPoint2 = mVar.nSL.getPointByGeoPoint(mVar.nRM.wTo.vNP, mVar.nRM.wTo.vNO);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(mVar.nRM.wTo.vNP), Double.valueOf(mVar.nRM.wTo.vNO), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y)});
                if (f.l(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) b)) {
                    arrayList.add(mVar.nRM.vIy);
                }
            }
            x.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", new Object[]{Integer.valueOf(arrayList.size())});
            if (arrayList.size() > 1) {
                g.pQN.h(10997, new Object[]{"12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                b.b(mVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void c(m mVar) {
        boolean z = true;
        if (mVar.nVb) {
            mVar.gp(false);
        }
        Collection<View> childs = mVar.nSL.getChilds();
        for (View view : childs) {
            if (view instanceof TrackPoint) {
                if (((TrackPoint) view).nYq.getVisibility() == 0) {
                    break;
                }
            }
        }
        z = false;
        for (View view2 : childs) {
            if (view2 instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) view2).aWI();
                } else {
                    ((TrackPoint) view2).aWJ();
                }
            }
        }
    }

    public m(Context context, d dVar, boolean z) {
        this.mContext = context;
        this.nSM = z;
        this.nSL = dVar;
        this.nUT = new ArrayList();
        dVar.setMapViewOnTouchListener(this.nVi);
    }

    public final void gp(boolean z) {
        if (z) {
            if ((this.nUV != null ? 1 : 0) != 0) {
                g.pQN.h(10997, new Object[]{"20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else {
                return;
            }
        }
        this.nVb = z;
    }

    public final void destroy() {
        synchronized (nUU) {
            if (this.nUT != null) {
                this.nUT.clear();
            }
        }
    }

    public final void gq(boolean z) {
        if (!(!z || this.nVa || this.nSL == null)) {
            for (View view : this.nSL.getChilds()) {
                if (view instanceof TrackPoint) {
                    ((TrackPoint) view).aWJ();
                }
            }
        }
        this.nVa = z;
    }

    public final void bb(List<brr> list) {
        this.nUX = true;
        int size = this.nUT.size() + 1;
        synchronized (nUU) {
            this.nUT.clear();
            for (int i = 0; i < list.size(); i++) {
                this.nUT.add(list.get(i));
            }
        }
        int size2 = this.nUT.size() + 1;
        synchronized (nUU) {
            Set<String> tags = this.nSL.getTags();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < this.nUT.size(); i2++) {
                hashSet.add(((brr) this.nUT.get(i2)).vIy);
            }
            List<String> linkedList = new LinkedList();
            for (String str : tags) {
                if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                    if (this.nUV == null || !this.nUV.equals(this.nSL.getViewByItag(str))) {
                        linkedList.add(str);
                    }
                }
            }
            for (String str2 : linkedList) {
                this.nSL.removeViewByTag(str2);
            }
            for (int i3 = 0; i3 < this.nUT.size(); i3++) {
                View view;
                brr com_tencent_mm_protocal_c_brr = (brr) this.nUT.get(i3);
                View viewByItag = this.nSL.getViewByItag(com_tencent_mm_protocal_c_brr.vIy);
                x.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[]{Integer.valueOf(i3), com_tencent_mm_protocal_c_brr.vIy, Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNO), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.wEE)});
                if (viewByItag != null) {
                    this.nSL.updateViewLayout(viewByItag, com_tencent_mm_protocal_c_brr.wTo.vNP, com_tencent_mm_protocal_c_brr.wTo.vNO);
                    view = viewByItag;
                } else {
                    viewByItag = new TrackPoint(this.mContext);
                    viewByItag.setVisibility(0);
                    if (!this.nUZ) {
                        ((TrackPoint) viewByItag).aWK();
                    }
                    this.nSL.addView(viewByItag, com_tencent_mm_protocal_c_brr.wTo.vNP, com_tencent_mm_protocal_c_brr.wTo.vNO, com_tencent_mm_protocal_c_brr.vIy);
                    ((TrackPoint) viewByItag).h(this.nVk);
                    ((TrackPoint) viewByItag).g(this.nVj);
                    view = viewByItag;
                }
                if (view instanceof TrackPoint) {
                    TrackPoint trackPoint = (TrackPoint) view;
                    trackPoint.DR(com_tencent_mm_protocal_c_brr.vIy);
                    trackPoint.o(com_tencent_mm_protocal_c_brr.wTo.wEE);
                    if (!this.nVa) {
                        trackPoint.aWI();
                    }
                }
            }
            if (this.nSM && this.nUX) {
                if (s.eV(l.aVu().nRR)) {
                    aWl();
                } else if (this.nUT.size() > 0) {
                    aWl();
                }
            }
            if (size < 10 && size2 >= 10) {
                for (View view2 : this.nSL.getChilds()) {
                    if (view2 instanceof TrackPoint) {
                        ((TrackPoint) view2).aWI();
                    }
                }
            } else if (size >= 10 && size2 < 10) {
                for (View view22 : this.nSL.getChilds()) {
                    if (view22 instanceof TrackPoint) {
                        ((TrackPoint) view22).aWJ();
                    }
                }
            }
        }
    }

    final void aWl() {
        if (!this.nUY && this.nRM != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            if (this.nRM != null) {
                LocationInfo locationInfo = l.aVu().nRN;
                if (this.nRM != null && e.h(locationInfo.nQx, locationInfo.nQy)) {
                    d = 2.0d * Math.abs(this.nRM.wTo.vNP - locationInfo.nQx);
                    d2 = Math.abs(this.nRM.wTo.vNO - locationInfo.nQy) * 2.0d;
                }
                double d3 = d2;
                double d4 = d;
                for (int i = 0; i < this.nUT.size(); i++) {
                    brr com_tencent_mm_protocal_c_brr = (brr) this.nUT.get(i);
                    if (com_tencent_mm_protocal_c_brr != null && e.h(com_tencent_mm_protocal_c_brr.wTo.vNP, com_tencent_mm_protocal_c_brr.wTo.vNO)) {
                        double abs = 2.0d * Math.abs(com_tencent_mm_protocal_c_brr.wTo.vNP - this.nRM.wTo.vNP);
                        d = Math.abs(com_tencent_mm_protocal_c_brr.wTo.vNO - this.nRM.wTo.vNO) * 2.0d;
                        if (abs > d4) {
                            d4 = abs;
                        }
                        if (d > d3) {
                            d3 = d;
                        }
                        x.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[]{com_tencent_mm_protocal_c_brr.vIy, Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNP), Double.valueOf(com_tencent_mm_protocal_c_brr.wTo.vNO)});
                    }
                }
                if (Math.abs(d4 - -1000.0d) >= 0.5d && Math.abs(d3 - -1000.0d) >= 0.5d) {
                    x.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.nQx + " " + locationInfo.nQy);
                    if (this.nRM != null) {
                        x.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[]{Double.valueOf(this.nRM.wTo.vNP), Double.valueOf(this.nRM.wTo.vNO)});
                        this.nSL.zoomToSpan(this.nRM.wTo.vNP, this.nRM.wTo.vNO, d4, d3);
                    } else if (e.h(locationInfo.nQx, locationInfo.nQy)) {
                        this.nSL.zoomToSpan(locationInfo.nQx, locationInfo.nQy, d4, d3);
                    }
                }
            }
            this.nUY = true;
        }
    }

    public final void a(d dVar) {
        if (this.nRM != null) {
            double d = this.nRM.wTo.vNO;
            dVar.getIController().animateTo(this.nRM.wTo.vNP, d);
            if (dVar.getZoomLevel() < 16) {
                dVar.getIController().setZoom(16);
            }
        }
    }

    public final void onResume() {
        c.OP().b(this.gyF, true);
        l.aVw().a(this.nRY);
    }

    public final void onPause() {
        c.OP().c(this.gyF);
        l.aVw().b(this.nRY);
    }
}
