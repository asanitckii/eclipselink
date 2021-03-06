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

package org.eclipse.persistence.testing.tests.wdf.jpa1.simple;

import jakarta.persistence.EntityManager;

import org.eclipse.persistence.testing.tests.wdf.jpa1.JPA1Base;
import org.junit.Test;

public class FirstTest extends JPA1Base {

    @Test
    public void testBasics() {
        EntityManager em = getEnvironment().getEntityManager();
        verify(em != null, "EntityManager is null");
        verify(em.isOpen(), "EntityManager is closed");
    }

}
