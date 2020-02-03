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

package com.google.security.zynamics.binnavi.Gui.Debug.MemoryRefreshButton;

import com.google.security.zynamics.zylib.disassembly.IAddress;

/**
 * Interface that can be implemented by objects that provide memory ranges that need refreshing.
 */
public interface IRefreshRangeProvider {
  /**
   * Returns the start address of the memory range to refresh.
   *
   * @return The start address of the memory range to refresh.
   */
  IAddress getAddress();

  /**
   * Returns the size in bytes of the memory range to refresh.
   *
   * @return The size in bytes of the memory range to refresh.
   */
  int getSize();
}
