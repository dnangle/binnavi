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

package com.google.security.zynamics.binnavi.debug.connection;

/**
 * This package contains classes that deal with the lowest level of abstraction for communicating
 * with debug clients. The classes in this package take the raw debug packets off the wire, decode
 * them, and push the results of the packet analysis up the chain into the next-highest abstraction
 * level.
 */
