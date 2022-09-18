package com.example.workflow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateNameSagaData {
    //private Criteria filters;
    private Long nameId;
    private RejectionReason rejectionReason;

//    public GenerateNameSagaData(Criteria filters) {
//        this.filters = filters;
//    }

    public GenerateNameSagaData() {
    }

}
