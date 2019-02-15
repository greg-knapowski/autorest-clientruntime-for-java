/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.rest.v3.http;

import com.microsoft.rest.v3.policy.HttpPipelineOptions;

import java.util.Objects;
import java.util.Optional;

/**
 * Type representing context local to a single http request and it's response.
 */
public final class HttpPipelineCallContext {
    private HttpRequest httpRequest;
    private ContextData data;
    private final HttpPipelineOptions requestPolicyOptions;

    //<editor-fold defaultstate="collapsed" desc="Package internal methods">
    /**
     * Package private ctr.
     *
     * Creates HttpPipelineCallContext.
     *
     * @param httpRequest the request for which context needs to be created
     * @param requestPolicyOptions the policy options
     *
     * @throws IllegalArgumentException if there are multiple policies with same name
     */
    HttpPipelineCallContext(HttpRequest httpRequest, HttpPipelineOptions requestPolicyOptions) {
       this(httpRequest, ContextData.NONE, requestPolicyOptions);
    }

    /**
     * Package private ctr.
     *
     * Creates HttpPipelineCallContext.
     *
     * @param httpRequest the request for which context needs to be created
     * @param data the data to associate with this context
     * @param requestPolicyOptions the policy options
     *
     * @throws IllegalArgumentException if there are multiple policies with same name
     */
    HttpPipelineCallContext(HttpRequest httpRequest, ContextData data, HttpPipelineOptions requestPolicyOptions) {
        Objects.requireNonNull(httpRequest);
        Objects.requireNonNull(data);
        //
        this.httpRequest = httpRequest;
        this.data = data;
        this.requestPolicyOptions = requestPolicyOptions;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Public methods">

    /**
     * Stores a key-value data in the context.
     *
     * @param key the key
     * @param value the value
     */
    public void setData(String key, Object value) {
        this.data = this.data.addData(key, value);
    }

    /**
     * Gets a value with the given key stored in the context.
     *
     * @param key the key
     * @return the value
     */
    public Optional<Object> getData(String key) {
        return this.data.getData(key);
    }

    /**
     * @return the http request.
     */
    public HttpRequest httpRequest() {
        return this.httpRequest;
    }

    /**
     * Sets the http request object in the context.
     *
     * @param request request object
     * @return HttpPipelineCallContext
     */
    public HttpPipelineCallContext withHttpRequest(HttpRequest request) {
        this.httpRequest = request;
        return this;
    }

    /**
     * @return the policy options
     */
    public HttpPipelineOptions requestPolicyOptions() {
        return this.requestPolicyOptions;
    }

    //</editor-fold>
}