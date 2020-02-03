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

package com.google.security.zynamics.reil.algorithms.mono.interfaces;

import java.util.List;

/**
 * The TreeWalker interface is used to walk through InstructionGraphs.
 */
public interface IGraphWalker<GraphNode, ObjectType> {
  /**
   * Returns a list of nodes that contains all nodes that are influenced by state changes in the
   * passed node.
   * 
   * @param node The start node.
   * 
   * @return List of nodes that are influenced by the passed node.
   */
  List<GraphNode> getInfluenced(GraphNode node);

  /**
   * Returns a list of nodes that contains all nodes that are necessary to determine the state of
   * the passed node.
   * 
   * @param node The start node.
   * 
   * @return List of nodes that influence the passed node.
   */
  List<? extends IInfluencingNode<GraphNode, ObjectType>> getInfluencing(GraphNode node);
}
