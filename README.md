# jdk17-achieve

[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![OracleJDK](https://img.shields.io/badge/OracleJDK-17.0.4-success.svg?style=flat&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgdmlld0JveD0iMCAwIDMyIDMyIj48cGF0aCBkPSJNMTEuNjIyIDI0Ljc0cy0xLjIzLjc0OC44NTUuOTYyYzIuNTEuMzIgMy44NDcuMjY3IDYuNjI1LS4yNjdhMTAuMDIgMTAuMDIgMCAwIDAgMS43NjMuODU1Yy02LjI1IDIuNjcyLTE0LjE2LS4xNi05LjI0NC0xLjU1em0tLjgtMy40NzNzLTEuMzM2IDEuMDE1Ljc0OCAxLjIzYzIuNzI1LjI2NyA0Ljg2Mi4zMiA4LjU1LS40MjdhMy4yNiAzLjI2IDAgMCAwIDEuMjgyLjgwMWMtNy41MzQgMi4yNDQtMTUuOTc2LjIxNC0xMC41OC0xLjYwM3ptMTQuNzQ3IDYuMDlzLjkwOC43NDgtMS4wMTUgMS4zMzZjLTMuNTggMS4wNy0xNS4wMTQgMS4zOS0xOC4yMiAwLTEuMTIyLS40OCAxLjAxNS0xLjE3NSAxLjctMS4yODIuNjk1LS4xNiAxLjA3LS4xNiAxLjA3LS4xNi0xLjIzLS44NTUtOC4xNzUgMS43NjMtMy41MjYgMi41MSAxMi43NyAyLjA4NCAyMy4yOTYtLjkwOCAxOS45ODMtMi40MDR6TTEyLjIgMTcuNjMzcy01LjgyNCAxLjM5LTIuMDg0IDEuODdjMS42MDMuMjE0IDQuNzU1LjE2IDcuNjk0LS4wNTMgMi40MDQtLjIxNCA0LjgxLS42NCA0LjgxLS42NHMtLjg1NS4zNzQtMS40NDMuNzQ4Yy01LjkzIDEuNTUtMTcuMzEyLjg1NS0xNC4wNTItLjc0OCAyLjc3OC0xLjMzNiA1LjA3Ni0xLjE3NSA1LjA3Ni0xLjE3NXptMTAuNDIgNS44MjRjNS45ODQtMy4xIDMuMjA2LTYuMDkgMS4yODItNS43MTctLjQ4LjEwNy0uNjk1LjIxNC0uNjk1LjIxNHMuMTYtLjMyLjUzNC0uNDI3YzMuNzk0LTEuMzM2IDYuNzg2IDQuMDA3LTEuMjMgNi4wOSAwIDAgLjA1My0uMDUzLjEwNy0uMTZ6bS05LjgzIDguNDQyYzUuNzcuMzc0IDE0LjU4Ny0uMjE0IDE0LjgtMi45NCAwIDAtLjQyNyAxLjA3LTQuNzU1IDEuODctNC45MTYuOTA4LTExLjAwNy44LTE0LjU4Ny4yMTQgMCAwIC43NDguNjQgNC41NDIuODU1eiIgZmlsbD0iIzRlNzg5NiIvPjxwYXRoIGQ9Ik0xOC45OTYuMDAxczMuMzEzIDMuMzY2LTMuMTUyIDguNDQyYy01LjE4MyA0LjExNC0xLjE3NSA2LjQ2NSAwIDkuMTM3LTMuMDQ2LTIuNzI1LTUuMjM2LTUuMTMtMy43NC03LjM3M0MxNC4yOTQgNi44OTMgMjAuMzMyIDUuMyAxOC45OTYuMDAxem0tMS43IDE1LjMzNWMxLjU1IDEuNzYzLS40MjcgMy4zNjYtLjQyNyAzLjM2NnMzLjk1NC0yLjAzIDIuMTM3LTQuNTQyYy0xLjY1Ni0yLjQwNC0yLjk0LTMuNTggNC4wMDctNy41ODcgMCAwLTEwLjk1MyAyLjcyNS01LjcxNyA4Ljc2M3oiIGZpbGw9IiNmNTgyMTkiLz48L3N2Zz4=)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![JUnit](https://img.shields.io/badge/JUnit-5.8.2-success.svg?style=flat&logo=junit5)](https://junit.org/junit5/docs/current/user-guide)
[![Gradle](https://img.shields.io/badge/Gradle-8.4-success.svg?style=flat&logo=gradle)](https://docs.gradle.org/8.4/userguide/installation.html)
[![Release](https://img.shields.io/badge/Release-0.4.0-informational.svg)](https://github.com/aaric/jdk17-achieve/releases)

> [JDK 17 Features Learning.](https://blog.jetbrains.com/idea/2021/09/java-17-and-intellij-idea/)
> [semantic-gitlog - Quick Start](https://semantic-gitlog.github.io/semantic-gitlog/#/zh-cn/with-gradle)

## 1 约定式提交规范

### 1.1 基础格式

```text
<类型>([可选的作用域]): <描述>
[可选的正文]
[可选的脚注]
```

### 1.2 类型

#### 1.2.1 基础类型

|Type|Title|Emoji|Release|Description|
|:---:|---|:---:|:---:|-----|
|`feat`|Features|✨|`minor`|*A new feature*|
|`refactor`| Code Refactoring|📦|`patch`|*A code change that neither fixes a bug nor adds a feature*|
|`perf`|Performance Improvements|🚀|`patch`|*A code change that improves performance*|
|`fix`|Bug Fixes|🐛|`patch`|*A bug Fix*|
|`chore`|Chores |♻|`patch`|*Other changes that don't modify src or test files*|
|`revert`| Reverts|🗑|`patch`|*Reverts a previous commit*|
|`docs`|Documentation|📚|`patch`|*Documentation only changes*|
|`style`|Styles|💎|-|*Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)*|
|`test`|Tests|🚨|-|*Adding missing tests or correcting existing tests*|
|`build`|Builds|🛠|`patch`|*Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)*|
|`ci`|Continuous Integrations|⚙|-|*Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)*|

- `feat` *类型为 `feat` 的提交表示在代码库中新增了一个功能（这和语义化版本中的 `MINOR` 相对应）。*
- `refactor` *代码重构，既不修复错误也不添加功能。*
- `perf` *改进性能的代码更改。*
- `fix` *类型为 `fix` 的 提交表示在代码库中修复了一个 `bug` （这和语义化版本中的 `PATCH` 相对应）。*
- `chore` *其他不修改 `src` 或 `test` 文件。*
- `revert` *commit 回退。*
- `docs` *只是更改文档。*
- `style` *不影响代码含义的变化（空白、格式化、缺少分号等）。*
- `test` *添加确实测试或更正现有的测试。*
- `build` *影响构建系统或外部依赖关系的更改（示例范围：gulp、broccoli、NPM）。*
- `ci` *更改持续集成文件和脚本（示例范围：Travis、Circle、BrowserStack、SauceLabs）。*

#### 1.2.2 特殊类型

|Type|Title|Release|
|:---:|-----|:---:|
|`BREAKING CHANGE`|Breaking Changes|`major`|
|`DEPRECATED`|Deprecations|follow type|

### 1.3 范围

*为提交类型添加一个围在圆括号内的作用域，以为其提供额外的上下文信息。例如 `feat(parser): adds ability to parse arrays.`。*
