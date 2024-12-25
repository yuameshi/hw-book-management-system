# 图书管理系统

作为期末实训成果

# 开发环境

## Java OpenJDK 17 (Microsoft)

```bash
$ java --version
```

> openjdk 17.0.10 2024-01-16 LTS
>
> OpenJDK Runtime Environment Microsoft-8902769 (build 17.0.10+7-LTS)
>
> OpenJDK 64-Bit Server VM Microsoft-8902769 (build 17.0.10+7-LTS, mixed mode, sharing)

## Windows 11

```bash
$ ver
```

> Microsoft Windows [版本 10.0.22631.4602]
>
> (c) Microsoft Corporation。保留所有权利。

## Visual Studio Code

> 帮助 - 关于

> 版本: 1.96.2 (system setup)
>
> 提交: fabdb6a30b49f79a7aba0f2ad9df9b399473380f
>
> 日期: 2024-12-19T10:22:47.216Z
>
> Electron: 32.2.6
>
> ElectronBuildId: 10629634
>
> Chromium: 128.0.6613.186
>
> Node.js: 20.18.1
>
> V8: 12.8.374.38-electron.0
>
> OS: Windows_NT x64 10.0.22631

## Visual Studio Code Java Extension Pack

> 扩展 - Java Extension Pack
> 版本: 0.29.0

## MySQL

使用社区 MariaDB 分支

```bash
$ mysql --version
```

> **REDACTED FOR PRIVACY REASON**\mariadb\bin\mysql.exe Ver 15.1 Distrib 10.11.5-MariaDB, for Win64 (AMD64), source revision 7875294b6b74b53dd3aaa723e6cc103d2bb47b2c

# 构建指南：

> 本项目以提供预构建的 Jar 包，可以直接跳转到下方[运行指南](#运行指南：)部分
> 以下为手动构建的步骤

1. 根据自身情况修改根目录下的`druid.properties`文件
2. 在根目录下执行以下命令块以构建 Jar 包

```bash
$ javac -encoding utf8 --class-path ./lib/* --source-path ./src/ ./src/App.java -d bin
$ mkdir -p bin/lib
$ cp ./lib/* ./bin/lib/
$ cp ./druid.properties ./bin/
$ jar -cvfm BookManagementSystem.jar MANIFEST.MF -C bin .
```

# 运行指南：

1. 启动 MySQL 服务器 并创建好实训指导书中的数据库 (亦可通过根目录中的`create-db.sql`文件创建)
2. 确保`druid.properties`文件配置正确并和`BookManagementSystem.jar`在同一目录下
3. 在根目录下执行以下命令以运行 Jar 包

```bash
$ java -jar BookManagementSystem.jar
```
