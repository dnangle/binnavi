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

package com.google.security.zynamics.reil.translators.arm;

import com.google.security.zynamics.reil.OperandSize;
import com.google.security.zynamics.reil.ReilHelpers;
import com.google.security.zynamics.reil.ReilInstruction;
import com.google.security.zynamics.reil.translators.ITranslationEnvironment;
import com.google.security.zynamics.reil.translators.InternalTranslationException;
import com.google.security.zynamics.reil.translators.TranslationHelpers;
import com.google.security.zynamics.zylib.disassembly.IInstruction;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;

import java.util.List;


public class ARMSwpbTranslator extends ARMBaseTranslator {
  @Override
  protected void translateCore(final ITranslationEnvironment environment,
      final IInstruction instruction, final List<ReilInstruction> instructions) {
    final IOperandTreeNode registerOperand1 =
        instruction.getOperands().get(0).getRootNode().getChildren().get(0);
    final IOperandTreeNode registerOperand2 =
        instruction.getOperands().get(1).getRootNode().getChildren().get(0);
    final IOperandTreeNode registerOperand3 =
        instruction.getOperands().get(2).getRootNode().getChildren().get(0).getChildren().get(0);

    final String targetRegister = (registerOperand1.getValue());
    final String sourceRegister1 = (registerOperand2.getValue());
    final String memoryRegister2 = (registerOperand3.getValue());

    final OperandSize bt = OperandSize.BYTE;
    final OperandSize dw = OperandSize.DWORD;

    long baseOffset = (instruction.getAddress().toLong() * 0x100) + instructions.size();

    // load
    instructions.add(ReilHelpers.createLdm(baseOffset++, dw, memoryRegister2, bt, targetRegister));

    // store
    instructions.add(ReilHelpers.createStm(baseOffset++, bt, sourceRegister1, dw, memoryRegister2));
  }

  /**
   * SWP{<cond>}B <Rd>, <Rm>, [<Rn>]
   * 
   * Operation:
   * 
   * MemoryAccess(B-bit, E-bit) processor_id = ExecutingProcessor() if ConditionPassed(cond) then
   * temp = Memory[address,1] Memory[address,1] = Rm[7:0] Rd = temp if Shared(address) then // ARMv6
   * physical_address = TLB(address) ClearExclusiveByAddress(physical_address,processor_id,1) // See
   * Summary of operation on page A2-49
   */

  @Override
  public void translate(final ITranslationEnvironment environment, final IInstruction instruction,
      final List<ReilInstruction> instructions) throws InternalTranslationException {
    TranslationHelpers.checkTranslationArguments(environment, instruction, instructions, "SWP");
    translateAll(environment, instruction, "SWP", instructions);
  }
}
