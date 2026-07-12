# LeetCode Practice - Java 21

這是一個用來練習 LeetCode 的 Java 21 專案。每一題都放在自己的 `.java` 檔案裡，並依照題型分類放到不同 package。

## 專案結構

```text
src/main/java/dev/poyuchen/leetcode/
  PracticeRunner.java                 # 跑目前範例題目的簡單檢查
  common/                             # 常用資料結構與檢查工具
    Checks.java
    ListNode.java
    TreeNode.java
  arrays/
    P0001TwoSum.java
  linked_list/
    P0021MergeTwoSortedLists.java
  trees/
    P0104MaximumDepthOfBinaryTree.java
  strings/
  two_pointers/
  sliding_window/
  stack/
  binary_search/
  heap_priority_queue/
  backtracking/
  graphs/
  dynamic_programming/
  greedy/
  intervals/
  math/
  bit_manipulation/
templates/
  ProblemTemplate.java
scripts/
  check.sh
  new-problem.sh
```

## Java 21

這台機器目前可用的 JDK 21 路徑是：

```bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-21.jdk
export PATH="$JAVA_HOME/bin:$PATH"
```

如果你有用 `direnv`，可以參考 `.envrc.example`。

如果你不想改全域 `JAVA_HOME`，也可以只給這個專案使用：

```bash
export LEETCODE_JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-21.jdk
```

## 編譯與檢查

不需要下載任何外部 dependency：

```bash
./scripts/check.sh
```

也可以用 Maven：

```bash
mvn test
```

## 進度索引

用 [PROGRESS.md](PROGRESS.md) 總覽所有題目的完成狀態，以及目前寫法是不是最佳解。

建議每做完一題就更新：

```text
Status: Todo / Doing / Solved
Optimal: Yes / No / Check
筆記: 目前解法、複雜度，或還可以改進的地方
```

## 新增題目

用 script 依分類建立單題檔案：

```bash
./scripts/new-problem.sh arrays 1 two-sum
```

會產生：

```text
src/main/java/dev/poyuchen/leetcode/arrays/P0001TwoSum.java
```

建議命名規則：

```text
P{四位數題號}{英文題名PascalCase}.java
```

例如：

```text
P0001TwoSum.java
P0021MergeTwoSortedLists.java
P0104MaximumDepthOfBinaryTree.java
```

每個檔案內保留和 LeetCode 題目一致的方法名稱與參數。提交到 LeetCode 時，只要把方法和需要的 helper 複製到 `class Solution` 裡即可。

## 分類目錄

目前先建立常見分類：

```text
arrays
strings
linked_list
trees
two_pointers
sliding_window
stack
binary_search
heap_priority_queue
backtracking
graphs
dynamic_programming
greedy
intervals
math
bit_manipulation
```

之後如果你的 LeetCode 分類不同，直接新增 package 目錄即可。
