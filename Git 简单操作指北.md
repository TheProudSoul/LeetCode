# Git 简单操作指北

> 这是写给某个 git 小白的，可别再 Add files via upload 了好吗
>
> There is the first crime here, a crime of stupidity.

## 前置准备

1. 先绑定 SSH Key，见横线下面 👇
2. 在 GitHub 上创建新的 repository，不要 ☑️ `Initialize this repository with a README`。
3. 在本地准备同步的文件夹下右键 `Git Bash Here`，或者打开 `CMD` 然后 `cd` 到此目录
4. 为了方便理解，我们将本地仓库理解为地面 🏠，将远程仓库理解为云端的 🏠。

------

生成 SSH

```shell script
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

将用户目录下的 `./id_rsa.pub` 中的内容复制过来

![](https://github.com/TheProudSoul/LeetCode/blob/master/images/ssh.png)

![](https://github.com/TheProudSoul/LeetCode/blob/master/images/ssh1.png)

------

概念理解

工作区、版本库

## 本地仓库相关操作

### 初始化一个新的仓库

> 这个命令初始化一个空的仓库，相当于建立一个新的地面 🏠。

```shell script
git init
```

### 在本地记录远程仓库

> 即为地面 🏠 记录确认好云端 🏠 的地址。

```shell script
git remote add origin git@github.com:address.git
```

这个命令理解为 **git** 应用，为现在的本地仓库添加（**add**）一个远程仓库（**git@github.com:address.git**）的对应关系（**remote**），将此远程库命名为 **origin**。

### 往仓库中添加文件

> 改造地面 🏠，为其添砖加瓦，在里面添置 🪑

```shell script
git add <文件名>
```

往仓库中放入 <文件名> 文件。

```shell script
git add .
```

`.` 意味当前目录，这个命令将当前文件夹下的所有文件都放入仓库中，使用频率相对较高。

### 添加版本信息

> 将当前变化添加记录到蓝图中

```shell script
git commit -m "first commit"
```

`commit` 提交一个版本，后接此版本的信息，比如，add 什么 feature，fix 什么 bug。

### 查看仓库状态

```shell script
git status
```

### 为当前分支与远程上游建立追踪关系

> push 理解为将手中所有蓝图送到云端的 🏠，让云端造着蓝图打造一份
>
> pull 刚好跟 push 相反

#### 在远程创建一个与本地同名分支并跟踪（就无脑用此方法）

```shell script
git push --set-upstream <远程主机名> <本地分支名>
```

自动在远程创建一个同名分支，然后本地分支会 track 该分支。后面再对该分支使用 push 和 pull 就自动同步。无需再指定分支。

**注:** 本地指定分支就和远程主机的同名分支建立追踪关系

#### 在本地创建一个同名分支跟踪远程分支

```shell script
git checkout --track <远程主机名>/<远程分支名>
```

#### 手动建立追踪关系

```shell script
git branch --set-upstream-to=<远程主机名>/<远程分支名> <本地分支名>
```

### 分支

#### 查看当前分支

```shell script
git branch
```

#### 查看分支追踪关系

```shell script
git branch -vv
```

#### 新建分支

```shell script
git branch <分支名>
```

#### 切换分支

```shell script
git checkout <分支名>
```

#### 创建并切换

```shell script
git checkout -b <分支名>
```

------

## 配置

清除某个文件夹的 git 缓存

```shell script
git rm -r --cached <文件夹名>
```