/*
 * MessageMediaMessages
 *
 */
package com.messagemedia.messages.controllers;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.messagemedia.messages.models.*;
import com.messagemedia.messages.exceptions.*;
import com.messagemedia.messages.APIHelper;
import com.messagemedia.messages.testing.TestHelper;
import com.messagemedia.messages.controllers.DeliveryReportsController;

import com.fasterxml.jackson.core.type.TypeReference;

public class DeliveryReportsControllerTest extends ControllerTestBase 
{
    
    /**
     * Controller instance (for all tests)
     */
    private static DeliveryReportsController controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() 
    {
        controller = getClient().getDeliveryReports();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException 
    {
        controller = null;
    }

    /**
     * Check for any delivery reports that have been received.
     * Delivery reports are a notification of the change in status of a message as it is being processed.
     * Each request to the check delivery reports endpoint will return any delivery reports received that
     * have not yet been confirmed using the confirm delivery reports endpoint. A response from the check
     * delivery reports endpoint will have the following structure:
     * ```json
     * {
     *     "delivery_reports": [
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "01e1fa0a-6e27-4945-9cdb-18644b4de043",
     *             "source_number": "+61491570157",
     *             "date_received": "2017-05-20T06:30:37.642Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-20T06:30:37.639Z",
     *             "original_text": "My first message!",
     *             "message_id": "d781dcab-d9d8-4fb2-9e03-872f07ae94ba",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         },
     *         {
     *             "callback_url": "https://my.callback.url.com",
     *             "delivery_report_id": "0edf9022-7ccc-43e6-acab-480e93e98c1b",
     *             "source_number": "+61491570158",
     *             "date_received": "2017-05-21T01:46:42.579Z",
     *             "status": "enroute",
     *             "delay": 0,
     *             "submitted_date": "2017-05-21T01:46:42.574Z",
     *             "original_text": "My second message!",
     *             "message_id": "fbb3b3f5-b702-4d8b-ab44-65b2ee39a281",
     *             "vendor_account_id": {
     *                 "vendor_id": "MessageMedia",
     *                 "account_id": "MyAccount"
     *             },
     *             "metadata": {
     *                 "key1": "value1",
     *                 "key2": "value2"
     *             }
     *         }
     *     ]
     * }
     * ```
     * Each delivery report will contain details about the message, including any metadata specified
     * and the new status of the message (as each delivery report indicates a change in status of a
     * message) and the timestamp at which the status changed. Every delivery report will have a 
     * unique delivery report ID for use with the confirm delivery reports endpoint.
     * *Note: The source number and destination number properties in a delivery report are the inverse of
     * those specified in the message that the delivery report relates to. The source number of the
     * delivery report is the destination number of the original message.*
     * Subsequent requests to the check delivery reports endpoint will return the same delivery reports
     * and a maximum of 100 delivery reports will be returned in each request. Applications should use the
     * confirm delivery reports endpoint in the following pattern so that delivery reports that have been
     * processed are no longer returned in subsequent check delivery reports requests.
     * 1. Call check delivery reports endpoint
     * 2. Process each delivery report
     * 3. Confirm all processed delivery reports using the confirm delivery reports endpoint
     * *Note: It is recommended to use the Webhooks feature to receive reply messages rather than
     * polling the check delivery reports endpoint.*
     * @throws Throwable
     */
    @Test
    public void testCheckDeliveryReports1() throws Throwable {

        // Set callback and perform API call
        CheckDeliveryReportsResponse result = null;
        controller.setHttpCallBack(httpResponse);
        try 
        {
            result = controller.getCheckDeliveryReports();
        } 
        catch(APIException e) 
        {
        	
        };

        // Test whether the response is null
        assertNotNull("Response is null", httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 200, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        
        headers.put("Content-Type", TestHelper.nullString);
        
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(headers, httpResponse.getResponse().getHeaders(), true));

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", result);
    }

    /**
     * Make sure our SDK fails when passed an invalid account id
     */
    @Test
    public void testCheckDeliveryReportsWithInvalidAccount() throws Throwable 
    {
        controller.setHttpCallBack(httpResponse);
       
        try 
        {
            controller.getCheckDeliveryReports("INVALID ACCOUNT");
        } 
        catch(APIException apiException) 
        {
        	assertEquals("We must get our error message", "HTTP Response Not OK. {\"message\":\"Invalid account 'INVALID ACCOUNT' in header Account\"}\n", apiException.getMessage());
			assertEquals("Status should be 403", 403, httpResponse.getResponse().getStatusCode());

        };
    }

    /**
     * Mark a delivery report as confirmed so it is no longer return in check delivery reports requests.
     * The confirm delivery reports endpoint is intended to be used in conjunction with the check delivery
     * reports endpoint to allow for robust processing of delivery reports. Once one or more delivery
     * reports have been processed, they can then be confirmed using the confirm delivery reports endpoint so they
     * are no longer returned in subsequent check delivery reports requests.
     * The confirm delivery reports endpoint takes a list of delivery report IDs as follows:
     * ```json
     * {
     *     "delivery_report_ids": [
     *         "011dcead-6988-4ad6-a1c7-6b6c68ea628d",
     *         "3487b3fa-6586-4979-a233-2d1b095c7718",
     *         "ba28e94b-c83d-4759-98e7-ff9c7edb87a1"
     *     ]
     * }
     * ```
     * Up to 100 delivery reports can be confirmed in a single confirm delivery reports request.
     * @throws Throwable
     */
    @Test
    public void testConfirmDeliveryReportsAsReceived1() throws Throwable 
    {
        // Parameters for the API call
        ConfirmDeliveryReportsAsReceivedRequest body = APIHelper.deserialize("{\"delivery_report_ids\":[\"011dcead-6988-4ad6-a1c7-6b6c68ea628d\",\"3487b3fa-6586-4979-a233-2d1b095c7718\",\"ba28e94b-c83d-4759-98e7-ff9c7edb87a1\"]}", new TypeReference<ConfirmDeliveryReportsAsReceivedRequest>(){});

        // Set callback and perform API call
        DynamicResponse result = null;
        
        controller.setHttpCallBack(httpResponse);
        try 
        {
            result = controller.createConfirmDeliveryReportsAsReceived(body);
        } 
        catch(APIException e)
        {
        	
        };

        // Test whether the response is null
        assertNotNull("Response is null", httpResponse.getResponse());
        
        // Test response code
        assertEquals("Status is not 202",202, httpResponse.getResponse().getStatusCode());

        // Test headers
        Map<String, String> headers = new LinkedHashMap<String, String>();
        
        headers.put("Content-Type", TestHelper.nullString);
        
        assertNotNull("Result must exist", result);
        assertTrue("Headers do not match", TestHelper.areHeadersProperSubsetOf(headers, httpResponse.getResponse().getHeaders(), true));
    }


    /**
     * Make sure our SDK fails when passed an invalid account id
     */
    @Test
    public void testConfirmDeliveryReportsAsReceivedWithInvalidAccount() throws Throwable 
    {
        // Parameters for the API call
        ConfirmDeliveryReportsAsReceivedRequest body = APIHelper.deserialize("{\"delivery_report_ids\":[\"011dcead-6988-4ad6-a1c7-6b6c68ea628d\",\"3487b3fa-6586-4979-a233-2d1b095c7718\",\"ba28e94b-c83d-4759-98e7-ff9c7edb87a1\"]}", new TypeReference<ConfirmDeliveryReportsAsReceivedRequest>(){});

        controller.setHttpCallBack(httpResponse);
       
        try 
        {
            controller.createConfirmDeliveryReportsAsReceived(body, "INVALID ACCOUNT");
        } 
        catch(APIException apiException) 
        {
        	assertEquals("We must get our error message", "HTTP Response Not OK. {\"message\":\"Invalid account 'INVALID ACCOUNT' in header Account\"}\n", apiException.getMessage());
			assertEquals("Status should be 403", 403, httpResponse.getResponse().getStatusCode());

        };
    }
}