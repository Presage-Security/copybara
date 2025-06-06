# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

load("@rules_java//java:defs.bzl", "java_library")

licenses(["notice"])

package(default_visibility = ["//visibility:public"])

JAVACOPTS = [
    "-Xlint:unchecked",
]

CORE = [
    "FetchResult.java",
    "GitCredential.java",
    "GitRepository.java",
    "GitRevision.java",
    "InvalidRefspecException.java",
    "NonFastForwardRepositoryException.java",
    "RebaseConflictException.java",
    "Refspec.java",
]

CREDS = [
    "CredentialFileHandler.java",
]

java_library(
    name = "git",
    srcs = glob(
        ["**/*.java"],
        exclude = CORE + CREDS,
    ),
    javacopts = JAVACOPTS,
    runtime_deps = [
        "//java/com/google/copybara/doc:annotations",
    ],
    deps = [
        ":core",
        ":creds",
        "//java/com/google/copybara:base",
        "//java/com/google/copybara:general_options",
        "//java/com/google/copybara:labels",
        "//java/com/google/copybara/action",
        "//java/com/google/copybara/approval",
        "//java/com/google/copybara/authoring",
        "//java/com/google/copybara/checks",
        "//java/com/google/copybara/config:base",
        "//java/com/google/copybara/config:global_migrations",
        "//java/com/google/copybara/credentials",
        "//java/com/google/copybara/doc:annotations",
        "//java/com/google/copybara/effect",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/git/github:api",
        "//java/com/google/copybara/git/github:util",
        "//java/com/google/copybara/git/gitlab:git_lab_options",
        "//java/com/google/copybara/git/gitlab:git_lab_util",
        "//java/com/google/copybara/git/gitlab/api:gitlab_api",
        "//java/com/google/copybara/git/gitlab/api/entities",
        "//java/com/google/copybara/go",
        "//java/com/google/copybara/http/auth",
        "//java/com/google/copybara/jcommander:converters",
        "//java/com/google/copybara/jcommander:splitters",
        "//java/com/google/copybara/jcommander:validators",
        "//java/com/google/copybara/json",
        "//java/com/google/copybara/monitor",
        "//java/com/google/copybara/profiler",
        "//java/com/google/copybara/revision",
        "//java/com/google/copybara/templatetoken",
        "//java/com/google/copybara/transform",
        "//java/com/google/copybara/transform/patch",
        "//java/com/google/copybara/util",
        "//java/com/google/copybara/util:origin_util",
        "//java/com/google/copybara/util/console",
        "//java/com/google/copybara/version",
        "//third_party:autovalue",
        "//third_party:error_prone",
        "//third_party:flogger",
        "//third_party:google_http_client",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:starlark",
    ],
)

java_library(
    name = "core",
    srcs = CORE,
    javacopts = JAVACOPTS,
    deps = [
        ":environment",
        "//java/com/google/copybara:base",
        "//java/com/google/copybara:general_options",
        "//java/com/google/copybara/authoring",
        "//java/com/google/copybara/credentials",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/jcommander:splitters",
        "//java/com/google/copybara/jcommander:validators",
        "//java/com/google/copybara/revision",
        "//java/com/google/copybara/util",
        "//third_party:error_prone",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:shell",
    ],
)

java_library(
    name = "git_options",
    srcs = [
        "GitOptions.java",
    ],
    javacopts = JAVACOPTS,
    deps = [
        ":core",
        ":environment",
        "//java/com/google/copybara:base",
        "//java/com/google/copybara:general_options",
        "//java/com/google/copybara/authoring",
        "//java/com/google/copybara/credentials",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/jcommander:splitters",
        "//java/com/google/copybara/jcommander:validators",
        "//java/com/google/copybara/revision",
        "//java/com/google/copybara/util",
        "//third_party:error_prone",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:shell",
    ],
)

java_library(
    name = "creds",
    srcs = CREDS,
    javacopts = JAVACOPTS,
    deps = [
        ":core",
        "//java/com/google/copybara/credentials",
        "//java/com/google/copybara/exception",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:re2j",
    ],
)

java_library(
    name = "environment",
    srcs = ["GitEnvironment.java"],
    javacopts = JAVACOPTS,
    deps = ["//third_party:guava"],
)
