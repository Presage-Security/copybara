/*
 * Copyright (C) 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.copybara.git.gitlab.api.entities;

import com.google.common.collect.ImmutableList;

/**
 * Params for querying the GitLab API for a list of users.
 *
 * @param username the username of the user of interest. If this is provided, the API will return a
 *     single user
 * @see <a href="https://docs.gitlab.com/api/users/#list-users">GitLab API List Users docs</a>
 */
public record ListUsersParams(String username) implements GitLabApiParams {

  @Override
  public ImmutableList<Param> params() {
    return ImmutableList.of(new Param("username", username));
  }
}
