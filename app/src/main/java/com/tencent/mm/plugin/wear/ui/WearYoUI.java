package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends Activity {
    private ImageView iip;
    private TextView kBH;
    private Vibrator kEd;
    private c spV = new 5(this);
    private ImageView tjg;
    private ImageView tjh;
    private ImageView tji;
    private ObjectAnimator[][] tjj = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private c tjk = new 2(this);
    private boolean tjl;
    private AtomicInteger tjm = new AtomicInteger();
    private Runnable tjn = new Runnable(this) {
        final /* synthetic */ WearYoUI tjp;

        {
            this.tjp = r1;
        }

        public final void run() {
            this.tjp.kEd.vibrate(200);
            this.tjp.iip.animate().scaleX(1.2f);
            this.tjp.iip.animate().scaleY(1.2f);
            this.tjp.iip.animate().setDuration(200);
            this.tjp.iip.animate().start();
            this.tjp.iip.animate().setListener(new a(this.tjp, 1));
        }
    };
    private BroadcastReceiver tjo = new 4(this);
    private String username;

    private class a implements AnimatorListener {
        private int jer = 1;
        final /* synthetic */ WearYoUI tjp;

        public a(WearYoUI wearYoUI, int i) {
            this.tjp = wearYoUI;
            this.jer = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.jer == 2) {
                x.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[]{Integer.valueOf(this.tjp.tjm.get())});
                if (this.tjp.tjm.get() > 0) {
                    this.tjp.tjm.decrementAndGet();
                    ag.h(this.tjp.tjn, 1000);
                    return;
                }
                this.tjp.iip.animate().setListener(null);
                this.tjp.tjl = false;
            } else if (this.jer == 1) {
                this.tjp.iip.animate().scaleX(1.0f);
                this.tjp.iip.animate().scaleY(1.0f);
                this.tjp.iip.animate().setDuration(100);
                this.tjp.iip.animate().start();
                this.tjp.iip.animate().setListener(new a(this.tjp, 2));
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.tjp.tjl = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        if (wearYoUI.tjl) {
            wearYoUI.tjm.addAndGet(1);
            x.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", new Object[]{Integer.valueOf(wearYoUI.tjm.get())});
            return;
        }
        wearYoUI.tjl = true;
        ag.y(wearYoUI.tjn);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(R.i.dtW);
        this.kEd = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.iip = (ImageView) findViewById(R.h.bLL);
        this.kBH = (TextView) findViewById(R.h.cAn);
        this.tjg = (ImageView) findViewById(R.h.bLQ);
        this.tjh = (ImageView) findViewById(R.h.bLR);
        this.tji = (ImageView) findViewById(R.h.bLS);
        b.o(this.iip, this.username);
        this.kBH.setText(r.gu(this.username));
        this.iip.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WearYoUI tjp;

            {
                this.tjp = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wear.model.a.bOt();
                x.i("MicroMsg.wear.WearYoLogic", "click avatarIV %s", new Object[]{this.tjp.username});
                Intent intent = new Intent();
                intent.putExtra("Main_User", r0);
                intent.putExtra("From_fail_notify", true);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                d.a(ac.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                this.tjp.finish();
            }
        });
        com.tencent.mm.sdk.b.a.xef.b(this.tjk);
        com.tencent.mm.sdk.b.a.xef.b(this.spV);
        a(0, this.tjg, 0);
        a(1, this.tjh, 1300);
        a(2, this.tji, 2600);
        this.kEd.vibrate(200);
        registerReceiver(this.tjo, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(R.a.bpU, R.a.bpV);
    }

    private void a(int i, ImageView imageView, long j) {
        this.tjj[i][0] = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 2.5f});
        this.tjj[i][0].setRepeatCount(-1);
        this.tjj[i][0].setStartDelay(j);
        this.tjj[i][0].setDuration(3900);
        this.tjj[i][0].start();
        this.tjj[i][1] = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 2.5f});
        this.tjj[i][1].setRepeatCount(-1);
        this.tjj[i][1].setStartDelay(j);
        this.tjj[i][1].setDuration(3900);
        this.tjj[i][1].start();
        this.tjj[i][2] = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{1.0f, 0.0f});
        this.tjj[i][2].setRepeatCount(-1);
        this.tjj[i][2].setInterpolator(new AccelerateInterpolator());
        this.tjj[i][2].setStartDelay(j);
        this.tjj[i][2].setDuration(3900);
        this.tjj[i][2].start();
    }

    public void onClickCheck(View view) {
        x.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[]{this.username});
        ar.CG().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
    }

    public void onClickNoCheck(View view) {
        x.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[]{this.username});
        finish();
    }

    protected void onDestroy() {
        for (int i = 0; i < this.tjj.length; i++) {
            for (ObjectAnimator cancel : this.tjj[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.tjo);
        com.tencent.mm.sdk.b.a.xef.c(this.spV);
        com.tencent.mm.sdk.b.a.xef.c(this.tjk);
        com.tencent.mm.plugin.wear.model.a.bOt().thO.bOJ();
        super.onDestroy();
    }
}
