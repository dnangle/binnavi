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

package com.google.security.zynamics.binnavi.Database.Exceptions;


import com.google.common.base.Preconditions;
import com.google.security.zynamics.binnavi.Database.DatabaseVersion;

/**
 * Signals that a BinNavi database needs upgrading before it can be used.
 */
public final class InvalidDatabaseVersionException extends Exception {

  /**
   * Version of the BinNavi database that can not be used without upgrading.
   */
  private final DatabaseVersion m_version;

  /**
   * Creates a new exception object.
   * 
   * @param version Version of the BinNavi database that can not be used without upgrading.
   */
  public InvalidDatabaseVersionException(final DatabaseVersion version) {
    m_version = Preconditions.checkNotNull(version, "IE01093: Version argument can not be null");
  }

  /**
   * Returns the version of the BinNavi database that can not be used without upgrading.
   * 
   * @return The version of the BinNavi database that can not be used without upgrading.
   */
  public DatabaseVersion getVersion() {
    return m_version;
  }
}
