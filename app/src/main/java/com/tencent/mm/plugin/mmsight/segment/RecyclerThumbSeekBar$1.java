package com.tencent.mm.plugin.mmsight.segment;

import java.util.concurrent.Callable;

class RecyclerThumbSeekBar$1 implements Callable<d> {
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$1(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
    }

    public final /* synthetic */ Object call() {
        d fFmpegSightJNIThumbFetcher = new FFmpegSightJNIThumbFetcher();
        fFmpegSightJNIThumbFetcher.init(RecyclerThumbSeekBar.a(this.oyG), RecyclerThumbSeekBar.b(this.oyG), RecyclerThumbSeekBar.c(this.oyG), RecyclerThumbSeekBar.d(this.oyG));
        return fFmpegSightJNIThumbFetcher;
    }
}
