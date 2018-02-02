package org.xwalk.core;

class XWalkDialogManager$ButtonAction {
    Runnable mClickAction;
    boolean mMandatory;
    int mWhich;

    XWalkDialogManager$ButtonAction(int i, Runnable runnable, boolean z) {
        this.mWhich = i;
        this.mClickAction = runnable;
        this.mMandatory = z;
    }
}
