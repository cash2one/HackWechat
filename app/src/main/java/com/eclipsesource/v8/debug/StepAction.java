package com.eclipsesource.v8.debug;

public enum StepAction {
    STEP_OUT(0),
    STEP_NEXT(1),
    STEP_IN(2),
    STEP_FRAME(3);
    
    int index;

    private StepAction(int i) {
        this.index = i;
    }
}
