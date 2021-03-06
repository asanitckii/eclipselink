/*
 * Copyright (c) 2018, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

@XmlSchema(
        namespace = "http://www.example.org/traveler", elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = { @XmlNs(prefix = "ns1", namespaceURI = "http://www.example.org/traveler") })
package org.eclipse.persistence.jpars.test.model.traveler;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;

