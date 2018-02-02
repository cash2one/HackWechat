package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import java.util.ArrayList;

public class GameDetailAutoScrollView extends LinearLayout {
    int lHX = 0;
    ak nlD = new ak(new a(this) {
        final /* synthetic */ GameDetailAutoScrollView nob;

        {
            this.nob = r1;
        }

        public final boolean uF() {
            GameDetailAutoScrollView.a(this.nob);
            return true;
        }
    }, true);
    ArrayList<String> nnS = new ArrayList();
    ViewGroup nnT;
    TextView nnU;
    TextView nnV;
    ViewGroup nnW;
    private TextView nnX;
    private TextView nnY;
    private Animation nnZ;
    private Animation noa;

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        if (gameDetailAutoScrollView.lHX < (gameDetailAutoScrollView.nnS.size() / 2) - 1) {
            gameDetailAutoScrollView.lHX++;
        } else {
            gameDetailAutoScrollView.lHX = 0;
        }
        String str = (String) gameDetailAutoScrollView.nnS.get((gameDetailAutoScrollView.lHX * 2) + 1);
        gameDetailAutoScrollView.nnX.setText(i.b(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.nnS.get(gameDetailAutoScrollView.lHX * 2), gameDetailAutoScrollView.nnX.getTextSize()));
        gameDetailAutoScrollView.nnY.setText(str);
        gameDetailAutoScrollView.nnT.startAnimation(gameDetailAutoScrollView.noa);
        gameDetailAutoScrollView.nnT.setVisibility(8);
        gameDetailAutoScrollView.nnW.startAnimation(gameDetailAutoScrollView.nnZ);
        gameDetailAutoScrollView.nnW.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.nnT;
        gameDetailAutoScrollView.nnT = gameDetailAutoScrollView.nnW;
        gameDetailAutoScrollView.nnW = viewGroup;
        TextView textView = gameDetailAutoScrollView.nnU;
        gameDetailAutoScrollView.nnU = gameDetailAutoScrollView.nnX;
        gameDetailAutoScrollView.nnX = textView;
        textView = gameDetailAutoScrollView.nnV;
        gameDetailAutoScrollView.nnV = gameDetailAutoScrollView.nnY;
        gameDetailAutoScrollView.nnY = textView;
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nnT = (ViewGroup) LayoutInflater.from(context).inflate(R.i.djT, this, false);
        this.nnU = (TextView) this.nnT.findViewById(R.h.ckX);
        this.nnV = (TextView) this.nnT.findViewById(R.h.ckY);
        addView(this.nnT);
        this.nnT.setVisibility(8);
        this.nnW = (ViewGroup) LayoutInflater.from(context).inflate(R.i.djT, this, false);
        this.nnX = (TextView) this.nnW.findViewById(R.h.ckX);
        this.nnY = (TextView) this.nnW.findViewById(R.h.ckY);
        addView(this.nnW);
        this.nnW.setVisibility(8);
        this.nnZ = AnimationUtils.loadAnimation(context, R.a.bqy);
        this.noa = AnimationUtils.loadAnimation(context, R.a.bqE);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nlD.TG();
    }
}
