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

package com.google.security.zynamics.binnavi.API.disassembly;

// ! Used to listen on text nodes.
/**
 * This interface can be implemented by classes that want to be notified about changes in text
 * nodes.
 */
public interface ITextNodeListener {
  // ! Signals a change in the node text.
  /**
   * Invoked right after the text of a text node changed.
   *
   * @param node The node whose text changed.
   */
  void changedText(TextNode node);
}
