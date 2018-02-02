package com.tencent.mm.plugin.fts;

class PluginFTS$1 implements Runnable {
    final /* synthetic */ PluginFTS mJM;

    PluginFTS$1(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final void run() {
        if (PluginFTS.access$200(this.mJM) != null) {
            PluginFTS.access$200(this.mJM).rollback();
        }
    }
}
