package org.example.Service.CertificationService;

public class Certificate {
    private final CertificationService certificationService;

    public Certificate(CertificationService certificationService){
        this.certificationService = certificationService;
    }

    public void doWork(){
        certificationService.doWork();
    }

}
