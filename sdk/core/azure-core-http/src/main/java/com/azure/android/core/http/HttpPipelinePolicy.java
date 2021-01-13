// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.core.http;

import com.azure.android.core.micro.util.Context;

/**
 * A policy within the {@link HttpPipeline}.
 *
 * @see HttpPipeline
 */
public interface HttpPipelinePolicy {
    /**
     * Applies the policy to a {@link HttpRequest} and the corresponding {@link HttpResponse}.
     *
     * <p>
     * Policy implementations are expected to use {@link HttpPipelinePolicyChain#getRequest()}
     * to access and intercept the request, then proceed to next policy by calling
     * {@link HttpPipelinePolicyChain#processNextPolicy(HttpRequest, Context, HttpCallback)}.
     *
     * The policy can intercept the resulting response or error notified to the {@code HttpCallback}
     * and must signal the completion of the policy by calling
     * {@link HttpPipelinePolicyChain#finishedProcessing(HttpResponse)} or
     * {@link HttpPipelinePolicyChain#finishedProcessing(Throwable)}.
     * </p>
     *
     * @param chain The chain for the policy to access the request, response and notify the completion
     *     of request and response interception.
     * @param context The context based on the one provided to
     *     {@link HttpPipeline#send(HttpRequest, Context, HttpCallback)}.
     */
    void process(HttpPipelinePolicyChain chain, Context context);
}
