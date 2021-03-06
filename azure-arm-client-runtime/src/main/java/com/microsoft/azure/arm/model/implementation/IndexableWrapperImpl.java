/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.arm.model.implementation;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.model.Indexable;

/**
 * The implementation for {@link Indexable} and {@link HasInner}.
 *
 * @param <InnerT> wrapped type
 */
public abstract class IndexableWrapperImpl<InnerT>
        extends IndexableImpl
        implements HasInner<InnerT> {
    private InnerT innerObject;
    protected IndexableWrapperImpl(InnerT innerObject) {
        super();
        this.innerObject = innerObject;
    }

    @Override
    public InnerT inner() {
        return this.innerObject;
    }

    /**
     * Sets the inner object of the wrapper.
     * <p>
     * (Internal use only)
     * @param innerObject an inner object
     */
    public void setInner(InnerT innerObject) {
        this.innerObject = innerObject;
    }
}
