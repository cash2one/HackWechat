package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.z.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameGestureGalleryUI extends MMActivity implements OnTouchListener, a {
    private a nqR;
    private MMGallery nqS;
    private MMGestureGallery nqT;
    float nqU = 0.0f;
    float nqV = 0.0f;
    boolean nqW = false;
    float nqX = 1.0f;
    private w nqY;
    private List<String> nqZ = new ArrayList();
    private int nra = -1;
    private OnItemSelectedListener nrb = new 2(this);
    private String thumbUrl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqY = new w(false);
        j.a(this);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.nqY.GM();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dqk;
    }

    protected final void initView() {
        this.thumbUrl = getIntent().getStringExtra("thumbUrl");
        String ou = bh.ou(getIntent().getStringExtra("nowUrl"));
        this.mController.hideTitleView();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            this.nqZ = new ArrayList();
            this.nqZ.add(ou);
        } else {
            this.nqZ = Arrays.asList(stringArrayExtra);
        }
        for (int i = 0; i < this.nqZ.size(); i++) {
            if (ou.equals(this.nqZ.get(i))) {
                this.nra = i;
                break;
            }
        }
        setBackBtn(new 1(this));
        this.nqR = new a(this);
        if (g.coK()) {
            this.nqT = (MMGestureGallery) findViewById(R.h.ckt);
            this.nqT.setVisibility(0);
            this.nqT.setVerticalFadingEdgeEnabled(false);
            this.nqT.setHorizontalFadingEdgeEnabled(false);
            this.nqT.setAdapter(this.nqR);
            this.nqT.setSelection(this.nra);
            this.nqT.setOnItemSelectedListener(this.nrb);
            return;
        }
        this.nqS = (MMGallery) findViewById(R.h.cku);
        this.nqS.setVisibility(0);
        this.nqS.setAdapter(this.nqR);
        this.nqS.setSelection(this.nra);
        this.nqS.setOnItemSelectedListener(this.nrb);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.GameGestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.nqW) {
                    this.nqV = g.J(motionEvent);
                    if (this.nqV >= 5.0f) {
                        float f = this.nqV - this.nqU;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.nqX, this.nqX + f2, this.nqX, this.nqX + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.nqX += f2;
                            this.nqS.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.nqX), (int) (this.nqX * 854.0f)));
                            this.nqU = this.nqV;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.nqU = g.J(motionEvent);
                if (this.nqU > 5.0f) {
                    this.nqW = true;
                    break;
                }
                break;
            case 6:
                this.nqW = false;
                break;
        }
        return false;
    }

    public final void l(String str, Bitmap bitmap) {
        if (this.nqZ != null && this.nqZ.size() != 0) {
            if ((((String) this.nqZ.get(0)).hashCode()).equals(str) && this.nqR != null) {
                this.nqR.notifyDataSetChanged();
            }
        }
    }
}
