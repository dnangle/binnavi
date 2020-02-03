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

package com.google.security.zynamics.binnavi.Gui.Progress;

/**
 * Interface to be implemented by classes that want to be notified about changes in ongoing
 * processes.
 */
public interface IGlobalProgressManagerListener {
  /**
   * Invoked after a new operation was added to the manager.
   * 
   * @param operation The new operation.
   */
  void added(IProgressOperation operation);

  /**
   * Invoked after an operation was removed from the manager.
   * 
   * @param operation The removed operation.
   */
  void removed(IProgressOperation operation);
}
