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

package com.google.security.zynamics.binnavi.Gui.GraphWindows.BottomPanel.InstructionHighlighter;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Used to sort the special instruction highlighting table according to the content of type column
 * rows.
 */
public final class CTypeComparator implements Comparator<ITypeDescription>, Serializable {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = 1416595875344338871L;

  @Override
  public int compare(final ITypeDescription lhs, final ITypeDescription rhs) // NO_UCD
  {
    return rhs.getDescription().hashCode() - lhs.getDescription().hashCode();
  }
}
