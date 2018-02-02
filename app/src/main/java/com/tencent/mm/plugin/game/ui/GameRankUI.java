package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameRankUI extends MMActivity {
    private ListView nov;
    private GameRankView nut;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        GameRankView gameRankView = this.nut;
        getIntent().getStringExtra("extra_app_id");
        LinkedList linkedList = new LinkedList();
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_user_ranks");
        if (serializableExtra != null && (serializableExtra instanceof List)) {
            linkedList.addAll((List) serializableExtra);
        }
        if (linkedList.size() == 0) {
            gameRankView.nuw.setVisibility(0);
            gameRankView.nuv.setVisibility(8);
            return;
        }
        gameRankView.nux.S(linkedList);
        gameRankView.nuv.setAdapter(gameRankView.nux);
        gameRankView.nuw.setVisibility(8);
        gameRankView.nuv.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.cna;
    }

    protected final void initView() {
        setMMTitle(R.l.emk);
        setBackBtn(new 1(this));
        this.nut = (GameRankView) findViewById(R.h.cna);
        this.nov = (ListView) this.nut.findViewById(R.h.cnd);
        new View(this).setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.bvv)));
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.dlb, this.nov, false);
        View inflate2 = layoutInflater.inflate(R.i.dlb, this.nov, false);
        this.nov.addHeaderView(inflate);
        this.nov.addFooterView(inflate2);
    }
}
