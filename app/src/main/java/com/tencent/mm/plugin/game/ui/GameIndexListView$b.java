package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a$a;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.GameFeedSocialInfoView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView$b extends a<a> {
    final /* synthetic */ GameIndexListView nrj;
    LinkedList<f> nrk = new LinkedList();

    public GameIndexListView$b(GameIndexListView gameIndexListView) {
        this.nrj = gameIndexListView;
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        View inflate;
        x.d("MicroMsg.GameIndexListView", "onCreateViewHolder, viewType = " + i);
        switch (i) {
            case 1:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkj, viewGroup, false);
                break;
            case 2:
            case 3:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dks, viewGroup, false);
                break;
            case 4:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkl, viewGroup, false);
                break;
            case 5:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dki, viewGroup, false);
                break;
            case 6:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dko, viewGroup, false);
                break;
            case 8:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkh, viewGroup, false);
                break;
            case 9:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkn, viewGroup, false);
                break;
            case 10:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkp, viewGroup, false);
                break;
            case 1000:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dju, viewGroup, false);
                break;
            case 1001:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.djs, viewGroup, false);
                break;
            case 1002:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.djt, viewGroup, false);
                break;
            case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                inflate = LayoutInflater.from(GameIndexListView.f(this.nrj)).inflate(R.i.dkm, viewGroup, false);
                break;
            default:
                inflate = new FrameLayout(this.nrj.getContext());
                break;
        }
        return new a(this, inflate);
    }

    public final /* synthetic */ void a(t tVar, int i) {
        a aVar = (a) tVar;
        x.d("MicroMsg.GameIndexListView", "onBindViewHolder， position = %d", new Object[]{Integer.valueOf(i)});
        f fVar = (f) this.nrk.get(i);
        if (fVar != null) {
            ag agVar;
            int size;
            d a;
            switch (fVar.type) {
                case 1:
                    GameFeedImageTextView gameFeedImageTextView = (GameFeedImageTextView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngE == null) {
                        gameFeedImageTextView.setVisibility(8);
                        return;
                    }
                    gameFeedImageTextView.nlS = fVar;
                    agVar = fVar.nbs;
                    gameFeedImageTextView.setVisibility(0);
                    gameFeedImageTextView.nqb.a(agVar.ngE.fon, agVar.ngE.nje, null);
                    if (bh.cA(agVar.ngE.njf)) {
                        gameFeedImageTextView.nqf.setVisibility(8);
                        gameFeedImageTextView.nqj.setVisibility(8);
                    } else {
                        size = agVar.ngE.njf.size();
                        if (size == 1) {
                            gameFeedImageTextView.nqj.setVisibility(8);
                            gameFeedImageTextView.nqf.setVisibility(0);
                            e.aRV().a(gameFeedImageTextView.nqf, (String) agVar.ngE.njf.get(0), gameFeedImageTextView.getResources().getDimensionPixelSize(R.f.bvf), gameFeedImageTextView.getResources().getDimensionPixelSize(R.f.bve), (c.getScreenWidth(gameFeedImageTextView.getContext()) - gameFeedImageTextView.getPaddingLeft()) - gameFeedImageTextView.getPaddingRight());
                        } else {
                            gameFeedImageTextView.nqf.setVisibility(8);
                            gameFeedImageTextView.nqj.setVisibility(0);
                            gameFeedImageTextView.nqn.setVisibility(8);
                            e$a$a com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                            com_tencent_mm_plugin_game_d_e_a_a.nxt = true;
                            e.a aRW = com_tencent_mm_plugin_game_d_e_a_a.aRW();
                            e.aRV().a(gameFeedImageTextView.nqk, (String) agVar.ngE.njf.get(0), aRW);
                            e.aRV().a(gameFeedImageTextView.nql, (String) agVar.ngE.njf.get(1), aRW);
                            if (size > 2) {
                                e.aRV().a(gameFeedImageTextView.nqm, (String) agVar.ngE.njf.get(2), aRW);
                                gameFeedImageTextView.nqm.setVisibility(0);
                                if (size > 3) {
                                    gameFeedImageTextView.nqn.setVisibility(0);
                                    gameFeedImageTextView.nqn.setText(String.format("共%d张", new Object[]{Integer.valueOf(size)}));
                                }
                            } else {
                                gameFeedImageTextView.nqm.setVisibility(4);
                            }
                        }
                    }
                    gameFeedImageTextView.nqo.a(agVar);
                    if (!gameFeedImageTextView.nlS.nbu) {
                        ap.a(gameFeedImageTextView.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedImageTextView.nlS.position, gameFeedImageTextView.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedImageTextView.nlS.nbs.nfK));
                        gameFeedImageTextView.nlS.nbu = true;
                        return;
                    }
                    return;
                case 2:
                    GameFeedVideoView gameFeedVideoView = (GameFeedVideoView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngF == null || bh.ov(fVar.nbs.ngF.nff)) {
                        gameFeedVideoView.setVisibility(8);
                        return;
                    }
                    gameFeedVideoView.nlS = fVar;
                    ag agVar2 = fVar.nbs;
                    gameFeedVideoView.setVisibility(0);
                    gameFeedVideoView.nqb.a(agVar2.ngF.fon, agVar2.ngF.nfe, null);
                    e.aRV().a(gameFeedVideoView.nqH, agVar2.ngF.nff, gameFeedVideoView.getResources().getDimensionPixelSize(R.f.bvf), gameFeedVideoView.getResources().getDimensionPixelSize(R.f.bve), (c.getScreenWidth(gameFeedVideoView.getContext()) - gameFeedVideoView.getPaddingLeft()) - gameFeedVideoView.getPaddingRight());
                    if (bh.ov(agVar2.ngF.nkq)) {
                        gameFeedVideoView.nqI.setVisibility(8);
                    } else {
                        gameFeedVideoView.nqI.setVisibility(0);
                        gameFeedVideoView.nqJ.setVisibility(8);
                        gameFeedVideoView.nqK.setText(agVar2.ngF.nkq);
                    }
                    gameFeedVideoView.nqo.a(agVar2);
                    return;
                case 3:
                    GameFeedVideoView gameFeedVideoView2 = (GameFeedVideoView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngG == null) {
                        gameFeedVideoView2.setVisibility(8);
                        return;
                    }
                    gameFeedVideoView2.nlS = fVar;
                    agVar = fVar.nbs;
                    gameFeedVideoView2.setVisibility(0);
                    gameFeedVideoView2.nqb.a(agVar.ngG.fon, agVar.ngG.nfe, null);
                    if (bh.ov(agVar.ngG.nff)) {
                        gameFeedVideoView2.nqe.setVisibility(8);
                    } else {
                        gameFeedVideoView2.nqe.setVisibility(0);
                        e.aRV().a(gameFeedVideoView2.nqH, agVar.ngG.nff, gameFeedVideoView2.getResources().getDimensionPixelSize(R.f.bvf), gameFeedVideoView2.getResources().getDimensionPixelSize(R.f.bve), (c.getScreenWidth(gameFeedVideoView2.getContext()) - gameFeedVideoView2.getPaddingLeft()) - gameFeedVideoView2.getPaddingRight());
                    }
                    if (bh.ov(agVar.ngG.njz)) {
                        gameFeedVideoView2.nqI.setVisibility(8);
                    } else {
                        gameFeedVideoView2.nqI.setVisibility(0);
                        gameFeedVideoView2.nqJ.setVisibility(0);
                        gameFeedVideoView2.nqK.setText(agVar.ngG.njz);
                    }
                    gameFeedVideoView2.nqo.a(agVar);
                    if (!gameFeedVideoView2.nlS.nbu) {
                        ap.a(gameFeedVideoView2.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedVideoView2.nlS.position, gameFeedVideoView2.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedVideoView2.nlS.nbs.nfK));
                        gameFeedVideoView2.nlS.nbu = true;
                        return;
                    }
                    return;
                case 4:
                    GameFeedMatchView gameFeedMatchView = (GameFeedMatchView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngH == null) {
                        gameFeedMatchView.setVisibility(8);
                        return;
                    }
                    gameFeedMatchView.nlS = fVar;
                    agVar = fVar.nbs;
                    gameFeedMatchView.setVisibility(0);
                    gameFeedMatchView.nqb.a(agVar.ngH.fon, agVar.ngH.nfe, null);
                    if (bh.ov(agVar.ngH.nff)) {
                        gameFeedMatchView.setVisibility(8);
                    } else {
                        gameFeedMatchView.nqr.setVisibility(0);
                        e.aRV().a(gameFeedMatchView.nqr, agVar.ngH.nff, gameFeedMatchView.getResources().getDimensionPixelSize(R.f.bvi), gameFeedMatchView.getResources().getDimensionPixelSize(R.f.bvh), (c.getScreenWidth(gameFeedMatchView.getContext()) - gameFeedMatchView.getPaddingLeft()) - gameFeedMatchView.getPaddingRight());
                    }
                    gameFeedMatchView.nqo.a(agVar);
                    if (!gameFeedMatchView.nlS.nbu) {
                        ap.a(gameFeedMatchView.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedMatchView.nlS.position, gameFeedMatchView.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedMatchView.nlS.nbs.nfK));
                        gameFeedMatchView.nlS.nbu = true;
                        return;
                    }
                    return;
                case 5:
                    GameFeedGameTemplateView gameFeedGameTemplateView = (GameFeedGameTemplateView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngI == null) {
                        gameFeedGameTemplateView.setVisibility(8);
                        return;
                    }
                    gameFeedGameTemplateView.nlS = fVar;
                    ag agVar3 = fVar.nbs;
                    gameFeedGameTemplateView.setVisibility(0);
                    e.aRV().a(gameFeedGameTemplateView.noM, agVar3.ngI.nfh.nfn, com.tencent.mm.bv.a.getDensity(gameFeedGameTemplateView.getContext()));
                    gameFeedGameTemplateView.noN.setText(agVar3.ngI.nfh.nfp);
                    gameFeedGameTemplateView.nqd.e(agVar3.ngI.nfh.nfE, gameFeedGameTemplateView.nlQ);
                    if (bh.ov(agVar3.ngI.nhC)) {
                        gameFeedGameTemplateView.lkn.setVisibility(8);
                    } else {
                        gameFeedGameTemplateView.lkn.setText(agVar3.ngI.nhC);
                        gameFeedGameTemplateView.lkn.setVisibility(0);
                    }
                    gameFeedGameTemplateView.nqe.setVisibility(0);
                    if (!bh.ov(agVar3.ngI.nhE)) {
                        gameFeedGameTemplateView.b(gameFeedGameTemplateView.nqf, agVar3.ngI.nff);
                        gameFeedGameTemplateView.nqg.setVisibility(0);
                    } else if (bh.ov(agVar3.ngI.nff)) {
                        gameFeedGameTemplateView.nqe.setVisibility(8);
                    } else {
                        gameFeedGameTemplateView.b(gameFeedGameTemplateView.nqf, agVar3.ngI.nff);
                        gameFeedGameTemplateView.nqg.setVisibility(8);
                    }
                    gameFeedGameTemplateView.nqe.setOnClickListener(gameFeedGameTemplateView);
                    gameFeedGameTemplateView.nqh.a(agVar3);
                    a = ad.a(gameFeedGameTemplateView.nlS.nbs.ngI.nfh);
                    a.scene = 10;
                    a.fFj = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    a.position = gameFeedGameTemplateView.nlS.position;
                    gameFeedGameTemplateView.nqi.a(new o(a));
                    if (!gameFeedGameTemplateView.nlS.nbu) {
                        ap.a(gameFeedGameTemplateView.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedGameTemplateView.nlS.position, gameFeedGameTemplateView.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedGameTemplateView.nlS.nbs.nfK));
                        gameFeedGameTemplateView.nlS.nbu = true;
                        return;
                    }
                    return;
                case 6:
                    GameFeedNoGamePlayTemplate gameFeedNoGamePlayTemplate = (GameFeedNoGamePlayTemplate) aVar.contentView;
                    x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngJ == null) {
                        gameFeedNoGamePlayTemplate.setVisibility(8);
                        return;
                    }
                    x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
                    gameFeedNoGamePlayTemplate.nlS = fVar;
                    agVar = fVar.nbs;
                    gameFeedNoGamePlayTemplate.setVisibility(0);
                    gameFeedNoGamePlayTemplate.nqs.a(agVar.ngJ.fon, agVar.ngJ.nfe, agVar.ngJ.nfM);
                    gameFeedNoGamePlayTemplate.nqt.setVisibility(0);
                    if (bh.ov(agVar.ngJ.nff)) {
                        gameFeedNoGamePlayTemplate.nqt.setVisibility(8);
                    } else {
                        e.aRV().a(gameFeedNoGamePlayTemplate.nqf, agVar.ngJ.nff, gameFeedNoGamePlayTemplate.getResources().getDimensionPixelSize(R.f.bvi), gameFeedNoGamePlayTemplate.getResources().getDimensionPixelSize(R.f.bvh), (c.getScreenWidth(gameFeedNoGamePlayTemplate.getContext()) - gameFeedNoGamePlayTemplate.getPaddingLeft()) - gameFeedNoGamePlayTemplate.getPaddingRight());
                        if (bh.ov(agVar.ngJ.nhE)) {
                            gameFeedNoGamePlayTemplate.nqg.setVisibility(8);
                        } else {
                            gameFeedNoGamePlayTemplate.nqg.setVisibility(0);
                        }
                    }
                    if (agVar.ngJ.nfh != null) {
                        gameFeedNoGamePlayTemplate.nqu.setVisibility(0);
                        e.aRV().a(gameFeedNoGamePlayTemplate.jVp, agVar.ngJ.nfh.nfn, com.tencent.mm.bv.a.getDensity(gameFeedNoGamePlayTemplate.getContext()));
                        gameFeedNoGamePlayTemplate.nqv.setText(agVar.ngJ.nfh.nfp);
                        a = ad.a(agVar.ngJ.nfh);
                        a.scene = 10;
                        a.fFj = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        a.position = gameFeedNoGamePlayTemplate.nlS.position;
                        gameFeedNoGamePlayTemplate.nlO.a(new o(a));
                    }
                    if (!gameFeedNoGamePlayTemplate.nlS.nbu) {
                        ap.a(gameFeedNoGamePlayTemplate.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedNoGamePlayTemplate.nlS.position, gameFeedNoGamePlayTemplate.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedNoGamePlayTemplate.nlS.nbs.nfK));
                        gameFeedNoGamePlayTemplate.nlS.nbu = true;
                        return;
                    }
                    return;
                case 8:
                    GameFeedAddTopicView gameFeedAddTopicView = (GameFeedAddTopicView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngL == null) {
                        gameFeedAddTopicView.setVisibility(8);
                        return;
                    }
                    gameFeedAddTopicView.nlS = fVar;
                    gameFeedAddTopicView.setVisibility(0);
                    gameFeedAddTopicView.nqb.a(fVar.nbs.ngL.fon, fVar.nbs.ngL.nfe, null);
                    gameFeedAddTopicView.nqc.setText(fVar.nbs.ngL.ngb);
                    if (!gameFeedAddTopicView.nlS.nbu) {
                        ap.a(gameFeedAddTopicView.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedAddTopicView.nlS.position, gameFeedAddTopicView.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedAddTopicView.nlS.nbs.nfK));
                        gameFeedAddTopicView.nlS.nbu = true;
                        return;
                    }
                    return;
                case 9:
                    GameFeedMoreGameEntranceView gameFeedMoreGameEntranceView = (GameFeedMoreGameEntranceView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngM == null) {
                        gameFeedMoreGameEntranceView.setVisibility(8);
                        return;
                    }
                    gameFeedMoreGameEntranceView.nlS = fVar;
                    gameFeedMoreGameEntranceView.setVisibility(0);
                    gameFeedMoreGameEntranceView.kO.setText(fVar.nbs.ngM.nfe);
                    if (!gameFeedMoreGameEntranceView.nlS.nbu) {
                        ap.a(gameFeedMoreGameEntranceView.getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedMoreGameEntranceView.nlS.position, gameFeedMoreGameEntranceView.nlS.nbs.ngo, GameIndexListView.aRA(), ap.BY(gameFeedMoreGameEntranceView.nlS.nbs.nfK));
                        gameFeedMoreGameEntranceView.nlS.nbu = true;
                        return;
                    }
                    return;
                case 10:
                    GameFeedQipaiView gameFeedQipaiView = (GameFeedQipaiView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngN == null) {
                        gameFeedQipaiView.setVisibility(8);
                        return;
                    }
                    agVar = fVar.nbs;
                    gameFeedQipaiView.setVisibility(0);
                    gameFeedQipaiView.nqz = agVar;
                    if (bh.ov(agVar.ngN.fon)) {
                        gameFeedQipaiView.jJn.setVisibility(8);
                    } else {
                        gameFeedQipaiView.jJn.setText(agVar.ngN.fon);
                        gameFeedQipaiView.jJn.setVisibility(0);
                    }
                    if (bh.ov(agVar.ngN.ngT)) {
                        gameFeedQipaiView.nqw.setVisibility(8);
                        gameFeedQipaiView.nqx.setVisibility(8);
                    } else {
                        gameFeedQipaiView.nqx.setVisibility(0);
                        gameFeedQipaiView.nqw.setVisibility(0);
                        gameFeedQipaiView.nqw.setText(agVar.ngN.ngT);
                    }
                    gameFeedQipaiView.nqy.removeAllViews();
                    if (!bh.cA(agVar.ngN.nfN)) {
                        Iterator it = agVar.ngN.nfN.iterator();
                        while (it.hasNext()) {
                            as asVar = (as) it.next();
                            View inflate = LayoutInflater.from(gameFeedQipaiView.getContext()).inflate(R.i.djD, gameFeedQipaiView, false);
                            inflate.setOnClickListener(gameFeedQipaiView);
                            inflate.setTag(Integer.valueOf(agVar.ngN.nfN.indexOf(asVar)));
                            gameFeedQipaiView.nqy.addView(inflate, new LayoutParams(-1, -2, 1.0f));
                            TextView textView = (TextView) inflate.findViewById(R.h.cGy);
                            ImageView imageView = (ImageView) inflate.findViewById(R.h.cGv);
                            TextView textView2 = (TextView) inflate.findViewById(R.h.cGx);
                            TextView textView3 = (TextView) inflate.findViewById(R.h.cGu);
                            textView.setVisibility(8);
                            e.aRV().h(imageView, asVar.nhp);
                            textView2.setText(asVar.fon);
                            textView3.setText(asVar.nfe);
                        }
                    }
                    if (!fVar.nbu) {
                        ap.a(gameFeedQipaiView.getContext(), 10, 1023, fVar.position, fVar.nbs.ngo, GameIndexListView.aRA(), ap.BY(fVar.nbs.nfK));
                        fVar.nbu = true;
                        return;
                    }
                    return;
                case 1000:
                    GameBestSellingTitle gameBestSellingTitle = (GameBestSellingTitle) aVar.contentView;
                    CharSequence charSequence = fVar.nbs.ngK.fon;
                    if (bh.ov(charSequence)) {
                        gameBestSellingTitle.setVisibility(8);
                        return;
                    }
                    gameBestSellingTitle.setVisibility(0);
                    ((TextView) gameBestSellingTitle.findViewById(R.h.ckG)).setText(charSequence);
                    return;
                case 1001:
                    GameBestSellingItemView gameBestSellingItemView = (GameBestSellingItemView) aVar.contentView;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngK == null || bh.cA(fVar.nbs.ngK.nfN)) {
                        gameBestSellingItemView.setVisibility(8);
                        return;
                    }
                    gameBestSellingItemView.nlS = fVar;
                    aa aaVar = (aa) fVar.nbs.ngK.nfN.get(fVar.nbt);
                    size = fVar.nbt + 1;
                    if (aaVar == null || aaVar.nfh == null) {
                        gameBestSellingItemView.setVisibility(8);
                    } else {
                        gameBestSellingItemView.nlR = aaVar;
                        d a2 = ad.a(gameBestSellingItemView.nlR.nfh);
                        a2.scene = 10;
                        a2.fFj = 1022;
                        a2.position = gameBestSellingItemView.nlS.nbt + 1;
                        gameBestSellingItemView.nlO.a(new o(a2));
                        gameBestSellingItemView.setVisibility(0);
                        gameBestSellingItemView.nlK.setText(String.valueOf(size));
                        if (size == 1) {
                            gameBestSellingItemView.nlK.setTextColor(c.parseColor("#EED157"));
                        } else if (size == 2) {
                            gameBestSellingItemView.nlK.setTextColor(c.parseColor("#BDC5CB"));
                        } else if (size == 3) {
                            gameBestSellingItemView.nlK.setTextColor(c.parseColor("#D4B897"));
                        } else {
                            gameBestSellingItemView.nlK.setTextColor(c.parseColor("#B2B2B2"));
                        }
                        e.aRV().a(gameBestSellingItemView.nlL, aaVar.nfh.nfn, com.tencent.mm.bv.a.getDensity(gameBestSellingItemView.getContext()));
                        gameBestSellingItemView.nlM.setText(aaVar.nfh.nfp);
                        gameBestSellingItemView.nlN.e(aaVar.nfh.nfE, gameBestSellingItemView.nlQ);
                        if (bh.cA(aaVar.ngt) && aaVar.ngu == null && aaVar.nfe == null) {
                            gameBestSellingItemView.nlP.setVisibility(8);
                        } else {
                            if (gameBestSellingItemView.nlP instanceof ViewStub) {
                                gameBestSellingItemView.nlP = ((ViewStub) gameBestSellingItemView.nlP).inflate();
                            }
                            GameFeedSocialInfoView gameFeedSocialInfoView = (GameFeedSocialInfoView) gameBestSellingItemView.nlP.findViewById(R.h.cnl);
                            if (bh.cA(aaVar.ngt) && aaVar.ngu == null) {
                                gameFeedSocialInfoView.nxX.setVisibility(8);
                            } else {
                                gameFeedSocialInfoView.nxX.setVisibility(0);
                                gameFeedSocialInfoView.nxY.H(aaVar.ngt);
                                if (aaVar.ngu != null) {
                                    gameFeedSocialInfoView.nxZ.setText(aaVar.ngu);
                                    gameFeedSocialInfoView.nxZ.setVisibility(0);
                                } else {
                                    gameFeedSocialInfoView.nxZ.setVisibility(8);
                                }
                            }
                            if (aaVar.nfe != null) {
                                gameFeedSocialInfoView.nya.setVisibility(0);
                                gameFeedSocialInfoView.lkn.setText(aaVar.nfe);
                            } else {
                                gameFeedSocialInfoView.nya.setVisibility(8);
                            }
                        }
                    }
                    if (!fVar.nbu) {
                        ap.a(gameBestSellingItemView.getContext(), 10, 1022, fVar.nbt + 1, aaVar.nfh.nfn, GameIndexListView.aRA(), ap.BY(fVar.nbs.nfK));
                        fVar.nbu = true;
                        return;
                    }
                    return;
                case 1002:
                    GameBestSellingMore gameBestSellingMore = (GameBestSellingMore) aVar.contentView;
                    gameBestSellingMore.nlS = fVar;
                    if (fVar == null || fVar.nbs == null || fVar.nbs.ngK == null || bh.ov(fVar.nbs.ngK.ngT)) {
                        gameBestSellingMore.nlT.setVisibility(8);
                        gameBestSellingMore.nlU.setVisibility(8);
                        gameBestSellingMore.setPadding(0, 0, 0, 0);
                        return;
                    }
                    gameBestSellingMore.setPadding(gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvg), 0, gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvg), gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvg));
                    gameBestSellingMore.nlT.setVisibility(0);
                    gameBestSellingMore.nlU.setVisibility(0);
                    gameBestSellingMore.nlT.setText(fVar.nbs.ngK.ngT);
                    return;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    GameFeedModuleTitle gameFeedModuleTitle = (GameFeedModuleTitle) aVar.contentView;
                    if (fVar == null || bh.ov(fVar.nbr)) {
                        gameFeedModuleTitle.setVisibility(8);
                        return;
                    }
                    gameFeedModuleTitle.setVisibility(0);
                    gameFeedModuleTitle.jJn.setText(fVar.nbr);
                    return;
                default:
                    return;
            }
        }
    }

    public final int getItemViewType(int i) {
        return ((f) this.nrk.get(i)).type;
    }

    public final int getItemCount() {
        return this.nrk.size();
    }
}
