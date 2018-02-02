package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.1;
import com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.2;
import com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.3;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics pBy;
    private SnsEditText rwP;
    private z rwQ = null;
    private LinearLayout rwR;
    private SnsSightUploadSayFooter rwS;
    private int rwT = 0;
    private int rwU = 0;
    private ArrayList<String> rwV;
    private boolean rwW = false;
    private int rwX = 0;
    private boolean rwY = false;
    private long rwZ = 0;
    private String rwv = "";
    private String rww = "";

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        this.pBy = getResources().getDisplayMetrics();
        this.rwQ = new al(this);
        this.rwQ.F(bundle);
        this.rwR = (LinearLayout) findViewById(f.qGj);
        this.rwR.addView(this.rwQ.bzk());
        setMMTitle(j.qMv);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.black));
        this.rwY = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rwZ = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        e.i(this);
    }

    protected final int getLayoutId() {
        return g.qHQ;
    }

    protected final void initView() {
        this.rwP = (SnsEditText) findViewById(f.qEs);
        this.rwP.setTextSize(1, (ac.eu(this.mController.xIM) * this.rwP.getTextSize()) / a.getDensity(this.mController.xIM));
        this.rwP.postDelayed(new 1(this, this.pBy.widthPixels - (this.rwP.getPaddingLeft() + this.rwR.getPaddingRight())), 100);
        if (!bh.ov(getIntent().getStringExtra("Kdescription"))) {
            this.rwP.setText(getIntent().getStringExtra("Kdescription"));
        }
        this.rwP.ztP = new 2(this);
        this.rwS = (SnsSightUploadSayFooter) findViewById(f.cIF);
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rwS;
        MMEditText mMEditText = this.rwP;
        snsSightUploadSayFooter.rGA = mMEditText;
        mMEditText.setOnClickListener(new 1(snsSightUploadSayFooter));
        mMEditText.setOnEditorActionListener(new 2(snsSightUploadSayFooter));
        ag.h(new 3(snsSightUploadSayFooter), 200);
        this.rwS.setVisibility(0);
        setBackBtn(new 3(this));
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, i.qIS, new 4(this));
        }
        a(0, getString(j.dGA), new 5(this), b.xJB);
        enableOptionMenu(true);
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rwS;
        if (snsSightUploadSayFooter.okx.getVisibility() == 8) {
            snsSightUploadSayFooter.fmM.showVKB();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.rwQ.bzl();
        this.rwS.rGC.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rwS;
        if (snsSightUploadSayFooter.okx != null) {
            snsSightUploadSayFooter.okx.ti();
            snsSightUploadSayFooter.okx.destroy();
        }
    }

    protected void onPause() {
        super.onPause();
        aWs();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6 || i == 5 || i == 10) {
                SnsSightUploadSayFooter snsSightUploadSayFooter = this.rwS;
                if (intent != null) {
                    if (i == 10) {
                        snsSightUploadSayFooter.rGC.U(intent);
                    } else if (i == 5) {
                        snsSightUploadSayFooter.rGB.a(i, i2, intent, null);
                    }
                }
            }
            if (i == 5 && intent != null) {
                int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                if (intExtra >= 2) {
                    this.rwv = intent.getStringExtra("Klabel_name_list");
                    this.rww = intent.getStringExtra("Kother_user_name_list");
                    List<String> asList = Arrays.asList(this.rwv.split(","));
                    List list;
                    if (bh.ov(this.rww)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.rww.split(","));
                    }
                    this.rwV = new ArrayList();
                    if (asList != null && asList.size() > 0) {
                        for (String Do : asList) {
                            List<String> Dr = com.tencent.mm.plugin.label.a.a.aUX().Dr(com.tencent.mm.plugin.label.a.a.aUX().Do(Do));
                            if (Dr == null || Dr.size() == 0) {
                                x.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String Do2 : Dr) {
                                if (!this.rwV.contains(Do2)) {
                                    this.rwV.add(Do2);
                                    x.d("MicroMsg.SightUploadUI", "dz:name : %s", Do2);
                                }
                            }
                        }
                    }
                    if (asList != null) {
                        int i3 = 0;
                        for (String Do22 : asList) {
                            int i4;
                            if (bh.ov(Do22)) {
                                i4 = i3;
                            } else {
                                i4 = i3 + 1;
                            }
                            i3 = i4;
                        }
                        this.rwT = i3;
                    }
                    this.rwU = 0;
                    if (r1 != null && r1.size() > 0) {
                        for (String Do222 : r1) {
                            if (!this.rwV.contains(Do222)) {
                                this.rwV.add(Do222);
                                this.rwU++;
                            }
                        }
                    }
                    if (intExtra == 2) {
                        this.rwW = false;
                    } else {
                        this.rwW = true;
                    }
                }
                if (1 == intExtra) {
                    this.rwX = 1;
                } else {
                    this.rwX = 0;
                }
            }
        }
    }
}
