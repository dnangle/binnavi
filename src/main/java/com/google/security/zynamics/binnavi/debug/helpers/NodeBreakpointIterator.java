// Copyright 2011-2016 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.security.zynamics.binnavi.debug.helpers;

import com.google.security.zynamics.binnavi.yfileswrap.zygraph.NaviNode;
import com.google.security.zynamics.binnavi.yfileswrap.zygraph.ZyGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;

/**
 * Iterator class that can be used to iterate over all nodes in a graph that can be breakpointed.
 */
public final class NodeBreakpointIterator {
  /**
   * You are not supposed to instantiate this class.
   */
  private NodeBreakpointIterator() {}

  /**
   * Iterates over all breakpoint table nodes in a graph.
   *
   * @param graph The graph to iterate over.
   * @param callback Callback object invoked for each breakpoint table node of the graph.
   */
  public static void iterate(final ZyGraph graph, final INodeCallback<NaviNode> callback) {
    graph.iterate(new NodeBreakpointDecider(callback));
  }
}
