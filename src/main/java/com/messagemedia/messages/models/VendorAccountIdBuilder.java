package com.messagemedia.messages.models;

import java.util.*;

public class VendorAccountIdBuilder {
    //the instance to build
    private VendorAccountId vendorAccountId;


    public VendorAccountIdBuilder() {
        vendorAccountId = new VendorAccountId();
    }

    public VendorAccountIdBuilder vendorId(String vendorId) {
        vendorAccountId.setVendorId(vendorId);
        return this;
    }

 
    public VendorAccountIdBuilder accountId(String accountId) {
        vendorAccountId.setAccountId(accountId);
        return this;
    }
  
    public VendorAccountId build() {
        return vendorAccountId;
    }
}