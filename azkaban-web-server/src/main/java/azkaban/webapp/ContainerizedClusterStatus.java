/*
 * Copyright 2021 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package azkaban.webapp;

import azkaban.executor.Executor;
import azkaban.imagemgmt.dto.ImageVersionMetadataResponseDTO;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * This POJO is used by GSON library to create a status JSON object. This class represents status
 * for containerized cluster.
 */
@JsonPropertyOrder({"version", "pid", "installationPath", "usedMemory", "xmx", "isDatabaseUp",
    "containerizationRampUp", "containerizationJobTypeFilter", "containerizationProxyToUserFilter",
    "executorStatusMap", "imageTypeVersionMap"})
public class ContainerizedClusterStatus extends Status {

  @JsonProperty("imageTypeVersionMap")
  private final Map<String, ImageVersionMetadataResponseDTO> imageTypeVersionMap;
  @JsonProperty("executorStatusMap")
  private final Map<Integer, Executor> executorStatusMap;
  @JsonProperty("containerizationRampUp")
  private final int containerizationRampUp;
  @JsonProperty("containerizationJobTypeFilter")
  private final String containerizationJobTypeFilter;
  @JsonProperty("containerizationProxyToUserFilter")
  private final String containerizationProxyToUserFilter;

  public ContainerizedClusterStatus(final String version,
      final String pid,
      final String installationPath,
      final long usedMemory,
      final long xmx,
      final boolean isDatabaseUp,
      final Map<String, ImageVersionMetadataResponseDTO> imageTypeVersionMap,
      final Map<Integer, Executor> executorStatusMap,
      final int containerizationRampUp,
      final String containerizationJobTypeFilter,
      final String containerizationProxyToUserFilter) {
    super(version, pid, installationPath, usedMemory, xmx, isDatabaseUp);
    this.imageTypeVersionMap = imageTypeVersionMap;
    this.executorStatusMap = executorStatusMap;
    this.containerizationRampUp = containerizationRampUp;
    this.containerizationJobTypeFilter = containerizationJobTypeFilter;
    this.containerizationProxyToUserFilter = containerizationProxyToUserFilter;
  }

  public Map<String, ImageVersionMetadataResponseDTO> getImageTypeVersionMap() {
    return imageTypeVersionMap;
  }
}
