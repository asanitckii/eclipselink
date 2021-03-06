/*
 * Copyright (c) 2005, 2020 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2005, 2015 SAP. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     SAP - initial API and implementation

package org.eclipse.persistence.testing.models.wdf.jpa1.employee;

import java.util.Collection;

import jakarta.persistence.Basic;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

@Cacheable(true)
@Entity
@DiscriminatorValue("4")
public class Bicycle extends Vehicle {

    private static final long serialVersionUID = -5261998177428381310L;

    private transient CallbackEventListener callbackListener;

    @Basic
    @Column(name = "NUM_GEARS")
    protected short numberOfGears;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "TMP_EMP_BICYCLE", joinColumns = { @JoinColumn(name = "BICYCLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "EMPLOYEE_ID") })
    protected Collection<Employee> riders;

    public void setNumberOfGears(short numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public short getNumberOfGears() {
        return numberOfGears;
    }

    public void setRiders(Collection<Employee> riders) {
        this.riders = riders;
    }

    public Collection<Employee> getRiders() {
        return riders;
    }

    public void registerListener(final CallbackEventListener listener) {
        callbackListener = listener;
    }

    @PrePersist
    public void callbackPrePersist() {
        if (callbackListener != null) {
            callbackListener.callbackCalled(this, PrePersist.class);
        }
    }

    @PreRemove
    public void callbackPreRemove() {
        if (callbackListener != null) {
            callbackListener.callbackCalled(this, PreRemove.class);
        }
    }
}
