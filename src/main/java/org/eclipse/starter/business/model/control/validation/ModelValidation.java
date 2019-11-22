/*
 * Copyright (c) 2017-2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   2018-09-29 - Rudy De Busscher
 *      Initially authored in Atbash Jessie
 */
package org.eclipse.starter.business.model.control.validation;

import org.eclipse.starter.business.addons.control.JessieAddon;
import org.eclipse.starter.business.exception.JessieConfigurationException;
import org.eclipse.starter.business.model.entity.JessieModel;
import org.eclipse.starter.business.templates.control.TemplateModelLoader;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 *
 */
@ApplicationScoped
public class ModelValidation {

    @Inject
    private TemplateModelLoader templateModelLoader;

    public void validate(JessieModel model) {
        if (!templateModelLoader.isValidTemplate(model.getTemplate())) {
            String message = String.format("Specified template '%s' is not found", model.getTemplate());
            throw new JessieConfigurationException(message);
        }
    }

    public void validateByAddons(JessieModel model) {
        List<JessieAddon> addons = model.getParameter(JessieModel.Parameter.ADDONS);
        for (JessieAddon addon : addons) {
            addon.validate(model);
        }
    }
}