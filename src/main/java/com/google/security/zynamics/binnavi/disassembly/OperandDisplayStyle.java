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

package com.google.security.zynamics.binnavi.disassembly;

/**
 * Contains valid operand display styles.
 */
public enum OperandDisplayStyle {
  /**
   * Operand is shown as a unsigned hexadecimal value.
   */
  UNSIGNED_HEXADECIMAL,

  /**
   * Operand is shown as a signed hexadecimal value.
   */
  SIGNED_HEXADECIMAL,

  /**
   * Operand is shown as a unsigned decimal value.
   */
  UNSIGNED_DECIMAL,

  /**
   * Operand is shown as a signed decimal value.
   */
  SIGNED_DECIMAL,

  /**
   * Operand is shown as a unsigned octal value.
   */
  OCTAL,

  /**
   * Operand is shown as a unsigned binary value.
   */
  BINARY,

  /**
   * Operand is shown as an offset.
   */
  OFFSET,

  /**
   * Operand is shown as ASCII character.
   */
  CHAR
}
