/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iotdb.cluster.rpc.raft.response.querymetric;

import com.alipay.sofa.jraft.entity.PeerId;
import org.apache.iotdb.cluster.rpc.raft.response.BasicResponse;

public class QueryLeaderResponse extends BasicResponse {

  private PeerId leader;

  private QueryLeaderResponse(String groupId, boolean redirected, String leaderStr,
      String errorMsg) {
    super(groupId, redirected, leaderStr, errorMsg);
  }

  public static QueryLeaderResponse createSuccessResponse(String groupId, PeerId leader) {
    QueryLeaderResponse response = new QueryLeaderResponse(groupId, false, null,
        null);
    response.leader = leader;
    return response;
  }

  public static QueryLeaderResponse createErrorResponse(String groupId, String errorMsg) {
    return new QueryLeaderResponse(groupId, false, null, errorMsg);
  }

  public PeerId getLeader() {
    return leader;
  }
}
