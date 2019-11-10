package com.messagemedia.messages.models;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VendorAccountIdBuilder.
 */
public class VendorAccountIdBuilder {
    
    /** The vendor account id. */
    //the instance to build
    private VendorAccountId vendorAccountId;

    /**
     * Default constructor to initialize the instance.
     */
    public VendorAccountIdBuilder() {
        vendorAccountId = new VendorAccountId();
    }

    /**
     * Vendor id.
     *
     * @param vendorId the vendor id
     * @return the vendor account id builder
     */
    public VendorAccountIdBuilder vendorId(String vendorId) {
        vendorAccountId.setVendorId(vendorId);
        return this;
    }

    /**
     * The account used to submit the original message.
     *
     * @param accountId the account id
     * @return the vendor account id builder
     */
    public VendorAccountIdBuilder accountId(String accountId) {
        vendorAccountId.setAccountId(accountId);
        return this;
    }
    
    /**
     * Build the instance with the given values.
     *
     * @return the vendor account id
     */
    public VendorAccountId build() {
        return vendorAccountId;
    }
}