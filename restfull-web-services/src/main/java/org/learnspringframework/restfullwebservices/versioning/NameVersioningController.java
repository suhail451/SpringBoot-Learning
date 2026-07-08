package org.learnspringframework.restfullwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameVersioningController {

//    URL Versioning (Twitter)

//    http://localhost:8080/v1/person
//    http://localhost:8080/v2/person

    @GetMapping(path = "/v1/person")
    public PersonV1 getURIVersion1(){
        return new PersonV1("Keertan Goswami");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getURIVersion2(){
        return new PersonV2(new Name("Keertan" , " Goswami"));
    }

//    Request Parameter Versioning  (Amazon)

//    http://localhost:8080/person?version=1
//    http://localhost:8080/person?version=2

@GetMapping(path = "/person" , params = "version=1")
public PersonV1 getRequestParameterVersion1(){
    return new PersonV1("Keertan Goswami");
}


@GetMapping(path = "/person" , params = "version=2")
public PersonV2 getRequestParameterVersion2(){
    return new PersonV2(new Name("Keertan" , " Goswami"));
}

// (Custom) Header Verioning  (Microsoft)

    @GetMapping(path = "/person" , headers = "X-API-VERSION=1")
    public PersonV1 getHeaderVersion1(){
        return new PersonV1("Keertan Goswami");
    }


    @GetMapping(path = "/person" , headers = "X-API-VERSION=2")
    public PersonV2 getHeaderVersion2(){
        return new PersonV2(new Name("Keertan" , " Goswami"));
    }


//   Media type version ---   Accept Header or content negotiation

    @GetMapping(path = "/person" , produces = "application/vnd.learnspringframework.restfullwebservices-v1+json")
    public PersonV1 getAcceptVersion1(){
        return new PersonV1("Keertan Goswami");
    }


    @GetMapping(path = "/person" , produces = "application/vnd.learnspringframework.restfullwebservices-v2+json")
    public PersonV2 getAcceptVersion2(){
        return new PersonV2(new Name("Keertan" , " Goswami"));
    }









}
