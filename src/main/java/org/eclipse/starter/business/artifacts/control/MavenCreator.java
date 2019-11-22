/*
 * Copyright (c) 2017-2019 Contributors to the Eclipse Foundation
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
package org.eclipse.starter.business.artifacts.control;

import org.eclipse.starter.business.model.entity.JessieModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 */
@ApplicationScoped
public class MavenCreator {

    public static final String SRC_MAIN_JAVA = "src/main/java";
    public static final String SRC_TEST_JAVA = "src/test/java";
    public static final String SRC_MAIN_RESOURCES = "src/main/resources";
    public static final String SRC_TEST_RESOURCES = "src/test/resources";
    public static final String SRC_MAIN_WEBAPP = "src/main/webapp";

    @Inject
    private DirectoryCreator directoryCreator;

    @Inject
    private FileCreator fileCreator;

    public void createMavenFiles(JessieModel model) {
        String directory = model.getDirectory();

        String javaDirectory = directory + "/" + SRC_MAIN_JAVA;
        directoryCreator.createDirectory(javaDirectory);

        String javaTestDirectory = directory + "/" + SRC_TEST_JAVA;
        directoryCreator.createDirectory(javaTestDirectory);

        String resourcesDirectory = directory + "/" + SRC_MAIN_RESOURCES;
        directoryCreator.createDirectory(resourcesDirectory);
        fileCreator.createEmptyFile(resourcesDirectory, ".gitkeep");

        String resourcesTestDirectory = directory + "/" + SRC_TEST_RESOURCES;
        directoryCreator.createDirectory(resourcesTestDirectory);
        fileCreator.createEmptyFile(resourcesTestDirectory, ".gitkeep");

        String webappDirectory = directory + "/" + SRC_MAIN_WEBAPP;
        directoryCreator.createDirectory(webappDirectory);
        fileCreator.createEmptyFile(webappDirectory, ".gitkeep");
    }

}