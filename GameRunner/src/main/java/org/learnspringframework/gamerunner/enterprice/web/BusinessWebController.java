package org.learnspringframework.gamerunner.enterprice.web;

import org.learnspringframework.gamerunner.enterprice.business.EnterpriseDataBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessWebController {

//    Hard Coded
//    public Long showBusinessData(){
//        return 200l;
//    }

    @Autowired
    private EnterpriseDataBusinessLogic enterpriceDataBusinessLogic;

//    Constrctor Dependancy injection
    public BusinessWebController(EnterpriseDataBusinessLogic enterpriceDataBusinessLogic) {
        this.enterpriceDataBusinessLogic = enterpriceDataBusinessLogic;
    }


//    Setter Dependancy injection
    public void setEnterpriceDataBusinessLogic(EnterpriseDataBusinessLogic enterpriceDataBusinessLogic) {
        this.enterpriceDataBusinessLogic = enterpriceDataBusinessLogic;
    }

    public Long showBusinessData(){
        return enterpriceDataBusinessLogic.calculateSum().longValue();
    }
}
