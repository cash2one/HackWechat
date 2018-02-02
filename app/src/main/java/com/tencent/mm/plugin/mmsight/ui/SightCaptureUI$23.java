package com.tencent.mm.plugin.mmsight.ui;

class SightCaptureUI$23 implements MMSightRecordButton$c {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$23(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void sY(int i) {
        if (SightCaptureUI.h(this.oDb) != null) {
            SightCaptureUI.h(this.oDb).b(true, true, i);
        }
    }

    public final void sZ(int i) {
        if (SightCaptureUI.h(this.oDb) != null) {
            SightCaptureUI.h(this.oDb).b(false, true, i);
        }
    }
}
