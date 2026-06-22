package org.learnspringframework.gamerunner.enterprice.business;

import org.learnspringframework.gamerunner.enterprice.data.EnterpriseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EnterpriseDataBusinessLogic {

    @Autowired
    private EnterpriseData enterpriseData;

//    Constructor Dependancy Injection
    public EnterpriseDataBusinessLogic(EnterpriseData enterpriseData){
        this.enterpriseData = enterpriseData;
    }


    public Integer calculateSum(){
       List<Integer> data =  enterpriseData.getBusinessData();
       return data.stream().reduce(Integer::sum).orElse(0); // functional Programming
    }

}
