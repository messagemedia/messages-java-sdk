package com.messagemedia.messages.models;

import java.util.*;

public class VendorAccountIdBuilder {
    //the instance to build
    private VendorAccountId vendorAccountId;

    /**
     * Default constructor to initialize the instance
     */
    public VendorAccountIdBuilder() {
        vendorAccountId = new VendorAccountId();
    }

    public VendorAccountIdBuilder vendorId(String vendorId) {
        vendorAccountId.setVendorId(vendorId);
        return this;
    }

    /**
     * The account used to submit the original message.
     */
    public VendorAccountIdBuilder accountId(String accountId) {
        vendorAccountId.setAccountId(accountId);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public VendorAccountId build() {
        return vendorAccountId;
    }
}