package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> pGQ = new HashMap();
    private OnClickListener mtg = new OnClickListener(this) {
        final /* synthetic */ c pGR;

        {
            this.pGR = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.bjS == 0) {
                if (h.d(bVar.fve, bVar.fqm)) {
                    x.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar.fqm);
                    intent.putExtra("record_xml", bVar.fEG);
                    intent.putExtra("record_data_id", bVar.fve.mvG);
                    view.getContext().startActivity(intent);
                    return;
                }
                f Ij = n.getRecordMsgCDNStorage().Ij(h.d(bVar.fve.mvG, bVar.fqm, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = Ij == null ? "null" : Integer.valueOf(Ij.field_status);
                x.i(str, str2, objArr);
                if (!(Ij == null || 2 == Ij.field_status || 3 == Ij.field_status)) {
                    if (4 == Ij.field_status) {
                        com.tencent.mm.ui.base.h.bu(view.getContext(), view.getResources().getString(R.l.egp));
                        return;
                    } else if (Ij.field_status == 0 || 1 == Ij.field_status) {
                        return;
                    }
                }
                h.a(bVar.fve, bVar.fqm, true);
            } else if (bVar.bjS == 1) {
                com.tencent.mm.sdk.b.b fvVar;
                x.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(bVar.pFG.field_id), Long.valueOf(bVar.pFG.field_localId), Integer.valueOf(bVar.pFG.field_itemStatus)});
                if (bVar.pFG.isDone()) {
                    fvVar = new fv();
                    fvVar.fvq.type = 14;
                    fvVar.fvq.fvs = bVar.fve;
                    a.xef.m(fvVar);
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[]{Integer.valueOf(fvVar.fvr.ret)});
                    if (fvVar.fvr.ret == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.pFG.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fve.mvG);
                        intent.putExtra("key_detail_can_delete", false);
                        d.b(view.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        return;
                    } else if (bh.ov(bVar.fve.wcJ)) {
                        x.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        return;
                    } else {
                        x.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar.pFG.aHN() || bVar.pFG.aHM()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar.pFG.isDownloading() || bVar.pFG.aHL()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    return;
                } else {
                    x.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                fvVar = new fv();
                fvVar.fvq.fqk = bVar.pFG.field_localId;
                if (bVar.pFG.aHM()) {
                    x.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    fvVar.fvq.type = 15;
                    a.xef.m(fvVar);
                    return;
                }
                x.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                fvVar.fvq.type = 16;
                a.xef.m(fvVar);
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a pGb;

    public c(com.tencent.mm.plugin.record.ui.h.a aVar) {
        this.pGb = aVar;
    }

    public final View dp(Context context) {
        View inflate = View.inflate(context, R.i.dqv, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.h.image)).wj(com.tencent.mm.bv.a.fromDPToPix(context, GameJsApiLaunchApplication.CTRL_BYTE));
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        view.setTag(bVar);
        view.setOnClickListener(this.mtg);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.image);
        ImageView imageView = (ImageView) view.findViewById(R.h.cPl);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
        aVar.cR(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.pGb;
        Map map = pGQ;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.fve = cVar.fve;
        String c;
        if (cVar.bjS == 0) {
            cVar2.pGd = cVar.fqm;
            if (h.d(cVar.fve, cVar.fqm)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = h.c(cVar.fve, cVar.fqm);
                if (!c.equals(aVar.Ur())) {
                    aVar.B(aVar2.a(cVar2));
                }
                aVar.aA(c, false);
                return;
            }
            f Ij = n.getRecordMsgCDNStorage().Ij(h.d(cVar.fve.mvG, cVar.fqm, true));
            if (Ij == null || 2 == Ij.field_status) {
                imageView.setImageResource(R.k.dAI);
            } else if (3 == Ij.field_status || 4 == Ij.field_status) {
                imageView.setImageResource(R.g.bGf);
            } else if (Ij.field_status == 0 || 1 == Ij.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) Ij.field_offset) / ((float) Math.max(1, Ij.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.B(aVar2.a(cVar2));
                return;
            } else {
                imageView.setImageResource(R.k.dAI);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.B(aVar2.a(cVar2));
        } else if (cVar.bjS == 1) {
            map.put(cVar.fve.mvG, view);
            x.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[]{Long.valueOf(cVar.pFG.field_localId), Integer.valueOf(cVar.pFG.field_itemStatus)});
            cVar2.pGd = cVar.pFG.field_localId;
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 14;
            fvVar.fvq.fvs = cVar.fve;
            a.xef.m(fvVar);
            if (cVar.pFG.isDone() || fvVar.fvr.ret == 1) {
                if (fvVar.fvr.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    fvVar.fvq.type = 2;
                    a.xef.m(fvVar);
                    c = fvVar.fvr.path;
                    if (bh.ov(c)) {
                        x.w("MicroMsg.SightRecordData", "videoPath is null!");
                        return;
                    }
                    if (!c.equals(aVar.Ur())) {
                        aVar.B(aVar2.a(cVar2));
                    }
                    aVar.aA(c, false);
                    return;
                } else if (bh.ov(cVar.fve.wcJ)) {
                    imageView.setImageResource(R.g.bGf);
                } else {
                    x.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.k.dAI);
                }
            } else if (cVar.pFG.aHN() || cVar.pFG.aHM()) {
                imageView.setImageResource(R.k.dAI);
            } else if (cVar.pFG.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.cyN();
                aVar.clear();
                aVar.B(aVar2.a(cVar2));
                return;
            } else {
                x.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.k.dAI);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.B(aVar2.a(cVar2));
        }
    }

    public final void destroy() {
        this.pGb = null;
    }

    public final void pause() {
    }
}
