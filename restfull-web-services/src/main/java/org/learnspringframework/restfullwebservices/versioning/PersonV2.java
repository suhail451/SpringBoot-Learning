package org.learnspringframework.restfullwebservices.versioning;

public class PersonV2 {

    private Name fullname;

    public PersonV2(Name fullname) {
        this.fullname = fullname;
    }

    public Name getFullname() {
        return fullname;
    }

    public void setFullname(Name fullname) {
        this.fullname = fullname;
    }
}
