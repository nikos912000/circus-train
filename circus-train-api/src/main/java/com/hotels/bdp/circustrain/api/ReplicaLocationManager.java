/**
 * Copyright (C) 2016-2017 Expedia Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hotels.bdp.circustrain.api;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.metastore.api.Partition;

public interface ReplicaLocationManager {

  Path getTableLocation() throws CircusTrainException;

  void cleanUpLocations() throws CircusTrainException;

  Path getPartitionBaseLocation() throws CircusTrainException;

  void addCleanUpLocation(String pathEventId, Path location);

  /**
   * @return the full partition location. For instance something like: s3:///base/path/event_id/key1=value/key2=value
   */
  Path getPartitionLocation(Partition sourcePartition);

}
