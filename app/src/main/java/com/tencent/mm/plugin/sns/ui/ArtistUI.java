package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

public class ArtistUI extends MMActivity implements e {
    private SharedPreferences gZO;
    private ListView kGl;
    private String nQA = "";
    private g rqU;
    private ArtistHeader rqV;
    private k rqW = null;
    private r tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String d = w.d(getSharedPreferences(ac.cfs(), 0));
        x.d("MicroMsg.ArtistUI", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nQA = d;
        x.d("MicroMsg.ArtistUI", "lan " + this.nQA);
        g.Dk();
        g.Di().gPJ.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        this.gZO = getSharedPreferences(ac.cfs(), 0);
        initView();
        ae.bvq().a(this.rqV);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog = null;
        }
        if (this.rqV != null) {
            ae.bvq().b(this.rqV);
        }
        ae.bvs().K(this);
        g.Dk();
        g.Di().gPJ.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        setMMTitle(j.qJP);
        getString(j.dGO);
        this.tipDialog = h.a(this, getString(j.dFy), true, new 1(this));
        this.kGl = (ListView) findViewById(f.qEb);
        a.ift.aH(false);
        this.rqU = new g(this, this.nQA, new b(this) {
            final /* synthetic */ ArtistUI rqX;

            {
                this.rqX = r1;
            }

            public final void xq(int i) {
                Intent intent = new Intent();
                intent.putExtra("sns_gallery_is_artist", true);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_artist_lan", this.rqX.nQA);
                intent.putExtra("sns_gallery_showtype", 2);
                intent.setClass(this.rqX, ArtistBrowseUI.class);
                this.rqX.startActivity(intent);
            }
        }, new 3(this));
        this.rqV = new ArtistHeader(this);
        this.kGl.addHeaderView(this.rqV);
        this.kGl.setAdapter(this.rqU);
        this.rqU.notifyDataSetChanged();
        this.rqV.setVisibility(8);
        setBackBtn(new 4(this));
    }

    protected final int getLayoutId() {
        return i.g.qHd;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof m) && ((m) kVar).Kl() == 4) {
            x.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                        if (this.rqU != null) {
                            this.rqU.Xy();
                        }
                        this.rqW = null;
                        return;
                    default:
                        return;
                }
            } else if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX && this.tipDialog != null) {
                this.tipDialog.dismiss();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.ArtistUI", "another scene");
    }
}
